package io.reactivex.rxjava3.internal.operators.observable;

import io.reactivex.rxjava3.annotations.NonNull;
import io.reactivex.rxjava3.annotations.Nullable;
import io.reactivex.rxjava3.core.ObservableSource;
import io.reactivex.rxjava3.core.Observer;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.exceptions.Exceptions;
import io.reactivex.rxjava3.functions.Function;
import io.reactivex.rxjava3.internal.disposables.DisposableHelper;
import io.reactivex.rxjava3.internal.disposables.EmptyDisposable;
import io.reactivex.rxjava3.internal.util.AtomicThrowable;
import io.reactivex.rxjava3.internal.util.HalfSerializer;
import io.reactivex.rxjava3.plugins.RxJavaPlugins;
import java.util.Arrays;
import java.util.Objects;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;
import java.util.concurrent.atomic.AtomicReferenceArray;

public final class ObservableWithLatestFromMany<T, R> extends AbstractObservableWithUpstream<T, R> {
    @Nullable

    /* renamed from: c  reason: collision with root package name */
    public final ObservableSource<?>[] f22538c;
    @Nullable

    /* renamed from: d  reason: collision with root package name */
    public final Iterable<? extends ObservableSource<?>> f22539d;
    @NonNull

    /* renamed from: e  reason: collision with root package name */
    public final Function<? super Object[], R> f22540e;

    public final class SingletonArrayFunc implements Function<T, R> {
        public SingletonArrayFunc() {
        }

        public R apply(T t11) throws Throwable {
            R apply = ObservableWithLatestFromMany.this.f22540e.apply(new Object[]{t11});
            Objects.requireNonNull(apply, "The combiner returned a null value");
            return apply;
        }
    }

    public static final class WithLatestFromObserver<T, R> extends AtomicInteger implements Observer<T>, Disposable {
        private static final long serialVersionUID = 1577321883966341961L;

        /* renamed from: b  reason: collision with root package name */
        public final Observer<? super R> f22542b;

        /* renamed from: c  reason: collision with root package name */
        public final Function<? super Object[], R> f22543c;

        /* renamed from: d  reason: collision with root package name */
        public final WithLatestInnerObserver[] f22544d;

        /* renamed from: e  reason: collision with root package name */
        public final AtomicReferenceArray<Object> f22545e;

        /* renamed from: f  reason: collision with root package name */
        public final AtomicReference<Disposable> f22546f;

        /* renamed from: g  reason: collision with root package name */
        public final AtomicThrowable f22547g;

        /* renamed from: h  reason: collision with root package name */
        public volatile boolean f22548h;

        public WithLatestFromObserver(Observer<? super R> observer, Function<? super Object[], R> function, int i11) {
            this.f22542b = observer;
            this.f22543c = function;
            WithLatestInnerObserver[] withLatestInnerObserverArr = new WithLatestInnerObserver[i11];
            for (int i12 = 0; i12 < i11; i12++) {
                withLatestInnerObserverArr[i12] = new WithLatestInnerObserver(this, i12);
            }
            this.f22544d = withLatestInnerObserverArr;
            this.f22545e = new AtomicReferenceArray<>(i11);
            this.f22546f = new AtomicReference<>();
            this.f22547g = new AtomicThrowable();
        }

        public void a(int i11) {
            WithLatestInnerObserver[] withLatestInnerObserverArr = this.f22544d;
            for (int i12 = 0; i12 < withLatestInnerObserverArr.length; i12++) {
                if (i12 != i11) {
                    withLatestInnerObserverArr[i12].dispose();
                }
            }
        }

        public void b(int i11, boolean z11) {
            if (!z11) {
                this.f22548h = true;
                a(i11);
                HalfSerializer.onComplete((Observer<?>) this.f22542b, (AtomicInteger) this, this.f22547g);
            }
        }

        public void c(int i11, Throwable th2) {
            this.f22548h = true;
            DisposableHelper.dispose(this.f22546f);
            a(i11);
            HalfSerializer.onError((Observer<?>) this.f22542b, th2, (AtomicInteger) this, this.f22547g);
        }

        public void d(int i11, Object obj) {
            this.f22545e.set(i11, obj);
        }

        public void dispose() {
            DisposableHelper.dispose(this.f22546f);
            for (WithLatestInnerObserver dispose : this.f22544d) {
                dispose.dispose();
            }
        }

        public void e(ObservableSource<?>[] observableSourceArr, int i11) {
            WithLatestInnerObserver[] withLatestInnerObserverArr = this.f22544d;
            AtomicReference<Disposable> atomicReference = this.f22546f;
            for (int i12 = 0; i12 < i11 && !DisposableHelper.isDisposed(atomicReference.get()) && !this.f22548h; i12++) {
                observableSourceArr[i12].subscribe(withLatestInnerObserverArr[i12]);
            }
        }

