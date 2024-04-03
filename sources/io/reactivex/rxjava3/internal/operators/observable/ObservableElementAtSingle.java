package io.reactivex.rxjava3.internal.operators.observable;

import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.core.ObservableSource;
import io.reactivex.rxjava3.core.Observer;
import io.reactivex.rxjava3.core.Single;
import io.reactivex.rxjava3.core.SingleObserver;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.internal.disposables.DisposableHelper;
import io.reactivex.rxjava3.internal.fuseable.FuseToObservable;
import io.reactivex.rxjava3.plugins.RxJavaPlugins;
import java.util.NoSuchElementException;

public final class ObservableElementAtSingle<T> extends Single<T> implements FuseToObservable<T> {

    /* renamed from: b  reason: collision with root package name */
    public final ObservableSource<T> f21692b;

    /* renamed from: c  reason: collision with root package name */
    public final long f21693c;

    /* renamed from: d  reason: collision with root package name */
    public final T f21694d;

    public static final class ElementAtObserver<T> implements Observer<T>, Disposable {

        /* renamed from: b  reason: collision with root package name */
        public final SingleObserver<? super T> f21695b;

        /* renamed from: c  reason: collision with root package name */
        public final long f21696c;

        /* renamed from: d  reason: collision with root package name */
        public final T f21697d;

        /* renamed from: e  reason: collision with root package name */
        public Disposable f21698e;

        /* renamed from: f  reason: collision with root package name */
        public long f21699f;

        /* renamed from: g  reason: collision with root package name */
        public boolean f21700g;

        public ElementAtObserver(SingleObserver<? super T> singleObserver, long j11, T t11) {
            this.f21695b = singleObserver;
            this.f21696c = j11;
            this.f21697d = t11;
        }

        public void dispose() {
            this.f21698e.dispose();
        }

        public boolean isDisposed() {
            return this.f21698e.isDisposed();
        }

        public void onComplete() {
            if (!this.f21700g) {
                this.f21700g = true;
                T t11 = this.f21697d;
                if (t11 != null) {
                    this.f21695b.onSuccess(t11);
                } else {
                    this.f21695b.onError(new NoSuchElementException());
                }
            }
        }

        public void onError(Throwable th2) {
            if (this.f21700g) {
                RxJavaPlugins.onError(th2);
                return;
            }
            this.f21700g = true;
            this.f21695b.onError(th2);
        }

        public void onNext(T t11) {
            if (!this.f21700g) {
                long j11 = this.f21699f;
                if (j11 == this.f21696c) {
                    this.f21700g = true;
                    this.f21698e.dispose();
                    this.f21695b.onSuccess(t11);
                    return;
                }
                this.f21699f = j11 + 1;
            }
        }

        public void onSubscribe(Disposable disposable) {
            if (DisposableHelper.validate(this.f21698e, disposable)) {
                this.f21698e = disposable;
                this.f21695b.onSubscribe(this);
            }
        }
    }

    public ObservableElementAtSingle(ObservableSource<T> observableSource, long j11, T t11) {
        this.f21692b = observableSource;
        this.f21693c = j11;
        this.f21694d = t11;
    }

    public Observable<T> fuseToObservable() {
        return RxJavaPlugins.onAssembly(new ObservableElementAt(this.f21692b, this.f21693c, this.f21694d, true));
    }

    public void subscribeActual(SingleObserver<? super T> singleObserver) {
        this.f21692b.subscribe(new ElementAtObserver(singleObserver, this.f21693c, this.f21694d));
    }
}
