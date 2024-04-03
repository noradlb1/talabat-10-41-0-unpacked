package lb;

import com.instabug.apm.APMPlugin;
import com.instabug.library.core.eventbus.instabugeventbus.EventBusSubscriber;

public final /* synthetic */ class c implements EventBusSubscriber {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ APMPlugin f47137a;

    public /* synthetic */ c(APMPlugin aPMPlugin) {
        this.f47137a = aPMPlugin;
    }

    public final void onNewEvent(Object obj) {
        this.f47137a.lambda$registerAPMSdkStateEventBus$0((Boolean) obj);
    }
}
