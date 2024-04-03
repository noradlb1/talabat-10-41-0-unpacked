package io.reactivex.internal.operators.completable;

import io.reactivex.Completable;
import io.reactivex.CompletableObserver;
import io.reactivex.CompletableSource;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.internal.util.AtomicThrowable;
import io.reactivex.plugins.RxJavaPlugins;
import java.util.concurrent.atomic.AtomicInteger;

public final class CompletableMergeDelayErrorArray extends Completable {

    /* renamed from: b  reason: collision with root package name */
    public final CompletableSource[] f14690b;

    public static final class MergeInnerCompletableObserver implements CompletableObserver {

        /* renamed from: b  reason: collision with root package name */
        public final CompletableObserver f14691b;

        /* renamed from: c  reason: collision with root package name */
        public final CompositeDisposable f14692c;

        /* renamed from: d  reason: collision with root package name */
        public final AtomicThrowable f14693d;

        /* renamed from: e  reason: collision with root package name */
        public final AtomicInteger f14694e;

        public MergeInnerCompletableObserver(CompletableObserver completableObserver, CompositeDisposable compositeDisposable, AtomicThrowable atomicThrowable, AtomicInteger atomicInteger) {
            this.f14691b = completableObserver;
            this.f14692c = compositeDisposable;
            this.f14693d = atomicThrowable;
            this.f14694e = atomicInteger;
        }

        public void a() {
            if (this.f14694e.decrementAndGet() == 0) {
                Throwable terminate = this.f14693d.terminate();
                if (terminate == null) {
                    this.f14691b.onComplete();
                } else {
                    this.f14691b.onError(terminate);
                }
            }
        }

        public void onComplete() {
            a();
        }

        public void onError(Throwable th2) {
            if (this.f14693d.addThrowable(th2)) {
                a();
            } else {
                RxJavaPlugins.onError(th2);
            }
        }

        public void onSubscribe(Disposable disposable) {
            this.f14692c.add(disposable);
        }
    }

    public CompletableMergeDelayErrorArray(CompletableSource[] completableSourceArr) {
        this.f14690b = completableSourceArr;
    }

    public void subscribeActual(CompletableObserver completableObserver) {
        CompositeDisposable compositeDisposable = new CompositeDisposable();
        AtomicInteger atomicInteger = new AtomicInteger(this.f14690b.length + 1);
        AtomicThrowable atomicThrowable = new AtomicThrowable();
        completableObserver.onSubscribe(compositeDisposable);
        CompletableSource[] completableSourceArr = this.f14690b;
        int length = completableSourceArr.length;
        int i11 = 0;
        while (i11 < length) {
            CompletableSource completableSource = completableSourceArr[i11];
            if (!compositeDisposable.isDisposed()) {
                if (completableSource == null) {
                    atomicThrowable.addThrowable(new NullPointerException("A completable source is null"));
                    atomicInteger.decrementAndGet();
                } else {
                    completableSource.subscribe(new MergeInnerCompletableObserver(completableObserver, compositeDisposable, atomicThrowable, atomicInteger));
                }
                i11++;
            } else {
                return;
            }
        }
        if (atomicInteger.decrementAndGet() == 0) {
            Throwable terminate = atomicThrowable.terminate();
            if (terminate == null) {
                completableObserver.onComplete();
            } else {
                completableObserver.onError(terminate);
            }
        }
    }
}
