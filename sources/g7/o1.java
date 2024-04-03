package g7;

import com.google.android.exoplayer2.SimpleBasePlayer;
import com.google.android.exoplayer2.trackselection.TrackSelectionParameters;
import com.google.common.base.Supplier;

public final /* synthetic */ class o1 implements Supplier {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ SimpleBasePlayer.State f35252b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ TrackSelectionParameters f35253c;

    public /* synthetic */ o1(SimpleBasePlayer.State state, TrackSelectionParameters trackSelectionParameters) {
        this.f35252b = state;
        this.f35253c = trackSelectionParameters;
    }

    public final Object get() {
        return this.f35252b.buildUpon().setTrackSelectionParameters(this.f35253c).build();
    }
}
