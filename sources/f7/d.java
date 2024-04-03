package f7;

import com.google.android.datatransport.runtime.TransportContext;
import com.google.android.datatransport.runtime.scheduling.jobscheduling.Uploader;
import com.google.android.datatransport.runtime.synchronization.SynchronizationGuard;

public final /* synthetic */ class d implements SynchronizationGuard.CriticalSection {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ Uploader f34440a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ TransportContext f34441b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ long f34442c;

    public /* synthetic */ d(Uploader uploader, TransportContext transportContext, long j11) {
        this.f34440a = uploader;
        this.f34441b = transportContext;
        this.f34442c = j11;
    }

    public final Object execute() {
        return this.f34440a.lambda$logAndUpdateState$8(this.f34441b, this.f34442c);
    }
}
