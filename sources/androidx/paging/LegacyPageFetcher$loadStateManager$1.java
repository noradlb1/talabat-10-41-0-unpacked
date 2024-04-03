package androidx.paging;

import androidx.paging.PagedList;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0018\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0016¨\u0006\b"}, d2 = {"androidx/paging/LegacyPageFetcher$loadStateManager$1", "Landroidx/paging/PagedList$LoadStateManager;", "onStateChanged", "", "type", "Landroidx/paging/LoadType;", "state", "Landroidx/paging/LoadState;", "paging-common"}, k = 1, mv = {1, 4, 2})
public final class LegacyPageFetcher$loadStateManager$1 extends PagedList.LoadStateManager {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ LegacyPageFetcher f36614a;

    public LegacyPageFetcher$loadStateManager$1(LegacyPageFetcher legacyPageFetcher) {
        this.f36614a = legacyPageFetcher;
    }

    public void onStateChanged(@NotNull LoadType loadType, @NotNull LoadState loadState) {
        Intrinsics.checkNotNullParameter(loadType, "type");
        Intrinsics.checkNotNullParameter(loadState, "state");
        this.f36614a.getPageConsumer().onStateChanged(loadType, loadState);
    }
}
