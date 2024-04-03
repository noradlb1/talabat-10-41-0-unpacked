package com.talabat.home.di;

import android.content.Context;
import com.google.errorprone.annotations.CanIgnoreReturnValue;
import com.talabat.configuration.ConfigurationLocalRepository;
import com.talabat.configuration.MutableLocationConfigurationRepository;
import com.talabat.configuration.di.ConfigurationLocalCoreLibApi;
import com.talabat.configuration.di.MutableConfigurationRemoteCoreLibApi;
import com.talabat.configuration.discovery.AppVersionProvider;
import com.talabat.core.context.domain.ContextCoreLibApi;
import com.talabat.core.deeplink.domain.DeepLinkCoreLibApi;
import com.talabat.core.deeplink.domain.DeepLinkNavigator;
import com.talabat.core.dispatcher.domain.CoroutineDispatchersFactory;
import com.talabat.core.dispatcher.domain.DispatcherCoreLibApi;
import com.talabat.core.experiment.domain.ExperimentCoreLibApi;
import com.talabat.core.experiment.domain.ITalabatExperiment;
import com.talabat.core.featureflag.domain.FeatureFlagCoreLibApi;
import com.talabat.core.featureflag.domain.ITalabatFeatureFlag;
import com.talabat.core.navigation.domain.NavigationCoreLibApi;
import com.talabat.core.navigation.domain.Navigator;
import com.talabat.core.observabilityNew.domain.IObservabilityManager;
import com.talabat.core.observabilityNew.domain.IScreenTracker;
import com.talabat.core.observabilityNew.domain.ObservabilityCoreLibApi;
import com.talabat.core.tracking.domain.TalabatTracker;
import com.talabat.core.tracking.domain.TrackingCoreLibApi;
import com.talabat.customer.domain.CustomerRepository;
import com.talabat.customer.domain.di.CustomerCoreLibApi;
import com.talabat.di.voucher.VoucherRepositoryModule_Companion_ProvideGrowthTrackerFactory;
import com.talabat.di.voucher.VoucherRepositoryModule_Companion_ProvideVoucherRepositoryImplFactory;
import com.talabat.feature.activecarts.domain.di.ActiveCartsApi;
import com.talabat.feature.bnplcore.domain.BnplCoreFeatureApi;
import com.talabat.feature.bnplcore.domain.usecase.GetOverdueNotificationAcknowledgeUseCase;
import com.talabat.feature.bnplcore.domain.usecase.GetOverdueUseCase;
import com.talabat.feature.bnplcore.domain.usecase.UpdateOverdueAcknowledgeStateUseCase;
import com.talabat.feature.darkstores.domain.DarkstoresFeatureApi;
import com.talabat.feature.darkstores.domain.navigator.DarkstoresNavigator;
import com.talabat.feature.rating.domain.RatingFeatureApi;
import com.talabat.feature.rating.domain.repo.RatingSession;
import com.talabat.feature.rating.domain.usecase.ShouldRateLastOrderUseCase;
import com.talabat.feature.tpro.presentation.util.SubscriptionSharedPrefManager;
import com.talabat.feature.ulcampaign.domain.CampaignMigratorFeatureApi;
import com.talabat.feature.ulcampaign.domain.CampaignMigratorSharedPreferences;
import com.talabat.feature.walletcobrandedcc.domain.WalletCobrandedCcFeatureApi;
import com.talabat.feature.walletcobrandedcc.domain.usecase.GetWalletStatusUseCase;
import com.talabat.feature.walletcobrandedcc.domain.usecase.ShowCobrandedNotificationUseCase;
import com.talabat.feature.walletcobrandedcc.presentation.CobrandedCcViewModel;
import com.talabat.feature.walletcobrandedcc.presentation.CobrandedCcViewModelFactory;
import com.talabat.feature.walletcobrandedcc.presentation.CobrandedCcViewModel_Factory;
import com.talabat.fluid.homescreen.domain.tracking.observability.HomeScreenPerformanceObservability;
import com.talabat.fluid.homescreen.ui.fragment.di.modules.FluidHomeScreenObservabilityModule;
import com.talabat.fluid.homescreen.ui.fragment.di.modules.FluidHomeScreenObservabilityModule_ProvideHomeScreenPerformanceObservabilityFactory;
import com.talabat.growth.ui.vouchers.entrypoint.viewmodel.VoucherEntryPointViewModel;
import com.talabat.growth.ui.vouchers.entrypoint.viewmodel.VoucherEntryPointViewModelFactory;
import com.talabat.growth.ui.vouchers.entrypoint.viewmodel.VoucherEntryPointViewModel_Factory;
import com.talabat.home.HomeScreenActivity;
import com.talabat.home.HomeScreenActivity_MembersInjector;
import com.talabat.home.di.HomeScreenActivityComponent;
import com.talabat.onboarding.domain.di.OnBoardingExperimentApi;
import com.talabat.onboarding.domain.usecase.IsOnboardingExperimentEnabledUseCase;
import com.talabat.talabatcommon.feature.vouchers.loyalty.domain.ActiveVouchersUseCase;
import com.talabat.talabatcommon.feature.vouchers.loyalty.domain.ActiveVouchersUseCase_Factory;
import com.talabat.talabatcommon.feature.vouchers.loyalty.domain.VoucherCountTextUseCase;
import com.talabat.talabatcommon.feature.vouchers.loyalty.domain.VoucherCountTextUseCase_Factory;
import com.talabat.talabatcommon.feature.vouchers.loyalty.repository.VoucherRepositoryImpl;
import com.talabat.talabatcommon.feature.vouchers.loyalty.tracking.GrowthTracker;
import dagger.internal.DaggerGenerated;
import dagger.internal.InstanceFactory;
import dagger.internal.Preconditions;
import dagger.internal.SingleCheck;
import javax.inject.Provider;
import library.talabat.mvp.home.IsNfvFlutterNavigationUsecase;
import library.talabat.mvp.home.IsNfvFlutterNavigationUsecaseImpl;
import library.talabat.mvp.home.IsNfvFlutterNavigationUsecaseImpl_Factory;
import library.talabat.mvp.home.domain.GetActiveCartInfoUseCase;

