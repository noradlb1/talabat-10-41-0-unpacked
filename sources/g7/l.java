package g7;

import com.google.android.exoplayer2.ExoPlayer;
import com.google.android.exoplayer2.trackselection.TrackSelector;
import com.google.common.base.Supplier;

public final /* synthetic */ class l implements Supplier {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ TrackSelector f35238b;

    public /* synthetic */ l(TrackSelector trackSelector) {
        this.f35238b = trackSelector;
    }

    public final Object get() {
        return ExoPlayer.Builder.lambda$setTrackSelector$18(this.f35238b);
    }
}
