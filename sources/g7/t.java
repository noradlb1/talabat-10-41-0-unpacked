package g7;

import android.content.Context;
import com.google.android.exoplayer2.ExoPlayer;
import com.google.common.base.Supplier;

public final /* synthetic */ class t implements Supplier {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ Context f35267b;

    public /* synthetic */ t(Context context) {
        this.f35267b = context;
    }

    public final Object get() {
        return ExoPlayer.Builder.lambda$new$3(this.f35267b);
    }
}
