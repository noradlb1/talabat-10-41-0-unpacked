package io.reactivex.rxjava3.internal.operators.flowable;

import io.reactivex.rxjava3.core.Emitter;
import io.reactivex.rxjava3.core.Flowable;
import io.reactivex.rxjava3.core.Scheduler;
import io.reactivex.rxjava3.flowables.ConnectableFlowable;
import io.reactivex.rxjava3.functions.Action;
import io.reactivex.rxjava3.functions.BiConsumer;
import io.reactivex.rxjava3.functions.BiFunction;
import io.reactivex.rxjava3.functions.Consumer;
import io.reactivex.rxjava3.functions.Function;
import io.reactivex.rxjava3.functions.Supplier;
import io.reactivex.rxjava3.internal.functions.Functions;
import java.util.Objects;
import java.util.concurrent.TimeUnit;
import org.reactivestreams.Publisher;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

public final class FlowableInternalHelper {

    public static final class BufferedReplaySupplier<T> implements Supplier<ConnectableFlowable<T>> {

        /* renamed from: b  reason: collision with root package name */
        public final Flowable<T> f19919b;

        /* renamed from: c  reason: collision with root package name */
        public final int f19920c;

        /* renamed from: d  reason: collision with root package name */
        public final boolean f19921d;

        public BufferedReplaySupplier(Flowable<T> flowable, int i11, boolean z11) {
            this.f19919b = flowable;
            this.f19920c = i11;
            this.f19921d = z11;
        }

        public ConnectableFlowable<T> get() {
            return this.f19919b.replay(this.f19920c, this.f19921d);
        }
    }

    public static final class BufferedTimedReplay<T> implements Supplier<ConnectableFlowable<T>> {

        /* renamed from: b  reason: collision with root package name */
        public final Flowable<T> f19922b;

        /* renamed from: c  reason: collision with root package name */
        public final int f19923c;

        /* renamed from: d  reason: collision with root package name */
        public final long f19924d;

        /* renamed from: e  reason: collision with root package name */
        public final TimeUnit f19925e;

        /* renamed from: f  reason: collision with root package name */
        public final Scheduler f19926f;

        /* renamed from: g  reason: collision with root package name */
        public final boolean f19927g;

        public BufferedTimedReplay(Flowable<T> flowable, int i11, long j11, TimeUnit timeUnit, Scheduler scheduler, boolean z11) {
            this.f19922b = flowable;
            this.f19923c = i11;
            this.f19924d = j11;
            this.f19925e = timeUnit;
            this.f19926f = scheduler;
            this.f19927g = z11;
        }

        public ConnectableFlowable<T> get() {
            return this.f19922b.replay(this.f19923c, this.f19924d, this.f19925e, this.f19926f, this.f19927g);
        }
    }

    public static final class FlatMapIntoIterable<T, U> implements Function<T, Publisher<U>> {
        private final Function<? super T, ? extends Iterable<? extends U>> mapper;

        public FlatMapIntoIterable(Function<? super T, ? extends Iterable<? extends U>> function) {
            this.mapper = function;
        }

        public Publisher<U> apply(T t11) throws Throwable {
            Object apply = this.mapper.apply(t11);
            Objects.requireNonNull(apply, "The mapper returned a null Iterable");
            return new FlowableFromIterable((Iterable) apply);
        }
    }

    public static final class FlatMapWithCombinerInner<U, R, T> implements Function<U, R> {
        private final BiFunction<? super T, ? super U, ? extends R> combiner;

        /* renamed from: t  reason: collision with root package name */
        private final T f19928t;

        public FlatMapWithCombinerInner(BiFunction<? super T, ? super U, ? extends R> biFunction, T t11) {
            this.combiner = biFunction;
            this.f19928t = t11;
        }

        public R apply(U u11) throws Throwable {
            return this.combiner.apply(this.f19928t, u11);
        }
    }

    public static final class FlatMapWithCombinerOuter<T, R, U> implements Function<T, Publisher<R>> {
        private final BiFunction<? super T, ? super U, ? extends R> combiner;
        private final Function<? super T, ? extends Publisher<? extends U>> mapper;

        public FlatMapWithCombinerOuter(BiFunction<? super T, ? super U, ? extends R> biFunction, Function<? super T, ? extends Publisher<? extends U>> function) {
            this.combiner = biFunction;
            this.mapper = function;
        }

        public Publisher<R> apply(T t11) throws Throwable {
            Object apply = this.mapper.apply(t11);
            Objects.requireNonNull(apply, "The mapper returned a null Publisher");
            return new FlowableMapPublisher((Publisher) apply, new FlatMapWithCombinerInner(this.combiner, t11));
        }
    }

    public static final class ItemDelayFunction<T, U> implements Function<T, Publisher<T>> {

        /* renamed from: b  reason: collision with root package name */
        public final Function<? super T, ? extends Publisher<U>> f19929b;

