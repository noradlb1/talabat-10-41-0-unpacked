package qa;

import com.google.android.gms.tasks.Continuation;
import com.google.android.gms.tasks.Task;
import com.google.firebase.remoteconfig.internal.ConfigRealtimeHttpClient;

public final /* synthetic */ class k implements Continuation {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ ConfigRealtimeHttpClient f50742a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ Task f50743b;

    public /* synthetic */ k(ConfigRealtimeHttpClient configRealtimeHttpClient, Task task) {
        this.f50742a = configRealtimeHttpClient;
        this.f50743b = task;
    }

    public final Object then(Task task) {
        return this.f50742a.lambda$beginRealtimeHttpStream$1(this.f50743b, task);
    }
}
