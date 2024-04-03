package com.talabat.growth.ui.vouchers.list;

import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.talabat.talabatcommon.views.vouchers.bottomSheetButton.model.VoucherItemDisplayModel;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B-\u0012\u000e\b\u0002\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004\u0012\u0016\b\u0002\u0010\u0006\u001a\u0010\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\b\u0018\u00010\u0007¢\u0006\u0002\u0010\tJ\u0014\u0010\n\u001a\u00020\b2\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\u00050\fJ\b\u0010\r\u001a\u00020\u000eH\u0016J\u0018\u0010\u000f\u001a\u00020\b2\u0006\u0010\u0010\u001a\u00020\u00022\u0006\u0010\u0011\u001a\u00020\u000eH\u0016J\u0018\u0010\u0012\u001a\u00020\u00022\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u000eH\u0016J\u0014\u0010\u0016\u001a\u00020\b2\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\u00050\fR\u001c\u0010\u0006\u001a\u0010\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\b\u0018\u00010\u0007X\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004X\u000e¢\u0006\u0002\n\u0000¨\u0006\u0017"}, d2 = {"Lcom/talabat/growth/ui/vouchers/list/VouchersListAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lcom/talabat/growth/ui/vouchers/list/VoucherItemViewHolder;", "pointsItems", "", "Lcom/talabat/talabatcommon/views/vouchers/bottomSheetButton/model/VoucherItemDisplayModel;", "onItemClicked", "Lkotlin/Function1;", "", "(Ljava/util/List;Lkotlin/jvm/functions/Function1;)V", "addToPointHistoryItems", "items", "", "getItemCount", "", "onBindViewHolder", "voucherItemViewHolder", "position", "onCreateViewHolder", "parentView", "Landroid/view/ViewGroup;", "p1", "updatePointHistory", "com_talabat_NewArchi_GrowthSquad_GrowthSquad"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class VouchersListAdapter extends RecyclerView.Adapter<VoucherItemViewHolder> {
    @Nullable
    private final Function1<VoucherItemDisplayModel, Unit> onItemClicked;
    @NotNull
    private List<VoucherItemDisplayModel> pointsItems;

    public VouchersListAdapter() {
        this((List) null, (Function1) null, 3, (DefaultConstructorMarker) null);
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ VouchersListAdapter(List list, Function1 function1, int i11, DefaultConstructorMarker defaultConstructorMarker) {
        this((i11 & 1) != 0 ? new ArrayList() : list, (i11 & 2) != 0 ? null : function1);
    }

    public final void addToPointHistoryItems(@NotNull List<VoucherItemDisplayModel> list) {
        Intrinsics.checkNotNullParameter(list, FirebaseAnalytics.Param.ITEMS);
        int size = this.pointsItems.size();
        int size2 = list.size();
        this.pointsItems.addAll(list);
        notifyItemRangeChanged(size, size2);
    }

    public int getItemCount() {
        return this.pointsItems.size();
    }

    public final void updatePointHistory(@NotNull List<VoucherItemDisplayModel> list) {
        Intrinsics.checkNotNullParameter(list, FirebaseAnalytics.Param.ITEMS);
        this.pointsItems = CollectionsKt___CollectionsKt.toMutableList(list);
        notifyDataSetChanged();
    }

    public void onBindViewHolder(@NotNull VoucherItemViewHolder voucherItemViewHolder, int i11) {
        Intrinsics.checkNotNullParameter(voucherItemViewHolder, "voucherItemViewHolder");
        voucherItemViewHolder.populate(this.pointsItems.get(i11));
        VouchersListAdapterKt.onItemClick(voucherItemViewHolder, this.pointsItems.get(i11), this.onItemClicked);
    }

    @NotNull
    public VoucherItemViewHolder onCreateViewHolder(@NotNull ViewGroup viewGroup, int i11) {
        Intrinsics.checkNotNullParameter(viewGroup, "parentView");
        return new VoucherItemViewHolder(viewGroup);
    }

    public VouchersListAdapter(@NotNull List<VoucherItemDisplayModel> list, @Nullable Function1<? super VoucherItemDisplayModel, Unit> function1) {
        Intrinsics.checkNotNullParameter(list, "pointsItems");
        this.pointsItems = list;
        this.onItemClicked = function1;
    }
}
