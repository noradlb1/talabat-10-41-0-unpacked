package qc;

import com.instabug.library.OnUserUUIDReadyCallback;

public final /* synthetic */ class e implements Runnable {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ OnUserUUIDReadyCallback f50751b;

    public /* synthetic */ e(OnUserUUIDReadyCallback onUserUUIDReadyCallback) {
        this.f50751b = onUserUUIDReadyCallback;
    }

    public final void run() {
        this.f50751b.onUserUUIDReady((String) null);
    }
}
