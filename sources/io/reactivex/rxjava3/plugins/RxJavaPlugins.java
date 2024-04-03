package io.reactivex.rxjava3.plugins;

import io.reactivex.rxjava3.annotations.NonNull;
import io.reactivex.rxjava3.annotations.Nullable;
import io.reactivex.rxjava3.core.Completable;
import io.reactivex.rxjava3.core.CompletableObserver;
import io.reactivex.rxjava3.core.Flowable;
import io.reactivex.rxjava3.core.Maybe;
import io.reactivex.rxjava3.core.MaybeObserver;
import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.core.Observer;
import io.reactivex.rxjava3.core.Scheduler;
import io.reactivex.rxjava3.core.Single;
import io.reactivex.rxjava3.core.SingleObserver;
import io.reactivex.rxjava3.exceptions.CompositeException;
import io.reactivex.rxjava3.exceptions.MissingBackpressureException;
import io.reactivex.rxjava3.exceptions.OnErrorNotImplementedException;
import io.reactivex.rxjava3.exceptions.UndeliverableException;
import io.reactivex.rxjava3.flowables.ConnectableFlowable;
import io.reactivex.rxjava3.functions.BiFunction;
import io.reactivex.rxjava3.functions.BooleanSupplier;
import io.reactivex.rxjava3.functions.Consumer;
import io.reactivex.rxjava3.functions.Function;
import io.reactivex.rxjava3.functions.Supplier;
import io.reactivex.rxjava3.internal.schedulers.ComputationScheduler;
import io.reactivex.rxjava3.internal.schedulers.ExecutorScheduler;
import io.reactivex.rxjava3.internal.schedulers.IoScheduler;
import io.reactivex.rxjava3.internal.schedulers.NewThreadScheduler;
import io.reactivex.rxjava3.internal.schedulers.SingleScheduler;
import io.reactivex.rxjava3.internal.util.ExceptionHelper;
import io.reactivex.rxjava3.observables.ConnectableObservable;
import io.reactivex.rxjava3.parallel.ParallelFlowable;
import java.util.Objects;
import java.util.concurrent.Executor;
import java.util.concurrent.ThreadFactory;
import org.reactivestreams.Subscriber;

public final class RxJavaPlugins {
    public static volatile boolean A;
    @Nullable

    /* renamed from: a  reason: collision with root package name */
    public static volatile Consumer<? super Throwable> f23238a;
    @Nullable

    /* renamed from: b  reason: collision with root package name */
    public static volatile Function<? super Runnable, ? extends Runnable> f23239b;
    @Nullable

    /* renamed from: c  reason: collision with root package name */
    public static volatile Function<? super Supplier<Scheduler>, ? extends Scheduler> f23240c;
    @Nullable

    /* renamed from: d  reason: collision with root package name */
    public static volatile Function<? super Supplier<Scheduler>, ? extends Scheduler> f23241d;
    @Nullable

    /* renamed from: e  reason: collision with root package name */
    public static volatile Function<? super Supplier<Scheduler>, ? extends Scheduler> f23242e;
    @Nullable

    /* renamed from: f  reason: collision with root package name */
    public static volatile Function<? super Supplier<Scheduler>, ? extends Scheduler> f23243f;
    @Nullable

    /* renamed from: g  reason: collision with root package name */
    public static volatile Function<? super Scheduler, ? extends Scheduler> f23244g;
    @Nullable

    /* renamed from: h  reason: collision with root package name */
    public static volatile Function<? super Scheduler, ? extends Scheduler> f23245h;
    @Nullable

    /* renamed from: i  reason: collision with root package name */
    public static volatile Function<? super Scheduler, ? extends Scheduler> f23246i;
    @Nullable

    /* renamed from: j  reason: collision with root package name */
    public static volatile Function<? super Scheduler, ? extends Scheduler> f23247j;
    @Nullable

    /* renamed from: k  reason: collision with root package name */
    public static volatile Function<? super Flowable, ? extends Flowable> f23248k;
    @Nullable

