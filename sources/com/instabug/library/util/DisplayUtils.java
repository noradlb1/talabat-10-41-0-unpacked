package com.instabug.library.util;

import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Point;
import android.os.Build;
import android.util.DisplayMetrics;
import android.view.Display;
import com.instabug.library.Instabug;

public class DisplayUtils {
    public static float dpToPx(Resources resources, int i11) {
        return ((float) i11) * (resources.getDisplayMetrics().xdpi / 160.0f);
    }

    public static int dpToPxIntRounded(Resources resources, int i11) {
        return Math.round(dpToPx(resources, i11));
    }

    public static int getDisplayHeightInPx(Activity activity) {
        Display defaultDisplay = activity.getWindowManager().getDefaultDisplay();
        Point point = new Point();
        defaultDisplay.getSize(point);
        return point.y;
    }

    public static int getDisplayWidthInPx(Context context) {
        return DeviceStateProvider.getDisplayMetrics(context).widthPixels;
    }

    public static boolean isLargeDisplay() {
        int i11;
        Context applicationContext = Instabug.getApplicationContext();
        if (applicationContext == null) {
            return false;
        }
        DisplayMetrics displayMetrics = DeviceStateProvider.getDisplayMetrics(applicationContext);
        int i12 = displayMetrics.densityDpi;
        if (Build.VERSION.SDK_INT >= 24) {
            i11 = DisplayMetrics.DENSITY_DEVICE_STABLE;
        } else {
            i11 = Math.round(displayMetrics.xdpi);
        }
        if (i12 > i11) {
            return true;
        }
        return false;
    }

    public static boolean isSmallDevice() {
        Context applicationContext = Instabug.getApplicationContext();
        if (applicationContext != null && (applicationContext.getResources().getConfiguration().screenLayout & 48) == 16) {
            return true;
        }
        return false;
    }

    public static int getDisplayHeightInPx(Context context) {
        return DeviceStateProvider.getDisplayMetrics(context).heightPixels;
    }
}
