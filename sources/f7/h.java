package f7;

import com.google.android.datatransport.runtime.TransportContext;
import com.google.android.datatransport.runtime.scheduling.jobscheduling.Uploader;
import com.google.android.datatransport.runtime.synchronization.SynchronizationGuard;

public final /* synthetic */ class h implements SynchronizationGuard.CriticalSection {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ Uploader f34451a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ TransportContext f34452b;

    public /* synthetic */ h(Uploader uploader, TransportContext transportContext) {
        this.f34451a = uploader;
        this.f34452b = transportContext;
    }

    public final Object execute() {
        return this.f34451a.lambda$logAndUpdateState$2(this.f34452b);
    }
}
