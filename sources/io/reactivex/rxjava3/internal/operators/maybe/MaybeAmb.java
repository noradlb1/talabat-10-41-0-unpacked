package io.reactivex.rxjava3.internal.operators.maybe;

import io.reactivex.rxjava3.core.Maybe;
import io.reactivex.rxjava3.core.MaybeObserver;
import io.reactivex.rxjava3.core.MaybeSource;
import io.reactivex.rxjava3.disposables.CompositeDisposable;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.exceptions.Exceptions;
import io.reactivex.rxjava3.internal.disposables.EmptyDisposable;
import io.reactivex.rxjava3.plugins.RxJavaPlugins;
import java.util.concurrent.atomic.AtomicBoolean;

public final class MaybeAmb<T> extends Maybe<T> {
    private final MaybeSource<? extends T>[] sources;
    private final Iterable<? extends MaybeSource<? extends T>> sourcesIterable;

    public static final class AmbMaybeObserver<T> implements MaybeObserver<T> {

        /* renamed from: b  reason: collision with root package name */
        public final MaybeObserver<? super T> f20764b;

        /* renamed from: c  reason: collision with root package name */
        public final AtomicBoolean f20765c;

        /* renamed from: d  reason: collision with root package name */
        public final CompositeDisposable f20766d;

        /* renamed from: e  reason: collision with root package name */
        public Disposable f20767e;

        public AmbMaybeObserver(MaybeObserver<? super T> maybeObserver, CompositeDisposable compositeDisposable, AtomicBoolean atomicBoolean) {
            this.f20764b = maybeObserver;
            this.f20766d = compositeDisposable;
            this.f20765c = atomicBoolean;
        }

        public void onComplete() {
            if (this.f20765c.compareAndSet(false, true)) {
                this.f20766d.delete(this.f20767e);
                this.f20766d.dispose();
                this.f20764b.onComplete();
            }
        }

        public void onError(Throwable th2) {
            if (this.f20765c.compareAndSet(false, true)) {
                this.f20766d.delete(this.f20767e);
                this.f20766d.dispose();
                this.f20764b.onError(th2);
                return;
            }
            RxJavaPlugins.onError(th2);
        }

        public void onSubscribe(Disposable disposable) {
            this.f20767e = disposable;
            this.f20766d.add(disposable);
        }

        public void onSuccess(T t11) {
            if (this.f20765c.compareAndSet(false, true)) {
                this.f20766d.delete(this.f20767e);
                this.f20766d.dispose();
                this.f20764b.onSuccess(t11);
            }
        }
    }

    public MaybeAmb(MaybeSource<? extends T>[] maybeSourceArr, Iterable<? extends MaybeSource<? extends T>> iterable) {
        this.sources = maybeSourceArr;
        this.sourcesIterable = iterable;
    }

    public void subscribeActual(MaybeObserver<? super T> maybeObserver) {
        int i11;
        MaybeSource<? extends T>[] maybeSourceArr = this.sources;
        if (maybeSourceArr == null) {
            maybeSourceArr = new MaybeSource[8];
            try {
                i11 = 0;
                for (MaybeSource<? extends T> maybeSource : this.sourcesIterable) {
                    if (maybeSource == null) {
                        EmptyDisposable.error((Throwable) new NullPointerException("One of the sources is null"), (MaybeObserver<?>) maybeObserver);
                        return;
                    }
                    if (i11 == maybeSourceArr.length) {
                        MaybeSource<? extends T>[] maybeSourceArr2 = new MaybeSource[((i11 >> 2) + i11)];
                        System.arraycopy(maybeSourceArr, 0, maybeSourceArr2, 0, i11);
                        maybeSourceArr = maybeSourceArr2;
                    }
                    int i12 = i11 + 1;
                    maybeSourceArr[i11] = maybeSource;
                    i11 = i12;
                }
            } catch (Throwable th2) {
                Exceptions.throwIfFatal(th2);
                EmptyDisposable.error(th2, (MaybeObserver<?>) maybeObserver);
                return;
            }
        } else {
            i11 = maybeSourceArr.length;
        }
        CompositeDisposable compositeDisposable = new CompositeDisposable();
        maybeObserver.onSubscribe(compositeDisposable);
        AtomicBoolean atomicBoolean = new AtomicBoolean();
        int i13 = 0;
        while (i13 < i11) {
            MaybeSource<? extends T> maybeSource2 = maybeSourceArr[i13];
            if (!compositeDisposable.isDisposed()) {
                if (maybeSource2 == null) {
                    compositeDisposable.dispose();
                    NullPointerException nullPointerException = new NullPointerException("One of the MaybeSources is null");
                    if (atomicBoolean.compareAndSet(false, true)) {
                        maybeObserver.onError(nullPointerException);
                        return;
                    } else {
                        RxJavaPlugins.onError(nullPointerException);
                        return;
                    }
                } else {
                    maybeSource2.subscribe(new AmbMaybeObserver(maybeObserver, compositeDisposable, atomicBoolean));
                    i13++;
                }
            } else {
                return;
            }
        }
        if (i11 == 0) {
            maybeObserver.onComplete();
        }
    }
}
