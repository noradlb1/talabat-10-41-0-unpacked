package y9;

import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.database.connection.PersistentConnectionImpl;

public final /* synthetic */ class b implements OnSuccessListener {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ PersistentConnectionImpl f50799a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ long f50800b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ Task f50801c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ Task f50802d;

    public /* synthetic */ b(PersistentConnectionImpl persistentConnectionImpl, long j11, Task task, Task task2) {
        this.f50799a = persistentConnectionImpl;
        this.f50800b = j11;
        this.f50801c = task;
        this.f50802d = task2;
    }

    public final void onSuccess(Object obj) {
        this.f50799a.lambda$tryScheduleReconnect$1(this.f50800b, this.f50801c, this.f50802d, (Void) obj);
    }
}
