package com.z.tools.az;

import android.content.Context;
import android.util.DisplayMetrics;

/**
 * screen tools.
 * <p>
 * Created by Az
 * on 2019/2/26.
 */
public final class ScreenTools {

    /**
     * obtain screen width.
     *
     * @param context context
     * @return screen width,unit is px.
     */
    public static int getScreenWidth(Context context) {
        DisplayMetrics displayMetrics = context.getResources().getDisplayMetrics();
        return displayMetrics.widthPixels;
    }

    /**
     * obtain screen height.
     *
     * @param context context
     * @return screen height unit is px.
     */
    public static int getScreenHeight(Context context) {
        DisplayMetrics displayMetrics = context.getResources().getDisplayMetrics();
        return displayMetrics.heightPixels;
    }

    /**
     * unit conversion,from dp to px.
     *
     * @param context context
     * @param dp      input,unit is dp.
     * @return output, unit is px.
     */
    public static int dpToPixel(Context context, float dp) {
        final float scale = context.getResources().getDisplayMetrics().density;
        return (int) (dp * scale);
    }

    /**
     * unit conversion,from px to dp.
     *
     * @param context context
     * @param px      input,unit is px.
     * @return output, unit is dp.
     */
    public static float PixelTodp(Context context, int px) {
        final float scale = context.getResources().getDisplayMetrics().density;
        return px / scale;
    }

    /**
     * unit conversion,from sp to px.
     *
     * @param context context
     * @param sp      input,unit is sp.
     * @return out put,unit is px.
     */
    public static int spToPixel(Context context, float sp) {
        final float fontScale = context.getResources().getDisplayMetrics().scaledDensity;
        return (int) (sp * fontScale);
    }

    /**
     * unit conversion,from px to sp.
     *
     * @param context context
     * @param px      input,unit is px.
     * @return output, unit is sp.
     */
    public static int pixelToSp(Context context, int px) {
        final float fontScale = context.getResources().getDisplayMetrics().scaledDensity;
        return (int) (px / fontScale + 0.5f);
    }

}
