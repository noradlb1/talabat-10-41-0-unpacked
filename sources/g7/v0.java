package g7;

import android.os.Bundle;
import com.google.android.exoplayer2.Bundleable;
import com.google.android.exoplayer2.PlaybackException;

public final /* synthetic */ class v0 implements Bundleable.Creator {
    public final Bundleable fromBundle(Bundle bundle) {
        return new PlaybackException(bundle);
    }
}
