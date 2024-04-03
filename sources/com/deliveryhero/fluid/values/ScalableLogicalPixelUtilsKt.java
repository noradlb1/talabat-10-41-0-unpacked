package com.deliveryhero.fluid.values;

import android.content.Context;
import android.util.TypedValue;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u0014\n\u0000\n\u0002\u0010\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a\u0015\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0004H\b\u001a\u0015\u0010\u0005\u001a\u00020\u0002*\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0001H\b¨\u0006\u0007"}, d2 = {"toPixel", "", "Lcom/deliveryhero/fluid/values/ScalableLogicalPixel;", "context", "Landroid/content/Context;", "toScalableLogicalPixel", "px", "core_release"}, k = 2, mv = {1, 6, 0}, xi = 48)
public final class ScalableLogicalPixelUtilsKt {
    public static final float toPixel(@NotNull ScalableLogicalPixel scalableLogicalPixel, @NotNull Context context) {
        Intrinsics.checkNotNullParameter(scalableLogicalPixel, "<this>");
        Intrinsics.checkNotNullParameter(context, "context");
        return TypedValue.applyDimension(2, scalableLogicalPixel.getValue(), context.getResources().getDisplayMetrics());
    }

    @NotNull
    public static final ScalableLogicalPixel toScalableLogicalPixel(@NotNull Context context, float f11) {
        Intrinsics.checkNotNullParameter(context, "<this>");
        return new ScalableLogicalPixel(f11 / context.getResources().getDisplayMetrics().scaledDensity);
    }
}
