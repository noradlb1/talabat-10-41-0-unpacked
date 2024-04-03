package io.reactivex.rxjava3.internal.operators.completable;

import io.reactivex.rxjava3.core.Completable;
import io.reactivex.rxjava3.core.CompletableObserver;
import io.reactivex.rxjava3.core.CompletableSource;
import io.reactivex.rxjava3.disposables.CompositeDisposable;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.internal.util.AtomicThrowable;
import java.util.concurrent.atomic.AtomicInteger;

public final class CompletableMergeArrayDelayError extends Completable {

    /* renamed from: b  reason: collision with root package name */
    public final CompletableSource[] f19176b;

    public static final class MergeInnerCompletableObserver implements CompletableObserver {

        /* renamed from: b  reason: collision with root package name */
        public final CompletableObserver f19177b;

        /* renamed from: c  reason: collision with root package name */
        public final CompositeDisposable f19178c;

        /* renamed from: d  reason: collision with root package name */
        public final AtomicThrowable f19179d;

        /* renamed from: e  reason: collision with root package name */
        public final AtomicInteger f19180e;

        public MergeInnerCompletableObserver(CompletableObserver completableObserver, CompositeDisposable compositeDisposable, AtomicThrowable atomicThrowable, AtomicInteger atomicInteger) {
            this.f19177b = completableObserver;
            this.f19178c = compositeDisposable;
            this.f19179d = atomicThrowable;
            this.f19180e = atomicInteger;
        }

        public void a() {
            if (this.f19180e.decrementAndGet() == 0) {
                this.f19179d.tryTerminateConsumer(this.f19177b);
            }
        }

        public void onComplete() {
            a();
        }

        public void onError(Throwable th2) {
            if (this.f19179d.tryAddThrowableOrReport(th2)) {
                a();
            }
        }

        public void onSubscribe(Disposable disposable) {
            this.f19178c.add(disposable);
        }
    }

    public static final class TryTerminateAndReportDisposable implements Disposable {

        /* renamed from: b  reason: collision with root package name */
        public final AtomicThrowable f19181b;

        public TryTerminateAndReportDisposable(AtomicThrowable atomicThrowable) {
            this.f19181b = atomicThrowable;
        }

        public void dispose() {
            this.f19181b.tryTerminateAndReport();
        }

        public boolean isDisposed() {
            return this.f19181b.isTerminated();
        }
    }

    public CompletableMergeArrayDelayError(CompletableSource[] completableSourceArr) {
        this.f19176b = completableSourceArr;
    }

    public void subscribeActual(CompletableObserver completableObserver) {
        CompositeDisposable compositeDisposable = new CompositeDisposable();
        AtomicInteger atomicInteger = new AtomicInteger(this.f19176b.length + 1);
        AtomicThrowable atomicThrowable = new AtomicThrowable();
        compositeDisposable.add(new TryTerminateAndReportDisposable(atomicThrowable));
        completableObserver.onSubscribe(compositeDisposable);
        CompletableSource[] completableSourceArr = this.f19176b;
        int length = completableSourceArr.length;
        int i11 = 0;
        while (i11 < length) {
            CompletableSource completableSource = completableSourceArr[i11];
            if (!compositeDisposable.isDisposed()) {
                if (completableSource == null) {
                    atomicThrowable.tryAddThrowableOrReport(new NullPointerException("A completable source is null"));
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
            atomicThrowable.tryTerminateConsumer(completableObserver);
        }
    }
}
