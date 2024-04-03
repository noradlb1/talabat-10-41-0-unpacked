package he;

import com.newrelic.agent.android.background.ApplicationStateMonitor;

public final /* synthetic */ class b implements Runnable {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ ApplicationStateMonitor f56870b;

    public /* synthetic */ b(ApplicationStateMonitor applicationStateMonitor) {
        this.f56870b = applicationStateMonitor;
    }

    public final void run() {
        this.f56870b.lambda$activityStarted$1();
    }
}
