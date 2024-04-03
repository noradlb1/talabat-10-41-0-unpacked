package g7;

import com.google.android.exoplayer2.Player;
import com.google.android.exoplayer2.SimpleBasePlayer;
import com.google.android.exoplayer2.util.ListenerSet;

public final /* synthetic */ class u1 implements ListenerSet.Event {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ SimpleBasePlayer.State f35271a;

    public /* synthetic */ u1(SimpleBasePlayer.State state) {
        this.f35271a = state;
    }

    public final void invoke(Object obj) {
        ((Player.Listener) obj).onRepeatModeChanged(this.f35271a.repeatMode);
    }
}
