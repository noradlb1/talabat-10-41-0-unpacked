package qa;

import com.google.android.gms.tasks.Continuation;
import com.google.android.gms.tasks.Task;
import com.google.firebase.remoteconfig.internal.ConfigRealtimeHttpClient;

public final /* synthetic */ class l implements Continuation {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ ConfigRealtimeHttpClient f50744a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ Task f50745b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ Task f50746c;

    public /* synthetic */ l(ConfigRealtimeHttpClient configRealtimeHttpClient, Task task, Task task2) {
        this.f50744a = configRealtimeHttpClient;
        this.f50745b = task;
        this.f50746c = task2;
    }

    public final Object then(Task task) {
        return this.f50744a.lambda$createRealtimeConnection$0(this.f50745b, this.f50746c, task);
    }
}
