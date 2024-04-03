package ia;

import com.google.firebase.perf.metrics.AppStartTrace;

public final /* synthetic */ class e implements Runnable {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ AppStartTrace f50645b;

    public /* synthetic */ e(AppStartTrace appStartTrace) {
        this.f50645b = appStartTrace;
    }

    public final void run() {
        this.f50645b.logAppStartTrace();
    }
}
