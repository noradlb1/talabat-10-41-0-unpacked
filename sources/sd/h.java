package sd;

import com.instabug.library.OnUsageExceededReady;
import com.instabug.library.apichecker.VoidRunnable;
import com.instabug.library.util.threading.PoolProvider;
import com.instabug.survey.di.a;

public final /* synthetic */ class h implements VoidRunnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ OnUsageExceededReady f57386a;

    public /* synthetic */ h(OnUsageExceededReady onUsageExceededReady) {
        this.f57386a = onUsageExceededReady;
    }

    public final void run() {
        PoolProvider.postMainThreadTask(new i(this.f57386a, a.b().d()));
    }
}
