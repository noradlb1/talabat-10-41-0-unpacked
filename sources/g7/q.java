package g7;

import com.google.android.exoplayer2.ExoPlayer;
import com.google.android.exoplayer2.RenderersFactory;
import com.google.common.base.Supplier;

public final /* synthetic */ class q implements Supplier {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ RenderersFactory f35258b;

    public /* synthetic */ q(RenderersFactory renderersFactory) {
        this.f35258b = renderersFactory;
    }

    public final Object get() {
        return ExoPlayer.Builder.lambda$new$6(this.f35258b);
    }
}
