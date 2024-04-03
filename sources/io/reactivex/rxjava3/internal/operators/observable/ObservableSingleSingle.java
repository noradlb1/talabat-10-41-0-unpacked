package io.reactivex.rxjava3.internal.operators.observable;

import io.reactivex.rxjava3.core.ObservableSource;
import io.reactivex.rxjava3.core.Observer;
import io.reactivex.rxjava3.core.Single;
import io.reactivex.rxjava3.core.SingleObserver;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.internal.disposables.DisposableHelper;
import io.reactivex.rxjava3.plugins.RxJavaPlugins;
import java.util.NoSuchElementException;

public final class ObservableSingleSingle<T> extends Single<T> {

    /* renamed from: b  reason: collision with root package name */
    public final ObservableSource<? extends T> f22214b;

    /* renamed from: c  reason: collision with root package name */
    public final T f22215c;

    public static final class SingleElementObserver<T> implements Observer<T>, Disposable {

        /* renamed from: b  reason: collision with root package name */
        public final SingleObserver<? super T> f22216b;

        /* renamed from: c  reason: collision with root package name */
        public final T f22217c;

        /* renamed from: d  reason: collision with root package name */
        public Disposable f22218d;

        /* renamed from: e  reason: collision with root package name */
        public T f22219e;

        /* renamed from: f  reason: collision with root package name */
        public boolean f22220f;

        public SingleElementObserver(SingleObserver<? super T> singleObserver, T t11) {
            this.f22216b = singleObserver;
            this.f22217c = t11;
        }

        public void dispose() {
            this.f22218d.dispose();
        }

        public boolean isDisposed() {
            return this.f22218d.isDisposed();
        }

        public void onComplete() {
            if (!this.f22220f) {
                this.f22220f = true;
                T t11 = this.f22219e;
                this.f22219e = null;
                if (t11 == null) {
                    t11 = this.f22217c;
                }
                if (t11 != null) {
                    this.f22216b.onSuccess(t11);
                } else {
                    this.f22216b.onError(new NoSuchElementException());
                }
            }
        }

        public void onError(Throwable th2) {
            if (this.f22220f) {
                RxJavaPlugins.onError(th2);
                return;
            }
            this.f22220f = true;
            this.f22216b.onError(th2);
        }

        public void onNext(T t11) {
            if (!this.f22220f) {
                if (this.f22219e != null) {
                    this.f22220f = true;
                    this.f22218d.dispose();
                    this.f22216b.onError(new IllegalArgumentException("Sequence contains more than one element!"));
                    return;
                }
                this.f22219e = t11;
            }
        }

        public void onSubscribe(Disposable disposable) {
            if (DisposableHelper.validate(this.f22218d, disposable)) {
                this.f22218d = disposable;
                this.f22216b.onSubscribe(this);
            }
        }
    }

    public ObservableSingleSingle(ObservableSource<? extends T> observableSource, T t11) {
        this.f22214b = observableSource;
        this.f22215c = t11;
    }

    public void subscribeActual(SingleObserver<? super T> singleObserver) {
        this.f22214b.subscribe(new SingleElementObserver(singleObserver, this.f22215c));
    }
}
