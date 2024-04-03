package com.talabat.wallet.common.interactors.walletBalance;

import JsonModels.Response.WalletCreditBalanceResponse;
import com.talabat.wallet.network.WalletApiService;
import com.talabat.wallet.network.WalletApiUrls;
import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import service.ApiHandler;

@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0018\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u00042\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007H\u0016¨\u0006\b"}, d2 = {"Lcom/talabat/wallet/common/interactors/walletBalance/WalletBalanceCommonInteractor;", "Lcom/talabat/wallet/common/interactors/walletBalance/IWalletBalanceCommonInteractor;", "()V", "getWalletCreditBalance", "Lio/reactivex/Observable;", "LJsonModels/Response/WalletCreditBalanceResponse;", "countryCode", "", "com_talabat_talabat_talabat"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class WalletBalanceCommonInteractor implements IWalletBalanceCommonInteractor {
    @NotNull
    public Observable<WalletCreditBalanceResponse> getWalletCreditBalance(@Nullable String str) {
        Observable<WalletCreditBalanceResponse> observeOn = ((WalletApiService) ApiHandler.getInstance().getRetrofit().create(WalletApiService.class)).getWalletCreditBalance(StringsKt__StringsJVMKt.replace(WalletApiUrls.Companion.getWALLET_CREDIT_BALANCE_URL(), "{countryCode}", String.valueOf(str), false)).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread());
        Intrinsics.checkNotNullExpressionValue(observeOn, "service.getWalletCreditB…ainThread()\n            )");
        return observeOn;
    }
}
