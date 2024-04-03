package io.reactivex.internal.operators.maybe;

import io.reactivex.MaybeObserver;
import io.reactivex.MaybeSource;
import io.reactivex.disposables.Disposable;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.plugins.RxJavaPlugins;
import java.util.concurrent.atomic.AtomicReference;

public final class MaybeTakeUntilMaybe<T, U> extends AbstractMaybeWithUpstream<T, T> {

    /* renamed from: c  reason: collision with root package name */
    public final MaybeSource<U> f16523c;

    public static final class TakeUntilMainMaybeObserver<T, U> extends AtomicReference<Disposable> implements MaybeObserver<T>, Disposable {
        private static final long serialVersionUID = -2187421758664251153L;

        /* renamed from: b  reason: collision with root package name */
        public final MaybeObserver<? super T> f16524b;

        /* renamed from: c  reason: collision with root package name */
        public final TakeUntilOtherMaybeObserver<U> f16525c = new TakeUntilOtherMaybeObserver<>(this);

        public static final class TakeUntilOtherMaybeObserver<U> extends AtomicReference<Disposable> implements MaybeObserver<U> {
            private static final long serialVersionUID = -1266041316834525931L;

            /* renamed from: b  reason: collision with root package name */
            public final TakeUntilMainMaybeObserver<?, U> f16526b;

            public TakeUntilOtherMaybeObserver(TakeUntilMainMaybeObserver<?, U> takeUntilMainMaybeObserver) {
                this.f16526b = takeUntilMainMaybeObserver;
            }

            public void onComplete() {
                this.f16526b.a();
            }

            public void onError(Throwable th2) {
                this.f16526b.b(th2);
            }

            public void onSubscribe(Disposable disposable) {
                DisposableHelper.setOnce(this, disposable);
            }

            public void onSuccess(Object obj) {
                this.f16526b.a();
            }
        }

        public TakeUntilMainMaybeObserver(MaybeObserver<? super T> maybeObserver) {
            this.f16524b = maybeObserver;
        }

        public void a() {
            if (DisposableHelper.dispose(this)) {
                this.f16524b.onComplete();
            }
        }

        public void b(Throwable th2) {
            if (DisposableHelper.dispose(this)) {
                this.f16524b.onError(th2);
            } else {
                RxJavaPlugins.onError(th2);
            }
        }

        public void dispose() {
            DisposableHelper.dispose(this);
            DisposableHelper.dispose(this.f16525c);
        }

        public boolean isDisposed() {
            return DisposableHelper.isDisposed((Disposable) get());
        }

        public void onComplete() {
            DisposableHelper.dispose(this.f16525c);
            DisposableHelper disposableHelper = DisposableHelper.DISPOSED;
            if (getAndSet(disposableHelper) != disposableHelper) {
                this.f16524b.onComplete();
            }
        }

        public void onError(Throwable th2) {
            DisposableHelper.dispose(this.f16525c);
            DisposableHelper disposableHelper = DisposableHelper.DISPOSED;
            if (getAndSet(disposableHelper) != disposableHelper) {
                this.f16524b.onError(th2);
            } else {
                RxJavaPlugins.onError(th2);
            }
        }

        public void onSubscribe(Disposable disposable) {
            DisposableHelper.setOnce(this, disposable);
        }

        public void onSuccess(T t11) {
            DisposableHelper.dispose(this.f16525c);
            DisposableHelper disposableHelper = DisposableHelper.DISPOSED;
            if (getAndSet(disposableHelper) != disposableHelper) {
                this.f16524b.onSuccess(t11);
            }
        }
    }

    public MaybeTakeUntilMaybe(MaybeSource<T> maybeSource, MaybeSource<U> maybeSource2) {
        super(maybeSource);
        this.f16523c = maybeSource2;
    }

    public void subscribeActual(MaybeObserver<? super T> maybeObserver) {
        TakeUntilMainMaybeObserver takeUntilMainMaybeObserver = new TakeUntilMainMaybeObserver(maybeObserver);
        maybeObserver.onSubscribe(takeUntilMainMaybeObserver);
        this.f16523c.subscribe(takeUntilMainMaybeObserver.f16525c);
        this.f16264b.subscribe(takeUntilMainMaybeObserver);
    }
}
