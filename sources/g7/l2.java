package g7;

import com.google.android.exoplayer2.MediaItem;
import com.google.android.exoplayer2.Player;
import com.google.android.exoplayer2.util.ListenerSet;

public final /* synthetic */ class l2 implements ListenerSet.Event {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ MediaItem f35241a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ int f35242b;

    public /* synthetic */ l2(MediaItem mediaItem, int i11) {
        this.f35241a = mediaItem;
        this.f35242b = i11;
    }

    public final void invoke(Object obj) {
        ((Player.Listener) obj).onMediaItemTransition(this.f35241a, this.f35242b);
    }
}
