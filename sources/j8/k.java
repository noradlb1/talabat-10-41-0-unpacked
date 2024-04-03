package j8;

import com.google.android.exoplayer2.trackselection.ExoTrackSelection;
import com.google.android.exoplayer2.trackselection.RandomTrackSelection;
import com.google.android.exoplayer2.trackselection.TrackSelectionUtil;

public final /* synthetic */ class k implements TrackSelectionUtil.AdaptiveTrackSelectionFactory {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ RandomTrackSelection.Factory f35490a;

    public /* synthetic */ k(RandomTrackSelection.Factory factory) {
        this.f35490a = factory;
    }

    public final ExoTrackSelection createAdaptiveTrackSelection(ExoTrackSelection.Definition definition) {
        return this.f35490a.lambda$createTrackSelections$0(definition);
    }
}
