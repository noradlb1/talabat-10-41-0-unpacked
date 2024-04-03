package f7;

import com.google.android.datatransport.runtime.scheduling.jobscheduling.Uploader;
import com.google.android.datatransport.runtime.synchronization.SynchronizationGuard;

public final /* synthetic */ class l implements SynchronizationGuard.CriticalSection {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ Uploader f34461a;

    public /* synthetic */ l(Uploader uploader) {
        this.f34461a = uploader;
    }

    public final Object execute() {
        return this.f34461a.lambda$logAndUpdateState$6();
    }
}
