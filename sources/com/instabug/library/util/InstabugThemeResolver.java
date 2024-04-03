package com.instabug.library.util;

import androidx.annotation.StyleRes;
import com.instabug.library.Feature;
import com.instabug.library.InstabugColorTheme;
import com.instabug.library.R;
import com.instabug.library.core.InstabugCore;

public class InstabugThemeResolver {
    @StyleRes
    private static int getCustomFontTheme(InstabugColorTheme instabugColorTheme) {
        if (instabugColorTheme == InstabugColorTheme.InstabugColorThemeLight) {
            return R.style.InstabugSdkTheme_Light_CustomFont;
        }
        return R.style.InstabugSdkTheme_Dark_CustomFont;
    }

    @StyleRes
    public static int resolveTheme(InstabugColorTheme instabugColorTheme) {
        if (InstabugCore.isFeatureEnabled(Feature.CUSTOM_FONT)) {
            return getCustomFontTheme(instabugColorTheme);
        }
        if (instabugColorTheme == InstabugColorTheme.InstabugColorThemeLight) {
            return R.style.InstabugSdkTheme_Light;
        }
        return R.style.InstabugSdkTheme_Dark;
    }
}
