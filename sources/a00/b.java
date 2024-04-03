package a00;

import com.google.common.util.concurrent.SettableFuture;
import io.flutter.plugins.googlesignin.BackgroundTaskRunner;
import java.util.concurrent.Callable;

public final /* synthetic */ class b implements Runnable {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ SettableFuture f11637b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ Callable f11638c;

    public /* synthetic */ b(SettableFuture settableFuture, Callable callable) {
        this.f11637b = settableFuture;
        this.f11638c = callable;
    }

    public final void run() {
        BackgroundTaskRunner.lambda$runInBackground$1(this.f11637b, this.f11638c);
    }
}
