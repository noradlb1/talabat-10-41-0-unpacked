package io.reactivex.internal.operators.maybe;

import io.reactivex.Maybe;
import io.reactivex.MaybeObserver;
import io.reactivex.MaybeSource;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.internal.disposables.EmptyDisposable;
import io.reactivex.plugins.RxJavaPlugins;
import java.util.concurrent.atomic.AtomicBoolean;

public final class MaybeAmb<T> extends Maybe<T> {
    private final MaybeSource<? extends T>[] sources;
    private final Iterable<? extends MaybeSource<? extends T>> sourcesIterable;

    public static final class AmbMaybeObserver<T> implements MaybeObserver<T> {

        /* renamed from: b  reason: collision with root package name */
        public final MaybeObserver<? super T> f16265b;

        /* renamed from: c  reason: collision with root package name */
        public final AtomicBoolean f16266c;

        /* renamed from: d  reason: collision with root package name */
        public final CompositeDisposable f16267d;

        /* renamed from: e  reason: collision with root package name */
        public Disposable f16268e;

        public AmbMaybeObserver(MaybeObserver<? super T> maybeObserver, CompositeDisposable compositeDisposable, AtomicBoolean atomicBoolean) {
            this.f16265b = maybeObserver;
            this.f16267d = compositeDisposable;
            this.f16266c = atomicBoolean;
        }

        public void onComplete() {
            if (this.f16266c.compareAndSet(false, true)) {
                this.f16267d.delete(this.f16268e);
                this.f16267d.dispose();
                this.f16265b.onComplete();
            }
        }

        public void onError(Throwable th2) {
            if (this.f16266c.compareAndSet(false, true)) {
                this.f16267d.delete(this.f16268e);
                this.f16267d.dispose();
                this.f16265b.onError(th2);
                return;
            }
            RxJavaPlugins.onError(th2);
        }

        public void onSubscribe(Disposable disposable) {
            this.f16268e = disposable;
            this.f16267d.add(disposable);
        }

        public void onSuccess(T t11) {
            if (this.f16266c.compareAndSet(false, true)) {
                this.f16267d.delete(this.f16268e);
                this.f16267d.dispose();
                this.f16265b.onSuccess(t11);
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
