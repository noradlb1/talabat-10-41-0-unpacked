package qd;

import com.instabug.library.apichecker.ReturnableRunnable;
import com.instabug.library.util.threading.ReturnableSingleThreadExecutor;
import java.util.concurrent.Callable;

public final /* synthetic */ class c implements Callable {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ ReturnableRunnable f57188b;

    public /* synthetic */ c(ReturnableRunnable returnableRunnable) {
        this.f57188b = returnableRunnable;
    }

    public final Object call() {
        return ReturnableSingleThreadExecutor.m9389executeAndGet$lambda0(this.f57188b);
    }
}
