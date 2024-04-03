package g7;

import com.google.android.exoplayer2.Player;
import com.google.android.exoplayer2.SimpleBasePlayer;
import com.google.android.exoplayer2.util.ListenerSet;

public final /* synthetic */ class b2 implements ListenerSet.Event {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ SimpleBasePlayer.State f35188a;

    public /* synthetic */ b2(SimpleBasePlayer.State state) {
        this.f35188a = state;
    }

    public final void invoke(Object obj) {
        ((Player.Listener) obj).onAudioAttributesChanged(this.f35188a.audioAttributes);
    }
}
