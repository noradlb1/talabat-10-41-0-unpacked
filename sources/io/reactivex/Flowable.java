package io.reactivex;

import io.reactivex.annotations.BackpressureKind;
import io.reactivex.annotations.BackpressureSupport;
import io.reactivex.annotations.CheckReturnValue;
import io.reactivex.annotations.Experimental;
import io.reactivex.annotations.NonNull;
import io.reactivex.annotations.SchedulerSupport;
import io.reactivex.disposables.Disposable;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.flowables.ConnectableFlowable;
import io.reactivex.flowables.GroupedFlowable;
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
import io.reactivex.functions.LongConsumer;
import io.reactivex.functions.Predicate;
import io.reactivex.internal.functions.Functions;
import io.reactivex.internal.functions.ObjectHelper;
import io.reactivex.internal.fuseable.ScalarCallable;
import io.reactivex.internal.operators.flowable.BlockingFlowableIterable;
import io.reactivex.internal.operators.flowable.BlockingFlowableLatest;
import io.reactivex.internal.operators.flowable.BlockingFlowableMostRecent;
import io.reactivex.internal.operators.flowable.BlockingFlowableNext;
import io.reactivex.internal.operators.flowable.FlowableAllSingle;
import io.reactivex.internal.operators.flowable.FlowableAmb;
import io.reactivex.internal.operators.flowable.FlowableAnySingle;
import io.reactivex.internal.operators.flowable.FlowableBlockingSubscribe;
import io.reactivex.internal.operators.flowable.FlowableBuffer;
import io.reactivex.internal.operators.flowable.FlowableBufferBoundary;
import io.reactivex.internal.operators.flowable.FlowableBufferBoundarySupplier;
import io.reactivex.internal.operators.flowable.FlowableBufferExactBoundary;
import io.reactivex.internal.operators.flowable.FlowableBufferTimed;
import io.reactivex.internal.operators.flowable.FlowableCache;
import io.reactivex.internal.operators.flowable.FlowableCollectSingle;
import io.reactivex.internal.operators.flowable.FlowableCombineLatest;
import io.reactivex.internal.operators.flowable.FlowableConcatArray;
import io.reactivex.internal.operators.flowable.FlowableConcatMap;
import io.reactivex.internal.operators.flowable.FlowableConcatMapEager;
import io.reactivex.internal.operators.flowable.FlowableConcatMapEagerPublisher;
import io.reactivex.internal.operators.flowable.FlowableConcatWithCompletable;
import io.reactivex.internal.operators.flowable.FlowableConcatWithMaybe;
import io.reactivex.internal.operators.flowable.FlowableConcatWithSingle;
import io.reactivex.internal.operators.flowable.FlowableCountSingle;
import io.reactivex.internal.operators.flowable.FlowableCreate;
import io.reactivex.internal.operators.flowable.FlowableDebounce;
import io.reactivex.internal.operators.flowable.FlowableDebounceTimed;
import io.reactivex.internal.operators.flowable.FlowableDefer;
import io.reactivex.internal.operators.flowable.FlowableDelay;
import io.reactivex.internal.operators.flowable.FlowableDelaySubscriptionOther;
import io.reactivex.internal.operators.flowable.FlowableDematerialize;
import io.reactivex.internal.operators.flowable.FlowableDetach;
import io.reactivex.internal.operators.flowable.FlowableDistinct;
import io.reactivex.internal.operators.flowable.FlowableDistinctUntilChanged;
import io.reactivex.internal.operators.flowable.FlowableDoAfterNext;
import io.reactivex.internal.operators.flowable.FlowableDoFinally;
import io.reactivex.internal.operators.flowable.FlowableDoOnEach;
import io.reactivex.internal.operators.flowable.FlowableDoOnLifecycle;
import io.reactivex.internal.operators.flowable.FlowableElementAtMaybe;
import io.reactivex.internal.operators.flowable.FlowableElementAtSingle;
import io.reactivex.internal.operators.flowable.FlowableEmpty;
import io.reactivex.internal.operators.flowable.FlowableError;
import io.reactivex.internal.operators.flowable.FlowableFilter;
import io.reactivex.internal.operators.flowable.FlowableFlatMap;
import io.reactivex.internal.operators.flowable.FlowableFlatMapCompletableCompletable;
import io.reactivex.internal.operators.flowable.FlowableFlatMapMaybe;
import io.reactivex.internal.operators.flowable.FlowableFlatMapSingle;
import io.reactivex.internal.operators.flowable.FlowableFlattenIterable;
import io.reactivex.internal.operators.flowable.FlowableFromArray;
import io.reactivex.internal.operators.flowable.FlowableFromCallable;
import io.reactivex.internal.operators.flowable.FlowableFromFuture;
import io.reactivex.internal.operators.flowable.FlowableFromIterable;
import io.reactivex.internal.operators.flowable.FlowableFromPublisher;
import io.reactivex.internal.operators.flowable.FlowableGenerate;
import io.reactivex.internal.operators.flowable.FlowableGroupBy;
import io.reactivex.internal.operators.flowable.FlowableGroupJoin;
import io.reactivex.internal.operators.flowable.FlowableHide;
import io.reactivex.internal.operators.flowable.FlowableIgnoreElements;
import io.reactivex.internal.operators.flowable.FlowableIgnoreElementsCompletable;
import io.reactivex.internal.operators.flowable.FlowableInternalHelper;
import io.reactivex.internal.operators.flowable.FlowableInterval;
import io.reactivex.internal.operators.flowable.FlowableIntervalRange;
import io.reactivex.internal.operators.flowable.FlowableJoin;
import io.reactivex.internal.operators.flowable.FlowableJust;
import io.reactivex.internal.operators.flowable.FlowableLastMaybe;
import io.reactivex.internal.operators.flowable.FlowableLastSingle;
import io.reactivex.internal.operators.flowable.FlowableLift;
import io.reactivex.internal.operators.flowable.FlowableLimit;
import io.reactivex.internal.operators.flowable.FlowableMap;
import io.reactivex.internal.operators.flowable.FlowableMapNotification;
import io.reactivex.internal.operators.flowable.FlowableMaterialize;
import io.reactivex.internal.operators.flowable.FlowableMergeWithCompletable;
import io.reactivex.internal.operators.flowable.FlowableMergeWithMaybe;
import io.reactivex.internal.operators.flowable.FlowableMergeWithSingle;
import io.reactivex.internal.operators.flowable.FlowableNever;
import io.reactivex.internal.operators.flowable.FlowableObserveOn;
import io.reactivex.internal.operators.flowable.FlowableOnBackpressureBuffer;
import io.reactivex.internal.operators.flowable.FlowableOnBackpressureBufferStrategy;
import io.reactivex.internal.operators.flowable.FlowableOnBackpressureDrop;
import io.reactivex.internal.operators.flowable.FlowableOnBackpressureLatest;
import io.reactivex.internal.operators.flowable.FlowableOnErrorNext;
import io.reactivex.internal.operators.flowable.FlowableOnErrorReturn;
import io.reactivex.internal.operators.flowable.FlowablePublish;
import io.reactivex.internal.operators.flowable.FlowablePublishMulticast;
import io.reactivex.internal.operators.flowable.FlowableRange;
import io.reactivex.internal.operators.flowable.FlowableRangeLong;
import io.reactivex.internal.operators.flowable.FlowableReduceMaybe;
import io.reactivex.internal.operators.flowable.FlowableReduceSeedSingle;
import io.reactivex.internal.operators.flowable.FlowableReduceWithSingle;
import io.reactivex.internal.operators.flowable.FlowableRepeat;
import io.reactivex.internal.operators.flowable.FlowableRepeatUntil;
import io.reactivex.internal.operators.flowable.FlowableRepeatWhen;
import io.reactivex.internal.operators.flowable.FlowableReplay;
import io.reactivex.internal.operators.flowable.FlowableRetryBiPredicate;
import io.reactivex.internal.operators.flowable.FlowableRetryPredicate;
import io.reactivex.internal.operators.flowable.FlowableRetryWhen;
import io.reactivex.internal.operators.flowable.FlowableSamplePublisher;
import io.reactivex.internal.operators.flowable.FlowableSampleTimed;
import io.reactivex.internal.operators.flowable.FlowableScalarXMap;
import io.reactivex.internal.operators.flowable.FlowableScan;
import io.reactivex.internal.operators.flowable.FlowableScanSeed;
import io.reactivex.internal.operators.flowable.FlowableSequenceEqualSingle;
import io.reactivex.internal.operators.flowable.FlowableSerialized;
import io.reactivex.internal.operators.flowable.FlowableSingleMaybe;
import io.reactivex.internal.operators.flowable.FlowableSingleSingle;
import io.reactivex.internal.operators.flowable.FlowableSkip;
import io.reactivex.internal.operators.flowable.FlowableSkipLast;
import io.reactivex.internal.operators.flowable.FlowableSkipLastTimed;
import io.reactivex.internal.operators.flowable.FlowableSkipUntil;
import io.reactivex.internal.operators.flowable.FlowableSkipWhile;
import io.reactivex.internal.operators.flowable.FlowableSubscribeOn;
import io.reactivex.internal.operators.flowable.FlowableSwitchIfEmpty;
import io.reactivex.internal.operators.flowable.FlowableSwitchMap;
import io.reactivex.internal.operators.flowable.FlowableTake;
import io.reactivex.internal.operators.flowable.FlowableTakeLast;
import io.reactivex.internal.operators.flowable.FlowableTakeLastOne;
import io.reactivex.internal.operators.flowable.FlowableTakeLastTimed;
import io.reactivex.internal.operators.flowable.FlowableTakeUntil;
import io.reactivex.internal.operators.flowable.FlowableTakeUntilPredicate;
import io.reactivex.internal.operators.flowable.FlowableTakeWhile;
import io.reactivex.internal.operators.flowable.FlowableThrottleFirstTimed;
import io.reactivex.internal.operators.flowable.FlowableThrottleLatest;
import io.reactivex.internal.operators.flowable.FlowableTimeInterval;
import io.reactivex.internal.operators.flowable.FlowableTimeout;
import io.reactivex.internal.operators.flowable.FlowableTimeoutTimed;
import io.reactivex.internal.operators.flowable.FlowableTimer;
import io.reactivex.internal.operators.flowable.FlowableToListSingle;
import io.reactivex.internal.operators.flowable.FlowableUnsubscribeOn;
import io.reactivex.internal.operators.flowable.FlowableUsing;
import io.reactivex.internal.operators.flowable.FlowableWindow;
import io.reactivex.internal.operators.flowable.FlowableWindowBoundary;
import io.reactivex.internal.operators.flowable.FlowableWindowBoundarySelector;
import io.reactivex.internal.operators.flowable.FlowableWindowBoundarySupplier;
import io.reactivex.internal.operators.flowable.FlowableWindowTimed;
import io.reactivex.internal.operators.flowable.FlowableWithLatestFrom;
import io.reactivex.internal.operators.flowable.FlowableWithLatestFromMany;
import io.reactivex.internal.operators.flowable.FlowableZip;
import io.reactivex.internal.operators.flowable.FlowableZipIterable;
import io.reactivex.internal.operators.mixed.FlowableConcatMapCompletable;
import io.reactivex.internal.operators.mixed.FlowableConcatMapMaybe;
import io.reactivex.internal.operators.mixed.FlowableConcatMapSingle;
import io.reactivex.internal.operators.mixed.FlowableSwitchMapCompletable;
import io.reactivex.internal.operators.mixed.FlowableSwitchMapMaybe;
import io.reactivex.internal.operators.mixed.FlowableSwitchMapSingle;
import io.reactivex.internal.operators.observable.ObservableFromPublisher;
import io.reactivex.internal.schedulers.ImmediateThinScheduler;
import io.reactivex.internal.subscribers.BlockingFirstSubscriber;
import io.reactivex.internal.subscribers.BlockingLastSubscriber;
import io.reactivex.internal.subscribers.ForEachWhileSubscriber;
import io.reactivex.internal.subscribers.FutureSubscriber;
import io.reactivex.internal.subscribers.LambdaSubscriber;
import io.reactivex.internal.subscribers.StrictSubscriber;
import io.reactivex.internal.util.ArrayListSupplier;
import io.reactivex.internal.util.ErrorMode;
import io.reactivex.internal.util.ExceptionHelper;
import io.reactivex.internal.util.HashMapSupplier;
import io.reactivex.parallel.ParallelFlowable;
import io.reactivex.plugins.RxJavaPlugins;
import io.reactivex.schedulers.Schedulers;
import io.reactivex.schedulers.Timed;
import io.reactivex.subscribers.SafeSubscriber;
import io.reactivex.subscribers.TestSubscriber;
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
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

public abstract class Flowable<T> implements Publisher<T> {

    /* renamed from: b  reason: collision with root package name */
    public static final int f14475b = Math.max(1, Integer.getInteger("rx2.buffer-size", 128).intValue());

    @CheckReturnValue
    @BackpressureSupport(BackpressureKind.PASS_THROUGH)
    @NonNull
    @SchedulerSupport("none")
    public static <T> Flowable<T> amb(Iterable<? extends Publisher<? extends T>> iterable) {
        ObjectHelper.requireNonNull(iterable, "sources is null");
        return RxJavaPlugins.onAssembly(new FlowableAmb((Publisher<? extends T>[]) null, iterable));
    }

    @CheckReturnValue
    @BackpressureSupport(BackpressureKind.PASS_THROUGH)
    @NonNull
    @SchedulerSupport("none")
    public static <T> Flowable<T> ambArray(Publisher<? extends T>... publisherArr) {
        ObjectHelper.requireNonNull(publisherArr, "sources is null");
        int length = publisherArr.length;
        if (length == 0) {
            return empty();
        }
        if (length == 1) {
            return fromPublisher(publisherArr[0]);
        }
        return RxJavaPlugins.onAssembly(new FlowableAmb(publisherArr, (Iterable) null));
    }

    public static int bufferSize() {
        return f14475b;
    }

    @CheckReturnValue
    @BackpressureSupport(BackpressureKind.FULL)
    @SchedulerSupport("none")
    public static <T, R> Flowable<R> combineLatest(Publisher<? extends T>[] publisherArr, Function<? super Object[], ? extends R> function) {
        return combineLatest(publisherArr, function, bufferSize());
    }

    @CheckReturnValue
    @BackpressureSupport(BackpressureKind.FULL)
    @SchedulerSupport("none")
    public static <T, R> Flowable<R> combineLatestDelayError(Publisher<? extends T>[] publisherArr, Function<? super Object[], ? extends R> function) {
        return combineLatestDelayError(publisherArr, function, bufferSize());
    }

    @CheckReturnValue
    @BackpressureSupport(BackpressureKind.FULL)
    @NonNull
    @SchedulerSupport("none")
    public static <T> Flowable<T> concat(Iterable<? extends Publisher<? extends T>> iterable) {
        ObjectHelper.requireNonNull(iterable, "sources is null");
        return fromIterable(iterable).concatMapDelayError(Functions.identity(), 2, false);
    }

    @CheckReturnValue
    @BackpressureSupport(BackpressureKind.FULL)
    @SchedulerSupport("none")
    public static <T> Flowable<T> concatArray(Publisher<? extends T>... publisherArr) {
        if (publisherArr.length == 0) {
            return empty();
        }
        if (publisherArr.length == 1) {
            return fromPublisher(publisherArr[0]);
        }
        return RxJavaPlugins.onAssembly(new FlowableConcatArray(publisherArr, false));
    }

    @CheckReturnValue
    @BackpressureSupport(BackpressureKind.FULL)
    @SchedulerSupport("none")
    public static <T> Flowable<T> concatArrayDelayError(Publisher<? extends T>... publisherArr) {
        if (publisherArr.length == 0) {
            return empty();
        }
        if (publisherArr.length == 1) {
            return fromPublisher(publisherArr[0]);
        }
        return RxJavaPlugins.onAssembly(new FlowableConcatArray(publisherArr, true));
    }

    @CheckReturnValue
    @BackpressureSupport(BackpressureKind.FULL)
    @SchedulerSupport("none")
    public static <T> Flowable<T> concatArrayEager(Publisher<? extends T>... publisherArr) {
        return concatArrayEager(bufferSize(), bufferSize(), publisherArr);
    }

    @CheckReturnValue
    @BackpressureSupport(BackpressureKind.FULL)
    @SchedulerSupport("none")
    public static <T> Flowable<T> concatArrayEagerDelayError(Publisher<? extends T>... publisherArr) {
        return concatArrayEagerDelayError(bufferSize(), bufferSize(), publisherArr);
    }

    @CheckReturnValue
    @BackpressureSupport(BackpressureKind.FULL)
    @NonNull
    @SchedulerSupport("none")
    public static <T> Flowable<T> concatDelayError(Iterable<? extends Publisher<? extends T>> iterable) {
        ObjectHelper.requireNonNull(iterable, "sources is null");
        return fromIterable(iterable).concatMapDelayError(Functions.identity());
    }

    @CheckReturnValue
    @BackpressureSupport(BackpressureKind.FULL)
    @SchedulerSupport("none")
    public static <T> Flowable<T> concatEager(Publisher<? extends Publisher<? extends T>> publisher) {
        return concatEager(publisher, bufferSize(), bufferSize());
    }

    @CheckReturnValue
    @BackpressureSupport(BackpressureKind.SPECIAL)
    @NonNull
    @SchedulerSupport("none")
    public static <T> Flowable<T> create(FlowableOnSubscribe<T> flowableOnSubscribe, BackpressureStrategy backpressureStrategy) {
        ObjectHelper.requireNonNull(flowableOnSubscribe, "source is null");
        ObjectHelper.requireNonNull(backpressureStrategy, "mode is null");
        return RxJavaPlugins.onAssembly(new FlowableCreate(flowableOnSubscribe, backpressureStrategy));
    }

    @CheckReturnValue
    @BackpressureSupport(BackpressureKind.PASS_THROUGH)
    @NonNull
    @SchedulerSupport("none")
    public static <T> Flowable<T> defer(Callable<? extends Publisher<? extends T>> callable) {
        ObjectHelper.requireNonNull(callable, "supplier is null");
        return RxJavaPlugins.onAssembly(new FlowableDefer(callable));
    }

    @CheckReturnValue
    @BackpressureSupport(BackpressureKind.PASS_THROUGH)
    @NonNull
    @SchedulerSupport("none")
    private Flowable<T> doOnEach(Consumer<? super T> consumer, Consumer<? super Throwable> consumer2, Action action, Action action2) {
        ObjectHelper.requireNonNull(consumer, "onNext is null");
        ObjectHelper.requireNonNull(consumer2, "onError is null");
        ObjectHelper.requireNonNull(action, "onComplete is null");
        ObjectHelper.requireNonNull(action2, "onAfterTerminate is null");
        return RxJavaPlugins.onAssembly(new FlowableDoOnEach(this, consumer, consumer2, action, action2));
    }

    @CheckReturnValue
    @BackpressureSupport(BackpressureKind.PASS_THROUGH)
    @SchedulerSupport("none")
    public static <T> Flowable<T> empty() {
        return RxJavaPlugins.onAssembly(FlowableEmpty.INSTANCE);
    }

    @CheckReturnValue
    @BackpressureSupport(BackpressureKind.PASS_THROUGH)
    @NonNull
    @SchedulerSupport("none")
    public static <T> Flowable<T> error(Callable<? extends Throwable> callable) {
        ObjectHelper.requireNonNull(callable, "supplier is null");
        return RxJavaPlugins.onAssembly(new FlowableError(callable));
    }

    @CheckReturnValue
    @BackpressureSupport(BackpressureKind.FULL)
    @NonNull
    @SchedulerSupport("none")
    public static <T> Flowable<T> fromArray(T... tArr) {
        ObjectHelper.requireNonNull(tArr, "items is null");
        if (tArr.length == 0) {
            return empty();
        }
        if (tArr.length == 1) {
            return just(tArr[0]);
        }
        return RxJavaPlugins.onAssembly(new FlowableFromArray(tArr));
    }

    @CheckReturnValue
    @BackpressureSupport(BackpressureKind.FULL)
    @NonNull
    @SchedulerSupport("none")
    public static <T> Flowable<T> fromCallable(Callable<? extends T> callable) {
        ObjectHelper.requireNonNull(callable, "supplier is null");
        return RxJavaPlugins.onAssembly(new FlowableFromCallable(callable));
    }

    @CheckReturnValue
    @BackpressureSupport(BackpressureKind.FULL)
    @NonNull
    @SchedulerSupport("none")
    public static <T> Flowable<T> fromFuture(Future<? extends T> future) {
        ObjectHelper.requireNonNull(future, "future is null");
        return RxJavaPlugins.onAssembly(new FlowableFromFuture(future, 0, (TimeUnit) null));
    }

    @CheckReturnValue
    @BackpressureSupport(BackpressureKind.FULL)
    @NonNull
    @SchedulerSupport("none")
    public static <T> Flowable<T> fromIterable(Iterable<? extends T> iterable) {
        ObjectHelper.requireNonNull(iterable, "source is null");
        return RxJavaPlugins.onAssembly(new FlowableFromIterable(iterable));
    }

    @CheckReturnValue
    @BackpressureSupport(BackpressureKind.PASS_THROUGH)
    @NonNull
    @SchedulerSupport("none")
    public static <T> Flowable<T> fromPublisher(Publisher<? extends T> publisher) {
        if (publisher instanceof Flowable) {
            return RxJavaPlugins.onAssembly((Flowable) publisher);
        }
        ObjectHelper.requireNonNull(publisher, "source is null");
        return RxJavaPlugins.onAssembly(new FlowableFromPublisher(publisher));
    }

    @CheckReturnValue
    @BackpressureSupport(BackpressureKind.FULL)
    @NonNull
    @SchedulerSupport("none")
    public static <T> Flowable<T> generate(Consumer<Emitter<T>> consumer) {
        ObjectHelper.requireNonNull(consumer, "generator is null");
        return generate(Functions.nullSupplier(), FlowableInternalHelper.simpleGenerator(consumer), Functions.emptyConsumer());
    }

    @CheckReturnValue
    @BackpressureSupport(BackpressureKind.ERROR)
    @SchedulerSupport("io.reactivex:computation")
    public static Flowable<Long> interval(long j11, long j12, TimeUnit timeUnit) {
        return interval(j11, j12, timeUnit, Schedulers.computation());
    }

    @CheckReturnValue
    @BackpressureSupport(BackpressureKind.ERROR)
    @SchedulerSupport("io.reactivex:computation")
    public static Flowable<Long> intervalRange(long j11, long j12, long j13, long j14, TimeUnit timeUnit) {
        return intervalRange(j11, j12, j13, j14, timeUnit, Schedulers.computation());
    }

    @CheckReturnValue
    @BackpressureSupport(BackpressureKind.FULL)
    @NonNull
    @SchedulerSupport("none")
    public static <T> Flowable<T> just(T t11) {
        ObjectHelper.requireNonNull(t11, "item is null");
        return RxJavaPlugins.onAssembly(new FlowableJust(t11));
    }

    @CheckReturnValue
    @BackpressureSupport(BackpressureKind.FULL)
    @SchedulerSupport("none")
    public static <T> Flowable<T> merge(Iterable<? extends Publisher<? extends T>> iterable, int i11, int i12) {
        return fromIterable(iterable).flatMap(Functions.identity(), false, i11, i12);
    }

    @CheckReturnValue
    @BackpressureSupport(BackpressureKind.FULL)
    @SchedulerSupport("none")
    public static <T> Flowable<T> mergeArray(int i11, int i12, Publisher<? extends T>... publisherArr) {
        return fromArray(publisherArr).flatMap(Functions.identity(), false, i11, i12);
    }

    @CheckReturnValue
    @BackpressureSupport(BackpressureKind.FULL)
    @SchedulerSupport("none")
    public static <T> Flowable<T> mergeArrayDelayError(int i11, int i12, Publisher<? extends T>... publisherArr) {
        return fromArray(publisherArr).flatMap(Functions.identity(), true, i11, i12);
    }

    @CheckReturnValue
    @BackpressureSupport(BackpressureKind.FULL)
    @SchedulerSupport("none")
    public static <T> Flowable<T> mergeDelayError(Iterable<? extends Publisher<? extends T>> iterable) {
        return fromIterable(iterable).flatMap(Functions.identity(), true);
    }

    @CheckReturnValue
    @BackpressureSupport(BackpressureKind.PASS_THROUGH)
    @SchedulerSupport("none")
    public static <T> Flowable<T> never() {
        return RxJavaPlugins.onAssembly(FlowableNever.INSTANCE);
    }

    @CheckReturnValue
    @BackpressureSupport(BackpressureKind.FULL)
    @SchedulerSupport("none")
    public static Flowable<Integer> range(int i11, int i12) {
        if (i12 < 0) {
            throw new IllegalArgumentException("count >= 0 required but it was " + i12);
        } else if (i12 == 0) {
            return empty();
        } else {
            if (i12 == 1) {
                return just(Integer.valueOf(i11));
            }
            if (((long) i11) + ((long) (i12 - 1)) <= 2147483647L) {
                return RxJavaPlugins.onAssembly(new FlowableRange(i11, i12));
            }
            throw new IllegalArgumentException("Integer overflow");
        }
    }

