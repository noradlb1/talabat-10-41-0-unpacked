package com.talabat.wallet.screens.walletTopupCardList.presenter;

import JsonModels.Response.WalletCreditCardGetListDataItem;
import buisnessmodels.Customer;
import com.talabat.configuration.ConfigurationLocalRepository;
import com.talabat.configuration.location.LocationConfigurationRepository;
import com.talabat.helpers.TalabatUtils;
import com.talabat.talabatcommon.extentions.IntKt;
import com.talabat.talabatcommon.feature.walletPayment.utils.PaymentProviderHelper;
import com.talabat.wallet.screens.walletTopupCardList.WalletTopupCardListListener;
import com.talabat.wallet.screens.walletTopupCardList.interactor.WalletTopupCardListScreenInteractor;
import com.talabat.wallet.screens.walletTopupCardList.view.WalletTopupCardListView;
import datamodels.Country;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u00012\u00020\u0002B\u001d\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\b¢\u0006\u0002\u0010\tJ\u0018\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u000bH\u0016J\u0016\u0010\u0013\u001a\u00020\u000f2\f\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00110\u0015H\u0016J\b\u0010\u0016\u001a\u00020\u000fH\u0016J\b\u0010\u0017\u001a\u00020\u000fH\u0016J\b\u0010\u0018\u001a\u00020\u000fH\u0016J\u0018\u0010\u0019\u001a\u00020\u000f2\u000e\u0010\u001a\u001a\n\u0012\u0004\u0012\u00020\u001b\u0018\u00010\u0015H\u0016J\b\u0010\u001c\u001a\u00020\u000fH\u0016J\u0018\u0010\u001d\u001a\u00020\u000f2\u0006\u0010\u001e\u001a\u00020\u001b2\u0006\u0010\u0012\u001a\u00020\u000bH\u0016R\u000e\u0010\n\u001a\u00020\u000bXD¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0003\u001a\u00020\u0004X\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\f\u001a\u0004\u0018\u00010\rX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u000e¢\u0006\u0002\n\u0000¨\u0006\u001f"}, d2 = {"Lcom/talabat/wallet/screens/walletTopupCardList/presenter/WalletTopupCardListScreenPresenter;", "Lcom/talabat/wallet/screens/walletTopupCardList/presenter/IWalletTopupCardListScreenPresenter;", "Lcom/talabat/wallet/screens/walletTopupCardList/WalletTopupCardListListener;", "locationConfigurationRepository", "Lcom/talabat/configuration/location/LocationConfigurationRepository;", "walletTopupCardListView", "Lcom/talabat/wallet/screens/walletTopupCardList/view/WalletTopupCardListView;", "configurationLocalRepository", "Lcom/talabat/configuration/ConfigurationLocalRepository;", "(Lcom/talabat/configuration/location/LocationConfigurationRepository;Lcom/talabat/wallet/screens/walletTopupCardList/view/WalletTopupCardListView;Lcom/talabat/configuration/ConfigurationLocalRepository;)V", "EVENT_ID", "", "walletTopupCardListScreenInteractor", "Lcom/talabat/wallet/screens/walletTopupCardList/interactor/WalletTopupCardListScreenInteractor;", "onCardWithBankPartnerAdvertMessageReceived", "", "walletCreditCardGetListDataItem", "LJsonModels/Response/WalletCreditCardGetListDataItem;", "position", "onCardWithBankPartnerDataReceived", "dataItem", "", "onDestroy", "onNetworkError", "onServerError", "onWalletAllCreditCardsReceived", "walletCreditCardList", "LJsonModels/Response/WalletCreditCardGetListDataItem$WalletCreditCardGetListResponseResult;", "setAllWalletCreditCards", "setWalletBankPartnerCardMessage", "card", "com_talabat_talabat_talabat"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class WalletTopupCardListScreenPresenter implements IWalletTopupCardListScreenPresenter, WalletTopupCardListListener {
    private final int EVENT_ID = 4;
    @NotNull
    private final ConfigurationLocalRepository configurationLocalRepository;
    @NotNull
    private final LocationConfigurationRepository locationConfigurationRepository;
    @Nullable
    private WalletTopupCardListScreenInteractor walletTopupCardListScreenInteractor;
    @Nullable
    private WalletTopupCardListView walletTopupCardListView;

    public WalletTopupCardListScreenPresenter(@NotNull LocationConfigurationRepository locationConfigurationRepository2, @NotNull WalletTopupCardListView walletTopupCardListView2, @NotNull ConfigurationLocalRepository configurationLocalRepository2) {
        Intrinsics.checkNotNullParameter(locationConfigurationRepository2, "locationConfigurationRepository");
        Intrinsics.checkNotNullParameter(walletTopupCardListView2, "walletTopupCardListView");
        Intrinsics.checkNotNullParameter(configurationLocalRepository2, "configurationLocalRepository");
        this.locationConfigurationRepository = locationConfigurationRepository2;
        this.configurationLocalRepository = configurationLocalRepository2;
        this.walletTopupCardListScreenInteractor = new WalletTopupCardListScreenInteractor(configurationLocalRepository2, this);
        this.walletTopupCardListView = walletTopupCardListView2;
    }

    public void onCardWithBankPartnerAdvertMessageReceived(@NotNull WalletCreditCardGetListDataItem walletCreditCardGetListDataItem, int i11) {
        Intrinsics.checkNotNullParameter(walletCreditCardGetListDataItem, "walletCreditCardGetListDataItem");
        WalletTopupCardListView walletTopupCardListView2 = this.walletTopupCardListView;
        if (walletTopupCardListView2 != null) {
            walletTopupCardListView2.onReceivedBankPartnerCardAdvertMessage(walletCreditCardGetListDataItem, i11);
        }
    }

    public void onCardWithBankPartnerDataReceived(@NotNull List<? extends WalletCreditCardGetListDataItem> list) {
        Intrinsics.checkNotNullParameter(list, "dataItem");
        WalletTopupCardListView walletTopupCardListView2 = this.walletTopupCardListView;
        if (walletTopupCardListView2 != null) {
            walletTopupCardListView2.onReceivedBankPartnerData(list);
        }
    }

    public void onDestroy() {
        this.walletTopupCardListView = null;
        this.walletTopupCardListScreenInteractor = null;
    }

    public void onNetworkError() {
        WalletTopupCardListView walletTopupCardListView2 = this.walletTopupCardListView;
        if (walletTopupCardListView2 != null) {
            walletTopupCardListView2.onNetworkError();
        }
    }

    public void onServerError() {
        WalletTopupCardListView walletTopupCardListView2 = this.walletTopupCardListView;
        if (walletTopupCardListView2 != null) {
            walletTopupCardListView2.onServerError();
        }
    }

    public void onWalletAllCreditCardsReceived(@Nullable List<WalletCreditCardGetListDataItem.WalletCreditCardGetListResponseResult> list) {
        WalletTopupCardListView walletTopupCardListView2 = this.walletTopupCardListView;
        if (walletTopupCardListView2 != null) {
            walletTopupCardListView2.onWalletCardReceived(list);
        }
    }

    public void setAllWalletCreditCards() {
        Customer instance = Customer.getInstance();
        if (instance != null && instance.isLoggedIn()) {
            Country selectedCountry = TalabatUtils.getSelectedCountry(this.configurationLocalRepository, this.locationConfigurationRepository);
            WalletTopupCardListView walletTopupCardListView2 = this.walletTopupCardListView;
            if (walletTopupCardListView2 != null) {
                walletTopupCardListView2.setupViewsBeforeServiceRequest();
            }
            WalletTopupCardListScreenInteractor walletTopupCardListScreenInteractor2 = this.walletTopupCardListScreenInteractor;
            if (walletTopupCardListScreenInteractor2 != null) {
                walletTopupCardListScreenInteractor2.getAllApiDataForBankPartnership(String.valueOf(selectedCountry.f13845id), Integer.valueOf(PaymentProviderHelper.Companion.getPaymentProvider(IntKt.orZero(Integer.valueOf(selectedCountry.f13845id)))), Integer.valueOf(this.EVENT_ID));
            }
        }
    }

    public void setWalletBankPartnerCardMessage(@NotNull WalletCreditCardGetListDataItem.WalletCreditCardGetListResponseResult walletCreditCardGetListResponseResult, int i11) {
        Intrinsics.checkNotNullParameter(walletCreditCardGetListResponseResult, "card");
        Customer instance = Customer.getInstance();
        if (instance != null && instance.isLoggedIn()) {
            Country selectedCountry = TalabatUtils.getSelectedCountry(this.configurationLocalRepository, this.locationConfigurationRepository);
            WalletTopupCardListScreenInteractor walletTopupCardListScreenInteractor2 = this.walletTopupCardListScreenInteractor;
            if (walletTopupCardListScreenInteractor2 != null) {
                walletTopupCardListScreenInteractor2.getCashBackCampaignPerCard(String.valueOf(selectedCountry.f13845id), walletCreditCardGetListResponseResult, i11);
            }
        }
    }
}
