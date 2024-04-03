package com.talabat.wallet.screens.walletTopUpResponse.interactor;

import kotlin.Metadata;
import library.talabat.mvp.IGlobalInteractor;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\bf\u0018\u00002\u00020\u0001J\u0012\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H&¨\u0006\u0006"}, d2 = {"Lcom/talabat/wallet/screens/walletTopUpResponse/interactor/IWalletTopUpScreenInteractor;", "Llibrary/talabat/mvp/IGlobalInteractor;", "getWalletCreditBalance", "", "countryCode", "", "com_talabat_talabat_talabat"}, k = 1, mv = {1, 6, 0}, xi = 48)
public interface IWalletTopUpScreenInteractor extends IGlobalInteractor {
    void getWalletCreditBalance(@Nullable String str);
}
