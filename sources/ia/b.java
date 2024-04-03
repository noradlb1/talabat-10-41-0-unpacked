package ia;

import com.google.firebase.perf.metrics.AppStartTrace;

public final /* synthetic */ class b implements Runnable {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ AppStartTrace f50642b;

    public /* synthetic */ b(AppStartTrace appStartTrace) {
        this.f50642b = appStartTrace;
    }

    public final void run() {
        this.f50642b.recordOnDrawFrontOfQueue();
    }
}
