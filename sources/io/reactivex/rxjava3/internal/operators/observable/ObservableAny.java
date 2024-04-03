package io.reactivex.rxjava3.internal.operators.observable;

import io.reactivex.rxjava3.core.ObservableSource;
import io.reactivex.rxjava3.core.Observer;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.exceptions.Exceptions;
import io.reactivex.rxjava3.functions.Predicate;
import io.reactivex.rxjava3.internal.disposables.DisposableHelper;
import io.reactivex.rxjava3.plugins.RxJavaPlugins;

public final class ObservableAny<T> extends AbstractObservableWithUpstream<T, Boolean> {

    /* renamed from: c  reason: collision with root package name */
    public final Predicate<? super T> f21342c;

    public static final class AnyObserver<T> implements Observer<T>, Disposable {

        /* renamed from: b  reason: collision with root package name */
        public final Observer<? super Boolean> f21343b;

        /* renamed from: c  reason: collision with root package name */
        public final Predicate<? super T> f21344c;

        /* renamed from: d  reason: collision with root package name */
        public Disposable f21345d;

        /* renamed from: e  reason: collision with root package name */
        public boolean f21346e;

        public AnyObserver(Observer<? super Boolean> observer, Predicate<? super T> predicate) {
            this.f21343b = observer;
            this.f21344c = predicate;
        }

        public void dispose() {
            this.f21345d.dispose();
        }

        public boolean isDisposed() {
            return this.f21345d.isDisposed();
        }

        public void onComplete() {
            if (!this.f21346e) {
                this.f21346e = true;
                this.f21343b.onNext(Boolean.FALSE);
                this.f21343b.onComplete();
            }
        }

        public void onError(Throwable th2) {
            if (this.f21346e) {
                RxJavaPlugins.onError(th2);
                return;
            }
            this.f21346e = true;
            this.f21343b.onError(th2);
        }

        public void onNext(T t11) {
            if (!this.f21346e) {
                try {
                    if (this.f21344c.test(t11)) {
                        this.f21346e = true;
                        this.f21345d.dispose();
                        this.f21343b.onNext(Boolean.TRUE);
                        this.f21343b.onComplete();
                    }
                } catch (Throwable th2) {
                    Exceptions.throwIfFatal(th2);
                    this.f21345d.dispose();
                    onError(th2);
                }
            }
        }

        public void onSubscribe(Disposable disposable) {
            if (DisposableHelper.validate(this.f21345d, disposable)) {
                this.f21345d = disposable;
                this.f21343b.onSubscribe(this);
            }
        }
    }

    public ObservableAny(ObservableSource<T> observableSource, Predicate<? super T> predicate) {
        super(observableSource);
        this.f21342c = predicate;
    }

    public void subscribeActual(Observer<? super Boolean> observer) {
        this.f21304b.subscribe(new AnyObserver(observer, this.f21342c));
    }
}
