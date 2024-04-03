package androidx.compose.ui.node;

import androidx.compose.runtime.collection.MutableVector;
import java.util.Comparator;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\b\b\u0000\u0018\u0000 \u000e2\u00020\u0001:\u0001\u000eB\u0005¢\u0006\u0002\u0010\u0002J\u0006\u0010\u0006\u001a\u00020\u0007J\u0010\u0010\b\u001a\u00020\u00072\u0006\u0010\t\u001a\u00020\u0005H\u0002J\u000e\u0010\n\u001a\u00020\u00072\u0006\u0010\u000b\u001a\u00020\u0005J\u000e\u0010\f\u001a\u00020\u00072\u0006\u0010\r\u001a\u00020\u0005R\u0014\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004X\u0004¢\u0006\u0002\n\u0000¨\u0006\u000f"}, d2 = {"Landroidx/compose/ui/node/OnPositionedDispatcher;", "", "()V", "layoutNodes", "Landroidx/compose/runtime/collection/MutableVector;", "Landroidx/compose/ui/node/LayoutNode;", "dispatch", "", "dispatchHierarchy", "layoutNode", "onNodePositioned", "node", "onRootNodePositioned", "rootNode", "Companion", "ui_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class OnPositionedDispatcher {
    @NotNull
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    @NotNull
    private final MutableVector<LayoutNode> layoutNodes = new MutableVector<>(new LayoutNode[16], 0);

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\b\u0003\u0018\u00002\u00020\u0001:\u0001\u0003B\u0007\b\u0002¢\u0006\u0002\u0010\u0002¨\u0006\u0004"}, d2 = {"Landroidx/compose/ui/node/OnPositionedDispatcher$Companion;", "", "()V", "DepthComparator", "ui_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public static final class Companion {

        @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\bÂ\u0002\u0018\u00002\u0012\u0012\u0004\u0012\u00020\u00020\u0001j\b\u0012\u0004\u0012\u00020\u0002`\u0003B\u0007\b\u0002¢\u0006\u0002\u0010\u0004J\u0018\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u00022\u0006\u0010\b\u001a\u00020\u0002H\u0016¨\u0006\t"}, d2 = {"Landroidx/compose/ui/node/OnPositionedDispatcher$Companion$DepthComparator;", "Ljava/util/Comparator;", "Landroidx/compose/ui/node/LayoutNode;", "Lkotlin/Comparator;", "()V", "compare", "", "a", "b", "ui_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
        public static final class DepthComparator implements Comparator<LayoutNode> {
            @NotNull
            public static final DepthComparator INSTANCE = new DepthComparator();

            private DepthComparator() {
            }

            public int compare(@NotNull LayoutNode layoutNode, @NotNull LayoutNode layoutNode2) {
                Intrinsics.checkNotNullParameter(layoutNode, "a");
                Intrinsics.checkNotNullParameter(layoutNode2, "b");
                int compare = Intrinsics.compare(layoutNode2.getDepth$ui_release(), layoutNode.getDepth$ui_release());
                if (compare != 0) {
                    return compare;
                }
                return Intrinsics.compare(layoutNode.hashCode(), layoutNode2.hashCode());
            }
        }

        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    private final void dispatchHierarchy(LayoutNode layoutNode) {
        layoutNode.dispatchOnPositionedCallbacks$ui_release();
        int i11 = 0;
        layoutNode.setNeedsOnPositionedDispatch$ui_release(false);
        MutableVector<LayoutNode> mutableVector = layoutNode.get_children$ui_release();
        int size = mutableVector.getSize();
        if (size > 0) {
            Object[] content = mutableVector.getContent();
            Intrinsics.checkNotNull(content, "null cannot be cast to non-null type kotlin.Array<T of androidx.compose.runtime.collection.MutableVector>");
            do {
                dispatchHierarchy((LayoutNode) content[i11]);
                i11++;
            } while (i11 < size);
        }
    }

    public final void dispatch() {
        this.layoutNodes.sortWith(Companion.DepthComparator.INSTANCE);
        MutableVector<LayoutNode> mutableVector = this.layoutNodes;
        int size = mutableVector.getSize();
        if (size > 0) {
            int i11 = size - 1;
            Object[] content = mutableVector.getContent();
            Intrinsics.checkNotNull(content, "null cannot be cast to non-null type kotlin.Array<T of androidx.compose.runtime.collection.MutableVector>");
            do {
                LayoutNode layoutNode = (LayoutNode) content[i11];
                if (layoutNode.getNeedsOnPositionedDispatch$ui_release()) {
                    dispatchHierarchy(layoutNode);
                }
                i11--;
            } while (i11 >= 0);
        }
        this.layoutNodes.clear();
    }

    public final void onNodePositioned(@NotNull LayoutNode layoutNode) {
        Intrinsics.checkNotNullParameter(layoutNode, "node");
        this.layoutNodes.add(layoutNode);
        layoutNode.setNeedsOnPositionedDispatch$ui_release(true);
    }

    public final void onRootNodePositioned(@NotNull LayoutNode layoutNode) {
        Intrinsics.checkNotNullParameter(layoutNode, "rootNode");
        this.layoutNodes.clear();
        this.layoutNodes.add(layoutNode);
        layoutNode.setNeedsOnPositionedDispatch$ui_release(true);
    }
}
