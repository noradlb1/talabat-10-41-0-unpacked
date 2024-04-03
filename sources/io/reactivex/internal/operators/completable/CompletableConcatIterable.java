package io.reactivex.internal.operators.completable;

import io.reactivex.Completable;
import io.reactivex.CompletableObserver;
import io.reactivex.CompletableSource;
import io.reactivex.disposables.Disposable;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.internal.disposables.EmptyDisposable;
import io.reactivex.internal.disposables.SequentialDisposable;
import io.reactivex.internal.functions.ObjectHelper;
import java.util.Iterator;
import java.util.concurrent.atomic.AtomicInteger;

public final class CompletableConcatIterable extends Completable {

    /* renamed from: b  reason: collision with root package name */
    public final Iterable<? extends CompletableSource> f14622b;

    public static final class ConcatInnerObserver extends AtomicInteger implements CompletableObserver {
        private static final long serialVersionUID = -7965400327305809232L;

        /* renamed from: b  reason: collision with root package name */
        public final CompletableObserver f14623b;

        /* renamed from: c  reason: collision with root package name */
        public final Iterator<? extends CompletableSource> f14624c;

        /* renamed from: d  reason: collision with root package name */
        public final SequentialDisposable f14625d = new SequentialDisposable();

        public ConcatInnerObserver(CompletableObserver completableObserver, Iterator<? extends CompletableSource> it) {
            this.f14623b = completableObserver;
            this.f14624c = it;
        }

        public void a() {
            if (!this.f14625d.isDisposed() && getAndIncrement() == 0) {
                Iterator<? extends CompletableSource> it = this.f14624c;
                while (!this.f14625d.isDisposed()) {
                    try {
                        if (!it.hasNext()) {
                            this.f14623b.onComplete();
                            return;
                        }
                        try {
                            ((CompletableSource) ObjectHelper.requireNonNull(it.next(), "The CompletableSource returned is null")).subscribe(this);
                            if (decrementAndGet() == 0) {
                                return;
                            }
                        } catch (Throwable th2) {
                            Exceptions.throwIfFatal(th2);
                            this.f14623b.onError(th2);
                            return;
                        }
                    } catch (Throwable th3) {
                        Exceptions.throwIfFatal(th3);
                        this.f14623b.onError(th3);
                        return;
                    }
                }
            }
        }

        public void onComplete() {
            a();
        }

        public void onError(Throwable th2) {
            this.f14623b.onError(th2);
        }

        public void onSubscribe(Disposable disposable) {
            this.f14625d.replace(disposable);
        }
    }

    public CompletableConcatIterable(Iterable<? extends CompletableSource> iterable) {
        this.f14622b = iterable;
    }

    public void subscribeActual(CompletableObserver completableObserver) {
        try {
            ConcatInnerObserver concatInnerObserver = new ConcatInnerObserver(completableObserver, (Iterator) ObjectHelper.requireNonNull(this.f14622b.iterator(), "The iterator returned is null"));
            completableObserver.onSubscribe(concatInnerObserver.f14625d);
            concatInnerObserver.a();
        } catch (Throwable th2) {
            Exceptions.throwIfFatal(th2);
            EmptyDisposable.error(th2, completableObserver);
        }
    }
}
