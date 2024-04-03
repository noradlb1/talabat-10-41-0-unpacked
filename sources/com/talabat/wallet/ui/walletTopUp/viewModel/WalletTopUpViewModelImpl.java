package com.talabat.wallet.ui.walletTopUp.viewModel;

import androidx.lifecycle.ViewModelKt;
import com.talabat.core.featureflag.domain.flags.pay.PayFeatureFlagConstants;
import com.talabat.talabatcommon.feature.walletCardList.GetCardListUseCase;
import com.talabat.talabatcommon.feature.walletCardManagement.GetWalletCardManagementFeatureEnabledUseCase;
import com.talabat.talabatcommon.feature.walletPayment.GetWalletPaymentFlagEnabledUseCase;
import com.talabat.talabatcommon.model.wallet.WalletCardListDisplayModel;
import com.talabat.talabatcommon.views.wallet.IsWalletAddCardFlutterScreenEnabledUseCase;
import com.talabat.talabatcommon.views.wallet.walletCardManagement.model.IconStateDisplayModel;
import com.talabat.talabatcore.exception.Failure;
import com.talabat.talabatcore.logger.LogManager;
import com.talabat.wallet.features.walletCashBack.CashBackCampaignOfferParams;
import com.talabat.wallet.features.walletCashBack.GetCalculatedCashBackUseCase;
import com.talabat.wallet.features.walletCashBack.GetCashBackCampaignOfferUseCase;
import com.talabat.wallet.features.walletCashBack.GetCashBackCampaignsUseCase;
import com.talabat.wallet.features.walletCashBack.GetFormattedWalletTopUpListUseCase;
import com.talabat.wallet.features.walletCashBack.model.request.WalletCalculateCashBackRequestModel;
import com.talabat.wallet.features.walletCashBack.model.response.WalletCashBackCampaignModel;
import com.talabat.wallet.features.walletCashBack.model.response.WalletCashBackCampaignResponse;
import com.talabat.wallet.features.walletCashBack.model.response.WalletCashBackCampaignResponseResult;
import com.talabat.wallet.ui.walletTopUp.model.WalletCalculateCashBackDisplayModel;
import com.talabat.wallet.ui.walletTopUp.model.WalletCashBackCampaignOfferDisplayModel;
import com.talabat.wallet.ui.walletTopUp.model.WalletCreditCardListDataItemDisplayModel;
import com.talabat.wallet.ui.walletTopUp.model.WalletCreditCardListDataItemWithTypeDisplayModel;
import java.util.Collection;
import java.util.List;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.Job;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001BU\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\u000b\u0012\u0006\u0010\f\u001a\u00020\r\u0012\u0006\u0010\u000e\u001a\u00020\u000f\u0012\u0006\u0010\u0010\u001a\u00020\u0011\u0012\u0006\u0010\u0012\u001a\u00020\u0013\u0012\u0006\u0010\u0014\u001a\u00020\u0015¢\u0006\u0002\u0010\u0016J\u0010\u0010\u001e\u001a\u00020\u001f2\u0006\u0010 \u001a\u00020!H\u0016J\u0010\u0010\"\u001a\u00020\u001f2\u0006\u0010#\u001a\u00020$H\u0016J\u0010\u0010%\u001a\u00020\u001f2\u0006\u0010&\u001a\u00020'H\u0016J\u0010\u0010(\u001a\u00020\u001f2\u0006\u0010)\u001a\u00020$H\u0016J\u0010\u0010*\u001a\u00020\u001f2\u0006\u0010+\u001a\u00020,H\u0002J\u0010\u0010-\u001a\u00020\u001f2\u0006\u0010.\u001a\u00020/H\u0002J\u0010\u00100\u001a\u00020\u001f2\u0006\u0010+\u001a\u00020,H\u0002J\u0010\u00101\u001a\u00020\u001f2\u0006\u0010+\u001a\u00020,H\u0002J\u0010\u00102\u001a\u00020\u001f2\u0006\u00103\u001a\u000204H\u0002J\u0010\u00105\u001a\u00020\u001f2\u0006\u00106\u001a\u000207H\u0002J\u0010\u00108\u001a\u00020\u001f2\u0006\u00109\u001a\u00020:H\u0002J\b\u0010;\u001a\u00020\u001fH\u0016J\u0010\u0010<\u001a\u00020\u001f2\u0006\u0010=\u001a\u00020>H\u0016J\b\u0010?\u001a\u00020\u001fH\u0016J\b\u0010@\u001a\u00020\u001fH\u0002R\u000e\u0010\n\u001a\u00020\u000bX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u0017\u001a\u00020\u0018X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\u0019\"\u0004\b\u001a\u0010\u001bR\u001a\u0010\u001c\u001a\u00020\u0018X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001c\u0010\u0019\"\u0004\b\u001d\u0010\u001bR\u000e\u0010\u0012\u001a\u00020\u0013X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0011X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0015X\u0004¢\u0006\u0002\n\u0000¨\u0006A"}, d2 = {"Lcom/talabat/wallet/ui/walletTopUp/viewModel/WalletTopUpViewModelImpl;", "Lcom/talabat/wallet/ui/walletTopUp/viewModel/WalletTopUpViewModel;", "getCardListUseCase", "Lcom/talabat/talabatcommon/feature/walletCardList/GetCardListUseCase;", "getCashBackCampaignsUseCase", "Lcom/talabat/wallet/features/walletCashBack/GetCashBackCampaignsUseCase;", "getCashBackCampaignOfferUseCase", "Lcom/talabat/wallet/features/walletCashBack/GetCashBackCampaignOfferUseCase;", "getFormattedWalletTopUpListUseCase", "Lcom/talabat/wallet/features/walletCashBack/GetFormattedWalletTopUpListUseCase;", "getCalculatedCashBackUseCase", "Lcom/talabat/wallet/features/walletCashBack/GetCalculatedCashBackUseCase;", "getWalletCardManagementFeatureEnabled", "Lcom/talabat/talabatcommon/feature/walletCardManagement/GetWalletCardManagementFeatureEnabledUseCase;", "getWalletPaymentFlagEnabledUseCase", "Lcom/talabat/talabatcommon/feature/walletPayment/GetWalletPaymentFlagEnabledUseCase;", "setDebitCardsDeflectionUseCase", "Lcom/talabat/wallet/ui/walletTopUp/viewModel/SetDebitCardsDeflectionUseCase;", "isWalletAddCardFlutterScreenEnabledUseCase", "Lcom/talabat/talabatcommon/views/wallet/IsWalletAddCardFlutterScreenEnabledUseCase;", "trackCreditCardClickedUseCase", "Lcom/talabat/wallet/ui/walletTopUp/viewModel/TrackCreditCardClickedUseCase;", "(Lcom/talabat/talabatcommon/feature/walletCardList/GetCardListUseCase;Lcom/talabat/wallet/features/walletCashBack/GetCashBackCampaignsUseCase;Lcom/talabat/wallet/features/walletCashBack/GetCashBackCampaignOfferUseCase;Lcom/talabat/wallet/features/walletCashBack/GetFormattedWalletTopUpListUseCase;Lcom/talabat/wallet/features/walletCashBack/GetCalculatedCashBackUseCase;Lcom/talabat/talabatcommon/feature/walletCardManagement/GetWalletCardManagementFeatureEnabledUseCase;Lcom/talabat/talabatcommon/feature/walletPayment/GetWalletPaymentFlagEnabledUseCase;Lcom/talabat/wallet/ui/walletTopUp/viewModel/SetDebitCardsDeflectionUseCase;Lcom/talabat/talabatcommon/views/wallet/IsWalletAddCardFlutterScreenEnabledUseCase;Lcom/talabat/wallet/ui/walletTopUp/viewModel/TrackCreditCardClickedUseCase;)V", "isCampaignAvailable", "", "()Z", "setCampaignAvailable", "(Z)V", "isWalletAddCardFlutterScreenEnabled", "setWalletAddCardFlutterScreenEnabled", "getCalculatedCashBack", "", "requestModel", "Lcom/talabat/wallet/features/walletCashBack/model/request/WalletCalculateCashBackRequestModel;", "getCardList", "countryCode", "", "getCashBackCampaignOffer", "cashBackCampaignOfferParams", "Lcom/talabat/wallet/features/walletCashBack/CashBackCampaignOfferParams;", "getCashBackCampaigns", "eventId", "handleCalculateCashBackFailure", "failure", "Lcom/talabat/talabatcore/exception/Failure;", "handleCalculateCashBackSuccess", "walletCalculateCashBackDisplayModel", "Lcom/talabat/wallet/ui/walletTopUp/model/WalletCalculateCashBackDisplayModel;", "handleCashBackCampaignFailure", "handleCashBackCampaignOfferFailure", "handleCashBackCampaignOfferSuccess", "walletCashBackCampaignOfferDisplayModel", "Lcom/talabat/wallet/ui/walletTopUp/model/WalletCashBackCampaignOfferDisplayModel;", "handleCashBackCampaignSuccess", "walletCashBackCampaignResponse", "Lcom/talabat/wallet/features/walletCashBack/model/response/WalletCashBackCampaignResponse;", "handleWalletCardListSuccess", "walletCardListDisplayModel", "Lcom/talabat/talabatcommon/model/wallet/WalletCardListDisplayModel;", "initFeatureFlags", "onCreditCardClicked", "walletCardDisplayModel", "Lcom/talabat/wallet/ui/walletTopUp/model/WalletCreditCardListDataItemDisplayModel$WalletCardAdapterDisplayModel;", "onShowAddCardButton", "populateWalletTopUpListData", "com_talabat_NewArchi_WalletSquad_WalletSquad"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class WalletTopUpViewModelImpl extends WalletTopUpViewModel {
    @NotNull
    private final GetCalculatedCashBackUseCase getCalculatedCashBackUseCase;
    @NotNull
    private final GetCardListUseCase getCardListUseCase;
    @NotNull
    private final GetCashBackCampaignOfferUseCase getCashBackCampaignOfferUseCase;
    @NotNull
    private final GetCashBackCampaignsUseCase getCashBackCampaignsUseCase;
    /* access modifiers changed from: private */
    @NotNull
    public final GetFormattedWalletTopUpListUseCase getFormattedWalletTopUpListUseCase;
    @NotNull
    private final GetWalletCardManagementFeatureEnabledUseCase getWalletCardManagementFeatureEnabled;
    @NotNull
    private final GetWalletPaymentFlagEnabledUseCase getWalletPaymentFlagEnabledUseCase;
    private boolean isCampaignAvailable;
    private boolean isWalletAddCardFlutterScreenEnabled;
    @NotNull
    private final IsWalletAddCardFlutterScreenEnabledUseCase isWalletAddCardFlutterScreenEnabledUseCase;
    /* access modifiers changed from: private */
    @NotNull
    public final SetDebitCardsDeflectionUseCase setDebitCardsDeflectionUseCase;
    @NotNull
    private final TrackCreditCardClickedUseCase trackCreditCardClickedUseCase;

    public WalletTopUpViewModelImpl(@NotNull GetCardListUseCase getCardListUseCase2, @NotNull GetCashBackCampaignsUseCase getCashBackCampaignsUseCase2, @NotNull GetCashBackCampaignOfferUseCase getCashBackCampaignOfferUseCase2, @NotNull GetFormattedWalletTopUpListUseCase getFormattedWalletTopUpListUseCase2, @NotNull GetCalculatedCashBackUseCase getCalculatedCashBackUseCase2, @NotNull GetWalletCardManagementFeatureEnabledUseCase getWalletCardManagementFeatureEnabledUseCase, @NotNull GetWalletPaymentFlagEnabledUseCase getWalletPaymentFlagEnabledUseCase2, @NotNull SetDebitCardsDeflectionUseCase setDebitCardsDeflectionUseCase2, @NotNull IsWalletAddCardFlutterScreenEnabledUseCase isWalletAddCardFlutterScreenEnabledUseCase2, @NotNull TrackCreditCardClickedUseCase trackCreditCardClickedUseCase2) {
        Intrinsics.checkNotNullParameter(getCardListUseCase2, "getCardListUseCase");
        Intrinsics.checkNotNullParameter(getCashBackCampaignsUseCase2, "getCashBackCampaignsUseCase");
        Intrinsics.checkNotNullParameter(getCashBackCampaignOfferUseCase2, "getCashBackCampaignOfferUseCase");
        Intrinsics.checkNotNullParameter(getFormattedWalletTopUpListUseCase2, "getFormattedWalletTopUpListUseCase");
        Intrinsics.checkNotNullParameter(getCalculatedCashBackUseCase2, "getCalculatedCashBackUseCase");
        Intrinsics.checkNotNullParameter(getWalletCardManagementFeatureEnabledUseCase, "getWalletCardManagementFeatureEnabled");
        Intrinsics.checkNotNullParameter(getWalletPaymentFlagEnabledUseCase2, "getWalletPaymentFlagEnabledUseCase");
        Intrinsics.checkNotNullParameter(setDebitCardsDeflectionUseCase2, "setDebitCardsDeflectionUseCase");
        Intrinsics.checkNotNullParameter(isWalletAddCardFlutterScreenEnabledUseCase2, "isWalletAddCardFlutterScreenEnabledUseCase");
        Intrinsics.checkNotNullParameter(trackCreditCardClickedUseCase2, "trackCreditCardClickedUseCase");
        this.getCardListUseCase = getCardListUseCase2;
        this.getCashBackCampaignsUseCase = getCashBackCampaignsUseCase2;
        this.getCashBackCampaignOfferUseCase = getCashBackCampaignOfferUseCase2;
        this.getFormattedWalletTopUpListUseCase = getFormattedWalletTopUpListUseCase2;
        this.getCalculatedCashBackUseCase = getCalculatedCashBackUseCase2;
        this.getWalletCardManagementFeatureEnabled = getWalletCardManagementFeatureEnabledUseCase;
        this.getWalletPaymentFlagEnabledUseCase = getWalletPaymentFlagEnabledUseCase2;
        this.setDebitCardsDeflectionUseCase = setDebitCardsDeflectionUseCase2;
        this.isWalletAddCardFlutterScreenEnabledUseCase = isWalletAddCardFlutterScreenEnabledUseCase2;
        this.trackCreditCardClickedUseCase = trackCreditCardClickedUseCase2;
    }

    /* access modifiers changed from: private */
    public final void handleCalculateCashBackFailure(Failure failure) {
        getCalculateCashBackLoaderData().setValue(Boolean.FALSE);
    }

    /* access modifiers changed from: private */
    public final void handleCalculateCashBackSuccess(WalletCalculateCashBackDisplayModel walletCalculateCashBackDisplayModel) {
        getCalculateCashBackLoaderData().setValue(Boolean.FALSE);
        getCalculatedCashBackData().setValue(walletCalculateCashBackDisplayModel);
    }

    /* access modifiers changed from: private */
    public final void handleCashBackCampaignFailure(Failure failure) {
        getCashBackCampaignData().setValue(new WalletCashBackCampaignResponse((WalletCashBackCampaignResponseResult) null, 1, (DefaultConstructorMarker) null));
        populateWalletTopUpListData();
    }

    /* access modifiers changed from: private */
    public final void handleCashBackCampaignOfferFailure(Failure failure) {
        LogManager.debug("CashBackCampaignOffer failed");
    }

    /* access modifiers changed from: private */
    public final void handleCashBackCampaignOfferSuccess(WalletCashBackCampaignOfferDisplayModel walletCashBackCampaignOfferDisplayModel) {
        WalletCreditCardListDataItemDisplayModel walletCreditCardListDataItemDisplayModel;
        List<WalletCreditCardListDataItemDisplayModel> data;
        WalletCreditCardListDataItemWithTypeDisplayModel value = getTopUpItemsListDataCredit().getValue();
        if (value == null || (data = value.getData()) == null) {
            walletCreditCardListDataItemDisplayModel = null;
        } else {
            walletCreditCardListDataItemDisplayModel = data.get(walletCashBackCampaignOfferDisplayModel.getAdapterPosition());
        }
        if (walletCreditCardListDataItemDisplayModel != null) {
            WalletCreditCardListDataItemDisplayModel.WalletCardAdapterDisplayModel walletCardAdapterDisplayModel = (WalletCreditCardListDataItemDisplayModel.WalletCardAdapterDisplayModel) walletCreditCardListDataItemDisplayModel;
            walletCardAdapterDisplayModel.setAdvertTextMessageShown(true);
            walletCardAdapterDisplayModel.setAdTextMessage(walletCashBackCampaignOfferDisplayModel.getCampaignText());
            walletCardAdapterDisplayModel.setPosition(walletCashBackCampaignOfferDisplayModel.getAdapterPosition());
            getCardAdapterItemData().setValue(walletCreditCardListDataItemDisplayModel);
            return;
        }
        throw new NullPointerException("null cannot be cast to non-null type com.talabat.wallet.ui.walletTopUp.model.WalletCreditCardListDataItemDisplayModel.WalletCardAdapterDisplayModel");
    }

    /* access modifiers changed from: private */
    public final void handleCashBackCampaignSuccess(WalletCashBackCampaignResponse walletCashBackCampaignResponse) {
        List<WalletCashBackCampaignModel> list;
        boolean z11;
        getCashBackCampaignData().setValue(walletCashBackCampaignResponse);
        WalletCashBackCampaignResponseResult result = walletCashBackCampaignResponse.getResult();
        if (result != null) {
            list = result.getCampaigns();
        } else {
            list = null;
        }
        Collection collection = list;
        if (collection == null || collection.isEmpty()) {
            z11 = true;
        } else {
            z11 = false;
        }
        if (!z11) {
            setCampaignAvailable(true);
        }
        populateWalletTopUpListData();
    }

    /* access modifiers changed from: private */
    public final void handleWalletCardListSuccess(WalletCardListDisplayModel walletCardListDisplayModel) {
        if (walletCardListDisplayModel.getCardList().isEmpty()) {
            getEmptyCardListData().setValue(Boolean.TRUE);
        }
        getTopUpCardListData().setValue(walletCardListDisplayModel);
        populateWalletTopUpListData();
    }

    private final void populateWalletTopUpListData() {
        Job unused = BuildersKt__Builders_commonKt.launch$default(ViewModelKt.getViewModelScope(this), (CoroutineContext) null, (CoroutineStart) null, new WalletTopUpViewModelImpl$populateWalletTopUpListData$1(this, (Continuation<? super WalletTopUpViewModelImpl$populateWalletTopUpListData$1>) null), 3, (Object) null);
    }

    public void getCalculatedCashBack(@NotNull WalletCalculateCashBackRequestModel walletCalculateCashBackRequestModel) {
        Intrinsics.checkNotNullParameter(walletCalculateCashBackRequestModel, "requestModel");
        if (this.getWalletPaymentFlagEnabledUseCase.invoke(PayFeatureFlagConstants.CASHBACK)) {
            getCalculateCashBackLoaderData().setValue(Boolean.TRUE);
            this.getCalculatedCashBackUseCase.invoke(walletCalculateCashBackRequestModel, new WalletTopUpViewModelImpl$getCalculatedCashBack$1(this));
        }
    }

    public void getCardList(int i11) {
        this.getCardListUseCase.invoke(Integer.valueOf(i11), new WalletTopUpViewModelImpl$getCardList$1(this));
    }

    public void getCashBackCampaignOffer(@NotNull CashBackCampaignOfferParams cashBackCampaignOfferParams) {
        Intrinsics.checkNotNullParameter(cashBackCampaignOfferParams, "cashBackCampaignOfferParams");
        if (this.getWalletPaymentFlagEnabledUseCase.invoke(PayFeatureFlagConstants.CASHBACK)) {
            this.getCashBackCampaignOfferUseCase.invoke(cashBackCampaignOfferParams, new WalletTopUpViewModelImpl$getCashBackCampaignOffer$1(this));
        }
    }

    public void getCashBackCampaigns(int i11) {
        if (this.getWalletPaymentFlagEnabledUseCase.invoke(PayFeatureFlagConstants.CASHBACK)) {
            this.getCashBackCampaignsUseCase.invoke(Integer.valueOf(i11), new WalletTopUpViewModelImpl$getCashBackCampaigns$1(this));
        } else {
            getCashBackCampaignData().setValue(new WalletCashBackCampaignResponse((WalletCashBackCampaignResponseResult) null, 1, (DefaultConstructorMarker) null));
        }
    }

    public void initFeatureFlags() {
        setWalletAddCardFlutterScreenEnabled(this.isWalletAddCardFlutterScreenEnabledUseCase.invoke());
    }

    public boolean isCampaignAvailable() {
        return this.isCampaignAvailable;
    }

    public boolean isWalletAddCardFlutterScreenEnabled() {
        return this.isWalletAddCardFlutterScreenEnabled;
    }

    public void onCreditCardClicked(@NotNull WalletCreditCardListDataItemDisplayModel.WalletCardAdapterDisplayModel walletCardAdapterDisplayModel) {
        Intrinsics.checkNotNullParameter(walletCardAdapterDisplayModel, "walletCardDisplayModel");
        this.trackCreditCardClickedUseCase.trackCreditCardClickedEvent();
    }

    public void onShowAddCardButton() {
        if (this.getWalletCardManagementFeatureEnabled.invoke(PayFeatureFlagConstants.ADD_CARD)) {
            getAddCardIconData().postValue(IconStateDisplayModel.ShowIcon.INSTANCE);
        } else {
            getAddCardIconData().postValue(IconStateDisplayModel.HideIcon.INSTANCE);
        }
    }

    public void setCampaignAvailable(boolean z11) {
        this.isCampaignAvailable = z11;
    }

    public void setWalletAddCardFlutterScreenEnabled(boolean z11) {
        this.isWalletAddCardFlutterScreenEnabled = z11;
    }
}
