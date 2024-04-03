package g7;

import com.google.android.exoplayer2.ExoPlayer;
import com.google.android.exoplayer2.LoadControl;
import com.google.common.base.Supplier;

public final /* synthetic */ class d0 implements Supplier {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ LoadControl f35194b;

    public /* synthetic */ d0(LoadControl loadControl) {
        this.f35194b = loadControl;
    }

    public final Object get() {
        return ExoPlayer.Builder.lambda$setLoadControl$19(this.f35194b);
    }
}
