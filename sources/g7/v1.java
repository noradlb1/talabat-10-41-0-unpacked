package g7;

import com.google.android.exoplayer2.Player;
import com.google.android.exoplayer2.SimpleBasePlayer;
import com.google.android.exoplayer2.util.ListenerSet;

public final /* synthetic */ class v1 implements ListenerSet.Event {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ SimpleBasePlayer.State f35274a;

    public /* synthetic */ v1(SimpleBasePlayer.State state) {
        this.f35274a = state;
    }

    public final void invoke(Object obj) {
        ((Player.Listener) obj).onShuffleModeEnabledChanged(this.f35274a.shuffleModeEnabled);
    }
}
