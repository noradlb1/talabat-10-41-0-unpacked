package g7;

import com.google.android.exoplayer2.Player;
import com.google.android.exoplayer2.SimpleBasePlayer;
import com.google.android.exoplayer2.util.ListenerSet;

public final /* synthetic */ class q1 implements ListenerSet.Event {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ SimpleBasePlayer.State f35259a;

    public /* synthetic */ q1(SimpleBasePlayer.State state) {
        this.f35259a = state;
    }

    public final void invoke(Object obj) {
        ((Player.Listener) obj).onPlayWhenReadyChanged(this.f35259a.playWhenReady, this.f35259a.playWhenReadyChangeReason);
    }
}
