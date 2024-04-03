package ma;

import com.google.firebase.perf.transport.TransportManager;
import com.google.firebase.perf.v1.ApplicationProcessState;
import com.google.firebase.perf.v1.NetworkRequestMetric;

public final /* synthetic */ class d implements Runnable {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ TransportManager f50672b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ NetworkRequestMetric f50673c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ ApplicationProcessState f50674d;

    public /* synthetic */ d(TransportManager transportManager, NetworkRequestMetric networkRequestMetric, ApplicationProcessState applicationProcessState) {
        this.f50672b = transportManager;
        this.f50673c = networkRequestMetric;
        this.f50674d = applicationProcessState;
    }

    public final void run() {
        this.f50672b.lambda$log$3(this.f50673c, this.f50674d);
    }
}
