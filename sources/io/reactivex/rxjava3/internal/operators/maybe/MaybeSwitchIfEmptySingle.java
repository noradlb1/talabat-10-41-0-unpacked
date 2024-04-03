package io.reactivex.rxjava3.internal.operators.maybe;

import io.reactivex.rxjava3.core.MaybeObserver;
import io.reactivex.rxjava3.core.MaybeSource;
import io.reactivex.rxjava3.core.Single;
import io.reactivex.rxjava3.core.SingleObserver;
import io.reactivex.rxjava3.core.SingleSource;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.internal.disposables.DisposableHelper;
import io.reactivex.rxjava3.internal.fuseable.HasUpstreamMaybeSource;
import java.util.concurrent.atomic.AtomicReference;

public final class MaybeSwitchIfEmptySingle<T> extends Single<T> implements HasUpstreamMaybeSource<T> {

    /* renamed from: b  reason: collision with root package name */
    public final MaybeSource<T> f21021b;

    /* renamed from: c  reason: collision with root package name */
    public final SingleSource<? extends T> f21022c;

    public static final class SwitchIfEmptyMaybeObserver<T> extends AtomicReference<Disposable> implements MaybeObserver<T>, Disposable {
        private static final long serialVersionUID = 4603919676453758899L;

        /* renamed from: b  reason: collision with root package name */
        public final SingleObserver<? super T> f21023b;

        /* renamed from: c  reason: collision with root package name */
        public final SingleSource<? extends T> f21024c;

        public static final class OtherSingleObserver<T> implements SingleObserver<T> {

            /* renamed from: b  reason: collision with root package name */
            public final SingleObserver<? super T> f21025b;

            /* renamed from: c  reason: collision with root package name */
            public final AtomicReference<Disposable> f21026c;

            public OtherSingleObserver(SingleObserver<? super T> singleObserver, AtomicReference<Disposable> atomicReference) {
                this.f21025b = singleObserver;
                this.f21026c = atomicReference;
            }

            public void onError(Throwable th2) {
                this.f21025b.onError(th2);
            }

            public void onSubscribe(Disposable disposable) {
                DisposableHelper.setOnce(this.f21026c, disposable);
            }

            public void onSuccess(T t11) {
                this.f21025b.onSuccess(t11);
            }
        }

        public SwitchIfEmptyMaybeObserver(SingleObserver<? super T> singleObserver, SingleSource<? extends T> singleSource) {
            this.f21023b = singleObserver;
            this.f21024c = singleSource;
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
                this.f21024c.subscribe(new OtherSingleObserver(this.f21023b, this));
            }
        }

        public void onError(Throwable th2) {
            this.f21023b.onError(th2);
        }

        public void onSubscribe(Disposable disposable) {
            if (DisposableHelper.setOnce(this, disposable)) {
                this.f21023b.onSubscribe(this);
            }
        }

        public void onSuccess(T t11) {
            this.f21023b.onSuccess(t11);
        }
    }

    public MaybeSwitchIfEmptySingle(MaybeSource<T> maybeSource, SingleSource<? extends T> singleSource) {
        this.f21021b = maybeSource;
        this.f21022c = singleSource;
    }

    public MaybeSource<T> source() {
        return this.f21021b;
    }

    public void subscribeActual(SingleObserver<? super T> singleObserver) {
        this.f21021b.subscribe(new SwitchIfEmptyMaybeObserver(singleObserver, this.f21022c));
    }
}
