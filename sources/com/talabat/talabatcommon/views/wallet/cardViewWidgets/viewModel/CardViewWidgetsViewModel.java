package com.talabat.talabatcommon.views.wallet.cardViewWidgets.viewModel;

import androidx.lifecycle.MutableLiveData;
import com.integration.IntegrationGlobalDataModel;
import com.talabat.talabatcommon.feature.walletPayment.utils.PaymentProviderHelper;
import com.talabat.talabatcommon.model.wallet.WalletCardDisplayModel;
import com.talabat.talabatcommon.model.wallet.WalletCardListDisplayModel;
import com.talabat.talabatcommon.views.wallet.walletPaymentWidgetConfig.model.WalletPaymentWidgetConfigDisplayModel;
import com.talabat.talabatcore.viewmodel.BaseViewModel;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0014\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\b\u0007\b&\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u001c\u00100\u001a\u0002012\b\b\u0002\u00102\u001a\u0002032\b\b\u0002\u00104\u001a\u000203H&J\u0016\u00105\u001a\u0002012\f\u00106\u001a\b\u0012\u0004\u0012\u00020 07H&J\"\u00108\u001a\u0002012\b\b\u0002\u00104\u001a\u0002032\u0006\u00109\u001a\u0002032\u0006\u0010:\u001a\u000203H&J\u0010\u0010;\u001a\u0002012\u0006\u0010<\u001a\u00020$H&J\b\u0010=\u001a\u000201H&R \u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR \u0010\n\u001a\b\u0012\u0004\u0012\u00020\u000b0\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\u0007\"\u0004\b\r\u0010\tR\u001a\u0010\u000e\u001a\u00020\u0005X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R\u0018\u0010\u0012\u001a\u00020\u0005X¦\u000e¢\u0006\f\u001a\u0004\b\u0012\u0010\u000f\"\u0004\b\u0013\u0010\u0011R\u001a\u0010\u0014\u001a\u00020\u0005X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u000f\"\u0004\b\u0015\u0010\u0011R\u0018\u0010\u0016\u001a\u00020\u0005X¦\u000e¢\u0006\f\u001a\u0004\b\u0016\u0010\u000f\"\u0004\b\u0017\u0010\u0011R \u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0018\u0010\u0007\"\u0004\b\u0019\u0010\tR\u001a\u0010\u001a\u001a\u00020\u0005X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001a\u0010\u000f\"\u0004\b\u001b\u0010\u0011R \u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001d\u0010\u0007\"\u0004\b\u001e\u0010\tR \u0010\u001f\u001a\b\u0012\u0004\u0012\u00020 0\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b!\u0010\u0007\"\u0004\b\"\u0010\tR\u001a\u0010#\u001a\u00020$X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b%\u0010&\"\u0004\b'\u0010(R \u0010)\u001a\b\u0012\u0004\u0012\u00020$0\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b*\u0010\u0007\"\u0004\b+\u0010\tR \u0010,\u001a\b\u0012\u0004\u0012\u00020-0\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b.\u0010\u0007\"\u0004\b/\u0010\t¨\u0006>"}, d2 = {"Lcom/talabat/talabatcommon/views/wallet/cardViewWidgets/viewModel/CardViewWidgetsViewModel;", "Lcom/talabat/talabatcore/viewmodel/BaseViewModel;", "()V", "cardChangedData", "Landroidx/lifecycle/MutableLiveData;", "", "getCardChangedData", "()Landroidx/lifecycle/MutableLiveData;", "setCardChangedData", "(Landroidx/lifecycle/MutableLiveData;)V", "deflectionInfoDisplayModelData", "Lcom/talabat/talabatcommon/views/wallet/cardViewWidgets/viewModel/DeflectionInfoDisplayModel;", "getDeflectionInfoDisplayModelData", "setDeflectionInfoDisplayModelData", "isCardEnabled", "()Z", "setCardEnabled", "(Z)V", "isCardEnabledFromParent", "setCardEnabledFromParent", "isCashEnabled", "setCashEnabled", "isCashEnabledFromParent", "setCashEnabledFromParent", "isPaymentMethodAvailable", "setPaymentMethodAvailable", "isWalletEnabled", "setWalletEnabled", "loadingCardStatus", "getLoadingCardStatus", "setLoadingCardStatus", "selectedCard", "Lcom/talabat/talabatcommon/model/wallet/WalletCardDisplayModel;", "getSelectedCard", "setSelectedCard", "walletCardList", "Lcom/talabat/talabatcommon/model/wallet/WalletCardListDisplayModel;", "getWalletCardList", "()Lcom/talabat/talabatcommon/model/wallet/WalletCardListDisplayModel;", "setWalletCardList", "(Lcom/talabat/talabatcommon/model/wallet/WalletCardListDisplayModel;)V", "walletCardListData", "getWalletCardListData", "setWalletCardListData", "walletPaymentWidgetConfigData", "Lcom/talabat/talabatcommon/views/wallet/walletPaymentWidgetConfig/model/WalletPaymentWidgetConfigDisplayModel;", "getWalletPaymentWidgetConfigData", "setWalletPaymentWidgetConfigData", "getCardList", "", "paymentProvider", "", "country", "getDebitCardsDeflectionInfo", "cardsList", "", "getWalletPaymentWidgetConfig", "componentId", "featureId", "setDefaultCard", "walletCardListDisplayModel", "updateChangeCard", "com_talabat_NewArchi_TalabatCommon_TalabatCommon"}, k = 1, mv = {1, 6, 0}, xi = 48)
public abstract class CardViewWidgetsViewModel extends BaseViewModel {
    @NotNull
    private MutableLiveData<Boolean> cardChangedData = new MutableLiveData<>();
    @NotNull
    private MutableLiveData<DeflectionInfoDisplayModel> deflectionInfoDisplayModelData = new MutableLiveData<>();
    private boolean isCardEnabled;
    private boolean isCashEnabled;
    @NotNull
    private MutableLiveData<Boolean> isPaymentMethodAvailable = new MutableLiveData<>();
    private boolean isWalletEnabled = true;
    @NotNull
    private MutableLiveData<Boolean> loadingCardStatus = new MutableLiveData<>();
    @NotNull
    private MutableLiveData<WalletCardDisplayModel> selectedCard = new MutableLiveData<>();
    @NotNull
    private WalletCardListDisplayModel walletCardList = new WalletCardListDisplayModel((List) null, false, 0, 7, (DefaultConstructorMarker) null);
    @NotNull
    private MutableLiveData<WalletCardListDisplayModel> walletCardListData = new MutableLiveData<>();
    @NotNull
    private MutableLiveData<WalletPaymentWidgetConfigDisplayModel> walletPaymentWidgetConfigData = new MutableLiveData<>();

