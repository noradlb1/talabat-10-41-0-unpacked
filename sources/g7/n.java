package g7;

import com.google.android.exoplayer2.ExoPlayer;
import com.google.android.exoplayer2.RenderersFactory;
import com.google.common.base.Supplier;

public final /* synthetic */ class n implements Supplier {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ RenderersFactory f35247b;

    public /* synthetic */ n(RenderersFactory renderersFactory) {
        this.f35247b = renderersFactory;
    }

    public final Object get() {
        return ExoPlayer.Builder.lambda$setRenderersFactory$16(this.f35247b);
    }
}
