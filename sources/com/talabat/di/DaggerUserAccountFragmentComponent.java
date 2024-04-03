package com.talabat.di;

import android.content.Context;
import com.google.errorprone.annotations.CanIgnoreReturnValue;
import com.talabat.configuration.ConfigurationLocalRepository;
import com.talabat.configuration.di.ConfigurationLocalCoreLibApi;
import com.talabat.configuration.di.ConfigurationRemoteCoreLibApi;
import com.talabat.configuration.location.LocationConfigurationRepository;
import com.talabat.core.context.domain.ContextCoreLibApi;
import com.talabat.core.deeplink.domain.DeepLinkCoreLibApi;
import com.talabat.core.deeplink.domain.DeepLinkNavigator;
import com.talabat.core.dispatcher.domain.CoroutineDispatchersFactory;
import com.talabat.core.dispatcher.domain.DispatcherCoreLibApi;
import com.talabat.core.dispatcher.domain.RxSchedulersFactory;
import com.talabat.core.experiment.domain.ExperimentCoreLibApi;
import com.talabat.core.experiment.domain.ITalabatExperiment;
import com.talabat.core.featureflag.domain.FeatureFlagCoreLibApi;
import com.talabat.core.featureflag.domain.ITalabatFeatureFlag;
import com.talabat.core.navigation.domain.NavigationCoreLibApi;
import com.talabat.core.navigation.domain.Navigator;
import com.talabat.core.observabilityNew.domain.IAppLaunchTrackingManager;
import com.talabat.core.observabilityNew.domain.IObservabilityManager;
import com.talabat.core.observabilityNew.domain.IScreenTracker;
import com.talabat.core.observabilityNew.domain.ObservabilityCoreLibApi;
import com.talabat.core.tracking.domain.TalabatTracker;
import com.talabat.core.tracking.domain.TrackingCoreLibApi;
import com.talabat.customer.domain.CustomerRepository;
import com.talabat.customer.domain.di.CustomerCoreLibApi;
import com.talabat.di.UserAccountFragmentComponent;
import com.talabat.di.voucher.VoucherRepositoryModule_Companion_ProvideGrowthTrackerFactory;
import com.talabat.di.voucher.VoucherRepositoryModule_Companion_ProvideVoucherRepositoryImplFactory;
import com.talabat.feature.bnplcore.domain.BnplCoreFeatureApi;
import com.talabat.feature.bnplcore.domain.usecase.GetOverdueUseCase;
import com.talabat.feature.bnplcore.domain.usecase.SendNavigationOptionLoadedEventUseCase;
import com.talabat.feature.bnplcore.domain.usecase.impl.IsUserBNPLEligibleUseCase;
import com.talabat.feature.cancellationpolicy.domain.HelpCenterFeatureApi;
import com.talabat.feature.cancellationpolicy.domain.IHelpCenterDeeplinkBuilder;
import com.talabat.feature.subscriptions.domain.ISubscriptionStatusRepository;
import com.talabat.feature.subscriptions.domain.ISubscriptionsFeatureFlagsRepository;
import com.talabat.feature.subscriptions.domain.ISubscriptionsRepository;
import com.talabat.feature.subscriptions.domain.ISubscriptionsTracker;
import com.talabat.feature.subscriptions.domain.di.SubscriptionsFeatureApi;
import com.talabat.feature.subscriptions.domain.usecase.GetSavingsInfoUseCase;
import com.talabat.feature.subscriptions.domain.usecase.GetSubscriptionsUseCase;
import com.talabat.feature.subscriptions.domain.usecase.UpdateAutoRenewalUseCase;
import com.talabat.feature.walletcobrandedcc.domain.WalletCobrandedCcFeatureApi;
import com.talabat.feature.walletcobrandedcc.domain.usecase.GetWalletStatusUseCase;
import com.talabat.feature.walletcobrandedcc.domain.usecase.ShowCobrandedNotificationUseCase;
import com.talabat.feature.walletcobrandedcc.presentation.CobrandedCcViewModel;
import com.talabat.feature.walletcobrandedcc.presentation.CobrandedCcViewModelFactory;
import com.talabat.feature.walletcobrandedcc.presentation.CobrandedCcViewModel_Factory;
import com.talabat.growth.ui.vouchers.entrypoint.viewmodel.VoucherEntryPointViewModel;
import com.talabat.growth.ui.vouchers.entrypoint.viewmodel.VoucherEntryPointViewModelFactory;
import com.talabat.growth.ui.vouchers.entrypoint.viewmodel.VoucherEntryPointViewModel_Factory;
import com.talabat.home.useraccount.UserAccountFragment;
import com.talabat.home.useraccount.UserAccountFragment_MembersInjector;
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

