package g7;

import com.google.android.exoplayer2.Player;
import com.google.android.exoplayer2.SimpleBasePlayer;
import com.google.android.exoplayer2.util.ListenerSet;

public final /* synthetic */ class f2 implements ListenerSet.Event {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ SimpleBasePlayer.State f35209a;

    public /* synthetic */ f2(SimpleBasePlayer.State state) {
        this.f35209a = state;
    }

    public final void invoke(Object obj) {
        ((Player.Listener) obj).onSurfaceSizeChanged(this.f35209a.surfaceSize.getWidth(), this.f35209a.surfaceSize.getHeight());
    }
}
