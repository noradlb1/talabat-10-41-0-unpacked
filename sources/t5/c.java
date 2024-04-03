package t5;

import com.deliveryhero.performance.core.screenmetric.ScreenMetricParent;
import com.deliveryhero.performance.core.tapresponse.TapTracker;

public final /* synthetic */ class c implements Runnable {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ ScreenMetricParent.Builder f34684b;

    public /* synthetic */ c(ScreenMetricParent.Builder builder) {
        this.f34684b = builder;
    }

    public final void run() {
        TapTracker.m8240intercept$lambda0(this.f34684b);
    }
}
