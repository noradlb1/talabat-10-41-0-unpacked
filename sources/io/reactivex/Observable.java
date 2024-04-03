package io.reactivex;

import io.reactivex.annotations.BackpressureKind;
import io.reactivex.annotations.BackpressureSupport;
import io.reactivex.annotations.CheckReturnValue;
import io.reactivex.annotations.Experimental;
import io.reactivex.annotations.NonNull;
import io.reactivex.annotations.SchedulerSupport;
import io.reactivex.disposables.Disposable;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.functions.Action;
import io.reactivex.functions.BiConsumer;
import io.reactivex.functions.BiFunction;
import io.reactivex.functions.BiPredicate;
import io.reactivex.functions.BooleanSupplier;
import io.reactivex.functions.Consumer;
import io.reactivex.functions.Function;
import io.reactivex.functions.Function3;
import io.reactivex.functions.Function4;
import io.reactivex.functions.Function5;
import io.reactivex.functions.Function6;
import io.reactivex.functions.Function7;
import io.reactivex.functions.Function8;
import io.reactivex.functions.Function9;
import io.reactivex.functions.Predicate;
import io.reactivex.internal.functions.Functions;
import io.reactivex.internal.functions.ObjectHelper;
import io.reactivex.internal.fuseable.ScalarCallable;
import io.reactivex.internal.observers.BlockingFirstObserver;
import io.reactivex.internal.observers.BlockingLastObserver;
import io.reactivex.internal.observers.ForEachWhileObserver;
import io.reactivex.internal.observers.FutureObserver;
import io.reactivex.internal.observers.LambdaObserver;
import io.reactivex.internal.operators.flowable.FlowableFromObservable;
import io.reactivex.internal.operators.flowable.FlowableOnBackpressureError;
import io.reactivex.internal.operators.mixed.ObservableConcatMapCompletable;
import io.reactivex.internal.operators.mixed.ObservableConcatMapMaybe;
import io.reactivex.internal.operators.mixed.ObservableConcatMapSingle;
import io.reactivex.internal.operators.mixed.ObservableSwitchMapCompletable;
import io.reactivex.internal.operators.mixed.ObservableSwitchMapMaybe;
import io.reactivex.internal.operators.mixed.ObservableSwitchMapSingle;
import io.reactivex.internal.operators.observable.BlockingObservableIterable;
import io.reactivex.internal.operators.observable.BlockingObservableLatest;
import io.reactivex.internal.operators.observable.BlockingObservableMostRecent;
import io.reactivex.internal.operators.observable.BlockingObservableNext;
import io.reactivex.internal.operators.observable.ObservableAllSingle;
import io.reactivex.internal.operators.observable.ObservableAmb;
import io.reactivex.internal.operators.observable.ObservableAnySingle;
import io.reactivex.internal.operators.observable.ObservableBlockingSubscribe;
import io.reactivex.internal.operators.observable.ObservableBuffer;
import io.reactivex.internal.operators.observable.ObservableBufferBoundary;
import io.reactivex.internal.operators.observable.ObservableBufferBoundarySupplier;
import io.reactivex.internal.operators.observable.ObservableBufferExactBoundary;
import io.reactivex.internal.operators.observable.ObservableBufferTimed;
import io.reactivex.internal.operators.observable.ObservableCache;
import io.reactivex.internal.operators.observable.ObservableCollectSingle;
import io.reactivex.internal.operators.observable.ObservableCombineLatest;
import io.reactivex.internal.operators.observable.ObservableConcatMap;
import io.reactivex.internal.operators.observable.ObservableConcatMapEager;
import io.reactivex.internal.operators.observable.ObservableConcatWithCompletable;
import io.reactivex.internal.operators.observable.ObservableConcatWithMaybe;
import io.reactivex.internal.operators.observable.ObservableConcatWithSingle;
import io.reactivex.internal.operators.observable.ObservableCountSingle;
import io.reactivex.internal.operators.observable.ObservableCreate;
import io.reactivex.internal.operators.observable.ObservableDebounce;
import io.reactivex.internal.operators.observable.ObservableDebounceTimed;
import io.reactivex.internal.operators.observable.ObservableDefer;
import io.reactivex.internal.operators.observable.ObservableDelay;
import io.reactivex.internal.operators.observable.ObservableDelaySubscriptionOther;
import io.reactivex.internal.operators.observable.ObservableDematerialize;
import io.reactivex.internal.operators.observable.ObservableDetach;
import io.reactivex.internal.operators.observable.ObservableDistinct;
import io.reactivex.internal.operators.observable.ObservableDistinctUntilChanged;
import io.reactivex.internal.operators.observable.ObservableDoAfterNext;
import io.reactivex.internal.operators.observable.ObservableDoFinally;
import io.reactivex.internal.operators.observable.ObservableDoOnEach;
import io.reactivex.internal.operators.observable.ObservableDoOnLifecycle;
import io.reactivex.internal.operators.observable.ObservableElementAtMaybe;
import io.reactivex.internal.operators.observable.ObservableElementAtSingle;
import io.reactivex.internal.operators.observable.ObservableEmpty;
import io.reactivex.internal.operators.observable.ObservableError;
import io.reactivex.internal.operators.observable.ObservableFilter;
import io.reactivex.internal.operators.observable.ObservableFlatMap;
import io.reactivex.internal.operators.observable.ObservableFlatMapCompletableCompletable;
import io.reactivex.internal.operators.observable.ObservableFlatMapMaybe;
import io.reactivex.internal.operators.observable.ObservableFlatMapSingle;
import io.reactivex.internal.operators.observable.ObservableFlattenIterable;
import io.reactivex.internal.operators.observable.ObservableFromArray;
import io.reactivex.internal.operators.observable.ObservableFromCallable;
import io.reactivex.internal.operators.observable.ObservableFromFuture;
import io.reactivex.internal.operators.observable.ObservableFromIterable;
import io.reactivex.internal.operators.observable.ObservableFromPublisher;
import io.reactivex.internal.operators.observable.ObservableFromUnsafeSource;
import io.reactivex.internal.operators.observable.ObservableGenerate;
import io.reactivex.internal.operators.observable.ObservableGroupBy;
import io.reactivex.internal.operators.observable.ObservableGroupJoin;
import io.reactivex.internal.operators.observable.ObservableHide;
import io.reactivex.internal.operators.observable.ObservableIgnoreElements;
import io.reactivex.internal.operators.observable.ObservableIgnoreElementsCompletable;
import io.reactivex.internal.operators.observable.ObservableInternalHelper;
import io.reactivex.internal.operators.observable.ObservableInterval;
import io.reactivex.internal.operators.observable.ObservableIntervalRange;
import io.reactivex.internal.operators.observable.ObservableJoin;
import io.reactivex.internal.operators.observable.ObservableJust;
import io.reactivex.internal.operators.observable.ObservableLastMaybe;
import io.reactivex.internal.operators.observable.ObservableLastSingle;
import io.reactivex.internal.operators.observable.ObservableLift;
import io.reactivex.internal.operators.observable.ObservableMap;
import io.reactivex.internal.operators.observable.ObservableMapNotification;
import io.reactivex.internal.operators.observable.ObservableMaterialize;
import io.reactivex.internal.operators.observable.ObservableMergeWithCompletable;
import io.reactivex.internal.operators.observable.ObservableMergeWithMaybe;
import io.reactivex.internal.operators.observable.ObservableMergeWithSingle;
import io.reactivex.internal.operators.observable.ObservableNever;
import io.reactivex.internal.operators.observable.ObservableObserveOn;
import io.reactivex.internal.operators.observable.ObservableOnErrorNext;
import io.reactivex.internal.operators.observable.ObservableOnErrorReturn;
import io.reactivex.internal.operators.observable.ObservablePublish;
import io.reactivex.internal.operators.observable.ObservablePublishSelector;
import io.reactivex.internal.operators.observable.ObservableRange;
import io.reactivex.internal.operators.observable.ObservableRangeLong;
import io.reactivex.internal.operators.observable.ObservableReduceMaybe;
import io.reactivex.internal.operators.observable.ObservableReduceSeedSingle;
import io.reactivex.internal.operators.observable.ObservableReduceWithSingle;
import io.reactivex.internal.operators.observable.ObservableRepeat;
import io.reactivex.internal.operators.observable.ObservableRepeatUntil;
import io.reactivex.internal.operators.observable.ObservableRepeatWhen;
import io.reactivex.internal.operators.observable.ObservableReplay;
import io.reactivex.internal.operators.observable.ObservableRetryBiPredicate;
import io.reactivex.internal.operators.observable.ObservableRetryPredicate;
import io.reactivex.internal.operators.observable.ObservableRetryWhen;
import io.reactivex.internal.operators.observable.ObservableSampleTimed;
import io.reactivex.internal.operators.observable.ObservableSampleWithObservable;
import io.reactivex.internal.operators.observable.ObservableScalarXMap;
import io.reactivex.internal.operators.observable.ObservableScan;
import io.reactivex.internal.operators.observable.ObservableScanSeed;
import io.reactivex.internal.operators.observable.ObservableSequenceEqualSingle;
import io.reactivex.internal.operators.observable.ObservableSerialized;
import io.reactivex.internal.operators.observable.ObservableSingleMaybe;
import io.reactivex.internal.operators.observable.ObservableSingleSingle;
import io.reactivex.internal.operators.observable.ObservableSkip;
import io.reactivex.internal.operators.observable.ObservableSkipLast;
import io.reactivex.internal.operators.observable.ObservableSkipLastTimed;
import io.reactivex.internal.operators.observable.ObservableSkipUntil;
import io.reactivex.internal.operators.observable.ObservableSkipWhile;
import io.reactivex.internal.operators.observable.ObservableSubscribeOn;
import io.reactivex.internal.operators.observable.ObservableSwitchIfEmpty;
import io.reactivex.internal.operators.observable.ObservableSwitchMap;
import io.reactivex.internal.operators.observable.ObservableTake;
import io.reactivex.internal.operators.observable.ObservableTakeLast;
import io.reactivex.internal.operators.observable.ObservableTakeLastOne;
import io.reactivex.internal.operators.observable.ObservableTakeLastTimed;
import io.reactivex.internal.operators.observable.ObservableTakeUntil;
import io.reactivex.internal.operators.observable.ObservableTakeUntilPredicate;
import io.reactivex.internal.operators.observable.ObservableTakeWhile;
import io.reactivex.internal.operators.observable.ObservableThrottleFirstTimed;
import io.reactivex.internal.operators.observable.ObservableThrottleLatest;
import io.reactivex.internal.operators.observable.ObservableTimeInterval;
import io.reactivex.internal.operators.observable.ObservableTimeout;
import io.reactivex.internal.operators.observable.ObservableTimeoutTimed;
import io.reactivex.internal.operators.observable.ObservableTimer;
import io.reactivex.internal.operators.observable.ObservableToList;
import io.reactivex.internal.operators.observable.ObservableToListSingle;
import io.reactivex.internal.operators.observable.ObservableUnsubscribeOn;
import io.reactivex.internal.operators.observable.ObservableUsing;
import io.reactivex.internal.operators.observable.ObservableWindow;
import io.reactivex.internal.operators.observable.ObservableWindowBoundary;
import io.reactivex.internal.operators.observable.ObservableWindowBoundarySelector;
import io.reactivex.internal.operators.observable.ObservableWindowBoundarySupplier;
import io.reactivex.internal.operators.observable.ObservableWindowTimed;
import io.reactivex.internal.operators.observable.ObservableWithLatestFrom;
import io.reactivex.internal.operators.observable.ObservableWithLatestFromMany;
import io.reactivex.internal.operators.observable.ObservableZip;
import io.reactivex.internal.operators.observable.ObservableZipIterable;
import io.reactivex.internal.util.ArrayListSupplier;
import io.reactivex.internal.util.ErrorMode;
import io.reactivex.internal.util.ExceptionHelper;
import io.reactivex.internal.util.HashMapSupplier;
import io.reactivex.observables.ConnectableObservable;
import io.reactivex.observables.GroupedObservable;
import io.reactivex.observers.SafeObserver;
import io.reactivex.observers.TestObserver;
import io.reactivex.plugins.RxJavaPlugins;
import io.reactivex.schedulers.Schedulers;
import io.reactivex.schedulers.Timed;
import java.util.Collection;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.concurrent.Callable;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import org.reactivestreams.Publisher;

public abstract class Observable<T> implements ObservableSource<T> {

