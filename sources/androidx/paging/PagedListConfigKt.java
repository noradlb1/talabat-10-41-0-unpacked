package androidx.paging;

import androidx.paging.PagedList;
import kotlin.Metadata;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0018\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\u001a6\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\u0007\u001a\u00020\u00032\b\b\u0002\u0010\b\u001a\u00020\u0003¨\u0006\t"}, d2 = {"Config", "Landroidx/paging/PagedList$Config;", "pageSize", "", "prefetchDistance", "enablePlaceholders", "", "initialLoadSizeHint", "maxSize", "paging-common"}, k = 2, mv = {1, 4, 2})
public final class PagedListConfigKt {
    public static /* synthetic */ PagedList.Config Config$default(int i11, int i12, boolean z11, int i13, int i14, int i15, Object obj) {
        if ((i15 & 2) != 0) {
            i12 = i11;
        }
        if ((i15 & 4) != 0) {
            z11 = true;
        }
        if ((i15 & 8) != 0) {
            i13 = i11 * 3;
        }
        if ((i15 & 16) != 0) {
            i14 = Integer.MAX_VALUE;
        }
        return new PagedList.Config.Builder().setPageSize(i11).setPrefetchDistance(i12).setEnablePlaceholders(z11).setInitialLoadSizeHint(i13).setMaxSize(i14).build();
    }
}
