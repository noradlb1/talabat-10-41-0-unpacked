package com.talabat.growth.ui.loyalty.history;

import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.talabat.growth.ui.loyalty.models.LoyaltyPointsDisplayModel;
import com.talabat.growth.ui.loyalty.views.LoyaltyPointsHistoryItemViewHolder;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0015\u0012\u000e\b\u0002\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004¢\u0006\u0002\u0010\u0006J\u0014\u0010\u0007\u001a\u00020\b2\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004J\b\u0010\n\u001a\u00020\u000bH\u0016J\u0018\u0010\f\u001a\u00020\b2\u0006\u0010\r\u001a\u00020\u00022\u0006\u0010\u000e\u001a\u00020\u000bH\u0016J\u0018\u0010\u000f\u001a\u00020\u00022\u0006\u0010\r\u001a\u00020\u00102\u0006\u0010\u000e\u001a\u00020\u000bH\u0016J\u0014\u0010\u0011\u001a\u00020\b2\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004R\u0014\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004X\u000e¢\u0006\u0002\n\u0000¨\u0006\u0012"}, d2 = {"Lcom/talabat/growth/ui/loyalty/history/LoyaltyHistoryListAdaptor;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lcom/talabat/growth/ui/loyalty/views/LoyaltyPointsHistoryItemViewHolder;", "pointsItems", "", "Lcom/talabat/growth/ui/loyalty/models/LoyaltyPointsDisplayModel;", "(Ljava/util/List;)V", "addToPointHistoryItems", "", "items", "getItemCount", "", "onBindViewHolder", "p0", "p1", "onCreateViewHolder", "Landroid/view/ViewGroup;", "updatePointHistory", "com_talabat_NewArchi_GrowthSquad_GrowthSquad"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class LoyaltyHistoryListAdaptor extends RecyclerView.Adapter<LoyaltyPointsHistoryItemViewHolder> {
    @NotNull
    private List<LoyaltyPointsDisplayModel> pointsItems;

    public LoyaltyHistoryListAdaptor() {
        this((List) null, 1, (DefaultConstructorMarker) null);
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ LoyaltyHistoryListAdaptor(List list, int i11, DefaultConstructorMarker defaultConstructorMarker) {
        this((i11 & 1) != 0 ? new ArrayList() : list);
    }

    public final void addToPointHistoryItems(@NotNull List<LoyaltyPointsDisplayModel> list) {
        Intrinsics.checkNotNullParameter(list, FirebaseAnalytics.Param.ITEMS);
        int size = this.pointsItems.size();
        int size2 = list.size();
        this.pointsItems.addAll(list);
        notifyItemRangeChanged(size, size2);
    }

    public int getItemCount() {
        return this.pointsItems.size();
    }

    public final void updatePointHistory(@NotNull List<LoyaltyPointsDisplayModel> list) {
        Intrinsics.checkNotNullParameter(list, FirebaseAnalytics.Param.ITEMS);
        this.pointsItems = list;
        notifyDataSetChanged();
    }

    public void onBindViewHolder(@NotNull LoyaltyPointsHistoryItemViewHolder loyaltyPointsHistoryItemViewHolder, int i11) {
        Intrinsics.checkNotNullParameter(loyaltyPointsHistoryItemViewHolder, "p0");
        loyaltyPointsHistoryItemViewHolder.populate(this.pointsItems.get(i11));
    }

    @NotNull
    public LoyaltyPointsHistoryItemViewHolder onCreateViewHolder(@NotNull ViewGroup viewGroup, int i11) {
        Intrinsics.checkNotNullParameter(viewGroup, "p0");
        return new LoyaltyPointsHistoryItemViewHolder(viewGroup);
    }

    public LoyaltyHistoryListAdaptor(@NotNull List<LoyaltyPointsDisplayModel> list) {
        Intrinsics.checkNotNullParameter(list, "pointsItems");
        this.pointsItems = list;
    }
}