    /* renamed from: l  reason: collision with root package name */
    public static volatile Function<? super ConnectableFlowable, ? extends ConnectableFlowable> f23249l;
    @Nullable

    /* renamed from: m  reason: collision with root package name */
    public static volatile Function<? super Observable, ? extends Observable> f23250m;
    @Nullable

    /* renamed from: n  reason: collision with root package name */
    public static volatile Function<? super ConnectableObservable, ? extends ConnectableObservable> f23251n;
    @Nullable

    /* renamed from: o  reason: collision with root package name */
    public static volatile Function<? super Maybe, ? extends Maybe> f23252o;
    @Nullable

    /* renamed from: p  reason: collision with root package name */
    public static volatile Function<? super Single, ? extends Single> f23253p;
    @Nullable

    /* renamed from: q  reason: collision with root package name */
    public static volatile Function<? super Completable, ? extends Completable> f23254q;
    @Nullable

    /* renamed from: r  reason: collision with root package name */
    public static volatile Function<? super ParallelFlowable, ? extends ParallelFlowable> f23255r;
    @Nullable

    /* renamed from: s  reason: collision with root package name */
    public static volatile BiFunction<? super Flowable, ? super Subscriber, ? extends Subscriber> f23256s;
    @Nullable

    /* renamed from: t  reason: collision with root package name */
    public static volatile BiFunction<? super Maybe, ? super MaybeObserver, ? extends MaybeObserver> f23257t;
    @Nullable

    /* renamed from: u  reason: collision with root package name */
    public static volatile BiFunction<? super Observable, ? super Observer, ? extends Observer> f23258u;
    @Nullable

    /* renamed from: v  reason: collision with root package name */
    public static volatile BiFunction<? super Single, ? super SingleObserver, ? extends SingleObserver> f23259v;
    @Nullable

    /* renamed from: w  reason: collision with root package name */
    public static volatile BiFunction<? super Completable, ? super CompletableObserver, ? extends CompletableObserver> f23260w;
    @Nullable

    /* renamed from: x  reason: collision with root package name */
    public static volatile BiFunction<? super ParallelFlowable, ? super Subscriber[], ? extends Subscriber[]> f23261x;
    @Nullable

    /* renamed from: y  reason: collision with root package name */
    public static volatile BooleanSupplier f23262y;

    /* renamed from: z  reason: collision with root package name */
    public static volatile boolean f23263z;

    private RxJavaPlugins() {
        throw new IllegalStateException("No instances!");
    }

    @NonNull
    public static <T, U, R> R a(@NonNull BiFunction<T, U, R> biFunction, @NonNull T t11, @NonNull U u11) {
        try {
            return biFunction.apply(t11, u11);
        } catch (Throwable th2) {
            throw ExceptionHelper.wrapOrThrow(th2);
        }
    }

    @NonNull
    public static <T, R> R b(@NonNull Function<T, R> function, @NonNull T t11) {
        try {
            return function.apply(t11);
        } catch (Throwable th2) {
            throw ExceptionHelper.wrapOrThrow(th2);
        }
    }

    @NonNull
    public static Scheduler c(@NonNull Function<? super Supplier<Scheduler>, ? extends Scheduler> function, Supplier<Scheduler> supplier) {
        Object b11 = b(function, supplier);
        Objects.requireNonNull(b11, "Scheduler Supplier result can't be null");
        return (Scheduler) b11;
    }

    @NonNull
    public static Scheduler createComputationScheduler(@NonNull ThreadFactory threadFactory) {
        Objects.requireNonNull(threadFactory, "threadFactory is null");
        return new ComputationScheduler(threadFactory);
    }

    @NonNull
    public static Scheduler createExecutorScheduler(@NonNull Executor executor, boolean z11, boolean z12) {
        return new ExecutorScheduler(executor, z11, z12);
    }

