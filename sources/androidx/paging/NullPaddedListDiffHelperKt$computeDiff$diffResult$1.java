package androidx.paging;

import androidx.recyclerview.widget.DiffUtil;
import kotlin.Metadata;
import org.jetbrains.annotations.Nullable;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000!\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0000\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0018\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0005H\u0016J\u0018\u0010\u0007\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0005H\u0016J\u001a\u0010\b\u001a\u0004\u0018\u00010\t2\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0005H\u0016J\b\u0010\n\u001a\u00020\u0005H\u0016J\b\u0010\u000b\u001a\u00020\u0005H\u0016¨\u0006\f"}, d2 = {"androidx/paging/NullPaddedListDiffHelperKt$computeDiff$diffResult$1", "Landroidx/recyclerview/widget/DiffUtil$Callback;", "areContentsTheSame", "", "oldItemPosition", "", "newItemPosition", "areItemsTheSame", "getChangePayload", "", "getNewListSize", "getOldListSize", "paging-runtime_release"}, k = 1, mv = {1, 4, 2})
public final class NullPaddedListDiffHelperKt$computeDiff$diffResult$1 extends DiffUtil.Callback {

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ NullPaddedList f36641c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ NullPaddedList f36642d;

    /* renamed from: e  reason: collision with root package name */
    public final /* synthetic */ DiffUtil.ItemCallback f36643e;

    /* renamed from: f  reason: collision with root package name */
    public final /* synthetic */ int f36644f;

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ int f36645g;

    public NullPaddedListDiffHelperKt$computeDiff$diffResult$1(NullPaddedList<T> nullPaddedList, NullPaddedList nullPaddedList2, DiffUtil.ItemCallback itemCallback, int i11, int i12) {
        this.f36641c = nullPaddedList;
        this.f36642d = nullPaddedList2;
        this.f36643e = itemCallback;
        this.f36644f = i11;
        this.f36645g = i12;
    }

    public boolean areContentsTheSame(int i11, int i12) {
        Object fromStorage = this.f36641c.getFromStorage(i11);
        Object fromStorage2 = this.f36642d.getFromStorage(i12);
        if (fromStorage == fromStorage2) {
            return true;
        }
        return this.f36643e.areContentsTheSame(fromStorage, fromStorage2);
    }

    public boolean areItemsTheSame(int i11, int i12) {
        Object fromStorage = this.f36641c.getFromStorage(i11);
        Object fromStorage2 = this.f36642d.getFromStorage(i12);
        if (fromStorage == fromStorage2) {
            return true;
        }
        return this.f36643e.areItemsTheSame(fromStorage, fromStorage2);
    }

    @Nullable
    public Object getChangePayload(int i11, int i12) {
        Object fromStorage = this.f36641c.getFromStorage(i11);
        Object fromStorage2 = this.f36642d.getFromStorage(i12);
        if (fromStorage == fromStorage2) {
            return Boolean.TRUE;
        }
        return this.f36643e.getChangePayload(fromStorage, fromStorage2);
    }

    public int getNewListSize() {
        return this.f36645g;
    }

    public int getOldListSize() {
        return this.f36644f;
    }
}
