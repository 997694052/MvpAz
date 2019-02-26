package com.z.tools.az;

import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.net.Uri;

import java.util.List;

/**
 * permission tools.
 * <p>
 * Created by Az
 * on 2019/2/25.
 */
public final class PermissionTools {

    /**
     * 授于组件对uri指向的资源读写权限.
     * 查询可以响应意图的所有组件,授于所有可以响应意图的组件权限.
     * 调用context.revokeUriPermission(Uri uri, int modeFlags)可以撤回授权.
     * note:这个做法并不是太好，可以考虑获取用户选择了哪一个组件来响应意图，只授予该组件权限。
     *
     * @param context context
     * @param intent  携带uri的意图
     * @param uri     uri
     */
    public static void grantUriPermission(Context context, Intent intent, Uri uri) {
        List<ResolveInfo> resolveInfoList = context.getPackageManager()
                .queryIntentActivities(intent, PackageManager.MATCH_DEFAULT_ONLY);
        for (ResolveInfo resolveInfo : resolveInfoList) {
            String packageName = resolveInfo.activityInfo.packageName;
            context.grantUriPermission(packageName, uri,
                    Intent.FLAG_GRANT_READ_URI_PERMISSION | Intent.FLAG_GRANT_WRITE_URI_PERMISSION);

        }
    }


}
