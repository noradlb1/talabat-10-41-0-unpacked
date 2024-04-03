package io.reactivex.rxjava3.internal.operators.single;

import io.reactivex.rxjava3.core.Single;
import io.reactivex.rxjava3.core.SingleObserver;
import io.reactivex.rxjava3.core.SingleSource;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.internal.disposables.DisposableHelper;
import io.reactivex.rxjava3.internal.observers.ResumeSingleObserver;
import java.util.concurrent.atomic.AtomicReference;

public final class SingleDelayWithSingle<T, U> extends Single<T> {

    /* renamed from: b  reason: collision with root package name */
    public final SingleSource<T> f22796b;

    /* renamed from: c  reason: collision with root package name */
    public final SingleSource<U> f22797c;

    public static final class OtherObserver<T, U> extends AtomicReference<Disposable> implements SingleObserver<U>, Disposable {
        private static final long serialVersionUID = -8565274649390031272L;

        /* renamed from: b  reason: collision with root package name */
        public final SingleObserver<? super T> f22798b;

        /* renamed from: c  reason: collision with root package name */
        public final SingleSource<T> f22799c;

        public OtherObserver(SingleObserver<? super T> singleObserver, SingleSource<T> singleSource) {
            this.f22798b = singleObserver;
            this.f22799c = singleSource;
        }

        public void dispose() {
            DisposableHelper.dispose(this);
        }

        public boolean isDisposed() {
            return DisposableHelper.isDisposed((Disposable) get());
        }

        public void onError(Throwable th2) {
            this.f22798b.onError(th2);
        }

        public void onSubscribe(Disposable disposable) {
            if (DisposableHelper.setOnce(this, disposable)) {
                this.f22798b.onSubscribe(this);
            }
        }

        public void onSuccess(U u11) {
            this.f22799c.subscribe(new ResumeSingleObserver(this, this.f22798b));
        }
    }

    public SingleDelayWithSingle(SingleSource<T> singleSource, SingleSource<U> singleSource2) {
        this.f22796b = singleSource;
        this.f22797c = singleSource2;
    }

    public void subscribeActual(SingleObserver<? super T> singleObserver) {
        this.f22797c.subscribe(new OtherObserver(singleObserver, this.f22796b));
    }
}
