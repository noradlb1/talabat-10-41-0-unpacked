package com.talabat.home;

import com.talabat.configuration.ConfigurationLocalRepository;
import com.talabat.configuration.MutableLocationConfigurationRepository;
import com.talabat.configuration.discovery.AppVersionProvider;
import com.talabat.core.deeplink.domain.DeepLinkNavigator;
import com.talabat.core.dispatcher.domain.CoroutineDispatchersFactory;
import com.talabat.core.experiment.domain.ITalabatExperiment;
import com.talabat.core.featureflag.domain.ITalabatFeatureFlag;
import com.talabat.core.navigation.domain.Navigator;
import com.talabat.core.observabilityNew.domain.IObservabilityManager;
import com.talabat.core.observabilityNew.domain.IScreenTracker;
import com.talabat.core.tracking.domain.TalabatTracker;
import com.talabat.customer.domain.CustomerRepository;
import com.talabat.feature.bnplcore.domain.usecase.GetOverdueNotificationAcknowledgeUseCase;
import com.talabat.feature.bnplcore.domain.usecase.GetOverdueUseCase;
import com.talabat.feature.bnplcore.domain.usecase.UpdateOverdueAcknowledgeStateUseCase;
import com.talabat.feature.darkstores.domain.navigator.DarkstoresNavigator;
import com.talabat.feature.rating.domain.repo.RatingSession;
import com.talabat.feature.rating.domain.usecase.ShouldRateLastOrderUseCase;
import com.talabat.feature.tpro.presentation.util.SubscriptionSharedPrefManager;
import com.talabat.feature.ulcampaign.domain.CampaignMigratorSharedPreferences;
import com.talabat.feature.walletcobrandedcc.presentation.CobrandedCcViewModelFactory;
import com.talabat.fluid.homescreen.domain.tracking.observability.HomeScreenPerformanceObservability;
import com.talabat.growth.ui.vouchers.entrypoint.viewmodel.VoucherEntryPointViewModelFactory;
import com.talabat.onboarding.domain.usecase.IsOnboardingExperimentEnabledUseCase;
import dagger.MembersInjector;
import dagger.internal.DaggerGenerated;
import dagger.internal.InjectedFieldSignature;
import dagger.internal.QualifierMetadata;
import javax.inject.Provider;
import library.talabat.mvp.home.IsNfvFlutterNavigationUsecase;
import library.talabat.mvp.home.domain.GetActiveCartInfoUseCase;

@QualifierMetadata
@DaggerGenerated
public final class HomeScreenActivity_MembersInjector implements MembersInjector<HomeScreenActivity> {
    private final Provider<AppVersionProvider> appVersionProvider;
    private final Provider<CampaignMigratorSharedPreferences> campaignMigratorSharedPreferencesProvider;
    private final Provider<CobrandedCcViewModelFactory> cobrandedVmFactoryProvider;
    private final Provider<ConfigurationLocalRepository> configurationLocalRepositoryProvider;
    private final Provider<CoroutineDispatchersFactory> coroutineDispatchersFactoryProvider;
    private final Provider<CustomerRepository> customerRepositoryProvider;
    private final Provider<DarkstoresNavigator> darkstoresNavigatorProvider;
    private final Provider<DeepLinkNavigator> deepLinkNavigatorProvider;
    private final Provider<VoucherEntryPointViewModelFactory> factoryProvider;
    private final Provider<GetActiveCartInfoUseCase> getActiveCartInfoUseCaseProvider;
    private final Provider<GetOverdueNotificationAcknowledgeUseCase> getOverdueNotificationAcknowledgeUseCaseProvider;
    private final Provider<GetOverdueUseCase> getOverdueUseCaseProvider;
    private final Provider<HomeScreenPerformanceObservability> homeScreenPerformanceObservabilityProvider;
    private final Provider<IsNfvFlutterNavigationUsecase> isNfvFlutterNavigationUsecaseProvider;
    private final Provider<IsOnboardingExperimentEnabledUseCase> isOnboardingExperimentEnabledUseCaseProvider;
    private final Provider<MutableLocationConfigurationRepository> mutableLocationConfigurationRepositoryProvider;
    private final Provider<Navigator> navigatorProvider;
    private final Provider<IObservabilityManager> observabilityManagerProvider;
    private final Provider<RatingSession> ratingSessionProvider;
    private final Provider<IScreenTracker> screenTrackerProvider;
    private final Provider<ShouldRateLastOrderUseCase> shouldRateLastOrderUseCaseProvider;
    private final Provider<SubscriptionSharedPrefManager> subscriptionSharedPrefManagerProvider;
    private final Provider<ITalabatExperiment> talabatExperimentProvider;
    private final Provider<ITalabatFeatureFlag> talabatFeatureFlagProvider;
    private final Provider<TalabatTracker> talabatTrackerProvider;
    private final Provider<UpdateOverdueAcknowledgeStateUseCase> updateOverdueAcknowledgeStateUseCaseProvider;

