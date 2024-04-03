package androidx.compose.ui.node;

import androidx.compose.ui.layout.IntrinsicMeasurable;
import androidx.compose.ui.layout.IntrinsicMeasureScope;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

public final /* synthetic */ class a {
    public static void a(LayoutModifierNode layoutModifierNode) {
        DelegatableNodeKt.requireLayoutNode(layoutModifierNode).forceRemeasure();
    }

    public static int b(LayoutModifierNode layoutModifierNode, @NotNull IntrinsicMeasureScope intrinsicMeasureScope, @NotNull IntrinsicMeasurable intrinsicMeasurable, int i11) {
        Intrinsics.checkNotNullParameter(intrinsicMeasureScope, "<this>");
        Intrinsics.checkNotNullParameter(intrinsicMeasurable, "measurable");
        return NodeMeasuringIntrinsics.INSTANCE.maxHeight$ui_release(layoutModifierNode, intrinsicMeasureScope, intrinsicMeasurable, i11);
    }

    public static int c(LayoutModifierNode layoutModifierNode, @NotNull IntrinsicMeasureScope intrinsicMeasureScope, @NotNull IntrinsicMeasurable intrinsicMeasurable, int i11) {
        Intrinsics.checkNotNullParameter(intrinsicMeasureScope, "<this>");
        Intrinsics.checkNotNullParameter(intrinsicMeasurable, "measurable");
        return NodeMeasuringIntrinsics.INSTANCE.maxWidth$ui_release(layoutModifierNode, intrinsicMeasureScope, intrinsicMeasurable, i11);
    }

    public static int d(LayoutModifierNode layoutModifierNode, @NotNull IntrinsicMeasureScope intrinsicMeasureScope, @NotNull IntrinsicMeasurable intrinsicMeasurable, int i11) {
        Intrinsics.checkNotNullParameter(intrinsicMeasureScope, "<this>");
        Intrinsics.checkNotNullParameter(intrinsicMeasurable, "measurable");
        return NodeMeasuringIntrinsics.INSTANCE.minHeight$ui_release(layoutModifierNode, intrinsicMeasureScope, intrinsicMeasurable, i11);
    }

    public static int e(LayoutModifierNode layoutModifierNode, @NotNull IntrinsicMeasureScope intrinsicMeasureScope, @NotNull IntrinsicMeasurable intrinsicMeasurable, int i11) {
        Intrinsics.checkNotNullParameter(intrinsicMeasureScope, "<this>");
        Intrinsics.checkNotNullParameter(intrinsicMeasurable, "measurable");
        return NodeMeasuringIntrinsics.INSTANCE.minWidth$ui_release(layoutModifierNode, intrinsicMeasureScope, intrinsicMeasurable, i11);
    }
}
