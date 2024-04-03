package g7;

import com.google.android.exoplayer2.Player;
import com.google.android.exoplayer2.SimpleBasePlayer;
import com.google.android.exoplayer2.util.ListenerSet;

public final /* synthetic */ class i2 implements ListenerSet.Event {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ SimpleBasePlayer.State f35227a;

    public /* synthetic */ i2(SimpleBasePlayer.State state) {
        this.f35227a = state;
    }

    public final void invoke(Object obj) {
        SimpleBasePlayer.lambda$updateStateAndInformListeners$52(this.f35227a, (Player.Listener) obj);
    }
}
