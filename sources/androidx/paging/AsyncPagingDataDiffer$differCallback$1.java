package androidx.paging;

import kotlin.Metadata;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0019\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0018\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0005H\u0016J\u0018\u0010\u0007\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0005H\u0016J\u0018\u0010\b\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0005H\u0016¨\u0006\t"}, d2 = {"androidx/paging/AsyncPagingDataDiffer$differCallback$1", "Landroidx/paging/DifferCallback;", "onChanged", "", "position", "", "count", "onInserted", "onRemoved", "paging-runtime_release"}, k = 1, mv = {1, 4, 2})
public final class AsyncPagingDataDiffer$differCallback$1 implements DifferCallback {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ AsyncPagingDataDiffer f36474a;

    public AsyncPagingDataDiffer$differCallback$1(AsyncPagingDataDiffer asyncPagingDataDiffer) {
        this.f36474a = asyncPagingDataDiffer;
    }

    public void onChanged(int i11, int i12) {
        if (i12 > 0) {
            this.f36474a.updateCallback.onChanged(i11, i12, (Object) null);
        }
    }

    public void onInserted(int i11, int i12) {
        if (i12 > 0) {
            this.f36474a.updateCallback.onInserted(i11, i12);
        }
    }

    public void onRemoved(int i11, int i12) {
        if (i12 > 0) {
            this.f36474a.updateCallback.onRemoved(i11, i12);
        }
    }
}
