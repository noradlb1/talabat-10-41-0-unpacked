package io.reactivex.internal.operators.single;

import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.SingleObserver;
import io.reactivex.SingleSource;
import io.reactivex.annotations.Nullable;
import io.reactivex.disposables.Disposable;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.functions.Function;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.functions.ObjectHelper;
import io.reactivex.internal.observers.BasicIntQueueDisposable;
import java.util.Iterator;

public final class SingleFlatMapIterableObservable<T, R> extends Observable<R> {

    /* renamed from: b  reason: collision with root package name */
    public final SingleSource<T> f18339b;

    /* renamed from: c  reason: collision with root package name */
    public final Function<? super T, ? extends Iterable<? extends R>> f18340c;

    public static final class FlatMapIterableObserver<T, R> extends BasicIntQueueDisposable<R> implements SingleObserver<T> {
        private static final long serialVersionUID = -8938804753851907758L;

        /* renamed from: b  reason: collision with root package name */
        public final Observer<? super R> f18341b;

        /* renamed from: c  reason: collision with root package name */
        public final Function<? super T, ? extends Iterable<? extends R>> f18342c;

        /* renamed from: d  reason: collision with root package name */
        public Disposable f18343d;

        /* renamed from: e  reason: collision with root package name */
        public volatile Iterator<? extends R> f18344e;

        /* renamed from: f  reason: collision with root package name */
        public volatile boolean f18345f;

        /* renamed from: g  reason: collision with root package name */
        public boolean f18346g;

        public FlatMapIterableObserver(Observer<? super R> observer, Function<? super T, ? extends Iterable<? extends R>> function) {
            this.f18341b = observer;
            this.f18342c = function;
        }

        public void clear() {
            this.f18344e = null;
        }

        public void dispose() {
            this.f18345f = true;
            this.f18343d.dispose();
            this.f18343d = DisposableHelper.DISPOSED;
        }

        public boolean isDisposed() {
            return this.f18345f;
        }

        public boolean isEmpty() {
            return this.f18344e == null;
        }

        public void onError(Throwable th2) {
            this.f18343d = DisposableHelper.DISPOSED;
            this.f18341b.onError(th2);
        }

        public void onSubscribe(Disposable disposable) {
            if (DisposableHelper.validate(this.f18343d, disposable)) {
                this.f18343d = disposable;
                this.f18341b.onSubscribe(this);
            }
        }

        public void onSuccess(T t11) {
            Observer<? super R> observer = this.f18341b;
            try {
                Iterator<? extends R> it = ((Iterable) this.f18342c.apply(t11)).iterator();
                if (!it.hasNext()) {
                    observer.onComplete();
                } else if (this.f18346g) {
                    this.f18344e = it;
                    observer.onNext(null);
                    observer.onComplete();
                } else {
                    while (!this.f18345f) {
                        try {
                            observer.onNext(it.next());
                            if (!this.f18345f) {
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
                }
            } catch (Throwable th4) {
                Exceptions.throwIfFatal(th4);
                this.f18341b.onError(th4);
            }
        }

        @Nullable
        public R poll() throws Exception {
            Iterator<? extends R> it = this.f18344e;
            if (it == null) {
                return null;
            }
            R requireNonNull = ObjectHelper.requireNonNull(it.next(), "The iterator returned a null value");
            if (!it.hasNext()) {
                this.f18344e = null;
            }
            return requireNonNull;
        }

        public int requestFusion(int i11) {
            if ((i11 & 2) == 0) {
                return 0;
            }
            this.f18346g = true;
            return 2;
        }
    }

    public SingleFlatMapIterableObservable(SingleSource<T> singleSource, Function<? super T, ? extends Iterable<? extends R>> function) {
        this.f18339b = singleSource;
        this.f18340c = function;
    }

    public void subscribeActual(Observer<? super R> observer) {
        this.f18339b.subscribe(new FlatMapIterableObserver(observer, this.f18340c));
    }
}
