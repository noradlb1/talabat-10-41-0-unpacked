package io.reactivex.rxjava3.internal.jdk8;

import io.reactivex.rxjava3.annotations.NonNull;
import io.reactivex.rxjava3.annotations.Nullable;
import io.reactivex.rxjava3.core.Maybe;
import io.reactivex.rxjava3.core.MaybeObserver;
import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.core.Observer;
import io.reactivex.rxjava3.core.SingleObserver;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.exceptions.Exceptions;
import io.reactivex.rxjava3.functions.Function;
import io.reactivex.rxjava3.internal.disposables.DisposableHelper;
import io.reactivex.rxjava3.internal.observers.BasicIntQueueDisposable;
import io.reactivex.rxjava3.plugins.RxJavaPlugins;
import j$.util.stream.Stream;
import java.util.Iterator;
import java.util.Objects;

public final class MaybeFlattenStreamAsObservable<T, R> extends Observable<R> {

    /* renamed from: b  reason: collision with root package name */
    public final Maybe<T> f18889b;

    /* renamed from: c  reason: collision with root package name */
    public final Function<? super T, ? extends Stream<? extends R>> f18890c;

    public static final class FlattenStreamMultiObserver<T, R> extends BasicIntQueueDisposable<R> implements MaybeObserver<T>, SingleObserver<T> {
        private static final long serialVersionUID = 7363336003027148283L;

        /* renamed from: b  reason: collision with root package name */
        public final Observer<? super R> f18891b;

        /* renamed from: c  reason: collision with root package name */
        public final Function<? super T, ? extends Stream<? extends R>> f18892c;

        /* renamed from: d  reason: collision with root package name */
        public Disposable f18893d;

        /* renamed from: e  reason: collision with root package name */
        public volatile Iterator<? extends R> f18894e;

        /* renamed from: f  reason: collision with root package name */
        public AutoCloseable f18895f;

        /* renamed from: g  reason: collision with root package name */
        public boolean f18896g;

        /* renamed from: h  reason: collision with root package name */
        public volatile boolean f18897h;

        /* renamed from: i  reason: collision with root package name */
        public boolean f18898i;

        public FlattenStreamMultiObserver(Observer<? super R> observer, Function<? super T, ? extends Stream<? extends R>> function) {
            this.f18891b = observer;
            this.f18892c = function;
        }

        public void a(AutoCloseable autoCloseable) {
            if (autoCloseable != null) {
                try {
                    autoCloseable.close();
                } catch (Throwable th2) {
                    Exceptions.throwIfFatal(th2);
                    RxJavaPlugins.onError(th2);
                }
            }
        }

        public void b() {
            if (getAndIncrement() == 0) {
                Observer<? super R> observer = this.f18891b;
                Iterator<? extends R> it = this.f18894e;
                int i11 = 1;
                while (true) {
                    if (this.f18897h) {
                        clear();
                    } else if (this.f18898i) {
                        observer.onNext(null);
                        observer.onComplete();
                    } else {
                        try {
                            Object next = it.next();
                            if (!this.f18897h) {
                                observer.onNext(next);
                                if (!this.f18897h) {
                                    try {
                                        boolean hasNext = it.hasNext();
                                        if (!this.f18897h && !hasNext) {
                                            observer.onComplete();
                                            this.f18897h = true;
                                        }
                                    } catch (Throwable th2) {
                                        Exceptions.throwIfFatal(th2);
                                        observer.onError(th2);
                                        this.f18897h = true;
                                    }
                                }
                            }
                        } catch (Throwable th3) {
                            Exceptions.throwIfFatal(th3);
                            observer.onError(th3);
                            this.f18897h = true;
                        }
                    }
                    i11 = addAndGet(-i11);
                    if (i11 == 0) {
                        return;
                    }
                }
            }
        }

        public void clear() {
            this.f18894e = null;
            AutoCloseable autoCloseable = this.f18895f;
            this.f18895f = null;
            a(autoCloseable);
        }

        public void dispose() {
            this.f18897h = true;
            this.f18893d.dispose();
            if (!this.f18898i) {
                b();
            }
        }

        public boolean isDisposed() {
            return this.f18897h;
        }

        public boolean isEmpty() {
            Iterator<? extends R> it = this.f18894e;
            if (it == null) {
                return true;
            }
            if (!this.f18896g || it.hasNext()) {
                return false;
            }
            clear();
            return true;
        }

        public void onComplete() {
            this.f18891b.onComplete();
        }

        public void onError(@NonNull Throwable th2) {
            this.f18891b.onError(th2);
        }

        public void onSubscribe(@NonNull Disposable disposable) {
            if (DisposableHelper.validate(this.f18893d, disposable)) {
                this.f18893d = disposable;
                this.f18891b.onSubscribe(this);
            }
        }

        public void onSuccess(@NonNull T t11) {
            try {
                Object apply = this.f18892c.apply(t11);
                Objects.requireNonNull(apply, "The mapper returned a null Stream");
                Stream stream = (Stream) apply;
                Iterator<? extends R> it = stream.iterator();
                if (!it.hasNext()) {
                    this.f18891b.onComplete();
                    a(stream);
                    return;
                }
                this.f18894e = it;
                this.f18895f = stream;
                b();
            } catch (Throwable th2) {
                Exceptions.throwIfFatal(th2);
                this.f18891b.onError(th2);
            }
        }

        @Nullable
        public R poll() throws Throwable {
            Iterator<? extends R> it = this.f18894e;
            if (it == null) {
                return null;
            }
            if (!this.f18896g) {
                this.f18896g = true;
            } else if (!it.hasNext()) {
                clear();
                return null;
            }
            return it.next();
        }

        public int requestFusion(int i11) {
            if ((i11 & 2) == 0) {
                return 0;
            }
            this.f18898i = true;
            return 2;
        }
    }

    public MaybeFlattenStreamAsObservable(Maybe<T> maybe, Function<? super T, ? extends Stream<? extends R>> function) {
        this.f18889b = maybe;
        this.f18890c = function;
    }

    public void subscribeActual(@NonNull Observer<? super R> observer) {
        this.f18889b.subscribe(new FlattenStreamMultiObserver(observer, this.f18890c));
    }
}
