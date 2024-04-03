package g7;

import com.google.android.exoplayer2.Player;
import com.google.android.exoplayer2.SimpleBasePlayer;
import com.google.android.exoplayer2.util.ListenerSet;

public final /* synthetic */ class p2 implements ListenerSet.Event {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ SimpleBasePlayer.State f35257a;

    public /* synthetic */ p2(SimpleBasePlayer.State state) {
        this.f35257a = state;
    }

    public final void invoke(Object obj) {
        ((Player.Listener) obj).onTrackSelectionParametersChanged(this.f35257a.trackSelectionParameters);
    }
}
