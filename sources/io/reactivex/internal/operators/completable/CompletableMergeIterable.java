package io.reactivex.internal.operators.completable;

import io.reactivex.Completable;
import io.reactivex.CompletableObserver;
import io.reactivex.CompletableSource;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.internal.functions.ObjectHelper;
import io.reactivex.plugins.RxJavaPlugins;
import java.util.Iterator;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;

public final class CompletableMergeIterable extends Completable {

    /* renamed from: b  reason: collision with root package name */
    public final Iterable<? extends CompletableSource> f14696b;

    public static final class MergeCompletableObserver extends AtomicBoolean implements CompletableObserver {
        private static final long serialVersionUID = -7730517613164279224L;

        /* renamed from: b  reason: collision with root package name */
        public final CompositeDisposable f14697b;

        /* renamed from: c  reason: collision with root package name */
        public final CompletableObserver f14698c;

        /* renamed from: d  reason: collision with root package name */
        public final AtomicInteger f14699d;

        public MergeCompletableObserver(CompletableObserver completableObserver, CompositeDisposable compositeDisposable, AtomicInteger atomicInteger) {
            this.f14698c = completableObserver;
            this.f14697b = compositeDisposable;
            this.f14699d = atomicInteger;
        }

        public void onComplete() {
            if (this.f14699d.decrementAndGet() == 0 && compareAndSet(false, true)) {
                this.f14698c.onComplete();
            }
        }

        public void onError(Throwable th2) {
            this.f14697b.dispose();
            if (compareAndSet(false, true)) {
                this.f14698c.onError(th2);
            } else {
                RxJavaPlugins.onError(th2);
            }
        }

        public void onSubscribe(Disposable disposable) {
            this.f14697b.add(disposable);
        }
    }

    public CompletableMergeIterable(Iterable<? extends CompletableSource> iterable) {
        this.f14696b = iterable;
    }

    public void subscribeActual(CompletableObserver completableObserver) {
        CompositeDisposable compositeDisposable = new CompositeDisposable();
        completableObserver.onSubscribe(compositeDisposable);
        try {
            Iterator it = (Iterator) ObjectHelper.requireNonNull(this.f14696b.iterator(), "The source iterator returned is null");
            AtomicInteger atomicInteger = new AtomicInteger(1);
            MergeCompletableObserver mergeCompletableObserver = new MergeCompletableObserver(completableObserver, compositeDisposable, atomicInteger);
            while (!compositeDisposable.isDisposed()) {
                try {
                    if (!it.hasNext()) {
                        mergeCompletableObserver.onComplete();
                        return;
                    } else if (!compositeDisposable.isDisposed()) {
                        try {
                            CompletableSource completableSource = (CompletableSource) ObjectHelper.requireNonNull(it.next(), "The iterator returned a null CompletableSource");
                            if (!compositeDisposable.isDisposed()) {
                                atomicInteger.getAndIncrement();
                                completableSource.subscribe(mergeCompletableObserver);
                            } else {
                                return;
                            }
                        } catch (Throwable th2) {
                            Exceptions.throwIfFatal(th2);
                            compositeDisposable.dispose();
                            mergeCompletableObserver.onError(th2);
                            return;
                        }
                    } else {
                        return;
                    }
                } catch (Throwable th3) {
                    Exceptions.throwIfFatal(th3);
                    compositeDisposable.dispose();
                    mergeCompletableObserver.onError(th3);
                    return;
                }
            }
        } catch (Throwable th4) {
            Exceptions.throwIfFatal(th4);
            completableObserver.onError(th4);
        }
    }
}
