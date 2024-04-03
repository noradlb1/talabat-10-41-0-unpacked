package g7;

import android.content.Context;
import com.google.android.exoplayer2.ExoPlayer;
import com.google.common.base.Supplier;

public final /* synthetic */ class m implements Supplier {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ Context f35243b;

    public /* synthetic */ m(Context context) {
        this.f35243b = context;
    }

    public final Object get() {
        return ExoPlayer.Builder.lambda$new$1(this.f35243b);
    }
}
