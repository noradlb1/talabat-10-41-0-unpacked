package com.talabat.wallet.ui.walletDashboard.viewModel;

import android.app.Activity;
import androidx.datastore.core.DataStore;
import androidx.datastore.preferences.core.Preferences;
import com.talabat.configuration.ConfigurationLocalRepository;
import com.talabat.configuration.di.ConfigurationLocalCoreLibApi;
import com.talabat.configuration.di.ConfigurationRemoteCoreLibApi;
import com.talabat.core.featureflag.domain.FeatureFlagCoreLibApi;
import com.talabat.core.featureflag.domain.ITalabatFeatureFlag;
import com.talabat.core.network.domain.NetworkCoreLibApi;
import com.talabat.core.network.network.TalabatAPIBuilder;
import com.talabat.core.observabilityNew.domain.IObservabilityManager;
import com.talabat.core.tracking.domain.TalabatTracker;
import com.talabat.core.ui.di.AndroidComponentsKt;
import com.talabat.talabatcommon.feature.walletBalance.GetWalletBalanceUseCase;
import com.talabat.talabatcommon.feature.walletBalance.network.WalletBalanceService;
import com.talabat.talabatcommon.feature.walletBalance.repository.WalletBalanceRepositoryImpl;
import com.talabat.talabatcommon.feature.walletBanner.GetWalletBannerUseCase;
import com.talabat.talabatcommon.feature.walletBanner.model.WalletCobrandedCcBaseUrl;
import com.talabat.talabatcommon.feature.walletBanner.repository.WalletBannerRepositoryImpl;
import com.talabat.talabatcommon.feature.walletBanner.service.WalletBannerApi;
import com.talabat.talabatcommon.feature.walletBanner.service.WalletBannerServiceImpl;
import com.talabat.talabatcore.platform.NetworkHandler;
import com.talabat.wallet.features.cobrandedcc.CobrandedCCBannerTrackerImpl;
import com.talabat.wallet.features.cobrandedcc.GetWalletDashboardCobrandedCCEnabledUseCase;
import com.talabat.wallet.features.expiringCard.GetExpiringCardDetailUseCase;
import com.talabat.wallet.features.expiringCard.network.ExpiringCardService;
import com.talabat.wallet.features.expiringCard.repository.ExpiringCardRepositoryImpl;
import com.talabat.wallet.features.walletTransactionList.GetFormattedWalletTransactionListUseCase;
import com.talabat.wallet.features.walletTransactionList.GetShouldShowWalletTransactionDetailsInFlutterUseCase;
import com.talabat.wallet.features.walletTransactionList.GetWalletDashboardFlagEnabledUseCase;
import com.talabat.wallet.features.walletTransactionList.GetWalletDashboardMoreButtonEnabledUseCase;
import com.talabat.wallet.features.walletTransactionList.GetWalletTransactionListUseCase;
import com.talabat.wallet.features.walletTransactionList.IsFlutterCardsManagementScreenEnabledUseCase;
import com.talabat.wallet.features.walletTransactionList.IsFlutterTopUpScreenEnabledUseCase;
import com.talabat.wallet.features.walletTransactionList.network.WalletTransactionListService;
import com.talabat.wallet.features.walletTransactionList.repository.WalletTransactionListRepositoryImpl;
import com.talabat.wallet.features.walletonboarding.GetWalletDashboardOnboardingEnabledUseCase;
import com.talabat.wallet.features.walletonboarding.repository.GetWasWalletOnboardingShownUseCase;
import com.talabat.wallet.features.walletonboarding.repository.UpdateWasWalletOnboardingShownUseCase;
import com.talabat.wallet.features.walletonboarding.repository.UserPreferencesRepository;
import com.talabat.wallet.walletbalance.data.local.impl.WalletBalanceLocalSourceImpl;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Dispatchers;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J4\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u000b0\n2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000f¨\u0006\u0010"}, d2 = {"Lcom/talabat/wallet/ui/walletDashboard/viewModel/WalletDashboardViewModelBuilder;", "", "()V", "getWalletDashboardViewModel", "Lcom/talabat/wallet/ui/walletDashboard/viewModel/WalletDashboardViewModelImpl;", "activity", "Landroid/app/Activity;", "coroutineScope", "Lkotlinx/coroutines/CoroutineScope;", "dataStore", "Landroidx/datastore/core/DataStore;", "Landroidx/datastore/preferences/core/Preferences;", "talabatTracker", "Lcom/talabat/core/tracking/domain/TalabatTracker;", "observabilityManager", "Lcom/talabat/core/observabilityNew/domain/IObservabilityManager;", "com_talabat_NewArchi_WalletSquad_WalletSquad"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class WalletDashboardViewModelBuilder {
    @NotNull
    public static final WalletDashboardViewModelBuilder INSTANCE = new WalletDashboardViewModelBuilder();

    private WalletDashboardViewModelBuilder() {
    }

    @NotNull
    public final WalletDashboardViewModelImpl getWalletDashboardViewModel(@NotNull Activity activity, @NotNull CoroutineScope coroutineScope, @NotNull DataStore<Preferences> dataStore, @NotNull TalabatTracker talabatTracker, @NotNull IObservabilityManager iObservabilityManager) {
        Activity activity2 = activity;
        CoroutineScope coroutineScope2 = coroutineScope;
        DataStore<Preferences> dataStore2 = dataStore;
        TalabatTracker talabatTracker2 = talabatTracker;
        Intrinsics.checkNotNullParameter(activity2, "activity");
        Intrinsics.checkNotNullParameter(coroutineScope2, "coroutineScope");
        Intrinsics.checkNotNullParameter(dataStore2, "dataStore");
        Intrinsics.checkNotNullParameter(talabatTracker2, "talabatTracker");
        Intrinsics.checkNotNullParameter(iObservabilityManager, "observabilityManager");
        ConfigurationLocalRepository repository = ((ConfigurationLocalCoreLibApi) AndroidComponentsKt.apiContainer(activity).getFeature(ConfigurationLocalCoreLibApi.class)).getRepository();
        ITalabatFeatureFlag talabatFeatureFlag = ((FeatureFlagCoreLibApi) AndroidComponentsKt.apiContainer(activity).getFeature(FeatureFlagCoreLibApi.class)).getTalabatFeatureFlag();
        GetWalletBalanceUseCase getWalletBalanceUseCase = r1;
        GetWalletBalanceUseCase getWalletBalanceUseCase2 = new GetWalletBalanceUseCase(new WalletBalanceRepositoryImpl(new NetworkHandler(activity2), new WalletBalanceService(new TalabatAPIBuilder()), ((ConfigurationRemoteCoreLibApi) AndroidComponentsKt.apiContainer(activity).getFeature(ConfigurationRemoteCoreLibApi.class)).getLocationConfigurationRepository()), coroutineScope2, Dispatchers.getMain());
        GetExpiringCardDetailUseCase getExpiringCardDetailUseCase = r1;
        GetExpiringCardDetailUseCase getExpiringCardDetailUseCase2 = new GetExpiringCardDetailUseCase(new ExpiringCardRepositoryImpl(new NetworkHandler(activity2), new ExpiringCardService(new TalabatAPIBuilder())), coroutineScope, Dispatchers.getMain(), (Function1) null, repository, 8, (DefaultConstructorMarker) null);
        ITalabatFeatureFlag iTalabatFeatureFlag = talabatFeatureFlag;
        GetWalletTransactionListUseCase getWalletTransactionListUseCase = r2;
        GetWalletTransactionListUseCase getWalletTransactionListUseCase2 = new GetWalletTransactionListUseCase(new WalletTransactionListRepositoryImpl(new NetworkHandler(activity2), new WalletTransactionListService(new TalabatAPIBuilder())), coroutineScope2, Dispatchers.getMain());
        UserPreferencesRepository userPreferencesRepository = new UserPreferencesRepository(dataStore2);
        String baseUrl = ((NetworkCoreLibApi) AndroidComponentsKt.apiContainer(activity).getFeature(NetworkCoreLibApi.class)).getBaseUrlFactory().baseUrl(new WalletCobrandedCcBaseUrl());
        GetFormattedWalletTransactionListUseCase getFormattedWalletTransactionListUseCase = r5;
        GetFormattedWalletTransactionListUseCase getFormattedWalletTransactionListUseCase2 = new GetFormattedWalletTransactionListUseCase();
        GetWalletDashboardFlagEnabledUseCase getWalletDashboardFlagEnabledUseCase = r5;
        GetWalletDashboardFlagEnabledUseCase getWalletDashboardFlagEnabledUseCase2 = new GetWalletDashboardFlagEnabledUseCase(iTalabatFeatureFlag, repository);
        WalletBalanceLocalSourceImpl walletBalanceLocalSourceImpl = r4;
        WalletBalanceLocalSourceImpl walletBalanceLocalSourceImpl2 = new WalletBalanceLocalSourceImpl();
        GetWalletDashboardOnboardingEnabledUseCase getWalletDashboardOnboardingEnabledUseCase = r4;
        GetWalletDashboardOnboardingEnabledUseCase getWalletDashboardOnboardingEnabledUseCase2 = new GetWalletDashboardOnboardingEnabledUseCase(iTalabatFeatureFlag);
        GetWalletDashboardCobrandedCCEnabledUseCase getWalletDashboardCobrandedCCEnabledUseCase = r4;
        GetWalletDashboardCobrandedCCEnabledUseCase getWalletDashboardCobrandedCCEnabledUseCase2 = new GetWalletDashboardCobrandedCCEnabledUseCase(iTalabatFeatureFlag);
        GetWasWalletOnboardingShownUseCase getWasWalletOnboardingShownUseCase = r4;
        GetWasWalletOnboardingShownUseCase getWasWalletOnboardingShownUseCase2 = new GetWasWalletOnboardingShownUseCase(userPreferencesRepository);
        UpdateWasWalletOnboardingShownUseCase updateWasWalletOnboardingShownUseCase = r4;
        UpdateWasWalletOnboardingShownUseCase updateWasWalletOnboardingShownUseCase2 = new UpdateWasWalletOnboardingShownUseCase(userPreferencesRepository);
        GetWalletDashboardMoreButtonEnabledUseCase getWalletDashboardMoreButtonEnabledUseCase = r1;
        GetWalletDashboardMoreButtonEnabledUseCase getWalletDashboardMoreButtonEnabledUseCase2 = new GetWalletDashboardMoreButtonEnabledUseCase(iTalabatFeatureFlag);
        GetShouldShowWalletTransactionDetailsInFlutterUseCase getShouldShowWalletTransactionDetailsInFlutterUseCase = r1;
        GetShouldShowWalletTransactionDetailsInFlutterUseCase getShouldShowWalletTransactionDetailsInFlutterUseCase2 = new GetShouldShowWalletTransactionDetailsInFlutterUseCase(iTalabatFeatureFlag);
        GetWalletBannerUseCase getWalletBannerUseCase = r1;
        GetWalletBannerUseCase getWalletBannerUseCase2 = new GetWalletBannerUseCase(new WalletBannerRepositoryImpl(new WalletBannerServiceImpl((WalletBannerApi) new TalabatAPIBuilder().createApi(baseUrl, WalletBannerApi.class))));
        CobrandedCCBannerTrackerImpl cobrandedCCBannerTrackerImpl = r0;
        CobrandedCCBannerTrackerImpl cobrandedCCBannerTrackerImpl2 = new CobrandedCCBannerTrackerImpl(talabatTracker2);
        IsFlutterTopUpScreenEnabledUseCase isFlutterTopUpScreenEnabledUseCase = r0;
        IsFlutterTopUpScreenEnabledUseCase isFlutterTopUpScreenEnabledUseCase2 = new IsFlutterTopUpScreenEnabledUseCase(iTalabatFeatureFlag);
        IsFlutterCardsManagementScreenEnabledUseCase isFlutterCardsManagementScreenEnabledUseCase = r0;
        IsFlutterCardsManagementScreenEnabledUseCase isFlutterCardsManagementScreenEnabledUseCase2 = new IsFlutterCardsManagementScreenEnabledUseCase(iTalabatFeatureFlag);
        return new WalletDashboardViewModelImpl(getWalletBalanceUseCase, getExpiringCardDetailUseCase, getWalletTransactionListUseCase, getFormattedWalletTransactionListUseCase, getWalletDashboardFlagEnabledUseCase, walletBalanceLocalSourceImpl, getWalletDashboardOnboardingEnabledUseCase, getWalletDashboardCobrandedCCEnabledUseCase, getWasWalletOnboardingShownUseCase, updateWasWalletOnboardingShownUseCase, getWalletDashboardMoreButtonEnabledUseCase, getShouldShowWalletTransactionDetailsInFlutterUseCase, getWalletBannerUseCase, cobrandedCCBannerTrackerImpl, isFlutterTopUpScreenEnabledUseCase, isFlutterCardsManagementScreenEnabledUseCase, iObservabilityManager);
    }
}
