package io.reactivex.rxjava3.internal.operators.maybe;

import io.reactivex.rxjava3.core.MaybeObserver;
import io.reactivex.rxjava3.core.MaybeSource;
import io.reactivex.rxjava3.core.Single;
import io.reactivex.rxjava3.core.SingleObserver;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.exceptions.Exceptions;
import io.reactivex.rxjava3.functions.BiPredicate;
import io.reactivex.rxjava3.internal.disposables.DisposableHelper;
import io.reactivex.rxjava3.plugins.RxJavaPlugins;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;

public final class MaybeEqualSingle<T> extends Single<Boolean> {

    /* renamed from: b  reason: collision with root package name */
    public final MaybeSource<? extends T> f20870b;

    /* renamed from: c  reason: collision with root package name */
    public final MaybeSource<? extends T> f20871c;

    /* renamed from: d  reason: collision with root package name */
    public final BiPredicate<? super T, ? super T> f20872d;

    public static final class EqualCoordinator<T> extends AtomicInteger implements Disposable {

        /* renamed from: b  reason: collision with root package name */
        public final SingleObserver<? super Boolean> f20873b;

        /* renamed from: c  reason: collision with root package name */
        public final EqualObserver<T> f20874c = new EqualObserver<>(this);

        /* renamed from: d  reason: collision with root package name */
        public final EqualObserver<T> f20875d = new EqualObserver<>(this);

        /* renamed from: e  reason: collision with root package name */
        public final BiPredicate<? super T, ? super T> f20876e;

        public EqualCoordinator(SingleObserver<? super Boolean> singleObserver, BiPredicate<? super T, ? super T> biPredicate) {
            super(2);
            this.f20873b = singleObserver;
            this.f20876e = biPredicate;
        }

        public void a() {
            boolean z11;
            if (decrementAndGet() == 0) {
                Object obj = this.f20874c.f20878c;
                Object obj2 = this.f20875d.f20878c;
                if (obj == null || obj2 == null) {
                    SingleObserver<? super Boolean> singleObserver = this.f20873b;
                    if (obj == null && obj2 == null) {
                        z11 = true;
                    } else {
                        z11 = false;
                    }
                    singleObserver.onSuccess(Boolean.valueOf(z11));
                    return;
                }
                try {
                    this.f20873b.onSuccess(Boolean.valueOf(this.f20876e.test(obj, obj2)));
                } catch (Throwable th2) {
                    Exceptions.throwIfFatal(th2);
                    this.f20873b.onError(th2);
                }
            }
        }

        public void b(EqualObserver<T> equalObserver, Throwable th2) {
            if (getAndSet(0) > 0) {
                EqualObserver<T> equalObserver2 = this.f20874c;
                if (equalObserver == equalObserver2) {
                    this.f20875d.dispose();
                } else {
                    equalObserver2.dispose();
                }
                this.f20873b.onError(th2);
                return;
            }
            RxJavaPlugins.onError(th2);
        }

        public void c(MaybeSource<? extends T> maybeSource, MaybeSource<? extends T> maybeSource2) {
            maybeSource.subscribe(this.f20874c);
            maybeSource2.subscribe(this.f20875d);
        }

        public void dispose() {
            this.f20874c.dispose();
            this.f20875d.dispose();
        }

        public boolean isDisposed() {
            return DisposableHelper.isDisposed((Disposable) this.f20874c.get());
        }
    }

    public static final class EqualObserver<T> extends AtomicReference<Disposable> implements MaybeObserver<T> {
        private static final long serialVersionUID = -3031974433025990931L;

        /* renamed from: b  reason: collision with root package name */
        public final EqualCoordinator<T> f20877b;

        /* renamed from: c  reason: collision with root package name */
        public Object f20878c;

        public EqualObserver(EqualCoordinator<T> equalCoordinator) {
            this.f20877b = equalCoordinator;
        }

        public void dispose() {
            DisposableHelper.dispose(this);
        }

        public void onComplete() {
            this.f20877b.a();
        }

        public void onError(Throwable th2) {
            this.f20877b.b(this, th2);
        }

        public void onSubscribe(Disposable disposable) {
            DisposableHelper.setOnce(this, disposable);
        }

        public void onSuccess(T t11) {
            this.f20878c = t11;
            this.f20877b.a();
        }
    }

    public MaybeEqualSingle(MaybeSource<? extends T> maybeSource, MaybeSource<? extends T> maybeSource2, BiPredicate<? super T, ? super T> biPredicate) {
        this.f20870b = maybeSource;
        this.f20871c = maybeSource2;
        this.f20872d = biPredicate;
    }

    public void subscribeActual(SingleObserver<? super Boolean> singleObserver) {
        EqualCoordinator equalCoordinator = new EqualCoordinator(singleObserver, this.f20872d);
        singleObserver.onSubscribe(equalCoordinator);
        equalCoordinator.c(this.f20870b, this.f20871c);
    }
}