        public ItemDelayFunction(Function<? super T, ? extends Publisher<U>> function) {
            this.f19929b = function;
        }

        public Publisher<T> apply(T t11) throws Throwable {
            Object apply = this.f19929b.apply(t11);
            Objects.requireNonNull(apply, "The itemDelay returned a null Publisher");
            return new FlowableTakePublisher((Publisher) apply, 1).map(Functions.justFunction(t11)).defaultIfEmpty(t11);
        }
    }

    public static final class ReplaySupplier<T> implements Supplier<ConnectableFlowable<T>> {

        /* renamed from: b  reason: collision with root package name */
        public final Flowable<T> f19930b;

        public ReplaySupplier(Flowable<T> flowable) {
            this.f19930b = flowable;
        }

        public ConnectableFlowable<T> get() {
            return this.f19930b.replay();
        }
    }

    public enum RequestMax implements Consumer<Subscription> {
        INSTANCE;

        public void accept(Subscription subscription) {
            subscription.request(Long.MAX_VALUE);
        }
    }

    public static final class SimpleBiGenerator<T, S> implements BiFunction<S, Emitter<T>, S> {

        /* renamed from: b  reason: collision with root package name */
        public final BiConsumer<S, Emitter<T>> f19931b;

        public SimpleBiGenerator(BiConsumer<S, Emitter<T>> biConsumer) {
            this.f19931b = biConsumer;
        }

        public S apply(S s11, Emitter<T> emitter) throws Throwable {
            this.f19931b.accept(s11, emitter);
            return s11;
        }
    }

    public static final class SimpleGenerator<T, S> implements BiFunction<S, Emitter<T>, S> {

        /* renamed from: b  reason: collision with root package name */
        public final Consumer<Emitter<T>> f19932b;

        public SimpleGenerator(Consumer<Emitter<T>> consumer) {
            this.f19932b = consumer;
        }

        public S apply(S s11, Emitter<T> emitter) throws Throwable {
            this.f19932b.accept(emitter);
            return s11;
        }
    }

    public static final class SubscriberOnComplete<T> implements Action {

        /* renamed from: b  reason: collision with root package name */
        public final Subscriber<T> f19933b;

        public SubscriberOnComplete(Subscriber<T> subscriber) {
            this.f19933b = subscriber;
        }

        public void run() {
            this.f19933b.onComplete();
        }
    }

    public static final class SubscriberOnError<T> implements Consumer<Throwable> {

        /* renamed from: b  reason: collision with root package name */
        public final Subscriber<T> f19934b;

        public SubscriberOnError(Subscriber<T> subscriber) {
            this.f19934b = subscriber;
        }

        public void accept(Throwable th2) {
            this.f19934b.onError(th2);
        }
    }

    public static final class SubscriberOnNext<T> implements Consumer<T> {

        /* renamed from: b  reason: collision with root package name */
        public final Subscriber<T> f19935b;

        public SubscriberOnNext(Subscriber<T> subscriber) {
            this.f19935b = subscriber;
        }

        public void accept(T t11) {
            this.f19935b.onNext(t11);
        }
    }

    public static final class TimedReplay<T> implements Supplier<ConnectableFlowable<T>> {

        /* renamed from: b  reason: collision with root package name */
        public final boolean f19936b;
        private final Flowable<T> parent;
        private final Scheduler scheduler;
        private final long time;
        private final TimeUnit unit;

        public TimedReplay(Flowable<T> flowable, long j11, TimeUnit timeUnit, Scheduler scheduler2, boolean z11) {
            this.parent = flowable;
            this.time = j11;
            this.unit = timeUnit;
            this.scheduler = scheduler2;
            this.f19936b = z11;
        }

        public ConnectableFlowable<T> get() {
            return this.parent.replay(this.time, this.unit, this.scheduler, this.f19936b);
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

    public static <T> Supplier<ConnectableFlowable<T>> replaySupplier(Flowable<T> flowable) {
        return new ReplaySupplier(flowable);
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

    public static <T> Supplier<ConnectableFlowable<T>> replaySupplier(Flowable<T> flowable, int i11, boolean z11) {
        return new BufferedReplaySupplier(flowable, i11, z11);
    }

    public static <T> Supplier<ConnectableFlowable<T>> replaySupplier(Flowable<T> flowable, int i11, long j11, TimeUnit timeUnit, Scheduler scheduler, boolean z11) {
        return new BufferedTimedReplay(flowable, i11, j11, timeUnit, scheduler, z11);
    }

    public static <T> Supplier<ConnectableFlowable<T>> replaySupplier(Flowable<T> flowable, long j11, TimeUnit timeUnit, Scheduler scheduler, boolean z11) {
        return new TimedReplay(flowable, j11, timeUnit, scheduler, z11);
    }
}
