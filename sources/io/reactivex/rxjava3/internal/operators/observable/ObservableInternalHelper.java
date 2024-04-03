package io.reactivex.rxjava3.internal.operators.observable;

import io.reactivex.rxjava3.core.Emitter;
import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.core.ObservableSource;
import io.reactivex.rxjava3.core.Observer;
import io.reactivex.rxjava3.core.Scheduler;
import io.reactivex.rxjava3.functions.Action;
import io.reactivex.rxjava3.functions.BiConsumer;
import io.reactivex.rxjava3.functions.BiFunction;
import io.reactivex.rxjava3.functions.Consumer;
import io.reactivex.rxjava3.functions.Function;
import io.reactivex.rxjava3.functions.Supplier;
import io.reactivex.rxjava3.internal.functions.Functions;
import io.reactivex.rxjava3.observables.ConnectableObservable;
import java.util.Objects;
import java.util.concurrent.TimeUnit;

public final class ObservableInternalHelper {

    public static final class BufferedReplaySupplier<T> implements Supplier<ConnectableObservable<T>> {

        /* renamed from: b  reason: collision with root package name */
        public final Observable<T> f21872b;

        /* renamed from: c  reason: collision with root package name */
        public final int f21873c;

        /* renamed from: d  reason: collision with root package name */
        public final boolean f21874d;

        public BufferedReplaySupplier(Observable<T> observable, int i11, boolean z11) {
            this.f21872b = observable;
            this.f21873c = i11;
            this.f21874d = z11;
        }

        public ConnectableObservable<T> get() {
            return this.f21872b.replay(this.f21873c, this.f21874d);
        }
    }

    public static final class BufferedTimedReplaySupplier<T> implements Supplier<ConnectableObservable<T>> {

        /* renamed from: b  reason: collision with root package name */
        public final Observable<T> f21875b;

        /* renamed from: c  reason: collision with root package name */
        public final int f21876c;

        /* renamed from: d  reason: collision with root package name */
        public final long f21877d;

        /* renamed from: e  reason: collision with root package name */
        public final TimeUnit f21878e;

        /* renamed from: f  reason: collision with root package name */
        public final Scheduler f21879f;

        /* renamed from: g  reason: collision with root package name */
        public final boolean f21880g;

        public BufferedTimedReplaySupplier(Observable<T> observable, int i11, long j11, TimeUnit timeUnit, Scheduler scheduler, boolean z11) {
            this.f21875b = observable;
            this.f21876c = i11;
            this.f21877d = j11;
            this.f21878e = timeUnit;
            this.f21879f = scheduler;
            this.f21880g = z11;
        }

        public ConnectableObservable<T> get() {
            return this.f21875b.replay(this.f21876c, this.f21877d, this.f21878e, this.f21879f, this.f21880g);
        }
    }

    public static final class FlatMapIntoIterable<T, U> implements Function<T, ObservableSource<U>> {
        private final Function<? super T, ? extends Iterable<? extends U>> mapper;

        public FlatMapIntoIterable(Function<? super T, ? extends Iterable<? extends U>> function) {
            this.mapper = function;
        }

        public ObservableSource<U> apply(T t11) throws Throwable {
            Object apply = this.mapper.apply(t11);
            Objects.requireNonNull(apply, "The mapper returned a null Iterable");
            return new ObservableFromIterable((Iterable) apply);
        }
    }

    public static final class FlatMapWithCombinerInner<U, R, T> implements Function<U, R> {
        private final BiFunction<? super T, ? super U, ? extends R> combiner;

        /* renamed from: t  reason: collision with root package name */
        private final T f21881t;

        public FlatMapWithCombinerInner(BiFunction<? super T, ? super U, ? extends R> biFunction, T t11) {
            this.combiner = biFunction;
            this.f21881t = t11;
        }

        public R apply(U u11) throws Throwable {
            return this.combiner.apply(this.f21881t, u11);
        }
    }

    public static final class FlatMapWithCombinerOuter<T, R, U> implements Function<T, ObservableSource<R>> {
        private final BiFunction<? super T, ? super U, ? extends R> combiner;
        private final Function<? super T, ? extends ObservableSource<? extends U>> mapper;

        public FlatMapWithCombinerOuter(BiFunction<? super T, ? super U, ? extends R> biFunction, Function<? super T, ? extends ObservableSource<? extends U>> function) {
            this.combiner = biFunction;
            this.mapper = function;
        }

        public ObservableSource<R> apply(T t11) throws Throwable {
            Object apply = this.mapper.apply(t11);
            Objects.requireNonNull(apply, "The mapper returned a null ObservableSource");
            return new ObservableMap((ObservableSource) apply, new FlatMapWithCombinerInner(this.combiner, t11));
        }
    }

    public static final class ItemDelayFunction<T, U> implements Function<T, ObservableSource<T>> {

        /* renamed from: b  reason: collision with root package name */
        public final Function<? super T, ? extends ObservableSource<U>> f21882b;

        public ItemDelayFunction(Function<? super T, ? extends ObservableSource<U>> function) {
            this.f21882b = function;
        }

        public ObservableSource<T> apply(T t11) throws Throwable {
            Object apply = this.f21882b.apply(t11);
            Objects.requireNonNull(apply, "The itemDelay returned a null ObservableSource");
            return new ObservableTake((ObservableSource) apply, 1).map(Functions.justFunction(t11)).defaultIfEmpty(t11);
        }
    }

    public enum MapToInt implements Function<Object, Object> {
        INSTANCE;

        public Object apply(Object obj) {
            return 0;
        }
    }

    public static final class ObserverOnComplete<T> implements Action {

