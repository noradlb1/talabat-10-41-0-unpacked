package io.reactivex.rxkotlin;

import io.reactivex.Completable;
import io.reactivex.CompletableSource;
import io.reactivex.Flowable;
import io.reactivex.Observable;
import io.reactivex.annotations.BackpressureKind;
import io.reactivex.annotations.BackpressureSupport;
import io.reactivex.annotations.CheckReturnValue;
import io.reactivex.annotations.SchedulerSupport;
import io.reactivex.functions.Action;
import java.util.concurrent.Callable;
import java.util.concurrent.Future;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(bv = {1, 0, 3}, d1 = {"\u00000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u001c\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u001a\u0012\u0010\u0000\u001a\u00020\u0001*\b\u0012\u0004\u0012\u00020\u00030\u0002H\u0007\u001a\u0012\u0010\u0004\u001a\u00020\u0001*\b\u0012\u0004\u0012\u00020\u00010\u0005H\u0007\u001a\u0012\u0010\u0004\u001a\u00020\u0001*\b\u0012\u0004\u0012\u00020\u00010\u0006H\u0007\u001a\u0010\u0010\u0007\u001a\u00020\u0001*\b\u0012\u0004\u0012\u00020\t0\b\u001a\n\u0010\u0007\u001a\u00020\u0001*\u00020\n\u001a\u0012\u0010\u0007\u001a\u00020\u0001*\n\u0012\u0006\b\u0001\u0012\u00020\t0\u000b\u001a\u0012\u0010\u0007\u001a\u00020\u0001*\n\u0012\u0006\b\u0001\u0012\u00020\t0\f¨\u0006\r"}, d2 = {"concatAll", "Lio/reactivex/Completable;", "", "Lio/reactivex/CompletableSource;", "mergeAllCompletables", "Lio/reactivex/Flowable;", "Lio/reactivex/Observable;", "toCompletable", "Lkotlin/Function0;", "", "Lio/reactivex/functions/Action;", "Ljava/util/concurrent/Callable;", "Ljava/util/concurrent/Future;", "rxkotlin"}, k = 2, mv = {1, 1, 15})
public final class CompletableKt {
    @CheckReturnValue
    @NotNull
    @SchedulerSupport("none")
    public static final Completable concatAll(@NotNull Iterable<? extends CompletableSource> iterable) {
        Intrinsics.checkParameterIsNotNull(iterable, "$this$concatAll");
        Completable concat = Completable.concat(iterable);
        Intrinsics.checkExpressionValueIsNotNull(concat, "Completable.concat(this)");
        return concat;
    }

    @CheckReturnValue
    @NotNull
    @SchedulerSupport("none")
    public static final Completable mergeAllCompletables(@NotNull Observable<Completable> observable) {
        Intrinsics.checkParameterIsNotNull(observable, "$this$mergeAllCompletables");
        Completable flatMapCompletable = observable.flatMapCompletable(CompletableKt$mergeAllCompletables$1.INSTANCE);
        Intrinsics.checkExpressionValueIsNotNull(flatMapCompletable, "flatMapCompletable { it }");
        return flatMapCompletable;
    }

    @NotNull
    public static final Completable toCompletable(@NotNull Action action) {
        Intrinsics.checkParameterIsNotNull(action, "$this$toCompletable");
        Completable fromAction = Completable.fromAction(action);
        Intrinsics.checkExpressionValueIsNotNull(fromAction, "Completable.fromAction(this)");
        return fromAction;
    }

    @CheckReturnValue
    @BackpressureSupport(BackpressureKind.UNBOUNDED_IN)
    @NotNull
    @SchedulerSupport("none")
    public static final Completable mergeAllCompletables(@NotNull Flowable<Completable> flowable) {
        Intrinsics.checkParameterIsNotNull(flowable, "$this$mergeAllCompletables");
        Completable flatMapCompletable = flowable.flatMapCompletable(CompletableKt$mergeAllCompletables$2.INSTANCE);
        Intrinsics.checkExpressionValueIsNotNull(flatMapCompletable, "flatMapCompletable { it }");
        return flatMapCompletable;
    }

    @NotNull
    public static final Completable toCompletable(@NotNull Callable<? extends Object> callable) {
        Intrinsics.checkParameterIsNotNull(callable, "$this$toCompletable");
        Completable fromCallable = Completable.fromCallable(callable);
        Intrinsics.checkExpressionValueIsNotNull(fromCallable, "Completable.fromCallable(this)");
        return fromCallable;
    }

    @NotNull
    public static final Completable toCompletable(@NotNull Future<? extends Object> future) {
        Intrinsics.checkParameterIsNotNull(future, "$this$toCompletable");
        Completable fromFuture = Completable.fromFuture(future);
        Intrinsics.checkExpressionValueIsNotNull(fromFuture, "Completable.fromFuture(this)");
        return fromFuture;
    }

    @NotNull
    public static final Completable toCompletable(@NotNull Function0<? extends Object> function0) {
        Intrinsics.checkParameterIsNotNull(function0, "$this$toCompletable");
        Completable fromCallable = Completable.fromCallable(new CompletableKt$sam$java_util_concurrent_Callable$0(function0));
        Intrinsics.checkExpressionValueIsNotNull(fromCallable, "Completable.fromCallable(this)");
        return fromCallable;
    }
}
