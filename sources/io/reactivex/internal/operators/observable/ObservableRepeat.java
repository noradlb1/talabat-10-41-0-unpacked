package io.reactivex.internal.operators.observable;

import io.reactivex.Observable;
import io.reactivex.ObservableSource;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import io.reactivex.internal.disposables.SequentialDisposable;
import java.util.concurrent.atomic.AtomicInteger;

public final class ObservableRepeat<T> extends AbstractObservableWithUpstream<T, T> {

    /* renamed from: c  reason: collision with root package name */
    public final long f17525c;

    public static final class RepeatObserver<T> extends AtomicInteger implements Observer<T> {
        private static final long serialVersionUID = -7098360935104053232L;

        /* renamed from: b  reason: collision with root package name */
        public final Observer<? super T> f17526b;

        /* renamed from: c  reason: collision with root package name */
        public final SequentialDisposable f17527c;

        /* renamed from: d  reason: collision with root package name */
        public final ObservableSource<? extends T> f17528d;

        /* renamed from: e  reason: collision with root package name */
        public long f17529e;

        public RepeatObserver(Observer<? super T> observer, long j11, SequentialDisposable sequentialDisposable, ObservableSource<? extends T> observableSource) {
            this.f17526b = observer;
            this.f17527c = sequentialDisposable;
            this.f17528d = observableSource;
            this.f17529e = j11;
        }

        public void a() {
            if (getAndIncrement() == 0) {
                int i11 = 1;
                while (!this.f17527c.isDisposed()) {
                    this.f17528d.subscribe(this);
                    i11 = addAndGet(-i11);
                    if (i11 == 0) {
                        return;
                    }
                }
            }
        }

        public void onComplete() {
            long j11 = this.f17529e;
            if (j11 != Long.MAX_VALUE) {
                this.f17529e = j11 - 1;
            }
            if (j11 != 0) {
                a();
            } else {
                this.f17526b.onComplete();
            }
        }

        public void onError(Throwable th2) {
            this.f17526b.onError(th2);
        }

        public void onNext(T t11) {
            this.f17526b.onNext(t11);
        }

        public void onSubscribe(Disposable disposable) {
            this.f17527c.replace(disposable);
        }
    }

    public ObservableRepeat(Observable<T> observable, long j11) {
        super(observable);
        this.f17525c = j11;
    }

    public void subscribeActual(Observer<? super T> observer) {
        SequentialDisposable sequentialDisposable = new SequentialDisposable();
        observer.onSubscribe(sequentialDisposable);
        long j11 = this.f17525c;
        long j12 = Long.MAX_VALUE;
        if (j11 != Long.MAX_VALUE) {
            j12 = j11 - 1;
        }
        new RepeatObserver(observer, j12, sequentialDisposable, this.f16799b).a();
    }
}
