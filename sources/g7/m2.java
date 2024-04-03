package g7;

import com.google.android.exoplayer2.Player;
import com.google.android.exoplayer2.SimpleBasePlayer;
import com.google.android.exoplayer2.util.ListenerSet;

public final /* synthetic */ class m2 implements ListenerSet.Event {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ SimpleBasePlayer.State f35246a;

    public /* synthetic */ m2(SimpleBasePlayer.State state) {
        this.f35246a = state;
    }

    public final void invoke(Object obj) {
        ((Player.Listener) obj).onAvailableCommandsChanged(this.f35246a.availableCommands);
    }
}
