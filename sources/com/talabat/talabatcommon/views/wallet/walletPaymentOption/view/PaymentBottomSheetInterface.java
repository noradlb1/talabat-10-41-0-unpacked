package com.talabat.talabatcommon.views.wallet.walletPaymentOption.view;

import com.talabat.talabatcommon.model.wallet.WalletCardDisplayModel;
import com.talabat.talabatcommon.views.wallet.walletPaymentOption.model.PaymentMethod;
import com.talabat.talabatcommon.views.wallet.walletPaymentOption.model.WalletPaymentStatus;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\bf\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H\u0016J\u0018\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH&J\u0018\u0010\t\u001a\u00020\u00032\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\rH&¨\u0006\u000e"}, d2 = {"Lcom/talabat/talabatcommon/views/wallet/walletPaymentOption/view/PaymentBottomSheetInterface;", "", "getCardClicked", "", "sendCardDetailsToParentScreen", "card", "Lcom/talabat/talabatcommon/model/wallet/WalletCardDisplayModel;", "paymentMethod", "Lcom/talabat/talabatcommon/views/wallet/walletPaymentOption/model/PaymentMethod;", "sendPaymentWidgetClosedEvent", "paymentStatus", "Lcom/talabat/talabatcommon/views/wallet/walletPaymentOption/model/WalletPaymentStatus;", "transactionId", "", "com_talabat_NewArchi_TalabatCommon_TalabatCommon"}, k = 1, mv = {1, 6, 0}, xi = 48)
public interface PaymentBottomSheetInterface {

    @Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
    public static final class DefaultImpls {
        public static void getCardClicked(@NotNull PaymentBottomSheetInterface paymentBottomSheetInterface) {
        }
    }

    void getCardClicked();

    void sendCardDetailsToParentScreen(@NotNull WalletCardDisplayModel walletCardDisplayModel, @NotNull PaymentMethod paymentMethod);

    void sendPaymentWidgetClosedEvent(@NotNull WalletPaymentStatus walletPaymentStatus, @NotNull String str);
}
