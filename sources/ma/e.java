package ma;

import com.google.firebase.perf.transport.TransportManager;

public final /* synthetic */ class e implements Runnable {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ TransportManager f50675b;

    public /* synthetic */ e(TransportManager transportManager) {
        this.f50675b = transportManager;
    }

    public final void run() {
        this.f50675b.lambda$onUpdateAppState$1();
    }
}
