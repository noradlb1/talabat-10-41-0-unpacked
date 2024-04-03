package ma;

import com.google.firebase.perf.transport.TransportManager;
import com.google.firebase.perf.v1.ApplicationProcessState;
import com.google.firebase.perf.v1.GaugeMetric;

public final /* synthetic */ class f implements Runnable {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ TransportManager f50676b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ GaugeMetric f50677c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ ApplicationProcessState f50678d;

    public /* synthetic */ f(TransportManager transportManager, GaugeMetric gaugeMetric, ApplicationProcessState applicationProcessState) {
        this.f50676b = transportManager;
        this.f50677c = gaugeMetric;
        this.f50678d = applicationProcessState;
    }

    public final void run() {
        this.f50676b.lambda$log$4(this.f50677c, this.f50678d);
    }
}
