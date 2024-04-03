package com.talabat.wallet.screens.walletTopUpResponse.interactor;

import androidx.webkit.ProxyConfig;
import com.talabat.wallet.network.WalletApiService;
import com.talabat.wallet.network.WalletApiUrls;
import com.talabat.wallet.screens.walletTopUpResponse.WalletTopUpResponseListener;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import library.talabat.mvp.IGlobalInteractor;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import service.ApiHandler;

@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\u0018\u00002\u00020\u00012\u00020\u0002B\r\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005J\u0012\u0010\u0006\u001a\u00020\u00072\b\u0010\b\u001a\u0004\u0018\u00010\tH\u0016J\b\u0010\n\u001a\u00020\u0007H\u0016R\u0010\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u000e¢\u0006\u0002\n\u0000¨\u0006\u000b"}, d2 = {"Lcom/talabat/wallet/screens/walletTopUpResponse/interactor/WalletTopUpScreenInteractor;", "Llibrary/talabat/mvp/IGlobalInteractor;", "Lcom/talabat/wallet/screens/walletTopUpResponse/interactor/IWalletTopUpScreenInteractor;", "walletTopUpResponseListener", "Lcom/talabat/wallet/screens/walletTopUpResponse/WalletTopUpResponseListener;", "(Lcom/talabat/wallet/screens/walletTopUpResponse/WalletTopUpResponseListener;)V", "getWalletCreditBalance", "", "countryCode", "", "unregister", "com_talabat_talabat_talabat"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class WalletTopUpScreenInteractor implements IGlobalInteractor, IWalletTopUpScreenInteractor {
    /* access modifiers changed from: private */
    @Nullable
    public WalletTopUpResponseListener walletTopUpResponseListener;

    public WalletTopUpScreenInteractor(@NotNull WalletTopUpResponseListener walletTopUpResponseListener2) {
        Intrinsics.checkNotNullParameter(walletTopUpResponseListener2, "walletTopUpResponseListener");
        this.walletTopUpResponseListener = walletTopUpResponseListener2;
    }

    public void getWalletCreditBalance(@Nullable String str) {
        ((WalletApiService) ApiHandler.getInstance().getRetrofit().create(WalletApiService.class)).getWalletCreditBalance(StringsKt__StringsJVMKt.replace(WalletApiUrls.Companion.getWALLET_CREDIT_BALANCE_URL(), "{countryCode}", String.valueOf(str), false)).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribe(new WalletTopUpScreenInteractor$getWalletCreditBalance$1(this, ProxyConfig.MATCH_HTTP));
    }

    public void unregister() {
        this.walletTopUpResponseListener = null;
    }
}
