package androidx.compose.ui.layout;

import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

public final /* synthetic */ class a {
    public static int a(LayoutModifier layoutModifier, @NotNull IntrinsicMeasureScope intrinsicMeasureScope, @NotNull IntrinsicMeasurable intrinsicMeasurable, int i11) {
        Intrinsics.checkNotNullParameter(intrinsicMeasureScope, "<this>");
        Intrinsics.checkNotNullParameter(intrinsicMeasurable, "measurable");
        return MeasuringIntrinsics.INSTANCE.maxHeight$ui_release(layoutModifier, intrinsicMeasureScope, intrinsicMeasurable, i11);
    }

    public static int b(LayoutModifier layoutModifier, @NotNull IntrinsicMeasureScope intrinsicMeasureScope, @NotNull IntrinsicMeasurable intrinsicMeasurable, int i11) {
        Intrinsics.checkNotNullParameter(intrinsicMeasureScope, "<this>");
        Intrinsics.checkNotNullParameter(intrinsicMeasurable, "measurable");
        return MeasuringIntrinsics.INSTANCE.maxWidth$ui_release(layoutModifier, intrinsicMeasureScope, intrinsicMeasurable, i11);
    }

    public static int c(LayoutModifier layoutModifier, @NotNull IntrinsicMeasureScope intrinsicMeasureScope, @NotNull IntrinsicMeasurable intrinsicMeasurable, int i11) {
        Intrinsics.checkNotNullParameter(intrinsicMeasureScope, "<this>");
        Intrinsics.checkNotNullParameter(intrinsicMeasurable, "measurable");
        return MeasuringIntrinsics.INSTANCE.minHeight$ui_release(layoutModifier, intrinsicMeasureScope, intrinsicMeasurable, i11);
    }

    public static int d(LayoutModifier layoutModifier, @NotNull IntrinsicMeasureScope intrinsicMeasureScope, @NotNull IntrinsicMeasurable intrinsicMeasurable, int i11) {
        Intrinsics.checkNotNullParameter(intrinsicMeasureScope, "<this>");
        Intrinsics.checkNotNullParameter(intrinsicMeasurable, "measurable");
        return MeasuringIntrinsics.INSTANCE.minWidth$ui_release(layoutModifier, intrinsicMeasureScope, intrinsicMeasurable, i11);
    }
}
