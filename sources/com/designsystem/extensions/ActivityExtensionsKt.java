package com.designsystem.extensions;

import android.app.Activity;
import android.graphics.Insets;
import android.os.Build;
import android.util.DisplayMetrics;
import android.view.WindowInsets;
import android.view.WindowMetrics;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0000\u001a\f\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u0000¨\u0006\u0003"}, d2 = {"getScreenHeight", "", "Landroid/app/Activity;", "marshmallow_release"}, k = 2, mv = {1, 5, 1}, xi = 48)
public final class ActivityExtensionsKt {
    public static final int getScreenHeight(@NotNull Activity activity) {
        Intrinsics.checkNotNullParameter(activity, "<this>");
        if (Build.VERSION.SDK_INT >= 30) {
            WindowMetrics a11 = activity.getWindowManager().getCurrentWindowMetrics();
            Intrinsics.checkNotNullExpressionValue(a11, "this.windowManager.currentWindowMetrics");
            Insets a12 = a11.getWindowInsets().getInsetsIgnoringVisibility(WindowInsets.Type.systemBars());
            Intrinsics.checkNotNullExpressionValue(a12, "windowMetrics.windowInse…Insets.Type.systemBars())");
            return (a11.getBounds().height() - a12.top) - a12.bottom;
        }
        DisplayMetrics displayMetrics = new DisplayMetrics();
        activity.getWindowManager().getDefaultDisplay().getMetrics(displayMetrics);
        return displayMetrics.heightPixels;
    }
}
