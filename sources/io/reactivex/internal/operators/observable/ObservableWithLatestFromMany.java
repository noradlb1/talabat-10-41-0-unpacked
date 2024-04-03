package io.reactivex.internal.operators.observable;

import io.reactivex.ObservableSource;
import io.reactivex.Observer;
import io.reactivex.annotations.NonNull;
import io.reactivex.annotations.Nullable;
import io.reactivex.disposables.Disposable;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.functions.Function;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.disposables.EmptyDisposable;
import io.reactivex.internal.functions.ObjectHelper;
import io.reactivex.internal.util.AtomicThrowable;
import io.reactivex.internal.util.HalfSerializer;
import io.reactivex.plugins.RxJavaPlugins;
import java.util.Arrays;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;
import java.util.concurrent.atomic.AtomicReferenceArray;

public final class ObservableWithLatestFromMany<T, R> extends AbstractObservableWithUpstream<T, R> {
    @Nullable

    /* renamed from: c  reason: collision with root package name */
    public final ObservableSource<?>[] f18007c;
    @Nullable

    /* renamed from: d  reason: collision with root package name */
    public final Iterable<? extends ObservableSource<?>> f18008d;
    @NonNull

    /* renamed from: e  reason: collision with root package name */
    public final Function<? super Object[], R> f18009e;

    public final class SingletonArrayFunc implements Function<T, R> {
        public SingletonArrayFunc() {
        }

        public R apply(T t11) throws Exception {
            return ObjectHelper.requireNonNull(ObservableWithLatestFromMany.this.f18009e.apply(new Object[]{t11}), "The combiner returned a null value");
        }
    }

    public static final class WithLatestFromObserver<T, R> extends AtomicInteger implements Observer<T>, Disposable {
        private static final long serialVersionUID = 1577321883966341961L;

        /* renamed from: b  reason: collision with root package name */
        public final Observer<? super R> f18011b;

        /* renamed from: c  reason: collision with root package name */
        public final Function<? super Object[], R> f18012c;

        /* renamed from: d  reason: collision with root package name */
        public final WithLatestInnerObserver[] f18013d;

        /* renamed from: e  reason: collision with root package name */
        public final AtomicReferenceArray<Object> f18014e;

        /* renamed from: f  reason: collision with root package name */
        public final AtomicReference<Disposable> f18015f;

        /* renamed from: g  reason: collision with root package name */
        public final AtomicThrowable f18016g;

        /* renamed from: h  reason: collision with root package name */
        public volatile boolean f18017h;

        public WithLatestFromObserver(Observer<? super R> observer, Function<? super Object[], R> function, int i11) {
            this.f18011b = observer;
            this.f18012c = function;
            WithLatestInnerObserver[] withLatestInnerObserverArr = new WithLatestInnerObserver[i11];
            for (int i12 = 0; i12 < i11; i12++) {
                withLatestInnerObserverArr[i12] = new WithLatestInnerObserver(this, i12);
            }
            this.f18013d = withLatestInnerObserverArr;
            this.f18014e = new AtomicReferenceArray<>(i11);
            this.f18015f = new AtomicReference<>();
            this.f18016g = new AtomicThrowable();
        }

        public void a(int i11) {
            WithLatestInnerObserver[] withLatestInnerObserverArr = this.f18013d;
            for (int i12 = 0; i12 < withLatestInnerObserverArr.length; i12++) {
                if (i12 != i11) {
                    withLatestInnerObserverArr[i12].dispose();
                }
            }
        }

        public void b(int i11, boolean z11) {
            if (!z11) {
                this.f18017h = true;
                a(i11);
                HalfSerializer.onComplete((Observer<?>) this.f18011b, (AtomicInteger) this, this.f18016g);
            }
        }

        public void c(int i11, Throwable th2) {
            this.f18017h = true;
            DisposableHelper.dispose(this.f18015f);
            a(i11);
            HalfSerializer.onError((Observer<?>) this.f18011b, th2, (AtomicInteger) this, this.f18016g);
        }

        public void d(int i11, Object obj) {
            this.f18014e.set(i11, obj);
        }

        public void dispose() {
            DisposableHelper.dispose(this.f18015f);
            for (WithLatestInnerObserver dispose : this.f18013d) {
                dispose.dispose();
            }
        }

