package io.reactivex.internal.operators.observable;

import io.reactivex.ObservableSource;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.BiConsumer;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.disposables.EmptyDisposable;
import io.reactivex.internal.functions.ObjectHelper;
import io.reactivex.plugins.RxJavaPlugins;
import java.util.concurrent.Callable;

public final class ObservableCollect<T, U> extends AbstractObservableWithUpstream<T, U> {

    /* renamed from: c  reason: collision with root package name */
    public final Callable<? extends U> f16957c;

    /* renamed from: d  reason: collision with root package name */
    public final BiConsumer<? super U, ? super T> f16958d;

    public static final class CollectObserver<T, U> implements Observer<T>, Disposable {

        /* renamed from: b  reason: collision with root package name */
        public final Observer<? super U> f16959b;

        /* renamed from: c  reason: collision with root package name */
        public final BiConsumer<? super U, ? super T> f16960c;

        /* renamed from: d  reason: collision with root package name */
        public final U f16961d;

        /* renamed from: e  reason: collision with root package name */
        public Disposable f16962e;

        /* renamed from: f  reason: collision with root package name */
        public boolean f16963f;

        public CollectObserver(Observer<? super U> observer, U u11, BiConsumer<? super U, ? super T> biConsumer) {
            this.f16959b = observer;
            this.f16960c = biConsumer;
            this.f16961d = u11;
        }

        public void dispose() {
            this.f16962e.dispose();
        }

        public boolean isDisposed() {
            return this.f16962e.isDisposed();
        }

        public void onComplete() {
            if (!this.f16963f) {
                this.f16963f = true;
                this.f16959b.onNext(this.f16961d);
                this.f16959b.onComplete();
            }
        }

        public void onError(Throwable th2) {
            if (this.f16963f) {
                RxJavaPlugins.onError(th2);
                return;
            }
            this.f16963f = true;
            this.f16959b.onError(th2);
        }

        public void onNext(T t11) {
            if (!this.f16963f) {
                try {
                    this.f16960c.accept(this.f16961d, t11);
                } catch (Throwable th2) {
                    this.f16962e.dispose();
                    onError(th2);
                }
            }
        }

        public void onSubscribe(Disposable disposable) {
            if (DisposableHelper.validate(this.f16962e, disposable)) {
                this.f16962e = disposable;
                this.f16959b.onSubscribe(this);
            }
        }
    }

    public ObservableCollect(ObservableSource<T> observableSource, Callable<? extends U> callable, BiConsumer<? super U, ? super T> biConsumer) {
        super(observableSource);
        this.f16957c = callable;
        this.f16958d = biConsumer;
    }

    public void subscribeActual(Observer<? super U> observer) {
        try {
            this.f16799b.subscribe(new CollectObserver(observer, ObjectHelper.requireNonNull(this.f16957c.call(), "The initialSupplier returned a null value"), this.f16958d));
        } catch (Throwable th2) {
            EmptyDisposable.error(th2, (Observer<?>) observer);
        }
    }
}
