package com.talabat.wallet.screens.walletAddCard;

import JsonModels.Response.WalletSaveCreditCardResponse;
import com.talabat.talabatcommon.views.wallet.walletCardManagement.viewModel.CheckoutResponse;
import datamodels.WalletCreditCard;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&J\u0018\u0010\u0006\u001a\u00020\u00032\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nH&J\b\u0010\u000b\u001a\u00020\u0003H&J\b\u0010\f\u001a\u00020\u0003H&J\u001a\u0010\r\u001a\u00020\u00032\b\u0010\u000e\u001a\u0004\u0018\u00010\u000f2\u0006\u0010\t\u001a\u00020\nH&¨\u0006\u0010"}, d2 = {"Lcom/talabat/wallet/screens/walletAddCard/WalletAddCardListener;", "", "onCardErrorReceived", "", "message", "", "onCheckoutResponseReceived", "response", "Lcom/talabat/talabatcommon/views/wallet/walletCardManagement/viewModel/CheckoutResponse;", "walletCreditCard", "Ldatamodels/WalletCreditCard;", "onNetworkError", "onServerError", "onWalletSaveCardResponseReceived", "walletSaveCreditCardResponse", "LJsonModels/Response/WalletSaveCreditCardResponse;", "com_talabat_talabat_talabat"}, k = 1, mv = {1, 6, 0}, xi = 48)
public interface WalletAddCardListener {
    void onCardErrorReceived(@NotNull String str);

    void onCheckoutResponseReceived(@NotNull CheckoutResponse checkoutResponse, @NotNull WalletCreditCard walletCreditCard);

    void onNetworkError();

    void onServerError();

    void onWalletSaveCardResponseReceived(@Nullable WalletSaveCreditCardResponse walletSaveCreditCardResponse, @NotNull WalletCreditCard walletCreditCard);
}
