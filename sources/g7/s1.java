package g7;

import com.google.android.exoplayer2.Player;
import com.google.android.exoplayer2.SimpleBasePlayer;
import com.google.android.exoplayer2.util.ListenerSet;

public final /* synthetic */ class s1 implements ListenerSet.Event {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ SimpleBasePlayer.State f35265a;

    public /* synthetic */ s1(SimpleBasePlayer.State state) {
        this.f35265a = state;
    }

    public final void invoke(Object obj) {
        ((Player.Listener) obj).onIsPlayingChanged(SimpleBasePlayer.isPlaying(this.f35265a));
    }
}
