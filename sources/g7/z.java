package g7;

import com.google.android.exoplayer2.ExoPlayer;
import com.google.android.exoplayer2.upstream.BandwidthMeter;
import com.google.common.base.Supplier;

public final /* synthetic */ class z implements Supplier {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ BandwidthMeter f35291b;

    public /* synthetic */ z(BandwidthMeter bandwidthMeter) {
        this.f35291b = bandwidthMeter;
    }

    public final Object get() {
        return ExoPlayer.Builder.lambda$new$12(this.f35291b);
    }
}
