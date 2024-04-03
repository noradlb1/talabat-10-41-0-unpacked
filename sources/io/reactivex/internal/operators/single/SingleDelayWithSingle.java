package io.reactivex.internal.operators.single;

import io.reactivex.Single;
import io.reactivex.SingleObserver;
import io.reactivex.SingleSource;
import io.reactivex.disposables.Disposable;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.observers.ResumeSingleObserver;
import java.util.concurrent.atomic.AtomicReference;

public final class SingleDelayWithSingle<T, U> extends Single<T> {

    /* renamed from: b  reason: collision with root package name */
    public final SingleSource<T> f18262b;

    /* renamed from: c  reason: collision with root package name */
    public final SingleSource<U> f18263c;

    public static final class OtherObserver<T, U> extends AtomicReference<Disposable> implements SingleObserver<U>, Disposable {
        private static final long serialVersionUID = -8565274649390031272L;

        /* renamed from: b  reason: collision with root package name */
        public final SingleObserver<? super T> f18264b;

        /* renamed from: c  reason: collision with root package name */
        public final SingleSource<T> f18265c;

        public OtherObserver(SingleObserver<? super T> singleObserver, SingleSource<T> singleSource) {
            this.f18264b = singleObserver;
            this.f18265c = singleSource;
        }

        public void dispose() {
            DisposableHelper.dispose(this);
        }

        public boolean isDisposed() {
            return DisposableHelper.isDisposed((Disposable) get());
        }

        public void onError(Throwable th2) {
            this.f18264b.onError(th2);
        }

        public void onSubscribe(Disposable disposable) {
            if (DisposableHelper.setOnce(this, disposable)) {
                this.f18264b.onSubscribe(this);
            }
        }

        public void onSuccess(U u11) {
            this.f18265c.subscribe(new ResumeSingleObserver(this, this.f18264b));
        }
    }

    public SingleDelayWithSingle(SingleSource<T> singleSource, SingleSource<U> singleSource2) {
        this.f18262b = singleSource;
        this.f18263c = singleSource2;
    }

    public void subscribeActual(SingleObserver<? super T> singleObserver) {
        this.f18263c.subscribe(new OtherObserver(singleObserver, this.f18262b));
    }
}
