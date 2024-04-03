package j8;

import android.os.Bundle;
import com.google.android.exoplayer2.Bundleable;
import com.google.android.exoplayer2.trackselection.DefaultTrackSelector;

public final /* synthetic */ class i implements Bundleable.Creator {
    public final Bundleable fromBundle(Bundle bundle) {
        return DefaultTrackSelector.SelectionOverride.lambda$static$0(bundle);
    }
}
