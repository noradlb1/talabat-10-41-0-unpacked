package j8;

import android.os.Bundle;
import com.google.android.exoplayer2.Bundleable;
import com.google.android.exoplayer2.trackselection.TrackSelectionParameters;

public final /* synthetic */ class m implements Bundleable.Creator {
    public final Bundleable fromBundle(Bundle bundle) {
        return TrackSelectionParameters.fromBundle(bundle);
    }
}