        /* renamed from: b  reason: collision with root package name */
        public final Observer<T> f21883b;

        public ObserverOnComplete(Observer<T> observer) {
            this.f21883b = observer;
        }

        public void run() {
            this.f21883b.onComplete();
        }
    }

    public static final class ObserverOnError<T> implements Consumer<Throwable> {

        /* renamed from: b  reason: collision with root package name */
        public final Observer<T> f21884b;

        public ObserverOnError(Observer<T> observer) {
            this.f21884b = observer;
        }

        public void accept(Throwable th2) {
            this.f21884b.onError(th2);
        }
    }

    public static final class ObserverOnNext<T> implements Consumer<T> {

        /* renamed from: b  reason: collision with root package name */
        public final Observer<T> f21885b;

        public ObserverOnNext(Observer<T> observer) {
            this.f21885b = observer;
        }

        public void accept(T t11) {
            this.f21885b.onNext(t11);
        }
    }

    public static final class ReplaySupplier<T> implements Supplier<ConnectableObservable<T>> {
        private final Observable<T> parent;

        public ReplaySupplier(Observable<T> observable) {
            this.parent = observable;
        }

        public ConnectableObservable<T> get() {
            return this.parent.replay();
        }
    }

    public static final class SimpleBiGenerator<T, S> implements BiFunction<S, Emitter<T>, S> {

        /* renamed from: b  reason: collision with root package name */
        public final BiConsumer<S, Emitter<T>> f21886b;

        public SimpleBiGenerator(BiConsumer<S, Emitter<T>> biConsumer) {
            this.f21886b = biConsumer;
        }

        public S apply(S s11, Emitter<T> emitter) throws Throwable {
            this.f21886b.accept(s11, emitter);
            return s11;
        }
    }

    public static final class SimpleGenerator<T, S> implements BiFunction<S, Emitter<T>, S> {

        /* renamed from: b  reason: collision with root package name */
        public final Consumer<Emitter<T>> f21887b;

        public SimpleGenerator(Consumer<Emitter<T>> consumer) {
            this.f21887b = consumer;
        }

        public S apply(S s11, Emitter<T> emitter) throws Throwable {
            this.f21887b.accept(emitter);
            return s11;
        }
    }

    public static final class TimedReplayCallable<T> implements Supplier<ConnectableObservable<T>> {

        /* renamed from: b  reason: collision with root package name */
        public final Observable<T> f21888b;

        /* renamed from: c  reason: collision with root package name */
        public final long f21889c;

        /* renamed from: d  reason: collision with root package name */
        public final TimeUnit f21890d;

        /* renamed from: e  reason: collision with root package name */
        public final Scheduler f21891e;

        /* renamed from: f  reason: collision with root package name */
        public final boolean f21892f;

        public TimedReplayCallable(Observable<T> observable, long j11, TimeUnit timeUnit, Scheduler scheduler, boolean z11) {
            this.f21888b = observable;
            this.f21889c = j11;
            this.f21890d = timeUnit;
            this.f21891e = scheduler;
            this.f21892f = z11;
        }

        public ConnectableObservable<T> get() {
            return this.f21888b.replay(this.f21889c, this.f21890d, this.f21891e, this.f21892f);
        }
    }

    private ObservableInternalHelper() {
        throw new IllegalStateException("No instances!");
    }

    public static <T, U> Function<T, ObservableSource<U>> flatMapIntoIterable(Function<? super T, ? extends Iterable<? extends U>> function) {
        return new FlatMapIntoIterable(function);
    }

    public static <T, U, R> Function<T, ObservableSource<R>> flatMapWithCombiner(Function<? super T, ? extends ObservableSource<? extends U>> function, BiFunction<? super T, ? super U, ? extends R> biFunction) {
        return new FlatMapWithCombinerOuter(biFunction, function);
    }

    public static <T, U> Function<T, ObservableSource<T>> itemDelay(Function<? super T, ? extends ObservableSource<U>> function) {
        return new ItemDelayFunction(function);
    }

    public static <T> Action observerOnComplete(Observer<T> observer) {
        return new ObserverOnComplete(observer);
    }

    public static <T> Consumer<Throwable> observerOnError(Observer<T> observer) {
        return new ObserverOnError(observer);
    }

    public static <T> Consumer<T> observerOnNext(Observer<T> observer) {
        return new ObserverOnNext(observer);
    }

    public static <T> Supplier<ConnectableObservable<T>> replaySupplier(Observable<T> observable) {
        return new ReplaySupplier(observable);
    }

    public static <T, S> BiFunction<S, Emitter<T>, S> simpleBiGenerator(BiConsumer<S, Emitter<T>> biConsumer) {
        return new SimpleBiGenerator(biConsumer);
    }

    public static <T, S> BiFunction<S, Emitter<T>, S> simpleGenerator(Consumer<Emitter<T>> consumer) {
        return new SimpleGenerator(consumer);
    }

    public static <T> Supplier<ConnectableObservable<T>> replaySupplier(Observable<T> observable, int i11, boolean z11) {
        return new BufferedReplaySupplier(observable, i11, z11);
    }

    public static <T> Supplier<ConnectableObservable<T>> replaySupplier(Observable<T> observable, int i11, long j11, TimeUnit timeUnit, Scheduler scheduler, boolean z11) {
        return new BufferedTimedReplaySupplier(observable, i11, j11, timeUnit, scheduler, z11);
    }

    public static <T> Supplier<ConnectableObservable<T>> replaySupplier(Observable<T> observable, long j11, TimeUnit timeUnit, Scheduler scheduler, boolean z11) {
        return new TimedReplayCallable(observable, j11, timeUnit, scheduler, z11);
    }
}
