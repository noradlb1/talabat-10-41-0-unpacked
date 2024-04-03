package io.reactivex.internal.operators.observable;

import io.reactivex.Observable;
import io.reactivex.ObservableSource;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import io.reactivex.exceptions.CompositeException;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.functions.Predicate;
import io.reactivex.internal.disposables.SequentialDisposable;
import java.util.concurrent.atomic.AtomicInteger;

public final class ObservableRetryPredicate<T> extends AbstractObservableWithUpstream<T, T> {

    /* renamed from: c  reason: collision with root package name */
    public final Predicate<? super Throwable> f17576c;

    /* renamed from: d  reason: collision with root package name */
    public final long f17577d;

    public static final class RepeatObserver<T> extends AtomicInteger implements Observer<T> {
        private static final long serialVersionUID = -7098360935104053232L;

        /* renamed from: b  reason: collision with root package name */
        public final Observer<? super T> f17578b;

        /* renamed from: c  reason: collision with root package name */
        public final SequentialDisposable f17579c;

        /* renamed from: d  reason: collision with root package name */
        public final ObservableSource<? extends T> f17580d;

        /* renamed from: e  reason: collision with root package name */
        public final Predicate<? super Throwable> f17581e;

        /* renamed from: f  reason: collision with root package name */
        public long f17582f;

        public RepeatObserver(Observer<? super T> observer, long j11, Predicate<? super Throwable> predicate, SequentialDisposable sequentialDisposable, ObservableSource<? extends T> observableSource) {
            this.f17578b = observer;
            this.f17579c = sequentialDisposable;
            this.f17580d = observableSource;
            this.f17581e = predicate;
            this.f17582f = j11;
        }

        public void a() {
            if (getAndIncrement() == 0) {
                int i11 = 1;
                while (!this.f17579c.isDisposed()) {
                    this.f17580d.subscribe(this);
                    i11 = addAndGet(-i11);
                    if (i11 == 0) {
                        return;
                    }
                }
            }
        }

        public void onComplete() {
            this.f17578b.onComplete();
        }

        public void onError(Throwable th2) {
            long j11 = this.f17582f;
            if (j11 != Long.MAX_VALUE) {
                this.f17582f = j11 - 1;
            }
            if (j11 == 0) {
                this.f17578b.onError(th2);
                return;
            }
            try {
                if (!this.f17581e.test(th2)) {
                    this.f17578b.onError(th2);
                } else {
                    a();
                }
            } catch (Throwable th3) {
                Exceptions.throwIfFatal(th3);
                this.f17578b.onError(new CompositeException(th2, th3));
            }
        }

        public void onNext(T t11) {
            this.f17578b.onNext(t11);
        }

        public void onSubscribe(Disposable disposable) {
            this.f17579c.replace(disposable);
        }
    }

    public ObservableRetryPredicate(Observable<T> observable, long j11, Predicate<? super Throwable> predicate) {
        super(observable);
        this.f17576c = predicate;
        this.f17577d = j11;
    }

    public void subscribeActual(Observer<? super T> observer) {
        SequentialDisposable sequentialDisposable = new SequentialDisposable();
        observer.onSubscribe(sequentialDisposable);
        new RepeatObserver(observer, this.f17577d, this.f17576c, sequentialDisposable, this.f16799b).a();
    }
}
