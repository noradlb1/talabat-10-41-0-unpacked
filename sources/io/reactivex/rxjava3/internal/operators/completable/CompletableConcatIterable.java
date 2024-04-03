package io.reactivex.rxjava3.internal.operators.completable;

import io.reactivex.rxjava3.core.Completable;
import io.reactivex.rxjava3.core.CompletableObserver;
import io.reactivex.rxjava3.core.CompletableSource;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.exceptions.Exceptions;
import io.reactivex.rxjava3.internal.disposables.EmptyDisposable;
import io.reactivex.rxjava3.internal.disposables.SequentialDisposable;
import java.util.Iterator;
import java.util.Objects;
import java.util.concurrent.atomic.AtomicInteger;

public final class CompletableConcatIterable extends Completable {

    /* renamed from: b  reason: collision with root package name */
    public final Iterable<? extends CompletableSource> f19107b;

    public static final class ConcatInnerObserver extends AtomicInteger implements CompletableObserver {
        private static final long serialVersionUID = -7965400327305809232L;

        /* renamed from: b  reason: collision with root package name */
        public final CompletableObserver f19108b;

        /* renamed from: c  reason: collision with root package name */
        public final Iterator<? extends CompletableSource> f19109c;

        /* renamed from: d  reason: collision with root package name */
        public final SequentialDisposable f19110d = new SequentialDisposable();

        public ConcatInnerObserver(CompletableObserver completableObserver, Iterator<? extends CompletableSource> it) {
            this.f19108b = completableObserver;
            this.f19109c = it;
        }

        public void a() {
            if (!this.f19110d.isDisposed() && getAndIncrement() == 0) {
                Iterator<? extends CompletableSource> it = this.f19109c;
                while (!this.f19110d.isDisposed()) {
                    try {
                        if (!it.hasNext()) {
                            this.f19108b.onComplete();
                            return;
                        }
                        try {
                            Object next = it.next();
                            Objects.requireNonNull(next, "The CompletableSource returned is null");
                            ((CompletableSource) next).subscribe(this);
                            if (decrementAndGet() == 0) {
                                return;
                            }
                        } catch (Throwable th2) {
                            Exceptions.throwIfFatal(th2);
                            this.f19108b.onError(th2);
                            return;
                        }
                    } catch (Throwable th3) {
                        Exceptions.throwIfFatal(th3);
                        this.f19108b.onError(th3);
                        return;
                    }
                }
            }
        }

        public void onComplete() {
            a();
        }

        public void onError(Throwable th2) {
            this.f19108b.onError(th2);
        }

        public void onSubscribe(Disposable disposable) {
            this.f19110d.replace(disposable);
        }
    }

    public CompletableConcatIterable(Iterable<? extends CompletableSource> iterable) {
        this.f19107b = iterable;
    }

    public void subscribeActual(CompletableObserver completableObserver) {
        try {
            Iterator<? extends CompletableSource> it = this.f19107b.iterator();
            Objects.requireNonNull(it, "The iterator returned is null");
            ConcatInnerObserver concatInnerObserver = new ConcatInnerObserver(completableObserver, it);
            completableObserver.onSubscribe(concatInnerObserver.f19110d);
            concatInnerObserver.a();
        } catch (Throwable th2) {
            Exceptions.throwIfFatal(th2);
            EmptyDisposable.error(th2, completableObserver);
        }
    }
}
