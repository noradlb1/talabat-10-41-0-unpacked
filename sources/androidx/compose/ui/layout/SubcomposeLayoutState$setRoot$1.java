package androidx.compose.ui.layout;

import androidx.compose.ui.node.LayoutNode;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u0012\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0004H\n¢\u0006\u0002\b\u0005"}, d2 = {"<anonymous>", "", "Landroidx/compose/ui/node/LayoutNode;", "it", "Landroidx/compose/ui/layout/SubcomposeLayoutState;", "invoke"}, k = 3, mv = {1, 7, 1}, xi = 48)
public final class SubcomposeLayoutState$setRoot$1 extends Lambda implements Function2<LayoutNode, SubcomposeLayoutState, Unit> {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ SubcomposeLayoutState f9894g;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public SubcomposeLayoutState$setRoot$1(SubcomposeLayoutState subcomposeLayoutState) {
        super(2);
        this.f9894g = subcomposeLayoutState;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
        invoke((LayoutNode) obj, (SubcomposeLayoutState) obj2);
        return Unit.INSTANCE;
    }

    public final void invoke(@NotNull LayoutNode layoutNode, @NotNull SubcomposeLayoutState subcomposeLayoutState) {
        Intrinsics.checkNotNullParameter(layoutNode, "$this$null");
        Intrinsics.checkNotNullParameter(subcomposeLayoutState, "it");
        SubcomposeLayoutState subcomposeLayoutState2 = this.f9894g;
        LayoutNodeSubcompositionsState subcompositionsState$ui_release = layoutNode.getSubcompositionsState$ui_release();
        if (subcompositionsState$ui_release == null) {
            subcompositionsState$ui_release = new LayoutNodeSubcompositionsState(layoutNode, this.f9894g.slotReusePolicy);
            layoutNode.setSubcompositionsState$ui_release(subcompositionsState$ui_release);
        }
        subcomposeLayoutState2._state = subcompositionsState$ui_release;
        this.f9894g.getState().makeSureStateIsConsistent();
        this.f9894g.getState().setSlotReusePolicy(this.f9894g.slotReusePolicy);
    }
}
