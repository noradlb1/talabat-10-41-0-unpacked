package io.reactivex.internal.operators.observable;

import io.reactivex.ObservableSource;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.functions.Predicate;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.plugins.RxJavaPlugins;

public final class ObservableAny<T> extends AbstractObservableWithUpstream<T, Boolean> {

    /* renamed from: c  reason: collision with root package name */
    public final Predicate<? super T> f16837c;

    public static final class AnyObserver<T> implements Observer<T>, Disposable {

        /* renamed from: b  reason: collision with root package name */
        public final Observer<? super Boolean> f16838b;

        /* renamed from: c  reason: collision with root package name */
        public final Predicate<? super T> f16839c;

        /* renamed from: d  reason: collision with root package name */
        public Disposable f16840d;

        /* renamed from: e  reason: collision with root package name */
        public boolean f16841e;

        public AnyObserver(Observer<? super Boolean> observer, Predicate<? super T> predicate) {
            this.f16838b = observer;
            this.f16839c = predicate;
        }

        public void dispose() {
            this.f16840d.dispose();
        }

        public boolean isDisposed() {
            return this.f16840d.isDisposed();
        }

        public void onComplete() {
            if (!this.f16841e) {
                this.f16841e = true;
                this.f16838b.onNext(Boolean.FALSE);
                this.f16838b.onComplete();
            }
        }

        public void onError(Throwable th2) {
            if (this.f16841e) {
                RxJavaPlugins.onError(th2);
                return;
            }
            this.f16841e = true;
            this.f16838b.onError(th2);
        }

        public void onNext(T t11) {
            if (!this.f16841e) {
                try {
                    if (this.f16839c.test(t11)) {
                        this.f16841e = true;
                        this.f16840d.dispose();
                        this.f16838b.onNext(Boolean.TRUE);
                        this.f16838b.onComplete();
                    }
                } catch (Throwable th2) {
                    Exceptions.throwIfFatal(th2);
                    this.f16840d.dispose();
                    onError(th2);
                }
            }
        }

        public void onSubscribe(Disposable disposable) {
            if (DisposableHelper.validate(this.f16840d, disposable)) {
                this.f16840d = disposable;
                this.f16838b.onSubscribe(this);
            }
        }
    }

    public ObservableAny(ObservableSource<T> observableSource, Predicate<? super T> predicate) {
        super(observableSource);
        this.f16837c = predicate;
    }

    public void subscribeActual(Observer<? super Boolean> observer) {
        this.f16799b.subscribe(new AnyObserver(observer, this.f16837c));
    }
}
