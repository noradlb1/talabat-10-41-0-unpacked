package androidx.paging;

import androidx.annotation.RestrictTo;
import androidx.paging.PagingSource;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0007\u0018\u0000*\b\b\u0000\u0010\u0001*\u00020\u0002*\b\b\u0001\u0010\u0003*\u00020\u00022\u000e\u0012\u0004\u0012\u0002H\u0001\u0012\u0004\u0012\u0002H\u00030\u0004B\u0005¢\u0006\u0002\u0010\u0005J#\u0010\u0006\u001a\u0004\u0018\u00018\u00002\u0012\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\bH\u0016¢\u0006\u0002\u0010\tJ+\u0010\n\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u000b2\f\u0010\f\u001a\b\u0012\u0004\u0012\u00028\u00000\rH@ø\u0001\u0000¢\u0006\u0002\u0010\u000e\u0002\u0004\n\u0002\b\u0019¨\u0006\u000f"}, d2 = {"Landroidx/paging/InitialPagingSource;", "K", "", "V", "Landroidx/paging/PagingSource;", "()V", "getRefreshKey", "state", "Landroidx/paging/PagingState;", "(Landroidx/paging/PagingState;)Ljava/lang/Object;", "load", "Landroidx/paging/PagingSource$LoadResult;", "params", "Landroidx/paging/PagingSource$LoadParams;", "(Landroidx/paging/PagingSource$LoadParams;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "paging-common"}, k = 1, mv = {1, 4, 2})
@RestrictTo({RestrictTo.Scope.LIBRARY})
public final class InitialPagingSource<K, V> extends PagingSource<K, V> {
    @Nullable
    public K getRefreshKey(@NotNull PagingState<K, V> pagingState) {
        Intrinsics.checkNotNullParameter(pagingState, "state");
        return null;
    }

    @Nullable
    public Object load(@NotNull PagingSource.LoadParams<K> loadParams, @NotNull Continuation<? super PagingSource.LoadResult<K, V>> continuation) {
        return PagingSource.LoadResult.Page.Companion.empty$paging_common();
    }
}
