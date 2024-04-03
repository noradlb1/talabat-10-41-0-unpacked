package g7;

import com.google.android.exoplayer2.ExoPlayer;
import com.google.android.exoplayer2.upstream.BandwidthMeter;
import com.google.common.base.Supplier;

public final /* synthetic */ class b0 implements Supplier {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ BandwidthMeter f35187b;

    public /* synthetic */ b0(BandwidthMeter bandwidthMeter) {
        this.f35187b = bandwidthMeter;
    }

    public final Object get() {
        return ExoPlayer.Builder.lambda$setBandwidthMeter$20(this.f35187b);
    }
}
