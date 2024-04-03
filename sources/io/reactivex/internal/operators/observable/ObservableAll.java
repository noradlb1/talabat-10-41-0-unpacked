package io.reactivex.internal.operators.observable;

import io.reactivex.ObservableSource;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.functions.Predicate;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.plugins.RxJavaPlugins;

public final class ObservableAll<T> extends AbstractObservableWithUpstream<T, Boolean> {

    /* renamed from: c  reason: collision with root package name */
    public final Predicate<? super T> f16817c;

    public static final class AllObserver<T> implements Observer<T>, Disposable {

        /* renamed from: b  reason: collision with root package name */
        public final Observer<? super Boolean> f16818b;

        /* renamed from: c  reason: collision with root package name */
        public final Predicate<? super T> f16819c;

        /* renamed from: d  reason: collision with root package name */
        public Disposable f16820d;

        /* renamed from: e  reason: collision with root package name */
        public boolean f16821e;

        public AllObserver(Observer<? super Boolean> observer, Predicate<? super T> predicate) {
            this.f16818b = observer;
            this.f16819c = predicate;
        }

        public void dispose() {
            this.f16820d.dispose();
        }

        public boolean isDisposed() {
            return this.f16820d.isDisposed();
        }

        public void onComplete() {
            if (!this.f16821e) {
                this.f16821e = true;
                this.f16818b.onNext(Boolean.TRUE);
                this.f16818b.onComplete();
            }
        }

        public void onError(Throwable th2) {
            if (this.f16821e) {
                RxJavaPlugins.onError(th2);
                return;
            }
            this.f16821e = true;
            this.f16818b.onError(th2);
        }

        public void onNext(T t11) {
            if (!this.f16821e) {
                try {
                    if (!this.f16819c.test(t11)) {
                        this.f16821e = true;
                        this.f16820d.dispose();
                        this.f16818b.onNext(Boolean.FALSE);
                        this.f16818b.onComplete();
                    }
                } catch (Throwable th2) {
                    Exceptions.throwIfFatal(th2);
                    this.f16820d.dispose();
                    onError(th2);
                }
            }
        }

        public void onSubscribe(Disposable disposable) {
            if (DisposableHelper.validate(this.f16820d, disposable)) {
                this.f16820d = disposable;
                this.f16818b.onSubscribe(this);
            }
        }
    }

    public ObservableAll(ObservableSource<T> observableSource, Predicate<? super T> predicate) {
        super(observableSource);
        this.f16817c = predicate;
    }

    public void subscribeActual(Observer<? super Boolean> observer) {
        this.f16799b.subscribe(new AllObserver(observer, this.f16817c));
    }
}
