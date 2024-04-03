package com.talabat.wallet.screens.walletTopUp.interactor;

import JsonModels.Request.WalletCalculateCashBackRequest;
import JsonModels.Request.WalletTopUpRequest;
import androidx.webkit.ProxyConfig;
import com.talabat.configuration.ConfigurationLocalRepository;
import com.talabat.wallet.network.WalletApiService;
import com.talabat.wallet.network.WalletApiUrls;
import com.talabat.wallet.screens.walletTopUp.WalletTopUpListener;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import library.talabat.com.talabatlib.CreateApiUrl;
import library.talabat.mvp.IGlobalInteractor;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import service.ApiHandler;

@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u00012\u00020\u0002B\u0015\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0002\u0010\u0007J\u0012\u0010\b\u001a\u00020\t2\b\u0010\n\u001a\u0004\u0018\u00010\u000bH\u0016J\u0010\u0010\f\u001a\u00020\t2\u0006\u0010\r\u001a\u00020\u000eH\u0016J\u0010\u0010\u000f\u001a\u00020\t2\u0006\u0010\u0010\u001a\u00020\u0011H\u0016J\b\u0010\u0012\u001a\u00020\tH\u0016R\u000e\u0010\u0003\u001a\u00020\u0004X\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u000e¢\u0006\u0002\n\u0000¨\u0006\u0013"}, d2 = {"Lcom/talabat/wallet/screens/walletTopUp/interactor/WalletTopUpScreenInteractor;", "Llibrary/talabat/mvp/IGlobalInteractor;", "Lcom/talabat/wallet/screens/walletTopUp/interactor/IWalletTopUpScreenInteractor;", "configurationLocalRepository", "Lcom/talabat/configuration/ConfigurationLocalRepository;", "walletTopUpListener", "Lcom/talabat/wallet/screens/walletTopUp/WalletTopUpListener;", "(Lcom/talabat/configuration/ConfigurationLocalRepository;Lcom/talabat/wallet/screens/walletTopUp/WalletTopUpListener;)V", "getAllWalletTopUpAmountSuggestion", "", "countryId", "", "getCalculatedCashBack", "walletCalculateCashBackRequest", "LJsonModels/Request/WalletCalculateCashBackRequest;", "getWalletTopUp", "walletTopUpRequest", "LJsonModels/Request/WalletTopUpRequest;", "unregister", "com_talabat_talabat_talabat"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class WalletTopUpScreenInteractor implements IGlobalInteractor, IWalletTopUpScreenInteractor {
    @NotNull
    private final ConfigurationLocalRepository configurationLocalRepository;
    /* access modifiers changed from: private */
    @Nullable
    public WalletTopUpListener walletTopUpListener;

    public WalletTopUpScreenInteractor(@NotNull ConfigurationLocalRepository configurationLocalRepository2, @NotNull WalletTopUpListener walletTopUpListener2) {
        Intrinsics.checkNotNullParameter(configurationLocalRepository2, "configurationLocalRepository");
        Intrinsics.checkNotNullParameter(walletTopUpListener2, "walletTopUpListener");
        this.configurationLocalRepository = configurationLocalRepository2;
        this.walletTopUpListener = walletTopUpListener2;
    }

    public void getAllWalletTopUpAmountSuggestion(@Nullable String str) {
        ((WalletApiService) ApiHandler.getInstance().getRetrofit().create(WalletApiService.class)).fetchWalletTopUpAmountSuggestion(CreateApiUrl.createWithParameters(WalletApiUrls.Companion.getWALLET_TOP_UP_SUGGESTION_URL(), new String[]{"{countryCode}", String.valueOf(str)})).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribe(new WalletTopUpScreenInteractor$getAllWalletTopUpAmountSuggestion$1(this));
    }

    public void getCalculatedCashBack(@NotNull WalletCalculateCashBackRequest walletCalculateCashBackRequest) {
        Intrinsics.checkNotNullParameter(walletCalculateCashBackRequest, "walletCalculateCashBackRequest");
        ((WalletApiService) ApiHandler.getInstance().getRetrofit().create(WalletApiService.class)).fetchWalletCalculateCashBack(WalletApiUrls.Companion.getWALLET_CALCULATE_CASH_BACK_URL(), walletCalculateCashBackRequest, this.configurationLocalRepository.selectedCountry().getCountryId()).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribe(new WalletTopUpScreenInteractor$getCalculatedCashBack$1(this));
    }

    public void getWalletTopUp(@NotNull WalletTopUpRequest walletTopUpRequest) {
        Intrinsics.checkNotNullParameter(walletTopUpRequest, "walletTopUpRequest");
        ((WalletApiService) ApiHandler.getInstance().getRetrofit().create(WalletApiService.class)).fetchWalletTopUp(WalletApiUrls.Companion.getWALLET_TOP_UP_URL(), walletTopUpRequest).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribe(new WalletTopUpScreenInteractor$getWalletTopUp$1(this, ProxyConfig.MATCH_HTTP));
    }

    public void unregister() {
        this.walletTopUpListener = null;
    }
}
