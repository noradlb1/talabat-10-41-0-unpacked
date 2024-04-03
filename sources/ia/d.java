package ia;

import com.google.firebase.perf.metrics.AppStartTrace;

public final /* synthetic */ class d implements Runnable {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ AppStartTrace f50644b;

    public /* synthetic */ d(AppStartTrace appStartTrace) {
        this.f50644b = appStartTrace;
    }

    public final void run() {
        this.f50644b.recordPreDrawFrontOfQueue();
    }
}
