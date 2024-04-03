package io.reactivex.internal.operators.observable;

import io.reactivex.Emitter;
import io.reactivex.Observable;
import io.reactivex.ObservableSource;
import io.reactivex.Observer;
import io.reactivex.Scheduler;
import io.reactivex.functions.Action;
import io.reactivex.functions.BiConsumer;
import io.reactivex.functions.BiFunction;
import io.reactivex.functions.Consumer;
import io.reactivex.functions.Function;
import io.reactivex.internal.functions.Functions;
import io.reactivex.internal.functions.ObjectHelper;
import io.reactivex.observables.ConnectableObservable;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.TimeUnit;

public final class ObservableInternalHelper {

    public static final class BufferedReplayCallable<T> implements Callable<ConnectableObservable<T>> {
        private final int bufferSize;
        private final Observable<T> parent;

        public BufferedReplayCallable(Observable<T> observable, int i11) {
            this.parent = observable;
            this.bufferSize = i11;
        }

        public ConnectableObservable<T> call() {
            return this.parent.replay(this.bufferSize);
        }
    }

    public static final class BufferedTimedReplayCallable<T> implements Callable<ConnectableObservable<T>> {
        private final int bufferSize;
        private final Observable<T> parent;
        private final Scheduler scheduler;
        private final long time;
        private final TimeUnit unit;

        public BufferedTimedReplayCallable(Observable<T> observable, int i11, long j11, TimeUnit timeUnit, Scheduler scheduler2) {
            this.parent = observable;
            this.bufferSize = i11;
            this.time = j11;
            this.unit = timeUnit;
            this.scheduler = scheduler2;
        }

        public ConnectableObservable<T> call() {
            return this.parent.replay(this.bufferSize, this.time, this.unit, this.scheduler);
        }
    }

    public static final class FlatMapIntoIterable<T, U> implements Function<T, ObservableSource<U>> {
        private final Function<? super T, ? extends Iterable<? extends U>> mapper;

        public FlatMapIntoIterable(Function<? super T, ? extends Iterable<? extends U>> function) {
            this.mapper = function;
        }

        public ObservableSource<U> apply(T t11) throws Exception {
            return new ObservableFromIterable((Iterable) ObjectHelper.requireNonNull(this.mapper.apply(t11), "The mapper returned a null Iterable"));
        }
    }

    public static final class FlatMapWithCombinerInner<U, R, T> implements Function<U, R> {
        private final BiFunction<? super T, ? super U, ? extends R> combiner;

        /* renamed from: t  reason: collision with root package name */
        private final T f17339t;

        public FlatMapWithCombinerInner(BiFunction<? super T, ? super U, ? extends R> biFunction, T t11) {
            this.combiner = biFunction;
            this.f17339t = t11;
        }

        public R apply(U u11) throws Exception {
            return this.combiner.apply(this.f17339t, u11);
        }
    }

    public static final class FlatMapWithCombinerOuter<T, R, U> implements Function<T, ObservableSource<R>> {
        private final BiFunction<? super T, ? super U, ? extends R> combiner;
        private final Function<? super T, ? extends ObservableSource<? extends U>> mapper;

        public FlatMapWithCombinerOuter(BiFunction<? super T, ? super U, ? extends R> biFunction, Function<? super T, ? extends ObservableSource<? extends U>> function) {
            this.combiner = biFunction;
            this.mapper = function;
        }

        public ObservableSource<R> apply(T t11) throws Exception {
            return new ObservableMap((ObservableSource) ObjectHelper.requireNonNull(this.mapper.apply(t11), "The mapper returned a null ObservableSource"), new FlatMapWithCombinerInner(this.combiner, t11));
        }
    }

    public static final class ItemDelayFunction<T, U> implements Function<T, ObservableSource<T>> {

        /* renamed from: b  reason: collision with root package name */
        public final Function<? super T, ? extends ObservableSource<U>> f17340b;

        public ItemDelayFunction(Function<? super T, ? extends ObservableSource<U>> function) {
            this.f17340b = function;
        }

        public ObservableSource<T> apply(T t11) throws Exception {
            return new ObservableTake((ObservableSource) ObjectHelper.requireNonNull(this.f17340b.apply(t11), "The itemDelay returned a null ObservableSource"), 1).map(Functions.justFunction(t11)).defaultIfEmpty(t11);
        }
    }

    public enum MapToInt implements Function<Object, Object> {
        INSTANCE;

        public Object apply(Object obj) throws Exception {
            return 0;
        }
    }

    public static final class ObserverOnComplete<T> implements Action {

        /* renamed from: b  reason: collision with root package name */
        public final Observer<T> f17341b;

        public ObserverOnComplete(Observer<T> observer) {
            this.f17341b = observer;
        }

        public void run() throws Exception {
            this.f17341b.onComplete();
        }
    }

    public static final class ObserverOnError<T> implements Consumer<Throwable> {

        /* renamed from: b  reason: collision with root package name */
        public final Observer<T> f17342b;

        public ObserverOnError(Observer<T> observer) {
            this.f17342b = observer;
        }

        public void accept(Throwable th2) throws Exception {
            this.f17342b.onError(th2);
        }
    }