@DaggerGenerated
public final class DaggerUserAccountFragmentComponent {

    public static final class Factory implements UserAccountFragmentComponent.Factory {
        private Factory() {
        }

        public UserAccountFragmentComponent create(ContextCoreLibApi contextCoreLibApi, BnplCoreFeatureApi bnplCoreFeatureApi, ConfigurationLocalCoreLibApi configurationLocalCoreLibApi, ConfigurationRemoteCoreLibApi configurationRemoteCoreLibApi, DeepLinkCoreLibApi deepLinkCoreLibApi, FeatureFlagCoreLibApi featureFlagCoreLibApi, ExperimentCoreLibApi experimentCoreLibApi, ObservabilityCoreLibApi observabilityCoreLibApi, SubscriptionsFeatureApi subscriptionsFeatureApi, DispatcherCoreLibApi dispatcherCoreLibApi, CustomerCoreLibApi customerCoreLibApi, NavigationCoreLibApi navigationCoreLibApi, HelpCenterFeatureApi helpCenterFeatureApi, TrackingCoreLibApi trackingCoreLibApi, WalletCobrandedCcFeatureApi walletCobrandedCcFeatureApi) {
            BnplCoreFeatureApi bnplCoreFeatureApi2 = bnplCoreFeatureApi;
            ConfigurationLocalCoreLibApi configurationLocalCoreLibApi2 = configurationLocalCoreLibApi;
            ConfigurationRemoteCoreLibApi configurationRemoteCoreLibApi2 = configurationRemoteCoreLibApi;
            DeepLinkCoreLibApi deepLinkCoreLibApi2 = deepLinkCoreLibApi;
            FeatureFlagCoreLibApi featureFlagCoreLibApi2 = featureFlagCoreLibApi;
            ExperimentCoreLibApi experimentCoreLibApi2 = experimentCoreLibApi;
            ObservabilityCoreLibApi observabilityCoreLibApi2 = observabilityCoreLibApi;
            SubscriptionsFeatureApi subscriptionsFeatureApi2 = subscriptionsFeatureApi;
            DispatcherCoreLibApi dispatcherCoreLibApi2 = dispatcherCoreLibApi;
            CustomerCoreLibApi customerCoreLibApi2 = customerCoreLibApi;
            NavigationCoreLibApi navigationCoreLibApi2 = navigationCoreLibApi;
            HelpCenterFeatureApi helpCenterFeatureApi2 = helpCenterFeatureApi;
            Preconditions.checkNotNull(contextCoreLibApi);
            Preconditions.checkNotNull(bnplCoreFeatureApi);
            Preconditions.checkNotNull(configurationLocalCoreLibApi);
            Preconditions.checkNotNull(configurationRemoteCoreLibApi);
            Preconditions.checkNotNull(deepLinkCoreLibApi);
            Preconditions.checkNotNull(featureFlagCoreLibApi);
            Preconditions.checkNotNull(experimentCoreLibApi);
            Preconditions.checkNotNull(observabilityCoreLibApi);
            Preconditions.checkNotNull(subscriptionsFeatureApi);
            Preconditions.checkNotNull(dispatcherCoreLibApi);
            Preconditions.checkNotNull(customerCoreLibApi);
            Preconditions.checkNotNull(navigationCoreLibApi);
            Preconditions.checkNotNull(helpCenterFeatureApi);
            Preconditions.checkNotNull(trackingCoreLibApi);
            Preconditions.checkNotNull(walletCobrandedCcFeatureApi);
            return new UserAccountFragmentComponentImpl(bnplCoreFeatureApi2, configurationLocalCoreLibApi2, configurationRemoteCoreLibApi2, featureFlagCoreLibApi2, experimentCoreLibApi2, observabilityCoreLibApi2, subscriptionsFeatureApi2, dispatcherCoreLibApi2, customerCoreLibApi2, navigationCoreLibApi2, deepLinkCoreLibApi2, helpCenterFeatureApi2, contextCoreLibApi, trackingCoreLibApi, walletCobrandedCcFeatureApi);
        }
    }

