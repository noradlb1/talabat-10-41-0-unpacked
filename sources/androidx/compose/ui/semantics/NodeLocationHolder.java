package androidx.compose.ui.semantics;

import androidx.compose.ui.geometry.Rect;
import androidx.compose.ui.layout.LayoutCoordinatesKt;
import androidx.compose.ui.node.LayoutNode;
import androidx.compose.ui.node.NodeCoordinator;
import androidx.compose.ui.unit.LayoutDirection;
import j0.b;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u000f\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0004\b\u0000\u0018\u0000 \u00102\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0002\u0010\u0011B\u0017\b\u0000\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0002\u0010\u0005J\u0011\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u0000H\u0002R\u000e\u0010\u0006\u001a\u00020\u0007X\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\b\u001a\u0004\u0018\u00010\tX\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0004\u001a\u00020\u0003X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0014\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\u000b¨\u0006\u0012"}, d2 = {"Landroidx/compose/ui/semantics/NodeLocationHolder;", "", "subtreeRoot", "Landroidx/compose/ui/node/LayoutNode;", "node", "(Landroidx/compose/ui/node/LayoutNode;Landroidx/compose/ui/node/LayoutNode;)V", "layoutDirection", "Landroidx/compose/ui/unit/LayoutDirection;", "location", "Landroidx/compose/ui/geometry/Rect;", "getNode$ui_release", "()Landroidx/compose/ui/node/LayoutNode;", "getSubtreeRoot$ui_release", "compareTo", "", "other", "Companion", "ComparisonStrategy", "ui_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class NodeLocationHolder implements Comparable<NodeLocationHolder> {
    @NotNull
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    /* access modifiers changed from: private */
    @NotNull
    public static ComparisonStrategy comparisonStrategy = ComparisonStrategy.Stripe;
    @NotNull
    private final LayoutDirection layoutDirection;
    @Nullable
    private final Rect location;
    @NotNull
    private final LayoutNode node;
    @NotNull
    private final LayoutNode subtreeRoot;

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u001a\u0010\u0003\u001a\u00020\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\b¨\u0006\t"}, d2 = {"Landroidx/compose/ui/semantics/NodeLocationHolder$Companion;", "", "()V", "comparisonStrategy", "Landroidx/compose/ui/semantics/NodeLocationHolder$ComparisonStrategy;", "getComparisonStrategy$ui_release", "()Landroidx/compose/ui/semantics/NodeLocationHolder$ComparisonStrategy;", "setComparisonStrategy$ui_release", "(Landroidx/compose/ui/semantics/NodeLocationHolder$ComparisonStrategy;)V", "ui_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @NotNull
        public final ComparisonStrategy getComparisonStrategy$ui_release() {
            return NodeLocationHolder.comparisonStrategy;
        }

        public final void setComparisonStrategy$ui_release(@NotNull ComparisonStrategy comparisonStrategy) {
            Intrinsics.checkNotNullParameter(comparisonStrategy, "<set-?>");
            NodeLocationHolder.comparisonStrategy = comparisonStrategy;
        }
    }

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0004\b\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004¨\u0006\u0005"}, d2 = {"Landroidx/compose/ui/semantics/NodeLocationHolder$ComparisonStrategy;", "", "(Ljava/lang/String;I)V", "Stripe", "Location", "ui_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public enum ComparisonStrategy {
        Stripe,
        Location
    }

    public NodeLocationHolder(@NotNull LayoutNode layoutNode, @NotNull LayoutNode layoutNode2) {
        Intrinsics.checkNotNullParameter(layoutNode, "subtreeRoot");
        Intrinsics.checkNotNullParameter(layoutNode2, "node");
        this.subtreeRoot = layoutNode;
        this.node = layoutNode2;
        this.layoutDirection = layoutNode.getLayoutDirection();
        NodeCoordinator innerCoordinator$ui_release = layoutNode.getInnerCoordinator$ui_release();
        NodeCoordinator findCoordinatorToGetBounds = SemanticsSortKt.findCoordinatorToGetBounds(layoutNode2);
        Rect rect = null;
        if (innerCoordinator$ui_release.isAttached() && findCoordinatorToGetBounds.isAttached()) {
            rect = b.c(innerCoordinator$ui_release, findCoordinatorToGetBounds, false, 2, (Object) null);
        }
        this.location = rect;
    }

    @NotNull
    public final LayoutNode getNode$ui_release() {
        return this.node;
    }

    @NotNull
    public final LayoutNode getSubtreeRoot$ui_release() {
        return this.subtreeRoot;
    }

    public int compareTo(@NotNull NodeLocationHolder nodeLocationHolder) {
        Intrinsics.checkNotNullParameter(nodeLocationHolder, "other");
        Rect rect = this.location;
        if (rect == null) {
            return 1;
        }
        if (nodeLocationHolder.location == null) {
            return -1;
        }
        if (comparisonStrategy == ComparisonStrategy.Stripe) {
            if (rect.getBottom() - nodeLocationHolder.location.getTop() <= 0.0f) {
                return -1;
            }
            if (this.location.getTop() - nodeLocationHolder.location.getBottom() >= 0.0f) {
                return 1;
            }
        }
        boolean z11 = false;
        if (this.layoutDirection == LayoutDirection.Ltr) {
            int i11 = ((this.location.getLeft() - nodeLocationHolder.location.getLeft()) > 0.0f ? 1 : ((this.location.getLeft() - nodeLocationHolder.location.getLeft()) == 0.0f ? 0 : -1));
            if (!(i11 == 0)) {
                if (i11 < 0) {
                    return -1;
                }
                return 1;
            }
        } else {
            int i12 = ((this.location.getRight() - nodeLocationHolder.location.getRight()) > 0.0f ? 1 : ((this.location.getRight() - nodeLocationHolder.location.getRight()) == 0.0f ? 0 : -1));
            if (!(i12 == 0)) {
                if (i12 < 0) {
                    return 1;
                }
                return -1;
            }
        }
        int i13 = ((this.location.getTop() - nodeLocationHolder.location.getTop()) > 0.0f ? 1 : ((this.location.getTop() - nodeLocationHolder.location.getTop()) == 0.0f ? 0 : -1));
        if (i13 == 0) {
            z11 = true;
        }
        if (z11) {
            Rect boundsInRoot = LayoutCoordinatesKt.boundsInRoot(SemanticsSortKt.findCoordinatorToGetBounds(this.node));
            Rect boundsInRoot2 = LayoutCoordinatesKt.boundsInRoot(SemanticsSortKt.findCoordinatorToGetBounds(nodeLocationHolder.node));
            LayoutNode findNodeByPredicateTraversal = SemanticsSortKt.findNodeByPredicateTraversal(this.node, new NodeLocationHolder$compareTo$child1$1(boundsInRoot));
            LayoutNode findNodeByPredicateTraversal2 = SemanticsSortKt.findNodeByPredicateTraversal(nodeLocationHolder.node, new NodeLocationHolder$compareTo$child2$1(boundsInRoot2));
            if (findNodeByPredicateTraversal != null && findNodeByPredicateTraversal2 != null) {
                return new NodeLocationHolder(this.subtreeRoot, findNodeByPredicateTraversal).compareTo(new NodeLocationHolder(nodeLocationHolder.subtreeRoot, findNodeByPredicateTraversal2));
            }
            if (findNodeByPredicateTraversal != null) {
                return 1;
            }
            if (findNodeByPredicateTraversal2 != null) {
                return -1;
            }
            int compare = LayoutNode.Companion.getZComparator$ui_release().compare(this.node, nodeLocationHolder.node);
            if (compare != 0) {
                return -compare;
            }
            return this.node.getSemanticsId() - nodeLocationHolder.node.getSemanticsId();
        } else if (i13 < 0) {
            return -1;
        } else {
            return 1;
        }
    }
}
