package g7;

import com.google.android.exoplayer2.Player;
import com.google.android.exoplayer2.SimpleBasePlayer;
import com.google.android.exoplayer2.util.ListenerSet;

public final /* synthetic */ class t1 implements ListenerSet.Event {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ SimpleBasePlayer.State f35268a;

    public /* synthetic */ t1(SimpleBasePlayer.State state) {
        this.f35268a = state;
    }

    public final void invoke(Object obj) {
        ((Player.Listener) obj).onPlaybackParametersChanged(this.f35268a.playbackParameters);
    }
}
