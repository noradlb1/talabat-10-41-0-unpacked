package com.talabat.wallet.screens.walletManageCard.presenter;

import JsonModels.Request.WalletDeleteCreditCardRequest;
import JsonModels.Request.WalletSetDefaultCreditCardRequest;
import JsonModels.Response.WalletCreditCardGetListDataModel;
import JsonModels.Response.WalletDeleteCreditCardsResponse;
import JsonModels.Response.WalletSetDefaultCreditCardResponse;
import buisnessmodels.Customer;
import com.talabat.configuration.ConfigurationLocalRepository;
import com.talabat.configuration.location.LocationConfigurationRepository;
import com.talabat.helpers.TalabatUtils;
import com.talabat.talabatcommon.extentions.IntKt;
import com.talabat.talabatcommon.feature.walletPayment.utils.PaymentProviderHelper;
import com.talabat.wallet.screens.walletManageCard.WalletManageCreditCardListener;
import com.talabat.wallet.screens.walletManageCard.interactor.WalletManageCreditCardsScreenInteractor;
import com.talabat.wallet.screens.walletManageCard.view.WalletManageCreditCardsView;
import datamodels.Country;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000`\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u00012\u00020\u0002B\u001d\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\b¢\u0006\u0002\u0010\tJ\u0016\u0010\f\u001a\u00020\r2\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00100\u000fH\u0016J\b\u0010\u0011\u001a\u00020\rH\u0016J\b\u0010\u0012\u001a\u00020\rH\u0016J\b\u0010\u0013\u001a\u00020\rH\u0016J\u0012\u0010\u0014\u001a\u00020\r2\b\u0010\u0015\u001a\u0004\u0018\u00010\u0016H\u0016J\u0012\u0010\u0017\u001a\u00020\r2\b\u0010\u0018\u001a\u0004\u0018\u00010\u0019H\u0016J\b\u0010\u001a\u001a\u00020\rH\u0016J\u0010\u0010\u001b\u001a\u00020\r2\u0006\u0010\u001c\u001a\u00020\u001dH\u0016J\u0018\u0010\u001e\u001a\u00020\r2\u0006\u0010\u001f\u001a\u00020 2\u0006\u0010!\u001a\u00020 H\u0016J\u0012\u0010\"\u001a\u00020\r2\b\u0010#\u001a\u0004\u0018\u00010$H\u0016R\u000e\u0010\u0003\u001a\u00020\u0004X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\n\u001a\u0004\u0018\u00010\u000bX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0007\u001a\u0004\u0018\u00010\bX\u000e¢\u0006\u0002\n\u0000¨\u0006%"}, d2 = {"Lcom/talabat/wallet/screens/walletManageCard/presenter/WalletManageCreditCardsScreenPresenter;", "Lcom/talabat/wallet/screens/walletManageCard/presenter/IWalletManageCardsScreenPresenter;", "Lcom/talabat/wallet/screens/walletManageCard/WalletManageCreditCardListener;", "configurationLocalRepository", "Lcom/talabat/configuration/ConfigurationLocalRepository;", "locationConfigurationRepository", "Lcom/talabat/configuration/location/LocationConfigurationRepository;", "walletManageCreditCardsView", "Lcom/talabat/wallet/screens/walletManageCard/view/WalletManageCreditCardsView;", "(Lcom/talabat/configuration/ConfigurationLocalRepository;Lcom/talabat/configuration/location/LocationConfigurationRepository;Lcom/talabat/wallet/screens/walletManageCard/view/WalletManageCreditCardsView;)V", "walletManageCreditCardsScreenInteractor", "Lcom/talabat/wallet/screens/walletManageCard/interactor/WalletManageCreditCardsScreenInteractor;", "deleteCreditCards", "", "cardIds", "", "LJsonModels/Request/WalletDeleteCreditCardRequest;", "onDestroy", "onNetworkError", "onServerError", "onSetDefaultCreditCardsReceived", "walletSetDefaultCreditCardResponse", "LJsonModels/Response/WalletSetDefaultCreditCardResponse;", "onWalletAllCreditCardsReceived", "walletCreditCardGetListDataModel", "LJsonModels/Response/WalletCreditCardGetListDataModel;", "onWalletDeleteAllCompleted", "onWalletDeleteCardResponseReceived", "walletDeleteCreditCardsResponse", "LJsonModels/Response/WalletDeleteCreditCardsResponse;", "setAllWalletCreditCards", "primaryCardLabel", "", "otherCardLabel", "setDefaultCreditCard", "walletSetDefaultCreditCardRequest", "LJsonModels/Request/WalletSetDefaultCreditCardRequest;", "com_talabat_talabat_talabat"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class WalletManageCreditCardsScreenPresenter implements IWalletManageCardsScreenPresenter, WalletManageCreditCardListener {
    @NotNull
    private final ConfigurationLocalRepository configurationLocalRepository;
    @NotNull
    private final LocationConfigurationRepository locationConfigurationRepository;
    @Nullable
    private WalletManageCreditCardsScreenInteractor walletManageCreditCardsScreenInteractor = new WalletManageCreditCardsScreenInteractor(this);
    @Nullable
    private WalletManageCreditCardsView walletManageCreditCardsView;

    public WalletManageCreditCardsScreenPresenter(@NotNull ConfigurationLocalRepository configurationLocalRepository2, @NotNull LocationConfigurationRepository locationConfigurationRepository2, @NotNull WalletManageCreditCardsView walletManageCreditCardsView2) {
        Intrinsics.checkNotNullParameter(configurationLocalRepository2, "configurationLocalRepository");
        Intrinsics.checkNotNullParameter(locationConfigurationRepository2, "locationConfigurationRepository");
        Intrinsics.checkNotNullParameter(walletManageCreditCardsView2, "walletManageCreditCardsView");
        this.configurationLocalRepository = configurationLocalRepository2;
        this.locationConfigurationRepository = locationConfigurationRepository2;
        this.walletManageCreditCardsView = walletManageCreditCardsView2;
    }

    public void deleteCreditCards(@NotNull List<WalletDeleteCreditCardRequest> list) {
        Intrinsics.checkNotNullParameter(list, "cardIds");
        Customer instance = Customer.getInstance();
        if (instance != null && instance.isLoggedIn()) {
            WalletManageCreditCardsView walletManageCreditCardsView2 = this.walletManageCreditCardsView;
            if (walletManageCreditCardsView2 != null) {
                walletManageCreditCardsView2.setupViewsBeforeServiceRequest();
            }
            WalletManageCreditCardsScreenInteractor walletManageCreditCardsScreenInteractor2 = this.walletManageCreditCardsScreenInteractor;
            if (walletManageCreditCardsScreenInteractor2 != null) {
                walletManageCreditCardsScreenInteractor2.deleteCards(list);
            }
        }
    }

    public void onDestroy() {
        this.walletManageCreditCardsScreenInteractor = null;
        this.walletManageCreditCardsView = null;
    }

    public void onNetworkError() {
        WalletManageCreditCardsView walletManageCreditCardsView2 = this.walletManageCreditCardsView;
        if (walletManageCreditCardsView2 != null) {
            walletManageCreditCardsView2.onNetworkError();
        }
    }

    public void onServerError() {
        WalletManageCreditCardsView walletManageCreditCardsView2 = this.walletManageCreditCardsView;
        if (walletManageCreditCardsView2 != null) {
            walletManageCreditCardsView2.displayServerErrorMessage();
        }
    }

    public void onSetDefaultCreditCardsReceived(@Nullable WalletSetDefaultCreditCardResponse walletSetDefaultCreditCardResponse) {
        WalletManageCreditCardsView walletManageCreditCardsView2 = this.walletManageCreditCardsView;
        if (walletManageCreditCardsView2 != null) {
            walletManageCreditCardsView2.addDefaultCreditCard(walletSetDefaultCreditCardResponse);
        }
    }

    public void onWalletAllCreditCardsReceived(@Nullable WalletCreditCardGetListDataModel walletCreditCardGetListDataModel) {
        WalletManageCreditCardsView walletManageCreditCardsView2 = this.walletManageCreditCardsView;
        if (walletManageCreditCardsView2 != null) {
            walletManageCreditCardsView2.addAllWalletCreditCards(walletCreditCardGetListDataModel);
        }
    }

    public void onWalletDeleteAllCompleted() {
        WalletManageCreditCardsView walletManageCreditCardsView2 = this.walletManageCreditCardsView;
        if (walletManageCreditCardsView2 != null) {
            walletManageCreditCardsView2.deleteAllCardsCompleted();
        }
    }

    public void onWalletDeleteCardResponseReceived(@NotNull WalletDeleteCreditCardsResponse walletDeleteCreditCardsResponse) {
        Intrinsics.checkNotNullParameter(walletDeleteCreditCardsResponse, "walletDeleteCreditCardsResponse");
        WalletManageCreditCardsView walletManageCreditCardsView2 = this.walletManageCreditCardsView;
        if (walletManageCreditCardsView2 != null) {
            walletManageCreditCardsView2.removeDeletedCards(walletDeleteCreditCardsResponse);
        }
    }

    public void setAllWalletCreditCards(@NotNull String str, @NotNull String str2) {
        Integer num;
        Intrinsics.checkNotNullParameter(str, "primaryCardLabel");
        Intrinsics.checkNotNullParameter(str2, "otherCardLabel");
        Customer instance = Customer.getInstance();
        if (instance != null && instance.isLoggedIn()) {
            Country selectedCountry = TalabatUtils.getSelectedCountry(this.configurationLocalRepository, this.locationConfigurationRepository);
            WalletManageCreditCardsView walletManageCreditCardsView2 = this.walletManageCreditCardsView;
            if (walletManageCreditCardsView2 != null) {
                walletManageCreditCardsView2.setupViewsBeforeServiceRequest();
            }
            WalletManageCreditCardsScreenInteractor walletManageCreditCardsScreenInteractor2 = this.walletManageCreditCardsScreenInteractor;
            if (walletManageCreditCardsScreenInteractor2 != null) {
                PaymentProviderHelper.Companion companion = PaymentProviderHelper.Companion;
                Integer num2 = null;
                if (selectedCountry != null) {
                    num = Integer.valueOf(selectedCountry.f13845id);
                } else {
                    num = null;
                }
                Integer valueOf = Integer.valueOf(companion.getPaymentProvider(IntKt.orZero(num)));
                if (selectedCountry != null) {
                    num2 = Integer.valueOf(selectedCountry.f13845id);
                }
                walletManageCreditCardsScreenInteractor2.getAllWalletCreditCards(valueOf, num2, str, str2);
            }
        }
    }

    public void setDefaultCreditCard(@Nullable WalletSetDefaultCreditCardRequest walletSetDefaultCreditCardRequest) {
        Customer instance = Customer.getInstance();
        if (instance != null && walletSetDefaultCreditCardRequest != null && instance.isLoggedIn()) {
            WalletManageCreditCardsView walletManageCreditCardsView2 = this.walletManageCreditCardsView;
            if (walletManageCreditCardsView2 != null) {
                walletManageCreditCardsView2.setupViewsBeforeServiceRequest();
            }
            WalletManageCreditCardsScreenInteractor walletManageCreditCardsScreenInteractor2 = this.walletManageCreditCardsScreenInteractor;
            if (walletManageCreditCardsScreenInteractor2 != null) {
                walletManageCreditCardsScreenInteractor2.setDefaultCard(walletSetDefaultCreditCardRequest);
            }
        }
    }
}
