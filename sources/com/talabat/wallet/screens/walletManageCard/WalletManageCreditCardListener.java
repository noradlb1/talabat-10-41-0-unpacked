package com.talabat.wallet.screens.walletManageCard;

import JsonModels.Response.WalletCreditCardGetListDataModel;
import JsonModels.Response.WalletDeleteCreditCardsResponse;
import JsonModels.Response.WalletSetDefaultCreditCardResponse;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&J\b\u0010\u0004\u001a\u00020\u0003H&J\u0012\u0010\u0005\u001a\u00020\u00032\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007H&J\u0012\u0010\b\u001a\u00020\u00032\b\u0010\t\u001a\u0004\u0018\u00010\nH&J\b\u0010\u000b\u001a\u00020\u0003H&J\u0010\u0010\f\u001a\u00020\u00032\u0006\u0010\r\u001a\u00020\u000eH&¨\u0006\u000f"}, d2 = {"Lcom/talabat/wallet/screens/walletManageCard/WalletManageCreditCardListener;", "", "onNetworkError", "", "onServerError", "onSetDefaultCreditCardsReceived", "walletSetDefaultCreditCardResponse", "LJsonModels/Response/WalletSetDefaultCreditCardResponse;", "onWalletAllCreditCardsReceived", "walletCreditCardGetListDataModel", "LJsonModels/Response/WalletCreditCardGetListDataModel;", "onWalletDeleteAllCompleted", "onWalletDeleteCardResponseReceived", "walletDeleteCreditCardsResponse", "LJsonModels/Response/WalletDeleteCreditCardsResponse;", "com_talabat_talabat_talabat"}, k = 1, mv = {1, 6, 0}, xi = 48)
public interface WalletManageCreditCardListener {
    void onNetworkError();

    void onServerError();

    void onSetDefaultCreditCardsReceived(@Nullable WalletSetDefaultCreditCardResponse walletSetDefaultCreditCardResponse);

    void onWalletAllCreditCardsReceived(@Nullable WalletCreditCardGetListDataModel walletCreditCardGetListDataModel);

    void onWalletDeleteAllCompleted();

    void onWalletDeleteCardResponseReceived(@NotNull WalletDeleteCreditCardsResponse walletDeleteCreditCardsResponse);
}
