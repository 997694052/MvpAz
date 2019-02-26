package com.z.tools.az;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;

/**
 * 应用工具.
 * <p>
 * Created by Az
 * on 2019/2/25.
 */
public final class AppTools {

    /**
     * obtain version code.
     *
     * @param context context
     * @return version code ,return -1 when get packageInfo exception.
     */
    public static int obtainAppVersionCode(Context context) {
        PackageManager packageManager = context.getPackageManager();
        try {
            PackageInfo packageInfo = packageManager.getPackageInfo(
                    context.getPackageName(), PackageManager.GET_CONFIGURATIONS);
            return packageInfo.versionCode;
        } catch (PackageManager.NameNotFoundException e) {
            return -1;
        }
    }

    /**
     * obtain version name.
     *
     * @param context context
     * @return version name, return "unknown" when get packageInfo exception.
     */
    public static String obtainAppVersionName(Context context) {
        PackageManager packageManager = context.getPackageManager();
        try {
            PackageInfo packageInfo = packageManager.getPackageInfo(
                    context.getPackageName(), PackageManager.GET_CONFIGURATIONS);
            return packageInfo.versionName;
        } catch (PackageManager.NameNotFoundException e) {
            return "unknown";
        }
    }


}
