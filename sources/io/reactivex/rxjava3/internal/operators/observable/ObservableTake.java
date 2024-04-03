package io.reactivex.rxjava3.internal.operators.observable;

import io.reactivex.rxjava3.core.ObservableSource;
import io.reactivex.rxjava3.core.Observer;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.internal.disposables.DisposableHelper;
import io.reactivex.rxjava3.internal.disposables.EmptyDisposable;
import io.reactivex.rxjava3.plugins.RxJavaPlugins;

public final class ObservableTake<T> extends AbstractObservableWithUpstream<T, T> {

    /* renamed from: c  reason: collision with root package name */
    public final long f22288c;

    public static final class TakeObserver<T> implements Observer<T>, Disposable {

        /* renamed from: b  reason: collision with root package name */
        public final Observer<? super T> f22289b;

        /* renamed from: c  reason: collision with root package name */
        public boolean f22290c;

        /* renamed from: d  reason: collision with root package name */
        public Disposable f22291d;

        /* renamed from: e  reason: collision with root package name */
        public long f22292e;

        public TakeObserver(Observer<? super T> observer, long j11) {
            this.f22289b = observer;
            this.f22292e = j11;
        }

        public void dispose() {
            this.f22291d.dispose();
        }

        public boolean isDisposed() {
            return this.f22291d.isDisposed();
        }

        public void onComplete() {
            if (!this.f22290c) {
                this.f22290c = true;
                this.f22291d.dispose();
                this.f22289b.onComplete();
            }
        }

        public void onError(Throwable th2) {
            if (this.f22290c) {
                RxJavaPlugins.onError(th2);
                return;
            }
            this.f22290c = true;
            this.f22291d.dispose();
            this.f22289b.onError(th2);
        }

        public void onNext(T t11) {
            boolean z11;
            if (!this.f22290c) {
                long j11 = this.f22292e;
                long j12 = j11 - 1;
                this.f22292e = j12;
                if (j11 > 0) {
                    if (j12 == 0) {
                        z11 = true;
                    } else {
                        z11 = false;
                    }
                    this.f22289b.onNext(t11);
                    if (z11) {
                        onComplete();
                    }
                }
            }
        }

        public void onSubscribe(Disposable disposable) {
            if (DisposableHelper.validate(this.f22291d, disposable)) {
                this.f22291d = disposable;
                if (this.f22292e == 0) {
                    this.f22290c = true;
                    disposable.dispose();
                    EmptyDisposable.complete((Observer<?>) this.f22289b);
                    return;
                }
                this.f22289b.onSubscribe(this);
            }
        }
    }

    public ObservableTake(ObservableSource<T> observableSource, long j11) {
        super(observableSource);
        this.f22288c = j11;
    }

    public void subscribeActual(Observer<? super T> observer) {
        this.f21304b.subscribe(new TakeObserver(observer, this.f22288c));
    }
}
