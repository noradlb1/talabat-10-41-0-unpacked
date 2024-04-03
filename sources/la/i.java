package la;

import com.google.firebase.perf.session.gauges.MemoryGaugeCollector;
import com.google.firebase.perf.util.Timer;

public final /* synthetic */ class i implements Runnable {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ MemoryGaugeCollector f50666b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ Timer f50667c;

    public /* synthetic */ i(MemoryGaugeCollector memoryGaugeCollector, Timer timer) {
        this.f50666b = memoryGaugeCollector;
        this.f50667c = timer;
    }

    public final void run() {
        this.f50666b.lambda$scheduleMemoryMetricCollectionOnce$1(this.f50667c);
    }
}
