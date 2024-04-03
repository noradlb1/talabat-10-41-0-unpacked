package androidx.paging;

import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b`\u0018\u0000*\b\b\u0000\u0010\u0001*\u00020\u0002*\b\b\u0001\u0010\u0003*\u00020\u00022\u00020\u0002J$\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0012\u0010\b\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\tH&J\u001c\u0010\n\u001a\u00020\u00052\u0012\u0010\b\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\tH&¨\u0006\u000b"}, d2 = {"Landroidx/paging/RemoteMediatorConnection;", "Key", "", "Value", "requestLoad", "", "loadType", "Landroidx/paging/LoadType;", "pagingState", "Landroidx/paging/PagingState;", "retryFailed", "paging-common"}, k = 1, mv = {1, 4, 2})
public interface RemoteMediatorConnection<Key, Value> {
    void requestLoad(@NotNull LoadType loadType, @NotNull PagingState<Key, Value> pagingState);

    void retryFailed(@NotNull PagingState<Key, Value> pagingState);
}