        public void e(ObservableSource<?>[] observableSourceArr, int i11) {
            WithLatestInnerObserver[] withLatestInnerObserverArr = this.f18013d;
            AtomicReference<Disposable> atomicReference = this.f18015f;
            for (int i12 = 0; i12 < i11 && !DisposableHelper.isDisposed(atomicReference.get()) && !this.f18017h; i12++) {
                observableSourceArr[i12].subscribe(withLatestInnerObserverArr[i12]);
            }
        }

        public boolean isDisposed() {
            return DisposableHelper.isDisposed(this.f18015f.get());
        }

        public void onComplete() {
            if (!this.f18017h) {
                this.f18017h = true;
                a(-1);
                HalfSerializer.onComplete((Observer<?>) this.f18011b, (AtomicInteger) this, this.f18016g);
            }
        }

        public void onError(Throwable th2) {
            if (this.f18017h) {
                RxJavaPlugins.onError(th2);
                return;
            }
            this.f18017h = true;
            a(-1);
            HalfSerializer.onError((Observer<?>) this.f18011b, th2, (AtomicInteger) this, this.f18016g);
        }

        public void onNext(T t11) {
            if (!this.f18017h) {
                AtomicReferenceArray<Object> atomicReferenceArray = this.f18014e;
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
                    HalfSerializer.onNext(this.f18011b, ObjectHelper.requireNonNull(this.f18012c.apply(objArr), "combiner returned a null value"), (AtomicInteger) this, this.f18016g);
                } catch (Throwable th2) {
                    Exceptions.throwIfFatal(th2);
                    dispose();
                    onError(th2);
                }
            }
        }

        public void onSubscribe(Disposable disposable) {
            DisposableHelper.setOnce(this.f18015f, disposable);
        }
    }

    public static final class WithLatestInnerObserver extends AtomicReference<Disposable> implements Observer<Object> {
        private static final long serialVersionUID = 3256684027868224024L;

        /* renamed from: b  reason: collision with root package name */
        public final WithLatestFromObserver<?, ?> f18018b;

        /* renamed from: c  reason: collision with root package name */
        public final int f18019c;

        /* renamed from: d  reason: collision with root package name */
        public boolean f18020d;

        public WithLatestInnerObserver(WithLatestFromObserver<?, ?> withLatestFromObserver, int i11) {
            this.f18018b = withLatestFromObserver;
            this.f18019c = i11;
        }

        public void dispose() {
            DisposableHelper.dispose(this);
        }

        public void onComplete() {
            this.f18018b.b(this.f18019c, this.f18020d);
        }

        public void onError(Throwable th2) {
            this.f18018b.c(this.f18019c, th2);
        }

        public void onNext(Object obj) {
            if (!this.f18020d) {
                this.f18020d = true;
            }
            this.f18018b.d(this.f18019c, obj);
        }

        public void onSubscribe(Disposable disposable) {
            DisposableHelper.setOnce(this, disposable);
        }
    }

    public ObservableWithLatestFromMany(@NonNull ObservableSource<T> observableSource, @NonNull ObservableSource<?>[] observableSourceArr, @NonNull Function<? super Object[], R> function) {
        super(observableSource);
        this.f18007c = observableSourceArr;
        this.f18008d = null;
        this.f18009e = function;
    }

    public void subscribeActual(Observer<? super R> observer) {
        int i11;
        ObservableSource<?>[] observableSourceArr = this.f18007c;
        if (observableSourceArr == null) {
            observableSourceArr = new ObservableSource[8];
            try {
                i11 = 0;
                for (ObservableSource<?> observableSource : this.f18008d) {
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
            new ObservableMap(this.f16799b, new SingletonArrayFunc()).subscribeActual(observer);
            return;
        }
        WithLatestFromObserver withLatestFromObserver = new WithLatestFromObserver(observer, this.f18009e, i11);
        observer.onSubscribe(withLatestFromObserver);
        withLatestFromObserver.e(observableSourceArr, i11);
        this.f16799b.subscribe(withLatestFromObserver);
    }

    public ObservableWithLatestFromMany(@NonNull ObservableSource<T> observableSource, @NonNull Iterable<? extends ObservableSource<?>> iterable, @NonNull Function<? super Object[], R> function) {
        super(observableSource);
        this.f18007c = null;
        this.f18008d = iterable;
        this.f18009e = function;
    }
}
