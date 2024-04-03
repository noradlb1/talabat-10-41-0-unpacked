package g7;

import android.os.Bundle;
import com.google.android.exoplayer2.Bundleable;
import com.google.android.exoplayer2.Timeline;

public final /* synthetic */ class p3 implements Bundleable.Creator {
    public final Bundleable fromBundle(Bundle bundle) {
        return Timeline.Period.fromBundle(bundle);
    }
}
