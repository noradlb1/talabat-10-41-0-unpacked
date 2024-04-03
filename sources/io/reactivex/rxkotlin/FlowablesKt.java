package io.reactivex.rxkotlin;

import io.reactivex.Flowable;
import io.reactivex.annotations.BackpressureKind;
import io.reactivex.annotations.BackpressureSupport;
import io.reactivex.annotations.CheckReturnValue;
import io.reactivex.annotations.SchedulerSupport;
import io.reactivex.functions.BiFunction;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Triple;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.functions.Function4;
import kotlin.jvm.functions.Function5;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.reactivestreams.Publisher;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000@\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u001ad\u0010\u0000\u001a\u001a\u0012\u0016\u0012\u0014\u0012\u0004\u0012\u0002H\u0003\u0012\u0004\u0012\u0002H\u0004\u0012\u0004\u0012\u0002H\u00050\u00020\u0001\"\b\b\u0000\u0010\u0003*\u00020\u0006\"\b\b\u0001\u0010\u0004*\u00020\u0006\"\b\b\u0002\u0010\u0005*\u00020\u0006*\b\u0012\u0004\u0012\u0002H\u00030\u00012\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u0002H\u00040\b2\f\u0010\t\u001a\b\u0012\u0004\u0012\u0002H\u00050\bH\u0007\u001a\u0010\u0000\u001a\b\u0012\u0004\u0012\u0002H\n0\u0001\"\b\b\u0000\u0010\u0003*\u00020\u0006\"\b\b\u0001\u0010\u0004*\u00020\u0006\"\b\b\u0002\u0010\u0005*\u00020\u0006\"\b\b\u0003\u0010\n*\u00020\u0006*\b\u0012\u0004\u0012\u0002H\u00030\u00012\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u0002H\u00040\b2\f\u0010\t\u001a\b\u0012\u0004\u0012\u0002H\u00050\b2 \b\u0004\u0010\u000b\u001a\u001a\u0012\u0004\u0012\u0002H\u0003\u0012\u0004\u0012\u0002H\u0004\u0012\u0004\u0012\u0002H\u0005\u0012\u0004\u0012\u0002H\n0\fH\b\u001a\u0001\u0010\u0000\u001a\b\u0012\u0004\u0012\u0002H\n0\u0001\"\b\b\u0000\u0010\u0003*\u00020\u0006\"\b\b\u0001\u0010\u0004*\u00020\u0006\"\b\b\u0002\u0010\u0005*\u00020\u0006\"\b\b\u0003\u0010\r*\u00020\u0006\"\b\b\u0004\u0010\n*\u00020\u0006*\b\u0012\u0004\u0012\u0002H\u00030\u00012\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u0002H\u00040\b2\f\u0010\t\u001a\b\u0012\u0004\u0012\u0002H\u00050\b2\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u0002H\r0\b2&\b\u0004\u0010\u000b\u001a \u0012\u0004\u0012\u0002H\u0003\u0012\u0004\u0012\u0002H\u0004\u0012\u0004\u0012\u0002H\u0005\u0012\u0004\u0012\u0002H\r\u0012\u0004\u0012\u0002H\n0\u000fH\b\u001a»\u0001\u0010\u0000\u001a\b\u0012\u0004\u0012\u0002H\n0\u0001\"\b\b\u0000\u0010\u0003*\u00020\u0006\"\b\b\u0001\u0010\u0004*\u00020\u0006\"\b\b\u0002\u0010\u0005*\u00020\u0006\"\b\b\u0003\u0010\r*\u00020\u0006\"\b\b\u0004\u0010\u0010*\u00020\u0006\"\b\b\u0005\u0010\n*\u00020\u0006*\b\u0012\u0004\u0012\u0002H\u00030\u00012\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u0002H\u00040\b2\f\u0010\t\u001a\b\u0012\u0004\u0012\u0002H\u00050\b2\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u0002H\r0\b2\f\u0010\u0011\u001a\b\u0012\u0004\u0012\u0002H\u00100\b2,\b\u0004\u0010\u000b\u001a&\u0012\u0004\u0012\u0002H\u0003\u0012\u0004\u0012\u0002H\u0004\u0012\u0004\u0012\u0002H\u0005\u0012\u0004\u0012\u0002H\r\u0012\u0004\u0012\u0002H\u0010\u0012\u0004\u0012\u0002H\n0\u0012H\b\u001aF\u0010\u0000\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u0002H\u0003\u0012\u0004\u0012\u0002H\u00140\u00130\u0001\"\b\b\u0000\u0010\u0003*\u00020\u0006\"\b\b\u0001\u0010\u0014*\u00020\u0006*\b\u0012\u0004\u0012\u0002H\u00030\u00012\f\u0010\u0015\u001a\b\u0012\u0004\u0012\u0002H\u00140\bH\u0007\u001aa\u0010\u0000\u001a\b\u0012\u0004\u0012\u0002H\n0\u0001\"\b\b\u0000\u0010\u0003*\u00020\u0006\"\b\b\u0001\u0010\u0014*\u00020\u0006\"\b\b\u0002\u0010\n*\u00020\u0006*\b\u0012\u0004\u0012\u0002H\u00030\u00012\f\u0010\u0015\u001a\b\u0012\u0004\u0012\u0002H\u00140\b2\u001a\b\u0004\u0010\u000b\u001a\u0014\u0012\u0004\u0012\u0002H\u0003\u0012\u0004\u0012\u0002H\u0014\u0012\u0004\u0012\u0002H\n0\u0016H\b\u001aF\u0010\u0017\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u0002H\u0003\u0012\u0004\u0012\u0002H\u00140\u00130\u0001\"\b\b\u0000\u0010\u0003*\u00020\u0006\"\b\b\u0001\u0010\u0014*\u00020\u0006*\b\u0012\u0004\u0012\u0002H\u00030\u00012\f\u0010\u0015\u001a\b\u0012\u0004\u0012\u0002H\u00140\bH\u0007\u001aa\u0010\u0017\u001a\b\u0012\u0004\u0012\u0002H\n0\u0001\"\b\b\u0000\u0010\u0003*\u00020\u0006\"\b\b\u0001\u0010\u0014*\u00020\u0006\"\b\b\u0002\u0010\n*\u00020\u0006*\b\u0012\u0004\u0012\u0002H\u00030\u00012\f\u0010\u0015\u001a\b\u0012\u0004\u0012\u0002H\u00140\b2\u001a\b\u0004\u0010\u0018\u001a\u0014\u0012\u0004\u0012\u0002H\u0003\u0012\u0004\u0012\u0002H\u0014\u0012\u0004\u0012\u0002H\n0\u0016H\b¨\u0006\u0019"}, d2 = {"withLatestFrom", "Lio/reactivex/Flowable;", "Lkotlin/Triple;", "T", "T1", "T2", "", "o1", "Lorg/reactivestreams/Publisher;", "o2", "R", "combiner", "Lkotlin/Function3;", "T3", "o3", "Lkotlin/Function4;", "T4", "o4", "Lkotlin/Function5;", "Lkotlin/Pair;", "U", "other", "Lkotlin/Function2;", "zipWith", "zipper", "rxkotlin"}, k = 2, mv = {1, 1, 15})
public final class FlowablesKt {
    @CheckReturnValue
    @BackpressureSupport(BackpressureKind.PASS_THROUGH)
    @NotNull
    @SchedulerSupport("none")
    public static final <T, U, R> Flowable<R> withLatestFrom(@NotNull Flowable<T> flowable, @NotNull Publisher<U> publisher, @NotNull Function2<? super T, ? super U, ? extends R> function2) {
        Intrinsics.checkParameterIsNotNull(flowable, "$this$withLatestFrom");
        Intrinsics.checkParameterIsNotNull(publisher, "other");
        Intrinsics.checkParameterIsNotNull(function2, "combiner");
        Flowable<R> withLatestFrom = flowable.withLatestFrom((Publisher<? extends U>) publisher, (BiFunction<? super T, ? super U, ? extends R>) new FlowablesKt$withLatestFrom$1(function2));
        Intrinsics.checkExpressionValueIsNotNull(withLatestFrom, "withLatestFrom(other, Bi… combiner.invoke(t, u) })");
        return withLatestFrom;
    }

