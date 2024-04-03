package androidx.compose.ui.node;

import androidx.compose.ui.layout.LayoutCoordinates;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u0016\n\u0000\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\"\u001e\u0010\u0000\u001a\u00020\u0001*\u00020\u00028@X\u0004¢\u0006\f\u0012\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0000\u0010\u0005\"\u001e\u0010\u0006\u001a\u00020\u0007*\u00020\u00028@X\u0004¢\u0006\f\u0012\u0004\b\b\u0010\u0004\u001a\u0004\b\t\u0010\n¨\u0006\u000b"}, d2 = {"isAttached", "", "Landroidx/compose/ui/node/PointerInputModifierNode;", "isAttached$annotations", "(Landroidx/compose/ui/node/PointerInputModifierNode;)V", "(Landroidx/compose/ui/node/PointerInputModifierNode;)Z", "layoutCoordinates", "Landroidx/compose/ui/layout/LayoutCoordinates;", "getLayoutCoordinates$annotations", "getLayoutCoordinates", "(Landroidx/compose/ui/node/PointerInputModifierNode;)Landroidx/compose/ui/layout/LayoutCoordinates;", "ui_release"}, k = 2, mv = {1, 7, 1}, xi = 48)
public final class PointerInputModifierNodeKt {
    @NotNull
    public static final LayoutCoordinates getLayoutCoordinates(@NotNull PointerInputModifierNode pointerInputModifierNode) {
        Intrinsics.checkNotNullParameter(pointerInputModifierNode, "<this>");
        return DelegatableNodeKt.m4588requireCoordinator64DMado(pointerInputModifierNode, Nodes.INSTANCE.m4765getPointerInputOLwlOKw());
    }

    public static /* synthetic */ void getLayoutCoordinates$annotations(PointerInputModifierNode pointerInputModifierNode) {
    }

    public static final boolean isAttached(@NotNull PointerInputModifierNode pointerInputModifierNode) {
        Intrinsics.checkNotNullParameter(pointerInputModifierNode, "<this>");
        return pointerInputModifierNode.getNode().isAttached();
    }

    public static /* synthetic */ void isAttached$annotations(PointerInputModifierNode pointerInputModifierNode) {
    }
}