@DaggerGenerated
public final class DaggerHomeScreenActivityComponent {

    public static final class Factory implements HomeScreenActivityComponent.Factory {
        private Factory() {
        }

        public HomeScreenActivityComponent create(ContextCoreLibApi contextCoreLibApi, ActiveCartsApi activeCartsApi, BnplCoreFeatureApi bnplCoreFeatureApi, ConfigurationLocalCoreLibApi configurationLocalCoreLibApi, CustomerCoreLibApi customerCoreLibApi, MutableConfigurationRemoteCoreLibApi mutableConfigurationRemoteCoreLibApi, DarkstoresFeatureApi darkstoresFeatureApi, DeepLinkCoreLibApi deepLinkCoreLibApi, ObservabilityCoreLibApi observabilityCoreLibApi, TrackingCoreLibApi trackingCoreLibApi, FeatureFlagCoreLibApi featureFlagCoreLibApi, RatingFeatureApi ratingFeatureApi, ExperimentCoreLibApi experimentCoreLibApi, CampaignMigratorFeatureApi campaignMigratorFeatureApi, NavigationCoreLibApi navigationCoreLibApi, DispatcherCoreLibApi dispatcherCoreLibApi, OnBoardingExperimentApi onBoardingExperimentApi, WalletCobrandedCcFeatureApi walletCobrandedCcFeatureApi) {
            ActiveCartsApi activeCartsApi2 = activeCartsApi;
            BnplCoreFeatureApi bnplCoreFeatureApi2 = bnplCoreFeatureApi;
            ConfigurationLocalCoreLibApi configurationLocalCoreLibApi2 = configurationLocalCoreLibApi;
            CustomerCoreLibApi customerCoreLibApi2 = customerCoreLibApi;
            MutableConfigurationRemoteCoreLibApi mutableConfigurationRemoteCoreLibApi2 = mutableConfigurationRemoteCoreLibApi;
            DarkstoresFeatureApi darkstoresFeatureApi2 = darkstoresFeatureApi;
            DeepLinkCoreLibApi deepLinkCoreLibApi2 = deepLinkCoreLibApi;
            ObservabilityCoreLibApi observabilityCoreLibApi2 = observabilityCoreLibApi;
            TrackingCoreLibApi trackingCoreLibApi2 = trackingCoreLibApi;
            FeatureFlagCoreLibApi featureFlagCoreLibApi2 = featureFlagCoreLibApi;
            RatingFeatureApi ratingFeatureApi2 = ratingFeatureApi;
            ExperimentCoreLibApi experimentCoreLibApi2 = experimentCoreLibApi;
            CampaignMigratorFeatureApi campaignMigratorFeatureApi2 = campaignMigratorFeatureApi;
            NavigationCoreLibApi navigationCoreLibApi2 = navigationCoreLibApi;
            Preconditions.checkNotNull(contextCoreLibApi);
            Preconditions.checkNotNull(activeCartsApi);
            Preconditions.checkNotNull(bnplCoreFeatureApi);
            Preconditions.checkNotNull(configurationLocalCoreLibApi);
            Preconditions.checkNotNull(customerCoreLibApi);
            Preconditions.checkNotNull(mutableConfigurationRemoteCoreLibApi);
            Preconditions.checkNotNull(darkstoresFeatureApi);
            Preconditions.checkNotNull(deepLinkCoreLibApi);
            Preconditions.checkNotNull(observabilityCoreLibApi);
            Preconditions.checkNotNull(trackingCoreLibApi);
            Preconditions.checkNotNull(featureFlagCoreLibApi);
            Preconditions.checkNotNull(ratingFeatureApi);
            Preconditions.checkNotNull(experimentCoreLibApi);
            Preconditions.checkNotNull(campaignMigratorFeatureApi);
            Preconditions.checkNotNull(navigationCoreLibApi);
            Preconditions.checkNotNull(dispatcherCoreLibApi);
            Preconditions.checkNotNull(onBoardingExperimentApi);
            Preconditions.checkNotNull(walletCobrandedCcFeatureApi);
            FluidHomeScreenObservabilityModule fluidHomeScreenObservabilityModule = r20;
            FluidHomeScreenObservabilityModule fluidHomeScreenObservabilityModule2 = new FluidHomeScreenObservabilityModule();
            return new HomeScreenActivityComponentImpl(fluidHomeScreenObservabilityModule, activeCartsApi2, bnplCoreFeatureApi2, configurationLocalCoreLibApi2, customerCoreLibApi2, mutableConfigurationRemoteCoreLibApi2, darkstoresFeatureApi2, deepLinkCoreLibApi2, observabilityCoreLibApi2, trackingCoreLibApi2, featureFlagCoreLibApi2, ratingFeatureApi2, experimentCoreLibApi2, campaignMigratorFeatureApi2, navigationCoreLibApi2, contextCoreLibApi, dispatcherCoreLibApi, onBoardingExperimentApi, walletCobrandedCcFeatureApi);
        }
    }

