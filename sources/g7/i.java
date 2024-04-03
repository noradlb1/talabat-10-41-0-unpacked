package g7;

import android.os.Bundle;
import com.google.android.exoplayer2.Bundleable;
import com.google.android.exoplayer2.ExoPlaybackException;

public final /* synthetic */ class i implements Bundleable.Creator {
    public final Bundleable fromBundle(Bundle bundle) {
        return ExoPlaybackException.a(bundle);
    }
}
