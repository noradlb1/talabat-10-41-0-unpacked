package qc;

import com.instabug.library.OnUserUUIDReadyCallback;
import com.instabug.library.apichecker.VoidRunnable;
import com.instabug.library.util.threading.PoolProvider;

public final /* synthetic */ class d implements VoidRunnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ OnUserUUIDReadyCallback f50750a;

    public /* synthetic */ d(OnUserUUIDReadyCallback onUserUUIDReadyCallback) {
        this.f50750a = onUserUUIDReadyCallback;
    }

    public final void run() {
        PoolProvider.postIOTask(new f(this.f50750a));
    }
}
