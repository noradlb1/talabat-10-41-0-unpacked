package ia;

import com.google.firebase.perf.metrics.AppStartTrace;
import com.google.firebase.perf.v1.TraceMetric;

public final /* synthetic */ class f implements Runnable {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ AppStartTrace f50646b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ TraceMetric.Builder f50647c;

    public /* synthetic */ f(AppStartTrace appStartTrace, TraceMetric.Builder builder) {
        this.f50646b = appStartTrace;
        this.f50647c = builder;
    }

    public final void run() {
        this.f50646b.lambda$logExperimentTrace$0(this.f50647c);
    }
}
