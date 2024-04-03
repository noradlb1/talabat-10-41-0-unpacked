package com.talabat.feature.tpro.presentation.util;

import android.content.Context;
import android.graphics.drawable.GradientDrawable;
import androidx.core.content.ContextCompat;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u0014\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\u001a\u0016\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005¨\u0006\u0006"}, d2 = {"createGradientDrawable", "Landroid/graphics/drawable/GradientDrawable;", "context", "Landroid/content/Context;", "color", "", "com_talabat_feature_tpro_presentation_presentation"}, k = 2, mv = {1, 6, 0}, xi = 48)
public final class CreateGradientDrawableKt {
    @NotNull
    public static final GradientDrawable createGradientDrawable(@NotNull Context context, int i11) {
        Intrinsics.checkNotNullParameter(context, "context");
        return new GradientDrawable(GradientDrawable.Orientation.TOP_BOTTOM, new int[]{ContextCompat.getColor(context, i11), ContextCompat.getColor(context, i11), 17170445});
    }
}
