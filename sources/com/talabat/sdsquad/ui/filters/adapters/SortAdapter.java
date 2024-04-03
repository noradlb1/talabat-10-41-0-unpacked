package com.talabat.sdsquad.ui.filters.adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import com.talabat.sdsquad.R;
import com.talabat.sdsquad.data.vendorslist.response.Sort;
import com.talabat.sdsquad.ui.filters.adapters.viewholders.SortViewHolder;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0003J\b\u0010\t\u001a\u00020\nH\u0016J\u0018\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u00022\u0006\u0010\u000e\u001a\u00020\nH\u0016J\u0018\u0010\u000f\u001a\u00020\u00022\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\nH\u0016J\u000e\u0010\u0013\u001a\u00020\f2\u0006\u0010\u0014\u001a\u00020\u0005J\u0014\u0010\u0015\u001a\u00020\f2\f\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\b0\u0007R\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007X\u000e¢\u0006\u0002\n\u0000¨\u0006\u0017"}, d2 = {"Lcom/talabat/sdsquad/ui/filters/adapters/SortAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "()V", "mSortClickListener", "Lcom/talabat/sdsquad/ui/filters/adapters/viewholders/SortViewHolder$OnSortClickListener;", "mSortList", "", "Lcom/talabat/sdsquad/data/vendorslist/response/Sort;", "getItemCount", "", "onBindViewHolder", "", "holder", "position", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "setClickListener", "clickListener", "setSortList", "sortList", "com_talabat_NewArchi_sdsquad_sdsquad"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class SortAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    @Nullable
    private SortViewHolder.OnSortClickListener mSortClickListener;
    @NotNull
    private List<Sort> mSortList = CollectionsKt__CollectionsKt.emptyList();

    public int getItemCount() {
        return this.mSortList.size();
    }

    public void onBindViewHolder(@NotNull RecyclerView.ViewHolder viewHolder, int i11) {
        Intrinsics.checkNotNullParameter(viewHolder, "holder");
        ((SortViewHolder) viewHolder).bind(this.mSortList.get(i11));
    }

    @NotNull
    public RecyclerView.ViewHolder onCreateViewHolder(@NotNull ViewGroup viewGroup, int i11) {
        Intrinsics.checkNotNullParameter(viewGroup, "parent");
        View inflate = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_vendor_sort, viewGroup, false);
        Intrinsics.checkNotNullExpressionValue(inflate, "view");
        return new SortViewHolder(inflate, this.mSortClickListener);
    }

    public final void setClickListener(@NotNull SortViewHolder.OnSortClickListener onSortClickListener) {
        Intrinsics.checkNotNullParameter(onSortClickListener, "clickListener");
        this.mSortClickListener = onSortClickListener;
    }

    public final void setSortList(@NotNull List<Sort> list) {
        Intrinsics.checkNotNullParameter(list, "sortList");
        this.mSortList = list;
        notifyDataSetChanged();
    }
}
