package g7;

import android.content.Context;
import com.google.android.exoplayer2.ExoPlayer;
import com.google.common.base.Supplier;

public final /* synthetic */ class o implements Supplier {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ Context f35251b;

    public /* synthetic */ o(Context context) {
        this.f35251b = context;
    }

    public final Object get() {
        return ExoPlayer.Builder.lambda$new$4(this.f35251b);
    }
}
