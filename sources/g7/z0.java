package g7;

import android.os.Bundle;
import com.google.android.exoplayer2.Bundleable;
import com.google.android.exoplayer2.Player;

public final /* synthetic */ class z0 implements Bundleable.Creator {
    public final Bundleable fromBundle(Bundle bundle) {
        return Player.PositionInfo.fromBundle(bundle);
    }
}
