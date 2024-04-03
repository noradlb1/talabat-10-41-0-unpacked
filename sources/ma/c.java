package ma;

import com.google.firebase.perf.transport.TransportManager;

public final /* synthetic */ class c implements Runnable {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ TransportManager f50671b;

    public /* synthetic */ c(TransportManager transportManager) {
        this.f50671b = transportManager;
    }

    public final void run() {
        this.f50671b.syncInit();
    }
}
