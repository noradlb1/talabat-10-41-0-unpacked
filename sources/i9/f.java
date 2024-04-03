package i9;

import com.google.common.util.concurrent.AsyncCallable;
import com.google.common.util.concurrent.ListenableFuture;
import com.google.common.util.concurrent.ListeningExecutorService;
import java.util.concurrent.Callable;

public final /* synthetic */ class f implements AsyncCallable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ ListeningExecutorService f47116a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ Callable f47117b;

    public /* synthetic */ f(ListeningExecutorService listeningExecutorService, Callable callable) {
        this.f47116a = listeningExecutorService;
        this.f47117b = callable;
    }

    public final ListenableFuture call() {
        return this.f47116a.submit(this.f47117b);
    }
}
