package qa;

import com.google.android.gms.tasks.Continuation;
import com.google.android.gms.tasks.Task;
import com.google.firebase.remoteconfig.internal.ConfigFetchHandler;
import java.util.Map;

public final /* synthetic */ class f implements Continuation {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ ConfigFetchHandler f50727a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ long f50728b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ Map f50729c;

    public /* synthetic */ f(ConfigFetchHandler configFetchHandler, long j11, Map map) {
        this.f50727a = configFetchHandler;
        this.f50728b = j11;
        this.f50729c = map;
    }

    public final Object then(Task task) {
        return this.f50727a.lambda$fetch$0(this.f50728b, this.f50729c, task);
    }
}
