package androidx.compose.ui.node;

import androidx.compose.runtime.collection.MutableVector;
import androidx.compose.ui.node.LayoutNode;
import androidx.compose.ui.node.LayoutNodeLayoutDelegate;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", "invoke"}, k = 3, mv = {1, 7, 1}, xi = 48)
public final class LayoutNodeLayoutDelegate$LookaheadPassDelegate$layoutChildren$1 extends Lambda implements Function0<Unit> {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ LayoutNodeLayoutDelegate.LookaheadPassDelegate f9923g;

    /* renamed from: h  reason: collision with root package name */
    public final /* synthetic */ LayoutNodeLayoutDelegate f9924h;

    /* renamed from: i  reason: collision with root package name */
    public final /* synthetic */ LookaheadDelegate f9925i;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public LayoutNodeLayoutDelegate$LookaheadPassDelegate$layoutChildren$1(LayoutNodeLayoutDelegate.LookaheadPassDelegate lookaheadPassDelegate, LayoutNodeLayoutDelegate layoutNodeLayoutDelegate, LookaheadDelegate lookaheadDelegate) {
        super(0);
        this.f9923g = lookaheadPassDelegate;
        this.f9924h = layoutNodeLayoutDelegate;
        this.f9925i = lookaheadDelegate;
    }

    public final void invoke() {
        MutableVector<LayoutNode> mutableVector = this.f9923g.f9922b.layoutNode.get_children$ui_release();
        int size = mutableVector.getSize();
        int i11 = 0;
        if (size > 0) {
            Object[] content = mutableVector.getContent();
            Intrinsics.checkNotNull(content, "null cannot be cast to non-null type kotlin.Array<T of androidx.compose.runtime.collection.MutableVector>");
            int i12 = 0;
            do {
                LayoutNodeLayoutDelegate.LookaheadPassDelegate lookaheadPassDelegate$ui_release = ((LayoutNode) content[i12]).getLayoutDelegate$ui_release().getLookaheadPassDelegate$ui_release();
                Intrinsics.checkNotNull(lookaheadPassDelegate$ui_release);
                lookaheadPassDelegate$ui_release.isPreviouslyPlaced = lookaheadPassDelegate$ui_release.isPlaced();
                lookaheadPassDelegate$ui_release.setPlaced(false);
                i12++;
            } while (i12 < size);
        }
        MutableVector<LayoutNode> mutableVector2 = this.f9924h.layoutNode.get_children$ui_release();
        int size2 = mutableVector2.getSize();
        if (size2 > 0) {
            Object[] content2 = mutableVector2.getContent();
            Intrinsics.checkNotNull(content2, "null cannot be cast to non-null type kotlin.Array<T of androidx.compose.runtime.collection.MutableVector>");
            int i13 = 0;
            do {
                LayoutNode layoutNode = (LayoutNode) content2[i13];
                if (layoutNode.getMeasuredByParentInLookahead$ui_release() == LayoutNode.UsageByParent.InLayoutBlock) {
                    layoutNode.setMeasuredByParentInLookahead$ui_release(LayoutNode.UsageByParent.NotUsed);
                }
                i13++;
            } while (i13 < size2);
        }
        this.f9923g.forEachChildAlignmentLinesOwner(AnonymousClass3.INSTANCE);
        this.f9925i.getMeasureResult$ui_release().placeChildren();
        this.f9923g.forEachChildAlignmentLinesOwner(AnonymousClass4.INSTANCE);
        MutableVector<LayoutNode> mutableVector3 = this.f9923g.f9922b.layoutNode.get_children$ui_release();
        int size3 = mutableVector3.getSize();
        if (size3 > 0) {
            Object[] content3 = mutableVector3.getContent();
            Intrinsics.checkNotNull(content3, "null cannot be cast to non-null type kotlin.Array<T of androidx.compose.runtime.collection.MutableVector>");
            do {
                LayoutNodeLayoutDelegate.LookaheadPassDelegate lookaheadPassDelegate$ui_release2 = ((LayoutNode) content3[i11]).getLayoutDelegate$ui_release().getLookaheadPassDelegate$ui_release();
                Intrinsics.checkNotNull(lookaheadPassDelegate$ui_release2);
                if (!lookaheadPassDelegate$ui_release2.isPlaced()) {
                    lookaheadPassDelegate$ui_release2.markSubtreeNotPlaced();
                }
                i11++;
            } while (i11 < size3);
        }
    }
}
