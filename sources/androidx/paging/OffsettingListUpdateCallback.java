package androidx.paging;

import androidx.recyclerview.widget.ListUpdateCallback;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u0000\n\u0002\b\u0006\b\u0002\u0018\u00002\u00020\u0001B\u0017\b\u0000\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0001¢\u0006\u0002\u0010\u0005J\"\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u00032\u0006\u0010\t\u001a\u00020\u00032\b\u0010\n\u001a\u0004\u0018\u00010\u000bH\u0016J\u0018\u0010\f\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u00032\u0006\u0010\t\u001a\u00020\u0003H\u0016J\u0018\u0010\r\u001a\u00020\u00072\u0006\u0010\u000e\u001a\u00020\u00032\u0006\u0010\u000f\u001a\u00020\u0003H\u0016J\u0018\u0010\u0010\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u00032\u0006\u0010\t\u001a\u00020\u0003H\u0016R\u000e\u0010\u0004\u001a\u00020\u0001X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000¨\u0006\u0011"}, d2 = {"Landroidx/paging/OffsettingListUpdateCallback;", "Landroidx/recyclerview/widget/ListUpdateCallback;", "offset", "", "callback", "(ILandroidx/recyclerview/widget/ListUpdateCallback;)V", "onChanged", "", "position", "count", "payload", "", "onInserted", "onMoved", "fromPosition", "toPosition", "onRemoved", "paging-runtime_release"}, k = 1, mv = {1, 4, 2})
final class OffsettingListUpdateCallback implements ListUpdateCallback {
    private final ListUpdateCallback callback;
    private final int offset;

    public OffsettingListUpdateCallback(int i11, @NotNull ListUpdateCallback listUpdateCallback) {
        Intrinsics.checkNotNullParameter(listUpdateCallback, "callback");
        this.offset = i11;
        this.callback = listUpdateCallback;
    }

    public void onChanged(int i11, int i12, @Nullable Object obj) {
        this.callback.onChanged(i11 + this.offset, i12, obj);
    }

    public void onInserted(int i11, int i12) {
        this.callback.onInserted(i11 + this.offset, i12);
    }

    public void onMoved(int i11, int i12) {
        ListUpdateCallback listUpdateCallback = this.callback;
        int i13 = this.offset;
        listUpdateCallback.onMoved(i11 + i13, i12 + i13);
    }

    public void onRemoved(int i11, int i12) {
        this.callback.onRemoved(i11 + this.offset, i12);
    }
}
