package com.designsystem.extensions;

import android.content.Context;
import android.hardware.display.DisplayManager;
import android.os.Build;
import android.view.Display;
import android.view.WindowManager;
import androidx.annotation.ColorInt;
import androidx.annotation.ColorRes;
import androidx.core.content.ContextCompat;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\u0014\n\u0000\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\u001a\u0016\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\b\b\u0001\u0010\u0003\u001a\u00020\u0001H\u0001\u001a\u000e\u0010\u0004\u001a\u0004\u0018\u00010\u0005*\u00020\u0002H\u0000¨\u0006\u0006"}, d2 = {"getColorCompat", "", "Landroid/content/Context;", "color", "getCurrentDisplay", "Landroid/view/Display;", "marshmallow_release"}, k = 2, mv = {1, 5, 1}, xi = 48)
public final class ContextExtensionsKt {
    @ColorInt
    public static final int getColorCompat(@NotNull Context context, @ColorRes int i11) {
        Intrinsics.checkNotNullParameter(context, "<this>");
        return ContextCompat.getColor(context, i11);
    }

    @Nullable
    public static final Display getCurrentDisplay(@NotNull Context context) {
        Intrinsics.checkNotNullParameter(context, "<this>");
        if (Build.VERSION.SDK_INT >= 30) {
            Object systemService = context.getSystemService("display");
            if (systemService != null) {
                return ((DisplayManager) systemService).getDisplay(0);
            }
            throw new NullPointerException("null cannot be cast to non-null type android.hardware.display.DisplayManager");
        }
        Object systemService2 = context.getSystemService("window");
        if (systemService2 != null) {
            return ((WindowManager) systemService2).getDefaultDisplay();
        }
        throw new NullPointerException("null cannot be cast to non-null type android.view.WindowManager");
    }
}
