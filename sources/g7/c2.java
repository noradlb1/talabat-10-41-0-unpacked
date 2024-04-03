package g7;

import com.google.android.exoplayer2.Player;
import com.google.android.exoplayer2.SimpleBasePlayer;
import com.google.android.exoplayer2.util.ListenerSet;

public final /* synthetic */ class c2 implements ListenerSet.Event {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ SimpleBasePlayer.State f35191a;

    public /* synthetic */ c2(SimpleBasePlayer.State state) {
        this.f35191a = state;
    }

    public final void invoke(Object obj) {
        ((Player.Listener) obj).onVideoSizeChanged(this.f35191a.videoSize);
    }
}
