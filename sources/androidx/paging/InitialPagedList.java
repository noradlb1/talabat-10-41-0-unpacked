package androidx.paging;

import androidx.annotation.RestrictTo;
import androidx.paging.PagedList;
import androidx.paging.PagingSource;
import com.talabat.darkstores.feature.main.DarkstoresMainActivity;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineDispatcher;
import kotlinx.coroutines.CoroutineScope;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0007\u0018\u0000*\b\b\u0000\u0010\u0001*\u00020\u0002*\b\b\u0001\u0010\u0003*\u00020\u00022\u000e\u0012\u0004\u0012\u0002H\u0001\u0012\u0004\u0012\u0002H\u00030\u0004BC\u0012\u0012\u0010\u0005\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u0006\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\u0006\u0010\t\u001a\u00020\n\u0012\u0006\u0010\u000b\u001a\u00020\n\u0012\u0006\u0010\f\u001a\u00020\r\u0012\b\u0010\u000e\u001a\u0004\u0018\u00018\u0000¢\u0006\u0002\u0010\u000f¨\u0006\u0010"}, d2 = {"Landroidx/paging/InitialPagedList;", "K", "", "V", "Landroidx/paging/ContiguousPagedList;", "pagingSource", "Landroidx/paging/PagingSource;", "coroutineScope", "Lkotlinx/coroutines/CoroutineScope;", "notifyDispatcher", "Lkotlinx/coroutines/CoroutineDispatcher;", "backgroundDispatcher", "config", "Landroidx/paging/PagedList$Config;", "initialLastKey", "(Landroidx/paging/PagingSource;Lkotlinx/coroutines/CoroutineScope;Lkotlinx/coroutines/CoroutineDispatcher;Lkotlinx/coroutines/CoroutineDispatcher;Landroidx/paging/PagedList$Config;Ljava/lang/Object;)V", "paging-common"}, k = 1, mv = {1, 4, 2})
@RestrictTo({RestrictTo.Scope.LIBRARY})
public final class InitialPagedList<K, V> extends ContiguousPagedList<K, V> {
    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public InitialPagedList(@NotNull PagingSource<K, V> pagingSource, @NotNull CoroutineScope coroutineScope, @NotNull CoroutineDispatcher coroutineDispatcher, @NotNull CoroutineDispatcher coroutineDispatcher2, @NotNull PagedList.Config config, @Nullable K k11) {
        super(pagingSource, coroutineScope, coroutineDispatcher, coroutineDispatcher2, (PagedList.BoundaryCallback) null, config, PagingSource.LoadResult.Page.Companion.empty$paging_common(), k11);
        Intrinsics.checkNotNullParameter(pagingSource, "pagingSource");
        Intrinsics.checkNotNullParameter(coroutineScope, "coroutineScope");
        Intrinsics.checkNotNullParameter(coroutineDispatcher, "notifyDispatcher");
        Intrinsics.checkNotNullParameter(coroutineDispatcher2, "backgroundDispatcher");
        Intrinsics.checkNotNullParameter(config, DarkstoresMainActivity.CONFIG_EXTRA_KEY);
    }
}
