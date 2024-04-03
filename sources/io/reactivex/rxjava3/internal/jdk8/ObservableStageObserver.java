package io.reactivex.rxjava3.internal.jdk8;

import io.reactivex.rxjava3.annotations.NonNull;
import io.reactivex.rxjava3.core.Observer;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.internal.disposables.DisposableHelper;
import io.reactivex.rxjava3.plugins.RxJavaPlugins;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.atomic.AtomicReference;

abstract class ObservableStageObserver<T> extends CompletableFuture<T> implements Observer<T> {

    /* renamed from: b  reason: collision with root package name */
    public final AtomicReference<Disposable> f18947b = new AtomicReference<>();

    /* renamed from: c  reason: collision with root package name */
    public T f18948c;

    public final void a() {
        this.f18948c = null;
        this.f18947b.lazySet(DisposableHelper.DISPOSED);
    }

    public final void b() {
        DisposableHelper.dispose(this.f18947b);
    }

    public final boolean cancel(boolean z11) {
        b();
        return super.cancel(z11);
    }

    public final boolean complete(T t11) {
        b();
        return super.complete(t11);
    }

    public final boolean completeExceptionally(Throwable th2) {
        b();
        return super.completeExceptionally(th2);
    }

    public final void onError(Throwable th2) {
        a();
        if (!completeExceptionally(th2)) {
            RxJavaPlugins.onError(th2);
        }
    }

    public final void onSubscribe(@NonNull Disposable disposable) {
        DisposableHelper.setOnce(this.f18947b, disposable);
    }
}
