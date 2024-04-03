package androidx.compose.ui.node;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", "invoke"}, k = 3, mv = {1, 7, 1}, xi = 48)
public final class LayoutNodeLayoutDelegate$performLookaheadMeasure$1 extends Lambda implements Function0<Unit> {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ LayoutNodeLayoutDelegate f9936g;

    /* renamed from: h  reason: collision with root package name */
    public final /* synthetic */ long f9937h;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public LayoutNodeLayoutDelegate$performLookaheadMeasure$1(LayoutNodeLayoutDelegate layoutNodeLayoutDelegate, long j11) {
        super(0);
        this.f9936g = layoutNodeLayoutDelegate;
        this.f9937h = j11;
    }

    public final void invoke() {
        LookaheadDelegate lookaheadDelegate$ui_release = this.f9936g.getOuterCoordinator().getLookaheadDelegate$ui_release();
        Intrinsics.checkNotNull(lookaheadDelegate$ui_release);
        lookaheadDelegate$ui_release.m4508measureBRTryo0(this.f9937h);
    }
}
