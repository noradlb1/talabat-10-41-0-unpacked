package com.talabat.wallet.screens.walletManageCard.view;

import JsonModels.Response.WalletCreditCardGetListDataModel;
import JsonModels.Response.WalletDeleteCreditCardsResponse;
import JsonModels.Response.WalletSetDefaultCreditCardResponse;
import com.talabat.helpers.Talabat;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\u0012\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H&J\u0012\u0010\u0006\u001a\u00020\u00032\b\u0010\u0007\u001a\u0004\u0018\u00010\bH&J\b\u0010\t\u001a\u00020\u0003H&J\b\u0010\n\u001a\u00020\u0003H&J\u0010\u0010\u000b\u001a\u00020\u00032\u0006\u0010\f\u001a\u00020\rH&J\b\u0010\u000e\u001a\u00020\u0003H&¨\u0006\u000f"}, d2 = {"Lcom/talabat/wallet/screens/walletManageCard/view/WalletManageCreditCardsView;", "Lcom/talabat/helpers/Talabat;", "addAllWalletCreditCards", "", "walletCreditCardGetListDataModel", "LJsonModels/Response/WalletCreditCardGetListDataModel;", "addDefaultCreditCard", "walletSetDefaultCreditCardResponse", "LJsonModels/Response/WalletSetDefaultCreditCardResponse;", "deleteAllCardsCompleted", "displayServerErrorMessage", "removeDeletedCards", "walletDeleteCreditCardsResponse", "LJsonModels/Response/WalletDeleteCreditCardsResponse;", "setupViewsBeforeServiceRequest", "com_talabat_talabat_talabat"}, k = 1, mv = {1, 6, 0}, xi = 48)
public interface WalletManageCreditCardsView extends Talabat {
    void addAllWalletCreditCards(@Nullable WalletCreditCardGetListDataModel walletCreditCardGetListDataModel);

    void addDefaultCreditCard(@Nullable WalletSetDefaultCreditCardResponse walletSetDefaultCreditCardResponse);

    void deleteAllCardsCompleted();

    void displayServerErrorMessage();

    void removeDeletedCards(@NotNull WalletDeleteCreditCardsResponse walletDeleteCreditCardsResponse);

    void setupViewsBeforeServiceRequest();
}