    @CheckReturnValue
    @BackpressureSupport(BackpressureKind.PASS_THROUGH)
    @NotNull
    @SchedulerSupport("none")
    public static final <T, U, R> Flowable<R> zipWith(@NotNull Flowable<T> flowable, @NotNull Publisher<U> publisher, @NotNull Function2<? super T, ? super U, ? extends R> function2) {
        Intrinsics.checkParameterIsNotNull(flowable, "$this$zipWith");
        Intrinsics.checkParameterIsNotNull(publisher, "other");
        Intrinsics.checkParameterIsNotNull(function2, "zipper");
        Flowable<R> zipWith = flowable.zipWith((Publisher<? extends U>) publisher, (BiFunction<? super T, ? super U, ? extends R>) new FlowablesKt$zipWith$1(function2));
        Intrinsics.checkExpressionValueIsNotNull(zipWith, "zipWith(other, BiFunctio…-> zipper.invoke(t, u) })");
        return zipWith;
    }

    @CheckReturnValue
    @BackpressureSupport(BackpressureKind.PASS_THROUGH)
    @NotNull
    @SchedulerSupport("none")
    public static final <T, U> Flowable<Pair<T, U>> withLatestFrom(@NotNull Flowable<T> flowable, @NotNull Publisher<U> publisher) {
        Intrinsics.checkParameterIsNotNull(flowable, "$this$withLatestFrom");
        Intrinsics.checkParameterIsNotNull(publisher, "other");
        Flowable<R> withLatestFrom = flowable.withLatestFrom((Publisher<? extends U>) publisher, (BiFunction<? super T, ? super U, ? extends R>) FlowablesKt$withLatestFrom$2.INSTANCE);
        Intrinsics.checkExpressionValueIsNotNull(withLatestFrom, "withLatestFrom(other, Bi…n { t, u -> Pair(t, u) })");
        return withLatestFrom;
    }

