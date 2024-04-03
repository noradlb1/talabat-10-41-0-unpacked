package g7;

import com.google.android.exoplayer2.Player;
import com.google.android.exoplayer2.SimpleBasePlayer;
import com.google.android.exoplayer2.util.ListenerSet;

public final /* synthetic */ class w1 implements ListenerSet.Event {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ SimpleBasePlayer.State f35281a;

    public /* synthetic */ w1(SimpleBasePlayer.State state) {
        this.f35281a = state;
    }

    public final void invoke(Object obj) {
        ((Player.Listener) obj).onSeekBackIncrementChanged(this.f35281a.seekBackIncrementMs);
    }
}
