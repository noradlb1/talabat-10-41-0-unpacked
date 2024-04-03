package com.talabat.verticals.ui.customViewLCAware.adapter;

import android.view.LayoutInflater;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import com.talabat.verticals.R;
import com.talabat.verticals.ui.customViewLCAware.adapter.VerticalsSubListItemViewHolder;
import com.talabat.verticals.ui.customViewLCAware.model.Vertical;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0006\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u0003:\u0001$B\u0005¢\u0006\u0002\u0010\u0004J\b\u0010\u0013\u001a\u00020\u0014H\u0016J\u0018\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u00022\u0006\u0010\u0018\u001a\u00020\u0014H\u0016J\u0018\u0010\u0019\u001a\u00020\u00022\u0006\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u0014H\u0016J\u0012\u0010\u001d\u001a\u00020\u00162\b\u0010\u001e\u001a\u0004\u0018\u00010\u001fH\u0016J\u001e\u0010 \u001a\u00020\u00162\u0016\u0010!\u001a\u0012\u0012\u0004\u0012\u00020\u00070\u0006j\b\u0012\u0004\u0012\u00020\u0007`\bJ\u000e\u0010\"\u001a\u00020\u00162\u0006\u0010#\u001a\u00020\u000eR*\u0010\u0005\u001a\u0012\u0012\u0004\u0012\u00020\u00070\u0006j\b\u0012\u0004\u0012\u00020\u0007`\bX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\fR\u001a\u0010\r\u001a\u00020\u000eX.¢\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012¨\u0006%"}, d2 = {"Lcom/talabat/verticals/ui/customViewLCAware/adapter/VerticalsSubListAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "Lcom/talabat/verticals/ui/customViewLCAware/adapter/VerticalsSubListItemViewHolder$ItemCLickListener;", "()V", "mList", "Ljava/util/ArrayList;", "Lcom/talabat/verticals/ui/customViewLCAware/model/Vertical;", "Lkotlin/collections/ArrayList;", "getMList", "()Ljava/util/ArrayList;", "setMList", "(Ljava/util/ArrayList;)V", "mListener", "Lcom/talabat/verticals/ui/customViewLCAware/adapter/VerticalsSubListAdapter$ItemClickListener;", "getMListener", "()Lcom/talabat/verticals/ui/customViewLCAware/adapter/VerticalsSubListAdapter$ItemClickListener;", "setMListener", "(Lcom/talabat/verticals/ui/customViewLCAware/adapter/VerticalsSubListAdapter$ItemClickListener;)V", "getItemCount", "", "onBindViewHolder", "", "holder", "position", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "onItemCLicked", "deepLink", "", "setData", "data", "setListener", "listener", "ItemClickListener", "com_talabat_NewArchi_VerticalsSquad_VerticalsSquad"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class VerticalsSubListAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> implements VerticalsSubListItemViewHolder.ItemCLickListener {
    @NotNull
    private ArrayList<Vertical> mList = new ArrayList<>();
    public ItemClickListener mListener;

    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\bf\u0018\u00002\u00020\u0001J\u0012\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H&¨\u0006\u0006"}, d2 = {"Lcom/talabat/verticals/ui/customViewLCAware/adapter/VerticalsSubListAdapter$ItemClickListener;", "", "onItemClicked", "", "deepLink", "", "com_talabat_NewArchi_VerticalsSquad_VerticalsSquad"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public interface ItemClickListener {
        void onItemClicked(@Nullable String str);
    }

    public int getItemCount() {
        return this.mList.size();
    }

    @NotNull
    public final ArrayList<Vertical> getMList() {
        return this.mList;
    }

    @NotNull
    public final ItemClickListener getMListener() {
        ItemClickListener itemClickListener = this.mListener;
        if (itemClickListener != null) {
            return itemClickListener;
        }
        Intrinsics.throwUninitializedPropertyAccessException("mListener");
        return null;
    }

    public void onBindViewHolder(@NotNull RecyclerView.ViewHolder viewHolder, int i11) {
        Intrinsics.checkNotNullParameter(viewHolder, "holder");
        Vertical vertical = this.mList.get(i11);
        Intrinsics.checkNotNullExpressionValue(vertical, "mList.get(position)");
        ((VerticalsSubListItemViewHolder) viewHolder).bindItem(vertical, this);
    }

    @NotNull
    public RecyclerView.ViewHolder onCreateViewHolder(@NotNull ViewGroup viewGroup, int i11) {
        Intrinsics.checkNotNullParameter(viewGroup, "parent");
        return new VerticalsSubListItemViewHolder(LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_verticals_sub_list, viewGroup, false));
    }

    public void onItemCLicked(@Nullable String str) {
        getMListener().onItemClicked(str);
    }

    public final void setData(@NotNull ArrayList<Vertical> arrayList) {
        Intrinsics.checkNotNullParameter(arrayList, "data");
        this.mList = arrayList;
        notifyDataSetChanged();
    }

    public final void setListener(@NotNull ItemClickListener itemClickListener) {
        Intrinsics.checkNotNullParameter(itemClickListener, ServiceSpecificExtraArgs.CastExtraArgs.LISTENER);
        setMListener(itemClickListener);
    }

    public final void setMList(@NotNull ArrayList<Vertical> arrayList) {
        Intrinsics.checkNotNullParameter(arrayList, "<set-?>");
        this.mList = arrayList;
    }

    public final void setMListener(@NotNull ItemClickListener itemClickListener) {
        Intrinsics.checkNotNullParameter(itemClickListener, "<set-?>");
        this.mListener = itemClickListener;
    }
}
