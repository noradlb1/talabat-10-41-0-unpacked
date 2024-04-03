package com.talabat.wallet.ui.walletTopUp.viewModel;

import androidx.lifecycle.MutableLiveData;
import com.talabat.talabatcommon.model.wallet.WalletCardListDisplayModel;
import com.talabat.talabatcommon.views.wallet.walletCardManagement.model.IconStateDisplayModel;
import com.talabat.talabatcore.viewmodel.BaseViewModel;
import com.talabat.wallet.features.walletCashBack.CashBackCampaignOfferParams;
import com.talabat.wallet.features.walletCashBack.model.request.WalletCalculateCashBackRequestModel;
import com.talabat.wallet.features.walletCashBack.model.response.WalletCashBackCampaignResponse;
import com.talabat.wallet.ui.walletTopUp.model.WalletCalculateCashBackDisplayModel;
import com.talabat.wallet.ui.walletTopUp.model.WalletCreditCardListDataItemDisplayModel;
import com.talabat.wallet.ui.walletTopUp.model.WalletCreditCardListDataItemWithTypeDisplayModel;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\b&\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0010\u0010+\u001a\u00020,2\u0006\u0010-\u001a\u00020.H&J\u0010\u0010/\u001a\u00020,2\u0006\u00100\u001a\u000201H&J\u0010\u00102\u001a\u00020,2\u0006\u00103\u001a\u000204H&J\u0010\u00105\u001a\u00020,2\u0006\u00106\u001a\u000201H&J\b\u00107\u001a\u00020,H&J\u0010\u00108\u001a\u00020,2\u0006\u00109\u001a\u00020\u0013H&J\b\u0010:\u001a\u00020,H&R \u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR \u0010\n\u001a\b\u0012\u0004\u0012\u00020\u000b0\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\u0007\"\u0004\b\r\u0010\tR \u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u000f0\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u0007\"\u0004\b\u0011\u0010\tR \u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00130\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u0007\"\u0004\b\u0015\u0010\tR \u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00170\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0018\u0010\u0007\"\u0004\b\u0019\u0010\tR \u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u000b0\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001b\u0010\u0007\"\u0004\b\u001c\u0010\tR\u0018\u0010\u001d\u001a\u00020\u000bX¦\u000e¢\u0006\f\u001a\u0004\b\u001d\u0010\u001e\"\u0004\b\u001f\u0010 R\u0018\u0010!\u001a\u00020\u000bX¦\u000e¢\u0006\f\u001a\u0004\b!\u0010\u001e\"\u0004\b\"\u0010 R \u0010#\u001a\b\u0012\u0004\u0012\u00020$0\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b%\u0010\u0007\"\u0004\b&\u0010\tR \u0010'\u001a\b\u0012\u0004\u0012\u00020(0\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b)\u0010\u0007\"\u0004\b*\u0010\t¨\u0006;"}, d2 = {"Lcom/talabat/wallet/ui/walletTopUp/viewModel/WalletTopUpViewModel;", "Lcom/talabat/talabatcore/viewmodel/BaseViewModel;", "()V", "addCardIconData", "Landroidx/lifecycle/MutableLiveData;", "Lcom/talabat/talabatcommon/views/wallet/walletCardManagement/model/IconStateDisplayModel;", "getAddCardIconData", "()Landroidx/lifecycle/MutableLiveData;", "setAddCardIconData", "(Landroidx/lifecycle/MutableLiveData;)V", "calculateCashBackLoaderData", "", "getCalculateCashBackLoaderData", "setCalculateCashBackLoaderData", "calculatedCashBackData", "Lcom/talabat/wallet/ui/walletTopUp/model/WalletCalculateCashBackDisplayModel;", "getCalculatedCashBackData", "setCalculatedCashBackData", "cardAdapterItemData", "Lcom/talabat/wallet/ui/walletTopUp/model/WalletCreditCardListDataItemDisplayModel$WalletCardAdapterDisplayModel;", "getCardAdapterItemData", "setCardAdapterItemData", "cashBackCampaignData", "Lcom/talabat/wallet/features/walletCashBack/model/response/WalletCashBackCampaignResponse;", "getCashBackCampaignData", "setCashBackCampaignData", "emptyCardListData", "getEmptyCardListData", "setEmptyCardListData", "isCampaignAvailable", "()Z", "setCampaignAvailable", "(Z)V", "isWalletAddCardFlutterScreenEnabled", "setWalletAddCardFlutterScreenEnabled", "topUpCardListData", "Lcom/talabat/talabatcommon/model/wallet/WalletCardListDisplayModel;", "getTopUpCardListData", "setTopUpCardListData", "topUpItemsListDataCredit", "Lcom/talabat/wallet/ui/walletTopUp/model/WalletCreditCardListDataItemWithTypeDisplayModel;", "getTopUpItemsListDataCredit", "setTopUpItemsListDataCredit", "getCalculatedCashBack", "", "requestModel", "Lcom/talabat/wallet/features/walletCashBack/model/request/WalletCalculateCashBackRequestModel;", "getCardList", "countryCode", "", "getCashBackCampaignOffer", "cashBackCampaignOfferParams", "Lcom/talabat/wallet/features/walletCashBack/CashBackCampaignOfferParams;", "getCashBackCampaigns", "eventId", "initFeatureFlags", "onCreditCardClicked", "walletCardDisplayModel", "onShowAddCardButton", "com_talabat_NewArchi_WalletSquad_WalletSquad"}, k = 1, mv = {1, 6, 0}, xi = 48)
public abstract class WalletTopUpViewModel extends BaseViewModel {
    @NotNull
    private MutableLiveData<IconStateDisplayModel> addCardIconData = new MutableLiveData<>();
    @NotNull
    private MutableLiveData<Boolean> calculateCashBackLoaderData = new MutableLiveData<>();
    @NotNull
    private MutableLiveData<WalletCalculateCashBackDisplayModel> calculatedCashBackData = new MutableLiveData<>();
    @NotNull
    private MutableLiveData<WalletCreditCardListDataItemDisplayModel.WalletCardAdapterDisplayModel> cardAdapterItemData = new MutableLiveData<>();
    @NotNull
    private MutableLiveData<WalletCashBackCampaignResponse> cashBackCampaignData = new MutableLiveData<>();
    @NotNull
    private MutableLiveData<Boolean> emptyCardListData = new MutableLiveData<>();
    @NotNull
    private MutableLiveData<WalletCardListDisplayModel> topUpCardListData = new MutableLiveData<>();
    @NotNull
    private MutableLiveData<WalletCreditCardListDataItemWithTypeDisplayModel> topUpItemsListDataCredit = new MutableLiveData<>();

