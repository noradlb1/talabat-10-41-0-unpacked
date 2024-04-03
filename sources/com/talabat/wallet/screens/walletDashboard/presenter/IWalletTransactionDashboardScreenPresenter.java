package com.talabat.wallet.screens.walletDashboard.presenter;

import JsonModels.Response.WalletTransactionListDataItem;
import kotlin.Metadata;
import library.talabat.mvp.IGlobalPresenter;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\"\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00052\b\u0010\u0007\u001a\u0004\u0018\u00010\bH&J\b\u0010\t\u001a\u00020\u0003H&¨\u0006\n"}, d2 = {"Lcom/talabat/wallet/screens/walletDashboard/presenter/IWalletTransactionDashboardScreenPresenter;", "Llibrary/talabat/mvp/IGlobalPresenter;", "setWalletTransactionListInfo", "", "pageNumber", "", "numberOfItemsPerPage", "lastTransactionModel", "LJsonModels/Response/WalletTransactionListDataItem$TransactionModel;", "showMenuButtonsBasedOnFlagStatus", "com_talabat_talabat_talabat"}, k = 1, mv = {1, 6, 0}, xi = 48)
public interface IWalletTransactionDashboardScreenPresenter extends IGlobalPresenter {
    void setWalletTransactionListInfo(int i11, int i12, @Nullable WalletTransactionListDataItem.TransactionModel transactionModel);

    void showMenuButtonsBasedOnFlagStatus();
}
