package g7;

import com.google.android.exoplayer2.ExoPlayer;
import com.google.android.exoplayer2.source.MediaSource;
import com.google.common.base.Supplier;

public final /* synthetic */ class p implements Supplier {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ MediaSource.Factory f35255b;

    public /* synthetic */ p(MediaSource.Factory factory) {
        this.f35255b = factory;
    }

    public final Object get() {
        return ExoPlayer.Builder.lambda$new$5(this.f35255b);
    }
}
