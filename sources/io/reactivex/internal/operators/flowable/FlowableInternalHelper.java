package io.reactivex.internal.operators.flowable;

import io.reactivex.Emitter;
import io.reactivex.Flowable;
import io.reactivex.Scheduler;
import io.reactivex.flowables.ConnectableFlowable;
import io.reactivex.functions.Action;
import io.reactivex.functions.BiConsumer;
import io.reactivex.functions.BiFunction;
import io.reactivex.functions.Consumer;
import io.reactivex.functions.Function;
import io.reactivex.internal.functions.Functions;
import io.reactivex.internal.functions.ObjectHelper;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.TimeUnit;
import org.reactivestreams.Publisher;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

public final class FlowableInternalHelper {

    public static final class BufferedReplayCallable<T> implements Callable<ConnectableFlowable<T>> {
        private final int bufferSize;
        private final Flowable<T> parent;

        public BufferedReplayCallable(Flowable<T> flowable, int i11) {
            this.parent = flowable;
            this.bufferSize = i11;
        }

        public ConnectableFlowable<T> call() {
            return this.parent.replay(this.bufferSize);
        }
    }

    public static final class BufferedTimedReplay<T> implements Callable<ConnectableFlowable<T>> {
        private final int bufferSize;
        private final Flowable<T> parent;
        private final Scheduler scheduler;
        private final long time;
        private final TimeUnit unit;

        public BufferedTimedReplay(Flowable<T> flowable, int i11, long j11, TimeUnit timeUnit, Scheduler scheduler2) {
            this.parent = flowable;
            this.bufferSize = i11;
            this.time = j11;
            this.unit = timeUnit;
            this.scheduler = scheduler2;
        }

        public ConnectableFlowable<T> call() {
            return this.parent.replay(this.bufferSize, this.time, this.unit, this.scheduler);
        }
    }

    public static final class FlatMapIntoIterable<T, U> implements Function<T, Publisher<U>> {
        private final Function<? super T, ? extends Iterable<? extends U>> mapper;

        public FlatMapIntoIterable(Function<? super T, ? extends Iterable<? extends U>> function) {
            this.mapper = function;
        }

        public Publisher<U> apply(T t11) throws Exception {
            return new FlowableFromIterable((Iterable) ObjectHelper.requireNonNull(this.mapper.apply(t11), "The mapper returned a null Iterable"));
        }
    }

    public static final class FlatMapWithCombinerInner<U, R, T> implements Function<U, R> {
        private final BiFunction<? super T, ? super U, ? extends R> combiner;

        /* renamed from: t  reason: collision with root package name */
        private final T f15403t;

        public FlatMapWithCombinerInner(BiFunction<? super T, ? super U, ? extends R> biFunction, T t11) {
            this.combiner = biFunction;
            this.f15403t = t11;
        }

        public R apply(U u11) throws Exception {
            return this.combiner.apply(this.f15403t, u11);
        }
    }

    public static final class FlatMapWithCombinerOuter<T, R, U> implements Function<T, Publisher<R>> {
        private final BiFunction<? super T, ? super U, ? extends R> combiner;
        private final Function<? super T, ? extends Publisher<? extends U>> mapper;

        public FlatMapWithCombinerOuter(BiFunction<? super T, ? super U, ? extends R> biFunction, Function<? super T, ? extends Publisher<? extends U>> function) {
            this.combiner = biFunction;
            this.mapper = function;
        }

        public Publisher<R> apply(T t11) throws Exception {
            return new FlowableMapPublisher((Publisher) ObjectHelper.requireNonNull(this.mapper.apply(t11), "The mapper returned a null Publisher"), new FlatMapWithCombinerInner(this.combiner, t11));
        }
    }

    public static final class ItemDelayFunction<T, U> implements Function<T, Publisher<T>> {

        /* renamed from: b  reason: collision with root package name */
        public final Function<? super T, ? extends Publisher<U>> f15404b;

        public ItemDelayFunction(Function<? super T, ? extends Publisher<U>> function) {
            this.f15404b = function;
        }

        public Publisher<T> apply(T t11) throws Exception {
            return new FlowableTakePublisher((Publisher) ObjectHelper.requireNonNull(this.f15404b.apply(t11), "The itemDelay returned a null Publisher"), 1).map(Functions.justFunction(t11)).defaultIfEmpty(t11);
        }
    }

    public static final class ReplayCallable<T> implements Callable<ConnectableFlowable<T>> {
        private final Flowable<T> parent;

        public ReplayCallable(Flowable<T> flowable) {
            this.parent = flowable;
        }

        public ConnectableFlowable<T> call() {
            return this.parent.replay();
        }
    }

    public static final class ReplayFunction<T, R> implements Function<Flowable<T>, Publisher<R>> {
        private final Scheduler scheduler;
        private final Function<? super Flowable<T>, ? extends Publisher<R>> selector;

        public ReplayFunction(Function<? super Flowable<T>, ? extends Publisher<R>> function, Scheduler scheduler2) {
            this.selector = function;
            this.scheduler = scheduler2;
        }

        public Publisher<R> apply(Flowable<T> flowable) throws Exception {
            return Flowable.fromPublisher((Publisher) ObjectHelper.requireNonNull(this.selector.apply(flowable), "The selector returned a null Publisher")).observeOn(this.scheduler);
        }
    }

    public enum RequestMax implements Consumer<Subscription> {
        INSTANCE;

        public void accept(Subscription subscription) throws Exception {
            subscription.request(Long.MAX_VALUE);
        }
    }

    public static final class SimpleBiGenerator<T, S> implements BiFunction<S, Emitter<T>, S> {

        /* renamed from: b  reason: collision with root package name */
        public final BiConsumer<S, Emitter<T>> f15405b;

