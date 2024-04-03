package g7;

import com.google.android.exoplayer2.Player;
import com.google.android.exoplayer2.SimpleBasePlayer;
import com.google.android.exoplayer2.util.ListenerSet;

public final /* synthetic */ class t2 implements ListenerSet.Event {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ SimpleBasePlayer.State f35269a;

    public /* synthetic */ t2(SimpleBasePlayer.State state) {
        this.f35269a = state;
    }

    public final void invoke(Object obj) {
        ((Player.Listener) obj).onPlayerStateChanged(this.f35269a.playWhenReady, this.f35269a.playbackState);
    }
}
