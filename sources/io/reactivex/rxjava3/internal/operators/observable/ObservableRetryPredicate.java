package io.reactivex.rxjava3.internal.operators.observable;

import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.core.ObservableSource;
import io.reactivex.rxjava3.core.Observer;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.exceptions.CompositeException;
import io.reactivex.rxjava3.exceptions.Exceptions;
import io.reactivex.rxjava3.functions.Predicate;
import io.reactivex.rxjava3.internal.disposables.SequentialDisposable;
import java.util.concurrent.atomic.AtomicInteger;

public final class ObservableRetryPredicate<T> extends AbstractObservableWithUpstream<T, T> {

    /* renamed from: c  reason: collision with root package name */
    public final Predicate<? super Throwable> f22119c;

    /* renamed from: d  reason: collision with root package name */
    public final long f22120d;

    public static final class RepeatObserver<T> extends AtomicInteger implements Observer<T> {
        private static final long serialVersionUID = -7098360935104053232L;

        /* renamed from: b  reason: collision with root package name */
        public final Observer<? super T> f22121b;

        /* renamed from: c  reason: collision with root package name */
        public final SequentialDisposable f22122c;

        /* renamed from: d  reason: collision with root package name */
        public final ObservableSource<? extends T> f22123d;

        /* renamed from: e  reason: collision with root package name */
        public final Predicate<? super Throwable> f22124e;

        /* renamed from: f  reason: collision with root package name */
        public long f22125f;

        public RepeatObserver(Observer<? super T> observer, long j11, Predicate<? super Throwable> predicate, SequentialDisposable sequentialDisposable, ObservableSource<? extends T> observableSource) {
            this.f22121b = observer;
            this.f22122c = sequentialDisposable;
            this.f22123d = observableSource;
            this.f22124e = predicate;
            this.f22125f = j11;
        }

        public void a() {
            if (getAndIncrement() == 0) {
                int i11 = 1;
                while (!this.f22122c.isDisposed()) {
                    this.f22123d.subscribe(this);
                    i11 = addAndGet(-i11);
                    if (i11 == 0) {
                        return;
                    }
                }
            }
        }

        public void onComplete() {
            this.f22121b.onComplete();
        }

        public void onError(Throwable th2) {
            long j11 = this.f22125f;
            if (j11 != Long.MAX_VALUE) {
                this.f22125f = j11 - 1;
            }
            if (j11 == 0) {
                this.f22121b.onError(th2);
                return;
            }
            try {
                if (!this.f22124e.test(th2)) {
                    this.f22121b.onError(th2);
                } else {
                    a();
                }
            } catch (Throwable th3) {
                Exceptions.throwIfFatal(th3);
                this.f22121b.onError(new CompositeException(th2, th3));
            }
        }

        public void onNext(T t11) {
            this.f22121b.onNext(t11);
        }

        public void onSubscribe(Disposable disposable) {
            this.f22122c.replace(disposable);
        }
    }

    public ObservableRetryPredicate(Observable<T> observable, long j11, Predicate<? super Throwable> predicate) {
        super(observable);
        this.f22119c = predicate;
        this.f22120d = j11;
    }

    public void subscribeActual(Observer<? super T> observer) {
        SequentialDisposable sequentialDisposable = new SequentialDisposable();
        observer.onSubscribe(sequentialDisposable);
        new RepeatObserver(observer, this.f22120d, this.f22119c, sequentialDisposable, this.f21304b).a();
    }
}
