package com.talabat.wallet.ui.walletDashboard.viewModel;

import androidx.lifecycle.MutableLiveData;
import com.talabat.talabatcommon.model.wallet.WalletBalanceDisplayModel;
import com.talabat.talabatcommon.model.wallet.WalletBannerDisplayModel;
import com.talabat.talabatcore.viewmodel.BaseViewModel;
import com.talabat.wallet.ui.transactionslistheader.TransactionsListHeaderDisplayModel;
import com.talabat.wallet.ui.walletDashboard.model.WalletDashBoardIconsDisplayModel;
import com.talabat.wallet.ui.walletDashboard.model.WalletOnboardingDisplayModel;
import com.talabat.wallet.ui.walletDashboard.model.WalletShowNextScreenDisplayModel;
import com.talabat.wallet.ui.walletDashboard.model.WalletTransactionDetailsDisplayModel;
import com.talabat.wallet.ui.walletDashboard.model.WalletTransactionEmptyListDisplayModel;
import com.talabat.wallet.ui.walletDashboard.model.WalletTransactionListDataItemDisplayModel;
import com.talabat.wallet.ui.walletDashboard.model.WalletTransactionListDisplayModel;
import java.util.HashMap;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0010\u0007\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0014\b&\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0018\u0010D\u001a\u00020E2\u0006\u0010F\u001a\u00020G2\u0006\u0010H\u001a\u00020\rH&J\u0018\u0010I\u001a\u00020E2\u0006\u0010F\u001a\u00020\u00052\u0006\u0010H\u001a\u00020\rH&J\u0018\u0010J\u001a\u00020E2\u0006\u0010K\u001a\u00020G2\u0006\u0010H\u001a\u00020\rH&J \u0010L\u001a\u00020E2\u0006\u0010K\u001a\u00020G2\u0006\u0010M\u001a\u00020G2\u0006\u0010N\u001a\u00020GH&J\u0014\u0010O\u001a\u00020E2\n\b\u0002\u0010P\u001a\u0004\u0018\u00010\u0005H&J\b\u0010Q\u001a\u00020EH&J\b\u0010R\u001a\u00020EH&J\u0018\u0010S\u001a\u00020E2\u0006\u0010T\u001a\u00020G2\u0006\u0010U\u001a\u00020GH&J\b\u0010V\u001a\u00020EH&J\b\u0010W\u001a\u00020\rH&J\b\u0010X\u001a\u00020\rH&J\u0010\u0010Y\u001a\u00020E2\u0006\u0010H\u001a\u00020\rH&J\b\u0010Z\u001a\u00020EH&R4\u0010\u0003\u001a\u001e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00060\u0004j\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u0006`\u0007X¦\u000e¢\u0006\f\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bR\u0018\u0010\f\u001a\u00020\rX¦\u000e¢\u0006\f\u001a\u0004\b\f\u0010\u000e\"\u0004\b\u000f\u0010\u0010R\u0018\u0010\u0011\u001a\u00020\u0012X¦\u000e¢\u0006\f\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016R \u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00190\u0018X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001a\u0010\u001b\"\u0004\b\u001c\u0010\u001dR\u0017\u0010\u001e\u001a\b\u0012\u0004\u0012\u00020\r0\u0018¢\u0006\b\n\u0000\u001a\u0004\b\u001f\u0010\u001bR\u0018\u0010 \u001a\u00020\rX¦\u000e¢\u0006\f\u001a\u0004\b!\u0010\u000e\"\u0004\b\"\u0010\u0010R\u0017\u0010#\u001a\b\u0012\u0004\u0012\u00020$0\u0018¢\u0006\b\n\u0000\u001a\u0004\b%\u0010\u001bR \u0010&\u001a\b\u0012\u0004\u0012\u00020'0\u0018X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b(\u0010\u001b\"\u0004\b)\u0010\u001dR \u0010*\u001a\b\u0012\u0004\u0012\u00020\r0\u0018X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b+\u0010\u001b\"\u0004\b,\u0010\u001dR \u0010-\u001a\b\u0012\u0004\u0012\u00020.0\u0018X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b/\u0010\u001b\"\u0004\b0\u0010\u001dR \u00101\u001a\b\u0012\u0004\u0012\u0002020\u0018X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b3\u0010\u001b\"\u0004\b4\u0010\u001dR \u00105\u001a\b\u0012\u0004\u0012\u0002060\u0018X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b7\u0010\u001b\"\u0004\b8\u0010\u001dR\u0017\u00109\u001a\b\u0012\u0004\u0012\u00020:0\u0018¢\u0006\b\n\u0000\u001a\u0004\b;\u0010\u001bR \u0010<\u001a\b\u0012\u0004\u0012\u00020=0\u0018X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b>\u0010\u001b\"\u0004\b?\u0010\u001dR \u0010@\u001a\b\u0012\u0004\u0012\u00020A0\u0018X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bB\u0010\u001b\"\u0004\bC\u0010\u001d¨\u0006["}, d2 = {"Lcom/talabat/wallet/ui/walletDashboard/viewModel/WalletDashboardViewModel;", "Lcom/talabat/talabatcore/viewmodel/BaseViewModel;", "()V", "amountSpentPerMonthMap", "Ljava/util/HashMap;", "", "", "Lkotlin/collections/HashMap;", "getAmountSpentPerMonthMap", "()Ljava/util/HashMap;", "setAmountSpentPerMonthMap", "(Ljava/util/HashMap;)V", "isFirstResponse", "", "()Z", "setFirstResponse", "(Z)V", "lastDisplayModel", "Lcom/talabat/wallet/ui/walletDashboard/model/WalletTransactionListDataItemDisplayModel$TransactionDisplayModel;", "getLastDisplayModel", "()Lcom/talabat/wallet/ui/walletDashboard/model/WalletTransactionListDataItemDisplayModel$TransactionDisplayModel;", "setLastDisplayModel", "(Lcom/talabat/wallet/ui/walletDashboard/model/WalletTransactionListDataItemDisplayModel$TransactionDisplayModel;)V", "shouldShowOnBoardingData", "Landroidx/lifecycle/MutableLiveData;", "Lcom/talabat/wallet/ui/walletDashboard/model/WalletOnboardingDisplayModel;", "getShouldShowOnBoardingData", "()Landroidx/lifecycle/MutableLiveData;", "setShouldShowOnBoardingData", "(Landroidx/lifecycle/MutableLiveData;)V", "shouldShowOnBoardingInfoData", "getShouldShowOnBoardingInfoData", "shouldShowTopUpMessage", "getShouldShowTopUpMessage", "setShouldShowTopUpMessage", "shouldShowTransactionDetailsData", "Lcom/talabat/wallet/ui/walletDashboard/model/WalletTransactionDetailsDisplayModel;", "getShouldShowTransactionDetailsData", "transactionsListHeaderDisplayModelData", "Lcom/talabat/wallet/ui/transactionslistheader/TransactionsListHeaderDisplayModel;", "getTransactionsListHeaderDisplayModelData", "setTransactionsListHeaderDisplayModelData", "userNotLoggedInData", "getUserNotLoggedInData", "setUserNotLoggedInData", "walletBalanceDisplayModelData", "Lcom/talabat/talabatcommon/model/wallet/WalletBalanceDisplayModel;", "getWalletBalanceDisplayModelData", "setWalletBalanceDisplayModelData", "walletBannerDisplayModelData", "Lcom/talabat/talabatcommon/model/wallet/WalletBannerDisplayModel;", "getWalletBannerDisplayModelData", "setWalletBannerDisplayModelData", "walletDashboardIconsData", "Lcom/talabat/wallet/ui/walletDashboard/model/WalletDashBoardIconsDisplayModel;", "getWalletDashboardIconsData", "setWalletDashboardIconsData", "walletShowNextScreenData", "Lcom/talabat/wallet/ui/walletDashboard/model/WalletShowNextScreenDisplayModel;", "getWalletShowNextScreenData", "walletTransactionEmptyListDisplayModelData", "Lcom/talabat/wallet/ui/walletDashboard/model/WalletTransactionEmptyListDisplayModel;", "getWalletTransactionEmptyListDisplayModelData", "setWalletTransactionEmptyListDisplayModelData", "walletTransactionListDisplayModelData", "Lcom/talabat/wallet/ui/walletDashboard/model/WalletTransactionListDisplayModel;", "getWalletTransactionListDisplayModelData", "setWalletTransactionListDisplayModelData", "getTransactionsListHeader", "", "country", "", "isLoggedIn", "getWalletBalance", "getWalletBanner", "countryId", "getWalletTransactionList", "take", "skip", "onCobrandedCCBannerClicked", "deeplink", "onOnBoardingShown", "onShowCreditInformationButtonClicked", "onTransactionDetailsClicked", "transactionId", "transactionTypeId", "shouldShowCreditInformationButton", "shouldShowFlutterCardsManagementScreen", "shouldShowFlutterTopUpScreen", "shouldShowOnboarding", "showDashBoardIcons", "com_talabat_NewArchi_WalletSquad_WalletSquad"}, k = 1, mv = {1, 6, 0}, xi = 48)
public abstract class WalletDashboardViewModel extends BaseViewModel {
    @NotNull
    private MutableLiveData<WalletOnboardingDisplayModel> shouldShowOnBoardingData = new MutableLiveData<>();
    @NotNull
    private final MutableLiveData<Boolean> shouldShowOnBoardingInfoData = new MutableLiveData<>();
    @NotNull
    private final MutableLiveData<WalletTransactionDetailsDisplayModel> shouldShowTransactionDetailsData = new MutableLiveData<>();
    @NotNull
    private MutableLiveData<TransactionsListHeaderDisplayModel> transactionsListHeaderDisplayModelData = new MutableLiveData<>();
    @NotNull
    private MutableLiveData<Boolean> userNotLoggedInData = new MutableLiveData<>();
    @NotNull
    private MutableLiveData<WalletBalanceDisplayModel> walletBalanceDisplayModelData = new MutableLiveData<>();
    @NotNull
    private MutableLiveData<WalletBannerDisplayModel> walletBannerDisplayModelData = new MutableLiveData<>();
    @NotNull
    private MutableLiveData<WalletDashBoardIconsDisplayModel> walletDashboardIconsData = new MutableLiveData<>();
    @NotNull
    private final MutableLiveData<WalletShowNextScreenDisplayModel> walletShowNextScreenData = new MutableLiveData<>();
    @NotNull
    private MutableLiveData<WalletTransactionEmptyListDisplayModel> walletTransactionEmptyListDisplayModelData = new MutableLiveData<>();
    @NotNull
    private MutableLiveData<WalletTransactionListDisplayModel> walletTransactionListDisplayModelData = new MutableLiveData<>();

    public static /* synthetic */ void onCobrandedCCBannerClicked$default(WalletDashboardViewModel walletDashboardViewModel, String str, int i11, Object obj) {
        if (obj == null) {
            if ((i11 & 1) != 0) {
                str = null;
            }
            walletDashboardViewModel.onCobrandedCCBannerClicked(str);
            return;
        }
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: onCobrandedCCBannerClicked");
    }

    @NotNull
    public abstract HashMap<String, Float> getAmountSpentPerMonthMap();

    @NotNull
    public abstract WalletTransactionListDataItemDisplayModel.TransactionDisplayModel getLastDisplayModel();

    @NotNull
    public final MutableLiveData<WalletOnboardingDisplayModel> getShouldShowOnBoardingData() {
        return this.shouldShowOnBoardingData;
    }

    @NotNull
    public final MutableLiveData<Boolean> getShouldShowOnBoardingInfoData() {
        return this.shouldShowOnBoardingInfoData;
    }

    public abstract boolean getShouldShowTopUpMessage();

    @NotNull
    public final MutableLiveData<WalletTransactionDetailsDisplayModel> getShouldShowTransactionDetailsData() {
        return this.shouldShowTransactionDetailsData;
    }

    public abstract void getTransactionsListHeader(int i11, boolean z11);

    @NotNull
    public final MutableLiveData<TransactionsListHeaderDisplayModel> getTransactionsListHeaderDisplayModelData() {
        return this.transactionsListHeaderDisplayModelData;
    }

    @NotNull
    public final MutableLiveData<Boolean> getUserNotLoggedInData() {
        return this.userNotLoggedInData;
    }

    public abstract void getWalletBalance(@NotNull String str, boolean z11);

    @NotNull
    public final MutableLiveData<WalletBalanceDisplayModel> getWalletBalanceDisplayModelData() {
        return this.walletBalanceDisplayModelData;
    }

    public abstract void getWalletBanner(int i11, boolean z11);

    @NotNull
    public final MutableLiveData<WalletBannerDisplayModel> getWalletBannerDisplayModelData() {
        return this.walletBannerDisplayModelData;
    }

    @NotNull
    public final MutableLiveData<WalletDashBoardIconsDisplayModel> getWalletDashboardIconsData() {
        return this.walletDashboardIconsData;
    }

    @NotNull
    public final MutableLiveData<WalletShowNextScreenDisplayModel> getWalletShowNextScreenData() {
        return this.walletShowNextScreenData;
    }

    @NotNull
    public final MutableLiveData<WalletTransactionEmptyListDisplayModel> getWalletTransactionEmptyListDisplayModelData() {
        return this.walletTransactionEmptyListDisplayModelData;
    }

    public abstract void getWalletTransactionList(int i11, int i12, int i13);

    @NotNull
    public final MutableLiveData<WalletTransactionListDisplayModel> getWalletTransactionListDisplayModelData() {
        return this.walletTransactionListDisplayModelData;
    }

    public abstract boolean isFirstResponse();

    public abstract void onCobrandedCCBannerClicked(@Nullable String str);

    public abstract void onOnBoardingShown();

    public abstract void onShowCreditInformationButtonClicked();

    public abstract void onTransactionDetailsClicked(int i11, int i12);

    public abstract void setAmountSpentPerMonthMap(@NotNull HashMap<String, Float> hashMap);

    public abstract void setFirstResponse(boolean z11);

    public abstract void setLastDisplayModel(@NotNull WalletTransactionListDataItemDisplayModel.TransactionDisplayModel transactionDisplayModel);

    public final void setShouldShowOnBoardingData(@NotNull MutableLiveData<WalletOnboardingDisplayModel> mutableLiveData) {
        Intrinsics.checkNotNullParameter(mutableLiveData, "<set-?>");
        this.shouldShowOnBoardingData = mutableLiveData;
    }

    public abstract void setShouldShowTopUpMessage(boolean z11);

    public final void setTransactionsListHeaderDisplayModelData(@NotNull MutableLiveData<TransactionsListHeaderDisplayModel> mutableLiveData) {
        Intrinsics.checkNotNullParameter(mutableLiveData, "<set-?>");
        this.transactionsListHeaderDisplayModelData = mutableLiveData;
    }

    public final void setUserNotLoggedInData(@NotNull MutableLiveData<Boolean> mutableLiveData) {
        Intrinsics.checkNotNullParameter(mutableLiveData, "<set-?>");
        this.userNotLoggedInData = mutableLiveData;
    }

    public final void setWalletBalanceDisplayModelData(@NotNull MutableLiveData<WalletBalanceDisplayModel> mutableLiveData) {
        Intrinsics.checkNotNullParameter(mutableLiveData, "<set-?>");
        this.walletBalanceDisplayModelData = mutableLiveData;
    }

    public final void setWalletBannerDisplayModelData(@NotNull MutableLiveData<WalletBannerDisplayModel> mutableLiveData) {
        Intrinsics.checkNotNullParameter(mutableLiveData, "<set-?>");
        this.walletBannerDisplayModelData = mutableLiveData;
    }

    public final void setWalletDashboardIconsData(@NotNull MutableLiveData<WalletDashBoardIconsDisplayModel> mutableLiveData) {
        Intrinsics.checkNotNullParameter(mutableLiveData, "<set-?>");
        this.walletDashboardIconsData = mutableLiveData;
    }

    public final void setWalletTransactionEmptyListDisplayModelData(@NotNull MutableLiveData<WalletTransactionEmptyListDisplayModel> mutableLiveData) {
        Intrinsics.checkNotNullParameter(mutableLiveData, "<set-?>");
        this.walletTransactionEmptyListDisplayModelData = mutableLiveData;
    }

    public final void setWalletTransactionListDisplayModelData(@NotNull MutableLiveData<WalletTransactionListDisplayModel> mutableLiveData) {
        Intrinsics.checkNotNullParameter(mutableLiveData, "<set-?>");
        this.walletTransactionListDisplayModelData = mutableLiveData;
    }

    public abstract void shouldShowCreditInformationButton();

    public abstract boolean shouldShowFlutterCardsManagementScreen();

    public abstract boolean shouldShowFlutterTopUpScreen();

    public abstract void shouldShowOnboarding(boolean z11);

    public abstract void showDashBoardIcons();
}