    public static final class HomeScreenActivityComponentImpl implements HomeScreenActivityComponent {
        private final ActiveCartsApi activeCartsApi;
        private Provider<ActiveVouchersUseCase> activeVouchersUseCaseProvider;
        private final BnplCoreFeatureApi bnplCoreFeatureApi;
        private final CampaignMigratorFeatureApi campaignMigratorFeatureApi;
        private Provider<CobrandedCcViewModel> cobrandedCcViewModelProvider;
        private final ConfigurationLocalCoreLibApi configurationLocalCoreLibApi;
        private Provider<ConfigurationLocalCoreLibApi> configurationLocalCoreLibApiProvider;
        private final ContextCoreLibApi contextCoreLibApi;
        private final CustomerCoreLibApi customerCoreLibApi;
        private final DarkstoresFeatureApi darkstoresFeatureApi;
        private final DeepLinkCoreLibApi deepLinkCoreLibApi;
        private final DispatcherCoreLibApi dispatcherCoreLibApi;
        private final ExperimentCoreLibApi experimentCoreLibApi;
        private final FeatureFlagCoreLibApi featureFlagCoreLibApi;
        private final FluidHomeScreenObservabilityModule fluidHomeScreenObservabilityModule;
        private Provider<Context> getContextProvider;
        private Provider<CoroutineDispatchersFactory> getCoroutineDispatchersFactoryProvider;
        private Provider<ITalabatExperiment> getExperimentProvider;
        private Provider<IObservabilityManager> getObservabilityManagerProvider;
        private Provider<ITalabatFeatureFlag> getTalabatFeatureFlagProvider;
        private Provider<TalabatTracker> getTalabatTrackerProvider;
        private Provider<GetWalletStatusUseCase> getWalletStatusUseCaseProvider;
        private final HomeScreenActivityComponentImpl homeScreenActivityComponentImpl;
        private Provider<IsNfvFlutterNavigationUsecaseImpl> isNfvFlutterNavigationUsecaseImplProvider;
        private final MutableConfigurationRemoteCoreLibApi mutableConfigurationRemoteCoreLibApi;
        private final NavigationCoreLibApi navigationCoreLibApi;
        private final ObservabilityCoreLibApi observabilityCoreLibApi;
        private final OnBoardingExperimentApi onBoardingExperimentApi;
        private Provider<GrowthTracker> provideGrowthTrackerProvider;
        private Provider<IsNfvFlutterNavigationUsecase> provideIsNfvFlutterNavigationUsecaseImplProvider;
        private Provider<VoucherRepositoryImpl> provideVoucherRepositoryImplProvider;
        private final RatingFeatureApi ratingFeatureApi;
        private Provider<ShowCobrandedNotificationUseCase> showCobrandedNotificationUseCaseProvider;
        private final TrackingCoreLibApi trackingCoreLibApi;
        private Provider<VoucherCountTextUseCase> voucherCountTextUseCaseProvider;
        private Provider<VoucherEntryPointViewModel> voucherEntryPointViewModelProvider;

