package androidx.paging.rxjava2;

import androidx.annotation.CheckResult;
import androidx.paging.Pager;
import androidx.paging.PagingData;
import io.reactivex.Flowable;
import io.reactivex.Maybe;
import io.reactivex.Observable;
import io.reactivex.Single;
import kotlin.Metadata;
import kotlin.jvm.JvmName;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.ExperimentalCoroutinesApi;
import org.jetbrains.annotations.NotNull;

@Metadata(bv = {1, 0, 3}, d1 = {"androidx/paging/rxjava2/PagingRx__PagingRxKt", "androidx/paging/rxjava2/PagingRx__RxPagingDataKt"}, k = 4, mv = {1, 4, 2})
public final class PagingRx {
    @NotNull
    @ExperimentalCoroutinesApi
    public static final <T> Flowable<PagingData<T>> cachedIn(@NotNull Flowable<PagingData<T>> flowable, @NotNull CoroutineScope coroutineScope) {
        return PagingRx__PagingRxKt.cachedIn(flowable, coroutineScope);
    }

    @CheckResult
    @NotNull
    @JvmName(name = "filter")
    public static final <T> PagingData<T> filter(@NotNull PagingData<T> pagingData, @NotNull Function1<? super T, ? extends Single<Boolean>> function1) {
        return PagingRx__RxPagingDataKt.filter(pagingData, function1);
    }

    @CheckResult
    @NotNull
    @JvmName(name = "flatMap")
    public static final <T, R> PagingData<R> flatMap(@NotNull PagingData<T> pagingData, @NotNull Function1<? super T, ? extends Single<Iterable<R>>> function1) {
        return PagingRx__RxPagingDataKt.flatMap(pagingData, function1);
    }

    @NotNull
    @ExperimentalCoroutinesApi
    public static final <Key, Value> Flowable<PagingData<Value>> getFlowable(@NotNull Pager<Key, Value> pager) {
        return PagingRx__PagingRxKt.getFlowable(pager);
    }

    @NotNull
    @ExperimentalCoroutinesApi
    public static final <Key, Value> Observable<PagingData<Value>> getObservable(@NotNull Pager<Key, Value> pager) {
        return PagingRx__PagingRxKt.getObservable(pager);
    }

    @CheckResult
    @NotNull
    @JvmName(name = "insertSeparators")
    public static final <T extends R, R> PagingData<R> insertSeparators(@NotNull PagingData<T> pagingData, @NotNull Function2<? super T, ? super T, ? extends Maybe<R>> function2) {
        return PagingRx__RxPagingDataKt.insertSeparators(pagingData, function2);
    }

    @CheckResult
    @NotNull
    @JvmName(name = "map")
    public static final <T, R> PagingData<R> map(@NotNull PagingData<T> pagingData, @NotNull Function1<? super T, ? extends Single<R>> function1) {
        return PagingRx__RxPagingDataKt.map(pagingData, function1);
    }

    @NotNull
    @ExperimentalCoroutinesApi
    public static final <T> Observable<PagingData<T>> cachedIn(@NotNull Observable<PagingData<T>> observable, @NotNull CoroutineScope coroutineScope) {
        return PagingRx__PagingRxKt.cachedIn(observable, coroutineScope);
    }
}
