package androidx.compose.ui.node;

import androidx.compose.ui.ExperimentalComposeUiApi;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\u001a\f\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u0001¨\u0006\u0003"}, d2 = {"requestDraw", "", "Landroidx/compose/ui/node/DrawModifierNode;", "ui_release"}, k = 2, mv = {1, 7, 1}, xi = 48)
public final class DrawModifierNodeKt {
    @ExperimentalComposeUiApi
    public static final void requestDraw(@NotNull DrawModifierNode drawModifierNode) {
        Intrinsics.checkNotNullParameter(drawModifierNode, "<this>");
        DelegatableNodeKt.requireLayoutNode(drawModifierNode).invalidateLayer$ui_release();
    }
}
