package la;

import com.google.firebase.perf.session.gauges.CpuGaugeCollector;
import com.google.firebase.perf.util.Timer;

public final /* synthetic */ class b implements Runnable {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ CpuGaugeCollector f50656b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ Timer f50657c;

    public /* synthetic */ b(CpuGaugeCollector cpuGaugeCollector, Timer timer) {
        this.f50656b = cpuGaugeCollector;
        this.f50657c = timer;
    }

    public final void run() {
        this.f50656b.lambda$scheduleCpuMetricCollectionOnce$1(this.f50657c);
    }
}
