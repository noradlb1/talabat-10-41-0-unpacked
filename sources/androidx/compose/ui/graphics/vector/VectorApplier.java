package androidx.compose.ui.graphics.vector;

import androidx.compose.runtime.AbstractApplier;
import androidx.compose.runtime.internal.StabilityInferred;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@StabilityInferred(parameters = 0)
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\f\b\u0007\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u000f\u0012\u0006\u0010\u0011\u001a\u00020\u0002¢\u0006\u0004\b\u0012\u0010\u0013J\f\u0010\u0004\u001a\u00020\u0003*\u00020\u0002H\u0002J\u0018\u0010\t\u001a\u00020\b2\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\u0002H\u0016J\u0018\u0010\n\u001a\u00020\b2\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\u0002H\u0016J\u0018\u0010\f\u001a\u00020\b2\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u000b\u001a\u00020\u0005H\u0016J\b\u0010\r\u001a\u00020\bH\u0014J \u0010\u0010\u001a\u00020\b2\u0006\u0010\u000e\u001a\u00020\u00052\u0006\u0010\u000f\u001a\u00020\u00052\u0006\u0010\u000b\u001a\u00020\u0005H\u0016¨\u0006\u0014"}, d2 = {"Landroidx/compose/ui/graphics/vector/VectorApplier;", "Landroidx/compose/runtime/AbstractApplier;", "Landroidx/compose/ui/graphics/vector/VNode;", "Landroidx/compose/ui/graphics/vector/GroupComponent;", "asGroup", "", "index", "instance", "", "insertTopDown", "insertBottomUp", "count", "remove", "a", "from", "to", "move", "root", "<init>", "(Landroidx/compose/ui/graphics/vector/VNode;)V", "ui_release"}, k = 1, mv = {1, 7, 1})
public final class VectorApplier extends AbstractApplier<VNode> {
    public static final int $stable = 0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public VectorApplier(@NotNull VNode vNode) {
        super(vNode);
        Intrinsics.checkNotNullParameter(vNode, "root");
    }

    private final GroupComponent asGroup(VNode vNode) {
        if (vNode instanceof GroupComponent) {
            return (GroupComponent) vNode;
        }
        throw new IllegalStateException("Cannot only insert VNode into Group".toString());
    }

    public void a() {
        GroupComponent asGroup = asGroup((VNode) getRoot());
        asGroup.remove(0, asGroup.getNumChildren());
    }

    public void insertBottomUp(int i11, @NotNull VNode vNode) {
        Intrinsics.checkNotNullParameter(vNode, "instance");
    }

    public void move(int i11, int i12, int i13) {
        asGroup((VNode) getCurrent()).move(i11, i12, i13);
    }

    public void remove(int i11, int i12) {
        asGroup((VNode) getCurrent()).remove(i11, i12);
    }

    public void insertTopDown(int i11, @NotNull VNode vNode) {
        Intrinsics.checkNotNullParameter(vNode, "instance");
        asGroup((VNode) getCurrent()).insertAt(i11, vNode);
    }
}
