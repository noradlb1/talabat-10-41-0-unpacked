package io.reactivex.rxjava3.internal.operators.completable;

import io.reactivex.rxjava3.core.Completable;
import io.reactivex.rxjava3.core.CompletableObserver;
import io.reactivex.rxjava3.core.CompletableSource;
import io.reactivex.rxjava3.disposables.CompositeDisposable;
import io.reactivex.rxjava3.exceptions.Exceptions;
import io.reactivex.rxjava3.internal.operators.completable.CompletableMergeArrayDelayError;
import io.reactivex.rxjava3.internal.util.AtomicThrowable;
import java.util.Iterator;
import java.util.Objects;
import java.util.concurrent.atomic.AtomicInteger;

public final class CompletableMergeDelayErrorIterable extends Completable {

    /* renamed from: b  reason: collision with root package name */
    public final Iterable<? extends CompletableSource> f19182b;

    public CompletableMergeDelayErrorIterable(Iterable<? extends CompletableSource> iterable) {
        this.f19182b = iterable;
    }

    public void subscribeActual(CompletableObserver completableObserver) {
        CompositeDisposable compositeDisposable = new CompositeDisposable();
        completableObserver.onSubscribe(compositeDisposable);
        try {
            Iterator<? extends CompletableSource> it = this.f19182b.iterator();
            Objects.requireNonNull(it, "The source iterator returned is null");
            Iterator it2 = it;
            AtomicInteger atomicInteger = new AtomicInteger(1);
            AtomicThrowable atomicThrowable = new AtomicThrowable();
            compositeDisposable.add(new CompletableMergeArrayDelayError.TryTerminateAndReportDisposable(atomicThrowable));
            while (!compositeDisposable.isDisposed()) {
                try {
                    if (!it2.hasNext()) {
                        if (atomicInteger.decrementAndGet() == 0) {
                            atomicThrowable.tryTerminateConsumer(completableObserver);
                            return;
                        }
                        return;
                    } else if (!compositeDisposable.isDisposed()) {
                        try {
                            Object next = it2.next();
                            Objects.requireNonNull(next, "The iterator returned a null CompletableSource");
                            CompletableSource completableSource = (CompletableSource) next;
                            if (!compositeDisposable.isDisposed()) {
                                atomicInteger.getAndIncrement();
                                completableSource.subscribe(new CompletableMergeArrayDelayError.MergeInnerCompletableObserver(completableObserver, compositeDisposable, atomicThrowable, atomicInteger));
                            } else {
                                return;
                            }
                        } catch (Throwable th2) {
                            Exceptions.throwIfFatal(th2);
                            atomicThrowable.tryAddThrowableOrReport(th2);
                        }
                    } else {
                        return;
                    }
                } catch (Throwable th3) {
                    Exceptions.throwIfFatal(th3);
                    atomicThrowable.tryAddThrowableOrReport(th3);
                }
            }
        } catch (Throwable th4) {
            Exceptions.throwIfFatal(th4);
            completableObserver.onError(th4);
        }
    }
}
