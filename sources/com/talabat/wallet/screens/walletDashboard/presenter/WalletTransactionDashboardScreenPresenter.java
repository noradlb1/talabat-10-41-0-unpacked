package com.talabat.wallet.screens.walletDashboard.presenter;

import JsonModels.Response.WalletTransactionListDataItem;
import JsonModels.Response.WalletTransactionListDataModel;
import buisnessmodels.Customer;
import com.talabat.configuration.ConfigurationLocalRepository;
import com.talabat.configuration.location.LocationConfigurationRepository;
import com.talabat.helpers.GlobalDataModel;
import com.talabat.helpers.TalabatUtils;
import com.talabat.wallet.screens.walletDashboard.WalletTransactionDashboardScreenListener;
import com.talabat.wallet.screens.walletDashboard.interactor.IWalletTransactionDashboardScreenInteractor;
import com.talabat.wallet.screens.walletDashboard.interactor.WalletTransactionDashboardScreenInteractor;
import com.talabat.wallet.screens.walletDashboard.view.WalletTransactionDashboardScreenView;
import datamodels.Country;
import java.util.Collection;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0007\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u00012\u00020\u0002B\u001d\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\b¢\u0006\u0002\u0010\tJ\u0006\u0010\u0015\u001a\u00020\u000bJ\b\u0010\u0016\u001a\u0004\u0018\u00010\u0014J\b\u0010\u0017\u001a\u00020\u0018H\u0016J\b\u0010\u0019\u001a\u00020\u0018H\u0016J\b\u0010\u001a\u001a\u00020\u0018H\u0016J\u0012\u0010\u001b\u001a\u00020\u00182\b\u0010\u001c\u001a\u0004\u0018\u00010\u0014H\u0016J\u0006\u0010\u001d\u001a\u00020\u0018J\"\u0010\u001e\u001a\u00020\u00182\u0006\u0010\u001f\u001a\u00020 2\u0006\u0010!\u001a\u00020 2\b\u0010\"\u001a\u0004\u0018\u00010#H\u0016J\b\u0010$\u001a\u00020\u0018H\u0016R\u000e\u0010\u0003\u001a\u00020\u0004X\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\n\u001a\u00020\u000bX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\u000e\u0010\u0010\u001a\u00020\u000bX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0011\u001a\u0004\u0018\u00010\u0012X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0007\u001a\u0004\u0018\u00010\bX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0013\u001a\u0004\u0018\u00010\u0014X\u000e¢\u0006\u0002\n\u0000¨\u0006%"}, d2 = {"Lcom/talabat/wallet/screens/walletDashboard/presenter/WalletTransactionDashboardScreenPresenter;", "Lcom/talabat/wallet/screens/walletDashboard/presenter/IWalletTransactionDashboardScreenPresenter;", "Lcom/talabat/wallet/screens/walletDashboard/WalletTransactionDashboardScreenListener;", "configurationLocalRepository", "Lcom/talabat/configuration/ConfigurationLocalRepository;", "locationConfigurationRepository", "Lcom/talabat/configuration/location/LocationConfigurationRepository;", "walletTransactionDashboardScreenView", "Lcom/talabat/wallet/screens/walletDashboard/view/WalletTransactionDashboardScreenView;", "(Lcom/talabat/configuration/ConfigurationLocalRepository;Lcom/talabat/configuration/location/LocationConfigurationRepository;Lcom/talabat/wallet/screens/walletDashboard/view/WalletTransactionDashboardScreenView;)V", "headerLoaded", "", "getHeaderLoaded", "()Z", "setHeaderLoaded", "(Z)V", "isFirstResponse", "walletTransactionDashboardScreenInteractor", "Lcom/talabat/wallet/screens/walletDashboard/interactor/IWalletTransactionDashboardScreenInteractor;", "walletTransactionListFirstResult", "LJsonModels/Response/WalletTransactionListDataModel;", "getFirstResponseStatus", "getWalletTransactionListFirstResult", "onDestroy", "", "onNetworkError", "onServerError", "onWalletCreditTransactionListReceived", "walletTransactionListDataModel", "setFirstResponse", "setWalletTransactionListInfo", "pageNumber", "", "numberOfItemsPerPage", "lastTransactionModel", "LJsonModels/Response/WalletTransactionListDataItem$TransactionModel;", "showMenuButtonsBasedOnFlagStatus", "com_talabat_talabat_talabat"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class WalletTransactionDashboardScreenPresenter implements IWalletTransactionDashboardScreenPresenter, WalletTransactionDashboardScreenListener {
    @NotNull
    private final ConfigurationLocalRepository configurationLocalRepository;
    private boolean headerLoaded;
    private boolean isFirstResponse = true;
    @NotNull
    private final LocationConfigurationRepository locationConfigurationRepository;
    @Nullable
    private IWalletTransactionDashboardScreenInteractor walletTransactionDashboardScreenInteractor = new WalletTransactionDashboardScreenInteractor(this);
    @Nullable
    private WalletTransactionDashboardScreenView walletTransactionDashboardScreenView;
    @Nullable
    private WalletTransactionListDataModel walletTransactionListFirstResult;

    public WalletTransactionDashboardScreenPresenter(@NotNull ConfigurationLocalRepository configurationLocalRepository2, @NotNull LocationConfigurationRepository locationConfigurationRepository2, @NotNull WalletTransactionDashboardScreenView walletTransactionDashboardScreenView2) {
        Intrinsics.checkNotNullParameter(configurationLocalRepository2, "configurationLocalRepository");
        Intrinsics.checkNotNullParameter(locationConfigurationRepository2, "locationConfigurationRepository");
        Intrinsics.checkNotNullParameter(walletTransactionDashboardScreenView2, "walletTransactionDashboardScreenView");
        this.configurationLocalRepository = configurationLocalRepository2;
        this.locationConfigurationRepository = locationConfigurationRepository2;
        this.walletTransactionDashboardScreenView = walletTransactionDashboardScreenView2;
    }

    public final boolean getFirstResponseStatus() {
        return this.isFirstResponse;
    }

    public final boolean getHeaderLoaded() {
        return this.headerLoaded;
    }

    @Nullable
    public final WalletTransactionListDataModel getWalletTransactionListFirstResult() {
        return this.walletTransactionListFirstResult;
    }

    public void onDestroy() {
        this.walletTransactionDashboardScreenView = null;
        this.walletTransactionDashboardScreenInteractor = null;
    }

    public void onNetworkError() {
        WalletTransactionDashboardScreenView walletTransactionDashboardScreenView2 = this.walletTransactionDashboardScreenView;
        if (walletTransactionDashboardScreenView2 != null) {
            walletTransactionDashboardScreenView2.onNetworkError();
        }
    }

    public void onServerError() {
        WalletTransactionDashboardScreenView walletTransactionDashboardScreenView2 = this.walletTransactionDashboardScreenView;
        if (walletTransactionDashboardScreenView2 != null) {
            walletTransactionDashboardScreenView2.displayServerErrorMessage();
        }
    }

    public void onWalletCreditTransactionListReceived(@Nullable WalletTransactionListDataModel walletTransactionListDataModel) {
        boolean z11;
        if (walletTransactionListDataModel != null) {
            if (this.isFirstResponse) {
                this.walletTransactionListFirstResult = walletTransactionListDataModel;
            }
            Collection transactionListDataItem = walletTransactionListDataModel.getTransactionListDataItem();
            if (transactionListDataItem == null || transactionListDataItem.isEmpty()) {
                z11 = true;
            } else {
                z11 = false;
            }
            if (!z11 || !this.isFirstResponse) {
                this.isFirstResponse = false;
                WalletTransactionDashboardScreenView walletTransactionDashboardScreenView2 = this.walletTransactionDashboardScreenView;
                if (walletTransactionDashboardScreenView2 != null) {
                    walletTransactionDashboardScreenView2.addWalletCreditTransactionListData(walletTransactionListDataModel);
                    return;
                }
                return;
            }
            WalletTransactionDashboardScreenView walletTransactionDashboardScreenView3 = this.walletTransactionDashboardScreenView;
            if (walletTransactionDashboardScreenView3 != null) {
                walletTransactionDashboardScreenView3.redirectToEmptyListView();
            }
        }
    }

    public final void setFirstResponse() {
        this.isFirstResponse = true;
    }

    public final void setHeaderLoaded(boolean z11) {
        this.headerLoaded = z11;
    }

    public void setWalletTransactionListInfo(int i11, int i12, @Nullable WalletTransactionListDataItem.TransactionModel transactionModel) {
        Customer instance = Customer.getInstance();
        if (instance == null) {
            return;
        }
        if (instance.isLoggedIn()) {
            Country selectedCountry = TalabatUtils.getSelectedCountry(this.configurationLocalRepository, this.locationConfigurationRepository);
            WalletTransactionDashboardScreenView walletTransactionDashboardScreenView2 = this.walletTransactionDashboardScreenView;
            if (walletTransactionDashboardScreenView2 != null) {
                walletTransactionDashboardScreenView2.setupProgressBarBeforeServiceRequest();
            }
            int i13 = i11 * i12;
            IWalletTransactionDashboardScreenInteractor iWalletTransactionDashboardScreenInteractor = this.walletTransactionDashboardScreenInteractor;
            if (iWalletTransactionDashboardScreenInteractor != null) {
                iWalletTransactionDashboardScreenInteractor.getWalletCreditTransactionList(String.valueOf(selectedCountry.f13845id), String.valueOf(i13), String.valueOf(i12), GlobalDataModel.SelectedLanguage, transactionModel);
                return;
            }
            return;
        }
        WalletTransactionDashboardScreenView walletTransactionDashboardScreenView3 = this.walletTransactionDashboardScreenView;
        if (walletTransactionDashboardScreenView3 != null) {
            walletTransactionDashboardScreenView3.redirectToLoginScreen();
        }
    }

    public void showMenuButtonsBasedOnFlagStatus() {
    }
}