    @CheckReturnValue
    @BackpressureSupport(BackpressureKind.FULL)
    @NotNull
    @SchedulerSupport("none")
    public static final <T, U> Flowable<Pair<T, U>> zipWith(@NotNull Flowable<T> flowable, @NotNull Publisher<U> publisher) {
        Intrinsics.checkParameterIsNotNull(flowable, "$this$zipWith");
        Intrinsics.checkParameterIsNotNull(publisher, "other");
        Flowable<R> zipWith = flowable.zipWith((Publisher<? extends U>) publisher, (BiFunction<? super T, ? super U, ? extends R>) FlowablesKt$zipWith$2.INSTANCE);
        Intrinsics.checkExpressionValueIsNotNull(zipWith, "zipWith(other, BiFunction { t, u -> Pair(t, u) })");
        return zipWith;
    }

    @CheckReturnValue
    @BackpressureSupport(BackpressureKind.PASS_THROUGH)
    @NotNull
    @SchedulerSupport("none")
    public static final <T, T1, T2, R> Flowable<R> withLatestFrom(@NotNull Flowable<T> flowable, @NotNull Publisher<T1> publisher, @NotNull Publisher<T2> publisher2, @NotNull Function3<? super T, ? super T1, ? super T2, ? extends R> function3) {
        Intrinsics.checkParameterIsNotNull(flowable, "$this$withLatestFrom");
        Intrinsics.checkParameterIsNotNull(publisher, "o1");
        Intrinsics.checkParameterIsNotNull(publisher2, "o2");
        Intrinsics.checkParameterIsNotNull(function3, "combiner");
        Flowable<R> withLatestFrom = flowable.withLatestFrom(publisher, publisher2, new FlowablesKt$withLatestFrom$3(function3));
        Intrinsics.checkExpressionValueIsNotNull(withLatestFrom, "withLatestFrom(o1, o2, F…iner.invoke(t, t1, t2) })");
        return withLatestFrom;
    }

