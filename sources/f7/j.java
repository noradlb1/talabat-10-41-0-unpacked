package f7;

import com.google.android.datatransport.runtime.TransportContext;
import com.google.android.datatransport.runtime.scheduling.jobscheduling.Uploader;
import com.google.android.datatransport.runtime.synchronization.SynchronizationGuard;

public final /* synthetic */ class j implements SynchronizationGuard.CriticalSection {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ Uploader f34455a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ Iterable f34456b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ TransportContext f34457c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ long f34458d;

    public /* synthetic */ j(Uploader uploader, Iterable iterable, TransportContext transportContext, long j11) {
        this.f34455a = uploader;
        this.f34456b = iterable;
        this.f34457c = transportContext;
        this.f34458d = j11;
    }

    public final Object execute() {
        return this.f34455a.lambda$logAndUpdateState$4(this.f34456b, this.f34457c, this.f34458d);
    }
}
