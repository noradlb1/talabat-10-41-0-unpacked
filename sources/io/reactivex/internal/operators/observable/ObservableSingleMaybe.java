package io.reactivex.internal.operators.observable;

import io.reactivex.Maybe;
import io.reactivex.MaybeObserver;
import io.reactivex.ObservableSource;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.plugins.RxJavaPlugins;

public final class ObservableSingleMaybe<T> extends Maybe<T> {

    /* renamed from: b  reason: collision with root package name */
    public final ObservableSource<T> f17666b;

    public static final class SingleElementObserver<T> implements Observer<T>, Disposable {

        /* renamed from: b  reason: collision with root package name */
        public final MaybeObserver<? super T> f17667b;

        /* renamed from: c  reason: collision with root package name */
        public Disposable f17668c;

        /* renamed from: d  reason: collision with root package name */
        public T f17669d;

        /* renamed from: e  reason: collision with root package name */
        public boolean f17670e;

        public SingleElementObserver(MaybeObserver<? super T> maybeObserver) {
            this.f17667b = maybeObserver;
        }

        public void dispose() {
            this.f17668c.dispose();
        }

        public boolean isDisposed() {
            return this.f17668c.isDisposed();
        }

        public void onComplete() {
            if (!this.f17670e) {
                this.f17670e = true;
                T t11 = this.f17669d;
                this.f17669d = null;
                if (t11 == null) {
                    this.f17667b.onComplete();
                } else {
                    this.f17667b.onSuccess(t11);
                }
            }
        }

        public void onError(Throwable th2) {
            if (this.f17670e) {
                RxJavaPlugins.onError(th2);
                return;
            }
            this.f17670e = true;
            this.f17667b.onError(th2);
        }

        public void onNext(T t11) {
            if (!this.f17670e) {
                if (this.f17669d != null) {
                    this.f17670e = true;
                    this.f17668c.dispose();
                    this.f17667b.onError(new IllegalArgumentException("Sequence contains more than one element!"));
                    return;
                }
                this.f17669d = t11;
            }
        }

        public void onSubscribe(Disposable disposable) {
            if (DisposableHelper.validate(this.f17668c, disposable)) {
                this.f17668c = disposable;
                this.f17667b.onSubscribe(this);
            }
        }
    }

    public ObservableSingleMaybe(ObservableSource<T> observableSource) {
        this.f17666b = observableSource;
    }

    public void subscribeActual(MaybeObserver<? super T> maybeObserver) {
        this.f17666b.subscribe(new SingleElementObserver(maybeObserver));
    }
}
