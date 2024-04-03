package com.instabug.library.util;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import androidx.annotation.DrawableRes;
import com.instabug.library.R;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public final class ResourcesUtils {
    @NotNull
    public static final ResourcesUtils INSTANCE = new ResourcesUtils();

    private ResourcesUtils() {
    }

    @JvmStatic
    @Nullable
    public static final Drawable getDrawable(@DrawableRes int i11, @NotNull Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        return context.getResources().getDrawable(i11, context.getTheme());
    }

    @JvmStatic
    @NotNull
    public static final String getSelectedText(@NotNull Resources resources, boolean z11) {
        String str;
        String str2;
        Intrinsics.checkNotNullParameter(resources, "<this>");
        if (z11) {
            str2 = resources.getString(R.string.ib_selected);
            str = "getString(R.string.ib_selected)";
        } else {
            str2 = resources.getString(R.string.ib_unselected);
            str = "getString(R.string.ib_unselected)";
        }
        Intrinsics.checkNotNullExpressionValue(str2, str);
        return str2;
    }

    @JvmStatic
    @Nullable
    public static final Drawable getVectorDrawable(@DrawableRes int i11, @NotNull Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        return context.getResources().getDrawable(i11, context.getTheme());
    }
}