    @NonNull
    public static Scheduler createIoScheduler(@NonNull ThreadFactory threadFactory) {
        Objects.requireNonNull(threadFactory, "threadFactory is null");
        return new IoScheduler(threadFactory);
    }

    @NonNull
    public static Scheduler createNewThreadScheduler(@NonNull ThreadFactory threadFactory) {
        Objects.requireNonNull(threadFactory, "threadFactory is null");
        return new NewThreadScheduler(threadFactory);
    }

    @NonNull
    public static Scheduler createSingleScheduler(@NonNull ThreadFactory threadFactory) {
        Objects.requireNonNull(threadFactory, "threadFactory is null");
        return new SingleScheduler(threadFactory);
    }

    @NonNull
    public static Scheduler d(@NonNull Supplier<Scheduler> supplier) {
        try {
            Scheduler scheduler = supplier.get();
            Objects.requireNonNull(scheduler, "Scheduler Supplier result can't be null");
            return scheduler;
        } catch (Throwable th2) {
            throw ExceptionHelper.wrapOrThrow(th2);
        }
    }

    public static boolean e(Throwable th2) {
        if (!(th2 instanceof OnErrorNotImplementedException) && !(th2 instanceof MissingBackpressureException) && !(th2 instanceof IllegalStateException) && !(th2 instanceof NullPointerException) && !(th2 instanceof IllegalArgumentException) && !(th2 instanceof CompositeException)) {
            return false;
        }
        return true;
    }

    public static void f(@NonNull Throwable th2) {
        Thread currentThread = Thread.currentThread();
        currentThread.getUncaughtExceptionHandler().uncaughtException(currentThread, th2);
    }

    @Nullable
    public static Function<? super Scheduler, ? extends Scheduler> getComputationSchedulerHandler() {
        return f23244g;
    }

    @Nullable
    public static Consumer<? super Throwable> getErrorHandler() {
        return f23238a;
    }

    @Nullable
    public static Function<? super Supplier<Scheduler>, ? extends Scheduler> getInitComputationSchedulerHandler() {
        return f23240c;
    }

    @Nullable
    public static Function<? super Supplier<Scheduler>, ? extends Scheduler> getInitIoSchedulerHandler() {
        return f23242e;
    }

    @Nullable
    public static Function<? super Supplier<Scheduler>, ? extends Scheduler> getInitNewThreadSchedulerHandler() {
        return f23243f;
    }

    @Nullable
    public static Function<? super Supplier<Scheduler>, ? extends Scheduler> getInitSingleSchedulerHandler() {
        return f23241d;
    }

    @Nullable
    public static Function<? super Scheduler, ? extends Scheduler> getIoSchedulerHandler() {
        return f23246i;
    }

    @Nullable
    public static Function<? super Scheduler, ? extends Scheduler> getNewThreadSchedulerHandler() {
        return f23247j;
    }

    @Nullable
    public static BooleanSupplier getOnBeforeBlocking() {
        return f23262y;
    }

    @Nullable
    public static Function<? super Completable, ? extends Completable> getOnCompletableAssembly() {
        return f23254q;
    }

    @Nullable
    public static BiFunction<? super Completable, ? super CompletableObserver, ? extends CompletableObserver> getOnCompletableSubscribe() {
        return f23260w;
    }

    @Nullable
    public static Function<? super ConnectableFlowable, ? extends ConnectableFlowable> getOnConnectableFlowableAssembly() {
        return f23249l;
    }

    @Nullable
    public static Function<? super ConnectableObservable, ? extends ConnectableObservable> getOnConnectableObservableAssembly() {
        return f23251n;
    }

    @Nullable
    public static Function<? super Flowable, ? extends Flowable> getOnFlowableAssembly() {
        return f23248k;
    }

    @Nullable
    public static BiFunction<? super Flowable, ? super Subscriber, ? extends Subscriber> getOnFlowableSubscribe() {
        return f23256s;
    }

    @Nullable
    public static Function<? super Maybe, ? extends Maybe> getOnMaybeAssembly() {
        return f23252o;
    }

