package g7;

import android.content.Context;
import com.google.android.exoplayer2.upstream.DefaultBandwidthMeter;
import com.google.common.base.Supplier;

public final /* synthetic */ class g0 implements Supplier {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ Context f35211b;

    public /* synthetic */ g0(Context context) {
        this.f35211b = context;
    }

    public final Object get() {
        return DefaultBandwidthMeter.getSingletonInstance(this.f35211b);
    }
}
