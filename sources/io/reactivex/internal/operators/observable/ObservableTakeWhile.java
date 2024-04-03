package io.reactivex.internal.operators.observable;

import io.reactivex.ObservableSource;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.functions.Predicate;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.plugins.RxJavaPlugins;

public final class ObservableTakeWhile<T> extends AbstractObservableWithUpstream<T, T> {

    /* renamed from: c  reason: collision with root package name */
    public final Predicate<? super T> f17785c;

    public static final class TakeWhileObserver<T> implements Observer<T>, Disposable {

        /* renamed from: b  reason: collision with root package name */
        public final Observer<? super T> f17786b;

        /* renamed from: c  reason: collision with root package name */
        public final Predicate<? super T> f17787c;

        /* renamed from: d  reason: collision with root package name */
        public Disposable f17788d;

        /* renamed from: e  reason: collision with root package name */
        public boolean f17789e;

        public TakeWhileObserver(Observer<? super T> observer, Predicate<? super T> predicate) {
            this.f17786b = observer;
            this.f17787c = predicate;
        }

        public void dispose() {
            this.f17788d.dispose();
        }

        public boolean isDisposed() {
            return this.f17788d.isDisposed();
        }

        public void onComplete() {
            if (!this.f17789e) {
                this.f17789e = true;
                this.f17786b.onComplete();
            }
        }

        public void onError(Throwable th2) {
            if (this.f17789e) {
                RxJavaPlugins.onError(th2);
                return;
            }
            this.f17789e = true;
            this.f17786b.onError(th2);
        }

        public void onNext(T t11) {
            if (!this.f17789e) {
                try {
                    if (!this.f17787c.test(t11)) {
                        this.f17789e = true;
                        this.f17788d.dispose();
                        this.f17786b.onComplete();
                        return;
                    }
                    this.f17786b.onNext(t11);
                } catch (Throwable th2) {
                    Exceptions.throwIfFatal(th2);
                    this.f17788d.dispose();
                    onError(th2);
                }
            }
        }

        public void onSubscribe(Disposable disposable) {
            if (DisposableHelper.validate(this.f17788d, disposable)) {
                this.f17788d = disposable;
                this.f17786b.onSubscribe(this);
            }
        }
    }

    public ObservableTakeWhile(ObservableSource<T> observableSource, Predicate<? super T> predicate) {
        super(observableSource);
        this.f17785c = predicate;
    }

    public void subscribeActual(Observer<? super T> observer) {
        this.f16799b.subscribe(new TakeWhileObserver(observer, this.f17785c));
    }
}
