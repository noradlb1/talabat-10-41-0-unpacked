package com.talabat.talabatcommon.views.wallet.walletPaymentOption.viewModel.paymentBottonSheet;

import com.talabat.talabatcommon.views.wallet.subscription.model.PaymentInfoDisplayModel;
import com.talabat.talabatcore.viewmodel.BaseViewModel;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b&\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002R\u0018\u0010\u0003\u001a\u00020\u0004X¦\u000e¢\u0006\f\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\b¨\u0006\t"}, d2 = {"Lcom/talabat/talabatcommon/views/wallet/walletPaymentOption/viewModel/paymentBottonSheet/PaymentBottomSheetViewModel;", "Lcom/talabat/talabatcore/viewmodel/BaseViewModel;", "()V", "paymentInfoDisplayModel", "Lcom/talabat/talabatcommon/views/wallet/subscription/model/PaymentInfoDisplayModel;", "getPaymentInfoDisplayModel", "()Lcom/talabat/talabatcommon/views/wallet/subscription/model/PaymentInfoDisplayModel;", "setPaymentInfoDisplayModel", "(Lcom/talabat/talabatcommon/views/wallet/subscription/model/PaymentInfoDisplayModel;)V", "com_talabat_NewArchi_TalabatCommon_TalabatCommon"}, k = 1, mv = {1, 6, 0}, xi = 48)
public abstract class PaymentBottomSheetViewModel extends BaseViewModel {
    @NotNull
    public abstract PaymentInfoDisplayModel getPaymentInfoDisplayModel();

    public abstract void setPaymentInfoDisplayModel(@NotNull PaymentInfoDisplayModel paymentInfoDisplayModel);
}
