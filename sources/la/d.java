package la;

import com.google.firebase.perf.session.gauges.GaugeManager;
import com.google.firebase.perf.v1.ApplicationProcessState;

public final /* synthetic */ class d implements Runnable {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ GaugeManager f50661b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ String f50662c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ ApplicationProcessState f50663d;

    public /* synthetic */ d(GaugeManager gaugeManager, String str, ApplicationProcessState applicationProcessState) {
        this.f50661b = gaugeManager;
        this.f50662c = str;
        this.f50663d = applicationProcessState;
    }

    public final void run() {
        this.f50661b.lambda$startCollectingGauges$2(this.f50662c, this.f50663d);
    }
}
