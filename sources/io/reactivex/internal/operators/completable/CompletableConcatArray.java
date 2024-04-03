package io.reactivex.internal.operators.completable;

import io.reactivex.Completable;
import io.reactivex.CompletableObserver;
import io.reactivex.CompletableSource;
import io.reactivex.disposables.Disposable;
import io.reactivex.internal.disposables.SequentialDisposable;
import java.util.concurrent.atomic.AtomicInteger;

public final class CompletableConcatArray extends Completable {

    /* renamed from: b  reason: collision with root package name */
    public final CompletableSource[] f14617b;

    public static final class ConcatInnerObserver extends AtomicInteger implements CompletableObserver {
        private static final long serialVersionUID = -7965400327305809232L;

        /* renamed from: b  reason: collision with root package name */
        public final CompletableObserver f14618b;

        /* renamed from: c  reason: collision with root package name */
        public final CompletableSource[] f14619c;

        /* renamed from: d  reason: collision with root package name */
        public int f14620d;

        /* renamed from: e  reason: collision with root package name */
        public final SequentialDisposable f14621e = new SequentialDisposable();

        public ConcatInnerObserver(CompletableObserver completableObserver, CompletableSource[] completableSourceArr) {
            this.f14618b = completableObserver;
            this.f14619c = completableSourceArr;
        }

        public void a() {
            if (!this.f14621e.isDisposed() && getAndIncrement() == 0) {
                CompletableSource[] completableSourceArr = this.f14619c;
                while (!this.f14621e.isDisposed()) {
                    int i11 = this.f14620d;
                    this.f14620d = i11 + 1;
                    if (i11 == completableSourceArr.length) {
                        this.f14618b.onComplete();
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
            this.f14618b.onError(th2);
        }

        public void onSubscribe(Disposable disposable) {
            this.f14621e.replace(disposable);
        }
    }

    public CompletableConcatArray(CompletableSource[] completableSourceArr) {
        this.f14617b = completableSourceArr;
    }

    public void subscribeActual(CompletableObserver completableObserver) {
        ConcatInnerObserver concatInnerObserver = new ConcatInnerObserver(completableObserver, this.f14617b);
        completableObserver.onSubscribe(concatInnerObserver.f14621e);
        concatInnerObserver.a();
    }
}
