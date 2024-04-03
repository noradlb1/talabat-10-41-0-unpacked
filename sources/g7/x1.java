package g7;

import com.google.android.exoplayer2.Player;
import com.google.android.exoplayer2.SimpleBasePlayer;
import com.google.android.exoplayer2.util.ListenerSet;

public final /* synthetic */ class x1 implements ListenerSet.Event {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ SimpleBasePlayer.State f35285a;

    public /* synthetic */ x1(SimpleBasePlayer.State state) {
        this.f35285a = state;
    }

    public final void invoke(Object obj) {
        ((Player.Listener) obj).onSeekForwardIncrementChanged(this.f35285a.seekForwardIncrementMs);
    }
}
