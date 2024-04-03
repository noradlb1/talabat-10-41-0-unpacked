package io.reactivex.internal.operators.maybe;

import io.reactivex.MaybeObserver;
import io.reactivex.MaybeSource;
import io.reactivex.Single;
import io.reactivex.SingleObserver;
import io.reactivex.disposables.Disposable;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.functions.BiPredicate;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.plugins.RxJavaPlugins;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;

public final class MaybeEqualSingle<T> extends Single<Boolean> {

    /* renamed from: b  reason: collision with root package name */
    public final MaybeSource<? extends T> f16359b;

    /* renamed from: c  reason: collision with root package name */
    public final MaybeSource<? extends T> f16360c;

    /* renamed from: d  reason: collision with root package name */
    public final BiPredicate<? super T, ? super T> f16361d;

    public static final class EqualCoordinator<T> extends AtomicInteger implements Disposable {

        /* renamed from: b  reason: collision with root package name */
        public final SingleObserver<? super Boolean> f16362b;

        /* renamed from: c  reason: collision with root package name */
        public final EqualObserver<T> f16363c = new EqualObserver<>(this);

        /* renamed from: d  reason: collision with root package name */
        public final EqualObserver<T> f16364d = new EqualObserver<>(this);

        /* renamed from: e  reason: collision with root package name */
        public final BiPredicate<? super T, ? super T> f16365e;

        public EqualCoordinator(SingleObserver<? super Boolean> singleObserver, BiPredicate<? super T, ? super T> biPredicate) {
            super(2);
            this.f16362b = singleObserver;
            this.f16365e = biPredicate;
        }

        public void a() {
            boolean z11;
            if (decrementAndGet() == 0) {
                Object obj = this.f16363c.f16367c;
                Object obj2 = this.f16364d.f16367c;
                if (obj == null || obj2 == null) {
                    SingleObserver<? super Boolean> singleObserver = this.f16362b;
                    if (obj == null && obj2 == null) {
                        z11 = true;
                    } else {
                        z11 = false;
                    }
                    singleObserver.onSuccess(Boolean.valueOf(z11));
                    return;
                }
                try {
                    this.f16362b.onSuccess(Boolean.valueOf(this.f16365e.test(obj, obj2)));
                } catch (Throwable th2) {
                    Exceptions.throwIfFatal(th2);
                    this.f16362b.onError(th2);
                }
            }
        }

        public void b(EqualObserver<T> equalObserver, Throwable th2) {
            if (getAndSet(0) > 0) {
                EqualObserver<T> equalObserver2 = this.f16363c;
                if (equalObserver == equalObserver2) {
                    this.f16364d.dispose();
                } else {
                    equalObserver2.dispose();
                }
                this.f16362b.onError(th2);
                return;
            }
            RxJavaPlugins.onError(th2);
        }

        public void c(MaybeSource<? extends T> maybeSource, MaybeSource<? extends T> maybeSource2) {
            maybeSource.subscribe(this.f16363c);
            maybeSource2.subscribe(this.f16364d);
        }

        public void dispose() {
            this.f16363c.dispose();
            this.f16364d.dispose();
        }

        public boolean isDisposed() {
            return DisposableHelper.isDisposed((Disposable) this.f16363c.get());
        }
    }

    public static final class EqualObserver<T> extends AtomicReference<Disposable> implements MaybeObserver<T> {
        private static final long serialVersionUID = -3031974433025990931L;

        /* renamed from: b  reason: collision with root package name */
        public final EqualCoordinator<T> f16366b;

        /* renamed from: c  reason: collision with root package name */
        public Object f16367c;

        public EqualObserver(EqualCoordinator<T> equalCoordinator) {
            this.f16366b = equalCoordinator;
        }

        public void dispose() {
            DisposableHelper.dispose(this);
        }

        public void onComplete() {
            this.f16366b.a();
        }

        public void onError(Throwable th2) {
            this.f16366b.b(this, th2);
        }

        public void onSubscribe(Disposable disposable) {
            DisposableHelper.setOnce(this, disposable);
        }

        public void onSuccess(T t11) {
            this.f16367c = t11;
            this.f16366b.a();
        }
    }

    public MaybeEqualSingle(MaybeSource<? extends T> maybeSource, MaybeSource<? extends T> maybeSource2, BiPredicate<? super T, ? super T> biPredicate) {
        this.f16359b = maybeSource;
        this.f16360c = maybeSource2;
        this.f16361d = biPredicate;
    }

    public void subscribeActual(SingleObserver<? super Boolean> singleObserver) {
        EqualCoordinator equalCoordinator = new EqualCoordinator(singleObserver, this.f16361d);
        singleObserver.onSubscribe(equalCoordinator);
        equalCoordinator.c(this.f16359b, this.f16360c);
    }
}
