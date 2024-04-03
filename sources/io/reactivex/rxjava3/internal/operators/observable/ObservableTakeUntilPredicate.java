package io.reactivex.rxjava3.internal.operators.observable;

import io.reactivex.rxjava3.core.ObservableSource;
import io.reactivex.rxjava3.core.Observer;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.exceptions.Exceptions;
import io.reactivex.rxjava3.functions.Predicate;
import io.reactivex.rxjava3.internal.disposables.DisposableHelper;
import io.reactivex.rxjava3.plugins.RxJavaPlugins;

public final class ObservableTakeUntilPredicate<T> extends AbstractObservableWithUpstream<T, T> {

    /* renamed from: c  reason: collision with root package name */
    public final Predicate<? super T> f22323c;

    public static final class TakeUntilPredicateObserver<T> implements Observer<T>, Disposable {

        /* renamed from: b  reason: collision with root package name */
        public final Observer<? super T> f22324b;

        /* renamed from: c  reason: collision with root package name */
        public final Predicate<? super T> f22325c;

        /* renamed from: d  reason: collision with root package name */
        public Disposable f22326d;

        /* renamed from: e  reason: collision with root package name */
        public boolean f22327e;

        public TakeUntilPredicateObserver(Observer<? super T> observer, Predicate<? super T> predicate) {
            this.f22324b = observer;
            this.f22325c = predicate;
        }

        public void dispose() {
            this.f22326d.dispose();
        }

        public boolean isDisposed() {
            return this.f22326d.isDisposed();
        }

        public void onComplete() {
            if (!this.f22327e) {
                this.f22327e = true;
                this.f22324b.onComplete();
            }
        }

        public void onError(Throwable th2) {
            if (!this.f22327e) {
                this.f22327e = true;
                this.f22324b.onError(th2);
                return;
            }
            RxJavaPlugins.onError(th2);
        }

        public void onNext(T t11) {
            if (!this.f22327e) {
                this.f22324b.onNext(t11);
                try {
                    if (this.f22325c.test(t11)) {
                        this.f22327e = true;
                        this.f22326d.dispose();
                        this.f22324b.onComplete();
                    }
                } catch (Throwable th2) {
                    Exceptions.throwIfFatal(th2);
                    this.f22326d.dispose();
                    onError(th2);
                }
            }
        }

        public void onSubscribe(Disposable disposable) {
            if (DisposableHelper.validate(this.f22326d, disposable)) {
                this.f22326d = disposable;
                this.f22324b.onSubscribe(this);
            }
        }
    }

    public ObservableTakeUntilPredicate(ObservableSource<T> observableSource, Predicate<? super T> predicate) {
        super(observableSource);
        this.f22323c = predicate;
    }

    public void subscribeActual(Observer<? super T> observer) {
        this.f21304b.subscribe(new TakeUntilPredicateObserver(observer, this.f22323c));
    }
}
