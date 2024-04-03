package com.talabat.wallet.screens.walletTopUp.interactor;

import JsonModels.Request.WalletCalculateCashBackRequest;
import JsonModels.Request.WalletTopUpRequest;
import kotlin.Metadata;
import library.talabat.mvp.IGlobalInteractor;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\u0012\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H&J\u0010\u0010\u0006\u001a\u00020\u00032\u0006\u0010\u0007\u001a\u00020\bH&J\u0010\u0010\t\u001a\u00020\u00032\u0006\u0010\n\u001a\u00020\u000bH&¨\u0006\f"}, d2 = {"Lcom/talabat/wallet/screens/walletTopUp/interactor/IWalletTopUpScreenInteractor;", "Llibrary/talabat/mvp/IGlobalInteractor;", "getAllWalletTopUpAmountSuggestion", "", "countryId", "", "getCalculatedCashBack", "walletCalculateCashBackRequest", "LJsonModels/Request/WalletCalculateCashBackRequest;", "getWalletTopUp", "walletTopUpRequest", "LJsonModels/Request/WalletTopUpRequest;", "com_talabat_talabat_talabat"}, k = 1, mv = {1, 6, 0}, xi = 48)
public interface IWalletTopUpScreenInteractor extends IGlobalInteractor {
    void getAllWalletTopUpAmountSuggestion(@Nullable String str);

    void getCalculatedCashBack(@NotNull WalletCalculateCashBackRequest walletCalculateCashBackRequest);

    void getWalletTopUp(@NotNull WalletTopUpRequest walletTopUpRequest);
}
