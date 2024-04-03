package l8;

import com.google.android.exoplayer2.upstream.DefaultBandwidthMeter;
import com.google.android.exoplayer2.util.NetworkTypeObserver;

public final /* synthetic */ class c implements NetworkTypeObserver.Listener {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ DefaultBandwidthMeter f35527a;

    public /* synthetic */ c(DefaultBandwidthMeter defaultBandwidthMeter) {
        this.f35527a = defaultBandwidthMeter;
    }

    public final void onNetworkTypeChanged(int i11) {
        this.f35527a.onNetworkTypeChanged(i11);
    }
}
