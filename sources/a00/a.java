package a00;

import com.google.common.util.concurrent.ListenableFuture;
import io.flutter.plugins.googlesignin.BackgroundTaskRunner;

public final /* synthetic */ class a implements Runnable {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ BackgroundTaskRunner.Callback f11635b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ ListenableFuture f11636c;

    public /* synthetic */ a(BackgroundTaskRunner.Callback callback, ListenableFuture listenableFuture) {
        this.f11635b = callback;
        this.f11636c = listenableFuture;
    }

    public final void run() {
        this.f11635b.run(this.f11636c);
    }
}