        public boolean isDisposed() {
            return DisposableHelper.isDisposed(this.f22546f.get());
        }

        public void onComplete() {
            if (!this.f22548h) {
                this.f22548h = true;
                a(-1);
                HalfSerializer.onComplete((Observer<?>) this.f22542b, (AtomicInteger) this, this.f22547g);
            }
        }

        public void onError(Throwable th2) {
            if (this.f22548h) {
                RxJavaPlugins.onError(th2);
                return;
            }
            this.f22548h = true;
            a(-1);
            HalfSerializer.onError((Observer<?>) this.f22542b, th2, (AtomicInteger) this, this.f22547g);
        }

        public void onNext(T t11) {
            if (!this.f22548h) {
                AtomicReferenceArray<Object> atomicReferenceArray = this.f22545e;
                int length = atomicReferenceArray.length();
                Object[] objArr = new Object[(length + 1)];
                int i11 = 0;
                objArr[0] = t11;
                while (i11 < length) {
                    Object obj = atomicReferenceArray.get(i11);
                    if (obj != null) {
                        i11++;
                        objArr[i11] = obj;
                    } else {
                        return;
                    }
                }
                try {
                    R apply = this.f22543c.apply(objArr);
                    Objects.requireNonNull(apply, "combiner returned a null value");
                    HalfSerializer.onNext(this.f22542b, apply, (AtomicInteger) this, this.f22547g);
                } catch (Throwable th2) {
                    Exceptions.throwIfFatal(th2);
                    dispose();
                    onError(th2);
                }
            }
        }

        public void onSubscribe(Disposable disposable) {
            DisposableHelper.setOnce(this.f22546f, disposable);
        }
    }

    public static final class WithLatestInnerObserver extends AtomicReference<Disposable> implements Observer<Object> {
        private static final long serialVersionUID = 3256684027868224024L;

        /* renamed from: b  reason: collision with root package name */
        public final WithLatestFromObserver<?, ?> f22549b;

        /* renamed from: c  reason: collision with root package name */
        public final int f22550c;

        /* renamed from: d  reason: collision with root package name */
        public boolean f22551d;

        public WithLatestInnerObserver(WithLatestFromObserver<?, ?> withLatestFromObserver, int i11) {
            this.f22549b = withLatestFromObserver;
            this.f22550c = i11;
        }

        public void dispose() {
            DisposableHelper.dispose(this);
        }

        public void onComplete() {
            this.f22549b.b(this.f22550c, this.f22551d);
        }

        public void onError(Throwable th2) {
            this.f22549b.c(this.f22550c, th2);
        }

        public void onNext(Object obj) {
            if (!this.f22551d) {
                this.f22551d = true;
            }
            this.f22549b.d(this.f22550c, obj);
        }

        public void onSubscribe(Disposable disposable) {
            DisposableHelper.setOnce(this, disposable);
        }
    }

    public ObservableWithLatestFromMany(@NonNull ObservableSource<T> observableSource, @NonNull ObservableSource<?>[] observableSourceArr, @NonNull Function<? super Object[], R> function) {
        super(observableSource);
        this.f22538c = observableSourceArr;
        this.f22539d = null;
        this.f22540e = function;
    }

    public void subscribeActual(Observer<? super R> observer) {
        int i11;
        ObservableSource<?>[] observableSourceArr = this.f22538c;
        if (observableSourceArr == null) {
            observableSourceArr = new ObservableSource[8];
            try {
                i11 = 0;
                for (ObservableSource<?> observableSource : this.f22539d) {
                    if (i11 == observableSourceArr.length) {
                        observableSourceArr = (ObservableSource[]) Arrays.copyOf(observableSourceArr, (i11 >> 1) + i11);
                    }
                    int i12 = i11 + 1;
                    observableSourceArr[i11] = observableSource;
                    i11 = i12;
                }
            } catch (Throwable th2) {
                Exceptions.throwIfFatal(th2);
                EmptyDisposable.error(th2, (Observer<?>) observer);
                return;
            }
        } else {
            i11 = observableSourceArr.length;
        }
        if (i11 == 0) {
            new ObservableMap(this.f21304b, new SingletonArrayFunc()).subscribeActual(observer);
            return;
        }
        WithLatestFromObserver withLatestFromObserver = new WithLatestFromObserver(observer, this.f22540e, i11);
        observer.onSubscribe(withLatestFromObserver);
        withLatestFromObserver.e(observableSourceArr, i11);
        this.f21304b.subscribe(withLatestFromObserver);
    }

    public ObservableWithLatestFromMany(@NonNull ObservableSource<T> observableSource, @NonNull Iterable<? extends ObservableSource<?>> iterable, @NonNull Function<? super Object[], R> function) {
        super(observableSource);
        this.f22538c = null;
        this.f22539d = iterable;
        this.f22540e = function;
    }
}
