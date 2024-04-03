package g7;

import com.google.android.exoplayer2.ExoPlayer;
import com.google.android.exoplayer2.RenderersFactory;
import com.google.common.base.Supplier;

public final /* synthetic */ class s implements Supplier {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ RenderersFactory f35264b;

    public /* synthetic */ s(RenderersFactory renderersFactory) {
        this.f35264b = renderersFactory;
    }

    public final Object get() {
        return ExoPlayer.Builder.lambda$new$2(this.f35264b);
    }
}
