package com.talabat.wallet.screens.walletTopUp;

import JsonModels.Response.WalletCalculateCashBackResponse;
import JsonModels.Response.WalletTopUpAmountSuggestionResponse;
import JsonModels.Response.WalletTopUpResponse;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&J\b\u0010\u0004\u001a\u00020\u0003H&J\b\u0010\u0005\u001a\u00020\u0003H&J\b\u0010\u0006\u001a\u00020\u0003H&J\u0012\u0010\u0007\u001a\u00020\u00032\b\u0010\b\u001a\u0004\u0018\u00010\tH&J\u0012\u0010\n\u001a\u00020\u00032\b\u0010\u000b\u001a\u0004\u0018\u00010\fH&J\u0010\u0010\r\u001a\u00020\u00032\u0006\u0010\u000e\u001a\u00020\u000fH&¨\u0006\u0010"}, d2 = {"Lcom/talabat/wallet/screens/walletTopUp/WalletTopUpListener;", "", "onGetAllWalletTopUpAmountSuggestionError", "", "onNetworkError", "onServerError", "onTopUpServerError", "onWalletAllCreditCardsReceived", "walletTopUpAmountSuggestionResponse", "LJsonModels/Response/WalletTopUpAmountSuggestionResponse;", "onWalletCalculateCashBackReceived", "walletCalculateCashBackResponse", "LJsonModels/Response/WalletCalculateCashBackResponse;", "onWalletTopUpReceived", "walletTopUpResponse", "LJsonModels/Response/WalletTopUpResponse;", "com_talabat_talabat_talabat"}, k = 1, mv = {1, 6, 0}, xi = 48)
public interface WalletTopUpListener {
    void onGetAllWalletTopUpAmountSuggestionError();

    void onNetworkError();

    void onServerError();

    void onTopUpServerError();

    void onWalletAllCreditCardsReceived(@Nullable WalletTopUpAmountSuggestionResponse walletTopUpAmountSuggestionResponse);

    void onWalletCalculateCashBackReceived(@Nullable WalletCalculateCashBackResponse walletCalculateCashBackResponse);

    void onWalletTopUpReceived(@NotNull WalletTopUpResponse walletTopUpResponse);
}
