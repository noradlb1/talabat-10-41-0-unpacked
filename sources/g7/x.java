package g7;

import com.google.android.exoplayer2.ExoPlayer;
import com.google.android.exoplayer2.trackselection.TrackSelector;
import com.google.common.base.Supplier;

public final /* synthetic */ class x implements Supplier {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ TrackSelector f35284b;

    public /* synthetic */ x(TrackSelector trackSelector) {
        this.f35284b = trackSelector;
    }

    public final Object get() {
        return ExoPlayer.Builder.lambda$new$10(this.f35284b);
    }
}
