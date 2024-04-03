package com.instabug.bug.utils;

import androidx.annotation.StyleRes;
import com.instabug.bug.R;
import com.instabug.library.Feature;
import com.instabug.library.InstabugColorTheme;
import com.instabug.library.core.InstabugCore;

public abstract class a {
    @StyleRes
    private static int a(InstabugColorTheme instabugColorTheme) {
        return instabugColorTheme == InstabugColorTheme.InstabugColorThemeLight ? R.style.InstabugBugReportingLight_CustomFont : R.style.InstabugBugReportingDark_CustomFont;
    }

    @StyleRes
    public static int b(InstabugColorTheme instabugColorTheme) {
        return !InstabugCore.isFeatureEnabled(Feature.CUSTOM_FONT) ? instabugColorTheme == InstabugColorTheme.InstabugColorThemeLight ? R.style.InstabugBugReportingLight : R.style.InstabugBugReportingDark : a(instabugColorTheme);
    }
}
