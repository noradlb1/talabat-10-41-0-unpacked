package qa;

import com.google.android.gms.tasks.Continuation;
import com.google.android.gms.tasks.Task;
import com.google.firebase.remoteconfig.internal.ConfigFetchHandler;
import java.util.Date;
import java.util.Map;

public final /* synthetic */ class g implements Continuation {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ ConfigFetchHandler f50730a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ Task f50731b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ Task f50732c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ Date f50733d;

    /* renamed from: e  reason: collision with root package name */
    public final /* synthetic */ Map f50734e;

    public /* synthetic */ g(ConfigFetchHandler configFetchHandler, Task task, Task task2, Date date, Map map) {
        this.f50730a = configFetchHandler;
        this.f50731b = task;
        this.f50732c = task2;
        this.f50733d = date;
        this.f50734e = map;
    }

    public final Object then(Task task) {
        return this.f50730a.lambda$fetchIfCacheExpiredAndNotThrottled$2(this.f50731b, this.f50732c, this.f50733d, this.f50734e, task);
    }
}