    public static /* synthetic */ void getCardList$default(CardViewWidgetsViewModel cardViewWidgetsViewModel, int i11, int i12, int i13, Object obj) {
        if (obj == null) {
            if ((i13 & 1) != 0) {
                i11 = PaymentProviderHelper.Companion.getPaymentProvider(IntegrationGlobalDataModel.Companion.selectedCountryCode());
            }
            if ((i13 & 2) != 0) {
                i12 = IntegrationGlobalDataModel.Companion.selectedCountryCode();
            }
            cardViewWidgetsViewModel.getCardList(i11, i12);
            return;
        }
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: getCardList");
    }

    public static /* synthetic */ void getWalletPaymentWidgetConfig$default(CardViewWidgetsViewModel cardViewWidgetsViewModel, int i11, int i12, int i13, int i14, Object obj) {
        if (obj == null) {
            if ((i14 & 1) != 0) {
                i11 = IntegrationGlobalDataModel.Companion.selectedCountryCode();
            }
            cardViewWidgetsViewModel.getWalletPaymentWidgetConfig(i11, i12, i13);
            return;
        }
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: getWalletPaymentWidgetConfig");
    }

    @NotNull
    public final MutableLiveData<Boolean> getCardChangedData() {
        return this.cardChangedData;
    }

    public abstract void getCardList(int i11, int i12);

    public abstract void getDebitCardsDeflectionInfo(@NotNull List<WalletCardDisplayModel> list);

    @NotNull
    public final MutableLiveData<DeflectionInfoDisplayModel> getDeflectionInfoDisplayModelData() {
        return this.deflectionInfoDisplayModelData;
    }

