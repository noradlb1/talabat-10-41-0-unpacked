package androidx.compose.ui.semantics;

import androidx.compose.ui.geometry.Rect;
import androidx.compose.ui.layout.LayoutCoordinatesKt;
import androidx.compose.ui.node.LayoutNode;
import androidx.compose.ui.node.NodeCoordinator;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"<anonymous>", "", "it", "Landroidx/compose/ui/node/LayoutNode;", "invoke", "(Landroidx/compose/ui/node/LayoutNode;)Ljava/lang/Boolean;"}, k = 3, mv = {1, 7, 1}, xi = 48)
public final class NodeLocationHolder$compareTo$child1$1 extends Lambda implements Function1<LayoutNode, Boolean> {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ Rect f10114g;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public NodeLocationHolder$compareTo$child1$1(Rect rect) {
        super(1);
        this.f10114g = rect;
    }

    @NotNull
    public final Boolean invoke(@NotNull LayoutNode layoutNode) {
        Intrinsics.checkNotNullParameter(layoutNode, "it");
        NodeCoordinator findCoordinatorToGetBounds = SemanticsSortKt.findCoordinatorToGetBounds(layoutNode);
        return Boolean.valueOf(findCoordinatorToGetBounds.isAttached() && !Intrinsics.areEqual((Object) this.f10114g, (Object) LayoutCoordinatesKt.boundsInRoot(findCoordinatorToGetBounds)));
    }
}
