package y9;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.firebase.database.connection.PersistentConnectionImpl;

public final /* synthetic */ class c implements OnFailureListener {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ PersistentConnectionImpl f50803a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ long f50804b;

    public /* synthetic */ c(PersistentConnectionImpl persistentConnectionImpl, long j11) {
        this.f50803a = persistentConnectionImpl;
        this.f50804b = j11;
    }

    public final void onFailure(Exception exc) {
        this.f50803a.lambda$tryScheduleReconnect$2(this.f50804b, exc);
    }
}
