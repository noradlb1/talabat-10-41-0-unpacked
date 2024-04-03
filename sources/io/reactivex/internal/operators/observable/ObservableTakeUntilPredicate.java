package io.reactivex.internal.operators.observable;

import io.reactivex.ObservableSource;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.functions.Predicate;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.plugins.RxJavaPlugins;

public final class ObservableTakeUntilPredicate<T> extends AbstractObservableWithUpstream<T, T> {

    /* renamed from: c  reason: collision with root package name */
    public final Predicate<? super T> f17780c;

    public static final class TakeUntilPredicateObserver<T> implements Observer<T>, Disposable {

        /* renamed from: b  reason: collision with root package name */
        public final Observer<? super T> f17781b;

        /* renamed from: c  reason: collision with root package name */
        public final Predicate<? super T> f17782c;

        /* renamed from: d  reason: collision with root package name */
        public Disposable f17783d;

        /* renamed from: e  reason: collision with root package name */
        public boolean f17784e;

        public TakeUntilPredicateObserver(Observer<? super T> observer, Predicate<? super T> predicate) {
            this.f17781b = observer;
            this.f17782c = predicate;
        }

        public void dispose() {
            this.f17783d.dispose();
        }

        public boolean isDisposed() {
            return this.f17783d.isDisposed();
        }

        public void onComplete() {
            if (!this.f17784e) {
                this.f17784e = true;
                this.f17781b.onComplete();
            }
        }

        public void onError(Throwable th2) {
            if (!this.f17784e) {
                this.f17784e = true;
                this.f17781b.onError(th2);
                return;
            }
            RxJavaPlugins.onError(th2);
        }

        public void onNext(T t11) {
            if (!this.f17784e) {
                this.f17781b.onNext(t11);
                try {
                    if (this.f17782c.test(t11)) {
                        this.f17784e = true;
                        this.f17783d.dispose();
                        this.f17781b.onComplete();
                    }
                } catch (Throwable th2) {
                    Exceptions.throwIfFatal(th2);
                    this.f17783d.dispose();
                    onError(th2);
                }
            }
        }

        public void onSubscribe(Disposable disposable) {
            if (DisposableHelper.validate(this.f17783d, disposable)) {
                this.f17783d = disposable;
                this.f17781b.onSubscribe(this);
            }
        }
    }

    public ObservableTakeUntilPredicate(ObservableSource<T> observableSource, Predicate<? super T> predicate) {
        super(observableSource);
        this.f17780c = predicate;
    }

    public void subscribeActual(Observer<? super T> observer) {
        this.f16799b.subscribe(new TakeUntilPredicateObserver(observer, this.f17780c));
    }
}
