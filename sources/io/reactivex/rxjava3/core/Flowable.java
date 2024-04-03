package io.reactivex.rxjava3.core;

import io.reactivex.rxjava3.annotations.BackpressureKind;
import io.reactivex.rxjava3.annotations.BackpressureSupport;
import io.reactivex.rxjava3.annotations.CheckReturnValue;
import io.reactivex.rxjava3.annotations.NonNull;
import io.reactivex.rxjava3.annotations.Nullable;
import io.reactivex.rxjava3.annotations.SchedulerSupport;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.disposables.DisposableContainer;
import io.reactivex.rxjava3.exceptions.Exceptions;
import io.reactivex.rxjava3.flowables.ConnectableFlowable;
import io.reactivex.rxjava3.flowables.GroupedFlowable;
import io.reactivex.rxjava3.functions.Action;
import io.reactivex.rxjava3.functions.BiConsumer;
import io.reactivex.rxjava3.functions.BiFunction;
import io.reactivex.rxjava3.functions.BiPredicate;
import io.reactivex.rxjava3.functions.BooleanSupplier;
import io.reactivex.rxjava3.functions.Consumer;
import io.reactivex.rxjava3.functions.Function;
import io.reactivex.rxjava3.functions.Function3;
import io.reactivex.rxjava3.functions.Function4;
import io.reactivex.rxjava3.functions.Function5;
import io.reactivex.rxjava3.functions.Function6;
import io.reactivex.rxjava3.functions.Function7;
import io.reactivex.rxjava3.functions.Function8;
import io.reactivex.rxjava3.functions.Function9;
import io.reactivex.rxjava3.functions.LongConsumer;
import io.reactivex.rxjava3.functions.Predicate;
import io.reactivex.rxjava3.functions.Supplier;
import io.reactivex.rxjava3.internal.functions.Functions;
import io.reactivex.rxjava3.internal.functions.ObjectHelper;
import io.reactivex.rxjava3.internal.jdk8.FlowableCollectWithCollectorSingle;
import io.reactivex.rxjava3.internal.jdk8.FlowableFirstStageSubscriber;
import io.reactivex.rxjava3.internal.jdk8.FlowableFlatMapStream;
import io.reactivex.rxjava3.internal.jdk8.FlowableFromCompletionStage;
import io.reactivex.rxjava3.internal.jdk8.FlowableFromStream;
import io.reactivex.rxjava3.internal.jdk8.FlowableLastStageSubscriber;
import io.reactivex.rxjava3.internal.jdk8.FlowableMapOptional;
import io.reactivex.rxjava3.internal.jdk8.FlowableSingleStageSubscriber;
import io.reactivex.rxjava3.internal.operators.flowable.BlockingFlowableIterable;
import io.reactivex.rxjava3.internal.operators.flowable.BlockingFlowableLatest;
import io.reactivex.rxjava3.internal.operators.flowable.BlockingFlowableMostRecent;
import io.reactivex.rxjava3.internal.operators.flowable.BlockingFlowableNext;
import io.reactivex.rxjava3.internal.operators.flowable.FlowableAllSingle;
import io.reactivex.rxjava3.internal.operators.flowable.FlowableAmb;
import io.reactivex.rxjava3.internal.operators.flowable.FlowableAnySingle;
import io.reactivex.rxjava3.internal.operators.flowable.FlowableBlockingSubscribe;
import io.reactivex.rxjava3.internal.operators.flowable.FlowableBuffer;
import io.reactivex.rxjava3.internal.operators.flowable.FlowableBufferBoundary;
import io.reactivex.rxjava3.internal.operators.flowable.FlowableBufferExactBoundary;
import io.reactivex.rxjava3.internal.operators.flowable.FlowableBufferTimed;
import io.reactivex.rxjava3.internal.operators.flowable.FlowableCache;
import io.reactivex.rxjava3.internal.operators.flowable.FlowableCollectSingle;
import io.reactivex.rxjava3.internal.operators.flowable.FlowableCombineLatest;
import io.reactivex.rxjava3.internal.operators.flowable.FlowableConcatArray;
import io.reactivex.rxjava3.internal.operators.flowable.FlowableConcatMap;
import io.reactivex.rxjava3.internal.operators.flowable.FlowableConcatMapEager;
import io.reactivex.rxjava3.internal.operators.flowable.FlowableConcatMapEagerPublisher;
import io.reactivex.rxjava3.internal.operators.flowable.FlowableConcatMapScheduler;
import io.reactivex.rxjava3.internal.operators.flowable.FlowableConcatWithCompletable;
import io.reactivex.rxjava3.internal.operators.flowable.FlowableConcatWithMaybe;
import io.reactivex.rxjava3.internal.operators.flowable.FlowableConcatWithSingle;
import io.reactivex.rxjava3.internal.operators.flowable.FlowableCountSingle;
import io.reactivex.rxjava3.internal.operators.flowable.FlowableCreate;
import io.reactivex.rxjava3.internal.operators.flowable.FlowableDebounce;
import io.reactivex.rxjava3.internal.operators.flowable.FlowableDebounceTimed;
import io.reactivex.rxjava3.internal.operators.flowable.FlowableDefer;
import io.reactivex.rxjava3.internal.operators.flowable.FlowableDelay;
import io.reactivex.rxjava3.internal.operators.flowable.FlowableDelaySubscriptionOther;
import io.reactivex.rxjava3.internal.operators.flowable.FlowableDematerialize;
import io.reactivex.rxjava3.internal.operators.flowable.FlowableDetach;
import io.reactivex.rxjava3.internal.operators.flowable.FlowableDistinct;
import io.reactivex.rxjava3.internal.operators.flowable.FlowableDistinctUntilChanged;
import io.reactivex.rxjava3.internal.operators.flowable.FlowableDoAfterNext;
import io.reactivex.rxjava3.internal.operators.flowable.FlowableDoFinally;
import io.reactivex.rxjava3.internal.operators.flowable.FlowableDoOnEach;
import io.reactivex.rxjava3.internal.operators.flowable.FlowableDoOnLifecycle;
import io.reactivex.rxjava3.internal.operators.flowable.FlowableElementAtMaybe;
import io.reactivex.rxjava3.internal.operators.flowable.FlowableElementAtSingle;
import io.reactivex.rxjava3.internal.operators.flowable.FlowableEmpty;
import io.reactivex.rxjava3.internal.operators.flowable.FlowableError;
import io.reactivex.rxjava3.internal.operators.flowable.FlowableFilter;
import io.reactivex.rxjava3.internal.operators.flowable.FlowableFlatMap;
import io.reactivex.rxjava3.internal.operators.flowable.FlowableFlatMapCompletableCompletable;
import io.reactivex.rxjava3.internal.operators.flowable.FlowableFlatMapMaybe;
import io.reactivex.rxjava3.internal.operators.flowable.FlowableFlatMapSingle;
import io.reactivex.rxjava3.internal.operators.flowable.FlowableFlattenIterable;
import io.reactivex.rxjava3.internal.operators.flowable.FlowableFromAction;
import io.reactivex.rxjava3.internal.operators.flowable.FlowableFromArray;
import io.reactivex.rxjava3.internal.operators.flowable.FlowableFromCallable;
import io.reactivex.rxjava3.internal.operators.flowable.FlowableFromCompletable;
import io.reactivex.rxjava3.internal.operators.flowable.FlowableFromFuture;
import io.reactivex.rxjava3.internal.operators.flowable.FlowableFromIterable;
import io.reactivex.rxjava3.internal.operators.flowable.FlowableFromObservable;
import io.reactivex.rxjava3.internal.operators.flowable.FlowableFromPublisher;
import io.reactivex.rxjava3.internal.operators.flowable.FlowableFromRunnable;
import io.reactivex.rxjava3.internal.operators.flowable.FlowableFromSupplier;
import io.reactivex.rxjava3.internal.operators.flowable.FlowableGenerate;
import io.reactivex.rxjava3.internal.operators.flowable.FlowableGroupBy;
import io.reactivex.rxjava3.internal.operators.flowable.FlowableGroupJoin;
import io.reactivex.rxjava3.internal.operators.flowable.FlowableHide;
import io.reactivex.rxjava3.internal.operators.flowable.FlowableIgnoreElements;
import io.reactivex.rxjava3.internal.operators.flowable.FlowableIgnoreElementsCompletable;
import io.reactivex.rxjava3.internal.operators.flowable.FlowableInternalHelper;
import io.reactivex.rxjava3.internal.operators.flowable.FlowableInterval;
import io.reactivex.rxjava3.internal.operators.flowable.FlowableIntervalRange;
import io.reactivex.rxjava3.internal.operators.flowable.FlowableJoin;
import io.reactivex.rxjava3.internal.operators.flowable.FlowableJust;
import io.reactivex.rxjava3.internal.operators.flowable.FlowableLastMaybe;
import io.reactivex.rxjava3.internal.operators.flowable.FlowableLastSingle;
import io.reactivex.rxjava3.internal.operators.flowable.FlowableLift;
import io.reactivex.rxjava3.internal.operators.flowable.FlowableMap;
import io.reactivex.rxjava3.internal.operators.flowable.FlowableMapNotification;
import io.reactivex.rxjava3.internal.operators.flowable.FlowableMaterialize;
import io.reactivex.rxjava3.internal.operators.flowable.FlowableMergeWithCompletable;
import io.reactivex.rxjava3.internal.operators.flowable.FlowableMergeWithMaybe;
import io.reactivex.rxjava3.internal.operators.flowable.FlowableMergeWithSingle;
import io.reactivex.rxjava3.internal.operators.flowable.FlowableNever;
import io.reactivex.rxjava3.internal.operators.flowable.FlowableObserveOn;
import io.reactivex.rxjava3.internal.operators.flowable.FlowableOnBackpressureBuffer;
import io.reactivex.rxjava3.internal.operators.flowable.FlowableOnBackpressureBufferStrategy;
import io.reactivex.rxjava3.internal.operators.flowable.FlowableOnBackpressureDrop;
import io.reactivex.rxjava3.internal.operators.flowable.FlowableOnBackpressureError;
import io.reactivex.rxjava3.internal.operators.flowable.FlowableOnBackpressureLatest;
import io.reactivex.rxjava3.internal.operators.flowable.FlowableOnBackpressureReduce;
import io.reactivex.rxjava3.internal.operators.flowable.FlowableOnBackpressureReduceWith;
import io.reactivex.rxjava3.internal.operators.flowable.FlowableOnErrorComplete;
import io.reactivex.rxjava3.internal.operators.flowable.FlowableOnErrorNext;
import io.reactivex.rxjava3.internal.operators.flowable.FlowableOnErrorReturn;
import io.reactivex.rxjava3.internal.operators.flowable.FlowablePublish;
import io.reactivex.rxjava3.internal.operators.flowable.FlowablePublishMulticast;
import io.reactivex.rxjava3.internal.operators.flowable.FlowableRange;
import io.reactivex.rxjava3.internal.operators.flowable.FlowableRangeLong;
import io.reactivex.rxjava3.internal.operators.flowable.FlowableReduceMaybe;
import io.reactivex.rxjava3.internal.operators.flowable.FlowableReduceSeedSingle;
import io.reactivex.rxjava3.internal.operators.flowable.FlowableReduceWithSingle;
import io.reactivex.rxjava3.internal.operators.flowable.FlowableRepeat;
import io.reactivex.rxjava3.internal.operators.flowable.FlowableRepeatUntil;
import io.reactivex.rxjava3.internal.operators.flowable.FlowableRepeatWhen;
import io.reactivex.rxjava3.internal.operators.flowable.FlowableReplay;
import io.reactivex.rxjava3.internal.operators.flowable.FlowableRetryBiPredicate;
import io.reactivex.rxjava3.internal.operators.flowable.FlowableRetryPredicate;
import io.reactivex.rxjava3.internal.operators.flowable.FlowableRetryWhen;
import io.reactivex.rxjava3.internal.operators.flowable.FlowableSamplePublisher;
import io.reactivex.rxjava3.internal.operators.flowable.FlowableSampleTimed;
import io.reactivex.rxjava3.internal.operators.flowable.FlowableScalarXMap;
import io.reactivex.rxjava3.internal.operators.flowable.FlowableScan;
import io.reactivex.rxjava3.internal.operators.flowable.FlowableScanSeed;
import io.reactivex.rxjava3.internal.operators.flowable.FlowableSequenceEqualSingle;
import io.reactivex.rxjava3.internal.operators.flowable.FlowableSerialized;
import io.reactivex.rxjava3.internal.operators.flowable.FlowableSingleMaybe;
import io.reactivex.rxjava3.internal.operators.flowable.FlowableSingleSingle;
import io.reactivex.rxjava3.internal.operators.flowable.FlowableSkip;
import io.reactivex.rxjava3.internal.operators.flowable.FlowableSkipLast;
import io.reactivex.rxjava3.internal.operators.flowable.FlowableSkipLastTimed;
import io.reactivex.rxjava3.internal.operators.flowable.FlowableSkipUntil;
import io.reactivex.rxjava3.internal.operators.flowable.FlowableSkipWhile;
import io.reactivex.rxjava3.internal.operators.flowable.FlowableSubscribeOn;
import io.reactivex.rxjava3.internal.operators.flowable.FlowableSwitchIfEmpty;
import io.reactivex.rxjava3.internal.operators.flowable.FlowableSwitchMap;
import io.reactivex.rxjava3.internal.operators.flowable.FlowableTake;
import io.reactivex.rxjava3.internal.operators.flowable.FlowableTakeLast;
import io.reactivex.rxjava3.internal.operators.flowable.FlowableTakeLastOne;
import io.reactivex.rxjava3.internal.operators.flowable.FlowableTakeLastTimed;
import io.reactivex.rxjava3.internal.operators.flowable.FlowableTakeUntil;
import io.reactivex.rxjava3.internal.operators.flowable.FlowableTakeUntilPredicate;
import io.reactivex.rxjava3.internal.operators.flowable.FlowableTakeWhile;
import io.reactivex.rxjava3.internal.operators.flowable.FlowableThrottleFirstTimed;
import io.reactivex.rxjava3.internal.operators.flowable.FlowableThrottleLatest;
import io.reactivex.rxjava3.internal.operators.flowable.FlowableTimeInterval;
import io.reactivex.rxjava3.internal.operators.flowable.FlowableTimeout;
import io.reactivex.rxjava3.internal.operators.flowable.FlowableTimeoutTimed;
import io.reactivex.rxjava3.internal.operators.flowable.FlowableTimer;
import io.reactivex.rxjava3.internal.operators.flowable.FlowableToListSingle;
import io.reactivex.rxjava3.internal.operators.flowable.FlowableUnsubscribeOn;
import io.reactivex.rxjava3.internal.operators.flowable.FlowableUsing;
import io.reactivex.rxjava3.internal.operators.flowable.FlowableWindow;
import io.reactivex.rxjava3.internal.operators.flowable.FlowableWindowBoundary;
import io.reactivex.rxjava3.internal.operators.flowable.FlowableWindowBoundarySelector;
import io.reactivex.rxjava3.internal.operators.flowable.FlowableWindowTimed;
import io.reactivex.rxjava3.internal.operators.flowable.FlowableWithLatestFrom;
import io.reactivex.rxjava3.internal.operators.flowable.FlowableWithLatestFromMany;
import io.reactivex.rxjava3.internal.operators.flowable.FlowableZip;
import io.reactivex.rxjava3.internal.operators.flowable.FlowableZipIterable;
import io.reactivex.rxjava3.internal.operators.maybe.MaybeToFlowable;
import io.reactivex.rxjava3.internal.operators.mixed.FlowableConcatMapCompletable;
import io.reactivex.rxjava3.internal.operators.mixed.FlowableConcatMapMaybe;
import io.reactivex.rxjava3.internal.operators.mixed.FlowableConcatMapSingle;
import io.reactivex.rxjava3.internal.operators.mixed.FlowableSwitchMapCompletable;
import io.reactivex.rxjava3.internal.operators.mixed.FlowableSwitchMapMaybe;
import io.reactivex.rxjava3.internal.operators.mixed.FlowableSwitchMapSingle;
import io.reactivex.rxjava3.internal.operators.observable.ObservableFromPublisher;
import io.reactivex.rxjava3.internal.operators.single.SingleToFlowable;
import io.reactivex.rxjava3.internal.schedulers.ImmediateThinScheduler;
import io.reactivex.rxjava3.internal.subscribers.BlockingFirstSubscriber;
import io.reactivex.rxjava3.internal.subscribers.BlockingLastSubscriber;
import io.reactivex.rxjava3.internal.subscribers.DisposableAutoReleaseSubscriber;
import io.reactivex.rxjava3.internal.subscribers.ForEachWhileSubscriber;
import io.reactivex.rxjava3.internal.subscribers.FutureSubscriber;
import io.reactivex.rxjava3.internal.subscribers.LambdaSubscriber;
import io.reactivex.rxjava3.internal.subscribers.StrictSubscriber;
import io.reactivex.rxjava3.internal.util.ArrayListSupplier;
import io.reactivex.rxjava3.internal.util.ErrorMode;
import io.reactivex.rxjava3.internal.util.ExceptionHelper;
import io.reactivex.rxjava3.internal.util.HashMapSupplier;
import io.reactivex.rxjava3.operators.ScalarSupplier;
import io.reactivex.rxjava3.parallel.ParallelFlowable;
import io.reactivex.rxjava3.plugins.RxJavaPlugins;
import io.reactivex.rxjava3.schedulers.Schedulers;
import io.reactivex.rxjava3.schedulers.Timed;
import io.reactivex.rxjava3.subscribers.SafeSubscriber;
import io.reactivex.rxjava3.subscribers.TestSubscriber;
import j$.util.Optional;
import j$.util.Spliterators;
import j$.util.stream.Collector;
import j$.util.stream.Stream;
import j$.util.stream.StreamSupport;
import j00.a;
import j00.b;
import j00.c;
import java.util.Collection;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Objects;
import java.util.concurrent.Callable;
import java.util.concurrent.CompletionStage;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import org.reactivestreams.Publisher;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

public abstract class Flowable<T> implements Publisher<T> {

    /* renamed from: b  reason: collision with root package name */
    public static final int f18762b = Math.max(1, Integer.getInteger("rx3.buffer-size", 128).intValue());

