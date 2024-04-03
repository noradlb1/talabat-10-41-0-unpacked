package androidx.compose.foundation;

import androidx.compose.ui.geometry.Size;
import androidx.compose.ui.unit.IntSize;
import androidx.compose.ui.unit.IntSizeKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"<anonymous>", "", "size", "Landroidx/compose/ui/unit/IntSize;", "invoke-ozmzZPI", "(J)V"}, k = 3, mv = {1, 7, 1}, xi = 48)
public final class AndroidEdgeEffectOverscrollEffect$onNewSize$1 extends Lambda implements Function1<IntSize, Unit> {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ AndroidEdgeEffectOverscrollEffect f1439g;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public AndroidEdgeEffectOverscrollEffect$onNewSize$1(AndroidEdgeEffectOverscrollEffect androidEdgeEffectOverscrollEffect) {
        super(1);
        this.f1439g = androidEdgeEffectOverscrollEffect;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        m169invokeozmzZPI(((IntSize) obj).m5642unboximpl());
        return Unit.INSTANCE;
    }

    /* renamed from: invoke-ozmzZPI  reason: not valid java name */
    public final void m169invokeozmzZPI(long j11) {
        boolean z11 = !Size.m2741equalsimpl0(IntSizeKt.m5648toSizeozmzZPI(j11), this.f1439g.containerSize);
        this.f1439g.containerSize = IntSizeKt.m5648toSizeozmzZPI(j11);
        if (z11) {
            this.f1439g.topEffect.setSize(IntSize.m5638getWidthimpl(j11), IntSize.m5637getHeightimpl(j11));
            this.f1439g.bottomEffect.setSize(IntSize.m5638getWidthimpl(j11), IntSize.m5637getHeightimpl(j11));
            this.f1439g.leftEffect.setSize(IntSize.m5637getHeightimpl(j11), IntSize.m5638getWidthimpl(j11));
            this.f1439g.rightEffect.setSize(IntSize.m5637getHeightimpl(j11), IntSize.m5638getWidthimpl(j11));
            this.f1439g.topEffectNegation.setSize(IntSize.m5638getWidthimpl(j11), IntSize.m5637getHeightimpl(j11));
            this.f1439g.bottomEffectNegation.setSize(IntSize.m5638getWidthimpl(j11), IntSize.m5637getHeightimpl(j11));
            this.f1439g.leftEffectNegation.setSize(IntSize.m5637getHeightimpl(j11), IntSize.m5638getWidthimpl(j11));
            this.f1439g.rightEffectNegation.setSize(IntSize.m5637getHeightimpl(j11), IntSize.m5638getWidthimpl(j11));
        }
        if (z11) {
            this.f1439g.invalidateOverscroll();
            this.f1439g.animateToRelease();
        }
    }
}