    @Nullable
    public static BiFunction<? super Maybe, ? super MaybeObserver, ? extends MaybeObserver> getOnMaybeSubscribe() {
        return f23257t;
    }

    @Nullable
    public static Function<? super Observable, ? extends Observable> getOnObservableAssembly() {
        return f23250m;
    }

    @Nullable
    public static BiFunction<? super Observable, ? super Observer, ? extends Observer> getOnObservableSubscribe() {
        return f23258u;
    }

    @Nullable
    public static Function<? super ParallelFlowable, ? extends ParallelFlowable> getOnParallelAssembly() {
        return f23255r;
    }

    @Nullable
    public static BiFunction<? super ParallelFlowable, ? super Subscriber[], ? extends Subscriber[]> getOnParallelSubscribe() {
        return f23261x;
    }

    @Nullable
    public static Function<? super Single, ? extends Single> getOnSingleAssembly() {
        return f23253p;
    }

    @Nullable
    public static BiFunction<? super Single, ? super SingleObserver, ? extends SingleObserver> getOnSingleSubscribe() {
        return f23259v;
    }

    @Nullable
    public static Function<? super Runnable, ? extends Runnable> getScheduleHandler() {
        return f23239b;
    }

    @Nullable
    public static Function<? super Scheduler, ? extends Scheduler> getSingleSchedulerHandler() {
        return f23245h;
    }

    @NonNull
    public static Scheduler initComputationScheduler(@NonNull Supplier<Scheduler> supplier) {
        Objects.requireNonNull(supplier, "Scheduler Supplier can't be null");
        Function<? super Supplier<Scheduler>, ? extends Scheduler> function = f23240c;
        if (function == null) {
            return d(supplier);
        }
        return c(function, supplier);
    }

    @NonNull
    public static Scheduler initIoScheduler(@NonNull Supplier<Scheduler> supplier) {
        Objects.requireNonNull(supplier, "Scheduler Supplier can't be null");
        Function<? super Supplier<Scheduler>, ? extends Scheduler> function = f23242e;
        if (function == null) {
            return d(supplier);
        }
        return c(function, supplier);
    }

    @NonNull
    public static Scheduler initNewThreadScheduler(@NonNull Supplier<Scheduler> supplier) {
        Objects.requireNonNull(supplier, "Scheduler Supplier can't be null");
        Function<? super Supplier<Scheduler>, ? extends Scheduler> function = f23243f;
        if (function == null) {
            return d(supplier);
        }
        return c(function, supplier);
    }

    @NonNull
    public static Scheduler initSingleScheduler(@NonNull Supplier<Scheduler> supplier) {
        Objects.requireNonNull(supplier, "Scheduler Supplier can't be null");
        Function<? super Supplier<Scheduler>, ? extends Scheduler> function = f23241d;
        if (function == null) {
            return d(supplier);
        }
        return c(function, supplier);
    }

    public static boolean isFailOnNonBlockingScheduler() {
        return A;
    }

    public static boolean isLockdown() {
        return f23263z;
    }

    public static void lockdown() {
        f23263z = true;
    }

    @NonNull
    public static <T> Maybe<T> onAssembly(@NonNull Maybe<T> maybe) {
        Function<? super Maybe, ? extends Maybe> function = f23252o;
        return function != null ? (Maybe) b(function, maybe) : maybe;
    }

    public static boolean onBeforeBlocking() {
        BooleanSupplier booleanSupplier = f23262y;
        if (booleanSupplier == null) {
            return false;
        }
        try {
            return booleanSupplier.getAsBoolean();
        } catch (Throwable th2) {
            throw ExceptionHelper.wrapOrThrow(th2);
        }
    }

    @NonNull
    public static Scheduler onComputationScheduler(@NonNull Scheduler scheduler) {
        Function<? super Scheduler, ? extends Scheduler> function = f23244g;
        if (function == null) {
            return scheduler;
        }
        return (Scheduler) b(function, scheduler);
    }