    @CheckReturnValue
    @BackpressureSupport(BackpressureKind.FULL)
    @SchedulerSupport("none")
    public static Flowable<Long> rangeLong(long j11, long j12) {
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
                return RxJavaPlugins.onAssembly(new FlowableRangeLong(j11, j12));
            }
            throw new IllegalArgumentException("Overflow! start + count is bigger than Long.MAX_VALUE");
        }
    }

    @CheckReturnValue
    @BackpressureSupport(BackpressureKind.FULL)
    @SchedulerSupport("none")
    public static <T> Single<Boolean> sequenceEqual(Publisher<? extends T> publisher, Publisher<? extends T> publisher2) {
        return sequenceEqual(publisher, publisher2, ObjectHelper.equalsPredicate(), bufferSize());
    }

    @CheckReturnValue
    @BackpressureSupport(BackpressureKind.FULL)
    @SchedulerSupport("none")
    public static <T> Flowable<T> switchOnNext(Publisher<? extends Publisher<? extends T>> publisher, int i11) {
        return fromPublisher(publisher).switchMap(Functions.identity(), i11);
    }

    @CheckReturnValue
    @BackpressureSupport(BackpressureKind.FULL)
    @SchedulerSupport("none")
    public static <T> Flowable<T> switchOnNextDelayError(Publisher<? extends Publisher<? extends T>> publisher) {
        return switchOnNextDelayError(publisher, bufferSize());
    }

    private Flowable<T> timeout0(long j11, TimeUnit timeUnit, Publisher<? extends T> publisher, Scheduler scheduler) {
        ObjectHelper.requireNonNull(timeUnit, "timeUnit is null");
        ObjectHelper.requireNonNull(scheduler, "scheduler is null");
        return RxJavaPlugins.onAssembly(new FlowableTimeoutTimed(this, j11, timeUnit, scheduler, publisher));
    }

    @CheckReturnValue
    @BackpressureSupport(BackpressureKind.ERROR)
    @SchedulerSupport("io.reactivex:computation")
    public static Flowable<Long> timer(long j11, TimeUnit timeUnit) {
        return timer(j11, timeUnit, Schedulers.computation());
    }

    @CheckReturnValue
    @BackpressureSupport(BackpressureKind.NONE)
    @NonNull
    @SchedulerSupport("none")
    public static <T> Flowable<T> unsafeCreate(Publisher<T> publisher) {
        ObjectHelper.requireNonNull(publisher, "onSubscribe is null");
        if (!(publisher instanceof Flowable)) {
            return RxJavaPlugins.onAssembly(new FlowableFromPublisher(publisher));
        }
        throw new IllegalArgumentException("unsafeCreate(Flowable) should be upgraded");
    }

    @CheckReturnValue
    @BackpressureSupport(BackpressureKind.PASS_THROUGH)
    @SchedulerSupport("none")
    public static <T, D> Flowable<T> using(Callable<? extends D> callable, Function<? super D, ? extends Publisher<? extends T>> function, Consumer<? super D> consumer) {
        return using(callable, function, consumer, true);
    }

    @CheckReturnValue
    @BackpressureSupport(BackpressureKind.FULL)
    @NonNull
    @SchedulerSupport("none")
    public static <T, R> Flowable<R> zip(Iterable<? extends Publisher<? extends T>> iterable, Function<? super Object[], ? extends R> function) {
        ObjectHelper.requireNonNull(function, "zipper is null");
        ObjectHelper.requireNonNull(iterable, "sources is null");
        return RxJavaPlugins.onAssembly(new FlowableZip((Publisher<? extends T>[]) null, iterable, function, bufferSize(), false));
    }

    @CheckReturnValue
    @BackpressureSupport(BackpressureKind.FULL)
    @NonNull
    @SchedulerSupport("none")
    public static <T, R> Flowable<R> zipArray(Function<? super Object[], ? extends R> function, boolean z11, int i11, Publisher<? extends T>... publisherArr) {
        if (publisherArr.length == 0) {
            return empty();
        }
        ObjectHelper.requireNonNull(function, "zipper is null");
        ObjectHelper.verifyPositive(i11, "bufferSize");
        return RxJavaPlugins.onAssembly(new FlowableZip(publisherArr, (Iterable) null, function, i11, z11));
    }

    @CheckReturnValue
    @BackpressureSupport(BackpressureKind.FULL)
    @NonNull
    @SchedulerSupport("none")
    public static <T, R> Flowable<R> zipIterable(Iterable<? extends Publisher<? extends T>> iterable, Function<? super Object[], ? extends R> function, boolean z11, int i11) {
        ObjectHelper.requireNonNull(function, "zipper is null");
        ObjectHelper.requireNonNull(iterable, "sources is null");
        ObjectHelper.verifyPositive(i11, "bufferSize");
        return RxJavaPlugins.onAssembly(new FlowableZip((Publisher<? extends T>[]) null, iterable, function, i11, z11));
    }

    public <R> Flowable<R> a(Function<? super T, ? extends Publisher<? extends R>> function, int i11, boolean z11) {
        ObjectHelper.requireNonNull(function, "mapper is null");
        ObjectHelper.verifyPositive(i11, "bufferSize");
        if (!(this instanceof ScalarCallable)) {
            return RxJavaPlugins.onAssembly(new FlowableSwitchMap(this, function, i11, z11));
        }
        Object call = ((ScalarCallable) this).call();
        if (call == null) {
            return empty();
        }
        return FlowableScalarXMap.scalarXMap(call, function);
    }

    @CheckReturnValue
    @BackpressureSupport(BackpressureKind.UNBOUNDED_IN)
    @NonNull
    @SchedulerSupport("none")
    public final Single<Boolean> all(Predicate<? super T> predicate) {
        ObjectHelper.requireNonNull(predicate, "predicate is null");
        return RxJavaPlugins.onAssembly(new FlowableAllSingle(this, predicate));
    }

    @CheckReturnValue
    @BackpressureSupport(BackpressureKind.FULL)
    @NonNull
    @SchedulerSupport("none")
    public final Flowable<T> ambWith(Publisher<? extends T> publisher) {
        ObjectHelper.requireNonNull(publisher, "other is null");
        return ambArray(this, publisher);
    }

    @CheckReturnValue
    @BackpressureSupport(BackpressureKind.UNBOUNDED_IN)
    @NonNull
    @SchedulerSupport("none")
    public final Single<Boolean> any(Predicate<? super T> predicate) {
        ObjectHelper.requireNonNull(predicate, "predicate is null");
        return RxJavaPlugins.onAssembly(new FlowableAnySingle(this, predicate));
    }

    @CheckReturnValue
    @BackpressureSupport(BackpressureKind.SPECIAL)
    @SchedulerSupport("none")
    public final <R> R as(@NonNull FlowableConverter<T, ? extends R> flowableConverter) {
        return ((FlowableConverter) ObjectHelper.requireNonNull(flowableConverter, "converter is null")).apply(this);
    }

    @CheckReturnValue
    @BackpressureSupport(BackpressureKind.UNBOUNDED_IN)
    @SchedulerSupport("none")
    public final T blockingFirst() {
        BlockingFirstSubscriber blockingFirstSubscriber = new BlockingFirstSubscriber();
        subscribe(blockingFirstSubscriber);
        T blockingGet = blockingFirstSubscriber.blockingGet();
        if (blockingGet != null) {
            return blockingGet;
        }
        throw new NoSuchElementException();
    }

    @BackpressureSupport(BackpressureKind.UNBOUNDED_IN)
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
    @BackpressureSupport(BackpressureKind.FULL)
    @SchedulerSupport("none")
    public final Iterable<T> blockingIterable() {
        return blockingIterable(bufferSize());
    }

    @CheckReturnValue
    @BackpressureSupport(BackpressureKind.UNBOUNDED_IN)
    @SchedulerSupport("none")
    public final T blockingLast() {
        BlockingLastSubscriber blockingLastSubscriber = new BlockingLastSubscriber();
        subscribe(blockingLastSubscriber);
        T blockingGet = blockingLastSubscriber.blockingGet();
        if (blockingGet != null) {
            return blockingGet;
        }
        throw new NoSuchElementException();
    }

    @CheckReturnValue
    @BackpressureSupport(BackpressureKind.UNBOUNDED_IN)
    @SchedulerSupport("none")
    public final Iterable<T> blockingLatest() {
        return new BlockingFlowableLatest(this);
    }

    @CheckReturnValue
    @BackpressureSupport(BackpressureKind.UNBOUNDED_IN)
    @SchedulerSupport("none")
    public final Iterable<T> blockingMostRecent(T t11) {
        return new BlockingFlowableMostRecent(this, t11);
    }

    @CheckReturnValue
    @BackpressureSupport(BackpressureKind.UNBOUNDED_IN)
    @SchedulerSupport("none")
    public final Iterable<T> blockingNext() {
        return new BlockingFlowableNext(this);
    }

    @CheckReturnValue
    @BackpressureSupport(BackpressureKind.UNBOUNDED_IN)
    @SchedulerSupport("none")
    public final T blockingSingle() {
        return singleOrError().blockingGet();
    }

    @BackpressureSupport(BackpressureKind.UNBOUNDED_IN)
    @SchedulerSupport("none")
    public final void blockingSubscribe() {
        FlowableBlockingSubscribe.subscribe(this);
    }

    @CheckReturnValue
    @BackpressureSupport(BackpressureKind.FULL)
    @SchedulerSupport("none")
    public final Flowable<List<T>> buffer(int i11) {
        return buffer(i11, i11);
    }

    @CheckReturnValue
    @BackpressureSupport(BackpressureKind.FULL)
    @SchedulerSupport("none")
    public final Flowable<T> cache() {
        return cacheWithInitialCapacity(16);
    }

    @CheckReturnValue
    @BackpressureSupport(BackpressureKind.FULL)
    @SchedulerSupport("none")
    public final Flowable<T> cacheWithInitialCapacity(int i11) {
        ObjectHelper.verifyPositive(i11, "initialCapacity");
        return RxJavaPlugins.onAssembly(new FlowableCache(this, i11));
    }

    @CheckReturnValue
    @BackpressureSupport(BackpressureKind.PASS_THROUGH)
    @NonNull
    @SchedulerSupport("none")
    public final <U> Flowable<U> cast(Class<U> cls) {
        ObjectHelper.requireNonNull(cls, "clazz is null");
        return map(Functions.castFunction(cls));
    }

    @CheckReturnValue
    @BackpressureSupport(BackpressureKind.UNBOUNDED_IN)
    @NonNull
    @SchedulerSupport("none")
    public final <U> Single<U> collect(Callable<? extends U> callable, BiConsumer<? super U, ? super T> biConsumer) {
        ObjectHelper.requireNonNull(callable, "initialItemSupplier is null");
        ObjectHelper.requireNonNull(biConsumer, "collector is null");
        return RxJavaPlugins.onAssembly(new FlowableCollectSingle(this, callable, biConsumer));
    }

    @CheckReturnValue
    @BackpressureSupport(BackpressureKind.UNBOUNDED_IN)
    @NonNull
    @SchedulerSupport("none")
    public final <U> Single<U> collectInto(U u11, BiConsumer<? super U, ? super T> biConsumer) {
        ObjectHelper.requireNonNull(u11, "initialItem is null");
        return collect(Functions.justCallable(u11), biConsumer);
    }

    @CheckReturnValue
    @BackpressureSupport(BackpressureKind.PASS_THROUGH)
    @SchedulerSupport("none")
    public final <R> Flowable<R> compose(FlowableTransformer<? super T, ? extends R> flowableTransformer) {
        return fromPublisher(((FlowableTransformer) ObjectHelper.requireNonNull(flowableTransformer, "composer is null")).apply(this));
    }

    @CheckReturnValue
    @BackpressureSupport(BackpressureKind.FULL)
    @SchedulerSupport("none")
    public final <R> Flowable<R> concatMap(Function<? super T, ? extends Publisher<? extends R>> function) {
        return concatMap(function, 2);
    }

    @CheckReturnValue
    @BackpressureSupport(BackpressureKind.FULL)
    @SchedulerSupport("none")
    public final Completable concatMapCompletable(Function<? super T, ? extends CompletableSource> function) {
        return concatMapCompletable(function, 2);
    }

    @CheckReturnValue
    @BackpressureSupport(BackpressureKind.FULL)
    @SchedulerSupport("none")
    public final Completable concatMapCompletableDelayError(Function<? super T, ? extends CompletableSource> function) {
        return concatMapCompletableDelayError(function, true, 2);
    }

    @CheckReturnValue
    @BackpressureSupport(BackpressureKind.FULL)
    @SchedulerSupport("none")
    public final <R> Flowable<R> concatMapDelayError(Function<? super T, ? extends Publisher<? extends R>> function) {
        return concatMapDelayError(function, 2, true);
    }

    @CheckReturnValue
    @BackpressureSupport(BackpressureKind.FULL)
    @SchedulerSupport("none")
    public final <R> Flowable<R> concatMapEager(Function<? super T, ? extends Publisher<? extends R>> function) {
        return concatMapEager(function, bufferSize(), bufferSize());
    }

    @CheckReturnValue
    @BackpressureSupport(BackpressureKind.FULL)
    @SchedulerSupport("none")
    public final <R> Flowable<R> concatMapEagerDelayError(Function<? super T, ? extends Publisher<? extends R>> function, boolean z11) {
        return concatMapEagerDelayError(function, bufferSize(), bufferSize(), z11);
    }

    @CheckReturnValue
    @BackpressureSupport(BackpressureKind.FULL)
    @SchedulerSupport("none")
    public final <U> Flowable<U> concatMapIterable(Function<? super T, ? extends Iterable<? extends U>> function) {
        return concatMapIterable(function, 2);
    }

    @CheckReturnValue
    @BackpressureSupport(BackpressureKind.FULL)
    @SchedulerSupport("none")
    public final <R> Flowable<R> concatMapMaybe(Function<? super T, ? extends MaybeSource<? extends R>> function) {
        return concatMapMaybe(function, 2);
    }

    @CheckReturnValue
    @BackpressureSupport(BackpressureKind.FULL)
    @SchedulerSupport("none")
    public final <R> Flowable<R> concatMapMaybeDelayError(Function<? super T, ? extends MaybeSource<? extends R>> function) {
        return concatMapMaybeDelayError(function, true, 2);
    }

    @CheckReturnValue
    @BackpressureSupport(BackpressureKind.FULL)
    @SchedulerSupport("none")
    public final <R> Flowable<R> concatMapSingle(Function<? super T, ? extends SingleSource<? extends R>> function) {
        return concatMapSingle(function, 2);
    }

    @CheckReturnValue
    @BackpressureSupport(BackpressureKind.FULL)
    @SchedulerSupport("none")
    public final <R> Flowable<R> concatMapSingleDelayError(Function<? super T, ? extends SingleSource<? extends R>> function) {
        return concatMapSingleDelayError(function, true, 2);
    }

    @CheckReturnValue
    @BackpressureSupport(BackpressureKind.FULL)
    @NonNull
    @SchedulerSupport("none")
    public final Flowable<T> concatWith(Publisher<? extends T> publisher) {
        ObjectHelper.requireNonNull(publisher, "other is null");
        return concat(this, (Flowable) publisher);
    }

    @CheckReturnValue
    @BackpressureSupport(BackpressureKind.UNBOUNDED_IN)
    @NonNull
    @SchedulerSupport("none")
    public final Single<Boolean> contains(Object obj) {
        ObjectHelper.requireNonNull(obj, "item is null");
        return any(Functions.equalsWith(obj));
    }

    @CheckReturnValue
    @BackpressureSupport(BackpressureKind.UNBOUNDED_IN)
    @SchedulerSupport("none")
    public final Single<Long> count() {
        return RxJavaPlugins.onAssembly(new FlowableCountSingle(this));
    }

    @CheckReturnValue
    @BackpressureSupport(BackpressureKind.ERROR)
    @NonNull
    @SchedulerSupport("none")
    public final <U> Flowable<T> debounce(Function<? super T, ? extends Publisher<U>> function) {
        ObjectHelper.requireNonNull(function, "debounceIndicator is null");
        return RxJavaPlugins.onAssembly(new FlowableDebounce(this, function));
    }

    @CheckReturnValue
    @BackpressureSupport(BackpressureKind.FULL)
    @NonNull
    @SchedulerSupport("none")
    public final Flowable<T> defaultIfEmpty(T t11) {
        ObjectHelper.requireNonNull(t11, "defaultItem is null");
        return switchIfEmpty(just(t11));
    }

    @CheckReturnValue
    @BackpressureSupport(BackpressureKind.FULL)
    @NonNull
    @SchedulerSupport("none")
    public final <U> Flowable<T> delay(Function<? super T, ? extends Publisher<U>> function) {
        ObjectHelper.requireNonNull(function, "itemDelayIndicator is null");
        return flatMap(FlowableInternalHelper.itemDelay(function));
    }

    @CheckReturnValue
    @BackpressureSupport(BackpressureKind.FULL)
    @NonNull
    @SchedulerSupport("none")
    public final <U> Flowable<T> delaySubscription(Publisher<U> publisher) {
        ObjectHelper.requireNonNull(publisher, "subscriptionIndicator is null");
        return RxJavaPlugins.onAssembly(new FlowableDelaySubscriptionOther(this, publisher));
    }

    @CheckReturnValue
    @BackpressureSupport(BackpressureKind.PASS_THROUGH)
    @Deprecated
    @SchedulerSupport("none")
    public final <T2> Flowable<T2> dematerialize() {
        return RxJavaPlugins.onAssembly(new FlowableDematerialize(this, Functions.identity()));
    }

    @CheckReturnValue
    @BackpressureSupport(BackpressureKind.FULL)
    @SchedulerSupport("none")
    public final Flowable<T> distinct() {
        return distinct(Functions.identity(), Functions.createHashSet());
    }

    @CheckReturnValue
    @BackpressureSupport(BackpressureKind.FULL)
    @SchedulerSupport("none")
    public final Flowable<T> distinctUntilChanged() {
        return distinctUntilChanged(Functions.identity());
    }

    @CheckReturnValue
    @BackpressureSupport(BackpressureKind.PASS_THROUGH)
    @SchedulerSupport("none")
    public final Flowable<T> doAfterNext(Consumer<? super T> consumer) {
        ObjectHelper.requireNonNull(consumer, "onAfterNext is null");
        return RxJavaPlugins.onAssembly(new FlowableDoAfterNext(this, consumer));
    }

    @CheckReturnValue
    @BackpressureSupport(BackpressureKind.PASS_THROUGH)
    @SchedulerSupport("none")
    public final Flowable<T> doAfterTerminate(Action action) {
        return doOnEach(Functions.emptyConsumer(), Functions.emptyConsumer(), Functions.EMPTY_ACTION, action);
    }

    @CheckReturnValue
    @BackpressureSupport(BackpressureKind.PASS_THROUGH)
    @SchedulerSupport("none")
    public final Flowable<T> doFinally(Action action) {
        ObjectHelper.requireNonNull(action, "onFinally is null");
        return RxJavaPlugins.onAssembly(new FlowableDoFinally(this, action));
    }

    @CheckReturnValue
    @BackpressureSupport(BackpressureKind.PASS_THROUGH)
    @SchedulerSupport("none")
    public final Flowable<T> doOnCancel(Action action) {
        return doOnLifecycle(Functions.emptyConsumer(), Functions.EMPTY_LONG_CONSUMER, action);
    }

    @CheckReturnValue
    @BackpressureSupport(BackpressureKind.PASS_THROUGH)
    @SchedulerSupport("none")
    public final Flowable<T> doOnComplete(Action action) {
        return doOnEach(Functions.emptyConsumer(), Functions.emptyConsumer(), action, Functions.EMPTY_ACTION);
    }

    @CheckReturnValue
    @BackpressureSupport(BackpressureKind.PASS_THROUGH)
    @SchedulerSupport("none")
    public final Flowable<T> doOnError(Consumer<? super Throwable> consumer) {
        Consumer emptyConsumer = Functions.emptyConsumer();
        Action action = Functions.EMPTY_ACTION;
        return doOnEach(emptyConsumer, consumer, action, action);
    }

    @CheckReturnValue
    @BackpressureSupport(BackpressureKind.PASS_THROUGH)
    @NonNull
    @SchedulerSupport("none")
    public final Flowable<T> doOnLifecycle(Consumer<? super Subscription> consumer, LongConsumer longConsumer, Action action) {
        ObjectHelper.requireNonNull(consumer, "onSubscribe is null");
        ObjectHelper.requireNonNull(longConsumer, "onRequest is null");
        ObjectHelper.requireNonNull(action, "onCancel is null");
        return RxJavaPlugins.onAssembly(new FlowableDoOnLifecycle(this, consumer, longConsumer, action));
    }

    @CheckReturnValue
    @BackpressureSupport(BackpressureKind.PASS_THROUGH)
    @SchedulerSupport("none")
    public final Flowable<T> doOnNext(Consumer<? super T> consumer) {
        Consumer emptyConsumer = Functions.emptyConsumer();
        Action action = Functions.EMPTY_ACTION;
        return doOnEach(consumer, emptyConsumer, action, action);
    }

    @CheckReturnValue
    @BackpressureSupport(BackpressureKind.PASS_THROUGH)
    @SchedulerSupport("none")
    public final Flowable<T> doOnRequest(LongConsumer longConsumer) {
        return doOnLifecycle(Functions.emptyConsumer(), longConsumer, Functions.EMPTY_ACTION);
    }

    @CheckReturnValue
    @BackpressureSupport(BackpressureKind.PASS_THROUGH)
    @SchedulerSupport("none")
    public final Flowable<T> doOnSubscribe(Consumer<? super Subscription> consumer) {
        return doOnLifecycle(consumer, Functions.EMPTY_LONG_CONSUMER, Functions.EMPTY_ACTION);
    }

    @CheckReturnValue
    @BackpressureSupport(BackpressureKind.PASS_THROUGH)
    @SchedulerSupport("none")
    public final Flowable<T> doOnTerminate(Action action) {
        return doOnEach(Functions.emptyConsumer(), Functions.actionConsumer(action), action, Functions.EMPTY_ACTION);
    }

    @CheckReturnValue
    @BackpressureSupport(BackpressureKind.UNBOUNDED_IN)
    @SchedulerSupport("none")
    public final Maybe<T> elementAt(long j11) {
        if (j11 >= 0) {
            return RxJavaPlugins.onAssembly(new FlowableElementAtMaybe(this, j11));
        }
        throw new IndexOutOfBoundsException("index >= 0 required but it was " + j11);
    }

    @CheckReturnValue
    @BackpressureSupport(BackpressureKind.UNBOUNDED_IN)
    @SchedulerSupport("none")
    public final Single<T> elementAtOrError(long j11) {
        if (j11 >= 0) {
            return RxJavaPlugins.onAssembly(new FlowableElementAtSingle(this, j11, null));
        }
        throw new IndexOutOfBoundsException("index >= 0 required but it was " + j11);
    }

    @CheckReturnValue
    @BackpressureSupport(BackpressureKind.PASS_THROUGH)
    @NonNull
    @SchedulerSupport("none")
    public final Flowable<T> filter(Predicate<? super T> predicate) {
        ObjectHelper.requireNonNull(predicate, "predicate is null");
        return RxJavaPlugins.onAssembly(new FlowableFilter(this, predicate));
    }

    @CheckReturnValue
    @BackpressureSupport(BackpressureKind.SPECIAL)
    @SchedulerSupport("none")
    public final Single<T> first(T t11) {
        return elementAt(0, t11);
    }

    @CheckReturnValue
    @BackpressureSupport(BackpressureKind.SPECIAL)
    @SchedulerSupport("none")
    public final Maybe<T> firstElement() {
        return elementAt(0);
    }

    @CheckReturnValue
    @BackpressureSupport(BackpressureKind.SPECIAL)
    @SchedulerSupport("none")
    public final Single<T> firstOrError() {
        return elementAtOrError(0);
    }

    @CheckReturnValue
    @BackpressureSupport(BackpressureKind.FULL)
    @SchedulerSupport("none")
    public final <R> Flowable<R> flatMap(Function<? super T, ? extends Publisher<? extends R>> function) {
        return flatMap(function, false, bufferSize(), bufferSize());
    }

    @CheckReturnValue
    @BackpressureSupport(BackpressureKind.UNBOUNDED_IN)
    @SchedulerSupport("none")
    public final Completable flatMapCompletable(Function<? super T, ? extends CompletableSource> function) {
        return flatMapCompletable(function, false, Integer.MAX_VALUE);
    }

    @CheckReturnValue
    @BackpressureSupport(BackpressureKind.FULL)
    @SchedulerSupport("none")
    public final <U> Flowable<U> flatMapIterable(Function<? super T, ? extends Iterable<? extends U>> function) {
        return flatMapIterable(function, bufferSize());
    }

    @CheckReturnValue
    @BackpressureSupport(BackpressureKind.UNBOUNDED_IN)
    @SchedulerSupport("none")
    public final <R> Flowable<R> flatMapMaybe(Function<? super T, ? extends MaybeSource<? extends R>> function) {
        return flatMapMaybe(function, false, Integer.MAX_VALUE);
    }

    @CheckReturnValue
    @BackpressureSupport(BackpressureKind.UNBOUNDED_IN)
    @SchedulerSupport("none")
    public final <R> Flowable<R> flatMapSingle(Function<? super T, ? extends SingleSource<? extends R>> function) {
        return flatMapSingle(function, false, Integer.MAX_VALUE);
    }

    @CheckReturnValue
    @BackpressureSupport(BackpressureKind.NONE)
    @SchedulerSupport("none")
    public final Disposable forEach(Consumer<? super T> consumer) {
        return subscribe(consumer);
    }

    @CheckReturnValue
    @BackpressureSupport(BackpressureKind.NONE)
    @SchedulerSupport("none")
    public final Disposable forEachWhile(Predicate<? super T> predicate) {
        return forEachWhile(predicate, Functions.ON_ERROR_MISSING, Functions.EMPTY_ACTION);
    }

    @CheckReturnValue
    @BackpressureSupport(BackpressureKind.FULL)
    @SchedulerSupport("none")
    public final <K> Flowable<GroupedFlowable<K, T>> groupBy(Function<? super T, ? extends K> function) {
        return groupBy(function, Functions.identity(), false, bufferSize());
    }

    @CheckReturnValue
    @BackpressureSupport(BackpressureKind.ERROR)
    @NonNull
    @SchedulerSupport("none")
    public final <TRight, TLeftEnd, TRightEnd, R> Flowable<R> groupJoin(Publisher<? extends TRight> publisher, Function<? super T, ? extends Publisher<TLeftEnd>> function, Function<? super TRight, ? extends Publisher<TRightEnd>> function2, BiFunction<? super T, ? super Flowable<TRight>, ? extends R> biFunction) {
        ObjectHelper.requireNonNull(publisher, "other is null");
        ObjectHelper.requireNonNull(function, "leftEnd is null");
        ObjectHelper.requireNonNull(function2, "rightEnd is null");
        ObjectHelper.requireNonNull(biFunction, "resultSelector is null");
        return RxJavaPlugins.onAssembly(new FlowableGroupJoin(this, publisher, function, function2, biFunction));
    }

    @CheckReturnValue
    @BackpressureSupport(BackpressureKind.PASS_THROUGH)
    @SchedulerSupport("none")
    public final Flowable<T> hide() {
        return RxJavaPlugins.onAssembly(new FlowableHide(this));
    }

    @BackpressureSupport(BackpressureKind.UNBOUNDED_IN)
    @CheckReturnValue
    @SchedulerSupport("none")
    public final Completable ignoreElements() {
        return RxJavaPlugins.onAssembly((Completable) new FlowableIgnoreElementsCompletable(this));
    }

    @CheckReturnValue
    @BackpressureSupport(BackpressureKind.UNBOUNDED_IN)
    @SchedulerSupport("none")
    public final Single<Boolean> isEmpty() {
        return all(Functions.alwaysFalse());
    }

    @CheckReturnValue
    @BackpressureSupport(BackpressureKind.ERROR)
    @NonNull
    @SchedulerSupport("none")
    public final <TRight, TLeftEnd, TRightEnd, R> Flowable<R> join(Publisher<? extends TRight> publisher, Function<? super T, ? extends Publisher<TLeftEnd>> function, Function<? super TRight, ? extends Publisher<TRightEnd>> function2, BiFunction<? super T, ? super TRight, ? extends R> biFunction) {
        ObjectHelper.requireNonNull(publisher, "other is null");
        ObjectHelper.requireNonNull(function, "leftEnd is null");
        ObjectHelper.requireNonNull(function2, "rightEnd is null");
        ObjectHelper.requireNonNull(biFunction, "resultSelector is null");
        return RxJavaPlugins.onAssembly(new FlowableJoin(this, publisher, function, function2, biFunction));
    }

    @CheckReturnValue
    @BackpressureSupport(BackpressureKind.UNBOUNDED_IN)
    @NonNull
    @SchedulerSupport("none")
    public final Single<T> last(T t11) {
        ObjectHelper.requireNonNull(t11, "defaultItem");
        return RxJavaPlugins.onAssembly(new FlowableLastSingle(this, t11));
    }

    @CheckReturnValue
    @BackpressureSupport(BackpressureKind.UNBOUNDED_IN)
    @SchedulerSupport("none")
    public final Maybe<T> lastElement() {
        return RxJavaPlugins.onAssembly(new FlowableLastMaybe(this));
    }

    @CheckReturnValue
    @BackpressureSupport(BackpressureKind.UNBOUNDED_IN)
    @SchedulerSupport("none")
    public final Single<T> lastOrError() {
        return RxJavaPlugins.onAssembly(new FlowableLastSingle(this, null));
    }

    @CheckReturnValue
    @BackpressureSupport(BackpressureKind.SPECIAL)
    @NonNull
    @SchedulerSupport("none")
    public final <R> Flowable<R> lift(FlowableOperator<? extends R, ? super T> flowableOperator) {
        ObjectHelper.requireNonNull(flowableOperator, "lifter is null");
        return RxJavaPlugins.onAssembly(new FlowableLift(this, flowableOperator));
    }

    @CheckReturnValue
    @BackpressureSupport(BackpressureKind.SPECIAL)
    @SchedulerSupport("none")
    public final Flowable<T> limit(long j11) {
        if (j11 >= 0) {
            return RxJavaPlugins.onAssembly(new FlowableLimit(this, j11));
        }
        throw new IllegalArgumentException("count >= 0 required but it was " + j11);
    }

    @CheckReturnValue
    @BackpressureSupport(BackpressureKind.PASS_THROUGH)
    @NonNull
    @SchedulerSupport("none")
    public final <R> Flowable<R> map(Function<? super T, ? extends R> function) {
        ObjectHelper.requireNonNull(function, "mapper is null");
        return RxJavaPlugins.onAssembly(new FlowableMap(this, function));
    }

    @CheckReturnValue
    @BackpressureSupport(BackpressureKind.FULL)
    @SchedulerSupport("none")
    public final Flowable<Notification<T>> materialize() {
        return RxJavaPlugins.onAssembly(new FlowableMaterialize(this));
    }

    @CheckReturnValue
    @BackpressureSupport(BackpressureKind.FULL)
    @NonNull
    @SchedulerSupport("none")
    public final Flowable<T> mergeWith(Publisher<? extends T> publisher) {
        ObjectHelper.requireNonNull(publisher, "other is null");
        return merge(this, (Flowable) publisher);
    }

    @CheckReturnValue
    @BackpressureSupport(BackpressureKind.FULL)
    @SchedulerSupport("custom")
    public final Flowable<T> observeOn(Scheduler scheduler) {
        return observeOn(scheduler, false, bufferSize());
    }

    @CheckReturnValue
    @BackpressureSupport(BackpressureKind.PASS_THROUGH)
    @NonNull
    @SchedulerSupport("none")
    public final <U> Flowable<U> ofType(Class<U> cls) {
        ObjectHelper.requireNonNull(cls, "clazz is null");
        return filter(Functions.isInstanceOf(cls)).cast(cls);
    }

    @CheckReturnValue
    @BackpressureSupport(BackpressureKind.UNBOUNDED_IN)
    @SchedulerSupport("none")
    public final Flowable<T> onBackpressureBuffer() {
        return onBackpressureBuffer(bufferSize(), false, true);
    }

    @CheckReturnValue
    @BackpressureSupport(BackpressureKind.UNBOUNDED_IN)
    @SchedulerSupport("none")
    public final Flowable<T> onBackpressureDrop() {
        return RxJavaPlugins.onAssembly(new FlowableOnBackpressureDrop(this));
    }

    @CheckReturnValue
    @BackpressureSupport(BackpressureKind.UNBOUNDED_IN)
    @SchedulerSupport("none")
    public final Flowable<T> onBackpressureLatest() {
        return RxJavaPlugins.onAssembly(new FlowableOnBackpressureLatest(this));
    }

    @CheckReturnValue
    @BackpressureSupport(BackpressureKind.FULL)
    @NonNull
    @SchedulerSupport("none")
    public final Flowable<T> onErrorResumeNext(Function<? super Throwable, ? extends Publisher<? extends T>> function) {
        ObjectHelper.requireNonNull(function, "resumeFunction is null");
        return RxJavaPlugins.onAssembly(new FlowableOnErrorNext(this, function, false));
    }

    @CheckReturnValue
    @BackpressureSupport(BackpressureKind.FULL)
    @NonNull
    @SchedulerSupport("none")
    public final Flowable<T> onErrorReturn(Function<? super Throwable, ? extends T> function) {
        ObjectHelper.requireNonNull(function, "valueSupplier is null");
        return RxJavaPlugins.onAssembly(new FlowableOnErrorReturn(this, function));
    }

    @CheckReturnValue
    @BackpressureSupport(BackpressureKind.FULL)
    @NonNull
    @SchedulerSupport("none")
    public final Flowable<T> onErrorReturnItem(T t11) {
        ObjectHelper.requireNonNull(t11, "item is null");
        return onErrorReturn(Functions.justFunction(t11));
    }

    @CheckReturnValue
    @BackpressureSupport(BackpressureKind.FULL)
    @NonNull
    @SchedulerSupport("none")
    public final Flowable<T> onExceptionResumeNext(Publisher<? extends T> publisher) {
        ObjectHelper.requireNonNull(publisher, "next is null");
        return RxJavaPlugins.onAssembly(new FlowableOnErrorNext(this, Functions.justFunction(publisher), true));
    }

    @CheckReturnValue
    @BackpressureSupport(BackpressureKind.PASS_THROUGH)
    @SchedulerSupport("none")
    public final Flowable<T> onTerminateDetach() {
        return RxJavaPlugins.onAssembly(new FlowableDetach(this));
    }

    @CheckReturnValue
    @BackpressureSupport(BackpressureKind.FULL)
    @SchedulerSupport("none")
    public final ParallelFlowable<T> parallel() {
        return ParallelFlowable.from(this);
    }

    @CheckReturnValue
    @BackpressureSupport(BackpressureKind.FULL)
    @SchedulerSupport("none")
    public final ConnectableFlowable<T> publish() {
        return publish(bufferSize());
    }

    @CheckReturnValue
    @BackpressureSupport(BackpressureKind.FULL)
    @SchedulerSupport("none")
    public final Flowable<T> rebatchRequests(int i11) {
        return observeOn(ImmediateThinScheduler.INSTANCE, true, i11);
    }

    @CheckReturnValue
    @BackpressureSupport(BackpressureKind.UNBOUNDED_IN)
    @NonNull
    @SchedulerSupport("none")
    public final Maybe<T> reduce(BiFunction<T, T, T> biFunction) {
        ObjectHelper.requireNonNull(biFunction, "reducer is null");
        return RxJavaPlugins.onAssembly(new FlowableReduceMaybe(this, biFunction));
    }

    @CheckReturnValue
    @BackpressureSupport(BackpressureKind.UNBOUNDED_IN)
    @NonNull
    @SchedulerSupport("none")
    public final <R> Single<R> reduceWith(Callable<R> callable, BiFunction<R, ? super T, R> biFunction) {
        ObjectHelper.requireNonNull(callable, "seedSupplier is null");
        ObjectHelper.requireNonNull(biFunction, "reducer is null");
        return RxJavaPlugins.onAssembly(new FlowableReduceWithSingle(this, callable, biFunction));
    }

    @CheckReturnValue
    @BackpressureSupport(BackpressureKind.FULL)
    @SchedulerSupport("none")
    public final Flowable<T> repeat() {
        return repeat(Long.MAX_VALUE);
    }

    @CheckReturnValue
    @BackpressureSupport(BackpressureKind.FULL)
    @NonNull
    @SchedulerSupport("none")
    public final Flowable<T> repeatUntil(BooleanSupplier booleanSupplier) {
        ObjectHelper.requireNonNull(booleanSupplier, "stop is null");
        return RxJavaPlugins.onAssembly(new FlowableRepeatUntil(this, booleanSupplier));
    }

    @CheckReturnValue
    @BackpressureSupport(BackpressureKind.FULL)
    @NonNull
    @SchedulerSupport("none")
    public final Flowable<T> repeatWhen(Function<? super Flowable<Object>, ? extends Publisher<?>> function) {
        ObjectHelper.requireNonNull(function, "handler is null");
        return RxJavaPlugins.onAssembly(new FlowableRepeatWhen(this, function));
    }

    @CheckReturnValue
    @BackpressureSupport(BackpressureKind.FULL)
    @SchedulerSupport("none")
    public final ConnectableFlowable<T> replay() {
        return FlowableReplay.createFrom(this);
    }

    @CheckReturnValue
    @BackpressureSupport(BackpressureKind.FULL)
    @SchedulerSupport("none")
    public final Flowable<T> retry() {
        return retry(Long.MAX_VALUE, Functions.alwaysTrue());
    }

    @CheckReturnValue
    @BackpressureSupport(BackpressureKind.FULL)
    @NonNull
    @SchedulerSupport("none")
    public final Flowable<T> retryUntil(BooleanSupplier booleanSupplier) {
        ObjectHelper.requireNonNull(booleanSupplier, "stop is null");
        return retry(Long.MAX_VALUE, Functions.predicateReverseFor(booleanSupplier));
    }

    @CheckReturnValue
    @BackpressureSupport(BackpressureKind.FULL)
    @NonNull
    @SchedulerSupport("none")
    public final Flowable<T> retryWhen(Function<? super Flowable<Throwable>, ? extends Publisher<?>> function) {
        ObjectHelper.requireNonNull(function, "handler is null");
        return RxJavaPlugins.onAssembly(new FlowableRetryWhen(this, function));
    }

    @BackpressureSupport(BackpressureKind.PASS_THROUGH)
    @SchedulerSupport("none")
    public final void safeSubscribe(Subscriber<? super T> subscriber) {
        ObjectHelper.requireNonNull(subscriber, "s is null");
        if (subscriber instanceof SafeSubscriber) {
            subscribe((SafeSubscriber) subscriber);
        } else {
            subscribe(new SafeSubscriber(subscriber));
        }
    }

    @CheckReturnValue
    @BackpressureSupport(BackpressureKind.ERROR)
    @SchedulerSupport("io.reactivex:computation")
    public final Flowable<T> sample(long j11, TimeUnit timeUnit) {
        return sample(j11, timeUnit, Schedulers.computation());
    }

    @CheckReturnValue
    @BackpressureSupport(BackpressureKind.FULL)
    @NonNull
    @SchedulerSupport("none")
    public final Flowable<T> scan(BiFunction<T, T, T> biFunction) {
        ObjectHelper.requireNonNull(biFunction, "accumulator is null");
        return RxJavaPlugins.onAssembly(new FlowableScan(this, biFunction));
    }

    @CheckReturnValue
    @BackpressureSupport(BackpressureKind.FULL)
    @NonNull
    @SchedulerSupport("none")
    public final <R> Flowable<R> scanWith(Callable<R> callable, BiFunction<R, ? super T, R> biFunction) {
        ObjectHelper.requireNonNull(callable, "seedSupplier is null");
        ObjectHelper.requireNonNull(biFunction, "accumulator is null");
        return RxJavaPlugins.onAssembly(new FlowableScanSeed(this, callable, biFunction));
    }

    @CheckReturnValue
    @BackpressureSupport(BackpressureKind.PASS_THROUGH)
    @SchedulerSupport("none")
    public final Flowable<T> serialize() {
        return RxJavaPlugins.onAssembly(new FlowableSerialized(this));
    }

    @CheckReturnValue
    @BackpressureSupport(BackpressureKind.FULL)
    @SchedulerSupport("none")
    public final Flowable<T> share() {
        return publish().refCount();
    }

    @CheckReturnValue
    @BackpressureSupport(BackpressureKind.UNBOUNDED_IN)
    @NonNull
    @SchedulerSupport("none")
    public final Single<T> single(T t11) {
        ObjectHelper.requireNonNull(t11, "defaultItem is null");
        return RxJavaPlugins.onAssembly(new FlowableSingleSingle(this, t11));
    }

    @CheckReturnValue
    @BackpressureSupport(BackpressureKind.UNBOUNDED_IN)
    @SchedulerSupport("none")
    public final Maybe<T> singleElement() {
        return RxJavaPlugins.onAssembly(new FlowableSingleMaybe(this));
    }

    @CheckReturnValue
    @BackpressureSupport(BackpressureKind.UNBOUNDED_IN)
    @SchedulerSupport("none")
    public final Single<T> singleOrError() {
        return RxJavaPlugins.onAssembly(new FlowableSingleSingle(this, null));
    }

    @CheckReturnValue
    @BackpressureSupport(BackpressureKind.FULL)
    @SchedulerSupport("none")
    public final Flowable<T> skip(long j11) {
        if (j11 <= 0) {
            return RxJavaPlugins.onAssembly(this);
        }
        return RxJavaPlugins.onAssembly(new FlowableSkip(this, j11));
    }

    @CheckReturnValue
    @BackpressureSupport(BackpressureKind.FULL)
    @SchedulerSupport("none")
    public final Flowable<T> skipLast(int i11) {
        if (i11 < 0) {
            throw new IndexOutOfBoundsException("count >= 0 required but it was " + i11);
        } else if (i11 == 0) {
            return RxJavaPlugins.onAssembly(this);
        } else {
            return RxJavaPlugins.onAssembly(new FlowableSkipLast(this, i11));
        }
    }

    @CheckReturnValue
    @BackpressureSupport(BackpressureKind.FULL)
    @NonNull
    @SchedulerSupport("none")
    public final <U> Flowable<T> skipUntil(Publisher<U> publisher) {
        ObjectHelper.requireNonNull(publisher, "other is null");
        return RxJavaPlugins.onAssembly(new FlowableSkipUntil(this, publisher));
    }

    @CheckReturnValue
    @BackpressureSupport(BackpressureKind.FULL)
    @NonNull
    @SchedulerSupport("none")
    public final Flowable<T> skipWhile(Predicate<? super T> predicate) {
        ObjectHelper.requireNonNull(predicate, "predicate is null");
        return RxJavaPlugins.onAssembly(new FlowableSkipWhile(this, predicate));
    }

    @CheckReturnValue
    @BackpressureSupport(BackpressureKind.FULL)
    @SchedulerSupport("none")
    public final Flowable<T> sorted() {
        return toList().toFlowable().map(Functions.listSorter(Functions.naturalComparator())).flatMapIterable(Functions.identity());
    }

    @CheckReturnValue
    @BackpressureSupport(BackpressureKind.FULL)
    @SchedulerSupport("none")
    public final Flowable<T> startWith(Iterable<? extends T> iterable) {
        return concatArray(fromIterable(iterable), this);
    }

    @CheckReturnValue
    @BackpressureSupport(BackpressureKind.FULL)
    @SchedulerSupport("none")
    public final Flowable<T> startWithArray(T... tArr) {
        Flowable fromArray = fromArray(tArr);
        if (fromArray == empty()) {
            return RxJavaPlugins.onAssembly(this);
        }
        return concatArray(fromArray, this);
    }

    @BackpressureSupport(BackpressureKind.UNBOUNDED_IN)
    @SchedulerSupport("none")
    public final Disposable subscribe() {
        return subscribe(Functions.emptyConsumer(), Functions.ON_ERROR_MISSING, Functions.EMPTY_ACTION, FlowableInternalHelper.RequestMax.INSTANCE);
    }

    public abstract void subscribeActual(Subscriber<? super T> subscriber);

    @CheckReturnValue
    @BackpressureSupport(BackpressureKind.PASS_THROUGH)
    @NonNull
    @SchedulerSupport("custom")
    public final Flowable<T> subscribeOn(@NonNull Scheduler scheduler) {
        ObjectHelper.requireNonNull(scheduler, "scheduler is null");
        return subscribeOn(scheduler, !(this instanceof FlowableCreate));
    }

    @CheckReturnValue
    @BackpressureSupport(BackpressureKind.SPECIAL)
    @SchedulerSupport("none")
    public final <E extends Subscriber<? super T>> E subscribeWith(E e11) {
        subscribe(e11);
        return e11;
    }

    @CheckReturnValue
    @BackpressureSupport(BackpressureKind.FULL)
    @NonNull
    @SchedulerSupport("none")
    public final Flowable<T> switchIfEmpty(Publisher<? extends T> publisher) {
        ObjectHelper.requireNonNull(publisher, "other is null");
        return RxJavaPlugins.onAssembly(new FlowableSwitchIfEmpty(this, publisher));
    }

    @CheckReturnValue
    @BackpressureSupport(BackpressureKind.FULL)
    @SchedulerSupport("none")
    public final <R> Flowable<R> switchMap(Function<? super T, ? extends Publisher<? extends R>> function) {
        return switchMap(function, bufferSize());
    }

    @CheckReturnValue
    @BackpressureSupport(BackpressureKind.UNBOUNDED_IN)
    @NonNull
    @SchedulerSupport("none")
    public final Completable switchMapCompletable(@NonNull Function<? super T, ? extends CompletableSource> function) {
        ObjectHelper.requireNonNull(function, "mapper is null");
        return RxJavaPlugins.onAssembly((Completable) new FlowableSwitchMapCompletable(this, function, false));
    }

    @CheckReturnValue
    @BackpressureSupport(BackpressureKind.UNBOUNDED_IN)
    @NonNull
    @SchedulerSupport("none")
    public final Completable switchMapCompletableDelayError(@NonNull Function<? super T, ? extends CompletableSource> function) {
        ObjectHelper.requireNonNull(function, "mapper is null");
        return RxJavaPlugins.onAssembly((Completable) new FlowableSwitchMapCompletable(this, function, true));
    }

    @CheckReturnValue
    @BackpressureSupport(BackpressureKind.SPECIAL)
    @SchedulerSupport("none")
    public final <R> Flowable<R> switchMapDelayError(Function<? super T, ? extends Publisher<? extends R>> function) {
        return switchMapDelayError(function, bufferSize());
    }

    @CheckReturnValue
    @BackpressureSupport(BackpressureKind.UNBOUNDED_IN)
    @NonNull
    @SchedulerSupport("none")
    public final <R> Flowable<R> switchMapMaybe(@NonNull Function<? super T, ? extends MaybeSource<? extends R>> function) {
        ObjectHelper.requireNonNull(function, "mapper is null");
        return RxJavaPlugins.onAssembly(new FlowableSwitchMapMaybe(this, function, false));
    }

    @CheckReturnValue
    @BackpressureSupport(BackpressureKind.UNBOUNDED_IN)
    @NonNull
    @SchedulerSupport("none")
    public final <R> Flowable<R> switchMapMaybeDelayError(@NonNull Function<? super T, ? extends MaybeSource<? extends R>> function) {
        ObjectHelper.requireNonNull(function, "mapper is null");
        return RxJavaPlugins.onAssembly(new FlowableSwitchMapMaybe(this, function, true));
    }

    @CheckReturnValue
    @BackpressureSupport(BackpressureKind.UNBOUNDED_IN)
    @NonNull
    @SchedulerSupport("none")
    public final <R> Flowable<R> switchMapSingle(@NonNull Function<? super T, ? extends SingleSource<? extends R>> function) {
        ObjectHelper.requireNonNull(function, "mapper is null");
        return RxJavaPlugins.onAssembly(new FlowableSwitchMapSingle(this, function, false));
    }

    @CheckReturnValue
    @BackpressureSupport(BackpressureKind.UNBOUNDED_IN)
    @NonNull
    @SchedulerSupport("none")
    public final <R> Flowable<R> switchMapSingleDelayError(@NonNull Function<? super T, ? extends SingleSource<? extends R>> function) {
        ObjectHelper.requireNonNull(function, "mapper is null");
        return RxJavaPlugins.onAssembly(new FlowableSwitchMapSingle(this, function, true));
    }

    @CheckReturnValue
    @BackpressureSupport(BackpressureKind.SPECIAL)
    @SchedulerSupport("none")
    public final Flowable<T> take(long j11) {
        if (j11 >= 0) {
            return RxJavaPlugins.onAssembly(new FlowableTake(this, j11));
        }
        throw new IllegalArgumentException("count >= 0 required but it was " + j11);
    }

    @CheckReturnValue
    @BackpressureSupport(BackpressureKind.FULL)
    @SchedulerSupport("none")
    public final Flowable<T> takeLast(int i11) {
        if (i11 < 0) {
            throw new IndexOutOfBoundsException("count >= 0 required but it was " + i11);
        } else if (i11 == 0) {
            return RxJavaPlugins.onAssembly(new FlowableIgnoreElements(this));
        } else {
            if (i11 == 1) {
                return RxJavaPlugins.onAssembly(new FlowableTakeLastOne(this));
            }
            return RxJavaPlugins.onAssembly(new FlowableTakeLast(this, i11));
        }
    }

    @CheckReturnValue
    @BackpressureSupport(BackpressureKind.PASS_THROUGH)
    @NonNull
    @SchedulerSupport("none")
    public final Flowable<T> takeUntil(Predicate<? super T> predicate) {
        ObjectHelper.requireNonNull(predicate, "stopPredicate is null");
        return RxJavaPlugins.onAssembly(new FlowableTakeUntilPredicate(this, predicate));
    }

    @CheckReturnValue
    @BackpressureSupport(BackpressureKind.PASS_THROUGH)
    @NonNull
    @SchedulerSupport("none")
    public final Flowable<T> takeWhile(Predicate<? super T> predicate) {
        ObjectHelper.requireNonNull(predicate, "predicate is null");
        return RxJavaPlugins.onAssembly(new FlowableTakeWhile(this, predicate));
    }

    @CheckReturnValue
    @BackpressureSupport(BackpressureKind.UNBOUNDED_IN)
    @SchedulerSupport("none")
    public final TestSubscriber<T> test() {
        TestSubscriber<T> testSubscriber = new TestSubscriber<>();
        subscribe(testSubscriber);
        return testSubscriber;
    }

    @CheckReturnValue
    @BackpressureSupport(BackpressureKind.ERROR)
    @SchedulerSupport("io.reactivex:computation")
    public final Flowable<T> throttleFirst(long j11, TimeUnit timeUnit) {
        return throttleFirst(j11, timeUnit, Schedulers.computation());
    }

    @CheckReturnValue
    @BackpressureSupport(BackpressureKind.ERROR)
    @SchedulerSupport("io.reactivex:computation")
    public final Flowable<T> throttleLast(long j11, TimeUnit timeUnit) {
        return sample(j11, timeUnit);
    }

    @CheckReturnValue
    @BackpressureSupport(BackpressureKind.ERROR)
    @SchedulerSupport("io.reactivex:computation")
    public final Flowable<T> throttleLatest(long j11, TimeUnit timeUnit) {
        return throttleLatest(j11, timeUnit, Schedulers.computation(), false);
    }

    @CheckReturnValue
    @BackpressureSupport(BackpressureKind.ERROR)
    @SchedulerSupport("io.reactivex:computation")
    public final Flowable<T> throttleWithTimeout(long j11, TimeUnit timeUnit) {
        return debounce(j11, timeUnit);
    }

    @CheckReturnValue
    @BackpressureSupport(BackpressureKind.PASS_THROUGH)
    @SchedulerSupport("none")
    public final Flowable<Timed<T>> timeInterval() {
        return timeInterval(TimeUnit.MILLISECONDS, Schedulers.computation());
    }

    @CheckReturnValue
    @BackpressureSupport(BackpressureKind.PASS_THROUGH)
    @SchedulerSupport("none")
    public final <V> Flowable<T> timeout(Function<? super T, ? extends Publisher<V>> function) {
        return timeout0((Publisher) null, function, (Publisher) null);
    }

    @CheckReturnValue
    @BackpressureSupport(BackpressureKind.PASS_THROUGH)
    @SchedulerSupport("none")
    public final Flowable<Timed<T>> timestamp() {
        return timestamp(TimeUnit.MILLISECONDS, Schedulers.computation());
    }

    @CheckReturnValue
    @BackpressureSupport(BackpressureKind.SPECIAL)
    @SchedulerSupport("none")
    public final <R> R to(Function<? super Flowable<T>, R> function) {
        try {
            return ((Function) ObjectHelper.requireNonNull(function, "converter is null")).apply(this);
        } catch (Throwable th2) {
            Exceptions.throwIfFatal(th2);
            throw ExceptionHelper.wrapOrThrow(th2);
        }
    }

    @CheckReturnValue
    @BackpressureSupport(BackpressureKind.UNBOUNDED_IN)
    @SchedulerSupport("none")
    public final Future<T> toFuture() {
        return (Future) subscribeWith(new FutureSubscriber());
    }

    @CheckReturnValue
    @BackpressureSupport(BackpressureKind.UNBOUNDED_IN)
    @SchedulerSupport("none")
    public final Single<List<T>> toList() {
        return RxJavaPlugins.onAssembly(new FlowableToListSingle(this));
    }

    @CheckReturnValue
    @BackpressureSupport(BackpressureKind.UNBOUNDED_IN)
    @NonNull
    @SchedulerSupport("none")
    public final <K> Single<Map<K, T>> toMap(Function<? super T, ? extends K> function) {
        ObjectHelper.requireNonNull(function, "keySelector is null");
        return collect(HashMapSupplier.asCallable(), Functions.toMapKeySelector(function));
    }

    @CheckReturnValue
    @BackpressureSupport(BackpressureKind.UNBOUNDED_IN)
    @SchedulerSupport("none")
    public final <K> Single<Map<K, Collection<T>>> toMultimap(Function<? super T, ? extends K> function) {
        return toMultimap(function, Functions.identity(), HashMapSupplier.asCallable(), ArrayListSupplier.asFunction());
    }

    @CheckReturnValue
    @BackpressureSupport(BackpressureKind.UNBOUNDED_IN)
    @SchedulerSupport("none")
    public final Observable<T> toObservable() {
        return RxJavaPlugins.onAssembly(new ObservableFromPublisher(this));
    }

    @CheckReturnValue
    @BackpressureSupport(BackpressureKind.UNBOUNDED_IN)
    @SchedulerSupport("none")
    public final Single<List<T>> toSortedList() {
        return toSortedList(Functions.naturalComparator());
    }

    @CheckReturnValue
    @BackpressureSupport(BackpressureKind.PASS_THROUGH)
    @NonNull
    @SchedulerSupport("custom")
    public final Flowable<T> unsubscribeOn(Scheduler scheduler) {
        ObjectHelper.requireNonNull(scheduler, "scheduler is null");
        return RxJavaPlugins.onAssembly(new FlowableUnsubscribeOn(this, scheduler));
    }

    @CheckReturnValue
    @BackpressureSupport(BackpressureKind.FULL)
    @SchedulerSupport("none")
    public final Flowable<Flowable<T>> window(long j11) {
        return window(j11, j11, bufferSize());
    }

    @CheckReturnValue
    @BackpressureSupport(BackpressureKind.PASS_THROUGH)
    @NonNull
    @SchedulerSupport("none")
    public final <U, R> Flowable<R> withLatestFrom(Publisher<? extends U> publisher, BiFunction<? super T, ? super U, ? extends R> biFunction) {
        ObjectHelper.requireNonNull(publisher, "other is null");
        ObjectHelper.requireNonNull(biFunction, "combiner is null");
        return RxJavaPlugins.onAssembly(new FlowableWithLatestFrom(this, biFunction, publisher));
    }

    @CheckReturnValue
    @BackpressureSupport(BackpressureKind.FULL)
    @NonNull
    @SchedulerSupport("none")
    public final <U, R> Flowable<R> zipWith(Iterable<U> iterable, BiFunction<? super T, ? super U, ? extends R> biFunction) {
        ObjectHelper.requireNonNull(iterable, "other is null");
        ObjectHelper.requireNonNull(biFunction, "zipper is null");
        return RxJavaPlugins.onAssembly(new FlowableZipIterable(this, iterable, biFunction));
    }

    @CheckReturnValue
    @BackpressureSupport(BackpressureKind.FULL)
    @SchedulerSupport("none")
    public static <T, R> Flowable<R> combineLatest(Function<? super Object[], ? extends R> function, Publisher<? extends T>... publisherArr) {
        return combineLatest(publisherArr, function, bufferSize());
    }

    @CheckReturnValue
    @BackpressureSupport(BackpressureKind.FULL)
    @SchedulerSupport("none")
    public static <T, R> Flowable<R> combineLatestDelayError(Function<? super Object[], ? extends R> function, Publisher<? extends T>... publisherArr) {
        return combineLatestDelayError(publisherArr, function, bufferSize());
    }

    @CheckReturnValue
    @BackpressureSupport(BackpressureKind.FULL)
    @NonNull
    @SchedulerSupport("none")
    public static <T> Flowable<T> concatArrayEager(int i11, int i12, Publisher<? extends T>... publisherArr) {
        ObjectHelper.requireNonNull(publisherArr, "sources is null");
        ObjectHelper.verifyPositive(i11, "maxConcurrency");
        ObjectHelper.verifyPositive(i12, "prefetch");
        return RxJavaPlugins.onAssembly(new FlowableConcatMapEager(new FlowableFromArray(publisherArr), Functions.identity(), i11, i12, ErrorMode.IMMEDIATE));
    }

    @CheckReturnValue
    @BackpressureSupport(BackpressureKind.FULL)
    @SchedulerSupport("none")
    public static <T> Flowable<T> concatArrayEagerDelayError(int i11, int i12, Publisher<? extends T>... publisherArr) {
        return fromArray(publisherArr).concatMapEagerDelayError(Functions.identity(), i11, i12, true);
    }

    @CheckReturnValue
    @BackpressureSupport(BackpressureKind.FULL)
    @NonNull
    @SchedulerSupport("none")
    public static <T> Flowable<T> concatEager(Publisher<? extends Publisher<? extends T>> publisher, int i11, int i12) {
        ObjectHelper.requireNonNull(publisher, "sources is null");
        ObjectHelper.verifyPositive(i11, "maxConcurrency");
        ObjectHelper.verifyPositive(i12, "prefetch");
        return RxJavaPlugins.onAssembly(new FlowableConcatMapEagerPublisher(publisher, Functions.identity(), i11, i12, ErrorMode.IMMEDIATE));
    }

    @CheckReturnValue
    @BackpressureSupport(BackpressureKind.ERROR)
    @NonNull
    @SchedulerSupport("custom")
    public static Flowable<Long> interval(long j11, long j12, TimeUnit timeUnit, Scheduler scheduler) {
        ObjectHelper.requireNonNull(timeUnit, "unit is null");
        ObjectHelper.requireNonNull(scheduler, "scheduler is null");
        return RxJavaPlugins.onAssembly(new FlowableInterval(Math.max(0, j11), Math.max(0, j12), timeUnit, scheduler));
    }

    @CheckReturnValue
    @BackpressureSupport(BackpressureKind.ERROR)
    @NonNull
    @SchedulerSupport("custom")
    public static Flowable<Long> intervalRange(long j11, long j12, long j13, long j14, TimeUnit timeUnit, Scheduler scheduler) {
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
                return RxJavaPlugins.onAssembly(new FlowableIntervalRange(j11, j17, Math.max(0, j16), Math.max(0, j14), timeUnit, scheduler));
            }
            throw new IllegalArgumentException("Overflow! start + count is bigger than Long.MAX_VALUE");
        }
    }

    @CheckReturnValue
    @BackpressureSupport(BackpressureKind.FULL)
    @SchedulerSupport("none")
    public static <T> Flowable<T> merge(Iterable<? extends Publisher<? extends T>> iterable) {
        return fromIterable(iterable).flatMap(Functions.identity());
    }

    @CheckReturnValue
    @BackpressureSupport(BackpressureKind.FULL)
    @SchedulerSupport("none")
    public static <T> Flowable<T> mergeArray(Publisher<? extends T>... publisherArr) {
        return fromArray(publisherArr).flatMap(Functions.identity(), publisherArr.length);
    }

    @CheckReturnValue
    @BackpressureSupport(BackpressureKind.FULL)
    @SchedulerSupport("none")
    public static <T> Flowable<T> mergeArrayDelayError(Publisher<? extends T>... publisherArr) {
        return fromArray(publisherArr).flatMap(Functions.identity(), true, publisherArr.length);
    }

    @CheckReturnValue
    @BackpressureSupport(BackpressureKind.FULL)
    @SchedulerSupport("none")
    public static <T> Flowable<T> mergeDelayError(Iterable<? extends Publisher<? extends T>> iterable, int i11, int i12) {
        return fromIterable(iterable).flatMap(Functions.identity(), true, i11, i12);
    }

    @CheckReturnValue
    @BackpressureSupport(BackpressureKind.FULL)
    @SchedulerSupport("none")
    public static <T> Single<Boolean> sequenceEqual(Publisher<? extends T> publisher, Publisher<? extends T> publisher2, BiPredicate<? super T, ? super T> biPredicate) {
        return sequenceEqual(publisher, publisher2, biPredicate, bufferSize());
    }

    @CheckReturnValue
    @BackpressureSupport(BackpressureKind.FULL)
    @SchedulerSupport("none")
    public static <T> Flowable<T> switchOnNext(Publisher<? extends Publisher<? extends T>> publisher) {
        return fromPublisher(publisher).switchMap(Functions.identity());
    }

    @CheckReturnValue
    @BackpressureSupport(BackpressureKind.FULL)
    @SchedulerSupport("none")
    public static <T> Flowable<T> switchOnNextDelayError(Publisher<? extends Publisher<? extends T>> publisher, int i11) {
        return fromPublisher(publisher).switchMapDelayError(Functions.identity(), i11);
    }

    @CheckReturnValue
    @BackpressureSupport(BackpressureKind.ERROR)
    @NonNull
    @SchedulerSupport("custom")
    public static Flowable<Long> timer(long j11, TimeUnit timeUnit, Scheduler scheduler) {
        ObjectHelper.requireNonNull(timeUnit, "unit is null");
        ObjectHelper.requireNonNull(scheduler, "scheduler is null");
        return RxJavaPlugins.onAssembly(new FlowableTimer(Math.max(0, j11), timeUnit, scheduler));
    }

    @CheckReturnValue
    @BackpressureSupport(BackpressureKind.PASS_THROUGH)
    @NonNull
    @SchedulerSupport("none")
    public static <T, D> Flowable<T> using(Callable<? extends D> callable, Function<? super D, ? extends Publisher<? extends T>> function, Consumer<? super D> consumer, boolean z11) {
        ObjectHelper.requireNonNull(callable, "resourceSupplier is null");
        ObjectHelper.requireNonNull(function, "sourceSupplier is null");
        ObjectHelper.requireNonNull(consumer, "resourceDisposer is null");
        return RxJavaPlugins.onAssembly(new FlowableUsing(callable, function, consumer, z11));
    }

    @CheckReturnValue
    @BackpressureSupport(BackpressureKind.FULL)
    @SchedulerSupport("none")
    public final Iterable<T> blockingIterable(int i11) {
        ObjectHelper.verifyPositive(i11, "bufferSize");
        return new BlockingFlowableIterable(this, i11);
    }

    @CheckReturnValue
    @BackpressureSupport(BackpressureKind.UNBOUNDED_IN)
    @SchedulerSupport("none")
    public final T blockingSingle(T t11) {
        return single(t11).blockingGet();
    }

    @BackpressureSupport(BackpressureKind.UNBOUNDED_IN)
    @SchedulerSupport("none")
    public final void blockingSubscribe(Consumer<? super T> consumer) {
        FlowableBlockingSubscribe.subscribe(this, consumer, Functions.ON_ERROR_MISSING, Functions.EMPTY_ACTION);
    }

    @CheckReturnValue
    @BackpressureSupport(BackpressureKind.FULL)
    @SchedulerSupport("none")
    public final Flowable<List<T>> buffer(int i11, int i12) {
        return buffer(i11, i12, ArrayListSupplier.asCallable());
    }

    @CheckReturnValue
    @BackpressureSupport(BackpressureKind.FULL)
    @NonNull
    @SchedulerSupport("none")
    public final <R> Flowable<R> concatMap(Function<? super T, ? extends Publisher<? extends R>> function, int i11) {
        ObjectHelper.requireNonNull(function, "mapper is null");
        ObjectHelper.verifyPositive(i11, "prefetch");
        if (!(this instanceof ScalarCallable)) {
            return RxJavaPlugins.onAssembly(new FlowableConcatMap(this, function, i11, ErrorMode.IMMEDIATE));
        }
        Object call = ((ScalarCallable) this).call();
        if (call == null) {
            return empty();
        }
        return FlowableScalarXMap.scalarXMap(call, function);
    }

    @CheckReturnValue
    @BackpressureSupport(BackpressureKind.FULL)
    @NonNull
    @SchedulerSupport("none")
    public final Completable concatMapCompletable(Function<? super T, ? extends CompletableSource> function, int i11) {
        ObjectHelper.requireNonNull(function, "mapper is null");
        ObjectHelper.verifyPositive(i11, "prefetch");
        return RxJavaPlugins.onAssembly((Completable) new FlowableConcatMapCompletable(this, function, ErrorMode.IMMEDIATE, i11));
    }

    @CheckReturnValue
    @BackpressureSupport(BackpressureKind.FULL)
    @SchedulerSupport("none")
    public final Completable concatMapCompletableDelayError(Function<? super T, ? extends CompletableSource> function, boolean z11) {
        return concatMapCompletableDelayError(function, z11, 2);
    }

    @CheckReturnValue
    @BackpressureSupport(BackpressureKind.FULL)
    @NonNull
    @SchedulerSupport("none")
    public final <R> Flowable<R> concatMapDelayError(Function<? super T, ? extends Publisher<? extends R>> function, int i11, boolean z11) {
        ObjectHelper.requireNonNull(function, "mapper is null");
        ObjectHelper.verifyPositive(i11, "prefetch");
        if (this instanceof ScalarCallable) {
            Object call = ((ScalarCallable) this).call();
            if (call == null) {
                return empty();
            }
            return FlowableScalarXMap.scalarXMap(call, function);
        }
        return RxJavaPlugins.onAssembly(new FlowableConcatMap(this, function, i11, z11 ? ErrorMode.END : ErrorMode.BOUNDARY));
    }

    @CheckReturnValue
    @BackpressureSupport(BackpressureKind.FULL)
    @NonNull
    @SchedulerSupport("none")
    public final <R> Flowable<R> concatMapEager(Function<? super T, ? extends Publisher<? extends R>> function, int i11, int i12) {
        ObjectHelper.requireNonNull(function, "mapper is null");
        ObjectHelper.verifyPositive(i11, "maxConcurrency");
        ObjectHelper.verifyPositive(i12, "prefetch");
        return RxJavaPlugins.onAssembly(new FlowableConcatMapEager(this, function, i11, i12, ErrorMode.IMMEDIATE));
    }

    @CheckReturnValue
    @BackpressureSupport(BackpressureKind.FULL)
    @NonNull
    @SchedulerSupport("none")
    public final <R> Flowable<R> concatMapEagerDelayError(Function<? super T, ? extends Publisher<? extends R>> function, int i11, int i12, boolean z11) {
        ObjectHelper.requireNonNull(function, "mapper is null");
        ObjectHelper.verifyPositive(i11, "maxConcurrency");
        ObjectHelper.verifyPositive(i12, "prefetch");
        return RxJavaPlugins.onAssembly(new FlowableConcatMapEager(this, function, i11, i12, z11 ? ErrorMode.END : ErrorMode.BOUNDARY));
    }

    @CheckReturnValue
    @BackpressureSupport(BackpressureKind.FULL)
    @NonNull
    @SchedulerSupport("none")
    public final <U> Flowable<U> concatMapIterable(Function<? super T, ? extends Iterable<? extends U>> function, int i11) {
        ObjectHelper.requireNonNull(function, "mapper is null");
        ObjectHelper.verifyPositive(i11, "prefetch");
        return RxJavaPlugins.onAssembly(new FlowableFlattenIterable(this, function, i11));
    }

    @CheckReturnValue
    @BackpressureSupport(BackpressureKind.FULL)
    @NonNull
    @SchedulerSupport("none")
    public final <R> Flowable<R> concatMapMaybe(Function<? super T, ? extends MaybeSource<? extends R>> function, int i11) {
        ObjectHelper.requireNonNull(function, "mapper is null");
        ObjectHelper.verifyPositive(i11, "prefetch");
        return RxJavaPlugins.onAssembly(new FlowableConcatMapMaybe(this, function, ErrorMode.IMMEDIATE, i11));
    }

    @CheckReturnValue
    @BackpressureSupport(BackpressureKind.FULL)
    @SchedulerSupport("none")
    public final <R> Flowable<R> concatMapMaybeDelayError(Function<? super T, ? extends MaybeSource<? extends R>> function, boolean z11) {
        return concatMapMaybeDelayError(function, z11, 2);
    }

    @CheckReturnValue
    @BackpressureSupport(BackpressureKind.FULL)
    @NonNull
    @SchedulerSupport("none")
    public final <R> Flowable<R> concatMapSingle(Function<? super T, ? extends SingleSource<? extends R>> function, int i11) {
        ObjectHelper.requireNonNull(function, "mapper is null");
        ObjectHelper.verifyPositive(i11, "prefetch");
        return RxJavaPlugins.onAssembly(new FlowableConcatMapSingle(this, function, ErrorMode.IMMEDIATE, i11));
    }

    @CheckReturnValue
    @BackpressureSupport(BackpressureKind.FULL)
    @SchedulerSupport("none")
    public final <R> Flowable<R> concatMapSingleDelayError(Function<? super T, ? extends SingleSource<? extends R>> function, boolean z11) {
        return concatMapSingleDelayError(function, z11, 2);
    }

    @CheckReturnValue
    @Experimental
    @BackpressureSupport(BackpressureKind.PASS_THROUGH)
    @NonNull
    @SchedulerSupport("none")
    public final <R> Flowable<R> dematerialize(Function<? super T, Notification<R>> function) {
        ObjectHelper.requireNonNull(function, "selector is null");
        return RxJavaPlugins.onAssembly(new FlowableDematerialize(this, function));
    }

    @CheckReturnValue
    @BackpressureSupport(BackpressureKind.FULL)
    @SchedulerSupport("none")
    public final <K> Flowable<T> distinct(Function<? super T, K> function) {
        return distinct(function, Functions.createHashSet());
    }

    @CheckReturnValue
    @BackpressureSupport(BackpressureKind.FULL)
    @SchedulerSupport("none")
    public final <K> Flowable<T> distinctUntilChanged(Function<? super T, K> function) {
        ObjectHelper.requireNonNull(function, "keySelector is null");
        return RxJavaPlugins.onAssembly(new FlowableDistinctUntilChanged(this, function, ObjectHelper.equalsPredicate()));
    }

    @CheckReturnValue
    @BackpressureSupport(BackpressureKind.FULL)
    @SchedulerSupport("none")
    public final <R> Flowable<R> flatMap(Function<? super T, ? extends Publisher<? extends R>> function, boolean z11) {
        return flatMap(function, z11, bufferSize(), bufferSize());
    }

    @CheckReturnValue
    @BackpressureSupport(BackpressureKind.UNBOUNDED_IN)
    @NonNull
    @SchedulerSupport("none")
    public final Completable flatMapCompletable(Function<? super T, ? extends CompletableSource> function, boolean z11, int i11) {
        ObjectHelper.requireNonNull(function, "mapper is null");
        ObjectHelper.verifyPositive(i11, "maxConcurrency");
        return RxJavaPlugins.onAssembly((Completable) new FlowableFlatMapCompletableCompletable(this, function, z11, i11));
    }

    @CheckReturnValue
    @BackpressureSupport(BackpressureKind.FULL)
    @NonNull
    @SchedulerSupport("none")
    public final <U> Flowable<U> flatMapIterable(Function<? super T, ? extends Iterable<? extends U>> function, int i11) {
        ObjectHelper.requireNonNull(function, "mapper is null");
        ObjectHelper.verifyPositive(i11, "bufferSize");
        return RxJavaPlugins.onAssembly(new FlowableFlattenIterable(this, function, i11));
    }

    @CheckReturnValue
    @BackpressureSupport(BackpressureKind.UNBOUNDED_IN)
    @NonNull
    @SchedulerSupport("none")
    public final <R> Flowable<R> flatMapMaybe(Function<? super T, ? extends MaybeSource<? extends R>> function, boolean z11, int i11) {
        ObjectHelper.requireNonNull(function, "mapper is null");
        ObjectHelper.verifyPositive(i11, "maxConcurrency");
        return RxJavaPlugins.onAssembly(new FlowableFlatMapMaybe(this, function, z11, i11));
    }

    @CheckReturnValue
    @BackpressureSupport(BackpressureKind.UNBOUNDED_IN)
    @NonNull
    @SchedulerSupport("none")
    public final <R> Flowable<R> flatMapSingle(Function<? super T, ? extends SingleSource<? extends R>> function, boolean z11, int i11) {
        ObjectHelper.requireNonNull(function, "mapper is null");
        ObjectHelper.verifyPositive(i11, "maxConcurrency");
        return RxJavaPlugins.onAssembly(new FlowableFlatMapSingle(this, function, z11, i11));
    }

    @CheckReturnValue
    @BackpressureSupport(BackpressureKind.NONE)
    @SchedulerSupport("none")
    public final Disposable forEachWhile(Predicate<? super T> predicate, Consumer<? super Throwable> consumer) {
        return forEachWhile(predicate, consumer, Functions.EMPTY_ACTION);
    }

    @CheckReturnValue
    @BackpressureSupport(BackpressureKind.FULL)
    @SchedulerSupport("none")
    public final <K> Flowable<GroupedFlowable<K, T>> groupBy(Function<? super T, ? extends K> function, boolean z11) {
        return groupBy(function, Functions.identity(), z11, bufferSize());
    }

    @CheckReturnValue
    @BackpressureSupport(BackpressureKind.FULL)
    @SchedulerSupport("custom")
    public final Flowable<T> observeOn(Scheduler scheduler, boolean z11) {
        return observeOn(scheduler, z11, bufferSize());
    }

    @CheckReturnValue
    @BackpressureSupport(BackpressureKind.UNBOUNDED_IN)
    @SchedulerSupport("none")
    public final Flowable<T> onBackpressureBuffer(boolean z11) {
        return onBackpressureBuffer(bufferSize(), z11, true);
    }

    @CheckReturnValue
    @BackpressureSupport(BackpressureKind.UNBOUNDED_IN)
    @NonNull
    @SchedulerSupport("none")
    public final Flowable<T> onBackpressureDrop(Consumer<? super T> consumer) {
        ObjectHelper.requireNonNull(consumer, "onDrop is null");
        return RxJavaPlugins.onAssembly(new FlowableOnBackpressureDrop(this, consumer));
    }

    @CheckReturnValue
    @BackpressureSupport(BackpressureKind.FULL)
    @SchedulerSupport("none")
    public final ParallelFlowable<T> parallel(int i11) {
        ObjectHelper.verifyPositive(i11, "parallelism");
        return ParallelFlowable.from(this, i11);
    }

    @CheckReturnValue
    @BackpressureSupport(BackpressureKind.FULL)
    @SchedulerSupport("none")
    public final <R> Flowable<R> publish(Function<? super Flowable<T>, ? extends Publisher<R>> function) {
        return publish(function, bufferSize());
    }

    @CheckReturnValue
    @BackpressureSupport(BackpressureKind.FULL)
    @SchedulerSupport("none")
    public final Flowable<T> repeat(long j11) {
        int i11 = (j11 > 0 ? 1 : (j11 == 0 ? 0 : -1));
        if (i11 < 0) {
            throw new IllegalArgumentException("times >= 0 required but it was " + j11);
        } else if (i11 == 0) {
            return empty();
        } else {
            return RxJavaPlugins.onAssembly(new FlowableRepeat(this, j11));
        }
    }

    @CheckReturnValue
    @BackpressureSupport(BackpressureKind.FULL)
    @NonNull
    @SchedulerSupport("none")
    public final <R> Flowable<R> replay(Function<? super Flowable<T>, ? extends Publisher<R>> function) {
        ObjectHelper.requireNonNull(function, "selector is null");
        return FlowableReplay.multicastSelector(FlowableInternalHelper.replayCallable(this), function);
    }

    @CheckReturnValue
    @BackpressureSupport(BackpressureKind.FULL)
    @NonNull
    @SchedulerSupport("none")
    public final Flowable<T> retry(BiPredicate<? super Integer, ? super Throwable> biPredicate) {
        ObjectHelper.requireNonNull(biPredicate, "predicate is null");
        return RxJavaPlugins.onAssembly(new FlowableRetryBiPredicate(this, biPredicate));
    }

    @CheckReturnValue
    @BackpressureSupport(BackpressureKind.ERROR)
    @SchedulerSupport("io.reactivex:computation")
    public final Flowable<T> sample(long j11, TimeUnit timeUnit, boolean z11) {
        return sample(j11, timeUnit, Schedulers.computation(), z11);
    }

    @CheckReturnValue
    @BackpressureSupport(BackpressureKind.FULL)
    @NonNull
    @SchedulerSupport("none")
    public final Flowable<T> sorted(Comparator<? super T> comparator) {
        ObjectHelper.requireNonNull(comparator, "sortFunction");
        return toList().toFlowable().map(Functions.listSorter(comparator)).flatMapIterable(Functions.identity());
    }

    @CheckReturnValue
    @BackpressureSupport(BackpressureKind.FULL)
    @NonNull
    @SchedulerSupport("none")
    public final Flowable<T> startWith(Publisher<? extends T> publisher) {
        ObjectHelper.requireNonNull(publisher, "other is null");
        return concatArray(publisher, this);
    }

    @CheckReturnValue
    @BackpressureSupport(BackpressureKind.UNBOUNDED_IN)
    @SchedulerSupport("none")
    public final Disposable subscribe(Consumer<? super T> consumer) {
        return subscribe(consumer, Functions.ON_ERROR_MISSING, Functions.EMPTY_ACTION, FlowableInternalHelper.RequestMax.INSTANCE);
    }

    @CheckReturnValue
    @BackpressureSupport(BackpressureKind.FULL)
    @SchedulerSupport("none")
    public final <R> Flowable<R> switchMap(Function<? super T, ? extends Publisher<? extends R>> function, int i11) {
        return a(function, i11, false);
    }

    @CheckReturnValue
    @BackpressureSupport(BackpressureKind.SPECIAL)
    @SchedulerSupport("none")
    public final <R> Flowable<R> switchMapDelayError(Function<? super T, ? extends Publisher<? extends R>> function, int i11) {
        return a(function, i11, true);
    }

    @CheckReturnValue
    @BackpressureSupport(BackpressureKind.ERROR)
    @NonNull
    @SchedulerSupport("custom")
    public final Flowable<T> throttleFirst(long j11, TimeUnit timeUnit, Scheduler scheduler) {
        ObjectHelper.requireNonNull(timeUnit, "unit is null");
        ObjectHelper.requireNonNull(scheduler, "scheduler is null");
        return RxJavaPlugins.onAssembly(new FlowableThrottleFirstTimed(this, j11, timeUnit, scheduler));
    }

    @CheckReturnValue
    @BackpressureSupport(BackpressureKind.ERROR)
    @SchedulerSupport("custom")
    public final Flowable<T> throttleLast(long j11, TimeUnit timeUnit, Scheduler scheduler) {
        return sample(j11, timeUnit, scheduler);
    }

    @CheckReturnValue
    @BackpressureSupport(BackpressureKind.ERROR)
    @SchedulerSupport("io.reactivex:computation")
    public final Flowable<T> throttleLatest(long j11, TimeUnit timeUnit, boolean z11) {
        return throttleLatest(j11, timeUnit, Schedulers.computation(), z11);
    }

    @CheckReturnValue
    @BackpressureSupport(BackpressureKind.ERROR)
    @SchedulerSupport("custom")
    public final Flowable<T> throttleWithTimeout(long j11, TimeUnit timeUnit, Scheduler scheduler) {
        return debounce(j11, timeUnit, scheduler);
    }

    @CheckReturnValue
    @BackpressureSupport(BackpressureKind.PASS_THROUGH)
    @SchedulerSupport("none")
    public final Flowable<Timed<T>> timeInterval(Scheduler scheduler) {
        return timeInterval(TimeUnit.MILLISECONDS, scheduler);
    }

    @CheckReturnValue
    @BackpressureSupport(BackpressureKind.FULL)
    @NonNull
    @SchedulerSupport("none")
    public final <V> Flowable<T> timeout(Function<? super T, ? extends Publisher<V>> function, Flowable<? extends T> flowable) {
        ObjectHelper.requireNonNull(flowable, "other is null");
        return timeout0((Publisher) null, function, flowable);
    }

    @CheckReturnValue
    @BackpressureSupport(BackpressureKind.PASS_THROUGH)
    @SchedulerSupport("none")
    public final Flowable<Timed<T>> timestamp(Scheduler scheduler) {
        return timestamp(TimeUnit.MILLISECONDS, scheduler);
    }

    @CheckReturnValue
    @BackpressureSupport(BackpressureKind.UNBOUNDED_IN)
    @SchedulerSupport("none")
    public final Single<List<T>> toList(int i11) {
        ObjectHelper.verifyPositive(i11, "capacityHint");
        return RxJavaPlugins.onAssembly(new FlowableToListSingle(this, Functions.createArrayList(i11)));
    }

    @CheckReturnValue
    @BackpressureSupport(BackpressureKind.UNBOUNDED_IN)
    @NonNull
    @SchedulerSupport("none")
    public final Single<List<T>> toSortedList(Comparator<? super T> comparator) {
        ObjectHelper.requireNonNull(comparator, "comparator is null");
        return toList().map(Functions.listSorter(comparator));
    }

    @CheckReturnValue
    @BackpressureSupport(BackpressureKind.FULL)
    @SchedulerSupport("none")
    public final Flowable<Flowable<T>> window(long j11, long j12) {
        return window(j11, j12, bufferSize());
    }

    @CheckReturnValue
    @BackpressureSupport(BackpressureKind.FULL)
    @NonNull
    @SchedulerSupport("none")
    public static <T, R> Flowable<R> combineLatest(Publisher<? extends T>[] publisherArr, Function<? super Object[], ? extends R> function, int i11) {
        ObjectHelper.requireNonNull(publisherArr, "sources is null");
        if (publisherArr.length == 0) {
            return empty();
        }
        ObjectHelper.requireNonNull(function, "combiner is null");
        ObjectHelper.verifyPositive(i11, "bufferSize");
        return RxJavaPlugins.onAssembly(new FlowableCombineLatest(publisherArr, function, i11, false));
    }

    @CheckReturnValue
    @BackpressureSupport(BackpressureKind.FULL)
    @SchedulerSupport("none")
    public static <T, R> Flowable<R> combineLatestDelayError(Function<? super Object[], ? extends R> function, int i11, Publisher<? extends T>... publisherArr) {
        return combineLatestDelayError(publisherArr, function, i11);
    }

    @CheckReturnValue
    @BackpressureSupport(BackpressureKind.FULL)
    @SchedulerSupport("none")
    public static <T> Flowable<T> concat(Publisher<? extends Publisher<? extends T>> publisher) {
        return concat(publisher, bufferSize());
    }

    @CheckReturnValue
    @BackpressureSupport(BackpressureKind.FULL)
    @SchedulerSupport("none")
    public static <T> Flowable<T> concatDelayError(Publisher<? extends Publisher<? extends T>> publisher) {
        return concatDelayError(publisher, bufferSize(), true);
    }

    @CheckReturnValue
    @BackpressureSupport(BackpressureKind.PASS_THROUGH)
    @NonNull
    @SchedulerSupport("none")
    public static <T> Flowable<T> error(Throwable th2) {
        ObjectHelper.requireNonNull(th2, "throwable is null");
        return error((Callable<? extends Throwable>) Functions.justCallable(th2));
    }

    @CheckReturnValue
    @BackpressureSupport(BackpressureKind.FULL)
    @NonNull
    @SchedulerSupport("none")
    public static <T> Flowable<T> fromFuture(Future<? extends T> future, long j11, TimeUnit timeUnit) {
        ObjectHelper.requireNonNull(future, "future is null");
        ObjectHelper.requireNonNull(timeUnit, "unit is null");
        return RxJavaPlugins.onAssembly(new FlowableFromFuture(future, j11, timeUnit));
    }

    @CheckReturnValue
    @BackpressureSupport(BackpressureKind.FULL)
    @NonNull
    @SchedulerSupport("none")
    public static <T> Flowable<T> just(T t11, T t12) {
        ObjectHelper.requireNonNull(t11, "item1 is null");
        ObjectHelper.requireNonNull(t12, "item2 is null");
        return fromArray(t11, t12);
    }

    @CheckReturnValue
    @BackpressureSupport(BackpressureKind.FULL)
    @SchedulerSupport("none")
    public static <T> Flowable<T> merge(Iterable<? extends Publisher<? extends T>> iterable, int i11) {
        return fromIterable(iterable).flatMap(Functions.identity(), i11);
    }

    @CheckReturnValue
    @BackpressureSupport(BackpressureKind.FULL)
    @SchedulerSupport("none")
    public static <T> Flowable<T> mergeDelayError(Iterable<? extends Publisher<? extends T>> iterable, int i11) {
        return fromIterable(iterable).flatMap(Functions.identity(), true, i11);
    }

    @CheckReturnValue
    @BackpressureSupport(BackpressureKind.FULL)
    @NonNull
    @SchedulerSupport("none")
    public static <T> Single<Boolean> sequenceEqual(Publisher<? extends T> publisher, Publisher<? extends T> publisher2, BiPredicate<? super T, ? super T> biPredicate, int i11) {
        ObjectHelper.requireNonNull(publisher, "source1 is null");
        ObjectHelper.requireNonNull(publisher2, "source2 is null");
        ObjectHelper.requireNonNull(biPredicate, "isEqual is null");
        ObjectHelper.verifyPositive(i11, "bufferSize");
        return RxJavaPlugins.onAssembly(new FlowableSequenceEqualSingle(publisher, publisher2, biPredicate, i11));
    }

    @BackpressureSupport(BackpressureKind.FULL)
    @SchedulerSupport("none")
    public final void blockingSubscribe(Consumer<? super T> consumer, int i11) {
        FlowableBlockingSubscribe.subscribe(this, consumer, Functions.ON_ERROR_MISSING, Functions.EMPTY_ACTION, i11);
    }

    @CheckReturnValue
    @BackpressureSupport(BackpressureKind.FULL)
    @NonNull
    @SchedulerSupport("none")
    public final <U extends Collection<? super T>> Flowable<U> buffer(int i11, int i12, Callable<U> callable) {
        ObjectHelper.verifyPositive(i11, "count");
        ObjectHelper.verifyPositive(i12, "skip");
        ObjectHelper.requireNonNull(callable, "bufferSupplier is null");
        return RxJavaPlugins.onAssembly(new FlowableBuffer(this, i11, i12, callable));
    }

    @CheckReturnValue
    @BackpressureSupport(BackpressureKind.FULL)
    @NonNull
    @SchedulerSupport("none")
    public final Completable concatMapCompletableDelayError(Function<? super T, ? extends CompletableSource> function, boolean z11, int i11) {
        ObjectHelper.requireNonNull(function, "mapper is null");
        ObjectHelper.verifyPositive(i11, "prefetch");
        return RxJavaPlugins.onAssembly((Completable) new FlowableConcatMapCompletable(this, function, z11 ? ErrorMode.END : ErrorMode.BOUNDARY, i11));
    }

    @CheckReturnValue
    @BackpressureSupport(BackpressureKind.FULL)
    @NonNull
    @SchedulerSupport("none")
    public final <R> Flowable<R> concatMapMaybeDelayError(Function<? super T, ? extends MaybeSource<? extends R>> function, boolean z11, int i11) {
        ObjectHelper.requireNonNull(function, "mapper is null");
        ObjectHelper.verifyPositive(i11, "prefetch");
        return RxJavaPlugins.onAssembly(new FlowableConcatMapMaybe(this, function, z11 ? ErrorMode.END : ErrorMode.BOUNDARY, i11));
    }

    @CheckReturnValue
    @BackpressureSupport(BackpressureKind.FULL)
    @NonNull
    @SchedulerSupport("none")
    public final <R> Flowable<R> concatMapSingleDelayError(Function<? super T, ? extends SingleSource<? extends R>> function, boolean z11, int i11) {
        ObjectHelper.requireNonNull(function, "mapper is null");
        ObjectHelper.verifyPositive(i11, "prefetch");
        return RxJavaPlugins.onAssembly(new FlowableConcatMapSingle(this, function, z11 ? ErrorMode.END : ErrorMode.BOUNDARY, i11));
    }

    @CheckReturnValue
    @BackpressureSupport(BackpressureKind.FULL)
    @SchedulerSupport("none")
    public final Flowable<T> concatWith(@NonNull SingleSource<? extends T> singleSource) {
        ObjectHelper.requireNonNull(singleSource, "other is null");
        return RxJavaPlugins.onAssembly(new FlowableConcatWithSingle(this, singleSource));
    }

    @CheckReturnValue
    @BackpressureSupport(BackpressureKind.ERROR)
    @SchedulerSupport("io.reactivex:computation")
    public final Flowable<T> debounce(long j11, TimeUnit timeUnit) {
        return debounce(j11, timeUnit, Schedulers.computation());
    }

    @CheckReturnValue
    @BackpressureSupport(BackpressureKind.FULL)
    @SchedulerSupport("io.reactivex:computation")
    public final Flowable<T> delay(long j11, TimeUnit timeUnit) {
        return delay(j11, timeUnit, Schedulers.computation(), false);
    }

    @CheckReturnValue
    @BackpressureSupport(BackpressureKind.FULL)
    @SchedulerSupport("io.reactivex:computation")
    public final Flowable<T> delaySubscription(long j11, TimeUnit timeUnit) {
        return delaySubscription(j11, timeUnit, Schedulers.computation());
    }

    @CheckReturnValue
    @BackpressureSupport(BackpressureKind.FULL)
    @SchedulerSupport("none")
    public final <K> Flowable<T> distinct(Function<? super T, K> function, Callable<? extends Collection<? super K>> callable) {
        ObjectHelper.requireNonNull(function, "keySelector is null");
        ObjectHelper.requireNonNull(callable, "collectionSupplier is null");
        return RxJavaPlugins.onAssembly(new FlowableDistinct(this, function, callable));
    }

    @CheckReturnValue
    @BackpressureSupport(BackpressureKind.UNBOUNDED_IN)
    @NonNull
    @SchedulerSupport("none")
    public final Single<T> elementAt(long j11, T t11) {
        if (j11 >= 0) {
            ObjectHelper.requireNonNull(t11, "defaultItem is null");
            return RxJavaPlugins.onAssembly(new FlowableElementAtSingle(this, j11, t11));
        }
        throw new IndexOutOfBoundsException("index >= 0 required but it was " + j11);
    }

    @CheckReturnValue
    @BackpressureSupport(BackpressureKind.FULL)
    @SchedulerSupport("none")
    public final <R> Flowable<R> flatMap(Function<? super T, ? extends Publisher<? extends R>> function, int i11) {
        return flatMap(function, false, i11, bufferSize());
    }

    @CheckReturnValue
    @BackpressureSupport(BackpressureKind.NONE)
    @NonNull
    @SchedulerSupport("none")
    public final Disposable forEachWhile(Predicate<? super T> predicate, Consumer<? super Throwable> consumer, Action action) {
        ObjectHelper.requireNonNull(predicate, "onNext is null");
        ObjectHelper.requireNonNull(consumer, "onError is null");
        ObjectHelper.requireNonNull(action, "onComplete is null");
        ForEachWhileSubscriber forEachWhileSubscriber = new ForEachWhileSubscriber(predicate, consumer, action);
        subscribe(forEachWhileSubscriber);
        return forEachWhileSubscriber;
    }

    @CheckReturnValue
    @BackpressureSupport(BackpressureKind.FULL)
    @SchedulerSupport("none")
    public final <K, V> Flowable<GroupedFlowable<K, V>> groupBy(Function<? super T, ? extends K> function, Function<? super T, ? extends V> function2) {
        return groupBy(function, function2, false, bufferSize());
    }

    @CheckReturnValue
    @BackpressureSupport(BackpressureKind.FULL)
    @NonNull
    @SchedulerSupport("none")
    public final Flowable<T> mergeWith(@NonNull SingleSource<? extends T> singleSource) {
        ObjectHelper.requireNonNull(singleSource, "other is null");
        return RxJavaPlugins.onAssembly(new FlowableMergeWithSingle(this, singleSource));
    }

    @CheckReturnValue
    @BackpressureSupport(BackpressureKind.FULL)
    @NonNull
    @SchedulerSupport("custom")
    public final Flowable<T> observeOn(Scheduler scheduler, boolean z11, int i11) {
        ObjectHelper.requireNonNull(scheduler, "scheduler is null");
        ObjectHelper.verifyPositive(i11, "bufferSize");
        return RxJavaPlugins.onAssembly(new FlowableObserveOn(this, scheduler, z11, i11));
    }

    @CheckReturnValue
    @BackpressureSupport(BackpressureKind.ERROR)
    @SchedulerSupport("none")
    public final Flowable<T> onBackpressureBuffer(int i11) {
        return onBackpressureBuffer(i11, false, false);
    }

    @CheckReturnValue
    @BackpressureSupport(BackpressureKind.FULL)
    @NonNull
    @SchedulerSupport("none")
    public final Flowable<T> onErrorResumeNext(Publisher<? extends T> publisher) {
        ObjectHelper.requireNonNull(publisher, "next is null");
        return onErrorResumeNext(Functions.justFunction(publisher));
    }

    @CheckReturnValue
    @BackpressureSupport(BackpressureKind.FULL)
    @NonNull
    @SchedulerSupport("none")
    public final <R> Flowable<R> publish(Function<? super Flowable<T>, ? extends Publisher<? extends R>> function, int i11) {
        ObjectHelper.requireNonNull(function, "selector is null");
        ObjectHelper.verifyPositive(i11, "prefetch");
        return RxJavaPlugins.onAssembly(new FlowablePublishMulticast(this, function, i11, false));
    }

    @CheckReturnValue
    @BackpressureSupport(BackpressureKind.UNBOUNDED_IN)
    @NonNull
    @SchedulerSupport("none")
    public final <R> Single<R> reduce(R r11, BiFunction<R, ? super T, R> biFunction) {
        ObjectHelper.requireNonNull(r11, "seed is null");
        ObjectHelper.requireNonNull(biFunction, "reducer is null");
        return RxJavaPlugins.onAssembly(new FlowableReduceSeedSingle(this, r11, biFunction));
    }

    @CheckReturnValue
    @BackpressureSupport(BackpressureKind.ERROR)
    @NonNull
    @SchedulerSupport("custom")
    public final Flowable<T> sample(long j11, TimeUnit timeUnit, Scheduler scheduler) {
        ObjectHelper.requireNonNull(timeUnit, "unit is null");
        ObjectHelper.requireNonNull(scheduler, "scheduler is null");
        return RxJavaPlugins.onAssembly(new FlowableSampleTimed(this, j11, timeUnit, scheduler, false));
    }

    @CheckReturnValue
    @BackpressureSupport(BackpressureKind.FULL)
    @NonNull
    @SchedulerSupport("none")
    public final <R> Flowable<R> scan(R r11, BiFunction<R, ? super T, R> biFunction) {
        ObjectHelper.requireNonNull(r11, "initialValue is null");
        return scanWith(Functions.justCallable(r11), biFunction);
    }

    @CheckReturnValue
    @BackpressureSupport(BackpressureKind.FULL)
    @SchedulerSupport("none")
    public final Flowable<T> skip(long j11, TimeUnit timeUnit) {
        return skipUntil(timer(j11, timeUnit));
    }

    @CheckReturnValue
    @BackpressureSupport(BackpressureKind.UNBOUNDED_IN)
    @SchedulerSupport("none")
    public final Disposable subscribe(Consumer<? super T> consumer, Consumer<? super Throwable> consumer2) {
        return subscribe(consumer, consumer2, Functions.EMPTY_ACTION, FlowableInternalHelper.RequestMax.INSTANCE);
    }

    @CheckReturnValue
    @BackpressureSupport(BackpressureKind.PASS_THROUGH)
    @NonNull
    @SchedulerSupport("custom")
    public final Flowable<T> subscribeOn(@NonNull Scheduler scheduler, boolean z11) {
        ObjectHelper.requireNonNull(scheduler, "scheduler is null");
        return RxJavaPlugins.onAssembly(new FlowableSubscribeOn(this, scheduler, z11));
    }

    @CheckReturnValue
    @BackpressureSupport(BackpressureKind.PASS_THROUGH)
    @SchedulerSupport("io.reactivex:computation")
    public final Flowable<T> take(long j11, TimeUnit timeUnit) {
        return takeUntil(timer(j11, timeUnit));
    }

    @CheckReturnValue
    @BackpressureSupport(BackpressureKind.PASS_THROUGH)
    @NonNull
    @SchedulerSupport("none")
    public final <U> Flowable<T> takeUntil(Publisher<U> publisher) {
        ObjectHelper.requireNonNull(publisher, "other is null");
        return RxJavaPlugins.onAssembly(new FlowableTakeUntil(this, publisher));
    }

    @CheckReturnValue
    @BackpressureSupport(BackpressureKind.FULL)
    @SchedulerSupport("none")
    public final TestSubscriber<T> test(long j11) {
        TestSubscriber<T> testSubscriber = new TestSubscriber<>(j11);
        subscribe(testSubscriber);
        return testSubscriber;
    }

    @CheckReturnValue
    @BackpressureSupport(BackpressureKind.ERROR)
    @SchedulerSupport("custom")
    public final Flowable<T> throttleLatest(long j11, TimeUnit timeUnit, Scheduler scheduler) {
        return throttleLatest(j11, timeUnit, scheduler, false);
    }

    @CheckReturnValue
    @BackpressureSupport(BackpressureKind.PASS_THROUGH)
    @SchedulerSupport("none")
    public final Flowable<Timed<T>> timeInterval(TimeUnit timeUnit) {
        return timeInterval(timeUnit, Schedulers.computation());
    }

    @CheckReturnValue
    @BackpressureSupport(BackpressureKind.PASS_THROUGH)
    @SchedulerSupport("none")
    public final Flowable<Timed<T>> timestamp(TimeUnit timeUnit) {
        return timestamp(timeUnit, Schedulers.computation());
    }

    @CheckReturnValue
    @BackpressureSupport(BackpressureKind.UNBOUNDED_IN)
    @NonNull
    @SchedulerSupport("none")
    public final <K, V> Single<Map<K, V>> toMap(Function<? super T, ? extends K> function, Function<? super T, ? extends V> function2) {
        ObjectHelper.requireNonNull(function, "keySelector is null");
        ObjectHelper.requireNonNull(function2, "valueSelector is null");
        return collect(HashMapSupplier.asCallable(), Functions.toMapKeyValueSelector(function, function2));
    }

    @CheckReturnValue
    @BackpressureSupport(BackpressureKind.FULL)
    @SchedulerSupport("none")
    public final Flowable<Flowable<T>> window(long j11, long j12, int i11) {
        ObjectHelper.verifyPositive(j12, "skip");
        ObjectHelper.verifyPositive(j11, "count");
        ObjectHelper.verifyPositive(i11, "bufferSize");
        return RxJavaPlugins.onAssembly(new FlowableWindow(this, j11, j12, i11));
    }

    @CheckReturnValue
    @BackpressureSupport(BackpressureKind.FULL)
    @NonNull
    @SchedulerSupport("none")
    public static <T, R> Flowable<R> combineLatestDelayError(Publisher<? extends T>[] publisherArr, Function<? super Object[], ? extends R> function, int i11) {
        ObjectHelper.requireNonNull(publisherArr, "sources is null");
        ObjectHelper.requireNonNull(function, "combiner is null");
        ObjectHelper.verifyPositive(i11, "bufferSize");
        if (publisherArr.length == 0) {
            return empty();
        }
        return RxJavaPlugins.onAssembly(new FlowableCombineLatest(publisherArr, function, i11, true));
    }

    @CheckReturnValue
    @BackpressureSupport(BackpressureKind.FULL)
    @SchedulerSupport("none")
    public static <T> Flowable<T> concat(Publisher<? extends Publisher<? extends T>> publisher, int i11) {
        return fromPublisher(publisher).concatMap(Functions.identity(), i11);
    }

    @CheckReturnValue
    @BackpressureSupport(BackpressureKind.FULL)
    @SchedulerSupport("none")
    public static <T> Flowable<T> concatDelayError(Publisher<? extends Publisher<? extends T>> publisher, int i11, boolean z11) {
        return fromPublisher(publisher).concatMapDelayError(Functions.identity(), i11, z11);
    }

    @CheckReturnValue
    @BackpressureSupport(BackpressureKind.FULL)
    @SchedulerSupport("none")
    public static <T> Flowable<T> merge(Publisher<? extends Publisher<? extends T>> publisher) {
        return merge(publisher, bufferSize());
    }

    @CheckReturnValue
    @BackpressureSupport(BackpressureKind.FULL)
    @SchedulerSupport("none")
    public static <T> Flowable<T> mergeDelayError(Publisher<? extends Publisher<? extends T>> publisher) {
        return mergeDelayError(publisher, bufferSize());
    }

    private <U, V> Flowable<T> timeout0(Publisher<U> publisher, Function<? super T, ? extends Publisher<V>> function, Publisher<? extends T> publisher2) {
        ObjectHelper.requireNonNull(function, "itemTimeoutIndicator is null");
        return RxJavaPlugins.onAssembly(new FlowableTimeout(this, publisher, function, publisher2));
    }

    /* JADX WARNING: type inference failed for: r2v0, types: [io.reactivex.functions.Function, io.reactivex.functions.Function<? super java.lang.Object[], ? extends R>, java.lang.Object] */
    /* JADX WARNING: Unknown variable types count: 1 */
    @io.reactivex.annotations.CheckReturnValue
    @io.reactivex.annotations.BackpressureSupport(io.reactivex.annotations.BackpressureKind.FULL)
    @io.reactivex.annotations.NonNull
    @io.reactivex.annotations.SchedulerSupport("none")
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static <T, R> io.reactivex.Flowable<R> zip(org.reactivestreams.Publisher<? extends org.reactivestreams.Publisher<? extends T>> r1, io.reactivex.functions.Function<? super java.lang.Object[], ? extends R> r2) {
        /*
            java.lang.String r0 = "zipper is null"
            io.reactivex.internal.functions.ObjectHelper.requireNonNull(r2, (java.lang.String) r0)
            io.reactivex.Flowable r1 = fromPublisher(r1)
            io.reactivex.Single r1 = r1.toList()
            io.reactivex.functions.Function r2 = io.reactivex.internal.operators.flowable.FlowableInternalHelper.zipIterable(r2)
            io.reactivex.Flowable r1 = r1.flatMapPublisher(r2)
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: io.reactivex.Flowable.zip(org.reactivestreams.Publisher, io.reactivex.functions.Function):io.reactivex.Flowable");
    }

    @BackpressureSupport(BackpressureKind.UNBOUNDED_IN)
    @SchedulerSupport("none")
    public final void blockingSubscribe(Consumer<? super T> consumer, Consumer<? super Throwable> consumer2) {
        FlowableBlockingSubscribe.subscribe(this, consumer, consumer2, Functions.EMPTY_ACTION);
    }

    @CheckReturnValue
    @BackpressureSupport(BackpressureKind.ERROR)
    @NonNull
    @SchedulerSupport("custom")
    public final Flowable<T> debounce(long j11, TimeUnit timeUnit, Scheduler scheduler) {
        ObjectHelper.requireNonNull(timeUnit, "unit is null");
        ObjectHelper.requireNonNull(scheduler, "scheduler is null");
        return RxJavaPlugins.onAssembly(new FlowableDebounceTimed(this, j11, timeUnit, scheduler));
    }

    @CheckReturnValue
    @BackpressureSupport(BackpressureKind.FULL)
    @SchedulerSupport("io.reactivex:computation")
    public final Flowable<T> delay(long j11, TimeUnit timeUnit, boolean z11) {
        return delay(j11, timeUnit, Schedulers.computation(), z11);
    }

    @CheckReturnValue
    @BackpressureSupport(BackpressureKind.FULL)
    @SchedulerSupport("custom")
    public final Flowable<T> delaySubscription(long j11, TimeUnit timeUnit, Scheduler scheduler) {
        return delaySubscription(timer(j11, timeUnit, scheduler));
    }

    @CheckReturnValue
    @BackpressureSupport(BackpressureKind.FULL)
    @SchedulerSupport("none")
    public final Flowable<T> distinctUntilChanged(BiPredicate<? super T, ? super T> biPredicate) {
        ObjectHelper.requireNonNull(biPredicate, "comparer is null");
        return RxJavaPlugins.onAssembly(new FlowableDistinctUntilChanged(this, Functions.identity(), biPredicate));
    }

    @CheckReturnValue
    @BackpressureSupport(BackpressureKind.FULL)
    @SchedulerSupport("none")
    public final <R> Flowable<R> flatMap(Function<? super T, ? extends Publisher<? extends R>> function, boolean z11, int i11) {
        return flatMap(function, z11, i11, bufferSize());
    }

    @CheckReturnValue
    @BackpressureSupport(BackpressureKind.FULL)
    @SchedulerSupport("none")
    public final <K, V> Flowable<GroupedFlowable<K, V>> groupBy(Function<? super T, ? extends K> function, Function<? super T, ? extends V> function2, boolean z11) {
        return groupBy(function, function2, z11, bufferSize());
    }

    @CheckReturnValue
    @BackpressureSupport(BackpressureKind.ERROR)
    @SchedulerSupport("none")
    public final Flowable<T> onBackpressureBuffer(int i11, boolean z11) {
        return onBackpressureBuffer(i11, z11, false);
    }

    @CheckReturnValue
    @BackpressureSupport(BackpressureKind.FULL)
    @SchedulerSupport("none")
    public final ParallelFlowable<T> parallel(int i11, int i12) {
        ObjectHelper.verifyPositive(i11, "parallelism");
        ObjectHelper.verifyPositive(i12, "prefetch");
        return ParallelFlowable.from(this, i11, i12);
    }

    @CheckReturnValue
    @BackpressureSupport(BackpressureKind.FULL)
    @NonNull
    @SchedulerSupport("none")
    public final <R> Flowable<R> replay(Function<? super Flowable<T>, ? extends Publisher<R>> function, int i11) {
        ObjectHelper.requireNonNull(function, "selector is null");
        ObjectHelper.verifyPositive(i11, "bufferSize");
        return FlowableReplay.multicastSelector(FlowableInternalHelper.replayCallable(this, i11), function);
    }

    @CheckReturnValue
    @BackpressureSupport(BackpressureKind.FULL)
    @SchedulerSupport("none")
    public final Flowable<T> retry(long j11) {
        return retry(j11, Functions.alwaysTrue());
    }

    @CheckReturnValue
    @BackpressureSupport(BackpressureKind.FULL)
    @SchedulerSupport("custom")
    public final Flowable<T> skip(long j11, TimeUnit timeUnit, Scheduler scheduler) {
        return skipUntil(timer(j11, timeUnit, scheduler));
    }

    @CheckReturnValue
    @BackpressureSupport(BackpressureKind.UNBOUNDED_IN)
    @SchedulerSupport("none")
    public final Flowable<T> skipLast(long j11, TimeUnit timeUnit) {
        return skipLast(j11, timeUnit, Schedulers.computation(), false, bufferSize());
    }

    @CheckReturnValue
    @BackpressureSupport(BackpressureKind.FULL)
    @NonNull
    @SchedulerSupport("none")
    public final Flowable<T> startWith(T t11) {
        ObjectHelper.requireNonNull(t11, "value is null");
        return concatArray(just(t11), this);
    }

    @CheckReturnValue
    @BackpressureSupport(BackpressureKind.UNBOUNDED_IN)
    @SchedulerSupport("none")
    public final Disposable subscribe(Consumer<? super T> consumer, Consumer<? super Throwable> consumer2, Action action) {
        return subscribe(consumer, consumer2, action, FlowableInternalHelper.RequestMax.INSTANCE);
    }

    @CheckReturnValue
    @BackpressureSupport(BackpressureKind.PASS_THROUGH)
    @SchedulerSupport("custom")
    public final Flowable<T> take(long j11, TimeUnit timeUnit, Scheduler scheduler) {
        return takeUntil(timer(j11, timeUnit, scheduler));
    }

    @CheckReturnValue
    @BackpressureSupport(BackpressureKind.ERROR)
    @NonNull
    @SchedulerSupport("custom")
    public final Flowable<T> throttleLatest(long j11, TimeUnit timeUnit, Scheduler scheduler, boolean z11) {
        ObjectHelper.requireNonNull(timeUnit, "unit is null");
        ObjectHelper.requireNonNull(scheduler, "scheduler is null");
        return RxJavaPlugins.onAssembly(new FlowableThrottleLatest(this, j11, timeUnit, scheduler, z11));
    }

    @CheckReturnValue
    @BackpressureSupport(BackpressureKind.PASS_THROUGH)
    @SchedulerSupport("none")
    public final Flowable<Timed<T>> timeInterval(TimeUnit timeUnit, Scheduler scheduler) {
        ObjectHelper.requireNonNull(timeUnit, "unit is null");
        ObjectHelper.requireNonNull(scheduler, "scheduler is null");
        return RxJavaPlugins.onAssembly(new FlowableTimeInterval(this, timeUnit, scheduler));
    }

    @CheckReturnValue
    @BackpressureSupport(BackpressureKind.PASS_THROUGH)
    @SchedulerSupport("io.reactivex:computation")
    public final Flowable<T> timeout(long j11, TimeUnit timeUnit) {
        return timeout0(j11, timeUnit, (Publisher) null, Schedulers.computation());
    }

    @CheckReturnValue
    @BackpressureSupport(BackpressureKind.PASS_THROUGH)
    @NonNull
    @SchedulerSupport("none")
    public final Flowable<Timed<T>> timestamp(TimeUnit timeUnit, Scheduler scheduler) {
        ObjectHelper.requireNonNull(timeUnit, "unit is null");
        ObjectHelper.requireNonNull(scheduler, "scheduler is null");
        return map(Functions.timestampWith(timeUnit, scheduler));
    }

    @CheckReturnValue
    @BackpressureSupport(BackpressureKind.UNBOUNDED_IN)
    @SchedulerSupport("none")
    public final <U extends Collection<? super T>> Single<U> toList(Callable<U> callable) {
        ObjectHelper.requireNonNull(callable, "collectionSupplier is null");
        return RxJavaPlugins.onAssembly(new FlowableToListSingle(this, callable));
    }

    @CheckReturnValue
    @BackpressureSupport(BackpressureKind.UNBOUNDED_IN)
    @NonNull
    @SchedulerSupport("none")
    public final Single<List<T>> toSortedList(Comparator<? super T> comparator, int i11) {
        ObjectHelper.requireNonNull(comparator, "comparator is null");
        return toList(i11).map(Functions.listSorter(comparator));
    }

    @CheckReturnValue
    @BackpressureSupport(BackpressureKind.PASS_THROUGH)
    @NonNull
    @SchedulerSupport("none")
    public final <T1, T2, R> Flowable<R> withLatestFrom(Publisher<T1> publisher, Publisher<T2> publisher2, Function3<? super T, ? super T1, ? super T2, R> function3) {
        ObjectHelper.requireNonNull(publisher, "source1 is null");
        ObjectHelper.requireNonNull(publisher2, "source2 is null");
        return withLatestFrom((Publisher<?>[]) new Publisher[]{publisher, publisher2}, Functions.toFunction(function3));
    }

    @CheckReturnValue
    @BackpressureSupport(BackpressureKind.FULL)
    @NonNull
    @SchedulerSupport("none")
    public final <U, R> Flowable<R> zipWith(Publisher<? extends U> publisher, BiFunction<? super T, ? super U, ? extends R> biFunction) {
        ObjectHelper.requireNonNull(publisher, "other is null");
        return zip(this, publisher, biFunction);
    }

    @CheckReturnValue
    @BackpressureSupport(BackpressureKind.FULL)
    @NonNull
    @SchedulerSupport("none")
    public static <T> Flowable<T> concat(Publisher<? extends T> publisher, Publisher<? extends T> publisher2) {
        ObjectHelper.requireNonNull(publisher, "source1 is null");
        ObjectHelper.requireNonNull(publisher2, "source2 is null");
        return concatArray(publisher, publisher2);
    }

    @CheckReturnValue
    @BackpressureSupport(BackpressureKind.ERROR)
    @SchedulerSupport("io.reactivex:computation")
    public static Flowable<Long> interval(long j11, TimeUnit timeUnit) {
        return interval(j11, j11, timeUnit, Schedulers.computation());
    }

    @CheckReturnValue
    @BackpressureSupport(BackpressureKind.FULL)
    @SchedulerSupport("none")
    public static <T> Flowable<T> merge(Publisher<? extends Publisher<? extends T>> publisher, int i11) {
        return fromPublisher(publisher).flatMap(Functions.identity(), i11);
    }

    @CheckReturnValue
    @BackpressureSupport(BackpressureKind.FULL)
    @SchedulerSupport("none")
    public static <T> Flowable<T> mergeDelayError(Publisher<? extends Publisher<? extends T>> publisher, int i11) {
        return fromPublisher(publisher).flatMap(Functions.identity(), true, i11);
    }

    @CheckReturnValue
    @BackpressureSupport(BackpressureKind.UNBOUNDED_IN)
    @SchedulerSupport("none")
    public final T blockingFirst(T t11) {
        BlockingFirstSubscriber blockingFirstSubscriber = new BlockingFirstSubscriber();
        subscribe(blockingFirstSubscriber);
        T blockingGet = blockingFirstSubscriber.blockingGet();
        return blockingGet != null ? blockingGet : t11;
    }

    @CheckReturnValue
    @BackpressureSupport(BackpressureKind.UNBOUNDED_IN)
    @SchedulerSupport("none")
    public final T blockingLast(T t11) {
        BlockingLastSubscriber blockingLastSubscriber = new BlockingLastSubscriber();
        subscribe(blockingLastSubscriber);
        T blockingGet = blockingLastSubscriber.blockingGet();
        return blockingGet != null ? blockingGet : t11;
    }

    @BackpressureSupport(BackpressureKind.FULL)
    @SchedulerSupport("none")
    public final void blockingSubscribe(Consumer<? super T> consumer, Consumer<? super Throwable> consumer2, int i11) {
        FlowableBlockingSubscribe.subscribe(this, consumer, consumer2, Functions.EMPTY_ACTION, i11);
    }

    @CheckReturnValue
    @BackpressureSupport(BackpressureKind.FULL)
    @SchedulerSupport("none")
    public final Flowable<T> concatWith(@NonNull MaybeSource<? extends T> maybeSource) {
        ObjectHelper.requireNonNull(maybeSource, "other is null");
        return RxJavaPlugins.onAssembly(new FlowableConcatWithMaybe(this, maybeSource));
    }

    @CheckReturnValue
    @BackpressureSupport(BackpressureKind.FULL)
    @SchedulerSupport("custom")
    public final Flowable<T> delay(long j11, TimeUnit timeUnit, Scheduler scheduler) {
        return delay(j11, timeUnit, scheduler, false);
    }

    @CheckReturnValue
    @BackpressureSupport(BackpressureKind.FULL)
    @NonNull
    @SchedulerSupport("none")
    public final <R> Flowable<R> flatMap(Function<? super T, ? extends Publisher<? extends R>> function, boolean z11, int i11, int i12) {
        ObjectHelper.requireNonNull(function, "mapper is null");
        ObjectHelper.verifyPositive(i11, "maxConcurrency");
        ObjectHelper.verifyPositive(i12, "bufferSize");
        if (!(this instanceof ScalarCallable)) {
            return RxJavaPlugins.onAssembly(new FlowableFlatMap(this, function, z11, i11, i12));
        }
        Object call = ((ScalarCallable) this).call();
        if (call == null) {
            return empty();
        }
        return FlowableScalarXMap.scalarXMap(call, function);
    }

    @CheckReturnValue
    @BackpressureSupport(BackpressureKind.FULL)
    @NonNull
    @SchedulerSupport("none")
    public final <U, V> Flowable<V> flatMapIterable(Function<? super T, ? extends Iterable<? extends U>> function, BiFunction<? super T, ? super U, ? extends V> biFunction) {
        ObjectHelper.requireNonNull(function, "mapper is null");
        ObjectHelper.requireNonNull(biFunction, "resultSelector is null");
        return flatMap(FlowableInternalHelper.flatMapIntoIterable(function), biFunction, false, bufferSize(), bufferSize());
    }

    @CheckReturnValue
    @BackpressureSupport(BackpressureKind.FULL)
    @NonNull
    @SchedulerSupport("none")
    public final <K, V> Flowable<GroupedFlowable<K, V>> groupBy(Function<? super T, ? extends K> function, Function<? super T, ? extends V> function2, boolean z11, int i11) {
        ObjectHelper.requireNonNull(function, "keySelector is null");
        ObjectHelper.requireNonNull(function2, "valueSelector is null");
        ObjectHelper.verifyPositive(i11, "bufferSize");
        return RxJavaPlugins.onAssembly(new FlowableGroupBy(this, function, function2, i11, z11, (Function) null));
    }

    @CheckReturnValue
    @BackpressureSupport(BackpressureKind.FULL)
    @NonNull
    @SchedulerSupport("none")
    public final Flowable<T> mergeWith(@NonNull MaybeSource<? extends T> maybeSource) {
        ObjectHelper.requireNonNull(maybeSource, "other is null");
        return RxJavaPlugins.onAssembly(new FlowableMergeWithMaybe(this, maybeSource));
    }

    @CheckReturnValue
    @BackpressureSupport(BackpressureKind.SPECIAL)
    @SchedulerSupport("none")
    public final Flowable<T> onBackpressureBuffer(int i11, boolean z11, boolean z12) {
        ObjectHelper.verifyPositive(i11, "capacity");
        return RxJavaPlugins.onAssembly(new FlowableOnBackpressureBuffer(this, i11, z12, z11, Functions.EMPTY_ACTION));
    }

    @CheckReturnValue
    @BackpressureSupport(BackpressureKind.FULL)
    @NonNull
    @SchedulerSupport("none")
    public final Flowable<T> retry(long j11, Predicate<? super Throwable> predicate) {
        if (j11 >= 0) {
            ObjectHelper.requireNonNull(predicate, "predicate is null");
            return RxJavaPlugins.onAssembly(new FlowableRetryPredicate(this, j11, predicate));
        }
        throw new IllegalArgumentException("times >= 0 required but it was " + j11);
    }

    @CheckReturnValue
    @BackpressureSupport(BackpressureKind.UNBOUNDED_IN)
    @SchedulerSupport("none")
    public final Flowable<T> skipLast(long j11, TimeUnit timeUnit, boolean z11) {
        return skipLast(j11, timeUnit, Schedulers.computation(), z11, bufferSize());
    }

    @CheckReturnValue
    @BackpressureSupport(BackpressureKind.SPECIAL)
    @NonNull
    @SchedulerSupport("none")
    public final Disposable subscribe(Consumer<? super T> consumer, Consumer<? super Throwable> consumer2, Action action, Consumer<? super Subscription> consumer3) {
        ObjectHelper.requireNonNull(consumer, "onNext is null");
        ObjectHelper.requireNonNull(consumer2, "onError is null");
        ObjectHelper.requireNonNull(action, "onComplete is null");
        ObjectHelper.requireNonNull(consumer3, "onSubscribe is null");
        LambdaSubscriber lambdaSubscriber = new LambdaSubscriber(consumer, consumer2, action, consumer3);
        subscribe(lambdaSubscriber);
        return lambdaSubscriber;
    }

    @CheckReturnValue
    @BackpressureSupport(BackpressureKind.FULL)
    @SchedulerSupport("none")
    public final Flowable<T> takeLast(long j11, long j12, TimeUnit timeUnit) {
        return takeLast(j11, j12, timeUnit, Schedulers.computation(), false, bufferSize());
    }

    @CheckReturnValue
    @BackpressureSupport(BackpressureKind.FULL)
    @SchedulerSupport("none")
    public final TestSubscriber<T> test(long j11, boolean z11) {
        TestSubscriber<T> testSubscriber = new TestSubscriber<>(j11);
        if (z11) {
            testSubscriber.cancel();
        }
        subscribe(testSubscriber);
        return testSubscriber;
    }

    @CheckReturnValue
    @BackpressureSupport(BackpressureKind.FULL)
    @NonNull
    @SchedulerSupport("io.reactivex:computation")
    public final Flowable<T> timeout(long j11, TimeUnit timeUnit, Publisher<? extends T> publisher) {
        ObjectHelper.requireNonNull(publisher, "other is null");
        return timeout0(j11, timeUnit, publisher, Schedulers.computation());
    }

    @CheckReturnValue
    @BackpressureSupport(BackpressureKind.UNBOUNDED_IN)
    @SchedulerSupport("none")
    public final <K, V> Single<Map<K, Collection<V>>> toMultimap(Function<? super T, ? extends K> function, Function<? super T, ? extends V> function2) {
        return toMultimap(function, function2, HashMapSupplier.asCallable(), ArrayListSupplier.asFunction());
    }

    @CheckReturnValue
    @BackpressureSupport(BackpressureKind.FULL)
    @SchedulerSupport("none")
    public static <T> Flowable<T> concatEager(Iterable<? extends Publisher<? extends T>> iterable) {
        return concatEager(iterable, bufferSize(), bufferSize());
    }

    @CheckReturnValue
    @BackpressureSupport(BackpressureKind.FULL)
    @NonNull
    @SchedulerSupport("custom")
    public static <T> Flowable<T> fromFuture(Future<? extends T> future, long j11, TimeUnit timeUnit, Scheduler scheduler) {
        ObjectHelper.requireNonNull(scheduler, "scheduler is null");
        return fromFuture(future, j11, timeUnit).subscribeOn(scheduler);
    }

    @CheckReturnValue
    @BackpressureSupport(BackpressureKind.FULL)
    @NonNull
    @SchedulerSupport("none")
    public static <T, S> Flowable<T> generate(Callable<S> callable, BiConsumer<S, Emitter<T>> biConsumer) {
        ObjectHelper.requireNonNull(biConsumer, "generator is null");
        return generate(callable, FlowableInternalHelper.simpleBiGenerator(biConsumer), Functions.emptyConsumer());
    }

    @CheckReturnValue
    @BackpressureSupport(BackpressureKind.ERROR)
    @SchedulerSupport("custom")
    public static Flowable<Long> interval(long j11, TimeUnit timeUnit, Scheduler scheduler) {
        return interval(j11, j11, timeUnit, scheduler);
    }

    @CheckReturnValue
    @BackpressureSupport(BackpressureKind.FULL)
    @NonNull
    @SchedulerSupport("none")
    public static <T> Flowable<T> just(T t11, T t12, T t13) {
        ObjectHelper.requireNonNull(t11, "item1 is null");
        ObjectHelper.requireNonNull(t12, "item2 is null");
        ObjectHelper.requireNonNull(t13, "item3 is null");
        return fromArray(t11, t12, t13);
    }

    @CheckReturnValue
    @BackpressureSupport(BackpressureKind.FULL)
    @NonNull
    @SchedulerSupport("none")
    public static <T> Flowable<T> merge(Publisher<? extends T> publisher, Publisher<? extends T> publisher2) {
        ObjectHelper.requireNonNull(publisher, "source1 is null");
        ObjectHelper.requireNonNull(publisher2, "source2 is null");
        return fromArray(publisher, publisher2).flatMap(Functions.identity(), false, 2);
    }

    @CheckReturnValue
    @BackpressureSupport(BackpressureKind.FULL)
    @NonNull
    @SchedulerSupport("none")
    public static <T> Flowable<T> mergeDelayError(Publisher<? extends T> publisher, Publisher<? extends T> publisher2) {
        ObjectHelper.requireNonNull(publisher, "source1 is null");
        ObjectHelper.requireNonNull(publisher2, "source2 is null");
        return fromArray(publisher, publisher2).flatMap(Functions.identity(), true, 2);
    }

    @CheckReturnValue
    @BackpressureSupport(BackpressureKind.FULL)
    @NonNull
    @SchedulerSupport("none")
    public static <T1, T2, R> Flowable<R> zip(Publisher<? extends T1> publisher, Publisher<? extends T2> publisher2, BiFunction<? super T1, ? super T2, ? extends R> biFunction) {
        ObjectHelper.requireNonNull(publisher, "source1 is null");
        ObjectHelper.requireNonNull(publisher2, "source2 is null");
        return zipArray(Functions.toFunction(biFunction), false, bufferSize(), publisher, publisher2);
    }

    @BackpressureSupport(BackpressureKind.UNBOUNDED_IN)
    @SchedulerSupport("none")
    public final void blockingSubscribe(Consumer<? super T> consumer, Consumer<? super Throwable> consumer2, Action action) {
        FlowableBlockingSubscribe.subscribe(this, consumer, consumer2, action);
    }

    @CheckReturnValue
    @BackpressureSupport(BackpressureKind.FULL)
    @NonNull
    @SchedulerSupport("custom")
    public final Flowable<T> delay(long j11, TimeUnit timeUnit, Scheduler scheduler, boolean z11) {
        ObjectHelper.requireNonNull(timeUnit, "unit is null");
        ObjectHelper.requireNonNull(scheduler, "scheduler is null");
        return RxJavaPlugins.onAssembly(new FlowableDelay(this, Math.max(0, j11), timeUnit, scheduler, z11));
    }

    @CheckReturnValue
    @BackpressureSupport(BackpressureKind.PASS_THROUGH)
    @NonNull
    @SchedulerSupport("none")
    public final Flowable<T> doOnEach(Consumer<? super Notification<T>> consumer) {
        ObjectHelper.requireNonNull(consumer, "onNotification is null");
        return doOnEach(Functions.notificationOnNext(consumer), Functions.notificationOnError(consumer), Functions.notificationOnComplete(consumer), Functions.EMPTY_ACTION);
    }

    @CheckReturnValue
    @BackpressureSupport(BackpressureKind.FULL)
    @SchedulerSupport("none")
    public final ConnectableFlowable<T> publish(int i11) {
        ObjectHelper.verifyPositive(i11, "bufferSize");
        return FlowablePublish.create(this, i11);
    }

    @CheckReturnValue
    @BackpressureSupport(BackpressureKind.ERROR)
    @NonNull
    @SchedulerSupport("custom")
    public final Flowable<T> sample(long j11, TimeUnit timeUnit, Scheduler scheduler, boolean z11) {
        ObjectHelper.requireNonNull(timeUnit, "unit is null");
        ObjectHelper.requireNonNull(scheduler, "scheduler is null");
        return RxJavaPlugins.onAssembly(new FlowableSampleTimed(this, j11, timeUnit, scheduler, z11));
    }

    @CheckReturnValue
    @BackpressureSupport(BackpressureKind.UNBOUNDED_IN)
    @SchedulerSupport("custom")
    public final Flowable<T> skipLast(long j11, TimeUnit timeUnit, Scheduler scheduler) {
        return skipLast(j11, timeUnit, scheduler, false, bufferSize());
    }

    @CheckReturnValue
    @BackpressureSupport(BackpressureKind.FULL)
    @SchedulerSupport("custom")
    public final Flowable<T> takeLast(long j11, long j12, TimeUnit timeUnit, Scheduler scheduler) {
        return takeLast(j11, j12, timeUnit, scheduler, false, bufferSize());
    }

    @CheckReturnValue
    @BackpressureSupport(BackpressureKind.UNBOUNDED_IN)
    @NonNull
    @SchedulerSupport("none")
    public final <K, V> Single<Map<K, V>> toMap(Function<? super T, ? extends K> function, Function<? super T, ? extends V> function2, Callable<? extends Map<K, V>> callable) {
        ObjectHelper.requireNonNull(function, "keySelector is null");
        ObjectHelper.requireNonNull(function2, "valueSelector is null");
        return collect(callable, Functions.toMapKeyValueSelector(function, function2));
    }

    @CheckReturnValue
    @BackpressureSupport(BackpressureKind.UNBOUNDED_IN)
    @SchedulerSupport("none")
    public final Single<List<T>> toSortedList(int i11) {
        return toSortedList(Functions.naturalComparator(), i11);
    }

    @CheckReturnValue
    @BackpressureSupport(BackpressureKind.FULL)
    @SchedulerSupport("none")
    public final <U, R> Flowable<R> zipWith(Publisher<? extends U> publisher, BiFunction<? super T, ? super U, ? extends R> biFunction, boolean z11) {
        return zip(this, publisher, biFunction, z11);
    }

    @CheckReturnValue
    @BackpressureSupport(BackpressureKind.FULL)
    @NonNull
    @SchedulerSupport("none")
    public static <T> Flowable<T> concatEager(Iterable<? extends Publisher<? extends T>> iterable, int i11, int i12) {
        ObjectHelper.requireNonNull(iterable, "sources is null");
        ObjectHelper.verifyPositive(i11, "maxConcurrency");
        ObjectHelper.verifyPositive(i12, "prefetch");
        return RxJavaPlugins.onAssembly(new FlowableConcatMapEager(new FlowableFromIterable(iterable), Functions.identity(), i11, i12, ErrorMode.IMMEDIATE));
    }

    @BackpressureSupport(BackpressureKind.FULL)
    @SchedulerSupport("none")
    public final void blockingSubscribe(Consumer<? super T> consumer, Consumer<? super Throwable> consumer2, Action action, int i11) {
        FlowableBlockingSubscribe.subscribe(this, consumer, consumer2, action, i11);
    }

    @CheckReturnValue
    @BackpressureSupport(BackpressureKind.FULL)
    @SchedulerSupport("none")
    public final <U extends Collection<? super T>> Flowable<U> buffer(int i11, Callable<U> callable) {
        return buffer(i11, i11, callable);
    }

    @CheckReturnValue
    @BackpressureSupport(BackpressureKind.PASS_THROUGH)
    @SchedulerSupport("none")
    public final Flowable<T> concatWith(@NonNull CompletableSource completableSource) {
        ObjectHelper.requireNonNull(completableSource, "other is null");
        return RxJavaPlugins.onAssembly(new FlowableConcatWithCompletable(this, completableSource));
    }

    @CheckReturnValue
    @BackpressureSupport(BackpressureKind.PASS_THROUGH)
    @NonNull
    @SchedulerSupport("none")
    public final Flowable<T> mergeWith(@NonNull CompletableSource completableSource) {
        ObjectHelper.requireNonNull(completableSource, "other is null");
        return RxJavaPlugins.onAssembly(new FlowableMergeWithCompletable(this, completableSource));
    }

    @CheckReturnValue
    @BackpressureSupport(BackpressureKind.SPECIAL)
    @NonNull
    @SchedulerSupport("none")
    public final Flowable<T> onBackpressureBuffer(int i11, boolean z11, boolean z12, Action action) {
        ObjectHelper.requireNonNull(action, "onOverflow is null");
        ObjectHelper.verifyPositive(i11, "capacity");
        return RxJavaPlugins.onAssembly(new FlowableOnBackpressureBuffer(this, i11, z12, z11, action));
    }

    @CheckReturnValue
    @BackpressureSupport(BackpressureKind.FULL)
    @SchedulerSupport("io.reactivex:computation")
    public final <R> Flowable<R> replay(Function<? super Flowable<T>, ? extends Publisher<R>> function, int i11, long j11, TimeUnit timeUnit) {
        return replay(function, i11, j11, timeUnit, Schedulers.computation());
    }

    @CheckReturnValue
    @BackpressureSupport(BackpressureKind.UNBOUNDED_IN)
    @SchedulerSupport("custom")
    public final Flowable<T> skipLast(long j11, TimeUnit timeUnit, Scheduler scheduler, boolean z11) {
        return skipLast(j11, timeUnit, scheduler, z11, bufferSize());
    }

    @CheckReturnValue
    @BackpressureSupport(BackpressureKind.FULL)
    @NonNull
    @SchedulerSupport("custom")
    public final Flowable<T> takeLast(long j11, long j12, TimeUnit timeUnit, Scheduler scheduler, boolean z11, int i11) {
        ObjectHelper.requireNonNull(timeUnit, "unit is null");
        ObjectHelper.requireNonNull(scheduler, "scheduler is null");
        ObjectHelper.verifyPositive(i11, "bufferSize");
        if (j11 >= 0) {
            return RxJavaPlugins.onAssembly(new FlowableTakeLastTimed(this, j11, j12, timeUnit, scheduler, i11, z11));
        }
        throw new IndexOutOfBoundsException("count >= 0 required but it was " + j11);
    }

    @CheckReturnValue
    @BackpressureSupport(BackpressureKind.FULL)
    @NonNull
    @SchedulerSupport("custom")
    public final Flowable<T> timeout(long j11, TimeUnit timeUnit, Scheduler scheduler, Publisher<? extends T> publisher) {
        ObjectHelper.requireNonNull(publisher, "other is null");
        return timeout0(j11, timeUnit, publisher, scheduler);
    }

    @CheckReturnValue
    @BackpressureSupport(BackpressureKind.ERROR)
    @SchedulerSupport("io.reactivex:computation")
    public final Flowable<Flowable<T>> window(long j11, long j12, TimeUnit timeUnit) {
        return window(j11, j12, timeUnit, Schedulers.computation(), bufferSize());
    }

    @CheckReturnValue
    @BackpressureSupport(BackpressureKind.FULL)
    @SchedulerSupport("none")
    public final <U, R> Flowable<R> zipWith(Publisher<? extends U> publisher, BiFunction<? super T, ? super U, ? extends R> biFunction, boolean z11, int i11) {
        return zip(this, publisher, biFunction, z11, i11);
    }

    @CheckReturnValue
    @BackpressureSupport(BackpressureKind.FULL)
    @NonNull
    @SchedulerSupport("none")
    public static <T> Flowable<T> concat(Publisher<? extends T> publisher, Publisher<? extends T> publisher2, Publisher<? extends T> publisher3) {
        ObjectHelper.requireNonNull(publisher, "source1 is null");
        ObjectHelper.requireNonNull(publisher2, "source2 is null");
        ObjectHelper.requireNonNull(publisher3, "source3 is null");
        return concatArray(publisher, publisher2, publisher3);
    }

    @CheckReturnValue
    @BackpressureSupport(BackpressureKind.FULL)
    @NonNull
    @SchedulerSupport("custom")
    public static <T> Flowable<T> fromFuture(Future<? extends T> future, Scheduler scheduler) {
        ObjectHelper.requireNonNull(scheduler, "scheduler is null");
        return fromFuture(future).subscribeOn(scheduler);
    }

    @CheckReturnValue
    @BackpressureSupport(BackpressureKind.FULL)
    @SchedulerSupport("none")
    public static <T> Single<Boolean> sequenceEqual(Publisher<? extends T> publisher, Publisher<? extends T> publisher2, int i11) {
        return sequenceEqual(publisher, publisher2, ObjectHelper.equalsPredicate(), i11);
    }

    @BackpressureSupport(BackpressureKind.SPECIAL)
    @SchedulerSupport("none")
    public final void blockingSubscribe(Subscriber<? super T> subscriber) {
        FlowableBlockingSubscribe.subscribe(this, subscriber);
    }

    @CheckReturnValue
    @BackpressureSupport(BackpressureKind.ERROR)
    @SchedulerSupport("io.reactivex:computation")
    public final Flowable<List<T>> buffer(long j11, long j12, TimeUnit timeUnit) {
        return buffer(j11, j12, timeUnit, Schedulers.computation(), ArrayListSupplier.asCallable());
    }

    @CheckReturnValue
    @BackpressureSupport(BackpressureKind.FULL)
    @NonNull
    @SchedulerSupport("none")
    public final <U, V> Flowable<V> flatMapIterable(Function<? super T, ? extends Iterable<? extends U>> function, BiFunction<? super T, ? super U, ? extends V> biFunction, int i11) {
        ObjectHelper.requireNonNull(function, "mapper is null");
        ObjectHelper.requireNonNull(biFunction, "resultSelector is null");
        return flatMap(FlowableInternalHelper.flatMapIntoIterable(function), biFunction, false, bufferSize(), i11);
    }

    @CheckReturnValue
    @BackpressureSupport(BackpressureKind.FULL)
    @NonNull
    @SchedulerSupport("custom")
    public final <R> Flowable<R> replay(Function<? super Flowable<T>, ? extends Publisher<R>> function, int i11, long j11, TimeUnit timeUnit, Scheduler scheduler) {
        ObjectHelper.requireNonNull(function, "selector is null");
        ObjectHelper.requireNonNull(timeUnit, "unit is null");
        ObjectHelper.verifyPositive(i11, "bufferSize");
        ObjectHelper.requireNonNull(scheduler, "scheduler is null");
        return FlowableReplay.multicastSelector(FlowableInternalHelper.replayCallable(this, i11, j11, timeUnit, scheduler), function);
    }

    @CheckReturnValue
    @BackpressureSupport(BackpressureKind.FULL)
    @SchedulerSupport("none")
    public final Flowable<T> retry(Predicate<? super Throwable> predicate) {
        return retry(Long.MAX_VALUE, predicate);
    }

    @CheckReturnValue
    @BackpressureSupport(BackpressureKind.UNBOUNDED_IN)
    @NonNull
    @SchedulerSupport("custom")
    public final Flowable<T> skipLast(long j11, TimeUnit timeUnit, Scheduler scheduler, boolean z11, int i11) {
        ObjectHelper.requireNonNull(timeUnit, "unit is null");
        ObjectHelper.requireNonNull(scheduler, "scheduler is null");
        ObjectHelper.verifyPositive(i11, "bufferSize");
        return RxJavaPlugins.onAssembly(new FlowableSkipLastTimed(this, j11, timeUnit, scheduler, i11 << 1, z11));
    }

    @CheckReturnValue
    @BackpressureSupport(BackpressureKind.UNBOUNDED_IN)
    @NonNull
    @SchedulerSupport("none")
    public final <K, V> Single<Map<K, Collection<V>>> toMultimap(Function<? super T, ? extends K> function, Function<? super T, ? extends V> function2, Callable<? extends Map<K, Collection<V>>> callable, Function<? super K, ? extends Collection<? super V>> function3) {
        ObjectHelper.requireNonNull(function, "keySelector is null");
        ObjectHelper.requireNonNull(function2, "valueSelector is null");
        ObjectHelper.requireNonNull(callable, "mapSupplier is null");
        ObjectHelper.requireNonNull(function3, "collectionFactory is null");
        return collect(callable, Functions.toMultimapKeyValueSelector(function, function2, function3));
    }

    @CheckReturnValue
    @BackpressureSupport(BackpressureKind.ERROR)
    @SchedulerSupport("custom")
    public final Flowable<Flowable<T>> window(long j11, long j12, TimeUnit timeUnit, Scheduler scheduler) {
        return window(j11, j12, timeUnit, scheduler, bufferSize());
    }

    @CheckReturnValue
    @BackpressureSupport(BackpressureKind.PASS_THROUGH)
    @NonNull
    @SchedulerSupport("none")
    public final <T1, T2, T3, R> Flowable<R> withLatestFrom(Publisher<T1> publisher, Publisher<T2> publisher2, Publisher<T3> publisher3, Function4<? super T, ? super T1, ? super T2, ? super T3, R> function4) {
        ObjectHelper.requireNonNull(publisher, "source1 is null");
        ObjectHelper.requireNonNull(publisher2, "source2 is null");
        ObjectHelper.requireNonNull(publisher3, "source3 is null");
        return withLatestFrom((Publisher<?>[]) new Publisher[]{publisher, publisher2, publisher3}, Functions.toFunction(function4));
    }

    @CheckReturnValue
    @BackpressureSupport(BackpressureKind.FULL)
    @SchedulerSupport("none")
    public static <T, R> Flowable<R> combineLatest(Iterable<? extends Publisher<? extends T>> iterable, Function<? super Object[], ? extends R> function) {
        return combineLatest(iterable, function, bufferSize());
    }

    @CheckReturnValue
    @BackpressureSupport(BackpressureKind.FULL)
    @NonNull
    @SchedulerSupport("none")
    public static <T> Flowable<T> merge(Publisher<? extends T> publisher, Publisher<? extends T> publisher2, Publisher<? extends T> publisher3) {
        ObjectHelper.requireNonNull(publisher, "source1 is null");
        ObjectHelper.requireNonNull(publisher2, "source2 is null");
        ObjectHelper.requireNonNull(publisher3, "source3 is null");
        return fromArray(publisher, publisher2, publisher3).flatMap(Functions.identity(), false, 3);
    }

    @CheckReturnValue
    @BackpressureSupport(BackpressureKind.FULL)
    @NonNull
    @SchedulerSupport("none")
    public static <T> Flowable<T> mergeDelayError(Publisher<? extends T> publisher, Publisher<? extends T> publisher2, Publisher<? extends T> publisher3) {
        ObjectHelper.requireNonNull(publisher, "source1 is null");
        ObjectHelper.requireNonNull(publisher2, "source2 is null");
        ObjectHelper.requireNonNull(publisher3, "source3 is null");
        return fromArray(publisher, publisher2, publisher3).flatMap(Functions.identity(), true, 3);
    }

    @CheckReturnValue
    @BackpressureSupport(BackpressureKind.FULL)
    @NonNull
    @SchedulerSupport("none")
    public static <T1, T2, R> Flowable<R> zip(Publisher<? extends T1> publisher, Publisher<? extends T2> publisher2, BiFunction<? super T1, ? super T2, ? extends R> biFunction, boolean z11) {
        ObjectHelper.requireNonNull(publisher, "source1 is null");
        ObjectHelper.requireNonNull(publisher2, "source2 is null");
        return zipArray(Functions.toFunction(biFunction), z11, bufferSize(), publisher, publisher2);
    }

    @CheckReturnValue
    @BackpressureSupport(BackpressureKind.ERROR)
    @SchedulerSupport("custom")
    public final Flowable<List<T>> buffer(long j11, long j12, TimeUnit timeUnit, Scheduler scheduler) {
        return buffer(j11, j12, timeUnit, scheduler, ArrayListSupplier.asCallable());
    }

    /* JADX WARNING: type inference failed for: r2v0, types: [io.reactivex.functions.Function, io.reactivex.functions.Function<? super T, ? extends org.reactivestreams.Publisher<V>>] */
    /* JADX WARNING: Unknown variable types count: 1 */
    @io.reactivex.annotations.CheckReturnValue
    @io.reactivex.annotations.BackpressureSupport(io.reactivex.annotations.BackpressureKind.FULL)
    @io.reactivex.annotations.SchedulerSupport("none")
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final <U, V> io.reactivex.Flowable<T> delay(org.reactivestreams.Publisher<U> r1, io.reactivex.functions.Function<? super T, ? extends org.reactivestreams.Publisher<V>> r2) {
        /*
            r0 = this;
            io.reactivex.Flowable r1 = r0.delaySubscription(r1)
            io.reactivex.Flowable r1 = r1.delay(r2)
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: io.reactivex.Flowable.delay(org.reactivestreams.Publisher, io.reactivex.functions.Function):io.reactivex.Flowable");
    }

    @CheckReturnValue
    @BackpressureSupport(BackpressureKind.FULL)
    @NonNull
    @SchedulerSupport("none")
    public final <K, V> Flowable<GroupedFlowable<K, V>> groupBy(Function<? super T, ? extends K> function, Function<? super T, ? extends V> function2, boolean z11, int i11, Function<? super Consumer<Object>, ? extends Map<K, Object>> function3) {
        ObjectHelper.requireNonNull(function, "keySelector is null");
        ObjectHelper.requireNonNull(function2, "valueSelector is null");
        ObjectHelper.verifyPositive(i11, "bufferSize");
        ObjectHelper.requireNonNull(function3, "evictingMapFactory is null");
        return RxJavaPlugins.onAssembly(new FlowableGroupBy(this, function, function2, i11, z11, function3));
    }

    @CheckReturnValue
    @BackpressureSupport(BackpressureKind.ERROR)
    @NonNull
    @SchedulerSupport("none")
    public final <U> Flowable<T> sample(Publisher<U> publisher) {
        ObjectHelper.requireNonNull(publisher, "sampler is null");
        return RxJavaPlugins.onAssembly(new FlowableSamplePublisher(this, publisher, false));
    }

    @CheckReturnValue
    @BackpressureSupport(BackpressureKind.PASS_THROUGH)
    @SchedulerSupport("custom")
    public final Flowable<T> timeout(long j11, TimeUnit timeUnit, Scheduler scheduler) {
        return timeout0(j11, timeUnit, (Publisher) null, scheduler);
    }

    @CheckReturnValue
    @BackpressureSupport(BackpressureKind.ERROR)
    @NonNull
    @SchedulerSupport("custom")
    public final Flowable<Flowable<T>> window(long j11, long j12, TimeUnit timeUnit, Scheduler scheduler, int i11) {
        int i12 = i11;
        ObjectHelper.verifyPositive(i12, "bufferSize");
        ObjectHelper.verifyPositive(j11, "timespan");
        long j13 = j12;
        ObjectHelper.verifyPositive(j13, "timeskip");
        Scheduler scheduler2 = scheduler;
        ObjectHelper.requireNonNull(scheduler2, "scheduler is null");
        TimeUnit timeUnit2 = timeUnit;
        ObjectHelper.requireNonNull(timeUnit2, "unit is null");
        return RxJavaPlugins.onAssembly(new FlowableWindowTimed(this, j11, j13, timeUnit2, scheduler2, Long.MAX_VALUE, i12, false));
    }

    @CheckReturnValue
    @BackpressureSupport(BackpressureKind.FULL)
    @NonNull
    @SchedulerSupport("none")
    public static <T, R> Flowable<R> combineLatest(Iterable<? extends Publisher<? extends T>> iterable, Function<? super Object[], ? extends R> function, int i11) {
        ObjectHelper.requireNonNull(iterable, "sources is null");
        ObjectHelper.requireNonNull(function, "combiner is null");
        ObjectHelper.verifyPositive(i11, "bufferSize");
        return RxJavaPlugins.onAssembly(new FlowableCombineLatest(iterable, function, i11, false));
    }

    @CheckReturnValue
    @BackpressureSupport(BackpressureKind.FULL)
    @SchedulerSupport("none")
    public static <T, R> Flowable<R> combineLatestDelayError(Iterable<? extends Publisher<? extends T>> iterable, Function<? super Object[], ? extends R> function) {
        return combineLatestDelayError(iterable, function, bufferSize());
    }

    @CheckReturnValue
    @BackpressureSupport(BackpressureKind.FULL)
    @NonNull
    @SchedulerSupport("none")
    public static <T, S> Flowable<T> generate(Callable<S> callable, BiConsumer<S, Emitter<T>> biConsumer, Consumer<? super S> consumer) {
        ObjectHelper.requireNonNull(biConsumer, "generator is null");
        return generate(callable, FlowableInternalHelper.simpleBiGenerator(biConsumer), consumer);
    }

    @CheckReturnValue
    @BackpressureSupport(BackpressureKind.FULL)
    @NonNull
    @SchedulerSupport("none")
    public static <T> Flowable<T> just(T t11, T t12, T t13, T t14) {
        ObjectHelper.requireNonNull(t11, "item1 is null");
        ObjectHelper.requireNonNull(t12, "item2 is null");
        ObjectHelper.requireNonNull(t13, "item3 is null");
        ObjectHelper.requireNonNull(t14, "item4 is null");
        return fromArray(t11, t12, t13, t14);
    }

    @CheckReturnValue
    @BackpressureSupport(BackpressureKind.ERROR)
    @NonNull
    @SchedulerSupport("custom")
    public final <U extends Collection<? super T>> Flowable<U> buffer(long j11, long j12, TimeUnit timeUnit, Scheduler scheduler, Callable<U> callable) {
        TimeUnit timeUnit2 = timeUnit;
        ObjectHelper.requireNonNull(timeUnit2, "unit is null");
        Scheduler scheduler2 = scheduler;
        ObjectHelper.requireNonNull(scheduler2, "scheduler is null");
        Callable<U> callable2 = callable;
        ObjectHelper.requireNonNull(callable2, "bufferSupplier is null");
        return RxJavaPlugins.onAssembly(new FlowableBufferTimed(this, j11, j12, timeUnit2, scheduler2, callable2, Integer.MAX_VALUE, false));
    }

    @CheckReturnValue
    @BackpressureSupport(BackpressureKind.ERROR)
    @SchedulerSupport("none")
    public final Flowable<T> onBackpressureBuffer(int i11, Action action) {
        return onBackpressureBuffer(i11, false, false, action);
    }

    @CheckReturnValue
    @BackpressureSupport(BackpressureKind.PASS_THROUGH)
    @NonNull
    @SchedulerSupport("none")
    public final <U, V> Flowable<T> timeout(Publisher<U> publisher, Function<? super T, ? extends Publisher<V>> function) {
        ObjectHelper.requireNonNull(publisher, "firstTimeoutIndicator is null");
        return timeout0(publisher, function, (Publisher) null);
    }

    @CheckReturnValue
    @BackpressureSupport(BackpressureKind.FULL)
    @SchedulerSupport("none")
    public static <T, R> Flowable<R> combineLatestDelayError(Iterable<? extends Publisher<? extends T>> iterable, Function<? super Object[], ? extends R> function, int i11) {
        ObjectHelper.requireNonNull(iterable, "sources is null");
        ObjectHelper.requireNonNull(function, "combiner is null");
        ObjectHelper.verifyPositive(i11, "bufferSize");
        return RxJavaPlugins.onAssembly(new FlowableCombineLatest(iterable, function, i11, true));
    }

    @CheckReturnValue
    @BackpressureSupport(BackpressureKind.PASS_THROUGH)
    @NonNull
    @SchedulerSupport("none")
    public final Flowable<T> doOnEach(Subscriber<? super T> subscriber) {
        ObjectHelper.requireNonNull(subscriber, "subscriber is null");
        return doOnEach(FlowableInternalHelper.subscriberOnNext(subscriber), FlowableInternalHelper.subscriberOnError(subscriber), FlowableInternalHelper.subscriberOnComplete(subscriber), Functions.EMPTY_ACTION);
    }

    @CheckReturnValue
    @BackpressureSupport(BackpressureKind.SPECIAL)
    @NonNull
    @SchedulerSupport("none")
    public final Flowable<T> onBackpressureBuffer(long j11, Action action, BackpressureOverflowStrategy backpressureOverflowStrategy) {
        ObjectHelper.requireNonNull(backpressureOverflowStrategy, "overflowStrategy is null");
        ObjectHelper.verifyPositive(j11, "capacity");
        return RxJavaPlugins.onAssembly(new FlowableOnBackpressureBufferStrategy(this, j11, action, backpressureOverflowStrategy));
    }

    @CheckReturnValue
    @BackpressureSupport(BackpressureKind.ERROR)
    @NonNull
    @SchedulerSupport("none")
    public final <U> Flowable<T> sample(Publisher<U> publisher, boolean z11) {
        ObjectHelper.requireNonNull(publisher, "sampler is null");
        return RxJavaPlugins.onAssembly(new FlowableSamplePublisher(this, publisher, z11));
    }

    @BackpressureSupport(BackpressureKind.SPECIAL)
    @SchedulerSupport("none")
    public final void subscribe(Subscriber<? super T> subscriber) {
        if (subscriber instanceof FlowableSubscriber) {
            subscribe((FlowableSubscriber) subscriber);
            return;
        }
        ObjectHelper.requireNonNull(subscriber, "s is null");
        subscribe(new StrictSubscriber(subscriber));
    }

    @CheckReturnValue
    @BackpressureSupport(BackpressureKind.FULL)
    @NonNull
    @SchedulerSupport("none")
    public static <T> Flowable<T> concat(Publisher<? extends T> publisher, Publisher<? extends T> publisher2, Publisher<? extends T> publisher3, Publisher<? extends T> publisher4) {
        ObjectHelper.requireNonNull(publisher, "source1 is null");
        ObjectHelper.requireNonNull(publisher2, "source2 is null");
        ObjectHelper.requireNonNull(publisher3, "source3 is null");
        ObjectHelper.requireNonNull(publisher4, "source4 is null");
        return concatArray(publisher, publisher2, publisher3, publisher4);
    }

    @CheckReturnValue
    @BackpressureSupport(BackpressureKind.FULL)
    @SchedulerSupport("none")
    public static <T, S> Flowable<T> generate(Callable<S> callable, BiFunction<S, Emitter<T>, S> biFunction) {
        return generate(callable, biFunction, Functions.emptyConsumer());
    }

    @CheckReturnValue
    @BackpressureSupport(BackpressureKind.FULL)
    @NonNull
    @SchedulerSupport("none")
    public static <T1, T2, R> Flowable<R> zip(Publisher<? extends T1> publisher, Publisher<? extends T2> publisher2, BiFunction<? super T1, ? super T2, ? extends R> biFunction, boolean z11, int i11) {
        ObjectHelper.requireNonNull(publisher, "source1 is null");
        ObjectHelper.requireNonNull(publisher2, "source2 is null");
        return zipArray(Functions.toFunction(biFunction), z11, i11, publisher, publisher2);
    }

    @CheckReturnValue
    @BackpressureSupport(BackpressureKind.FULL)
    @SchedulerSupport("io.reactivex:computation")
    public final Flowable<T> takeLast(long j11, TimeUnit timeUnit) {
        return takeLast(j11, timeUnit, Schedulers.computation(), false, bufferSize());
    }

    @CheckReturnValue
    @BackpressureSupport(BackpressureKind.FULL)
    @NonNull
    @SchedulerSupport("none")
    public final <U, V> Flowable<T> timeout(Publisher<U> publisher, Function<? super T, ? extends Publisher<V>> function, Publisher<? extends T> publisher2) {
        ObjectHelper.requireNonNull(publisher, "firstTimeoutSelector is null");
        ObjectHelper.requireNonNull(publisher2, "other is null");
        return timeout0(publisher, function, publisher2);
    }

    @CheckReturnValue
    @BackpressureSupport(BackpressureKind.FULL)
    @NonNull
    @SchedulerSupport("none")
    public static <T, S> Flowable<T> generate(Callable<S> callable, BiFunction<S, Emitter<T>, S> biFunction, Consumer<? super S> consumer) {
        ObjectHelper.requireNonNull(callable, "initialState is null");
        ObjectHelper.requireNonNull(biFunction, "generator is null");
        ObjectHelper.requireNonNull(consumer, "disposeState is null");
        return RxJavaPlugins.onAssembly(new FlowableGenerate(callable, biFunction, consumer));
    }

    @CheckReturnValue
    @BackpressureSupport(BackpressureKind.FULL)
    @NonNull
    @SchedulerSupport("none")
    public static <T> Flowable<T> merge(Publisher<? extends T> publisher, Publisher<? extends T> publisher2, Publisher<? extends T> publisher3, Publisher<? extends T> publisher4) {
        ObjectHelper.requireNonNull(publisher, "source1 is null");
        ObjectHelper.requireNonNull(publisher2, "source2 is null");
        ObjectHelper.requireNonNull(publisher3, "source3 is null");
        ObjectHelper.requireNonNull(publisher4, "source4 is null");
        return fromArray(publisher, publisher2, publisher3, publisher4).flatMap(Functions.identity(), false, 4);
    }

    @CheckReturnValue
    @BackpressureSupport(BackpressureKind.FULL)
    @NonNull
    @SchedulerSupport("none")
    public static <T> Flowable<T> mergeDelayError(Publisher<? extends T> publisher, Publisher<? extends T> publisher2, Publisher<? extends T> publisher3, Publisher<? extends T> publisher4) {
        ObjectHelper.requireNonNull(publisher, "source1 is null");
        ObjectHelper.requireNonNull(publisher2, "source2 is null");
        ObjectHelper.requireNonNull(publisher3, "source3 is null");
        ObjectHelper.requireNonNull(publisher4, "source4 is null");
        return fromArray(publisher, publisher2, publisher3, publisher4).flatMap(Functions.identity(), true, 4);
    }

    @CheckReturnValue
    @BackpressureSupport(BackpressureKind.FULL)
    @NonNull
    @SchedulerSupport("none")
    public final <R> Flowable<R> flatMap(Function<? super T, ? extends Publisher<? extends R>> function, Function<? super Throwable, ? extends Publisher<? extends R>> function2, Callable<? extends Publisher<? extends R>> callable) {
        ObjectHelper.requireNonNull(function, "onNextMapper is null");
        ObjectHelper.requireNonNull(function2, "onErrorMapper is null");
        ObjectHelper.requireNonNull(callable, "onCompleteSupplier is null");
        return merge(new FlowableMapNotification(this, function, function2, callable));
    }

    @CheckReturnValue
    @BackpressureSupport(BackpressureKind.FULL)
    @SchedulerSupport("io.reactivex:computation")
    public final Flowable<T> takeLast(long j11, TimeUnit timeUnit, boolean z11) {
        return takeLast(j11, timeUnit, Schedulers.computation(), z11, bufferSize());
    }

    @CheckReturnValue
    @BackpressureSupport(BackpressureKind.UNBOUNDED_IN)
    @SchedulerSupport("none")
    public final <K, V> Single<Map<K, Collection<V>>> toMultimap(Function<? super T, ? extends K> function, Function<? super T, ? extends V> function2, Callable<Map<K, Collection<V>>> callable) {
        return toMultimap(function, function2, callable, ArrayListSupplier.asFunction());
    }

    @CheckReturnValue
    @BackpressureSupport(BackpressureKind.PASS_THROUGH)
    @NonNull
    @SchedulerSupport("none")
    public final <T1, T2, T3, T4, R> Flowable<R> withLatestFrom(Publisher<T1> publisher, Publisher<T2> publisher2, Publisher<T3> publisher3, Publisher<T4> publisher4, Function5<? super T, ? super T1, ? super T2, ? super T3, ? super T4, R> function5) {
        ObjectHelper.requireNonNull(publisher, "source1 is null");
        ObjectHelper.requireNonNull(publisher2, "source2 is null");
        ObjectHelper.requireNonNull(publisher3, "source3 is null");
        ObjectHelper.requireNonNull(publisher4, "source4 is null");
        return withLatestFrom((Publisher<?>[]) new Publisher[]{publisher, publisher2, publisher3, publisher4}, Functions.toFunction(function5));
    }

    @CheckReturnValue
    @BackpressureSupport(BackpressureKind.FULL)
    @SchedulerSupport("none")
    public static <T1, T2, R> Flowable<R> combineLatest(Publisher<? extends T1> publisher, Publisher<? extends T2> publisher2, BiFunction<? super T1, ? super T2, ? extends R> biFunction) {
        ObjectHelper.requireNonNull(publisher, "source1 is null");
        ObjectHelper.requireNonNull(publisher2, "source2 is null");
        return combineLatest(Functions.toFunction(biFunction), (Publisher<? extends T>[]) new Publisher[]{publisher, publisher2});
    }

    @CheckReturnValue
    @BackpressureSupport(BackpressureKind.ERROR)
    @SchedulerSupport("io.reactivex:computation")
    public final Flowable<List<T>> buffer(long j11, TimeUnit timeUnit) {
        return buffer(j11, timeUnit, Schedulers.computation(), Integer.MAX_VALUE);
    }

    @CheckReturnValue
    @BackpressureSupport(BackpressureKind.FULL)
    @NonNull
    @SchedulerSupport("custom")
    public final <R> Flowable<R> replay(Function<? super Flowable<T>, ? extends Publisher<R>> function, int i11, Scheduler scheduler) {
        ObjectHelper.requireNonNull(function, "selector is null");
        ObjectHelper.requireNonNull(scheduler, "scheduler is null");
        ObjectHelper.verifyPositive(i11, "bufferSize");
        return FlowableReplay.multicastSelector(FlowableInternalHelper.replayCallable(this, i11), FlowableInternalHelper.replayFunction(function, scheduler));
    }

    @CheckReturnValue
    @BackpressureSupport(BackpressureKind.FULL)
    @SchedulerSupport("custom")
    public final Flowable<T> takeLast(long j11, TimeUnit timeUnit, Scheduler scheduler) {
        return takeLast(j11, timeUnit, scheduler, false, bufferSize());
    }

    @CheckReturnValue
    @BackpressureSupport(BackpressureKind.FULL)
    @NonNull
    @SchedulerSupport("none")
    public static <T> Flowable<T> just(T t11, T t12, T t13, T t14, T t15) {
        ObjectHelper.requireNonNull(t11, "item1 is null");
        ObjectHelper.requireNonNull(t12, "item2 is null");
        ObjectHelper.requireNonNull(t13, "item3 is null");
        ObjectHelper.requireNonNull(t14, "item4 is null");
        ObjectHelper.requireNonNull(t15, "item5 is null");
        return fromArray(t11, t12, t13, t14, t15);
    }

    @CheckReturnValue
    @BackpressureSupport(BackpressureKind.FULL)
    @NonNull
    @SchedulerSupport("none")
    public static <T1, T2, T3, R> Flowable<R> zip(Publisher<? extends T1> publisher, Publisher<? extends T2> publisher2, Publisher<? extends T3> publisher3, Function3<? super T1, ? super T2, ? super T3, ? extends R> function3) {
        ObjectHelper.requireNonNull(publisher, "source1 is null");
        ObjectHelper.requireNonNull(publisher2, "source2 is null");
        ObjectHelper.requireNonNull(publisher3, "source3 is null");
        return zipArray(Functions.toFunction(function3), false, bufferSize(), publisher, publisher2, publisher3);
    }

    @CheckReturnValue
    @BackpressureSupport(BackpressureKind.ERROR)
    @SchedulerSupport("io.reactivex:computation")
    public final Flowable<List<T>> buffer(long j11, TimeUnit timeUnit, int i11) {
        return buffer(j11, timeUnit, Schedulers.computation(), i11);
    }

    @BackpressureSupport(BackpressureKind.SPECIAL)
    @SchedulerSupport("none")
    public final void subscribe(FlowableSubscriber<? super T> flowableSubscriber) {
        ObjectHelper.requireNonNull(flowableSubscriber, "s is null");
        try {
            Subscriber<? super Object> onSubscribe = RxJavaPlugins.onSubscribe(this, flowableSubscriber);
            ObjectHelper.requireNonNull(onSubscribe, "The RxJavaPlugins.onSubscribe hook returned a null FlowableSubscriber. Please check the handler provided to RxJavaPlugins.setOnFlowableSubscribe for invalid null returns. Further reading: https://github.com/ReactiveX/RxJava/wiki/Plugins");
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
    @BackpressureSupport(BackpressureKind.FULL)
    @SchedulerSupport("custom")
    public final Flowable<T> takeLast(long j11, TimeUnit timeUnit, Scheduler scheduler, boolean z11) {
        return takeLast(j11, timeUnit, scheduler, z11, bufferSize());
    }

    @CheckReturnValue
    @BackpressureSupport(BackpressureKind.ERROR)
    @SchedulerSupport("io.reactivex:computation")
    public final Flowable<Flowable<T>> window(long j11, TimeUnit timeUnit) {
        return window(j11, timeUnit, Schedulers.computation(), Long.MAX_VALUE, false);
    }

    @CheckReturnValue
    @BackpressureSupport(BackpressureKind.ERROR)
    @SchedulerSupport("custom")
    public final Flowable<List<T>> buffer(long j11, TimeUnit timeUnit, Scheduler scheduler, int i11) {
        return buffer(j11, timeUnit, scheduler, i11, ArrayListSupplier.asCallable(), false);
    }

    @CheckReturnValue
    @BackpressureSupport(BackpressureKind.FULL)
    @SchedulerSupport("custom")
    public final Flowable<T> takeLast(long j11, TimeUnit timeUnit, Scheduler scheduler, boolean z11, int i11) {
        return takeLast(Long.MAX_VALUE, j11, timeUnit, scheduler, z11, i11);
    }

    @CheckReturnValue
    @BackpressureSupport(BackpressureKind.ERROR)
    @SchedulerSupport("io.reactivex:computation")
    public final Flowable<Flowable<T>> window(long j11, TimeUnit timeUnit, long j12) {
        return window(j11, timeUnit, Schedulers.computation(), j12, false);
    }

    @CheckReturnValue
    @BackpressureSupport(BackpressureKind.ERROR)
    @SchedulerSupport("custom")
    public final <U extends Collection<? super T>> Flowable<U> buffer(long j11, TimeUnit timeUnit, Scheduler scheduler, int i11, Callable<U> callable, boolean z11) {
        ObjectHelper.requireNonNull(timeUnit, "unit is null");
        Scheduler scheduler2 = scheduler;
        ObjectHelper.requireNonNull(scheduler2, "scheduler is null");
        Callable<U> callable2 = callable;
        ObjectHelper.requireNonNull(callable2, "bufferSupplier is null");
        int i12 = i11;
        ObjectHelper.verifyPositive(i12, "count");
        return RxJavaPlugins.onAssembly(new FlowableBufferTimed(this, j11, j11, timeUnit, scheduler2, callable2, i12, z11));
    }

    @CheckReturnValue
    @BackpressureSupport(BackpressureKind.FULL)
    @NonNull
    @SchedulerSupport("none")
    public final <R> Flowable<R> flatMap(Function<? super T, ? extends Publisher<? extends R>> function, Function<Throwable, ? extends Publisher<? extends R>> function2, Callable<? extends Publisher<? extends R>> callable, int i11) {
        ObjectHelper.requireNonNull(function, "onNextMapper is null");
        ObjectHelper.requireNonNull(function2, "onErrorMapper is null");
        ObjectHelper.requireNonNull(callable, "onCompleteSupplier is null");
        return merge(new FlowableMapNotification(this, function, function2, callable), i11);
    }

    @CheckReturnValue
    @BackpressureSupport(BackpressureKind.ERROR)
    @SchedulerSupport("io.reactivex:computation")
    public final Flowable<Flowable<T>> window(long j11, TimeUnit timeUnit, long j12, boolean z11) {
        return window(j11, timeUnit, Schedulers.computation(), j12, z11);
    }

    @CheckReturnValue
    @BackpressureSupport(BackpressureKind.FULL)
    @NonNull
    @SchedulerSupport("none")
    public static <T1, T2, T3, R> Flowable<R> combineLatest(Publisher<? extends T1> publisher, Publisher<? extends T2> publisher2, Publisher<? extends T3> publisher3, Function3<? super T1, ? super T2, ? super T3, ? extends R> function3) {
        ObjectHelper.requireNonNull(publisher, "source1 is null");
        ObjectHelper.requireNonNull(publisher2, "source2 is null");
        ObjectHelper.requireNonNull(publisher3, "source3 is null");
        return combineLatest(Functions.toFunction(function3), (Publisher<? extends T>[]) new Publisher[]{publisher, publisher2, publisher3});
    }

    @CheckReturnValue
    @BackpressureSupport(BackpressureKind.ERROR)
    @SchedulerSupport("custom")
    public final Flowable<Flowable<T>> window(long j11, TimeUnit timeUnit, Scheduler scheduler) {
        return window(j11, timeUnit, scheduler, Long.MAX_VALUE, false);
    }

    @CheckReturnValue
    @BackpressureSupport(BackpressureKind.FULL)
    @NonNull
    @SchedulerSupport("none")
    public static <T1, T2, T3, T4, R> Flowable<R> zip(Publisher<? extends T1> publisher, Publisher<? extends T2> publisher2, Publisher<? extends T3> publisher3, Publisher<? extends T4> publisher4, Function4<? super T1, ? super T2, ? super T3, ? super T4, ? extends R> function4) {
        ObjectHelper.requireNonNull(publisher, "source1 is null");
        ObjectHelper.requireNonNull(publisher2, "source2 is null");
        ObjectHelper.requireNonNull(publisher3, "source3 is null");
        ObjectHelper.requireNonNull(publisher4, "source4 is null");
        return zipArray(Functions.toFunction(function4), false, bufferSize(), publisher, publisher2, publisher3, publisher4);
    }

    @CheckReturnValue
    @BackpressureSupport(BackpressureKind.ERROR)
    @SchedulerSupport("custom")
    public final Flowable<Flowable<T>> window(long j11, TimeUnit timeUnit, Scheduler scheduler, long j12) {
        return window(j11, timeUnit, scheduler, j12, false);
    }

    @CheckReturnValue
    @BackpressureSupport(BackpressureKind.PASS_THROUGH)
    @NonNull
    @SchedulerSupport("none")
    public final <R> Flowable<R> withLatestFrom(Publisher<?>[] publisherArr, Function<? super Object[], R> function) {
        ObjectHelper.requireNonNull(publisherArr, "others is null");
        ObjectHelper.requireNonNull(function, "combiner is null");
        return RxJavaPlugins.onAssembly(new FlowableWithLatestFromMany(this, publisherArr, function));
    }

    @CheckReturnValue
    @BackpressureSupport(BackpressureKind.FULL)
    @SchedulerSupport("io.reactivex:computation")
    public final <R> Flowable<R> replay(Function<? super Flowable<T>, ? extends Publisher<R>> function, long j11, TimeUnit timeUnit) {
        return replay(function, j11, timeUnit, Schedulers.computation());
    }

    @CheckReturnValue
    @BackpressureSupport(BackpressureKind.ERROR)
    @SchedulerSupport("custom")
    public final Flowable<Flowable<T>> window(long j11, TimeUnit timeUnit, Scheduler scheduler, long j12, boolean z11) {
        return window(j11, timeUnit, scheduler, j12, z11, bufferSize());
    }

    @CheckReturnValue
    @BackpressureSupport(BackpressureKind.FULL)
    @NonNull
    @SchedulerSupport("none")
    public static <T> Flowable<T> just(T t11, T t12, T t13, T t14, T t15, T t16) {
        ObjectHelper.requireNonNull(t11, "item1 is null");
        ObjectHelper.requireNonNull(t12, "item2 is null");
        ObjectHelper.requireNonNull(t13, "item3 is null");
        ObjectHelper.requireNonNull(t14, "item4 is null");
        ObjectHelper.requireNonNull(t15, "item5 is null");
        ObjectHelper.requireNonNull(t16, "item6 is null");
        return fromArray(t11, t12, t13, t14, t15, t16);
    }

    @CheckReturnValue
    @BackpressureSupport(BackpressureKind.FULL)
    @SchedulerSupport("none")
    public final <U, R> Flowable<R> flatMap(Function<? super T, ? extends Publisher<? extends U>> function, BiFunction<? super T, ? super U, ? extends R> biFunction) {
        return flatMap(function, biFunction, false, bufferSize(), bufferSize());
    }

    @CheckReturnValue
    @BackpressureSupport(BackpressureKind.FULL)
    @NonNull
    @SchedulerSupport("custom")
    public final <R> Flowable<R> replay(Function<? super Flowable<T>, ? extends Publisher<R>> function, long j11, TimeUnit timeUnit, Scheduler scheduler) {
        ObjectHelper.requireNonNull(function, "selector is null");
        ObjectHelper.requireNonNull(timeUnit, "unit is null");
        ObjectHelper.requireNonNull(scheduler, "scheduler is null");
        return FlowableReplay.multicastSelector(FlowableInternalHelper.replayCallable(this, j11, timeUnit, scheduler), function);
    }

    @CheckReturnValue
    @BackpressureSupport(BackpressureKind.ERROR)
    @NonNull
    @SchedulerSupport("custom")
    public final Flowable<Flowable<T>> window(long j11, TimeUnit timeUnit, Scheduler scheduler, long j12, boolean z11, int i11) {
        int i12 = i11;
        ObjectHelper.verifyPositive(i12, "bufferSize");
        Scheduler scheduler2 = scheduler;
        ObjectHelper.requireNonNull(scheduler2, "scheduler is null");
        TimeUnit timeUnit2 = timeUnit;
        ObjectHelper.requireNonNull(timeUnit2, "unit is null");
        long j13 = j12;
        ObjectHelper.verifyPositive(j13, "count");
        return RxJavaPlugins.onAssembly(new FlowableWindowTimed(this, j11, j11, timeUnit2, scheduler2, j13, i12, z11));
    }

    @CheckReturnValue
    @BackpressureSupport(BackpressureKind.FULL)
    @NonNull
    @SchedulerSupport("none")
    public static <T1, T2, T3, T4, R> Flowable<R> combineLatest(Publisher<? extends T1> publisher, Publisher<? extends T2> publisher2, Publisher<? extends T3> publisher3, Publisher<? extends T4> publisher4, Function4<? super T1, ? super T2, ? super T3, ? super T4, ? extends R> function4) {
        ObjectHelper.requireNonNull(publisher, "source1 is null");
        ObjectHelper.requireNonNull(publisher2, "source2 is null");
        ObjectHelper.requireNonNull(publisher3, "source3 is null");
        ObjectHelper.requireNonNull(publisher4, "source4 is null");
        return combineLatest(Functions.toFunction(function4), (Publisher<? extends T>[]) new Publisher[]{publisher, publisher2, publisher3, publisher4});
    }

    @CheckReturnValue
    @BackpressureSupport(BackpressureKind.ERROR)
    @SchedulerSupport("custom")
    public final Flowable<List<T>> buffer(long j11, TimeUnit timeUnit, Scheduler scheduler) {
        return buffer(j11, timeUnit, scheduler, Integer.MAX_VALUE, ArrayListSupplier.asCallable(), false);
    }

    @CheckReturnValue
    @BackpressureSupport(BackpressureKind.FULL)
    @SchedulerSupport("none")
    public final <U, R> Flowable<R> flatMap(Function<? super T, ? extends Publisher<? extends U>> function, BiFunction<? super T, ? super U, ? extends R> biFunction, boolean z11) {
        return flatMap(function, biFunction, z11, bufferSize(), bufferSize());
    }

    @CheckReturnValue
    @BackpressureSupport(BackpressureKind.PASS_THROUGH)
    @NonNull
    @SchedulerSupport("none")
    public final <R> Flowable<R> withLatestFrom(Iterable<? extends Publisher<?>> iterable, Function<? super Object[], R> function) {
        ObjectHelper.requireNonNull(iterable, "others is null");
        ObjectHelper.requireNonNull(function, "combiner is null");
        return RxJavaPlugins.onAssembly(new FlowableWithLatestFromMany(this, iterable, function));
    }

    @CheckReturnValue
    @BackpressureSupport(BackpressureKind.ERROR)
    @SchedulerSupport("none")
    public final <TOpening, TClosing> Flowable<List<T>> buffer(Flowable<? extends TOpening> flowable, Function<? super TOpening, ? extends Publisher<? extends TClosing>> function) {
        return buffer(flowable, function, ArrayListSupplier.asCallable());
    }

    @CheckReturnValue
    @BackpressureSupport(BackpressureKind.FULL)
    @SchedulerSupport("none")
    public final <U, R> Flowable<R> flatMap(Function<? super T, ? extends Publisher<? extends U>> function, BiFunction<? super T, ? super U, ? extends R> biFunction, boolean z11, int i11) {
        return flatMap(function, biFunction, z11, i11, bufferSize());
    }

    @CheckReturnValue
    @BackpressureSupport(BackpressureKind.FULL)
    @NonNull
    @SchedulerSupport("none")
    public static <T1, T2, T3, T4, T5, R> Flowable<R> zip(Publisher<? extends T1> publisher, Publisher<? extends T2> publisher2, Publisher<? extends T3> publisher3, Publisher<? extends T4> publisher4, Publisher<? extends T5> publisher5, Function5<? super T1, ? super T2, ? super T3, ? super T4, ? super T5, ? extends R> function5) {
        ObjectHelper.requireNonNull(publisher, "source1 is null");
        ObjectHelper.requireNonNull(publisher2, "source2 is null");
        ObjectHelper.requireNonNull(publisher3, "source3 is null");
        ObjectHelper.requireNonNull(publisher4, "source4 is null");
        ObjectHelper.requireNonNull(publisher5, "source5 is null");
        return zipArray(Functions.toFunction(function5), false, bufferSize(), publisher, publisher2, publisher3, publisher4, publisher5);
    }

    @CheckReturnValue
    @BackpressureSupport(BackpressureKind.ERROR)
    @SchedulerSupport("none")
    public final <TOpening, TClosing, U extends Collection<? super T>> Flowable<U> buffer(Flowable<? extends TOpening> flowable, Function<? super TOpening, ? extends Publisher<? extends TClosing>> function, Callable<U> callable) {
        ObjectHelper.requireNonNull(flowable, "openingIndicator is null");
        ObjectHelper.requireNonNull(function, "closingIndicator is null");
        ObjectHelper.requireNonNull(callable, "bufferSupplier is null");
        return RxJavaPlugins.onAssembly(new FlowableBufferBoundary(this, flowable, function, callable));
    }

    @CheckReturnValue
    @BackpressureSupport(BackpressureKind.FULL)
    @NonNull
    @SchedulerSupport("none")
    public final <U, R> Flowable<R> flatMap(Function<? super T, ? extends Publisher<? extends U>> function, BiFunction<? super T, ? super U, ? extends R> biFunction, boolean z11, int i11, int i12) {
        ObjectHelper.requireNonNull(function, "mapper is null");
        ObjectHelper.requireNonNull(biFunction, "combiner is null");
        ObjectHelper.verifyPositive(i11, "maxConcurrency");
        ObjectHelper.verifyPositive(i12, "bufferSize");
        return flatMap(FlowableInternalHelper.flatMapWithCombiner(function, biFunction), z11, i11, i12);
    }

    @CheckReturnValue
    @BackpressureSupport(BackpressureKind.FULL)
    @NonNull
    @SchedulerSupport("custom")
    public final <R> Flowable<R> replay(Function<? super Flowable<T>, ? extends Publisher<R>> function, Scheduler scheduler) {
        ObjectHelper.requireNonNull(function, "selector is null");
        ObjectHelper.requireNonNull(scheduler, "scheduler is null");
        return FlowableReplay.multicastSelector(FlowableInternalHelper.replayCallable(this), FlowableInternalHelper.replayFunction(function, scheduler));
    }

    @CheckReturnValue
    @BackpressureSupport(BackpressureKind.ERROR)
    @SchedulerSupport("none")
    public final <B> Flowable<Flowable<T>> window(Publisher<B> publisher) {
        return window(publisher, bufferSize());
    }

    @CheckReturnValue
    @BackpressureSupport(BackpressureKind.FULL)
    @NonNull
    @SchedulerSupport("none")
    public static <T1, T2, T3, T4, T5, R> Flowable<R> combineLatest(Publisher<? extends T1> publisher, Publisher<? extends T2> publisher2, Publisher<? extends T3> publisher3, Publisher<? extends T4> publisher4, Publisher<? extends T5> publisher5, Function5<? super T1, ? super T2, ? super T3, ? super T4, ? super T5, ? extends R> function5) {
        ObjectHelper.requireNonNull(publisher, "source1 is null");
        ObjectHelper.requireNonNull(publisher2, "source2 is null");
        ObjectHelper.requireNonNull(publisher3, "source3 is null");
        ObjectHelper.requireNonNull(publisher4, "source4 is null");
        ObjectHelper.requireNonNull(publisher5, "source5 is null");
        return combineLatest(Functions.toFunction(function5), (Publisher<? extends T>[]) new Publisher[]{publisher, publisher2, publisher3, publisher4, publisher5});
    }

    @CheckReturnValue
    @BackpressureSupport(BackpressureKind.ERROR)
    @NonNull
    @SchedulerSupport("none")
    public final <B> Flowable<Flowable<T>> window(Publisher<B> publisher, int i11) {
        ObjectHelper.requireNonNull(publisher, "boundaryIndicator is null");
        ObjectHelper.verifyPositive(i11, "bufferSize");
        return RxJavaPlugins.onAssembly(new FlowableWindowBoundary(this, publisher, i11));
    }

    @CheckReturnValue
    @BackpressureSupport(BackpressureKind.FULL)
    @NonNull
    @SchedulerSupport("none")
    public static <T> Flowable<T> just(T t11, T t12, T t13, T t14, T t15, T t16, T t17) {
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
    @BackpressureSupport(BackpressureKind.ERROR)
    @SchedulerSupport("none")
    public final <B> Flowable<List<T>> buffer(Publisher<B> publisher) {
        return buffer(publisher, ArrayListSupplier.asCallable());
    }

    @CheckReturnValue
    @BackpressureSupport(BackpressureKind.ERROR)
    @SchedulerSupport("none")
    public final <B> Flowable<List<T>> buffer(Publisher<B> publisher, int i11) {
        ObjectHelper.verifyPositive(i11, "initialCapacity");
        return buffer(publisher, Functions.createArrayList(i11));
    }

    @CheckReturnValue
    @BackpressureSupport(BackpressureKind.FULL)
    @SchedulerSupport("none")
    public final <U, R> Flowable<R> flatMap(Function<? super T, ? extends Publisher<? extends U>> function, BiFunction<? super T, ? super U, ? extends R> biFunction, int i11) {
        return flatMap(function, biFunction, false, i11, bufferSize());
    }

    @CheckReturnValue
    @BackpressureSupport(BackpressureKind.FULL)
    @NonNull
    @SchedulerSupport("none")
    public static <T1, T2, T3, T4, T5, T6, R> Flowable<R> zip(Publisher<? extends T1> publisher, Publisher<? extends T2> publisher2, Publisher<? extends T3> publisher3, Publisher<? extends T4> publisher4, Publisher<? extends T5> publisher5, Publisher<? extends T6> publisher6, Function6<? super T1, ? super T2, ? super T3, ? super T4, ? super T5, ? super T6, ? extends R> function6) {
        ObjectHelper.requireNonNull(publisher, "source1 is null");
        ObjectHelper.requireNonNull(publisher2, "source2 is null");
        ObjectHelper.requireNonNull(publisher3, "source3 is null");
        ObjectHelper.requireNonNull(publisher4, "source4 is null");
        ObjectHelper.requireNonNull(publisher5, "source5 is null");
        ObjectHelper.requireNonNull(publisher6, "source6 is null");
        return zipArray(Functions.toFunction(function6), false, bufferSize(), publisher, publisher2, publisher3, publisher4, publisher5, publisher6);
    }

    @CheckReturnValue
    @BackpressureSupport(BackpressureKind.FULL)
    @SchedulerSupport("none")
    public final ConnectableFlowable<T> replay(int i11) {
        ObjectHelper.verifyPositive(i11, "bufferSize");
        return FlowableReplay.create(this, i11);
    }

    @CheckReturnValue
    @BackpressureSupport(BackpressureKind.ERROR)
    @SchedulerSupport("none")
    public final <U, V> Flowable<Flowable<T>> window(Publisher<U> publisher, Function<? super U, ? extends Publisher<V>> function) {
        return window(publisher, function, bufferSize());
    }

    @CheckReturnValue
    @BackpressureSupport(BackpressureKind.ERROR)
    @SchedulerSupport("none")
    public final <B, U extends Collection<? super T>> Flowable<U> buffer(Publisher<B> publisher, Callable<U> callable) {
        ObjectHelper.requireNonNull(publisher, "boundaryIndicator is null");
        ObjectHelper.requireNonNull(callable, "bufferSupplier is null");
        return RxJavaPlugins.onAssembly(new FlowableBufferExactBoundary(this, publisher, callable));
    }

    @CheckReturnValue
    @BackpressureSupport(BackpressureKind.ERROR)
    @NonNull
    @SchedulerSupport("none")
    public final <U, V> Flowable<Flowable<T>> window(Publisher<U> publisher, Function<? super U, ? extends Publisher<V>> function, int i11) {
        ObjectHelper.requireNonNull(publisher, "openingIndicator is null");
        ObjectHelper.requireNonNull(function, "closingIndicator is null");
        ObjectHelper.verifyPositive(i11, "bufferSize");
        return RxJavaPlugins.onAssembly(new FlowableWindowBoundarySelector(this, publisher, function, i11));
    }

    @CheckReturnValue
    @BackpressureSupport(BackpressureKind.FULL)
    @SchedulerSupport("io.reactivex:computation")
    public final ConnectableFlowable<T> replay(int i11, long j11, TimeUnit timeUnit) {
        return replay(i11, j11, timeUnit, Schedulers.computation());
    }

    @CheckReturnValue
    @BackpressureSupport(BackpressureKind.FULL)
    @NonNull
    @SchedulerSupport("none")
    public static <T1, T2, T3, T4, T5, T6, R> Flowable<R> combineLatest(Publisher<? extends T1> publisher, Publisher<? extends T2> publisher2, Publisher<? extends T3> publisher3, Publisher<? extends T4> publisher4, Publisher<? extends T5> publisher5, Publisher<? extends T6> publisher6, Function6<? super T1, ? super T2, ? super T3, ? super T4, ? super T5, ? super T6, ? extends R> function6) {
        ObjectHelper.requireNonNull(publisher, "source1 is null");
        ObjectHelper.requireNonNull(publisher2, "source2 is null");
        ObjectHelper.requireNonNull(publisher3, "source3 is null");
        ObjectHelper.requireNonNull(publisher4, "source4 is null");
        ObjectHelper.requireNonNull(publisher5, "source5 is null");
        ObjectHelper.requireNonNull(publisher6, "source6 is null");
        return combineLatest(Functions.toFunction(function6), (Publisher<? extends T>[]) new Publisher[]{publisher, publisher2, publisher3, publisher4, publisher5, publisher6});
    }

    @CheckReturnValue
    @BackpressureSupport(BackpressureKind.FULL)
    @SchedulerSupport("custom")
    public final ConnectableFlowable<T> replay(int i11, long j11, TimeUnit timeUnit, Scheduler scheduler) {
        ObjectHelper.verifyPositive(i11, "bufferSize");
        ObjectHelper.requireNonNull(timeUnit, "unit is null");
        ObjectHelper.requireNonNull(scheduler, "scheduler is null");
        ObjectHelper.verifyPositive(i11, "bufferSize");
        return FlowableReplay.create(this, j11, timeUnit, scheduler, i11);
    }

    @CheckReturnValue
    @BackpressureSupport(BackpressureKind.ERROR)
    @SchedulerSupport("none")
    public final <B> Flowable<List<T>> buffer(Callable<? extends Publisher<B>> callable) {
        return buffer(callable, ArrayListSupplier.asCallable());
    }

    @CheckReturnValue
    @BackpressureSupport(BackpressureKind.ERROR)
    @SchedulerSupport("none")
    public final <B, U extends Collection<? super T>> Flowable<U> buffer(Callable<? extends Publisher<B>> callable, Callable<U> callable2) {
        ObjectHelper.requireNonNull(callable, "boundaryIndicatorSupplier is null");
        ObjectHelper.requireNonNull(callable2, "bufferSupplier is null");
        return RxJavaPlugins.onAssembly(new FlowableBufferBoundarySupplier(this, callable, callable2));
    }

    @CheckReturnValue
    @BackpressureSupport(BackpressureKind.ERROR)
    @SchedulerSupport("none")
    public final <B> Flowable<Flowable<T>> window(Callable<? extends Publisher<B>> callable) {
        return window(callable, bufferSize());
    }

    @CheckReturnValue
    @BackpressureSupport(BackpressureKind.FULL)
    @NonNull
    @SchedulerSupport("none")
    public static <T> Flowable<T> just(T t11, T t12, T t13, T t14, T t15, T t16, T t17, T t18) {
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
    @BackpressureSupport(BackpressureKind.ERROR)
    @NonNull
    @SchedulerSupport("none")
    public final <B> Flowable<Flowable<T>> window(Callable<? extends Publisher<B>> callable, int i11) {
        ObjectHelper.requireNonNull(callable, "boundaryIndicatorSupplier is null");
        ObjectHelper.verifyPositive(i11, "bufferSize");
        return RxJavaPlugins.onAssembly(new FlowableWindowBoundarySupplier(this, callable, i11));
    }

    @CheckReturnValue
    @BackpressureSupport(BackpressureKind.FULL)
    @NonNull
    @SchedulerSupport("none")
    public static <T1, T2, T3, T4, T5, T6, T7, R> Flowable<R> zip(Publisher<? extends T1> publisher, Publisher<? extends T2> publisher2, Publisher<? extends T3> publisher3, Publisher<? extends T4> publisher4, Publisher<? extends T5> publisher5, Publisher<? extends T6> publisher6, Publisher<? extends T7> publisher7, Function7<? super T1, ? super T2, ? super T3, ? super T4, ? super T5, ? super T6, ? super T7, ? extends R> function7) {
        ObjectHelper.requireNonNull(publisher, "source1 is null");
        ObjectHelper.requireNonNull(publisher2, "source2 is null");
        ObjectHelper.requireNonNull(publisher3, "source3 is null");
        ObjectHelper.requireNonNull(publisher4, "source4 is null");
        ObjectHelper.requireNonNull(publisher5, "source5 is null");
        ObjectHelper.requireNonNull(publisher6, "source6 is null");
        ObjectHelper.requireNonNull(publisher7, "source7 is null");
        return zipArray(Functions.toFunction(function7), false, bufferSize(), publisher, publisher2, publisher3, publisher4, publisher5, publisher6, publisher7);
    }

    @CheckReturnValue
    @BackpressureSupport(BackpressureKind.FULL)
    @SchedulerSupport("custom")
    public final ConnectableFlowable<T> replay(int i11, Scheduler scheduler) {
        ObjectHelper.requireNonNull(scheduler, "scheduler is null");
        return FlowableReplay.observeOn(replay(i11), scheduler);
    }

    @CheckReturnValue
    @BackpressureSupport(BackpressureKind.FULL)
    @NonNull
    @SchedulerSupport("none")
    public static <T1, T2, T3, T4, T5, T6, T7, R> Flowable<R> combineLatest(Publisher<? extends T1> publisher, Publisher<? extends T2> publisher2, Publisher<? extends T3> publisher3, Publisher<? extends T4> publisher4, Publisher<? extends T5> publisher5, Publisher<? extends T6> publisher6, Publisher<? extends T7> publisher7, Function7<? super T1, ? super T2, ? super T3, ? super T4, ? super T5, ? super T6, ? super T7, ? extends R> function7) {
        ObjectHelper.requireNonNull(publisher, "source1 is null");
        ObjectHelper.requireNonNull(publisher2, "source2 is null");
        ObjectHelper.requireNonNull(publisher3, "source3 is null");
        ObjectHelper.requireNonNull(publisher4, "source4 is null");
        ObjectHelper.requireNonNull(publisher5, "source5 is null");
        ObjectHelper.requireNonNull(publisher6, "source6 is null");
        ObjectHelper.requireNonNull(publisher7, "source7 is null");
        return combineLatest(Functions.toFunction(function7), (Publisher<? extends T>[]) new Publisher[]{publisher, publisher2, publisher3, publisher4, publisher5, publisher6, publisher7});
    }

    @CheckReturnValue
    @BackpressureSupport(BackpressureKind.FULL)
    @SchedulerSupport("io.reactivex:computation")
    public final ConnectableFlowable<T> replay(long j11, TimeUnit timeUnit) {
        return replay(j11, timeUnit, Schedulers.computation());
    }

    @CheckReturnValue
    @BackpressureSupport(BackpressureKind.FULL)
    @SchedulerSupport("custom")
    public final ConnectableFlowable<T> replay(long j11, TimeUnit timeUnit, Scheduler scheduler) {
        ObjectHelper.requireNonNull(timeUnit, "unit is null");
        ObjectHelper.requireNonNull(scheduler, "scheduler is null");
        return FlowableReplay.create(this, j11, timeUnit, scheduler);
    }

    @CheckReturnValue
    @BackpressureSupport(BackpressureKind.FULL)
    @SchedulerSupport("custom")
    public final ConnectableFlowable<T> replay(Scheduler scheduler) {
        ObjectHelper.requireNonNull(scheduler, "scheduler is null");
        return FlowableReplay.observeOn(replay(), scheduler);
    }

    @CheckReturnValue
    @BackpressureSupport(BackpressureKind.FULL)
    @NonNull
    @SchedulerSupport("none")
    public static <T> Flowable<T> just(T t11, T t12, T t13, T t14, T t15, T t16, T t17, T t18, T t19) {
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
    @BackpressureSupport(BackpressureKind.FULL)
    @NonNull
    @SchedulerSupport("none")
    public static <T1, T2, T3, T4, T5, T6, T7, T8, R> Flowable<R> zip(Publisher<? extends T1> publisher, Publisher<? extends T2> publisher2, Publisher<? extends T3> publisher3, Publisher<? extends T4> publisher4, Publisher<? extends T5> publisher5, Publisher<? extends T6> publisher6, Publisher<? extends T7> publisher7, Publisher<? extends T8> publisher8, Function8<? super T1, ? super T2, ? super T3, ? super T4, ? super T5, ? super T6, ? super T7, ? super T8, ? extends R> function8) {
        ObjectHelper.requireNonNull(publisher, "source1 is null");
        ObjectHelper.requireNonNull(publisher2, "source2 is null");
        ObjectHelper.requireNonNull(publisher3, "source3 is null");
        ObjectHelper.requireNonNull(publisher4, "source4 is null");
        ObjectHelper.requireNonNull(publisher5, "source5 is null");
        ObjectHelper.requireNonNull(publisher6, "source6 is null");
        ObjectHelper.requireNonNull(publisher7, "source7 is null");
        ObjectHelper.requireNonNull(publisher8, "source8 is null");
        return zipArray(Functions.toFunction(function8), false, bufferSize(), publisher, publisher2, publisher3, publisher4, publisher5, publisher6, publisher7, publisher8);
    }

    @CheckReturnValue
    @BackpressureSupport(BackpressureKind.FULL)
    @NonNull
    @SchedulerSupport("none")
    public static <T1, T2, T3, T4, T5, T6, T7, T8, R> Flowable<R> combineLatest(Publisher<? extends T1> publisher, Publisher<? extends T2> publisher2, Publisher<? extends T3> publisher3, Publisher<? extends T4> publisher4, Publisher<? extends T5> publisher5, Publisher<? extends T6> publisher6, Publisher<? extends T7> publisher7, Publisher<? extends T8> publisher8, Function8<? super T1, ? super T2, ? super T3, ? super T4, ? super T5, ? super T6, ? super T7, ? super T8, ? extends R> function8) {
        ObjectHelper.requireNonNull(publisher, "source1 is null");
        ObjectHelper.requireNonNull(publisher2, "source2 is null");
        ObjectHelper.requireNonNull(publisher3, "source3 is null");
        ObjectHelper.requireNonNull(publisher4, "source4 is null");
        ObjectHelper.requireNonNull(publisher5, "source5 is null");
        ObjectHelper.requireNonNull(publisher6, "source6 is null");
        ObjectHelper.requireNonNull(publisher7, "source7 is null");
        ObjectHelper.requireNonNull(publisher8, "source8 is null");
        return combineLatest(Functions.toFunction(function8), (Publisher<? extends T>[]) new Publisher[]{publisher, publisher2, publisher3, publisher4, publisher5, publisher6, publisher7, publisher8});
    }

    @CheckReturnValue
    @BackpressureSupport(BackpressureKind.FULL)
    @NonNull
    @SchedulerSupport("none")
    public static <T1, T2, T3, T4, T5, T6, T7, T8, T9, R> Flowable<R> zip(Publisher<? extends T1> publisher, Publisher<? extends T2> publisher2, Publisher<? extends T3> publisher3, Publisher<? extends T4> publisher4, Publisher<? extends T5> publisher5, Publisher<? extends T6> publisher6, Publisher<? extends T7> publisher7, Publisher<? extends T8> publisher8, Publisher<? extends T9> publisher9, Function9<? super T1, ? super T2, ? super T3, ? super T4, ? super T5, ? super T6, ? super T7, ? super T8, ? super T9, ? extends R> function9) {
        ObjectHelper.requireNonNull(publisher, "source1 is null");
        ObjectHelper.requireNonNull(publisher2, "source2 is null");
        ObjectHelper.requireNonNull(publisher3, "source3 is null");
        ObjectHelper.requireNonNull(publisher4, "source4 is null");
        ObjectHelper.requireNonNull(publisher5, "source5 is null");
        ObjectHelper.requireNonNull(publisher6, "source6 is null");
        ObjectHelper.requireNonNull(publisher7, "source7 is null");
        ObjectHelper.requireNonNull(publisher8, "source8 is null");
        ObjectHelper.requireNonNull(publisher9, "source9 is null");
        return zipArray(Functions.toFunction(function9), false, bufferSize(), publisher, publisher2, publisher3, publisher4, publisher5, publisher6, publisher7, publisher8, publisher9);
    }

    @CheckReturnValue
    @BackpressureSupport(BackpressureKind.FULL)
    @NonNull
    @SchedulerSupport("none")
    public static <T> Flowable<T> just(T t11, T t12, T t13, T t14, T t15, T t16, T t17, T t18, T t19, T t21) {
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
    @BackpressureSupport(BackpressureKind.FULL)
    @NonNull
    @SchedulerSupport("none")
    public static <T1, T2, T3, T4, T5, T6, T7, T8, T9, R> Flowable<R> combineLatest(Publisher<? extends T1> publisher, Publisher<? extends T2> publisher2, Publisher<? extends T3> publisher3, Publisher<? extends T4> publisher4, Publisher<? extends T5> publisher5, Publisher<? extends T6> publisher6, Publisher<? extends T7> publisher7, Publisher<? extends T8> publisher8, Publisher<? extends T9> publisher9, Function9<? super T1, ? super T2, ? super T3, ? super T4, ? super T5, ? super T6, ? super T7, ? super T8, ? super T9, ? extends R> function9) {
        ObjectHelper.requireNonNull(publisher, "source1 is null");
        ObjectHelper.requireNonNull(publisher2, "source2 is null");
        ObjectHelper.requireNonNull(publisher3, "source3 is null");
        ObjectHelper.requireNonNull(publisher4, "source4 is null");
        ObjectHelper.requireNonNull(publisher5, "source5 is null");
        ObjectHelper.requireNonNull(publisher6, "source6 is null");
        ObjectHelper.requireNonNull(publisher7, "source7 is null");
        ObjectHelper.requireNonNull(publisher8, "source8 is null");
        ObjectHelper.requireNonNull(publisher9, "source9 is null");
        return combineLatest(Functions.toFunction(function9), (Publisher<? extends T>[]) new Publisher[]{publisher, publisher2, publisher3, publisher4, publisher5, publisher6, publisher7, publisher8, publisher9});
    }
}
