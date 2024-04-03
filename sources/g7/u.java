package g7;

import com.google.android.exoplayer2.ExoPlayer;
import com.google.android.exoplayer2.RenderersFactory;
import com.google.common.base.Supplier;

public final /* synthetic */ class u implements Supplier {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ RenderersFactory f35270b;

    public /* synthetic */ u(RenderersFactory renderersFactory) {
        this.f35270b = renderersFactory;
    }

    public final Object get() {
        return ExoPlayer.Builder.lambda$new$8(this.f35270b);
    }
}