    public static void onError(@NonNull Throwable th2) {
        Consumer<? super Throwable> consumer = f23238a;
        if (th2 == null) {
            th2 = ExceptionHelper.createNullPointerException("onError called with a null Throwable.");
        } else if (!e(th2)) {
            th2 = new UndeliverableException(th2);
        }
        if (consumer != null) {
            try {
                consumer.accept(th2);
                return;
            } catch (Throwable th3) {
                th3.printStackTrace();
                f(th3);
            }
        }
        th2.printStackTrace();
        f(th2);
    }

    @NonNull
    public static Scheduler onIoScheduler(@NonNull Scheduler scheduler) {
        Function<? super Scheduler, ? extends Scheduler> function = f23246i;
        if (function == null) {
            return scheduler;
        }
        return (Scheduler) b(function, scheduler);
    }

    @NonNull
    public static Scheduler onNewThreadScheduler(@NonNull Scheduler scheduler) {
        Function<? super Scheduler, ? extends Scheduler> function = f23247j;
        if (function == null) {
            return scheduler;
        }
        return (Scheduler) b(function, scheduler);
    }

    @NonNull
    public static Runnable onSchedule(@NonNull Runnable runnable) {
        Objects.requireNonNull(runnable, "run is null");
        Function<? super Runnable, ? extends Runnable> function = f23239b;
        if (function == null) {
            return runnable;
        }
        return (Runnable) b(function, runnable);
    }

    @NonNull
    public static Scheduler onSingleScheduler(@NonNull Scheduler scheduler) {
        Function<? super Scheduler, ? extends Scheduler> function = f23245h;
        if (function == null) {
            return scheduler;
        }
        return (Scheduler) b(function, scheduler);
    }

    @NonNull
    public static <T> Subscriber<? super T> onSubscribe(@NonNull Flowable<T> flowable, @NonNull Subscriber<? super T> subscriber) {
        BiFunction<? super Flowable, ? super Subscriber, ? extends Subscriber> biFunction = f23256s;
        return biFunction != null ? (Subscriber) a(biFunction, flowable, subscriber) : subscriber;
    }

    public static void reset() {
        setErrorHandler((Consumer<? super Throwable>) null);
        setScheduleHandler((Function<? super Runnable, ? extends Runnable>) null);
        setComputationSchedulerHandler((Function<? super Scheduler, ? extends Scheduler>) null);
        setInitComputationSchedulerHandler((Function<? super Supplier<Scheduler>, ? extends Scheduler>) null);
        setIoSchedulerHandler((Function<? super Scheduler, ? extends Scheduler>) null);
        setInitIoSchedulerHandler((Function<? super Supplier<Scheduler>, ? extends Scheduler>) null);
        setSingleSchedulerHandler((Function<? super Scheduler, ? extends Scheduler>) null);
        setInitSingleSchedulerHandler((Function<? super Supplier<Scheduler>, ? extends Scheduler>) null);
        setNewThreadSchedulerHandler((Function<? super Scheduler, ? extends Scheduler>) null);
        setInitNewThreadSchedulerHandler((Function<? super Supplier<Scheduler>, ? extends Scheduler>) null);
        setOnFlowableAssembly((Function<? super Flowable, ? extends Flowable>) null);
        setOnFlowableSubscribe((BiFunction<? super Flowable, ? super Subscriber, ? extends Subscriber>) null);
        setOnObservableAssembly((Function<? super Observable, ? extends Observable>) null);
        setOnObservableSubscribe((BiFunction<? super Observable, ? super Observer, ? extends Observer>) null);
        setOnSingleAssembly((Function<? super Single, ? extends Single>) null);
        setOnSingleSubscribe((BiFunction<? super Single, ? super SingleObserver, ? extends SingleObserver>) null);
        setOnCompletableAssembly((Function<? super Completable, ? extends Completable>) null);
        setOnCompletableSubscribe((BiFunction<? super Completable, ? super CompletableObserver, ? extends CompletableObserver>) null);
        setOnConnectableFlowableAssembly((Function<? super ConnectableFlowable, ? extends ConnectableFlowable>) null);
        setOnConnectableObservableAssembly((Function<? super ConnectableObservable, ? extends ConnectableObservable>) null);
        setOnMaybeAssembly((Function<? super Maybe, ? extends Maybe>) null);
        setOnMaybeSubscribe((BiFunction<? super Maybe, MaybeObserver, ? extends MaybeObserver>) null);
        setOnParallelAssembly((Function<? super ParallelFlowable, ? extends ParallelFlowable>) null);
        setOnParallelSubscribe((BiFunction<? super ParallelFlowable, ? super Subscriber[], ? extends Subscriber[]>) null);
        setFailOnNonBlockingScheduler(false);
        setOnBeforeBlocking((BooleanSupplier) null);
    }

