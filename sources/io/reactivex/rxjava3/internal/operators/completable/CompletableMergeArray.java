package io.reactivex.rxjava3.internal.operators.completable;

import io.reactivex.rxjava3.core.Completable;
import io.reactivex.rxjava3.core.CompletableObserver;
import io.reactivex.rxjava3.core.CompletableSource;
import io.reactivex.rxjava3.disposables.CompositeDisposable;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.plugins.RxJavaPlugins;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;

public final class CompletableMergeArray extends Completable {

    /* renamed from: b  reason: collision with root package name */
    public final CompletableSource[] f19172b;

    public static final class InnerCompletableObserver extends AtomicInteger implements CompletableObserver, Disposable {
        private static final long serialVersionUID = -8360547806504310570L;

        /* renamed from: b  reason: collision with root package name */
        public final CompletableObserver f19173b;

        /* renamed from: c  reason: collision with root package name */
        public final AtomicBoolean f19174c;

        /* renamed from: d  reason: collision with root package name */
        public final CompositeDisposable f19175d;

        public InnerCompletableObserver(CompletableObserver completableObserver, AtomicBoolean atomicBoolean, CompositeDisposable compositeDisposable, int i11) {
            this.f19173b = completableObserver;
            this.f19174c = atomicBoolean;
            this.f19175d = compositeDisposable;
            lazySet(i11);
        }

        public void dispose() {
            this.f19175d.dispose();
            this.f19174c.set(true);
        }

        public boolean isDisposed() {
            return this.f19175d.isDisposed();
        }

        public void onComplete() {
            if (decrementAndGet() == 0) {
                this.f19173b.onComplete();
            }
        }

        public void onError(Throwable th2) {
            this.f19175d.dispose();
            if (this.f19174c.compareAndSet(false, true)) {
                this.f19173b.onError(th2);
            } else {
                RxJavaPlugins.onError(th2);
            }
        }

        public void onSubscribe(Disposable disposable) {
            this.f19175d.add(disposable);
        }
    }

    public CompletableMergeArray(CompletableSource[] completableSourceArr) {
        this.f19172b = completableSourceArr;
    }

    public void subscribeActual(CompletableObserver completableObserver) {
        CompositeDisposable compositeDisposable = new CompositeDisposable();
        InnerCompletableObserver innerCompletableObserver = new InnerCompletableObserver(completableObserver, new AtomicBoolean(), compositeDisposable, this.f19172b.length + 1);
        completableObserver.onSubscribe(innerCompletableObserver);
        CompletableSource[] completableSourceArr = this.f19172b;
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
