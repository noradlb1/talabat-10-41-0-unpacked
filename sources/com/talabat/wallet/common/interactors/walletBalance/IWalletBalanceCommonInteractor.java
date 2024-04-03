package com.talabat.wallet.common.interactors.walletBalance;

import JsonModels.Response.WalletCreditBalanceResponse;
import io.reactivex.Observable;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\bf\u0018\u00002\u00020\u0001J\u0018\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006H&¨\u0006\u0007"}, d2 = {"Lcom/talabat/wallet/common/interactors/walletBalance/IWalletBalanceCommonInteractor;", "", "getWalletCreditBalance", "Lio/reactivex/Observable;", "LJsonModels/Response/WalletCreditBalanceResponse;", "countryCode", "", "com_talabat_talabat_talabat"}, k = 1, mv = {1, 6, 0}, xi = 48)
public interface IWalletBalanceCommonInteractor {
    @NotNull
    Observable<WalletCreditBalanceResponse> getWalletCreditBalance(@Nullable String str);
}
