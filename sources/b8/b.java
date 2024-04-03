package b8;

import android.os.Bundle;
import com.google.android.exoplayer2.Bundleable;
import com.google.android.exoplayer2.source.ads.AdPlaybackState;

public final /* synthetic */ class b implements Bundleable.Creator {
    public final Bundleable fromBundle(Bundle bundle) {
        return AdPlaybackState.AdGroup.fromBundle(bundle);
    }
}
