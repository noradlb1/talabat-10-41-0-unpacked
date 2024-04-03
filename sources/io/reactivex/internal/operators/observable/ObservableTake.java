package io.reactivex.internal.operators.observable;

import io.reactivex.ObservableSource;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.disposables.EmptyDisposable;
import io.reactivex.plugins.RxJavaPlugins;

public final class ObservableTake<T> extends AbstractObservableWithUpstream<T, T> {

    /* renamed from: c  reason: collision with root package name */
    public final long f17745c;

    public static final class TakeObserver<T> implements Observer<T>, Disposable {

        /* renamed from: b  reason: collision with root package name */
        public final Observer<? super T> f17746b;

        /* renamed from: c  reason: collision with root package name */
        public boolean f17747c;

        /* renamed from: d  reason: collision with root package name */
        public Disposable f17748d;

        /* renamed from: e  reason: collision with root package name */
        public long f17749e;

        public TakeObserver(Observer<? super T> observer, long j11) {
            this.f17746b = observer;
            this.f17749e = j11;
        }

        public void dispose() {
            this.f17748d.dispose();
        }

        public boolean isDisposed() {
            return this.f17748d.isDisposed();
        }

        public void onComplete() {
            if (!this.f17747c) {
                this.f17747c = true;
                this.f17748d.dispose();
                this.f17746b.onComplete();
            }
        }

        public void onError(Throwable th2) {
            if (this.f17747c) {
                RxJavaPlugins.onError(th2);
                return;
            }
            this.f17747c = true;
            this.f17748d.dispose();
            this.f17746b.onError(th2);
        }

        public void onNext(T t11) {
            boolean z11;
            if (!this.f17747c) {
                long j11 = this.f17749e;
                long j12 = j11 - 1;
                this.f17749e = j12;
                if (j11 > 0) {
                    if (j12 == 0) {
                        z11 = true;
                    } else {
                        z11 = false;
                    }
                    this.f17746b.onNext(t11);
                    if (z11) {
                        onComplete();
                    }
                }
            }
        }

        public void onSubscribe(Disposable disposable) {
            if (DisposableHelper.validate(this.f17748d, disposable)) {
                this.f17748d = disposable;
                if (this.f17749e == 0) {
                    this.f17747c = true;
                    disposable.dispose();
                    EmptyDisposable.complete((Observer<?>) this.f17746b);
                    return;
                }
                this.f17746b.onSubscribe(this);
            }
        }
    }

    public ObservableTake(ObservableSource<T> observableSource, long j11) {
        super(observableSource);
        this.f17745c = j11;
    }

    public void subscribeActual(Observer<? super T> observer) {
        this.f16799b.subscribe(new TakeObserver(observer, this.f17745c));
    }
}