        public static final class GetContextProvider implements Provider<Context> {
            private final ContextCoreLibApi contextCoreLibApi;

            public GetContextProvider(ContextCoreLibApi contextCoreLibApi2) {
                this.contextCoreLibApi = contextCoreLibApi2;
            }

            public Context get() {
                return (Context) Preconditions.checkNotNullFromComponent(this.contextCoreLibApi.getContext());
            }
        }

        public static final class GetCoroutineDispatchersFactoryProvider implements Provider<CoroutineDispatchersFactory> {
            private final DispatcherCoreLibApi dispatcherCoreLibApi;

            public GetCoroutineDispatchersFactoryProvider(DispatcherCoreLibApi dispatcherCoreLibApi2) {
                this.dispatcherCoreLibApi = dispatcherCoreLibApi2;
            }

            public CoroutineDispatchersFactory get() {
                return (CoroutineDispatchersFactory) Preconditions.checkNotNullFromComponent(this.dispatcherCoreLibApi.getCoroutineDispatchersFactory());
            }
        }

        public static final class GetExperimentProviderProvider implements Provider<ITalabatExperiment> {
            private final ExperimentCoreLibApi experimentCoreLibApi;

            public GetExperimentProviderProvider(ExperimentCoreLibApi experimentCoreLibApi2) {
                this.experimentCoreLibApi = experimentCoreLibApi2;
            }

            public ITalabatExperiment get() {
                return (ITalabatExperiment) Preconditions.checkNotNullFromComponent(this.experimentCoreLibApi.getExperimentProvider());
            }
        }

        public static final class GetObservabilityManagerProvider implements Provider<IObservabilityManager> {
            private final ObservabilityCoreLibApi observabilityCoreLibApi;

            public GetObservabilityManagerProvider(ObservabilityCoreLibApi observabilityCoreLibApi2) {
                this.observabilityCoreLibApi = observabilityCoreLibApi2;
            }

            public IObservabilityManager get() {
                return (IObservabilityManager) Preconditions.checkNotNullFromComponent(this.observabilityCoreLibApi.getObservabilityManager());
            }
        }

        public static final class GetTalabatFeatureFlagProvider implements Provider<ITalabatFeatureFlag> {
            private final FeatureFlagCoreLibApi featureFlagCoreLibApi;

            public GetTalabatFeatureFlagProvider(FeatureFlagCoreLibApi featureFlagCoreLibApi2) {
                this.featureFlagCoreLibApi = featureFlagCoreLibApi2;
            }

            public ITalabatFeatureFlag get() {
                return (ITalabatFeatureFlag) Preconditions.checkNotNullFromComponent(this.featureFlagCoreLibApi.getTalabatFeatureFlag());
            }
        }

        public static final class GetTalabatTrackerProvider implements Provider<TalabatTracker> {
            private final TrackingCoreLibApi trackingCoreLibApi;

            public GetTalabatTrackerProvider(TrackingCoreLibApi trackingCoreLibApi2) {
                this.trackingCoreLibApi = trackingCoreLibApi2;
            }

            public TalabatTracker get() {
                return (TalabatTracker) Preconditions.checkNotNullFromComponent(this.trackingCoreLibApi.getTalabatTracker());
            }
        }