    public static final class UserAccountFragmentComponentImpl implements UserAccountFragmentComponent {
        private Provider<ActiveVouchersUseCase> activeVouchersUseCaseProvider;
        private final BnplCoreFeatureApi bnplCoreFeatureApi;
        private Provider<CobrandedCcViewModel> cobrandedCcViewModelProvider;
        private final ConfigurationLocalCoreLibApi configurationLocalCoreLibApi;
        private Provider<ConfigurationLocalCoreLibApi> configurationLocalCoreLibApiProvider;
        private final ConfigurationRemoteCoreLibApi configurationRemoteCoreLibApi;
        private final CustomerCoreLibApi customerCoreLibApi;
        private final DeepLinkCoreLibApi deepLinkCoreLibApi;
        private final DispatcherCoreLibApi dispatcherCoreLibApi;
        private final ExperimentCoreLibApi experimentCoreLibApi;
        private final FeatureFlagCoreLibApi featureFlagCoreLibApi;
        private Provider<Context> getContextProvider;
        private Provider<CoroutineDispatchersFactory> getCoroutineDispatchersFactoryProvider;
        private Provider<IObservabilityManager> getObservabilityManagerProvider;
        private Provider<ITalabatFeatureFlag> getTalabatFeatureFlagProvider;
        private Provider<TalabatTracker> getTalabatTrackerProvider;
        private Provider<GetWalletStatusUseCase> getWalletStatusUseCaseProvider;
        private final HelpCenterFeatureApi helpCenterFeatureApi;
        private final NavigationCoreLibApi navigationCoreLibApi;
        private final ObservabilityCoreLibApi observabilityCoreLibApi;
        private Provider<GrowthTracker> provideGrowthTrackerProvider;
        private Provider<VoucherRepositoryImpl> provideVoucherRepositoryImplProvider;
        private Provider<ShowCobrandedNotificationUseCase> showCobrandedNotificationUseCaseProvider;
        private final SubscriptionsFeatureApi subscriptionsFeatureApi;
        private final TrackingCoreLibApi trackingCoreLibApi;
        private final UserAccountFragmentComponentImpl userAccountFragmentComponentImpl;
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

        private UserAccountFragmentComponentImpl(BnplCoreFeatureApi bnplCoreFeatureApi2, ConfigurationLocalCoreLibApi configurationLocalCoreLibApi2, ConfigurationRemoteCoreLibApi configurationRemoteCoreLibApi2, FeatureFlagCoreLibApi featureFlagCoreLibApi2, ExperimentCoreLibApi experimentCoreLibApi2, ObservabilityCoreLibApi observabilityCoreLibApi2, SubscriptionsFeatureApi subscriptionsFeatureApi2, DispatcherCoreLibApi dispatcherCoreLibApi2, CustomerCoreLibApi customerCoreLibApi2, NavigationCoreLibApi navigationCoreLibApi2, DeepLinkCoreLibApi deepLinkCoreLibApi2, HelpCenterFeatureApi helpCenterFeatureApi2, ContextCoreLibApi contextCoreLibApi, TrackingCoreLibApi trackingCoreLibApi2, WalletCobrandedCcFeatureApi walletCobrandedCcFeatureApi) {
            this.userAccountFragmentComponentImpl = this;
            this.observabilityCoreLibApi = observabilityCoreLibApi2;
            this.configurationLocalCoreLibApi = configurationLocalCoreLibApi2;
            this.configurationRemoteCoreLibApi = configurationRemoteCoreLibApi2;
            this.featureFlagCoreLibApi = featureFlagCoreLibApi2;
            this.experimentCoreLibApi = experimentCoreLibApi2;
            this.customerCoreLibApi = customerCoreLibApi2;
            this.subscriptionsFeatureApi = subscriptionsFeatureApi2;
            this.bnplCoreFeatureApi = bnplCoreFeatureApi2;
            this.dispatcherCoreLibApi = dispatcherCoreLibApi2;
            this.trackingCoreLibApi = trackingCoreLibApi2;
            this.navigationCoreLibApi = navigationCoreLibApi2;
            this.deepLinkCoreLibApi = deepLinkCoreLibApi2;
            this.helpCenterFeatureApi = helpCenterFeatureApi2;
            initialize(bnplCoreFeatureApi2, configurationLocalCoreLibApi2, configurationRemoteCoreLibApi2, featureFlagCoreLibApi2, experimentCoreLibApi2, observabilityCoreLibApi2, subscriptionsFeatureApi2, dispatcherCoreLibApi2, customerCoreLibApi2, navigationCoreLibApi2, deepLinkCoreLibApi2, helpCenterFeatureApi2, contextCoreLibApi, trackingCoreLibApi2, walletCobrandedCcFeatureApi);
        }

        private CobrandedCcViewModelFactory cobrandedCcViewModelFactory() {
            return new CobrandedCcViewModelFactory(this.cobrandedCcViewModelProvider);
        }

