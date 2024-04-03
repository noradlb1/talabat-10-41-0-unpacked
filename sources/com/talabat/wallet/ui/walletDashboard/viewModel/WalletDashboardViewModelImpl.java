package com.talabat.wallet.ui.walletDashboard.viewModel;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModelKt;
import com.talabat.core.navigation.domain.screen.Screen;
import com.talabat.core.observabilityNew.domain.IObservabilityManager;
import com.talabat.talabatcommon.feature.walletBalance.GetWalletBalanceUseCase;
import com.talabat.talabatcommon.feature.walletBanner.GetWalletBannerUseCase;
import com.talabat.talabatcommon.model.wallet.WalletBalanceDisplayModel;
import com.talabat.talabatcommon.model.wallet.WalletBannerDisplayModel;
import com.talabat.talabatcore.exception.Failure;
import com.talabat.wallet.features.cobrandedcc.CobrandedCCBannerTracker;
import com.talabat.wallet.features.cobrandedcc.CobrandedDynamicBannerConstants;
import com.talabat.wallet.features.cobrandedcc.GetWalletDashboardCobrandedCCEnabledUseCase;
import com.talabat.wallet.features.expiringCard.GetExpiringCardDetailUseCase;
import com.talabat.wallet.features.walletTransactionList.GetFormattedWalletTransactionListUseCase;
import com.talabat.wallet.features.walletTransactionList.GetShouldShowWalletTransactionDetailsInFlutterUseCase;
import com.talabat.wallet.features.walletTransactionList.GetWalletDashboardFlagEnabledUseCase;
import com.talabat.wallet.features.walletTransactionList.GetWalletDashboardMoreButtonEnabledUseCase;
import com.talabat.wallet.features.walletTransactionList.GetWalletTransactionListUseCase;
import com.talabat.wallet.features.walletTransactionList.IsFlutterCardsManagementScreenEnabledUseCase;
import com.talabat.wallet.features.walletTransactionList.IsFlutterTopUpScreenEnabledUseCase;
import com.talabat.wallet.features.walletTransactionList.WalletTransactionListFormatterParam;
import com.talabat.wallet.features.walletTransactionList.WalletTransactionListParam;
import com.talabat.wallet.features.walletTransactionList.model.response.WalletTransactionListResponse;
import com.talabat.wallet.features.walletonboarding.GetWalletDashboardOnboardingEnabledUseCase;
import com.talabat.wallet.features.walletonboarding.repository.GetWasWalletOnboardingShownUseCase;
import com.talabat.wallet.features.walletonboarding.repository.UpdateWasWalletOnboardingShownUseCase;
import com.talabat.wallet.ui.expiringCard.model.ExpiringCardDetailDisplayModel;
import com.talabat.wallet.ui.walletDashboard.model.MonthlySpentDisplayModel;
import com.talabat.wallet.ui.walletDashboard.model.NavigationType;
import com.talabat.wallet.ui.walletDashboard.model.NextScreenCobrandedCreditCardFlutter;
import com.talabat.wallet.ui.walletDashboard.model.NextScreenDeeplinkFlutter;
import com.talabat.wallet.ui.walletDashboard.model.NextScreenType;
import com.talabat.wallet.ui.walletDashboard.model.OnboardingType;
import com.talabat.wallet.ui.walletDashboard.model.WalletOnboardingDisplayModel;
import com.talabat.wallet.ui.walletDashboard.model.WalletShowNextScreenDisplayModel;
import com.talabat.wallet.ui.walletDashboard.model.WalletTransactionListDataItemDisplayModel;
import com.talabat.wallet.ui.walletDashboard.model.WalletTransactionListDisplayModel;
import com.talabat.wallet.walletbalance.data.local.WalletBalanceLocalSource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.Job;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000Ö\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0010\u0007\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0001\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\u000b\u0012\u0006\u0010\f\u001a\u00020\r\u0012\u0006\u0010\u000e\u001a\u00020\u000f\u0012\u0006\u0010\u0010\u001a\u00020\u0011\u0012\u0006\u0010\u0012\u001a\u00020\u0013\u0012\u0006\u0010\u0014\u001a\u00020\u0015\u0012\u0006\u0010\u0016\u001a\u00020\u0017\u0012\u0006\u0010\u0018\u001a\u00020\u0019\u0012\u0006\u0010\u001a\u001a\u00020\u001b\u0012\u0006\u0010\u001c\u001a\u00020\u001d\u0012\u0006\u0010\u001e\u001a\u00020\u001f\u0012\u0006\u0010 \u001a\u00020!\u0012\u0006\u0010\"\u001a\u00020#¢\u0006\u0002\u0010$J\u0018\u0010<\u001a\u00020=2\u0006\u0010>\u001a\u00020?2\u0006\u0010@\u001a\u00020/H\u0016J\u0018\u0010A\u001a\u00020=2\u0006\u0010>\u001a\u00020'2\u0006\u0010@\u001a\u00020/H\u0016J\u0018\u0010B\u001a\u00020=2\u0006\u0010C\u001a\u00020?2\u0006\u0010@\u001a\u00020/H\u0016J \u0010D\u001a\u00020=2\u0006\u0010C\u001a\u00020?2\u0006\u0010E\u001a\u00020?2\u0006\u0010F\u001a\u00020?H\u0016J\u0010\u0010G\u001a\u00020=2\u0006\u0010H\u001a\u00020IH\u0002J\u0010\u0010J\u001a\u00020=2\u0006\u0010K\u001a\u00020LH\u0002J\u0010\u0010M\u001a\u00020=2\u0006\u0010N\u001a\u00020OH\u0002J\u0010\u0010P\u001a\u00020=2\u0006\u0010Q\u001a\u00020RH\u0002J\b\u0010S\u001a\u00020/H\u0002J\u0012\u0010T\u001a\u00020=2\b\u0010U\u001a\u0004\u0018\u00010'H\u0016J\b\u0010V\u001a\u00020=H\u0016J\b\u0010W\u001a\u00020=H\u0016J\u0018\u0010X\u001a\u00020=2\u0006\u0010Y\u001a\u00020?2\u0006\u0010Z\u001a\u00020?H\u0016J\u0016\u0010[\u001a\u00020=2\f\u0010\\\u001a\b\u0012\u0004\u0012\u00020^0]H\u0002J\b\u0010_\u001a\u00020=H\u0016J\b\u0010`\u001a\u00020/H\u0016J\b\u0010a\u001a\u00020/H\u0016J\u0010\u0010b\u001a\u00020=2\u0006\u0010@\u001a\u00020/H\u0016J\b\u0010c\u001a\u00020=H\u0016J\b\u0010d\u001a\u00020=H\u0002J\u0010\u0010e\u001a\u00020=2\u0006\u0010f\u001a\u00020gH\u0002R6\u0010%\u001a\u001e\u0012\u0004\u0012\u00020'\u0012\u0004\u0012\u00020(0&j\u000e\u0012\u0004\u0012\u00020'\u0012\u0004\u0012\u00020(`)X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b*\u0010+\"\u0004\b,\u0010-R\u000e\u0010\u001c\u001a\u00020\u001dX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0018\u001a\u00020\u0019X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u001a\u001a\u00020\u001bX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0011X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u0017X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0013X\u0004¢\u0006\u0002\n\u0000R\u001a\u0010.\u001a\u00020/X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b.\u00100\"\u0004\b1\u00102R\u000e\u0010 \u001a\u00020!X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u001e\u001a\u00020\u001fX\u0004¢\u0006\u0002\n\u0000R\u001a\u00103\u001a\u000204X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b5\u00106\"\u0004\b7\u00108R\u000e\u0010\"\u001a\u00020#X\u0004¢\u0006\u0002\n\u0000R\u001a\u00109\u001a\u00020/X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b:\u00100\"\u0004\b;\u00102R\u000e\u0010\u0014\u001a\u00020\u0015X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0004¢\u0006\u0002\n\u0000¨\u0006h"}, d2 = {"Lcom/talabat/wallet/ui/walletDashboard/viewModel/WalletDashboardViewModelImpl;", "Lcom/talabat/wallet/ui/walletDashboard/viewModel/WalletDashboardViewModel;", "getWalletBalanceUseCase", "Lcom/talabat/talabatcommon/feature/walletBalance/GetWalletBalanceUseCase;", "getWalletExpiringCreditUseCase", "Lcom/talabat/wallet/features/expiringCard/GetExpiringCardDetailUseCase;", "getWalletTransactionListUseCase", "Lcom/talabat/wallet/features/walletTransactionList/GetWalletTransactionListUseCase;", "getFormattedWalletTransactionListUseCase", "Lcom/talabat/wallet/features/walletTransactionList/GetFormattedWalletTransactionListUseCase;", "getWalletDashboardFlagEnabledUseCase", "Lcom/talabat/wallet/features/walletTransactionList/GetWalletDashboardFlagEnabledUseCase;", "walletBalanceLocalSource", "Lcom/talabat/wallet/walletbalance/data/local/WalletBalanceLocalSource;", "getWalletDashboardOnboardingEnabledUseCase", "Lcom/talabat/wallet/features/walletonboarding/GetWalletDashboardOnboardingEnabledUseCase;", "getWalletDashboardCobrandedCCEnabledUseCase", "Lcom/talabat/wallet/features/cobrandedcc/GetWalletDashboardCobrandedCCEnabledUseCase;", "getWasWalletOnboardingShownUseCase", "Lcom/talabat/wallet/features/walletonboarding/repository/GetWasWalletOnboardingShownUseCase;", "updateWasWalletOnboardingShownUseCase", "Lcom/talabat/wallet/features/walletonboarding/repository/UpdateWasWalletOnboardingShownUseCase;", "getWalletDashboardMoreButtonEnabledUseCase", "Lcom/talabat/wallet/features/walletTransactionList/GetWalletDashboardMoreButtonEnabledUseCase;", "getShouldShowWalletTransactionDetailsInFlutterUseCase", "Lcom/talabat/wallet/features/walletTransactionList/GetShouldShowWalletTransactionDetailsInFlutterUseCase;", "getWalletBannerUseCase", "Lcom/talabat/talabatcommon/feature/walletBanner/GetWalletBannerUseCase;", "cobrandedCCBannerTracker", "Lcom/talabat/wallet/features/cobrandedcc/CobrandedCCBannerTracker;", "isFlutterTopUpScreenEnabledUseCase", "Lcom/talabat/wallet/features/walletTransactionList/IsFlutterTopUpScreenEnabledUseCase;", "isFlutterCardsManagementScreenEnabledUseCase", "Lcom/talabat/wallet/features/walletTransactionList/IsFlutterCardsManagementScreenEnabledUseCase;", "observabilityManager", "Lcom/talabat/core/observabilityNew/domain/IObservabilityManager;", "(Lcom/talabat/talabatcommon/feature/walletBalance/GetWalletBalanceUseCase;Lcom/talabat/wallet/features/expiringCard/GetExpiringCardDetailUseCase;Lcom/talabat/wallet/features/walletTransactionList/GetWalletTransactionListUseCase;Lcom/talabat/wallet/features/walletTransactionList/GetFormattedWalletTransactionListUseCase;Lcom/talabat/wallet/features/walletTransactionList/GetWalletDashboardFlagEnabledUseCase;Lcom/talabat/wallet/walletbalance/data/local/WalletBalanceLocalSource;Lcom/talabat/wallet/features/walletonboarding/GetWalletDashboardOnboardingEnabledUseCase;Lcom/talabat/wallet/features/cobrandedcc/GetWalletDashboardCobrandedCCEnabledUseCase;Lcom/talabat/wallet/features/walletonboarding/repository/GetWasWalletOnboardingShownUseCase;Lcom/talabat/wallet/features/walletonboarding/repository/UpdateWasWalletOnboardingShownUseCase;Lcom/talabat/wallet/features/walletTransactionList/GetWalletDashboardMoreButtonEnabledUseCase;Lcom/talabat/wallet/features/walletTransactionList/GetShouldShowWalletTransactionDetailsInFlutterUseCase;Lcom/talabat/talabatcommon/feature/walletBanner/GetWalletBannerUseCase;Lcom/talabat/wallet/features/cobrandedcc/CobrandedCCBannerTracker;Lcom/talabat/wallet/features/walletTransactionList/IsFlutterTopUpScreenEnabledUseCase;Lcom/talabat/wallet/features/walletTransactionList/IsFlutterCardsManagementScreenEnabledUseCase;Lcom/talabat/core/observabilityNew/domain/IObservabilityManager;)V", "amountSpentPerMonthMap", "Ljava/util/HashMap;", "", "", "Lkotlin/collections/HashMap;", "getAmountSpentPerMonthMap", "()Ljava/util/HashMap;", "setAmountSpentPerMonthMap", "(Ljava/util/HashMap;)V", "isFirstResponse", "", "()Z", "setFirstResponse", "(Z)V", "lastDisplayModel", "Lcom/talabat/wallet/ui/walletDashboard/model/WalletTransactionListDataItemDisplayModel$TransactionDisplayModel;", "getLastDisplayModel", "()Lcom/talabat/wallet/ui/walletDashboard/model/WalletTransactionListDataItemDisplayModel$TransactionDisplayModel;", "setLastDisplayModel", "(Lcom/talabat/wallet/ui/walletDashboard/model/WalletTransactionListDataItemDisplayModel$TransactionDisplayModel;)V", "shouldShowTopUpMessage", "getShouldShowTopUpMessage", "setShouldShowTopUpMessage", "getTransactionsListHeader", "", "country", "", "isLoggedIn", "getWalletBalance", "getWalletBanner", "countryId", "getWalletTransactionList", "take", "skip", "handleExpiringCardSuccess", "expiringCardDetailDisplayModelParam", "Lcom/talabat/wallet/ui/expiringCard/model/ExpiringCardDetailDisplayModel;", "handleExpiringCreditFailure", "failure", "Lcom/talabat/talabatcore/exception/Failure;", "handleWalletBalanceServiceSuccess", "walletBalanceDisplayModel", "Lcom/talabat/talabatcommon/model/wallet/WalletBalanceDisplayModel;", "handleWalletTransactionListSuccess", "walletTransactionListResponse", "Lcom/talabat/wallet/features/walletTransactionList/model/response/WalletTransactionListResponse;", "isCobrandedApplicationPending", "onCobrandedCCBannerClicked", "deeplink", "onOnBoardingShown", "onShowCreditInformationButtonClicked", "onTransactionDetailsClicked", "transactionId", "transactionTypeId", "populateAmountSpentInMonthMap", "list", "", "Lcom/talabat/wallet/ui/walletDashboard/model/MonthlySpentDisplayModel;", "shouldShowCreditInformationButton", "shouldShowFlutterCardsManagementScreen", "shouldShowFlutterTopUpScreen", "shouldShowOnboarding", "showDashBoardIcons", "showDefaultHeader", "updateTransactionsList", "formattedResponse", "Lcom/talabat/wallet/ui/walletDashboard/model/WalletTransactionListDisplayModel;", "com_talabat_NewArchi_WalletSquad_WalletSquad"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class WalletDashboardViewModelImpl extends WalletDashboardViewModel {
    @NotNull
    private HashMap<String, Float> amountSpentPerMonthMap = new HashMap<>();
    /* access modifiers changed from: private */
    @NotNull
    public final CobrandedCCBannerTracker cobrandedCCBannerTracker;
    @NotNull
    private final GetFormattedWalletTransactionListUseCase getFormattedWalletTransactionListUseCase;
    /* access modifiers changed from: private */
    @NotNull
    public final GetShouldShowWalletTransactionDetailsInFlutterUseCase getShouldShowWalletTransactionDetailsInFlutterUseCase;
    @NotNull
    private final GetWalletBalanceUseCase getWalletBalanceUseCase;
    /* access modifiers changed from: private */
    @NotNull
    public final GetWalletBannerUseCase getWalletBannerUseCase;
    /* access modifiers changed from: private */
    @NotNull
    public final GetWalletDashboardCobrandedCCEnabledUseCase getWalletDashboardCobrandedCCEnabledUseCase;
    /* access modifiers changed from: private */
    @NotNull
    public final GetWalletDashboardFlagEnabledUseCase getWalletDashboardFlagEnabledUseCase;
    /* access modifiers changed from: private */
    @NotNull
    public final GetWalletDashboardMoreButtonEnabledUseCase getWalletDashboardMoreButtonEnabledUseCase;
    /* access modifiers changed from: private */
    @NotNull
    public final GetWalletDashboardOnboardingEnabledUseCase getWalletDashboardOnboardingEnabledUseCase;
    /* access modifiers changed from: private */
    @NotNull
    public final GetExpiringCardDetailUseCase getWalletExpiringCreditUseCase;
    @NotNull
    private final GetWalletTransactionListUseCase getWalletTransactionListUseCase;
    /* access modifiers changed from: private */
    @NotNull
    public final GetWasWalletOnboardingShownUseCase getWasWalletOnboardingShownUseCase;
    private boolean isFirstResponse = true;
    @NotNull
    private final IsFlutterCardsManagementScreenEnabledUseCase isFlutterCardsManagementScreenEnabledUseCase;
    @NotNull
    private final IsFlutterTopUpScreenEnabledUseCase isFlutterTopUpScreenEnabledUseCase;
    @NotNull
    private WalletTransactionListDataItemDisplayModel.TransactionDisplayModel lastDisplayModel = new WalletTransactionListDataItemDisplayModel.TransactionDisplayModel();
    /* access modifiers changed from: private */
    @NotNull
    public final IObservabilityManager observabilityManager;
    private boolean shouldShowTopUpMessage;
    /* access modifiers changed from: private */
    @NotNull
    public final UpdateWasWalletOnboardingShownUseCase updateWasWalletOnboardingShownUseCase;
    @NotNull
    private final WalletBalanceLocalSource walletBalanceLocalSource;

    public WalletDashboardViewModelImpl(@NotNull GetWalletBalanceUseCase getWalletBalanceUseCase2, @NotNull GetExpiringCardDetailUseCase getExpiringCardDetailUseCase, @NotNull GetWalletTransactionListUseCase getWalletTransactionListUseCase2, @NotNull GetFormattedWalletTransactionListUseCase getFormattedWalletTransactionListUseCase2, @NotNull GetWalletDashboardFlagEnabledUseCase getWalletDashboardFlagEnabledUseCase2, @NotNull WalletBalanceLocalSource walletBalanceLocalSource2, @NotNull GetWalletDashboardOnboardingEnabledUseCase getWalletDashboardOnboardingEnabledUseCase2, @NotNull GetWalletDashboardCobrandedCCEnabledUseCase getWalletDashboardCobrandedCCEnabledUseCase2, @NotNull GetWasWalletOnboardingShownUseCase getWasWalletOnboardingShownUseCase2, @NotNull UpdateWasWalletOnboardingShownUseCase updateWasWalletOnboardingShownUseCase2, @NotNull GetWalletDashboardMoreButtonEnabledUseCase getWalletDashboardMoreButtonEnabledUseCase2, @NotNull GetShouldShowWalletTransactionDetailsInFlutterUseCase getShouldShowWalletTransactionDetailsInFlutterUseCase2, @NotNull GetWalletBannerUseCase getWalletBannerUseCase2, @NotNull CobrandedCCBannerTracker cobrandedCCBannerTracker2, @NotNull IsFlutterTopUpScreenEnabledUseCase isFlutterTopUpScreenEnabledUseCase2, @NotNull IsFlutterCardsManagementScreenEnabledUseCase isFlutterCardsManagementScreenEnabledUseCase2, @NotNull IObservabilityManager iObservabilityManager) {
        GetWalletBalanceUseCase getWalletBalanceUseCase3 = getWalletBalanceUseCase2;
        GetExpiringCardDetailUseCase getExpiringCardDetailUseCase2 = getExpiringCardDetailUseCase;
        GetWalletTransactionListUseCase getWalletTransactionListUseCase3 = getWalletTransactionListUseCase2;
        GetFormattedWalletTransactionListUseCase getFormattedWalletTransactionListUseCase3 = getFormattedWalletTransactionListUseCase2;
        GetWalletDashboardFlagEnabledUseCase getWalletDashboardFlagEnabledUseCase3 = getWalletDashboardFlagEnabledUseCase2;
        WalletBalanceLocalSource walletBalanceLocalSource3 = walletBalanceLocalSource2;
        GetWalletDashboardOnboardingEnabledUseCase getWalletDashboardOnboardingEnabledUseCase3 = getWalletDashboardOnboardingEnabledUseCase2;
        GetWalletDashboardCobrandedCCEnabledUseCase getWalletDashboardCobrandedCCEnabledUseCase3 = getWalletDashboardCobrandedCCEnabledUseCase2;
        GetWasWalletOnboardingShownUseCase getWasWalletOnboardingShownUseCase3 = getWasWalletOnboardingShownUseCase2;
        UpdateWasWalletOnboardingShownUseCase updateWasWalletOnboardingShownUseCase3 = updateWasWalletOnboardingShownUseCase2;
        GetWalletDashboardMoreButtonEnabledUseCase getWalletDashboardMoreButtonEnabledUseCase3 = getWalletDashboardMoreButtonEnabledUseCase2;
        GetShouldShowWalletTransactionDetailsInFlutterUseCase getShouldShowWalletTransactionDetailsInFlutterUseCase3 = getShouldShowWalletTransactionDetailsInFlutterUseCase2;
        GetWalletBannerUseCase getWalletBannerUseCase3 = getWalletBannerUseCase2;
        CobrandedCCBannerTracker cobrandedCCBannerTracker3 = cobrandedCCBannerTracker2;
        IsFlutterCardsManagementScreenEnabledUseCase isFlutterCardsManagementScreenEnabledUseCase3 = isFlutterCardsManagementScreenEnabledUseCase2;
        Intrinsics.checkNotNullParameter(getWalletBalanceUseCase3, "getWalletBalanceUseCase");
        Intrinsics.checkNotNullParameter(getExpiringCardDetailUseCase2, "getWalletExpiringCreditUseCase");
        Intrinsics.checkNotNullParameter(getWalletTransactionListUseCase3, "getWalletTransactionListUseCase");
        Intrinsics.checkNotNullParameter(getFormattedWalletTransactionListUseCase3, "getFormattedWalletTransactionListUseCase");
        Intrinsics.checkNotNullParameter(getWalletDashboardFlagEnabledUseCase3, "getWalletDashboardFlagEnabledUseCase");
        Intrinsics.checkNotNullParameter(walletBalanceLocalSource3, "walletBalanceLocalSource");
        Intrinsics.checkNotNullParameter(getWalletDashboardOnboardingEnabledUseCase3, "getWalletDashboardOnboardingEnabledUseCase");
        Intrinsics.checkNotNullParameter(getWalletDashboardCobrandedCCEnabledUseCase3, "getWalletDashboardCobrandedCCEnabledUseCase");
        Intrinsics.checkNotNullParameter(getWasWalletOnboardingShownUseCase3, "getWasWalletOnboardingShownUseCase");
        Intrinsics.checkNotNullParameter(updateWasWalletOnboardingShownUseCase3, "updateWasWalletOnboardingShownUseCase");
        Intrinsics.checkNotNullParameter(getWalletDashboardMoreButtonEnabledUseCase3, "getWalletDashboardMoreButtonEnabledUseCase");
        Intrinsics.checkNotNullParameter(getShouldShowWalletTransactionDetailsInFlutterUseCase3, "getShouldShowWalletTransactionDetailsInFlutterUseCase");
        Intrinsics.checkNotNullParameter(getWalletBannerUseCase3, "getWalletBannerUseCase");
        Intrinsics.checkNotNullParameter(cobrandedCCBannerTracker3, "cobrandedCCBannerTracker");
        Intrinsics.checkNotNullParameter(isFlutterTopUpScreenEnabledUseCase2, "isFlutterTopUpScreenEnabledUseCase");
        Intrinsics.checkNotNullParameter(isFlutterCardsManagementScreenEnabledUseCase2, "isFlutterCardsManagementScreenEnabledUseCase");
        Intrinsics.checkNotNullParameter(iObservabilityManager, "observabilityManager");
        this.getWalletBalanceUseCase = getWalletBalanceUseCase3;
        this.getWalletExpiringCreditUseCase = getExpiringCardDetailUseCase2;
        this.getWalletTransactionListUseCase = getWalletTransactionListUseCase3;
        this.getFormattedWalletTransactionListUseCase = getFormattedWalletTransactionListUseCase3;
        this.getWalletDashboardFlagEnabledUseCase = getWalletDashboardFlagEnabledUseCase3;
        this.walletBalanceLocalSource = walletBalanceLocalSource3;
        this.getWalletDashboardOnboardingEnabledUseCase = getWalletDashboardOnboardingEnabledUseCase3;
        this.getWalletDashboardCobrandedCCEnabledUseCase = getWalletDashboardCobrandedCCEnabledUseCase3;
        this.getWasWalletOnboardingShownUseCase = getWasWalletOnboardingShownUseCase3;
        this.updateWasWalletOnboardingShownUseCase = updateWasWalletOnboardingShownUseCase3;
        this.getWalletDashboardMoreButtonEnabledUseCase = getWalletDashboardMoreButtonEnabledUseCase3;
        this.getShouldShowWalletTransactionDetailsInFlutterUseCase = getShouldShowWalletTransactionDetailsInFlutterUseCase3;
        this.getWalletBannerUseCase = getWalletBannerUseCase3;
        this.cobrandedCCBannerTracker = cobrandedCCBannerTracker3;
        this.isFlutterTopUpScreenEnabledUseCase = isFlutterTopUpScreenEnabledUseCase2;
        this.isFlutterCardsManagementScreenEnabledUseCase = isFlutterCardsManagementScreenEnabledUseCase2;
        this.observabilityManager = iObservabilityManager;
    }

    /* access modifiers changed from: private */
    public final void handleExpiringCardSuccess(ExpiringCardDetailDisplayModel expiringCardDetailDisplayModel) {
        Job unused = BuildersKt__Builders_commonKt.launch$default(ViewModelKt.getViewModelScope(this), (CoroutineContext) null, (CoroutineStart) null, new WalletDashboardViewModelImpl$handleExpiringCardSuccess$1(this, expiringCardDetailDisplayModel, (Continuation<? super WalletDashboardViewModelImpl$handleExpiringCardSuccess$1>) null), 3, (Object) null);
    }

    /* access modifiers changed from: private */
    public final void handleExpiringCreditFailure(Failure failure) {
        showDefaultHeader();
    }

    /* access modifiers changed from: private */
    public final void handleWalletBalanceServiceSuccess(WalletBalanceDisplayModel walletBalanceDisplayModel) {
        getWalletBalanceDisplayModelData().setValue(walletBalanceDisplayModel);
        this.walletBalanceLocalSource.setWalletBalance(walletBalanceDisplayModel.getWalletBalance());
    }

    /* access modifiers changed from: private */
    public final void handleWalletTransactionListSuccess(WalletTransactionListResponse walletTransactionListResponse) {
        WalletTransactionListDisplayModel invoke = this.getFormattedWalletTransactionListUseCase.invoke(new WalletTransactionListFormatterParam(walletTransactionListResponse, isFirstResponse(), getLastDisplayModel()));
        if (!isFirstResponse() || !invoke.getWalletTransactionList().isEmpty()) {
            updateTransactionsList(invoke);
        } else {
            Job unused = BuildersKt__Builders_commonKt.launch$default(ViewModelKt.getViewModelScope(this), (CoroutineContext) null, (CoroutineStart) null, new WalletDashboardViewModelImpl$handleWalletTransactionListSuccess$1(this, (Continuation<? super WalletDashboardViewModelImpl$handleWalletTransactionListSuccess$1>) null), 3, (Object) null);
        }
    }

    /* access modifiers changed from: private */
    public final boolean isCobrandedApplicationPending() {
        WalletBannerDisplayModel value = getWalletBannerDisplayModelData().getValue();
        return Intrinsics.areEqual((Object) value != null ? value.getBannerName() : null, (Object) "co_branded_card_pending_application");
    }

    private final void populateAmountSpentInMonthMap(List<MonthlySpentDisplayModel> list) {
        for (MonthlySpentDisplayModel next : list) {
            getAmountSpentPerMonthMap().put(next.getMonth(), Float.valueOf(next.getAmount()));
        }
    }

    /* access modifiers changed from: private */
    public final void showDefaultHeader() {
        Job unused = BuildersKt__Builders_commonKt.launch$default(ViewModelKt.getViewModelScope(this), (CoroutineContext) null, (CoroutineStart) null, new WalletDashboardViewModelImpl$showDefaultHeader$1(this, (Continuation<? super WalletDashboardViewModelImpl$showDefaultHeader$1>) null), 3, (Object) null);
    }

    private final void updateTransactionsList(WalletTransactionListDisplayModel walletTransactionListDisplayModel) {
        setLastDisplayModel(walletTransactionListDisplayModel.getLastTransactionDisplayModel());
        populateAmountSpentInMonthMap(walletTransactionListDisplayModel.getSpendPerMonthList());
        getWalletTransactionListDisplayModelData().setValue(walletTransactionListDisplayModel);
    }

    @NotNull
    public HashMap<String, Float> getAmountSpentPerMonthMap() {
        return this.amountSpentPerMonthMap;
    }

    @NotNull
    public WalletTransactionListDataItemDisplayModel.TransactionDisplayModel getLastDisplayModel() {
        return this.lastDisplayModel;
    }

    public boolean getShouldShowTopUpMessage() {
        return this.shouldShowTopUpMessage;
    }

    public void getTransactionsListHeader(int i11, boolean z11) {
        Job unused = BuildersKt__Builders_commonKt.launch$default(ViewModelKt.getViewModelScope(this), (CoroutineContext) null, (CoroutineStart) null, new WalletDashboardViewModelImpl$getTransactionsListHeader$1(z11, this, i11, (Continuation<? super WalletDashboardViewModelImpl$getTransactionsListHeader$1>) null), 3, (Object) null);
    }

    public void getWalletBalance(@NotNull String str, boolean z11) {
        Intrinsics.checkNotNullParameter(str, "country");
        if (z11) {
            this.getWalletBalanceUseCase.invoke(str, new WalletDashboardViewModelImpl$getWalletBalance$1(this));
        }
    }

    public void getWalletBanner(int i11, boolean z11) {
        if (z11) {
            Job unused = BuildersKt__Builders_commonKt.launch$default(ViewModelKt.getViewModelScope(this), (CoroutineContext) null, (CoroutineStart) null, new WalletDashboardViewModelImpl$getWalletBanner$1(this, i11, (Continuation<? super WalletDashboardViewModelImpl$getWalletBanner$1>) null), 3, (Object) null);
        }
    }

    public void getWalletTransactionList(int i11, int i12, int i13) {
        this.getWalletTransactionListUseCase.invoke(new WalletTransactionListParam(i11, i12, i13), new WalletDashboardViewModelImpl$getWalletTransactionList$1(this));
    }

    public boolean isFirstResponse() {
        return this.isFirstResponse;
    }

    public void onCobrandedCCBannerClicked(@Nullable String str) {
        String str2;
        String str3;
        NextScreenType nextScreenType;
        MutableLiveData<WalletShowNextScreenDisplayModel> walletShowNextScreenData = getWalletShowNextScreenData();
        WalletShowNextScreenDisplayModel walletShowNextScreenDisplayModel = new WalletShowNextScreenDisplayModel();
        if (str != null) {
            str2 = str + "?source=wallet_dashboard";
        } else {
            str2 = null;
        }
        WalletBannerDisplayModel value = getWalletBannerDisplayModelData().getValue();
        if (value != null) {
            str3 = value.getBannerName();
        } else {
            str3 = null;
        }
        String valueOf = String.valueOf(str3);
        if (str2 == null) {
            nextScreenType = new NextScreenCobrandedCreditCardFlutter((NavigationType) null, (Screen) null, 3, (DefaultConstructorMarker) null);
        } else {
            nextScreenType = new NextScreenDeeplinkFlutter(str2, valueOf, (NavigationType) null, (Screen) null, 12, (DefaultConstructorMarker) null);
        }
        walletShowNextScreenDisplayModel.setNextScreen(nextScreenType);
        this.cobrandedCCBannerTracker.trackBannerClicked(isCobrandedApplicationPending());
        this.observabilityManager.trackEvent(CobrandedDynamicBannerConstants.EVENT_NAME, CobrandedDynamicBannerConstants.COBRANDED_DEEPLINK_EVENT, (Map<String, String>) MapsKt__MapsKt.mapOf(TuplesKt.to("deeplink", String.valueOf(str2)), TuplesKt.to("bannerName", valueOf)));
        walletShowNextScreenData.setValue(walletShowNextScreenDisplayModel);
    }

    public void onOnBoardingShown() {
        Job unused = BuildersKt__Builders_commonKt.launch$default(ViewModelKt.getViewModelScope(this), (CoroutineContext) null, (CoroutineStart) null, new WalletDashboardViewModelImpl$onOnBoardingShown$1(this, (Continuation<? super WalletDashboardViewModelImpl$onOnBoardingShown$1>) null), 3, (Object) null);
    }

    public void onShowCreditInformationButtonClicked() {
        Job unused = BuildersKt__Builders_commonKt.launch$default(ViewModelKt.getViewModelScope(this), (CoroutineContext) null, (CoroutineStart) null, new WalletDashboardViewModelImpl$onShowCreditInformationButtonClicked$1(this, (Continuation<? super WalletDashboardViewModelImpl$onShowCreditInformationButtonClicked$1>) null), 3, (Object) null);
    }

    public void onTransactionDetailsClicked(int i11, int i12) {
        Job unused = BuildersKt__Builders_commonKt.launch$default(ViewModelKt.getViewModelScope(this), (CoroutineContext) null, (CoroutineStart) null, new WalletDashboardViewModelImpl$onTransactionDetailsClicked$1(this, i11, i12, (Continuation<? super WalletDashboardViewModelImpl$onTransactionDetailsClicked$1>) null), 3, (Object) null);
    }

    public void setAmountSpentPerMonthMap(@NotNull HashMap<String, Float> hashMap) {
        Intrinsics.checkNotNullParameter(hashMap, "<set-?>");
        this.amountSpentPerMonthMap = hashMap;
    }

    public void setFirstResponse(boolean z11) {
        this.isFirstResponse = z11;
    }

    public void setLastDisplayModel(@NotNull WalletTransactionListDataItemDisplayModel.TransactionDisplayModel transactionDisplayModel) {
        Intrinsics.checkNotNullParameter(transactionDisplayModel, "<set-?>");
        this.lastDisplayModel = transactionDisplayModel;
    }

    public void setShouldShowTopUpMessage(boolean z11) {
        this.shouldShowTopUpMessage = z11;
    }

    public void shouldShowCreditInformationButton() {
        Job unused = BuildersKt__Builders_commonKt.launch$default(ViewModelKt.getViewModelScope(this), (CoroutineContext) null, (CoroutineStart) null, new WalletDashboardViewModelImpl$shouldShowCreditInformationButton$1(this, (Continuation<? super WalletDashboardViewModelImpl$shouldShowCreditInformationButton$1>) null), 3, (Object) null);
    }

    public boolean shouldShowFlutterCardsManagementScreen() {
        return this.isFlutterCardsManagementScreenEnabledUseCase.invoke();
    }

    public boolean shouldShowFlutterTopUpScreen() {
        return this.isFlutterTopUpScreenEnabledUseCase.invoke();
    }

    public void shouldShowOnboarding(boolean z11) {
        if (!z11) {
            MutableLiveData<WalletOnboardingDisplayModel> shouldShowOnBoardingData = getShouldShowOnBoardingData();
            WalletOnboardingDisplayModel walletOnboardingDisplayModel = new WalletOnboardingDisplayModel();
            walletOnboardingDisplayModel.setOnboardingType(OnboardingType.None.INSTANCE);
            shouldShowOnBoardingData.setValue(walletOnboardingDisplayModel);
            return;
        }
        Job unused = BuildersKt__Builders_commonKt.launch$default(ViewModelKt.getViewModelScope(this), (CoroutineContext) null, (CoroutineStart) null, new WalletDashboardViewModelImpl$shouldShowOnboarding$2(this, (Continuation<? super WalletDashboardViewModelImpl$shouldShowOnboarding$2>) null), 3, (Object) null);
    }

    public void showDashBoardIcons() {
        Job unused = BuildersKt__Builders_commonKt.launch$default(ViewModelKt.getViewModelScope(this), (CoroutineContext) null, (CoroutineStart) null, new WalletDashboardViewModelImpl$showDashBoardIcons$1(this, (Continuation<? super WalletDashboardViewModelImpl$showDashBoardIcons$1>) null), 3, (Object) null);
    }
}
