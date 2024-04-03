package g7;

import android.view.SurfaceHolder;
import com.google.android.exoplayer2.SimpleBasePlayer;
import com.google.common.base.Supplier;

public final /* synthetic */ class w2 implements Supplier {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ SimpleBasePlayer.State f35282b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ SurfaceHolder f35283c;

    public /* synthetic */ w2(SimpleBasePlayer.State state, SurfaceHolder surfaceHolder) {
        this.f35282b = state;
        this.f35283c = surfaceHolder;
    }

    public final Object get() {
        return this.f35282b.buildUpon().setSurfaceSize(SimpleBasePlayer.getSurfaceHolderSize(this.f35283c)).build();
    }
}
