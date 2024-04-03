package com.instabug.featuresrequest.utils;

import androidx.annotation.StyleRes;
import com.instabug.featuresrequest.R;
import com.instabug.library.Feature;
import com.instabug.library.InstabugColorTheme;
import com.instabug.library.core.InstabugCore;

public abstract class c {
    @StyleRes
    private static int a(InstabugColorTheme instabugColorTheme) {
        return instabugColorTheme == InstabugColorTheme.InstabugColorThemeLight ? R.style.IbFrLight_CustomFont : R.style.IbFrDark_CustomFont;
    }

    @StyleRes
    public static int b(InstabugColorTheme instabugColorTheme) {
        return !InstabugCore.isFeatureEnabled(Feature.CUSTOM_FONT) ? instabugColorTheme == InstabugColorTheme.InstabugColorThemeLight ? R.style.IbFrLight : R.style.IbFrDark : a(instabugColorTheme);
    }
}
