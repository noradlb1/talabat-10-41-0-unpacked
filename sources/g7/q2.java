package g7;

import com.google.android.exoplayer2.Player;
import com.google.android.exoplayer2.Tracks;
import com.google.android.exoplayer2.util.ListenerSet;

public final /* synthetic */ class q2 implements ListenerSet.Event {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ Tracks f35260a;

    public /* synthetic */ q2(Tracks tracks) {
        this.f35260a = tracks;
    }

    public final void invoke(Object obj) {
        ((Player.Listener) obj).onTracksChanged(this.f35260a);
    }
}
