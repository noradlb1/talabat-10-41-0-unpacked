package la;

import com.google.firebase.perf.session.gauges.CpuGaugeCollector;
import com.google.firebase.perf.util.Timer;

public final /* synthetic */ class a implements Runnable {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ CpuGaugeCollector f50654b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ Timer f50655c;

    public /* synthetic */ a(CpuGaugeCollector cpuGaugeCollector, Timer timer) {
        this.f50654b = cpuGaugeCollector;
        this.f50655c = timer;
    }

    public final void run() {
        this.f50654b.lambda$scheduleCpuMetricCollectionWithRate$0(this.f50655c);
    }
}