        public SimpleBiGenerator(BiConsumer<S, Emitter<T>> biConsumer) {
            this.f15405b = biConsumer;
        }

        public S apply(S s11, Emitter<T> emitter) throws Exception {
            this.f15405b.accept(s11, emitter);
            return s11;
        }
    }

    public static final class SimpleGenerator<T, S> implements BiFunction<S, Emitter<T>, S> {

        /* renamed from: b  reason: collision with root package name */
        public final Consumer<Emitter<T>> f15406b;

        public SimpleGenerator(Consumer<Emitter<T>> consumer) {
            this.f15406b = consumer;
        }

        public S apply(S s11, Emitter<T> emitter) throws Exception {
            this.f15406b.accept(emitter);
            return s11;
        }
    }

    public static final class SubscriberOnComplete<T> implements Action {

        /* renamed from: b  reason: collision with root package name */
        public final Subscriber<T> f15407b;

        public SubscriberOnComplete(Subscriber<T> subscriber) {
            this.f15407b = subscriber;
        }

        public void run() throws Exception {
            this.f15407b.onComplete();
        }
    }

    public static final class SubscriberOnError<T> implements Consumer<Throwable> {

        /* renamed from: b  reason: collision with root package name */
        public final Subscriber<T> f15408b;

        public SubscriberOnError(Subscriber<T> subscriber) {
            this.f15408b = subscriber;
        }

        public void accept(Throwable th2) throws Exception {
            this.f15408b.onError(th2);
        }
    }

    public static final class SubscriberOnNext<T> implements Consumer<T> {

        /* renamed from: b  reason: collision with root package name */
        public final Subscriber<T> f15409b;

        public SubscriberOnNext(Subscriber<T> subscriber) {
            this.f15409b = subscriber;
        }

        public void accept(T t11) throws Exception {
            this.f15409b.onNext(t11);
        }
    }

    public static final class TimedReplay<T> implements Callable<ConnectableFlowable<T>> {
        private final Flowable<T> parent;
        private final Scheduler scheduler;
        private final long time;
        private final TimeUnit unit;

        public TimedReplay(Flowable<T> flowable, long j11, TimeUnit timeUnit, Scheduler scheduler2) {
            this.parent = flowable;
            this.time = j11;
            this.unit = timeUnit;
            this.scheduler = scheduler2;
        }

        public ConnectableFlowable<T> call() {
            return this.parent.replay(this.time, this.unit, this.scheduler);
        }
    }

    public static final class ZipIterableFunction<T, R> implements Function<List<Publisher<? extends T>>, Publisher<? extends R>> {
        private final Function<? super Object[], ? extends R> zipper;

        public ZipIterableFunction(Function<? super Object[], ? extends R> function) {
            this.zipper = function;
        }

        public Publisher<? extends R> apply(List<Publisher<? extends T>> list) {
            return Flowable.zipIterable(list, this.zipper, false, Flowable.bufferSize());
        }
    }

    private FlowableInternalHelper() {
        throw new IllegalStateException("No instances!");
    }

    public static <T, U> Function<T, Publisher<U>> flatMapIntoIterable(Function<? super T, ? extends Iterable<? extends U>> function) {
        return new FlatMapIntoIterable(function);
    }

    public static <T, U, R> Function<T, Publisher<R>> flatMapWithCombiner(Function<? super T, ? extends Publisher<? extends U>> function, BiFunction<? super T, ? super U, ? extends R> biFunction) {
        return new FlatMapWithCombinerOuter(biFunction, function);
    }

    public static <T, U> Function<T, Publisher<T>> itemDelay(Function<? super T, ? extends Publisher<U>> function) {
        return new ItemDelayFunction(function);
    }

    public static <T> Callable<ConnectableFlowable<T>> replayCallable(Flowable<T> flowable) {
        return new ReplayCallable(flowable);
    }

    public static <T, R> Function<Flowable<T>, Publisher<R>> replayFunction(Function<? super Flowable<T>, ? extends Publisher<R>> function, Scheduler scheduler) {
        return new ReplayFunction(function, scheduler);
    }

    public static <T, S> BiFunction<S, Emitter<T>, S> simpleBiGenerator(BiConsumer<S, Emitter<T>> biConsumer) {
        return new SimpleBiGenerator(biConsumer);
    }

    public static <T, S> BiFunction<S, Emitter<T>, S> simpleGenerator(Consumer<Emitter<T>> consumer) {
        return new SimpleGenerator(consumer);
    }

    public static <T> Action subscriberOnComplete(Subscriber<T> subscriber) {
        return new SubscriberOnComplete(subscriber);
    }

    public static <T> Consumer<Throwable> subscriberOnError(Subscriber<T> subscriber) {
        return new SubscriberOnError(subscriber);
    }

    public static <T> Consumer<T> subscriberOnNext(Subscriber<T> subscriber) {
        return new SubscriberOnNext(subscriber);
    }

    public static <T, R> Function<List<Publisher<? extends T>>, Publisher<? extends R>> zipIterable(Function<? super Object[], ? extends R> function) {
        return new ZipIterableFunction(function);
    }

    public static <T> Callable<ConnectableFlowable<T>> replayCallable(Flowable<T> flowable, int i11) {
        return new BufferedReplayCallable(flowable, i11);
    }

    public static <T> Callable<ConnectableFlowable<T>> replayCallable(Flowable<T> flowable, int i11, long j11, TimeUnit timeUnit, Scheduler scheduler) {
        return new BufferedTimedReplay(flowable, i11, j11, timeUnit, scheduler);
    }

    public static <T> Callable<ConnectableFlowable<T>> replayCallable(Flowable<T> flowable, long j11, TimeUnit timeUnit, Scheduler scheduler) {
        return new TimedReplay(flowable, j11, timeUnit, scheduler);
    }
}
