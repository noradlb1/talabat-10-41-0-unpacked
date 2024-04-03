package io.reactivex.rxjava3.internal.operators.observable;

import io.reactivex.rxjava3.core.ObservableSource;
import io.reactivex.rxjava3.core.Observer;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.exceptions.CompositeException;
import io.reactivex.rxjava3.exceptions.Exceptions;
import io.reactivex.rxjava3.functions.Function;
import io.reactivex.rxjava3.functions.Supplier;
import io.reactivex.rxjava3.internal.disposables.DisposableHelper;
import java.util.Objects;

public final class ObservableMapNotification<T, R> extends AbstractObservableWithUpstream<T, ObservableSource<? extends R>> {

    /* renamed from: c  reason: collision with root package name */
    public final Function<? super T, ? extends ObservableSource<? extends R>> f21942c;

    /* renamed from: d  reason: collision with root package name */
    public final Function<? super Throwable, ? extends ObservableSource<? extends R>> f21943d;

    /* renamed from: e  reason: collision with root package name */
    public final Supplier<? extends ObservableSource<? extends R>> f21944e;

    public static final class MapNotificationObserver<T, R> implements Observer<T>, Disposable {

        /* renamed from: b  reason: collision with root package name */
        public final Observer<? super ObservableSource<? extends R>> f21945b;

        /* renamed from: c  reason: collision with root package name */
        public final Function<? super T, ? extends ObservableSource<? extends R>> f21946c;

        /* renamed from: d  reason: collision with root package name */
        public final Function<? super Throwable, ? extends ObservableSource<? extends R>> f21947d;

        /* renamed from: e  reason: collision with root package name */
        public final Supplier<? extends ObservableSource<? extends R>> f21948e;

        /* renamed from: f  reason: collision with root package name */
        public Disposable f21949f;

        public MapNotificationObserver(Observer<? super ObservableSource<? extends R>> observer, Function<? super T, ? extends ObservableSource<? extends R>> function, Function<? super Throwable, ? extends ObservableSource<? extends R>> function2, Supplier<? extends ObservableSource<? extends R>> supplier) {
            this.f21945b = observer;
            this.f21946c = function;
            this.f21947d = function2;
            this.f21948e = supplier;
        }

        public void dispose() {
            this.f21949f.dispose();
        }

        public boolean isDisposed() {
            return this.f21949f.isDisposed();
        }

        public void onComplete() {
            try {
                Object obj = this.f21948e.get();
                Objects.requireNonNull(obj, "The onComplete ObservableSource returned is null");
                this.f21945b.onNext((ObservableSource) obj);
                this.f21945b.onComplete();
            } catch (Throwable th2) {
                Exceptions.throwIfFatal(th2);
                this.f21945b.onError(th2);
            }
        }

        public void onError(Throwable th2) {
            try {
                Object apply = this.f21947d.apply(th2);
                Objects.requireNonNull(apply, "The onError ObservableSource returned is null");
                this.f21945b.onNext((ObservableSource) apply);
                this.f21945b.onComplete();
            } catch (Throwable th3) {
                Exceptions.throwIfFatal(th3);
                this.f21945b.onError(new CompositeException(th2, th3));
            }
        }

        public void onNext(T t11) {
            try {
                Object apply = this.f21946c.apply(t11);
                Objects.requireNonNull(apply, "The onNext ObservableSource returned is null");
                this.f21945b.onNext((ObservableSource) apply);
            } catch (Throwable th2) {
                Exceptions.throwIfFatal(th2);
                this.f21945b.onError(th2);
            }
        }

        public void onSubscribe(Disposable disposable) {
            if (DisposableHelper.validate(this.f21949f, disposable)) {
                this.f21949f = disposable;
                this.f21945b.onSubscribe(this);
            }
        }
    }

    public ObservableMapNotification(ObservableSource<T> observableSource, Function<? super T, ? extends ObservableSource<? extends R>> function, Function<? super Throwable, ? extends ObservableSource<? extends R>> function2, Supplier<? extends ObservableSource<? extends R>> supplier) {
        super(observableSource);
        this.f21942c = function;
        this.f21943d = function2;
        this.f21944e = supplier;
    }

    public void subscribeActual(Observer<? super ObservableSource<? extends R>> observer) {
        this.f21304b.subscribe(new MapNotificationObserver(observer, this.f21942c, this.f21943d, this.f21944e));
    }
}
