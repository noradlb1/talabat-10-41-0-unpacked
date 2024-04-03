package g7;

import com.google.android.exoplayer2.Player;
import com.google.android.exoplayer2.SimpleBasePlayer;
import com.google.android.exoplayer2.util.ListenerSet;

public final /* synthetic */ class r1 implements ListenerSet.Event {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ SimpleBasePlayer.State f35262a;

    public /* synthetic */ r1(SimpleBasePlayer.State state) {
        this.f35262a = state;
    }

    public final void invoke(Object obj) {
        ((Player.Listener) obj).onPlaybackSuppressionReasonChanged(this.f35262a.playbackSuppressionReason);
    }
}
