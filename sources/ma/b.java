package ma;

import com.google.firebase.perf.transport.TransportManager;
import com.google.firebase.perf.v1.ApplicationProcessState;
import com.google.firebase.perf.v1.TraceMetric;

public final /* synthetic */ class b implements Runnable {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ TransportManager f50668b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ TraceMetric f50669c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ ApplicationProcessState f50670d;

    public /* synthetic */ b(TransportManager transportManager, TraceMetric traceMetric, ApplicationProcessState applicationProcessState) {
        this.f50668b = transportManager;
        this.f50669c = traceMetric;
        this.f50670d = applicationProcessState;
    }

    public final void run() {
        this.f50668b.lambda$log$2(this.f50669c, this.f50670d);
    }
}
