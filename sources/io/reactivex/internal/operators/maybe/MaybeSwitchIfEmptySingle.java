package io.reactivex.internal.operators.maybe;

import io.reactivex.MaybeObserver;
import io.reactivex.MaybeSource;
import io.reactivex.Single;
import io.reactivex.SingleObserver;
import io.reactivex.SingleSource;
import io.reactivex.disposables.Disposable;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.fuseable.HasUpstreamMaybeSource;
import java.util.concurrent.atomic.AtomicReference;

public final class MaybeSwitchIfEmptySingle<T> extends Single<T> implements HasUpstreamMaybeSource<T> {

    /* renamed from: b  reason: collision with root package name */
    public final MaybeSource<T> f16517b;

    /* renamed from: c  reason: collision with root package name */
    public final SingleSource<? extends T> f16518c;

    public static final class SwitchIfEmptyMaybeObserver<T> extends AtomicReference<Disposable> implements MaybeObserver<T>, Disposable {
        private static final long serialVersionUID = 4603919676453758899L;

        /* renamed from: b  reason: collision with root package name */
        public final SingleObserver<? super T> f16519b;

        /* renamed from: c  reason: collision with root package name */
        public final SingleSource<? extends T> f16520c;

        public static final class OtherSingleObserver<T> implements SingleObserver<T> {

            /* renamed from: b  reason: collision with root package name */
            public final SingleObserver<? super T> f16521b;

            /* renamed from: c  reason: collision with root package name */
            public final AtomicReference<Disposable> f16522c;

            public OtherSingleObserver(SingleObserver<? super T> singleObserver, AtomicReference<Disposable> atomicReference) {
                this.f16521b = singleObserver;
                this.f16522c = atomicReference;
            }

            public void onError(Throwable th2) {
                this.f16521b.onError(th2);
            }

            public void onSubscribe(Disposable disposable) {
                DisposableHelper.setOnce(this.f16522c, disposable);
            }

            public void onSuccess(T t11) {
                this.f16521b.onSuccess(t11);
            }
        }

        public SwitchIfEmptyMaybeObserver(SingleObserver<? super T> singleObserver, SingleSource<? extends T> singleSource) {
            this.f16519b = singleObserver;
            this.f16520c = singleSource;
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
                this.f16520c.subscribe(new OtherSingleObserver(this.f16519b, this));
            }
        }

        public void onError(Throwable th2) {
            this.f16519b.onError(th2);
        }

        public void onSubscribe(Disposable disposable) {
            if (DisposableHelper.setOnce(this, disposable)) {
                this.f16519b.onSubscribe(this);
            }
        }

        public void onSuccess(T t11) {
            this.f16519b.onSuccess(t11);
        }
    }

    public MaybeSwitchIfEmptySingle(MaybeSource<T> maybeSource, SingleSource<? extends T> singleSource) {
        this.f16517b = maybeSource;
        this.f16518c = singleSource;
    }

    public MaybeSource<T> source() {
        return this.f16517b;
    }

    public void subscribeActual(SingleObserver<? super T> singleObserver) {
        this.f16517b.subscribe(new SwitchIfEmptyMaybeObserver(singleObserver, this.f16518c));
    }
}
