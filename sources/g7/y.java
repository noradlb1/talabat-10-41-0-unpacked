package g7;

import com.google.android.exoplayer2.ExoPlayer;
import com.google.android.exoplayer2.LoadControl;
import com.google.common.base.Supplier;

public final /* synthetic */ class y implements Supplier {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ LoadControl f35287b;

    public /* synthetic */ y(LoadControl loadControl) {
        this.f35287b = loadControl;
    }

    public final Object get() {
        return ExoPlayer.Builder.lambda$new$11(this.f35287b);
    }
}