    public static void setComputationSchedulerHandler(@Nullable Function<? super Scheduler, ? extends Scheduler> function) {
        if (!f23263z) {
            f23244g = function;
            return;
        }
        throw new IllegalStateException("Plugins can't be changed anymore");
    }

    public static void setErrorHandler(@Nullable Consumer<? super Throwable> consumer) {
        if (!f23263z) {
            f23238a = consumer;
            return;
        }
        throw new IllegalStateException("Plugins can't be changed anymore");
    }

    public static void setFailOnNonBlockingScheduler(boolean z11) {
        if (!f23263z) {
            A = z11;
            return;
        }
        throw new IllegalStateException("Plugins can't be changed anymore");
    }

    public static void setInitComputationSchedulerHandler(@Nullable Function<? super Supplier<Scheduler>, ? extends Scheduler> function) {
        if (!f23263z) {
            f23240c = function;
            return;
        }
        throw new IllegalStateException("Plugins can't be changed anymore");
    }

    public static void setInitIoSchedulerHandler(@Nullable Function<? super Supplier<Scheduler>, ? extends Scheduler> function) {
        if (!f23263z) {
            f23242e = function;
            return;
        }
        throw new IllegalStateException("Plugins can't be changed anymore");
    }

    public static void setInitNewThreadSchedulerHandler(@Nullable Function<? super Supplier<Scheduler>, ? extends Scheduler> function) {
        if (!f23263z) {
            f23243f = function;
            return;
        }
        throw new IllegalStateException("Plugins can't be changed anymore");
    }

    public static void setInitSingleSchedulerHandler(@Nullable Function<? super Supplier<Scheduler>, ? extends Scheduler> function) {
        if (!f23263z) {
            f23241d = function;
            return;
        }
        throw new IllegalStateException("Plugins can't be changed anymore");
    }

    public static void setIoSchedulerHandler(@Nullable Function<? super Scheduler, ? extends Scheduler> function) {
        if (!f23263z) {
            f23246i = function;
            return;
        }
        throw new IllegalStateException("Plugins can't be changed anymore");
    }

    public static void setNewThreadSchedulerHandler(@Nullable Function<? super Scheduler, ? extends Scheduler> function) {
        if (!f23263z) {
            f23247j = function;
            return;
        }
        throw new IllegalStateException("Plugins can't be changed anymore");
    }

    public static void setOnBeforeBlocking(@Nullable BooleanSupplier booleanSupplier) {
        if (!f23263z) {
            f23262y = booleanSupplier;
            return;
        }
        throw new IllegalStateException("Plugins can't be changed anymore");
    }

    public static void setOnCompletableAssembly(@Nullable Function<? super Completable, ? extends Completable> function) {
        if (!f23263z) {
            f23254q = function;
            return;
        }
        throw new IllegalStateException("Plugins can't be changed anymore");
    }

    public static void setOnCompletableSubscribe(@Nullable BiFunction<? super Completable, ? super CompletableObserver, ? extends CompletableObserver> biFunction) {
        if (!f23263z) {
            f23260w = biFunction;
            return;
        }
        throw new IllegalStateException("Plugins can't be changed anymore");
    }

