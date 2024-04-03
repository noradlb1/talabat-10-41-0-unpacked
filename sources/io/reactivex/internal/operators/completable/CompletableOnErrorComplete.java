package io.reactivex.internal.operators.completable;

import io.reactivex.Completable;
import io.reactivex.CompletableObserver;
import io.reactivex.CompletableSource;
import io.reactivex.disposables.Disposable;
import io.reactivex.exceptions.CompositeException;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.functions.Predicate;

public final class CompletableOnErrorComplete extends Completable {

    /* renamed from: b  reason: collision with root package name */
    public final CompletableSource f14705b;

    /* renamed from: c  reason: collision with root package name */
    public final Predicate<? super Throwable> f14706c;

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
                if (CompletableOnErrorComplete.this.f14706c.test(th2)) {
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
        this.f14705b = completableSource;
        this.f14706c = predicate;
    }

    public void subscribeActual(CompletableObserver completableObserver) {
        this.f14705b.subscribe(new OnError(completableObserver));
    }
}
