package t5;

import android.view.Window;
import com.deliveryhero.performance.core.tapresponse.CurrentFrameMetricsListener;

public final /* synthetic */ class a implements Runnable {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ Window f34680b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ CurrentFrameMetricsListener f34681c;

    public /* synthetic */ a(Window window, CurrentFrameMetricsListener currentFrameMetricsListener) {
        this.f34680b = window;
        this.f34681c = currentFrameMetricsListener;
    }

    public final void run() {
        CurrentFrameMetricsListener.m8238onFrameMetricsAvailable$lambda0(this.f34680b, this.f34681c);
    }
}