    public static void setOnConnectableFlowableAssembly(@Nullable Function<? super ConnectableFlowable, ? extends ConnectableFlowable> function) {
        if (!f23263z) {
            f23249l = function;
            return;
        }
        throw new IllegalStateException("Plugins can't be changed anymore");
    }

    public static void setOnConnectableObservableAssembly(@Nullable Function<? super ConnectableObservable, ? extends ConnectableObservable> function) {
        if (!f23263z) {
            f23251n = function;
            return;
        }
        throw new IllegalStateException("Plugins can't be changed anymore");
    }

    public static void setOnFlowableAssembly(@Nullable Function<? super Flowable, ? extends Flowable> function) {
        if (!f23263z) {
            f23248k = function;
            return;
        }
        throw new IllegalStateException("Plugins can't be changed anymore");
    }

    public static void setOnFlowableSubscribe(@Nullable BiFunction<? super Flowable, ? super Subscriber, ? extends Subscriber> biFunction) {
        if (!f23263z) {
            f23256s = biFunction;
            return;
        }
        throw new IllegalStateException("Plugins can't be changed anymore");
    }

    public static void setOnMaybeAssembly(@Nullable Function<? super Maybe, ? extends Maybe> function) {
        if (!f23263z) {
            f23252o = function;
            return;
        }
        throw new IllegalStateException("Plugins can't be changed anymore");
    }

    public static void setOnMaybeSubscribe(@Nullable BiFunction<? super Maybe, MaybeObserver, ? extends MaybeObserver> biFunction) {
        if (!f23263z) {
            f23257t = biFunction;
            return;
        }
        throw new IllegalStateException("Plugins can't be changed anymore");
    }

    public static void setOnObservableAssembly(@Nullable Function<? super Observable, ? extends Observable> function) {
        if (!f23263z) {
            f23250m = function;
            return;
        }
        throw new IllegalStateException("Plugins can't be changed anymore");
    }

    public static void setOnObservableSubscribe(@Nullable BiFunction<? super Observable, ? super Observer, ? extends Observer> biFunction) {
        if (!f23263z) {
            f23258u = biFunction;
            return;
        }
        throw new IllegalStateException("Plugins can't be changed anymore");
    }

    public static void setOnParallelAssembly(@Nullable Function<? super ParallelFlowable, ? extends ParallelFlowable> function) {
        if (!f23263z) {
            f23255r = function;
            return;
        }
        throw new IllegalStateException("Plugins can't be changed anymore");
    }

    public static void setOnParallelSubscribe(@Nullable BiFunction<? super ParallelFlowable, ? super Subscriber[], ? extends Subscriber[]> biFunction) {
        if (!f23263z) {
            f23261x = biFunction;
            return;
        }
        throw new IllegalStateException("Plugins can't be changed anymore");
    }

    public static void setOnSingleAssembly(@Nullable Function<? super Single, ? extends Single> function) {
        if (!f23263z) {
            f23253p = function;
            return;
        }
        throw new IllegalStateException("Plugins can't be changed anymore");
    }

    public static void setOnSingleSubscribe(@Nullable BiFunction<? super Single, ? super SingleObserver, ? extends SingleObserver> biFunction) {
        if (!f23263z) {
            f23259v = biFunction;
            return;
        }
        throw new IllegalStateException("Plugins can't be changed anymore");
    }

    public static void setScheduleHandler(@Nullable Function<? super Runnable, ? extends Runnable> function) {
        if (!f23263z) {
            f23239b = function;
            return;
        }
        throw new IllegalStateException("Plugins can't be changed anymore");
    }

    public static void setSingleSchedulerHandler(@Nullable Function<? super Scheduler, ? extends Scheduler> function) {
        if (!f23263z) {
            f23245h = function;
            return;
        }
        throw new IllegalStateException("Plugins can't be changed anymore");
    }