        public static final class GetWalletStatusUseCaseProvider implements Provider<GetWalletStatusUseCase> {
            private final WalletCobrandedCcFeatureApi walletCobrandedCcFeatureApi;

            public GetWalletStatusUseCaseProvider(WalletCobrandedCcFeatureApi walletCobrandedCcFeatureApi2) {
                this.walletCobrandedCcFeatureApi = walletCobrandedCcFeatureApi2;
            }

            public GetWalletStatusUseCase get() {
                return (GetWalletStatusUseCase) Preconditions.checkNotNullFromComponent(this.walletCobrandedCcFeatureApi.getWalletStatusUseCase());
            }
        }

        public static final class ShowCobrandedNotificationUseCaseProvider implements Provider<ShowCobrandedNotificationUseCase> {
            private final WalletCobrandedCcFeatureApi walletCobrandedCcFeatureApi;

            public ShowCobrandedNotificationUseCaseProvider(WalletCobrandedCcFeatureApi walletCobrandedCcFeatureApi2) {
                this.walletCobrandedCcFeatureApi = walletCobrandedCcFeatureApi2;
            }

            public ShowCobrandedNotificationUseCase get() {
                return (ShowCobrandedNotificationUseCase) Preconditions.checkNotNullFromComponent(this.walletCobrandedCcFeatureApi.showCobrandedNotificationUseCase());
            }
        }

        private HomeScreenActivityComponentImpl(FluidHomeScreenObservabilityModule fluidHomeScreenObservabilityModule2, ActiveCartsApi activeCartsApi2, BnplCoreFeatureApi bnplCoreFeatureApi2, ConfigurationLocalCoreLibApi configurationLocalCoreLibApi2, CustomerCoreLibApi customerCoreLibApi2, MutableConfigurationRemoteCoreLibApi mutableConfigurationRemoteCoreLibApi2, DarkstoresFeatureApi darkstoresFeatureApi2, DeepLinkCoreLibApi deepLinkCoreLibApi2, ObservabilityCoreLibApi observabilityCoreLibApi2, TrackingCoreLibApi trackingCoreLibApi2, FeatureFlagCoreLibApi featureFlagCoreLibApi2, RatingFeatureApi ratingFeatureApi2, ExperimentCoreLibApi experimentCoreLibApi2, CampaignMigratorFeatureApi campaignMigratorFeatureApi2, NavigationCoreLibApi navigationCoreLibApi2, ContextCoreLibApi contextCoreLibApi2, DispatcherCoreLibApi dispatcherCoreLibApi2, OnBoardingExperimentApi onBoardingExperimentApi2, WalletCobrandedCcFeatureApi walletCobrandedCcFeatureApi) {
            this.homeScreenActivityComponentImpl = this;
            this.mutableConfigurationRemoteCoreLibApi = mutableConfigurationRemoteCoreLibApi2;
            this.trackingCoreLibApi = trackingCoreLibApi2;
            this.configurationLocalCoreLibApi = configurationLocalCoreLibApi2;
            this.observabilityCoreLibApi = observabilityCoreLibApi2;
            this.featureFlagCoreLibApi = featureFlagCoreLibApi2;
            this.experimentCoreLibApi = experimentCoreLibApi2;
            this.ratingFeatureApi = ratingFeatureApi2;
            this.deepLinkCoreLibApi = deepLinkCoreLibApi2;
            this.navigationCoreLibApi = navigationCoreLibApi2;
            this.bnplCoreFeatureApi = bnplCoreFeatureApi2;
            this.campaignMigratorFeatureApi = campaignMigratorFeatureApi2;
            this.activeCartsApi = activeCartsApi2;
            this.darkstoresFeatureApi = darkstoresFeatureApi2;
            this.fluidHomeScreenObservabilityModule = fluidHomeScreenObservabilityModule2;
            this.contextCoreLibApi = contextCoreLibApi2;
            this.dispatcherCoreLibApi = dispatcherCoreLibApi2;
            this.customerCoreLibApi = customerCoreLibApi2;
            this.onBoardingExperimentApi = onBoardingExperimentApi2;
            initialize(fluidHomeScreenObservabilityModule2, activeCartsApi2, bnplCoreFeatureApi2, configurationLocalCoreLibApi2, customerCoreLibApi2, mutableConfigurationRemoteCoreLibApi2, darkstoresFeatureApi2, deepLinkCoreLibApi2, observabilityCoreLibApi2, trackingCoreLibApi2, featureFlagCoreLibApi2, ratingFeatureApi2, experimentCoreLibApi2, campaignMigratorFeatureApi2, navigationCoreLibApi2, contextCoreLibApi2, dispatcherCoreLibApi2, onBoardingExperimentApi2, walletCobrandedCcFeatureApi);
        }

