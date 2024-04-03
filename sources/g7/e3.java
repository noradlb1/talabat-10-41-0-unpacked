package g7;

import com.google.android.exoplayer2.SimpleBasePlayer;
import com.google.common.base.Supplier;

public final /* synthetic */ class e3 implements Supplier {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ SimpleBasePlayer.State f35206b;

    public /* synthetic */ e3(SimpleBasePlayer.State state) {
        this.f35206b = state;
    }

    public final Object get() {
        return this.f35206b.buildUpon().setPlaybackState(1).setTotalBufferedDurationMs(SimpleBasePlayer.PositionSupplier.ZERO).setContentBufferedPositionMs(k3.a(SimpleBasePlayer.getContentPositionMsInternal(this.f35206b))).setAdBufferedPositionMs(this.f35206b.adPositionMsSupplier).setIsLoading(false).build();
    }
}
