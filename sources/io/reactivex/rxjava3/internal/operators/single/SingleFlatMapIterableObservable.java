package io.reactivex.rxjava3.internal.operators.single;

import io.reactivex.rxjava3.annotations.Nullable;
import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.core.Observer;
import io.reactivex.rxjava3.core.SingleObserver;
import io.reactivex.rxjava3.core.SingleSource;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.exceptions.Exceptions;
import io.reactivex.rxjava3.functions.Function;
import io.reactivex.rxjava3.internal.disposables.DisposableHelper;
import io.reactivex.rxjava3.internal.observers.BasicIntQueueDisposable;
import java.util.Iterator;
import java.util.Objects;

public final class SingleFlatMapIterableObservable<T, R> extends Observable<R> {

    /* renamed from: b  reason: collision with root package name */
    public final SingleSource<T> f22888b;

    /* renamed from: c  reason: collision with root package name */
    public final Function<? super T, ? extends Iterable<? extends R>> f22889c;

    public static final class FlatMapIterableObserver<T, R> extends BasicIntQueueDisposable<R> implements SingleObserver<T> {
        private static final long serialVersionUID = -8938804753851907758L;

        /* renamed from: b  reason: collision with root package name */
        public final Observer<? super R> f22890b;

        /* renamed from: c  reason: collision with root package name */
        public final Function<? super T, ? extends Iterable<? extends R>> f22891c;

        /* renamed from: d  reason: collision with root package name */
        public Disposable f22892d;

        /* renamed from: e  reason: collision with root package name */
        public volatile Iterator<? extends R> f22893e;

        /* renamed from: f  reason: collision with root package name */
        public volatile boolean f22894f;

        /* renamed from: g  reason: collision with root package name */
        public boolean f22895g;

        public FlatMapIterableObserver(Observer<? super R> observer, Function<? super T, ? extends Iterable<? extends R>> function) {
            this.f22890b = observer;
            this.f22891c = function;
        }

        public void clear() {
            this.f22893e = null;
        }

        public void dispose() {
            this.f22894f = true;
            this.f22892d.dispose();
            this.f22892d = DisposableHelper.DISPOSED;
        }

        public boolean isDisposed() {
            return this.f22894f;
        }

        public boolean isEmpty() {
            return this.f22893e == null;
        }

        public void onError(Throwable th2) {
            this.f22892d = DisposableHelper.DISPOSED;
            this.f22890b.onError(th2);
        }

        public void onSubscribe(Disposable disposable) {
            if (DisposableHelper.validate(this.f22892d, disposable)) {
                this.f22892d = disposable;
                this.f22890b.onSubscribe(this);
            }
        }

        public void onSuccess(T t11) {
            Observer<? super R> observer = this.f22890b;
            try {
                Iterator<? extends R> it = ((Iterable) this.f22891c.apply(t11)).iterator();
                if (!it.hasNext()) {
                    observer.onComplete();
                } else if (this.f22895g) {
                    this.f22893e = it;
                    observer.onNext(null);
                    observer.onComplete();
                } else {
                    while (!this.f22894f) {
                        try {
                            observer.onNext(it.next());
                            if (!this.f22894f) {
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
                this.f22890b.onError(th4);
            }
        }

        @Nullable
        public R poll() {
            Iterator<? extends R> it = this.f22893e;
            if (it == null) {
                return null;
            }
            R next = it.next();
            Objects.requireNonNull(next, "The iterator returned a null value");
            if (!it.hasNext()) {
                this.f22893e = null;
            }
            return next;
        }

        public int requestFusion(int i11) {
            if ((i11 & 2) == 0) {
                return 0;
            }
            this.f22895g = true;
            return 2;
        }
    }

    public SingleFlatMapIterableObservable(SingleSource<T> singleSource, Function<? super T, ? extends Iterable<? extends R>> function) {
        this.f22888b = singleSource;
        this.f22889c = function;
    }

    public void subscribeActual(Observer<? super R> observer) {
        this.f22888b.subscribe(new FlatMapIterableObserver(observer, this.f22889c));
    }
}
