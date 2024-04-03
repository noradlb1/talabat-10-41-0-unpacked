package io.reactivex.rxjava3.internal.operators.completable;

import io.reactivex.rxjava3.core.Completable;
import io.reactivex.rxjava3.core.CompletableObserver;
import io.reactivex.rxjava3.core.CompletableSource;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.exceptions.CompositeException;
import io.reactivex.rxjava3.exceptions.Exceptions;
import io.reactivex.rxjava3.functions.Predicate;

public final class CompletableOnErrorComplete extends Completable {

    /* renamed from: b  reason: collision with root package name */
    public final CompletableSource f19192b;

    /* renamed from: c  reason: collision with root package name */
    public final Predicate<? super Throwable> f19193c;

    public final class OnError implements CompletableObserver {
        private final CompletableObserver downstream;

        public OnError(CompletableObserver completableObserver) {
            this.downstream = completableObserver;
        }

        public void onComplete() {
            this.downstream.onComplete();
        }

        public void onError(Throwable th2) {
            try {
                if (CompletableOnErrorComplete.this.f19193c.test(th2)) {
                    this.downstream.onComplete();
                } else {
                    this.downstream.onError(th2);
                }
            } catch (Throwable th3) {
                Exceptions.throwIfFatal(th3);
                this.downstream.onError(new CompositeException(th2, th3));
            }
        }

        public void onSubscribe(Disposable disposable) {
            this.downstream.onSubscribe(disposable);
        }
    }

    public CompletableOnErrorComplete(CompletableSource completableSource, Predicate<? super Throwable> predicate) {
        this.f19192b = completableSource;
        this.f19193c = predicate;
    }

    public void subscribeActual(CompletableObserver completableObserver) {
        this.f19192b.subscribe(new OnError(completableObserver));
    }
}
