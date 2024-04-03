package io.reactivex.internal.operators.maybe;

import io.reactivex.Maybe;
import io.reactivex.MaybeObserver;
import io.reactivex.disposables.Disposable;
import io.reactivex.disposables.Disposables;
import io.reactivex.exceptions.Exceptions;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

public final class MaybeFromFuture<T> extends Maybe<T> {

    /* renamed from: b  reason: collision with root package name */
    public final Future<? extends T> f16438b;

    /* renamed from: c  reason: collision with root package name */
    public final long f16439c;

    /* renamed from: d  reason: collision with root package name */
    public final TimeUnit f16440d;

    public MaybeFromFuture(Future<? extends T> future, long j11, TimeUnit timeUnit) {
        this.f16438b = future;
        this.f16439c = j11;
        this.f16440d = timeUnit;
    }

    public void subscribeActual(MaybeObserver<? super T> maybeObserver) {
        Object obj;
        Disposable empty = Disposables.empty();
        maybeObserver.onSubscribe(empty);
        if (!empty.isDisposed()) {
            try {
                long j11 = this.f16439c;
                if (j11 <= 0) {
                    obj = this.f16438b.get();
                } else {
                    obj = this.f16438b.get(j11, this.f16440d);
                }
                if (empty.isDisposed()) {
                    return;
                }
                if (obj == null) {
                    maybeObserver.onComplete();
                } else {
                    maybeObserver.onSuccess(obj);
                }
            } catch (Throwable th2) {
                th = th2;
                if (th instanceof ExecutionException) {
                    th = th.getCause();
                }
                Exceptions.throwIfFatal(th);
                if (!empty.isDisposed()) {
                    maybeObserver.onError(th);
                }
            }
        }
    }
}