    /* renamed from: io.reactivex.rxjava3.core.Flowable$1  reason: invalid class name */
    public static /* synthetic */ class AnonymousClass1 {

        /* renamed from: a  reason: collision with root package name */
        public static final /* synthetic */ int[] f18763a;

        /* JADX WARNING: Can't wrap try/catch for region: R(8:0|1|2|3|4|5|6|(3:7|8|10)) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0012 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x001d */
        /* JADX WARNING: Missing exception handler attribute for start block: B:7:0x0028 */
        static {
            /*
                io.reactivex.rxjava3.core.BackpressureStrategy[] r0 = io.reactivex.rxjava3.core.BackpressureStrategy.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                f18763a = r0
                io.reactivex.rxjava3.core.BackpressureStrategy r1 = io.reactivex.rxjava3.core.BackpressureStrategy.DROP     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                int[] r0 = f18763a     // Catch:{ NoSuchFieldError -> 0x001d }
                io.reactivex.rxjava3.core.BackpressureStrategy r1 = io.reactivex.rxjava3.core.BackpressureStrategy.LATEST     // Catch:{ NoSuchFieldError -> 0x001d }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                int[] r0 = f18763a     // Catch:{ NoSuchFieldError -> 0x0028 }
                io.reactivex.rxjava3.core.BackpressureStrategy r1 = io.reactivex.rxjava3.core.BackpressureStrategy.MISSING     // Catch:{ NoSuchFieldError -> 0x0028 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0028 }
                r2 = 3
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0028 }
            L_0x0028:
                int[] r0 = f18763a     // Catch:{ NoSuchFieldError -> 0x0033 }
                io.reactivex.rxjava3.core.BackpressureStrategy r1 = io.reactivex.rxjava3.core.BackpressureStrategy.ERROR     // Catch:{ NoSuchFieldError -> 0x0033 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0033 }
                r2 = 4
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0033 }
            L_0x0033:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: io.reactivex.rxjava3.core.Flowable.AnonymousClass1.<clinit>():void");
        }
    }

    @BackpressureSupport(BackpressureKind.PASS_THROUGH)
    @SchedulerSupport("none")
    @NonNull
    @CheckReturnValue
    public static <T> Flowable<T> amb(@NonNull Iterable<? extends Publisher<? extends T>> iterable) {
        Objects.requireNonNull(iterable, "sources is null");
        return RxJavaPlugins.onAssembly(new FlowableAmb((Publisher<? extends T>[]) null, iterable));
    }

    @BackpressureSupport(BackpressureKind.PASS_THROUGH)
    @SchedulerSupport("none")
    @SafeVarargs
    @NonNull
    @CheckReturnValue
    public static <T> Flowable<T> ambArray(@NonNull Publisher<? extends T>... publisherArr) {
        Objects.requireNonNull(publisherArr, "sources is null");
        int length = publisherArr.length;
        if (length == 0) {
            return empty();
        }
        if (length == 1) {
            return fromPublisher(publisherArr[0]);
        }
        return RxJavaPlugins.onAssembly(new FlowableAmb(publisherArr, (Iterable) null));
    }

    @CheckReturnValue
    public static int bufferSize() {
        return f18762b;
    }

    @BackpressureSupport(BackpressureKind.FULL)
    @SchedulerSupport("none")
    @NonNull
    @CheckReturnValue
    public static <T, R> Flowable<R> combineLatest(@NonNull Iterable<? extends Publisher<? extends T>> iterable, @NonNull Function<? super Object[], ? extends R> function) {
        return combineLatest(iterable, function, bufferSize());
    }

    @BackpressureSupport(BackpressureKind.FULL)
    @SchedulerSupport("none")
    @NonNull
    @CheckReturnValue
    public static <T, R> Flowable<R> combineLatestArray(@NonNull Publisher<? extends T>[] publisherArr, @NonNull Function<? super Object[], ? extends R> function) {
        return combineLatestArray(publisherArr, function, bufferSize());
    }

    @BackpressureSupport(BackpressureKind.FULL)
    @SchedulerSupport("none")
    @NonNull
    @CheckReturnValue
    public static <T, R> Flowable<R> combineLatestArrayDelayError(@NonNull Publisher<? extends T>[] publisherArr, @NonNull Function<? super Object[], ? extends R> function) {
        return combineLatestArrayDelayError(publisherArr, function, bufferSize());
    }

    @BackpressureSupport(BackpressureKind.FULL)
    @SchedulerSupport("none")
    @NonNull
    @CheckReturnValue
    public static <T, R> Flowable<R> combineLatestDelayError(@NonNull Iterable<? extends Publisher<? extends T>> iterable, @NonNull Function<? super Object[], ? extends R> function) {
        return combineLatestDelayError(iterable, function, bufferSize());
    }

    @BackpressureSupport(BackpressureKind.FULL)
    @SchedulerSupport("none")
    @NonNull
    @CheckReturnValue
    public static <T> Flowable<T> concat(@NonNull Iterable<? extends Publisher<? extends T>> iterable) {
        Objects.requireNonNull(iterable, "sources is null");
        return fromIterable(iterable).concatMapDelayError(Functions.identity(), false, 2);
    }

    @BackpressureSupport(BackpressureKind.FULL)
    @SchedulerSupport("none")
    @SafeVarargs
    @NonNull
    @CheckReturnValue
    public static <T> Flowable<T> concatArray(@NonNull Publisher<? extends T>... publisherArr) {
        Objects.requireNonNull(publisherArr, "sources is null");
        if (publisherArr.length == 0) {
            return empty();
        }
        if (publisherArr.length == 1) {
            return fromPublisher(publisherArr[0]);
        }
        return RxJavaPlugins.onAssembly(new FlowableConcatArray(publisherArr, false));
    }

    @BackpressureSupport(BackpressureKind.FULL)
    @SchedulerSupport("none")
    @SafeVarargs
    @NonNull
    @CheckReturnValue
    public static <T> Flowable<T> concatArrayDelayError(@NonNull Publisher<? extends T>... publisherArr) {
        Objects.requireNonNull(publisherArr, "sources is null");
        if (publisherArr.length == 0) {
            return empty();
        }
        if (publisherArr.length == 1) {
            return fromPublisher(publisherArr[0]);
        }
        return RxJavaPlugins.onAssembly(new FlowableConcatArray(publisherArr, true));
    }

    @BackpressureSupport(BackpressureKind.FULL)
    @SchedulerSupport("none")
    @SafeVarargs
    @NonNull
    @CheckReturnValue
    public static <T> Flowable<T> concatArrayEager(@NonNull Publisher<? extends T>... publisherArr) {
        return concatArrayEager(bufferSize(), bufferSize(), publisherArr);
    }

    @BackpressureSupport(BackpressureKind.FULL)
    @SchedulerSupport("none")
    @SafeVarargs
    @NonNull
    @CheckReturnValue
    public static <T> Flowable<T> concatArrayEagerDelayError(@NonNull Publisher<? extends T>... publisherArr) {
        return concatArrayEagerDelayError(bufferSize(), bufferSize(), publisherArr);
    }

    @BackpressureSupport(BackpressureKind.FULL)
    @SchedulerSupport("none")
    @NonNull
    @CheckReturnValue
    public static <T> Flowable<T> concatDelayError(@NonNull Iterable<? extends Publisher<? extends T>> iterable) {
        Objects.requireNonNull(iterable, "sources is null");
        return fromIterable(iterable).concatMapDelayError(Functions.identity());
    }

    @BackpressureSupport(BackpressureKind.FULL)
    @SchedulerSupport("none")
    @NonNull
    @CheckReturnValue
    public static <T> Flowable<T> concatEager(@NonNull Iterable<? extends Publisher<? extends T>> iterable) {
        return concatEager(iterable, bufferSize(), bufferSize());
    }

    @BackpressureSupport(BackpressureKind.FULL)
    @SchedulerSupport("none")
    @NonNull
    @CheckReturnValue
    public static <T> Flowable<T> concatEagerDelayError(@NonNull Iterable<? extends Publisher<? extends T>> iterable) {
        return concatEagerDelayError(iterable, bufferSize(), bufferSize());
    }

    @BackpressureSupport(BackpressureKind.SPECIAL)
    @SchedulerSupport("none")
    @NonNull
    @CheckReturnValue
    public static <T> Flowable<T> create(@NonNull FlowableOnSubscribe<T> flowableOnSubscribe, @NonNull BackpressureStrategy backpressureStrategy) {
        Objects.requireNonNull(flowableOnSubscribe, "source is null");
        Objects.requireNonNull(backpressureStrategy, "mode is null");
        return RxJavaPlugins.onAssembly(new FlowableCreate(flowableOnSubscribe, backpressureStrategy));
    }

    @BackpressureSupport(BackpressureKind.PASS_THROUGH)
    @SchedulerSupport("none")
    @NonNull
    @CheckReturnValue
    public static <T> Flowable<T> defer(@NonNull Supplier<? extends Publisher<? extends T>> supplier) {
        Objects.requireNonNull(supplier, "supplier is null");
        return RxJavaPlugins.onAssembly(new FlowableDefer(supplier));
    }

    @BackpressureSupport(BackpressureKind.PASS_THROUGH)
    @SchedulerSupport("none")
    @NonNull
    @CheckReturnValue
    private Flowable<T> doOnEach(@NonNull Consumer<? super T> consumer, @NonNull Consumer<? super Throwable> consumer2, Action action, Action action2) {
        Objects.requireNonNull(consumer, "onNext is null");
        Objects.requireNonNull(consumer2, "onError is null");
        Objects.requireNonNull(action, "onComplete is null");
        Objects.requireNonNull(action2, "onAfterTerminate is null");
        return RxJavaPlugins.onAssembly(new FlowableDoOnEach(this, consumer, consumer2, action, action2));
    }

    @BackpressureSupport(BackpressureKind.PASS_THROUGH)
    @SchedulerSupport("none")
    @NonNull
    @CheckReturnValue
    public static <T> Flowable<T> empty() {
        return RxJavaPlugins.onAssembly(FlowableEmpty.INSTANCE);
    }

    @BackpressureSupport(BackpressureKind.PASS_THROUGH)
    @SchedulerSupport("none")
    @NonNull
    @CheckReturnValue
    public static <T> Flowable<T> error(@NonNull Supplier<? extends Throwable> supplier) {
        Objects.requireNonNull(supplier, "supplier is null");
        return RxJavaPlugins.onAssembly(new FlowableError(supplier));
    }

    @BackpressureSupport(BackpressureKind.PASS_THROUGH)
    @SchedulerSupport("none")
    @NonNull
    @CheckReturnValue
    public static <T> Flowable<T> fromAction(@NonNull Action action) {
        Objects.requireNonNull(action, "action is null");
        return RxJavaPlugins.onAssembly(new FlowableFromAction(action));
    }

    @BackpressureSupport(BackpressureKind.FULL)
    @SchedulerSupport("none")
    @SafeVarargs
    @NonNull
    @CheckReturnValue
    public static <T> Flowable<T> fromArray(@NonNull T... tArr) {
        Objects.requireNonNull(tArr, "items is null");
        if (tArr.length == 0) {
            return empty();
        }
        if (tArr.length == 1) {
            return just(tArr[0]);
        }
        return RxJavaPlugins.onAssembly(new FlowableFromArray(tArr));
    }

    @BackpressureSupport(BackpressureKind.FULL)
    @SchedulerSupport("none")
    @NonNull
    @CheckReturnValue
    public static <T> Flowable<T> fromCallable(@NonNull Callable<? extends T> callable) {
        Objects.requireNonNull(callable, "callable is null");
        return RxJavaPlugins.onAssembly(new FlowableFromCallable(callable));
    }

    @BackpressureSupport(BackpressureKind.PASS_THROUGH)
    @SchedulerSupport("none")
    @NonNull
    @CheckReturnValue
    public static <T> Flowable<T> fromCompletable(@NonNull CompletableSource completableSource) {
        Objects.requireNonNull(completableSource, "completableSource is null");
        return RxJavaPlugins.onAssembly(new FlowableFromCompletable(completableSource));
    }

    @BackpressureSupport(BackpressureKind.FULL)
    @SchedulerSupport("none")
    @NonNull
    @CheckReturnValue
    public static <T> Flowable<T> fromCompletionStage(@NonNull CompletionStage<T> completionStage) {
        Objects.requireNonNull(completionStage, "stage is null");
        return RxJavaPlugins.onAssembly(new FlowableFromCompletionStage(completionStage));
    }

    @BackpressureSupport(BackpressureKind.FULL)
    @SchedulerSupport("none")
    @NonNull
    @CheckReturnValue
    public static <T> Flowable<T> fromFuture(@NonNull Future<? extends T> future) {
        Objects.requireNonNull(future, "future is null");
        return RxJavaPlugins.onAssembly(new FlowableFromFuture(future, 0, (TimeUnit) null));
    }

    @BackpressureSupport(BackpressureKind.FULL)
    @SchedulerSupport("none")
    @NonNull
    @CheckReturnValue
    public static <T> Flowable<T> fromIterable(@NonNull Iterable<? extends T> iterable) {
        Objects.requireNonNull(iterable, "source is null");
        return RxJavaPlugins.onAssembly(new FlowableFromIterable(iterable));
    }

    @BackpressureSupport(BackpressureKind.FULL)
    @SchedulerSupport("none")
    @NonNull
    @CheckReturnValue
    public static <T> Flowable<T> fromMaybe(@NonNull MaybeSource<T> maybeSource) {
        Objects.requireNonNull(maybeSource, "maybe is null");
        return RxJavaPlugins.onAssembly(new MaybeToFlowable(maybeSource));
    }

    @BackpressureSupport(BackpressureKind.SPECIAL)
    @SchedulerSupport("none")
    @NonNull
    @CheckReturnValue
    public static <T> Flowable<T> fromObservable(@NonNull ObservableSource<T> observableSource, @NonNull BackpressureStrategy backpressureStrategy) {
        Objects.requireNonNull(observableSource, "source is null");
        Objects.requireNonNull(backpressureStrategy, "strategy is null");
        FlowableFromObservable flowableFromObservable = new FlowableFromObservable(observableSource);
        int i11 = AnonymousClass1.f18763a[backpressureStrategy.ordinal()];
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

    @BackpressureSupport(BackpressureKind.FULL)
    @SchedulerSupport("none")
    @NonNull
    @CheckReturnValue
    public static <T> Flowable<T> fromOptional(@NonNull Optional<T> optional) {
        Objects.requireNonNull(optional, "optional is null");
        return (Flowable) optional.map(new b()).orElseGet(new c());
    }

    @BackpressureSupport(BackpressureKind.PASS_THROUGH)
    @SchedulerSupport("none")
    @NonNull
    @CheckReturnValue
    public static <T> Flowable<T> fromPublisher(@NonNull Publisher<? extends T> publisher) {
        if (publisher instanceof Flowable) {
            return RxJavaPlugins.onAssembly((Flowable) publisher);
        }
        Objects.requireNonNull(publisher, "publisher is null");
        return RxJavaPlugins.onAssembly(new FlowableFromPublisher(publisher));
    }

    @BackpressureSupport(BackpressureKind.PASS_THROUGH)
    @SchedulerSupport("none")
    @NonNull
    @CheckReturnValue
    public static <T> Flowable<T> fromRunnable(@NonNull Runnable runnable) {
        Objects.requireNonNull(runnable, "run is null");
        return RxJavaPlugins.onAssembly(new FlowableFromRunnable(runnable));
    }

    @BackpressureSupport(BackpressureKind.FULL)
    @SchedulerSupport("none")
    @NonNull
    @CheckReturnValue
    public static <T> Flowable<T> fromSingle(@NonNull SingleSource<T> singleSource) {
        Objects.requireNonNull(singleSource, "source is null");
        return RxJavaPlugins.onAssembly(new SingleToFlowable(singleSource));
    }

    @BackpressureSupport(BackpressureKind.FULL)
    @SchedulerSupport("none")
    @NonNull
    @CheckReturnValue
    public static <T> Flowable<T> fromStream(@NonNull Stream<T> stream) {
        Objects.requireNonNull(stream, "stream is null");
        return RxJavaPlugins.onAssembly(new FlowableFromStream(stream));
    }

    @BackpressureSupport(BackpressureKind.FULL)
    @SchedulerSupport("none")
    @NonNull
    @CheckReturnValue
    public static <T> Flowable<T> fromSupplier(@NonNull Supplier<? extends T> supplier) {
        Objects.requireNonNull(supplier, "supplier is null");
        return RxJavaPlugins.onAssembly(new FlowableFromSupplier(supplier));
    }

    @BackpressureSupport(BackpressureKind.FULL)
    @SchedulerSupport("none")
    @NonNull
    @CheckReturnValue
    public static <T> Flowable<T> generate(@NonNull Consumer<Emitter<T>> consumer) {
        Objects.requireNonNull(consumer, "generator is null");
        return generate(Functions.nullSupplier(), FlowableInternalHelper.simpleGenerator(consumer), Functions.emptyConsumer());
    }

    @BackpressureSupport(BackpressureKind.ERROR)
    @SchedulerSupport("io.reactivex:computation")
    @NonNull
    @CheckReturnValue
    public static Flowable<Long> interval(long j11, long j12, @NonNull TimeUnit timeUnit) {
        return interval(j11, j12, timeUnit, Schedulers.computation());
    }

    @BackpressureSupport(BackpressureKind.ERROR)
    @SchedulerSupport("io.reactivex:computation")
    @NonNull
    @CheckReturnValue
    public static Flowable<Long> intervalRange(long j11, long j12, long j13, long j14, @NonNull TimeUnit timeUnit) {
        return intervalRange(j11, j12, j13, j14, timeUnit, Schedulers.computation());
    }

    @BackpressureSupport(BackpressureKind.FULL)
    @SchedulerSupport("none")
    @NonNull
    @CheckReturnValue
    public static <T> Flowable<T> just(T t11) {
        Objects.requireNonNull(t11, "item is null");
        return RxJavaPlugins.onAssembly(new FlowableJust(t11));
    }

    @BackpressureSupport(BackpressureKind.FULL)
    @SchedulerSupport("none")
    @NonNull
    @CheckReturnValue
    public static <T> Flowable<T> merge(@NonNull Iterable<? extends Publisher<? extends T>> iterable, int i11, int i12) {
        return fromIterable(iterable).flatMap(Functions.identity(), false, i11, i12);
    }

    @BackpressureSupport(BackpressureKind.FULL)
    @SchedulerSupport("none")
    @SafeVarargs
    @NonNull
    @CheckReturnValue
    public static <T> Flowable<T> mergeArray(int i11, int i12, @NonNull Publisher<? extends T>... publisherArr) {
        return fromArray(publisherArr).flatMap(Functions.identity(), false, i11, i12);
    }

    @BackpressureSupport(BackpressureKind.FULL)
    @SchedulerSupport("none")
    @SafeVarargs
    @NonNull
    @CheckReturnValue
    public static <T> Flowable<T> mergeArrayDelayError(int i11, int i12, @NonNull Publisher<? extends T>... publisherArr) {
        return fromArray(publisherArr).flatMap(Functions.identity(), true, i11, i12);
    }

    @BackpressureSupport(BackpressureKind.FULL)
    @SchedulerSupport("none")
    @NonNull
    @CheckReturnValue
    public static <T> Flowable<T> mergeDelayError(@NonNull Iterable<? extends Publisher<? extends T>> iterable) {
        return fromIterable(iterable).flatMap(Functions.identity(), true);
    }

    @BackpressureSupport(BackpressureKind.PASS_THROUGH)
    @SchedulerSupport("none")
    @NonNull
    @CheckReturnValue
    public static <T> Flowable<T> never() {
        return RxJavaPlugins.onAssembly(FlowableNever.INSTANCE);
    }

    @BackpressureSupport(BackpressureKind.FULL)
    @SchedulerSupport("none")
    @NonNull
    @CheckReturnValue
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

    @BackpressureSupport(BackpressureKind.FULL)
    @SchedulerSupport("none")
    @NonNull
    @CheckReturnValue
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

    @BackpressureSupport(BackpressureKind.FULL)
    @SchedulerSupport("none")
    @NonNull
    @CheckReturnValue
    public static <T> Single<Boolean> sequenceEqual(@NonNull Publisher<? extends T> publisher, @NonNull Publisher<? extends T> publisher2) {
        return sequenceEqual(publisher, publisher2, ObjectHelper.equalsPredicate(), bufferSize());
    }

    @BackpressureSupport(BackpressureKind.FULL)
    @SchedulerSupport("none")
    @NonNull
    @CheckReturnValue
    public static <T> Flowable<T> switchOnNext(@NonNull Publisher<? extends Publisher<? extends T>> publisher, int i11) {
        return fromPublisher(publisher).switchMap(Functions.identity(), i11);
    }

    @BackpressureSupport(BackpressureKind.FULL)
    @SchedulerSupport("none")
    @NonNull
    @CheckReturnValue
    public static <T> Flowable<T> switchOnNextDelayError(@NonNull Publisher<? extends Publisher<? extends T>> publisher) {
        return switchOnNextDelayError(publisher, bufferSize());
    }

    private Flowable<T> timeout0(long j11, TimeUnit timeUnit, Publisher<? extends T> publisher, Scheduler scheduler) {
        Objects.requireNonNull(timeUnit, "unit is null");
        Objects.requireNonNull(scheduler, "scheduler is null");
        return RxJavaPlugins.onAssembly(new FlowableTimeoutTimed(this, j11, timeUnit, scheduler, publisher));
    }

    @BackpressureSupport(BackpressureKind.ERROR)
    @SchedulerSupport("io.reactivex:computation")
    @NonNull
    @CheckReturnValue
    public static Flowable<Long> timer(long j11, @NonNull TimeUnit timeUnit) {
        return timer(j11, timeUnit, Schedulers.computation());
    }

    @BackpressureSupport(BackpressureKind.NONE)
    @SchedulerSupport("none")
    @NonNull
    @CheckReturnValue
    public static <T> Flowable<T> unsafeCreate(@NonNull Publisher<T> publisher) {
        Objects.requireNonNull(publisher, "onSubscribe is null");
        if (!(publisher instanceof Flowable)) {
            return RxJavaPlugins.onAssembly(new FlowableFromPublisher(publisher));
        }
        throw new IllegalArgumentException("unsafeCreate(Flowable) should be upgraded");
    }

    @BackpressureSupport(BackpressureKind.PASS_THROUGH)
    @SchedulerSupport("none")
    @NonNull
    @CheckReturnValue
    public static <T, D> Flowable<T> using(@NonNull Supplier<? extends D> supplier, @NonNull Function<? super D, ? extends Publisher<? extends T>> function, @NonNull Consumer<? super D> consumer) {
        return using(supplier, function, consumer, true);
    }

    @BackpressureSupport(BackpressureKind.FULL)
    @SchedulerSupport("none")
    @NonNull
    @CheckReturnValue
    public static <T, R> Flowable<R> zip(@NonNull Iterable<? extends Publisher<? extends T>> iterable, @NonNull Function<? super Object[], ? extends R> function) {
        Objects.requireNonNull(function, "zipper is null");
        Objects.requireNonNull(iterable, "sources is null");
        return RxJavaPlugins.onAssembly(new FlowableZip((Publisher<? extends T>[]) null, iterable, function, bufferSize(), false));
    }

    @BackpressureSupport(BackpressureKind.FULL)
    @SchedulerSupport("none")
    @SafeVarargs
    @NonNull
    @CheckReturnValue
    public static <T, R> Flowable<R> zipArray(@NonNull Function<? super Object[], ? extends R> function, boolean z11, int i11, @NonNull Publisher<? extends T>... publisherArr) {
        Objects.requireNonNull(publisherArr, "sources is null");
        if (publisherArr.length == 0) {
            return empty();
        }
        Objects.requireNonNull(function, "zipper is null");
        ObjectHelper.verifyPositive(i11, "bufferSize");
        return RxJavaPlugins.onAssembly(new FlowableZip(publisherArr, (Iterable) null, function, i11, z11));
    }

    public <R> Flowable<R> a(Function<? super T, ? extends Publisher<? extends R>> function, int i11, boolean z11) {
        Objects.requireNonNull(function, "mapper is null");
        ObjectHelper.verifyPositive(i11, "bufferSize");
        if (!(this instanceof ScalarSupplier)) {
            return RxJavaPlugins.onAssembly(new FlowableSwitchMap(this, function, i11, z11));
        }
        Object obj = ((ScalarSupplier) this).get();
        if (obj == null) {
            return empty();
        }
        return FlowableScalarXMap.scalarXMap(obj, function);
    }

    @BackpressureSupport(BackpressureKind.UNBOUNDED_IN)
    @SchedulerSupport("none")
    @NonNull
    @CheckReturnValue
    public final Single<Boolean> all(@NonNull Predicate<? super T> predicate) {
        Objects.requireNonNull(predicate, "predicate is null");
        return RxJavaPlugins.onAssembly(new FlowableAllSingle(this, predicate));
    }

    @BackpressureSupport(BackpressureKind.FULL)
    @SchedulerSupport("none")
    @NonNull
    @CheckReturnValue
    public final Flowable<T> ambWith(@NonNull Publisher<? extends T> publisher) {
        Objects.requireNonNull(publisher, "other is null");
        return ambArray(this, publisher);
    }

    @BackpressureSupport(BackpressureKind.UNBOUNDED_IN)
    @SchedulerSupport("none")
    @NonNull
    @CheckReturnValue
    public final Single<Boolean> any(@NonNull Predicate<? super T> predicate) {
        Objects.requireNonNull(predicate, "predicate is null");
        return RxJavaPlugins.onAssembly(new FlowableAnySingle(this, predicate));
    }

    @BackpressureSupport(BackpressureKind.UNBOUNDED_IN)
    @SchedulerSupport("none")
    @NonNull
    @CheckReturnValue
    public final T blockingFirst() {
        BlockingFirstSubscriber blockingFirstSubscriber = new BlockingFirstSubscriber();
        subscribe(blockingFirstSubscriber);
        T blockingGet = blockingFirstSubscriber.blockingGet();
        if (blockingGet != null) {
            return blockingGet;
        }
        throw new NoSuchElementException();
    }

    @BackpressureSupport(BackpressureKind.FULL)
    @SchedulerSupport("none")
    public final void blockingForEach(@NonNull Consumer<? super T> consumer) {
        blockingForEach(consumer, bufferSize());
    }

    @BackpressureSupport(BackpressureKind.FULL)
    @SchedulerSupport("none")
    @NonNull
    @CheckReturnValue
    public final Iterable<T> blockingIterable() {
        return blockingIterable(bufferSize());
    }

    @BackpressureSupport(BackpressureKind.UNBOUNDED_IN)
    @SchedulerSupport("none")
    @NonNull
    @CheckReturnValue
    public final T blockingLast() {
        BlockingLastSubscriber blockingLastSubscriber = new BlockingLastSubscriber();
        subscribe(blockingLastSubscriber);
        T blockingGet = blockingLastSubscriber.blockingGet();
        if (blockingGet != null) {
            return blockingGet;
        }
        throw new NoSuchElementException();
    }

    @BackpressureSupport(BackpressureKind.UNBOUNDED_IN)
    @SchedulerSupport("none")
    @NonNull
    @CheckReturnValue
    public final Iterable<T> blockingLatest() {
        return new BlockingFlowableLatest(this);
    }

    @BackpressureSupport(BackpressureKind.UNBOUNDED_IN)
    @SchedulerSupport("none")
    @NonNull
    @CheckReturnValue
    public final Iterable<T> blockingMostRecent(@NonNull T t11) {
        Objects.requireNonNull(t11, "initialItem is null");
        return new BlockingFlowableMostRecent(this, t11);
    }

    @BackpressureSupport(BackpressureKind.UNBOUNDED_IN)
    @SchedulerSupport("none")
    @NonNull
    @CheckReturnValue
    public final Iterable<T> blockingNext() {
        return new BlockingFlowableNext(this);
    }

    @BackpressureSupport(BackpressureKind.UNBOUNDED_IN)
    @SchedulerSupport("none")
    @NonNull
    @CheckReturnValue
    public final T blockingSingle() {
        return singleOrError().blockingGet();
    }

    @BackpressureSupport(BackpressureKind.FULL)
    @SchedulerSupport("none")
    @NonNull
    @CheckReturnValue
    public final Stream<T> blockingStream() {
        return blockingStream(bufferSize());
    }

    @BackpressureSupport(BackpressureKind.UNBOUNDED_IN)
    @SchedulerSupport("none")
    public final void blockingSubscribe() {
        FlowableBlockingSubscribe.subscribe(this);
    }

    @BackpressureSupport(BackpressureKind.FULL)
    @SchedulerSupport("none")
    @NonNull
    @CheckReturnValue
    public final Flowable<List<T>> buffer(int i11) {
        return buffer(i11, i11);
    }

    @BackpressureSupport(BackpressureKind.FULL)
    @SchedulerSupport("none")
    @NonNull
    @CheckReturnValue
    public final Flowable<T> cache() {
        return cacheWithInitialCapacity(16);
    }

    @BackpressureSupport(BackpressureKind.FULL)
    @SchedulerSupport("none")
    @NonNull
    @CheckReturnValue
    public final Flowable<T> cacheWithInitialCapacity(int i11) {
        ObjectHelper.verifyPositive(i11, "initialCapacity");
        return RxJavaPlugins.onAssembly(new FlowableCache(this, i11));
    }

    @BackpressureSupport(BackpressureKind.PASS_THROUGH)
    @SchedulerSupport("none")
    @NonNull
    @CheckReturnValue
    public final <U> Flowable<U> cast(@NonNull Class<U> cls) {
        Objects.requireNonNull(cls, "clazz is null");
        return map(Functions.castFunction(cls));
    }

    @BackpressureSupport(BackpressureKind.UNBOUNDED_IN)
    @SchedulerSupport("none")
    @NonNull
    @CheckReturnValue
    public final <U> Single<U> collect(@NonNull Supplier<? extends U> supplier, @NonNull BiConsumer<? super U, ? super T> biConsumer) {
        Objects.requireNonNull(supplier, "initialItemSupplier is null");
        Objects.requireNonNull(biConsumer, "collector is null");
        return RxJavaPlugins.onAssembly(new FlowableCollectSingle(this, supplier, biConsumer));
    }

    @BackpressureSupport(BackpressureKind.UNBOUNDED_IN)
    @SchedulerSupport("none")
    @NonNull
    @CheckReturnValue
    public final <U> Single<U> collectInto(U u11, @NonNull BiConsumer<? super U, ? super T> biConsumer) {
        Objects.requireNonNull(u11, "initialItem is null");
        return collect(Functions.justSupplier(u11), biConsumer);
    }

    @BackpressureSupport(BackpressureKind.PASS_THROUGH)
    @SchedulerSupport("none")
    @NonNull
    @CheckReturnValue
    public final <R> Flowable<R> compose(@NonNull FlowableTransformer<? super T, ? extends R> flowableTransformer) {
        Objects.requireNonNull(flowableTransformer, "composer is null");
        return fromPublisher(flowableTransformer.apply(this));
    }

    @BackpressureSupport(BackpressureKind.FULL)
    @SchedulerSupport("none")
    @NonNull
    @CheckReturnValue
    public final <R> Flowable<R> concatMap(@NonNull Function<? super T, ? extends Publisher<? extends R>> function) {
        return concatMap(function, 2);
    }

    @BackpressureSupport(BackpressureKind.FULL)
    @SchedulerSupport("none")
    @NonNull
    @CheckReturnValue
    public final Completable concatMapCompletable(@NonNull Function<? super T, ? extends CompletableSource> function) {
        return concatMapCompletable(function, 2);
    }

    @BackpressureSupport(BackpressureKind.FULL)
    @SchedulerSupport("none")
    @NonNull
    @CheckReturnValue
    public final Completable concatMapCompletableDelayError(@NonNull Function<? super T, ? extends CompletableSource> function) {
        return concatMapCompletableDelayError(function, true, 2);
    }

    @BackpressureSupport(BackpressureKind.FULL)
    @SchedulerSupport("none")
    @NonNull
    @CheckReturnValue
    public final <R> Flowable<R> concatMapDelayError(@NonNull Function<? super T, ? extends Publisher<? extends R>> function) {
        return concatMapDelayError(function, true, 2);
    }

    @BackpressureSupport(BackpressureKind.FULL)
    @SchedulerSupport("none")
    @NonNull
    @CheckReturnValue
    public final <R> Flowable<R> concatMapEager(@NonNull Function<? super T, ? extends Publisher<? extends R>> function) {
        return concatMapEager(function, bufferSize(), bufferSize());
    }

    @BackpressureSupport(BackpressureKind.FULL)
    @SchedulerSupport("none")
    @NonNull
    @CheckReturnValue
    public final <R> Flowable<R> concatMapEagerDelayError(@NonNull Function<? super T, ? extends Publisher<? extends R>> function, boolean z11) {
        return concatMapEagerDelayError(function, z11, bufferSize(), bufferSize());
    }

    @BackpressureSupport(BackpressureKind.FULL)
    @SchedulerSupport("none")
    @NonNull
    @CheckReturnValue
    public final <U> Flowable<U> concatMapIterable(@NonNull Function<? super T, ? extends Iterable<? extends U>> function) {
        return concatMapIterable(function, 2);
    }

    @BackpressureSupport(BackpressureKind.FULL)
    @SchedulerSupport("none")
    @NonNull
    @CheckReturnValue
    public final <R> Flowable<R> concatMapMaybe(@NonNull Function<? super T, ? extends MaybeSource<? extends R>> function) {
        return concatMapMaybe(function, 2);
    }

    @BackpressureSupport(BackpressureKind.FULL)
    @SchedulerSupport("none")
    @NonNull
    @CheckReturnValue
    public final <R> Flowable<R> concatMapMaybeDelayError(@NonNull Function<? super T, ? extends MaybeSource<? extends R>> function) {
        return concatMapMaybeDelayError(function, true, 2);
    }

    @BackpressureSupport(BackpressureKind.FULL)
    @SchedulerSupport("none")
    @NonNull
    @CheckReturnValue
    public final <R> Flowable<R> concatMapSingle(@NonNull Function<? super T, ? extends SingleSource<? extends R>> function) {
        return concatMapSingle(function, 2);
    }

    @BackpressureSupport(BackpressureKind.FULL)
    @SchedulerSupport("none")
    @NonNull
    @CheckReturnValue
    public final <R> Flowable<R> concatMapSingleDelayError(@NonNull Function<? super T, ? extends SingleSource<? extends R>> function) {
        return concatMapSingleDelayError(function, true, 2);
    }

    @BackpressureSupport(BackpressureKind.FULL)
    @SchedulerSupport("none")
    @NonNull
    @CheckReturnValue
    public final <R> Flowable<R> concatMapStream(@NonNull Function<? super T, ? extends Stream<? extends R>> function) {
        return flatMapStream(function, bufferSize());
    }

    @BackpressureSupport(BackpressureKind.FULL)
    @SchedulerSupport("none")
    @NonNull
    @CheckReturnValue
    public final Flowable<T> concatWith(@NonNull Publisher<? extends T> publisher) {
        Objects.requireNonNull(publisher, "other is null");
        return concat(this, (Flowable) publisher);
    }

    @BackpressureSupport(BackpressureKind.UNBOUNDED_IN)
    @SchedulerSupport("none")
    @NonNull
    @CheckReturnValue
    public final Single<Boolean> contains(@NonNull Object obj) {
        Objects.requireNonNull(obj, "item is null");
        return any(Functions.equalsWith(obj));
    }

    @BackpressureSupport(BackpressureKind.UNBOUNDED_IN)
    @SchedulerSupport("none")
    @NonNull
    @CheckReturnValue
    public final Single<Long> count() {
        return RxJavaPlugins.onAssembly(new FlowableCountSingle(this));
    }

    @BackpressureSupport(BackpressureKind.ERROR)
    @SchedulerSupport("none")
    @NonNull
    @CheckReturnValue
    public final <U> Flowable<T> debounce(@NonNull Function<? super T, ? extends Publisher<U>> function) {
        Objects.requireNonNull(function, "debounceIndicator is null");
        return RxJavaPlugins.onAssembly(new FlowableDebounce(this, function));
    }

    @BackpressureSupport(BackpressureKind.FULL)
    @SchedulerSupport("none")
    @NonNull
    @CheckReturnValue
    public final Flowable<T> defaultIfEmpty(@NonNull T t11) {
        Objects.requireNonNull(t11, "defaultItem is null");
        return switchIfEmpty(just(t11));
    }

    @BackpressureSupport(BackpressureKind.FULL)
    @SchedulerSupport("none")
    @NonNull
    @CheckReturnValue
    public final <U> Flowable<T> delay(@NonNull Function<? super T, ? extends Publisher<U>> function) {
        Objects.requireNonNull(function, "itemDelayIndicator is null");
        return flatMap(FlowableInternalHelper.itemDelay(function));
    }

    @BackpressureSupport(BackpressureKind.FULL)
    @SchedulerSupport("none")
    @NonNull
    @CheckReturnValue
    public final <U> Flowable<T> delaySubscription(@NonNull Publisher<U> publisher) {
        Objects.requireNonNull(publisher, "subscriptionIndicator is null");
        return RxJavaPlugins.onAssembly(new FlowableDelaySubscriptionOther(this, publisher));
    }

    @BackpressureSupport(BackpressureKind.PASS_THROUGH)
    @SchedulerSupport("none")
    @NonNull
    @CheckReturnValue
    public final <R> Flowable<R> dematerialize(@NonNull Function<? super T, Notification<R>> function) {
        Objects.requireNonNull(function, "selector is null");
        return RxJavaPlugins.onAssembly(new FlowableDematerialize(this, function));
    }

    @BackpressureSupport(BackpressureKind.FULL)
    @SchedulerSupport("none")
    @NonNull
    @CheckReturnValue
    public final Flowable<T> distinct() {
        return distinct(Functions.identity(), Functions.createHashSet());
    }

    @BackpressureSupport(BackpressureKind.FULL)
    @SchedulerSupport("none")
    @NonNull
    @CheckReturnValue
    public final Flowable<T> distinctUntilChanged() {
        return distinctUntilChanged(Functions.identity());
    }

    @BackpressureSupport(BackpressureKind.PASS_THROUGH)
    @SchedulerSupport("none")
    @NonNull
    @CheckReturnValue
    public final Flowable<T> doAfterNext(@NonNull Consumer<? super T> consumer) {
        Objects.requireNonNull(consumer, "onAfterNext is null");
        return RxJavaPlugins.onAssembly(new FlowableDoAfterNext(this, consumer));
    }

    @BackpressureSupport(BackpressureKind.PASS_THROUGH)
    @SchedulerSupport("none")
    @NonNull
    @CheckReturnValue
    public final Flowable<T> doAfterTerminate(@NonNull Action action) {
        return doOnEach(Functions.emptyConsumer(), Functions.emptyConsumer(), Functions.EMPTY_ACTION, action);
    }

    @BackpressureSupport(BackpressureKind.PASS_THROUGH)
    @SchedulerSupport("none")
    @NonNull
    @CheckReturnValue
    public final Flowable<T> doFinally(@NonNull Action action) {
        Objects.requireNonNull(action, "onFinally is null");
        return RxJavaPlugins.onAssembly(new FlowableDoFinally(this, action));
    }

    @BackpressureSupport(BackpressureKind.PASS_THROUGH)
    @SchedulerSupport("none")
    @NonNull
    @CheckReturnValue
    public final Flowable<T> doOnCancel(@NonNull Action action) {
        return doOnLifecycle(Functions.emptyConsumer(), Functions.EMPTY_LONG_CONSUMER, action);
    }

    @BackpressureSupport(BackpressureKind.PASS_THROUGH)
    @SchedulerSupport("none")
    @NonNull
    @CheckReturnValue
    public final Flowable<T> doOnComplete(@NonNull Action action) {
        return doOnEach(Functions.emptyConsumer(), Functions.emptyConsumer(), action, Functions.EMPTY_ACTION);
    }

    @BackpressureSupport(BackpressureKind.PASS_THROUGH)
    @SchedulerSupport("none")
    @NonNull
    @CheckReturnValue
    public final Flowable<T> doOnError(@NonNull Consumer<? super Throwable> consumer) {
        Consumer emptyConsumer = Functions.emptyConsumer();
        Action action = Functions.EMPTY_ACTION;
        return doOnEach(emptyConsumer, consumer, action, action);
    }

    @BackpressureSupport(BackpressureKind.PASS_THROUGH)
    @SchedulerSupport("none")
    @NonNull
    @CheckReturnValue
    public final Flowable<T> doOnLifecycle(@NonNull Consumer<? super Subscription> consumer, @NonNull LongConsumer longConsumer, @NonNull Action action) {
        Objects.requireNonNull(consumer, "onSubscribe is null");
        Objects.requireNonNull(longConsumer, "onRequest is null");
        Objects.requireNonNull(action, "onCancel is null");
        return RxJavaPlugins.onAssembly(new FlowableDoOnLifecycle(this, consumer, longConsumer, action));
    }

    @BackpressureSupport(BackpressureKind.PASS_THROUGH)
    @SchedulerSupport("none")
    @NonNull
    @CheckReturnValue
    public final Flowable<T> doOnNext(@NonNull Consumer<? super T> consumer) {
        Consumer emptyConsumer = Functions.emptyConsumer();
        Action action = Functions.EMPTY_ACTION;
        return doOnEach(consumer, emptyConsumer, action, action);
    }

    @BackpressureSupport(BackpressureKind.PASS_THROUGH)
    @SchedulerSupport("none")
    @NonNull
    @CheckReturnValue
    public final Flowable<T> doOnRequest(@NonNull LongConsumer longConsumer) {
        return doOnLifecycle(Functions.emptyConsumer(), longConsumer, Functions.EMPTY_ACTION);
    }

    @BackpressureSupport(BackpressureKind.PASS_THROUGH)
    @SchedulerSupport("none")
    @NonNull
    @CheckReturnValue
    public final Flowable<T> doOnSubscribe(@NonNull Consumer<? super Subscription> consumer) {
        return doOnLifecycle(consumer, Functions.EMPTY_LONG_CONSUMER, Functions.EMPTY_ACTION);
    }

    @BackpressureSupport(BackpressureKind.PASS_THROUGH)
    @SchedulerSupport("none")
    @NonNull
    @CheckReturnValue
    public final Flowable<T> doOnTerminate(@NonNull Action action) {
        return doOnEach(Functions.emptyConsumer(), Functions.actionConsumer(action), action, Functions.EMPTY_ACTION);
    }

    @BackpressureSupport(BackpressureKind.FULL)
    @SchedulerSupport("none")
    @NonNull
    @CheckReturnValue
    public final Maybe<T> elementAt(long j11) {
        if (j11 >= 0) {
            return RxJavaPlugins.onAssembly(new FlowableElementAtMaybe(this, j11));
        }
        throw new IndexOutOfBoundsException("index >= 0 required but it was " + j11);
    }

    @BackpressureSupport(BackpressureKind.FULL)
    @SchedulerSupport("none")
    @NonNull
    @CheckReturnValue
    public final Single<T> elementAtOrError(long j11) {
        if (j11 >= 0) {
            return RxJavaPlugins.onAssembly(new FlowableElementAtSingle(this, j11, null));
        }
        throw new IndexOutOfBoundsException("index >= 0 required but it was " + j11);
    }

    @BackpressureSupport(BackpressureKind.PASS_THROUGH)
    @SchedulerSupport("none")
    @NonNull
    @CheckReturnValue
    public final Flowable<T> filter(@NonNull Predicate<? super T> predicate) {
        Objects.requireNonNull(predicate, "predicate is null");
        return RxJavaPlugins.onAssembly(new FlowableFilter(this, predicate));
    }

    @BackpressureSupport(BackpressureKind.FULL)
    @SchedulerSupport("none")
    @NonNull
    @CheckReturnValue
    public final Single<T> first(@NonNull T t11) {
        return elementAt(0, t11);
    }

    @BackpressureSupport(BackpressureKind.FULL)
    @SchedulerSupport("none")
    @NonNull
    @CheckReturnValue
    public final Maybe<T> firstElement() {
        return elementAt(0);
    }

    @BackpressureSupport(BackpressureKind.FULL)
    @SchedulerSupport("none")
    @NonNull
    @CheckReturnValue
    public final Single<T> firstOrError() {
        return elementAtOrError(0);
    }

    @BackpressureSupport(BackpressureKind.FULL)
    @SchedulerSupport("none")
    @NonNull
    @CheckReturnValue
    public final CompletionStage<T> firstOrErrorStage() {
        return (CompletionStage) subscribeWith(new FlowableFirstStageSubscriber(false, null));
    }

    @BackpressureSupport(BackpressureKind.FULL)
    @SchedulerSupport("none")
    @NonNull
    @CheckReturnValue
    public final CompletionStage<T> firstStage(@Nullable T t11) {
        return (CompletionStage) subscribeWith(new FlowableFirstStageSubscriber(true, t11));
    }

    @BackpressureSupport(BackpressureKind.FULL)
    @SchedulerSupport("none")
    @NonNull
    @CheckReturnValue
    public final <R> Flowable<R> flatMap(@NonNull Function<? super T, ? extends Publisher<? extends R>> function) {
        return flatMap(function, false, bufferSize(), bufferSize());
    }

    @BackpressureSupport(BackpressureKind.UNBOUNDED_IN)
    @SchedulerSupport("none")
    @NonNull
    @CheckReturnValue
    public final Completable flatMapCompletable(@NonNull Function<? super T, ? extends CompletableSource> function) {
        return flatMapCompletable(function, false, Integer.MAX_VALUE);
    }

    @BackpressureSupport(BackpressureKind.FULL)
    @SchedulerSupport("none")
    @NonNull
    @CheckReturnValue
    public final <U> Flowable<U> flatMapIterable(@NonNull Function<? super T, ? extends Iterable<? extends U>> function) {
        return flatMapIterable(function, bufferSize());
    }

    @BackpressureSupport(BackpressureKind.UNBOUNDED_IN)
    @SchedulerSupport("none")
    @NonNull
    @CheckReturnValue
    public final <R> Flowable<R> flatMapMaybe(@NonNull Function<? super T, ? extends MaybeSource<? extends R>> function) {
        return flatMapMaybe(function, false, Integer.MAX_VALUE);
    }

    @BackpressureSupport(BackpressureKind.UNBOUNDED_IN)
    @SchedulerSupport("none")
    @NonNull
    @CheckReturnValue
    public final <R> Flowable<R> flatMapSingle(@NonNull Function<? super T, ? extends SingleSource<? extends R>> function) {
        return flatMapSingle(function, false, Integer.MAX_VALUE);
    }

    @BackpressureSupport(BackpressureKind.FULL)
    @SchedulerSupport("none")
    @NonNull
    @CheckReturnValue
    public final <R> Flowable<R> flatMapStream(@NonNull Function<? super T, ? extends Stream<? extends R>> function) {
        return flatMapStream(function, bufferSize());
    }

    @BackpressureSupport(BackpressureKind.NONE)
    @SchedulerSupport("none")
    @NonNull
    @CheckReturnValue
    public final Disposable forEach(@NonNull Consumer<? super T> consumer) {
        return subscribe(consumer);
    }

    @BackpressureSupport(BackpressureKind.NONE)
    @SchedulerSupport("none")
    @NonNull
    @CheckReturnValue
    public final Disposable forEachWhile(@NonNull Predicate<? super T> predicate) {
        return forEachWhile(predicate, Functions.ON_ERROR_MISSING, Functions.EMPTY_ACTION);
    }

    @BackpressureSupport(BackpressureKind.ERROR)
    @SchedulerSupport("none")
    @NonNull
    @CheckReturnValue
    public final <K> Flowable<GroupedFlowable<K, T>> groupBy(@NonNull Function<? super T, ? extends K> function) {
        return groupBy(function, Functions.identity(), false, bufferSize());
    }

    @BackpressureSupport(BackpressureKind.ERROR)
    @SchedulerSupport("none")
    @NonNull
    @CheckReturnValue
    public final <TRight, TLeftEnd, TRightEnd, R> Flowable<R> groupJoin(@NonNull Publisher<? extends TRight> publisher, @NonNull Function<? super T, ? extends Publisher<TLeftEnd>> function, @NonNull Function<? super TRight, ? extends Publisher<TRightEnd>> function2, @NonNull BiFunction<? super T, ? super Flowable<TRight>, ? extends R> biFunction) {
        Objects.requireNonNull(publisher, "other is null");
        Objects.requireNonNull(function, "leftEnd is null");
        Objects.requireNonNull(function2, "rightEnd is null");
        Objects.requireNonNull(biFunction, "resultSelector is null");
        return RxJavaPlugins.onAssembly(new FlowableGroupJoin(this, publisher, function, function2, biFunction));
    }

    @BackpressureSupport(BackpressureKind.PASS_THROUGH)
    @SchedulerSupport("none")
    @NonNull
    @CheckReturnValue
    public final Flowable<T> hide() {
        return RxJavaPlugins.onAssembly(new FlowableHide(this));
    }

    @BackpressureSupport(BackpressureKind.UNBOUNDED_IN)
    @SchedulerSupport("none")
    @NonNull
    @CheckReturnValue
    public final Completable ignoreElements() {
        return RxJavaPlugins.onAssembly((Completable) new FlowableIgnoreElementsCompletable(this));
    }

    @BackpressureSupport(BackpressureKind.UNBOUNDED_IN)
    @SchedulerSupport("none")
    @NonNull
    @CheckReturnValue
    public final Single<Boolean> isEmpty() {
        return all(Functions.alwaysFalse());
    }

    @BackpressureSupport(BackpressureKind.ERROR)
    @SchedulerSupport("none")
    @NonNull
    @CheckReturnValue
    public final <TRight, TLeftEnd, TRightEnd, R> Flowable<R> join(@NonNull Publisher<? extends TRight> publisher, @NonNull Function<? super T, ? extends Publisher<TLeftEnd>> function, @NonNull Function<? super TRight, ? extends Publisher<TRightEnd>> function2, @NonNull BiFunction<? super T, ? super TRight, ? extends R> biFunction) {
        Objects.requireNonNull(publisher, "other is null");
        Objects.requireNonNull(function, "leftEnd is null");
        Objects.requireNonNull(function2, "rightEnd is null");
        Objects.requireNonNull(biFunction, "resultSelector is null");
        return RxJavaPlugins.onAssembly(new FlowableJoin(this, publisher, function, function2, biFunction));
    }

    @BackpressureSupport(BackpressureKind.UNBOUNDED_IN)
    @SchedulerSupport("none")
    @NonNull
    @CheckReturnValue
    public final Single<T> last(@NonNull T t11) {
        Objects.requireNonNull(t11, "defaultItem is null");
        return RxJavaPlugins.onAssembly(new FlowableLastSingle(this, t11));
    }

    @BackpressureSupport(BackpressureKind.UNBOUNDED_IN)
    @SchedulerSupport("none")
    @NonNull
    @CheckReturnValue
    public final Maybe<T> lastElement() {
        return RxJavaPlugins.onAssembly(new FlowableLastMaybe(this));
    }

    @BackpressureSupport(BackpressureKind.UNBOUNDED_IN)
    @SchedulerSupport("none")
    @NonNull
    @CheckReturnValue
    public final Single<T> lastOrError() {
        return RxJavaPlugins.onAssembly(new FlowableLastSingle(this, null));
    }

    @BackpressureSupport(BackpressureKind.FULL)
    @SchedulerSupport("none")
    @NonNull
    @CheckReturnValue
    public final CompletionStage<T> lastOrErrorStage() {
        return (CompletionStage) subscribeWith(new FlowableLastStageSubscriber(false, null));
    }

    @BackpressureSupport(BackpressureKind.UNBOUNDED_IN)
    @SchedulerSupport("none")
    @NonNull
    @CheckReturnValue
    public final CompletionStage<T> lastStage(@Nullable T t11) {
        return (CompletionStage) subscribeWith(new FlowableLastStageSubscriber(true, t11));
    }

    @BackpressureSupport(BackpressureKind.SPECIAL)
    @SchedulerSupport("none")
    @NonNull
    @CheckReturnValue
    public final <R> Flowable<R> lift(@NonNull FlowableOperator<? extends R, ? super T> flowableOperator) {
        Objects.requireNonNull(flowableOperator, "lifter is null");
        return RxJavaPlugins.onAssembly(new FlowableLift(this, flowableOperator));
    }

    @BackpressureSupport(BackpressureKind.PASS_THROUGH)
    @SchedulerSupport("none")
    @NonNull
    @CheckReturnValue
    public final <R> Flowable<R> map(@NonNull Function<? super T, ? extends R> function) {
        Objects.requireNonNull(function, "mapper is null");
        return RxJavaPlugins.onAssembly(new FlowableMap(this, function));
    }

    @BackpressureSupport(BackpressureKind.FULL)
    @SchedulerSupport("none")
    @NonNull
    @CheckReturnValue
    public final <R> Flowable<R> mapOptional(@NonNull Function<? super T, Optional<? extends R>> function) {
        Objects.requireNonNull(function, "mapper is null");
        return RxJavaPlugins.onAssembly(new FlowableMapOptional(this, function));
    }

    @BackpressureSupport(BackpressureKind.FULL)
    @SchedulerSupport("none")
    @NonNull
    @CheckReturnValue
    public final Flowable<Notification<T>> materialize() {
        return RxJavaPlugins.onAssembly(new FlowableMaterialize(this));
    }

    @BackpressureSupport(BackpressureKind.FULL)
    @SchedulerSupport("none")
    @NonNull
    @CheckReturnValue
    public final Flowable<T> mergeWith(@NonNull Publisher<? extends T> publisher) {
        Objects.requireNonNull(publisher, "other is null");
        return merge(this, (Flowable) publisher);
    }

    @BackpressureSupport(BackpressureKind.FULL)
    @SchedulerSupport("custom")
    @NonNull
    @CheckReturnValue
    public final Flowable<T> observeOn(@NonNull Scheduler scheduler) {
        return observeOn(scheduler, false, bufferSize());
    }

    @BackpressureSupport(BackpressureKind.PASS_THROUGH)
    @SchedulerSupport("none")
    @NonNull
    @CheckReturnValue
    public final <U> Flowable<U> ofType(@NonNull Class<U> cls) {
        Objects.requireNonNull(cls, "clazz is null");
        return filter(Functions.isInstanceOf(cls)).cast(cls);
    }

    @BackpressureSupport(BackpressureKind.UNBOUNDED_IN)
    @SchedulerSupport("none")
    @NonNull
    @CheckReturnValue
    public final Flowable<T> onBackpressureBuffer() {
        return onBackpressureBuffer(bufferSize(), false, true);
    }

    @BackpressureSupport(BackpressureKind.UNBOUNDED_IN)
    @SchedulerSupport("none")
    @NonNull
    @CheckReturnValue
    public final Flowable<T> onBackpressureDrop() {
        return RxJavaPlugins.onAssembly(new FlowableOnBackpressureDrop(this));
    }

    @BackpressureSupport(BackpressureKind.UNBOUNDED_IN)
    @SchedulerSupport("none")
    @NonNull
    @CheckReturnValue
    public final Flowable<T> onBackpressureLatest() {
        return RxJavaPlugins.onAssembly(new FlowableOnBackpressureLatest(this));
    }

    @BackpressureSupport(BackpressureKind.UNBOUNDED_IN)
    @SchedulerSupport("none")
    @NonNull
    @CheckReturnValue
    public final Flowable<T> onBackpressureReduce(@NonNull BiFunction<T, T, T> biFunction) {
        Objects.requireNonNull(biFunction, "reducer is null");
        return RxJavaPlugins.onAssembly(new FlowableOnBackpressureReduce(this, biFunction));
    }

    @BackpressureSupport(BackpressureKind.PASS_THROUGH)
    @SchedulerSupport("none")
    @NonNull
    @CheckReturnValue
    public final Flowable<T> onErrorComplete() {
        return onErrorComplete(Functions.alwaysTrue());
    }

    @BackpressureSupport(BackpressureKind.FULL)
    @SchedulerSupport("none")
    @NonNull
    @CheckReturnValue
    public final Flowable<T> onErrorResumeNext(@NonNull Function<? super Throwable, ? extends Publisher<? extends T>> function) {
        Objects.requireNonNull(function, "fallbackSupplier is null");
        return RxJavaPlugins.onAssembly(new FlowableOnErrorNext(this, function));
    }

    @BackpressureSupport(BackpressureKind.FULL)
    @SchedulerSupport("none")
    @NonNull
    @CheckReturnValue
    public final Flowable<T> onErrorResumeWith(@NonNull Publisher<? extends T> publisher) {
        Objects.requireNonNull(publisher, "fallback is null");
        return onErrorResumeNext(Functions.justFunction(publisher));
    }

    @BackpressureSupport(BackpressureKind.FULL)
    @SchedulerSupport("none")
    @NonNull
    @CheckReturnValue
    public final Flowable<T> onErrorReturn(@NonNull Function<? super Throwable, ? extends T> function) {
        Objects.requireNonNull(function, "itemSupplier is null");
        return RxJavaPlugins.onAssembly(new FlowableOnErrorReturn(this, function));
    }

    @BackpressureSupport(BackpressureKind.FULL)
    @SchedulerSupport("none")
    @NonNull
    @CheckReturnValue
    public final Flowable<T> onErrorReturnItem(@NonNull T t11) {
        Objects.requireNonNull(t11, "item is null");
        return onErrorReturn(Functions.justFunction(t11));
    }

    @BackpressureSupport(BackpressureKind.PASS_THROUGH)
    @SchedulerSupport("none")
    @NonNull
    @CheckReturnValue
    public final Flowable<T> onTerminateDetach() {
        return RxJavaPlugins.onAssembly(new FlowableDetach(this));
    }

    @BackpressureSupport(BackpressureKind.FULL)
    @SchedulerSupport("none")
    @NonNull
    @CheckReturnValue
    public final ParallelFlowable<T> parallel() {
        return ParallelFlowable.from(this);
    }

    @BackpressureSupport(BackpressureKind.FULL)
    @SchedulerSupport("none")
    @NonNull
    @CheckReturnValue
    public final ConnectableFlowable<T> publish() {
        return publish(bufferSize());
    }

    @BackpressureSupport(BackpressureKind.FULL)
    @SchedulerSupport("none")
    @NonNull
    @CheckReturnValue
    public final Flowable<T> rebatchRequests(int i11) {
        return observeOn(ImmediateThinScheduler.INSTANCE, true, i11);
    }

    @BackpressureSupport(BackpressureKind.UNBOUNDED_IN)
    @SchedulerSupport("none")
    @NonNull
    @CheckReturnValue
    public final Maybe<T> reduce(@NonNull BiFunction<T, T, T> biFunction) {
        Objects.requireNonNull(biFunction, "reducer is null");
        return RxJavaPlugins.onAssembly(new FlowableReduceMaybe(this, biFunction));
    }

    @BackpressureSupport(BackpressureKind.UNBOUNDED_IN)
    @SchedulerSupport("none")
    @NonNull
    @CheckReturnValue
    public final <R> Single<R> reduceWith(@NonNull Supplier<R> supplier, @NonNull BiFunction<R, ? super T, R> biFunction) {
        Objects.requireNonNull(supplier, "seedSupplier is null");
        Objects.requireNonNull(biFunction, "reducer is null");
        return RxJavaPlugins.onAssembly(new FlowableReduceWithSingle(this, supplier, biFunction));
    }

    @BackpressureSupport(BackpressureKind.FULL)
    @SchedulerSupport("none")
    @NonNull
    @CheckReturnValue
    public final Flowable<T> repeat() {
        return repeat(Long.MAX_VALUE);
    }

    @BackpressureSupport(BackpressureKind.FULL)
    @SchedulerSupport("none")
    @NonNull
    @CheckReturnValue
    public final Flowable<T> repeatUntil(@NonNull BooleanSupplier booleanSupplier) {
        Objects.requireNonNull(booleanSupplier, "stop is null");
        return RxJavaPlugins.onAssembly(new FlowableRepeatUntil(this, booleanSupplier));
    }

    @BackpressureSupport(BackpressureKind.FULL)
    @SchedulerSupport("none")
    @NonNull
    @CheckReturnValue
    public final Flowable<T> repeatWhen(@NonNull Function<? super Flowable<Object>, ? extends Publisher<?>> function) {
        Objects.requireNonNull(function, "handler is null");
        return RxJavaPlugins.onAssembly(new FlowableRepeatWhen(this, function));
    }

    @BackpressureSupport(BackpressureKind.FULL)
    @SchedulerSupport("none")
    @NonNull
    @CheckReturnValue
    public final ConnectableFlowable<T> replay() {
        return FlowableReplay.createFrom(this);
    }

    @BackpressureSupport(BackpressureKind.FULL)
    @SchedulerSupport("none")
    @NonNull
    @CheckReturnValue
    public final Flowable<T> retry() {
        return retry(Long.MAX_VALUE, Functions.alwaysTrue());
    }

    @BackpressureSupport(BackpressureKind.FULL)
    @SchedulerSupport("none")
    @NonNull
    @CheckReturnValue
    public final Flowable<T> retryUntil(@NonNull BooleanSupplier booleanSupplier) {
        Objects.requireNonNull(booleanSupplier, "stop is null");
        return retry(Long.MAX_VALUE, Functions.predicateReverseFor(booleanSupplier));
    }

    @BackpressureSupport(BackpressureKind.FULL)
    @SchedulerSupport("none")
    @NonNull
    @CheckReturnValue
    public final Flowable<T> retryWhen(@NonNull Function<? super Flowable<Throwable>, ? extends Publisher<?>> function) {
        Objects.requireNonNull(function, "handler is null");
        return RxJavaPlugins.onAssembly(new FlowableRetryWhen(this, function));
    }

    @BackpressureSupport(BackpressureKind.PASS_THROUGH)
    @SchedulerSupport("none")
    public final void safeSubscribe(@NonNull Subscriber<? super T> subscriber) {
        Objects.requireNonNull(subscriber, "subscriber is null");
        if (subscriber instanceof SafeSubscriber) {
            subscribe((SafeSubscriber) subscriber);
        } else {
            subscribe(new SafeSubscriber(subscriber));
        }
    }

    @BackpressureSupport(BackpressureKind.ERROR)
    @SchedulerSupport("io.reactivex:computation")
    @NonNull
    @CheckReturnValue
    public final Flowable<T> sample(long j11, @NonNull TimeUnit timeUnit) {
        return sample(j11, timeUnit, Schedulers.computation());
    }

    @BackpressureSupport(BackpressureKind.FULL)
    @SchedulerSupport("none")
    @NonNull
    @CheckReturnValue
    public final Flowable<T> scan(@NonNull BiFunction<T, T, T> biFunction) {
        Objects.requireNonNull(biFunction, "accumulator is null");
        return RxJavaPlugins.onAssembly(new FlowableScan(this, biFunction));
    }

    @BackpressureSupport(BackpressureKind.FULL)
    @SchedulerSupport("none")
    @NonNull
    @CheckReturnValue
    public final <R> Flowable<R> scanWith(@NonNull Supplier<R> supplier, @NonNull BiFunction<R, ? super T, R> biFunction) {
        Objects.requireNonNull(supplier, "seedSupplier is null");
        Objects.requireNonNull(biFunction, "accumulator is null");
        return RxJavaPlugins.onAssembly(new FlowableScanSeed(this, supplier, biFunction));
    }

    @BackpressureSupport(BackpressureKind.PASS_THROUGH)
    @SchedulerSupport("none")
    @NonNull
    @CheckReturnValue
    public final Flowable<T> serialize() {
        return RxJavaPlugins.onAssembly(new FlowableSerialized(this));
    }

    @BackpressureSupport(BackpressureKind.FULL)
    @SchedulerSupport("none")
    @NonNull
    @CheckReturnValue
    public final Flowable<T> share() {
        return publish().refCount();
    }

    @BackpressureSupport(BackpressureKind.UNBOUNDED_IN)
    @SchedulerSupport("none")
    @NonNull
    @CheckReturnValue
    public final Single<T> single(@NonNull T t11) {
        Objects.requireNonNull(t11, "defaultItem is null");
        return RxJavaPlugins.onAssembly(new FlowableSingleSingle(this, t11));
    }

    @BackpressureSupport(BackpressureKind.UNBOUNDED_IN)
    @SchedulerSupport("none")
    @NonNull
    @CheckReturnValue
    public final Maybe<T> singleElement() {
        return RxJavaPlugins.onAssembly(new FlowableSingleMaybe(this));
    }

    @BackpressureSupport(BackpressureKind.UNBOUNDED_IN)
    @SchedulerSupport("none")
    @NonNull
    @CheckReturnValue
    public final Single<T> singleOrError() {
        return RxJavaPlugins.onAssembly(new FlowableSingleSingle(this, null));
    }

    @BackpressureSupport(BackpressureKind.FULL)
    @SchedulerSupport("none")
    @NonNull
    @CheckReturnValue
    public final CompletionStage<T> singleOrErrorStage() {
        return (CompletionStage) subscribeWith(new FlowableSingleStageSubscriber(false, null));
    }

    @BackpressureSupport(BackpressureKind.FULL)
    @SchedulerSupport("none")
    @NonNull
    @CheckReturnValue
    public final CompletionStage<T> singleStage(@Nullable T t11) {
        return (CompletionStage) subscribeWith(new FlowableSingleStageSubscriber(true, t11));
    }

    @BackpressureSupport(BackpressureKind.FULL)
    @SchedulerSupport("none")
    @NonNull
    @CheckReturnValue
    public final Flowable<T> skip(long j11) {
        int i11 = (j11 > 0 ? 1 : (j11 == 0 ? 0 : -1));
        if (i11 < 0) {
            throw new IllegalArgumentException("count >= 0 expected but it was " + j11);
        } else if (i11 == 0) {
            return RxJavaPlugins.onAssembly(this);
        } else {
            return RxJavaPlugins.onAssembly(new FlowableSkip(this, j11));
        }
    }

    @BackpressureSupport(BackpressureKind.FULL)
    @SchedulerSupport("none")
    @NonNull
    @CheckReturnValue
    public final Flowable<T> skipLast(int i11) {
        if (i11 < 0) {
            throw new IllegalArgumentException("count >= 0 required but it was " + i11);
        } else if (i11 == 0) {
            return RxJavaPlugins.onAssembly(this);
        } else {
            return RxJavaPlugins.onAssembly(new FlowableSkipLast(this, i11));
        }
    }

    @BackpressureSupport(BackpressureKind.FULL)
    @SchedulerSupport("none")
    @NonNull
    @CheckReturnValue
    public final <U> Flowable<T> skipUntil(@NonNull Publisher<U> publisher) {
        Objects.requireNonNull(publisher, "other is null");
        return RxJavaPlugins.onAssembly(new FlowableSkipUntil(this, publisher));
    }

    @BackpressureSupport(BackpressureKind.FULL)
    @SchedulerSupport("none")
    @NonNull
    @CheckReturnValue
    public final Flowable<T> skipWhile(@NonNull Predicate<? super T> predicate) {
        Objects.requireNonNull(predicate, "predicate is null");
        return RxJavaPlugins.onAssembly(new FlowableSkipWhile(this, predicate));
    }

    @BackpressureSupport(BackpressureKind.FULL)
    @SchedulerSupport("none")
    @NonNull
    @CheckReturnValue
    public final Flowable<T> sorted() {
        return toList().toFlowable().map(Functions.listSorter(Functions.naturalComparator())).flatMapIterable(Functions.identity());
    }

    @BackpressureSupport(BackpressureKind.FULL)
    @SchedulerSupport("none")
    @NonNull
    @CheckReturnValue
    public final Flowable<T> startWith(@NonNull CompletableSource completableSource) {
        Objects.requireNonNull(completableSource, "other is null");
        return concat(Completable.wrap(completableSource).toFlowable(), this);
    }

    @BackpressureSupport(BackpressureKind.FULL)
    @SchedulerSupport("none")
    @SafeVarargs
    @NonNull
    @CheckReturnValue
    public final Flowable<T> startWithArray(@NonNull T... tArr) {
        Flowable fromArray = fromArray(tArr);
        if (fromArray == empty()) {
            return RxJavaPlugins.onAssembly(this);
        }
        return concatArray(fromArray, this);
    }

    @BackpressureSupport(BackpressureKind.FULL)
    @SchedulerSupport("none")
    @NonNull
    @CheckReturnValue
    public final Flowable<T> startWithItem(@NonNull T t11) {
        Objects.requireNonNull(t11, "item is null");
        return concatArray(just(t11), this);
    }

    @BackpressureSupport(BackpressureKind.FULL)
    @SchedulerSupport("none")
    @NonNull
    @CheckReturnValue
    public final Flowable<T> startWithIterable(@NonNull Iterable<? extends T> iterable) {
        return concatArray(fromIterable(iterable), this);
    }

    @NonNull
    @BackpressureSupport(BackpressureKind.UNBOUNDED_IN)
    @SchedulerSupport("none")
    public final Disposable subscribe() {
        return subscribe(Functions.emptyConsumer(), Functions.ON_ERROR_MISSING, Functions.EMPTY_ACTION);
    }

    public abstract void subscribeActual(@NonNull Subscriber<? super T> subscriber);

    @BackpressureSupport(BackpressureKind.PASS_THROUGH)
    @SchedulerSupport("custom")
    @NonNull
    @CheckReturnValue
    public final Flowable<T> subscribeOn(@NonNull Scheduler scheduler) {
        Objects.requireNonNull(scheduler, "scheduler is null");
        return subscribeOn(scheduler, !(this instanceof FlowableCreate));
    }

    @BackpressureSupport(BackpressureKind.SPECIAL)
    @SchedulerSupport("none")
    @NonNull
    @CheckReturnValue
    public final <E extends Subscriber<? super T>> E subscribeWith(E e11) {
        subscribe(e11);
        return e11;
    }

    @BackpressureSupport(BackpressureKind.FULL)
    @SchedulerSupport("none")
    @NonNull
    @CheckReturnValue
    public final Flowable<T> switchIfEmpty(@NonNull Publisher<? extends T> publisher) {
        Objects.requireNonNull(publisher, "other is null");
        return RxJavaPlugins.onAssembly(new FlowableSwitchIfEmpty(this, publisher));
    }

    @BackpressureSupport(BackpressureKind.FULL)
    @SchedulerSupport("none")
    @NonNull
    @CheckReturnValue
    public final <R> Flowable<R> switchMap(@NonNull Function<? super T, ? extends Publisher<? extends R>> function) {
        return switchMap(function, bufferSize());
    }

    @BackpressureSupport(BackpressureKind.UNBOUNDED_IN)
    @SchedulerSupport("none")
    @NonNull
    @CheckReturnValue
    public final Completable switchMapCompletable(@NonNull Function<? super T, ? extends CompletableSource> function) {
        Objects.requireNonNull(function, "mapper is null");
        return RxJavaPlugins.onAssembly((Completable) new FlowableSwitchMapCompletable(this, function, false));
    }

    @BackpressureSupport(BackpressureKind.UNBOUNDED_IN)
    @SchedulerSupport("none")
    @NonNull
    @CheckReturnValue
    public final Completable switchMapCompletableDelayError(@NonNull Function<? super T, ? extends CompletableSource> function) {
        Objects.requireNonNull(function, "mapper is null");
        return RxJavaPlugins.onAssembly((Completable) new FlowableSwitchMapCompletable(this, function, true));
    }

    @BackpressureSupport(BackpressureKind.SPECIAL)
    @SchedulerSupport("none")
    @NonNull
    @CheckReturnValue
    public final <R> Flowable<R> switchMapDelayError(@NonNull Function<? super T, ? extends Publisher<? extends R>> function) {
        return switchMapDelayError(function, bufferSize());
    }

    @BackpressureSupport(BackpressureKind.UNBOUNDED_IN)
    @SchedulerSupport("none")
    @NonNull
    @CheckReturnValue
    public final <R> Flowable<R> switchMapMaybe(@NonNull Function<? super T, ? extends MaybeSource<? extends R>> function) {
        Objects.requireNonNull(function, "mapper is null");
        return RxJavaPlugins.onAssembly(new FlowableSwitchMapMaybe(this, function, false));
    }

    @BackpressureSupport(BackpressureKind.UNBOUNDED_IN)
    @SchedulerSupport("none")
    @NonNull
    @CheckReturnValue
    public final <R> Flowable<R> switchMapMaybeDelayError(@NonNull Function<? super T, ? extends MaybeSource<? extends R>> function) {
        Objects.requireNonNull(function, "mapper is null");
        return RxJavaPlugins.onAssembly(new FlowableSwitchMapMaybe(this, function, true));
    }

    @BackpressureSupport(BackpressureKind.UNBOUNDED_IN)
    @SchedulerSupport("none")
    @NonNull
    @CheckReturnValue
    public final <R> Flowable<R> switchMapSingle(@NonNull Function<? super T, ? extends SingleSource<? extends R>> function) {
        Objects.requireNonNull(function, "mapper is null");
        return RxJavaPlugins.onAssembly(new FlowableSwitchMapSingle(this, function, false));
    }

    @BackpressureSupport(BackpressureKind.UNBOUNDED_IN)
    @SchedulerSupport("none")
    @NonNull
    @CheckReturnValue
    public final <R> Flowable<R> switchMapSingleDelayError(@NonNull Function<? super T, ? extends SingleSource<? extends R>> function) {
        Objects.requireNonNull(function, "mapper is null");
        return RxJavaPlugins.onAssembly(new FlowableSwitchMapSingle(this, function, true));
    }

    @BackpressureSupport(BackpressureKind.FULL)
    @SchedulerSupport("none")
    @NonNull
    @CheckReturnValue
    public final Flowable<T> take(long j11) {
        if (j11 >= 0) {
            return RxJavaPlugins.onAssembly(new FlowableTake(this, j11));
        }
        throw new IllegalArgumentException("count >= 0 required but it was " + j11);
    }

    @BackpressureSupport(BackpressureKind.FULL)
    @SchedulerSupport("none")
    @NonNull
    @CheckReturnValue
    public final Flowable<T> takeLast(int i11) {
        if (i11 < 0) {
            throw new IllegalArgumentException("count >= 0 required but it was " + i11);
        } else if (i11 == 0) {
            return RxJavaPlugins.onAssembly(new FlowableIgnoreElements(this));
        } else {
            if (i11 == 1) {
                return RxJavaPlugins.onAssembly(new FlowableTakeLastOne(this));
            }
            return RxJavaPlugins.onAssembly(new FlowableTakeLast(this, i11));
        }
    }

    @BackpressureSupport(BackpressureKind.PASS_THROUGH)
    @SchedulerSupport("none")
    @NonNull
    @CheckReturnValue
    public final Flowable<T> takeUntil(@NonNull Predicate<? super T> predicate) {
        Objects.requireNonNull(predicate, "stopPredicate is null");
        return RxJavaPlugins.onAssembly(new FlowableTakeUntilPredicate(this, predicate));
    }

    @BackpressureSupport(BackpressureKind.PASS_THROUGH)
    @SchedulerSupport("none")
    @NonNull
    @CheckReturnValue
    public final Flowable<T> takeWhile(@NonNull Predicate<? super T> predicate) {
        Objects.requireNonNull(predicate, "predicate is null");
        return RxJavaPlugins.onAssembly(new FlowableTakeWhile(this, predicate));
    }

    @BackpressureSupport(BackpressureKind.UNBOUNDED_IN)
    @SchedulerSupport("none")
    @NonNull
    @CheckReturnValue
    public final TestSubscriber<T> test() {
        TestSubscriber<T> testSubscriber = new TestSubscriber<>();
        subscribe(testSubscriber);
        return testSubscriber;
    }

    @BackpressureSupport(BackpressureKind.ERROR)
    @SchedulerSupport("io.reactivex:computation")
    @NonNull
    @CheckReturnValue
    public final Flowable<T> throttleFirst(long j11, @NonNull TimeUnit timeUnit) {
        return throttleFirst(j11, timeUnit, Schedulers.computation());
    }

    @BackpressureSupport(BackpressureKind.ERROR)
    @SchedulerSupport("io.reactivex:computation")
    @NonNull
    @CheckReturnValue
    public final Flowable<T> throttleLast(long j11, @NonNull TimeUnit timeUnit) {
        return sample(j11, timeUnit);
    }

    @BackpressureSupport(BackpressureKind.ERROR)
    @SchedulerSupport("io.reactivex:computation")
    @NonNull
    @CheckReturnValue
    public final Flowable<T> throttleLatest(long j11, @NonNull TimeUnit timeUnit) {
        return throttleLatest(j11, timeUnit, Schedulers.computation(), false);
    }

    @BackpressureSupport(BackpressureKind.ERROR)
    @SchedulerSupport("io.reactivex:computation")
    @NonNull
    @CheckReturnValue
    public final Flowable<T> throttleWithTimeout(long j11, @NonNull TimeUnit timeUnit) {
        return debounce(j11, timeUnit);
    }

    @BackpressureSupport(BackpressureKind.PASS_THROUGH)
    @SchedulerSupport("none")
    @NonNull
    @CheckReturnValue
    public final Flowable<Timed<T>> timeInterval() {
        return timeInterval(TimeUnit.MILLISECONDS, Schedulers.computation());
    }

    @BackpressureSupport(BackpressureKind.PASS_THROUGH)
    @SchedulerSupport("none")
    @NonNull
    @CheckReturnValue
    public final <V> Flowable<T> timeout(@NonNull Function<? super T, ? extends Publisher<V>> function) {
        return timeout0((Publisher) null, function, (Publisher) null);
    }

    @BackpressureSupport(BackpressureKind.PASS_THROUGH)
    @SchedulerSupport("none")
    @NonNull
    @CheckReturnValue
    public final Flowable<Timed<T>> timestamp() {
        return timestamp(TimeUnit.MILLISECONDS, Schedulers.computation());
    }

    @BackpressureSupport(BackpressureKind.SPECIAL)
    @SchedulerSupport("none")
    @CheckReturnValue
    public final <R> R to(@NonNull FlowableConverter<T, ? extends R> flowableConverter) {
        Objects.requireNonNull(flowableConverter, "converter is null");
        return flowableConverter.apply(this);
    }

    @BackpressureSupport(BackpressureKind.UNBOUNDED_IN)
    @SchedulerSupport("none")
    @NonNull
    @CheckReturnValue
    public final Future<T> toFuture() {
        return (Future) subscribeWith(new FutureSubscriber());
    }

    @BackpressureSupport(BackpressureKind.UNBOUNDED_IN)
    @SchedulerSupport("none")
    @NonNull
    @CheckReturnValue
    public final Single<List<T>> toList() {
        return RxJavaPlugins.onAssembly(new FlowableToListSingle(this));
    }

    @BackpressureSupport(BackpressureKind.UNBOUNDED_IN)
    @SchedulerSupport("none")
    @NonNull
    @CheckReturnValue
    public final <K> Single<Map<K, T>> toMap(@NonNull Function<? super T, ? extends K> function) {
        Objects.requireNonNull(function, "keySelector is null");
        return collect(HashMapSupplier.asSupplier(), Functions.toMapKeySelector(function));
    }

    @BackpressureSupport(BackpressureKind.UNBOUNDED_IN)
    @SchedulerSupport("none")
    @NonNull
    @CheckReturnValue
    public final <K> Single<Map<K, Collection<T>>> toMultimap(@NonNull Function<? super T, ? extends K> function) {
        return toMultimap(function, Functions.identity(), HashMapSupplier.asSupplier(), ArrayListSupplier.asFunction());
    }

    @BackpressureSupport(BackpressureKind.UNBOUNDED_IN)
    @SchedulerSupport("none")
    @NonNull
    @CheckReturnValue
    public final Observable<T> toObservable() {
        return RxJavaPlugins.onAssembly(new ObservableFromPublisher(this));
    }

    @BackpressureSupport(BackpressureKind.UNBOUNDED_IN)
    @SchedulerSupport("none")
    @NonNull
    @CheckReturnValue
    public final Single<List<T>> toSortedList() {
        return toSortedList(Functions.naturalComparator());
    }

    @BackpressureSupport(BackpressureKind.PASS_THROUGH)
    @SchedulerSupport("custom")
    @NonNull
    @CheckReturnValue
    public final Flowable<T> unsubscribeOn(@NonNull Scheduler scheduler) {
        Objects.requireNonNull(scheduler, "scheduler is null");
        return RxJavaPlugins.onAssembly(new FlowableUnsubscribeOn(this, scheduler));
    }

    @BackpressureSupport(BackpressureKind.FULL)
    @SchedulerSupport("none")
    @NonNull
    @CheckReturnValue
    public final Flowable<Flowable<T>> window(long j11) {
        return window(j11, j11, bufferSize());
    }

    @BackpressureSupport(BackpressureKind.PASS_THROUGH)
    @SchedulerSupport("none")
    @NonNull
    @CheckReturnValue
    public final <U, R> Flowable<R> withLatestFrom(@NonNull Publisher<? extends U> publisher, @NonNull BiFunction<? super T, ? super U, ? extends R> biFunction) {
        Objects.requireNonNull(publisher, "other is null");
        Objects.requireNonNull(biFunction, "combiner is null");
        return RxJavaPlugins.onAssembly(new FlowableWithLatestFrom(this, biFunction, publisher));
    }

    @BackpressureSupport(BackpressureKind.FULL)
    @SchedulerSupport("none")
    @NonNull
    @CheckReturnValue
    public final <U, R> Flowable<R> zipWith(@NonNull Iterable<U> iterable, @NonNull BiFunction<? super T, ? super U, ? extends R> biFunction) {
        Objects.requireNonNull(iterable, "other is null");
        Objects.requireNonNull(biFunction, "zipper is null");
        return RxJavaPlugins.onAssembly(new FlowableZipIterable(this, iterable, biFunction));
    }

    @BackpressureSupport(BackpressureKind.FULL)
    @SchedulerSupport("none")
    @NonNull
    @CheckReturnValue
    public static <T, R> Flowable<R> combineLatest(@NonNull Iterable<? extends Publisher<? extends T>> iterable, @NonNull Function<? super Object[], ? extends R> function, int i11) {
        Objects.requireNonNull(iterable, "sources is null");
        Objects.requireNonNull(function, "combiner is null");
        ObjectHelper.verifyPositive(i11, "bufferSize");
        return RxJavaPlugins.onAssembly(new FlowableCombineLatest(iterable, function, i11, false));
    }

    @BackpressureSupport(BackpressureKind.FULL)
    @SchedulerSupport("none")
    @NonNull
    @CheckReturnValue
    public static <T, R> Flowable<R> combineLatestArray(@NonNull Publisher<? extends T>[] publisherArr, @NonNull Function<? super Object[], ? extends R> function, int i11) {
        Objects.requireNonNull(publisherArr, "sources is null");
        if (publisherArr.length == 0) {
            return empty();
        }
        Objects.requireNonNull(function, "combiner is null");
        ObjectHelper.verifyPositive(i11, "bufferSize");
        return RxJavaPlugins.onAssembly(new FlowableCombineLatest(publisherArr, function, i11, false));
    }

    @BackpressureSupport(BackpressureKind.FULL)
    @SchedulerSupport("none")
    @NonNull
    @CheckReturnValue
    public static <T, R> Flowable<R> combineLatestArrayDelayError(@NonNull Publisher<? extends T>[] publisherArr, @NonNull Function<? super Object[], ? extends R> function, int i11) {
        Objects.requireNonNull(publisherArr, "sources is null");
        Objects.requireNonNull(function, "combiner is null");
        ObjectHelper.verifyPositive(i11, "bufferSize");
        if (publisherArr.length == 0) {
            return empty();
        }
        return RxJavaPlugins.onAssembly(new FlowableCombineLatest(publisherArr, function, i11, true));
    }

    @BackpressureSupport(BackpressureKind.FULL)
    @SchedulerSupport("none")
    @NonNull
    @CheckReturnValue
    public static <T, R> Flowable<R> combineLatestDelayError(@NonNull Iterable<? extends Publisher<? extends T>> iterable, @NonNull Function<? super Object[], ? extends R> function, int i11) {
        Objects.requireNonNull(iterable, "sources is null");
        Objects.requireNonNull(function, "combiner is null");
        ObjectHelper.verifyPositive(i11, "bufferSize");
        return RxJavaPlugins.onAssembly(new FlowableCombineLatest(iterable, function, i11, true));
    }

    @BackpressureSupport(BackpressureKind.FULL)
    @SchedulerSupport("none")
    @SafeVarargs
    @NonNull
    @CheckReturnValue
    public static <T> Flowable<T> concatArrayEager(int i11, int i12, @NonNull Publisher<? extends T>... publisherArr) {
        Objects.requireNonNull(publisherArr, "sources is null");
        ObjectHelper.verifyPositive(i11, "maxConcurrency");
        ObjectHelper.verifyPositive(i12, "prefetch");
        return RxJavaPlugins.onAssembly(new FlowableConcatMapEager(new FlowableFromArray(publisherArr), Functions.identity(), i11, i12, ErrorMode.IMMEDIATE));
    }

    @BackpressureSupport(BackpressureKind.FULL)
    @SchedulerSupport("none")
    @SafeVarargs
    @NonNull
    @CheckReturnValue
    public static <T> Flowable<T> concatArrayEagerDelayError(int i11, int i12, @NonNull Publisher<? extends T>... publisherArr) {
        return fromArray(publisherArr).concatMapEagerDelayError(Functions.identity(), true, i11, i12);
    }

    @BackpressureSupport(BackpressureKind.FULL)
    @SchedulerSupport("none")
    @NonNull
    @CheckReturnValue
    public static <T> Flowable<T> concatEager(@NonNull Iterable<? extends Publisher<? extends T>> iterable, int i11, int i12) {
        Objects.requireNonNull(iterable, "sources is null");
        ObjectHelper.verifyPositive(i11, "maxConcurrency");
        ObjectHelper.verifyPositive(i12, "prefetch");
        return RxJavaPlugins.onAssembly(new FlowableConcatMapEager(new FlowableFromIterable(iterable), Functions.identity(), i11, i12, ErrorMode.BOUNDARY));
    }

    @BackpressureSupport(BackpressureKind.FULL)
    @SchedulerSupport("none")
    @NonNull
    @CheckReturnValue
    public static <T> Flowable<T> concatEagerDelayError(@NonNull Iterable<? extends Publisher<? extends T>> iterable, int i11, int i12) {
        Objects.requireNonNull(iterable, "sources is null");
        ObjectHelper.verifyPositive(i11, "maxConcurrency");
        ObjectHelper.verifyPositive(i12, "prefetch");
        return RxJavaPlugins.onAssembly(new FlowableConcatMapEager(new FlowableFromIterable(iterable), Functions.identity(), i11, i12, ErrorMode.END));
    }

    @BackpressureSupport(BackpressureKind.ERROR)
    @SchedulerSupport("custom")
    @NonNull
    @CheckReturnValue
    public static Flowable<Long> interval(long j11, long j12, @NonNull TimeUnit timeUnit, @NonNull Scheduler scheduler) {
        Objects.requireNonNull(timeUnit, "unit is null");
        Objects.requireNonNull(scheduler, "scheduler is null");
        return RxJavaPlugins.onAssembly(new FlowableInterval(Math.max(0, j11), Math.max(0, j12), timeUnit, scheduler));
    }

    @BackpressureSupport(BackpressureKind.ERROR)
    @SchedulerSupport("custom")
    @NonNull
    @CheckReturnValue
    public static Flowable<Long> intervalRange(long j11, long j12, long j13, long j14, @NonNull TimeUnit timeUnit, @NonNull Scheduler scheduler) {
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
                Objects.requireNonNull(timeUnit2, "unit is null");
                Objects.requireNonNull(scheduler2, "scheduler is null");
                return RxJavaPlugins.onAssembly(new FlowableIntervalRange(j11, j17, Math.max(0, j16), Math.max(0, j14), timeUnit, scheduler));
            }
            throw new IllegalArgumentException("Overflow! start + count is bigger than Long.MAX_VALUE");
        }
    }

    @BackpressureSupport(BackpressureKind.FULL)
    @SchedulerSupport("none")
    @NonNull
    @CheckReturnValue
    public static <T> Flowable<T> merge(@NonNull Iterable<? extends Publisher<? extends T>> iterable) {
        return fromIterable(iterable).flatMap(Functions.identity());
    }

    @BackpressureSupport(BackpressureKind.FULL)
    @SchedulerSupport("none")
    @SafeVarargs
    @NonNull
    @CheckReturnValue
    public static <T> Flowable<T> mergeArray(@NonNull Publisher<? extends T>... publisherArr) {
        return fromArray(publisherArr).flatMap(Functions.identity(), publisherArr.length);
    }

    @BackpressureSupport(BackpressureKind.FULL)
    @SchedulerSupport("none")
    @SafeVarargs
    @NonNull
    @CheckReturnValue
    public static <T> Flowable<T> mergeArrayDelayError(@NonNull Publisher<? extends T>... publisherArr) {
        return fromArray(publisherArr).flatMap(Functions.identity(), true, publisherArr.length);
    }

    @BackpressureSupport(BackpressureKind.FULL)
    @SchedulerSupport("none")
    @NonNull
    @CheckReturnValue
    public static <T> Flowable<T> mergeDelayError(@NonNull Iterable<? extends Publisher<? extends T>> iterable, int i11, int i12) {
        return fromIterable(iterable).flatMap(Functions.identity(), true, i11, i12);
    }

    @BackpressureSupport(BackpressureKind.FULL)
    @SchedulerSupport("none")
    @NonNull
    @CheckReturnValue
    public static <T> Single<Boolean> sequenceEqual(@NonNull Publisher<? extends T> publisher, @NonNull Publisher<? extends T> publisher2, @NonNull BiPredicate<? super T, ? super T> biPredicate) {
        return sequenceEqual(publisher, publisher2, biPredicate, bufferSize());
    }

    @BackpressureSupport(BackpressureKind.FULL)
    @SchedulerSupport("none")
    @NonNull
    @CheckReturnValue
    public static <T> Flowable<T> switchOnNext(@NonNull Publisher<? extends Publisher<? extends T>> publisher) {
        return fromPublisher(publisher).switchMap(Functions.identity());
    }

    @BackpressureSupport(BackpressureKind.FULL)
    @SchedulerSupport("none")
    @NonNull
    @CheckReturnValue
    public static <T> Flowable<T> switchOnNextDelayError(@NonNull Publisher<? extends Publisher<? extends T>> publisher, int i11) {
        return fromPublisher(publisher).switchMapDelayError(Functions.identity(), i11);
    }

    @BackpressureSupport(BackpressureKind.ERROR)
    @SchedulerSupport("custom")
    @NonNull
    @CheckReturnValue
    public static Flowable<Long> timer(long j11, @NonNull TimeUnit timeUnit, @NonNull Scheduler scheduler) {
        Objects.requireNonNull(timeUnit, "unit is null");
        Objects.requireNonNull(scheduler, "scheduler is null");
        return RxJavaPlugins.onAssembly(new FlowableTimer(Math.max(0, j11), timeUnit, scheduler));
    }

    @BackpressureSupport(BackpressureKind.PASS_THROUGH)
    @SchedulerSupport("none")
    @NonNull
    @CheckReturnValue
    public static <T, D> Flowable<T> using(@NonNull Supplier<? extends D> supplier, @NonNull Function<? super D, ? extends Publisher<? extends T>> function, @NonNull Consumer<? super D> consumer, boolean z11) {
        Objects.requireNonNull(supplier, "resourceSupplier is null");
        Objects.requireNonNull(function, "sourceSupplier is null");
        Objects.requireNonNull(consumer, "resourceCleanup is null");
        return RxJavaPlugins.onAssembly(new FlowableUsing(supplier, function, consumer, z11));
    }

    @BackpressureSupport(BackpressureKind.FULL)
    @SchedulerSupport("none")
    public final void blockingForEach(@NonNull Consumer<? super T> consumer, int i11) {
        Objects.requireNonNull(consumer, "onNext is null");
        Iterator it = blockingIterable(i11).iterator();
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

    @BackpressureSupport(BackpressureKind.FULL)
    @SchedulerSupport("none")
    @NonNull
    @CheckReturnValue
    public final Iterable<T> blockingIterable(int i11) {
        ObjectHelper.verifyPositive(i11, "bufferSize");
        return new BlockingFlowableIterable(this, i11);
    }

    @BackpressureSupport(BackpressureKind.UNBOUNDED_IN)
    @SchedulerSupport("none")
    @NonNull
    @CheckReturnValue
    public final T blockingSingle(@NonNull T t11) {
        return single(t11).blockingGet();
    }

    @BackpressureSupport(BackpressureKind.FULL)
    @SchedulerSupport("none")
    @NonNull
    @CheckReturnValue
    public final Stream<T> blockingStream(int i11) {
        Iterator it = blockingIterable(i11).iterator();
        Stream stream = StreamSupport.stream(Spliterators.spliteratorUnknownSize(it, 0), false);
        Disposable disposable = (Disposable) it;
        disposable.getClass();
        return (Stream) stream.onClose(new a(disposable));
    }

    @BackpressureSupport(BackpressureKind.UNBOUNDED_IN)
    @SchedulerSupport("none")
    public final void blockingSubscribe(@NonNull Consumer<? super T> consumer) {
        FlowableBlockingSubscribe.subscribe(this, consumer, Functions.ON_ERROR_MISSING, Functions.EMPTY_ACTION);
    }

    @BackpressureSupport(BackpressureKind.FULL)
    @SchedulerSupport("none")
    @NonNull
    @CheckReturnValue
    public final Flowable<List<T>> buffer(int i11, int i12) {
        return buffer(i11, i12, ArrayListSupplier.asSupplier());
    }

    @BackpressureSupport(BackpressureKind.FULL)
    @SchedulerSupport("none")
    @NonNull
    @CheckReturnValue
    public final <R> Flowable<R> concatMap(@NonNull Function<? super T, ? extends Publisher<? extends R>> function, int i11) {
        Objects.requireNonNull(function, "mapper is null");
        ObjectHelper.verifyPositive(i11, "prefetch");
        if (!(this instanceof ScalarSupplier)) {
            return RxJavaPlugins.onAssembly(new FlowableConcatMap(this, function, i11, ErrorMode.IMMEDIATE));
        }
        Object obj = ((ScalarSupplier) this).get();
        if (obj == null) {
            return empty();
        }
        return FlowableScalarXMap.scalarXMap(obj, function);
    }

    @BackpressureSupport(BackpressureKind.FULL)
    @SchedulerSupport("none")
    @NonNull
    @CheckReturnValue
    public final Completable concatMapCompletable(@NonNull Function<? super T, ? extends CompletableSource> function, int i11) {
        Objects.requireNonNull(function, "mapper is null");
        ObjectHelper.verifyPositive(i11, "prefetch");
        return RxJavaPlugins.onAssembly((Completable) new FlowableConcatMapCompletable(this, function, ErrorMode.IMMEDIATE, i11));
    }

    @BackpressureSupport(BackpressureKind.FULL)
    @SchedulerSupport("none")
    @NonNull
    @CheckReturnValue
    public final Completable concatMapCompletableDelayError(@NonNull Function<? super T, ? extends CompletableSource> function, boolean z11) {
        return concatMapCompletableDelayError(function, z11, 2);
    }

    @BackpressureSupport(BackpressureKind.FULL)
    @SchedulerSupport("none")
    @NonNull
    @CheckReturnValue
    public final <R> Flowable<R> concatMapDelayError(@NonNull Function<? super T, ? extends Publisher<? extends R>> function, boolean z11, int i11) {
        Objects.requireNonNull(function, "mapper is null");
        ObjectHelper.verifyPositive(i11, "prefetch");
        if (this instanceof ScalarSupplier) {
            Object obj = ((ScalarSupplier) this).get();
            if (obj == null) {
                return empty();
            }
            return FlowableScalarXMap.scalarXMap(obj, function);
        }
        return RxJavaPlugins.onAssembly(new FlowableConcatMap(this, function, i11, z11 ? ErrorMode.END : ErrorMode.BOUNDARY));
    }

    @BackpressureSupport(BackpressureKind.FULL)
    @SchedulerSupport("none")
    @NonNull
    @CheckReturnValue
    public final <R> Flowable<R> concatMapEager(@NonNull Function<? super T, ? extends Publisher<? extends R>> function, int i11, int i12) {
        Objects.requireNonNull(function, "mapper is null");
        ObjectHelper.verifyPositive(i11, "maxConcurrency");
        ObjectHelper.verifyPositive(i12, "prefetch");
        return RxJavaPlugins.onAssembly(new FlowableConcatMapEager(this, function, i11, i12, ErrorMode.IMMEDIATE));
    }

    @BackpressureSupport(BackpressureKind.FULL)
    @SchedulerSupport("none")
    @NonNull
    @CheckReturnValue
    public final <R> Flowable<R> concatMapEagerDelayError(@NonNull Function<? super T, ? extends Publisher<? extends R>> function, boolean z11, int i11, int i12) {
        Objects.requireNonNull(function, "mapper is null");
        ObjectHelper.verifyPositive(i11, "maxConcurrency");
        ObjectHelper.verifyPositive(i12, "prefetch");
        return RxJavaPlugins.onAssembly(new FlowableConcatMapEager(this, function, i11, i12, z11 ? ErrorMode.END : ErrorMode.BOUNDARY));
    }

    @BackpressureSupport(BackpressureKind.FULL)
    @SchedulerSupport("none")
    @NonNull
    @CheckReturnValue
    public final <U> Flowable<U> concatMapIterable(@NonNull Function<? super T, ? extends Iterable<? extends U>> function, int i11) {
        Objects.requireNonNull(function, "mapper is null");
        ObjectHelper.verifyPositive(i11, "prefetch");
        return RxJavaPlugins.onAssembly(new FlowableFlattenIterable(this, function, i11));
    }

    @BackpressureSupport(BackpressureKind.FULL)
    @SchedulerSupport("none")
    @NonNull
    @CheckReturnValue
    public final <R> Flowable<R> concatMapMaybe(@NonNull Function<? super T, ? extends MaybeSource<? extends R>> function, int i11) {
        Objects.requireNonNull(function, "mapper is null");
        ObjectHelper.verifyPositive(i11, "prefetch");
        return RxJavaPlugins.onAssembly(new FlowableConcatMapMaybe(this, function, ErrorMode.IMMEDIATE, i11));
    }

    @BackpressureSupport(BackpressureKind.FULL)
    @SchedulerSupport("none")
    @NonNull
    @CheckReturnValue
    public final <R> Flowable<R> concatMapMaybeDelayError(@NonNull Function<? super T, ? extends MaybeSource<? extends R>> function, boolean z11) {
        return concatMapMaybeDelayError(function, z11, 2);
    }

    @BackpressureSupport(BackpressureKind.FULL)
    @SchedulerSupport("none")
    @NonNull
    @CheckReturnValue
    public final <R> Flowable<R> concatMapSingle(@NonNull Function<? super T, ? extends SingleSource<? extends R>> function, int i11) {
        Objects.requireNonNull(function, "mapper is null");
        ObjectHelper.verifyPositive(i11, "prefetch");
        return RxJavaPlugins.onAssembly(new FlowableConcatMapSingle(this, function, ErrorMode.IMMEDIATE, i11));
    }

    @BackpressureSupport(BackpressureKind.FULL)
    @SchedulerSupport("none")
    @NonNull
    @CheckReturnValue
    public final <R> Flowable<R> concatMapSingleDelayError(@NonNull Function<? super T, ? extends SingleSource<? extends R>> function, boolean z11) {
        return concatMapSingleDelayError(function, z11, 2);
    }

    @BackpressureSupport(BackpressureKind.FULL)
    @SchedulerSupport("none")
    @NonNull
    @CheckReturnValue
    public final <R> Flowable<R> concatMapStream(@NonNull Function<? super T, ? extends Stream<? extends R>> function, int i11) {
        Objects.requireNonNull(function, "mapper is null");
        ObjectHelper.verifyPositive(i11, "prefetch");
        return RxJavaPlugins.onAssembly(new FlowableFlatMapStream(this, function, i11));
    }

    @BackpressureSupport(BackpressureKind.FULL)
    @SchedulerSupport("none")
    @NonNull
    @CheckReturnValue
    public final <K> Flowable<T> distinct(@NonNull Function<? super T, K> function) {
        return distinct(function, Functions.createHashSet());
    }

    @BackpressureSupport(BackpressureKind.FULL)
    @SchedulerSupport("none")
    @NonNull
    @CheckReturnValue
    public final <K> Flowable<T> distinctUntilChanged(@NonNull Function<? super T, K> function) {
        Objects.requireNonNull(function, "keySelector is null");
        return RxJavaPlugins.onAssembly(new FlowableDistinctUntilChanged(this, function, ObjectHelper.equalsPredicate()));
    }

    @BackpressureSupport(BackpressureKind.FULL)
    @SchedulerSupport("none")
    @NonNull
    @CheckReturnValue
    public final <R> Flowable<R> flatMap(@NonNull Function<? super T, ? extends Publisher<? extends R>> function, boolean z11) {
        return flatMap(function, z11, bufferSize(), bufferSize());
    }

    @BackpressureSupport(BackpressureKind.UNBOUNDED_IN)
    @SchedulerSupport("none")
    @NonNull
    @CheckReturnValue
    public final Completable flatMapCompletable(@NonNull Function<? super T, ? extends CompletableSource> function, boolean z11, int i11) {
        Objects.requireNonNull(function, "mapper is null");
        ObjectHelper.verifyPositive(i11, "maxConcurrency");
        return RxJavaPlugins.onAssembly((Completable) new FlowableFlatMapCompletableCompletable(this, function, z11, i11));
    }

    @BackpressureSupport(BackpressureKind.FULL)
    @SchedulerSupport("none")
    @NonNull
    @CheckReturnValue
    public final <U> Flowable<U> flatMapIterable(@NonNull Function<? super T, ? extends Iterable<? extends U>> function, int i11) {
        Objects.requireNonNull(function, "mapper is null");
        ObjectHelper.verifyPositive(i11, "bufferSize");
        return RxJavaPlugins.onAssembly(new FlowableFlattenIterable(this, function, i11));
    }

    @BackpressureSupport(BackpressureKind.UNBOUNDED_IN)
    @SchedulerSupport("none")
    @NonNull
    @CheckReturnValue
    public final <R> Flowable<R> flatMapMaybe(@NonNull Function<? super T, ? extends MaybeSource<? extends R>> function, boolean z11, int i11) {
        Objects.requireNonNull(function, "mapper is null");
        ObjectHelper.verifyPositive(i11, "maxConcurrency");
        return RxJavaPlugins.onAssembly(new FlowableFlatMapMaybe(this, function, z11, i11));
    }

    @BackpressureSupport(BackpressureKind.UNBOUNDED_IN)
    @SchedulerSupport("none")
    @NonNull
    @CheckReturnValue
    public final <R> Flowable<R> flatMapSingle(@NonNull Function<? super T, ? extends SingleSource<? extends R>> function, boolean z11, int i11) {
        Objects.requireNonNull(function, "mapper is null");
        ObjectHelper.verifyPositive(i11, "maxConcurrency");
        return RxJavaPlugins.onAssembly(new FlowableFlatMapSingle(this, function, z11, i11));
    }

    @BackpressureSupport(BackpressureKind.FULL)
    @SchedulerSupport("none")
    @NonNull
    @CheckReturnValue
    public final <R> Flowable<R> flatMapStream(@NonNull Function<? super T, ? extends Stream<? extends R>> function, int i11) {
        Objects.requireNonNull(function, "mapper is null");
        ObjectHelper.verifyPositive(i11, "prefetch");
        return RxJavaPlugins.onAssembly(new FlowableFlatMapStream(this, function, i11));
    }

    @BackpressureSupport(BackpressureKind.NONE)
    @SchedulerSupport("none")
    @NonNull
    @CheckReturnValue
    public final Disposable forEachWhile(@NonNull Predicate<? super T> predicate, @NonNull Consumer<? super Throwable> consumer) {
        return forEachWhile(predicate, consumer, Functions.EMPTY_ACTION);
    }

    @BackpressureSupport(BackpressureKind.ERROR)
    @SchedulerSupport("none")
    @NonNull
    @CheckReturnValue
    public final <K> Flowable<GroupedFlowable<K, T>> groupBy(@NonNull Function<? super T, ? extends K> function, boolean z11) {
        return groupBy(function, Functions.identity(), z11, bufferSize());
    }

    @BackpressureSupport(BackpressureKind.FULL)
    @SchedulerSupport("custom")
    @NonNull
    @CheckReturnValue
    public final Flowable<T> observeOn(@NonNull Scheduler scheduler, boolean z11) {
        return observeOn(scheduler, z11, bufferSize());
    }

    @BackpressureSupport(BackpressureKind.UNBOUNDED_IN)
    @SchedulerSupport("none")
    @NonNull
    @CheckReturnValue
    public final Flowable<T> onBackpressureBuffer(boolean z11) {
        return onBackpressureBuffer(bufferSize(), z11, true);
    }

    @BackpressureSupport(BackpressureKind.UNBOUNDED_IN)
    @SchedulerSupport("none")
    @NonNull
    @CheckReturnValue
    public final Flowable<T> onBackpressureDrop(@NonNull Consumer<? super T> consumer) {
        Objects.requireNonNull(consumer, "onDrop is null");
        return RxJavaPlugins.onAssembly(new FlowableOnBackpressureDrop(this, consumer));
    }

    @BackpressureSupport(BackpressureKind.PASS_THROUGH)
    @SchedulerSupport("none")
    @NonNull
    @CheckReturnValue
    public final Flowable<T> onErrorComplete(@NonNull Predicate<? super Throwable> predicate) {
        Objects.requireNonNull(predicate, "predicate is null");
        return RxJavaPlugins.onAssembly(new FlowableOnErrorComplete(this, predicate));
    }

    @BackpressureSupport(BackpressureKind.FULL)
    @SchedulerSupport("none")
    @NonNull
    @CheckReturnValue
    public final ParallelFlowable<T> parallel(int i11) {
        return ParallelFlowable.from(this, i11);
    }

    @BackpressureSupport(BackpressureKind.FULL)
    @SchedulerSupport("none")
    @NonNull
    @CheckReturnValue
    public final <R> Flowable<R> publish(@NonNull Function<? super Flowable<T>, ? extends Publisher<R>> function) {
        return publish(function, bufferSize());
    }

    @BackpressureSupport(BackpressureKind.FULL)
    @SchedulerSupport("none")
    @NonNull
    @CheckReturnValue
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

    @BackpressureSupport(BackpressureKind.FULL)
    @SchedulerSupport("none")
    @NonNull
    @CheckReturnValue
    public final <R> Flowable<R> replay(@NonNull Function<? super Flowable<T>, ? extends Publisher<R>> function) {
        Objects.requireNonNull(function, "selector is null");
        return FlowableReplay.multicastSelector(FlowableInternalHelper.replaySupplier(this), function);
    }

    @BackpressureSupport(BackpressureKind.FULL)
    @SchedulerSupport("none")
    @NonNull
    @CheckReturnValue
    public final Flowable<T> retry(@NonNull BiPredicate<? super Integer, ? super Throwable> biPredicate) {
        Objects.requireNonNull(biPredicate, "predicate is null");
        return RxJavaPlugins.onAssembly(new FlowableRetryBiPredicate(this, biPredicate));
    }

    @BackpressureSupport(BackpressureKind.ERROR)
    @SchedulerSupport("io.reactivex:computation")
    @NonNull
    @CheckReturnValue
    public final Flowable<T> sample(long j11, @NonNull TimeUnit timeUnit, boolean z11) {
        return sample(j11, timeUnit, Schedulers.computation(), z11);
    }

    @BackpressureSupport(BackpressureKind.FULL)
    @SchedulerSupport("none")
    @NonNull
    @CheckReturnValue
    public final Flowable<T> sorted(@NonNull Comparator<? super T> comparator) {
        Objects.requireNonNull(comparator, "comparator is null");
        return toList().toFlowable().map(Functions.listSorter(comparator)).flatMapIterable(Functions.identity());
    }

    @BackpressureSupport(BackpressureKind.UNBOUNDED_IN)
    @SchedulerSupport("none")
    @NonNull
    @CheckReturnValue
    public final Disposable subscribe(@NonNull Consumer<? super T> consumer) {
        return subscribe(consumer, Functions.ON_ERROR_MISSING, Functions.EMPTY_ACTION);
    }

    @BackpressureSupport(BackpressureKind.FULL)
    @SchedulerSupport("none")
    @NonNull
    @CheckReturnValue
    public final <R> Flowable<R> switchMap(@NonNull Function<? super T, ? extends Publisher<? extends R>> function, int i11) {
        return a(function, i11, false);
    }

    @BackpressureSupport(BackpressureKind.SPECIAL)
    @SchedulerSupport("none")
    @NonNull
    @CheckReturnValue
    public final <R> Flowable<R> switchMapDelayError(@NonNull Function<? super T, ? extends Publisher<? extends R>> function, int i11) {
        return a(function, i11, true);
    }

    @BackpressureSupport(BackpressureKind.ERROR)
    @SchedulerSupport("custom")
    @NonNull
    @CheckReturnValue
    public final Flowable<T> throttleFirst(long j11, @NonNull TimeUnit timeUnit, @NonNull Scheduler scheduler) {
        Objects.requireNonNull(timeUnit, "unit is null");
        Objects.requireNonNull(scheduler, "scheduler is null");
        return RxJavaPlugins.onAssembly(new FlowableThrottleFirstTimed(this, j11, timeUnit, scheduler));
    }

    @BackpressureSupport(BackpressureKind.ERROR)
    @SchedulerSupport("custom")
    @NonNull
    @CheckReturnValue
    public final Flowable<T> throttleLast(long j11, @NonNull TimeUnit timeUnit, @NonNull Scheduler scheduler) {
        return sample(j11, timeUnit, scheduler);
    }

    @BackpressureSupport(BackpressureKind.ERROR)
    @SchedulerSupport("io.reactivex:computation")
    @NonNull
    @CheckReturnValue
    public final Flowable<T> throttleLatest(long j11, @NonNull TimeUnit timeUnit, boolean z11) {
        return throttleLatest(j11, timeUnit, Schedulers.computation(), z11);
    }

    @BackpressureSupport(BackpressureKind.ERROR)
    @SchedulerSupport("custom")
    @NonNull
    @CheckReturnValue
    public final Flowable<T> throttleWithTimeout(long j11, @NonNull TimeUnit timeUnit, @NonNull Scheduler scheduler) {
        return debounce(j11, timeUnit, scheduler);
    }

    @BackpressureSupport(BackpressureKind.PASS_THROUGH)
    @SchedulerSupport("none")
    @NonNull
    @CheckReturnValue
    public final Flowable<Timed<T>> timeInterval(@NonNull Scheduler scheduler) {
        return timeInterval(TimeUnit.MILLISECONDS, scheduler);
    }

    @BackpressureSupport(BackpressureKind.FULL)
    @SchedulerSupport("none")
    @NonNull
    @CheckReturnValue
    public final <V> Flowable<T> timeout(@NonNull Function<? super T, ? extends Publisher<V>> function, @NonNull Publisher<? extends T> publisher) {
        Objects.requireNonNull(publisher, "fallback is null");
        return timeout0((Publisher) null, function, publisher);
    }

    @BackpressureSupport(BackpressureKind.PASS_THROUGH)
    @SchedulerSupport("none")
    @NonNull
    @CheckReturnValue
    public final Flowable<Timed<T>> timestamp(@NonNull Scheduler scheduler) {
        return timestamp(TimeUnit.MILLISECONDS, scheduler);
    }

    @BackpressureSupport(BackpressureKind.UNBOUNDED_IN)
    @SchedulerSupport("none")
    @NonNull
    @CheckReturnValue
    public final Single<List<T>> toList(int i11) {
        ObjectHelper.verifyPositive(i11, "capacityHint");
        return RxJavaPlugins.onAssembly(new FlowableToListSingle(this, Functions.createArrayList(i11)));
    }

    @BackpressureSupport(BackpressureKind.UNBOUNDED_IN)
    @SchedulerSupport("none")
    @NonNull
    @CheckReturnValue
    public final Single<List<T>> toSortedList(@NonNull Comparator<? super T> comparator) {
        Objects.requireNonNull(comparator, "comparator is null");
        return toList().map(Functions.listSorter(comparator));
    }

    @BackpressureSupport(BackpressureKind.FULL)
    @SchedulerSupport("none")
    @NonNull
    @CheckReturnValue
    public final Flowable<Flowable<T>> window(long j11, long j12) {
        return window(j11, j12, bufferSize());
    }

    @BackpressureSupport(BackpressureKind.FULL)
    @SchedulerSupport("none")
    @NonNull
    @CheckReturnValue
    public static <T> Flowable<T> concat(@NonNull Publisher<? extends Publisher<? extends T>> publisher) {
        return concat(publisher, bufferSize());
    }

    @BackpressureSupport(BackpressureKind.FULL)
    @SchedulerSupport("none")
    @NonNull
    @CheckReturnValue
    public static <T> Flowable<T> concatDelayError(@NonNull Publisher<? extends Publisher<? extends T>> publisher) {
        return concatDelayError(publisher, bufferSize(), true);
    }

    @BackpressureSupport(BackpressureKind.PASS_THROUGH)
    @SchedulerSupport("none")
    @NonNull
    @CheckReturnValue
    public static <T> Flowable<T> error(@NonNull Throwable th2) {
        Objects.requireNonNull(th2, "throwable is null");
        return error((Supplier<? extends Throwable>) Functions.justSupplier(th2));
    }

    @BackpressureSupport(BackpressureKind.FULL)
    @SchedulerSupport("none")
    @NonNull
    @CheckReturnValue
    public static <T> Flowable<T> fromFuture(@NonNull Future<? extends T> future, long j11, @NonNull TimeUnit timeUnit) {
        Objects.requireNonNull(future, "future is null");
        Objects.requireNonNull(timeUnit, "unit is null");
        return RxJavaPlugins.onAssembly(new FlowableFromFuture(future, j11, timeUnit));
    }

    @BackpressureSupport(BackpressureKind.FULL)
    @SchedulerSupport("none")
    @NonNull
    @CheckReturnValue
    public static <T> Flowable<T> just(T t11, T t12) {
        Objects.requireNonNull(t11, "item1 is null");
        Objects.requireNonNull(t12, "item2 is null");
        return fromArray(t11, t12);
    }

    @BackpressureSupport(BackpressureKind.FULL)
    @SchedulerSupport("none")
    @NonNull
    @CheckReturnValue
    public static <T> Flowable<T> merge(@NonNull Iterable<? extends Publisher<? extends T>> iterable, int i11) {
        return fromIterable(iterable).flatMap(Functions.identity(), i11);
    }

    @BackpressureSupport(BackpressureKind.FULL)
    @SchedulerSupport("none")
    @NonNull
    @CheckReturnValue
    public static <T> Flowable<T> mergeDelayError(@NonNull Iterable<? extends Publisher<? extends T>> iterable, int i11) {
        return fromIterable(iterable).flatMap(Functions.identity(), true, i11);
    }

    @BackpressureSupport(BackpressureKind.FULL)
    @SchedulerSupport("none")
    @NonNull
    @CheckReturnValue
    public static <T> Single<Boolean> sequenceEqual(@NonNull Publisher<? extends T> publisher, @NonNull Publisher<? extends T> publisher2, @NonNull BiPredicate<? super T, ? super T> biPredicate, int i11) {
        Objects.requireNonNull(publisher, "source1 is null");
        Objects.requireNonNull(publisher2, "source2 is null");
        Objects.requireNonNull(biPredicate, "isEqual is null");
        ObjectHelper.verifyPositive(i11, "bufferSize");
        return RxJavaPlugins.onAssembly(new FlowableSequenceEqualSingle(publisher, publisher2, biPredicate, i11));
    }

    @BackpressureSupport(BackpressureKind.FULL)
    @SchedulerSupport("none")
    public final void blockingSubscribe(@NonNull Consumer<? super T> consumer, int i11) {
        FlowableBlockingSubscribe.subscribe(this, consumer, Functions.ON_ERROR_MISSING, Functions.EMPTY_ACTION, i11);
    }

    @BackpressureSupport(BackpressureKind.FULL)
    @SchedulerSupport("none")
    @NonNull
    @CheckReturnValue
    public final <U extends Collection<? super T>> Flowable<U> buffer(int i11, int i12, @NonNull Supplier<U> supplier) {
        ObjectHelper.verifyPositive(i11, "count");
        ObjectHelper.verifyPositive(i12, "skip");
        Objects.requireNonNull(supplier, "bufferSupplier is null");
        return RxJavaPlugins.onAssembly(new FlowableBuffer(this, i11, i12, supplier));
    }

    @BackpressureSupport(BackpressureKind.FULL)
    @SchedulerSupport("none")
    @NonNull
    @CheckReturnValue
    public final Completable concatMapCompletableDelayError(@NonNull Function<? super T, ? extends CompletableSource> function, boolean z11, int i11) {
        Objects.requireNonNull(function, "mapper is null");
        ObjectHelper.verifyPositive(i11, "prefetch");
        return RxJavaPlugins.onAssembly((Completable) new FlowableConcatMapCompletable(this, function, z11 ? ErrorMode.END : ErrorMode.BOUNDARY, i11));
    }

    @BackpressureSupport(BackpressureKind.FULL)
    @SchedulerSupport("none")
    @NonNull
    @CheckReturnValue
    public final <R> Flowable<R> concatMapMaybeDelayError(@NonNull Function<? super T, ? extends MaybeSource<? extends R>> function, boolean z11, int i11) {
        Objects.requireNonNull(function, "mapper is null");
        ObjectHelper.verifyPositive(i11, "prefetch");
        return RxJavaPlugins.onAssembly(new FlowableConcatMapMaybe(this, function, z11 ? ErrorMode.END : ErrorMode.BOUNDARY, i11));
    }

    @BackpressureSupport(BackpressureKind.FULL)
    @SchedulerSupport("none")
    @NonNull
    @CheckReturnValue
    public final <R> Flowable<R> concatMapSingleDelayError(@NonNull Function<? super T, ? extends SingleSource<? extends R>> function, boolean z11, int i11) {
        Objects.requireNonNull(function, "mapper is null");
        ObjectHelper.verifyPositive(i11, "prefetch");
        return RxJavaPlugins.onAssembly(new FlowableConcatMapSingle(this, function, z11 ? ErrorMode.END : ErrorMode.BOUNDARY, i11));
    }

    @BackpressureSupport(BackpressureKind.FULL)
    @SchedulerSupport("none")
    @NonNull
    @CheckReturnValue
    public final Flowable<T> concatWith(@NonNull SingleSource<? extends T> singleSource) {
        Objects.requireNonNull(singleSource, "other is null");
        return RxJavaPlugins.onAssembly(new FlowableConcatWithSingle(this, singleSource));
    }

    @BackpressureSupport(BackpressureKind.ERROR)
    @SchedulerSupport("io.reactivex:computation")
    @NonNull
    @CheckReturnValue
    public final Flowable<T> debounce(long j11, @NonNull TimeUnit timeUnit) {
        return debounce(j11, timeUnit, Schedulers.computation());
    }

    @BackpressureSupport(BackpressureKind.FULL)
    @SchedulerSupport("io.reactivex:computation")
    @NonNull
    @CheckReturnValue
    public final Flowable<T> delay(long j11, @NonNull TimeUnit timeUnit) {
        return delay(j11, timeUnit, Schedulers.computation(), false);
    }

    @BackpressureSupport(BackpressureKind.FULL)
    @SchedulerSupport("io.reactivex:computation")
    @NonNull
    @CheckReturnValue
    public final Flowable<T> delaySubscription(long j11, @NonNull TimeUnit timeUnit) {
        return delaySubscription(j11, timeUnit, Schedulers.computation());
    }

    @BackpressureSupport(BackpressureKind.FULL)
    @SchedulerSupport("none")
    @NonNull
    @CheckReturnValue
    public final <K> Flowable<T> distinct(@NonNull Function<? super T, K> function, @NonNull Supplier<? extends Collection<? super K>> supplier) {
        Objects.requireNonNull(function, "keySelector is null");
        Objects.requireNonNull(supplier, "collectionSupplier is null");
        return RxJavaPlugins.onAssembly(new FlowableDistinct(this, function, supplier));
    }

    @BackpressureSupport(BackpressureKind.FULL)
    @SchedulerSupport("none")
    @NonNull
    @CheckReturnValue
    public final Single<T> elementAt(long j11, @NonNull T t11) {
        if (j11 >= 0) {
            Objects.requireNonNull(t11, "defaultItem is null");
            return RxJavaPlugins.onAssembly(new FlowableElementAtSingle(this, j11, t11));
        }
        throw new IndexOutOfBoundsException("index >= 0 required but it was " + j11);
    }

    @BackpressureSupport(BackpressureKind.FULL)
    @SchedulerSupport("none")
    @NonNull
    @CheckReturnValue
    public final <R> Flowable<R> flatMap(@NonNull Function<? super T, ? extends Publisher<? extends R>> function, int i11) {
        return flatMap(function, false, i11, bufferSize());
    }

    @BackpressureSupport(BackpressureKind.NONE)
    @SchedulerSupport("none")
    @NonNull
    @CheckReturnValue
    public final Disposable forEachWhile(@NonNull Predicate<? super T> predicate, @NonNull Consumer<? super Throwable> consumer, @NonNull Action action) {
        Objects.requireNonNull(predicate, "onNext is null");
        Objects.requireNonNull(consumer, "onError is null");
        Objects.requireNonNull(action, "onComplete is null");
        ForEachWhileSubscriber forEachWhileSubscriber = new ForEachWhileSubscriber(predicate, consumer, action);
        subscribe(forEachWhileSubscriber);
        return forEachWhileSubscriber;
    }

    @BackpressureSupport(BackpressureKind.ERROR)
    @SchedulerSupport("none")
    @NonNull
    @CheckReturnValue
    public final <K, V> Flowable<GroupedFlowable<K, V>> groupBy(@NonNull Function<? super T, ? extends K> function, @NonNull Function<? super T, ? extends V> function2) {
        return groupBy(function, function2, false, bufferSize());
    }

    @BackpressureSupport(BackpressureKind.FULL)
    @SchedulerSupport("none")
    @NonNull
    @CheckReturnValue
    public final Flowable<T> mergeWith(@NonNull SingleSource<? extends T> singleSource) {
        Objects.requireNonNull(singleSource, "other is null");
        return RxJavaPlugins.onAssembly(new FlowableMergeWithSingle(this, singleSource));
    }

    @BackpressureSupport(BackpressureKind.FULL)
    @SchedulerSupport("custom")
    @NonNull
    @CheckReturnValue
    public final Flowable<T> observeOn(@NonNull Scheduler scheduler, boolean z11, int i11) {
        Objects.requireNonNull(scheduler, "scheduler is null");
        ObjectHelper.verifyPositive(i11, "bufferSize");
        return RxJavaPlugins.onAssembly(new FlowableObserveOn(this, scheduler, z11, i11));
    }

    @BackpressureSupport(BackpressureKind.ERROR)
    @SchedulerSupport("none")
    @NonNull
    @CheckReturnValue
    public final Flowable<T> onBackpressureBuffer(int i11) {
        return onBackpressureBuffer(i11, false, false);
    }

    @BackpressureSupport(BackpressureKind.UNBOUNDED_IN)
    @SchedulerSupport("none")
    @NonNull
    @CheckReturnValue
    public final <R> Flowable<R> onBackpressureReduce(@NonNull Supplier<R> supplier, @NonNull BiFunction<R, ? super T, R> biFunction) {
        Objects.requireNonNull(supplier, "supplier is null");
        Objects.requireNonNull(biFunction, "reducer is null");
        return RxJavaPlugins.onAssembly(new FlowableOnBackpressureReduceWith(this, supplier, biFunction));
    }

    @BackpressureSupport(BackpressureKind.FULL)
    @SchedulerSupport("none")
    @NonNull
    @CheckReturnValue
    public final ParallelFlowable<T> parallel(int i11, int i12) {
        return ParallelFlowable.from(this, i11, i12);
    }

    @BackpressureSupport(BackpressureKind.FULL)
    @SchedulerSupport("none")
    @NonNull
    @CheckReturnValue
    public final <R> Flowable<R> publish(@NonNull Function<? super Flowable<T>, ? extends Publisher<? extends R>> function, int i11) {
        Objects.requireNonNull(function, "selector is null");
        ObjectHelper.verifyPositive(i11, "prefetch");
        return RxJavaPlugins.onAssembly(new FlowablePublishMulticast(this, function, i11, false));
    }

    @BackpressureSupport(BackpressureKind.UNBOUNDED_IN)
    @SchedulerSupport("none")
    @NonNull
    @CheckReturnValue
    public final <R> Single<R> reduce(R r11, @NonNull BiFunction<R, ? super T, R> biFunction) {
        Objects.requireNonNull(r11, "seed is null");
        Objects.requireNonNull(biFunction, "reducer is null");
        return RxJavaPlugins.onAssembly(new FlowableReduceSeedSingle(this, r11, biFunction));
    }

    @BackpressureSupport(BackpressureKind.ERROR)
    @SchedulerSupport("custom")
    @NonNull
    @CheckReturnValue
    public final Flowable<T> sample(long j11, @NonNull TimeUnit timeUnit, @NonNull Scheduler scheduler) {
        Objects.requireNonNull(timeUnit, "unit is null");
        Objects.requireNonNull(scheduler, "scheduler is null");
        return RxJavaPlugins.onAssembly(new FlowableSampleTimed(this, j11, timeUnit, scheduler, false));
    }

    @BackpressureSupport(BackpressureKind.FULL)
    @SchedulerSupport("none")
    @NonNull
    @CheckReturnValue
    public final <R> Flowable<R> scan(R r11, @NonNull BiFunction<R, ? super T, R> biFunction) {
        Objects.requireNonNull(r11, "initialValue is null");
        return scanWith(Functions.justSupplier(r11), biFunction);
    }

    @BackpressureSupport(BackpressureKind.FULL)
    @SchedulerSupport("none")
    @NonNull
    @CheckReturnValue
    public final Flowable<T> startWith(@NonNull SingleSource<T> singleSource) {
        Objects.requireNonNull(singleSource, "other is null");
        return concat(Single.wrap(singleSource).toFlowable(), (Flowable<T>) this);
    }

    @BackpressureSupport(BackpressureKind.UNBOUNDED_IN)
    @SchedulerSupport("none")
    @NonNull
    @CheckReturnValue
    public final Disposable subscribe(@NonNull Consumer<? super T> consumer, @NonNull Consumer<? super Throwable> consumer2) {
        return subscribe(consumer, consumer2, Functions.EMPTY_ACTION);
    }

    @BackpressureSupport(BackpressureKind.PASS_THROUGH)
    @SchedulerSupport("custom")
    @NonNull
    @CheckReturnValue
    public final Flowable<T> subscribeOn(@NonNull Scheduler scheduler, boolean z11) {
        Objects.requireNonNull(scheduler, "scheduler is null");
        return RxJavaPlugins.onAssembly(new FlowableSubscribeOn(this, scheduler, z11));
    }

    @BackpressureSupport(BackpressureKind.PASS_THROUGH)
    @SchedulerSupport("io.reactivex:computation")
    @NonNull
    @CheckReturnValue
    public final Flowable<T> take(long j11, @NonNull TimeUnit timeUnit) {
        return takeUntil(timer(j11, timeUnit));
    }

    @BackpressureSupport(BackpressureKind.PASS_THROUGH)
    @SchedulerSupport("none")
    @NonNull
    @CheckReturnValue
    public final <U> Flowable<T> takeUntil(@NonNull Publisher<U> publisher) {
        Objects.requireNonNull(publisher, "other is null");
        return RxJavaPlugins.onAssembly(new FlowableTakeUntil(this, publisher));
    }

    @BackpressureSupport(BackpressureKind.FULL)
    @SchedulerSupport("none")
    @NonNull
    @CheckReturnValue
    public final TestSubscriber<T> test(long j11) {
        TestSubscriber<T> testSubscriber = new TestSubscriber<>(j11);
        subscribe(testSubscriber);
        return testSubscriber;
    }

    @BackpressureSupport(BackpressureKind.ERROR)
    @SchedulerSupport("custom")
    @NonNull
    @CheckReturnValue
    public final Flowable<T> throttleLatest(long j11, @NonNull TimeUnit timeUnit, @NonNull Scheduler scheduler) {
        return throttleLatest(j11, timeUnit, scheduler, false);
    }

    @BackpressureSupport(BackpressureKind.PASS_THROUGH)
    @SchedulerSupport("none")
    @NonNull
    @CheckReturnValue
    public final Flowable<Timed<T>> timeInterval(@NonNull TimeUnit timeUnit) {
        return timeInterval(timeUnit, Schedulers.computation());
    }

    @BackpressureSupport(BackpressureKind.PASS_THROUGH)
    @SchedulerSupport("none")
    @NonNull
    @CheckReturnValue
    public final Flowable<Timed<T>> timestamp(@NonNull TimeUnit timeUnit) {
        return timestamp(timeUnit, Schedulers.computation());
    }

    @BackpressureSupport(BackpressureKind.UNBOUNDED_IN)
    @SchedulerSupport("none")
    @NonNull
    @CheckReturnValue
    public final <K, V> Single<Map<K, V>> toMap(@NonNull Function<? super T, ? extends K> function, @NonNull Function<? super T, ? extends V> function2) {
        Objects.requireNonNull(function, "keySelector is null");
        Objects.requireNonNull(function2, "valueSelector is null");
        return collect(HashMapSupplier.asSupplier(), Functions.toMapKeyValueSelector(function, function2));
    }

    @BackpressureSupport(BackpressureKind.FULL)
    @SchedulerSupport("none")
    @NonNull
    @CheckReturnValue
    public final Flowable<Flowable<T>> window(long j11, long j12, int i11) {
        ObjectHelper.verifyPositive(j12, "skip");
        ObjectHelper.verifyPositive(j11, "count");
        ObjectHelper.verifyPositive(i11, "bufferSize");
        return RxJavaPlugins.onAssembly(new FlowableWindow(this, j11, j12, i11));
    }

    @BackpressureSupport(BackpressureKind.FULL)
    @SchedulerSupport("none")
    @NonNull
    @CheckReturnValue
    public static <T> Flowable<T> concat(@NonNull Publisher<? extends Publisher<? extends T>> publisher, int i11) {
        return fromPublisher(publisher).concatMap(Functions.identity(), i11);
    }

    @BackpressureSupport(BackpressureKind.FULL)
    @SchedulerSupport("none")
    @NonNull
    @CheckReturnValue
    public static <T> Flowable<T> concatDelayError(@NonNull Publisher<? extends Publisher<? extends T>> publisher, int i11, boolean z11) {
        return fromPublisher(publisher).concatMapDelayError(Functions.identity(), z11, i11);
    }

    @BackpressureSupport(BackpressureKind.FULL)
    @SchedulerSupport("none")
    @NonNull
    @CheckReturnValue
    public static <T> Flowable<T> merge(@NonNull Publisher<? extends Publisher<? extends T>> publisher) {
        return merge(publisher, bufferSize());
    }

    @BackpressureSupport(BackpressureKind.FULL)
    @SchedulerSupport("none")
    @NonNull
    @CheckReturnValue
    public static <T> Flowable<T> mergeDelayError(@NonNull Publisher<? extends Publisher<? extends T>> publisher) {
        return mergeDelayError(publisher, bufferSize());
    }

    private <U, V> Flowable<T> timeout0(Publisher<U> publisher, Function<? super T, ? extends Publisher<V>> function, Publisher<? extends T> publisher2) {
        Objects.requireNonNull(function, "itemTimeoutIndicator is null");
        return RxJavaPlugins.onAssembly(new FlowableTimeout(this, publisher, function, publisher2));
    }

    @BackpressureSupport(BackpressureKind.FULL)
    @SchedulerSupport("none")
    @NonNull
    @CheckReturnValue
    public static <T, R> Flowable<R> zip(@NonNull Iterable<? extends Publisher<? extends T>> iterable, @NonNull Function<? super Object[], ? extends R> function, boolean z11, int i11) {
        Objects.requireNonNull(function, "zipper is null");
        Objects.requireNonNull(iterable, "sources is null");
        ObjectHelper.verifyPositive(i11, "bufferSize");
        return RxJavaPlugins.onAssembly(new FlowableZip((Publisher<? extends T>[]) null, iterable, function, i11, z11));
    }

    @BackpressureSupport(BackpressureKind.UNBOUNDED_IN)
    @SchedulerSupport("none")
    public final void blockingSubscribe(@NonNull Consumer<? super T> consumer, @NonNull Consumer<? super Throwable> consumer2) {
        FlowableBlockingSubscribe.subscribe(this, consumer, consumer2, Functions.EMPTY_ACTION);
    }

    @BackpressureSupport(BackpressureKind.UNBOUNDED_IN)
    @SchedulerSupport("none")
    @NonNull
    @CheckReturnValue
    public final <R, A> Single<R> collect(@NonNull Collector<? super T, A, R> collector) {
        Objects.requireNonNull(collector, "collector is null");
        return RxJavaPlugins.onAssembly(new FlowableCollectWithCollectorSingle(this, collector));
    }

    @BackpressureSupport(BackpressureKind.ERROR)
    @SchedulerSupport("custom")
    @NonNull
    @CheckReturnValue
    public final Flowable<T> debounce(long j11, @NonNull TimeUnit timeUnit, @NonNull Scheduler scheduler) {
        Objects.requireNonNull(timeUnit, "unit is null");
        Objects.requireNonNull(scheduler, "scheduler is null");
        return RxJavaPlugins.onAssembly(new FlowableDebounceTimed(this, j11, timeUnit, scheduler));
    }

    @BackpressureSupport(BackpressureKind.FULL)
    @SchedulerSupport("io.reactivex:computation")
    @NonNull
    @CheckReturnValue
    public final Flowable<T> delay(long j11, @NonNull TimeUnit timeUnit, boolean z11) {
        return delay(j11, timeUnit, Schedulers.computation(), z11);
    }

    @BackpressureSupport(BackpressureKind.FULL)
    @SchedulerSupport("custom")
    @NonNull
    @CheckReturnValue
    public final Flowable<T> delaySubscription(long j11, @NonNull TimeUnit timeUnit, @NonNull Scheduler scheduler) {
        return delaySubscription(timer(j11, timeUnit, scheduler));
    }

    @BackpressureSupport(BackpressureKind.FULL)
    @SchedulerSupport("none")
    @NonNull
    @CheckReturnValue
    public final Flowable<T> distinctUntilChanged(@NonNull BiPredicate<? super T, ? super T> biPredicate) {
        Objects.requireNonNull(biPredicate, "comparer is null");
        return RxJavaPlugins.onAssembly(new FlowableDistinctUntilChanged(this, Functions.identity(), biPredicate));
    }

    @BackpressureSupport(BackpressureKind.FULL)
    @SchedulerSupport("none")
    @NonNull
    @CheckReturnValue
    public final <R> Flowable<R> flatMap(@NonNull Function<? super T, ? extends Publisher<? extends R>> function, boolean z11, int i11) {
        return flatMap(function, z11, i11, bufferSize());
    }

    @BackpressureSupport(BackpressureKind.ERROR)
    @SchedulerSupport("none")
    @NonNull
    @CheckReturnValue
    public final <K, V> Flowable<GroupedFlowable<K, V>> groupBy(@NonNull Function<? super T, ? extends K> function, @NonNull Function<? super T, ? extends V> function2, boolean z11) {
        return groupBy(function, function2, z11, bufferSize());
    }

    @BackpressureSupport(BackpressureKind.ERROR)
    @SchedulerSupport("none")
    @NonNull
    @CheckReturnValue
    public final Flowable<T> onBackpressureBuffer(int i11, boolean z11) {
        return onBackpressureBuffer(i11, z11, false);
    }

    @BackpressureSupport(BackpressureKind.FULL)
    @SchedulerSupport("none")
    @NonNull
    @CheckReturnValue
    public final <R> Flowable<R> replay(@NonNull Function<? super Flowable<T>, ? extends Publisher<R>> function, int i11) {
        Objects.requireNonNull(function, "selector is null");
        ObjectHelper.verifyPositive(i11, "bufferSize");
        return FlowableReplay.multicastSelector(FlowableInternalHelper.replaySupplier(this, i11, false), function);
    }

    @BackpressureSupport(BackpressureKind.FULL)
    @SchedulerSupport("none")
    @NonNull
    @CheckReturnValue
    public final Flowable<T> retry(long j11) {
        return retry(j11, Functions.alwaysTrue());
    }

    @BackpressureSupport(BackpressureKind.FULL)
    @SchedulerSupport("none")
    @NonNull
    @CheckReturnValue
    public final Flowable<T> skip(long j11, @NonNull TimeUnit timeUnit) {
        return skipUntil(timer(j11, timeUnit));
    }

    @BackpressureSupport(BackpressureKind.UNBOUNDED_IN)
    @SchedulerSupport("none")
    @NonNull
    @CheckReturnValue
    public final Flowable<T> skipLast(long j11, @NonNull TimeUnit timeUnit) {
        return skipLast(j11, timeUnit, Schedulers.computation(), false, bufferSize());
    }

    @BackpressureSupport(BackpressureKind.UNBOUNDED_IN)
    @SchedulerSupport("none")
    @NonNull
    @CheckReturnValue
    public final Disposable subscribe(@NonNull Consumer<? super T> consumer, @NonNull Consumer<? super Throwable> consumer2, @NonNull Action action) {
        Objects.requireNonNull(consumer, "onNext is null");
        Objects.requireNonNull(consumer2, "onError is null");
        Objects.requireNonNull(action, "onComplete is null");
        LambdaSubscriber lambdaSubscriber = new LambdaSubscriber(consumer, consumer2, action, FlowableInternalHelper.RequestMax.INSTANCE);
        subscribe(lambdaSubscriber);
        return lambdaSubscriber;
    }

    @BackpressureSupport(BackpressureKind.PASS_THROUGH)
    @SchedulerSupport("custom")
    @NonNull
    @CheckReturnValue
    public final Flowable<T> take(long j11, @NonNull TimeUnit timeUnit, @NonNull Scheduler scheduler) {
        return takeUntil(timer(j11, timeUnit, scheduler));
    }

    @BackpressureSupport(BackpressureKind.ERROR)
    @SchedulerSupport("custom")
    @NonNull
    @CheckReturnValue
    public final Flowable<T> throttleLatest(long j11, @NonNull TimeUnit timeUnit, @NonNull Scheduler scheduler, boolean z11) {
        Objects.requireNonNull(timeUnit, "unit is null");
        Objects.requireNonNull(scheduler, "scheduler is null");
        return RxJavaPlugins.onAssembly(new FlowableThrottleLatest(this, j11, timeUnit, scheduler, z11));
    }

    @BackpressureSupport(BackpressureKind.PASS_THROUGH)
    @SchedulerSupport("none")
    @NonNull
    @CheckReturnValue
    public final Flowable<Timed<T>> timeInterval(@NonNull TimeUnit timeUnit, @NonNull Scheduler scheduler) {
        Objects.requireNonNull(timeUnit, "unit is null");
        Objects.requireNonNull(scheduler, "scheduler is null");
        return RxJavaPlugins.onAssembly(new FlowableTimeInterval(this, timeUnit, scheduler));
    }

    @BackpressureSupport(BackpressureKind.PASS_THROUGH)
    @SchedulerSupport("io.reactivex:computation")
    @NonNull
    @CheckReturnValue
    public final Flowable<T> timeout(long j11, @NonNull TimeUnit timeUnit) {
        return timeout0(j11, timeUnit, (Publisher) null, Schedulers.computation());
    }

    @BackpressureSupport(BackpressureKind.PASS_THROUGH)
    @SchedulerSupport("none")
    @NonNull
    @CheckReturnValue
    public final Flowable<Timed<T>> timestamp(@NonNull TimeUnit timeUnit, @NonNull Scheduler scheduler) {
        Objects.requireNonNull(timeUnit, "unit is null");
        Objects.requireNonNull(scheduler, "scheduler is null");
        return map(Functions.timestampWith(timeUnit, scheduler));
    }

    @BackpressureSupport(BackpressureKind.UNBOUNDED_IN)
    @SchedulerSupport("none")
    @NonNull
    @CheckReturnValue
    public final <U extends Collection<? super T>> Single<U> toList(@NonNull Supplier<U> supplier) {
        Objects.requireNonNull(supplier, "collectionSupplier is null");
        return RxJavaPlugins.onAssembly(new FlowableToListSingle(this, supplier));
    }

    @BackpressureSupport(BackpressureKind.UNBOUNDED_IN)
    @SchedulerSupport("none")
    @NonNull
    @CheckReturnValue
    public final Single<List<T>> toSortedList(@NonNull Comparator<? super T> comparator, int i11) {
        Objects.requireNonNull(comparator, "comparator is null");
        return toList(i11).map(Functions.listSorter(comparator));
    }

    @BackpressureSupport(BackpressureKind.PASS_THROUGH)
    @SchedulerSupport("none")
    @NonNull
    @CheckReturnValue
    public final <T1, T2, R> Flowable<R> withLatestFrom(@NonNull Publisher<T1> publisher, @NonNull Publisher<T2> publisher2, @NonNull Function3<? super T, ? super T1, ? super T2, R> function3) {
        Objects.requireNonNull(publisher, "source1 is null");
        Objects.requireNonNull(publisher2, "source2 is null");
        Objects.requireNonNull(function3, "combiner is null");
        return withLatestFrom((Publisher<?>[]) new Publisher[]{publisher, publisher2}, Functions.toFunction(function3));
    }

    @BackpressureSupport(BackpressureKind.FULL)
    @SchedulerSupport("none")
    @NonNull
    @CheckReturnValue
    public final <U, R> Flowable<R> zipWith(@NonNull Publisher<? extends U> publisher, @NonNull BiFunction<? super T, ? super U, ? extends R> biFunction) {
        Objects.requireNonNull(publisher, "other is null");
        return zip(this, publisher, biFunction);
    }

    @BackpressureSupport(BackpressureKind.FULL)
    @SchedulerSupport("none")
    @NonNull
    @CheckReturnValue
    public static <T> Flowable<T> concat(@NonNull Publisher<? extends T> publisher, @NonNull Publisher<? extends T> publisher2) {
        Objects.requireNonNull(publisher, "source1 is null");
        Objects.requireNonNull(publisher2, "source2 is null");
        return concatArray(publisher, publisher2);
    }

    @BackpressureSupport(BackpressureKind.ERROR)
    @SchedulerSupport("io.reactivex:computation")
    @NonNull
    @CheckReturnValue
    public static Flowable<Long> interval(long j11, @NonNull TimeUnit timeUnit) {
        return interval(j11, j11, timeUnit, Schedulers.computation());
    }

    @BackpressureSupport(BackpressureKind.FULL)
    @SchedulerSupport("none")
    @NonNull
    @CheckReturnValue
    public static <T> Flowable<T> merge(@NonNull Publisher<? extends Publisher<? extends T>> publisher, int i11) {
        return fromPublisher(publisher).flatMap(Functions.identity(), i11);
    }

    @BackpressureSupport(BackpressureKind.FULL)
    @SchedulerSupport("none")
    @NonNull
    @CheckReturnValue
    public static <T> Flowable<T> mergeDelayError(@NonNull Publisher<? extends Publisher<? extends T>> publisher, int i11) {
        return fromPublisher(publisher).flatMap(Functions.identity(), true, i11);
    }

    @BackpressureSupport(BackpressureKind.UNBOUNDED_IN)
    @SchedulerSupport("none")
    @NonNull
    @CheckReturnValue
    public final T blockingFirst(@NonNull T t11) {
        Objects.requireNonNull(t11, "defaultItem is null");
        BlockingFirstSubscriber blockingFirstSubscriber = new BlockingFirstSubscriber();
        subscribe(blockingFirstSubscriber);
        T blockingGet = blockingFirstSubscriber.blockingGet();
        return blockingGet != null ? blockingGet : t11;
    }

    @BackpressureSupport(BackpressureKind.UNBOUNDED_IN)
    @SchedulerSupport("none")
    @NonNull
    @CheckReturnValue
    public final T blockingLast(@NonNull T t11) {
        Objects.requireNonNull(t11, "defaultItem is null");
        BlockingLastSubscriber blockingLastSubscriber = new BlockingLastSubscriber();
        subscribe(blockingLastSubscriber);
        T blockingGet = blockingLastSubscriber.blockingGet();
        return blockingGet != null ? blockingGet : t11;
    }

    @BackpressureSupport(BackpressureKind.FULL)
    @SchedulerSupport("none")
    public final void blockingSubscribe(@NonNull Consumer<? super T> consumer, @NonNull Consumer<? super Throwable> consumer2, int i11) {
        FlowableBlockingSubscribe.subscribe(this, consumer, consumer2, Functions.EMPTY_ACTION, i11);
    }

    @BackpressureSupport(BackpressureKind.FULL)
    @SchedulerSupport("none")
    @NonNull
    @CheckReturnValue
    public final Flowable<T> concatWith(@NonNull MaybeSource<? extends T> maybeSource) {
        Objects.requireNonNull(maybeSource, "other is null");
        return RxJavaPlugins.onAssembly(new FlowableConcatWithMaybe(this, maybeSource));
    }

    @BackpressureSupport(BackpressureKind.FULL)
    @SchedulerSupport("custom")
    @NonNull
    @CheckReturnValue
    public final Flowable<T> delay(long j11, @NonNull TimeUnit timeUnit, @NonNull Scheduler scheduler) {
        return delay(j11, timeUnit, scheduler, false);
    }

    @BackpressureSupport(BackpressureKind.FULL)
    @SchedulerSupport("none")
    @NonNull
    @CheckReturnValue
    public final <R> Flowable<R> flatMap(@NonNull Function<? super T, ? extends Publisher<? extends R>> function, boolean z11, int i11, int i12) {
        Objects.requireNonNull(function, "mapper is null");
        ObjectHelper.verifyPositive(i11, "maxConcurrency");
        ObjectHelper.verifyPositive(i12, "bufferSize");
        if (!(this instanceof ScalarSupplier)) {
            return RxJavaPlugins.onAssembly(new FlowableFlatMap(this, function, z11, i11, i12));
        }
        Object obj = ((ScalarSupplier) this).get();
        if (obj == null) {
            return empty();
        }
        return FlowableScalarXMap.scalarXMap(obj, function);
    }

    @BackpressureSupport(BackpressureKind.FULL)
    @SchedulerSupport("none")
    @NonNull
    @CheckReturnValue
    public final <U, V> Flowable<V> flatMapIterable(@NonNull Function<? super T, ? extends Iterable<? extends U>> function, @NonNull BiFunction<? super T, ? super U, ? extends V> biFunction) {
        Objects.requireNonNull(function, "mapper is null");
        Objects.requireNonNull(biFunction, "combiner is null");
        return flatMap(FlowableInternalHelper.flatMapIntoIterable(function), biFunction, false, bufferSize(), bufferSize());
    }

    @BackpressureSupport(BackpressureKind.SPECIAL)
    @SchedulerSupport("none")
    @NonNull
    @CheckReturnValue
    public final <K, V> Flowable<GroupedFlowable<K, V>> groupBy(@NonNull Function<? super T, ? extends K> function, @NonNull Function<? super T, ? extends V> function2, boolean z11, int i11) {
        Objects.requireNonNull(function, "keySelector is null");
        Objects.requireNonNull(function2, "valueSelector is null");
        ObjectHelper.verifyPositive(i11, "bufferSize");
        return RxJavaPlugins.onAssembly(new FlowableGroupBy(this, function, function2, i11, z11, (Function) null));
    }

    @BackpressureSupport(BackpressureKind.FULL)
    @SchedulerSupport("none")
    @NonNull
    @CheckReturnValue
    public final Flowable<T> mergeWith(@NonNull MaybeSource<? extends T> maybeSource) {
        Objects.requireNonNull(maybeSource, "other is null");
        return RxJavaPlugins.onAssembly(new FlowableMergeWithMaybe(this, maybeSource));
    }

    @BackpressureSupport(BackpressureKind.SPECIAL)
    @SchedulerSupport("none")
    @NonNull
    @CheckReturnValue
    public final Flowable<T> onBackpressureBuffer(int i11, boolean z11, boolean z12) {
        ObjectHelper.verifyPositive(i11, "capacity");
        return RxJavaPlugins.onAssembly(new FlowableOnBackpressureBuffer(this, i11, z12, z11, Functions.EMPTY_ACTION));
    }

    @BackpressureSupport(BackpressureKind.FULL)
    @SchedulerSupport("none")
    @NonNull
    @CheckReturnValue
    public final Flowable<T> retry(long j11, @NonNull Predicate<? super Throwable> predicate) {
        if (j11 >= 0) {
            Objects.requireNonNull(predicate, "predicate is null");
            return RxJavaPlugins.onAssembly(new FlowableRetryPredicate(this, j11, predicate));
        }
        throw new IllegalArgumentException("times >= 0 required but it was " + j11);
    }

    @BackpressureSupport(BackpressureKind.FULL)
    @SchedulerSupport("custom")
    @NonNull
    @CheckReturnValue
    public final Flowable<T> skip(long j11, @NonNull TimeUnit timeUnit, @NonNull Scheduler scheduler) {
        return skipUntil(timer(j11, timeUnit, scheduler));
    }

    @BackpressureSupport(BackpressureKind.UNBOUNDED_IN)
    @SchedulerSupport("none")
    @NonNull
    @CheckReturnValue
    public final Flowable<T> skipLast(long j11, @NonNull TimeUnit timeUnit, boolean z11) {
        return skipLast(j11, timeUnit, Schedulers.computation(), z11, bufferSize());
    }

    @BackpressureSupport(BackpressureKind.FULL)
    @SchedulerSupport("none")
    @NonNull
    @CheckReturnValue
    public final Flowable<T> startWith(@NonNull MaybeSource<T> maybeSource) {
        Objects.requireNonNull(maybeSource, "other is null");
        return concat(Maybe.wrap(maybeSource).toFlowable(), (Flowable<T>) this);
    }

    @BackpressureSupport(BackpressureKind.FULL)
    @SchedulerSupport("none")
    @NonNull
    @CheckReturnValue
    public final Flowable<T> takeLast(long j11, long j12, @NonNull TimeUnit timeUnit) {
        return takeLast(j11, j12, timeUnit, Schedulers.computation(), false, bufferSize());
    }

    @BackpressureSupport(BackpressureKind.FULL)
    @SchedulerSupport("none")
    @NonNull
    @CheckReturnValue
    public final TestSubscriber<T> test(long j11, boolean z11) {
        TestSubscriber<T> testSubscriber = new TestSubscriber<>(j11);
        if (z11) {
            testSubscriber.cancel();
        }
        subscribe(testSubscriber);
        return testSubscriber;
    }

    @BackpressureSupport(BackpressureKind.FULL)
    @SchedulerSupport("io.reactivex:computation")
    @NonNull
    @CheckReturnValue
    public final Flowable<T> timeout(long j11, @NonNull TimeUnit timeUnit, @NonNull Publisher<? extends T> publisher) {
        Objects.requireNonNull(publisher, "fallback is null");
        return timeout0(j11, timeUnit, publisher, Schedulers.computation());
    }

    @BackpressureSupport(BackpressureKind.UNBOUNDED_IN)
    @SchedulerSupport("none")
    @NonNull
    @CheckReturnValue
    public final <K, V> Single<Map<K, Collection<V>>> toMultimap(@NonNull Function<? super T, ? extends K> function, @NonNull Function<? super T, ? extends V> function2) {
        return toMultimap(function, function2, HashMapSupplier.asSupplier(), ArrayListSupplier.asFunction());
    }

    @BackpressureSupport(BackpressureKind.FULL)
    @SchedulerSupport("none")
    @NonNull
    @CheckReturnValue
    public static <T1, T2, R> Flowable<R> combineLatest(@NonNull Publisher<? extends T1> publisher, @NonNull Publisher<? extends T2> publisher2, @NonNull BiFunction<? super T1, ? super T2, ? extends R> biFunction) {
        Objects.requireNonNull(publisher, "source1 is null");
        Objects.requireNonNull(publisher2, "source2 is null");
        Objects.requireNonNull(biFunction, "combiner is null");
        return combineLatestArray(new Publisher[]{publisher, publisher2}, Functions.toFunction(biFunction), bufferSize());
    }

    @BackpressureSupport(BackpressureKind.FULL)
    @SchedulerSupport("none")
    @NonNull
    @CheckReturnValue
    public static <T> Flowable<T> concatEager(@NonNull Publisher<? extends Publisher<? extends T>> publisher) {
        return concatEager(publisher, bufferSize(), bufferSize());
    }

    @BackpressureSupport(BackpressureKind.FULL)
    @SchedulerSupport("none")
    @NonNull
    @CheckReturnValue
    public static <T> Flowable<T> concatEagerDelayError(@NonNull Publisher<? extends Publisher<? extends T>> publisher) {
        return concatEagerDelayError(publisher, bufferSize(), bufferSize());
    }

    @BackpressureSupport(BackpressureKind.FULL)
    @SchedulerSupport("none")
    @NonNull
    @CheckReturnValue
    public static <T, S> Flowable<T> generate(@NonNull Supplier<S> supplier, @NonNull BiConsumer<S, Emitter<T>> biConsumer) {
        Objects.requireNonNull(biConsumer, "generator is null");
        return generate(supplier, FlowableInternalHelper.simpleBiGenerator(biConsumer), Functions.emptyConsumer());
    }

    @BackpressureSupport(BackpressureKind.ERROR)
    @SchedulerSupport("custom")
    @NonNull
    @CheckReturnValue
    public static Flowable<Long> interval(long j11, @NonNull TimeUnit timeUnit, @NonNull Scheduler scheduler) {
        return interval(j11, j11, timeUnit, scheduler);
    }

    @BackpressureSupport(BackpressureKind.FULL)
    @SchedulerSupport("none")
    @NonNull
    @CheckReturnValue
    public static <T> Flowable<T> just(T t11, T t12, T t13) {
        Objects.requireNonNull(t11, "item1 is null");
        Objects.requireNonNull(t12, "item2 is null");
        Objects.requireNonNull(t13, "item3 is null");
        return fromArray(t11, t12, t13);
    }

    @BackpressureSupport(BackpressureKind.FULL)
    @SchedulerSupport("none")
    @NonNull
    @CheckReturnValue
    public static <T> Flowable<T> merge(@NonNull Publisher<? extends T> publisher, @NonNull Publisher<? extends T> publisher2) {
        Objects.requireNonNull(publisher, "source1 is null");
        Objects.requireNonNull(publisher2, "source2 is null");
        return fromArray(publisher, publisher2).flatMap(Functions.identity(), false, 2);
    }

    @BackpressureSupport(BackpressureKind.FULL)
    @SchedulerSupport("none")
    @NonNull
    @CheckReturnValue
    public static <T> Flowable<T> mergeDelayError(@NonNull Publisher<? extends T> publisher, @NonNull Publisher<? extends T> publisher2) {
        Objects.requireNonNull(publisher, "source1 is null");
        Objects.requireNonNull(publisher2, "source2 is null");
        return fromArray(publisher, publisher2).flatMap(Functions.identity(), true, 2);
    }

    @BackpressureSupport(BackpressureKind.UNBOUNDED_IN)
    @SchedulerSupport("none")
    public final void blockingSubscribe(@NonNull Consumer<? super T> consumer, @NonNull Consumer<? super Throwable> consumer2, @NonNull Action action) {
        FlowableBlockingSubscribe.subscribe(this, consumer, consumer2, action);
    }

    @BackpressureSupport(BackpressureKind.FULL)
    @SchedulerSupport("custom")
    @NonNull
    @CheckReturnValue
    public final Flowable<T> delay(long j11, @NonNull TimeUnit timeUnit, @NonNull Scheduler scheduler, boolean z11) {
        Objects.requireNonNull(timeUnit, "unit is null");
        Objects.requireNonNull(scheduler, "scheduler is null");
        return RxJavaPlugins.onAssembly(new FlowableDelay(this, Math.max(0, j11), timeUnit, scheduler, z11));
    }

    @BackpressureSupport(BackpressureKind.PASS_THROUGH)
    @SchedulerSupport("none")
    @NonNull
    @CheckReturnValue
    public final Flowable<T> doOnEach(@NonNull Consumer<? super Notification<T>> consumer) {
        Objects.requireNonNull(consumer, "onNotification is null");
        return doOnEach(Functions.notificationOnNext(consumer), Functions.notificationOnError(consumer), Functions.notificationOnComplete(consumer), Functions.EMPTY_ACTION);
    }

    @BackpressureSupport(BackpressureKind.FULL)
    @SchedulerSupport("none")
    @NonNull
    @CheckReturnValue
    public final ConnectableFlowable<T> publish(int i11) {
        ObjectHelper.verifyPositive(i11, "bufferSize");
        return RxJavaPlugins.onAssembly(new FlowablePublish(this, i11));
    }

    @BackpressureSupport(BackpressureKind.ERROR)
    @SchedulerSupport("custom")
    @NonNull
    @CheckReturnValue
    public final Flowable<T> sample(long j11, @NonNull TimeUnit timeUnit, @NonNull Scheduler scheduler, boolean z11) {
        Objects.requireNonNull(timeUnit, "unit is null");
        Objects.requireNonNull(scheduler, "scheduler is null");
        return RxJavaPlugins.onAssembly(new FlowableSampleTimed(this, j11, timeUnit, scheduler, z11));
    }

    @BackpressureSupport(BackpressureKind.UNBOUNDED_IN)
    @SchedulerSupport("custom")
    @NonNull
    @CheckReturnValue
    public final Flowable<T> skipLast(long j11, @NonNull TimeUnit timeUnit, @NonNull Scheduler scheduler) {
        return skipLast(j11, timeUnit, scheduler, false, bufferSize());
    }

    @BackpressureSupport(BackpressureKind.FULL)
    @SchedulerSupport("custom")
    @NonNull
    @CheckReturnValue
    public final Flowable<T> takeLast(long j11, long j12, @NonNull TimeUnit timeUnit, @NonNull Scheduler scheduler) {
        return takeLast(j11, j12, timeUnit, scheduler, false, bufferSize());
    }

    @BackpressureSupport(BackpressureKind.UNBOUNDED_IN)
    @SchedulerSupport("none")
    @NonNull
    @CheckReturnValue
    public final <K, V> Single<Map<K, V>> toMap(@NonNull Function<? super T, ? extends K> function, @NonNull Function<? super T, ? extends V> function2, @NonNull Supplier<? extends Map<K, V>> supplier) {
        Objects.requireNonNull(function, "keySelector is null");
        Objects.requireNonNull(function2, "valueSelector is null");
        return collect(supplier, Functions.toMapKeyValueSelector(function, function2));
    }

    @BackpressureSupport(BackpressureKind.UNBOUNDED_IN)
    @SchedulerSupport("none")
    @NonNull
    @CheckReturnValue
    public final Single<List<T>> toSortedList(int i11) {
        return toSortedList(Functions.naturalComparator(), i11);
    }

    @BackpressureSupport(BackpressureKind.FULL)
    @SchedulerSupport("none")
    @NonNull
    @CheckReturnValue
    public final <U, R> Flowable<R> zipWith(@NonNull Publisher<? extends U> publisher, @NonNull BiFunction<? super T, ? super U, ? extends R> biFunction, boolean z11) {
        return zip(this, publisher, biFunction, z11);
    }

    @BackpressureSupport(BackpressureKind.FULL)
    @SchedulerSupport("none")
    @NonNull
    @CheckReturnValue
    public static <T> Flowable<T> concatEager(@NonNull Publisher<? extends Publisher<? extends T>> publisher, int i11, int i12) {
        Objects.requireNonNull(publisher, "sources is null");
        ObjectHelper.verifyPositive(i11, "maxConcurrency");
        ObjectHelper.verifyPositive(i12, "prefetch");
        return RxJavaPlugins.onAssembly(new FlowableConcatMapEagerPublisher(publisher, Functions.identity(), i11, i12, ErrorMode.IMMEDIATE));
    }

    @BackpressureSupport(BackpressureKind.FULL)
    @SchedulerSupport("none")
    @NonNull
    @CheckReturnValue
    public static <T> Flowable<T> concatEagerDelayError(@NonNull Publisher<? extends Publisher<? extends T>> publisher, int i11, int i12) {
        Objects.requireNonNull(publisher, "sources is null");
        ObjectHelper.verifyPositive(i11, "maxConcurrency");
        ObjectHelper.verifyPositive(i12, "prefetch");
        return RxJavaPlugins.onAssembly(new FlowableConcatMapEagerPublisher(publisher, Functions.identity(), i11, i12, ErrorMode.END));
    }

    @BackpressureSupport(BackpressureKind.FULL)
    @SchedulerSupport("none")
    public final void blockingSubscribe(@NonNull Consumer<? super T> consumer, @NonNull Consumer<? super Throwable> consumer2, @NonNull Action action, int i11) {
        FlowableBlockingSubscribe.subscribe(this, consumer, consumer2, action, i11);
    }

    @BackpressureSupport(BackpressureKind.FULL)
    @SchedulerSupport("none")
    @NonNull
    @CheckReturnValue
    public final <U extends Collection<? super T>> Flowable<U> buffer(int i11, @NonNull Supplier<U> supplier) {
        return buffer(i11, i11, supplier);
    }

    @BackpressureSupport(BackpressureKind.PASS_THROUGH)
    @SchedulerSupport("none")
    @NonNull
    @CheckReturnValue
    public final Flowable<T> concatWith(@NonNull CompletableSource completableSource) {
        Objects.requireNonNull(completableSource, "other is null");
        return RxJavaPlugins.onAssembly(new FlowableConcatWithCompletable(this, completableSource));
    }

    @BackpressureSupport(BackpressureKind.PASS_THROUGH)
    @SchedulerSupport("none")
    @NonNull
    @CheckReturnValue
    public final Flowable<T> mergeWith(@NonNull CompletableSource completableSource) {
        Objects.requireNonNull(completableSource, "other is null");
        return RxJavaPlugins.onAssembly(new FlowableMergeWithCompletable(this, completableSource));
    }

    @BackpressureSupport(BackpressureKind.SPECIAL)
    @SchedulerSupport("none")
    @NonNull
    @CheckReturnValue
    public final Flowable<T> onBackpressureBuffer(int i11, boolean z11, boolean z12, @NonNull Action action) {
        Objects.requireNonNull(action, "onOverflow is null");
        ObjectHelper.verifyPositive(i11, "capacity");
        return RxJavaPlugins.onAssembly(new FlowableOnBackpressureBuffer(this, i11, z12, z11, action));
    }

    @BackpressureSupport(BackpressureKind.FULL)
    @SchedulerSupport("none")
    @NonNull
    @CheckReturnValue
    public final <R> Flowable<R> replay(@NonNull Function<? super Flowable<T>, ? extends Publisher<R>> function, int i11, boolean z11) {
        Objects.requireNonNull(function, "selector is null");
        ObjectHelper.verifyPositive(i11, "bufferSize");
        return FlowableReplay.multicastSelector(FlowableInternalHelper.replaySupplier(this, i11, z11), function);
    }

    @BackpressureSupport(BackpressureKind.UNBOUNDED_IN)
    @SchedulerSupport("custom")
    @NonNull
    @CheckReturnValue
    public final Flowable<T> skipLast(long j11, @NonNull TimeUnit timeUnit, @NonNull Scheduler scheduler, boolean z11) {
        return skipLast(j11, timeUnit, scheduler, z11, bufferSize());
    }

    @BackpressureSupport(BackpressureKind.FULL)
    @SchedulerSupport("none")
    @NonNull
    @CheckReturnValue
    public final Flowable<T> startWith(@NonNull Publisher<? extends T> publisher) {
        Objects.requireNonNull(publisher, "other is null");
        return concatArray(publisher, this);
    }

    @BackpressureSupport(BackpressureKind.FULL)
    @SchedulerSupport("custom")
    @NonNull
    @CheckReturnValue
    public final Flowable<T> takeLast(long j11, long j12, @NonNull TimeUnit timeUnit, @NonNull Scheduler scheduler, boolean z11, int i11) {
        Objects.requireNonNull(timeUnit, "unit is null");
        Objects.requireNonNull(scheduler, "scheduler is null");
        ObjectHelper.verifyPositive(i11, "bufferSize");
        if (j11 >= 0) {
            return RxJavaPlugins.onAssembly(new FlowableTakeLastTimed(this, j11, j12, timeUnit, scheduler, i11, z11));
        }
        throw new IllegalArgumentException("count >= 0 required but it was " + j11);
    }

    @BackpressureSupport(BackpressureKind.FULL)
    @SchedulerSupport("custom")
    @NonNull
    @CheckReturnValue
    public final Flowable<T> timeout(long j11, @NonNull TimeUnit timeUnit, @NonNull Scheduler scheduler, @NonNull Publisher<? extends T> publisher) {
        Objects.requireNonNull(publisher, "fallback is null");
        return timeout0(j11, timeUnit, publisher, scheduler);
    }

    @BackpressureSupport(BackpressureKind.ERROR)
    @SchedulerSupport("io.reactivex:computation")
    @NonNull
    @CheckReturnValue
    public final Flowable<Flowable<T>> window(long j11, long j12, @NonNull TimeUnit timeUnit) {
        return window(j11, j12, timeUnit, Schedulers.computation(), bufferSize());
    }

    @BackpressureSupport(BackpressureKind.FULL)
    @SchedulerSupport("none")
    @NonNull
    @CheckReturnValue
    public final <U, R> Flowable<R> zipWith(@NonNull Publisher<? extends U> publisher, @NonNull BiFunction<? super T, ? super U, ? extends R> biFunction, boolean z11, int i11) {
        return zip(this, publisher, biFunction, z11, i11);
    }

    @BackpressureSupport(BackpressureKind.FULL)
    @SchedulerSupport("none")
    @NonNull
    @CheckReturnValue
    public static <T> Flowable<T> concat(@NonNull Publisher<? extends T> publisher, @NonNull Publisher<? extends T> publisher2, @NonNull Publisher<? extends T> publisher3) {
        Objects.requireNonNull(publisher, "source1 is null");
        Objects.requireNonNull(publisher2, "source2 is null");
        Objects.requireNonNull(publisher3, "source3 is null");
        return concatArray(publisher, publisher2, publisher3);
    }

    @BackpressureSupport(BackpressureKind.FULL)
    @SchedulerSupport("none")
    @NonNull
    @CheckReturnValue
    public static <T> Single<Boolean> sequenceEqual(@NonNull Publisher<? extends T> publisher, @NonNull Publisher<? extends T> publisher2, int i11) {
        return sequenceEqual(publisher, publisher2, ObjectHelper.equalsPredicate(), i11);
    }

    @BackpressureSupport(BackpressureKind.FULL)
    @SchedulerSupport("none")
    @NonNull
    @CheckReturnValue
    public static <T1, T2, R> Flowable<R> zip(@NonNull Publisher<? extends T1> publisher, @NonNull Publisher<? extends T2> publisher2, @NonNull BiFunction<? super T1, ? super T2, ? extends R> biFunction) {
        Objects.requireNonNull(publisher, "source1 is null");
        Objects.requireNonNull(publisher2, "source2 is null");
        Objects.requireNonNull(biFunction, "zipper is null");
        return zipArray(Functions.toFunction(biFunction), false, bufferSize(), publisher, publisher2);
    }

    @BackpressureSupport(BackpressureKind.SPECIAL)
    @SchedulerSupport("none")
    public final void blockingSubscribe(@NonNull Subscriber<? super T> subscriber) {
        Objects.requireNonNull(subscriber, "subscriber is null");
        FlowableBlockingSubscribe.subscribe(this, subscriber);
    }

    @BackpressureSupport(BackpressureKind.ERROR)
    @SchedulerSupport("io.reactivex:computation")
    @NonNull
    @CheckReturnValue
    public final Flowable<List<T>> buffer(long j11, long j12, @NonNull TimeUnit timeUnit) {
        return buffer(j11, j12, timeUnit, Schedulers.computation(), ArrayListSupplier.asSupplier());
    }

    @BackpressureSupport(BackpressureKind.FULL)
    @SchedulerSupport("none")
    @NonNull
    @CheckReturnValue
    public final <U, V> Flowable<V> flatMapIterable(@NonNull Function<? super T, ? extends Iterable<? extends U>> function, @NonNull BiFunction<? super T, ? super U, ? extends V> biFunction, int i11) {
        Objects.requireNonNull(function, "mapper is null");
        Objects.requireNonNull(biFunction, "combiner is null");
        return flatMap(FlowableInternalHelper.flatMapIntoIterable(function), biFunction, false, bufferSize(), i11);
    }

    @BackpressureSupport(BackpressureKind.FULL)
    @SchedulerSupport("none")
    @NonNull
    @CheckReturnValue
    public final Flowable<T> retry(@NonNull Predicate<? super Throwable> predicate) {
        return retry(Long.MAX_VALUE, predicate);
    }

    @BackpressureSupport(BackpressureKind.UNBOUNDED_IN)
    @SchedulerSupport("custom")
    @NonNull
    @CheckReturnValue
    public final Flowable<T> skipLast(long j11, @NonNull TimeUnit timeUnit, @NonNull Scheduler scheduler, boolean z11, int i11) {
        Objects.requireNonNull(timeUnit, "unit is null");
        Objects.requireNonNull(scheduler, "scheduler is null");
        ObjectHelper.verifyPositive(i11, "bufferSize");
        return RxJavaPlugins.onAssembly(new FlowableSkipLastTimed(this, j11, timeUnit, scheduler, i11 << 1, z11));
    }

    @BackpressureSupport(BackpressureKind.UNBOUNDED_IN)
    @SchedulerSupport("none")
    @NonNull
    @CheckReturnValue
    public final <K, V> Single<Map<K, Collection<V>>> toMultimap(@NonNull Function<? super T, ? extends K> function, @NonNull Function<? super T, ? extends V> function2, @NonNull Supplier<? extends Map<K, Collection<V>>> supplier, @NonNull Function<? super K, ? extends Collection<? super V>> function3) {
        Objects.requireNonNull(function, "keySelector is null");
        Objects.requireNonNull(function2, "valueSelector is null");
        Objects.requireNonNull(supplier, "mapSupplier is null");
        Objects.requireNonNull(function3, "collectionFactory is null");
        return collect(supplier, Functions.toMultimapKeyValueSelector(function, function2, function3));
    }

    @BackpressureSupport(BackpressureKind.ERROR)
    @SchedulerSupport("custom")
    @NonNull
    @CheckReturnValue
    public final Flowable<Flowable<T>> window(long j11, long j12, @NonNull TimeUnit timeUnit, @NonNull Scheduler scheduler) {
        return window(j11, j12, timeUnit, scheduler, bufferSize());
    }

    @BackpressureSupport(BackpressureKind.FULL)
    @SchedulerSupport("none")
    @NonNull
    @CheckReturnValue
    public static <T> Flowable<T> merge(@NonNull Publisher<? extends T> publisher, @NonNull Publisher<? extends T> publisher2, @NonNull Publisher<? extends T> publisher3) {
        Objects.requireNonNull(publisher, "source1 is null");
        Objects.requireNonNull(publisher2, "source2 is null");
        Objects.requireNonNull(publisher3, "source3 is null");
        return fromArray(publisher, publisher2, publisher3).flatMap(Functions.identity(), false, 3);
    }

    @BackpressureSupport(BackpressureKind.FULL)
    @SchedulerSupport("none")
    @NonNull
    @CheckReturnValue
    public static <T> Flowable<T> mergeDelayError(@NonNull Publisher<? extends T> publisher, @NonNull Publisher<? extends T> publisher2, @NonNull Publisher<? extends T> publisher3) {
        Objects.requireNonNull(publisher, "source1 is null");
        Objects.requireNonNull(publisher2, "source2 is null");
        Objects.requireNonNull(publisher3, "source3 is null");
        return fromArray(publisher, publisher2, publisher3).flatMap(Functions.identity(), true, 3);
    }

    @BackpressureSupport(BackpressureKind.ERROR)
    @SchedulerSupport("custom")
    @NonNull
    @CheckReturnValue
    public final Flowable<List<T>> buffer(long j11, long j12, @NonNull TimeUnit timeUnit, @NonNull Scheduler scheduler) {
        return buffer(j11, j12, timeUnit, scheduler, ArrayListSupplier.asSupplier());
    }

    @BackpressureSupport(BackpressureKind.FULL)
    @SchedulerSupport("custom")
    @NonNull
    @CheckReturnValue
    public final <R> Flowable<R> concatMap(@NonNull Function<? super T, ? extends Publisher<? extends R>> function, int i11, @NonNull Scheduler scheduler) {
        Objects.requireNonNull(function, "mapper is null");
        ObjectHelper.verifyPositive(i11, "prefetch");
        Objects.requireNonNull(scheduler, "scheduler is null");
        return RxJavaPlugins.onAssembly(new FlowableConcatMapScheduler(this, function, i11, ErrorMode.IMMEDIATE, scheduler));
    }

    @BackpressureSupport(BackpressureKind.FULL)
    @SchedulerSupport("custom")
    @NonNull
    @CheckReturnValue
    public final <R> Flowable<R> concatMapDelayError(@NonNull Function<? super T, ? extends Publisher<? extends R>> function, boolean z11, int i11, @NonNull Scheduler scheduler) {
        Objects.requireNonNull(function, "mapper is null");
        ObjectHelper.verifyPositive(i11, "prefetch");
        Objects.requireNonNull(scheduler, "scheduler is null");
        return RxJavaPlugins.onAssembly(new FlowableConcatMapScheduler(this, function, i11, z11 ? ErrorMode.END : ErrorMode.BOUNDARY, scheduler));
    }

    /* JADX WARNING: type inference failed for: r2v0, types: [io.reactivex.rxjava3.functions.Function, io.reactivex.rxjava3.functions.Function<? super T, ? extends org.reactivestreams.Publisher<V>>] */
    /* JADX WARNING: Unknown variable types count: 1 */
    @io.reactivex.rxjava3.annotations.BackpressureSupport(io.reactivex.rxjava3.annotations.BackpressureKind.FULL)
    @io.reactivex.rxjava3.annotations.SchedulerSupport("none")
    @io.reactivex.rxjava3.annotations.NonNull
    @io.reactivex.rxjava3.annotations.CheckReturnValue
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final <U, V> io.reactivex.rxjava3.core.Flowable<T> delay(@io.reactivex.rxjava3.annotations.NonNull org.reactivestreams.Publisher<U> r1, @io.reactivex.rxjava3.annotations.NonNull io.reactivex.rxjava3.functions.Function<? super T, ? extends org.reactivestreams.Publisher<V>> r2) {
        /*
            r0 = this;
            io.reactivex.rxjava3.core.Flowable r1 = r0.delaySubscription(r1)
            io.reactivex.rxjava3.core.Flowable r1 = r1.delay(r2)
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: io.reactivex.rxjava3.core.Flowable.delay(org.reactivestreams.Publisher, io.reactivex.rxjava3.functions.Function):io.reactivex.rxjava3.core.Flowable");
    }

    @BackpressureSupport(BackpressureKind.SPECIAL)
    @SchedulerSupport("none")
    @NonNull
    @CheckReturnValue
    public final <K, V> Flowable<GroupedFlowable<K, V>> groupBy(@NonNull Function<? super T, ? extends K> function, @NonNull Function<? super T, ? extends V> function2, boolean z11, int i11, @NonNull Function<? super Consumer<Object>, ? extends Map<K, Object>> function3) {
        Objects.requireNonNull(function, "keySelector is null");
        Objects.requireNonNull(function2, "valueSelector is null");
        ObjectHelper.verifyPositive(i11, "bufferSize");
        Objects.requireNonNull(function3, "evictingMapFactory is null");
        return RxJavaPlugins.onAssembly(new FlowableGroupBy(this, function, function2, i11, z11, function3));
    }

    @BackpressureSupport(BackpressureKind.ERROR)
    @SchedulerSupport("none")
    @NonNull
    @CheckReturnValue
    public final <U> Flowable<T> sample(@NonNull Publisher<U> publisher) {
        Objects.requireNonNull(publisher, "sampler is null");
        return RxJavaPlugins.onAssembly(new FlowableSamplePublisher(this, publisher, false));
    }

    @BackpressureSupport(BackpressureKind.SPECIAL)
    @SchedulerSupport("none")
    @NonNull
    public final Disposable subscribe(@NonNull Consumer<? super T> consumer, @NonNull Consumer<? super Throwable> consumer2, @NonNull Action action, @NonNull DisposableContainer disposableContainer) {
        Objects.requireNonNull(consumer, "onNext is null");
        Objects.requireNonNull(consumer2, "onError is null");
        Objects.requireNonNull(action, "onComplete is null");
        Objects.requireNonNull(disposableContainer, "container is null");
        DisposableAutoReleaseSubscriber disposableAutoReleaseSubscriber = new DisposableAutoReleaseSubscriber(disposableContainer, consumer, consumer2, action);
        disposableContainer.add(disposableAutoReleaseSubscriber);
        subscribe(disposableAutoReleaseSubscriber);
        return disposableAutoReleaseSubscriber;
    }

    @BackpressureSupport(BackpressureKind.PASS_THROUGH)
    @SchedulerSupport("custom")
    @NonNull
    @CheckReturnValue
    public final Flowable<T> timeout(long j11, @NonNull TimeUnit timeUnit, @NonNull Scheduler scheduler) {
        return timeout0(j11, timeUnit, (Publisher) null, scheduler);
    }

    @BackpressureSupport(BackpressureKind.ERROR)
    @SchedulerSupport("custom")
    @NonNull
    @CheckReturnValue
    public final Flowable<Flowable<T>> window(long j11, long j12, @NonNull TimeUnit timeUnit, @NonNull Scheduler scheduler, int i11) {
        int i12 = i11;
        ObjectHelper.verifyPositive(i12, "bufferSize");
        ObjectHelper.verifyPositive(j11, "timespan");
        long j13 = j12;
        ObjectHelper.verifyPositive(j13, "timeskip");
        Scheduler scheduler2 = scheduler;
        Objects.requireNonNull(scheduler2, "scheduler is null");
        TimeUnit timeUnit2 = timeUnit;
        Objects.requireNonNull(timeUnit2, "unit is null");
        return RxJavaPlugins.onAssembly(new FlowableWindowTimed(this, j11, j13, timeUnit2, scheduler2, Long.MAX_VALUE, i12, false));
    }

    @BackpressureSupport(BackpressureKind.PASS_THROUGH)
    @SchedulerSupport("none")
    @NonNull
    @CheckReturnValue
    public final <T1, T2, T3, R> Flowable<R> withLatestFrom(@NonNull Publisher<T1> publisher, @NonNull Publisher<T2> publisher2, @NonNull Publisher<T3> publisher3, @NonNull Function4<? super T, ? super T1, ? super T2, ? super T3, R> function4) {
        Objects.requireNonNull(publisher, "source1 is null");
        Objects.requireNonNull(publisher2, "source2 is null");
        Objects.requireNonNull(publisher3, "source3 is null");
        Objects.requireNonNull(function4, "combiner is null");
        return withLatestFrom((Publisher<?>[]) new Publisher[]{publisher, publisher2, publisher3}, Functions.toFunction(function4));
    }

    @BackpressureSupport(BackpressureKind.FULL)
    @SchedulerSupport("none")
    @NonNull
    @CheckReturnValue
    public static <T1, T2, T3, R> Flowable<R> combineLatest(@NonNull Publisher<? extends T1> publisher, @NonNull Publisher<? extends T2> publisher2, @NonNull Publisher<? extends T3> publisher3, @NonNull Function3<? super T1, ? super T2, ? super T3, ? extends R> function3) {
        Objects.requireNonNull(publisher, "source1 is null");
        Objects.requireNonNull(publisher2, "source2 is null");
        Objects.requireNonNull(publisher3, "source3 is null");
        Objects.requireNonNull(function3, "combiner is null");
        return combineLatestArray(new Publisher[]{publisher, publisher2, publisher3}, Functions.toFunction(function3), bufferSize());
    }

    @BackpressureSupport(BackpressureKind.FULL)
    @SchedulerSupport("none")
    @NonNull
    @CheckReturnValue
    public static <T, S> Flowable<T> generate(@NonNull Supplier<S> supplier, @NonNull BiConsumer<S, Emitter<T>> biConsumer, @NonNull Consumer<? super S> consumer) {
        Objects.requireNonNull(biConsumer, "generator is null");
        return generate(supplier, FlowableInternalHelper.simpleBiGenerator(biConsumer), consumer);
    }

    @BackpressureSupport(BackpressureKind.FULL)
    @SchedulerSupport("none")
    @NonNull
    @CheckReturnValue
    public static <T> Flowable<T> just(T t11, T t12, T t13, T t14) {
        Objects.requireNonNull(t11, "item1 is null");
        Objects.requireNonNull(t12, "item2 is null");
        Objects.requireNonNull(t13, "item3 is null");
        Objects.requireNonNull(t14, "item4 is null");
        return fromArray(t11, t12, t13, t14);
    }

    @BackpressureSupport(BackpressureKind.ERROR)
    @SchedulerSupport("custom")
    @NonNull
    @CheckReturnValue
    public final <U extends Collection<? super T>> Flowable<U> buffer(long j11, long j12, @NonNull TimeUnit timeUnit, @NonNull Scheduler scheduler, @NonNull Supplier<U> supplier) {
        TimeUnit timeUnit2 = timeUnit;
        Objects.requireNonNull(timeUnit2, "unit is null");
        Scheduler scheduler2 = scheduler;
        Objects.requireNonNull(scheduler2, "scheduler is null");
        Supplier<U> supplier2 = supplier;
        Objects.requireNonNull(supplier2, "bufferSupplier is null");
        return RxJavaPlugins.onAssembly(new FlowableBufferTimed(this, j11, j12, timeUnit2, scheduler2, supplier2, Integer.MAX_VALUE, false));
    }

    @BackpressureSupport(BackpressureKind.ERROR)
    @SchedulerSupport("none")
    @NonNull
    @CheckReturnValue
    public final Flowable<T> onBackpressureBuffer(int i11, @NonNull Action action) {
        return onBackpressureBuffer(i11, false, false, action);
    }

    @BackpressureSupport(BackpressureKind.FULL)
    @SchedulerSupport("io.reactivex:computation")
    @NonNull
    @CheckReturnValue
    public final <R> Flowable<R> replay(@NonNull Function<? super Flowable<T>, ? extends Publisher<R>> function, int i11, long j11, @NonNull TimeUnit timeUnit) {
        return replay(function, i11, j11, timeUnit, Schedulers.computation());
    }

    @BackpressureSupport(BackpressureKind.PASS_THROUGH)
    @SchedulerSupport("none")
    @NonNull
    @CheckReturnValue
    public final <U, V> Flowable<T> timeout(@NonNull Publisher<U> publisher, @NonNull Function<? super T, ? extends Publisher<V>> function) {
        Objects.requireNonNull(publisher, "firstTimeoutIndicator is null");
        return timeout0(publisher, function, (Publisher) null);
    }

    @BackpressureSupport(BackpressureKind.PASS_THROUGH)
    @SchedulerSupport("none")
    @NonNull
    @CheckReturnValue
    public final Flowable<T> doOnEach(@NonNull Subscriber<? super T> subscriber) {
        Objects.requireNonNull(subscriber, "subscriber is null");
        return doOnEach(FlowableInternalHelper.subscriberOnNext(subscriber), FlowableInternalHelper.subscriberOnError(subscriber), FlowableInternalHelper.subscriberOnComplete(subscriber), Functions.EMPTY_ACTION);
    }

    @BackpressureSupport(BackpressureKind.SPECIAL)
    @SchedulerSupport("none")
    @NonNull
    @CheckReturnValue
    public final Flowable<T> onBackpressureBuffer(long j11, @Nullable Action action, @NonNull BackpressureOverflowStrategy backpressureOverflowStrategy) {
        Objects.requireNonNull(backpressureOverflowStrategy, "overflowStrategy is null");
        ObjectHelper.verifyPositive(j11, "capacity");
        return RxJavaPlugins.onAssembly(new FlowableOnBackpressureBufferStrategy(this, j11, action, backpressureOverflowStrategy));
    }

    @BackpressureSupport(BackpressureKind.FULL)
    @SchedulerSupport("custom")
    @NonNull
    @CheckReturnValue
    public final <R> Flowable<R> replay(@NonNull Function<? super Flowable<T>, ? extends Publisher<R>> function, int i11, long j11, @NonNull TimeUnit timeUnit, @NonNull Scheduler scheduler) {
        Objects.requireNonNull(function, "selector is null");
        Objects.requireNonNull(timeUnit, "unit is null");
        ObjectHelper.verifyPositive(i11, "bufferSize");
        Objects.requireNonNull(scheduler, "scheduler is null");
        return FlowableReplay.multicastSelector(FlowableInternalHelper.replaySupplier(this, i11, j11, timeUnit, scheduler, false), function);
    }

    @BackpressureSupport(BackpressureKind.ERROR)
    @SchedulerSupport("none")
    @NonNull
    @CheckReturnValue
    public final <U> Flowable<T> sample(@NonNull Publisher<U> publisher, boolean z11) {
        Objects.requireNonNull(publisher, "sampler is null");
        return RxJavaPlugins.onAssembly(new FlowableSamplePublisher(this, publisher, z11));
    }

    @BackpressureSupport(BackpressureKind.FULL)
    @SchedulerSupport("none")
    @NonNull
    @CheckReturnValue
    public static <T> Flowable<T> concat(@NonNull Publisher<? extends T> publisher, @NonNull Publisher<? extends T> publisher2, @NonNull Publisher<? extends T> publisher3, @NonNull Publisher<? extends T> publisher4) {
        Objects.requireNonNull(publisher, "source1 is null");
        Objects.requireNonNull(publisher2, "source2 is null");
        Objects.requireNonNull(publisher3, "source3 is null");
        Objects.requireNonNull(publisher4, "source4 is null");
        return concatArray(publisher, publisher2, publisher3, publisher4);
    }

    @BackpressureSupport(BackpressureKind.FULL)
    @SchedulerSupport("none")
    @NonNull
    @CheckReturnValue
    public static <T, S> Flowable<T> generate(@NonNull Supplier<S> supplier, @NonNull BiFunction<S, Emitter<T>, S> biFunction) {
        return generate(supplier, biFunction, Functions.emptyConsumer());
    }

    @BackpressureSupport(BackpressureKind.FULL)
    @SchedulerSupport("none")
    @NonNull
    @CheckReturnValue
    public static <T1, T2, R> Flowable<R> zip(@NonNull Publisher<? extends T1> publisher, @NonNull Publisher<? extends T2> publisher2, @NonNull BiFunction<? super T1, ? super T2, ? extends R> biFunction, boolean z11) {
        Objects.requireNonNull(publisher, "source1 is null");
        Objects.requireNonNull(publisher2, "source2 is null");
        Objects.requireNonNull(biFunction, "zipper is null");
        return zipArray(Functions.toFunction(biFunction), z11, bufferSize(), publisher, publisher2);
    }

    @BackpressureSupport(BackpressureKind.FULL)
    @SchedulerSupport("io.reactivex:computation")
    @NonNull
    @CheckReturnValue
    public final Flowable<T> takeLast(long j11, @NonNull TimeUnit timeUnit) {
        return takeLast(j11, timeUnit, Schedulers.computation(), false, bufferSize());
    }

    @BackpressureSupport(BackpressureKind.FULL)
    @SchedulerSupport("none")
    @NonNull
    @CheckReturnValue
    public final <U, V> Flowable<T> timeout(@NonNull Publisher<U> publisher, @NonNull Function<? super T, ? extends Publisher<V>> function, @NonNull Publisher<? extends T> publisher2) {
        Objects.requireNonNull(publisher, "firstTimeoutIndicator is null");
        Objects.requireNonNull(publisher2, "fallback is null");
        return timeout0(publisher, function, publisher2);
    }

    @BackpressureSupport(BackpressureKind.FULL)
    @SchedulerSupport("none")
    @NonNull
    @CheckReturnValue
    public static <T, S> Flowable<T> generate(@NonNull Supplier<S> supplier, @NonNull BiFunction<S, Emitter<T>, S> biFunction, @NonNull Consumer<? super S> consumer) {
        Objects.requireNonNull(supplier, "initialState is null");
        Objects.requireNonNull(biFunction, "generator is null");
        Objects.requireNonNull(consumer, "disposeState is null");
        return RxJavaPlugins.onAssembly(new FlowableGenerate(supplier, biFunction, consumer));
    }

    @BackpressureSupport(BackpressureKind.FULL)
    @SchedulerSupport("none")
    @NonNull
    @CheckReturnValue
    public static <T> Flowable<T> merge(@NonNull Publisher<? extends T> publisher, @NonNull Publisher<? extends T> publisher2, @NonNull Publisher<? extends T> publisher3, @NonNull Publisher<? extends T> publisher4) {
        Objects.requireNonNull(publisher, "source1 is null");
        Objects.requireNonNull(publisher2, "source2 is null");
        Objects.requireNonNull(publisher3, "source3 is null");
        Objects.requireNonNull(publisher4, "source4 is null");
        return fromArray(publisher, publisher2, publisher3, publisher4).flatMap(Functions.identity(), false, 4);
    }

    @BackpressureSupport(BackpressureKind.FULL)
    @SchedulerSupport("none")
    @NonNull
    @CheckReturnValue
    public static <T> Flowable<T> mergeDelayError(@NonNull Publisher<? extends T> publisher, @NonNull Publisher<? extends T> publisher2, @NonNull Publisher<? extends T> publisher3, @NonNull Publisher<? extends T> publisher4) {
        Objects.requireNonNull(publisher, "source1 is null");
        Objects.requireNonNull(publisher2, "source2 is null");
        Objects.requireNonNull(publisher3, "source3 is null");
        Objects.requireNonNull(publisher4, "source4 is null");
        return fromArray(publisher, publisher2, publisher3, publisher4).flatMap(Functions.identity(), true, 4);
    }

    @BackpressureSupport(BackpressureKind.FULL)
    @SchedulerSupport("none")
    @NonNull
    @CheckReturnValue
    public final <R> Flowable<R> flatMap(@NonNull Function<? super T, ? extends Publisher<? extends R>> function, @NonNull Function<? super Throwable, ? extends Publisher<? extends R>> function2, @NonNull Supplier<? extends Publisher<? extends R>> supplier) {
        Objects.requireNonNull(function, "onNextMapper is null");
        Objects.requireNonNull(function2, "onErrorMapper is null");
        Objects.requireNonNull(supplier, "onCompleteSupplier is null");
        return merge(new FlowableMapNotification(this, function, function2, supplier));
    }

    @BackpressureSupport(BackpressureKind.FULL)
    @SchedulerSupport("io.reactivex:computation")
    @NonNull
    @CheckReturnValue
    public final Flowable<T> takeLast(long j11, @NonNull TimeUnit timeUnit, boolean z11) {
        return takeLast(j11, timeUnit, Schedulers.computation(), z11, bufferSize());
    }

    @BackpressureSupport(BackpressureKind.UNBOUNDED_IN)
    @SchedulerSupport("none")
    @NonNull
    @CheckReturnValue
    public final <K, V> Single<Map<K, Collection<V>>> toMultimap(@NonNull Function<? super T, ? extends K> function, @NonNull Function<? super T, ? extends V> function2, @NonNull Supplier<Map<K, Collection<V>>> supplier) {
        return toMultimap(function, function2, supplier, ArrayListSupplier.asFunction());
    }

    @BackpressureSupport(BackpressureKind.ERROR)
    @SchedulerSupport("io.reactivex:computation")
    @NonNull
    @CheckReturnValue
    public final Flowable<List<T>> buffer(long j11, @NonNull TimeUnit timeUnit) {
        return buffer(j11, timeUnit, Schedulers.computation(), Integer.MAX_VALUE);
    }

    @BackpressureSupport(BackpressureKind.FULL)
    @SchedulerSupport("custom")
    @NonNull
    @CheckReturnValue
    public final Flowable<T> takeLast(long j11, @NonNull TimeUnit timeUnit, @NonNull Scheduler scheduler) {
        return takeLast(j11, timeUnit, scheduler, false, bufferSize());
    }

    @BackpressureSupport(BackpressureKind.FULL)
    @SchedulerSupport("none")
    @NonNull
    @CheckReturnValue
    public static <T1, T2, T3, T4, R> Flowable<R> combineLatest(@NonNull Publisher<? extends T1> publisher, @NonNull Publisher<? extends T2> publisher2, @NonNull Publisher<? extends T3> publisher3, @NonNull Publisher<? extends T4> publisher4, @NonNull Function4<? super T1, ? super T2, ? super T3, ? super T4, ? extends R> function4) {
        Objects.requireNonNull(publisher, "source1 is null");
        Objects.requireNonNull(publisher2, "source2 is null");
        Objects.requireNonNull(publisher3, "source3 is null");
        Objects.requireNonNull(publisher4, "source4 is null");
        Objects.requireNonNull(function4, "combiner is null");
        return combineLatestArray(new Publisher[]{publisher, publisher2, publisher3, publisher4}, Functions.toFunction(function4), bufferSize());
    }

    @BackpressureSupport(BackpressureKind.FULL)
    @SchedulerSupport("none")
    @NonNull
    @CheckReturnValue
    public static <T> Flowable<T> just(T t11, T t12, T t13, T t14, T t15) {
        Objects.requireNonNull(t11, "item1 is null");
        Objects.requireNonNull(t12, "item2 is null");
        Objects.requireNonNull(t13, "item3 is null");
        Objects.requireNonNull(t14, "item4 is null");
        Objects.requireNonNull(t15, "item5 is null");
        return fromArray(t11, t12, t13, t14, t15);
    }

    @BackpressureSupport(BackpressureKind.ERROR)
    @SchedulerSupport("io.reactivex:computation")
    @NonNull
    @CheckReturnValue
    public final Flowable<List<T>> buffer(long j11, @NonNull TimeUnit timeUnit, int i11) {
        return buffer(j11, timeUnit, Schedulers.computation(), i11);
    }

    @BackpressureSupport(BackpressureKind.FULL)
    @SchedulerSupport("custom")
    @NonNull
    @CheckReturnValue
    public final Flowable<T> takeLast(long j11, @NonNull TimeUnit timeUnit, @NonNull Scheduler scheduler, boolean z11) {
        return takeLast(j11, timeUnit, scheduler, z11, bufferSize());
    }

    @BackpressureSupport(BackpressureKind.ERROR)
    @SchedulerSupport("io.reactivex:computation")
    @NonNull
    @CheckReturnValue
    public final Flowable<Flowable<T>> window(long j11, @NonNull TimeUnit timeUnit) {
        return window(j11, timeUnit, Schedulers.computation(), Long.MAX_VALUE, false);
    }

    @BackpressureSupport(BackpressureKind.PASS_THROUGH)
    @SchedulerSupport("none")
    @NonNull
    @CheckReturnValue
    public final <T1, T2, T3, T4, R> Flowable<R> withLatestFrom(@NonNull Publisher<T1> publisher, @NonNull Publisher<T2> publisher2, @NonNull Publisher<T3> publisher3, @NonNull Publisher<T4> publisher4, @NonNull Function5<? super T, ? super T1, ? super T2, ? super T3, ? super T4, R> function5) {
        Objects.requireNonNull(publisher, "source1 is null");
        Objects.requireNonNull(publisher2, "source2 is null");
        Objects.requireNonNull(publisher3, "source3 is null");
        Objects.requireNonNull(publisher4, "source4 is null");
        Objects.requireNonNull(function5, "combiner is null");
        return withLatestFrom((Publisher<?>[]) new Publisher[]{publisher, publisher2, publisher3, publisher4}, Functions.toFunction(function5));
    }

    @BackpressureSupport(BackpressureKind.FULL)
    @SchedulerSupport("none")
    @NonNull
    @CheckReturnValue
    public static <T1, T2, R> Flowable<R> zip(@NonNull Publisher<? extends T1> publisher, @NonNull Publisher<? extends T2> publisher2, @NonNull BiFunction<? super T1, ? super T2, ? extends R> biFunction, boolean z11, int i11) {
        Objects.requireNonNull(publisher, "source1 is null");
        Objects.requireNonNull(publisher2, "source2 is null");
        Objects.requireNonNull(biFunction, "zipper is null");
        return zipArray(Functions.toFunction(biFunction), z11, i11, publisher, publisher2);
    }

    @BackpressureSupport(BackpressureKind.ERROR)
    @SchedulerSupport("custom")
    @NonNull
    @CheckReturnValue
    public final Flowable<List<T>> buffer(long j11, @NonNull TimeUnit timeUnit, @NonNull Scheduler scheduler, int i11) {
        return buffer(j11, timeUnit, scheduler, i11, ArrayListSupplier.asSupplier(), false);
    }

    @BackpressureSupport(BackpressureKind.SPECIAL)
    @SchedulerSupport("none")
    public final void subscribe(@NonNull Subscriber<? super T> subscriber) {
        if (subscriber instanceof FlowableSubscriber) {
            subscribe((FlowableSubscriber) subscriber);
            return;
        }
        Objects.requireNonNull(subscriber, "subscriber is null");
        subscribe(new StrictSubscriber(subscriber));
    }

    @BackpressureSupport(BackpressureKind.FULL)
    @SchedulerSupport("custom")
    @NonNull
    @CheckReturnValue
    public final Flowable<T> takeLast(long j11, @NonNull TimeUnit timeUnit, @NonNull Scheduler scheduler, boolean z11, int i11) {
        return takeLast(Long.MAX_VALUE, j11, timeUnit, scheduler, z11, i11);
    }

    @BackpressureSupport(BackpressureKind.ERROR)
    @SchedulerSupport("io.reactivex:computation")
    @NonNull
    @CheckReturnValue
    public final Flowable<Flowable<T>> window(long j11, @NonNull TimeUnit timeUnit, long j12) {
        return window(j11, timeUnit, Schedulers.computation(), j12, false);
    }

    @BackpressureSupport(BackpressureKind.ERROR)
    @SchedulerSupport("custom")
    @NonNull
    @CheckReturnValue
    public final <U extends Collection<? super T>> Flowable<U> buffer(long j11, @NonNull TimeUnit timeUnit, @NonNull Scheduler scheduler, int i11, @NonNull Supplier<U> supplier, boolean z11) {
        Objects.requireNonNull(timeUnit, "unit is null");
        Scheduler scheduler2 = scheduler;
        Objects.requireNonNull(scheduler2, "scheduler is null");
        Supplier<U> supplier2 = supplier;
        Objects.requireNonNull(supplier2, "bufferSupplier is null");
        int i12 = i11;
        ObjectHelper.verifyPositive(i12, "count");
        return RxJavaPlugins.onAssembly(new FlowableBufferTimed(this, j11, j11, timeUnit, scheduler2, supplier2, i12, z11));
    }

    @BackpressureSupport(BackpressureKind.FULL)
    @SchedulerSupport("none")
    @NonNull
    @CheckReturnValue
    public final <R> Flowable<R> flatMap(@NonNull Function<? super T, ? extends Publisher<? extends R>> function, @NonNull Function<Throwable, ? extends Publisher<? extends R>> function2, @NonNull Supplier<? extends Publisher<? extends R>> supplier, int i11) {
        Objects.requireNonNull(function, "onNextMapper is null");
        Objects.requireNonNull(function2, "onErrorMapper is null");
        Objects.requireNonNull(supplier, "onCompleteSupplier is null");
        return merge(new FlowableMapNotification(this, function, function2, supplier), i11);
    }

    @BackpressureSupport(BackpressureKind.FULL)
    @SchedulerSupport("custom")
    @NonNull
    @CheckReturnValue
    public final <R> Flowable<R> replay(@NonNull Function<? super Flowable<T>, ? extends Publisher<R>> function, int i11, long j11, @NonNull TimeUnit timeUnit, @NonNull Scheduler scheduler, boolean z11) {
        Objects.requireNonNull(function, "selector is null");
        Objects.requireNonNull(timeUnit, "unit is null");
        ObjectHelper.verifyPositive(i11, "bufferSize");
        Objects.requireNonNull(scheduler, "scheduler is null");
        return FlowableReplay.multicastSelector(FlowableInternalHelper.replaySupplier(this, i11, j11, timeUnit, scheduler, z11), function);
    }

    @BackpressureSupport(BackpressureKind.ERROR)
    @SchedulerSupport("io.reactivex:computation")
    @NonNull
    @CheckReturnValue
    public final Flowable<Flowable<T>> window(long j11, @NonNull TimeUnit timeUnit, long j12, boolean z11) {
        return window(j11, timeUnit, Schedulers.computation(), j12, z11);
    }

    @BackpressureSupport(BackpressureKind.ERROR)
    @SchedulerSupport("custom")
    @NonNull
    @CheckReturnValue
    public final Flowable<Flowable<T>> window(long j11, @NonNull TimeUnit timeUnit, @NonNull Scheduler scheduler) {
        return window(j11, timeUnit, scheduler, Long.MAX_VALUE, false);
    }

    @BackpressureSupport(BackpressureKind.ERROR)
    @SchedulerSupport("custom")
    @NonNull
    @CheckReturnValue
    public final Flowable<Flowable<T>> window(long j11, @NonNull TimeUnit timeUnit, @NonNull Scheduler scheduler, long j12) {
        return window(j11, timeUnit, scheduler, j12, false);
    }

    @BackpressureSupport(BackpressureKind.FULL)
    @SchedulerSupport("none")
    @NonNull
    @CheckReturnValue
    public static <T1, T2, T3, R> Flowable<R> zip(@NonNull Publisher<? extends T1> publisher, @NonNull Publisher<? extends T2> publisher2, @NonNull Publisher<? extends T3> publisher3, @NonNull Function3<? super T1, ? super T2, ? super T3, ? extends R> function3) {
        Objects.requireNonNull(publisher, "source1 is null");
        Objects.requireNonNull(publisher2, "source2 is null");
        Objects.requireNonNull(publisher3, "source3 is null");
        Objects.requireNonNull(function3, "zipper is null");
        return zipArray(Functions.toFunction(function3), false, bufferSize(), publisher, publisher2, publisher3);
    }

    @BackpressureSupport(BackpressureKind.SPECIAL)
    @SchedulerSupport("none")
    public final void subscribe(@NonNull FlowableSubscriber<? super T> flowableSubscriber) {
        Objects.requireNonNull(flowableSubscriber, "subscriber is null");
        try {
            Subscriber<? super Object> onSubscribe = RxJavaPlugins.onSubscribe(this, flowableSubscriber);
            Objects.requireNonNull(onSubscribe, "The RxJavaPlugins.onSubscribe hook returned a null FlowableSubscriber. Please check the handler provided to RxJavaPlugins.setOnFlowableSubscribe for invalid null returns. Further reading: https://github.com/ReactiveX/RxJava/wiki/Plugins");
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

    @BackpressureSupport(BackpressureKind.ERROR)
    @SchedulerSupport("custom")
    @NonNull
    @CheckReturnValue
    public final Flowable<Flowable<T>> window(long j11, @NonNull TimeUnit timeUnit, @NonNull Scheduler scheduler, long j12, boolean z11) {
        return window(j11, timeUnit, scheduler, j12, z11, bufferSize());
    }

    @BackpressureSupport(BackpressureKind.FULL)
    @SchedulerSupport("none")
    @NonNull
    @CheckReturnValue
    public static <T1, T2, T3, T4, T5, R> Flowable<R> combineLatest(@NonNull Publisher<? extends T1> publisher, @NonNull Publisher<? extends T2> publisher2, @NonNull Publisher<? extends T3> publisher3, @NonNull Publisher<? extends T4> publisher4, @NonNull Publisher<? extends T5> publisher5, @NonNull Function5<? super T1, ? super T2, ? super T3, ? super T4, ? super T5, ? extends R> function5) {
        Objects.requireNonNull(publisher, "source1 is null");
        Objects.requireNonNull(publisher2, "source2 is null");
        Objects.requireNonNull(publisher3, "source3 is null");
        Objects.requireNonNull(publisher4, "source4 is null");
        Objects.requireNonNull(publisher5, "source5 is null");
        Objects.requireNonNull(function5, "combiner is null");
        return combineLatestArray(new Publisher[]{publisher, publisher2, publisher3, publisher4, publisher5}, Functions.toFunction(function5), bufferSize());
    }

    @BackpressureSupport(BackpressureKind.FULL)
    @SchedulerSupport("none")
    @NonNull
    @CheckReturnValue
    public static <T> Flowable<T> just(T t11, T t12, T t13, T t14, T t15, T t16) {
        Objects.requireNonNull(t11, "item1 is null");
        Objects.requireNonNull(t12, "item2 is null");
        Objects.requireNonNull(t13, "item3 is null");
        Objects.requireNonNull(t14, "item4 is null");
        Objects.requireNonNull(t15, "item5 is null");
        Objects.requireNonNull(t16, "item6 is null");
        return fromArray(t11, t12, t13, t14, t15, t16);
    }

    @BackpressureSupport(BackpressureKind.FULL)
    @SchedulerSupport("none")
    @NonNull
    @CheckReturnValue
    public final <U, R> Flowable<R> flatMap(@NonNull Function<? super T, ? extends Publisher<? extends U>> function, @NonNull BiFunction<? super T, ? super U, ? extends R> biFunction) {
        return flatMap(function, biFunction, false, bufferSize(), bufferSize());
    }

    @BackpressureSupport(BackpressureKind.ERROR)
    @SchedulerSupport("custom")
    @NonNull
    @CheckReturnValue
    public final Flowable<Flowable<T>> window(long j11, @NonNull TimeUnit timeUnit, @NonNull Scheduler scheduler, long j12, boolean z11, int i11) {
        int i12 = i11;
        ObjectHelper.verifyPositive(i12, "bufferSize");
        Scheduler scheduler2 = scheduler;
        Objects.requireNonNull(scheduler2, "scheduler is null");
        TimeUnit timeUnit2 = timeUnit;
        Objects.requireNonNull(timeUnit2, "unit is null");
        long j13 = j12;
        ObjectHelper.verifyPositive(j13, "count");
        return RxJavaPlugins.onAssembly(new FlowableWindowTimed(this, j11, j11, timeUnit2, scheduler2, j13, i12, z11));
    }

    @BackpressureSupport(BackpressureKind.ERROR)
    @SchedulerSupport("custom")
    @NonNull
    @CheckReturnValue
    public final Flowable<List<T>> buffer(long j11, @NonNull TimeUnit timeUnit, @NonNull Scheduler scheduler) {
        return buffer(j11, timeUnit, scheduler, Integer.MAX_VALUE, ArrayListSupplier.asSupplier(), false);
    }

    @BackpressureSupport(BackpressureKind.FULL)
    @SchedulerSupport("none")
    @NonNull
    @CheckReturnValue
    public final <U, R> Flowable<R> flatMap(@NonNull Function<? super T, ? extends Publisher<? extends U>> function, @NonNull BiFunction<? super T, ? super U, ? extends R> biFunction, boolean z11) {
        return flatMap(function, biFunction, z11, bufferSize(), bufferSize());
    }

    @BackpressureSupport(BackpressureKind.PASS_THROUGH)
    @SchedulerSupport("none")
    @NonNull
    @CheckReturnValue
    public final <R> Flowable<R> withLatestFrom(@NonNull Publisher<?>[] publisherArr, @NonNull Function<? super Object[], R> function) {
        Objects.requireNonNull(publisherArr, "others is null");
        Objects.requireNonNull(function, "combiner is null");
        return RxJavaPlugins.onAssembly(new FlowableWithLatestFromMany(this, publisherArr, function));
    }

    @BackpressureSupport(BackpressureKind.ERROR)
    @SchedulerSupport("none")
    @NonNull
    @CheckReturnValue
    public final <TOpening, TClosing> Flowable<List<T>> buffer(@NonNull Publisher<? extends TOpening> publisher, @NonNull Function<? super TOpening, ? extends Publisher<? extends TClosing>> function) {
        return buffer(publisher, function, ArrayListSupplier.asSupplier());
    }

    @BackpressureSupport(BackpressureKind.FULL)
    @SchedulerSupport("none")
    @NonNull
    @CheckReturnValue
    public final <U, R> Flowable<R> flatMap(@NonNull Function<? super T, ? extends Publisher<? extends U>> function, @NonNull BiFunction<? super T, ? super U, ? extends R> biFunction, boolean z11, int i11) {
        return flatMap(function, biFunction, z11, i11, bufferSize());
    }

    @BackpressureSupport(BackpressureKind.FULL)
    @SchedulerSupport("io.reactivex:computation")
    @NonNull
    @CheckReturnValue
    public final <R> Flowable<R> replay(@NonNull Function<? super Flowable<T>, ? extends Publisher<R>> function, long j11, @NonNull TimeUnit timeUnit) {
        return replay(function, j11, timeUnit, Schedulers.computation());
    }

    @BackpressureSupport(BackpressureKind.ERROR)
    @SchedulerSupport("none")
    @NonNull
    @CheckReturnValue
    public final <TOpening, TClosing, U extends Collection<? super T>> Flowable<U> buffer(@NonNull Publisher<? extends TOpening> publisher, @NonNull Function<? super TOpening, ? extends Publisher<? extends TClosing>> function, @NonNull Supplier<U> supplier) {
        Objects.requireNonNull(publisher, "openingIndicator is null");
        Objects.requireNonNull(function, "closingIndicator is null");
        Objects.requireNonNull(supplier, "bufferSupplier is null");
        return RxJavaPlugins.onAssembly(new FlowableBufferBoundary(this, publisher, function, supplier));
    }

    @BackpressureSupport(BackpressureKind.FULL)
    @SchedulerSupport("none")
    @NonNull
    @CheckReturnValue
    public final <U, R> Flowable<R> flatMap(@NonNull Function<? super T, ? extends Publisher<? extends U>> function, @NonNull BiFunction<? super T, ? super U, ? extends R> biFunction, boolean z11, int i11, int i12) {
        Objects.requireNonNull(function, "mapper is null");
        Objects.requireNonNull(biFunction, "combiner is null");
        ObjectHelper.verifyPositive(i11, "maxConcurrency");
        ObjectHelper.verifyPositive(i12, "bufferSize");
        return flatMap(FlowableInternalHelper.flatMapWithCombiner(function, biFunction), z11, i11, i12);
    }

    @BackpressureSupport(BackpressureKind.FULL)
    @SchedulerSupport("custom")
    @NonNull
    @CheckReturnValue
    public final <R> Flowable<R> replay(@NonNull Function<? super Flowable<T>, ? extends Publisher<R>> function, long j11, @NonNull TimeUnit timeUnit, @NonNull Scheduler scheduler) {
        Objects.requireNonNull(function, "selector is null");
        Objects.requireNonNull(timeUnit, "unit is null");
        Objects.requireNonNull(scheduler, "scheduler is null");
        return FlowableReplay.multicastSelector(FlowableInternalHelper.replaySupplier(this, j11, timeUnit, scheduler, false), function);
    }

    @BackpressureSupport(BackpressureKind.FULL)
    @SchedulerSupport("none")
    @NonNull
    @CheckReturnValue
    public static <T1, T2, T3, T4, R> Flowable<R> zip(@NonNull Publisher<? extends T1> publisher, @NonNull Publisher<? extends T2> publisher2, @NonNull Publisher<? extends T3> publisher3, @NonNull Publisher<? extends T4> publisher4, @NonNull Function4<? super T1, ? super T2, ? super T3, ? super T4, ? extends R> function4) {
        Objects.requireNonNull(publisher, "source1 is null");
        Objects.requireNonNull(publisher2, "source2 is null");
        Objects.requireNonNull(publisher3, "source3 is null");
        Objects.requireNonNull(publisher4, "source4 is null");
        Objects.requireNonNull(function4, "zipper is null");
        return zipArray(Functions.toFunction(function4), false, bufferSize(), publisher, publisher2, publisher3, publisher4);
    }

    @BackpressureSupport(BackpressureKind.PASS_THROUGH)
    @SchedulerSupport("none")
    @NonNull
    @CheckReturnValue
    public final <R> Flowable<R> withLatestFrom(@NonNull Iterable<? extends Publisher<?>> iterable, @NonNull Function<? super Object[], R> function) {
        Objects.requireNonNull(iterable, "others is null");
        Objects.requireNonNull(function, "combiner is null");
        return RxJavaPlugins.onAssembly(new FlowableWithLatestFromMany(this, iterable, function));
    }

    @BackpressureSupport(BackpressureKind.ERROR)
    @SchedulerSupport("none")
    @NonNull
    @CheckReturnValue
    public final <B> Flowable<Flowable<T>> window(@NonNull Publisher<B> publisher) {
        return window(publisher, bufferSize());
    }

    @BackpressureSupport(BackpressureKind.ERROR)
    @SchedulerSupport("none")
    @NonNull
    @CheckReturnValue
    public final <B> Flowable<Flowable<T>> window(@NonNull Publisher<B> publisher, int i11) {
        Objects.requireNonNull(publisher, "boundaryIndicator is null");
        ObjectHelper.verifyPositive(i11, "bufferSize");
        return RxJavaPlugins.onAssembly(new FlowableWindowBoundary(this, publisher, i11));
    }

    @BackpressureSupport(BackpressureKind.FULL)
    @SchedulerSupport("none")
    @NonNull
    @CheckReturnValue
    public static <T1, T2, T3, T4, T5, T6, R> Flowable<R> combineLatest(@NonNull Publisher<? extends T1> publisher, @NonNull Publisher<? extends T2> publisher2, @NonNull Publisher<? extends T3> publisher3, @NonNull Publisher<? extends T4> publisher4, @NonNull Publisher<? extends T5> publisher5, @NonNull Publisher<? extends T6> publisher6, @NonNull Function6<? super T1, ? super T2, ? super T3, ? super T4, ? super T5, ? super T6, ? extends R> function6) {
        Objects.requireNonNull(publisher, "source1 is null");
        Objects.requireNonNull(publisher2, "source2 is null");
        Objects.requireNonNull(publisher3, "source3 is null");
        Objects.requireNonNull(publisher4, "source4 is null");
        Objects.requireNonNull(publisher5, "source5 is null");
        Objects.requireNonNull(publisher6, "source6 is null");
        Objects.requireNonNull(function6, "combiner is null");
        return combineLatestArray(new Publisher[]{publisher, publisher2, publisher3, publisher4, publisher5, publisher6}, Functions.toFunction(function6), bufferSize());
    }

    @BackpressureSupport(BackpressureKind.FULL)
    @SchedulerSupport("none")
    @NonNull
    @CheckReturnValue
    public static <T> Flowable<T> just(T t11, T t12, T t13, T t14, T t15, T t16, T t17) {
        Objects.requireNonNull(t11, "item1 is null");
        Objects.requireNonNull(t12, "item2 is null");
        Objects.requireNonNull(t13, "item3 is null");
        Objects.requireNonNull(t14, "item4 is null");
        Objects.requireNonNull(t15, "item5 is null");
        Objects.requireNonNull(t16, "item6 is null");
        Objects.requireNonNull(t17, "item7 is null");
        return fromArray(t11, t12, t13, t14, t15, t16, t17);
    }

    @BackpressureSupport(BackpressureKind.ERROR)
    @SchedulerSupport("none")
    @NonNull
    @CheckReturnValue
    public final <B> Flowable<List<T>> buffer(@NonNull Publisher<B> publisher) {
        return buffer(publisher, ArrayListSupplier.asSupplier());
    }

    @BackpressureSupport(BackpressureKind.FULL)
    @SchedulerSupport("custom")
    @NonNull
    @CheckReturnValue
    public final <R> Flowable<R> replay(@NonNull Function<? super Flowable<T>, ? extends Publisher<R>> function, long j11, @NonNull TimeUnit timeUnit, @NonNull Scheduler scheduler, boolean z11) {
        Objects.requireNonNull(function, "selector is null");
        Objects.requireNonNull(timeUnit, "unit is null");
        Objects.requireNonNull(scheduler, "scheduler is null");
        return FlowableReplay.multicastSelector(FlowableInternalHelper.replaySupplier(this, j11, timeUnit, scheduler, z11), function);
    }

    @BackpressureSupport(BackpressureKind.ERROR)
    @SchedulerSupport("none")
    @NonNull
    @CheckReturnValue
    public final <B> Flowable<List<T>> buffer(@NonNull Publisher<B> publisher, int i11) {
        ObjectHelper.verifyPositive(i11, "initialCapacity");
        return buffer(publisher, Functions.createArrayList(i11));
    }

    @BackpressureSupport(BackpressureKind.FULL)
    @SchedulerSupport("none")
    @NonNull
    @CheckReturnValue
    public final <U, R> Flowable<R> flatMap(@NonNull Function<? super T, ? extends Publisher<? extends U>> function, @NonNull BiFunction<? super T, ? super U, ? extends R> biFunction, int i11) {
        return flatMap(function, biFunction, false, i11, bufferSize());
    }

    @BackpressureSupport(BackpressureKind.ERROR)
    @SchedulerSupport("none")
    @NonNull
    @CheckReturnValue
    public final <U, V> Flowable<Flowable<T>> window(@NonNull Publisher<U> publisher, @NonNull Function<? super U, ? extends Publisher<V>> function) {
        return window(publisher, function, bufferSize());
    }

    @BackpressureSupport(BackpressureKind.FULL)
    @SchedulerSupport("none")
    @NonNull
    @CheckReturnValue
    public static <T1, T2, T3, T4, T5, R> Flowable<R> zip(@NonNull Publisher<? extends T1> publisher, @NonNull Publisher<? extends T2> publisher2, @NonNull Publisher<? extends T3> publisher3, @NonNull Publisher<? extends T4> publisher4, @NonNull Publisher<? extends T5> publisher5, @NonNull Function5<? super T1, ? super T2, ? super T3, ? super T4, ? super T5, ? extends R> function5) {
        Objects.requireNonNull(publisher, "source1 is null");
        Objects.requireNonNull(publisher2, "source2 is null");
        Objects.requireNonNull(publisher3, "source3 is null");
        Objects.requireNonNull(publisher4, "source4 is null");
        Objects.requireNonNull(publisher5, "source5 is null");
        Objects.requireNonNull(function5, "zipper is null");
        return zipArray(Functions.toFunction(function5), false, bufferSize(), publisher, publisher2, publisher3, publisher4, publisher5);
    }

    @BackpressureSupport(BackpressureKind.ERROR)
    @SchedulerSupport("none")
    @NonNull
    @CheckReturnValue
    public final <B, U extends Collection<? super T>> Flowable<U> buffer(@NonNull Publisher<B> publisher, @NonNull Supplier<U> supplier) {
        Objects.requireNonNull(publisher, "boundaryIndicator is null");
        Objects.requireNonNull(supplier, "bufferSupplier is null");
        return RxJavaPlugins.onAssembly(new FlowableBufferExactBoundary(this, publisher, supplier));
    }

    @BackpressureSupport(BackpressureKind.ERROR)
    @SchedulerSupport("none")
    @NonNull
    @CheckReturnValue
    public final <U, V> Flowable<Flowable<T>> window(@NonNull Publisher<U> publisher, @NonNull Function<? super U, ? extends Publisher<V>> function, int i11) {
        Objects.requireNonNull(publisher, "openingIndicator is null");
        Objects.requireNonNull(function, "closingIndicator is null");
        ObjectHelper.verifyPositive(i11, "bufferSize");
        return RxJavaPlugins.onAssembly(new FlowableWindowBoundarySelector(this, publisher, function, i11));
    }

    @BackpressureSupport(BackpressureKind.FULL)
    @SchedulerSupport("none")
    @NonNull
    @CheckReturnValue
    public final ConnectableFlowable<T> replay(int i11) {
        ObjectHelper.verifyPositive(i11, "bufferSize");
        return FlowableReplay.create(this, i11, false);
    }

    @BackpressureSupport(BackpressureKind.FULL)
    @SchedulerSupport("none")
    @NonNull
    @CheckReturnValue
    public final ConnectableFlowable<T> replay(int i11, boolean z11) {
        ObjectHelper.verifyPositive(i11, "bufferSize");
        return FlowableReplay.create(this, i11, z11);
    }

    @BackpressureSupport(BackpressureKind.FULL)
    @SchedulerSupport("none")
    @NonNull
    @CheckReturnValue
    public static <T1, T2, T3, T4, T5, T6, T7, R> Flowable<R> combineLatest(@NonNull Publisher<? extends T1> publisher, @NonNull Publisher<? extends T2> publisher2, @NonNull Publisher<? extends T3> publisher3, @NonNull Publisher<? extends T4> publisher4, @NonNull Publisher<? extends T5> publisher5, @NonNull Publisher<? extends T6> publisher6, @NonNull Publisher<? extends T7> publisher7, @NonNull Function7<? super T1, ? super T2, ? super T3, ? super T4, ? super T5, ? super T6, ? super T7, ? extends R> function7) {
        Objects.requireNonNull(publisher, "source1 is null");
        Objects.requireNonNull(publisher2, "source2 is null");
        Objects.requireNonNull(publisher3, "source3 is null");
        Objects.requireNonNull(publisher4, "source4 is null");
        Objects.requireNonNull(publisher5, "source5 is null");
        Objects.requireNonNull(publisher6, "source6 is null");
        Objects.requireNonNull(publisher7, "source7 is null");
        Objects.requireNonNull(function7, "combiner is null");
        return combineLatestArray(new Publisher[]{publisher, publisher2, publisher3, publisher4, publisher5, publisher6, publisher7}, Functions.toFunction(function7), bufferSize());
    }

    @BackpressureSupport(BackpressureKind.FULL)
    @SchedulerSupport("none")
    @NonNull
    @CheckReturnValue
    public static <T> Flowable<T> just(T t11, T t12, T t13, T t14, T t15, T t16, T t17, T t18) {
        Objects.requireNonNull(t11, "item1 is null");
        Objects.requireNonNull(t12, "item2 is null");
        Objects.requireNonNull(t13, "item3 is null");
        Objects.requireNonNull(t14, "item4 is null");
        Objects.requireNonNull(t15, "item5 is null");
        Objects.requireNonNull(t16, "item6 is null");
        Objects.requireNonNull(t17, "item7 is null");
        Objects.requireNonNull(t18, "item8 is null");
        return fromArray(t11, t12, t13, t14, t15, t16, t17, t18);
    }

    @BackpressureSupport(BackpressureKind.FULL)
    @SchedulerSupport("io.reactivex:computation")
    @NonNull
    @CheckReturnValue
    public final ConnectableFlowable<T> replay(int i11, long j11, @NonNull TimeUnit timeUnit) {
        return replay(i11, j11, timeUnit, Schedulers.computation());
    }

    @BackpressureSupport(BackpressureKind.FULL)
    @SchedulerSupport("custom")
    @NonNull
    @CheckReturnValue
    public final ConnectableFlowable<T> replay(int i11, long j11, @NonNull TimeUnit timeUnit, @NonNull Scheduler scheduler) {
        Objects.requireNonNull(timeUnit, "unit is null");
        Objects.requireNonNull(scheduler, "scheduler is null");
        ObjectHelper.verifyPositive(i11, "bufferSize");
        return FlowableReplay.create(this, j11, timeUnit, scheduler, i11, false);
    }

    @BackpressureSupport(BackpressureKind.FULL)
    @SchedulerSupport("none")
    @NonNull
    @CheckReturnValue
    public static <T1, T2, T3, T4, T5, T6, R> Flowable<R> zip(@NonNull Publisher<? extends T1> publisher, @NonNull Publisher<? extends T2> publisher2, @NonNull Publisher<? extends T3> publisher3, @NonNull Publisher<? extends T4> publisher4, @NonNull Publisher<? extends T5> publisher5, @NonNull Publisher<? extends T6> publisher6, @NonNull Function6<? super T1, ? super T2, ? super T3, ? super T4, ? super T5, ? super T6, ? extends R> function6) {
        Objects.requireNonNull(publisher, "source1 is null");
        Objects.requireNonNull(publisher2, "source2 is null");
        Objects.requireNonNull(publisher3, "source3 is null");
        Objects.requireNonNull(publisher4, "source4 is null");
        Objects.requireNonNull(publisher5, "source5 is null");
        Objects.requireNonNull(publisher6, "source6 is null");
        Objects.requireNonNull(function6, "zipper is null");
        return zipArray(Functions.toFunction(function6), false, bufferSize(), publisher, publisher2, publisher3, publisher4, publisher5, publisher6);
    }

    @BackpressureSupport(BackpressureKind.FULL)
    @SchedulerSupport("custom")
    @NonNull
    @CheckReturnValue
    public final ConnectableFlowable<T> replay(int i11, long j11, @NonNull TimeUnit timeUnit, @NonNull Scheduler scheduler, boolean z11) {
        Objects.requireNonNull(timeUnit, "unit is null");
        Objects.requireNonNull(scheduler, "scheduler is null");
        ObjectHelper.verifyPositive(i11, "bufferSize");
        return FlowableReplay.create(this, j11, timeUnit, scheduler, i11, z11);
    }

    @BackpressureSupport(BackpressureKind.FULL)
    @SchedulerSupport("none")
    @NonNull
    @CheckReturnValue
    public static <T1, T2, T3, T4, T5, T6, T7, T8, R> Flowable<R> combineLatest(@NonNull Publisher<? extends T1> publisher, @NonNull Publisher<? extends T2> publisher2, @NonNull Publisher<? extends T3> publisher3, @NonNull Publisher<? extends T4> publisher4, @NonNull Publisher<? extends T5> publisher5, @NonNull Publisher<? extends T6> publisher6, @NonNull Publisher<? extends T7> publisher7, @NonNull Publisher<? extends T8> publisher8, @NonNull Function8<? super T1, ? super T2, ? super T3, ? super T4, ? super T5, ? super T6, ? super T7, ? super T8, ? extends R> function8) {
        Objects.requireNonNull(publisher, "source1 is null");
        Objects.requireNonNull(publisher2, "source2 is null");
        Objects.requireNonNull(publisher3, "source3 is null");
        Objects.requireNonNull(publisher4, "source4 is null");
        Objects.requireNonNull(publisher5, "source5 is null");
        Objects.requireNonNull(publisher6, "source6 is null");
        Objects.requireNonNull(publisher7, "source7 is null");
        Objects.requireNonNull(publisher8, "source8 is null");
        Objects.requireNonNull(function8, "combiner is null");
        return combineLatestArray(new Publisher[]{publisher, publisher2, publisher3, publisher4, publisher5, publisher6, publisher7, publisher8}, Functions.toFunction(function8), bufferSize());
    }

    @BackpressureSupport(BackpressureKind.FULL)
    @SchedulerSupport("none")
    @NonNull
    @CheckReturnValue
    public static <T> Flowable<T> just(T t11, T t12, T t13, T t14, T t15, T t16, T t17, T t18, T t19) {
        Objects.requireNonNull(t11, "item1 is null");
        Objects.requireNonNull(t12, "item2 is null");
        Objects.requireNonNull(t13, "item3 is null");
        Objects.requireNonNull(t14, "item4 is null");
        Objects.requireNonNull(t15, "item5 is null");
        Objects.requireNonNull(t16, "item6 is null");
        Objects.requireNonNull(t17, "item7 is null");
        Objects.requireNonNull(t18, "item8 is null");
        Objects.requireNonNull(t19, "item9 is null");
        return fromArray(t11, t12, t13, t14, t15, t16, t17, t18, t19);
    }

    @BackpressureSupport(BackpressureKind.FULL)
    @SchedulerSupport("io.reactivex:computation")
    @NonNull
    @CheckReturnValue
    public final ConnectableFlowable<T> replay(long j11, @NonNull TimeUnit timeUnit) {
        return replay(j11, timeUnit, Schedulers.computation());
    }

    @BackpressureSupport(BackpressureKind.FULL)
    @SchedulerSupport("none")
    @NonNull
    @CheckReturnValue
    public static <T1, T2, T3, T4, T5, T6, T7, R> Flowable<R> zip(@NonNull Publisher<? extends T1> publisher, @NonNull Publisher<? extends T2> publisher2, @NonNull Publisher<? extends T3> publisher3, @NonNull Publisher<? extends T4> publisher4, @NonNull Publisher<? extends T5> publisher5, @NonNull Publisher<? extends T6> publisher6, @NonNull Publisher<? extends T7> publisher7, @NonNull Function7<? super T1, ? super T2, ? super T3, ? super T4, ? super T5, ? super T6, ? super T7, ? extends R> function7) {
        Objects.requireNonNull(publisher, "source1 is null");
        Objects.requireNonNull(publisher2, "source2 is null");
        Objects.requireNonNull(publisher3, "source3 is null");
        Objects.requireNonNull(publisher4, "source4 is null");
        Objects.requireNonNull(publisher5, "source5 is null");
        Objects.requireNonNull(publisher6, "source6 is null");
        Objects.requireNonNull(publisher7, "source7 is null");
        Objects.requireNonNull(function7, "zipper is null");
        return zipArray(Functions.toFunction(function7), false, bufferSize(), publisher, publisher2, publisher3, publisher4, publisher5, publisher6, publisher7);
    }

    @BackpressureSupport(BackpressureKind.FULL)
    @SchedulerSupport("custom")
    @NonNull
    @CheckReturnValue
    public final ConnectableFlowable<T> replay(long j11, @NonNull TimeUnit timeUnit, @NonNull Scheduler scheduler) {
        Objects.requireNonNull(timeUnit, "unit is null");
        Objects.requireNonNull(scheduler, "scheduler is null");
        return FlowableReplay.create(this, j11, timeUnit, scheduler, false);
    }

    @BackpressureSupport(BackpressureKind.FULL)
    @SchedulerSupport("custom")
    @NonNull
    @CheckReturnValue
    public final ConnectableFlowable<T> replay(long j11, @NonNull TimeUnit timeUnit, @NonNull Scheduler scheduler, boolean z11) {
        Objects.requireNonNull(timeUnit, "unit is null");
        Objects.requireNonNull(scheduler, "scheduler is null");
        return FlowableReplay.create(this, j11, timeUnit, scheduler, z11);
    }

    @BackpressureSupport(BackpressureKind.FULL)
    @SchedulerSupport("none")
    @NonNull
    @CheckReturnValue
    public static <T1, T2, T3, T4, T5, T6, T7, T8, T9, R> Flowable<R> combineLatest(@NonNull Publisher<? extends T1> publisher, @NonNull Publisher<? extends T2> publisher2, @NonNull Publisher<? extends T3> publisher3, @NonNull Publisher<? extends T4> publisher4, @NonNull Publisher<? extends T5> publisher5, @NonNull Publisher<? extends T6> publisher6, @NonNull Publisher<? extends T7> publisher7, @NonNull Publisher<? extends T8> publisher8, @NonNull Publisher<? extends T9> publisher9, @NonNull Function9<? super T1, ? super T2, ? super T3, ? super T4, ? super T5, ? super T6, ? super T7, ? super T8, ? super T9, ? extends R> function9) {
        Objects.requireNonNull(publisher, "source1 is null");
        Objects.requireNonNull(publisher2, "source2 is null");
        Objects.requireNonNull(publisher3, "source3 is null");
        Objects.requireNonNull(publisher4, "source4 is null");
        Objects.requireNonNull(publisher5, "source5 is null");
        Objects.requireNonNull(publisher6, "source6 is null");
        Objects.requireNonNull(publisher7, "source7 is null");
        Objects.requireNonNull(publisher8, "source8 is null");
        Objects.requireNonNull(publisher9, "source9 is null");
        Objects.requireNonNull(function9, "combiner is null");
        return combineLatestArray(new Publisher[]{publisher, publisher2, publisher3, publisher4, publisher5, publisher6, publisher7, publisher8, publisher9}, Functions.toFunction(function9), bufferSize());
    }

    @BackpressureSupport(BackpressureKind.FULL)
    @SchedulerSupport("none")
    @NonNull
    @CheckReturnValue
    public static <T> Flowable<T> just(T t11, T t12, T t13, T t14, T t15, T t16, T t17, T t18, T t19, T t21) {
        Objects.requireNonNull(t11, "item1 is null");
        Objects.requireNonNull(t12, "item2 is null");
        Objects.requireNonNull(t13, "item3 is null");
        Objects.requireNonNull(t14, "item4 is null");
        Objects.requireNonNull(t15, "item5 is null");
        Objects.requireNonNull(t16, "item6 is null");
        Objects.requireNonNull(t17, "item7 is null");
        Objects.requireNonNull(t18, "item8 is null");
        Objects.requireNonNull(t19, "item9 is null");
        Objects.requireNonNull(t21, "item10 is null");
        return fromArray(t11, t12, t13, t14, t15, t16, t17, t18, t19, t21);
    }

    @BackpressureSupport(BackpressureKind.FULL)
    @SchedulerSupport("none")
    @NonNull
    @CheckReturnValue
    public static <T1, T2, T3, T4, T5, T6, T7, T8, R> Flowable<R> zip(@NonNull Publisher<? extends T1> publisher, @NonNull Publisher<? extends T2> publisher2, @NonNull Publisher<? extends T3> publisher3, @NonNull Publisher<? extends T4> publisher4, @NonNull Publisher<? extends T5> publisher5, @NonNull Publisher<? extends T6> publisher6, @NonNull Publisher<? extends T7> publisher7, @NonNull Publisher<? extends T8> publisher8, @NonNull Function8<? super T1, ? super T2, ? super T3, ? super T4, ? super T5, ? super T6, ? super T7, ? super T8, ? extends R> function8) {
        Objects.requireNonNull(publisher, "source1 is null");
        Objects.requireNonNull(publisher2, "source2 is null");
        Objects.requireNonNull(publisher3, "source3 is null");
        Objects.requireNonNull(publisher4, "source4 is null");
        Objects.requireNonNull(publisher5, "source5 is null");
        Objects.requireNonNull(publisher6, "source6 is null");
        Objects.requireNonNull(publisher7, "source7 is null");
        Objects.requireNonNull(publisher8, "source8 is null");
        Objects.requireNonNull(function8, "zipper is null");
        return zipArray(Functions.toFunction(function8), false, bufferSize(), publisher, publisher2, publisher3, publisher4, publisher5, publisher6, publisher7, publisher8);
    }

    @BackpressureSupport(BackpressureKind.FULL)
    @SchedulerSupport("none")
    @NonNull
    @CheckReturnValue
    public static <T1, T2, T3, T4, T5, T6, T7, T8, T9, R> Flowable<R> zip(@NonNull Publisher<? extends T1> publisher, @NonNull Publisher<? extends T2> publisher2, @NonNull Publisher<? extends T3> publisher3, @NonNull Publisher<? extends T4> publisher4, @NonNull Publisher<? extends T5> publisher5, @NonNull Publisher<? extends T6> publisher6, @NonNull Publisher<? extends T7> publisher7, @NonNull Publisher<? extends T8> publisher8, @NonNull Publisher<? extends T9> publisher9, @NonNull Function9<? super T1, ? super T2, ? super T3, ? super T4, ? super T5, ? super T6, ? super T7, ? super T8, ? super T9, ? extends R> function9) {
        Objects.requireNonNull(publisher, "source1 is null");
        Objects.requireNonNull(publisher2, "source2 is null");
        Objects.requireNonNull(publisher3, "source3 is null");
        Objects.requireNonNull(publisher4, "source4 is null");
        Objects.requireNonNull(publisher5, "source5 is null");
        Objects.requireNonNull(publisher6, "source6 is null");
        Objects.requireNonNull(publisher7, "source7 is null");
        Objects.requireNonNull(publisher8, "source8 is null");
        Objects.requireNonNull(publisher9, "source9 is null");
        Objects.requireNonNull(function9, "zipper is null");
        return zipArray(Functions.toFunction(function9), false, bufferSize(), publisher, publisher2, publisher3, publisher4, publisher5, publisher6, publisher7, publisher8, publisher9);
    }
}
