package com.z.tools.az;

import android.Manifest;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.support.v4.content.ContextCompat;

/**
 * 通讯工具.
 * <p>
 * Created by z
 * on 2019/2/25.
 */

public final class CommunicationTools {

    /**
     * open dialer,auto-input phone number and need hand-click dial to call.
     * not required permission.
     *
     * @param context     context
     * @param phoneNumber phone number
     */
    public static void dialPhone(Context context, String phoneNumber) {
        Intent intent = new Intent(Intent.ACTION_DIAL);
        Uri uri = Uri.parse("tel:" + phoneNumber);
        intent.setData(uri);
        context.startActivity(intent);
    }

    /**
     * open dialer, auto-input phone number and auto-call.
     * required permission "android.permission.CALL_PHONE"
     * need request permissions in runtime when API>=23
     *
     * @param context     context
     * @param phoneNumber phone number
     * @throws SecurityException throw exception when permission denial
     */
    public static void callPhone(Context context, String phoneNumber) throws SecurityException {
        if (ContextCompat.checkSelfPermission(context, Manifest.permission.CALL_PHONE)
                == PackageManager.PERMISSION_GRANTED) {
            Intent intent = new Intent(Intent.ACTION_CALL);
            Uri uri = Uri.parse("tel:" + phoneNumber);
            intent.setData(uri);
            context.startActivity(intent);
        } else {
            throw new SecurityException("Permission Denial:required permission.CALL_PHONE");
        }
    }

}
