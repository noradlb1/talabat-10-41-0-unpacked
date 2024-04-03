package androidx.compose.ui.node;

import androidx.compose.ui.node.LayoutNodeLayoutDelegate;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", "invoke"}, k = 3, mv = {1, 7, 1}, xi = 48)
public final class LayoutNodeLayoutDelegate$MeasurePassDelegate$layoutChildren$1$1 extends Lambda implements Function0<Unit> {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ LayoutNodeLayoutDelegate f9929g;

    /* renamed from: h  reason: collision with root package name */
    public final /* synthetic */ LayoutNodeLayoutDelegate.MeasurePassDelegate f9930h;

    /* renamed from: i  reason: collision with root package name */
    public final /* synthetic */ LayoutNode f9931i;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public LayoutNodeLayoutDelegate$MeasurePassDelegate$layoutChildren$1$1(LayoutNodeLayoutDelegate layoutNodeLayoutDelegate, LayoutNodeLayoutDelegate.MeasurePassDelegate measurePassDelegate, LayoutNode layoutNode) {
        super(0);
        this.f9929g = layoutNodeLayoutDelegate;
        this.f9930h = measurePassDelegate;
        this.f9931i = layoutNode;
    }

    public final void invoke() {
        this.f9929g.layoutNode.clearPlaceOrder$ui_release();
        this.f9930h.forEachChildAlignmentLinesOwner(AnonymousClass1.INSTANCE);
        this.f9931i.getInnerCoordinator$ui_release().getMeasureResult$ui_release().placeChildren();
        this.f9929g.layoutNode.checkChildrenPlaceOrderForUpdates$ui_release();
        this.f9930h.forEachChildAlignmentLinesOwner(AnonymousClass2.INSTANCE);
    }
}
