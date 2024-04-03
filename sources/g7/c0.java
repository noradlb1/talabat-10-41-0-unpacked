package g7;

import com.google.android.exoplayer2.ExoPlayer;
import com.google.android.exoplayer2.source.MediaSource;
import com.google.common.base.Supplier;

public final /* synthetic */ class c0 implements Supplier {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ MediaSource.Factory f35190b;

    public /* synthetic */ c0(MediaSource.Factory factory) {
        this.f35190b = factory;
    }

    public final Object get() {
        return ExoPlayer.Builder.lambda$setMediaSourceFactory$17(this.f35190b);
    }
}
