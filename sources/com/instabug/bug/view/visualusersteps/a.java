package com.instabug.bug.view.visualusersteps;

import android.os.Build;
import android.text.Html;
import android.text.Spanned;
import com.instabug.bug.utils.d;
import com.instabug.library.Feature;
import com.instabug.library.core.InstabugCore;

public abstract class a {
    public static Spanned a(String str, String str2) {
        String a11 = a(str + " [" + str2 + "](" + "#repro-steps-screen" + ")");
        return Build.VERSION.SDK_INT >= 24 ? Html.fromHtml(a11, 0) : Html.fromHtml(a11);
    }

    private static String a(String str) {
        return d.a(str, "#repro-steps-screen", "");
    }

    public static boolean b(String str) {
        return str != null && !str.isEmpty() && InstabugCore.getFeatureState(Feature.REPRO_STEPS) == Feature.State.ENABLED && InstabugCore.isReproStepsScreenshotEnabled();
    }
}
