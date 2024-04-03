package io.reactivex.rxjava3.internal.operators.completable;

import io.reactivex.rxjava3.core.Completable;
import io.reactivex.rxjava3.core.CompletableObserver;
import io.reactivex.rxjava3.core.CompletableSource;
import io.reactivex.rxjava3.disposables.CompositeDisposable;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.exceptions.Exceptions;
import io.reactivex.rxjava3.internal.disposables.EmptyDisposable;
import io.reactivex.rxjava3.plugins.RxJavaPlugins;
import java.util.concurrent.atomic.AtomicBoolean;

public final class CompletableAmb extends Completable {
    private final CompletableSource[] sources;
    private final Iterable<? extends CompletableSource> sourcesIterable;

    public static final class Amb implements CompletableObserver {

        /* renamed from: b  reason: collision with root package name */
        public final AtomicBoolean f19070b;

        /* renamed from: c  reason: collision with root package name */
        public final CompositeDisposable f19071c;

        /* renamed from: d  reason: collision with root package name */
        public final CompletableObserver f19072d;

        /* renamed from: e  reason: collision with root package name */
        public Disposable f19073e;

        public Amb(AtomicBoolean atomicBoolean, CompositeDisposable compositeDisposable, CompletableObserver completableObserver) {
            this.f19070b = atomicBoolean;
            this.f19071c = compositeDisposable;
            this.f19072d = completableObserver;
        }

        public void onComplete() {
            if (this.f19070b.compareAndSet(false, true)) {
                this.f19071c.delete(this.f19073e);
                this.f19071c.dispose();
                this.f19072d.onComplete();
            }
        }

        public void onError(Throwable th2) {
            if (this.f19070b.compareAndSet(false, true)) {
                this.f19071c.delete(this.f19073e);
                this.f19071c.dispose();
                this.f19072d.onError(th2);
                return;
            }
            RxJavaPlugins.onError(th2);
        }

        public void onSubscribe(Disposable disposable) {
            this.f19073e = disposable;
            this.f19071c.add(disposable);
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