        private CobrandedCcViewModelFactory cobrandedCcViewModelFactory() {
            return new CobrandedCcViewModelFactory(this.cobrandedCcViewModelProvider);
        }

        private HomeScreenPerformanceObservability homeScreenPerformanceObservability() {
            return FluidHomeScreenObservabilityModule_ProvideHomeScreenPerformanceObservabilityFactory.provideHomeScreenPerformanceObservability(this.fluidHomeScreenObservabilityModule, (IObservabilityManager) Preconditions.checkNotNullFromComponent(this.observabilityCoreLibApi.getObservabilityManager()), (ITalabatFeatureFlag) Preconditions.checkNotNullFromComponent(this.featureFlagCoreLibApi.getTalabatFeatureFlag()));
        }

        private void initialize(FluidHomeScreenObservabilityModule fluidHomeScreenObservabilityModule2, ActiveCartsApi activeCartsApi2, BnplCoreFeatureApi bnplCoreFeatureApi2, ConfigurationLocalCoreLibApi configurationLocalCoreLibApi2, CustomerCoreLibApi customerCoreLibApi2, MutableConfigurationRemoteCoreLibApi mutableConfigurationRemoteCoreLibApi2, DarkstoresFeatureApi darkstoresFeatureApi2, DeepLinkCoreLibApi deepLinkCoreLibApi2, ObservabilityCoreLibApi observabilityCoreLibApi2, TrackingCoreLibApi trackingCoreLibApi2, FeatureFlagCoreLibApi featureFlagCoreLibApi2, RatingFeatureApi ratingFeatureApi2, ExperimentCoreLibApi experimentCoreLibApi2, CampaignMigratorFeatureApi campaignMigratorFeatureApi2, NavigationCoreLibApi navigationCoreLibApi2, ContextCoreLibApi contextCoreLibApi2, DispatcherCoreLibApi dispatcherCoreLibApi2, OnBoardingExperimentApi onBoardingExperimentApi2, WalletCobrandedCcFeatureApi walletCobrandedCcFeatureApi) {
            WalletCobrandedCcFeatureApi walletCobrandedCcFeatureApi2 = walletCobrandedCcFeatureApi;
            GetContextProvider getContextProvider2 = new GetContextProvider(contextCoreLibApi2);
            this.getContextProvider = getContextProvider2;
            this.provideVoucherRepositoryImplProvider = SingleCheck.provider(VoucherRepositoryModule_Companion_ProvideVoucherRepositoryImplFactory.create(getContextProvider2));
            GetObservabilityManagerProvider getObservabilityManagerProvider2 = new GetObservabilityManagerProvider(observabilityCoreLibApi2);
            this.getObservabilityManagerProvider = getObservabilityManagerProvider2;
            this.activeVouchersUseCaseProvider = ActiveVouchersUseCase_Factory.create(this.provideVoucherRepositoryImplProvider, getObservabilityManagerProvider2);
            this.voucherCountTextUseCaseProvider = VoucherCountTextUseCase_Factory.create(this.getContextProvider);
            this.configurationLocalCoreLibApiProvider = InstanceFactory.create(configurationLocalCoreLibApi2);
            this.getCoroutineDispatchersFactoryProvider = new GetCoroutineDispatchersFactoryProvider(dispatcherCoreLibApi2);
            this.getTalabatFeatureFlagProvider = new GetTalabatFeatureFlagProvider(featureFlagCoreLibApi2);
            GetTalabatTrackerProvider getTalabatTrackerProvider2 = new GetTalabatTrackerProvider(trackingCoreLibApi2);
            this.getTalabatTrackerProvider = getTalabatTrackerProvider2;
            VoucherRepositoryModule_Companion_ProvideGrowthTrackerFactory create = VoucherRepositoryModule_Companion_ProvideGrowthTrackerFactory.create(getTalabatTrackerProvider2);
            this.provideGrowthTrackerProvider = create;
            this.voucherEntryPointViewModelProvider = VoucherEntryPointViewModel_Factory.create(this.activeVouchersUseCaseProvider, this.voucherCountTextUseCaseProvider, this.configurationLocalCoreLibApiProvider, this.getCoroutineDispatchersFactoryProvider, this.getTalabatFeatureFlagProvider, this.getObservabilityManagerProvider, create);
            this.showCobrandedNotificationUseCaseProvider = new ShowCobrandedNotificationUseCaseProvider(walletCobrandedCcFeatureApi2);
            GetWalletStatusUseCaseProvider getWalletStatusUseCaseProvider2 = new GetWalletStatusUseCaseProvider(walletCobrandedCcFeatureApi2);
            this.getWalletStatusUseCaseProvider = getWalletStatusUseCaseProvider2;
            this.cobrandedCcViewModelProvider = CobrandedCcViewModel_Factory.create(this.showCobrandedNotificationUseCaseProvider, getWalletStatusUseCaseProvider2, this.getTalabatTrackerProvider);
            GetExperimentProviderProvider getExperimentProviderProvider = new GetExperimentProviderProvider(experimentCoreLibApi2);
            this.getExperimentProvider = getExperimentProviderProvider;
            IsNfvFlutterNavigationUsecaseImpl_Factory create2 = IsNfvFlutterNavigationUsecaseImpl_Factory.create(getExperimentProviderProvider);
            this.isNfvFlutterNavigationUsecaseImplProvider = create2;
            this.provideIsNfvFlutterNavigationUsecaseImplProvider = SingleCheck.provider(create2);
        }

