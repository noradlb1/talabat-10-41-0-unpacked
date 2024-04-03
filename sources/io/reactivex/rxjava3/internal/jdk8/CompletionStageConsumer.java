package io.reactivex.rxjava3.internal.jdk8;

import io.reactivex.rxjava3.annotations.NonNull;
import io.reactivex.rxjava3.core.CompletableObserver;
import io.reactivex.rxjava3.core.MaybeObserver;
import io.reactivex.rxjava3.core.SingleObserver;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.internal.disposables.DisposableHelper;
import io.reactivex.rxjava3.plugins.RxJavaPlugins;
import java.util.NoSuchElementException;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.atomic.AtomicReference;

public final class CompletionStageConsumer<T> extends CompletableFuture<T> implements MaybeObserver<T>, SingleObserver<T>, CompletableObserver {

    /* renamed from: b  reason: collision with root package name */
    public final AtomicReference<Disposable> f18821b = new AtomicReference<>();

    /* renamed from: c  reason: collision with root package name */
    public final boolean f18822c;

    /* renamed from: d  reason: collision with root package name */
    public final T f18823d;

    public CompletionStageConsumer(boolean z11, T t11) {
        this.f18822c = z11;
        this.f18823d = t11;
    }

    public void a() {
        DisposableHelper.dispose(this.f18821b);
    }

    public void b() {
        this.f18821b.lazySet(DisposableHelper.DISPOSED);
    }

    public boolean cancel(boolean z11) {
        a();
        return super.cancel(z11);
    }

    public boolean complete(T t11) {
        a();
        return super.complete(t11);
    }

    public boolean completeExceptionally(Throwable th2) {
        a();
        return super.completeExceptionally(th2);
    }

    public void onComplete() {
        if (this.f18822c) {
            complete(this.f18823d);
        } else {
            completeExceptionally(new NoSuchElementException("The source was empty"));
        }
    }

    public void onError(Throwable th2) {
        b();
        if (!completeExceptionally(th2)) {
            RxJavaPlugins.onError(th2);
        }
    }

    public void onSubscribe(@NonNull Disposable disposable) {
        DisposableHelper.setOnce(this.f18821b, disposable);
    }

    public void onSuccess(@NonNull T t11) {
        b();
        complete(t11);
    }
}