    public HomeScreenActivity_MembersInjector(Provider<AppVersionProvider> provider, Provider<TalabatTracker> provider2, Provider<ConfigurationLocalRepository> provider3, Provider<IObservabilityManager> provider4, Provider<ITalabatFeatureFlag> provider5, Provider<ITalabatExperiment> provider6, Provider<RatingSession> provider7, Provider<DeepLinkNavigator> provider8, Provider<Navigator> provider9, Provider<GetOverdueUseCase> provider10, Provider<GetOverdueNotificationAcknowledgeUseCase> provider11, Provider<UpdateOverdueAcknowledgeStateUseCase> provider12, Provider<CampaignMigratorSharedPreferences> provider13, Provider<GetActiveCartInfoUseCase> provider14, Provider<DarkstoresNavigator> provider15, Provider<HomeScreenPerformanceObservability> provider16, Provider<SubscriptionSharedPrefManager> provider17, Provider<MutableLocationConfigurationRepository> provider18, Provider<IScreenTracker> provider19, Provider<ShouldRateLastOrderUseCase> provider20, Provider<CoroutineDispatchersFactory> provider21, Provider<CustomerRepository> provider22, Provider<VoucherEntryPointViewModelFactory> provider23, Provider<CobrandedCcViewModelFactory> provider24, Provider<IsOnboardingExperimentEnabledUseCase> provider25, Provider<IsNfvFlutterNavigationUsecase> provider26) {
        this.appVersionProvider = provider;
        this.talabatTrackerProvider = provider2;
        this.configurationLocalRepositoryProvider = provider3;
        this.observabilityManagerProvider = provider4;
        this.talabatFeatureFlagProvider = provider5;
        this.talabatExperimentProvider = provider6;
        this.ratingSessionProvider = provider7;
        this.deepLinkNavigatorProvider = provider8;
        this.navigatorProvider = provider9;
        this.getOverdueUseCaseProvider = provider10;
        this.getOverdueNotificationAcknowledgeUseCaseProvider = provider11;
        this.updateOverdueAcknowledgeStateUseCaseProvider = provider12;
        this.campaignMigratorSharedPreferencesProvider = provider13;
        this.getActiveCartInfoUseCaseProvider = provider14;
        this.darkstoresNavigatorProvider = provider15;
        this.homeScreenPerformanceObservabilityProvider = provider16;
        this.subscriptionSharedPrefManagerProvider = provider17;
        this.mutableLocationConfigurationRepositoryProvider = provider18;
        this.screenTrackerProvider = provider19;
        this.shouldRateLastOrderUseCaseProvider = provider20;
        this.coroutineDispatchersFactoryProvider = provider21;
        this.customerRepositoryProvider = provider22;
        this.factoryProvider = provider23;
        this.cobrandedVmFactoryProvider = provider24;
        this.isOnboardingExperimentEnabledUseCaseProvider = provider25;
        this.isNfvFlutterNavigationUsecaseProvider = provider26;
    }

    public static MembersInjector<HomeScreenActivity> create(Provider<AppVersionProvider> provider, Provider<TalabatTracker> provider2, Provider<ConfigurationLocalRepository> provider3, Provider<IObservabilityManager> provider4, Provider<ITalabatFeatureFlag> provider5, Provider<ITalabatExperiment> provider6, Provider<RatingSession> provider7, Provider<DeepLinkNavigator> provider8, Provider<Navigator> provider9, Provider<GetOverdueUseCase> provider10, Provider<GetOverdueNotificationAcknowledgeUseCase> provider11, Provider<UpdateOverdueAcknowledgeStateUseCase> provider12, Provider<CampaignMigratorSharedPreferences> provider13, Provider<GetActiveCartInfoUseCase> provider14, Provider<DarkstoresNavigator> provider15, Provider<HomeScreenPerformanceObservability> provider16, Provider<SubscriptionSharedPrefManager> provider17, Provider<MutableLocationConfigurationRepository> provider18, Provider<IScreenTracker> provider19, Provider<ShouldRateLastOrderUseCase> provider20, Provider<CoroutineDispatchersFactory> provider21, Provider<CustomerRepository> provider22, Provider<VoucherEntryPointViewModelFactory> provider23, Provider<CobrandedCcViewModelFactory> provider24, Provider<IsOnboardingExperimentEnabledUseCase> provider25, Provider<IsNfvFlutterNavigationUsecase> provider26) {
        return new HomeScreenActivity_MembersInjector(provider, provider2, provider3, provider4, provider5, provider6, provider7, provider8, provider9, provider10, provider11, provider12, provider13, provider14, provider15, provider16, provider17, provider18, provider19, provider20, provider21, provider22, provider23, provider24, provider25, provider26);
    }

