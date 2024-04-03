package io.reactivex.rxjava3.internal.operators.completable;

import io.reactivex.rxjava3.core.Completable;
import io.reactivex.rxjava3.core.CompletableObserver;
import io.reactivex.rxjava3.core.CompletableSource;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.exceptions.CompositeException;
import io.reactivex.rxjava3.exceptions.Exceptions;
import io.reactivex.rxjava3.functions.Consumer;

public final class CompletableDoOnEvent extends Completable {

    /* renamed from: b  reason: collision with root package name */
    public final CompletableSource f19139b;

    /* renamed from: c  reason: collision with root package name */
    public final Consumer<? super Throwable> f19140c;

    public final class DoOnEvent implements CompletableObserver {
        private final CompletableObserver observer;

        public DoOnEvent(CompletableObserver completableObserver) {
            this.observer = completableObserver;
        }

        public void onComplete() {
            try {
                CompletableDoOnEvent.this.f19140c.accept(null);
                this.observer.onComplete();
            } catch (Throwable th2) {
                Exceptions.throwIfFatal(th2);
                this.observer.onError(th2);
            }
        }

        public void onError(Throwable th2) {
            try {
                CompletableDoOnEvent.this.f19140c.accept(th2);
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
        this.f19139b = completableSource;
        this.f19140c = consumer;
    }

    public void subscribeActual(CompletableObserver completableObserver) {
        this.f19139b.subscribe(new DoOnEvent(completableObserver));
    }
}
