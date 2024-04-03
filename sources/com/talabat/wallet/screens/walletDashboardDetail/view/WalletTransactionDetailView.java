package com.talabat.wallet.screens.walletDashboardDetail.view;

import JsonModels.Response.WalletCreditTransactionDetailObject;
import JsonModels.Response.WalletCreditTransactionDetailResponse;
import com.talabat.helpers.Talabat;
import datamodels.OrderDetails;
import kotlin.Metadata;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\bf\u0018\u00002\u00020\u0001J\u0012\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H&J\b\u0010\u0006\u001a\u00020\u0003H&J\u0012\u0010\u0007\u001a\u00020\u00032\b\u0010\b\u001a\u0004\u0018\u00010\tH&J\b\u0010\n\u001a\u00020\u0003H&J\u0012\u0010\u000b\u001a\u00020\u00032\b\u0010\f\u001a\u0004\u0018\u00010\rH&J\u0012\u0010\u000e\u001a\u00020\u00032\b\u0010\f\u001a\u0004\u0018\u00010\rH&J\u0012\u0010\u000f\u001a\u00020\u00032\b\u0010\f\u001a\u0004\u0018\u00010\rH&J\u0012\u0010\u0010\u001a\u00020\u00032\b\u0010\f\u001a\u0004\u0018\u00010\rH&J\u0012\u0010\u0011\u001a\u00020\u00032\b\u0010\f\u001a\u0004\u0018\u00010\rH&J\u0012\u0010\u0012\u001a\u00020\u00032\b\u0010\f\u001a\u0004\u0018\u00010\rH&J\u0012\u0010\u0013\u001a\u00020\u00032\b\u0010\f\u001a\u0004\u0018\u00010\rH&¨\u0006\u0014"}, d2 = {"Lcom/talabat/wallet/screens/walletDashboardDetail/view/WalletTransactionDetailView;", "Lcom/talabat/helpers/Talabat;", "addWalletTransactionDetail", "", "walletCreditTransactionDetailResponse", "LJsonModels/Response/WalletCreditTransactionDetailResponse;", "displayServerErrorMessage", "onOrderDetailsRecieved", "orderDetails", "Ldatamodels/OrderDetails;", "setupProgressBarBeforeServiceRequest", "showCashBackReversalTransactionTypeView", "walletCreditTransactionDetailObject", "LJsonModels/Response/WalletCreditTransactionDetailObject;", "showCreditExpiredTransactionTypeView", "showCreditVoucherTransactionTypeView", "showPaidTransactionTypeView", "showRechargeTransactionTypeView", "showRefundTransactionTypeView", "showRiderTipTransactionTypeView", "com_talabat_talabat_talabat"}, k = 1, mv = {1, 6, 0}, xi = 48)
public interface WalletTransactionDetailView extends Talabat {
    void addWalletTransactionDetail(@Nullable WalletCreditTransactionDetailResponse walletCreditTransactionDetailResponse);

    void displayServerErrorMessage();

    void onOrderDetailsRecieved(@Nullable OrderDetails orderDetails);

    void setupProgressBarBeforeServiceRequest();

    void showCashBackReversalTransactionTypeView(@Nullable WalletCreditTransactionDetailObject walletCreditTransactionDetailObject);

    void showCreditExpiredTransactionTypeView(@Nullable WalletCreditTransactionDetailObject walletCreditTransactionDetailObject);

    void showCreditVoucherTransactionTypeView(@Nullable WalletCreditTransactionDetailObject walletCreditTransactionDetailObject);

    void showPaidTransactionTypeView(@Nullable WalletCreditTransactionDetailObject walletCreditTransactionDetailObject);

    void showRechargeTransactionTypeView(@Nullable WalletCreditTransactionDetailObject walletCreditTransactionDetailObject);

    void showRefundTransactionTypeView(@Nullable WalletCreditTransactionDetailObject walletCreditTransactionDetailObject);

    void showRiderTipTransactionTypeView(@Nullable WalletCreditTransactionDetailObject walletCreditTransactionDetailObject);
}