        private GetSavingsInfoUseCase getSavingsInfoUseCase() {
            return new GetSavingsInfoUseCase((ISubscriptionsRepository) Preconditions.checkNotNullFromComponent(this.subscriptionsFeatureApi.getRepository()));
        }

        private GetSubscriptionsUseCase getSubscriptionsUseCase() {
            return new GetSubscriptionsUseCase((ISubscriptionsRepository) Preconditions.checkNotNullFromComponent(this.subscriptionsFeatureApi.getRepository()), (ConfigurationLocalRepository) Preconditions.checkNotNullFromComponent(this.configurationLocalCoreLibApi.getRepository()));
        }

        private void initialize(BnplCoreFeatureApi bnplCoreFeatureApi2, ConfigurationLocalCoreLibApi configurationLocalCoreLibApi2, ConfigurationRemoteCoreLibApi configurationRemoteCoreLibApi2, FeatureFlagCoreLibApi featureFlagCoreLibApi2, ExperimentCoreLibApi experimentCoreLibApi2, ObservabilityCoreLibApi observabilityCoreLibApi2, SubscriptionsFeatureApi subscriptionsFeatureApi2, DispatcherCoreLibApi dispatcherCoreLibApi2, CustomerCoreLibApi customerCoreLibApi2, NavigationCoreLibApi navigationCoreLibApi2, DeepLinkCoreLibApi deepLinkCoreLibApi2, HelpCenterFeatureApi helpCenterFeatureApi2, ContextCoreLibApi contextCoreLibApi, TrackingCoreLibApi trackingCoreLibApi2, WalletCobrandedCcFeatureApi walletCobrandedCcFeatureApi) {
            GetContextProvider getContextProvider2 = new GetContextProvider(contextCoreLibApi);
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
            this.showCobrandedNotificationUseCaseProvider = new ShowCobrandedNotificationUseCaseProvider(walletCobrandedCcFeatureApi);
            GetWalletStatusUseCaseProvider getWalletStatusUseCaseProvider2 = new GetWalletStatusUseCaseProvider(walletCobrandedCcFeatureApi);
            this.getWalletStatusUseCaseProvider = getWalletStatusUseCaseProvider2;
            this.cobrandedCcViewModelProvider = CobrandedCcViewModel_Factory.create(this.showCobrandedNotificationUseCaseProvider, getWalletStatusUseCaseProvider2, this.getTalabatTrackerProvider);
        }

