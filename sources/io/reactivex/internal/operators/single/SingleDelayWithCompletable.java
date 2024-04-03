package io.reactivex.internal.operators.single;

import io.reactivex.CompletableObserver;
import io.reactivex.CompletableSource;
import io.reactivex.Single;
import io.reactivex.SingleObserver;
import io.reactivex.SingleSource;
import io.reactivex.disposables.Disposable;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.observers.ResumeSingleObserver;
import java.util.concurrent.atomic.AtomicReference;

public final class SingleDelayWithCompletable<T> extends Single<T> {

    /* renamed from: b  reason: collision with root package name */
    public final SingleSource<T> f18247b;

    /* renamed from: c  reason: collision with root package name */
    public final CompletableSource f18248c;

    public static final class OtherObserver<T> extends AtomicReference<Disposable> implements CompletableObserver, Disposable {
        private static final long serialVersionUID = -8565274649390031272L;

        /* renamed from: b  reason: collision with root package name */
        public final SingleObserver<? super T> f18249b;

        /* renamed from: c  reason: collision with root package name */
        public final SingleSource<T> f18250c;

        public OtherObserver(SingleObserver<? super T> singleObserver, SingleSource<T> singleSource) {
            this.f18249b = singleObserver;
            this.f18250c = singleSource;
        }

        public void dispose() {
            DisposableHelper.dispose(this);
        }

        public boolean isDisposed() {
            return DisposableHelper.isDisposed((Disposable) get());
        }

        public void onComplete() {
            this.f18250c.subscribe(new ResumeSingleObserver(this, this.f18249b));
        }

        public void onError(Throwable th2) {
            this.f18249b.onError(th2);
        }

        public void onSubscribe(Disposable disposable) {
            if (DisposableHelper.setOnce(this, disposable)) {
                this.f18249b.onSubscribe(this);
            }
        }
    }

    public SingleDelayWithCompletable(SingleSource<T> singleSource, CompletableSource completableSource) {
        this.f18247b = singleSource;
        this.f18248c = completableSource;
    }

    public void subscribeActual(SingleObserver<? super T> singleObserver) {
        this.f18248c.subscribe(new OtherObserver(singleObserver, this.f18247b));
    }
}
