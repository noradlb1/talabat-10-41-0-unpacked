package com.talabat.feature.customervouchersswimlane.presentation.adapter;

import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBinding;
import com.talabat.features.swimlanevoucherslist.domain.model.CustomerVoucher;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b&\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0010\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH&¨\u0006\t"}, d2 = {"Lcom/talabat/feature/customervouchersswimlane/presentation/adapter/VouchersSwimLaneViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "view", "Landroidx/viewbinding/ViewBinding;", "(Landroidx/viewbinding/ViewBinding;)V", "bind", "", "voucher", "Lcom/talabat/features/swimlanevoucherslist/domain/model/CustomerVoucher;", "com_talabat_feature_customer-vouchers-swimlane_presentation_presentation"}, k = 1, mv = {1, 6, 0}, xi = 48)
public abstract class VouchersSwimLaneViewHolder extends RecyclerView.ViewHolder {
    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public VouchersSwimLaneViewHolder(@NotNull ViewBinding viewBinding) {
        super(viewBinding.getRoot());
        Intrinsics.checkNotNullParameter(viewBinding, "view");
    }

    public abstract void bind(@NotNull CustomerVoucher customerVoucher);
}
