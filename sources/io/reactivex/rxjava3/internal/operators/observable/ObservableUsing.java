package io.reactivex.rxjava3.internal.operators.observable;

import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.core.ObservableSource;
import io.reactivex.rxjava3.core.Observer;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.exceptions.CompositeException;
import io.reactivex.rxjava3.exceptions.Exceptions;
import io.reactivex.rxjava3.functions.Consumer;
import io.reactivex.rxjava3.functions.Function;
import io.reactivex.rxjava3.functions.Supplier;
import io.reactivex.rxjava3.internal.disposables.DisposableHelper;
import io.reactivex.rxjava3.internal.disposables.EmptyDisposable;
import io.reactivex.rxjava3.plugins.RxJavaPlugins;
import java.util.Objects;
import java.util.concurrent.atomic.AtomicBoolean;

public final class ObservableUsing<T, D> extends Observable<T> {

    /* renamed from: b  reason: collision with root package name */
    public final Supplier<? extends D> f22420b;

    /* renamed from: c  reason: collision with root package name */
    public final Function<? super D, ? extends ObservableSource<? extends T>> f22421c;

    /* renamed from: d  reason: collision with root package name */
    public final Consumer<? super D> f22422d;

    /* renamed from: e  reason: collision with root package name */
    public final boolean f22423e;

    public static final class UsingObserver<T, D> extends AtomicBoolean implements Observer<T>, Disposable {
        private static final long serialVersionUID = 5904473792286235046L;

        /* renamed from: b  reason: collision with root package name */
        public final Observer<? super T> f22424b;

        /* renamed from: c  reason: collision with root package name */
        public final D f22425c;

        /* renamed from: d  reason: collision with root package name */
        public final Consumer<? super D> f22426d;

        /* renamed from: e  reason: collision with root package name */
        public final boolean f22427e;

        /* renamed from: f  reason: collision with root package name */
        public Disposable f22428f;

        public UsingObserver(Observer<? super T> observer, D d11, Consumer<? super D> consumer, boolean z11) {
            this.f22424b = observer;
            this.f22425c = d11;
            this.f22426d = consumer;
            this.f22427e = z11;
        }

        public void a() {
            if (compareAndSet(false, true)) {
                try {
                    this.f22426d.accept(this.f22425c);
                } catch (Throwable th2) {
                    Exceptions.throwIfFatal(th2);
                    RxJavaPlugins.onError(th2);
                }
            }
        }

        public void dispose() {
            if (this.f22427e) {
                a();
                this.f22428f.dispose();
                this.f22428f = DisposableHelper.DISPOSED;
                return;
            }
            this.f22428f.dispose();
            this.f22428f = DisposableHelper.DISPOSED;
            a();
        }

        public boolean isDisposed() {
            return get();
        }

        public void onComplete() {
            if (this.f22427e) {
                if (compareAndSet(false, true)) {
                    try {
                        this.f22426d.accept(this.f22425c);
                    } catch (Throwable th2) {
                        Exceptions.throwIfFatal(th2);
                        this.f22424b.onError(th2);
                        return;
                    }
                }
                this.f22424b.onComplete();
                return;
            }
            this.f22424b.onComplete();
            a();
        }

        public void onError(Throwable th2) {
            if (this.f22427e) {
                if (compareAndSet(false, true)) {
                    try {
                        this.f22426d.accept(this.f22425c);
                    } catch (Throwable th3) {
                        Exceptions.throwIfFatal(th3);
                        th2 = new CompositeException(th2, th3);
                    }
                }
                this.f22424b.onError(th2);
                return;
            }
            this.f22424b.onError(th2);
            a();
        }

        public void onNext(T t11) {
            this.f22424b.onNext(t11);
        }

        public void onSubscribe(Disposable disposable) {
            if (DisposableHelper.validate(this.f22428f, disposable)) {
                this.f22428f = disposable;
                this.f22424b.onSubscribe(this);
            }
        }
    }

    public ObservableUsing(Supplier<? extends D> supplier, Function<? super D, ? extends ObservableSource<? extends T>> function, Consumer<? super D> consumer, boolean z11) {
        this.f22420b = supplier;
        this.f22421c = function;
        this.f22422d = consumer;
        this.f22423e = z11;
    }

    public void subscribeActual(Observer<? super T> observer) {
        try {
            Object obj = this.f22420b.get();
            try {
                Object apply = this.f22421c.apply(obj);
                Objects.requireNonNull(apply, "The sourceSupplier returned a null ObservableSource");
                ((ObservableSource) apply).subscribe(new UsingObserver(observer, obj, this.f22422d, this.f22423e));
            } catch (Throwable th2) {
                Exceptions.throwIfFatal(th2);
                EmptyDisposable.error((Throwable) new CompositeException(th, th2), (Observer<?>) observer);
            }
        } catch (Throwable th3) {
            Exceptions.throwIfFatal(th3);
            EmptyDisposable.error(th3, (Observer<?>) observer);
        }
    }
}
