package com.instabug.library.util;

import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.util.DisplayMetrics;
import android.view.KeyCharacterMap;
import android.view.ViewConfiguration;
import androidx.annotation.Nullable;

public class ScreenUtility {
    public static int getNavigationBarHeight(Resources resources) {
        int identifier = resources.getIdentifier("navigation_bar_height", "dimen", "android");
        if (identifier > 0) {
            return resources.getDimensionPixelSize(identifier);
        }
        return 0;
    }

    public static int getNavigationBarWidth(Resources resources) {
        int identifier = resources.getIdentifier("navigation_bar_width", "dimen", "android");
        if (identifier > 0) {
            return resources.getDimensionPixelSize(identifier);
        }
        return 0;
    }

    public static int getScreenHeight(@Nullable Context context) {
        if (context != null) {
            return context.getResources().getDisplayMetrics().heightPixels;
        }
        return 0;
    }

    public static boolean hasNavBar(Context context) {
        if (context == null) {
            return false;
        }
        boolean hasPermanentMenuKey = ViewConfiguration.get(context).hasPermanentMenuKey();
        boolean deviceHasKey = KeyCharacterMap.deviceHasKey(4);
        if (!hasPermanentMenuKey || !deviceHasKey) {
            return true;
        }
        return false;
    }

    public static boolean isLandscape(Activity activity) {
        DisplayMetrics displayMetrics = new DisplayMetrics();
        activity.getWindowManager().getDefaultDisplay().getMetrics(displayMetrics);
        if (displayMetrics.widthPixels > displayMetrics.heightPixels) {
            return true;
        }
        return false;
    }
}
