package qc;

import com.instabug.library.OnUserUUIDReadyCallback;
import com.instabug.library.util.threading.PoolProvider;

public final /* synthetic */ class f implements Runnable {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ OnUserUUIDReadyCallback f50752b;

    public /* synthetic */ f(OnUserUUIDReadyCallback onUserUUIDReadyCallback) {
        this.f50752b = onUserUUIDReadyCallback;
    }

    public final void run() {
        PoolProvider.postMainThreadTask(new a(this.f50752b, com.instabug.library.user.f.k()));
    }
}
