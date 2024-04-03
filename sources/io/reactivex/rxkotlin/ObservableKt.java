package io.reactivex.rxkotlin;

import io.reactivex.Observable;
import io.reactivex.ObservableSource;
import io.reactivex.Single;
import io.reactivex.annotations.CheckReturnValue;
import io.reactivex.annotations.SchedulerSupport;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.IntProgression;
import kotlin.sequences.Sequence;
import org.jetbrains.annotations.NotNull;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000¢\u0001\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u001c\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010(\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010%\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u001f\n\u0000\n\u0002\u0010\u0011\n\u0000\n\u0002\u0010\u000b\n\u0002\u0010\u0018\n\u0002\u0010\u0005\n\u0002\u0010\u0012\n\u0002\u0010\f\n\u0002\u0010\u0019\n\u0002\u0010\u0006\n\u0002\u0010\u0013\n\u0002\u0010\u0007\n\u0002\u0010\u0014\n\u0002\u0010\b\n\u0002\u0010\u0015\n\u0002\u0010\t\n\u0002\u0010\u0016\n\u0002\u0010\n\n\u0002\u0010\u0017\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a#\u0010\u0000\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\n\b\u0000\u0010\u0002\u0018\u0001*\u00020\u0003*\u0006\u0012\u0002\b\u00030\u0001H\b\u001a^\u0010\u0004\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\b\b\u0000\u0010\u0005*\u00020\u0003\"\b\b\u0001\u0010\u0002*\u00020\u0003*\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00050\u00010\u00062)\b\u0004\u0010\u0007\u001a#\u0012\u0019\u0012\u0017\u0012\u0004\u0012\u0002H\u00050\t¢\u0006\f\b\n\u0012\b\b\u000b\u0012\u0004\b\b(\f\u0012\u0004\u0012\u0002H\u00020\bH\b\u001a(\u0010\r\u001a\b\u0012\u0004\u0012\u0002H\u00050\u0001\"\b\b\u0000\u0010\u0005*\u00020\u0003*\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00050\u00010\u0001H\u0007\u001a(\u0010\r\u001a\b\u0012\u0004\u0012\u0002H\u00050\u0001\"\b\b\u0000\u0010\u0005*\u00020\u0003*\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00050\u000e0\u0006H\u0007\u001a*\u0010\u000f\u001a\b\u0012\u0004\u0012\u0002H\u00050\u0001\"\b\b\u0000\u0010\u0005*\u00020\u0003*\u0010\u0012\f\b\u0001\u0012\b\u0012\u0004\u0012\u0002H\u00050\u00060\u0001H\u0007\u001a*\u0010\u0010\u001a\b\u0012\u0004\u0012\u0002H\u00050\u0001\"\b\b\u0000\u0010\u0005*\u00020\u0003*\u0010\u0012\f\b\u0001\u0012\b\u0012\u0004\u0012\u0002H\u00050\u00060\u0001H\u0007\u001aI\u0010\u0011\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\b\b\u0000\u0010\u0005*\u00020\u0003\"\b\b\u0001\u0010\u0002*\u00020\u0003*\b\u0012\u0004\u0012\u0002H\u00050\u00012\u001a\b\u0004\u0010\u0012\u001a\u0014\u0012\u0004\u0012\u0002H\u0005\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00020\u00130\bH\b\u001a*\u0010\u0014\u001a\b\u0012\u0004\u0012\u0002H\u00050\u0001\"\b\b\u0000\u0010\u0005*\u00020\u0003*\u0010\u0012\f\u0012\n\u0012\u0006\b\u0001\u0012\u0002H\u00050\u00010\u0006H\u0007\u001a(\u0010\u0015\u001a\b\u0012\u0004\u0012\u0002H\u00050\u0001\"\b\b\u0000\u0010\u0005*\u00020\u0003*\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00050\u00010\u0001H\u0007\u001a*\u0010\u0016\u001a\b\u0012\u0004\u0012\u0002H\u00050\u0001\"\b\b\u0000\u0010\u0005*\u00020\u0003*\u0010\u0012\f\u0012\n\u0012\u0006\b\u0001\u0012\u0002H\u00050\u00010\u0006H\u0007\u001a#\u0010\u0017\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\n\b\u0000\u0010\u0002\u0018\u0001*\u00020\u0003*\u0006\u0012\u0002\b\u00030\u0001H\b\u001a(\u0010\u0018\u001a\b\u0012\u0004\u0012\u0002H\u00050\u0001\"\b\b\u0000\u0010\u0005*\u00020\u0003*\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00050\u00010\u0001H\u0007\u001a(\u0010\u0019\u001a\b\u0012\u0004\u0012\u0002H\u00050\u0001\"\b\b\u0000\u0010\u0005*\u00020\u0003*\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00050\u00010\u0001H\u0007\u001a\"\u0010\u001a\u001a\b\u0012\u0004\u0012\u0002H\u00050\u0006\"\b\b\u0000\u0010\u0005*\u00020\u0003*\b\u0012\u0004\u0012\u0002H\u00050\u001bH\u0002\u001aD\u0010\u001c\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u0002H\u001f\u0012\u0004\u0012\u0002H 0\u001e0\u001d\"\b\b\u0000\u0010\u001f*\u00020\u0003\"\b\b\u0001\u0010 *\u00020\u0003*\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u0002H\u001f\u0012\u0004\u0012\u0002H 0!0\u0001H\u0007\u001aJ\u0010\"\u001a\u001a\u0012\u0016\u0012\u0014\u0012\u0004\u0012\u0002H\u001f\u0012\n\u0012\b\u0012\u0004\u0012\u0002H 0#0\u001e0\u001d\"\b\b\u0000\u0010\u001f*\u00020\u0003\"\b\b\u0001\u0010 *\u00020\u0003*\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u0002H\u001f\u0012\u0004\u0012\u0002H 0!0\u0001H\u0007\u001a'\u0010$\u001a\b\u0012\u0004\u0012\u0002H\u00050\u0001\"\b\b\u0000\u0010\u0005*\u00020\u0003*\b\u0012\u0004\u0012\u0002H\u00050%H\u0007¢\u0006\u0002\u0010&\u001a\u0012\u0010$\u001a\b\u0012\u0004\u0012\u00020'0\u0001*\u00020(H\u0007\u001a\u0012\u0010$\u001a\b\u0012\u0004\u0012\u00020)0\u0001*\u00020*H\u0007\u001a\u0012\u0010$\u001a\b\u0012\u0004\u0012\u00020+0\u0001*\u00020,H\u0007\u001a\u0012\u0010$\u001a\b\u0012\u0004\u0012\u00020-0\u0001*\u00020.H\u0007\u001a\u0012\u0010$\u001a\b\u0012\u0004\u0012\u00020/0\u0001*\u000200H\u0007\u001a\u0012\u0010$\u001a\b\u0012\u0004\u0012\u0002010\u0001*\u000202H\u0007\u001a\u0012\u0010$\u001a\b\u0012\u0004\u0012\u0002030\u0001*\u000204H\u0007\u001a\u0012\u0010$\u001a\b\u0012\u0004\u0012\u0002050\u0001*\u000206H\u0007\u001a\"\u0010$\u001a\b\u0012\u0004\u0012\u0002H\u00050\u0001\"\b\b\u0000\u0010\u0005*\u00020\u0003*\b\u0012\u0004\u0012\u0002H\u00050\u0006H\u0007\u001a\"\u0010$\u001a\b\u0012\u0004\u0012\u0002H\u00050\u0001\"\b\b\u0000\u0010\u0005*\u00020\u0003*\b\u0012\u0004\u0012\u0002H\u00050\u001bH\u0007\u001a\u0012\u0010$\u001a\b\u0012\u0004\u0012\u0002010\u0001*\u000207H\u0007\u001a\"\u0010$\u001a\b\u0012\u0004\u0012\u0002H\u00050\u0001\"\b\b\u0000\u0010\u0005*\u00020\u0003*\b\u0012\u0004\u0012\u0002H\u00050\u0013H\u0007\u001a^\u00108\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\b\b\u0000\u0010\u0005*\u00020\u0003\"\b\b\u0001\u0010\u0002*\u00020\u0003*\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00050\u00010\u00062)\b\u0004\u00109\u001a#\u0012\u0019\u0012\u0017\u0012\u0004\u0012\u0002H\u00050\t¢\u0006\f\b\n\u0012\b\b\u000b\u0012\u0004\b\b(\f\u0012\u0004\u0012\u0002H\u00020\bH\b¨\u0006:"}, d2 = {"cast", "Lio/reactivex/Observable;", "R", "", "combineLatest", "T", "", "combineFunction", "Lkotlin/Function1;", "", "Lkotlin/ParameterName;", "name", "args", "concatAll", "Lio/reactivex/ObservableSource;", "concatMapIterable", "flatMapIterable", "flatMapSequence", "body", "Lkotlin/sequences/Sequence;", "merge", "mergeAll", "mergeDelayError", "ofType", "switchLatest", "switchOnNext", "toIterable", "", "toMap", "Lio/reactivex/Single;", "", "A", "B", "Lkotlin/Pair;", "toMultimap", "", "toObservable", "", "([Ljava/lang/Object;)Lio/reactivex/Observable;", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "Lkotlin/ranges/IntProgression;", "zip", "zipFunction", "rxkotlin"}, k = 2, mv = {1, 1, 15})
public final class ObservableKt {
    @CheckReturnValue
    @NotNull
    @SchedulerSupport("none")
    public static final /* synthetic */ <R> Observable<R> cast(@NotNull Observable<?> observable) {
        Intrinsics.checkParameterIsNotNull(observable, "$this$cast");
        Intrinsics.reifiedOperationMarker(4, "R");
        Observable<U> cast = observable.cast(Object.class);
        Intrinsics.checkExpressionValueIsNotNull(cast, "cast(R::class.java)");
        return cast;
    }

    @CheckReturnValue
    @NotNull
    @SchedulerSupport("none")
    public static final <T, R> Observable<R> combineLatest(@NotNull Iterable<? extends Observable<T>> iterable, @NotNull Function1<? super List<? extends T>, ? extends R> function1) {
        Intrinsics.checkParameterIsNotNull(iterable, "$this$combineLatest");
        Intrinsics.checkParameterIsNotNull(function1, "combineFunction");
        Observable<R> combineLatest = Observable.combineLatest(iterable, new ObservableKt$combineLatest$1(function1));
        Intrinsics.checkExpressionValueIsNotNull(combineLatest, "Observable.combineLatest…List().map { it as T }) }");
        return combineLatest;
    }

    @CheckReturnValue
    @NotNull
    @SchedulerSupport("none")
    public static final <T> Observable<T> concatAll(@NotNull Observable<Observable<T>> observable) {
        Intrinsics.checkParameterIsNotNull(observable, "$this$concatAll");
        Observable<R> concatMap = observable.concatMap(ObservableKt$concatAll$1.INSTANCE);
        Intrinsics.checkExpressionValueIsNotNull(concatMap, "concatMap { it }");
        return concatMap;
    }

    @CheckReturnValue
    @NotNull
    @SchedulerSupport("none")
    public static final <T> Observable<T> concatMapIterable(@NotNull Observable<? extends Iterable<? extends T>> observable) {
        Intrinsics.checkParameterIsNotNull(observable, "$this$concatMapIterable");
        Observable<U> concatMapIterable = observable.concatMapIterable(ObservableKt$concatMapIterable$1.INSTANCE);
        Intrinsics.checkExpressionValueIsNotNull(concatMapIterable, "concatMapIterable { it }");
        return concatMapIterable;
    }

    @CheckReturnValue
    @NotNull
    @SchedulerSupport("none")
    public static final <T> Observable<T> flatMapIterable(@NotNull Observable<? extends Iterable<? extends T>> observable) {
        Intrinsics.checkParameterIsNotNull(observable, "$this$flatMapIterable");
        Observable<U> flatMapIterable = observable.flatMapIterable(ObservableKt$flatMapIterable$1.INSTANCE);
        Intrinsics.checkExpressionValueIsNotNull(flatMapIterable, "flatMapIterable { it }");
        return flatMapIterable;
    }

    @CheckReturnValue
    @NotNull
    @SchedulerSupport("none")
    public static final <T, R> Observable<R> flatMapSequence(@NotNull Observable<T> observable, @NotNull Function1<? super T, ? extends Sequence<? extends R>> function1) {
        Intrinsics.checkParameterIsNotNull(observable, "$this$flatMapSequence");
        Intrinsics.checkParameterIsNotNull(function1, "body");
        Observable<R> flatMap = observable.flatMap(new ObservableKt$flatMapSequence$1(function1));
        Intrinsics.checkExpressionValueIsNotNull(flatMap, "flatMap { body(it).toObservable() }");
        return flatMap;
    }

    @CheckReturnValue
    @NotNull
    @SchedulerSupport("none")
    public static final <T> Observable<T> merge(@NotNull Iterable<? extends Observable<? extends T>> iterable) {
        Intrinsics.checkParameterIsNotNull(iterable, "$this$merge");
        Observable<T> merge = Observable.merge(toObservable(iterable));
        Intrinsics.checkExpressionValueIsNotNull(merge, "Observable.merge(this.toObservable())");
        return merge;
    }

    @CheckReturnValue
    @NotNull
    @SchedulerSupport("none")
    public static final <T> Observable<T> mergeAll(@NotNull Observable<Observable<T>> observable) {
        Intrinsics.checkParameterIsNotNull(observable, "$this$mergeAll");
        Observable<R> flatMap = observable.flatMap(ObservableKt$mergeAll$1.INSTANCE);
        Intrinsics.checkExpressionValueIsNotNull(flatMap, "flatMap { it }");
        return flatMap;
    }

    @CheckReturnValue
    @NotNull
    @SchedulerSupport("none")
    public static final <T> Observable<T> mergeDelayError(@NotNull Iterable<? extends Observable<? extends T>> iterable) {
        Intrinsics.checkParameterIsNotNull(iterable, "$this$mergeDelayError");
        Observable<T> mergeDelayError = Observable.mergeDelayError(toObservable(iterable));
        Intrinsics.checkExpressionValueIsNotNull(mergeDelayError, "Observable.mergeDelayError(this.toObservable())");
        return mergeDelayError;
    }

    @CheckReturnValue
    @NotNull
    @SchedulerSupport("none")
    public static final /* synthetic */ <R> Observable<R> ofType(@NotNull Observable<?> observable) {
        Intrinsics.checkParameterIsNotNull(observable, "$this$ofType");
        Intrinsics.reifiedOperationMarker(4, "R");
        Observable<U> ofType = observable.ofType(Object.class);
        Intrinsics.checkExpressionValueIsNotNull(ofType, "ofType(R::class.java)");
        return ofType;
    }

    @CheckReturnValue
    @NotNull
    @SchedulerSupport("none")
    public static final <T> Observable<T> switchLatest(@NotNull Observable<Observable<T>> observable) {
        Intrinsics.checkParameterIsNotNull(observable, "$this$switchLatest");
        Observable<R> switchMap = observable.switchMap(ObservableKt$switchLatest$1.INSTANCE);
        Intrinsics.checkExpressionValueIsNotNull(switchMap, "switchMap { it }");
        return switchMap;
    }

    @CheckReturnValue
    @NotNull
    @SchedulerSupport("none")
    public static final <T> Observable<T> switchOnNext(@NotNull Observable<Observable<T>> observable) {
        Intrinsics.checkParameterIsNotNull(observable, "$this$switchOnNext");
        Observable<T> switchOnNext = Observable.switchOnNext(observable);
        Intrinsics.checkExpressionValueIsNotNull(switchOnNext, "Observable.switchOnNext(this)");
        return switchOnNext;
    }

    private static final <T> Iterable<T> toIterable(@NotNull Iterator<? extends T> it) {
        return new ObservableKt$toIterable$1(it);
    }

    @CheckReturnValue
    @NotNull
    @SchedulerSupport("none")
    public static final <A, B> Single<Map<A, B>> toMap(@NotNull Observable<Pair<A, B>> observable) {
        Intrinsics.checkParameterIsNotNull(observable, "$this$toMap");
        Single<Map<K, V>> map = observable.toMap(ObservableKt$toMap$1.INSTANCE, ObservableKt$toMap$2.INSTANCE);
        Intrinsics.checkExpressionValueIsNotNull(map, "toMap({ it.first }, { it.second })");
        return map;
    }

    @CheckReturnValue
    @NotNull
    @SchedulerSupport("none")
    public static final <A, B> Single<Map<A, Collection<B>>> toMultimap(@NotNull Observable<Pair<A, B>> observable) {
        Intrinsics.checkParameterIsNotNull(observable, "$this$toMultimap");
        Single<Map<K, Collection<V>>> multimap = observable.toMultimap(ObservableKt$toMultimap$1.INSTANCE, ObservableKt$toMultimap$2.INSTANCE);
        Intrinsics.checkExpressionValueIsNotNull(multimap, "toMultimap({ it.first }, { it.second })");
        return multimap;
    }

    @CheckReturnValue
    @NotNull
    @SchedulerSupport("none")
    public static final Observable<Boolean> toObservable(@NotNull boolean[] zArr) {
        Intrinsics.checkParameterIsNotNull(zArr, "$this$toObservable");
        return toObservable(ArraysKt___ArraysKt.asIterable(zArr));
    }

    @CheckReturnValue
    @NotNull
    @SchedulerSupport("none")
    public static final <T, R> Observable<R> zip(@NotNull Iterable<? extends Observable<T>> iterable, @NotNull Function1<? super List<? extends T>, ? extends R> function1) {
        Intrinsics.checkParameterIsNotNull(iterable, "$this$zip");
        Intrinsics.checkParameterIsNotNull(function1, "zipFunction");
        Observable<R> zip = Observable.zip(iterable, new ObservableKt$zip$1(function1));
        Intrinsics.checkExpressionValueIsNotNull(zip, "Observable.zip(this) { z…List().map { it as T }) }");
        return zip;
    }

    @CheckReturnValue
    @NotNull
    @SchedulerSupport("none")
    public static final <T> Observable<T> concatAll(@NotNull Iterable<? extends ObservableSource<T>> iterable) {
        Intrinsics.checkParameterIsNotNull(iterable, "$this$concatAll");
        Observable<T> concat = Observable.concat(iterable);
        Intrinsics.checkExpressionValueIsNotNull(concat, "Observable.concat(this)");
        return concat;
    }

    @CheckReturnValue
    @NotNull
    @SchedulerSupport("none")
    public static final Observable<Byte> toObservable(@NotNull byte[] bArr) {
        Intrinsics.checkParameterIsNotNull(bArr, "$this$toObservable");
        return toObservable(ArraysKt___ArraysKt.asIterable(bArr));
    }

    @CheckReturnValue
    @NotNull
    @SchedulerSupport("none")
    public static final Observable<Character> toObservable(@NotNull char[] cArr) {
        Intrinsics.checkParameterIsNotNull(cArr, "$this$toObservable");
        return toObservable(ArraysKt___ArraysKt.asIterable(cArr));
    }

    @CheckReturnValue
    @NotNull
    @SchedulerSupport("none")
    public static final Observable<Short> toObservable(@NotNull short[] sArr) {
        Intrinsics.checkParameterIsNotNull(sArr, "$this$toObservable");
        return toObservable(ArraysKt___ArraysKt.asIterable(sArr));
    }

    @CheckReturnValue
    @NotNull
    @SchedulerSupport("none")
    public static final Observable<Integer> toObservable(@NotNull int[] iArr) {
        Intrinsics.checkParameterIsNotNull(iArr, "$this$toObservable");
        return toObservable(ArraysKt___ArraysKt.asIterable(iArr));
    }

    @CheckReturnValue
    @NotNull
    @SchedulerSupport("none")
    public static final Observable<Long> toObservable(@NotNull long[] jArr) {
        Intrinsics.checkParameterIsNotNull(jArr, "$this$toObservable");
        return toObservable(ArraysKt___ArraysKt.asIterable(jArr));
    }

    @CheckReturnValue
    @NotNull
    @SchedulerSupport("none")
    public static final Observable<Float> toObservable(@NotNull float[] fArr) {
        Intrinsics.checkParameterIsNotNull(fArr, "$this$toObservable");
        return toObservable(ArraysKt___ArraysKt.asIterable(fArr));
    }

    @CheckReturnValue
    @NotNull
    @SchedulerSupport("none")
    public static final Observable<Double> toObservable(@NotNull double[] dArr) {
        Intrinsics.checkParameterIsNotNull(dArr, "$this$toObservable");
        return toObservable(ArraysKt___ArraysKt.asIterable(dArr));
    }

    @CheckReturnValue
    @NotNull
    @SchedulerSupport("none")
    public static final <T> Observable<T> toObservable(@NotNull T[] tArr) {
        Intrinsics.checkParameterIsNotNull(tArr, "$this$toObservable");
        Observable<T> fromArray = Observable.fromArray(Arrays.copyOf(tArr, tArr.length));
        Intrinsics.checkExpressionValueIsNotNull(fromArray, "Observable.fromArray(*this)");
        return fromArray;
    }

    @CheckReturnValue
    @NotNull
    @SchedulerSupport("none")
    public static final Observable<Integer> toObservable(@NotNull IntProgression intProgression) {
        Intrinsics.checkParameterIsNotNull(intProgression, "$this$toObservable");
        if (intProgression.getStep() != 1 || ((long) intProgression.getLast()) - ((long) intProgression.getFirst()) >= ((long) Integer.MAX_VALUE)) {
            Observable<Integer> fromIterable = Observable.fromIterable(intProgression);
            Intrinsics.checkExpressionValueIsNotNull(fromIterable, "Observable.fromIterable(this)");
            return fromIterable;
        }
        Observable<Integer> range = Observable.range(intProgression.getFirst(), Math.max(0, (intProgression.getLast() - intProgression.getFirst()) + 1));
        Intrinsics.checkExpressionValueIsNotNull(range, "Observable.range(first, …max(0, last - first + 1))");
        return range;
    }

    @CheckReturnValue
    @NotNull
    @SchedulerSupport("none")
    public static final <T> Observable<T> toObservable(@NotNull Iterator<? extends T> it) {
        Intrinsics.checkParameterIsNotNull(it, "$this$toObservable");
        return toObservable(toIterable(it));
    }

    @CheckReturnValue
    @NotNull
    @SchedulerSupport("none")
    public static final <T> Observable<T> toObservable(@NotNull Iterable<? extends T> iterable) {
        Intrinsics.checkParameterIsNotNull(iterable, "$this$toObservable");
        Observable<T> fromIterable = Observable.fromIterable(iterable);
        Intrinsics.checkExpressionValueIsNotNull(fromIterable, "Observable.fromIterable(this)");
        return fromIterable;
    }

    @CheckReturnValue
    @NotNull
    @SchedulerSupport("none")
    public static final <T> Observable<T> toObservable(@NotNull Sequence<? extends T> sequence) {
        Intrinsics.checkParameterIsNotNull(sequence, "$this$toObservable");
        return toObservable(SequencesKt___SequencesKt.asIterable(sequence));
    }
}
