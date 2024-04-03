package androidx.compose.ui.node;

import androidx.compose.ui.ExperimentalComposeUiApi;
import androidx.compose.ui.layout.LayoutCoordinates;
import androidx.compose.ui.layout.LookaheadLayoutCoordinates;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

@ExperimentalComposeUiApi
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bg\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016J\u0010\u0010\u0006\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0007H\u0016J\u001d\u0010\b\u001a\u00020\u00032\u0006\u0010\t\u001a\u00020\nH\u0016ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\u000b\u0010\fø\u0001\u0002\u0002\u0011\n\u0005\b¡\u001e0\u0001\n\u0002\b\u0019\n\u0004\b!0\u0001¨\u0006\rÀ\u0006\u0001"}, d2 = {"Landroidx/compose/ui/node/LayoutAwareModifierNode;", "Landroidx/compose/ui/node/DelegatableNode;", "onLookaheadPlaced", "", "coordinates", "Landroidx/compose/ui/layout/LookaheadLayoutCoordinates;", "onPlaced", "Landroidx/compose/ui/layout/LayoutCoordinates;", "onRemeasured", "size", "Landroidx/compose/ui/unit/IntSize;", "onRemeasured-ozmzZPI", "(J)V", "ui_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public interface LayoutAwareModifierNode extends DelegatableNode {
    void onLookaheadPlaced(@NotNull LookaheadLayoutCoordinates lookaheadLayoutCoordinates);

    void onPlaced(@NotNull LayoutCoordinates layoutCoordinates);

    /* renamed from: onRemeasured-ozmzZPI  reason: not valid java name */
    void m4611onRemeasuredozmzZPI(long j11);
}
