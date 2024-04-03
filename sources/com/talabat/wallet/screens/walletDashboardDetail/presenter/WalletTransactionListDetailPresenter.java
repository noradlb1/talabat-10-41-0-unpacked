package com.talabat.wallet.screens.walletDashboardDetail.presenter;

import JsonModels.OrderDetailsRM;
import JsonModels.Response.WalletCreditTransactionDetailObject;
import JsonModels.Response.WalletCreditTransactionDetailResponse;
import JsonModels.Response.WalletTransactionTypes;
import buisnessmodels.Customer;
import com.talabat.configuration.ConfigurationLocalRepository;
import com.talabat.configuration.location.LocationConfigurationRepository;
import com.talabat.helpers.TalabatUtils;
import com.talabat.talabatcore.logger.LogManager;
import com.talabat.wallet.screens.walletDashboardDetail.WalletTransactionDetailScreenListener;
import com.talabat.wallet.screens.walletDashboardDetail.interactor.IWalletTransactionListInteractor;
import com.talabat.wallet.screens.walletDashboardDetail.interactor.WalletTransactionDetailInteractor;
import com.talabat.wallet.screens.walletDashboardDetail.view.WalletTransactionDetailView;
import java.util.Set;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000X\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\"\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u00012\u00020\u0002B\u001d\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\b¢\u0006\u0002\u0010\tJ\u0012\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0012H\u0016J\b\u0010\u0013\u001a\u00020\u0010H\u0016J\b\u0010\u0014\u001a\u00020\u0010H\u0016J\u0010\u0010\u0015\u001a\u00020\u00102\u0006\u0010\u0016\u001a\u00020\u0017H\u0016J\b\u0010\u0018\u001a\u00020\u0010H\u0016J\u0012\u0010\u0019\u001a\u00020\u00102\b\u0010\u001a\u001a\u0004\u0018\u00010\u001bH\u0016J\u0010\u0010\u001c\u001a\u00020\u00102\u0006\u0010\u001d\u001a\u00020\u001eH\u0016J\u001f\u0010\u001f\u001a\u00020\u00102\u0006\u0010 \u001a\u00020\f2\b\u0010!\u001a\u0004\u0018\u00010\fH\u0016¢\u0006\u0002\u0010\"R\u0016\u0010\n\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\f0\u000bX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0003\u001a\u00020\u0004X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0007\u001a\u0004\u0018\u00010\bX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\r\u001a\u0004\u0018\u00010\u000eX\u000e¢\u0006\u0002\n\u0000¨\u0006#"}, d2 = {"Lcom/talabat/wallet/screens/walletDashboardDetail/presenter/WalletTransactionListDetailPresenter;", "Lcom/talabat/wallet/screens/walletDashboardDetail/WalletTransactionDetailScreenListener;", "Lcom/talabat/wallet/screens/walletDashboardDetail/presenter/IWalletTransactionListDetailPresenter;", "configurationLocalRepository", "Lcom/talabat/configuration/ConfigurationLocalRepository;", "locationConfigurationRepository", "Lcom/talabat/configuration/location/LocationConfigurationRepository;", "walletTransactionDetailView", "Lcom/talabat/wallet/screens/walletDashboardDetail/view/WalletTransactionDetailView;", "(Lcom/talabat/configuration/ConfigurationLocalRepository;Lcom/talabat/configuration/location/LocationConfigurationRepository;Lcom/talabat/wallet/screens/walletDashboardDetail/view/WalletTransactionDetailView;)V", "commonTransactionTypeSet", "", "", "walletTransactionListInteractor", "Lcom/talabat/wallet/screens/walletDashboardDetail/interactor/IWalletTransactionListInteractor;", "getOrderDetailsBeforeNavigation", "", "transactionId", "", "onDestroy", "onNetworkError", "onOrderDetailReceived", "orderDetailResponse", "LJsonModels/OrderDetailsRM;", "onServerError", "onWalletCreditTransactionDetailReceived", "walletCreditTransactionDetailResponse", "LJsonModels/Response/WalletCreditTransactionDetailResponse;", "setTransactionTypeType", "walletCreditTransactionDetailObject", "LJsonModels/Response/WalletCreditTransactionDetailObject;", "setWalletCreditTransactionDetail", "transactionType", "id", "(ILjava/lang/Integer;)V", "com_talabat_talabat_talabat"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class WalletTransactionListDetailPresenter implements WalletTransactionDetailScreenListener, IWalletTransactionListDetailPresenter {
    @NotNull
    private final Set<Integer> commonTransactionTypeSet = SetsKt__SetsKt.setOf(WalletTransactionTypes.REFUNDCREDIT.getValue(), WalletTransactionTypes.REFUNDORDER.getValue(), WalletTransactionTypes.CMSCOMPENSATION.getValue(), WalletTransactionTypes.CMSGIFT.getValue(), WalletTransactionTypes.CMSREFUND.getValue(), WalletTransactionTypes.TALABATCREDIT.getValue(), WalletTransactionTypes.GIFTVOUCHERRECHARGE.getValue(), WalletTransactionTypes.TALABATREWARDSLOYALITY.getValue(), WalletTransactionTypes.RECEIVEDCREDIT.getValue(), WalletTransactionTypes.EMPLOYEE_GIFT_CREDIT.getValue());
    @NotNull
    private final ConfigurationLocalRepository configurationLocalRepository;
    @NotNull
    private final LocationConfigurationRepository locationConfigurationRepository;
    @Nullable
    private WalletTransactionDetailView walletTransactionDetailView;
    @Nullable
    private IWalletTransactionListInteractor walletTransactionListInteractor = new WalletTransactionDetailInteractor(this);

    public WalletTransactionListDetailPresenter(@NotNull ConfigurationLocalRepository configurationLocalRepository2, @NotNull LocationConfigurationRepository locationConfigurationRepository2, @NotNull WalletTransactionDetailView walletTransactionDetailView2) {
        Intrinsics.checkNotNullParameter(configurationLocalRepository2, "configurationLocalRepository");
        Intrinsics.checkNotNullParameter(locationConfigurationRepository2, "locationConfigurationRepository");
        Intrinsics.checkNotNullParameter(walletTransactionDetailView2, "walletTransactionDetailView");
        this.configurationLocalRepository = configurationLocalRepository2;
        this.locationConfigurationRepository = locationConfigurationRepository2;
        this.walletTransactionDetailView = walletTransactionDetailView2;
    }

    public void getOrderDetailsBeforeNavigation(@Nullable String str) {
        IWalletTransactionListInteractor iWalletTransactionListInteractor = this.walletTransactionListInteractor;
        if (iWalletTransactionListInteractor != null) {
            iWalletTransactionListInteractor.getOrderDetails(str);
        }
    }

    public void onDestroy() {
        this.walletTransactionDetailView = null;
        this.walletTransactionListInteractor = null;
    }

    public void onNetworkError() {
        WalletTransactionDetailView walletTransactionDetailView2 = this.walletTransactionDetailView;
        if (walletTransactionDetailView2 != null) {
            walletTransactionDetailView2.onNetworkError();
        }
    }

    public void onOrderDetailReceived(@NotNull OrderDetailsRM orderDetailsRM) {
        Intrinsics.checkNotNullParameter(orderDetailsRM, "orderDetailResponse");
        WalletTransactionDetailView walletTransactionDetailView2 = this.walletTransactionDetailView;
        if (walletTransactionDetailView2 != null) {
            walletTransactionDetailView2.onOrderDetailsRecieved(orderDetailsRM.result);
        }
    }

    public void onServerError() {
        WalletTransactionDetailView walletTransactionDetailView2 = this.walletTransactionDetailView;
        if (walletTransactionDetailView2 != null) {
            walletTransactionDetailView2.displayServerErrorMessage();
        }
    }

    public void onWalletCreditTransactionDetailReceived(@Nullable WalletCreditTransactionDetailResponse walletCreditTransactionDetailResponse) {
        WalletTransactionDetailView walletTransactionDetailView2 = this.walletTransactionDetailView;
        if (walletTransactionDetailView2 != null) {
            walletTransactionDetailView2.addWalletTransactionDetail(walletCreditTransactionDetailResponse);
        }
    }

    public void setTransactionTypeType(@NotNull WalletCreditTransactionDetailObject walletCreditTransactionDetailObject) {
        Intrinsics.checkNotNullParameter(walletCreditTransactionDetailObject, "walletCreditTransactionDetailObject");
        Integer transactionTypeId = walletCreditTransactionDetailObject.getTransactionTypeId();
        if (Intrinsics.areEqual((Object) transactionTypeId, (Object) WalletTransactionTypes.PAID.getValue())) {
            WalletTransactionDetailView walletTransactionDetailView2 = this.walletTransactionDetailView;
            if (walletTransactionDetailView2 != null) {
                walletTransactionDetailView2.showPaidTransactionTypeView(walletCreditTransactionDetailObject);
            }
        } else if (Intrinsics.areEqual((Object) transactionTypeId, (Object) WalletTransactionTypes.CASHBACKREVERSAL.getValue())) {
            WalletTransactionDetailView walletTransactionDetailView3 = this.walletTransactionDetailView;
            if (walletTransactionDetailView3 != null) {
                walletTransactionDetailView3.showCashBackReversalTransactionTypeView(walletCreditTransactionDetailObject);
            }
        } else if (Intrinsics.areEqual((Object) transactionTypeId, (Object) WalletTransactionTypes.RECHARGE.getValue())) {
            WalletTransactionDetailView walletTransactionDetailView4 = this.walletTransactionDetailView;
            if (walletTransactionDetailView4 != null) {
                walletTransactionDetailView4.showRechargeTransactionTypeView(walletCreditTransactionDetailObject);
            }
        } else if (Intrinsics.areEqual((Object) transactionTypeId, (Object) WalletTransactionTypes.CREDITVOUCHER.getValue())) {
            WalletTransactionDetailView walletTransactionDetailView5 = this.walletTransactionDetailView;
            if (walletTransactionDetailView5 != null) {
                walletTransactionDetailView5.showCreditVoucherTransactionTypeView(walletCreditTransactionDetailObject);
            }
        } else if (Intrinsics.areEqual((Object) transactionTypeId, (Object) WalletTransactionTypes.CREDITEXPIRED.getValue())) {
            WalletTransactionDetailView walletTransactionDetailView6 = this.walletTransactionDetailView;
            if (walletTransactionDetailView6 != null) {
                walletTransactionDetailView6.showCreditExpiredTransactionTypeView(walletCreditTransactionDetailObject);
            }
        } else if (Intrinsics.areEqual((Object) transactionTypeId, (Object) WalletTransactionTypes.RIDERTIP.getValue())) {
            WalletTransactionDetailView walletTransactionDetailView7 = this.walletTransactionDetailView;
            if (walletTransactionDetailView7 != null) {
                walletTransactionDetailView7.showRiderTipTransactionTypeView(walletCreditTransactionDetailObject);
            }
        } else if (this.commonTransactionTypeSet.contains(transactionTypeId)) {
            WalletTransactionDetailView walletTransactionDetailView8 = this.walletTransactionDetailView;
            if (walletTransactionDetailView8 != null) {
                walletTransactionDetailView8.showRefundTransactionTypeView(walletCreditTransactionDetailObject);
            }
        } else {
            LogManager.debug("no matching transaction type");
        }
    }

    public void setWalletCreditTransactionDetail(int i11, @Nullable Integer num) {
        Customer instance = Customer.getInstance();
        if (instance != null && instance.isLoggedIn()) {
            TalabatUtils.getSelectedCountry(this.configurationLocalRepository, this.locationConfigurationRepository);
            WalletTransactionDetailView walletTransactionDetailView2 = this.walletTransactionDetailView;
            if (walletTransactionDetailView2 != null) {
                walletTransactionDetailView2.setupProgressBarBeforeServiceRequest();
            }
            IWalletTransactionListInteractor iWalletTransactionListInteractor = this.walletTransactionListInteractor;
            if (iWalletTransactionListInteractor != null) {
                iWalletTransactionListInteractor.getWalletCreditTransactionDetail(String.valueOf(i11), num);
            }
        }
    }
}
