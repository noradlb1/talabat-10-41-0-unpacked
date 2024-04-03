package io.reactivex.rxjava3.internal.operators.observable;

import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.core.ObservableSource;
import io.reactivex.rxjava3.core.Observer;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.internal.disposables.SequentialDisposable;
import java.util.concurrent.atomic.AtomicInteger;

public final class ObservableRepeat<T> extends AbstractObservableWithUpstream<T, T> {

    /* renamed from: c  reason: collision with root package name */
    public final long f22064c;

    public static final class RepeatObserver<T> extends AtomicInteger implements Observer<T> {
        private static final long serialVersionUID = -7098360935104053232L;

        /* renamed from: b  reason: collision with root package name */
        public final Observer<? super T> f22065b;

        /* renamed from: c  reason: collision with root package name */
        public final SequentialDisposable f22066c;

        /* renamed from: d  reason: collision with root package name */
        public final ObservableSource<? extends T> f22067d;

        /* renamed from: e  reason: collision with root package name */
        public long f22068e;

        public RepeatObserver(Observer<? super T> observer, long j11, SequentialDisposable sequentialDisposable, ObservableSource<? extends T> observableSource) {
            this.f22065b = observer;
            this.f22066c = sequentialDisposable;
            this.f22067d = observableSource;
            this.f22068e = j11;
        }

        public void a() {
            if (getAndIncrement() == 0) {
                int i11 = 1;
                while (!this.f22066c.isDisposed()) {
                    this.f22067d.subscribe(this);
                    i11 = addAndGet(-i11);
                    if (i11 == 0) {
                        return;
                    }
                }
            }
        }

        public void onComplete() {
            long j11 = this.f22068e;
            if (j11 != Long.MAX_VALUE) {
                this.f22068e = j11 - 1;
            }
            if (j11 != 0) {
                a();
            } else {
                this.f22065b.onComplete();
            }
        }

        public void onError(Throwable th2) {
            this.f22065b.onError(th2);
        }

        public void onNext(T t11) {
            this.f22065b.onNext(t11);
        }

        public void onSubscribe(Disposable disposable) {
            this.f22066c.replace(disposable);
        }
    }

    public ObservableRepeat(Observable<T> observable, long j11) {
        super(observable);
        this.f22064c = j11;
    }

    public void subscribeActual(Observer<? super T> observer) {
        SequentialDisposable sequentialDisposable = new SequentialDisposable();
        observer.onSubscribe(sequentialDisposable);
        long j11 = this.f22064c;
        long j12 = Long.MAX_VALUE;
        if (j11 != Long.MAX_VALUE) {
            j12 = j11 - 1;
        }
        new RepeatObserver(observer, j12, sequentialDisposable, this.f21304b).a();
    }
}
