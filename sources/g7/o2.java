package g7;

import com.google.android.exoplayer2.PlaybackException;
import com.google.android.exoplayer2.Player;
import com.google.android.exoplayer2.SimpleBasePlayer;
import com.google.android.exoplayer2.util.ListenerSet;
import com.google.android.exoplayer2.util.Util;

public final /* synthetic */ class o2 implements ListenerSet.Event {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ SimpleBasePlayer.State f35254a;

    public /* synthetic */ o2(SimpleBasePlayer.State state) {
        this.f35254a = state;
    }

    public final void invoke(Object obj) {
        ((Player.Listener) obj).onPlayerError((PlaybackException) Util.castNonNull(this.f35254a.playerError));
    }
}
