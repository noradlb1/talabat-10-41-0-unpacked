package g7;

import com.google.android.exoplayer2.Player;
import com.google.android.exoplayer2.SimpleBasePlayer;
import com.google.android.exoplayer2.util.ListenerSet;

public final /* synthetic */ class n1 implements ListenerSet.Event {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ SimpleBasePlayer.State f35248a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ int f35249b;

    public /* synthetic */ n1(SimpleBasePlayer.State state, int i11) {
        this.f35248a = state;
        this.f35249b = i11;
    }

    public final void invoke(Object obj) {
        ((Player.Listener) obj).onTimelineChanged(this.f35248a.timeline, this.f35249b);
    }
}
