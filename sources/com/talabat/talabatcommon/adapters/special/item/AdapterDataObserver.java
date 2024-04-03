package com.talabat.talabatcommon.adapters.special.item;

import androidx.recyclerview.widget.RecyclerView;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0004\b\u0000\u0018\u00002\u00020\u0001B\u0013\u0012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\u0002\u0010\u0005J\b\u0010\u0006\u001a\u00020\u0007H\u0016J\u0018\u0010\b\u001a\u00020\u00072\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\nH\u0016J\u0018\u0010\f\u001a\u00020\u00072\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\nH\u0016J\u0018\u0010\r\u001a\u00020\u00072\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\nH\u0016R\u0014\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003X\u0004¢\u0006\u0002\n\u0000¨\u0006\u000e"}, d2 = {"Lcom/talabat/talabatcommon/adapters/special/item/AdapterDataObserver;", "Landroidx/recyclerview/widget/RecyclerView$AdapterDataObserver;", "wrapperAdapter", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "(Landroidx/recyclerview/widget/RecyclerView$Adapter;)V", "onChanged", "", "onItemRangeChanged", "positionStart", "", "itemCount", "onItemRangeInserted", "onItemRangeRemoved", "com_talabat_NewArchi_TalabatCommon_TalabatCommon"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class AdapterDataObserver extends RecyclerView.AdapterDataObserver {
    @NotNull
    private final RecyclerView.Adapter<RecyclerView.ViewHolder> wrapperAdapter;

    public AdapterDataObserver(@NotNull RecyclerView.Adapter<RecyclerView.ViewHolder> adapter) {
        Intrinsics.checkNotNullParameter(adapter, "wrapperAdapter");
        this.wrapperAdapter = adapter;
    }

    public void onChanged() {
        this.wrapperAdapter.notifyDataSetChanged();
    }

    public void onItemRangeChanged(int i11, int i12) {
        this.wrapperAdapter.notifyItemRangeChanged(i11, i12);
    }

    public void onItemRangeInserted(int i11, int i12) {
        this.wrapperAdapter.notifyItemRangeInserted(i11, i12);
    }

    public void onItemRangeRemoved(int i11, int i12) {
        this.wrapperAdapter.notifyItemRangeRemoved(i11, i12);
    }
}
