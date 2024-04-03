package androidx.compose.ui.layout;

import androidx.compose.ui.layout.SubcomposeLayoutState;
import androidx.compose.ui.node.LayoutNode;
import androidx.compose.ui.node.LayoutNodeKt;
import java.util.List;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000#\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0006\u001a\u00020\u0007H\u0016J%\u0010\b\u001a\u00020\u00072\u0006\u0010\t\u001a\u00020\u00032\u0006\u0010\n\u001a\u00020\u000bH\u0016ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\f\u0010\rR\u0014\u0010\u0002\u001a\u00020\u00038VX\u0004¢\u0006\u0006\u001a\u0004\b\u0004\u0010\u0005\u0002\u000b\n\u0005\b¡\u001e0\u0001\n\u0002\b\u0019¨\u0006\u000e"}, d2 = {"androidx/compose/ui/layout/LayoutNodeSubcompositionsState$precompose$1", "Landroidx/compose/ui/layout/SubcomposeLayoutState$PrecomposedSlotHandle;", "placeablesCount", "", "getPlaceablesCount", "()I", "dispose", "", "premeasure", "index", "constraints", "Landroidx/compose/ui/unit/Constraints;", "premeasure-0kLqBqw", "(IJ)V", "ui_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class LayoutNodeSubcompositionsState$precompose$1 implements SubcomposeLayoutState.PrecomposedSlotHandle {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ LayoutNodeSubcompositionsState f9856a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ Object f9857b;

    public LayoutNodeSubcompositionsState$precompose$1(LayoutNodeSubcompositionsState layoutNodeSubcompositionsState, Object obj) {
        this.f9856a = layoutNodeSubcompositionsState;
        this.f9857b = obj;
    }

    public void dispose() {
        boolean z11;
        this.f9856a.makeSureStateIsConsistent();
        LayoutNode layoutNode = (LayoutNode) this.f9856a.precomposeMap.remove(this.f9857b);
        if (layoutNode != null) {
            boolean z12 = false;
            if (this.f9856a.precomposedCount > 0) {
                z11 = true;
            } else {
                z11 = false;
            }
            if (z11) {
                int indexOf = this.f9856a.root.getFoldedChildren$ui_release().indexOf(layoutNode);
                if (indexOf >= this.f9856a.root.getFoldedChildren$ui_release().size() - this.f9856a.precomposedCount) {
                    z12 = true;
                }
                if (z12) {
                    LayoutNodeSubcompositionsState layoutNodeSubcompositionsState = this.f9856a;
                    layoutNodeSubcompositionsState.reusableCount = layoutNodeSubcompositionsState.reusableCount + 1;
                    LayoutNodeSubcompositionsState layoutNodeSubcompositionsState2 = this.f9856a;
                    layoutNodeSubcompositionsState2.precomposedCount = layoutNodeSubcompositionsState2.precomposedCount - 1;
                    int size = (this.f9856a.root.getFoldedChildren$ui_release().size() - this.f9856a.precomposedCount) - this.f9856a.reusableCount;
                    this.f9856a.move(indexOf, size, 1);
                    this.f9856a.disposeOrReuseStartingFromIndex(size);
                    return;
                }
                throw new IllegalStateException("Check failed.".toString());
            }
            throw new IllegalStateException("Check failed.".toString());
        }
    }

    public int getPlaceablesCount() {
        List<LayoutNode> children$ui_release;
        LayoutNode layoutNode = (LayoutNode) this.f9856a.precomposeMap.get(this.f9857b);
        if (layoutNode == null || (children$ui_release = layoutNode.getChildren$ui_release()) == null) {
            return 0;
        }
        return children$ui_release.size();
    }

    /* renamed from: premeasure-0kLqBqw  reason: not valid java name */
    public void m4496premeasure0kLqBqw(int i11, long j11) {
        LayoutNode layoutNode = (LayoutNode) this.f9856a.precomposeMap.get(this.f9857b);
        if (layoutNode != null && layoutNode.isAttached()) {
            int size = layoutNode.getChildren$ui_release().size();
            if (i11 < 0 || i11 >= size) {
                throw new IndexOutOfBoundsException("Index (" + i11 + ") is out of bound of [0, " + size + ')');
            } else if (!layoutNode.isPlaced()) {
                LayoutNode access$getRoot$p = this.f9856a.root;
                access$getRoot$p.ignoreRemeasureRequests = true;
                LayoutNodeKt.requireOwner(layoutNode).m4777measureAndLayout0kLqBqw(layoutNode.getChildren$ui_release().get(i11), j11);
                access$getRoot$p.ignoreRemeasureRequests = false;
            } else {
                throw new IllegalArgumentException("Failed requirement.".toString());
            }
        }
    }
}
