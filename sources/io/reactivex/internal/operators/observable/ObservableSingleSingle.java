package io.reactivex.internal.operators.observable;

import io.reactivex.ObservableSource;
import io.reactivex.Observer;
import io.reactivex.Single;
import io.reactivex.SingleObserver;
import io.reactivex.disposables.Disposable;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.plugins.RxJavaPlugins;
import java.util.NoSuchElementException;

public final class ObservableSingleSingle<T> extends Single<T> {

    /* renamed from: b  reason: collision with root package name */
    public final ObservableSource<? extends T> f17671b;

    /* renamed from: c  reason: collision with root package name */
    public final T f17672c;

    public static final class SingleElementObserver<T> implements Observer<T>, Disposable {

        /* renamed from: b  reason: collision with root package name */
        public final SingleObserver<? super T> f17673b;

        /* renamed from: c  reason: collision with root package name */
        public final T f17674c;

        /* renamed from: d  reason: collision with root package name */
        public Disposable f17675d;

        /* renamed from: e  reason: collision with root package name */
        public T f17676e;

        /* renamed from: f  reason: collision with root package name */
        public boolean f17677f;

        public SingleElementObserver(SingleObserver<? super T> singleObserver, T t11) {
            this.f17673b = singleObserver;
            this.f17674c = t11;
        }

        public void dispose() {
            this.f17675d.dispose();
        }

        public boolean isDisposed() {
            return this.f17675d.isDisposed();
        }

        public void onComplete() {
            if (!this.f17677f) {
                this.f17677f = true;
                T t11 = this.f17676e;
                this.f17676e = null;
                if (t11 == null) {
                    t11 = this.f17674c;
                }
                if (t11 != null) {
                    this.f17673b.onSuccess(t11);
                } else {
                    this.f17673b.onError(new NoSuchElementException());
                }
            }
        }

        public void onError(Throwable th2) {
            if (this.f17677f) {
                RxJavaPlugins.onError(th2);
                return;
            }
            this.f17677f = true;
            this.f17673b.onError(th2);
        }

        public void onNext(T t11) {
            if (!this.f17677f) {
                if (this.f17676e != null) {
                    this.f17677f = true;
                    this.f17675d.dispose();
                    this.f17673b.onError(new IllegalArgumentException("Sequence contains more than one element!"));
                    return;
                }
                this.f17676e = t11;
            }
        }

        public void onSubscribe(Disposable disposable) {
            if (DisposableHelper.validate(this.f17675d, disposable)) {
                this.f17675d = disposable;
                this.f17673b.onSubscribe(this);
            }
        }
    }

    public ObservableSingleSingle(ObservableSource<? extends T> observableSource, T t11) {
        this.f17671b = observableSource;
        this.f17672c = t11;
    }

    public void subscribeActual(SingleObserver<? super T> singleObserver) {
        this.f17671b.subscribe(new SingleElementObserver(singleObserver, this.f17672c));
    }
}
