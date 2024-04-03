package io.reactivex.rxjava3.internal.operators.completable;

import io.reactivex.rxjava3.core.Completable;
import io.reactivex.rxjava3.core.CompletableObserver;
import io.reactivex.rxjava3.core.CompletableSource;
import io.reactivex.rxjava3.disposables.CompositeDisposable;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.exceptions.Exceptions;
import io.reactivex.rxjava3.plugins.RxJavaPlugins;
import java.util.Iterator;
import java.util.Objects;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;

public final class CompletableMergeIterable extends Completable {

    /* renamed from: b  reason: collision with root package name */
    public final Iterable<? extends CompletableSource> f19183b;

    public static final class MergeCompletableObserver extends AtomicBoolean implements CompletableObserver, Disposable {
        private static final long serialVersionUID = -7730517613164279224L;

        /* renamed from: b  reason: collision with root package name */
        public final CompositeDisposable f19184b;

        /* renamed from: c  reason: collision with root package name */
        public final CompletableObserver f19185c;

        /* renamed from: d  reason: collision with root package name */
        public final AtomicInteger f19186d;

        public MergeCompletableObserver(CompletableObserver completableObserver, CompositeDisposable compositeDisposable, AtomicInteger atomicInteger) {
            this.f19185c = completableObserver;
            this.f19184b = compositeDisposable;
            this.f19186d = atomicInteger;
        }

        public void dispose() {
            this.f19184b.dispose();
            set(true);
        }

        public boolean isDisposed() {
            return this.f19184b.isDisposed();
        }

        public void onComplete() {
            if (this.f19186d.decrementAndGet() == 0) {
                this.f19185c.onComplete();
            }
        }

        public void onError(Throwable th2) {
            this.f19184b.dispose();
            if (compareAndSet(false, true)) {
                this.f19185c.onError(th2);
            } else {
                RxJavaPlugins.onError(th2);
            }
        }

        public void onSubscribe(Disposable disposable) {
            this.f19184b.add(disposable);
        }
    }

    public CompletableMergeIterable(Iterable<? extends CompletableSource> iterable) {
        this.f19183b = iterable;
    }

    public void subscribeActual(CompletableObserver completableObserver) {
        CompositeDisposable compositeDisposable = new CompositeDisposable();
        AtomicInteger atomicInteger = new AtomicInteger(1);
        MergeCompletableObserver mergeCompletableObserver = new MergeCompletableObserver(completableObserver, compositeDisposable, atomicInteger);
        completableObserver.onSubscribe(mergeCompletableObserver);
        try {
            Iterator<? extends CompletableSource> it = this.f19183b.iterator();
            Objects.requireNonNull(it, "The source iterator returned is null");
            Iterator it2 = it;
            while (!compositeDisposable.isDisposed()) {
                try {
                    if (!it2.hasNext()) {
                        mergeCompletableObserver.onComplete();
                        return;
                    } else if (!compositeDisposable.isDisposed()) {
                        try {
                            Object next = it2.next();
                            Objects.requireNonNull(next, "The iterator returned a null CompletableSource");
                            CompletableSource completableSource = (CompletableSource) next;
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