    /* renamed from: io.reactivex.Observable$1  reason: invalid class name */
    public static /* synthetic */ class AnonymousClass1 {

        /* renamed from: a  reason: collision with root package name */
        public static final /* synthetic */ int[] f14478a;

        /* JADX WARNING: Can't wrap try/catch for region: R(8:0|1|2|3|4|5|6|(3:7|8|10)) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0012 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x001d */
        /* JADX WARNING: Missing exception handler attribute for start block: B:7:0x0028 */
        static {
            /*
                io.reactivex.BackpressureStrategy[] r0 = io.reactivex.BackpressureStrategy.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                f14478a = r0
                io.reactivex.BackpressureStrategy r1 = io.reactivex.BackpressureStrategy.DROP     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                int[] r0 = f14478a     // Catch:{ NoSuchFieldError -> 0x001d }
                io.reactivex.BackpressureStrategy r1 = io.reactivex.BackpressureStrategy.LATEST     // Catch:{ NoSuchFieldError -> 0x001d }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                int[] r0 = f14478a     // Catch:{ NoSuchFieldError -> 0x0028 }
                io.reactivex.BackpressureStrategy r1 = io.reactivex.BackpressureStrategy.MISSING     // Catch:{ NoSuchFieldError -> 0x0028 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0028 }
                r2 = 3
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0028 }
            L_0x0028:
                int[] r0 = f14478a     // Catch:{ NoSuchFieldError -> 0x0033 }
                io.reactivex.BackpressureStrategy r1 = io.reactivex.BackpressureStrategy.ERROR     // Catch:{ NoSuchFieldError -> 0x0033 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0033 }
                r2 = 4
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0033 }
            L_0x0033:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: io.reactivex.Observable.AnonymousClass1.<clinit>():void");
        }
    }

    @CheckReturnValue
    @NonNull
    @SchedulerSupport("none")
    public static <T> Observable<T> amb(Iterable<? extends ObservableSource<? extends T>> iterable) {
        ObjectHelper.requireNonNull(iterable, "sources is null");
        return RxJavaPlugins.onAssembly(new ObservableAmb((ObservableSource<? extends T>[]) null, iterable));
    }

    @CheckReturnValue
    @NonNull
    @SchedulerSupport("none")
    public static <T> Observable<T> ambArray(ObservableSource<? extends T>... observableSourceArr) {
        ObjectHelper.requireNonNull(observableSourceArr, "sources is null");
        int length = observableSourceArr.length;
        if (length == 0) {
            return empty();
        }
        if (length == 1) {
            return wrap(observableSourceArr[0]);
        }
        return RxJavaPlugins.onAssembly(new ObservableAmb(observableSourceArr, (Iterable) null));
    }

    public static int bufferSize() {
        return Flowable.bufferSize();
    }

    @CheckReturnValue
    @SchedulerSupport("none")
    public static <T, R> Observable<R> combineLatest(Function<? super Object[], ? extends R> function, int i11, ObservableSource<? extends T>... observableSourceArr) {
        return combineLatest(observableSourceArr, function, i11);
    }

    @CheckReturnValue
    @SchedulerSupport("none")
    public static <T, R> Observable<R> combineLatestDelayError(ObservableSource<? extends T>[] observableSourceArr, Function<? super Object[], ? extends R> function) {
        return combineLatestDelayError(observableSourceArr, function, bufferSize());
    }

    @CheckReturnValue
    @NonNull
    @SchedulerSupport("none")
    public static <T> Observable<T> concat(Iterable<? extends ObservableSource<? extends T>> iterable) {
        ObjectHelper.requireNonNull(iterable, "sources is null");
        return fromIterable(iterable).concatMapDelayError(Functions.identity(), bufferSize(), false);
    }

    @CheckReturnValue
    @SchedulerSupport("none")
    public static <T> Observable<T> concatArray(ObservableSource<? extends T>... observableSourceArr) {
        if (observableSourceArr.length == 0) {
            return empty();
        }
        if (observableSourceArr.length == 1) {
            return wrap(observableSourceArr[0]);
        }
        return RxJavaPlugins.onAssembly(new ObservableConcatMap(fromArray(observableSourceArr), Functions.identity(), bufferSize(), ErrorMode.BOUNDARY));
    }

    @CheckReturnValue
    @SchedulerSupport("none")
    public static <T> Observable<T> concatArrayDelayError(ObservableSource<? extends T>... observableSourceArr) {
        if (observableSourceArr.length == 0) {
            return empty();
        }
        if (observableSourceArr.length == 1) {
            return wrap(observableSourceArr[0]);
        }
        return concatDelayError(fromArray(observableSourceArr));
    }

    @CheckReturnValue
    @SchedulerSupport("none")
    public static <T> Observable<T> concatArrayEager(ObservableSource<? extends T>... observableSourceArr) {
        return concatArrayEager(bufferSize(), bufferSize(), observableSourceArr);
    }

    @CheckReturnValue
    @SchedulerSupport("none")
    public static <T> Observable<T> concatArrayEagerDelayError(ObservableSource<? extends T>... observableSourceArr) {
        return concatArrayEagerDelayError(bufferSize(), bufferSize(), observableSourceArr);
    }

    @CheckReturnValue
    @NonNull
    @SchedulerSupport("none")
    public static <T> Observable<T> concatDelayError(Iterable<? extends ObservableSource<? extends T>> iterable) {
        ObjectHelper.requireNonNull(iterable, "sources is null");
        return concatDelayError(fromIterable(iterable));
    }

    @CheckReturnValue
    @SchedulerSupport("none")
    public static <T> Observable<T> concatEager(ObservableSource<? extends ObservableSource<? extends T>> observableSource) {
        return concatEager(observableSource, bufferSize(), bufferSize());
    }

    @CheckReturnValue
    @NonNull
    @SchedulerSupport("none")
    public static <T> Observable<T> create(ObservableOnSubscribe<T> observableOnSubscribe) {
        ObjectHelper.requireNonNull(observableOnSubscribe, "source is null");
        return RxJavaPlugins.onAssembly(new ObservableCreate(observableOnSubscribe));
    }

    @CheckReturnValue
    @NonNull
    @SchedulerSupport("none")
    public static <T> Observable<T> defer(Callable<? extends ObservableSource<? extends T>> callable) {
        ObjectHelper.requireNonNull(callable, "supplier is null");
        return RxJavaPlugins.onAssembly(new ObservableDefer(callable));
    }

    @CheckReturnValue
    @SchedulerSupport("none")
    private Observable<T> doOnEach(Consumer<? super T> consumer, Consumer<? super Throwable> consumer2, Action action, Action action2) {
        ObjectHelper.requireNonNull(consumer, "onNext is null");
        ObjectHelper.requireNonNull(consumer2, "onError is null");
        ObjectHelper.requireNonNull(action, "onComplete is null");
        ObjectHelper.requireNonNull(action2, "onAfterTerminate is null");
        return RxJavaPlugins.onAssembly(new ObservableDoOnEach(this, consumer, consumer2, action, action2));
    }

    @CheckReturnValue
    @SchedulerSupport("none")
    public static <T> Observable<T> empty() {
        return RxJavaPlugins.onAssembly(ObservableEmpty.INSTANCE);
    }

    @CheckReturnValue
    @NonNull
    @SchedulerSupport("none")
    public static <T> Observable<T> error(Callable<? extends Throwable> callable) {
        ObjectHelper.requireNonNull(callable, "errorSupplier is null");
        return RxJavaPlugins.onAssembly(new ObservableError(callable));
    }

    @CheckReturnValue
    @NonNull
    @SchedulerSupport("none")
    public static <T> Observable<T> fromArray(T... tArr) {
        ObjectHelper.requireNonNull(tArr, "items is null");
        if (tArr.length == 0) {
            return empty();
        }
        if (tArr.length == 1) {
            return just(tArr[0]);
        }
        return RxJavaPlugins.onAssembly(new ObservableFromArray(tArr));
    }

    @CheckReturnValue
    @NonNull
    @SchedulerSupport("none")
    public static <T> Observable<T> fromCallable(Callable<? extends T> callable) {
        ObjectHelper.requireNonNull(callable, "supplier is null");
        return RxJavaPlugins.onAssembly(new ObservableFromCallable(callable));
    }

    @CheckReturnValue
    @NonNull
    @SchedulerSupport("none")
    public static <T> Observable<T> fromFuture(Future<? extends T> future) {
        ObjectHelper.requireNonNull(future, "future is null");
        return RxJavaPlugins.onAssembly(new ObservableFromFuture(future, 0, (TimeUnit) null));
    }

    @CheckReturnValue
    @NonNull
    @SchedulerSupport("none")
    public static <T> Observable<T> fromIterable(Iterable<? extends T> iterable) {
        ObjectHelper.requireNonNull(iterable, "source is null");
        return RxJavaPlugins.onAssembly(new ObservableFromIterable(iterable));
    }

    @CheckReturnValue
    @BackpressureSupport(BackpressureKind.UNBOUNDED_IN)
    @NonNull
    @SchedulerSupport("none")
    public static <T> Observable<T> fromPublisher(Publisher<? extends T> publisher) {
        ObjectHelper.requireNonNull(publisher, "publisher is null");
        return RxJavaPlugins.onAssembly(new ObservableFromPublisher(publisher));
    }

    @CheckReturnValue
    @NonNull
    @SchedulerSupport("none")
    public static <T> Observable<T> generate(Consumer<Emitter<T>> consumer) {
        ObjectHelper.requireNonNull(consumer, "generator is null");
        return generate(Functions.nullSupplier(), ObservableInternalHelper.simpleGenerator(consumer), Functions.emptyConsumer());
    }

    @CheckReturnValue
    @SchedulerSupport("io.reactivex:computation")
    public static Observable<Long> interval(long j11, long j12, TimeUnit timeUnit) {
        return interval(j11, j12, timeUnit, Schedulers.computation());
    }

    @CheckReturnValue
    @SchedulerSupport("io.reactivex:computation")
    public static Observable<Long> intervalRange(long j11, long j12, long j13, long j14, TimeUnit timeUnit) {
        return intervalRange(j11, j12, j13, j14, timeUnit, Schedulers.computation());
    }

    @CheckReturnValue
    @NonNull
    @SchedulerSupport("none")
    public static <T> Observable<T> just(T t11) {
        ObjectHelper.requireNonNull(t11, "item is null");
        return RxJavaPlugins.onAssembly(new ObservableJust(t11));
    }

    @CheckReturnValue
    @SchedulerSupport("none")
    public static <T> Observable<T> merge(Iterable<? extends ObservableSource<? extends T>> iterable, int i11, int i12) {
        return fromIterable(iterable).flatMap(Functions.identity(), false, i11, i12);
    }

    @CheckReturnValue
    @SchedulerSupport("none")
    public static <T> Observable<T> mergeArray(int i11, int i12, ObservableSource<? extends T>... observableSourceArr) {
        return fromArray(observableSourceArr).flatMap(Functions.identity(), false, i11, i12);
    }

    @CheckReturnValue
    @SchedulerSupport("none")
    public static <T> Observable<T> mergeArrayDelayError(int i11, int i12, ObservableSource<? extends T>... observableSourceArr) {
        return fromArray(observableSourceArr).flatMap(Functions.identity(), true, i11, i12);
    }

    @CheckReturnValue
    @SchedulerSupport("none")
    public static <T> Observable<T> mergeDelayError(Iterable<? extends ObservableSource<? extends T>> iterable) {
        return fromIterable(iterable).flatMap(Functions.identity(), true);
    }

    @CheckReturnValue
    @SchedulerSupport("none")
    public static <T> Observable<T> never() {
        return RxJavaPlugins.onAssembly(ObservableNever.INSTANCE);
    }

    @CheckReturnValue
    @SchedulerSupport("none")
    public static Observable<Integer> range(int i11, int i12) {
        if (i12 < 0) {
            throw new IllegalArgumentException("count >= 0 required but it was " + i12);
        } else if (i12 == 0) {
            return empty();
        } else {
            if (i12 == 1) {
                return just(Integer.valueOf(i11));
            }
            if (((long) i11) + ((long) (i12 - 1)) <= 2147483647L) {
                return RxJavaPlugins.onAssembly(new ObservableRange(i11, i12));
            }
            throw new IllegalArgumentException("Integer overflow");
        }
    }

    @CheckReturnValue
    @SchedulerSupport("none")
    public static Observable<Long> rangeLong(long j11, long j12) {
        int i11 = (j12 > 0 ? 1 : (j12 == 0 ? 0 : -1));
        if (i11 < 0) {
            throw new IllegalArgumentException("count >= 0 required but it was " + j12);
        } else if (i11 == 0) {
            return empty();
        } else {
            if (j12 == 1) {
                return just(Long.valueOf(j11));
            }
            long j13 = (j12 - 1) + j11;
            if (j11 <= 0 || j13 >= 0) {
                return RxJavaPlugins.onAssembly(new ObservableRangeLong(j11, j12));
            }
            throw new IllegalArgumentException("Overflow! start + count is bigger than Long.MAX_VALUE");
        }
    }

    @CheckReturnValue
    @SchedulerSupport("none")
    public static <T> Single<Boolean> sequenceEqual(ObservableSource<? extends T> observableSource, ObservableSource<? extends T> observableSource2) {
        return sequenceEqual(observableSource, observableSource2, ObjectHelper.equalsPredicate(), bufferSize());
    }

    @CheckReturnValue
    @SchedulerSupport("none")
    public static <T> Observable<T> switchOnNext(ObservableSource<? extends ObservableSource<? extends T>> observableSource, int i11) {
        ObjectHelper.requireNonNull(observableSource, "sources is null");
        ObjectHelper.verifyPositive(i11, "bufferSize");
        return RxJavaPlugins.onAssembly(new ObservableSwitchMap(observableSource, Functions.identity(), i11, false));
    }

    @CheckReturnValue
    @SchedulerSupport("none")
    public static <T> Observable<T> switchOnNextDelayError(ObservableSource<? extends ObservableSource<? extends T>> observableSource) {
        return switchOnNextDelayError(observableSource, bufferSize());
    }

    private Observable<T> timeout0(long j11, TimeUnit timeUnit, ObservableSource<? extends T> observableSource, Scheduler scheduler) {
        ObjectHelper.requireNonNull(timeUnit, "timeUnit is null");
        ObjectHelper.requireNonNull(scheduler, "scheduler is null");
        return RxJavaPlugins.onAssembly(new ObservableTimeoutTimed(this, j11, timeUnit, scheduler, observableSource));
    }

    @CheckReturnValue
    @SchedulerSupport("io.reactivex:computation")
    public static Observable<Long> timer(long j11, TimeUnit timeUnit) {
        return timer(j11, timeUnit, Schedulers.computation());
    }

    @CheckReturnValue
    @SchedulerSupport("none")
    public static <T> Observable<T> unsafeCreate(ObservableSource<T> observableSource) {
        ObjectHelper.requireNonNull(observableSource, "onSubscribe is null");
        if (!(observableSource instanceof Observable)) {
            return RxJavaPlugins.onAssembly(new ObservableFromUnsafeSource(observableSource));
        }
        throw new IllegalArgumentException("unsafeCreate(Observable) should be upgraded");
    }

    @CheckReturnValue
    @SchedulerSupport("none")
    public static <T, D> Observable<T> using(Callable<? extends D> callable, Function<? super D, ? extends ObservableSource<? extends T>> function, Consumer<? super D> consumer) {
        return using(callable, function, consumer, true);
    }

    @CheckReturnValue
    @SchedulerSupport("none")
    public static <T> Observable<T> wrap(ObservableSource<T> observableSource) {
        ObjectHelper.requireNonNull(observableSource, "source is null");
        if (observableSource instanceof Observable) {
            return RxJavaPlugins.onAssembly((Observable) observableSource);
        }
        return RxJavaPlugins.onAssembly(new ObservableFromUnsafeSource(observableSource));
    }

    @CheckReturnValue
    @SchedulerSupport("none")
    public static <T, R> Observable<R> zip(Iterable<? extends ObservableSource<? extends T>> iterable, Function<? super Object[], ? extends R> function) {
        ObjectHelper.requireNonNull(function, "zipper is null");
        ObjectHelper.requireNonNull(iterable, "sources is null");
        return RxJavaPlugins.onAssembly(new ObservableZip((ObservableSource<? extends T>[]) null, iterable, function, bufferSize(), false));
    }

    @CheckReturnValue
    @SchedulerSupport("none")
    public static <T, R> Observable<R> zipArray(Function<? super Object[], ? extends R> function, boolean z11, int i11, ObservableSource<? extends T>... observableSourceArr) {
        if (observableSourceArr.length == 0) {
            return empty();
        }
        ObjectHelper.requireNonNull(function, "zipper is null");
        ObjectHelper.verifyPositive(i11, "bufferSize");
        return RxJavaPlugins.onAssembly(new ObservableZip(observableSourceArr, (Iterable) null, function, i11, z11));
    }

    @CheckReturnValue
    @SchedulerSupport("none")
    public static <T, R> Observable<R> zipIterable(Iterable<? extends ObservableSource<? extends T>> iterable, Function<? super Object[], ? extends R> function, boolean z11, int i11) {
        ObjectHelper.requireNonNull(function, "zipper is null");
        ObjectHelper.requireNonNull(iterable, "sources is null");
        ObjectHelper.verifyPositive(i11, "bufferSize");
        return RxJavaPlugins.onAssembly(new ObservableZip((ObservableSource<? extends T>[]) null, iterable, function, i11, z11));
    }

    @CheckReturnValue
    @SchedulerSupport("none")
    public final Single<Boolean> all(Predicate<? super T> predicate) {
        ObjectHelper.requireNonNull(predicate, "predicate is null");
        return RxJavaPlugins.onAssembly(new ObservableAllSingle(this, predicate));
    }

    @CheckReturnValue
    @SchedulerSupport("none")
    public final Observable<T> ambWith(ObservableSource<? extends T> observableSource) {
        ObjectHelper.requireNonNull(observableSource, "other is null");
        return ambArray(this, observableSource);
    }

    @CheckReturnValue
    @SchedulerSupport("none")
    public final Single<Boolean> any(Predicate<? super T> predicate) {
        ObjectHelper.requireNonNull(predicate, "predicate is null");
        return RxJavaPlugins.onAssembly(new ObservableAnySingle(this, predicate));
    }

    @CheckReturnValue
    @SchedulerSupport("none")
    public final <R> R as(@NonNull ObservableConverter<T, ? extends R> observableConverter) {
        return ((ObservableConverter) ObjectHelper.requireNonNull(observableConverter, "converter is null")).apply(this);
    }

    @CheckReturnValue
    @SchedulerSupport("none")
    public final T blockingFirst() {
        BlockingFirstObserver blockingFirstObserver = new BlockingFirstObserver();
        subscribe(blockingFirstObserver);
        T blockingGet = blockingFirstObserver.blockingGet();
        if (blockingGet != null) {
            return blockingGet;
        }
        throw new NoSuchElementException();
    }

    @SchedulerSupport("none")
    public final void blockingForEach(Consumer<? super T> consumer) {
        Iterator it = blockingIterable().iterator();
        while (it.hasNext()) {
            try {
                consumer.accept(it.next());
            } catch (Throwable th2) {
                Exceptions.throwIfFatal(th2);
                ((Disposable) it).dispose();
                throw ExceptionHelper.wrapOrThrow(th2);
            }
        }
    }

    @CheckReturnValue
    @SchedulerSupport("none")
    public final Iterable<T> blockingIterable() {
        return blockingIterable(bufferSize());
    }

    @CheckReturnValue
    @SchedulerSupport("none")
    public final T blockingLast() {
        BlockingLastObserver blockingLastObserver = new BlockingLastObserver();
        subscribe(blockingLastObserver);
        T blockingGet = blockingLastObserver.blockingGet();
        if (blockingGet != null) {
            return blockingGet;
        }
        throw new NoSuchElementException();
    }

    @CheckReturnValue
    @SchedulerSupport("none")
    public final Iterable<T> blockingLatest() {
        return new BlockingObservableLatest(this);
    }

    @CheckReturnValue
    @SchedulerSupport("none")
    public final Iterable<T> blockingMostRecent(T t11) {
        return new BlockingObservableMostRecent(this, t11);
    }

    @CheckReturnValue
    @SchedulerSupport("none")
    public final Iterable<T> blockingNext() {
        return new BlockingObservableNext(this);
    }

    @CheckReturnValue
    @SchedulerSupport("none")
    public final T blockingSingle() {
        T blockingGet = singleElement().blockingGet();
        if (blockingGet != null) {
            return blockingGet;
        }
        throw new NoSuchElementException();
    }

    @SchedulerSupport("none")
    public final void blockingSubscribe() {
        ObservableBlockingSubscribe.subscribe(this);
    }

    @CheckReturnValue
    @SchedulerSupport("none")
    public final Observable<List<T>> buffer(int i11) {
        return buffer(i11, i11);
    }

    @CheckReturnValue
    @SchedulerSupport("none")
    public final Observable<T> cache() {
        return cacheWithInitialCapacity(16);
    }

    @CheckReturnValue
    @SchedulerSupport("none")
    public final Observable<T> cacheWithInitialCapacity(int i11) {
        ObjectHelper.verifyPositive(i11, "initialCapacity");
        return RxJavaPlugins.onAssembly(new ObservableCache(this, i11));
    }

    @CheckReturnValue
    @SchedulerSupport("none")
    public final <U> Observable<U> cast(Class<U> cls) {
        ObjectHelper.requireNonNull(cls, "clazz is null");
        return map(Functions.castFunction(cls));
    }

    @CheckReturnValue
    @SchedulerSupport("none")
    public final <U> Single<U> collect(Callable<? extends U> callable, BiConsumer<? super U, ? super T> biConsumer) {
        ObjectHelper.requireNonNull(callable, "initialValueSupplier is null");
        ObjectHelper.requireNonNull(biConsumer, "collector is null");
        return RxJavaPlugins.onAssembly(new ObservableCollectSingle(this, callable, biConsumer));
    }

    @CheckReturnValue
    @SchedulerSupport("none")
    public final <U> Single<U> collectInto(U u11, BiConsumer<? super U, ? super T> biConsumer) {
        ObjectHelper.requireNonNull(u11, "initialValue is null");
        return collect(Functions.justCallable(u11), biConsumer);
    }

    @CheckReturnValue
    @SchedulerSupport("none")
    public final <R> Observable<R> compose(ObservableTransformer<? super T, ? extends R> observableTransformer) {
        return wrap(((ObservableTransformer) ObjectHelper.requireNonNull(observableTransformer, "composer is null")).apply(this));
    }

    @CheckReturnValue
    @SchedulerSupport("none")
    public final <R> Observable<R> concatMap(Function<? super T, ? extends ObservableSource<? extends R>> function) {
        return concatMap(function, 2);
    }

    @CheckReturnValue
    @SchedulerSupport("none")
    public final Completable concatMapCompletable(Function<? super T, ? extends CompletableSource> function) {
        return concatMapCompletable(function, 2);
    }

    @CheckReturnValue
    @SchedulerSupport("none")
    public final Completable concatMapCompletableDelayError(Function<? super T, ? extends CompletableSource> function) {
        return concatMapCompletableDelayError(function, true, 2);
    }

    @CheckReturnValue
    @SchedulerSupport("none")
    public final <R> Observable<R> concatMapDelayError(Function<? super T, ? extends ObservableSource<? extends R>> function) {
        return concatMapDelayError(function, bufferSize(), true);
    }

    @CheckReturnValue
    @SchedulerSupport("none")
    public final <R> Observable<R> concatMapEager(Function<? super T, ? extends ObservableSource<? extends R>> function) {
        return concatMapEager(function, Integer.MAX_VALUE, bufferSize());
    }

    @CheckReturnValue
    @SchedulerSupport("none")
    public final <R> Observable<R> concatMapEagerDelayError(Function<? super T, ? extends ObservableSource<? extends R>> function, boolean z11) {
        return concatMapEagerDelayError(function, Integer.MAX_VALUE, bufferSize(), z11);
    }

    @CheckReturnValue
    @SchedulerSupport("none")
    public final <U> Observable<U> concatMapIterable(Function<? super T, ? extends Iterable<? extends U>> function) {
        ObjectHelper.requireNonNull(function, "mapper is null");
        return RxJavaPlugins.onAssembly(new ObservableFlattenIterable(this, function));
    }

    @CheckReturnValue
    @SchedulerSupport("none")
    public final <R> Observable<R> concatMapMaybe(Function<? super T, ? extends MaybeSource<? extends R>> function) {
        return concatMapMaybe(function, 2);
    }

    @CheckReturnValue
    @SchedulerSupport("none")
    public final <R> Observable<R> concatMapMaybeDelayError(Function<? super T, ? extends MaybeSource<? extends R>> function) {
        return concatMapMaybeDelayError(function, true, 2);
    }

    @CheckReturnValue
    @SchedulerSupport("none")
    public final <R> Observable<R> concatMapSingle(Function<? super T, ? extends SingleSource<? extends R>> function) {
        return concatMapSingle(function, 2);
    }

    @CheckReturnValue
    @SchedulerSupport("none")
    public final <R> Observable<R> concatMapSingleDelayError(Function<? super T, ? extends SingleSource<? extends R>> function) {
        return concatMapSingleDelayError(function, true, 2);
    }

    @CheckReturnValue
    @SchedulerSupport("none")
    public final Observable<T> concatWith(ObservableSource<? extends T> observableSource) {
        ObjectHelper.requireNonNull(observableSource, "other is null");
        return concat(this, (Observable) observableSource);
    }

    @CheckReturnValue
    @SchedulerSupport("none")
    public final Single<Boolean> contains(Object obj) {
        ObjectHelper.requireNonNull(obj, "element is null");
        return any(Functions.equalsWith(obj));
    }

    @CheckReturnValue
    @SchedulerSupport("none")
    public final Single<Long> count() {
        return RxJavaPlugins.onAssembly(new ObservableCountSingle(this));
    }

    @CheckReturnValue
    @SchedulerSupport("none")
    public final <U> Observable<T> debounce(Function<? super T, ? extends ObservableSource<U>> function) {
        ObjectHelper.requireNonNull(function, "debounceSelector is null");
        return RxJavaPlugins.onAssembly(new ObservableDebounce(this, function));
    }

    @CheckReturnValue
    @SchedulerSupport("none")
    public final Observable<T> defaultIfEmpty(T t11) {
        ObjectHelper.requireNonNull(t11, "defaultItem is null");
        return switchIfEmpty(just(t11));
    }

    @CheckReturnValue
    @SchedulerSupport("none")
    public final <U> Observable<T> delay(Function<? super T, ? extends ObservableSource<U>> function) {
        ObjectHelper.requireNonNull(function, "itemDelay is null");
        return flatMap(ObservableInternalHelper.itemDelay(function));
    }

    @CheckReturnValue
    @SchedulerSupport("none")
    public final <U> Observable<T> delaySubscription(ObservableSource<U> observableSource) {
        ObjectHelper.requireNonNull(observableSource, "other is null");
        return RxJavaPlugins.onAssembly(new ObservableDelaySubscriptionOther(this, observableSource));
    }

    @CheckReturnValue
    @Deprecated
    @SchedulerSupport("none")
    public final <T2> Observable<T2> dematerialize() {
        return RxJavaPlugins.onAssembly(new ObservableDematerialize(this, Functions.identity()));
    }

    @CheckReturnValue
    @SchedulerSupport("none")
    public final Observable<T> distinct() {
        return distinct(Functions.identity(), Functions.createHashSet());
    }

    @CheckReturnValue
    @SchedulerSupport("none")
    public final Observable<T> distinctUntilChanged() {
        return distinctUntilChanged(Functions.identity());
    }

    @CheckReturnValue
    @SchedulerSupport("none")
    public final Observable<T> doAfterNext(Consumer<? super T> consumer) {
        ObjectHelper.requireNonNull(consumer, "onAfterNext is null");
        return RxJavaPlugins.onAssembly(new ObservableDoAfterNext(this, consumer));
    }

    @CheckReturnValue
    @SchedulerSupport("none")
    public final Observable<T> doAfterTerminate(Action action) {
        ObjectHelper.requireNonNull(action, "onFinally is null");
        return doOnEach(Functions.emptyConsumer(), Functions.emptyConsumer(), Functions.EMPTY_ACTION, action);
    }

    @CheckReturnValue
    @SchedulerSupport("none")
    public final Observable<T> doFinally(Action action) {
        ObjectHelper.requireNonNull(action, "onFinally is null");
        return RxJavaPlugins.onAssembly(new ObservableDoFinally(this, action));
    }

    @CheckReturnValue
    @SchedulerSupport("none")
    public final Observable<T> doOnComplete(Action action) {
        return doOnEach(Functions.emptyConsumer(), Functions.emptyConsumer(), action, Functions.EMPTY_ACTION);
    }

    @CheckReturnValue
    @SchedulerSupport("none")
    public final Observable<T> doOnDispose(Action action) {
        return doOnLifecycle(Functions.emptyConsumer(), action);
    }

    @CheckReturnValue
    @SchedulerSupport("none")
    public final Observable<T> doOnError(Consumer<? super Throwable> consumer) {
        Consumer emptyConsumer = Functions.emptyConsumer();
        Action action = Functions.EMPTY_ACTION;
        return doOnEach(emptyConsumer, consumer, action, action);
    }

    @CheckReturnValue
    @SchedulerSupport("none")
    public final Observable<T> doOnLifecycle(Consumer<? super Disposable> consumer, Action action) {
        ObjectHelper.requireNonNull(consumer, "onSubscribe is null");
        ObjectHelper.requireNonNull(action, "onDispose is null");
        return RxJavaPlugins.onAssembly(new ObservableDoOnLifecycle(this, consumer, action));
    }

    @CheckReturnValue
    @SchedulerSupport("none")
    public final Observable<T> doOnNext(Consumer<? super T> consumer) {
        Consumer emptyConsumer = Functions.emptyConsumer();
        Action action = Functions.EMPTY_ACTION;
        return doOnEach(consumer, emptyConsumer, action, action);
    }

    @CheckReturnValue
    @SchedulerSupport("none")
    public final Observable<T> doOnSubscribe(Consumer<? super Disposable> consumer) {
        return doOnLifecycle(consumer, Functions.EMPTY_ACTION);
    }

    @CheckReturnValue
    @SchedulerSupport("none")
    public final Observable<T> doOnTerminate(Action action) {
        ObjectHelper.requireNonNull(action, "onTerminate is null");
        return doOnEach(Functions.emptyConsumer(), Functions.actionConsumer(action), action, Functions.EMPTY_ACTION);
    }

    @CheckReturnValue
    @SchedulerSupport("none")
    public final Maybe<T> elementAt(long j11) {
        if (j11 >= 0) {
            return RxJavaPlugins.onAssembly(new ObservableElementAtMaybe(this, j11));
        }
        throw new IndexOutOfBoundsException("index >= 0 required but it was " + j11);
    }

    @CheckReturnValue
    @SchedulerSupport("none")
    public final Single<T> elementAtOrError(long j11) {
        if (j11 >= 0) {
            return RxJavaPlugins.onAssembly(new ObservableElementAtSingle(this, j11, null));
        }
        throw new IndexOutOfBoundsException("index >= 0 required but it was " + j11);
    }

    @CheckReturnValue
    @SchedulerSupport("none")
    public final Observable<T> filter(Predicate<? super T> predicate) {
        ObjectHelper.requireNonNull(predicate, "predicate is null");
        return RxJavaPlugins.onAssembly(new ObservableFilter(this, predicate));
    }

    @CheckReturnValue
    @SchedulerSupport("none")
    public final Single<T> first(T t11) {
        return elementAt(0, t11);
    }

    @CheckReturnValue
    @SchedulerSupport("none")
    public final Maybe<T> firstElement() {
        return elementAt(0);
    }

    @CheckReturnValue
    @SchedulerSupport("none")
    public final Single<T> firstOrError() {
        return elementAtOrError(0);
    }

    @CheckReturnValue
    @SchedulerSupport("none")
    public final <R> Observable<R> flatMap(Function<? super T, ? extends ObservableSource<? extends R>> function) {
        return flatMap(function, false);
    }

    @CheckReturnValue
    @SchedulerSupport("none")
    public final Completable flatMapCompletable(Function<? super T, ? extends CompletableSource> function) {
        return flatMapCompletable(function, false);
    }

    @CheckReturnValue
    @SchedulerSupport("none")
    public final <U> Observable<U> flatMapIterable(Function<? super T, ? extends Iterable<? extends U>> function) {
        ObjectHelper.requireNonNull(function, "mapper is null");
        return RxJavaPlugins.onAssembly(new ObservableFlattenIterable(this, function));
    }

    @CheckReturnValue
    @SchedulerSupport("none")
    public final <R> Observable<R> flatMapMaybe(Function<? super T, ? extends MaybeSource<? extends R>> function) {
        return flatMapMaybe(function, false);
    }

    @CheckReturnValue
    @SchedulerSupport("none")
    public final <R> Observable<R> flatMapSingle(Function<? super T, ? extends SingleSource<? extends R>> function) {
        return flatMapSingle(function, false);
    }

    @CheckReturnValue
    @SchedulerSupport("none")
    public final Disposable forEach(Consumer<? super T> consumer) {
        return subscribe(consumer);
    }

    @CheckReturnValue
    @SchedulerSupport("none")
    public final Disposable forEachWhile(Predicate<? super T> predicate) {
        return forEachWhile(predicate, Functions.ON_ERROR_MISSING, Functions.EMPTY_ACTION);
    }

    @CheckReturnValue
    @SchedulerSupport("none")
    public final <K> Observable<GroupedObservable<K, T>> groupBy(Function<? super T, ? extends K> function) {
        return groupBy(function, Functions.identity(), false, bufferSize());
    }

    @CheckReturnValue
    @SchedulerSupport("none")
    public final <TRight, TLeftEnd, TRightEnd, R> Observable<R> groupJoin(ObservableSource<? extends TRight> observableSource, Function<? super T, ? extends ObservableSource<TLeftEnd>> function, Function<? super TRight, ? extends ObservableSource<TRightEnd>> function2, BiFunction<? super T, ? super Observable<TRight>, ? extends R> biFunction) {
        ObjectHelper.requireNonNull(observableSource, "other is null");
        ObjectHelper.requireNonNull(function, "leftEnd is null");
        ObjectHelper.requireNonNull(function2, "rightEnd is null");
        ObjectHelper.requireNonNull(biFunction, "resultSelector is null");
        return RxJavaPlugins.onAssembly(new ObservableGroupJoin(this, observableSource, function, function2, biFunction));
    }

    @CheckReturnValue
    @SchedulerSupport("none")
    public final Observable<T> hide() {
        return RxJavaPlugins.onAssembly(new ObservableHide(this));
    }

    @CheckReturnValue
    @SchedulerSupport("none")
    public final Completable ignoreElements() {
        return RxJavaPlugins.onAssembly((Completable) new ObservableIgnoreElementsCompletable(this));
    }

    @CheckReturnValue
    @SchedulerSupport("none")
    public final Single<Boolean> isEmpty() {
        return all(Functions.alwaysFalse());
    }

    @CheckReturnValue
    @SchedulerSupport("none")
    public final <TRight, TLeftEnd, TRightEnd, R> Observable<R> join(ObservableSource<? extends TRight> observableSource, Function<? super T, ? extends ObservableSource<TLeftEnd>> function, Function<? super TRight, ? extends ObservableSource<TRightEnd>> function2, BiFunction<? super T, ? super TRight, ? extends R> biFunction) {
        ObjectHelper.requireNonNull(observableSource, "other is null");
        ObjectHelper.requireNonNull(function, "leftEnd is null");
        ObjectHelper.requireNonNull(function2, "rightEnd is null");
        ObjectHelper.requireNonNull(biFunction, "resultSelector is null");
        return RxJavaPlugins.onAssembly(new ObservableJoin(this, observableSource, function, function2, biFunction));
    }

    @CheckReturnValue
    @SchedulerSupport("none")
    public final Single<T> last(T t11) {
        ObjectHelper.requireNonNull(t11, "defaultItem is null");
        return RxJavaPlugins.onAssembly(new ObservableLastSingle(this, t11));
    }

    @CheckReturnValue
    @SchedulerSupport("none")
    public final Maybe<T> lastElement() {
        return RxJavaPlugins.onAssembly(new ObservableLastMaybe(this));
    }

    @CheckReturnValue
    @SchedulerSupport("none")
    public final Single<T> lastOrError() {
        return RxJavaPlugins.onAssembly(new ObservableLastSingle(this, null));
    }

    @CheckReturnValue
    @SchedulerSupport("none")
    public final <R> Observable<R> lift(ObservableOperator<? extends R, ? super T> observableOperator) {
        ObjectHelper.requireNonNull(observableOperator, "lifter is null");
        return RxJavaPlugins.onAssembly(new ObservableLift(this, observableOperator));
    }

    @CheckReturnValue
    @SchedulerSupport("none")
    public final <R> Observable<R> map(Function<? super T, ? extends R> function) {
        ObjectHelper.requireNonNull(function, "mapper is null");
        return RxJavaPlugins.onAssembly(new ObservableMap(this, function));
    }

    @CheckReturnValue
    @SchedulerSupport("none")
    public final Observable<Notification<T>> materialize() {
        return RxJavaPlugins.onAssembly(new ObservableMaterialize(this));
    }

    @CheckReturnValue
    @SchedulerSupport("none")
    public final Observable<T> mergeWith(ObservableSource<? extends T> observableSource) {
        ObjectHelper.requireNonNull(observableSource, "other is null");
        return merge(this, (Observable) observableSource);
    }

    @CheckReturnValue
    @SchedulerSupport("custom")
    public final Observable<T> observeOn(Scheduler scheduler) {
        return observeOn(scheduler, false, bufferSize());
    }

    @CheckReturnValue
    @SchedulerSupport("none")
    public final <U> Observable<U> ofType(Class<U> cls) {
        ObjectHelper.requireNonNull(cls, "clazz is null");
        return filter(Functions.isInstanceOf(cls)).cast(cls);
    }

    @CheckReturnValue
    @SchedulerSupport("none")
    public final Observable<T> onErrorResumeNext(Function<? super Throwable, ? extends ObservableSource<? extends T>> function) {
        ObjectHelper.requireNonNull(function, "resumeFunction is null");
        return RxJavaPlugins.onAssembly(new ObservableOnErrorNext(this, function, false));
    }

    @CheckReturnValue
    @SchedulerSupport("none")
    public final Observable<T> onErrorReturn(Function<? super Throwable, ? extends T> function) {
        ObjectHelper.requireNonNull(function, "valueSupplier is null");
        return RxJavaPlugins.onAssembly(new ObservableOnErrorReturn(this, function));
    }

    @CheckReturnValue
    @SchedulerSupport("none")
    public final Observable<T> onErrorReturnItem(T t11) {
        ObjectHelper.requireNonNull(t11, "item is null");
        return onErrorReturn(Functions.justFunction(t11));
    }

    @CheckReturnValue
    @SchedulerSupport("none")
    public final Observable<T> onExceptionResumeNext(ObservableSource<? extends T> observableSource) {
        ObjectHelper.requireNonNull(observableSource, "next is null");
        return RxJavaPlugins.onAssembly(new ObservableOnErrorNext(this, Functions.justFunction(observableSource), true));
    }

    @CheckReturnValue
    @SchedulerSupport("none")
    public final Observable<T> onTerminateDetach() {
        return RxJavaPlugins.onAssembly(new ObservableDetach(this));
    }

    @CheckReturnValue
    @SchedulerSupport("none")
    public final ConnectableObservable<T> publish() {
        return ObservablePublish.create(this);
    }

    @CheckReturnValue
    @SchedulerSupport("none")
    public final Maybe<T> reduce(BiFunction<T, T, T> biFunction) {
        ObjectHelper.requireNonNull(biFunction, "reducer is null");
        return RxJavaPlugins.onAssembly(new ObservableReduceMaybe(this, biFunction));
    }

    @CheckReturnValue
    @SchedulerSupport("none")
    public final <R> Single<R> reduceWith(Callable<R> callable, BiFunction<R, ? super T, R> biFunction) {
        ObjectHelper.requireNonNull(callable, "seedSupplier is null");
        ObjectHelper.requireNonNull(biFunction, "reducer is null");
        return RxJavaPlugins.onAssembly(new ObservableReduceWithSingle(this, callable, biFunction));
    }

    @CheckReturnValue
    @SchedulerSupport("none")
    public final Observable<T> repeat() {
        return repeat(Long.MAX_VALUE);
    }

    @CheckReturnValue
    @SchedulerSupport("none")
    public final Observable<T> repeatUntil(BooleanSupplier booleanSupplier) {
        ObjectHelper.requireNonNull(booleanSupplier, "stop is null");
        return RxJavaPlugins.onAssembly(new ObservableRepeatUntil(this, booleanSupplier));
    }

    @CheckReturnValue
    @SchedulerSupport("none")
    public final Observable<T> repeatWhen(Function<? super Observable<Object>, ? extends ObservableSource<?>> function) {
        ObjectHelper.requireNonNull(function, "handler is null");
        return RxJavaPlugins.onAssembly(new ObservableRepeatWhen(this, function));
    }

    @CheckReturnValue
    @SchedulerSupport("none")
    public final ConnectableObservable<T> replay() {
        return ObservableReplay.createFrom(this);
    }

    @CheckReturnValue
    @SchedulerSupport("none")
    public final Observable<T> retry() {
        return retry(Long.MAX_VALUE, Functions.alwaysTrue());
    }

    @CheckReturnValue
    @SchedulerSupport("none")
    public final Observable<T> retryUntil(BooleanSupplier booleanSupplier) {
        ObjectHelper.requireNonNull(booleanSupplier, "stop is null");
        return retry(Long.MAX_VALUE, Functions.predicateReverseFor(booleanSupplier));
    }

    @CheckReturnValue
    @SchedulerSupport("none")
    public final Observable<T> retryWhen(Function<? super Observable<Throwable>, ? extends ObservableSource<?>> function) {
        ObjectHelper.requireNonNull(function, "handler is null");
        return RxJavaPlugins.onAssembly(new ObservableRetryWhen(this, function));
    }

    @SchedulerSupport("none")
    public final void safeSubscribe(Observer<? super T> observer) {
        ObjectHelper.requireNonNull(observer, "observer is null");
        if (observer instanceof SafeObserver) {
            subscribe(observer);
        } else {
            subscribe(new SafeObserver(observer));
        }
    }

    @CheckReturnValue
    @SchedulerSupport("io.reactivex:computation")
    public final Observable<T> sample(long j11, TimeUnit timeUnit) {
        return sample(j11, timeUnit, Schedulers.computation());
    }

    @CheckReturnValue
    @SchedulerSupport("none")
    public final Observable<T> scan(BiFunction<T, T, T> biFunction) {
        ObjectHelper.requireNonNull(biFunction, "accumulator is null");
        return RxJavaPlugins.onAssembly(new ObservableScan(this, biFunction));
    }

    @CheckReturnValue
    @SchedulerSupport("none")
    public final <R> Observable<R> scanWith(Callable<R> callable, BiFunction<R, ? super T, R> biFunction) {
        ObjectHelper.requireNonNull(callable, "seedSupplier is null");
        ObjectHelper.requireNonNull(biFunction, "accumulator is null");
        return RxJavaPlugins.onAssembly(new ObservableScanSeed(this, callable, biFunction));
    }

    @CheckReturnValue
    @SchedulerSupport("none")
    public final Observable<T> serialize() {
        return RxJavaPlugins.onAssembly(new ObservableSerialized(this));
    }

    @CheckReturnValue
    @SchedulerSupport("none")
    public final Observable<T> share() {
        return publish().refCount();
    }

    @CheckReturnValue
    @SchedulerSupport("none")
    public final Single<T> single(T t11) {
        ObjectHelper.requireNonNull(t11, "defaultItem is null");
        return RxJavaPlugins.onAssembly(new ObservableSingleSingle(this, t11));
    }

    @CheckReturnValue
    @SchedulerSupport("none")
    public final Maybe<T> singleElement() {
        return RxJavaPlugins.onAssembly(new ObservableSingleMaybe(this));
    }

    @CheckReturnValue
    @SchedulerSupport("none")
    public final Single<T> singleOrError() {
        return RxJavaPlugins.onAssembly(new ObservableSingleSingle(this, null));
    }

    @CheckReturnValue
    @SchedulerSupport("none")
    public final Observable<T> skip(long j11) {
        if (j11 <= 0) {
            return RxJavaPlugins.onAssembly(this);
        }
        return RxJavaPlugins.onAssembly(new ObservableSkip(this, j11));
    }

    @CheckReturnValue
    @SchedulerSupport("none")
    public final Observable<T> skipLast(int i11) {
        if (i11 < 0) {
            throw new IndexOutOfBoundsException("count >= 0 required but it was " + i11);
        } else if (i11 == 0) {
            return RxJavaPlugins.onAssembly(this);
        } else {
            return RxJavaPlugins.onAssembly(new ObservableSkipLast(this, i11));
        }
    }

    @CheckReturnValue
    @SchedulerSupport("none")
    public final <U> Observable<T> skipUntil(ObservableSource<U> observableSource) {
        ObjectHelper.requireNonNull(observableSource, "other is null");
        return RxJavaPlugins.onAssembly(new ObservableSkipUntil(this, observableSource));
    }

    @CheckReturnValue
    @SchedulerSupport("none")
    public final Observable<T> skipWhile(Predicate<? super T> predicate) {
        ObjectHelper.requireNonNull(predicate, "predicate is null");
        return RxJavaPlugins.onAssembly(new ObservableSkipWhile(this, predicate));
    }

    @CheckReturnValue
    @SchedulerSupport("none")
    public final Observable<T> sorted() {
        return toList().toObservable().map(Functions.listSorter(Functions.naturalComparator())).flatMapIterable(Functions.identity());
    }

    @CheckReturnValue
    @SchedulerSupport("none")
    public final Observable<T> startWith(Iterable<? extends T> iterable) {
        return concatArray(fromIterable(iterable), this);
    }

    @CheckReturnValue
    @SchedulerSupport("none")
    public final Observable<T> startWithArray(T... tArr) {
        Observable fromArray = fromArray(tArr);
        if (fromArray == empty()) {
            return RxJavaPlugins.onAssembly(this);
        }
        return concatArray(fromArray, this);
    }

    @SchedulerSupport("none")
    public final Disposable subscribe() {
        return subscribe(Functions.emptyConsumer(), Functions.ON_ERROR_MISSING, Functions.EMPTY_ACTION, Functions.emptyConsumer());
    }

    public abstract void subscribeActual(Observer<? super T> observer);

    @CheckReturnValue
    @SchedulerSupport("custom")
    public final Observable<T> subscribeOn(Scheduler scheduler) {
        ObjectHelper.requireNonNull(scheduler, "scheduler is null");
        return RxJavaPlugins.onAssembly(new ObservableSubscribeOn(this, scheduler));
    }

    @CheckReturnValue
    @SchedulerSupport("none")
    public final <E extends Observer<? super T>> E subscribeWith(E e11) {
        subscribe(e11);
        return e11;
    }

    @CheckReturnValue
    @SchedulerSupport("none")
    public final Observable<T> switchIfEmpty(ObservableSource<? extends T> observableSource) {
        ObjectHelper.requireNonNull(observableSource, "other is null");
        return RxJavaPlugins.onAssembly(new ObservableSwitchIfEmpty(this, observableSource));
    }

    @CheckReturnValue
    @SchedulerSupport("none")
    public final <R> Observable<R> switchMap(Function<? super T, ? extends ObservableSource<? extends R>> function) {
        return switchMap(function, bufferSize());
    }

    @CheckReturnValue
    @SchedulerSupport("none")
    public final Completable switchMapCompletable(@NonNull Function<? super T, ? extends CompletableSource> function) {
        ObjectHelper.requireNonNull(function, "mapper is null");
        return RxJavaPlugins.onAssembly((Completable) new ObservableSwitchMapCompletable(this, function, false));
    }

    @CheckReturnValue
    @SchedulerSupport("none")
    public final Completable switchMapCompletableDelayError(@NonNull Function<? super T, ? extends CompletableSource> function) {
        ObjectHelper.requireNonNull(function, "mapper is null");
        return RxJavaPlugins.onAssembly((Completable) new ObservableSwitchMapCompletable(this, function, true));
    }

    @CheckReturnValue
    @SchedulerSupport("none")
    public final <R> Observable<R> switchMapDelayError(Function<? super T, ? extends ObservableSource<? extends R>> function) {
        return switchMapDelayError(function, bufferSize());
    }

    @CheckReturnValue
    @SchedulerSupport("none")
    public final <R> Observable<R> switchMapMaybe(@NonNull Function<? super T, ? extends MaybeSource<? extends R>> function) {
        ObjectHelper.requireNonNull(function, "mapper is null");
        return RxJavaPlugins.onAssembly(new ObservableSwitchMapMaybe(this, function, false));
    }

    @CheckReturnValue
    @SchedulerSupport("none")
    public final <R> Observable<R> switchMapMaybeDelayError(@NonNull Function<? super T, ? extends MaybeSource<? extends R>> function) {
        ObjectHelper.requireNonNull(function, "mapper is null");
        return RxJavaPlugins.onAssembly(new ObservableSwitchMapMaybe(this, function, true));
    }

    @CheckReturnValue
    @NonNull
    @SchedulerSupport("none")
    public final <R> Observable<R> switchMapSingle(@NonNull Function<? super T, ? extends SingleSource<? extends R>> function) {
        ObjectHelper.requireNonNull(function, "mapper is null");
        return RxJavaPlugins.onAssembly(new ObservableSwitchMapSingle(this, function, false));
    }

    @CheckReturnValue
    @NonNull
    @SchedulerSupport("none")
    public final <R> Observable<R> switchMapSingleDelayError(@NonNull Function<? super T, ? extends SingleSource<? extends R>> function) {
        ObjectHelper.requireNonNull(function, "mapper is null");
        return RxJavaPlugins.onAssembly(new ObservableSwitchMapSingle(this, function, true));
    }

    @CheckReturnValue
    @SchedulerSupport("none")
    public final Observable<T> take(long j11) {
        if (j11 >= 0) {
            return RxJavaPlugins.onAssembly(new ObservableTake(this, j11));
        }
        throw new IllegalArgumentException("count >= 0 required but it was " + j11);
    }

    @CheckReturnValue
    @SchedulerSupport("none")
    public final Observable<T> takeLast(int i11) {
        if (i11 < 0) {
            throw new IndexOutOfBoundsException("count >= 0 required but it was " + i11);
        } else if (i11 == 0) {
            return RxJavaPlugins.onAssembly(new ObservableIgnoreElements(this));
        } else {
            if (i11 == 1) {
                return RxJavaPlugins.onAssembly(new ObservableTakeLastOne(this));
            }
            return RxJavaPlugins.onAssembly(new ObservableTakeLast(this, i11));
        }
    }

    @CheckReturnValue
    @SchedulerSupport("none")
    public final <U> Observable<T> takeUntil(ObservableSource<U> observableSource) {
        ObjectHelper.requireNonNull(observableSource, "other is null");
        return RxJavaPlugins.onAssembly(new ObservableTakeUntil(this, observableSource));
    }

    @CheckReturnValue
    @SchedulerSupport("none")
    public final Observable<T> takeWhile(Predicate<? super T> predicate) {
        ObjectHelper.requireNonNull(predicate, "predicate is null");
        return RxJavaPlugins.onAssembly(new ObservableTakeWhile(this, predicate));
    }

    @CheckReturnValue
    @SchedulerSupport("none")
    public final TestObserver<T> test() {
        TestObserver<T> testObserver = new TestObserver<>();
        subscribe(testObserver);
        return testObserver;
    }

    @CheckReturnValue
    @SchedulerSupport("io.reactivex:computation")
    public final Observable<T> throttleFirst(long j11, TimeUnit timeUnit) {
        return throttleFirst(j11, timeUnit, Schedulers.computation());
    }

    @CheckReturnValue
    @SchedulerSupport("io.reactivex:computation")
    public final Observable<T> throttleLast(long j11, TimeUnit timeUnit) {
        return sample(j11, timeUnit);
    }

    @CheckReturnValue
    @SchedulerSupport("io.reactivex:computation")
    public final Observable<T> throttleLatest(long j11, TimeUnit timeUnit) {
        return throttleLatest(j11, timeUnit, Schedulers.computation(), false);
    }

    @CheckReturnValue
    @SchedulerSupport("io.reactivex:computation")
    public final Observable<T> throttleWithTimeout(long j11, TimeUnit timeUnit) {
        return debounce(j11, timeUnit);
    }

    @CheckReturnValue
    @SchedulerSupport("none")
    public final Observable<Timed<T>> timeInterval() {
        return timeInterval(TimeUnit.MILLISECONDS, Schedulers.computation());
    }

    @CheckReturnValue
    @SchedulerSupport("none")
    public final <V> Observable<T> timeout(Function<? super T, ? extends ObservableSource<V>> function) {
        return timeout0((ObservableSource) null, function, (ObservableSource) null);
    }

    @CheckReturnValue
    @SchedulerSupport("none")
    public final Observable<Timed<T>> timestamp() {
        return timestamp(TimeUnit.MILLISECONDS, Schedulers.computation());
    }

    @CheckReturnValue
    @SchedulerSupport("none")
    public final <R> R to(Function<? super Observable<T>, R> function) {
        try {
            return ((Function) ObjectHelper.requireNonNull(function, "converter is null")).apply(this);
        } catch (Throwable th2) {
            Exceptions.throwIfFatal(th2);
            throw ExceptionHelper.wrapOrThrow(th2);
        }
    }

    @CheckReturnValue
    @BackpressureSupport(BackpressureKind.SPECIAL)
    @SchedulerSupport("none")
    public final Flowable<T> toFlowable(BackpressureStrategy backpressureStrategy) {
        FlowableFromObservable flowableFromObservable = new FlowableFromObservable(this);
        int i11 = AnonymousClass1.f14478a[backpressureStrategy.ordinal()];
        if (i11 == 1) {
            return flowableFromObservable.onBackpressureDrop();
        }
        if (i11 == 2) {
            return flowableFromObservable.onBackpressureLatest();
        }
        if (i11 == 3) {
            return flowableFromObservable;
        }
        if (i11 != 4) {
            return flowableFromObservable.onBackpressureBuffer();
        }
        return RxJavaPlugins.onAssembly(new FlowableOnBackpressureError(flowableFromObservable));
    }

    @CheckReturnValue
    @SchedulerSupport("none")
    public final Future<T> toFuture() {
        return (Future) subscribeWith(new FutureObserver());
    }

    @CheckReturnValue
    @SchedulerSupport("none")
    public final Single<List<T>> toList() {
        return toList(16);
    }

    @CheckReturnValue
    @SchedulerSupport("none")
    public final <K> Single<Map<K, T>> toMap(Function<? super T, ? extends K> function) {
        ObjectHelper.requireNonNull(function, "keySelector is null");
        return collect(HashMapSupplier.asCallable(), Functions.toMapKeySelector(function));
    }

    @CheckReturnValue
    @SchedulerSupport("none")
    public final <K> Single<Map<K, Collection<T>>> toMultimap(Function<? super T, ? extends K> function) {
        return toMultimap(function, Functions.identity(), HashMapSupplier.asCallable(), ArrayListSupplier.asFunction());
    }

    @CheckReturnValue
    @SchedulerSupport("none")
    public final Single<List<T>> toSortedList() {
        return toSortedList(Functions.naturalOrder());
    }

    @CheckReturnValue
    @SchedulerSupport("custom")
    public final Observable<T> unsubscribeOn(Scheduler scheduler) {
        ObjectHelper.requireNonNull(scheduler, "scheduler is null");
        return RxJavaPlugins.onAssembly(new ObservableUnsubscribeOn(this, scheduler));
    }

    @CheckReturnValue
    @SchedulerSupport("none")
    public final Observable<Observable<T>> window(long j11) {
        return window(j11, j11, bufferSize());
    }

    @CheckReturnValue
    @SchedulerSupport("none")
    public final <U, R> Observable<R> withLatestFrom(ObservableSource<? extends U> observableSource, BiFunction<? super T, ? super U, ? extends R> biFunction) {
        ObjectHelper.requireNonNull(observableSource, "other is null");
        ObjectHelper.requireNonNull(biFunction, "combiner is null");
        return RxJavaPlugins.onAssembly(new ObservableWithLatestFrom(this, biFunction, observableSource));
    }

    @CheckReturnValue
    @SchedulerSupport("none")
    public final <U, R> Observable<R> zipWith(Iterable<U> iterable, BiFunction<? super T, ? super U, ? extends R> biFunction) {
        ObjectHelper.requireNonNull(iterable, "other is null");
        ObjectHelper.requireNonNull(biFunction, "zipper is null");
        return RxJavaPlugins.onAssembly(new ObservableZipIterable(this, iterable, biFunction));
    }

    @CheckReturnValue
    @SchedulerSupport("none")
    public static <T, R> Observable<R> combineLatest(Iterable<? extends ObservableSource<? extends T>> iterable, Function<? super Object[], ? extends R> function) {
        return combineLatest(iterable, function, bufferSize());
    }

    @CheckReturnValue
    @SchedulerSupport("none")
    public static <T, R> Observable<R> combineLatestDelayError(Function<? super Object[], ? extends R> function, int i11, ObservableSource<? extends T>... observableSourceArr) {
        return combineLatestDelayError(observableSourceArr, function, i11);
    }

    @CheckReturnValue
    @SchedulerSupport("none")
    public static <T> Observable<T> concatArrayEager(int i11, int i12, ObservableSource<? extends T>... observableSourceArr) {
        return fromArray(observableSourceArr).concatMapEagerDelayError(Functions.identity(), i11, i12, false);
    }

    @CheckReturnValue
    @SchedulerSupport("none")
    public static <T> Observable<T> concatArrayEagerDelayError(int i11, int i12, ObservableSource<? extends T>... observableSourceArr) {
        return fromArray(observableSourceArr).concatMapEagerDelayError(Functions.identity(), i11, i12, true);
    }

    @CheckReturnValue
    @SchedulerSupport("none")
    public static <T> Observable<T> concatEager(ObservableSource<? extends ObservableSource<? extends T>> observableSource, int i11, int i12) {
        return wrap(observableSource).concatMapEager(Functions.identity(), i11, i12);
    }

    @CheckReturnValue
    @NonNull
    @SchedulerSupport("custom")
    public static Observable<Long> interval(long j11, long j12, TimeUnit timeUnit, Scheduler scheduler) {
        ObjectHelper.requireNonNull(timeUnit, "unit is null");
        ObjectHelper.requireNonNull(scheduler, "scheduler is null");
        return RxJavaPlugins.onAssembly(new ObservableInterval(Math.max(0, j11), Math.max(0, j12), timeUnit, scheduler));
    }

    @CheckReturnValue
    @NonNull
    @SchedulerSupport("custom")
    public static Observable<Long> intervalRange(long j11, long j12, long j13, long j14, TimeUnit timeUnit, Scheduler scheduler) {
        long j15 = j12;
        long j16 = j13;
        TimeUnit timeUnit2 = timeUnit;
        Scheduler scheduler2 = scheduler;
        int i11 = (j15 > 0 ? 1 : (j15 == 0 ? 0 : -1));
        if (i11 < 0) {
            throw new IllegalArgumentException("count >= 0 required but it was " + j15);
        } else if (i11 == 0) {
            return empty().delay(j16, timeUnit2, scheduler2);
        } else {
            long j17 = j11 + (j15 - 1);
            if (j11 <= 0 || j17 >= 0) {
                ObjectHelper.requireNonNull(timeUnit2, "unit is null");
                ObjectHelper.requireNonNull(scheduler2, "scheduler is null");
                return RxJavaPlugins.onAssembly(new ObservableIntervalRange(j11, j17, Math.max(0, j16), Math.max(0, j14), timeUnit, scheduler));
            }
            throw new IllegalArgumentException("Overflow! start + count is bigger than Long.MAX_VALUE");
        }
    }

    @CheckReturnValue
    @SchedulerSupport("none")
    public static <T> Observable<T> merge(Iterable<? extends ObservableSource<? extends T>> iterable) {
        return fromIterable(iterable).flatMap(Functions.identity());
    }

    @CheckReturnValue
    @SchedulerSupport("none")
    public static <T> Observable<T> mergeArray(ObservableSource<? extends T>... observableSourceArr) {
        return fromArray(observableSourceArr).flatMap(Functions.identity(), observableSourceArr.length);
    }

    @CheckReturnValue
    @SchedulerSupport("none")
    public static <T> Observable<T> mergeArrayDelayError(ObservableSource<? extends T>... observableSourceArr) {
        return fromArray(observableSourceArr).flatMap(Functions.identity(), true, observableSourceArr.length);
    }

    @CheckReturnValue
    @SchedulerSupport("none")
    public static <T> Observable<T> mergeDelayError(Iterable<? extends ObservableSource<? extends T>> iterable, int i11, int i12) {
        return fromIterable(iterable).flatMap(Functions.identity(), true, i11, i12);
    }

    @CheckReturnValue
    @SchedulerSupport("none")
    public static <T> Single<Boolean> sequenceEqual(ObservableSource<? extends T> observableSource, ObservableSource<? extends T> observableSource2, BiPredicate<? super T, ? super T> biPredicate) {
        return sequenceEqual(observableSource, observableSource2, biPredicate, bufferSize());
    }

    @CheckReturnValue
    @SchedulerSupport("none")
    public static <T> Observable<T> switchOnNextDelayError(ObservableSource<? extends ObservableSource<? extends T>> observableSource, int i11) {
        ObjectHelper.requireNonNull(observableSource, "sources is null");
        ObjectHelper.verifyPositive(i11, "prefetch");
        return RxJavaPlugins.onAssembly(new ObservableSwitchMap(observableSource, Functions.identity(), i11, true));
    }

    @CheckReturnValue
    @SchedulerSupport("custom")
    public static Observable<Long> timer(long j11, TimeUnit timeUnit, Scheduler scheduler) {
        ObjectHelper.requireNonNull(timeUnit, "unit is null");
        ObjectHelper.requireNonNull(scheduler, "scheduler is null");
        return RxJavaPlugins.onAssembly(new ObservableTimer(Math.max(j11, 0), timeUnit, scheduler));
    }

    @CheckReturnValue
    @SchedulerSupport("none")
    public static <T, D> Observable<T> using(Callable<? extends D> callable, Function<? super D, ? extends ObservableSource<? extends T>> function, Consumer<? super D> consumer, boolean z11) {
        ObjectHelper.requireNonNull(callable, "resourceSupplier is null");
        ObjectHelper.requireNonNull(function, "sourceSupplier is null");
        ObjectHelper.requireNonNull(consumer, "disposer is null");
        return RxJavaPlugins.onAssembly(new ObservableUsing(callable, function, consumer, z11));
    }

    @CheckReturnValue
    @SchedulerSupport("none")
    public final Iterable<T> blockingIterable(int i11) {
        ObjectHelper.verifyPositive(i11, "bufferSize");
        return new BlockingObservableIterable(this, i11);
    }

    @SchedulerSupport("none")
    public final void blockingSubscribe(Consumer<? super T> consumer) {
        ObservableBlockingSubscribe.subscribe(this, consumer, Functions.ON_ERROR_MISSING, Functions.EMPTY_ACTION);
    }

    @CheckReturnValue
    @SchedulerSupport("none")
    public final Observable<List<T>> buffer(int i11, int i12) {
        return buffer(i11, i12, ArrayListSupplier.asCallable());
    }

    @CheckReturnValue
    @SchedulerSupport("none")
    public final <R> Observable<R> concatMap(Function<? super T, ? extends ObservableSource<? extends R>> function, int i11) {
        ObjectHelper.requireNonNull(function, "mapper is null");
        ObjectHelper.verifyPositive(i11, "prefetch");
        if (!(this instanceof ScalarCallable)) {
            return RxJavaPlugins.onAssembly(new ObservableConcatMap(this, function, i11, ErrorMode.IMMEDIATE));
        }
        Object call = ((ScalarCallable) this).call();
        if (call == null) {
            return empty();
        }
        return ObservableScalarXMap.scalarXMap(call, function);
    }

    @CheckReturnValue
    @SchedulerSupport("none")
    public final Completable concatMapCompletable(Function<? super T, ? extends CompletableSource> function, int i11) {
        ObjectHelper.requireNonNull(function, "mapper is null");
        ObjectHelper.verifyPositive(i11, "capacityHint");
        return RxJavaPlugins.onAssembly((Completable) new ObservableConcatMapCompletable(this, function, ErrorMode.IMMEDIATE, i11));
    }

    @CheckReturnValue
    @SchedulerSupport("none")
    public final Completable concatMapCompletableDelayError(Function<? super T, ? extends CompletableSource> function, boolean z11) {
        return concatMapCompletableDelayError(function, z11, 2);
    }

    @CheckReturnValue
    @SchedulerSupport("none")
    public final <R> Observable<R> concatMapDelayError(Function<? super T, ? extends ObservableSource<? extends R>> function, int i11, boolean z11) {
        ObjectHelper.requireNonNull(function, "mapper is null");
        ObjectHelper.verifyPositive(i11, "prefetch");
        if (this instanceof ScalarCallable) {
            Object call = ((ScalarCallable) this).call();
            if (call == null) {
                return empty();
            }
            return ObservableScalarXMap.scalarXMap(call, function);
        }
        return RxJavaPlugins.onAssembly(new ObservableConcatMap(this, function, i11, z11 ? ErrorMode.END : ErrorMode.BOUNDARY));
    }

    @CheckReturnValue
    @SchedulerSupport("none")
    public final <R> Observable<R> concatMapEager(Function<? super T, ? extends ObservableSource<? extends R>> function, int i11, int i12) {
        ObjectHelper.requireNonNull(function, "mapper is null");
        ObjectHelper.verifyPositive(i11, "maxConcurrency");
        ObjectHelper.verifyPositive(i12, "prefetch");
        return RxJavaPlugins.onAssembly(new ObservableConcatMapEager(this, function, ErrorMode.IMMEDIATE, i11, i12));
    }

    @CheckReturnValue
    @SchedulerSupport("none")
    public final <R> Observable<R> concatMapEagerDelayError(Function<? super T, ? extends ObservableSource<? extends R>> function, int i11, int i12, boolean z11) {
        ObjectHelper.requireNonNull(function, "mapper is null");
        ObjectHelper.verifyPositive(i11, "maxConcurrency");
        ObjectHelper.verifyPositive(i12, "prefetch");
        return RxJavaPlugins.onAssembly(new ObservableConcatMapEager(this, function, z11 ? ErrorMode.END : ErrorMode.BOUNDARY, i11, i12));
    }

    @CheckReturnValue
    @SchedulerSupport("none")
    public final <R> Observable<R> concatMapMaybe(Function<? super T, ? extends MaybeSource<? extends R>> function, int i11) {
        ObjectHelper.requireNonNull(function, "mapper is null");
        ObjectHelper.verifyPositive(i11, "prefetch");
        return RxJavaPlugins.onAssembly(new ObservableConcatMapMaybe(this, function, ErrorMode.IMMEDIATE, i11));
    }

    @CheckReturnValue
    @SchedulerSupport("none")
    public final <R> Observable<R> concatMapMaybeDelayError(Function<? super T, ? extends MaybeSource<? extends R>> function, boolean z11) {
        return concatMapMaybeDelayError(function, z11, 2);
    }

    @CheckReturnValue
    @SchedulerSupport("none")
    public final <R> Observable<R> concatMapSingle(Function<? super T, ? extends SingleSource<? extends R>> function, int i11) {
        ObjectHelper.requireNonNull(function, "mapper is null");
        ObjectHelper.verifyPositive(i11, "prefetch");
        return RxJavaPlugins.onAssembly(new ObservableConcatMapSingle(this, function, ErrorMode.IMMEDIATE, i11));
    }

    @CheckReturnValue
    @SchedulerSupport("none")
    public final <R> Observable<R> concatMapSingleDelayError(Function<? super T, ? extends SingleSource<? extends R>> function, boolean z11) {
        return concatMapSingleDelayError(function, z11, 2);
    }

    @CheckReturnValue
    @Experimental
    @SchedulerSupport("none")
    public final <R> Observable<R> dematerialize(Function<? super T, Notification<R>> function) {
        ObjectHelper.requireNonNull(function, "selector is null");
        return RxJavaPlugins.onAssembly(new ObservableDematerialize(this, function));
    }

    @CheckReturnValue
    @SchedulerSupport("none")
    public final <K> Observable<T> distinct(Function<? super T, K> function) {
        return distinct(function, Functions.createHashSet());
    }

    @CheckReturnValue
    @SchedulerSupport("none")
    public final <K> Observable<T> distinctUntilChanged(Function<? super T, K> function) {
        ObjectHelper.requireNonNull(function, "keySelector is null");
        return RxJavaPlugins.onAssembly(new ObservableDistinctUntilChanged(this, function, ObjectHelper.equalsPredicate()));
    }

    @CheckReturnValue
    @SchedulerSupport("none")
    public final <R> Observable<R> flatMap(Function<? super T, ? extends ObservableSource<? extends R>> function, boolean z11) {
        return flatMap(function, z11, Integer.MAX_VALUE);
    }

    @CheckReturnValue
    @SchedulerSupport("none")
    public final Completable flatMapCompletable(Function<? super T, ? extends CompletableSource> function, boolean z11) {
        ObjectHelper.requireNonNull(function, "mapper is null");
        return RxJavaPlugins.onAssembly((Completable) new ObservableFlatMapCompletableCompletable(this, function, z11));
    }

    @CheckReturnValue
    @SchedulerSupport("none")
    public final <R> Observable<R> flatMapMaybe(Function<? super T, ? extends MaybeSource<? extends R>> function, boolean z11) {
        ObjectHelper.requireNonNull(function, "mapper is null");
        return RxJavaPlugins.onAssembly(new ObservableFlatMapMaybe(this, function, z11));
    }

    @CheckReturnValue
    @SchedulerSupport("none")
    public final <R> Observable<R> flatMapSingle(Function<? super T, ? extends SingleSource<? extends R>> function, boolean z11) {
        ObjectHelper.requireNonNull(function, "mapper is null");
        return RxJavaPlugins.onAssembly(new ObservableFlatMapSingle(this, function, z11));
    }

    @CheckReturnValue
    @SchedulerSupport("none")
    public final Disposable forEachWhile(Predicate<? super T> predicate, Consumer<? super Throwable> consumer) {
        return forEachWhile(predicate, consumer, Functions.EMPTY_ACTION);
    }

    @CheckReturnValue
    @SchedulerSupport("none")
    public final <K> Observable<GroupedObservable<K, T>> groupBy(Function<? super T, ? extends K> function, boolean z11) {
        return groupBy(function, Functions.identity(), z11, bufferSize());
    }

    @CheckReturnValue
    @SchedulerSupport("custom")
    public final Observable<T> observeOn(Scheduler scheduler, boolean z11) {
        return observeOn(scheduler, z11, bufferSize());
    }

    @CheckReturnValue
    @SchedulerSupport("none")
    public final <R> Observable<R> publish(Function<? super Observable<T>, ? extends ObservableSource<R>> function) {
        ObjectHelper.requireNonNull(function, "selector is null");
        return RxJavaPlugins.onAssembly(new ObservablePublishSelector(this, function));
    }

    @CheckReturnValue
    @SchedulerSupport("none")
    public final Observable<T> repeat(long j11) {
        int i11 = (j11 > 0 ? 1 : (j11 == 0 ? 0 : -1));
        if (i11 < 0) {
            throw new IllegalArgumentException("times >= 0 required but it was " + j11);
        } else if (i11 == 0) {
            return empty();
        } else {
            return RxJavaPlugins.onAssembly(new ObservableRepeat(this, j11));
        }
    }

    @CheckReturnValue
    @SchedulerSupport("none")
    public final <R> Observable<R> replay(Function<? super Observable<T>, ? extends ObservableSource<R>> function) {
        ObjectHelper.requireNonNull(function, "selector is null");
        return ObservableReplay.multicastSelector(ObservableInternalHelper.replayCallable(this), function);
    }

    @CheckReturnValue
    @SchedulerSupport("none")
    public final Observable<T> retry(BiPredicate<? super Integer, ? super Throwable> biPredicate) {
        ObjectHelper.requireNonNull(biPredicate, "predicate is null");
        return RxJavaPlugins.onAssembly(new ObservableRetryBiPredicate(this, biPredicate));
    }

    @CheckReturnValue
    @SchedulerSupport("io.reactivex:computation")
    public final Observable<T> sample(long j11, TimeUnit timeUnit, boolean z11) {
        return sample(j11, timeUnit, Schedulers.computation(), z11);
    }

    @CheckReturnValue
    @SchedulerSupport("none")
    public final Observable<T> sorted(Comparator<? super T> comparator) {
        ObjectHelper.requireNonNull(comparator, "sortFunction is null");
        return toList().toObservable().map(Functions.listSorter(comparator)).flatMapIterable(Functions.identity());
    }

    @CheckReturnValue
    @SchedulerSupport("none")
    public final Observable<T> startWith(ObservableSource<? extends T> observableSource) {
        ObjectHelper.requireNonNull(observableSource, "other is null");
        return concatArray(observableSource, this);
    }

    @CheckReturnValue
    @SchedulerSupport("none")
    public final Disposable subscribe(Consumer<? super T> consumer) {
        return subscribe(consumer, Functions.ON_ERROR_MISSING, Functions.EMPTY_ACTION, Functions.emptyConsumer());
    }

    @CheckReturnValue
    @SchedulerSupport("none")
    public final <R> Observable<R> switchMap(Function<? super T, ? extends ObservableSource<? extends R>> function, int i11) {
        ObjectHelper.requireNonNull(function, "mapper is null");
        ObjectHelper.verifyPositive(i11, "bufferSize");
        if (!(this instanceof ScalarCallable)) {
            return RxJavaPlugins.onAssembly(new ObservableSwitchMap(this, function, i11, false));
        }
        Object call = ((ScalarCallable) this).call();
        if (call == null) {
            return empty();
        }
        return ObservableScalarXMap.scalarXMap(call, function);
    }

    @CheckReturnValue
    @SchedulerSupport("none")
    public final <R> Observable<R> switchMapDelayError(Function<? super T, ? extends ObservableSource<? extends R>> function, int i11) {
        ObjectHelper.requireNonNull(function, "mapper is null");
        ObjectHelper.verifyPositive(i11, "bufferSize");
        if (!(this instanceof ScalarCallable)) {
            return RxJavaPlugins.onAssembly(new ObservableSwitchMap(this, function, i11, true));
        }
        Object call = ((ScalarCallable) this).call();
        if (call == null) {
            return empty();
        }
        return ObservableScalarXMap.scalarXMap(call, function);
    }

    @CheckReturnValue
    @SchedulerSupport("custom")
    public final Observable<T> throttleFirst(long j11, TimeUnit timeUnit, Scheduler scheduler) {
        ObjectHelper.requireNonNull(timeUnit, "unit is null");
        ObjectHelper.requireNonNull(scheduler, "scheduler is null");
        return RxJavaPlugins.onAssembly(new ObservableThrottleFirstTimed(this, j11, timeUnit, scheduler));
    }

    @CheckReturnValue
    @SchedulerSupport("custom")
    public final Observable<T> throttleLast(long j11, TimeUnit timeUnit, Scheduler scheduler) {
        return sample(j11, timeUnit, scheduler);
    }

    @CheckReturnValue
    @SchedulerSupport("io.reactivex:computation")
    public final Observable<T> throttleLatest(long j11, TimeUnit timeUnit, boolean z11) {
        return throttleLatest(j11, timeUnit, Schedulers.computation(), z11);
    }

    @CheckReturnValue
    @SchedulerSupport("custom")
    public final Observable<T> throttleWithTimeout(long j11, TimeUnit timeUnit, Scheduler scheduler) {
        return debounce(j11, timeUnit, scheduler);
    }

    @CheckReturnValue
    @SchedulerSupport("none")
    public final Observable<Timed<T>> timeInterval(Scheduler scheduler) {
        return timeInterval(TimeUnit.MILLISECONDS, scheduler);
    }

    @CheckReturnValue
    @SchedulerSupport("none")
    public final <V> Observable<T> timeout(Function<? super T, ? extends ObservableSource<V>> function, ObservableSource<? extends T> observableSource) {
        ObjectHelper.requireNonNull(observableSource, "other is null");
        return timeout0((ObservableSource) null, function, observableSource);
    }

    @CheckReturnValue
    @SchedulerSupport("none")
    public final Observable<Timed<T>> timestamp(Scheduler scheduler) {
        return timestamp(TimeUnit.MILLISECONDS, scheduler);
    }

    @CheckReturnValue
    @SchedulerSupport("none")
    public final Single<List<T>> toList(int i11) {
        ObjectHelper.verifyPositive(i11, "capacityHint");
        return RxJavaPlugins.onAssembly(new ObservableToListSingle(this, i11));
    }

    @CheckReturnValue
    @SchedulerSupport("none")
    public final Single<List<T>> toSortedList(Comparator<? super T> comparator) {
        ObjectHelper.requireNonNull(comparator, "comparator is null");
        return toList().map(Functions.listSorter(comparator));
    }

    @CheckReturnValue
    @SchedulerSupport("none")
    public final Observable<Observable<T>> window(long j11, long j12) {
        return window(j11, j12, bufferSize());
    }

    @CheckReturnValue
    @NonNull
    @SchedulerSupport("none")
    public static <T, R> Observable<R> combineLatest(Iterable<? extends ObservableSource<? extends T>> iterable, Function<? super Object[], ? extends R> function, int i11) {
        ObjectHelper.requireNonNull(iterable, "sources is null");
        ObjectHelper.requireNonNull(function, "combiner is null");
        ObjectHelper.verifyPositive(i11, "bufferSize");
        return RxJavaPlugins.onAssembly(new ObservableCombineLatest((ObservableSource<? extends T>[]) null, iterable, function, i11 << 1, false));
    }

    @CheckReturnValue
    @NonNull
    @SchedulerSupport("none")
    public static <T, R> Observable<R> combineLatestDelayError(ObservableSource<? extends T>[] observableSourceArr, Function<? super Object[], ? extends R> function, int i11) {
        ObjectHelper.verifyPositive(i11, "bufferSize");
        ObjectHelper.requireNonNull(function, "combiner is null");
        if (observableSourceArr.length == 0) {
            return empty();
        }
        return RxJavaPlugins.onAssembly(new ObservableCombineLatest(observableSourceArr, (Iterable) null, function, i11 << 1, true));
    }

    @CheckReturnValue
    @SchedulerSupport("none")
    public static <T> Observable<T> concat(ObservableSource<? extends ObservableSource<? extends T>> observableSource) {
        return concat(observableSource, bufferSize());
    }

    @CheckReturnValue
    @SchedulerSupport("none")
    public static <T> Observable<T> concatDelayError(ObservableSource<? extends ObservableSource<? extends T>> observableSource) {
        return concatDelayError(observableSource, bufferSize(), true);
    }

    @CheckReturnValue
    @SchedulerSupport("none")
    public static <T> Observable<T> concatEager(Iterable<? extends ObservableSource<? extends T>> iterable) {
        return concatEager(iterable, bufferSize(), bufferSize());
    }

    @CheckReturnValue
    @NonNull
    @SchedulerSupport("none")
    public static <T> Observable<T> error(Throwable th2) {
        ObjectHelper.requireNonNull(th2, "exception is null");
        return error((Callable<? extends Throwable>) Functions.justCallable(th2));
    }

    @CheckReturnValue
    @NonNull
    @SchedulerSupport("none")
    public static <T> Observable<T> fromFuture(Future<? extends T> future, long j11, TimeUnit timeUnit) {
        ObjectHelper.requireNonNull(future, "future is null");
        ObjectHelper.requireNonNull(timeUnit, "unit is null");
        return RxJavaPlugins.onAssembly(new ObservableFromFuture(future, j11, timeUnit));
    }

    @CheckReturnValue
    @NonNull
    @SchedulerSupport("none")
    public static <T> Observable<T> just(T t11, T t12) {
        ObjectHelper.requireNonNull(t11, "item1 is null");
        ObjectHelper.requireNonNull(t12, "item2 is null");
        return fromArray(t11, t12);
    }

    @CheckReturnValue
    @SchedulerSupport("none")
    public static <T> Observable<T> merge(Iterable<? extends ObservableSource<? extends T>> iterable, int i11) {
        return fromIterable(iterable).flatMap(Functions.identity(), i11);
    }

    @CheckReturnValue
    @SchedulerSupport("none")
    public static <T> Observable<T> mergeDelayError(Iterable<? extends ObservableSource<? extends T>> iterable, int i11) {
        return fromIterable(iterable).flatMap(Functions.identity(), true, i11);
    }

    @CheckReturnValue
    @SchedulerSupport("none")
    public static <T> Single<Boolean> sequenceEqual(ObservableSource<? extends T> observableSource, ObservableSource<? extends T> observableSource2, BiPredicate<? super T, ? super T> biPredicate, int i11) {
        ObjectHelper.requireNonNull(observableSource, "source1 is null");
        ObjectHelper.requireNonNull(observableSource2, "source2 is null");
        ObjectHelper.requireNonNull(biPredicate, "isEqual is null");
        ObjectHelper.verifyPositive(i11, "bufferSize");
        return RxJavaPlugins.onAssembly(new ObservableSequenceEqualSingle(observableSource, observableSource2, biPredicate, i11));
    }

    @CheckReturnValue
    @SchedulerSupport("none")
    public final T blockingSingle(T t11) {
        return single(t11).blockingGet();
    }

    @SchedulerSupport("none")
    public final void blockingSubscribe(Consumer<? super T> consumer, Consumer<? super Throwable> consumer2) {
        ObservableBlockingSubscribe.subscribe(this, consumer, consumer2, Functions.EMPTY_ACTION);
    }

    @CheckReturnValue
    @SchedulerSupport("none")
    public final <U extends Collection<? super T>> Observable<U> buffer(int i11, int i12, Callable<U> callable) {
        ObjectHelper.verifyPositive(i11, "count");
        ObjectHelper.verifyPositive(i12, "skip");
        ObjectHelper.requireNonNull(callable, "bufferSupplier is null");
        return RxJavaPlugins.onAssembly(new ObservableBuffer(this, i11, i12, callable));
    }

    @CheckReturnValue
    @SchedulerSupport("none")
    public final Completable concatMapCompletableDelayError(Function<? super T, ? extends CompletableSource> function, boolean z11, int i11) {
        ObjectHelper.requireNonNull(function, "mapper is null");
        ObjectHelper.verifyPositive(i11, "prefetch");
        return RxJavaPlugins.onAssembly((Completable) new ObservableConcatMapCompletable(this, function, z11 ? ErrorMode.END : ErrorMode.BOUNDARY, i11));
    }

    @CheckReturnValue
    @SchedulerSupport("none")
    public final <U> Observable<U> concatMapIterable(Function<? super T, ? extends Iterable<? extends U>> function, int i11) {
        ObjectHelper.requireNonNull(function, "mapper is null");
        ObjectHelper.verifyPositive(i11, "prefetch");
        return concatMap(ObservableInternalHelper.flatMapIntoIterable(function), i11);
    }

    @CheckReturnValue
    @SchedulerSupport("none")
    public final <R> Observable<R> concatMapMaybeDelayError(Function<? super T, ? extends MaybeSource<? extends R>> function, boolean z11, int i11) {
        ObjectHelper.requireNonNull(function, "mapper is null");
        ObjectHelper.verifyPositive(i11, "prefetch");
        return RxJavaPlugins.onAssembly(new ObservableConcatMapMaybe(this, function, z11 ? ErrorMode.END : ErrorMode.BOUNDARY, i11));
    }

    @CheckReturnValue
    @SchedulerSupport("none")
    public final <R> Observable<R> concatMapSingleDelayError(Function<? super T, ? extends SingleSource<? extends R>> function, boolean z11, int i11) {
        ObjectHelper.requireNonNull(function, "mapper is null");
        ObjectHelper.verifyPositive(i11, "prefetch");
        return RxJavaPlugins.onAssembly(new ObservableConcatMapSingle(this, function, z11 ? ErrorMode.END : ErrorMode.BOUNDARY, i11));
    }

    @CheckReturnValue
    @SchedulerSupport("none")
    public final Observable<T> concatWith(@NonNull SingleSource<? extends T> singleSource) {
        ObjectHelper.requireNonNull(singleSource, "other is null");
        return RxJavaPlugins.onAssembly(new ObservableConcatWithSingle(this, singleSource));
    }

    @CheckReturnValue
    @SchedulerSupport("io.reactivex:computation")
    public final Observable<T> debounce(long j11, TimeUnit timeUnit) {
        return debounce(j11, timeUnit, Schedulers.computation());
    }

    @CheckReturnValue
    @SchedulerSupport("io.reactivex:computation")
    public final Observable<T> delay(long j11, TimeUnit timeUnit) {
        return delay(j11, timeUnit, Schedulers.computation(), false);
    }

    @CheckReturnValue
    @SchedulerSupport("io.reactivex:computation")
    public final Observable<T> delaySubscription(long j11, TimeUnit timeUnit) {
        return delaySubscription(j11, timeUnit, Schedulers.computation());
    }

    @CheckReturnValue
    @SchedulerSupport("none")
    public final <K> Observable<T> distinct(Function<? super T, K> function, Callable<? extends Collection<? super K>> callable) {
        ObjectHelper.requireNonNull(function, "keySelector is null");
        ObjectHelper.requireNonNull(callable, "collectionSupplier is null");
        return RxJavaPlugins.onAssembly(new ObservableDistinct(this, function, callable));
    }

    @CheckReturnValue
    @SchedulerSupport("none")
    public final Single<T> elementAt(long j11, T t11) {
        if (j11 >= 0) {
            ObjectHelper.requireNonNull(t11, "defaultItem is null");
            return RxJavaPlugins.onAssembly(new ObservableElementAtSingle(this, j11, t11));
        }
        throw new IndexOutOfBoundsException("index >= 0 required but it was " + j11);
    }

    @CheckReturnValue
    @SchedulerSupport("none")
    public final <R> Observable<R> flatMap(Function<? super T, ? extends ObservableSource<? extends R>> function, boolean z11, int i11) {
        return flatMap(function, z11, i11, bufferSize());
    }

    @CheckReturnValue
    @SchedulerSupport("none")
    public final <U, V> Observable<V> flatMapIterable(Function<? super T, ? extends Iterable<? extends U>> function, BiFunction<? super T, ? super U, ? extends V> biFunction) {
        ObjectHelper.requireNonNull(function, "mapper is null");
        ObjectHelper.requireNonNull(biFunction, "resultSelector is null");
        return flatMap(ObservableInternalHelper.flatMapIntoIterable(function), biFunction, false, bufferSize(), bufferSize());
    }

    @CheckReturnValue
    @SchedulerSupport("none")
    public final Disposable forEachWhile(Predicate<? super T> predicate, Consumer<? super Throwable> consumer, Action action) {
        ObjectHelper.requireNonNull(predicate, "onNext is null");
        ObjectHelper.requireNonNull(consumer, "onError is null");
        ObjectHelper.requireNonNull(action, "onComplete is null");
        ForEachWhileObserver forEachWhileObserver = new ForEachWhileObserver(predicate, consumer, action);
        subscribe(forEachWhileObserver);
        return forEachWhileObserver;
    }

    @CheckReturnValue
    @SchedulerSupport("none")
    public final <K, V> Observable<GroupedObservable<K, V>> groupBy(Function<? super T, ? extends K> function, Function<? super T, ? extends V> function2) {
        return groupBy(function, function2, false, bufferSize());
    }

    @CheckReturnValue
    @SchedulerSupport("none")
    public final Observable<T> mergeWith(@NonNull SingleSource<? extends T> singleSource) {
        ObjectHelper.requireNonNull(singleSource, "other is null");
        return RxJavaPlugins.onAssembly(new ObservableMergeWithSingle(this, singleSource));
    }

    @CheckReturnValue
    @SchedulerSupport("custom")
    public final Observable<T> observeOn(Scheduler scheduler, boolean z11, int i11) {
        ObjectHelper.requireNonNull(scheduler, "scheduler is null");
        ObjectHelper.verifyPositive(i11, "bufferSize");
        return RxJavaPlugins.onAssembly(new ObservableObserveOn(this, scheduler, z11, i11));
    }

    @CheckReturnValue
    @SchedulerSupport("none")
    public final Observable<T> onErrorResumeNext(ObservableSource<? extends T> observableSource) {
        ObjectHelper.requireNonNull(observableSource, "next is null");
        return onErrorResumeNext(Functions.justFunction(observableSource));
    }

    @CheckReturnValue
    @SchedulerSupport("none")
    public final <R> Single<R> reduce(R r11, BiFunction<R, ? super T, R> biFunction) {
        ObjectHelper.requireNonNull(r11, "seed is null");
        ObjectHelper.requireNonNull(biFunction, "reducer is null");
        return RxJavaPlugins.onAssembly(new ObservableReduceSeedSingle(this, r11, biFunction));
    }

    @CheckReturnValue
    @SchedulerSupport("custom")
    public final Observable<T> sample(long j11, TimeUnit timeUnit, Scheduler scheduler) {
        ObjectHelper.requireNonNull(timeUnit, "unit is null");
        ObjectHelper.requireNonNull(scheduler, "scheduler is null");
        return RxJavaPlugins.onAssembly(new ObservableSampleTimed(this, j11, timeUnit, scheduler, false));
    }

    @CheckReturnValue
    @SchedulerSupport("none")
    public final <R> Observable<R> scan(R r11, BiFunction<R, ? super T, R> biFunction) {
        ObjectHelper.requireNonNull(r11, "initialValue is null");
        return scanWith(Functions.justCallable(r11), biFunction);
    }

    @CheckReturnValue
    @SchedulerSupport("io.reactivex:computation")
    public final Observable<T> skip(long j11, TimeUnit timeUnit) {
        return skipUntil(timer(j11, timeUnit));
    }

    @CheckReturnValue
    @SchedulerSupport("none")
    public final Disposable subscribe(Consumer<? super T> consumer, Consumer<? super Throwable> consumer2) {
        return subscribe(consumer, consumer2, Functions.EMPTY_ACTION, Functions.emptyConsumer());
    }

    @CheckReturnValue
    @SchedulerSupport("none")
    public final Observable<T> take(long j11, TimeUnit timeUnit) {
        return takeUntil(timer(j11, timeUnit));
    }

    @CheckReturnValue
    @SchedulerSupport("none")
    public final Observable<T> takeUntil(Predicate<? super T> predicate) {
        ObjectHelper.requireNonNull(predicate, "stopPredicate is null");
        return RxJavaPlugins.onAssembly(new ObservableTakeUntilPredicate(this, predicate));
    }

    @CheckReturnValue
    @SchedulerSupport("none")
    public final TestObserver<T> test(boolean z11) {
        TestObserver<T> testObserver = new TestObserver<>();
        if (z11) {
            testObserver.dispose();
        }
        subscribe(testObserver);
        return testObserver;
    }

    @CheckReturnValue
    @SchedulerSupport("custom")
    public final Observable<T> throttleLatest(long j11, TimeUnit timeUnit, Scheduler scheduler) {
        return throttleLatest(j11, timeUnit, scheduler, false);
    }

    @CheckReturnValue
    @SchedulerSupport("none")
    public final Observable<Timed<T>> timeInterval(TimeUnit timeUnit) {
        return timeInterval(timeUnit, Schedulers.computation());
    }

    @CheckReturnValue
    @SchedulerSupport("none")
    public final Observable<Timed<T>> timestamp(TimeUnit timeUnit) {
        return timestamp(timeUnit, Schedulers.computation());
    }

    @CheckReturnValue
    @SchedulerSupport("none")
    public final <K, V> Single<Map<K, V>> toMap(Function<? super T, ? extends K> function, Function<? super T, ? extends V> function2) {
        ObjectHelper.requireNonNull(function, "keySelector is null");
        ObjectHelper.requireNonNull(function2, "valueSelector is null");
        return collect(HashMapSupplier.asCallable(), Functions.toMapKeyValueSelector(function, function2));
    }

    @CheckReturnValue
    @SchedulerSupport("none")
    public final Observable<Observable<T>> window(long j11, long j12, int i11) {
        ObjectHelper.verifyPositive(j11, "count");
        ObjectHelper.verifyPositive(j12, "skip");
        ObjectHelper.verifyPositive(i11, "bufferSize");
        return RxJavaPlugins.onAssembly(new ObservableWindow(this, j11, j12, i11));
    }

    @CheckReturnValue
    @NonNull
    @SchedulerSupport("none")
    public static <T> Observable<T> concat(ObservableSource<? extends ObservableSource<? extends T>> observableSource, int i11) {
        ObjectHelper.requireNonNull(observableSource, "sources is null");
        ObjectHelper.verifyPositive(i11, "prefetch");
        return RxJavaPlugins.onAssembly(new ObservableConcatMap(observableSource, Functions.identity(), i11, ErrorMode.IMMEDIATE));
    }

    @CheckReturnValue
    @NonNull
    @SchedulerSupport("none")
    public static <T> Observable<T> concatDelayError(ObservableSource<? extends ObservableSource<? extends T>> observableSource, int i11, boolean z11) {
        ObjectHelper.requireNonNull(observableSource, "sources is null");
        ObjectHelper.verifyPositive(i11, "prefetch is null");
        return RxJavaPlugins.onAssembly(new ObservableConcatMap(observableSource, Functions.identity(), i11, z11 ? ErrorMode.END : ErrorMode.BOUNDARY));
    }

    @CheckReturnValue
    @SchedulerSupport("none")
    public static <T> Observable<T> concatEager(Iterable<? extends ObservableSource<? extends T>> iterable, int i11, int i12) {
        return fromIterable(iterable).concatMapEagerDelayError(Functions.identity(), i11, i12, false);
    }

    @CheckReturnValue
    @SchedulerSupport("none")
    public static <T> Observable<T> merge(ObservableSource<? extends ObservableSource<? extends T>> observableSource) {
        ObjectHelper.requireNonNull(observableSource, "sources is null");
        return RxJavaPlugins.onAssembly(new ObservableFlatMap(observableSource, Functions.identity(), false, Integer.MAX_VALUE, bufferSize()));
    }

    @CheckReturnValue
    @SchedulerSupport("none")
    public static <T> Observable<T> mergeDelayError(ObservableSource<? extends ObservableSource<? extends T>> observableSource) {
        ObjectHelper.requireNonNull(observableSource, "sources is null");
        return RxJavaPlugins.onAssembly(new ObservableFlatMap(observableSource, Functions.identity(), true, Integer.MAX_VALUE, bufferSize()));
    }

    @CheckReturnValue
    @SchedulerSupport("none")
    public static <T> Observable<T> switchOnNext(ObservableSource<? extends ObservableSource<? extends T>> observableSource) {
        return switchOnNext(observableSource, bufferSize());
    }

    private <U, V> Observable<T> timeout0(ObservableSource<U> observableSource, Function<? super T, ? extends ObservableSource<V>> function, ObservableSource<? extends T> observableSource2) {
        ObjectHelper.requireNonNull(function, "itemTimeoutIndicator is null");
        return RxJavaPlugins.onAssembly(new ObservableTimeout(this, observableSource, function, observableSource2));
    }

    @CheckReturnValue
    @SchedulerSupport("none")
    public static <T, R> Observable<R> zip(ObservableSource<? extends ObservableSource<? extends T>> observableSource, Function<? super Object[], ? extends R> function) {
        ObjectHelper.requireNonNull(function, "zipper is null");
        ObjectHelper.requireNonNull(observableSource, "sources is null");
        return RxJavaPlugins.onAssembly(new ObservableToList(observableSource, 16).flatMap(ObservableInternalHelper.zipIterable(function)));
    }

    @SchedulerSupport("none")
    public final void blockingSubscribe(Consumer<? super T> consumer, Consumer<? super Throwable> consumer2, Action action) {
        ObservableBlockingSubscribe.subscribe(this, consumer, consumer2, action);
    }

    @CheckReturnValue
    @SchedulerSupport("custom")
    public final Observable<T> debounce(long j11, TimeUnit timeUnit, Scheduler scheduler) {
        ObjectHelper.requireNonNull(timeUnit, "unit is null");
        ObjectHelper.requireNonNull(scheduler, "scheduler is null");
        return RxJavaPlugins.onAssembly(new ObservableDebounceTimed(this, j11, timeUnit, scheduler));
    }

    @CheckReturnValue
    @SchedulerSupport("io.reactivex:computation")
    public final Observable<T> delay(long j11, TimeUnit timeUnit, boolean z11) {
        return delay(j11, timeUnit, Schedulers.computation(), z11);
    }

    @CheckReturnValue
    @SchedulerSupport("custom")
    public final Observable<T> delaySubscription(long j11, TimeUnit timeUnit, Scheduler scheduler) {
        return delaySubscription(timer(j11, timeUnit, scheduler));
    }

    @CheckReturnValue
    @SchedulerSupport("none")
    public final Observable<T> distinctUntilChanged(BiPredicate<? super T, ? super T> biPredicate) {
        ObjectHelper.requireNonNull(biPredicate, "comparer is null");
        return RxJavaPlugins.onAssembly(new ObservableDistinctUntilChanged(this, Functions.identity(), biPredicate));
    }

    @CheckReturnValue
    @SchedulerSupport("none")
    public final <R> Observable<R> flatMap(Function<? super T, ? extends ObservableSource<? extends R>> function, boolean z11, int i11, int i12) {
        ObjectHelper.requireNonNull(function, "mapper is null");
        ObjectHelper.verifyPositive(i11, "maxConcurrency");
        ObjectHelper.verifyPositive(i12, "bufferSize");
        if (!(this instanceof ScalarCallable)) {
            return RxJavaPlugins.onAssembly(new ObservableFlatMap(this, function, z11, i11, i12));
        }
        Object call = ((ScalarCallable) this).call();
        if (call == null) {
            return empty();
        }
        return ObservableScalarXMap.scalarXMap(call, function);
    }

    @CheckReturnValue
    @SchedulerSupport("none")
    public final <K, V> Observable<GroupedObservable<K, V>> groupBy(Function<? super T, ? extends K> function, Function<? super T, ? extends V> function2, boolean z11) {
        return groupBy(function, function2, z11, bufferSize());
    }

    @CheckReturnValue
    @SchedulerSupport("none")
    public final <R> Observable<R> replay(Function<? super Observable<T>, ? extends ObservableSource<R>> function, int i11) {
        ObjectHelper.requireNonNull(function, "selector is null");
        ObjectHelper.verifyPositive(i11, "bufferSize");
        return ObservableReplay.multicastSelector(ObservableInternalHelper.replayCallable(this, i11), function);
    }

    @CheckReturnValue
    @SchedulerSupport("none")
    public final Observable<T> retry(long j11) {
        return retry(j11, Functions.alwaysTrue());
    }

    @CheckReturnValue
    @SchedulerSupport("custom")
    public final Observable<T> skip(long j11, TimeUnit timeUnit, Scheduler scheduler) {
        return skipUntil(timer(j11, timeUnit, scheduler));
    }

    @CheckReturnValue
    @SchedulerSupport("io.reactivex:trampoline")
    public final Observable<T> skipLast(long j11, TimeUnit timeUnit) {
        return skipLast(j11, timeUnit, Schedulers.trampoline(), false, bufferSize());
    }

    @CheckReturnValue
    @SchedulerSupport("none")
    public final Observable<T> startWith(T t11) {
        ObjectHelper.requireNonNull(t11, "item is null");
        return concatArray(just(t11), this);
    }

    @CheckReturnValue
    @SchedulerSupport("none")
    public final Disposable subscribe(Consumer<? super T> consumer, Consumer<? super Throwable> consumer2, Action action) {
        return subscribe(consumer, consumer2, action, Functions.emptyConsumer());
    }

    @CheckReturnValue
    @SchedulerSupport("custom")
    public final Observable<T> take(long j11, TimeUnit timeUnit, Scheduler scheduler) {
        return takeUntil(timer(j11, timeUnit, scheduler));
    }

    @CheckReturnValue
    @SchedulerSupport("custom")
    public final Observable<T> throttleLatest(long j11, TimeUnit timeUnit, Scheduler scheduler, boolean z11) {
        ObjectHelper.requireNonNull(timeUnit, "unit is null");
        ObjectHelper.requireNonNull(scheduler, "scheduler is null");
        return RxJavaPlugins.onAssembly(new ObservableThrottleLatest(this, j11, timeUnit, scheduler, z11));
    }

    @CheckReturnValue
    @SchedulerSupport("none")
    public final Observable<Timed<T>> timeInterval(TimeUnit timeUnit, Scheduler scheduler) {
        ObjectHelper.requireNonNull(timeUnit, "unit is null");
        ObjectHelper.requireNonNull(scheduler, "scheduler is null");
        return RxJavaPlugins.onAssembly(new ObservableTimeInterval(this, timeUnit, scheduler));
    }

    @CheckReturnValue
    @SchedulerSupport("io.reactivex:computation")
    public final Observable<T> timeout(long j11, TimeUnit timeUnit) {
        return timeout0(j11, timeUnit, (ObservableSource) null, Schedulers.computation());
    }

    @CheckReturnValue
    @SchedulerSupport("none")
    public final Observable<Timed<T>> timestamp(TimeUnit timeUnit, Scheduler scheduler) {
        ObjectHelper.requireNonNull(timeUnit, "unit is null");
        ObjectHelper.requireNonNull(scheduler, "scheduler is null");
        return map(Functions.timestampWith(timeUnit, scheduler));
    }

    @CheckReturnValue
    @SchedulerSupport("none")
    public final <U extends Collection<? super T>> Single<U> toList(Callable<U> callable) {
        ObjectHelper.requireNonNull(callable, "collectionSupplier is null");
        return RxJavaPlugins.onAssembly(new ObservableToListSingle(this, callable));
    }

    @CheckReturnValue
    @SchedulerSupport("none")
    public final Single<List<T>> toSortedList(Comparator<? super T> comparator, int i11) {
        ObjectHelper.requireNonNull(comparator, "comparator is null");
        return toList(i11).map(Functions.listSorter(comparator));
    }

    @CheckReturnValue
    @SchedulerSupport("none")
    public final <T1, T2, R> Observable<R> withLatestFrom(ObservableSource<T1> observableSource, ObservableSource<T2> observableSource2, Function3<? super T, ? super T1, ? super T2, R> function3) {
        ObjectHelper.requireNonNull(observableSource, "o1 is null");
        ObjectHelper.requireNonNull(observableSource2, "o2 is null");
        ObjectHelper.requireNonNull(function3, "combiner is null");
        return withLatestFrom((ObservableSource<?>[]) new ObservableSource[]{observableSource, observableSource2}, Functions.toFunction(function3));
    }

    @CheckReturnValue
    @SchedulerSupport("none")
    public final <U, R> Observable<R> zipWith(ObservableSource<? extends U> observableSource, BiFunction<? super T, ? super U, ? extends R> biFunction) {
        ObjectHelper.requireNonNull(observableSource, "other is null");
        return zip(this, observableSource, biFunction);
    }

    @CheckReturnValue
    @NonNull
    @SchedulerSupport("none")
    public static <T, S> Observable<T> generate(Callable<S> callable, BiConsumer<S, Emitter<T>> biConsumer) {
        ObjectHelper.requireNonNull(biConsumer, "generator is null");
        return generate(callable, ObservableInternalHelper.simpleBiGenerator(biConsumer), Functions.emptyConsumer());
    }

    @CheckReturnValue
    @SchedulerSupport("io.reactivex:computation")
    public static Observable<Long> interval(long j11, TimeUnit timeUnit) {
        return interval(j11, j11, timeUnit, Schedulers.computation());
    }

    @CheckReturnValue
    @SchedulerSupport("none")
    public final T blockingFirst(T t11) {
        BlockingFirstObserver blockingFirstObserver = new BlockingFirstObserver();
        subscribe(blockingFirstObserver);
        T blockingGet = blockingFirstObserver.blockingGet();
        return blockingGet != null ? blockingGet : t11;
    }

    @CheckReturnValue
    @SchedulerSupport("none")
    public final T blockingLast(T t11) {
        BlockingLastObserver blockingLastObserver = new BlockingLastObserver();
        subscribe(blockingLastObserver);
        T blockingGet = blockingLastObserver.blockingGet();
        return blockingGet != null ? blockingGet : t11;
    }

    @SchedulerSupport("none")
    public final void blockingSubscribe(Observer<? super T> observer) {
        ObservableBlockingSubscribe.subscribe(this, observer);
    }

    @CheckReturnValue
    @SchedulerSupport("none")
    public final Observable<T> concatWith(@NonNull MaybeSource<? extends T> maybeSource) {
        ObjectHelper.requireNonNull(maybeSource, "other is null");
        return RxJavaPlugins.onAssembly(new ObservableConcatWithMaybe(this, maybeSource));
    }

    @CheckReturnValue
    @SchedulerSupport("custom")
    public final Observable<T> delay(long j11, TimeUnit timeUnit, Scheduler scheduler) {
        return delay(j11, timeUnit, scheduler, false);
    }

    @CheckReturnValue
    @SchedulerSupport("none")
    public final <K, V> Observable<GroupedObservable<K, V>> groupBy(Function<? super T, ? extends K> function, Function<? super T, ? extends V> function2, boolean z11, int i11) {
        ObjectHelper.requireNonNull(function, "keySelector is null");
        ObjectHelper.requireNonNull(function2, "valueSelector is null");
        ObjectHelper.verifyPositive(i11, "bufferSize");
        return RxJavaPlugins.onAssembly(new ObservableGroupBy(this, function, function2, i11, z11));
    }

    @CheckReturnValue
    @SchedulerSupport("none")
    public final Observable<T> mergeWith(@NonNull MaybeSource<? extends T> maybeSource) {
        ObjectHelper.requireNonNull(maybeSource, "other is null");
        return RxJavaPlugins.onAssembly(new ObservableMergeWithMaybe(this, maybeSource));
    }

    @CheckReturnValue
    @SchedulerSupport("none")
    public final Observable<T> retry(long j11, Predicate<? super Throwable> predicate) {
        if (j11 >= 0) {
            ObjectHelper.requireNonNull(predicate, "predicate is null");
            return RxJavaPlugins.onAssembly(new ObservableRetryPredicate(this, j11, predicate));
        }
        throw new IllegalArgumentException("times >= 0 required but it was " + j11);
    }

    @CheckReturnValue
    @SchedulerSupport("io.reactivex:trampoline")
    public final Observable<T> skipLast(long j11, TimeUnit timeUnit, boolean z11) {
        return skipLast(j11, timeUnit, Schedulers.trampoline(), z11, bufferSize());
    }

    @CheckReturnValue
    @SchedulerSupport("none")
    public final Disposable subscribe(Consumer<? super T> consumer, Consumer<? super Throwable> consumer2, Action action, Consumer<? super Disposable> consumer3) {
        ObjectHelper.requireNonNull(consumer, "onNext is null");
        ObjectHelper.requireNonNull(consumer2, "onError is null");
        ObjectHelper.requireNonNull(action, "onComplete is null");
        ObjectHelper.requireNonNull(consumer3, "onSubscribe is null");
        LambdaObserver lambdaObserver = new LambdaObserver(consumer, consumer2, action, consumer3);
        subscribe(lambdaObserver);
        return lambdaObserver;
    }

    @CheckReturnValue
    @SchedulerSupport("io.reactivex:trampoline")
    public final Observable<T> takeLast(long j11, long j12, TimeUnit timeUnit) {
        return takeLast(j11, j12, timeUnit, Schedulers.trampoline(), false, bufferSize());
    }

    @CheckReturnValue
    @SchedulerSupport("io.reactivex:computation")
    public final Observable<T> timeout(long j11, TimeUnit timeUnit, ObservableSource<? extends T> observableSource) {
        ObjectHelper.requireNonNull(observableSource, "other is null");
        return timeout0(j11, timeUnit, observableSource, Schedulers.computation());
    }

    @CheckReturnValue
    @SchedulerSupport("none")
    public final <K, V> Single<Map<K, Collection<V>>> toMultimap(Function<? super T, ? extends K> function, Function<? super T, ? extends V> function2) {
        return toMultimap(function, function2, HashMapSupplier.asCallable(), ArrayListSupplier.asFunction());
    }

    @CheckReturnValue
    @NonNull
    @SchedulerSupport("custom")
    public static <T> Observable<T> fromFuture(Future<? extends T> future, long j11, TimeUnit timeUnit, Scheduler scheduler) {
        ObjectHelper.requireNonNull(scheduler, "scheduler is null");
        return fromFuture(future, j11, timeUnit).subscribeOn(scheduler);
    }

    @CheckReturnValue
    @SchedulerSupport("custom")
    public static Observable<Long> interval(long j11, TimeUnit timeUnit, Scheduler scheduler) {
        return interval(j11, j11, timeUnit, scheduler);
    }

    @CheckReturnValue
    @NonNull
    @SchedulerSupport("none")
    public static <T> Observable<T> just(T t11, T t12, T t13) {
        ObjectHelper.requireNonNull(t11, "item1 is null");
        ObjectHelper.requireNonNull(t12, "item2 is null");
        ObjectHelper.requireNonNull(t13, "item3 is null");
        return fromArray(t11, t12, t13);
    }

    @CheckReturnValue
    @SchedulerSupport("none")
    public static <T> Observable<T> merge(ObservableSource<? extends ObservableSource<? extends T>> observableSource, int i11) {
        ObjectHelper.requireNonNull(observableSource, "sources is null");
        ObjectHelper.verifyPositive(i11, "maxConcurrency");
        return RxJavaPlugins.onAssembly(new ObservableFlatMap(observableSource, Functions.identity(), false, i11, bufferSize()));
    }

    @CheckReturnValue
    @SchedulerSupport("none")
    public static <T> Observable<T> mergeDelayError(ObservableSource<? extends ObservableSource<? extends T>> observableSource, int i11) {
        ObjectHelper.requireNonNull(observableSource, "sources is null");
        ObjectHelper.verifyPositive(i11, "maxConcurrency");
        return RxJavaPlugins.onAssembly(new ObservableFlatMap(observableSource, Functions.identity(), true, i11, bufferSize()));
    }

    @CheckReturnValue
    @SchedulerSupport("custom")
    public final Observable<T> delay(long j11, TimeUnit timeUnit, Scheduler scheduler, boolean z11) {
        ObjectHelper.requireNonNull(timeUnit, "unit is null");
        ObjectHelper.requireNonNull(scheduler, "scheduler is null");
        return RxJavaPlugins.onAssembly(new ObservableDelay(this, j11, timeUnit, scheduler, z11));
    }

    @CheckReturnValue
    @SchedulerSupport("none")
    public final Observable<T> doOnEach(Consumer<? super Notification<T>> consumer) {
        ObjectHelper.requireNonNull(consumer, "onNotification is null");
        return doOnEach(Functions.notificationOnNext(consumer), Functions.notificationOnError(consumer), Functions.notificationOnComplete(consumer), Functions.EMPTY_ACTION);
    }

    @CheckReturnValue
    @SchedulerSupport("custom")
    public final Observable<T> sample(long j11, TimeUnit timeUnit, Scheduler scheduler, boolean z11) {
        ObjectHelper.requireNonNull(timeUnit, "unit is null");
        ObjectHelper.requireNonNull(scheduler, "scheduler is null");
        return RxJavaPlugins.onAssembly(new ObservableSampleTimed(this, j11, timeUnit, scheduler, z11));
    }

    @CheckReturnValue
    @SchedulerSupport("custom")
    public final Observable<T> skipLast(long j11, TimeUnit timeUnit, Scheduler scheduler) {
        return skipLast(j11, timeUnit, scheduler, false, bufferSize());
    }

    @CheckReturnValue
    @SchedulerSupport("custom")
    public final Observable<T> takeLast(long j11, long j12, TimeUnit timeUnit, Scheduler scheduler) {
        return takeLast(j11, j12, timeUnit, scheduler, false, bufferSize());
    }

    @CheckReturnValue
    @SchedulerSupport("none")
    public final <K, V> Single<Map<K, V>> toMap(Function<? super T, ? extends K> function, Function<? super T, ? extends V> function2, Callable<? extends Map<K, V>> callable) {
        ObjectHelper.requireNonNull(function, "keySelector is null");
        ObjectHelper.requireNonNull(function2, "valueSelector is null");
        ObjectHelper.requireNonNull(callable, "mapSupplier is null");
        return collect(callable, Functions.toMapKeyValueSelector(function, function2));
    }

    @CheckReturnValue
    @SchedulerSupport("none")
    public final Single<List<T>> toSortedList(int i11) {
        return toSortedList(Functions.naturalOrder(), i11);
    }

    @CheckReturnValue
    @SchedulerSupport("none")
    public final <U, R> Observable<R> zipWith(ObservableSource<? extends U> observableSource, BiFunction<? super T, ? super U, ? extends R> biFunction, boolean z11) {
        return zip(this, observableSource, biFunction, z11);
    }

    @CheckReturnValue
    @SchedulerSupport("none")
    public static <T, R> Observable<R> combineLatest(ObservableSource<? extends T>[] observableSourceArr, Function<? super Object[], ? extends R> function) {
        return combineLatest(observableSourceArr, function, bufferSize());
    }

    @CheckReturnValue
    @NonNull
    @SchedulerSupport("none")
    public static <T> Observable<T> concat(ObservableSource<? extends T> observableSource, ObservableSource<? extends T> observableSource2) {
        ObjectHelper.requireNonNull(observableSource, "source1 is null");
        ObjectHelper.requireNonNull(observableSource2, "source2 is null");
        return concatArray(observableSource, observableSource2);
    }

    @CheckReturnValue
    @NonNull
    @SchedulerSupport("none")
    public static <T, S> Observable<T> generate(Callable<S> callable, BiConsumer<S, Emitter<T>> biConsumer, Consumer<? super S> consumer) {
        ObjectHelper.requireNonNull(biConsumer, "generator is null");
        return generate(callable, ObservableInternalHelper.simpleBiGenerator(biConsumer), consumer);
    }

    @CheckReturnValue
    @SchedulerSupport("none")
    public final <U extends Collection<? super T>> Observable<U> buffer(int i11, Callable<U> callable) {
        return buffer(i11, i11, callable);
    }

    @CheckReturnValue
    @SchedulerSupport("none")
    public final Observable<T> concatWith(@NonNull CompletableSource completableSource) {
        ObjectHelper.requireNonNull(completableSource, "other is null");
        return RxJavaPlugins.onAssembly(new ObservableConcatWithCompletable(this, completableSource));
    }

    @CheckReturnValue
    @SchedulerSupport("none")
    public final Observable<T> mergeWith(@NonNull CompletableSource completableSource) {
        ObjectHelper.requireNonNull(completableSource, "other is null");
        return RxJavaPlugins.onAssembly(new ObservableMergeWithCompletable(this, completableSource));
    }

    @CheckReturnValue
    @SchedulerSupport("io.reactivex:computation")
    public final <R> Observable<R> replay(Function<? super Observable<T>, ? extends ObservableSource<R>> function, int i11, long j11, TimeUnit timeUnit) {
        return replay(function, i11, j11, timeUnit, Schedulers.computation());
    }

    @CheckReturnValue
    @SchedulerSupport("custom")
    public final Observable<T> skipLast(long j11, TimeUnit timeUnit, Scheduler scheduler, boolean z11) {
        return skipLast(j11, timeUnit, scheduler, z11, bufferSize());
    }

    @CheckReturnValue
    @SchedulerSupport("custom")
    public final Observable<T> takeLast(long j11, long j12, TimeUnit timeUnit, Scheduler scheduler, boolean z11, int i11) {
        ObjectHelper.requireNonNull(timeUnit, "unit is null");
        ObjectHelper.requireNonNull(scheduler, "scheduler is null");
        ObjectHelper.verifyPositive(i11, "bufferSize");
        if (j11 >= 0) {
            return RxJavaPlugins.onAssembly(new ObservableTakeLastTimed(this, j11, j12, timeUnit, scheduler, i11, z11));
        }
        throw new IndexOutOfBoundsException("count >= 0 required but it was " + j11);
    }

    @CheckReturnValue
    @SchedulerSupport("custom")
    public final Observable<T> timeout(long j11, TimeUnit timeUnit, Scheduler scheduler, ObservableSource<? extends T> observableSource) {
        ObjectHelper.requireNonNull(observableSource, "other is null");
        return timeout0(j11, timeUnit, observableSource, scheduler);
    }

    @CheckReturnValue
    @SchedulerSupport("io.reactivex:computation")
    public final Observable<Observable<T>> window(long j11, long j12, TimeUnit timeUnit) {
        return window(j11, j12, timeUnit, Schedulers.computation(), bufferSize());
    }

    @CheckReturnValue
    @SchedulerSupport("none")
    public final <U, R> Observable<R> zipWith(ObservableSource<? extends U> observableSource, BiFunction<? super T, ? super U, ? extends R> biFunction, boolean z11, int i11) {
        return zip(this, observableSource, biFunction, z11, i11);
    }

    @CheckReturnValue
    @NonNull
    @SchedulerSupport("none")
    public static <T, R> Observable<R> combineLatest(ObservableSource<? extends T>[] observableSourceArr, Function<? super Object[], ? extends R> function, int i11) {
        ObjectHelper.requireNonNull(observableSourceArr, "sources is null");
        if (observableSourceArr.length == 0) {
            return empty();
        }
        ObjectHelper.requireNonNull(function, "combiner is null");
        ObjectHelper.verifyPositive(i11, "bufferSize");
        return RxJavaPlugins.onAssembly(new ObservableCombineLatest(observableSourceArr, (Iterable) null, function, i11 << 1, false));
    }

    @CheckReturnValue
    @SchedulerSupport("none")
    public static <T, R> Observable<R> combineLatestDelayError(Iterable<? extends ObservableSource<? extends T>> iterable, Function<? super Object[], ? extends R> function) {
        return combineLatestDelayError(iterable, function, bufferSize());
    }

    @CheckReturnValue
    @SchedulerSupport("none")
    public static <T> Single<Boolean> sequenceEqual(ObservableSource<? extends T> observableSource, ObservableSource<? extends T> observableSource2, int i11) {
        return sequenceEqual(observableSource, observableSource2, ObjectHelper.equalsPredicate(), i11);
    }

    @CheckReturnValue
    @SchedulerSupport("io.reactivex:computation")
    public final Observable<List<T>> buffer(long j11, long j12, TimeUnit timeUnit) {
        return buffer(j11, j12, timeUnit, Schedulers.computation(), ArrayListSupplier.asCallable());
    }

    @CheckReturnValue
    @SchedulerSupport("custom")
    public final <R> Observable<R> replay(Function<? super Observable<T>, ? extends ObservableSource<R>> function, int i11, long j11, TimeUnit timeUnit, Scheduler scheduler) {
        ObjectHelper.requireNonNull(function, "selector is null");
        ObjectHelper.verifyPositive(i11, "bufferSize");
        ObjectHelper.requireNonNull(timeUnit, "unit is null");
        ObjectHelper.requireNonNull(scheduler, "scheduler is null");
        return ObservableReplay.multicastSelector(ObservableInternalHelper.replayCallable(this, i11, j11, timeUnit, scheduler), function);
    }

    @CheckReturnValue
    @SchedulerSupport("none")
    public final Observable<T> retry(Predicate<? super Throwable> predicate) {
        return retry(Long.MAX_VALUE, predicate);
    }

    @CheckReturnValue
    @SchedulerSupport("custom")
    public final Observable<T> skipLast(long j11, TimeUnit timeUnit, Scheduler scheduler, boolean z11, int i11) {
        ObjectHelper.requireNonNull(timeUnit, "unit is null");
        ObjectHelper.requireNonNull(scheduler, "scheduler is null");
        ObjectHelper.verifyPositive(i11, "bufferSize");
        return RxJavaPlugins.onAssembly(new ObservableSkipLastTimed(this, j11, timeUnit, scheduler, i11 << 1, z11));
    }

    @CheckReturnValue
    @SchedulerSupport("none")
    public final <K, V> Single<Map<K, Collection<V>>> toMultimap(Function<? super T, ? extends K> function, Function<? super T, ? extends V> function2, Callable<? extends Map<K, Collection<V>>> callable, Function<? super K, ? extends Collection<? super V>> function3) {
        ObjectHelper.requireNonNull(function, "keySelector is null");
        ObjectHelper.requireNonNull(function2, "valueSelector is null");
        ObjectHelper.requireNonNull(callable, "mapSupplier is null");
        ObjectHelper.requireNonNull(function3, "collectionFactory is null");
        return collect(callable, Functions.toMultimapKeyValueSelector(function, function2, function3));
    }

    @CheckReturnValue
    @SchedulerSupport("custom")
    public final Observable<Observable<T>> window(long j11, long j12, TimeUnit timeUnit, Scheduler scheduler) {
        return window(j11, j12, timeUnit, scheduler, bufferSize());
    }

    @CheckReturnValue
    @NonNull
    @SchedulerSupport("none")
    public static <T, R> Observable<R> combineLatestDelayError(Iterable<? extends ObservableSource<? extends T>> iterable, Function<? super Object[], ? extends R> function, int i11) {
        ObjectHelper.requireNonNull(iterable, "sources is null");
        ObjectHelper.requireNonNull(function, "combiner is null");
        ObjectHelper.verifyPositive(i11, "bufferSize");
        return RxJavaPlugins.onAssembly(new ObservableCombineLatest((ObservableSource<? extends T>[]) null, iterable, function, i11 << 1, true));
    }

    @CheckReturnValue
    @NonNull
    @SchedulerSupport("custom")
    public static <T> Observable<T> fromFuture(Future<? extends T> future, Scheduler scheduler) {
        ObjectHelper.requireNonNull(scheduler, "scheduler is null");
        return fromFuture(future).subscribeOn(scheduler);
    }

    @CheckReturnValue
    @SchedulerSupport("none")
    public static <T, S> Observable<T> generate(Callable<S> callable, BiFunction<S, Emitter<T>, S> biFunction) {
        return generate(callable, biFunction, Functions.emptyConsumer());
    }

    @CheckReturnValue
    @SchedulerSupport("none")
    public static <T> Observable<T> merge(ObservableSource<? extends T> observableSource, ObservableSource<? extends T> observableSource2) {
        ObjectHelper.requireNonNull(observableSource, "source1 is null");
        ObjectHelper.requireNonNull(observableSource2, "source2 is null");
        return fromArray(observableSource, observableSource2).flatMap(Functions.identity(), false, 2);
    }

    @CheckReturnValue
    @SchedulerSupport("none")
    public static <T> Observable<T> mergeDelayError(ObservableSource<? extends T> observableSource, ObservableSource<? extends T> observableSource2) {
        ObjectHelper.requireNonNull(observableSource, "source1 is null");
        ObjectHelper.requireNonNull(observableSource2, "source2 is null");
        return fromArray(observableSource, observableSource2).flatMap(Functions.identity(), true, 2);
    }

    @CheckReturnValue
    @SchedulerSupport("none")
    public static <T1, T2, R> Observable<R> zip(ObservableSource<? extends T1> observableSource, ObservableSource<? extends T2> observableSource2, BiFunction<? super T1, ? super T2, ? extends R> biFunction) {
        ObjectHelper.requireNonNull(observableSource, "source1 is null");
        ObjectHelper.requireNonNull(observableSource2, "source2 is null");
        return zipArray(Functions.toFunction(biFunction), false, bufferSize(), observableSource, observableSource2);
    }

    @CheckReturnValue
    @SchedulerSupport("custom")
    public final Observable<List<T>> buffer(long j11, long j12, TimeUnit timeUnit, Scheduler scheduler) {
        return buffer(j11, j12, timeUnit, scheduler, ArrayListSupplier.asCallable());
    }

    /* JADX WARNING: type inference failed for: r2v0, types: [io.reactivex.functions.Function, io.reactivex.functions.Function<? super T, ? extends io.reactivex.ObservableSource<V>>] */
    /* JADX WARNING: Unknown variable types count: 1 */
    @io.reactivex.annotations.CheckReturnValue
    @io.reactivex.annotations.SchedulerSupport("none")
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final <U, V> io.reactivex.Observable<T> delay(io.reactivex.ObservableSource<U> r1, io.reactivex.functions.Function<? super T, ? extends io.reactivex.ObservableSource<V>> r2) {
        /*
            r0 = this;
            io.reactivex.Observable r1 = r0.delaySubscription(r1)
            io.reactivex.Observable r1 = r1.delay(r2)
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: io.reactivex.Observable.delay(io.reactivex.ObservableSource, io.reactivex.functions.Function):io.reactivex.Observable");
    }

    @CheckReturnValue
    @SchedulerSupport("none")
    public final <U> Observable<T> sample(ObservableSource<U> observableSource) {
        ObjectHelper.requireNonNull(observableSource, "sampler is null");
        return RxJavaPlugins.onAssembly(new ObservableSampleWithObservable(this, observableSource, false));
    }

    @CheckReturnValue
    @SchedulerSupport("custom")
    public final Observable<T> timeout(long j11, TimeUnit timeUnit, Scheduler scheduler) {
        return timeout0(j11, timeUnit, (ObservableSource) null, scheduler);
    }

    @CheckReturnValue
    @SchedulerSupport("custom")
    public final Observable<Observable<T>> window(long j11, long j12, TimeUnit timeUnit, Scheduler scheduler, int i11) {
        ObjectHelper.verifyPositive(j11, "timespan");
        long j13 = j12;
        ObjectHelper.verifyPositive(j13, "timeskip");
        int i12 = i11;
        ObjectHelper.verifyPositive(i12, "bufferSize");
        Scheduler scheduler2 = scheduler;
        ObjectHelper.requireNonNull(scheduler2, "scheduler is null");
        TimeUnit timeUnit2 = timeUnit;
        ObjectHelper.requireNonNull(timeUnit2, "unit is null");
        return RxJavaPlugins.onAssembly(new ObservableWindowTimed(this, j11, j13, timeUnit2, scheduler2, Long.MAX_VALUE, i12, false));
    }

    @CheckReturnValue
    @SchedulerSupport("none")
    public final <T1, T2, T3, R> Observable<R> withLatestFrom(ObservableSource<T1> observableSource, ObservableSource<T2> observableSource2, ObservableSource<T3> observableSource3, Function4<? super T, ? super T1, ? super T2, ? super T3, R> function4) {
        ObjectHelper.requireNonNull(observableSource, "o1 is null");
        ObjectHelper.requireNonNull(observableSource2, "o2 is null");
        ObjectHelper.requireNonNull(observableSource3, "o3 is null");
        ObjectHelper.requireNonNull(function4, "combiner is null");
        return withLatestFrom((ObservableSource<?>[]) new ObservableSource[]{observableSource, observableSource2, observableSource3}, Functions.toFunction(function4));
    }

    @CheckReturnValue
    @NonNull
    @SchedulerSupport("none")
    public static <T> Observable<T> concat(ObservableSource<? extends T> observableSource, ObservableSource<? extends T> observableSource2, ObservableSource<? extends T> observableSource3) {
        ObjectHelper.requireNonNull(observableSource, "source1 is null");
        ObjectHelper.requireNonNull(observableSource2, "source2 is null");
        ObjectHelper.requireNonNull(observableSource3, "source3 is null");
        return concatArray(observableSource, observableSource2, observableSource3);
    }

    @CheckReturnValue
    @NonNull
    @SchedulerSupport("none")
    public static <T, S> Observable<T> generate(Callable<S> callable, BiFunction<S, Emitter<T>, S> biFunction, Consumer<? super S> consumer) {
        ObjectHelper.requireNonNull(callable, "initialState is null");
        ObjectHelper.requireNonNull(biFunction, "generator is null");
        ObjectHelper.requireNonNull(consumer, "disposeState is null");
        return RxJavaPlugins.onAssembly(new ObservableGenerate(callable, biFunction, consumer));
    }

    @CheckReturnValue
    @NonNull
    @SchedulerSupport("none")
    public static <T> Observable<T> just(T t11, T t12, T t13, T t14) {
        ObjectHelper.requireNonNull(t11, "item1 is null");
        ObjectHelper.requireNonNull(t12, "item2 is null");
        ObjectHelper.requireNonNull(t13, "item3 is null");
        ObjectHelper.requireNonNull(t14, "item4 is null");
        return fromArray(t11, t12, t13, t14);
    }

    @CheckReturnValue
    @SchedulerSupport("custom")
    public final <U extends Collection<? super T>> Observable<U> buffer(long j11, long j12, TimeUnit timeUnit, Scheduler scheduler, Callable<U> callable) {
        TimeUnit timeUnit2 = timeUnit;
        ObjectHelper.requireNonNull(timeUnit2, "unit is null");
        Scheduler scheduler2 = scheduler;
        ObjectHelper.requireNonNull(scheduler2, "scheduler is null");
        Callable<U> callable2 = callable;
        ObjectHelper.requireNonNull(callable2, "bufferSupplier is null");
        return RxJavaPlugins.onAssembly(new ObservableBufferTimed(this, j11, j12, timeUnit2, scheduler2, callable2, Integer.MAX_VALUE, false));
    }

    @CheckReturnValue
    @SchedulerSupport("none")
    public final <U, V> Observable<T> timeout(ObservableSource<U> observableSource, Function<? super T, ? extends ObservableSource<V>> function) {
        ObjectHelper.requireNonNull(observableSource, "firstTimeoutIndicator is null");
        return timeout0(observableSource, function, (ObservableSource) null);
    }

    @CheckReturnValue
    @SchedulerSupport("none")
    public final Observable<T> doOnEach(Observer<? super T> observer) {
        ObjectHelper.requireNonNull(observer, "observer is null");
        return doOnEach(ObservableInternalHelper.observerOnNext(observer), ObservableInternalHelper.observerOnError(observer), ObservableInternalHelper.observerOnComplete(observer), Functions.EMPTY_ACTION);
    }

    @CheckReturnValue
    @SchedulerSupport("none")
    public final <U> Observable<T> sample(ObservableSource<U> observableSource, boolean z11) {
        ObjectHelper.requireNonNull(observableSource, "sampler is null");
        return RxJavaPlugins.onAssembly(new ObservableSampleWithObservable(this, observableSource, z11));
    }

    @SchedulerSupport("none")
    public final void subscribe(Observer<? super T> observer) {
        ObjectHelper.requireNonNull(observer, "observer is null");
        try {
            Observer<? super Object> onSubscribe = RxJavaPlugins.onSubscribe(this, observer);
            ObjectHelper.requireNonNull(onSubscribe, "The RxJavaPlugins.onSubscribe hook returned a null Observer. Please change the handler provided to RxJavaPlugins.setOnObservableSubscribe for invalid null returns. Further reading: https://github.com/ReactiveX/RxJava/wiki/Plugins");
            subscribeActual(onSubscribe);
        } catch (NullPointerException e11) {
            throw e11;
        } catch (Throwable th2) {
            Exceptions.throwIfFatal(th2);
            RxJavaPlugins.onError(th2);
            NullPointerException nullPointerException = new NullPointerException("Actually not, but can't throw other exceptions due to RS");
            nullPointerException.initCause(th2);
            throw nullPointerException;
        }
    }

    @CheckReturnValue
    @SchedulerSupport("none")
    public static <T> Observable<T> merge(ObservableSource<? extends T> observableSource, ObservableSource<? extends T> observableSource2, ObservableSource<? extends T> observableSource3) {
        ObjectHelper.requireNonNull(observableSource, "source1 is null");
        ObjectHelper.requireNonNull(observableSource2, "source2 is null");
        ObjectHelper.requireNonNull(observableSource3, "source3 is null");
        return fromArray(observableSource, observableSource2, observableSource3).flatMap(Functions.identity(), false, 3);
    }

    @CheckReturnValue
    @SchedulerSupport("none")
    public static <T> Observable<T> mergeDelayError(ObservableSource<? extends T> observableSource, ObservableSource<? extends T> observableSource2, ObservableSource<? extends T> observableSource3) {
        ObjectHelper.requireNonNull(observableSource, "source1 is null");
        ObjectHelper.requireNonNull(observableSource2, "source2 is null");
        ObjectHelper.requireNonNull(observableSource3, "source3 is null");
        return fromArray(observableSource, observableSource2, observableSource3).flatMap(Functions.identity(), true, 3);
    }

    @CheckReturnValue
    @SchedulerSupport("none")
    public static <T1, T2, R> Observable<R> zip(ObservableSource<? extends T1> observableSource, ObservableSource<? extends T2> observableSource2, BiFunction<? super T1, ? super T2, ? extends R> biFunction, boolean z11) {
        ObjectHelper.requireNonNull(observableSource, "source1 is null");
        ObjectHelper.requireNonNull(observableSource2, "source2 is null");
        return zipArray(Functions.toFunction(biFunction), z11, bufferSize(), observableSource, observableSource2);
    }

    @CheckReturnValue
    @SchedulerSupport("none")
    public final <R> Observable<R> flatMap(Function<? super T, ? extends ObservableSource<? extends R>> function, Function<? super Throwable, ? extends ObservableSource<? extends R>> function2, Callable<? extends ObservableSource<? extends R>> callable) {
        ObjectHelper.requireNonNull(function, "onNextMapper is null");
        ObjectHelper.requireNonNull(function2, "onErrorMapper is null");
        ObjectHelper.requireNonNull(callable, "onCompleteSupplier is null");
        return merge(new ObservableMapNotification(this, function, function2, callable));
    }

    @CheckReturnValue
    @SchedulerSupport("io.reactivex:trampoline")
    public final Observable<T> takeLast(long j11, TimeUnit timeUnit) {
        return takeLast(j11, timeUnit, Schedulers.trampoline(), false, bufferSize());
    }

    @CheckReturnValue
    @SchedulerSupport("none")
    public final <U, V> Observable<T> timeout(ObservableSource<U> observableSource, Function<? super T, ? extends ObservableSource<V>> function, ObservableSource<? extends T> observableSource2) {
        ObjectHelper.requireNonNull(observableSource, "firstTimeoutIndicator is null");
        ObjectHelper.requireNonNull(observableSource2, "other is null");
        return timeout0(observableSource, function, observableSource2);
    }

    @CheckReturnValue
    @SchedulerSupport("io.reactivex:trampoline")
    public final Observable<T> takeLast(long j11, TimeUnit timeUnit, boolean z11) {
        return takeLast(j11, timeUnit, Schedulers.trampoline(), z11, bufferSize());
    }

    @CheckReturnValue
    @SchedulerSupport("none")
    public final <K, V> Single<Map<K, Collection<V>>> toMultimap(Function<? super T, ? extends K> function, Function<? super T, ? extends V> function2, Callable<Map<K, Collection<V>>> callable) {
        return toMultimap(function, function2, callable, ArrayListSupplier.asFunction());
    }

    @CheckReturnValue
    @NonNull
    @SchedulerSupport("none")
    public static <T1, T2, R> Observable<R> combineLatest(ObservableSource<? extends T1> observableSource, ObservableSource<? extends T2> observableSource2, BiFunction<? super T1, ? super T2, ? extends R> biFunction) {
        ObjectHelper.requireNonNull(observableSource, "source1 is null");
        ObjectHelper.requireNonNull(observableSource2, "source2 is null");
        return combineLatest(Functions.toFunction(biFunction), bufferSize(), (ObservableSource<? extends T>[]) new ObservableSource[]{observableSource, observableSource2});
    }

    @CheckReturnValue
    @NonNull
    @SchedulerSupport("none")
    public static <T> Observable<T> concat(ObservableSource<? extends T> observableSource, ObservableSource<? extends T> observableSource2, ObservableSource<? extends T> observableSource3, ObservableSource<? extends T> observableSource4) {
        ObjectHelper.requireNonNull(observableSource, "source1 is null");
        ObjectHelper.requireNonNull(observableSource2, "source2 is null");
        ObjectHelper.requireNonNull(observableSource3, "source3 is null");
        ObjectHelper.requireNonNull(observableSource4, "source4 is null");
        return concatArray(observableSource, observableSource2, observableSource3, observableSource4);
    }

    @CheckReturnValue
    @SchedulerSupport("io.reactivex:computation")
    public final Observable<List<T>> buffer(long j11, TimeUnit timeUnit) {
        return buffer(j11, timeUnit, Schedulers.computation(), Integer.MAX_VALUE);
    }

    @CheckReturnValue
    @SchedulerSupport("custom")
    public final <R> Observable<R> replay(Function<? super Observable<T>, ? extends ObservableSource<R>> function, int i11, Scheduler scheduler) {
        ObjectHelper.requireNonNull(function, "selector is null");
        ObjectHelper.requireNonNull(scheduler, "scheduler is null");
        ObjectHelper.verifyPositive(i11, "bufferSize");
        return ObservableReplay.multicastSelector(ObservableInternalHelper.replayCallable(this, i11), ObservableInternalHelper.replayFunction(function, scheduler));
    }

    @CheckReturnValue
    @SchedulerSupport("custom")
    public final Observable<T> takeLast(long j11, TimeUnit timeUnit, Scheduler scheduler) {
        return takeLast(j11, timeUnit, scheduler, false, bufferSize());
    }

    @CheckReturnValue
    @NonNull
    @SchedulerSupport("none")
    public static <T> Observable<T> just(T t11, T t12, T t13, T t14, T t15) {
        ObjectHelper.requireNonNull(t11, "item1 is null");
        ObjectHelper.requireNonNull(t12, "item2 is null");
        ObjectHelper.requireNonNull(t13, "item3 is null");
        ObjectHelper.requireNonNull(t14, "item4 is null");
        ObjectHelper.requireNonNull(t15, "item5 is null");
        return fromArray(t11, t12, t13, t14, t15);
    }

    @CheckReturnValue
    @SchedulerSupport("none")
    public static <T1, T2, R> Observable<R> zip(ObservableSource<? extends T1> observableSource, ObservableSource<? extends T2> observableSource2, BiFunction<? super T1, ? super T2, ? extends R> biFunction, boolean z11, int i11) {
        ObjectHelper.requireNonNull(observableSource, "source1 is null");
        ObjectHelper.requireNonNull(observableSource2, "source2 is null");
        return zipArray(Functions.toFunction(biFunction), z11, i11, observableSource, observableSource2);
    }

    @CheckReturnValue
    @SchedulerSupport("io.reactivex:computation")
    public final Observable<List<T>> buffer(long j11, TimeUnit timeUnit, int i11) {
        return buffer(j11, timeUnit, Schedulers.computation(), i11);
    }

    @CheckReturnValue
    @SchedulerSupport("custom")
    public final Observable<T> takeLast(long j11, TimeUnit timeUnit, Scheduler scheduler, boolean z11) {
        return takeLast(j11, timeUnit, scheduler, z11, bufferSize());
    }

    @CheckReturnValue
    @SchedulerSupport("io.reactivex:computation")
    public final Observable<Observable<T>> window(long j11, TimeUnit timeUnit) {
        return window(j11, timeUnit, Schedulers.computation(), Long.MAX_VALUE, false);
    }

    @CheckReturnValue
    @SchedulerSupport("none")
    public final <T1, T2, T3, T4, R> Observable<R> withLatestFrom(ObservableSource<T1> observableSource, ObservableSource<T2> observableSource2, ObservableSource<T3> observableSource3, ObservableSource<T4> observableSource4, Function5<? super T, ? super T1, ? super T2, ? super T3, ? super T4, R> function5) {
        ObjectHelper.requireNonNull(observableSource, "o1 is null");
        ObjectHelper.requireNonNull(observableSource2, "o2 is null");
        ObjectHelper.requireNonNull(observableSource3, "o3 is null");
        ObjectHelper.requireNonNull(observableSource4, "o4 is null");
        ObjectHelper.requireNonNull(function5, "combiner is null");
        return withLatestFrom((ObservableSource<?>[]) new ObservableSource[]{observableSource, observableSource2, observableSource3, observableSource4}, Functions.toFunction(function5));
    }

    @CheckReturnValue
    @SchedulerSupport("none")
    public static <T> Observable<T> merge(ObservableSource<? extends T> observableSource, ObservableSource<? extends T> observableSource2, ObservableSource<? extends T> observableSource3, ObservableSource<? extends T> observableSource4) {
        ObjectHelper.requireNonNull(observableSource, "source1 is null");
        ObjectHelper.requireNonNull(observableSource2, "source2 is null");
        ObjectHelper.requireNonNull(observableSource3, "source3 is null");
        ObjectHelper.requireNonNull(observableSource4, "source4 is null");
        return fromArray(observableSource, observableSource2, observableSource3, observableSource4).flatMap(Functions.identity(), false, 4);
    }

    @CheckReturnValue
    @SchedulerSupport("none")
    public static <T> Observable<T> mergeDelayError(ObservableSource<? extends T> observableSource, ObservableSource<? extends T> observableSource2, ObservableSource<? extends T> observableSource3, ObservableSource<? extends T> observableSource4) {
        ObjectHelper.requireNonNull(observableSource, "source1 is null");
        ObjectHelper.requireNonNull(observableSource2, "source2 is null");
        ObjectHelper.requireNonNull(observableSource3, "source3 is null");
        ObjectHelper.requireNonNull(observableSource4, "source4 is null");
        return fromArray(observableSource, observableSource2, observableSource3, observableSource4).flatMap(Functions.identity(), true, 4);
    }

    @CheckReturnValue
    @SchedulerSupport("custom")
    public final Observable<List<T>> buffer(long j11, TimeUnit timeUnit, Scheduler scheduler, int i11) {
        return buffer(j11, timeUnit, scheduler, i11, ArrayListSupplier.asCallable(), false);
    }

    @CheckReturnValue
    @SchedulerSupport("none")
    public final <R> Observable<R> flatMap(Function<? super T, ? extends ObservableSource<? extends R>> function, Function<Throwable, ? extends ObservableSource<? extends R>> function2, Callable<? extends ObservableSource<? extends R>> callable, int i11) {
        ObjectHelper.requireNonNull(function, "onNextMapper is null");
        ObjectHelper.requireNonNull(function2, "onErrorMapper is null");
        ObjectHelper.requireNonNull(callable, "onCompleteSupplier is null");
        return merge(new ObservableMapNotification(this, function, function2, callable), i11);
    }

    @CheckReturnValue
    @SchedulerSupport("custom")
    public final Observable<T> takeLast(long j11, TimeUnit timeUnit, Scheduler scheduler, boolean z11, int i11) {
        return takeLast(Long.MAX_VALUE, j11, timeUnit, scheduler, z11, i11);
    }

    @CheckReturnValue
    @SchedulerSupport("io.reactivex:computation")
    public final Observable<Observable<T>> window(long j11, TimeUnit timeUnit, long j12) {
        return window(j11, timeUnit, Schedulers.computation(), j12, false);
    }

    @CheckReturnValue
    @NonNull
    @SchedulerSupport("none")
    public static <T1, T2, T3, R> Observable<R> combineLatest(ObservableSource<? extends T1> observableSource, ObservableSource<? extends T2> observableSource2, ObservableSource<? extends T3> observableSource3, Function3<? super T1, ? super T2, ? super T3, ? extends R> function3) {
        ObjectHelper.requireNonNull(observableSource, "source1 is null");
        ObjectHelper.requireNonNull(observableSource2, "source2 is null");
        ObjectHelper.requireNonNull(observableSource3, "source3 is null");
        return combineLatest(Functions.toFunction(function3), bufferSize(), (ObservableSource<? extends T>[]) new ObservableSource[]{observableSource, observableSource2, observableSource3});
    }

    @CheckReturnValue
    @SchedulerSupport("custom")
    public final <U extends Collection<? super T>> Observable<U> buffer(long j11, TimeUnit timeUnit, Scheduler scheduler, int i11, Callable<U> callable, boolean z11) {
        ObjectHelper.requireNonNull(timeUnit, "unit is null");
        Scheduler scheduler2 = scheduler;
        ObjectHelper.requireNonNull(scheduler2, "scheduler is null");
        Callable<U> callable2 = callable;
        ObjectHelper.requireNonNull(callable2, "bufferSupplier is null");
        int i12 = i11;
        ObjectHelper.verifyPositive(i12, "count");
        return RxJavaPlugins.onAssembly(new ObservableBufferTimed(this, j11, j11, timeUnit, scheduler2, callable2, i12, z11));
    }

    @CheckReturnValue
    @SchedulerSupport("io.reactivex:computation")
    public final Observable<Observable<T>> window(long j11, TimeUnit timeUnit, long j12, boolean z11) {
        return window(j11, timeUnit, Schedulers.computation(), j12, z11);
    }

    @CheckReturnValue
    @SchedulerSupport("none")
    public static <T1, T2, T3, R> Observable<R> zip(ObservableSource<? extends T1> observableSource, ObservableSource<? extends T2> observableSource2, ObservableSource<? extends T3> observableSource3, Function3<? super T1, ? super T2, ? super T3, ? extends R> function3) {
        ObjectHelper.requireNonNull(observableSource, "source1 is null");
        ObjectHelper.requireNonNull(observableSource2, "source2 is null");
        ObjectHelper.requireNonNull(observableSource3, "source3 is null");
        return zipArray(Functions.toFunction(function3), false, bufferSize(), observableSource, observableSource2, observableSource3);
    }

    @CheckReturnValue
    @SchedulerSupport("custom")
    public final Observable<Observable<T>> window(long j11, TimeUnit timeUnit, Scheduler scheduler) {
        return window(j11, timeUnit, scheduler, Long.MAX_VALUE, false);
    }

    @CheckReturnValue
    @SchedulerSupport("custom")
    public final Observable<Observable<T>> window(long j11, TimeUnit timeUnit, Scheduler scheduler, long j12) {
        return window(j11, timeUnit, scheduler, j12, false);
    }

    @CheckReturnValue
    @SchedulerSupport("none")
    public final <R> Observable<R> flatMap(Function<? super T, ? extends ObservableSource<? extends R>> function, int i11) {
        return flatMap(function, false, i11, bufferSize());
    }

    @CheckReturnValue
    @SchedulerSupport("io.reactivex:computation")
    public final <R> Observable<R> replay(Function<? super Observable<T>, ? extends ObservableSource<R>> function, long j11, TimeUnit timeUnit) {
        return replay(function, j11, timeUnit, Schedulers.computation());
    }

    @CheckReturnValue
    @SchedulerSupport("custom")
    public final Observable<Observable<T>> window(long j11, TimeUnit timeUnit, Scheduler scheduler, long j12, boolean z11) {
        return window(j11, timeUnit, scheduler, j12, z11, bufferSize());
    }

    @CheckReturnValue
    @NonNull
    @SchedulerSupport("none")
    public static <T1, T2, T3, T4, R> Observable<R> combineLatest(ObservableSource<? extends T1> observableSource, ObservableSource<? extends T2> observableSource2, ObservableSource<? extends T3> observableSource3, ObservableSource<? extends T4> observableSource4, Function4<? super T1, ? super T2, ? super T3, ? super T4, ? extends R> function4) {
        ObjectHelper.requireNonNull(observableSource, "source1 is null");
        ObjectHelper.requireNonNull(observableSource2, "source2 is null");
        ObjectHelper.requireNonNull(observableSource3, "source3 is null");
        ObjectHelper.requireNonNull(observableSource4, "source4 is null");
        return combineLatest(Functions.toFunction(function4), bufferSize(), (ObservableSource<? extends T>[]) new ObservableSource[]{observableSource, observableSource2, observableSource3, observableSource4});
    }

    @CheckReturnValue
    @NonNull
    @SchedulerSupport("none")
    public static <T> Observable<T> just(T t11, T t12, T t13, T t14, T t15, T t16) {
        ObjectHelper.requireNonNull(t11, "item1 is null");
        ObjectHelper.requireNonNull(t12, "item2 is null");
        ObjectHelper.requireNonNull(t13, "item3 is null");
        ObjectHelper.requireNonNull(t14, "item4 is null");
        ObjectHelper.requireNonNull(t15, "item5 is null");
        ObjectHelper.requireNonNull(t16, "item6 is null");
        return fromArray(t11, t12, t13, t14, t15, t16);
    }

    @CheckReturnValue
    @SchedulerSupport("none")
    public final <U, R> Observable<R> flatMap(Function<? super T, ? extends ObservableSource<? extends U>> function, BiFunction<? super T, ? super U, ? extends R> biFunction) {
        return flatMap(function, biFunction, false, bufferSize(), bufferSize());
    }

    @CheckReturnValue
    @SchedulerSupport("custom")
    public final <R> Observable<R> replay(Function<? super Observable<T>, ? extends ObservableSource<R>> function, long j11, TimeUnit timeUnit, Scheduler scheduler) {
        ObjectHelper.requireNonNull(function, "selector is null");
        ObjectHelper.requireNonNull(timeUnit, "unit is null");
        ObjectHelper.requireNonNull(scheduler, "scheduler is null");
        return ObservableReplay.multicastSelector(ObservableInternalHelper.replayCallable(this, j11, timeUnit, scheduler), function);
    }

    @CheckReturnValue
    @SchedulerSupport("custom")
    public final Observable<Observable<T>> window(long j11, TimeUnit timeUnit, Scheduler scheduler, long j12, boolean z11, int i11) {
        int i12 = i11;
        ObjectHelper.verifyPositive(i12, "bufferSize");
        Scheduler scheduler2 = scheduler;
        ObjectHelper.requireNonNull(scheduler2, "scheduler is null");
        TimeUnit timeUnit2 = timeUnit;
        ObjectHelper.requireNonNull(timeUnit2, "unit is null");
        long j13 = j12;
        ObjectHelper.verifyPositive(j13, "count");
        return RxJavaPlugins.onAssembly(new ObservableWindowTimed(this, j11, j11, timeUnit2, scheduler2, j13, i12, z11));
    }

    @CheckReturnValue
    @SchedulerSupport("none")
    public static <T1, T2, T3, T4, R> Observable<R> zip(ObservableSource<? extends T1> observableSource, ObservableSource<? extends T2> observableSource2, ObservableSource<? extends T3> observableSource3, ObservableSource<? extends T4> observableSource4, Function4<? super T1, ? super T2, ? super T3, ? super T4, ? extends R> function4) {
        ObjectHelper.requireNonNull(observableSource, "source1 is null");
        ObjectHelper.requireNonNull(observableSource2, "source2 is null");
        ObjectHelper.requireNonNull(observableSource3, "source3 is null");
        ObjectHelper.requireNonNull(observableSource4, "source4 is null");
        return zipArray(Functions.toFunction(function4), false, bufferSize(), observableSource, observableSource2, observableSource3, observableSource4);
    }

    @CheckReturnValue
    @SchedulerSupport("custom")
    public final Observable<List<T>> buffer(long j11, TimeUnit timeUnit, Scheduler scheduler) {
        return buffer(j11, timeUnit, scheduler, Integer.MAX_VALUE, ArrayListSupplier.asCallable(), false);
    }

    @CheckReturnValue
    @SchedulerSupport("none")
    public final <U, R> Observable<R> flatMap(Function<? super T, ? extends ObservableSource<? extends U>> function, BiFunction<? super T, ? super U, ? extends R> biFunction, boolean z11) {
        return flatMap(function, biFunction, z11, bufferSize(), bufferSize());
    }

    @CheckReturnValue
    @SchedulerSupport("none")
    public final <R> Observable<R> withLatestFrom(ObservableSource<?>[] observableSourceArr, Function<? super Object[], R> function) {
        ObjectHelper.requireNonNull(observableSourceArr, "others is null");
        ObjectHelper.requireNonNull(function, "combiner is null");
        return RxJavaPlugins.onAssembly(new ObservableWithLatestFromMany(this, observableSourceArr, function));
    }

    @CheckReturnValue
    @SchedulerSupport("none")
    public final <TOpening, TClosing> Observable<List<T>> buffer(ObservableSource<? extends TOpening> observableSource, Function<? super TOpening, ? extends ObservableSource<? extends TClosing>> function) {
        return buffer(observableSource, function, ArrayListSupplier.asCallable());
    }

    @CheckReturnValue
    @SchedulerSupport("none")
    public final <U, R> Observable<R> flatMap(Function<? super T, ? extends ObservableSource<? extends U>> function, BiFunction<? super T, ? super U, ? extends R> biFunction, boolean z11, int i11) {
        return flatMap(function, biFunction, z11, i11, bufferSize());
    }

    @CheckReturnValue
    @SchedulerSupport("none")
    public final <TOpening, TClosing, U extends Collection<? super T>> Observable<U> buffer(ObservableSource<? extends TOpening> observableSource, Function<? super TOpening, ? extends ObservableSource<? extends TClosing>> function, Callable<U> callable) {
        ObjectHelper.requireNonNull(observableSource, "openingIndicator is null");
        ObjectHelper.requireNonNull(function, "closingIndicator is null");
        ObjectHelper.requireNonNull(callable, "bufferSupplier is null");
        return RxJavaPlugins.onAssembly(new ObservableBufferBoundary(this, observableSource, function, callable));
    }

    @CheckReturnValue
    @SchedulerSupport("none")
    public final <U, R> Observable<R> flatMap(Function<? super T, ? extends ObservableSource<? extends U>> function, BiFunction<? super T, ? super U, ? extends R> biFunction, boolean z11, int i11, int i12) {
        ObjectHelper.requireNonNull(function, "mapper is null");
        ObjectHelper.requireNonNull(biFunction, "combiner is null");
        return flatMap(ObservableInternalHelper.flatMapWithCombiner(function, biFunction), z11, i11, i12);
    }

    @CheckReturnValue
    @SchedulerSupport("custom")
    public final <R> Observable<R> replay(Function<? super Observable<T>, ? extends ObservableSource<R>> function, Scheduler scheduler) {
        ObjectHelper.requireNonNull(function, "selector is null");
        ObjectHelper.requireNonNull(scheduler, "scheduler is null");
        return ObservableReplay.multicastSelector(ObservableInternalHelper.replayCallable(this), ObservableInternalHelper.replayFunction(function, scheduler));
    }

    @CheckReturnValue
    @SchedulerSupport("none")
    public final <R> Observable<R> withLatestFrom(Iterable<? extends ObservableSource<?>> iterable, Function<? super Object[], R> function) {
        ObjectHelper.requireNonNull(iterable, "others is null");
        ObjectHelper.requireNonNull(function, "combiner is null");
        return RxJavaPlugins.onAssembly(new ObservableWithLatestFromMany(this, iterable, function));
    }

    @CheckReturnValue
    @NonNull
    @SchedulerSupport("none")
    public static <T1, T2, T3, T4, T5, R> Observable<R> combineLatest(ObservableSource<? extends T1> observableSource, ObservableSource<? extends T2> observableSource2, ObservableSource<? extends T3> observableSource3, ObservableSource<? extends T4> observableSource4, ObservableSource<? extends T5> observableSource5, Function5<? super T1, ? super T2, ? super T3, ? super T4, ? super T5, ? extends R> function5) {
        ObjectHelper.requireNonNull(observableSource, "source1 is null");
        ObjectHelper.requireNonNull(observableSource2, "source2 is null");
        ObjectHelper.requireNonNull(observableSource3, "source3 is null");
        ObjectHelper.requireNonNull(observableSource4, "source4 is null");
        ObjectHelper.requireNonNull(observableSource5, "source5 is null");
        return combineLatest(Functions.toFunction(function5), bufferSize(), (ObservableSource<? extends T>[]) new ObservableSource[]{observableSource, observableSource2, observableSource3, observableSource4, observableSource5});
    }

    @CheckReturnValue
    @SchedulerSupport("none")
    public final <B> Observable<Observable<T>> window(ObservableSource<B> observableSource) {
        return window(observableSource, bufferSize());
    }

    @CheckReturnValue
    @SchedulerSupport("none")
    public static <T1, T2, T3, T4, T5, R> Observable<R> zip(ObservableSource<? extends T1> observableSource, ObservableSource<? extends T2> observableSource2, ObservableSource<? extends T3> observableSource3, ObservableSource<? extends T4> observableSource4, ObservableSource<? extends T5> observableSource5, Function5<? super T1, ? super T2, ? super T3, ? super T4, ? super T5, ? extends R> function5) {
        ObjectHelper.requireNonNull(observableSource, "source1 is null");
        ObjectHelper.requireNonNull(observableSource2, "source2 is null");
        ObjectHelper.requireNonNull(observableSource3, "source3 is null");
        ObjectHelper.requireNonNull(observableSource4, "source4 is null");
        ObjectHelper.requireNonNull(observableSource5, "source5 is null");
        return zipArray(Functions.toFunction(function5), false, bufferSize(), observableSource, observableSource2, observableSource3, observableSource4, observableSource5);
    }

    @CheckReturnValue
    @SchedulerSupport("none")
    public final <U, R> Observable<R> flatMap(Function<? super T, ? extends ObservableSource<? extends U>> function, BiFunction<? super T, ? super U, ? extends R> biFunction, int i11) {
        return flatMap(function, biFunction, false, i11, bufferSize());
    }

    @CheckReturnValue
    @SchedulerSupport("none")
    public final <B> Observable<Observable<T>> window(ObservableSource<B> observableSource, int i11) {
        ObjectHelper.requireNonNull(observableSource, "boundary is null");
        ObjectHelper.verifyPositive(i11, "bufferSize");
        return RxJavaPlugins.onAssembly(new ObservableWindowBoundary(this, observableSource, i11));
    }

    @CheckReturnValue
    @NonNull
    @SchedulerSupport("none")
    public static <T> Observable<T> just(T t11, T t12, T t13, T t14, T t15, T t16, T t17) {
        ObjectHelper.requireNonNull(t11, "item1 is null");
        ObjectHelper.requireNonNull(t12, "item2 is null");
        ObjectHelper.requireNonNull(t13, "item3 is null");
        ObjectHelper.requireNonNull(t14, "item4 is null");
        ObjectHelper.requireNonNull(t15, "item5 is null");
        ObjectHelper.requireNonNull(t16, "item6 is null");
        ObjectHelper.requireNonNull(t17, "item7 is null");
        return fromArray(t11, t12, t13, t14, t15, t16, t17);
    }

    @CheckReturnValue
    @SchedulerSupport("none")
    public final <B> Observable<List<T>> buffer(ObservableSource<B> observableSource) {
        return buffer(observableSource, ArrayListSupplier.asCallable());
    }

    @CheckReturnValue
    @SchedulerSupport("none")
    public final <B> Observable<List<T>> buffer(ObservableSource<B> observableSource, int i11) {
        ObjectHelper.verifyPositive(i11, "initialCapacity");
        return buffer(observableSource, Functions.createArrayList(i11));
    }

    @CheckReturnValue
    @SchedulerSupport("none")
    public final ConnectableObservable<T> replay(int i11) {
        ObjectHelper.verifyPositive(i11, "bufferSize");
        return ObservableReplay.create(this, i11);
    }

    @CheckReturnValue
    @SchedulerSupport("none")
    public final <U, V> Observable<Observable<T>> window(ObservableSource<U> observableSource, Function<? super U, ? extends ObservableSource<V>> function) {
        return window(observableSource, function, bufferSize());
    }

    @CheckReturnValue
    @SchedulerSupport("none")
    public final <B, U extends Collection<? super T>> Observable<U> buffer(ObservableSource<B> observableSource, Callable<U> callable) {
        ObjectHelper.requireNonNull(observableSource, "boundary is null");
        ObjectHelper.requireNonNull(callable, "bufferSupplier is null");
        return RxJavaPlugins.onAssembly(new ObservableBufferExactBoundary(this, observableSource, callable));
    }

    @CheckReturnValue
    @SchedulerSupport("none")
    public final <U, V> Observable<Observable<T>> window(ObservableSource<U> observableSource, Function<? super U, ? extends ObservableSource<V>> function, int i11) {
        ObjectHelper.requireNonNull(observableSource, "openingIndicator is null");
        ObjectHelper.requireNonNull(function, "closingIndicator is null");
        ObjectHelper.verifyPositive(i11, "bufferSize");
        return RxJavaPlugins.onAssembly(new ObservableWindowBoundarySelector(this, observableSource, function, i11));
    }

    @CheckReturnValue
    @NonNull
    @SchedulerSupport("none")
    public static <T1, T2, T3, T4, T5, T6, R> Observable<R> combineLatest(ObservableSource<? extends T1> observableSource, ObservableSource<? extends T2> observableSource2, ObservableSource<? extends T3> observableSource3, ObservableSource<? extends T4> observableSource4, ObservableSource<? extends T5> observableSource5, ObservableSource<? extends T6> observableSource6, Function6<? super T1, ? super T2, ? super T3, ? super T4, ? super T5, ? super T6, ? extends R> function6) {
        ObjectHelper.requireNonNull(observableSource, "source1 is null");
        ObjectHelper.requireNonNull(observableSource2, "source2 is null");
        ObjectHelper.requireNonNull(observableSource3, "source3 is null");
        ObjectHelper.requireNonNull(observableSource4, "source4 is null");
        ObjectHelper.requireNonNull(observableSource5, "source5 is null");
        ObjectHelper.requireNonNull(observableSource6, "source6 is null");
        return combineLatest(Functions.toFunction(function6), bufferSize(), (ObservableSource<? extends T>[]) new ObservableSource[]{observableSource, observableSource2, observableSource3, observableSource4, observableSource5, observableSource6});
    }

    @CheckReturnValue
    @SchedulerSupport("io.reactivex:computation")
    public final ConnectableObservable<T> replay(int i11, long j11, TimeUnit timeUnit) {
        return replay(i11, j11, timeUnit, Schedulers.computation());
    }

    @CheckReturnValue
    @SchedulerSupport("none")
    public static <T1, T2, T3, T4, T5, T6, R> Observable<R> zip(ObservableSource<? extends T1> observableSource, ObservableSource<? extends T2> observableSource2, ObservableSource<? extends T3> observableSource3, ObservableSource<? extends T4> observableSource4, ObservableSource<? extends T5> observableSource5, ObservableSource<? extends T6> observableSource6, Function6<? super T1, ? super T2, ? super T3, ? super T4, ? super T5, ? super T6, ? extends R> function6) {
        ObjectHelper.requireNonNull(observableSource, "source1 is null");
        ObjectHelper.requireNonNull(observableSource2, "source2 is null");
        ObjectHelper.requireNonNull(observableSource3, "source3 is null");
        ObjectHelper.requireNonNull(observableSource4, "source4 is null");
        ObjectHelper.requireNonNull(observableSource5, "source5 is null");
        ObjectHelper.requireNonNull(observableSource6, "source6 is null");
        return zipArray(Functions.toFunction(function6), false, bufferSize(), observableSource, observableSource2, observableSource3, observableSource4, observableSource5, observableSource6);
    }

    @CheckReturnValue
    @SchedulerSupport("custom")
    public final ConnectableObservable<T> replay(int i11, long j11, TimeUnit timeUnit, Scheduler scheduler) {
        ObjectHelper.verifyPositive(i11, "bufferSize");
        ObjectHelper.requireNonNull(timeUnit, "unit is null");
        ObjectHelper.requireNonNull(scheduler, "scheduler is null");
        return ObservableReplay.create(this, j11, timeUnit, scheduler, i11);
    }

    @CheckReturnValue
    @SchedulerSupport("none")
    public final <B> Observable<List<T>> buffer(Callable<? extends ObservableSource<B>> callable) {
        return buffer(callable, ArrayListSupplier.asCallable());
    }

    @CheckReturnValue
    @SchedulerSupport("none")
    public final <B, U extends Collection<? super T>> Observable<U> buffer(Callable<? extends ObservableSource<B>> callable, Callable<U> callable2) {
        ObjectHelper.requireNonNull(callable, "boundarySupplier is null");
        ObjectHelper.requireNonNull(callable2, "bufferSupplier is null");
        return RxJavaPlugins.onAssembly(new ObservableBufferBoundarySupplier(this, callable, callable2));
    }

    @CheckReturnValue
    @SchedulerSupport("none")
    public final <B> Observable<Observable<T>> window(Callable<? extends ObservableSource<B>> callable) {
        return window(callable, bufferSize());
    }

    @CheckReturnValue
    @NonNull
    @SchedulerSupport("none")
    public static <T> Observable<T> just(T t11, T t12, T t13, T t14, T t15, T t16, T t17, T t18) {
        ObjectHelper.requireNonNull(t11, "item1 is null");
        ObjectHelper.requireNonNull(t12, "item2 is null");
        ObjectHelper.requireNonNull(t13, "item3 is null");
        ObjectHelper.requireNonNull(t14, "item4 is null");
        ObjectHelper.requireNonNull(t15, "item5 is null");
        ObjectHelper.requireNonNull(t16, "item6 is null");
        ObjectHelper.requireNonNull(t17, "item7 is null");
        ObjectHelper.requireNonNull(t18, "item8 is null");
        return fromArray(t11, t12, t13, t14, t15, t16, t17, t18);
    }

    @CheckReturnValue
    @SchedulerSupport("none")
    public final <B> Observable<Observable<T>> window(Callable<? extends ObservableSource<B>> callable, int i11) {
        ObjectHelper.requireNonNull(callable, "boundary is null");
        ObjectHelper.verifyPositive(i11, "bufferSize");
        return RxJavaPlugins.onAssembly(new ObservableWindowBoundarySupplier(this, callable, i11));
    }

    @CheckReturnValue
    @SchedulerSupport("custom")
    public final ConnectableObservable<T> replay(int i11, Scheduler scheduler) {
        ObjectHelper.verifyPositive(i11, "bufferSize");
        return ObservableReplay.observeOn(replay(i11), scheduler);
    }

    @CheckReturnValue
    @NonNull
    @SchedulerSupport("none")
    public static <T1, T2, T3, T4, T5, T6, T7, R> Observable<R> combineLatest(ObservableSource<? extends T1> observableSource, ObservableSource<? extends T2> observableSource2, ObservableSource<? extends T3> observableSource3, ObservableSource<? extends T4> observableSource4, ObservableSource<? extends T5> observableSource5, ObservableSource<? extends T6> observableSource6, ObservableSource<? extends T7> observableSource7, Function7<? super T1, ? super T2, ? super T3, ? super T4, ? super T5, ? super T6, ? super T7, ? extends R> function7) {
        ObjectHelper.requireNonNull(observableSource, "source1 is null");
        ObjectHelper.requireNonNull(observableSource2, "source2 is null");
        ObjectHelper.requireNonNull(observableSource3, "source3 is null");
        ObjectHelper.requireNonNull(observableSource4, "source4 is null");
        ObjectHelper.requireNonNull(observableSource5, "source5 is null");
        ObjectHelper.requireNonNull(observableSource6, "source6 is null");
        ObjectHelper.requireNonNull(observableSource7, "source7 is null");
        return combineLatest(Functions.toFunction(function7), bufferSize(), (ObservableSource<? extends T>[]) new ObservableSource[]{observableSource, observableSource2, observableSource3, observableSource4, observableSource5, observableSource6, observableSource7});
    }

    @CheckReturnValue
    @SchedulerSupport("io.reactivex:computation")
    public final ConnectableObservable<T> replay(long j11, TimeUnit timeUnit) {
        return replay(j11, timeUnit, Schedulers.computation());
    }

    @CheckReturnValue
    @SchedulerSupport("none")
    public static <T1, T2, T3, T4, T5, T6, T7, R> Observable<R> zip(ObservableSource<? extends T1> observableSource, ObservableSource<? extends T2> observableSource2, ObservableSource<? extends T3> observableSource3, ObservableSource<? extends T4> observableSource4, ObservableSource<? extends T5> observableSource5, ObservableSource<? extends T6> observableSource6, ObservableSource<? extends T7> observableSource7, Function7<? super T1, ? super T2, ? super T3, ? super T4, ? super T5, ? super T6, ? super T7, ? extends R> function7) {
        ObjectHelper.requireNonNull(observableSource, "source1 is null");
        ObjectHelper.requireNonNull(observableSource2, "source2 is null");
        ObjectHelper.requireNonNull(observableSource3, "source3 is null");
        ObjectHelper.requireNonNull(observableSource4, "source4 is null");
        ObjectHelper.requireNonNull(observableSource5, "source5 is null");
        ObjectHelper.requireNonNull(observableSource6, "source6 is null");
        ObjectHelper.requireNonNull(observableSource7, "source7 is null");
        return zipArray(Functions.toFunction(function7), false, bufferSize(), observableSource, observableSource2, observableSource3, observableSource4, observableSource5, observableSource6, observableSource7);
    }

    @CheckReturnValue
    @SchedulerSupport("custom")
    public final ConnectableObservable<T> replay(long j11, TimeUnit timeUnit, Scheduler scheduler) {
        ObjectHelper.requireNonNull(timeUnit, "unit is null");
        ObjectHelper.requireNonNull(scheduler, "scheduler is null");
        return ObservableReplay.create(this, j11, timeUnit, scheduler);
    }

    @CheckReturnValue
    @SchedulerSupport("custom")
    public final ConnectableObservable<T> replay(Scheduler scheduler) {
        ObjectHelper.requireNonNull(scheduler, "scheduler is null");
        return ObservableReplay.observeOn(replay(), scheduler);
    }

    @CheckReturnValue
    @NonNull
    @SchedulerSupport("none")
    public static <T> Observable<T> just(T t11, T t12, T t13, T t14, T t15, T t16, T t17, T t18, T t19) {
        ObjectHelper.requireNonNull(t11, "item1 is null");
        ObjectHelper.requireNonNull(t12, "item2 is null");
        ObjectHelper.requireNonNull(t13, "item3 is null");
        ObjectHelper.requireNonNull(t14, "item4 is null");
        ObjectHelper.requireNonNull(t15, "item5 is null");
        ObjectHelper.requireNonNull(t16, "item6 is null");
        ObjectHelper.requireNonNull(t17, "item7 is null");
        ObjectHelper.requireNonNull(t18, "item8 is null");
        ObjectHelper.requireNonNull(t19, "item9 is null");
        return fromArray(t11, t12, t13, t14, t15, t16, t17, t18, t19);
    }

    @CheckReturnValue
    @NonNull
    @SchedulerSupport("none")
    public static <T1, T2, T3, T4, T5, T6, T7, T8, R> Observable<R> combineLatest(ObservableSource<? extends T1> observableSource, ObservableSource<? extends T2> observableSource2, ObservableSource<? extends T3> observableSource3, ObservableSource<? extends T4> observableSource4, ObservableSource<? extends T5> observableSource5, ObservableSource<? extends T6> observableSource6, ObservableSource<? extends T7> observableSource7, ObservableSource<? extends T8> observableSource8, Function8<? super T1, ? super T2, ? super T3, ? super T4, ? super T5, ? super T6, ? super T7, ? super T8, ? extends R> function8) {
        ObjectHelper.requireNonNull(observableSource, "source1 is null");
        ObjectHelper.requireNonNull(observableSource2, "source2 is null");
        ObjectHelper.requireNonNull(observableSource3, "source3 is null");
        ObjectHelper.requireNonNull(observableSource4, "source4 is null");
        ObjectHelper.requireNonNull(observableSource5, "source5 is null");
        ObjectHelper.requireNonNull(observableSource6, "source6 is null");
        ObjectHelper.requireNonNull(observableSource7, "source7 is null");
        ObjectHelper.requireNonNull(observableSource8, "source8 is null");
        return combineLatest(Functions.toFunction(function8), bufferSize(), (ObservableSource<? extends T>[]) new ObservableSource[]{observableSource, observableSource2, observableSource3, observableSource4, observableSource5, observableSource6, observableSource7, observableSource8});
    }

    @CheckReturnValue
    @SchedulerSupport("none")
    public static <T1, T2, T3, T4, T5, T6, T7, T8, R> Observable<R> zip(ObservableSource<? extends T1> observableSource, ObservableSource<? extends T2> observableSource2, ObservableSource<? extends T3> observableSource3, ObservableSource<? extends T4> observableSource4, ObservableSource<? extends T5> observableSource5, ObservableSource<? extends T6> observableSource6, ObservableSource<? extends T7> observableSource7, ObservableSource<? extends T8> observableSource8, Function8<? super T1, ? super T2, ? super T3, ? super T4, ? super T5, ? super T6, ? super T7, ? super T8, ? extends R> function8) {
        ObjectHelper.requireNonNull(observableSource, "source1 is null");
        ObjectHelper.requireNonNull(observableSource2, "source2 is null");
        ObjectHelper.requireNonNull(observableSource3, "source3 is null");
        ObjectHelper.requireNonNull(observableSource4, "source4 is null");
        ObjectHelper.requireNonNull(observableSource5, "source5 is null");
        ObjectHelper.requireNonNull(observableSource6, "source6 is null");
        ObjectHelper.requireNonNull(observableSource7, "source7 is null");
        ObjectHelper.requireNonNull(observableSource8, "source8 is null");
        return zipArray(Functions.toFunction(function8), false, bufferSize(), observableSource, observableSource2, observableSource3, observableSource4, observableSource5, observableSource6, observableSource7, observableSource8);
    }

    @CheckReturnValue
    @NonNull
    @SchedulerSupport("none")
    public static <T> Observable<T> just(T t11, T t12, T t13, T t14, T t15, T t16, T t17, T t18, T t19, T t21) {
        ObjectHelper.requireNonNull(t11, "item1 is null");
        ObjectHelper.requireNonNull(t12, "item2 is null");
        ObjectHelper.requireNonNull(t13, "item3 is null");
        ObjectHelper.requireNonNull(t14, "item4 is null");
        ObjectHelper.requireNonNull(t15, "item5 is null");
        ObjectHelper.requireNonNull(t16, "item6 is null");
        ObjectHelper.requireNonNull(t17, "item7 is null");
        ObjectHelper.requireNonNull(t18, "item8 is null");
        ObjectHelper.requireNonNull(t19, "item9 is null");
        ObjectHelper.requireNonNull(t21, "item10 is null");
        return fromArray(t11, t12, t13, t14, t15, t16, t17, t18, t19, t21);
    }

    @CheckReturnValue
    @NonNull
    @SchedulerSupport("none")
    public static <T1, T2, T3, T4, T5, T6, T7, T8, T9, R> Observable<R> combineLatest(ObservableSource<? extends T1> observableSource, ObservableSource<? extends T2> observableSource2, ObservableSource<? extends T3> observableSource3, ObservableSource<? extends T4> observableSource4, ObservableSource<? extends T5> observableSource5, ObservableSource<? extends T6> observableSource6, ObservableSource<? extends T7> observableSource7, ObservableSource<? extends T8> observableSource8, ObservableSource<? extends T9> observableSource9, Function9<? super T1, ? super T2, ? super T3, ? super T4, ? super T5, ? super T6, ? super T7, ? super T8, ? super T9, ? extends R> function9) {
        ObjectHelper.requireNonNull(observableSource, "source1 is null");
        ObjectHelper.requireNonNull(observableSource2, "source2 is null");
        ObjectHelper.requireNonNull(observableSource3, "source3 is null");
        ObjectHelper.requireNonNull(observableSource4, "source4 is null");
        ObjectHelper.requireNonNull(observableSource5, "source5 is null");
        ObjectHelper.requireNonNull(observableSource6, "source6 is null");
        ObjectHelper.requireNonNull(observableSource7, "source7 is null");
        ObjectHelper.requireNonNull(observableSource8, "source8 is null");
        ObjectHelper.requireNonNull(observableSource9, "source9 is null");
        return combineLatest(Functions.toFunction(function9), bufferSize(), (ObservableSource<? extends T>[]) new ObservableSource[]{observableSource, observableSource2, observableSource3, observableSource4, observableSource5, observableSource6, observableSource7, observableSource8, observableSource9});
    }

    @CheckReturnValue
    @SchedulerSupport("none")
    public static <T1, T2, T3, T4, T5, T6, T7, T8, T9, R> Observable<R> zip(ObservableSource<? extends T1> observableSource, ObservableSource<? extends T2> observableSource2, ObservableSource<? extends T3> observableSource3, ObservableSource<? extends T4> observableSource4, ObservableSource<? extends T5> observableSource5, ObservableSource<? extends T6> observableSource6, ObservableSource<? extends T7> observableSource7, ObservableSource<? extends T8> observableSource8, ObservableSource<? extends T9> observableSource9, Function9<? super T1, ? super T2, ? super T3, ? super T4, ? super T5, ? super T6, ? super T7, ? super T8, ? super T9, ? extends R> function9) {
        ObjectHelper.requireNonNull(observableSource, "source1 is null");
        ObjectHelper.requireNonNull(observableSource2, "source2 is null");
        ObjectHelper.requireNonNull(observableSource3, "source3 is null");
        ObjectHelper.requireNonNull(observableSource4, "source4 is null");
        ObjectHelper.requireNonNull(observableSource5, "source5 is null");
        ObjectHelper.requireNonNull(observableSource6, "source6 is null");
        ObjectHelper.requireNonNull(observableSource7, "source7 is null");
        ObjectHelper.requireNonNull(observableSource8, "source8 is null");
        ObjectHelper.requireNonNull(observableSource9, "source9 is null");
        return zipArray(Functions.toFunction(function9), false, bufferSize(), observableSource, observableSource2, observableSource3, observableSource4, observableSource5, observableSource6, observableSource7, observableSource8, observableSource9);
    }
}
