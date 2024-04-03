package com.talabat.wallet.screens.walletDashboard;

import JsonModels.Response.WalletTransactionListDataModel;
import kotlin.Metadata;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&J\b\u0010\u0004\u001a\u00020\u0003H&J\u0012\u0010\u0005\u001a\u00020\u00032\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007H&¨\u0006\b"}, d2 = {"Lcom/talabat/wallet/screens/walletDashboard/WalletTransactionDashboardScreenListener;", "", "onNetworkError", "", "onServerError", "onWalletCreditTransactionListReceived", "walletTransactionListDataModel", "LJsonModels/Response/WalletTransactionListDataModel;", "com_talabat_talabat_talabat"}, k = 1, mv = {1, 6, 0}, xi = 48)
public interface WalletTransactionDashboardScreenListener {
    void onNetworkError();

    void onServerError();

    void onWalletCreditTransactionListReceived(@Nullable WalletTransactionListDataModel walletTransactionListDataModel);
}
