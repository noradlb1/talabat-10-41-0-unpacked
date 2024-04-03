package io.reactivex.rxjava3.internal.operators.single;

import io.reactivex.rxjava3.core.CompletableObserver;
import io.reactivex.rxjava3.core.CompletableSource;
import io.reactivex.rxjava3.core.Single;
import io.reactivex.rxjava3.core.SingleObserver;
import io.reactivex.rxjava3.core.SingleSource;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.internal.disposables.DisposableHelper;
import io.reactivex.rxjava3.internal.observers.ResumeSingleObserver;
import java.util.concurrent.atomic.AtomicReference;

public final class SingleDelayWithCompletable<T> extends Single<T> {

    /* renamed from: b  reason: collision with root package name */
    public final SingleSource<T> f22781b;

    /* renamed from: c  reason: collision with root package name */
    public final CompletableSource f22782c;

    public static final class OtherObserver<T> extends AtomicReference<Disposable> implements CompletableObserver, Disposable {
        private static final long serialVersionUID = -8565274649390031272L;

        /* renamed from: b  reason: collision with root package name */
        public final SingleObserver<? super T> f22783b;

        /* renamed from: c  reason: collision with root package name */
        public final SingleSource<T> f22784c;

        public OtherObserver(SingleObserver<? super T> singleObserver, SingleSource<T> singleSource) {
            this.f22783b = singleObserver;
            this.f22784c = singleSource;
        }

        public void dispose() {
            DisposableHelper.dispose(this);
        }

        public boolean isDisposed() {
            return DisposableHelper.isDisposed((Disposable) get());
        }

        public void onComplete() {
            this.f22784c.subscribe(new ResumeSingleObserver(this, this.f22783b));
        }

        public void onError(Throwable th2) {
            this.f22783b.onError(th2);
        }

        public void onSubscribe(Disposable disposable) {
            if (DisposableHelper.setOnce(this, disposable)) {
                this.f22783b.onSubscribe(this);
            }
        }
    }

    public SingleDelayWithCompletable(SingleSource<T> singleSource, CompletableSource completableSource) {
        this.f22781b = singleSource;
        this.f22782c = completableSource;
    }

    public void subscribeActual(SingleObserver<? super T> singleObserver) {
        this.f22782c.subscribe(new OtherObserver(singleObserver, this.f22781b));
    }
}
