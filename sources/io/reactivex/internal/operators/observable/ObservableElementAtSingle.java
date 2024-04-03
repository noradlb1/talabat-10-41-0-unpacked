package io.reactivex.internal.operators.observable;

import io.reactivex.Observable;
import io.reactivex.ObservableSource;
import io.reactivex.Observer;
import io.reactivex.Single;
import io.reactivex.SingleObserver;
import io.reactivex.disposables.Disposable;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.fuseable.FuseToObservable;
import io.reactivex.plugins.RxJavaPlugins;
import java.util.NoSuchElementException;

public final class ObservableElementAtSingle<T> extends Single<T> implements FuseToObservable<T> {

    /* renamed from: b  reason: collision with root package name */
    public final ObservableSource<T> f17164b;

    /* renamed from: c  reason: collision with root package name */
    public final long f17165c;

    /* renamed from: d  reason: collision with root package name */
    public final T f17166d;

    public static final class ElementAtObserver<T> implements Observer<T>, Disposable {

        /* renamed from: b  reason: collision with root package name */
        public final SingleObserver<? super T> f17167b;

        /* renamed from: c  reason: collision with root package name */
        public final long f17168c;

        /* renamed from: d  reason: collision with root package name */
        public final T f17169d;

        /* renamed from: e  reason: collision with root package name */
        public Disposable f17170e;

        /* renamed from: f  reason: collision with root package name */
        public long f17171f;

        /* renamed from: g  reason: collision with root package name */
        public boolean f17172g;

        public ElementAtObserver(SingleObserver<? super T> singleObserver, long j11, T t11) {
            this.f17167b = singleObserver;
            this.f17168c = j11;
            this.f17169d = t11;
        }

        public void dispose() {
            this.f17170e.dispose();
        }

        public boolean isDisposed() {
            return this.f17170e.isDisposed();
        }

        public void onComplete() {
            if (!this.f17172g) {
                this.f17172g = true;
                T t11 = this.f17169d;
                if (t11 != null) {
                    this.f17167b.onSuccess(t11);
                } else {
                    this.f17167b.onError(new NoSuchElementException());
                }
            }
        }

        public void onError(Throwable th2) {
            if (this.f17172g) {
                RxJavaPlugins.onError(th2);
                return;
            }
            this.f17172g = true;
            this.f17167b.onError(th2);
        }

        public void onNext(T t11) {
            if (!this.f17172g) {
                long j11 = this.f17171f;
                if (j11 == this.f17168c) {
                    this.f17172g = true;
                    this.f17170e.dispose();
                    this.f17167b.onSuccess(t11);
                    return;
                }
                this.f17171f = j11 + 1;
            }
        }

        public void onSubscribe(Disposable disposable) {
            if (DisposableHelper.validate(this.f17170e, disposable)) {
                this.f17170e = disposable;
                this.f17167b.onSubscribe(this);
            }
        }
    }

    public ObservableElementAtSingle(ObservableSource<T> observableSource, long j11, T t11) {
        this.f17164b = observableSource;
        this.f17165c = j11;
        this.f17166d = t11;
    }

    public Observable<T> fuseToObservable() {
        return RxJavaPlugins.onAssembly(new ObservableElementAt(this.f17164b, this.f17165c, this.f17166d, true));
    }

    public void subscribeActual(SingleObserver<? super T> singleObserver) {
        this.f17164b.subscribe(new ElementAtObserver(singleObserver, this.f17165c, this.f17166d));
    }
}
