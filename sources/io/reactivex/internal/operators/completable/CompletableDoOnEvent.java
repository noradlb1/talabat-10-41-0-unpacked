package io.reactivex.internal.operators.completable;

import io.reactivex.Completable;
import io.reactivex.CompletableObserver;
import io.reactivex.CompletableSource;
import io.reactivex.disposables.Disposable;
import io.reactivex.exceptions.CompositeException;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.functions.Consumer;

public final class CompletableDoOnEvent extends Completable {

    /* renamed from: b  reason: collision with root package name */
    public final CompletableSource f14654b;

    /* renamed from: c  reason: collision with root package name */
    public final Consumer<? super Throwable> f14655c;

    public final class DoOnEvent implements CompletableObserver {
        private final CompletableObserver observer;

        public DoOnEvent(CompletableObserver completableObserver) {
            this.observer = completableObserver;
        }

        public void onComplete() {
            try {
                CompletableDoOnEvent.this.f14655c.accept(null);
                this.observer.onComplete();
            } catch (Throwable th2) {
                Exceptions.throwIfFatal(th2);
                this.observer.onError(th2);
            }
        }

        public void onError(Throwable th2) {
            try {
                CompletableDoOnEvent.this.f14655c.accept(th2);
            } catch (Throwable th3) {
                Exceptions.throwIfFatal(th3);
                th2 = new CompositeException(th2, th3);
            }
            this.observer.onError(th2);
        }

        public void onSubscribe(Disposable disposable) {
            this.observer.onSubscribe(disposable);
        }
    }

    public CompletableDoOnEvent(CompletableSource completableSource, Consumer<? super Throwable> consumer) {
        this.f14654b = completableSource;
        this.f14655c = consumer;
    }

    public void subscribeActual(CompletableObserver completableObserver) {
        this.f14654b.subscribe(new DoOnEvent(completableObserver));
    }
}
