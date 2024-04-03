package g7;

import com.google.android.exoplayer2.MediaMetadata;
import com.google.android.exoplayer2.SimpleBasePlayer;
import com.google.common.base.Supplier;

public final /* synthetic */ class c3 implements Supplier {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ SimpleBasePlayer.State f35192b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ MediaMetadata f35193c;

    public /* synthetic */ c3(SimpleBasePlayer.State state, MediaMetadata mediaMetadata) {
        this.f35192b = state;
        this.f35193c = mediaMetadata;
    }

    public final Object get() {
        return this.f35192b.buildUpon().setPlaylistMetadata(this.f35193c).build();
    }
}
