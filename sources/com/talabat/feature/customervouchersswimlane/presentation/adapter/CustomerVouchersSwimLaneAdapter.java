package com.talabat.feature.customervouchersswimlane.presentation.adapter;

import android.view.LayoutInflater;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import com.talabat.feature.swimlanevoucherslist.presentation.databinding.DarkstoresItemCustomerVouchersSwimlaneBinding;
import com.talabat.feature.swimlanevoucherslist.presentation.databinding.DarkstoresSingleItemCustomerVouchersSwimlaneBinding;
import com.talabat.features.swimlanevoucherslist.domain.model.CustomerVoucher;
import com.talabat.talabatcommon.views.wallet.cardViewWidgets.view.DefaultCardView;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010!\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u0000 \u00172\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\u0017B\u001f\u0012\u0018\u0010\u0003\u001a\u0014\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00070\u0004¢\u0006\u0002\u0010\bJ\u0014\u0010\u000b\u001a\u00020\u00072\f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u00050\rJ\b\u0010\u000e\u001a\u00020\u0006H\u0016J\u0010\u0010\u000f\u001a\u00020\u00062\u0006\u0010\u0010\u001a\u00020\u0006H\u0016J\u0018\u0010\u0011\u001a\u00020\u00072\u0006\u0010\u0012\u001a\u00020\u00022\u0006\u0010\u0010\u001a\u00020\u0006H\u0016J\u0018\u0010\u0013\u001a\u00020\u00022\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u0006H\u0016R \u0010\u0003\u001a\u0014\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00070\u0004X\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00050\nX\u000e¢\u0006\u0002\n\u0000¨\u0006\u0018"}, d2 = {"Lcom/talabat/feature/customervouchersswimlane/presentation/adapter/CustomerVouchersSwimLaneAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lcom/talabat/feature/customervouchersswimlane/presentation/adapter/VouchersSwimLaneViewHolder;", "onVoucherClick", "Lkotlin/Function2;", "Lcom/talabat/features/swimlanevoucherslist/domain/model/CustomerVoucher;", "", "", "(Lkotlin/jvm/functions/Function2;)V", "vouchersList", "", "addVouchersList", "list", "", "getItemCount", "getItemViewType", "position", "onBindViewHolder", "holder", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "Companion", "com_talabat_feature_customer-vouchers-swimlane_presentation_presentation"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class CustomerVouchersSwimLaneAdapter extends RecyclerView.Adapter<VouchersSwimLaneViewHolder> {
    @NotNull
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    public static final int LIST = 1;
    public static final int SINGLE = 0;
    @NotNull
    private final Function2<CustomerVoucher, Integer, Unit> onVoucherClick;
    @NotNull
    private List<CustomerVoucher> vouchersList = new ArrayList();

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0006"}, d2 = {"Lcom/talabat/feature/customervouchersswimlane/presentation/adapter/CustomerVouchersSwimLaneAdapter$Companion;", "", "()V", "LIST", "", "SINGLE", "com_talabat_feature_customer-vouchers-swimlane_presentation_presentation"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public CustomerVouchersSwimLaneAdapter(@NotNull Function2<? super CustomerVoucher, ? super Integer, Unit> function2) {
        Intrinsics.checkNotNullParameter(function2, "onVoucherClick");
        this.onVoucherClick = function2;
    }

    public final void addVouchersList(@NotNull List<CustomerVoucher> list) {
        Intrinsics.checkNotNullParameter(list, DefaultCardView.CARD_LIST);
        this.vouchersList.clear();
        this.vouchersList.addAll(list);
        notifyDataSetChanged();
    }

    public int getItemCount() {
        return this.vouchersList.size();
    }

    public int getItemViewType(int i11) {
        return this.vouchersList.size() == 1 ? 0 : 1;
    }

    public void onBindViewHolder(@NotNull VouchersSwimLaneViewHolder vouchersSwimLaneViewHolder, int i11) {
        Intrinsics.checkNotNullParameter(vouchersSwimLaneViewHolder, "holder");
        vouchersSwimLaneViewHolder.bind(this.vouchersList.get(i11));
    }

    @NotNull
    public VouchersSwimLaneViewHolder onCreateViewHolder(@NotNull ViewGroup viewGroup, int i11) {
        Intrinsics.checkNotNullParameter(viewGroup, "parent");
        if (i11 == 0) {
            DarkstoresSingleItemCustomerVouchersSwimlaneBinding inflate = DarkstoresSingleItemCustomerVouchersSwimlaneBinding.inflate(LayoutInflater.from(viewGroup.getContext()), viewGroup, false);
            Intrinsics.checkNotNullExpressionValue(inflate, "inflate(LayoutInflater.f….context), parent, false)");
            return new SingleVouchersSwimLaneViewHolder(inflate, this.onVoucherClick);
        }
        DarkstoresItemCustomerVouchersSwimlaneBinding inflate2 = DarkstoresItemCustomerVouchersSwimlaneBinding.inflate(LayoutInflater.from(viewGroup.getContext()), viewGroup, false);
        Intrinsics.checkNotNullExpressionValue(inflate2, "inflate(LayoutInflater.f….context), parent, false)");
        return new VouchersListSwimLaneViewHolder(inflate2, this.onVoucherClick);
    }
}
