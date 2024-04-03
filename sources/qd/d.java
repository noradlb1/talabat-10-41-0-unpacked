package qd;

import com.instabug.library.apichecker.ReturnableRunnable;
import com.instabug.library.util.threading.m;
import java.util.concurrent.Callable;

public final /* synthetic */ class d implements Callable {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ ReturnableRunnable f57189b;

    public /* synthetic */ d(ReturnableRunnable returnableRunnable) {
        this.f57189b = returnableRunnable;
    }

    public final Object call() {
        return m.a(this.f57189b);
    }
}
