package f7;

import com.google.android.datatransport.runtime.scheduling.jobscheduling.WorkInitializer;
import com.google.android.datatransport.runtime.synchronization.SynchronizationGuard;

public final /* synthetic */ class n implements SynchronizationGuard.CriticalSection {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ WorkInitializer f34464a;

    public /* synthetic */ n(WorkInitializer workInitializer) {
        this.f34464a = workInitializer;
    }

    public final Object execute() {
        return this.f34464a.lambda$ensureContextsScheduled$0();
    }
}
