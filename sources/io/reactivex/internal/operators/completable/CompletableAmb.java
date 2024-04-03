package io.reactivex.internal.operators.completable;

import io.reactivex.Completable;
import io.reactivex.CompletableObserver;
import io.reactivex.CompletableSource;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.internal.disposables.EmptyDisposable;
import io.reactivex.plugins.RxJavaPlugins;
import java.util.concurrent.atomic.AtomicBoolean;

public final class CompletableAmb extends Completable {
    private final CompletableSource[] sources;
    private final Iterable<? extends CompletableSource> sourcesIterable;

    public static final class Amb implements CompletableObserver {

        /* renamed from: b  reason: collision with root package name */
        public final AtomicBoolean f14585b;

        /* renamed from: c  reason: collision with root package name */
        public final CompositeDisposable f14586c;

        /* renamed from: d  reason: collision with root package name */
        public final CompletableObserver f14587d;

        /* renamed from: e  reason: collision with root package name */
        public Disposable f14588e;

        public Amb(AtomicBoolean atomicBoolean, CompositeDisposable compositeDisposable, CompletableObserver completableObserver) {
            this.f14585b = atomicBoolean;
            this.f14586c = compositeDisposable;
            this.f14587d = completableObserver;
        }

        public void onComplete() {
            if (this.f14585b.compareAndSet(false, true)) {
                this.f14586c.delete(this.f14588e);
                this.f14586c.dispose();
                this.f14587d.onComplete();
            }
        }

        public void onError(Throwable th2) {
            if (this.f14585b.compareAndSet(false, true)) {
                this.f14586c.delete(this.f14588e);
                this.f14586c.dispose();
                this.f14587d.onError(th2);
                return;
            }
            RxJavaPlugins.onError(th2);
        }

        public void onSubscribe(Disposable disposable) {
            this.f14588e = disposable;
            this.f14586c.add(disposable);
        }
    }

    public CompletableAmb(CompletableSource[] completableSourceArr, Iterable<? extends CompletableSource> iterable) {
        this.sources = completableSourceArr;
        this.sourcesIterable = iterable;
    }

    public void subscribeActual(CompletableObserver completableObserver) {
        int i11;
        CompletableSource[] completableSourceArr = this.sources;
        if (completableSourceArr == null) {
            completableSourceArr = new CompletableSource[8];
            try {
                i11 = 0;
                for (CompletableSource completableSource : this.sourcesIterable) {
                    if (completableSource == null) {
                        EmptyDisposable.error((Throwable) new NullPointerException("One of the sources is null"), completableObserver);
                        return;
                    }
                    if (i11 == completableSourceArr.length) {
                        CompletableSource[] completableSourceArr2 = new CompletableSource[((i11 >> 2) + i11)];
                        System.arraycopy(completableSourceArr, 0, completableSourceArr2, 0, i11);
                        completableSourceArr = completableSourceArr2;
                    }
                    int i12 = i11 + 1;
                    completableSourceArr[i11] = completableSource;
                    i11 = i12;
                }
            } catch (Throwable th2) {
                Exceptions.throwIfFatal(th2);
                EmptyDisposable.error(th2, completableObserver);
                return;
            }
        } else {
            i11 = completableSourceArr.length;
        }
        CompositeDisposable compositeDisposable = new CompositeDisposable();
        completableObserver.onSubscribe(compositeDisposable);
        AtomicBoolean atomicBoolean = new AtomicBoolean();
        int i13 = 0;
        while (i13 < i11) {
            CompletableSource completableSource2 = completableSourceArr[i13];
            if (!compositeDisposable.isDisposed()) {
                if (completableSource2 == null) {
                    NullPointerException nullPointerException = new NullPointerException("One of the sources is null");
                    if (atomicBoolean.compareAndSet(false, true)) {
                        compositeDisposable.dispose();
                        completableObserver.onError(nullPointerException);
                        return;
                    }
                    RxJavaPlugins.onError(nullPointerException);
                    return;
                }
                completableSource2.subscribe(new Amb(atomicBoolean, compositeDisposable, completableObserver));
                i13++;
            } else {
                return;
            }
        }
        if (i11 == 0) {
            completableObserver.onComplete();
        }
    }
}
