package io.reactivex.rxjava3.internal.operators.maybe;

import io.reactivex.rxjava3.annotations.Nullable;
import io.reactivex.rxjava3.core.MaybeObserver;
import io.reactivex.rxjava3.core.MaybeSource;
import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.core.Observer;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.exceptions.Exceptions;
import io.reactivex.rxjava3.functions.Function;
import io.reactivex.rxjava3.internal.disposables.DisposableHelper;
import io.reactivex.rxjava3.internal.observers.BasicQueueDisposable;
import java.util.Iterator;
import java.util.Objects;

public final class MaybeFlatMapIterableObservable<T, R> extends Observable<R> {

    /* renamed from: b  reason: collision with root package name */
    public final MaybeSource<T> f20910b;

    /* renamed from: c  reason: collision with root package name */
    public final Function<? super T, ? extends Iterable<? extends R>> f20911c;

    public static final class FlatMapIterableObserver<T, R> extends BasicQueueDisposable<R> implements MaybeObserver<T> {

        /* renamed from: b  reason: collision with root package name */
        public final Observer<? super R> f20912b;

        /* renamed from: c  reason: collision with root package name */
        public final Function<? super T, ? extends Iterable<? extends R>> f20913c;

        /* renamed from: d  reason: collision with root package name */
        public Disposable f20914d;

        /* renamed from: e  reason: collision with root package name */
        public volatile Iterator<? extends R> f20915e;

        /* renamed from: f  reason: collision with root package name */
        public volatile boolean f20916f;

        /* renamed from: g  reason: collision with root package name */
        public boolean f20917g;

        public FlatMapIterableObserver(Observer<? super R> observer, Function<? super T, ? extends Iterable<? extends R>> function) {
            this.f20912b = observer;
            this.f20913c = function;
        }

        public void clear() {
            this.f20915e = null;
        }

        public void dispose() {
            this.f20916f = true;
            this.f20914d.dispose();
            this.f20914d = DisposableHelper.DISPOSED;
        }

        public boolean isDisposed() {
            return this.f20916f;
        }

        public boolean isEmpty() {
            return this.f20915e == null;
        }

        public void onComplete() {
            this.f20912b.onComplete();
        }

        public void onError(Throwable th2) {
            this.f20914d = DisposableHelper.DISPOSED;
            this.f20912b.onError(th2);
        }

        public void onSubscribe(Disposable disposable) {
            if (DisposableHelper.validate(this.f20914d, disposable)) {
                this.f20914d = disposable;
                this.f20912b.onSubscribe(this);
            }
        }

        public void onSuccess(T t11) {
            Observer<? super R> observer = this.f20912b;
            try {
                Iterator<? extends R> it = ((Iterable) this.f20913c.apply(t11)).iterator();
                if (!it.hasNext()) {
                    observer.onComplete();
                    return;
                }
                this.f20915e = it;
                if (this.f20917g) {
                    observer.onNext(null);
                    observer.onComplete();
                    return;
                }
                while (!this.f20916f) {
                    try {
                        observer.onNext(it.next());
                        if (!this.f20916f) {
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
        public R poll() {
            Iterator<? extends R> it = this.f20915e;
            if (it == null) {
                return null;
            }
            R next = it.next();
            Objects.requireNonNull(next, "The iterator returned a null value");
            if (!it.hasNext()) {
                this.f20915e = null;
            }
            return next;
        }

        public int requestFusion(int i11) {
            if ((i11 & 2) == 0) {
                return 0;
            }
            this.f20917g = true;
            return 2;
        }
    }

    public MaybeFlatMapIterableObservable(MaybeSource<T> maybeSource, Function<? super T, ? extends Iterable<? extends R>> function) {
        this.f20910b = maybeSource;
        this.f20911c = function;
    }

    public void subscribeActual(Observer<? super R> observer) {
        this.f20910b.subscribe(new FlatMapIterableObserver(observer, this.f20911c));
    }
}
