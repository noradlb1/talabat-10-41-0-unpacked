package io.reactivex.rxjava3.internal.operators.observable;

import io.reactivex.rxjava3.core.Maybe;
import io.reactivex.rxjava3.core.MaybeObserver;
import io.reactivex.rxjava3.core.ObservableSource;
import io.reactivex.rxjava3.core.Observer;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.internal.disposables.DisposableHelper;
import io.reactivex.rxjava3.plugins.RxJavaPlugins;

public final class ObservableSingleMaybe<T> extends Maybe<T> {

    /* renamed from: b  reason: collision with root package name */
    public final ObservableSource<T> f22209b;

    public static final class SingleElementObserver<T> implements Observer<T>, Disposable {

        /* renamed from: b  reason: collision with root package name */
        public final MaybeObserver<? super T> f22210b;

        /* renamed from: c  reason: collision with root package name */
        public Disposable f22211c;

        /* renamed from: d  reason: collision with root package name */
        public T f22212d;

        /* renamed from: e  reason: collision with root package name */
        public boolean f22213e;

        public SingleElementObserver(MaybeObserver<? super T> maybeObserver) {
            this.f22210b = maybeObserver;
        }

        public void dispose() {
            this.f22211c.dispose();
        }

        public boolean isDisposed() {
            return this.f22211c.isDisposed();
        }

        public void onComplete() {
            if (!this.f22213e) {
                this.f22213e = true;
                T t11 = this.f22212d;
                this.f22212d = null;
                if (t11 == null) {
                    this.f22210b.onComplete();
                } else {
                    this.f22210b.onSuccess(t11);
                }
            }
        }

        public void onError(Throwable th2) {
            if (this.f22213e) {
                RxJavaPlugins.onError(th2);
                return;
            }
            this.f22213e = true;
            this.f22210b.onError(th2);
        }

        public void onNext(T t11) {
            if (!this.f22213e) {
                if (this.f22212d != null) {
                    this.f22213e = true;
                    this.f22211c.dispose();
                    this.f22210b.onError(new IllegalArgumentException("Sequence contains more than one element!"));
                    return;
                }
                this.f22212d = t11;
            }
        }

        public void onSubscribe(Disposable disposable) {
            if (DisposableHelper.validate(this.f22211c, disposable)) {
                this.f22211c = disposable;
                this.f22210b.onSubscribe(this);
            }
        }
    }

    public ObservableSingleMaybe(ObservableSource<T> observableSource) {
        this.f22209b = observableSource;
    }

    public void subscribeActual(MaybeObserver<? super T> maybeObserver) {
        this.f22209b.subscribe(new SingleElementObserver(maybeObserver));
    }
}
