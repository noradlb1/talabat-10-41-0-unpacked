package io.reactivex.internal.operators.maybe;

import io.reactivex.MaybeObserver;
import io.reactivex.MaybeSource;
import io.reactivex.disposables.Disposable;
import io.reactivex.internal.disposables.DisposableHelper;
import java.util.concurrent.atomic.AtomicReference;

public final class MaybeSwitchIfEmpty<T> extends AbstractMaybeWithUpstream<T, T> {

    /* renamed from: c  reason: collision with root package name */
    public final MaybeSource<? extends T> f16512c;

    public static final class SwitchIfEmptyMaybeObserver<T> extends AtomicReference<Disposable> implements MaybeObserver<T>, Disposable {
        private static final long serialVersionUID = -2223459372976438024L;

        /* renamed from: b  reason: collision with root package name */
        public final MaybeObserver<? super T> f16513b;

        /* renamed from: c  reason: collision with root package name */
        public final MaybeSource<? extends T> f16514c;

        public static final class OtherMaybeObserver<T> implements MaybeObserver<T> {

            /* renamed from: b  reason: collision with root package name */
            public final MaybeObserver<? super T> f16515b;

            /* renamed from: c  reason: collision with root package name */
            public final AtomicReference<Disposable> f16516c;

            public OtherMaybeObserver(MaybeObserver<? super T> maybeObserver, AtomicReference<Disposable> atomicReference) {
                this.f16515b = maybeObserver;
                this.f16516c = atomicReference;
            }

            public void onComplete() {
                this.f16515b.onComplete();
            }

            public void onError(Throwable th2) {
                this.f16515b.onError(th2);
            }

            public void onSubscribe(Disposable disposable) {
                DisposableHelper.setOnce(this.f16516c, disposable);
            }

            public void onSuccess(T t11) {
                this.f16515b.onSuccess(t11);
            }
        }

        public SwitchIfEmptyMaybeObserver(MaybeObserver<? super T> maybeObserver, MaybeSource<? extends T> maybeSource) {
            this.f16513b = maybeObserver;
            this.f16514c = maybeSource;
        }

        public void dispose() {
            DisposableHelper.dispose(this);
        }

        public boolean isDisposed() {
            return DisposableHelper.isDisposed((Disposable) get());
        }

        public void onComplete() {
            Disposable disposable = (Disposable) get();
            if (disposable != DisposableHelper.DISPOSED && compareAndSet(disposable, (Object) null)) {
                this.f16514c.subscribe(new OtherMaybeObserver(this.f16513b, this));
            }
        }

        public void onError(Throwable th2) {
            this.f16513b.onError(th2);
        }

        public void onSubscribe(Disposable disposable) {
            if (DisposableHelper.setOnce(this, disposable)) {
                this.f16513b.onSubscribe(this);
            }
        }

        public void onSuccess(T t11) {
            this.f16513b.onSuccess(t11);
        }
    }

    public MaybeSwitchIfEmpty(MaybeSource<T> maybeSource, MaybeSource<? extends T> maybeSource2) {
        super(maybeSource);
        this.f16512c = maybeSource2;
    }

    public void subscribeActual(MaybeObserver<? super T> maybeObserver) {
        this.f16264b.subscribe(new SwitchIfEmptyMaybeObserver(maybeObserver, this.f16512c));
    }
}
