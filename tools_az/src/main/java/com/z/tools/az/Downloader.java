package com.z.tools.az;

import android.os.AsyncTask;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;

/**
 * 下载器.
 * 简单的下载器,不适用于下载超过一个G的文件.
 * <p>
 * Create by Az
 * on 2019/03/05.
 */
public class Downloader {

    private String fileUrl;     //下载地址
    private String filePath;    //保存路径
    private ProgressListener progressListener;  //进度监听

    /**
     * 设置下载地址.
     *
     * @param fileUrl url
     * @return this
     */
    public Downloader from(String fileUrl) {
        this.fileUrl = fileUrl;
        return this;
    }

    /**
     * 设置保存路径.
     *
     * @param filePath path
     * @return this
     */
    public Downloader into(String filePath) {
        this.filePath = filePath;
        return this;
    }

    /**
     * 设置进度监听.
     *
     * @param listener 进度监听器
     * @return this
     */
    public Downloader setProgressListener(ProgressListener listener) {
        this.progressListener = listener;
        return this;
    }

    /**
     * 启动下载.
     */
    public void download() {
        new DownloadTask(progressListener).execute(fileUrl, filePath);
    }

    /**
     * 下载异步任务.
     */
    private static class DownloadTask extends AsyncTask<String, Integer, Exception> {

        private ProgressListener progressListener;  //下载进度监听

        private DownloadTask(ProgressListener progressListener) {
            this.progressListener = progressListener;
        }

        @Override
        protected void onPreExecute() {
            if (progressListener != null) {
                progressListener.downloadStart();
            }
        }

        @Override
        protected Exception doInBackground(String... strings) {
            FileOutputStream fileOutputStream = null;
            InputStream netInputStream = null;

            try {
                URL url = new URL(strings[0]);
                URLConnection urlConnection = url.openConnection();
                if (urlConnection instanceof HttpURLConnection &&
                        ((HttpURLConnection) urlConnection).getResponseCode() != HttpURLConnection.HTTP_OK) {
                    return new Exception("http error,code = " +
                            ((HttpURLConnection) urlConnection).getResponseCode());
                }
                File file = new File(strings[1]);
                fileOutputStream = new FileOutputStream(file);
                netInputStream = urlConnection.getInputStream();
                int totalLength = urlConnection.getContentLength();
                int currentLength = 0;
                int readLength;
                byte[] buffer = new byte[2048];
                readLength = netInputStream.read(buffer);
                while (readLength != -1) {
                    fileOutputStream.write(buffer, 0, readLength);
                    currentLength += readLength;
                    readLength = netInputStream.read(buffer);
                    if (progressListener != null) {
                        progressListener.downloading(currentLength, totalLength);
                    }
                }
            } catch (IOException e) {
                return e;
            } finally {
                if (fileOutputStream != null) {
                    try {
                        fileOutputStream.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
                if (netInputStream != null) {
                    try {
                        netInputStream.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }
            return null;
        }

        @Override
        protected void onProgressUpdate(Integer... values) {
            if (progressListener != null) {
                progressListener.downloading(values[0], values[1]);
            }
        }

        @Override
        protected void onPostExecute(Exception e) {
            if (progressListener != null) {
                progressListener.downloadComplete(e);
            }
        }
    }

    public interface ProgressListener {

        /**
         * 下载前初始化.
         */
        void downloadStart();

        /**
         * 下载中.
         *
         * @param current 已下载字节数.
         * @param total   总字节数.
         */
        void downloading(int current, int total);

        /**
         * 下载完成.
         *
         * @param e null,or exception when exception.
         */
        void downloadComplete(Exception e);

    }

}