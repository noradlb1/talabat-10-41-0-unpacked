package com.instabug.library.util;

import android.graphics.ColorFilter;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffColorFilter;
import android.graphics.drawable.Drawable;
import android.widget.ImageView;
import com.instabug.library.core.InstabugCore;
import com.instabug.library.settings.SettingsManager;

public class Colorizer {
    public static void applyPrimaryColorTint(ImageView imageView) {
        applyTint(SettingsManager.getInstance().getPrimaryColor(), imageView);
    }

    public static void applyTint(int i11, ImageView imageView) {
        imageView.clearColorFilter();
        imageView.setColorFilter(new PorterDuffColorFilter(i11, PorterDuff.Mode.SRC_IN));
    }

    public static ColorFilter getPrimaryColorFilter() {
        return new PorterDuffColorFilter(SettingsManager.getInstance().getPrimaryColor(), PorterDuff.Mode.SRC_IN);
    }

    public static Drawable getPrimaryColorTintedDrawable(Drawable drawable) {
        return getTintedDrawable(InstabugCore.getPrimaryColor(), drawable);
    }

    public static Drawable getTintedDrawable(int i11, Drawable drawable) {
        drawable.clearColorFilter();
        drawable.setColorFilter(i11, PorterDuff.Mode.SRC_IN);
        return drawable;
    }
}
