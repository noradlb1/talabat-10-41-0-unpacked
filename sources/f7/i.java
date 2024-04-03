package f7;

import com.google.android.datatransport.runtime.TransportContext;
import com.google.android.datatransport.runtime.scheduling.jobscheduling.Uploader;
import com.google.android.datatransport.runtime.synchronization.SynchronizationGuard;

public final /* synthetic */ class i implements SynchronizationGuard.CriticalSection {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ Uploader f34453a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ TransportContext f34454b;

    public /* synthetic */ i(Uploader uploader, TransportContext transportContext) {
        this.f34453a = uploader;
        this.f34454b = transportContext;
    }

    public final Object execute() {
        return this.f34453a.lambda$logAndUpdateState$3(this.f34454b);
    }
}
