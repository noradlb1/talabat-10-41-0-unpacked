package com.talabat.verticals.ui.customViewLCAware.adapter;

import android.view.View;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import com.talabat.verticals.R;
import com.talabat.verticals.ui.customViewLCAware.adapter.VerticalsSubListAdapter;
import com.talabat.verticals.ui.customViewLCAware.model.Vertical;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\u0018\u00002\u00020\u00012\u00020\u0002:\u0001\u001cB\r\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005J&\u0010\u0012\u001a\u00020\u00132\u0016\u0010\u0014\u001a\u0012\u0012\u0004\u0012\u00020\u00160\u0015j\b\u0012\u0004\u0012\u00020\u0016`\u00172\u0006\u0010\u0018\u001a\u00020\rJ\u0012\u0010\u0019\u001a\u00020\u00132\b\u0010\u001a\u001a\u0004\u0018\u00010\u001bH\u0016R\u001a\u0010\u0006\u001a\u00020\u0007X.¢\u0006\u000e\n\u0000\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bR\u001a\u0010\f\u001a\u00020\rX.¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011¨\u0006\u001d"}, d2 = {"Lcom/talabat/verticals/ui/customViewLCAware/adapter/VerticalsSubListViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "Lcom/talabat/verticals/ui/customViewLCAware/adapter/VerticalsSubListAdapter$ItemClickListener;", "itemView", "Landroid/view/View;", "(Landroid/view/View;)V", "mAdapter", "Lcom/talabat/verticals/ui/customViewLCAware/adapter/VerticalsSubListAdapter;", "getMAdapter", "()Lcom/talabat/verticals/ui/customViewLCAware/adapter/VerticalsSubListAdapter;", "setMAdapter", "(Lcom/talabat/verticals/ui/customViewLCAware/adapter/VerticalsSubListAdapter;)V", "mListener", "Lcom/talabat/verticals/ui/customViewLCAware/adapter/VerticalsSubListViewHolder$ItemCLickListener;", "getMListener", "()Lcom/talabat/verticals/ui/customViewLCAware/adapter/VerticalsSubListViewHolder$ItemCLickListener;", "setMListener", "(Lcom/talabat/verticals/ui/customViewLCAware/adapter/VerticalsSubListViewHolder$ItemCLickListener;)V", "bindItem", "", "subVerticals", "Ljava/util/ArrayList;", "Lcom/talabat/verticals/ui/customViewLCAware/model/Vertical;", "Lkotlin/collections/ArrayList;", "listener", "onItemClicked", "deepLink", "", "ItemCLickListener", "com_talabat_NewArchi_VerticalsSquad_VerticalsSquad"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class VerticalsSubListViewHolder extends RecyclerView.ViewHolder implements VerticalsSubListAdapter.ItemClickListener {
    public VerticalsSubListAdapter mAdapter;
    public ItemCLickListener mListener;

    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\bf\u0018\u00002\u00020\u0001J\u0012\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H&¨\u0006\u0006"}, d2 = {"Lcom/talabat/verticals/ui/customViewLCAware/adapter/VerticalsSubListViewHolder$ItemCLickListener;", "", "onItemCLicked", "", "deepLink", "", "com_talabat_NewArchi_VerticalsSquad_VerticalsSquad"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public interface ItemCLickListener {
        void onItemCLicked(@Nullable String str);
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public VerticalsSubListViewHolder(@NotNull View view) {
        super(view);
        Intrinsics.checkNotNullParameter(view, "itemView");
    }

    public final void bindItem(@NotNull ArrayList<Vertical> arrayList, @NotNull ItemCLickListener itemCLickListener) {
        Intrinsics.checkNotNullParameter(arrayList, "subVerticals");
        Intrinsics.checkNotNullParameter(itemCLickListener, ServiceSpecificExtraArgs.CastExtraArgs.LISTENER);
        setMListener(itemCLickListener);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this.itemView.getContext(), 0, false);
        View view = this.itemView;
        int i11 = R.id.subVerticals_list;
        ((RecyclerView) view.findViewById(i11)).setLayoutManager(linearLayoutManager);
        setMAdapter(new VerticalsSubListAdapter());
        ((RecyclerView) this.itemView.findViewById(i11)).setAdapter(getMAdapter());
        getMAdapter().setListener(this);
        getMAdapter().setData(arrayList);
    }

    @NotNull
    public final VerticalsSubListAdapter getMAdapter() {
        VerticalsSubListAdapter verticalsSubListAdapter = this.mAdapter;
        if (verticalsSubListAdapter != null) {
            return verticalsSubListAdapter;
        }
        Intrinsics.throwUninitializedPropertyAccessException("mAdapter");
        return null;
    }

    @NotNull
    public final ItemCLickListener getMListener() {
        ItemCLickListener itemCLickListener = this.mListener;
        if (itemCLickListener != null) {
            return itemCLickListener;
        }
        Intrinsics.throwUninitializedPropertyAccessException("mListener");
        return null;
    }

    public void onItemClicked(@Nullable String str) {
        getMListener().onItemCLicked(str);
    }

    public final void setMAdapter(@NotNull VerticalsSubListAdapter verticalsSubListAdapter) {
        Intrinsics.checkNotNullParameter(verticalsSubListAdapter, "<set-?>");
        this.mAdapter = verticalsSubListAdapter;
    }

    public final void setMListener(@NotNull ItemCLickListener itemCLickListener) {
        Intrinsics.checkNotNullParameter(itemCLickListener, "<set-?>");
        this.mListener = itemCLickListener;
    }
}