    @InjectedFieldSignature("com.talabat.home.HomeScreenActivity.appVersionProvider")
    public static void injectAppVersionProvider(HomeScreenActivity homeScreenActivity, AppVersionProvider appVersionProvider2) {
        homeScreenActivity.appVersionProvider = appVersionProvider2;
    }

    @InjectedFieldSignature("com.talabat.home.HomeScreenActivity.campaignMigratorSharedPreferences")
    public static void injectCampaignMigratorSharedPreferences(HomeScreenActivity homeScreenActivity, CampaignMigratorSharedPreferences campaignMigratorSharedPreferences) {
        homeScreenActivity.campaignMigratorSharedPreferences = campaignMigratorSharedPreferences;
    }

    @InjectedFieldSignature("com.talabat.home.HomeScreenActivity.cobrandedVmFactory")
    public static void injectCobrandedVmFactory(HomeScreenActivity homeScreenActivity, CobrandedCcViewModelFactory cobrandedCcViewModelFactory) {
        homeScreenActivity.cobrandedVmFactory = cobrandedCcViewModelFactory;
    }

    @InjectedFieldSignature("com.talabat.home.HomeScreenActivity.configurationLocalRepository")
    public static void injectConfigurationLocalRepository(HomeScreenActivity homeScreenActivity, ConfigurationLocalRepository configurationLocalRepository) {
        homeScreenActivity.configurationLocalRepository = configurationLocalRepository;
    }

    @InjectedFieldSignature("com.talabat.home.HomeScreenActivity.coroutineDispatchersFactory")
    public static void injectCoroutineDispatchersFactory(HomeScreenActivity homeScreenActivity, CoroutineDispatchersFactory coroutineDispatchersFactory) {
        homeScreenActivity.coroutineDispatchersFactory = coroutineDispatchersFactory;
    }

    @InjectedFieldSignature("com.talabat.home.HomeScreenActivity.customerRepository")
    public static void injectCustomerRepository(HomeScreenActivity homeScreenActivity, CustomerRepository customerRepository) {
        homeScreenActivity.customerRepository = customerRepository;
    }

    @InjectedFieldSignature("com.talabat.home.HomeScreenActivity.darkstoresNavigator")
    public static void injectDarkstoresNavigator(HomeScreenActivity homeScreenActivity, DarkstoresNavigator darkstoresNavigator) {
        homeScreenActivity.darkstoresNavigator = darkstoresNavigator;
    }

    @InjectedFieldSignature("com.talabat.home.HomeScreenActivity.deepLinkNavigator")
    public static void injectDeepLinkNavigator(HomeScreenActivity homeScreenActivity, DeepLinkNavigator deepLinkNavigator) {
        homeScreenActivity.deepLinkNavigator = deepLinkNavigator;
    }

    @InjectedFieldSignature("com.talabat.home.HomeScreenActivity.factory")
    public static void injectFactory(HomeScreenActivity homeScreenActivity, VoucherEntryPointViewModelFactory voucherEntryPointViewModelFactory) {
        homeScreenActivity.factory = voucherEntryPointViewModelFactory;
    }

    @InjectedFieldSignature("com.talabat.home.HomeScreenActivity.getActiveCartInfoUseCase")
    public static void injectGetActiveCartInfoUseCase(HomeScreenActivity homeScreenActivity, GetActiveCartInfoUseCase getActiveCartInfoUseCase) {
        homeScreenActivity.getActiveCartInfoUseCase = getActiveCartInfoUseCase;
    }

