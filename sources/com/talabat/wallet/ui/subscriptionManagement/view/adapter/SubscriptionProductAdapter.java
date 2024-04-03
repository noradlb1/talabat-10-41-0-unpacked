package com.talabat.wallet.ui.subscriptionManagement.view.adapter;

import android.view.ViewGroup;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.talabat.talabatcommon.views.wallet.subscription.model.SubscriptionProductDisplayModel;
import com.talabat.wallet.R;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010 \n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0003J\u0014\u0010\u000b\u001a\u00020\f2\f\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u00060\u000eJ\b\u0010\u000f\u001a\u00020\u0010H\u0016J\u0018\u0010\u0011\u001a\u00020\f2\u0006\u0010\u0012\u001a\u00020\u00022\u0006\u0010\u0013\u001a\u00020\u0010H\u0016J\u0018\u0010\u0014\u001a\u00020\u00022\u0006\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u0010H\u0016R \u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\n¨\u0006\u0018"}, d2 = {"Lcom/talabat/wallet/ui/subscriptionManagement/view/adapter/SubscriptionProductAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "()V", "dataItems", "", "Lcom/talabat/talabatcommon/views/wallet/subscription/model/SubscriptionProductDisplayModel;", "getDataItems", "()Ljava/util/List;", "setDataItems", "(Ljava/util/List;)V", "addItems", "", "newItems", "", "getItemCount", "", "onBindViewHolder", "holder", "position", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "com_talabat_NewArchi_WalletSquad_WalletSquad"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class SubscriptionProductAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    @NotNull
    private List<SubscriptionProductDisplayModel> dataItems = new ArrayList();

    public final void addItems(@NotNull List<SubscriptionProductDisplayModel> list) {
        Intrinsics.checkNotNullParameter(list, "newItems");
        this.dataItems.clear();
        this.dataItems.addAll(list);
        notifyDataSetChanged();
    }

    @NotNull
    public final List<SubscriptionProductDisplayModel> getDataItems() {
        return this.dataItems;
    }

    public int getItemCount() {
        return this.dataItems.size();
    }

    public void onBindViewHolder(@NotNull RecyclerView.ViewHolder viewHolder, int i11) {
        Intrinsics.checkNotNullParameter(viewHolder, "holder");
        SubscriptionProductDisplayModel subscriptionProductDisplayModel = this.dataItems.get(i11);
        ((TextView) viewHolder.itemView.findViewById(R.id.product_title)).setText(subscriptionProductDisplayModel.getTitle());
        ((TextView) viewHolder.itemView.findViewById(R.id.product_detail)).setText(subscriptionProductDisplayModel.getDescription());
    }

    @NotNull
    public RecyclerView.ViewHolder onCreateViewHolder(@NotNull ViewGroup viewGroup, int i11) {
        Intrinsics.checkNotNullParameter(viewGroup, "parent");
        return SubscriptionProductViewHolder.Companion.from(viewGroup);
    }

    public final void setDataItems(@NotNull List<SubscriptionProductDisplayModel> list) {
        Intrinsics.checkNotNullParameter(list, "<set-?>");
        this.dataItems = list;
    }
}
