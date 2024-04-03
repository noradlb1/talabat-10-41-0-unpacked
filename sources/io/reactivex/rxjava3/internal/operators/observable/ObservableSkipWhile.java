package io.reactivex.rxjava3.internal.operators.observable;

import io.reactivex.rxjava3.core.ObservableSource;
import io.reactivex.rxjava3.core.Observer;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.exceptions.Exceptions;
import io.reactivex.rxjava3.functions.Predicate;
import io.reactivex.rxjava3.internal.disposables.DisposableHelper;

public final class ObservableSkipWhile<T> extends AbstractObservableWithUpstream<T, T> {

    /* renamed from: c  reason: collision with root package name */
    public final Predicate<? super T> f22255c;

    public static final class SkipWhileObserver<T> implements Observer<T>, Disposable {

        /* renamed from: b  reason: collision with root package name */
        public final Observer<? super T> f22256b;

        /* renamed from: c  reason: collision with root package name */
        public final Predicate<? super T> f22257c;

        /* renamed from: d  reason: collision with root package name */
        public Disposable f22258d;

        /* renamed from: e  reason: collision with root package name */
        public boolean f22259e;

        public SkipWhileObserver(Observer<? super T> observer, Predicate<? super T> predicate) {
            this.f22256b = observer;
            this.f22257c = predicate;
        }

        public void dispose() {
            this.f22258d.dispose();
        }

        public boolean isDisposed() {
            return this.f22258d.isDisposed();
        }

        public void onComplete() {
            this.f22256b.onComplete();
        }

        public void onError(Throwable th2) {
            this.f22256b.onError(th2);
        }

        public void onNext(T t11) {
            if (this.f22259e) {
                this.f22256b.onNext(t11);
                return;
            }
            try {
                if (!this.f22257c.test(t11)) {
                    this.f22259e = true;
                    this.f22256b.onNext(t11);
                }
            } catch (Throwable th2) {
                Exceptions.throwIfFatal(th2);
                this.f22258d.dispose();
                this.f22256b.onError(th2);
            }
        }

        public void onSubscribe(Disposable disposable) {
            if (DisposableHelper.validate(this.f22258d, disposable)) {
                this.f22258d = disposable;
                this.f22256b.onSubscribe(this);
            }
        }
    }

    public ObservableSkipWhile(ObservableSource<T> observableSource, Predicate<? super T> predicate) {
        super(observableSource);
        this.f22255c = predicate;
    }

    public void subscribeActual(Observer<? super T> observer) {
        this.f21304b.subscribe(new SkipWhileObserver(observer, this.f22255c));
    }
}