    public static final class ObserverOnNext<T> implements Consumer<T> {

        /* renamed from: b  reason: collision with root package name */
        public final Observer<T> f17343b;

        public ObserverOnNext(Observer<T> observer) {
            this.f17343b = observer;
        }

        public void accept(T t11) throws Exception {
            this.f17343b.onNext(t11);
        }
    }

    public static final class ReplayCallable<T> implements Callable<ConnectableObservable<T>> {
        private final Observable<T> parent;

        public ReplayCallable(Observable<T> observable) {
            this.parent = observable;
        }

        public ConnectableObservable<T> call() {
            return this.parent.replay();
        }
    }

    public static final class ReplayFunction<T, R> implements Function<Observable<T>, ObservableSource<R>> {
        private final Scheduler scheduler;
        private final Function<? super Observable<T>, ? extends ObservableSource<R>> selector;

        public ReplayFunction(Function<? super Observable<T>, ? extends ObservableSource<R>> function, Scheduler scheduler2) {
            this.selector = function;
            this.scheduler = scheduler2;
        }

        public ObservableSource<R> apply(Observable<T> observable) throws Exception {
            return Observable.wrap((ObservableSource) ObjectHelper.requireNonNull(this.selector.apply(observable), "The selector returned a null ObservableSource")).observeOn(this.scheduler);
        }
    }

    public static final class SimpleBiGenerator<T, S> implements BiFunction<S, Emitter<T>, S> {

        /* renamed from: b  reason: collision with root package name */
        public final BiConsumer<S, Emitter<T>> f17344b;

        public SimpleBiGenerator(BiConsumer<S, Emitter<T>> biConsumer) {
            this.f17344b = biConsumer;
        }

        public S apply(S s11, Emitter<T> emitter) throws Exception {
            this.f17344b.accept(s11, emitter);
            return s11;
        }
    }

    public static final class SimpleGenerator<T, S> implements BiFunction<S, Emitter<T>, S> {

        /* renamed from: b  reason: collision with root package name */
        public final Consumer<Emitter<T>> f17345b;

        public SimpleGenerator(Consumer<Emitter<T>> consumer) {
            this.f17345b = consumer;
        }

        public S apply(S s11, Emitter<T> emitter) throws Exception {
            this.f17345b.accept(emitter);
            return s11;
        }
    }

    public static final class TimedReplayCallable<T> implements Callable<ConnectableObservable<T>> {
        private final Observable<T> parent;
        private final Scheduler scheduler;
        private final long time;
        private final TimeUnit unit;

        public TimedReplayCallable(Observable<T> observable, long j11, TimeUnit timeUnit, Scheduler scheduler2) {
            this.parent = observable;
            this.time = j11;
            this.unit = timeUnit;
            this.scheduler = scheduler2;
        }

        public ConnectableObservable<T> call() {
            return this.parent.replay(this.time, this.unit, this.scheduler);
        }
    }

    public static final class ZipIterableFunction<T, R> implements Function<List<ObservableSource<? extends T>>, ObservableSource<? extends R>> {
        private final Function<? super Object[], ? extends R> zipper;

        public ZipIterableFunction(Function<? super Object[], ? extends R> function) {
            this.zipper = function;
        }

        public ObservableSource<? extends R> apply(List<ObservableSource<? extends T>> list) {
            return Observable.zipIterable(list, this.zipper, false, Observable.bufferSize());
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

    public static <T> Callable<ConnectableObservable<T>> replayCallable(Observable<T> observable) {
        return new ReplayCallable(observable);
    }

    public static <T, R> Function<Observable<T>, ObservableSource<R>> replayFunction(Function<? super Observable<T>, ? extends ObservableSource<R>> function, Scheduler scheduler) {
        return new ReplayFunction(function, scheduler);
    }

    public static <T, S> BiFunction<S, Emitter<T>, S> simpleBiGenerator(BiConsumer<S, Emitter<T>> biConsumer) {
        return new SimpleBiGenerator(biConsumer);
    }

    public static <T, S> BiFunction<S, Emitter<T>, S> simpleGenerator(Consumer<Emitter<T>> consumer) {
        return new SimpleGenerator(consumer);
    }

    public static <T, R> Function<List<ObservableSource<? extends T>>, ObservableSource<? extends R>> zipIterable(Function<? super Object[], ? extends R> function) {
        return new ZipIterableFunction(function);
    }

    public static <T> Callable<ConnectableObservable<T>> replayCallable(Observable<T> observable, int i11) {
        return new BufferedReplayCallable(observable, i11);
    }

    public static <T> Callable<ConnectableObservable<T>> replayCallable(Observable<T> observable, int i11, long j11, TimeUnit timeUnit, Scheduler scheduler) {
        return new BufferedTimedReplayCallable(observable, i11, j11, timeUnit, scheduler);
    }

    public static <T> Callable<ConnectableObservable<T>> replayCallable(Observable<T> observable, long j11, TimeUnit timeUnit, Scheduler scheduler) {
        return new TimedReplayCallable(observable, j11, timeUnit, scheduler);
    }
}
