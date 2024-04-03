package g7;

import com.google.android.exoplayer2.Player;
import com.google.android.exoplayer2.SimpleBasePlayer;
import com.google.android.exoplayer2.util.ListenerSet;

public final /* synthetic */ class g2 implements ListenerSet.Event {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ SimpleBasePlayer.State f35216a;

    public /* synthetic */ g2(SimpleBasePlayer.State state) {
        this.f35216a = state;
    }

    public final void invoke(Object obj) {
        ((Player.Listener) obj).onVolumeChanged(this.f35216a.volume);
    }
}
