package i8;

import android.os.Bundle;
import com.google.android.exoplayer2.Bundleable;
import com.google.android.exoplayer2.text.CueGroup;

public final /* synthetic */ class b implements Bundleable.Creator {
    public final Bundleable fromBundle(Bundle bundle) {
        return CueGroup.fromBundle(bundle);
    }
}
