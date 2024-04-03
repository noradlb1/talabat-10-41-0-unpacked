package androidx.compose.ui.node;

import androidx.compose.runtime.AbstractApplier;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\r\b\u0000\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u000f\u0012\u0006\u0010\u0010\u001a\u00020\u0002¢\u0006\u0004\b\u0011\u0010\u0012J\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u0002H\u0016J\u0018\u0010\b\u001a\u00020\u00062\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u0002H\u0016J\u0018\u0010\n\u001a\u00020\u00062\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\t\u001a\u00020\u0003H\u0016J \u0010\r\u001a\u00020\u00062\u0006\u0010\u000b\u001a\u00020\u00032\u0006\u0010\f\u001a\u00020\u00032\u0006\u0010\t\u001a\u00020\u0003H\u0016J\b\u0010\u000e\u001a\u00020\u0006H\u0014J\b\u0010\u000f\u001a\u00020\u0006H\u0016¨\u0006\u0013"}, d2 = {"Landroidx/compose/ui/node/UiApplier;", "Landroidx/compose/runtime/AbstractApplier;", "Landroidx/compose/ui/node/LayoutNode;", "", "index", "instance", "", "insertTopDown", "insertBottomUp", "count", "remove", "from", "to", "move", "a", "onEndChanges", "root", "<init>", "(Landroidx/compose/ui/node/LayoutNode;)V", "ui_release"}, k = 1, mv = {1, 7, 1})
public final class UiApplier extends AbstractApplier<LayoutNode> {
    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public UiApplier(@NotNull LayoutNode layoutNode) {
        super(layoutNode);
        Intrinsics.checkNotNullParameter(layoutNode, "root");
    }

    public void a() {
        ((LayoutNode) getRoot()).removeAll$ui_release();
    }

    public void insertTopDown(int i11, @NotNull LayoutNode layoutNode) {
        Intrinsics.checkNotNullParameter(layoutNode, "instance");
    }

    public void move(int i11, int i12, int i13) {
        ((LayoutNode) getCurrent()).move$ui_release(i11, i12, i13);
    }

    public void onEndChanges() {
        super.onEndChanges();
        Owner owner$ui_release = ((LayoutNode) getRoot()).getOwner$ui_release();
        if (owner$ui_release != null) {
            owner$ui_release.onEndApplyChanges();
        }
    }

    public void remove(int i11, int i12) {
        ((LayoutNode) getCurrent()).removeAt$ui_release(i11, i12);
    }

    public void insertBottomUp(int i11, @NotNull LayoutNode layoutNode) {
        Intrinsics.checkNotNullParameter(layoutNode, "instance");
        ((LayoutNode) getCurrent()).insertAt$ui_release(i11, layoutNode);
    }
}
