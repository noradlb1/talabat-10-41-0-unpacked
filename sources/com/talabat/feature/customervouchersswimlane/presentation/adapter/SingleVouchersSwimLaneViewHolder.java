package com.talabat.feature.customervouchersswimlane.presentation.adapter;

import android.view.View;
import android.widget.ImageView;
import com.bumptech.glide.Glide;
import com.bumptech.glide.RequestBuilder;
import com.talabat.feature.swimlanevoucherslist.presentation.databinding.DarkstoresSingleItemCustomerVouchersSwimlaneBinding;
import com.talabat.features.swimlanevoucherslist.domain.model.CustomerVoucher;
import com.talabat.homescreen.network.UrlConstantsKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import sl.a;

@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\u0010\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B'\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0018\u0010\u0004\u001a\u0014\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\b0\u0005¢\u0006\u0002\u0010\tJ\u0010\u0010\n\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\u0006H\u0016R \u0010\u0004\u001a\u0014\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\b0\u0005X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000¨\u0006\f"}, d2 = {"Lcom/talabat/feature/customervouchersswimlane/presentation/adapter/SingleVouchersSwimLaneViewHolder;", "Lcom/talabat/feature/customervouchersswimlane/presentation/adapter/VouchersSwimLaneViewHolder;", "view", "Lcom/talabat/feature/swimlanevoucherslist/presentation/databinding/DarkstoresSingleItemCustomerVouchersSwimlaneBinding;", "onVoucherClick", "Lkotlin/Function2;", "Lcom/talabat/features/swimlanevoucherslist/domain/model/CustomerVoucher;", "", "", "(Lcom/talabat/feature/swimlanevoucherslist/presentation/databinding/DarkstoresSingleItemCustomerVouchersSwimlaneBinding;Lkotlin/jvm/functions/Function2;)V", "bind", "voucher", "com_talabat_feature_customer-vouchers-swimlane_presentation_presentation"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class SingleVouchersSwimLaneViewHolder extends VouchersSwimLaneViewHolder {
    @NotNull
    private final Function2<CustomerVoucher, Integer, Unit> onVoucherClick;
    @NotNull
    private final DarkstoresSingleItemCustomerVouchersSwimlaneBinding view;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public SingleVouchersSwimLaneViewHolder(@NotNull DarkstoresSingleItemCustomerVouchersSwimlaneBinding darkstoresSingleItemCustomerVouchersSwimlaneBinding, @NotNull Function2<? super CustomerVoucher, ? super Integer, Unit> function2) {
        super(darkstoresSingleItemCustomerVouchersSwimlaneBinding);
        Intrinsics.checkNotNullParameter(darkstoresSingleItemCustomerVouchersSwimlaneBinding, "view");
        Intrinsics.checkNotNullParameter(function2, "onVoucherClick");
        this.view = darkstoresSingleItemCustomerVouchersSwimlaneBinding;
        this.onVoucherClick = function2;
    }

    /* access modifiers changed from: private */
    /* renamed from: bind$lambda-1$lambda-0  reason: not valid java name */
    public static final void m10146bind$lambda1$lambda0(SingleVouchersSwimLaneViewHolder singleVouchersSwimLaneViewHolder, CustomerVoucher customerVoucher, View view2) {
        Intrinsics.checkNotNullParameter(singleVouchersSwimLaneViewHolder, "this$0");
        Intrinsics.checkNotNullParameter(customerVoucher, "$voucher");
        singleVouchersSwimLaneViewHolder.onVoucherClick.invoke(customerVoucher, Integer.valueOf(singleVouchersSwimLaneViewHolder.getAdapterPosition()));
    }

    public void bind(@NotNull CustomerVoucher customerVoucher) {
        Intrinsics.checkNotNullParameter(customerVoucher, UrlConstantsKt.HEADER_VOUCHER);
        DarkstoresSingleItemCustomerVouchersSwimlaneBinding darkstoresSingleItemCustomerVouchersSwimlaneBinding = this.view;
        darkstoresSingleItemCustomerVouchersSwimlaneBinding.voucherRoot.setOnClickListener(new a(this, customerVoucher));
        darkstoresSingleItemCustomerVouchersSwimlaneBinding.voucherTitle.setText(customerVoucher.getVoucherTitle());
        darkstoresSingleItemCustomerVouchersSwimlaneBinding.voucherDesc.setText(customerVoucher.getVoucherDescription());
        ((RequestBuilder) Glide.with(this.view.getRoot().getContext()).load(customerVoucher.getImageUrl()).fitCenter()).into((ImageView) darkstoresSingleItemCustomerVouchersSwimlaneBinding.voucherImage);
    }
}
