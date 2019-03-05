package com.z.tools.az;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.provider.Settings;

/**
 * APK安装工具.
 * <p>
 * Create by Az
 * on 2019/03/05.
 */
public class InstallTools {

    public static int UNKNOWN_APP_RETURN_CODE = 1024;   //从设置是否允许安装未知源返回.

    /**
     * 安装APK.
     * 安装前会进行版本和权限检查.
     * 如果系统在 Android.O以上且不被允许安装未知源应用,则执行 {@param showRationale}
     * 一般操作是在 showRationale 中弹出提示框,告知用户需要同意安装未知源应用,
     * 然后调用{@link #startSetting(Activity)}打开设置界面.在activity返回后判断请求码,
     * 如果为{@link #UNKNOWN_APP_RETURN_CODE},则看具体需求判断是否再次调用install.
     *
     * @param activity      activity
     * @param apkUri        apk uri
     * @param showRationale 如果系统版本大于 Android.O 且没有被允许安装未知源应用,则执行该Runnable
     */
    public static void install(Activity activity, Uri apkUri, Runnable showRationale) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            if (activity.getPackageManager().canRequestPackageInstalls()) {
                startInstall(activity, apkUri);
            } else {
                showRationale.run();
            }
        } else {
            startInstall(activity, apkUri);
        }
    }

    /**
     * 打开该应用的“允许安装未知源”设置界面.
     *
     * @param activity activity
     */
    public static void startSetting(Activity activity) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            Uri uri = Uri.parse("package:" + activity.getPackageName());
            Intent intent = new Intent(Settings.ACTION_MANAGE_UNKNOWN_APP_SOURCES, uri);
            activity.startActivityForResult(intent, UNKNOWN_APP_RETURN_CODE);
        }
    }

    /**
     * 启动应用包安装器.
     *
     * @param activity activity.
     * @param apkUri   apk uri.     必须保证该uri可用.注意7.0以后uri获取方式:FileProvider
     */
    private static void startInstall(Activity activity, Uri apkUri) {
        Intent intent = new Intent();
        intent.addFlags(Intent.FLAG_GRANT_READ_URI_PERMISSION);
        intent.setAction(Intent.ACTION_INSTALL_PACKAGE);
        //intent.setType("application/vnd.android.package-archive");
        intent.setData(apkUri);
        activity.startActivity(intent);
    }

}
