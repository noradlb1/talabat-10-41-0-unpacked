package g7;

import com.google.android.exoplayer2.MediaMetadata;
import com.google.android.exoplayer2.Player;
import com.google.android.exoplayer2.util.ListenerSet;

public final /* synthetic */ class r2 implements ListenerSet.Event {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ MediaMetadata f35263a;

    public /* synthetic */ r2(MediaMetadata mediaMetadata) {
        this.f35263a = mediaMetadata;
    }

    public final void invoke(Object obj) {
        ((Player.Listener) obj).onMediaMetadataChanged(this.f35263a);
    }
}
