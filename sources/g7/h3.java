package g7;

import android.view.SurfaceView;
import com.google.android.exoplayer2.SimpleBasePlayer;
import com.google.common.base.Supplier;

public final /* synthetic */ class h3 implements Supplier {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ SimpleBasePlayer.State f35222b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ SurfaceView f35223c;

    public /* synthetic */ h3(SimpleBasePlayer.State state, SurfaceView surfaceView) {
        this.f35222b = state;
        this.f35223c = surfaceView;
    }

    public final Object get() {
        return this.f35222b.buildUpon().setSurfaceSize(SimpleBasePlayer.getSurfaceHolderSize(this.f35223c.getHolder())).build();
    }
}
