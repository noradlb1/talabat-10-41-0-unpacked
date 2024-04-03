package io.reactivex.internal.operators.observable;

import io.reactivex.Maybe;
import io.reactivex.MaybeObserver;
import io.reactivex.Observable;
import io.reactivex.ObservableSource;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.fuseable.FuseToObservable;
import io.reactivex.plugins.RxJavaPlugins;

public final class ObservableElementAtMaybe<T> extends Maybe<T> implements FuseToObservable<T> {

    /* renamed from: b  reason: collision with root package name */
    public final ObservableSource<T> f17157b;

    /* renamed from: c  reason: collision with root package name */
    public final long f17158c;

    public static final class ElementAtObserver<T> implements Observer<T>, Disposable {

        /* renamed from: b  reason: collision with root package name */
        public final MaybeObserver<? super T> f17159b;

        /* renamed from: c  reason: collision with root package name */
        public final long f17160c;

        /* renamed from: d  reason: collision with root package name */
        public Disposable f17161d;

        /* renamed from: e  reason: collision with root package name */
        public long f17162e;

        /* renamed from: f  reason: collision with root package name */
        public boolean f17163f;

        public ElementAtObserver(MaybeObserver<? super T> maybeObserver, long j11) {
            this.f17159b = maybeObserver;
            this.f17160c = j11;
        }

        public void dispose() {
            this.f17161d.dispose();
        }

        public boolean isDisposed() {
            return this.f17161d.isDisposed();
        }

        public void onComplete() {
            if (!this.f17163f) {
                this.f17163f = true;
                this.f17159b.onComplete();
            }
        }

        public void onError(Throwable th2) {
            if (this.f17163f) {
                RxJavaPlugins.onError(th2);
                return;
            }
            this.f17163f = true;
            this.f17159b.onError(th2);
        }

        public void onNext(T t11) {
            if (!this.f17163f) {
                long j11 = this.f17162e;
                if (j11 == this.f17160c) {
                    this.f17163f = true;
                    this.f17161d.dispose();
                    this.f17159b.onSuccess(t11);
                    return;
                }
                this.f17162e = j11 + 1;
            }
        }

        public void onSubscribe(Disposable disposable) {
            if (DisposableHelper.validate(this.f17161d, disposable)) {
                this.f17161d = disposable;
                this.f17159b.onSubscribe(this);
            }
        }
    }

    public ObservableElementAtMaybe(ObservableSource<T> observableSource, long j11) {
        this.f17157b = observableSource;
        this.f17158c = j11;
    }

    public Observable<T> fuseToObservable() {
        return RxJavaPlugins.onAssembly(new ObservableElementAt(this.f17157b, this.f17158c, null, false));
    }

    public void subscribeActual(MaybeObserver<? super T> maybeObserver) {
        this.f17157b.subscribe(new ElementAtObserver(maybeObserver, this.f17158c));
    }
}
