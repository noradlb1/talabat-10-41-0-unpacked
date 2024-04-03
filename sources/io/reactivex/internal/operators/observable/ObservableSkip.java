package io.reactivex.internal.operators.observable;

import io.reactivex.ObservableSource;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import io.reactivex.internal.disposables.DisposableHelper;

public final class ObservableSkip<T> extends AbstractObservableWithUpstream<T, T> {

    /* renamed from: c  reason: collision with root package name */
    public final long f17678c;

    public static final class SkipObserver<T> implements Observer<T>, Disposable {

        /* renamed from: b  reason: collision with root package name */
        public final Observer<? super T> f17679b;

        /* renamed from: c  reason: collision with root package name */
        public long f17680c;

        /* renamed from: d  reason: collision with root package name */
        public Disposable f17681d;

        public SkipObserver(Observer<? super T> observer, long j11) {
            this.f17679b = observer;
            this.f17680c = j11;
        }

        public void dispose() {
            this.f17681d.dispose();
        }

        public boolean isDisposed() {
            return this.f17681d.isDisposed();
        }

        public void onComplete() {
            this.f17679b.onComplete();
        }

        public void onError(Throwable th2) {
            this.f17679b.onError(th2);
        }

        public void onNext(T t11) {
            long j11 = this.f17680c;
            if (j11 != 0) {
                this.f17680c = j11 - 1;
            } else {
                this.f17679b.onNext(t11);
            }
        }

        public void onSubscribe(Disposable disposable) {
            if (DisposableHelper.validate(this.f17681d, disposable)) {
                this.f17681d = disposable;
                this.f17679b.onSubscribe(this);
            }
        }
    }

    public ObservableSkip(ObservableSource<T> observableSource, long j11) {
        super(observableSource);
        this.f17678c = j11;
    }

    public void subscribeActual(Observer<? super T> observer) {
        this.f16799b.subscribe(new SkipObserver(observer, this.f17678c));
    }
}
