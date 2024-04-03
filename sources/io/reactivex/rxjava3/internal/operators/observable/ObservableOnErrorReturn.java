package io.reactivex.rxjava3.internal.operators.observable;

import io.reactivex.rxjava3.core.ObservableSource;
import io.reactivex.rxjava3.core.Observer;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.exceptions.CompositeException;
import io.reactivex.rxjava3.exceptions.Exceptions;
import io.reactivex.rxjava3.functions.Function;
import io.reactivex.rxjava3.internal.disposables.DisposableHelper;

public final class ObservableOnErrorReturn<T> extends AbstractObservableWithUpstream<T, T> {

    /* renamed from: c  reason: collision with root package name */
    public final Function<? super Throwable, ? extends T> f22006c;

    public static final class OnErrorReturnObserver<T> implements Observer<T>, Disposable {

        /* renamed from: b  reason: collision with root package name */
        public final Observer<? super T> f22007b;

        /* renamed from: c  reason: collision with root package name */
        public final Function<? super Throwable, ? extends T> f22008c;

        /* renamed from: d  reason: collision with root package name */
        public Disposable f22009d;

        public OnErrorReturnObserver(Observer<? super T> observer, Function<? super Throwable, ? extends T> function) {
            this.f22007b = observer;
            this.f22008c = function;
        }

        public void dispose() {
            this.f22009d.dispose();
        }

        public boolean isDisposed() {
            return this.f22009d.isDisposed();
        }

        public void onComplete() {
            this.f22007b.onComplete();
        }

        public void onError(Throwable th2) {
            try {
                Object apply = this.f22008c.apply(th2);
                if (apply == null) {
                    NullPointerException nullPointerException = new NullPointerException("The supplied value is null");
                    nullPointerException.initCause(th2);
                    this.f22007b.onError(nullPointerException);
                    return;
                }
                this.f22007b.onNext(apply);
                this.f22007b.onComplete();
            } catch (Throwable th3) {
                Exceptions.throwIfFatal(th3);
                this.f22007b.onError(new CompositeException(th2, th3));
            }
        }

        public void onNext(T t11) {
            this.f22007b.onNext(t11);
        }

        public void onSubscribe(Disposable disposable) {
            if (DisposableHelper.validate(this.f22009d, disposable)) {
                this.f22009d = disposable;
                this.f22007b.onSubscribe(this);
            }
        }
    }

    public ObservableOnErrorReturn(ObservableSource<T> observableSource, Function<? super Throwable, ? extends T> function) {
        super(observableSource);
        this.f22006c = function;
    }

    public void subscribeActual(Observer<? super T> observer) {
        this.f21304b.subscribe(new OnErrorReturnObserver(observer, this.f22006c));
    }
}
