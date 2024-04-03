package io.reactivex.rxjava3.internal.operators.observable;

import io.reactivex.rxjava3.core.ObservableSource;
import io.reactivex.rxjava3.core.Observer;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.exceptions.Exceptions;
import io.reactivex.rxjava3.functions.BiConsumer;
import io.reactivex.rxjava3.functions.Supplier;
import io.reactivex.rxjava3.internal.disposables.DisposableHelper;
import io.reactivex.rxjava3.internal.disposables.EmptyDisposable;
import io.reactivex.rxjava3.plugins.RxJavaPlugins;
import java.util.Objects;

public final class ObservableCollect<T, U> extends AbstractObservableWithUpstream<T, U> {

    /* renamed from: c  reason: collision with root package name */
    public final Supplier<? extends U> f21453c;

    /* renamed from: d  reason: collision with root package name */
    public final BiConsumer<? super U, ? super T> f21454d;

    public static final class CollectObserver<T, U> implements Observer<T>, Disposable {

        /* renamed from: b  reason: collision with root package name */
        public final Observer<? super U> f21455b;

        /* renamed from: c  reason: collision with root package name */
        public final BiConsumer<? super U, ? super T> f21456c;

        /* renamed from: d  reason: collision with root package name */
        public final U f21457d;

        /* renamed from: e  reason: collision with root package name */
        public Disposable f21458e;

        /* renamed from: f  reason: collision with root package name */
        public boolean f21459f;

        public CollectObserver(Observer<? super U> observer, U u11, BiConsumer<? super U, ? super T> biConsumer) {
            this.f21455b = observer;
            this.f21456c = biConsumer;
            this.f21457d = u11;
        }

        public void dispose() {
            this.f21458e.dispose();
        }

        public boolean isDisposed() {
            return this.f21458e.isDisposed();
        }

        public void onComplete() {
            if (!this.f21459f) {
                this.f21459f = true;
                this.f21455b.onNext(this.f21457d);
                this.f21455b.onComplete();
            }
        }

        public void onError(Throwable th2) {
            if (this.f21459f) {
                RxJavaPlugins.onError(th2);
                return;
            }
            this.f21459f = true;
            this.f21455b.onError(th2);
        }

        public void onNext(T t11) {
            if (!this.f21459f) {
                try {
                    this.f21456c.accept(this.f21457d, t11);
                } catch (Throwable th2) {
                    Exceptions.throwIfFatal(th2);
                    this.f21458e.dispose();
                    onError(th2);
                }
            }
        }

        public void onSubscribe(Disposable disposable) {
            if (DisposableHelper.validate(this.f21458e, disposable)) {
                this.f21458e = disposable;
                this.f21455b.onSubscribe(this);
            }
        }
    }

    public ObservableCollect(ObservableSource<T> observableSource, Supplier<? extends U> supplier, BiConsumer<? super U, ? super T> biConsumer) {
        super(observableSource);
        this.f21453c = supplier;
        this.f21454d = biConsumer;
    }

    public void subscribeActual(Observer<? super U> observer) {
        try {
            Object obj = this.f21453c.get();
            Objects.requireNonNull(obj, "The initialSupplier returned a null value");
            this.f21304b.subscribe(new CollectObserver(observer, obj, this.f21454d));
        } catch (Throwable th2) {
            Exceptions.throwIfFatal(th2);
            EmptyDisposable.error(th2, (Observer<?>) observer);
        }
    }
}
