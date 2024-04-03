package g7;

import com.google.android.exoplayer2.Player;
import com.google.android.exoplayer2.SimpleBasePlayer;
import com.google.android.exoplayer2.util.ListenerSet;

public final /* synthetic */ class h2 implements ListenerSet.Event {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ SimpleBasePlayer.State f35221a;

    public /* synthetic */ h2(SimpleBasePlayer.State state) {
        this.f35221a = state;
    }

    public final void invoke(Object obj) {
        ((Player.Listener) obj).onDeviceVolumeChanged(this.f35221a.deviceVolume, this.f35221a.isDeviceMuted);
    }
}
