package y9;

import com.google.firebase.database.connection.PersistentConnectionImpl;

public final /* synthetic */ class a implements Runnable {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ PersistentConnectionImpl f50796b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ boolean f50797c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ boolean f50798d;

    public /* synthetic */ a(PersistentConnectionImpl persistentConnectionImpl, boolean z11, boolean z12) {
        this.f50796b = persistentConnectionImpl;
        this.f50797c = z11;
        this.f50798d = z12;
    }

    public final void run() {
        this.f50796b.lambda$tryScheduleReconnect$3(this.f50797c, this.f50798d);
    }
}
