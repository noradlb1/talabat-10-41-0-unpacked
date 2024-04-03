package j8;

import com.google.android.exoplayer2.source.TrackGroup;
import com.google.android.exoplayer2.trackselection.DefaultTrackSelector;
import java.util.List;

public final /* synthetic */ class b implements DefaultTrackSelector.TrackInfo.Factory {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ DefaultTrackSelector.Parameters f35482a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ String f35483b;

    public /* synthetic */ b(DefaultTrackSelector.Parameters parameters, String str) {
        this.f35482a = parameters;
        this.f35483b = str;
    }

    public final List create(int i11, TrackGroup trackGroup, int[] iArr) {
        return DefaultTrackSelector.TextTrackInfo.createForTrackGroup(i11, trackGroup, this.f35482a, iArr, this.f35483b);
    }
}
