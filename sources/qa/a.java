package qa;

import com.google.android.gms.tasks.Continuation;
import com.google.android.gms.tasks.Task;
import com.google.firebase.remoteconfig.internal.ConfigAutoFetch;

public final /* synthetic */ class a implements Continuation {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ ConfigAutoFetch f50715a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ Task f50716b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ Task f50717c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ long f50718d;

    /* renamed from: e  reason: collision with root package name */
    public final /* synthetic */ int f50719e;

    public /* synthetic */ a(ConfigAutoFetch configAutoFetch, Task task, Task task2, long j11, int i11) {
        this.f50715a = configAutoFetch;
        this.f50716b = task;
        this.f50717c = task2;
        this.f50718d = j11;
        this.f50719e = i11;
    }

    public final Object then(Task task) {
        return this.f50715a.lambda$fetchLatestConfig$0(this.f50716b, this.f50717c, this.f50718d, this.f50719e, task);
    }
}