    @InjectedFieldSignature("com.talabat.home.HomeScreenActivity.getOverdueNotificationAcknowledgeUseCase")
    public static void injectGetOverdueNotificationAcknowledgeUseCase(HomeScreenActivity homeScreenActivity, GetOverdueNotificationAcknowledgeUseCase getOverdueNotificationAcknowledgeUseCase) {
        homeScreenActivity.getOverdueNotificationAcknowledgeUseCase = getOverdueNotificationAcknowledgeUseCase;
    }

    @InjectedFieldSignature("com.talabat.home.HomeScreenActivity.getOverdueUseCase")
    public static void injectGetOverdueUseCase(HomeScreenActivity homeScreenActivity, GetOverdueUseCase getOverdueUseCase) {
        homeScreenActivity.getOverdueUseCase = getOverdueUseCase;
    }

    @InjectedFieldSignature("com.talabat.home.HomeScreenActivity.homeScreenPerformanceObservability")
    public static void injectHomeScreenPerformanceObservability(HomeScreenActivity homeScreenActivity, HomeScreenPerformanceObservability homeScreenPerformanceObservability) {
        homeScreenActivity.homeScreenPerformanceObservability = homeScreenPerformanceObservability;
    }

    @InjectedFieldSignature("com.talabat.home.HomeScreenActivity.isNfvFlutterNavigationUsecase")
    public static void injectIsNfvFlutterNavigationUsecase(HomeScreenActivity homeScreenActivity, IsNfvFlutterNavigationUsecase isNfvFlutterNavigationUsecase) {
        homeScreenActivity.isNfvFlutterNavigationUsecase = isNfvFlutterNavigationUsecase;
    }

    @InjectedFieldSignature("com.talabat.home.HomeScreenActivity.isOnboardingExperimentEnabledUseCase")
    public static void injectIsOnboardingExperimentEnabledUseCase(HomeScreenActivity homeScreenActivity, IsOnboardingExperimentEnabledUseCase isOnboardingExperimentEnabledUseCase) {
        homeScreenActivity.isOnboardingExperimentEnabledUseCase = isOnboardingExperimentEnabledUseCase;
    }

    @InjectedFieldSignature("com.talabat.home.HomeScreenActivity.mutableLocationConfigurationRepository")
    public static void injectMutableLocationConfigurationRepository(HomeScreenActivity homeScreenActivity, MutableLocationConfigurationRepository mutableLocationConfigurationRepository) {
        homeScreenActivity.mutableLocationConfigurationRepository = mutableLocationConfigurationRepository;
    }

    @InjectedFieldSignature("com.talabat.home.HomeScreenActivity.navigator")
    public static void injectNavigator(HomeScreenActivity homeScreenActivity, Navigator navigator) {
        homeScreenActivity.navigator = navigator;
    }

    @InjectedFieldSignature("com.talabat.home.HomeScreenActivity.observabilityManager")
    public static void injectObservabilityManager(HomeScreenActivity homeScreenActivity, IObservabilityManager iObservabilityManager) {
        homeScreenActivity.observabilityManager = iObservabilityManager;
    }

    @InjectedFieldSignature("com.talabat.home.HomeScreenActivity.ratingSession")
    public static void injectRatingSession(HomeScreenActivity homeScreenActivity, RatingSession ratingSession) {
        homeScreenActivity.ratingSession = ratingSession;
    }

    @InjectedFieldSignature("com.talabat.home.HomeScreenActivity.screenTracker")
    public static void injectScreenTracker(HomeScreenActivity homeScreenActivity, IScreenTracker iScreenTracker) {
        homeScreenActivity.screenTracker = iScreenTracker;
    }

    @InjectedFieldSignature("com.talabat.home.HomeScreenActivity.shouldRateLastOrderUseCase")
    public static void injectShouldRateLastOrderUseCase(HomeScreenActivity homeScreenActivity, ShouldRateLastOrderUseCase shouldRateLastOrderUseCase) {
        homeScreenActivity.shouldRateLastOrderUseCase = shouldRateLastOrderUseCase;
    }

    @InjectedFieldSignature("com.talabat.home.HomeScreenActivity.subscriptionSharedPrefManager")
    public static void injectSubscriptionSharedPrefManager(HomeScreenActivity homeScreenActivity, SubscriptionSharedPrefManager subscriptionSharedPrefManager) {
        homeScreenActivity.subscriptionSharedPrefManager = subscriptionSharedPrefManager;
    }

