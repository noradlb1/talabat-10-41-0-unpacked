package f7;

import com.google.android.datatransport.runtime.scheduling.jobscheduling.Uploader;
import com.google.android.datatransport.runtime.synchronization.SynchronizationGuard;

public final /* synthetic */ class k implements SynchronizationGuard.CriticalSection {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ Uploader f34459a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ Iterable f34460b;

    public /* synthetic */ k(Uploader uploader, Iterable iterable) {
        this.f34459a = uploader;
        this.f34460b = iterable;
    }

    public final Object execute() {
        return this.f34459a.lambda$logAndUpdateState$5(this.f34460b);
    }
}
