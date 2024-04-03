package com.talabat.wallet.screens.walletDashboardDetail.interactor;

import kotlin.Metadata;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\u0012\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H&J!\u0010\u0006\u001a\u00020\u00032\b\u0010\u0007\u001a\u0004\u0018\u00010\u00052\b\u0010\b\u001a\u0004\u0018\u00010\tH&¢\u0006\u0002\u0010\n¨\u0006\u000b"}, d2 = {"Lcom/talabat/wallet/screens/walletDashboardDetail/interactor/IWalletTransactionListInteractor;", "", "getOrderDetails", "", "transactionOrderId", "", "getWalletCreditTransactionDetail", "transactionType", "id", "", "(Ljava/lang/String;Ljava/lang/Integer;)V", "com_talabat_talabat_talabat"}, k = 1, mv = {1, 6, 0}, xi = 48)
public interface IWalletTransactionListInteractor {
    void getOrderDetails(@Nullable String str);

    void getWalletCreditTransactionDetail(@Nullable String str, @Nullable Integer num);
}
