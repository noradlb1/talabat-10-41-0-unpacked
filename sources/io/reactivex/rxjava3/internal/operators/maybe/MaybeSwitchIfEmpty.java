package io.reactivex.rxjava3.internal.operators.maybe;

import io.reactivex.rxjava3.core.MaybeObserver;
import io.reactivex.rxjava3.core.MaybeSource;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.internal.disposables.DisposableHelper;
import java.util.concurrent.atomic.AtomicReference;

public final class MaybeSwitchIfEmpty<T> extends AbstractMaybeWithUpstream<T, T> {

    /* renamed from: c  reason: collision with root package name */
    public final MaybeSource<? extends T> f21016c;

    public static final class SwitchIfEmptyMaybeObserver<T> extends AtomicReference<Disposable> implements MaybeObserver<T>, Disposable {
        private static final long serialVersionUID = -2223459372976438024L;

        /* renamed from: b  reason: collision with root package name */
        public final MaybeObserver<? super T> f21017b;

        /* renamed from: c  reason: collision with root package name */
        public final MaybeSource<? extends T> f21018c;

        public static final class OtherMaybeObserver<T> implements MaybeObserver<T> {

            /* renamed from: b  reason: collision with root package name */
            public final MaybeObserver<? super T> f21019b;

            /* renamed from: c  reason: collision with root package name */
            public final AtomicReference<Disposable> f21020c;

            public OtherMaybeObserver(MaybeObserver<? super T> maybeObserver, AtomicReference<Disposable> atomicReference) {
                this.f21019b = maybeObserver;
                this.f21020c = atomicReference;
            }

            public void onComplete() {
                this.f21019b.onComplete();
            }

            public void onError(Throwable th2) {
                this.f21019b.onError(th2);
            }

            public void onSubscribe(Disposable disposable) {
                DisposableHelper.setOnce(this.f21020c, disposable);
            }

            public void onSuccess(T t11) {
                this.f21019b.onSuccess(t11);
            }
        }

        public SwitchIfEmptyMaybeObserver(MaybeObserver<? super T> maybeObserver, MaybeSource<? extends T> maybeSource) {
            this.f21017b = maybeObserver;
            this.f21018c = maybeSource;
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
                this.f21018c.subscribe(new OtherMaybeObserver(this.f21017b, this));
            }
        }

        public void onError(Throwable th2) {
            this.f21017b.onError(th2);
        }

        public void onSubscribe(Disposable disposable) {
            if (DisposableHelper.setOnce(this, disposable)) {
                this.f21017b.onSubscribe(this);
            }
        }

        public void onSuccess(T t11) {
            this.f21017b.onSuccess(t11);
        }
    }

    public MaybeSwitchIfEmpty(MaybeSource<T> maybeSource, MaybeSource<? extends T> maybeSource2) {
        super(maybeSource);
        this.f21016c = maybeSource2;
    }

    public void subscribeActual(MaybeObserver<? super T> maybeObserver) {
        this.f20763b.subscribe(new SwitchIfEmptyMaybeObserver(maybeObserver, this.f21016c));
    }
}
