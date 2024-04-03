package com.talabat.wallet.screens.walletDashboardDetail.presenter;

import JsonModels.Response.WalletCreditTransactionDetailObject;
import kotlin.Metadata;
import library.talabat.mvp.IGlobalPresenter;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J\u0012\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H&J\u0010\u0010\u0006\u001a\u00020\u00032\u0006\u0010\u0007\u001a\u00020\bH&J\u001f\u0010\t\u001a\u00020\u00032\u0006\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\u000bH&¢\u0006\u0002\u0010\r¨\u0006\u000e"}, d2 = {"Lcom/talabat/wallet/screens/walletDashboardDetail/presenter/IWalletTransactionListDetailPresenter;", "Llibrary/talabat/mvp/IGlobalPresenter;", "getOrderDetailsBeforeNavigation", "", "transactionId", "", "setTransactionTypeType", "walletCreditTransactionDetailObject", "LJsonModels/Response/WalletCreditTransactionDetailObject;", "setWalletCreditTransactionDetail", "transactionType", "", "id", "(ILjava/lang/Integer;)V", "com_talabat_talabat_talabat"}, k = 1, mv = {1, 6, 0}, xi = 48)
public interface IWalletTransactionListDetailPresenter extends IGlobalPresenter {
    void getOrderDetailsBeforeNavigation(@Nullable String str);

    void setTransactionTypeType(@NotNull WalletCreditTransactionDetailObject walletCreditTransactionDetailObject);

    void setWalletCreditTransactionDetail(int i11, @Nullable Integer num);
}
