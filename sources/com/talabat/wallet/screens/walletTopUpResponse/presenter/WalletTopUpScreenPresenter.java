package com.talabat.wallet.screens.walletTopUpResponse.presenter;

import buisnessmodels.Customer;
import com.talabat.configuration.ConfigurationLocalRepository;
import com.talabat.configuration.location.LocationConfigurationRepository;
import com.talabat.helpers.TalabatUtils;
import com.talabat.wallet.screens.walletTopUpResponse.WalletTopUpResponseListener;
import com.talabat.wallet.screens.walletTopUpResponse.interactor.WalletTopUpScreenInteractor;
import com.talabat.wallet.screens.walletTopUpResponse.view.WalletTopUpResponseView;
import datamodels.Country;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u00012\u00020\u0002B\u001d\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\b¢\u0006\u0002\u0010\tJ\u0012\u0010\f\u001a\u00020\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u000fH\u0016J\b\u0010\u0010\u001a\u00020\rH\u0016J\b\u0010\u0011\u001a\u00020\rH\u0016J\b\u0010\u0012\u001a\u00020\rH\u0016J\b\u0010\u0013\u001a\u00020\rH\u0016R\u000e\u0010\u0003\u001a\u00020\u0004X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0007\u001a\u0004\u0018\u00010\bX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\n\u001a\u0004\u0018\u00010\u000bX\u000e¢\u0006\u0002\n\u0000¨\u0006\u0014"}, d2 = {"Lcom/talabat/wallet/screens/walletTopUpResponse/presenter/WalletTopUpScreenPresenter;", "Lcom/talabat/wallet/screens/walletTopUpResponse/presenter/IWalletTopUpScreenPresenter;", "Lcom/talabat/wallet/screens/walletTopUpResponse/WalletTopUpResponseListener;", "configurationLocalRepository", "Lcom/talabat/configuration/ConfigurationLocalRepository;", "locationConfigurationRepository", "Lcom/talabat/configuration/location/LocationConfigurationRepository;", "walletTopUpResponseView", "Lcom/talabat/wallet/screens/walletTopUpResponse/view/WalletTopUpResponseView;", "(Lcom/talabat/configuration/ConfigurationLocalRepository;Lcom/talabat/configuration/location/LocationConfigurationRepository;Lcom/talabat/wallet/screens/walletTopUpResponse/view/WalletTopUpResponseView;)V", "walletTopUpScreenInteractor", "Lcom/talabat/wallet/screens/walletTopUpResponse/interactor/WalletTopUpScreenInteractor;", "onCreditBalanceReceived", "", "walletCreditBalanceResponseResult", "LJsonModels/Response/WalletCreditBalanceResponse;", "onDestroy", "onNetworkError", "onServerError", "setWalletCreditBalance", "com_talabat_talabat_talabat"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class WalletTopUpScreenPresenter implements IWalletTopUpScreenPresenter, WalletTopUpResponseListener {
    @NotNull
    private final ConfigurationLocalRepository configurationLocalRepository;
    @NotNull
    private final LocationConfigurationRepository locationConfigurationRepository;
    @Nullable
    private WalletTopUpResponseView walletTopUpResponseView;
    @Nullable
    private WalletTopUpScreenInteractor walletTopUpScreenInteractor = new WalletTopUpScreenInteractor(this);

    public WalletTopUpScreenPresenter(@NotNull ConfigurationLocalRepository configurationLocalRepository2, @NotNull LocationConfigurationRepository locationConfigurationRepository2, @NotNull WalletTopUpResponseView walletTopUpResponseView2) {
        Intrinsics.checkNotNullParameter(configurationLocalRepository2, "configurationLocalRepository");
        Intrinsics.checkNotNullParameter(locationConfigurationRepository2, "locationConfigurationRepository");
        Intrinsics.checkNotNullParameter(walletTopUpResponseView2, "walletTopUpResponseView");
        this.configurationLocalRepository = configurationLocalRepository2;
        this.locationConfigurationRepository = locationConfigurationRepository2;
        this.walletTopUpResponseView = walletTopUpResponseView2;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:3:0x0006, code lost:
        r2 = r2.getResult();
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void onCreditBalanceReceived(@org.jetbrains.annotations.Nullable JsonModels.Response.WalletCreditBalanceResponse r2) {
        /*
            r1 = this;
            com.talabat.wallet.screens.walletTopUpResponse.view.WalletTopUpResponseView r0 = r1.walletTopUpResponseView
            if (r0 == 0) goto L_0x0015
            if (r2 == 0) goto L_0x0011
            JsonModels.Response.WalletCreditBalanceResultModel r2 = r2.getResult()
            if (r2 == 0) goto L_0x0011
            java.lang.Float r2 = r2.getBalanceAmount()
            goto L_0x0012
        L_0x0011:
            r2 = 0
        L_0x0012:
            r0.addBalance(r2)
        L_0x0015:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.talabat.wallet.screens.walletTopUpResponse.presenter.WalletTopUpScreenPresenter.onCreditBalanceReceived(JsonModels.Response.WalletCreditBalanceResponse):void");
    }

    public void onDestroy() {
        this.walletTopUpResponseView = null;
        this.walletTopUpScreenInteractor = null;
    }

    public void onNetworkError() {
        WalletTopUpResponseView walletTopUpResponseView2 = this.walletTopUpResponseView;
        if (walletTopUpResponseView2 != null) {
            walletTopUpResponseView2.onNetworkError();
        }
    }

    public void onServerError() {
        WalletTopUpResponseView walletTopUpResponseView2 = this.walletTopUpResponseView;
        if (walletTopUpResponseView2 != null) {
            walletTopUpResponseView2.displayServerErrorMessage();
        }
    }

    public void setWalletCreditBalance() {
        Customer instance = Customer.getInstance();
        if (instance == null) {
            return;
        }
        if (instance.isLoggedIn()) {
            Country selectedCountry = TalabatUtils.getSelectedCountry(this.configurationLocalRepository, this.locationConfigurationRepository);
            WalletTopUpResponseView walletTopUpResponseView2 = this.walletTopUpResponseView;
            if (walletTopUpResponseView2 != null) {
                walletTopUpResponseView2.setupViewsBeforeServiceRequest();
            }
            WalletTopUpScreenInteractor walletTopUpScreenInteractor2 = this.walletTopUpScreenInteractor;
            if (walletTopUpScreenInteractor2 != null) {
                walletTopUpScreenInteractor2.getWalletCreditBalance(String.valueOf(selectedCountry.f13845id));
                return;
            }
            return;
        }
        WalletTopUpResponseView walletTopUpResponseView3 = this.walletTopUpResponseView;
        if (walletTopUpResponseView3 != null) {
            walletTopUpResponseView3.redirectToLoginScreen();
        }
    }
}
