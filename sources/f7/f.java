package f7;

import com.google.android.datatransport.runtime.scheduling.persistence.EventStore;
import com.google.android.datatransport.runtime.synchronization.SynchronizationGuard;

public final /* synthetic */ class f implements SynchronizationGuard.CriticalSection {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ EventStore f34447a;

    public /* synthetic */ f(EventStore eventStore) {
        this.f34447a = eventStore;
    }

    public final Object execute() {
        return Integer.valueOf(this.f34447a.cleanUp());
    }
}
