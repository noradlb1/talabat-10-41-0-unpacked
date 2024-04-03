package io.reactivex.rxjava3.internal.operators.observable;

import io.reactivex.rxjava3.core.ObservableSource;
import io.reactivex.rxjava3.core.Observer;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.exceptions.Exceptions;
import io.reactivex.rxjava3.functions.Predicate;
import io.reactivex.rxjava3.internal.disposables.DisposableHelper;
import io.reactivex.rxjava3.plugins.RxJavaPlugins;

public final class ObservableTakeWhile<T> extends AbstractObservableWithUpstream<T, T> {

    /* renamed from: c  reason: collision with root package name */
    public final Predicate<? super T> f22328c;

    public static final class TakeWhileObserver<T> implements Observer<T>, Disposable {

        /* renamed from: b  reason: collision with root package name */
        public final Observer<? super T> f22329b;

        /* renamed from: c  reason: collision with root package name */
        public final Predicate<? super T> f22330c;

        /* renamed from: d  reason: collision with root package name */
        public Disposable f22331d;

        /* renamed from: e  reason: collision with root package name */
        public boolean f22332e;

        public TakeWhileObserver(Observer<? super T> observer, Predicate<? super T> predicate) {
            this.f22329b = observer;
            this.f22330c = predicate;
        }

        public void dispose() {
            this.f22331d.dispose();
        }

        public boolean isDisposed() {
            return this.f22331d.isDisposed();
        }

        public void onComplete() {
            if (!this.f22332e) {
                this.f22332e = true;
                this.f22329b.onComplete();
            }
        }

        public void onError(Throwable th2) {
            if (this.f22332e) {
                RxJavaPlugins.onError(th2);
                return;
            }
            this.f22332e = true;
            this.f22329b.onError(th2);
        }

        public void onNext(T t11) {
            if (!this.f22332e) {
                try {
                    if (!this.f22330c.test(t11)) {
                        this.f22332e = true;
                        this.f22331d.dispose();
                        this.f22329b.onComplete();
                        return;
                    }
                    this.f22329b.onNext(t11);
                } catch (Throwable th2) {
                    Exceptions.throwIfFatal(th2);
                    this.f22331d.dispose();
                    onError(th2);
                }
            }
        }

        public void onSubscribe(Disposable disposable) {
            if (DisposableHelper.validate(this.f22331d, disposable)) {
                this.f22331d = disposable;
                this.f22329b.onSubscribe(this);
            }
        }
    }

    public ObservableTakeWhile(ObservableSource<T> observableSource, Predicate<? super T> predicate) {
        super(observableSource);
        this.f22328c = predicate;
    }

    public void subscribeActual(Observer<? super T> observer) {
        this.f21304b.subscribe(new TakeWhileObserver(observer, this.f22328c));
    }
}
