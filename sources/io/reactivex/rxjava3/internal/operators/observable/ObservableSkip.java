package io.reactivex.rxjava3.internal.operators.observable;

import io.reactivex.rxjava3.core.ObservableSource;
import io.reactivex.rxjava3.core.Observer;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.internal.disposables.DisposableHelper;

public final class ObservableSkip<T> extends AbstractObservableWithUpstream<T, T> {

    /* renamed from: c  reason: collision with root package name */
    public final long f22221c;

    public static final class SkipObserver<T> implements Observer<T>, Disposable {

        /* renamed from: b  reason: collision with root package name */
        public final Observer<? super T> f22222b;

        /* renamed from: c  reason: collision with root package name */
        public long f22223c;

        /* renamed from: d  reason: collision with root package name */
        public Disposable f22224d;

        public SkipObserver(Observer<? super T> observer, long j11) {
            this.f22222b = observer;
            this.f22223c = j11;
        }

        public void dispose() {
            this.f22224d.dispose();
        }

        public boolean isDisposed() {
            return this.f22224d.isDisposed();
        }

        public void onComplete() {
            this.f22222b.onComplete();
        }

        public void onError(Throwable th2) {
            this.f22222b.onError(th2);
        }

        public void onNext(T t11) {
            long j11 = this.f22223c;
            if (j11 != 0) {
                this.f22223c = j11 - 1;
            } else {
                this.f22222b.onNext(t11);
            }
        }

        public void onSubscribe(Disposable disposable) {
            if (DisposableHelper.validate(this.f22224d, disposable)) {
                this.f22224d = disposable;
                this.f22222b.onSubscribe(this);
            }
        }
    }

    public ObservableSkip(ObservableSource<T> observableSource, long j11) {
        super(observableSource);
        this.f22221c = j11;
    }

    public void subscribeActual(Observer<? super T> observer) {
        this.f21304b.subscribe(new SkipObserver(observer, this.f22221c));
    }
}
