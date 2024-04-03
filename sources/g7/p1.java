package g7;

import com.google.android.exoplayer2.Player;
import com.google.android.exoplayer2.SimpleBasePlayer;
import com.google.android.exoplayer2.util.ListenerSet;

public final /* synthetic */ class p1 implements ListenerSet.Event {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ SimpleBasePlayer.State f35256a;

    public /* synthetic */ p1(SimpleBasePlayer.State state) {
        this.f35256a = state;
    }

    public final void invoke(Object obj) {
        ((Player.Listener) obj).onPlaybackStateChanged(this.f35256a.playbackState);
    }
}