        @CanIgnoreReturnValue
        private UserAccountFragment injectUserAccountFragment(UserAccountFragment userAccountFragment) {
            UserAccountFragment_MembersInjector.injectAppLaunchTrackingManager(userAccountFragment, (IAppLaunchTrackingManager) Preconditions.checkNotNullFromComponent(this.observabilityCoreLibApi.getAppLaunchTrackingManager()));
            UserAccountFragment_MembersInjector.injectConfigurationRepository(userAccountFragment, (ConfigurationLocalRepository) Preconditions.checkNotNullFromComponent(this.configurationLocalCoreLibApi.getRepository()));
            UserAccountFragment_MembersInjector.injectLocationConfigurationRepository(userAccountFragment, (LocationConfigurationRepository) Preconditions.checkNotNullFromComponent(this.configurationRemoteCoreLibApi.getLocationConfigurationRepository()));
            UserAccountFragment_MembersInjector.injectFeatureFlagRepo(userAccountFragment, (ITalabatFeatureFlag) Preconditions.checkNotNullFromComponent(this.featureFlagCoreLibApi.getTalabatFeatureFlag()));
            UserAccountFragment_MembersInjector.injectExperiment(userAccountFragment, (ITalabatExperiment) Preconditions.checkNotNullFromComponent(this.experimentCoreLibApi.getExperimentProvider()));
            UserAccountFragment_MembersInjector.injectObservabilityManager(userAccountFragment, (IObservabilityManager) Preconditions.checkNotNullFromComponent(this.observabilityCoreLibApi.getObservabilityManager()));
            UserAccountFragment_MembersInjector.injectCustomerRepository(userAccountFragment, (CustomerRepository) Preconditions.checkNotNullFromComponent(this.customerCoreLibApi.getRepository()));
            UserAccountFragment_MembersInjector.injectSubscriptionsFeatureFlagRepo(userAccountFragment, (ISubscriptionsFeatureFlagsRepository) Preconditions.checkNotNullFromComponent(this.subscriptionsFeatureApi.getSubscriptionsFeatureFlagRepository()));
            UserAccountFragment_MembersInjector.injectGetSubscriptionsSavingsInfo(userAccountFragment, getSavingsInfoUseCase());
            UserAccountFragment_MembersInjector.injectUpdateAutoRenewalUseCase(userAccountFragment, updateAutoRenewalUseCase());
            UserAccountFragment_MembersInjector.injectGetOverdueUseCase(userAccountFragment, (GetOverdueUseCase) Preconditions.checkNotNullFromComponent(this.bnplCoreFeatureApi.getBnplOverduesUseCase()));
            UserAccountFragment_MembersInjector.injectSendNavigationOptionLoadedEventUsecase(userAccountFragment, (SendNavigationOptionLoadedEventUseCase) Preconditions.checkNotNullFromComponent(this.bnplCoreFeatureApi.sendNavigationOptionLoadedEventUseCase()));
            UserAccountFragment_MembersInjector.injectCoroutineDispatchersFactory(userAccountFragment, (CoroutineDispatchersFactory) Preconditions.checkNotNullFromComponent(this.dispatcherCoreLibApi.getCoroutineDispatchersFactory()));
            UserAccountFragment_MembersInjector.injectSchedulersFactory(userAccountFragment, (RxSchedulersFactory) Preconditions.checkNotNullFromComponent(this.dispatcherCoreLibApi.getRxSchedulersFactory()));
            UserAccountFragment_MembersInjector.injectScreenTracker(userAccountFragment, (IScreenTracker) Preconditions.checkNotNullFromComponent(this.observabilityCoreLibApi.getScreenTracker()));
            UserAccountFragment_MembersInjector.injectTalabatTracker(userAccountFragment, (TalabatTracker) Preconditions.checkNotNullFromComponent(this.trackingCoreLibApi.getTalabatTracker()));
            UserAccountFragment_MembersInjector.injectSubscriptionStatusRepository(userAccountFragment, (ISubscriptionStatusRepository) Preconditions.checkNotNullFromComponent(this.subscriptionsFeatureApi.getSubscriptionStatusRepository()));
            UserAccountFragment_MembersInjector.injectSubscriptionTracker(userAccountFragment, (ISubscriptionsTracker) Preconditions.checkNotNullFromComponent(this.subscriptionsFeatureApi.getTracker()));
            UserAccountFragment_MembersInjector.injectNavigator(userAccountFragment, (Navigator) Preconditions.checkNotNullFromComponent(this.navigationCoreLibApi.getNavigator()));
            UserAccountFragment_MembersInjector.injectIsUserBNPLEligibleUseCase(userAccountFragment, (IsUserBNPLEligibleUseCase) Preconditions.checkNotNullFromComponent(this.bnplCoreFeatureApi.isUserBNPLEligibleUseCase()));
            UserAccountFragment_MembersInjector.injectDeepLinkNavigator(userAccountFragment, (DeepLinkNavigator) Preconditions.checkNotNullFromComponent(this.deepLinkCoreLibApi.getDeepLinkNavigator()));
            UserAccountFragment_MembersInjector.injectHelpCenterDeeplinkBuilder(userAccountFragment, (IHelpCenterDeeplinkBuilder) Preconditions.checkNotNullFromComponent(this.helpCenterFeatureApi.getHelpCenterDeeplinkNavigator()));
            UserAccountFragment_MembersInjector.injectFactory(userAccountFragment, voucherEntryPointViewModelFactory());
            UserAccountFragment_MembersInjector.injectCobrandedCcViewModelFactory(userAccountFragment, cobrandedCcViewModelFactory());
            return userAccountFragment;
        }

        private UpdateAutoRenewalUseCase updateAutoRenewalUseCase() {
            return new UpdateAutoRenewalUseCase((ISubscriptionsRepository) Preconditions.checkNotNullFromComponent(this.subscriptionsFeatureApi.getRepository()), (ISubscriptionStatusRepository) Preconditions.checkNotNullFromComponent(this.subscriptionsFeatureApi.getSubscriptionStatusRepository()), getSubscriptionsUseCase(), (ConfigurationLocalRepository) Preconditions.checkNotNullFromComponent(this.configurationLocalCoreLibApi.getRepository()));
        }

        private VoucherEntryPointViewModelFactory voucherEntryPointViewModelFactory() {
            return new VoucherEntryPointViewModelFactory(this.voucherEntryPointViewModelProvider);
        }

        public void inject(UserAccountFragment userAccountFragment) {
            injectUserAccountFragment(userAccountFragment);
        }
    }

    private DaggerUserAccountFragmentComponent() {
    }

    public static UserAccountFragmentComponent.Factory factory() {
        return new Factory();
    }
}
