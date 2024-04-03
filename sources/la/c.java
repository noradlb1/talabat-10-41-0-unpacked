package la;

import com.google.firebase.perf.session.gauges.GaugeManager;
import com.google.firebase.perf.v1.ApplicationProcessState;

public final /* synthetic */ class c implements Runnable {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ GaugeManager f50658b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ String f50659c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ ApplicationProcessState f50660d;

    public /* synthetic */ c(GaugeManager gaugeManager, String str, ApplicationProcessState applicationProcessState) {
        this.f50658b = gaugeManager;
        this.f50659c = str;
        this.f50660d = applicationProcessState;
    }

    public final void run() {
        this.f50658b.lambda$stopCollectingGauges$3(this.f50659c, this.f50660d);
    }
}
