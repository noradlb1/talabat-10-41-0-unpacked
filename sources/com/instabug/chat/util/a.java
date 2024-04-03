package com.instabug.chat.util;

import androidx.annotation.StyleRes;
import com.instabug.chat.R;
import com.instabug.library.Feature;
import com.instabug.library.InstabugColorTheme;
import com.instabug.library.core.InstabugCore;

public abstract class a {
    @StyleRes
    private static int a(InstabugColorTheme instabugColorTheme) {
        return instabugColorTheme == InstabugColorTheme.InstabugColorThemeLight ? R.style.InstabugChatLight_CustomFont : R.style.InstabugChatDark_CustomFont;
    }

    @StyleRes
    public static int b(InstabugColorTheme instabugColorTheme) {
        return !InstabugCore.isFeatureEnabled(Feature.CUSTOM_FONT) ? instabugColorTheme == InstabugColorTheme.InstabugColorThemeLight ? R.style.InstabugChatLight : R.style.InstabugChatDark : a(instabugColorTheme);
    }
}
