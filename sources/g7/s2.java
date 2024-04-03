package g7;

import com.google.android.exoplayer2.Player;
import com.google.android.exoplayer2.SimpleBasePlayer;
import com.google.android.exoplayer2.util.ListenerSet;

public final /* synthetic */ class s2 implements ListenerSet.Event {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ SimpleBasePlayer.State f35266a;

    public /* synthetic */ s2(SimpleBasePlayer.State state) {
        this.f35266a = state;
    }

    public final void invoke(Object obj) {
        SimpleBasePlayer.lambda$updateStateAndInformListeners$33(this.f35266a, (Player.Listener) obj);
    }
}
