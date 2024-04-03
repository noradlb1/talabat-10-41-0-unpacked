package androidx.compose.ui.node;

import androidx.compose.ui.layout.Placeable;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", "invoke"}, k = 3, mv = {1, 7, 1}, xi = 48)
public final class LayoutNodeLayoutDelegate$LookaheadPassDelegate$placeAt$1 extends Lambda implements Function0<Unit> {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ LayoutNodeLayoutDelegate f9926g;

    /* renamed from: h  reason: collision with root package name */
    public final /* synthetic */ long f9927h;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public LayoutNodeLayoutDelegate$LookaheadPassDelegate$placeAt$1(LayoutNodeLayoutDelegate layoutNodeLayoutDelegate, long j11) {
        super(0);
        this.f9926g = layoutNodeLayoutDelegate;
        this.f9927h = j11;
    }

    public final void invoke() {
        Placeable.PlacementScope.Companion companion = Placeable.PlacementScope.Companion;
        LayoutNodeLayoutDelegate layoutNodeLayoutDelegate = this.f9926g;
        long j11 = this.f9927h;
        LookaheadDelegate lookaheadDelegate$ui_release = layoutNodeLayoutDelegate.getOuterCoordinator().getLookaheadDelegate$ui_release();
        Intrinsics.checkNotNull(lookaheadDelegate$ui_release);
        Placeable.PlacementScope.m4529place70tqf50$default(companion, lookaheadDelegate$ui_release, j11, 0.0f, 2, (Object) null);
    }
}
