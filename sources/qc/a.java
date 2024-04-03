package qc;

import com.instabug.library.OnUserUUIDReadyCallback;

public final /* synthetic */ class a implements Runnable {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ OnUserUUIDReadyCallback f50747b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ String f50748c;

    public /* synthetic */ a(OnUserUUIDReadyCallback onUserUUIDReadyCallback, String str) {
        this.f50747b = onUserUUIDReadyCallback;
        this.f50748c = str;
    }

    public final void run() {
        this.f50747b.onUserUUIDReady(this.f50748c);
    }
}
