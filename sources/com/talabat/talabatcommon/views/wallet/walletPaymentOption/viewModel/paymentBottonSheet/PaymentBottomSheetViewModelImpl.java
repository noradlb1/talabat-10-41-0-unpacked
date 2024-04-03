package com.talabat.talabatcommon.views.wallet.walletPaymentOption.viewModel.paymentBottonSheet;

import com.talabat.talabatcommon.feature.walletPayment.model.request.WalletPaymentFeature;
import com.talabat.talabatcommon.views.wallet.subscription.model.PaymentInfoDisplayModel;
import com.talabat.talabatcommon.views.wallet.walletPaymentOption.model.WalletBottomSheetPaymentMode;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002R\u001a\u0010\u0003\u001a\u00020\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\b¨\u0006\t"}, d2 = {"Lcom/talabat/talabatcommon/views/wallet/walletPaymentOption/viewModel/paymentBottonSheet/PaymentBottomSheetViewModelImpl;", "Lcom/talabat/talabatcommon/views/wallet/walletPaymentOption/viewModel/paymentBottonSheet/PaymentBottomSheetViewModel;", "()V", "paymentInfoDisplayModel", "Lcom/talabat/talabatcommon/views/wallet/subscription/model/PaymentInfoDisplayModel;", "getPaymentInfoDisplayModel", "()Lcom/talabat/talabatcommon/views/wallet/subscription/model/PaymentInfoDisplayModel;", "setPaymentInfoDisplayModel", "(Lcom/talabat/talabatcommon/views/wallet/subscription/model/PaymentInfoDisplayModel;)V", "com_talabat_NewArchi_TalabatCommon_TalabatCommon"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class PaymentBottomSheetViewModelImpl extends PaymentBottomSheetViewModel {
    @NotNull
    private PaymentInfoDisplayModel paymentInfoDisplayModel;

    public PaymentBottomSheetViewModelImpl() {
        PaymentInfoDisplayModel paymentInfoDisplayModel2 = r0;
        PaymentInfoDisplayModel paymentInfoDisplayModel3 = new PaymentInfoDisplayModel((String) null, (String) null, (String) null, 0, false, (String) null, (String) null, 0.0f, (WalletBottomSheetPaymentMode) null, (String) null, (String) null, (WalletPaymentFeature) null, (String) null, false, (String) null, 0.0f, (String) null, 131071, (DefaultConstructorMarker) null);
        this.paymentInfoDisplayModel = paymentInfoDisplayModel2;
    }

    @NotNull
    public PaymentInfoDisplayModel getPaymentInfoDisplayModel() {
        return this.paymentInfoDisplayModel;
    }

    public void setPaymentInfoDisplayModel(@NotNull PaymentInfoDisplayModel paymentInfoDisplayModel2) {
        Intrinsics.checkNotNullParameter(paymentInfoDisplayModel2, "<set-?>");
        this.paymentInfoDisplayModel = paymentInfoDisplayModel2;
    }
}
