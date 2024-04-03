package io.reactivex.internal.operators.maybe;

import io.reactivex.MaybeObserver;
import io.reactivex.MaybeSource;
import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.annotations.Nullable;
import io.reactivex.disposables.Disposable;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.functions.Function;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.functions.ObjectHelper;
import io.reactivex.internal.observers.BasicQueueDisposable;
import java.util.Iterator;

public final class MaybeFlatMapIterableObservable<T, R> extends Observable<R> {

    /* renamed from: b  reason: collision with root package name */
    public final MaybeSource<T> f16399b;

    /* renamed from: c  reason: collision with root package name */
    public final Function<? super T, ? extends Iterable<? extends R>> f16400c;

    public static final class FlatMapIterableObserver<T, R> extends BasicQueueDisposable<R> implements MaybeObserver<T> {

        /* renamed from: b  reason: collision with root package name */
        public final Observer<? super R> f16401b;

        /* renamed from: c  reason: collision with root package name */
        public final Function<? super T, ? extends Iterable<? extends R>> f16402c;

        /* renamed from: d  reason: collision with root package name */
        public Disposable f16403d;

        /* renamed from: e  reason: collision with root package name */
        public volatile Iterator<? extends R> f16404e;

        /* renamed from: f  reason: collision with root package name */
        public volatile boolean f16405f;

        /* renamed from: g  reason: collision with root package name */
        public boolean f16406g;

        public FlatMapIterableObserver(Observer<? super R> observer, Function<? super T, ? extends Iterable<? extends R>> function) {
            this.f16401b = observer;
            this.f16402c = function;
        }

        public void clear() {
            this.f16404e = null;
        }

        public void dispose() {
            this.f16405f = true;
            this.f16403d.dispose();
            this.f16403d = DisposableHelper.DISPOSED;
        }

        public boolean isDisposed() {
            return this.f16405f;
        }

        public boolean isEmpty() {
            return this.f16404e == null;
        }

        public void onComplete() {
            this.f16401b.onComplete();
        }

        public void onError(Throwable th2) {
            this.f16403d = DisposableHelper.DISPOSED;
            this.f16401b.onError(th2);
        }

        public void onSubscribe(Disposable disposable) {
            if (DisposableHelper.validate(this.f16403d, disposable)) {
                this.f16403d = disposable;
                this.f16401b.onSubscribe(this);
            }
        }

        public void onSuccess(T t11) {
            Observer<? super R> observer = this.f16401b;
            try {
                Iterator<? extends R> it = ((Iterable) this.f16402c.apply(t11)).iterator();
                if (!it.hasNext()) {
                    observer.onComplete();
                    return;
                }
                this.f16404e = it;
                if (this.f16406g) {
                    observer.onNext(null);
                    observer.onComplete();
                    return;
                }
                while (!this.f16405f) {
                    try {
                        observer.onNext(it.next());
                        if (!this.f16405f) {
                            try {
                                if (!it.hasNext()) {
                                    observer.onComplete();
                                    return;
                                }
                            } catch (Throwable th2) {
                                Exceptions.throwIfFatal(th2);
                                observer.onError(th2);
                                return;
                            }
                        } else {
                            return;
                        }
                    } catch (Throwable th3) {
                        Exceptions.throwIfFatal(th3);
                        observer.onError(th3);
                        return;
                    }
                }
            } catch (Throwable th4) {
                Exceptions.throwIfFatal(th4);
                observer.onError(th4);
            }
        }

        @Nullable
        public R poll() throws Exception {
            Iterator<? extends R> it = this.f16404e;
            if (it == null) {
                return null;
            }
            R requireNonNull = ObjectHelper.requireNonNull(it.next(), "The iterator returned a null value");
            if (!it.hasNext()) {
                this.f16404e = null;
            }
            return requireNonNull;
        }

        public int requestFusion(int i11) {
            if ((i11 & 2) == 0) {
                return 0;
            }
            this.f16406g = true;
            return 2;
        }
    }

    public MaybeFlatMapIterableObservable(MaybeSource<T> maybeSource, Function<? super T, ? extends Iterable<? extends R>> function) {
        this.f16399b = maybeSource;
        this.f16400c = function;
    }

    public void subscribeActual(Observer<? super R> observer) {
        this.f16399b.subscribe(new FlatMapIterableObserver(observer, this.f16400c));
    }
}
