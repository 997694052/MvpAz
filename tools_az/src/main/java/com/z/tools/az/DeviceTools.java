package com.z.tools.az;

import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.net.ConnectivityManager;
import android.net.Network;
import android.net.NetworkInfo;
import android.net.Uri;
import android.os.Build;
import android.os.Environment;
import android.telephony.TelephonyManager;

import java.io.File;
import java.util.List;

/**
 * device tools.
 * <p>
 * Created by z
 * on 2019/2/25.
 */

public final class DeviceTools {

    /**
     * obtain android version.
     *
     * @return android version.like "8.0.0".
     */
    public static String getSystemVersion() {
        return Build.VERSION.RELEASE;
    }

    /**
     * obtain api level.
     *
     * @return api level.like "26".
     */
    public static int getApiVersion() {
        return Build.VERSION.SDK_INT;
    }

    /**
     * obtain device model.
     *
     * @return device model.like "Nexus 5".
     */
    public static String getSystemModel() {
        return Build.MODEL;
    }

    /**
     * obtain external cache directory.
     *
     * @param context context
     * @return external cache directory.return null when external storage unavailable.
     */
    public static File obtainExternalCacheDir(Context context) {
        if (Environment.MEDIA_MOUNTED.equals(Environment.getExternalStorageState())) {
            return context.getExternalCacheDir();
        } else {
            return null;
        }
    }

    /**
     * obtain external file root directory.
     *
     * @param context context
     * @return external file root directory.return null when external storage unavailable.
     */
    public static File obtainExternalFileRootDir(Context context) {
        if (Environment.MEDIA_MOUNTED.equals(Environment.getExternalStorageState())) {
            return context.getExternalFilesDir(null);
        } else {
            return null;
        }
    }

}
