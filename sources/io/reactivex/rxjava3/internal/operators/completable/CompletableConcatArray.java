package io.reactivex.rxjava3.internal.operators.completable;

import io.reactivex.rxjava3.core.Completable;
import io.reactivex.rxjava3.core.CompletableObserver;
import io.reactivex.rxjava3.core.CompletableSource;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.internal.disposables.SequentialDisposable;
import java.util.concurrent.atomic.AtomicInteger;

public final class CompletableConcatArray extends Completable {

    /* renamed from: b  reason: collision with root package name */
    public final CompletableSource[] f19102b;

    public static final class ConcatInnerObserver extends AtomicInteger implements CompletableObserver {
        private static final long serialVersionUID = -7965400327305809232L;

        /* renamed from: b  reason: collision with root package name */
        public final CompletableObserver f19103b;

        /* renamed from: c  reason: collision with root package name */
        public final CompletableSource[] f19104c;

        /* renamed from: d  reason: collision with root package name */
        public int f19105d;

        /* renamed from: e  reason: collision with root package name */
        public final SequentialDisposable f19106e = new SequentialDisposable();

        public ConcatInnerObserver(CompletableObserver completableObserver, CompletableSource[] completableSourceArr) {
            this.f19103b = completableObserver;
            this.f19104c = completableSourceArr;
        }

        public void a() {
            if (!this.f19106e.isDisposed() && getAndIncrement() == 0) {
                CompletableSource[] completableSourceArr = this.f19104c;
                while (!this.f19106e.isDisposed()) {
                    int i11 = this.f19105d;
                    this.f19105d = i11 + 1;
                    if (i11 == completableSourceArr.length) {
                        this.f19103b.onComplete();
                        return;
                    }
                    completableSourceArr[i11].subscribe(this);
                    if (decrementAndGet() == 0) {
                        return;
                    }
                }
            }
        }

        public void onComplete() {
            a();
        }

        public void onError(Throwable th2) {
            this.f19103b.onError(th2);
        }

        public void onSubscribe(Disposable disposable) {
            this.f19106e.replace(disposable);
        }
    }

    public CompletableConcatArray(CompletableSource[] completableSourceArr) {
        this.f19102b = completableSourceArr;
    }

    public void subscribeActual(CompletableObserver completableObserver) {
        ConcatInnerObserver concatInnerObserver = new ConcatInnerObserver(completableObserver, this.f19102b);
        completableObserver.onSubscribe(concatInnerObserver.f19106e);
        concatInnerObserver.a();
    }
}
