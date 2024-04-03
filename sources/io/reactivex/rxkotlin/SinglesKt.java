package io.reactivex.rxkotlin;

import io.reactivex.Single;
import io.reactivex.SingleSource;
import io.reactivex.annotations.CheckReturnValue;
import io.reactivex.annotations.SchedulerSupport;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\"\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\u001aF\u0010\u0000\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u0002H\u0003\u0012\u0004\u0012\u0002H\u00040\u00020\u0001\"\b\b\u0000\u0010\u0003*\u00020\u0005\"\b\b\u0001\u0010\u0004*\u00020\u0005*\b\u0012\u0004\u0012\u0002H\u00030\u00012\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u0002H\u00040\u0007H\u0007\u001aa\u0010\u0000\u001a\b\u0012\u0004\u0012\u0002H\b0\u0001\"\b\b\u0000\u0010\u0003*\u00020\u0005\"\b\b\u0001\u0010\u0004*\u00020\u0005\"\b\b\u0002\u0010\b*\u00020\u0005*\b\u0012\u0004\u0012\u0002H\u00030\u00012\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u0002H\u00040\u00072\u001a\b\u0004\u0010\t\u001a\u0014\u0012\u0004\u0012\u0002H\u0003\u0012\u0004\u0012\u0002H\u0004\u0012\u0004\u0012\u0002H\b0\nH\b¨\u0006\u000b"}, d2 = {"zipWith", "Lio/reactivex/Single;", "Lkotlin/Pair;", "T", "U", "", "other", "Lio/reactivex/SingleSource;", "R", "zipper", "Lkotlin/Function2;", "rxkotlin"}, k = 2, mv = {1, 1, 15})
public final class SinglesKt {
    @CheckReturnValue
    @NotNull
    @SchedulerSupport("none")
    public static final <T, U, R> Single<R> zipWith(@NotNull Single<T> single, @NotNull SingleSource<U> singleSource, @NotNull Function2<? super T, ? super U, ? extends R> function2) {
        Intrinsics.checkParameterIsNotNull(single, "$this$zipWith");
        Intrinsics.checkParameterIsNotNull(singleSource, "other");
        Intrinsics.checkParameterIsNotNull(function2, "zipper");
        Single<R> zipWith = single.zipWith(singleSource, new SinglesKt$zipWith$1(function2));
        Intrinsics.checkExpressionValueIsNotNull(zipWith, "zipWith(other, BiFunctio…-> zipper.invoke(t, u) })");
        return zipWith;
    }

    @CheckReturnValue
    @NotNull
    @SchedulerSupport("none")
    public static final <T, U> Single<Pair<T, U>> zipWith(@NotNull Single<T> single, @NotNull SingleSource<U> singleSource) {
        Intrinsics.checkParameterIsNotNull(single, "$this$zipWith");
        Intrinsics.checkParameterIsNotNull(singleSource, "other");
        Single<R> zipWith = single.zipWith(singleSource, SinglesKt$zipWith$2.INSTANCE);
        Intrinsics.checkExpressionValueIsNotNull(zipWith, "zipWith(other, BiFunction { t, u -> Pair(t, u) })");
        return zipWith;
    }
}
