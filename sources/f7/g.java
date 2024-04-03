package f7;

import com.google.android.datatransport.runtime.TransportContext;
import com.google.android.datatransport.runtime.scheduling.jobscheduling.Uploader;
import com.google.android.datatransport.runtime.synchronization.SynchronizationGuard;

public final /* synthetic */ class g implements SynchronizationGuard.CriticalSection {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ Uploader f34448a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ TransportContext f34449b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ int f34450c;

    public /* synthetic */ g(Uploader uploader, TransportContext transportContext, int i11) {
        this.f34448a = uploader;
        this.f34449b = transportContext;
        this.f34450c = i11;
    }

    public final Object execute() {
        return this.f34448a.lambda$upload$0(this.f34449b, this.f34450c);
    }
}
