package io.reactivex.rxjava3.internal.operators.observable;

import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.core.ObservableSource;
import io.reactivex.rxjava3.core.Observer;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.exceptions.CompositeException;
import io.reactivex.rxjava3.exceptions.Exceptions;
import io.reactivex.rxjava3.functions.BiPredicate;
import io.reactivex.rxjava3.internal.disposables.SequentialDisposable;
import java.util.concurrent.atomic.AtomicInteger;

public final class ObservableRetryBiPredicate<T> extends AbstractObservableWithUpstream<T, T> {

    /* renamed from: c  reason: collision with root package name */
    public final BiPredicate<? super Integer, ? super Throwable> f22113c;

    public static final class RetryBiObserver<T> extends AtomicInteger implements Observer<T> {
        private static final long serialVersionUID = -7098360935104053232L;

        /* renamed from: b  reason: collision with root package name */
        public final Observer<? super T> f22114b;

        /* renamed from: c  reason: collision with root package name */
        public final SequentialDisposable f22115c;

        /* renamed from: d  reason: collision with root package name */
        public final ObservableSource<? extends T> f22116d;

        /* renamed from: e  reason: collision with root package name */
        public final BiPredicate<? super Integer, ? super Throwable> f22117e;

        /* renamed from: f  reason: collision with root package name */
        public int f22118f;

        public RetryBiObserver(Observer<? super T> observer, BiPredicate<? super Integer, ? super Throwable> biPredicate, SequentialDisposable sequentialDisposable, ObservableSource<? extends T> observableSource) {
            this.f22114b = observer;
            this.f22115c = sequentialDisposable;
            this.f22116d = observableSource;
            this.f22117e = biPredicate;
        }

        public void a() {
            if (getAndIncrement() == 0) {
                int i11 = 1;
                while (!this.f22115c.isDisposed()) {
                    this.f22116d.subscribe(this);
                    i11 = addAndGet(-i11);
                    if (i11 == 0) {
                        return;
                    }
                }
            }
        }

        public void onComplete() {
            this.f22114b.onComplete();
        }

        public void onError(Throwable th2) {
            try {
                BiPredicate<? super Integer, ? super Throwable> biPredicate = this.f22117e;
                int i11 = this.f22118f + 1;
                this.f22118f = i11;
                if (!biPredicate.test(Integer.valueOf(i11), th2)) {
                    this.f22114b.onError(th2);
                } else {
                    a();
                }
            } catch (Throwable th3) {
                Exceptions.throwIfFatal(th3);
                this.f22114b.onError(new CompositeException(th2, th3));
            }
        }

        public void onNext(T t11) {
            this.f22114b.onNext(t11);
        }

        public void onSubscribe(Disposable disposable) {
            this.f22115c.replace(disposable);
        }
    }

    public ObservableRetryBiPredicate(Observable<T> observable, BiPredicate<? super Integer, ? super Throwable> biPredicate) {
        super(observable);
        this.f22113c = biPredicate;
    }

    public void subscribeActual(Observer<? super T> observer) {
        SequentialDisposable sequentialDisposable = new SequentialDisposable();
        observer.onSubscribe(sequentialDisposable);
        new RetryBiObserver(observer, this.f22113c, sequentialDisposable, this.f21304b).a();
    }
}