    @InjectedFieldSignature("com.talabat.home.HomeScreenActivity.talabatExperiment")
    public static void injectTalabatExperiment(HomeScreenActivity homeScreenActivity, ITalabatExperiment iTalabatExperiment) {
        homeScreenActivity.talabatExperiment = iTalabatExperiment;
    }

    @InjectedFieldSignature("com.talabat.home.HomeScreenActivity.talabatFeatureFlag")
    public static void injectTalabatFeatureFlag(HomeScreenActivity homeScreenActivity, ITalabatFeatureFlag iTalabatFeatureFlag) {
        homeScreenActivity.talabatFeatureFlag = iTalabatFeatureFlag;
    }

    @InjectedFieldSignature("com.talabat.home.HomeScreenActivity.talabatTracker")
    public static void injectTalabatTracker(HomeScreenActivity homeScreenActivity, TalabatTracker talabatTracker) {
        homeScreenActivity.talabatTracker = talabatTracker;
    }

    @InjectedFieldSignature("com.talabat.home.HomeScreenActivity.updateOverdueAcknowledgeStateUseCase")
    public static void injectUpdateOverdueAcknowledgeStateUseCase(HomeScreenActivity homeScreenActivity, UpdateOverdueAcknowledgeStateUseCase updateOverdueAcknowledgeStateUseCase) {
        homeScreenActivity.updateOverdueAcknowledgeStateUseCase = updateOverdueAcknowledgeStateUseCase;
    }

    public void injectMembers(HomeScreenActivity homeScreenActivity) {
        injectAppVersionProvider(homeScreenActivity, this.appVersionProvider.get());
        injectTalabatTracker(homeScreenActivity, this.talabatTrackerProvider.get());
        injectConfigurationLocalRepository(homeScreenActivity, this.configurationLocalRepositoryProvider.get());
        injectObservabilityManager(homeScreenActivity, this.observabilityManagerProvider.get());
        injectTalabatFeatureFlag(homeScreenActivity, this.talabatFeatureFlagProvider.get());
        injectTalabatExperiment(homeScreenActivity, this.talabatExperimentProvider.get());
        injectRatingSession(homeScreenActivity, this.ratingSessionProvider.get());
        injectDeepLinkNavigator(homeScreenActivity, this.deepLinkNavigatorProvider.get());
        injectNavigator(homeScreenActivity, this.navigatorProvider.get());
        injectGetOverdueUseCase(homeScreenActivity, this.getOverdueUseCaseProvider.get());
        injectGetOverdueNotificationAcknowledgeUseCase(homeScreenActivity, this.getOverdueNotificationAcknowledgeUseCaseProvider.get());
        injectUpdateOverdueAcknowledgeStateUseCase(homeScreenActivity, this.updateOverdueAcknowledgeStateUseCaseProvider.get());
        injectCampaignMigratorSharedPreferences(homeScreenActivity, this.campaignMigratorSharedPreferencesProvider.get());
        injectGetActiveCartInfoUseCase(homeScreenActivity, this.getActiveCartInfoUseCaseProvider.get());
        injectDarkstoresNavigator(homeScreenActivity, this.darkstoresNavigatorProvider.get());
        injectHomeScreenPerformanceObservability(homeScreenActivity, this.homeScreenPerformanceObservabilityProvider.get());
        injectSubscriptionSharedPrefManager(homeScreenActivity, this.subscriptionSharedPrefManagerProvider.get());
        injectMutableLocationConfigurationRepository(homeScreenActivity, this.mutableLocationConfigurationRepositoryProvider.get());
        injectScreenTracker(homeScreenActivity, this.screenTrackerProvider.get());
        injectShouldRateLastOrderUseCase(homeScreenActivity, this.shouldRateLastOrderUseCaseProvider.get());
        injectCoroutineDispatchersFactory(homeScreenActivity, this.coroutineDispatchersFactoryProvider.get());
        injectCustomerRepository(homeScreenActivity, this.customerRepositoryProvider.get());
        injectFactory(homeScreenActivity, this.factoryProvider.get());
        injectCobrandedVmFactory(homeScreenActivity, this.cobrandedVmFactoryProvider.get());
        injectIsOnboardingExperimentEnabledUseCase(homeScreenActivity, this.isOnboardingExperimentEnabledUseCaseProvider.get());
        injectIsNfvFlutterNavigationUsecase(homeScreenActivity, this.isNfvFlutterNavigationUsecaseProvider.get());
    }
}
