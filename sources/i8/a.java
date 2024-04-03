package i8;

import android.os.Bundle;
import com.google.android.exoplayer2.Bundleable;
import com.google.android.exoplayer2.text.Cue;

public final /* synthetic */ class a implements Bundleable.Creator {
    public final Bundleable fromBundle(Bundle bundle) {
        return Cue.fromBundle(bundle);
    }
}
