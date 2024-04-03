package f7;

import com.google.android.datatransport.runtime.scheduling.jobscheduling.Uploader;
import com.google.android.datatransport.runtime.synchronization.SynchronizationGuard;
import java.util.Map;

public final /* synthetic */ class m implements SynchronizationGuard.CriticalSection {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ Uploader f34462a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ Map f34463b;

    public /* synthetic */ m(Uploader uploader, Map map) {
        this.f34462a = uploader;
        this.f34463b = map;
    }

    public final Object execute() {
        return this.f34462a.lambda$logAndUpdateState$7(this.f34463b);
    }
}
