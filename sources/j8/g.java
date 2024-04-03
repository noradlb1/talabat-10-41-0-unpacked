package j8;

import com.google.android.exoplayer2.source.TrackGroup;
import com.google.android.exoplayer2.trackselection.DefaultTrackSelector;
import java.util.List;

public final /* synthetic */ class g implements DefaultTrackSelector.TrackInfo.Factory {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ DefaultTrackSelector f35487a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ DefaultTrackSelector.Parameters f35488b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ boolean f35489c;

    public /* synthetic */ g(DefaultTrackSelector defaultTrackSelector, DefaultTrackSelector.Parameters parameters, boolean z11) {
        this.f35487a = defaultTrackSelector;
        this.f35488b = parameters;
        this.f35489c = z11;
    }

    public final List create(int i11, TrackGroup trackGroup, int[] iArr) {
        return this.f35487a.lambda$selectAudioTrack$3(this.f35488b, this.f35489c, i11, trackGroup, iArr);
    }
}
