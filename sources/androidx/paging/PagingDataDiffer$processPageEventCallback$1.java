package androidx.paging;

import androidx.paging.PagePresenter;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000+\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0018\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0005H\u0016J\u0018\u0010\u0007\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0005H\u0016J\u0018\u0010\b\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0005H\u0016J \u0010\t\u001a\u00020\u00032\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000fH\u0016¨\u0006\u0010"}, d2 = {"androidx/paging/PagingDataDiffer$processPageEventCallback$1", "Landroidx/paging/PagePresenter$ProcessPageEventCallback;", "onChanged", "", "position", "", "count", "onInserted", "onRemoved", "onStateUpdate", "loadType", "Landroidx/paging/LoadType;", "fromMediator", "", "loadState", "Landroidx/paging/LoadState;", "paging-common"}, k = 1, mv = {1, 4, 2})
public final class PagingDataDiffer$processPageEventCallback$1 implements PagePresenter.ProcessPageEventCallback {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ PagingDataDiffer f36892a;

    public PagingDataDiffer$processPageEventCallback$1(PagingDataDiffer pagingDataDiffer) {
        this.f36892a = pagingDataDiffer;
    }

    public void onChanged(int i11, int i12) {
        this.f36892a.differCallback.onChanged(i11, i12);
    }

    public void onInserted(int i11, int i12) {
        this.f36892a.differCallback.onInserted(i11, i12);
    }

    public void onRemoved(int i11, int i12) {
        this.f36892a.differCallback.onRemoved(i11, i12);
    }

    public void onStateUpdate(@NotNull LoadType loadType, boolean z11, @NotNull LoadState loadState) {
        Intrinsics.checkNotNullParameter(loadType, "loadType");
        Intrinsics.checkNotNullParameter(loadState, "loadState");
        if (!Intrinsics.areEqual((Object) this.f36892a.combinedLoadStates.get(loadType, z11), (Object) loadState)) {
            this.f36892a.combinedLoadStates.set(loadType, z11, loadState);
            CombinedLoadStates snapshot = this.f36892a.combinedLoadStates.snapshot();
            for (Function1 invoke : this.f36892a.loadStateListeners) {
                invoke.invoke(snapshot);
            }
        }
    }
}
