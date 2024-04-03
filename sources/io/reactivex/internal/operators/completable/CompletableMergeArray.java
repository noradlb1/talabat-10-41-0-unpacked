package io.reactivex.internal.operators.completable;

import io.reactivex.Completable;
import io.reactivex.CompletableObserver;
import io.reactivex.CompletableSource;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.plugins.RxJavaPlugins;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;

public final class CompletableMergeArray extends Completable {

    /* renamed from: b  reason: collision with root package name */
    public final CompletableSource[] f14686b;

    public static final class InnerCompletableObserver extends AtomicInteger implements CompletableObserver {
        private static final long serialVersionUID = -8360547806504310570L;

        /* renamed from: b  reason: collision with root package name */
        public final CompletableObserver f14687b;

        /* renamed from: c  reason: collision with root package name */
        public final AtomicBoolean f14688c;

        /* renamed from: d  reason: collision with root package name */
        public final CompositeDisposable f14689d;

        public InnerCompletableObserver(CompletableObserver completableObserver, AtomicBoolean atomicBoolean, CompositeDisposable compositeDisposable, int i11) {
            this.f14687b = completableObserver;
            this.f14688c = atomicBoolean;
            this.f14689d = compositeDisposable;
            lazySet(i11);
        }

        public void onComplete() {
            if (decrementAndGet() == 0 && this.f14688c.compareAndSet(false, true)) {
                this.f14687b.onComplete();
            }
        }

        public void onError(Throwable th2) {
            this.f14689d.dispose();
            if (this.f14688c.compareAndSet(false, true)) {
                this.f14687b.onError(th2);
            } else {
                RxJavaPlugins.onError(th2);
            }
        }

        public void onSubscribe(Disposable disposable) {
            this.f14689d.add(disposable);
        }
    }

    public CompletableMergeArray(CompletableSource[] completableSourceArr) {
        this.f14686b = completableSourceArr;
    }

    public void subscribeActual(CompletableObserver completableObserver) {
        CompositeDisposable compositeDisposable = new CompositeDisposable();
        InnerCompletableObserver innerCompletableObserver = new InnerCompletableObserver(completableObserver, new AtomicBoolean(), compositeDisposable, this.f14686b.length + 1);
        completableObserver.onSubscribe(compositeDisposable);
        CompletableSource[] completableSourceArr = this.f14686b;
        int length = completableSourceArr.length;
        int i11 = 0;
        while (i11 < length) {
            CompletableSource completableSource = completableSourceArr[i11];
            if (!compositeDisposable.isDisposed()) {
                if (completableSource == null) {
                    compositeDisposable.dispose();
                    innerCompletableObserver.onError(new NullPointerException("A completable source is null"));
                    return;
                }
                completableSource.subscribe(innerCompletableObserver);
                i11++;
            } else {
                return;
            }
        }
        innerCompletableObserver.onComplete();
    }
}
