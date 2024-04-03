package com.instabug.survey.utils;

import androidx.annotation.StyleRes;
import com.instabug.library.Feature;
import com.instabug.library.InstabugColorTheme;
import com.instabug.library.core.InstabugCore;
import com.instabug.survey.R;

public abstract class p {
    @StyleRes
    private static int a(InstabugColorTheme instabugColorTheme) {
        return instabugColorTheme == InstabugColorTheme.InstabugColorThemeLight ? R.style.InstabugSurveyLight_CustomFont : R.style.InstabugSurveyDark_CustomFont;
    }

    @StyleRes
    public static int b(InstabugColorTheme instabugColorTheme) {
        return !InstabugCore.isFeatureEnabled(Feature.CUSTOM_FONT) ? instabugColorTheme == InstabugColorTheme.InstabugColorThemeLight ? R.style.InstabugSurveyLight : R.style.InstabugSurveyDark : a(instabugColorTheme);
    }
}
