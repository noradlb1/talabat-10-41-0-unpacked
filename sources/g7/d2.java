package g7;

import com.google.android.exoplayer2.Player;
import com.google.android.exoplayer2.SimpleBasePlayer;
import com.google.android.exoplayer2.util.ListenerSet;

public final /* synthetic */ class d2 implements ListenerSet.Event {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ SimpleBasePlayer.State f35200a;

    public /* synthetic */ d2(SimpleBasePlayer.State state) {
        this.f35200a = state;
    }

    public final void invoke(Object obj) {
        ((Player.Listener) obj).onDeviceInfoChanged(this.f35200a.deviceInfo);
    }
}
