package qa;

import com.google.android.gms.tasks.Continuation;
import com.google.android.gms.tasks.Task;
import com.google.firebase.remoteconfig.internal.ConfigFetchHandler;
import java.util.Map;

public final /* synthetic */ class i implements Continuation {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ ConfigFetchHandler f50737a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ Map f50738b;

    public /* synthetic */ i(ConfigFetchHandler configFetchHandler, Map map) {
        this.f50737a = configFetchHandler;
        this.f50738b = map;
    }

    public final Object then(Task task) {
        return this.f50737a.lambda$fetchNowWithTypeAndAttemptNumber$1(this.f50738b, task);
    }
}
