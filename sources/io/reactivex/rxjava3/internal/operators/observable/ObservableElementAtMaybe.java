package io.reactivex.rxjava3.internal.operators.observable;

import io.reactivex.rxjava3.core.Maybe;
import io.reactivex.rxjava3.core.MaybeObserver;
import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.core.ObservableSource;
import io.reactivex.rxjava3.core.Observer;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.internal.disposables.DisposableHelper;
import io.reactivex.rxjava3.internal.fuseable.FuseToObservable;
import io.reactivex.rxjava3.plugins.RxJavaPlugins;

public final class ObservableElementAtMaybe<T> extends Maybe<T> implements FuseToObservable<T> {

    /* renamed from: b  reason: collision with root package name */
    public final ObservableSource<T> f21685b;

    /* renamed from: c  reason: collision with root package name */
    public final long f21686c;

    public static final class ElementAtObserver<T> implements Observer<T>, Disposable {

        /* renamed from: b  reason: collision with root package name */
        public final MaybeObserver<? super T> f21687b;

        /* renamed from: c  reason: collision with root package name */
        public final long f21688c;

        /* renamed from: d  reason: collision with root package name */
        public Disposable f21689d;

        /* renamed from: e  reason: collision with root package name */
        public long f21690e;

        /* renamed from: f  reason: collision with root package name */
        public boolean f21691f;

        public ElementAtObserver(MaybeObserver<? super T> maybeObserver, long j11) {
            this.f21687b = maybeObserver;
            this.f21688c = j11;
        }

        public void dispose() {
            this.f21689d.dispose();
        }

        public boolean isDisposed() {
            return this.f21689d.isDisposed();
        }

        public void onComplete() {
            if (!this.f21691f) {
                this.f21691f = true;
                this.f21687b.onComplete();
            }
        }

        public void onError(Throwable th2) {
            if (this.f21691f) {
                RxJavaPlugins.onError(th2);
                return;
            }
            this.f21691f = true;
            this.f21687b.onError(th2);
        }

        public void onNext(T t11) {
            if (!this.f21691f) {
                long j11 = this.f21690e;
                if (j11 == this.f21688c) {
                    this.f21691f = true;
                    this.f21689d.dispose();
                    this.f21687b.onSuccess(t11);
                    return;
                }
                this.f21690e = j11 + 1;
            }
        }

        public void onSubscribe(Disposable disposable) {
            if (DisposableHelper.validate(this.f21689d, disposable)) {
                this.f21689d = disposable;
                this.f21687b.onSubscribe(this);
            }
        }
    }

    public ObservableElementAtMaybe(ObservableSource<T> observableSource, long j11) {
        this.f21685b = observableSource;
        this.f21686c = j11;
    }

    public Observable<T> fuseToObservable() {
        return RxJavaPlugins.onAssembly(new ObservableElementAt(this.f21685b, this.f21686c, null, false));
    }

    public void subscribeActual(MaybeObserver<? super T> maybeObserver) {
        this.f21685b.subscribe(new ElementAtObserver(maybeObserver, this.f21686c));
    }
}