    @NonNull
    public static <T> Flowable<T> onAssembly(@NonNull Flowable<T> flowable) {
        Function<? super Flowable, ? extends Flowable> function = f23248k;
        return function != null ? (Flowable) b(function, flowable) : flowable;
    }

    @NonNull
    public static <T> Observer<? super T> onSubscribe(@NonNull Observable<T> observable, @NonNull Observer<? super T> observer) {
        BiFunction<? super Observable, ? super Observer, ? extends Observer> biFunction = f23258u;
        return biFunction != null ? (Observer) a(biFunction, observable, observer) : observer;
    }

    @NonNull
    public static <T> ConnectableFlowable<T> onAssembly(@NonNull ConnectableFlowable<T> connectableFlowable) {
        Function<? super ConnectableFlowable, ? extends ConnectableFlowable> function = f23249l;
        return function != null ? (ConnectableFlowable) b(function, connectableFlowable) : connectableFlowable;
    }

    @NonNull
    public static <T> SingleObserver<? super T> onSubscribe(@NonNull Single<T> single, @NonNull SingleObserver<? super T> singleObserver) {
        BiFunction<? super Single, ? super SingleObserver, ? extends SingleObserver> biFunction = f23259v;
        return biFunction != null ? (SingleObserver) a(biFunction, single, singleObserver) : singleObserver;
    }

    @NonNull
    public static <T> Observable<T> onAssembly(@NonNull Observable<T> observable) {
        Function<? super Observable, ? extends Observable> function = f23250m;
        return function != null ? (Observable) b(function, observable) : observable;
    }

    @NonNull
    public static CompletableObserver onSubscribe(@NonNull Completable completable, @NonNull CompletableObserver completableObserver) {
        BiFunction<? super Completable, ? super CompletableObserver, ? extends CompletableObserver> biFunction = f23260w;
        return biFunction != null ? (CompletableObserver) a(biFunction, completable, completableObserver) : completableObserver;
    }

    @NonNull
    public static <T> ConnectableObservable<T> onAssembly(@NonNull ConnectableObservable<T> connectableObservable) {
        Function<? super ConnectableObservable, ? extends ConnectableObservable> function = f23251n;
        return function != null ? (ConnectableObservable) b(function, connectableObservable) : connectableObservable;
    }

    @NonNull
    public static <T> MaybeObserver<? super T> onSubscribe(@NonNull Maybe<T> maybe, @NonNull MaybeObserver<? super T> maybeObserver) {
        BiFunction<? super Maybe, ? super MaybeObserver, ? extends MaybeObserver> biFunction = f23257t;
        return biFunction != null ? (MaybeObserver) a(biFunction, maybe, maybeObserver) : maybeObserver;
    }

    @NonNull
    public static <T> Single<T> onAssembly(@NonNull Single<T> single) {
        Function<? super Single, ? extends Single> function = f23253p;
        return function != null ? (Single) b(function, single) : single;
    }

    @NonNull
    public static <T> Subscriber<? super T>[] onSubscribe(@NonNull ParallelFlowable<T> parallelFlowable, @NonNull Subscriber<? super T>[] subscriberArr) {
        BiFunction<? super ParallelFlowable, ? super Subscriber[], ? extends Subscriber[]> biFunction = f23261x;
        return biFunction != null ? (Subscriber[]) a(biFunction, parallelFlowable, subscriberArr) : subscriberArr;
    }

    @NonNull
    public static Completable onAssembly(@NonNull Completable completable) {
        Function<? super Completable, ? extends Completable> function = f23254q;
        return function != null ? (Completable) b(function, completable) : completable;
    }

    @NonNull
    public static <T> ParallelFlowable<T> onAssembly(@NonNull ParallelFlowable<T> parallelFlowable) {
        Function<? super ParallelFlowable, ? extends ParallelFlowable> function = f23255r;
        return function != null ? (ParallelFlowable) b(function, parallelFlowable) : parallelFlowable;
    }
}
