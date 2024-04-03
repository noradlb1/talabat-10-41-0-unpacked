package com.deliveryhero.fluid.utils;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import androidx.annotation.DrawableRes;
import androidx.appcompat.content.res.AppCompatResources;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u0018\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\u001a\u001c\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\b\b\u0001\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006¨\u0006\u0007"}, d2 = {"getDrawableCompat", "Landroid/graphics/drawable/Drawable;", "Landroid/content/Context;", "id", "", "name", "", "core_release"}, k = 2, mv = {1, 6, 0}, xi = 48)
public final class ResourcesUtilsKt {
    @NotNull
    public static final Drawable getDrawableCompat(@NotNull Context context, @DrawableRes int i11, @NotNull String str) {
        Intrinsics.checkNotNullParameter(context, "<this>");
        Intrinsics.checkNotNullParameter(str, "name");
        Drawable drawable = AppCompatResources.getDrawable(context, i11);
        if (drawable != null) {
            return drawable;
        }
        throw new Resources.NotFoundException("drawable/" + str);
    }
}