    @NotNull
    public final MutableLiveData<Boolean> getLoadingCardStatus() {
        return this.loadingCardStatus;
    }

    @NotNull
    public final MutableLiveData<WalletCardDisplayModel> getSelectedCard() {
        return this.selectedCard;
    }

    @NotNull
    public final WalletCardListDisplayModel getWalletCardList() {
        return this.walletCardList;
    }

    @NotNull
    public final MutableLiveData<WalletCardListDisplayModel> getWalletCardListData() {
        return this.walletCardListData;
    }

    public abstract void getWalletPaymentWidgetConfig(int i11, int i12, int i13);

    @NotNull
    public final MutableLiveData<WalletPaymentWidgetConfigDisplayModel> getWalletPaymentWidgetConfigData() {
        return this.walletPaymentWidgetConfigData;
    }

    public final boolean isCardEnabled() {
        return this.isCardEnabled;
    }

    public abstract boolean isCardEnabledFromParent();

    public final boolean isCashEnabled() {
        return this.isCashEnabled;
    }

    public abstract boolean isCashEnabledFromParent();

    @NotNull
    public final MutableLiveData<Boolean> isPaymentMethodAvailable() {
        return this.isPaymentMethodAvailable;
    }

    public final boolean isWalletEnabled() {
        return this.isWalletEnabled;
    }

    public final void setCardChangedData(@NotNull MutableLiveData<Boolean> mutableLiveData) {
        Intrinsics.checkNotNullParameter(mutableLiveData, "<set-?>");
        this.cardChangedData = mutableLiveData;
    }

    public final void setCardEnabled(boolean z11) {
        this.isCardEnabled = z11;
    }

    public abstract void setCardEnabledFromParent(boolean z11);

    public final void setCashEnabled(boolean z11) {
        this.isCashEnabled = z11;
    }

    public abstract void setCashEnabledFromParent(boolean z11);

    public abstract void setDefaultCard(@NotNull WalletCardListDisplayModel walletCardListDisplayModel);

    public final void setDeflectionInfoDisplayModelData(@NotNull MutableLiveData<DeflectionInfoDisplayModel> mutableLiveData) {
        Intrinsics.checkNotNullParameter(mutableLiveData, "<set-?>");
        this.deflectionInfoDisplayModelData = mutableLiveData;
    }

    public final void setLoadingCardStatus(@NotNull MutableLiveData<Boolean> mutableLiveData) {
        Intrinsics.checkNotNullParameter(mutableLiveData, "<set-?>");
        this.loadingCardStatus = mutableLiveData;
    }

    public final void setPaymentMethodAvailable(@NotNull MutableLiveData<Boolean> mutableLiveData) {
        Intrinsics.checkNotNullParameter(mutableLiveData, "<set-?>");
        this.isPaymentMethodAvailable = mutableLiveData;
    }

    public final void setSelectedCard(@NotNull MutableLiveData<WalletCardDisplayModel> mutableLiveData) {
        Intrinsics.checkNotNullParameter(mutableLiveData, "<set-?>");
        this.selectedCard = mutableLiveData;
    }

    public final void setWalletCardList(@NotNull WalletCardListDisplayModel walletCardListDisplayModel) {
        Intrinsics.checkNotNullParameter(walletCardListDisplayModel, "<set-?>");
        this.walletCardList = walletCardListDisplayModel;
    }

    public final void setWalletCardListData(@NotNull MutableLiveData<WalletCardListDisplayModel> mutableLiveData) {
        Intrinsics.checkNotNullParameter(mutableLiveData, "<set-?>");
        this.walletCardListData = mutableLiveData;
    }

    public final void setWalletEnabled(boolean z11) {
        this.isWalletEnabled = z11;
    }

    public final void setWalletPaymentWidgetConfigData(@NotNull MutableLiveData<WalletPaymentWidgetConfigDisplayModel> mutableLiveData) {
        Intrinsics.checkNotNullParameter(mutableLiveData, "<set-?>");
        this.walletPaymentWidgetConfigData = mutableLiveData;
    }

    public abstract void updateChangeCard();
}