        @CanIgnoreReturnValue
        private HomeScreenActivity injectHomeScreenActivity(HomeScreenActivity homeScreenActivity) {
            HomeScreenActivity_MembersInjector.injectAppVersionProvider(homeScreenActivity, (AppVersionProvider) Preconditions.checkNotNullFromComponent(this.mutableConfigurationRemoteCoreLibApi.getAppVersionProvider()));
            HomeScreenActivity_MembersInjector.injectTalabatTracker(homeScreenActivity, (TalabatTracker) Preconditions.checkNotNullFromComponent(this.trackingCoreLibApi.getTalabatTracker()));
            HomeScreenActivity_MembersInjector.injectConfigurationLocalRepository(homeScreenActivity, (ConfigurationLocalRepository) Preconditions.checkNotNullFromComponent(this.configurationLocalCoreLibApi.getRepository()));
            HomeScreenActivity_MembersInjector.injectObservabilityManager(homeScreenActivity, (IObservabilityManager) Preconditions.checkNotNullFromComponent(this.observabilityCoreLibApi.getObservabilityManager()));
            HomeScreenActivity_MembersInjector.injectTalabatFeatureFlag(homeScreenActivity, (ITalabatFeatureFlag) Preconditions.checkNotNullFromComponent(this.featureFlagCoreLibApi.getTalabatFeatureFlag()));
            HomeScreenActivity_MembersInjector.injectTalabatExperiment(homeScreenActivity, (ITalabatExperiment) Preconditions.checkNotNullFromComponent(this.experimentCoreLibApi.getExperimentProvider()));
            HomeScreenActivity_MembersInjector.injectRatingSession(homeScreenActivity, (RatingSession) Preconditions.checkNotNullFromComponent(this.ratingFeatureApi.getRatingSession()));
            HomeScreenActivity_MembersInjector.injectDeepLinkNavigator(homeScreenActivity, (DeepLinkNavigator) Preconditions.checkNotNullFromComponent(this.deepLinkCoreLibApi.getDeepLinkNavigator()));
            HomeScreenActivity_MembersInjector.injectNavigator(homeScreenActivity, (Navigator) Preconditions.checkNotNullFromComponent(this.navigationCoreLibApi.getNavigator()));
            HomeScreenActivity_MembersInjector.injectGetOverdueUseCase(homeScreenActivity, (GetOverdueUseCase) Preconditions.checkNotNullFromComponent(this.bnplCoreFeatureApi.getBnplOverduesUseCase()));
            HomeScreenActivity_MembersInjector.injectGetOverdueNotificationAcknowledgeUseCase(homeScreenActivity, (GetOverdueNotificationAcknowledgeUseCase) Preconditions.checkNotNullFromComponent(this.bnplCoreFeatureApi.getOverdueNotificationAcknowledgeUseCase()));
            HomeScreenActivity_MembersInjector.injectUpdateOverdueAcknowledgeStateUseCase(homeScreenActivity, (UpdateOverdueAcknowledgeStateUseCase) Preconditions.checkNotNullFromComponent(this.bnplCoreFeatureApi.updateOverdueAcknowledgeStateUseCase()));
            HomeScreenActivity_MembersInjector.injectCampaignMigratorSharedPreferences(homeScreenActivity, (CampaignMigratorSharedPreferences) Preconditions.checkNotNullFromComponent(this.campaignMigratorFeatureApi.getCampaignMigratorSharedPreferences()));
            HomeScreenActivity_MembersInjector.injectGetActiveCartInfoUseCase(homeScreenActivity, (GetActiveCartInfoUseCase) Preconditions.checkNotNullFromComponent(this.activeCartsApi.getActiveCartInfoUseCase()));
            HomeScreenActivity_MembersInjector.injectDarkstoresNavigator(homeScreenActivity, (DarkstoresNavigator) Preconditions.checkNotNullFromComponent(this.darkstoresFeatureApi.darkstoresNavigator()));
            HomeScreenActivity_MembersInjector.injectHomeScreenPerformanceObservability(homeScreenActivity, homeScreenPerformanceObservability());
            HomeScreenActivity_MembersInjector.injectSubscriptionSharedPrefManager(homeScreenActivity, subscriptionSharedPrefManager());
            HomeScreenActivity_MembersInjector.injectMutableLocationConfigurationRepository(homeScreenActivity, (MutableLocationConfigurationRepository) Preconditions.checkNotNullFromComponent(this.mutableConfigurationRemoteCoreLibApi.getMutableLocationConfigurationRepository()));
            HomeScreenActivity_MembersInjector.injectScreenTracker(homeScreenActivity, (IScreenTracker) Preconditions.checkNotNullFromComponent(this.observabilityCoreLibApi.getScreenTracker()));
            HomeScreenActivity_MembersInjector.injectShouldRateLastOrderUseCase(homeScreenActivity, (ShouldRateLastOrderUseCase) Preconditions.checkNotNullFromComponent(this.ratingFeatureApi.getShouldRateLastOrderUseCase()));
            HomeScreenActivity_MembersInjector.injectCoroutineDispatchersFactory(homeScreenActivity, (CoroutineDispatchersFactory) Preconditions.checkNotNullFromComponent(this.dispatcherCoreLibApi.getCoroutineDispatchersFactory()));
            HomeScreenActivity_MembersInjector.injectCustomerRepository(homeScreenActivity, (CustomerRepository) Preconditions.checkNotNullFromComponent(this.customerCoreLibApi.getRepository()));
            HomeScreenActivity_MembersInjector.injectFactory(homeScreenActivity, voucherEntryPointViewModelFactory());
            HomeScreenActivity_MembersInjector.injectCobrandedVmFactory(homeScreenActivity, cobrandedCcViewModelFactory());
            HomeScreenActivity_MembersInjector.injectIsOnboardingExperimentEnabledUseCase(homeScreenActivity, (IsOnboardingExperimentEnabledUseCase) Preconditions.checkNotNullFromComponent(this.onBoardingExperimentApi.isOnboardingExperimentEnabledUseCase()));
            HomeScreenActivity_MembersInjector.injectIsNfvFlutterNavigationUsecase(homeScreenActivity, this.provideIsNfvFlutterNavigationUsecaseImplProvider.get());
            return homeScreenActivity;
        }

        private SubscriptionSharedPrefManager subscriptionSharedPrefManager() {
            return new SubscriptionSharedPrefManager((Context) Preconditions.checkNotNullFromComponent(this.contextCoreLibApi.getContext()));
        }

        private VoucherEntryPointViewModelFactory voucherEntryPointViewModelFactory() {
            return new VoucherEntryPointViewModelFactory(this.voucherEntryPointViewModelProvider);
        }

        public void inject(HomeScreenActivity homeScreenActivity) {
            injectHomeScreenActivity(homeScreenActivity);
        }
    }

    private DaggerHomeScreenActivityComponent() {
    }

    public static HomeScreenActivityComponent.Factory factory() {
        return new Factory();
    }
}
