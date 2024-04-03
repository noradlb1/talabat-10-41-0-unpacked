package he;

import com.newrelic.agent.android.background.ApplicationStateMonitor;

public final /* synthetic */ class a implements Runnable {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ ApplicationStateMonitor f56869b;

    public /* synthetic */ a(ApplicationStateMonitor applicationStateMonitor) {
        this.f56869b = applicationStateMonitor;
    }

    public final void run() {
        this.f56869b.lambda$uiHidden$0();
    }
}
