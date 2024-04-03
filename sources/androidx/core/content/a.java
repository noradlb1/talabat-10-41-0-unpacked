package androidx.core.content;

public final /* synthetic */ class a implements Runnable {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ UnusedAppRestrictionsBackportServiceConnection f11239b;

    public /* synthetic */ a(UnusedAppRestrictionsBackportServiceConnection unusedAppRestrictionsBackportServiceConnection) {
        this.f11239b = unusedAppRestrictionsBackportServiceConnection;
    }

    public final void run() {
        this.f11239b.disconnectFromService();
    }
}
