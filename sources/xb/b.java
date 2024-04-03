package xb;

import com.instabug.bug.di.a;
import com.instabug.library.OnUsageExceededReady;
import com.instabug.library.apichecker.VoidRunnable;
import com.instabug.library.util.threading.PoolProvider;

public final /* synthetic */ class b implements VoidRunnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ OnUsageExceededReady f47262a;

    public /* synthetic */ b(OnUsageExceededReady onUsageExceededReady) {
        this.f47262a = onUsageExceededReady;
    }

    public final void run() {
        PoolProvider.postMainThreadTaskWithoutCheck(new d(this.f47262a, a.e().b()));
    }
}
