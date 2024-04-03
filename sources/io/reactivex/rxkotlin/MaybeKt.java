package io.reactivex.rxkotlin;

import io.reactivex.Flowable;
import io.reactivex.Maybe;
import io.reactivex.MaybeSource;
import io.reactivex.Observable;
import io.reactivex.annotations.BackpressureKind;
import io.reactivex.annotations.BackpressureSupport;
import io.reactivex.annotations.CheckReturnValue;
import io.reactivex.annotations.SchedulerSupport;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000&\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u001c\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a#\u0010\u0000\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\n\b\u0000\u0010\u0002\u0018\u0001*\u00020\u0003*\u0006\u0012\u0002\b\u00030\u0001H\b\u001a(\u0010\u0004\u001a\b\u0012\u0004\u0012\u0002H\u00060\u0005\"\b\b\u0000\u0010\u0006*\u00020\u0003*\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00060\b0\u0007H\u0007\u001a(\u0010\t\u001a\b\u0012\u0004\u0012\u0002H\u00060\u0005\"\b\b\u0000\u0010\u0006*\u00020\u0003*\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00060\u00010\u0005H\u0007\u001a(\u0010\t\u001a\b\u0012\u0004\u0012\u0002H\u00060\n\"\b\b\u0000\u0010\u0006*\u00020\u0003*\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00060\u00010\nH\u0007\u001a#\u0010\u000b\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\n\b\u0000\u0010\u0002\u0018\u0001*\u00020\u0003*\u0006\u0012\u0002\b\u00030\u0001H\b¨\u0006\f"}, d2 = {"cast", "Lio/reactivex/Maybe;", "R", "", "concatAll", "Lio/reactivex/Flowable;", "T", "", "Lio/reactivex/MaybeSource;", "mergeAllMaybes", "Lio/reactivex/Observable;", "ofType", "rxkotlin"}, k = 2, mv = {1, 1, 15})
public final class MaybeKt {
    @CheckReturnValue
    @NotNull
    @SchedulerSupport("none")
    public static final /* synthetic */ <R> Maybe<R> cast(@NotNull Maybe<?> maybe) {
        Intrinsics.checkParameterIsNotNull(maybe, "$this$cast");
        Intrinsics.reifiedOperationMarker(4, "R");
        Maybe<U> cast = maybe.cast(Object.class);
        Intrinsics.checkExpressionValueIsNotNull(cast, "cast(R::class.java)");
        return cast;
    }

    @CheckReturnValue
    @BackpressureSupport(BackpressureKind.FULL)
    @NotNull
    @SchedulerSupport("none")
    public static final <T> Flowable<T> concatAll(@NotNull Iterable<? extends MaybeSource<T>> iterable) {
        Intrinsics.checkParameterIsNotNull(iterable, "$this$concatAll");
        Flowable<T> concat = Maybe.concat(iterable);
        Intrinsics.checkExpressionValueIsNotNull(concat, "Maybe.concat(this)");
        return concat;
    }

    @CheckReturnValue
    @NotNull
    @SchedulerSupport("none")
    public static final <T> Observable<T> mergeAllMaybes(@NotNull Observable<Maybe<T>> observable) {
        Intrinsics.checkParameterIsNotNull(observable, "$this$mergeAllMaybes");
        Observable<R> flatMapMaybe = observable.flatMapMaybe(MaybeKt$mergeAllMaybes$1.INSTANCE);
        Intrinsics.checkExpressionValueIsNotNull(flatMapMaybe, "flatMapMaybe { it }");
        return flatMapMaybe;
    }

    @CheckReturnValue
    @NotNull
    @SchedulerSupport("none")
    public static final /* synthetic */ <R> Maybe<R> ofType(@NotNull Maybe<?> maybe) {
        Intrinsics.checkParameterIsNotNull(maybe, "$this$ofType");
        Intrinsics.reifiedOperationMarker(4, "R");
        Maybe<U> ofType = maybe.ofType(Object.class);
        Intrinsics.checkExpressionValueIsNotNull(ofType, "ofType(R::class.java)");
        return ofType;
    }

    @CheckReturnValue
    @BackpressureSupport(BackpressureKind.UNBOUNDED_IN)
    @NotNull
    @SchedulerSupport("none")
    public static final <T> Flowable<T> mergeAllMaybes(@NotNull Flowable<Maybe<T>> flowable) {
        Intrinsics.checkParameterIsNotNull(flowable, "$this$mergeAllMaybes");
        Flowable<R> flatMapMaybe = flowable.flatMapMaybe(MaybeKt$mergeAllMaybes$2.INSTANCE);
        Intrinsics.checkExpressionValueIsNotNull(flatMapMaybe, "flatMapMaybe { it }");
        return flatMapMaybe;
    }
}
