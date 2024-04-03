package la;

import com.google.firebase.perf.session.gauges.MemoryGaugeCollector;
import com.google.firebase.perf.util.Timer;

public final /* synthetic */ class h implements Runnable {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ MemoryGaugeCollector f50664b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ Timer f50665c;

    public /* synthetic */ h(MemoryGaugeCollector memoryGaugeCollector, Timer timer) {
        this.f50664b = memoryGaugeCollector;
        this.f50665c = timer;
    }

    public final void run() {
        this.f50664b.lambda$scheduleMemoryMetricCollectionWithRate$0(this.f50665c);
    }
}
