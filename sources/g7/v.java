package g7;

import com.google.android.exoplayer2.ExoPlayer;
import com.google.android.exoplayer2.source.MediaSource;
import com.google.common.base.Supplier;

public final /* synthetic */ class v implements Supplier {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ MediaSource.Factory f35273b;

    public /* synthetic */ v(MediaSource.Factory factory) {
        this.f35273b = factory;
    }

    public final Object get() {
        return ExoPlayer.Builder.lambda$new$9(this.f35273b);
    }
}
