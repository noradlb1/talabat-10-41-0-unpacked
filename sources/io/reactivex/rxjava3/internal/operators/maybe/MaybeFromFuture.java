package io.reactivex.rxjava3.internal.operators.maybe;

import io.reactivex.rxjava3.core.Maybe;
import io.reactivex.rxjava3.core.MaybeObserver;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.disposables.a;
import io.reactivex.rxjava3.exceptions.Exceptions;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

public final class MaybeFromFuture<T> extends Maybe<T> {

    /* renamed from: b  reason: collision with root package name */
    public final Future<? extends T> f20943b;

    /* renamed from: c  reason: collision with root package name */
    public final long f20944c;

    /* renamed from: d  reason: collision with root package name */
    public final TimeUnit f20945d;

    public MaybeFromFuture(Future<? extends T> future, long j11, TimeUnit timeUnit) {
        this.f20943b = future;
        this.f20944c = j11;
        this.f20945d = timeUnit;
    }

    public void subscribeActual(MaybeObserver<? super T> maybeObserver) {
        Object obj;
        Disposable b11 = a.b();
        maybeObserver.onSubscribe(b11);
        if (!b11.isDisposed()) {
            try {
                long j11 = this.f20944c;
                if (j11 <= 0) {
                    obj = this.f20943b.get();
                } else {
                    obj = this.f20943b.get(j11, this.f20945d);
                }
                if (b11.isDisposed()) {
                    return;
                }
                if (obj == null) {
                    maybeObserver.onComplete();
                } else {
                    maybeObserver.onSuccess(obj);
                }
            } catch (Throwable th2) {
                th = th2;
                Exceptions.throwIfFatal(th);
                if (th instanceof ExecutionException) {
                    th = th.getCause();
                }
                Exceptions.throwIfFatal(th);
                if (!b11.isDisposed()) {
                    maybeObserver.onError(th);
                }
            }
        }
    }
}
