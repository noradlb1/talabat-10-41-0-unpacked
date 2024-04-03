package com.talabat.wallet.screens.walletDashboard.interactor;

import JsonModels.Response.WalletTransactionListDataItem;
import JsonModels.Response.WalletTransactionListDataModel;
import JsonModels.Response.WalletTransactionListResponse;
import java.util.Set;
import kotlin.Metadata;
import library.talabat.mvp.IGlobalInteractor;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\"\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\u000e\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003H&J:\u0010\u0005\u001a\u00020\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\b2\b\u0010\t\u001a\u0004\u0018\u00010\b2\b\u0010\n\u001a\u0004\u0018\u00010\b2\b\u0010\u000b\u001a\u0004\u0018\u00010\b2\b\u0010\f\u001a\u0004\u0018\u00010\rH&J\u001c\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u00112\b\u0010\u0012\u001a\u0004\u0018\u00010\rH&¨\u0006\u0013"}, d2 = {"Lcom/talabat/wallet/screens/walletDashboard/interactor/IWalletTransactionDashboardScreenInteractor;", "Llibrary/talabat/mvp/IGlobalInteractor;", "getAllowCountryListForSendGift", "", "", "getWalletCreditTransactionList", "", "countryCode", "", "skip", "numberOfItemsPerPage", "selectedLanguage", "lastTransactionModel", "LJsonModels/Response/WalletTransactionListDataItem$TransactionModel;", "getWalletTransactionListDataModel", "LJsonModels/Response/WalletTransactionListDataModel;", "response", "LJsonModels/Response/WalletTransactionListResponse;", "transactionModel", "com_talabat_talabat_talabat"}, k = 1, mv = {1, 6, 0}, xi = 48)
public interface IWalletTransactionDashboardScreenInteractor extends IGlobalInteractor {
    @NotNull
    Set<Integer> getAllowCountryListForSendGift();

    void getWalletCreditTransactionList(@Nullable String str, @Nullable String str2, @Nullable String str3, @Nullable String str4, @Nullable WalletTransactionListDataItem.TransactionModel transactionModel);

    @NotNull
    WalletTransactionListDataModel getWalletTransactionListDataModel(@Nullable WalletTransactionListResponse walletTransactionListResponse, @Nullable WalletTransactionListDataItem.TransactionModel transactionModel);
}