    @NotNull
    public final MutableLiveData<IconStateDisplayModel> getAddCardIconData() {
        return this.addCardIconData;
    }

    @NotNull
    public final MutableLiveData<Boolean> getCalculateCashBackLoaderData() {
        return this.calculateCashBackLoaderData;
    }

    public abstract void getCalculatedCashBack(@NotNull WalletCalculateCashBackRequestModel walletCalculateCashBackRequestModel);

    @NotNull
    public final MutableLiveData<WalletCalculateCashBackDisplayModel> getCalculatedCashBackData() {
        return this.calculatedCashBackData;
    }

    @NotNull
    public final MutableLiveData<WalletCreditCardListDataItemDisplayModel.WalletCardAdapterDisplayModel> getCardAdapterItemData() {
        return this.cardAdapterItemData;
    }

    public abstract void getCardList(int i11);

    @NotNull
    public final MutableLiveData<WalletCashBackCampaignResponse> getCashBackCampaignData() {
        return this.cashBackCampaignData;
    }

    public abstract void getCashBackCampaignOffer(@NotNull CashBackCampaignOfferParams cashBackCampaignOfferParams);

    public abstract void getCashBackCampaigns(int i11);

    @NotNull
    public final MutableLiveData<Boolean> getEmptyCardListData() {
        return this.emptyCardListData;
    }

    @NotNull
    public final MutableLiveData<WalletCardListDisplayModel> getTopUpCardListData() {
        return this.topUpCardListData;
    }

    @NotNull
    public final MutableLiveData<WalletCreditCardListDataItemWithTypeDisplayModel> getTopUpItemsListDataCredit() {
        return this.topUpItemsListDataCredit;
    }

    public abstract void initFeatureFlags();

    public abstract boolean isCampaignAvailable();

    public abstract boolean isWalletAddCardFlutterScreenEnabled();

    public abstract void onCreditCardClicked(@NotNull WalletCreditCardListDataItemDisplayModel.WalletCardAdapterDisplayModel walletCardAdapterDisplayModel);

    public abstract void onShowAddCardButton();

    public final void setAddCardIconData(@NotNull MutableLiveData<IconStateDisplayModel> mutableLiveData) {
        Intrinsics.checkNotNullParameter(mutableLiveData, "<set-?>");
        this.addCardIconData = mutableLiveData;
    }

    public final void setCalculateCashBackLoaderData(@NotNull MutableLiveData<Boolean> mutableLiveData) {
        Intrinsics.checkNotNullParameter(mutableLiveData, "<set-?>");
        this.calculateCashBackLoaderData = mutableLiveData;
    }

    public final void setCalculatedCashBackData(@NotNull MutableLiveData<WalletCalculateCashBackDisplayModel> mutableLiveData) {
        Intrinsics.checkNotNullParameter(mutableLiveData, "<set-?>");
        this.calculatedCashBackData = mutableLiveData;
    }

    public abstract void setCampaignAvailable(boolean z11);

    public final void setCardAdapterItemData(@NotNull MutableLiveData<WalletCreditCardListDataItemDisplayModel.WalletCardAdapterDisplayModel> mutableLiveData) {
        Intrinsics.checkNotNullParameter(mutableLiveData, "<set-?>");
        this.cardAdapterItemData = mutableLiveData;
    }

    public final void setCashBackCampaignData(@NotNull MutableLiveData<WalletCashBackCampaignResponse> mutableLiveData) {
        Intrinsics.checkNotNullParameter(mutableLiveData, "<set-?>");
        this.cashBackCampaignData = mutableLiveData;
    }

    public final void setEmptyCardListData(@NotNull MutableLiveData<Boolean> mutableLiveData) {
        Intrinsics.checkNotNullParameter(mutableLiveData, "<set-?>");
        this.emptyCardListData = mutableLiveData;
    }

    public final void setTopUpCardListData(@NotNull MutableLiveData<WalletCardListDisplayModel> mutableLiveData) {
        Intrinsics.checkNotNullParameter(mutableLiveData, "<set-?>");
        this.topUpCardListData = mutableLiveData;
    }

    public final void setTopUpItemsListDataCredit(@NotNull MutableLiveData<WalletCreditCardListDataItemWithTypeDisplayModel> mutableLiveData) {
        Intrinsics.checkNotNullParameter(mutableLiveData, "<set-?>");
        this.topUpItemsListDataCredit = mutableLiveData;
    }

    public abstract void setWalletAddCardFlutterScreenEnabled(boolean z11);
}
