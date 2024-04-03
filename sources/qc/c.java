package qc;

import com.instabug.library.Instabug;
import com.instabug.library.apichecker.VoidRunnable;
import java.util.concurrent.Callable;

public final /* synthetic */ class c implements VoidRunnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ Callable f50749a;

    public /* synthetic */ c(Callable callable) {
        this.f50749a = callable;
    }

    public final void run() {
        Instabug.lambda$setScreenshotProvider$9(this.f50749a);
    }
}
