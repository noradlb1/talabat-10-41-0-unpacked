package io.reactivex.internal.operators.observable;

import io.reactivex.Observable;
import io.reactivex.ObservableSource;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import io.reactivex.exceptions.CompositeException;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.functions.BiPredicate;
import io.reactivex.internal.disposables.SequentialDisposable;
import java.util.concurrent.atomic.AtomicInteger;

public final class ObservableRetryBiPredicate<T> extends AbstractObservableWithUpstream<T, T> {

    /* renamed from: c  reason: collision with root package name */
    public final BiPredicate<? super Integer, ? super Throwable> f17570c;

    public static final class RetryBiObserver<T> extends AtomicInteger implements Observer<T> {
        private static final long serialVersionUID = -7098360935104053232L;

        /* renamed from: b  reason: collision with root package name */
        public final Observer<? super T> f17571b;

        /* renamed from: c  reason: collision with root package name */
        public final SequentialDisposable f17572c;

        /* renamed from: d  reason: collision with root package name */
        public final ObservableSource<? extends T> f17573d;

        /* renamed from: e  reason: collision with root package name */
        public final BiPredicate<? super Integer, ? super Throwable> f17574e;

        /* renamed from: f  reason: collision with root package name */
        public int f17575f;

        public RetryBiObserver(Observer<? super T> observer, BiPredicate<? super Integer, ? super Throwable> biPredicate, SequentialDisposable sequentialDisposable, ObservableSource<? extends T> observableSource) {
            this.f17571b = observer;
            this.f17572c = sequentialDisposable;
            this.f17573d = observableSource;
            this.f17574e = biPredicate;
        }

        public void a() {
            if (getAndIncrement() == 0) {
                int i11 = 1;
                while (!this.f17572c.isDisposed()) {
                    this.f17573d.subscribe(this);
                    i11 = addAndGet(-i11);
                    if (i11 == 0) {
                        return;
                    }
                }
            }
        }

        public void onComplete() {
            this.f17571b.onComplete();
        }

        public void onError(Throwable th2) {
            try {
                BiPredicate<? super Integer, ? super Throwable> biPredicate = this.f17574e;
                int i11 = this.f17575f + 1;
                this.f17575f = i11;
                if (!biPredicate.test(Integer.valueOf(i11), th2)) {
                    this.f17571b.onError(th2);
                } else {
                    a();
                }
            } catch (Throwable th3) {
                Exceptions.throwIfFatal(th3);
                this.f17571b.onError(new CompositeException(th2, th3));
            }
        }

        public void onNext(T t11) {
            this.f17571b.onNext(t11);
        }

        public void onSubscribe(Disposable disposable) {
            this.f17572c.replace(disposable);
        }
    }

    public ObservableRetryBiPredicate(Observable<T> observable, BiPredicate<? super Integer, ? super Throwable> biPredicate) {
        super(observable);
        this.f17570c = biPredicate;
    }

    public void subscribeActual(Observer<? super T> observer) {
        SequentialDisposable sequentialDisposable = new SequentialDisposable();
        observer.onSubscribe(sequentialDisposable);
        new RetryBiObserver(observer, this.f17570c, sequentialDisposable, this.f16799b).a();
    }
}
