package io.reactivex.rxkotlin;

import io.reactivex.Flowable;
import io.reactivex.Single;
import io.reactivex.annotations.BackpressureKind;
import io.reactivex.annotations.BackpressureSupport;
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
import org.reactivestreams.Publisher;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000ª\u0001\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u001c\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u0011\n\u0000\n\u0002\u0010\u000b\n\u0002\u0010\u0018\n\u0002\u0010\u0005\n\u0002\u0010\u0012\n\u0002\u0010\f\n\u0002\u0010\u0019\n\u0002\u0010\u0006\n\u0002\u0010\u0013\n\u0002\u0010\u0007\n\u0002\u0010\u0014\n\u0002\u0010\b\n\u0002\u0010\u0015\n\u0002\u0010\t\n\u0002\u0010\u0016\n\u0002\u0010\n\n\u0002\u0010\u0017\n\u0002\u0010(\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010%\n\u0002\b\u0003\n\u0002\u0010\u001f\n\u0002\b\u0003\u001a#\u0010\u0000\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\n\b\u0000\u0010\u0002\u0018\u0001*\u00020\u0003*\u0006\u0012\u0002\b\u00030\u0001H\b\u001aF\u0010\u0004\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u0002H\u0006\u0012\u0004\u0012\u0002H\u00020\u00050\u0001\"\b\b\u0000\u0010\u0006*\u00020\u0003\"\b\b\u0001\u0010\u0002*\u00020\u0003*\b\u0012\u0004\u0012\u0002H\u00060\u00012\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0001H\u0007\u001ad\u0010\u0004\u001a\u001a\u0012\u0016\u0012\u0014\u0012\u0004\u0012\u0002H\u0006\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\t0\b0\u0001\"\b\b\u0000\u0010\u0006*\u00020\u0003\"\b\b\u0001\u0010\u0002*\u00020\u0003\"\b\b\u0002\u0010\t*\u00020\u0003*\b\u0012\u0004\u0012\u0002H\u00060\u00012\f\u0010\n\u001a\b\u0012\u0004\u0012\u0002H\u00020\u00012\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u0002H\t0\u0001H\u0007\u001a^\u0010\u0004\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\b\b\u0000\u0010\u0006*\u00020\u0003\"\b\b\u0001\u0010\u0002*\u00020\u0003*\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00060\u00010\f2)\b\u0004\u0010\r\u001a#\u0012\u0019\u0012\u0017\u0012\u0004\u0012\u0002H\u00060\u000f¢\u0006\f\b\u0010\u0012\b\b\u0011\u0012\u0004\b\b(\u0012\u0012\u0004\u0012\u0002H\u00020\u000eH\b\u001a(\u0010\u0013\u001a\b\u0012\u0004\u0012\u0002H\u00060\u0001\"\b\b\u0000\u0010\u0006*\u00020\u0003*\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00060\u00010\u0001H\u0007\u001a(\u0010\u0013\u001a\b\u0012\u0004\u0012\u0002H\u00060\u0001\"\b\b\u0000\u0010\u0006*\u00020\u0003*\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00060\u00140\fH\u0007\u001aI\u0010\u0015\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\b\b\u0000\u0010\u0006*\u00020\u0003\"\b\b\u0001\u0010\u0002*\u00020\u0003*\b\u0012\u0004\u0012\u0002H\u00060\u00012\u001a\b\u0004\u0010\u0016\u001a\u0014\u0012\u0004\u0012\u0002H\u0006\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00020\u00170\u000eH\b\u001a*\u0010\u0018\u001a\b\u0012\u0004\u0012\u0002H\u00060\u0001\"\b\b\u0000\u0010\u0006*\u00020\u0003*\u0010\u0012\f\u0012\n\u0012\u0006\b\u0001\u0012\u0002H\u00060\u00010\fH\u0007\u001a(\u0010\u0019\u001a\b\u0012\u0004\u0012\u0002H\u00060\u0001\"\b\b\u0000\u0010\u0006*\u00020\u0003*\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00060\u00010\u0001H\u0007\u001a*\u0010\u001a\u001a\b\u0012\u0004\u0012\u0002H\u00060\u0001\"\b\b\u0000\u0010\u0006*\u00020\u0003*\u0010\u0012\f\u0012\n\u0012\u0006\b\u0001\u0012\u0002H\u00060\u00010\fH\u0007\u001a#\u0010\u001b\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\n\b\u0000\u0010\u0002\u0018\u0001*\u00020\u0003*\u0006\u0012\u0002\b\u00030\u0001H\b\u001a(\u0010\u001c\u001a\b\u0012\u0004\u0012\u0002H\u00060\u0001\"\b\b\u0000\u0010\u0006*\u00020\u0003*\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00060\u00010\u0001H\u0007\u001a(\u0010\u001d\u001a\b\u0012\u0004\u0012\u0002H\u00060\u0001\"\b\b\u0000\u0010\u0006*\u00020\u0003*\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00060\u00010\u0001H\u0007\u001a'\u0010\u001e\u001a\b\u0012\u0004\u0012\u0002H\u00060\u0001\"\b\b\u0000\u0010\u0006*\u00020\u0003*\b\u0012\u0004\u0012\u0002H\u00060\u001fH\u0007¢\u0006\u0002\u0010 \u001a\u0012\u0010\u001e\u001a\b\u0012\u0004\u0012\u00020!0\u0001*\u00020\"H\u0007\u001a\u0012\u0010\u001e\u001a\b\u0012\u0004\u0012\u00020#0\u0001*\u00020$H\u0007\u001a\u0012\u0010\u001e\u001a\b\u0012\u0004\u0012\u00020%0\u0001*\u00020&H\u0007\u001a\u0012\u0010\u001e\u001a\b\u0012\u0004\u0012\u00020'0\u0001*\u00020(H\u0007\u001a\u0012\u0010\u001e\u001a\b\u0012\u0004\u0012\u00020)0\u0001*\u00020*H\u0007\u001a\u0012\u0010\u001e\u001a\b\u0012\u0004\u0012\u00020+0\u0001*\u00020,H\u0007\u001a\u0012\u0010\u001e\u001a\b\u0012\u0004\u0012\u00020-0\u0001*\u00020.H\u0007\u001a\u0012\u0010\u001e\u001a\b\u0012\u0004\u0012\u00020/0\u0001*\u000200H\u0007\u001a\"\u0010\u001e\u001a\b\u0012\u0004\u0012\u0002H\u00060\u0001\"\b\b\u0000\u0010\u0006*\u00020\u0003*\b\u0012\u0004\u0012\u0002H\u00060\fH\u0007\u001a \u0010\u001e\u001a\b\u0012\u0004\u0012\u0002H\u00060\u0001\"\b\b\u0000\u0010\u0006*\u00020\u0003*\b\u0012\u0004\u0012\u0002H\u000601\u001a\u0012\u0010\u001e\u001a\b\u0012\u0004\u0012\u00020+0\u0001*\u000202H\u0007\u001a \u0010\u001e\u001a\b\u0012\u0004\u0012\u0002H\u00060\u0001\"\b\b\u0000\u0010\u0006*\u00020\u0003*\b\u0012\u0004\u0012\u0002H\u00060\u0017\u001a\"\u00103\u001a\b\u0012\u0004\u0012\u0002H\u00060\f\"\b\b\u0000\u0010\u0006*\u00020\u0003*\b\u0012\u0004\u0012\u0002H\u000601H\u0002\u001aD\u00104\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u0002H7\u0012\u0004\u0012\u0002H80605\"\b\b\u0000\u00107*\u00020\u0003\"\b\b\u0001\u00108*\u00020\u0003*\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u0002H7\u0012\u0004\u0012\u0002H80\u00050\u0001H\u0007\u001aJ\u00109\u001a\u001a\u0012\u0016\u0012\u0014\u0012\u0004\u0012\u0002H7\u0012\n\u0012\b\u0012\u0004\u0012\u0002H80:0605\"\b\b\u0000\u00107*\u00020\u0003\"\b\b\u0001\u00108*\u00020\u0003*\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u0002H7\u0012\u0004\u0012\u0002H80\u00050\u0001H\u0007\u001a^\u0010;\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\b\b\u0000\u0010\u0006*\u00020\u0003\"\b\b\u0001\u0010\u0002*\u00020\u0003*\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00060\u00010\f2)\b\u0004\u0010<\u001a#\u0012\u0019\u0012\u0017\u0012\u0004\u0012\u0002H\u00060\u000f¢\u0006\f\b\u0010\u0012\b\b\u0011\u0012\u0004\b\b(\u0012\u0012\u0004\u0012\u0002H\u00020\u000eH\b¨\u0006="}, d2 = {"cast", "Lio/reactivex/Flowable;", "R", "", "combineLatest", "Lkotlin/Pair;", "T", "flowable", "Lkotlin/Triple;", "U", "flowable1", "flowable2", "", "combineFunction", "Lkotlin/Function1;", "", "Lkotlin/ParameterName;", "name", "args", "concatAll", "Lorg/reactivestreams/Publisher;", "flatMapSequence", "body", "Lkotlin/sequences/Sequence;", "merge", "mergeAll", "mergeDelayError", "ofType", "switchLatest", "switchOnNext", "toFlowable", "", "([Ljava/lang/Object;)Lio/reactivex/Flowable;", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "Lkotlin/ranges/IntProgression;", "toIterable", "toMap", "Lio/reactivex/Single;", "", "A", "B", "toMultimap", "", "zip", "zipFunction", "rxkotlin"}, k = 2, mv = {1, 1, 15})
public final class FlowableKt {
    @CheckReturnValue
    @BackpressureSupport(BackpressureKind.PASS_THROUGH)
    @NotNull
    @SchedulerSupport("none")
    public static final /* synthetic */ <R> Flowable<R> cast(@NotNull Flowable<?> flowable) {
        Intrinsics.checkParameterIsNotNull(flowable, "$this$cast");
        Intrinsics.reifiedOperationMarker(4, "R");
        Flowable<U> cast = flowable.cast(Object.class);
        Intrinsics.checkExpressionValueIsNotNull(cast, "cast(R::class.java)");
        return cast;
    }

    @CheckReturnValue
    @BackpressureSupport(BackpressureKind.FULL)
    @NotNull
    @SchedulerSupport("none")
    public static final <T, R> Flowable<R> combineLatest(@NotNull Iterable<? extends Flowable<T>> iterable, @NotNull Function1<? super List<? extends T>, ? extends R> function1) {
        Intrinsics.checkParameterIsNotNull(iterable, "$this$combineLatest");
        Intrinsics.checkParameterIsNotNull(function1, "combineFunction");
        Flowable<R> combineLatest = Flowable.combineLatest(iterable, new FlowableKt$combineLatest$1(function1));
        Intrinsics.checkExpressionValueIsNotNull(combineLatest, "Flowable.combineLatest(t…List().map { it as T }) }");
        return combineLatest;
    }

    @CheckReturnValue
    @BackpressureSupport(BackpressureKind.FULL)
    @NotNull
    @SchedulerSupport("none")
    public static final <T> Flowable<T> concatAll(@NotNull Flowable<Flowable<T>> flowable) {
        Intrinsics.checkParameterIsNotNull(flowable, "$this$concatAll");
        Flowable<R> concatMap = flowable.concatMap(FlowableKt$concatAll$1.INSTANCE);
        Intrinsics.checkExpressionValueIsNotNull(concatMap, "concatMap { it }");
        return concatMap;
    }

    @CheckReturnValue
    @BackpressureSupport(BackpressureKind.FULL)
    @NotNull
    @SchedulerSupport("none")
    public static final <T, R> Flowable<R> flatMapSequence(@NotNull Flowable<T> flowable, @NotNull Function1<? super T, ? extends Sequence<? extends R>> function1) {
        Intrinsics.checkParameterIsNotNull(flowable, "$this$flatMapSequence");
        Intrinsics.checkParameterIsNotNull(function1, "body");
        Flowable<R> flatMap = flowable.flatMap(new FlowableKt$flatMapSequence$1(function1));
        Intrinsics.checkExpressionValueIsNotNull(flatMap, "flatMap { body(it).toFlowable() }");
        return flatMap;
    }

    @CheckReturnValue
    @BackpressureSupport(BackpressureKind.FULL)
    @NotNull
    @SchedulerSupport("none")
    public static final <T> Flowable<T> merge(@NotNull Iterable<? extends Flowable<? extends T>> iterable) {
        Intrinsics.checkParameterIsNotNull(iterable, "$this$merge");
        Flowable<T> merge = Flowable.merge(toFlowable(iterable));
        Intrinsics.checkExpressionValueIsNotNull(merge, "Flowable.merge(this.toFlowable())");
        return merge;
    }

    @CheckReturnValue
    @BackpressureSupport(BackpressureKind.FULL)
    @NotNull
    @SchedulerSupport("none")
    public static final <T> Flowable<T> mergeAll(@NotNull Flowable<Flowable<T>> flowable) {
        Intrinsics.checkParameterIsNotNull(flowable, "$this$mergeAll");
        Flowable<R> flatMap = flowable.flatMap(FlowableKt$mergeAll$1.INSTANCE);
        Intrinsics.checkExpressionValueIsNotNull(flatMap, "flatMap { it }");
        return flatMap;
    }

    @CheckReturnValue
    @BackpressureSupport(BackpressureKind.FULL)
    @NotNull
    @SchedulerSupport("none")
    public static final <T> Flowable<T> mergeDelayError(@NotNull Iterable<? extends Flowable<? extends T>> iterable) {
        Intrinsics.checkParameterIsNotNull(iterable, "$this$mergeDelayError");
        Flowable<T> mergeDelayError = Flowable.mergeDelayError(toFlowable(iterable));
        Intrinsics.checkExpressionValueIsNotNull(mergeDelayError, "Flowable.mergeDelayError(this.toFlowable())");
        return mergeDelayError;
    }

    @CheckReturnValue
    @BackpressureSupport(BackpressureKind.PASS_THROUGH)
    @NotNull
    @SchedulerSupport("none")
    public static final /* synthetic */ <R> Flowable<R> ofType(@NotNull Flowable<?> flowable) {
        Intrinsics.checkParameterIsNotNull(flowable, "$this$ofType");
        Intrinsics.reifiedOperationMarker(4, "R");
        Flowable<U> ofType = flowable.ofType(Object.class);
        Intrinsics.checkExpressionValueIsNotNull(ofType, "ofType(R::class.java)");
        return ofType;
    }

    @CheckReturnValue
    @BackpressureSupport(BackpressureKind.FULL)
    @NotNull
    @SchedulerSupport("none")
    public static final <T> Flowable<T> switchLatest(@NotNull Flowable<Flowable<T>> flowable) {
        Intrinsics.checkParameterIsNotNull(flowable, "$this$switchLatest");
        Flowable<R> switchMap = flowable.switchMap(FlowableKt$switchLatest$1.INSTANCE);
        Intrinsics.checkExpressionValueIsNotNull(switchMap, "switchMap { it }");
        return switchMap;
    }

    @CheckReturnValue
    @BackpressureSupport(BackpressureKind.FULL)
    @NotNull
    @SchedulerSupport("none")
    public static final <T> Flowable<T> switchOnNext(@NotNull Flowable<Flowable<T>> flowable) {
        Intrinsics.checkParameterIsNotNull(flowable, "$this$switchOnNext");
        Flowable<T> switchOnNext = Flowable.switchOnNext(flowable);
        Intrinsics.checkExpressionValueIsNotNull(switchOnNext, "Flowable.switchOnNext(this)");
        return switchOnNext;
    }

    @CheckReturnValue
    @NotNull
    public static final Flowable<Boolean> toFlowable(@NotNull boolean[] zArr) {
        Intrinsics.checkParameterIsNotNull(zArr, "$this$toFlowable");
        return toFlowable(ArraysKt___ArraysKt.asIterable(zArr));
    }

    private static final <T> Iterable<T> toIterable(@NotNull Iterator<? extends T> it) {
        return new FlowableKt$toIterable$1(it);
    }

    @CheckReturnValue
    @BackpressureSupport(BackpressureKind.UNBOUNDED_IN)
    @NotNull
    @SchedulerSupport("none")
    public static final <A, B> Single<Map<A, B>> toMap(@NotNull Flowable<Pair<A, B>> flowable) {
        Intrinsics.checkParameterIsNotNull(flowable, "$this$toMap");
        Single<Map<K, V>> map = flowable.toMap(FlowableKt$toMap$1.INSTANCE, FlowableKt$toMap$2.INSTANCE);
        Intrinsics.checkExpressionValueIsNotNull(map, "toMap({ it.first }, { it.second })");
        return map;
    }

    @CheckReturnValue
    @BackpressureSupport(BackpressureKind.UNBOUNDED_IN)
    @NotNull
    @SchedulerSupport("none")
    public static final <A, B> Single<Map<A, Collection<B>>> toMultimap(@NotNull Flowable<Pair<A, B>> flowable) {
        Intrinsics.checkParameterIsNotNull(flowable, "$this$toMultimap");
        Single<Map<K, Collection<V>>> multimap = flowable.toMultimap(FlowableKt$toMultimap$1.INSTANCE, FlowableKt$toMultimap$2.INSTANCE);
        Intrinsics.checkExpressionValueIsNotNull(multimap, "toMultimap({ it.first }, { it.second })");
        return multimap;
    }

    @CheckReturnValue
    @BackpressureSupport(BackpressureKind.FULL)
    @NotNull
    @SchedulerSupport("none")
    public static final <T, R> Flowable<R> zip(@NotNull Iterable<? extends Flowable<T>> iterable, @NotNull Function1<? super List<? extends T>, ? extends R> function1) {
        Intrinsics.checkParameterIsNotNull(iterable, "$this$zip");
        Intrinsics.checkParameterIsNotNull(function1, "zipFunction");
        Flowable<R> zip = Flowable.zip(iterable, new FlowableKt$zip$1(function1));
        Intrinsics.checkExpressionValueIsNotNull(zip, "Flowable.zip(this) { zip…List().map { it as T }) }");
        return zip;
    }

    /* JADX WARNING: type inference failed for: r1v0, types: [io.reactivex.rxkotlin.FlowableKt$sam$io_reactivex_functions_BiFunction$0] */
    /* JADX WARNING: Multi-variable type inference failed */
    @io.reactivex.annotations.CheckReturnValue
    @io.reactivex.annotations.BackpressureSupport(io.reactivex.annotations.BackpressureKind.FULL)
    @org.jetbrains.annotations.NotNull
    @io.reactivex.annotations.SchedulerSupport("none")
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final <T, R> io.reactivex.Flowable<kotlin.Pair<T, R>> combineLatest(@org.jetbrains.annotations.NotNull io.reactivex.Flowable<T> r2, @org.jetbrains.annotations.NotNull io.reactivex.Flowable<R> r3) {
        /*
            java.lang.String r0 = "$this$combineLatest"
            kotlin.jvm.internal.Intrinsics.checkParameterIsNotNull(r2, r0)
            java.lang.String r0 = "flowable"
            kotlin.jvm.internal.Intrinsics.checkParameterIsNotNull(r3, r0)
            io.reactivex.rxkotlin.FlowableKt$combineLatest$2 r0 = io.reactivex.rxkotlin.FlowableKt$combineLatest$2.INSTANCE
            if (r0 == 0) goto L_0x0014
            io.reactivex.rxkotlin.FlowableKt$sam$io_reactivex_functions_BiFunction$0 r1 = new io.reactivex.rxkotlin.FlowableKt$sam$io_reactivex_functions_BiFunction$0
            r1.<init>(r0)
            r0 = r1
        L_0x0014:
            io.reactivex.functions.BiFunction r0 = (io.reactivex.functions.BiFunction) r0
            io.reactivex.Flowable r2 = io.reactivex.Flowable.combineLatest(r2, r3, r0)
            java.lang.String r3 = "Flowable.combineLatest(t…able, BiFunction(::Pair))"
            kotlin.jvm.internal.Intrinsics.checkExpressionValueIsNotNull(r2, r3)
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: io.reactivex.rxkotlin.FlowableKt.combineLatest(io.reactivex.Flowable, io.reactivex.Flowable):io.reactivex.Flowable");
    }

    @CheckReturnValue
    @BackpressureSupport(BackpressureKind.FULL)
    @NotNull
    @SchedulerSupport("none")
    public static final <T> Flowable<T> concatAll(@NotNull Iterable<? extends Publisher<T>> iterable) {
        Intrinsics.checkParameterIsNotNull(iterable, "$this$concatAll");
        Flowable<T> concat = Flowable.concat(iterable);
        Intrinsics.checkExpressionValueIsNotNull(concat, "Flowable.concat(this)");
        return concat;
    }

    @CheckReturnValue
    @NotNull
    public static final Flowable<Byte> toFlowable(@NotNull byte[] bArr) {
        Intrinsics.checkParameterIsNotNull(bArr, "$this$toFlowable");
        return toFlowable(ArraysKt___ArraysKt.asIterable(bArr));
    }

    /* JADX WARNING: type inference failed for: r1v0, types: [io.reactivex.rxkotlin.FlowableKt$sam$io_reactivex_functions_Function3$0] */
    /* JADX WARNING: Multi-variable type inference failed */
    @io.reactivex.annotations.CheckReturnValue
    @io.reactivex.annotations.BackpressureSupport(io.reactivex.annotations.BackpressureKind.FULL)
    @org.jetbrains.annotations.NotNull
    @io.reactivex.annotations.SchedulerSupport("none")
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final <T, R, U> io.reactivex.Flowable<kotlin.Triple<T, R, U>> combineLatest(@org.jetbrains.annotations.NotNull io.reactivex.Flowable<T> r2, @org.jetbrains.annotations.NotNull io.reactivex.Flowable<R> r3, @org.jetbrains.annotations.NotNull io.reactivex.Flowable<U> r4) {
        /*
            java.lang.String r0 = "$this$combineLatest"
            kotlin.jvm.internal.Intrinsics.checkParameterIsNotNull(r2, r0)
            java.lang.String r0 = "flowable1"
            kotlin.jvm.internal.Intrinsics.checkParameterIsNotNull(r3, r0)
            java.lang.String r0 = "flowable2"
            kotlin.jvm.internal.Intrinsics.checkParameterIsNotNull(r4, r0)
            io.reactivex.rxkotlin.FlowableKt$combineLatest$3 r0 = io.reactivex.rxkotlin.FlowableKt$combineLatest$3.INSTANCE
            if (r0 == 0) goto L_0x0019
            io.reactivex.rxkotlin.FlowableKt$sam$io_reactivex_functions_Function3$0 r1 = new io.reactivex.rxkotlin.FlowableKt$sam$io_reactivex_functions_Function3$0
            r1.<init>(r0)
            r0 = r1
        L_0x0019:
            io.reactivex.functions.Function3 r0 = (io.reactivex.functions.Function3) r0
            io.reactivex.Flowable r2 = io.reactivex.Flowable.combineLatest(r2, r3, r4, r0)
            java.lang.String r3 = "Flowable.combineLatest(t…le2, Function3(::Triple))"
            kotlin.jvm.internal.Intrinsics.checkExpressionValueIsNotNull(r2, r3)
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: io.reactivex.rxkotlin.FlowableKt.combineLatest(io.reactivex.Flowable, io.reactivex.Flowable, io.reactivex.Flowable):io.reactivex.Flowable");
    }

    @CheckReturnValue
    @NotNull
    public static final Flowable<Character> toFlowable(@NotNull char[] cArr) {
        Intrinsics.checkParameterIsNotNull(cArr, "$this$toFlowable");
        return toFlowable(ArraysKt___ArraysKt.asIterable(cArr));
    }

    @CheckReturnValue
    @NotNull
    public static final Flowable<Short> toFlowable(@NotNull short[] sArr) {
        Intrinsics.checkParameterIsNotNull(sArr, "$this$toFlowable");
        return toFlowable(ArraysKt___ArraysKt.asIterable(sArr));
    }

    @CheckReturnValue
    @NotNull
    public static final Flowable<Integer> toFlowable(@NotNull int[] iArr) {
        Intrinsics.checkParameterIsNotNull(iArr, "$this$toFlowable");
        return toFlowable(ArraysKt___ArraysKt.asIterable(iArr));
    }

    @CheckReturnValue
    @NotNull
    public static final Flowable<Long> toFlowable(@NotNull long[] jArr) {
        Intrinsics.checkParameterIsNotNull(jArr, "$this$toFlowable");
        return toFlowable(ArraysKt___ArraysKt.asIterable(jArr));
    }

    @CheckReturnValue
    @NotNull
    public static final Flowable<Float> toFlowable(@NotNull float[] fArr) {
        Intrinsics.checkParameterIsNotNull(fArr, "$this$toFlowable");
        return toFlowable(ArraysKt___ArraysKt.asIterable(fArr));
    }

    @CheckReturnValue
    @NotNull
    public static final Flowable<Double> toFlowable(@NotNull double[] dArr) {
        Intrinsics.checkParameterIsNotNull(dArr, "$this$toFlowable");
        return toFlowable(ArraysKt___ArraysKt.asIterable(dArr));
    }

    @CheckReturnValue
    @BackpressureSupport(BackpressureKind.FULL)
    @NotNull
    @SchedulerSupport("none")
    public static final <T> Flowable<T> toFlowable(@NotNull T[] tArr) {
        Intrinsics.checkParameterIsNotNull(tArr, "$this$toFlowable");
        Flowable<T> fromArray = Flowable.fromArray(Arrays.copyOf(tArr, tArr.length));
        Intrinsics.checkExpressionValueIsNotNull(fromArray, "Flowable.fromArray(*this)");
        return fromArray;
    }

    @CheckReturnValue
    @BackpressureSupport(BackpressureKind.FULL)
    @NotNull
    @SchedulerSupport("none")
    public static final Flowable<Integer> toFlowable(@NotNull IntProgression intProgression) {
        Intrinsics.checkParameterIsNotNull(intProgression, "$this$toFlowable");
        if (intProgression.getStep() != 1 || ((long) intProgression.getLast()) - ((long) intProgression.getFirst()) >= ((long) Integer.MAX_VALUE)) {
            Flowable<Integer> fromIterable = Flowable.fromIterable(intProgression);
            Intrinsics.checkExpressionValueIsNotNull(fromIterable, "Flowable.fromIterable(this)");
            return fromIterable;
        }
        Flowable<Integer> range = Flowable.range(intProgression.getFirst(), Math.max(0, (intProgression.getLast() - intProgression.getFirst()) + 1));
        Intrinsics.checkExpressionValueIsNotNull(range, "Flowable.range(first, Ma…max(0, last - first + 1))");
        return range;
    }

    @NotNull
    public static final <T> Flowable<T> toFlowable(@NotNull Iterator<? extends T> it) {
        Intrinsics.checkParameterIsNotNull(it, "$this$toFlowable");
        return toFlowable(toIterable(it));
    }

    @CheckReturnValue
    @BackpressureSupport(BackpressureKind.FULL)
    @NotNull
    @SchedulerSupport("none")
    public static final <T> Flowable<T> toFlowable(@NotNull Iterable<? extends T> iterable) {
        Intrinsics.checkParameterIsNotNull(iterable, "$this$toFlowable");
        Flowable<T> fromIterable = Flowable.fromIterable(iterable);
        Intrinsics.checkExpressionValueIsNotNull(fromIterable, "Flowable.fromIterable(this)");
        return fromIterable;
    }

    @NotNull
    public static final <T> Flowable<T> toFlowable(@NotNull Sequence<? extends T> sequence) {
        Intrinsics.checkParameterIsNotNull(sequence, "$this$toFlowable");
        return toFlowable(SequencesKt___SequencesKt.asIterable(sequence));
    }
}
