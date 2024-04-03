package g7;

import com.google.android.exoplayer2.PlaybackParameters;
import com.google.android.exoplayer2.SimpleBasePlayer;
import com.google.common.base.Supplier;

public final /* synthetic */ class y2 implements Supplier {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ SimpleBasePlayer.State f35289b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ PlaybackParameters f35290c;

    public /* synthetic */ y2(SimpleBasePlayer.State state, PlaybackParameters playbackParameters) {
        this.f35289b = state;
        this.f35290c = playbackParameters;
    }

    public final Object get() {
        return this.f35289b.buildUpon().setPlaybackParameters(this.f35290c).build();
    }
}
