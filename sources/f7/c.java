package f7;

import com.google.android.datatransport.runtime.scheduling.persistence.ClientHealthMetricsStore;
import com.google.android.datatransport.runtime.synchronization.SynchronizationGuard;

public final /* synthetic */ class c implements SynchronizationGuard.CriticalSection {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ ClientHealthMetricsStore f34439a;

    public /* synthetic */ c(ClientHealthMetricsStore clientHealthMetricsStore) {
        this.f34439a = clientHealthMetricsStore;
    }

    public final Object execute() {
        return this.f34439a.loadClientMetrics();
    }
}
