package com.instabug.library.util;

import android.app.Activity;
import android.graphics.Color;
import android.view.View;
import android.view.Window;
import androidx.annotation.NonNull;
import androidx.core.content.ContextCompat;
import com.google.android.exoplayer2.C;
import com.instabug.library.InstabugColorTheme;
import com.instabug.library.R;
import com.instabug.library.core.InstabugCore;
import com.instabug.library.settings.SettingsManager;

public class StatusBarUtils {
    private static int darkenColor(int i11) {
        float[] fArr = new float[3];
        Color.colorToHSV(i11, fArr);
        fArr[2] = fArr[2] * 0.8f;
        return Color.HSVToColor(fArr);
    }

    public static void darkenStatusBarColor(@NonNull Activity activity, int i11) {
        int i12;
        if (InstabugCore.getTheme() == InstabugColorTheme.InstabugColorThemeLight) {
            i12 = darkenColor(i11);
        } else {
            i12 = darkenColor(ContextCompat.getColor(activity, R.color.instabug_toolbar_color_dark));
        }
        Window window = activity.getWindow();
        window.addFlags(Integer.MIN_VALUE);
        window.setStatusBarColor(i12);
        activity.getWindow().getDecorView().setSystemUiVisibility(0);
    }

    public static void setStatusBar(Activity activity) {
        Window window = activity.getWindow();
        window.addFlags(Integer.MIN_VALUE);
        window.setStatusBarColor(SettingsManager.getInstance().getStatusBarColor());
        View decorView = activity.getWindow().getDecorView();
        if (SettingsManager.getInstance().getTheme() == InstabugColorTheme.InstabugColorThemeLight) {
            decorView.setSystemUiVisibility(8192);
        } else {
            decorView.setSystemUiVisibility(0);
        }
    }

    public static void setStatusBarColorForPrompt(Activity activity) {
        if (activity != null && activity.getWindow() != null) {
            activity.getWindow().addFlags(Integer.MIN_VALUE);
            activity.getWindow().clearFlags(67108864);
            activity.getWindow().addFlags(C.BUFFER_FLAG_FIRST_SAMPLE);
            activity.getWindow().clearFlags(67108864);
            activity.getWindow().setStatusBarColor(0);
        }
    }

    public static void setStatusBarForDialog(@NonNull Activity activity) {
        Window window = activity.getWindow();
        window.addFlags(Integer.MIN_VALUE);
        window.setStatusBarColor(activity.getResources().getColor(17170445));
        View decorView = activity.getWindow().getDecorView();
        decorView.setSystemUiVisibility(decorView.getSystemUiVisibility() | 4096);
    }

    public static void setTranslucent(@NonNull Activity activity, boolean z11) {
        if (z11) {
            activity.getWindow().setFlags(67108864, 67108864);
        } else {
            activity.getWindow().clearFlags(67108864);
        }
    }
}
