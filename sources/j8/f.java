package j8;

import com.google.android.exoplayer2.source.TrackGroup;
import com.google.android.exoplayer2.trackselection.DefaultTrackSelector;
import java.util.List;

public final /* synthetic */ class f implements DefaultTrackSelector.TrackInfo.Factory {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ DefaultTrackSelector.Parameters f35485a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ int[] f35486b;

    public /* synthetic */ f(DefaultTrackSelector.Parameters parameters, int[] iArr) {
        this.f35485a = parameters;
        this.f35486b = iArr;
    }

    public final List create(int i11, TrackGroup trackGroup, int[] iArr) {
        return DefaultTrackSelector.VideoTrackInfo.createForTrackGroup(i11, trackGroup, this.f35485a, iArr, this.f35486b[i11]);
    }
}
