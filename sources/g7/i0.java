package g7;

import android.content.Context;
import com.google.android.exoplayer2.ExoPlayer;
import com.google.common.base.Supplier;

public final /* synthetic */ class i0 implements Supplier {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ Context f35224b;

    public /* synthetic */ i0(Context context) {
        this.f35224b = context;
    }

    public final Object get() {
        return ExoPlayer.Builder.lambda$new$0(this.f35224b);
    }
}
