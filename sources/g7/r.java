package g7;

import com.google.android.exoplayer2.ExoPlayer;
import com.google.android.exoplayer2.source.MediaSource;
import com.google.common.base.Supplier;

public final /* synthetic */ class r implements Supplier {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ MediaSource.Factory f35261b;

    public /* synthetic */ r(MediaSource.Factory factory) {
        this.f35261b = factory;
    }

    public final Object get() {
        return ExoPlayer.Builder.lambda$new$7(this.f35261b);
    }
}
