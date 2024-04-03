package qa;

import com.google.android.gms.tasks.Continuation;
import com.google.android.gms.tasks.Task;
import com.google.firebase.remoteconfig.internal.ConfigFetchHandler;
import java.util.Date;

public final /* synthetic */ class h implements Continuation {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ ConfigFetchHandler f50735a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ Date f50736b;

    public /* synthetic */ h(ConfigFetchHandler configFetchHandler, Date date) {
        this.f50735a = configFetchHandler;
        this.f50736b = date;
    }

    public final Object then(Task task) {
        return this.f50735a.lambda$fetchIfCacheExpiredAndNotThrottled$3(this.f50736b, task);
    }
}
