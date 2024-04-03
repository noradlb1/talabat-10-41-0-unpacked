package io.reactivex.rxjava3.internal.operators.observable;

import io.reactivex.rxjava3.core.ObservableSource;
import io.reactivex.rxjava3.core.Observer;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.exceptions.Exceptions;
import io.reactivex.rxjava3.functions.Predicate;
import io.reactivex.rxjava3.internal.disposables.DisposableHelper;
import io.reactivex.rxjava3.plugins.RxJavaPlugins;

public final class ObservableAll<T> extends AbstractObservableWithUpstream<T, Boolean> {

    /* renamed from: c  reason: collision with root package name */
    public final Predicate<? super T> f21322c;

    public static final class AllObserver<T> implements Observer<T>, Disposable {

        /* renamed from: b  reason: collision with root package name */
        public final Observer<? super Boolean> f21323b;

        /* renamed from: c  reason: collision with root package name */
        public final Predicate<? super T> f21324c;

        /* renamed from: d  reason: collision with root package name */
        public Disposable f21325d;

        /* renamed from: e  reason: collision with root package name */
        public boolean f21326e;

        public AllObserver(Observer<? super Boolean> observer, Predicate<? super T> predicate) {
            this.f21323b = observer;
            this.f21324c = predicate;
        }

        public void dispose() {
            this.f21325d.dispose();
        }

        public boolean isDisposed() {
            return this.f21325d.isDisposed();
        }

        public void onComplete() {
            if (!this.f21326e) {
                this.f21326e = true;
                this.f21323b.onNext(Boolean.TRUE);
                this.f21323b.onComplete();
            }
        }

        public void onError(Throwable th2) {
            if (this.f21326e) {
                RxJavaPlugins.onError(th2);
                return;
            }
            this.f21326e = true;
            this.f21323b.onError(th2);
        }

        public void onNext(T t11) {
            if (!this.f21326e) {
                try {
                    if (!this.f21324c.test(t11)) {
                        this.f21326e = true;
                        this.f21325d.dispose();
                        this.f21323b.onNext(Boolean.FALSE);
                        this.f21323b.onComplete();
                    }
                } catch (Throwable th2) {
                    Exceptions.throwIfFatal(th2);
                    this.f21325d.dispose();
                    onError(th2);
                }
            }
        }

        public void onSubscribe(Disposable disposable) {
            if (DisposableHelper.validate(this.f21325d, disposable)) {
                this.f21325d = disposable;
                this.f21323b.onSubscribe(this);
            }
        }
    }

    public ObservableAll(ObservableSource<T> observableSource, Predicate<? super T> predicate) {
        super(observableSource);
        this.f21322c = predicate;
    }

    public void subscribeActual(Observer<? super Boolean> observer) {
        this.f21304b.subscribe(new AllObserver(observer, this.f21322c));
    }
}
