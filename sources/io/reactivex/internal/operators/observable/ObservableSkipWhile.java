package io.reactivex.internal.operators.observable;

import io.reactivex.ObservableSource;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.functions.Predicate;
import io.reactivex.internal.disposables.DisposableHelper;

public final class ObservableSkipWhile<T> extends AbstractObservableWithUpstream<T, T> {

    /* renamed from: c  reason: collision with root package name */
    public final Predicate<? super T> f17712c;

    public static final class SkipWhileObserver<T> implements Observer<T>, Disposable {

        /* renamed from: b  reason: collision with root package name */
        public final Observer<? super T> f17713b;

        /* renamed from: c  reason: collision with root package name */
        public final Predicate<? super T> f17714c;

        /* renamed from: d  reason: collision with root package name */
        public Disposable f17715d;

        /* renamed from: e  reason: collision with root package name */
        public boolean f17716e;

        public SkipWhileObserver(Observer<? super T> observer, Predicate<? super T> predicate) {
            this.f17713b = observer;
            this.f17714c = predicate;
        }

        public void dispose() {
            this.f17715d.dispose();
        }

        public boolean isDisposed() {
            return this.f17715d.isDisposed();
        }

        public void onComplete() {
            this.f17713b.onComplete();
        }

        public void onError(Throwable th2) {
            this.f17713b.onError(th2);
        }

        public void onNext(T t11) {
            if (this.f17716e) {
                this.f17713b.onNext(t11);
                return;
            }
            try {
                if (!this.f17714c.test(t11)) {
                    this.f17716e = true;
                    this.f17713b.onNext(t11);
                }
            } catch (Throwable th2) {
                Exceptions.throwIfFatal(th2);
                this.f17715d.dispose();
                this.f17713b.onError(th2);
            }
        }

        public void onSubscribe(Disposable disposable) {
            if (DisposableHelper.validate(this.f17715d, disposable)) {
                this.f17715d = disposable;
                this.f17713b.onSubscribe(this);
            }
        }
    }

    public ObservableSkipWhile(ObservableSource<T> observableSource, Predicate<? super T> predicate) {
        super(observableSource);
        this.f17712c = predicate;
    }

    public void subscribeActual(Observer<? super T> observer) {
        this.f16799b.subscribe(new SkipWhileObserver(observer, this.f17712c));
    }
}
