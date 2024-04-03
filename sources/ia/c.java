package ia;

import com.google.firebase.perf.metrics.AppStartTrace;

public final /* synthetic */ class c implements Runnable {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ AppStartTrace f50643b;

    public /* synthetic */ c(AppStartTrace appStartTrace) {
        this.f50643b = appStartTrace;
    }

    public final void run() {
        this.f50643b.recordPreDraw();
    }
}
