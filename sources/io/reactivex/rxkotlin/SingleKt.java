package io.reactivex.rxkotlin;

import io.reactivex.Flowable;
import io.reactivex.Observable;
import io.reactivex.Single;
import io.reactivex.SingleSource;
import io.reactivex.annotations.BackpressureKind;
import io.reactivex.annotations.BackpressureSupport;
import io.reactivex.annotations.CheckReturnValue;
import io.reactivex.annotations.SchedulerSupport;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000$\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u001c\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u001a#\u0010\u0000\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\n\b\u0000\u0010\u0002\u0018\u0001*\u00020\u0003*\u0006\u0012\u0002\b\u00030\u0001H\b\u001a(\u0010\u0004\u001a\b\u0012\u0004\u0012\u0002H\u00060\u0005\"\b\b\u0000\u0010\u0006*\u00020\u0003*\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00060\b0\u0007H\u0007\u001a(\u0010\t\u001a\b\u0012\u0004\u0012\u0002H\u00060\u0005\"\b\b\u0000\u0010\u0006*\u00020\u0003*\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00060\u00010\u0005H\u0007\u001a(\u0010\t\u001a\b\u0012\u0004\u0012\u0002H\u00060\n\"\b\b\u0000\u0010\u0006*\u00020\u0003*\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00060\u00010\nH\u0007¨\u0006\u000b"}, d2 = {"cast", "Lio/reactivex/Single;", "R", "", "concatAll", "Lio/reactivex/Flowable;", "T", "", "Lio/reactivex/SingleSource;", "mergeAllSingles", "Lio/reactivex/Observable;", "rxkotlin"}, k = 2, mv = {1, 1, 15})
public final class SingleKt {
    @NotNull
    public static final /* synthetic */ <R> Single<R> cast(@NotNull Single<?> single) {
        Intrinsics.checkParameterIsNotNull(single, "$this$cast");
        Intrinsics.reifiedOperationMarker(4, "R");
        Single<U> cast = single.cast(Object.class);
        Intrinsics.checkExpressionValueIsNotNull(cast, "cast(R::class.java)");
        return cast;
    }

    @CheckReturnValue
    @BackpressureSupport(BackpressureKind.FULL)
    @NotNull
    @SchedulerSupport("none")
    public static final <T> Flowable<T> concatAll(@NotNull Iterable<? extends SingleSource<T>> iterable) {
        Intrinsics.checkParameterIsNotNull(iterable, "$this$concatAll");
        Flowable<T> concat = Single.concat(iterable);
        Intrinsics.checkExpressionValueIsNotNull(concat, "Single.concat(this)");
        return concat;
    }

    @CheckReturnValue
    @NotNull
    @SchedulerSupport("none")
    public static final <T> Observable<T> mergeAllSingles(@NotNull Observable<Single<T>> observable) {
        Intrinsics.checkParameterIsNotNull(observable, "$this$mergeAllSingles");
        Observable<R> flatMapSingle = observable.flatMapSingle(SingleKt$mergeAllSingles$1.INSTANCE);
        Intrinsics.checkExpressionValueIsNotNull(flatMapSingle, "flatMapSingle { it }");
        return flatMapSingle;
    }

    @CheckReturnValue
    @BackpressureSupport(BackpressureKind.UNBOUNDED_IN)
    @NotNull
    @SchedulerSupport("none")
    public static final <T> Flowable<T> mergeAllSingles(@NotNull Flowable<Single<T>> flowable) {
        Intrinsics.checkParameterIsNotNull(flowable, "$this$mergeAllSingles");
        Flowable<R> flatMapSingle = flowable.flatMapSingle(SingleKt$mergeAllSingles$2.INSTANCE);
        Intrinsics.checkExpressionValueIsNotNull(flatMapSingle, "flatMapSingle { it }");
        return flatMapSingle;
    }
}
