package com.deliveryhero.fluid.values;

import android.content.Context;
import android.util.TypedValue;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u001c\n\u0000\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0002\u001a\u0015\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0004H\b\u001a\u0015\u0010\u0005\u001a\u00020\u0002*\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0007H\b\u001a\u0015\u0010\u0005\u001a\u00020\u0002*\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0001H\b\u001a\u0015\u0010\b\u001a\u00020\u0007*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0004H\b¨\u0006\t"}, d2 = {"toIntPixel", "", "Lcom/deliveryhero/fluid/values/LogicalPixel;", "context", "Landroid/content/Context;", "toLogicalPixel", "px", "", "toPixel", "core_release"}, k = 2, mv = {1, 6, 0}, xi = 48)
public final class LogicalPixelUtilsKt {
    public static final int toIntPixel(@NotNull LogicalPixel logicalPixel, @NotNull Context context) {
        Intrinsics.checkNotNullParameter(logicalPixel, "<this>");
        Intrinsics.checkNotNullParameter(context, "context");
        return (int) TypedValue.applyDimension(1, logicalPixel.getValue(), context.getResources().getDisplayMetrics());
    }

    @NotNull
    public static final LogicalPixel toLogicalPixel(@NotNull Context context, float f11) {
        Intrinsics.checkNotNullParameter(context, "<this>");
        return new LogicalPixel(f11 / context.getResources().getDisplayMetrics().density);
    }

    public static final float toPixel(@NotNull LogicalPixel logicalPixel, @NotNull Context context) {
        Intrinsics.checkNotNullParameter(logicalPixel, "<this>");
        Intrinsics.checkNotNullParameter(context, "context");
        return TypedValue.applyDimension(1, logicalPixel.getValue(), context.getResources().getDisplayMetrics());
    }

    @NotNull
    public static final LogicalPixel toLogicalPixel(@NotNull Context context, int i11) {
        Intrinsics.checkNotNullParameter(context, "<this>");
        return new LogicalPixel(((float) i11) / context.getResources().getDisplayMetrics().density);
    }
}