    @CheckReturnValue
    @BackpressureSupport(BackpressureKind.PASS_THROUGH)
    @NotNull
    @SchedulerSupport("none")
    public static final <T, T1, T2> Flowable<Triple<T, T1, T2>> withLatestFrom(@NotNull Flowable<T> flowable, @NotNull Publisher<T1> publisher, @NotNull Publisher<T2> publisher2) {
        Intrinsics.checkParameterIsNotNull(flowable, "$this$withLatestFrom");
        Intrinsics.checkParameterIsNotNull(publisher, "o1");
        Intrinsics.checkParameterIsNotNull(publisher2, "o2");
        Flowable<R> withLatestFrom = flowable.withLatestFrom(publisher, publisher2, FlowablesKt$withLatestFrom$4.INSTANCE);
        Intrinsics.checkExpressionValueIsNotNull(withLatestFrom, "withLatestFrom(o1, o2, F…2 -> Triple(t, t1, t2) })");
        return withLatestFrom;
    }

    @CheckReturnValue
    @BackpressureSupport(BackpressureKind.PASS_THROUGH)
    @NotNull
    @SchedulerSupport("none")
    public static final <T, T1, T2, T3, R> Flowable<R> withLatestFrom(@NotNull Flowable<T> flowable, @NotNull Publisher<T1> publisher, @NotNull Publisher<T2> publisher2, @NotNull Publisher<T3> publisher3, @NotNull Function4<? super T, ? super T1, ? super T2, ? super T3, ? extends R> function4) {
        Intrinsics.checkParameterIsNotNull(flowable, "$this$withLatestFrom");
        Intrinsics.checkParameterIsNotNull(publisher, "o1");
        Intrinsics.checkParameterIsNotNull(publisher2, "o2");
        Intrinsics.checkParameterIsNotNull(publisher3, "o3");
        Intrinsics.checkParameterIsNotNull(function4, "combiner");
        Flowable<R> withLatestFrom = flowable.withLatestFrom(publisher, publisher2, publisher3, new FlowablesKt$withLatestFrom$5(function4));
        Intrinsics.checkExpressionValueIsNotNull(withLatestFrom, "withLatestFrom(o1, o2, o….invoke(t, t1, t2, t3) })");
        return withLatestFrom;
    }

    @CheckReturnValue
    @BackpressureSupport(BackpressureKind.FULL)
    @NotNull
    @SchedulerSupport("none")
    public static final <T, T1, T2, T3, T4, R> Flowable<R> withLatestFrom(@NotNull Flowable<T> flowable, @NotNull Publisher<T1> publisher, @NotNull Publisher<T2> publisher2, @NotNull Publisher<T3> publisher3, @NotNull Publisher<T4> publisher4, @NotNull Function5<? super T, ? super T1, ? super T2, ? super T3, ? super T4, ? extends R> function5) {
        Intrinsics.checkParameterIsNotNull(flowable, "$this$withLatestFrom");
        Intrinsics.checkParameterIsNotNull(publisher, "o1");
        Intrinsics.checkParameterIsNotNull(publisher2, "o2");
        Intrinsics.checkParameterIsNotNull(publisher3, "o3");
        Intrinsics.checkParameterIsNotNull(publisher4, "o4");
        Intrinsics.checkParameterIsNotNull(function5, "combiner");
        Flowable<R> withLatestFrom = flowable.withLatestFrom(publisher, publisher2, publisher3, publisher4, new FlowablesKt$withLatestFrom$6(function5));
        Intrinsics.checkExpressionValueIsNotNull(withLatestFrom, "withLatestFrom(o1, o2, o…oke(t, t1, t2, t3, t4) })");
        return withLatestFrom;
    }
}
