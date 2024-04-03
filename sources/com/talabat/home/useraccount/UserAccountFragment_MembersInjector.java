package com.talabat.home.useraccount;

import com.talabat.configuration.ConfigurationLocalRepository;
import com.talabat.configuration.location.LocationConfigurationRepository;
import com.talabat.core.deeplink.domain.DeepLinkNavigator;
import com.talabat.core.dispatcher.domain.CoroutineDispatchersFactory;
import com.talabat.core.dispatcher.domain.RxSchedulersFactory;
import com.talabat.core.experiment.domain.ITalabatExperiment;
import com.talabat.core.featureflag.domain.ITalabatFeatureFlag;
import com.talabat.core.navigation.domain.Navigator;
import com.talabat.core.observabilityNew.domain.IAppLaunchTrackingManager;
import com.talabat.core.observabilityNew.domain.IObservabilityManager;
import com.talabat.core.observabilityNew.domain.IScreenTracker;
import com.talabat.core.tracking.domain.TalabatTracker;
import com.talabat.customer.domain.CustomerRepository;
import com.talabat.feature.bnplcore.domain.usecase.GetOverdueUseCase;
import com.talabat.feature.bnplcore.domain.usecase.SendNavigationOptionLoadedEventUseCase;
import com.talabat.feature.bnplcore.domain.usecase.impl.IsUserBNPLEligibleUseCase;
import com.talabat.feature.cancellationpolicy.domain.IHelpCenterDeeplinkBuilder;
import com.talabat.feature.subscriptions.domain.ISubscriptionStatusRepository;
import com.talabat.feature.subscriptions.domain.ISubscriptionsFeatureFlagsRepository;
import com.talabat.feature.subscriptions.domain.ISubscriptionsTracker;
import com.talabat.feature.subscriptions.domain.usecase.GetSavingsInfoUseCase;
import com.talabat.feature.subscriptions.domain.usecase.UpdateAutoRenewalUseCase;
import com.talabat.feature.walletcobrandedcc.presentation.CobrandedCcViewModelFactory;
import com.talabat.growth.ui.vouchers.entrypoint.viewmodel.VoucherEntryPointViewModelFactory;
import dagger.MembersInjector;
import dagger.internal.DaggerGenerated;
import dagger.internal.InjectedFieldSignature;
import dagger.internal.QualifierMetadata;
import javax.inject.Provider;

@QualifierMetadata
@DaggerGenerated
public final class UserAccountFragment_MembersInjector implements MembersInjector<UserAccountFragment> {
    private final Provider<IAppLaunchTrackingManager> appLaunchTrackingManagerProvider;
    private final Provider<CobrandedCcViewModelFactory> cobrandedCcViewModelFactoryProvider;
    private final Provider<ConfigurationLocalRepository> configurationRepositoryProvider;
    private final Provider<CoroutineDispatchersFactory> coroutineDispatchersFactoryProvider;
    private final Provider<CustomerRepository> customerRepositoryProvider;
    private final Provider<DeepLinkNavigator> deepLinkNavigatorProvider;
    private final Provider<ITalabatExperiment> experimentProvider;
    private final Provider<VoucherEntryPointViewModelFactory> factoryProvider;
    private final Provider<ITalabatFeatureFlag> featureFlagRepoProvider;
    private final Provider<GetOverdueUseCase> getOverdueUseCaseProvider;
    private final Provider<GetSavingsInfoUseCase> getSubscriptionsSavingsInfoProvider;
    private final Provider<IHelpCenterDeeplinkBuilder> helpCenterDeeplinkBuilderProvider;
    private final Provider<IsUserBNPLEligibleUseCase> isUserBNPLEligibleUseCaseProvider;
    private final Provider<LocationConfigurationRepository> locationConfigurationRepositoryProvider;
    private final Provider<Navigator> navigatorProvider;
    private final Provider<IObservabilityManager> observabilityManagerProvider;
    private final Provider<RxSchedulersFactory> schedulersFactoryProvider;
    private final Provider<IScreenTracker> screenTrackerProvider;
    private final Provider<SendNavigationOptionLoadedEventUseCase> sendNavigationOptionLoadedEventUsecaseProvider;
    private final Provider<ISubscriptionStatusRepository> subscriptionStatusRepositoryProvider;
    private final Provider<ISubscriptionsTracker> subscriptionTrackerProvider;
    private final Provider<ISubscriptionsFeatureFlagsRepository> subscriptionsFeatureFlagRepoProvider;
    private final Provider<TalabatTracker> talabatTrackerProvider;
    private final Provider<UpdateAutoRenewalUseCase> updateAutoRenewalUseCaseProvider;

    public UserAccountFragment_MembersInjector(Provider<IAppLaunchTrackingManager> provider, Provider<ConfigurationLocalRepository> provider2, Provider<LocationConfigurationRepository> provider3, Provider<ITalabatFeatureFlag> provider4, Provider<ITalabatExperiment> provider5, Provider<IObservabilityManager> provider6, Provider<CustomerRepository> provider7, Provider<ISubscriptionsFeatureFlagsRepository> provider8, Provider<GetSavingsInfoUseCase> provider9, Provider<UpdateAutoRenewalUseCase> provider10, Provider<GetOverdueUseCase> provider11, Provider<SendNavigationOptionLoadedEventUseCase> provider12, Provider<CoroutineDispatchersFactory> provider13, Provider<RxSchedulersFactory> provider14, Provider<IScreenTracker> provider15, Provider<TalabatTracker> provider16, Provider<ISubscriptionStatusRepository> provider17, Provider<ISubscriptionsTracker> provider18, Provider<Navigator> provider19, Provider<IsUserBNPLEligibleUseCase> provider20, Provider<DeepLinkNavigator> provider21, Provider<IHelpCenterDeeplinkBuilder> provider22, Provider<VoucherEntryPointViewModelFactory> provider23, Provider<CobrandedCcViewModelFactory> provider24) {
        this.appLaunchTrackingManagerProvider = provider;
        this.configurationRepositoryProvider = provider2;
        this.locationConfigurationRepositoryProvider = provider3;
        this.featureFlagRepoProvider = provider4;
        this.experimentProvider = provider5;
        this.observabilityManagerProvider = provider6;
        this.customerRepositoryProvider = provider7;
        this.subscriptionsFeatureFlagRepoProvider = provider8;
        this.getSubscriptionsSavingsInfoProvider = provider9;
        this.updateAutoRenewalUseCaseProvider = provider10;
        this.getOverdueUseCaseProvider = provider11;
        this.sendNavigationOptionLoadedEventUsecaseProvider = provider12;
        this.coroutineDispatchersFactoryProvider = provider13;
        this.schedulersFactoryProvider = provider14;
        this.screenTrackerProvider = provider15;
        this.talabatTrackerProvider = provider16;
        this.subscriptionStatusRepositoryProvider = provider17;
        this.subscriptionTrackerProvider = provider18;
        this.navigatorProvider = provider19;
        this.isUserBNPLEligibleUseCaseProvider = provider20;
        this.deepLinkNavigatorProvider = provider21;
        this.helpCenterDeeplinkBuilderProvider = provider22;
        this.factoryProvider = provider23;
        this.cobrandedCcViewModelFactoryProvider = provider24;
    }

    public static MembersInjector<UserAccountFragment> create(Provider<IAppLaunchTrackingManager> provider, Provider<ConfigurationLocalRepository> provider2, Provider<LocationConfigurationRepository> provider3, Provider<ITalabatFeatureFlag> provider4, Provider<ITalabatExperiment> provider5, Provider<IObservabilityManager> provider6, Provider<CustomerRepository> provider7, Provider<ISubscriptionsFeatureFlagsRepository> provider8, Provider<GetSavingsInfoUseCase> provider9, Provider<UpdateAutoRenewalUseCase> provider10, Provider<GetOverdueUseCase> provider11, Provider<SendNavigationOptionLoadedEventUseCase> provider12, Provider<CoroutineDispatchersFactory> provider13, Provider<RxSchedulersFactory> provider14, Provider<IScreenTracker> provider15, Provider<TalabatTracker> provider16, Provider<ISubscriptionStatusRepository> provider17, Provider<ISubscriptionsTracker> provider18, Provider<Navigator> provider19, Provider<IsUserBNPLEligibleUseCase> provider20, Provider<DeepLinkNavigator> provider21, Provider<IHelpCenterDeeplinkBuilder> provider22, Provider<VoucherEntryPointViewModelFactory> provider23, Provider<CobrandedCcViewModelFactory> provider24) {
        return new UserAccountFragment_MembersInjector(provider, provider2, provider3, provider4, provider5, provider6, provider7, provider8, provider9, provider10, provider11, provider12, provider13, provider14, provider15, provider16, provider17, provider18, provider19, provider20, provider21, provider22, provider23, provider24);
    }

    @InjectedFieldSignature("com.talabat.home.useraccount.UserAccountFragment.appLaunchTrackingManager")
    public static void injectAppLaunchTrackingManager(UserAccountFragment userAccountFragment, IAppLaunchTrackingManager iAppLaunchTrackingManager) {
        userAccountFragment.appLaunchTrackingManager = iAppLaunchTrackingManager;
    }

    @InjectedFieldSignature("com.talabat.home.useraccount.UserAccountFragment.cobrandedCcViewModelFactory")
    public static void injectCobrandedCcViewModelFactory(UserAccountFragment userAccountFragment, CobrandedCcViewModelFactory cobrandedCcViewModelFactory) {
        userAccountFragment.cobrandedCcViewModelFactory = cobrandedCcViewModelFactory;
    }

    @InjectedFieldSignature("com.talabat.home.useraccount.UserAccountFragment.configurationRepository")
    public static void injectConfigurationRepository(UserAccountFragment userAccountFragment, ConfigurationLocalRepository configurationLocalRepository) {
        userAccountFragment.configurationRepository = configurationLocalRepository;
    }

    @InjectedFieldSignature("com.talabat.home.useraccount.UserAccountFragment.coroutineDispatchersFactory")
    public static void injectCoroutineDispatchersFactory(UserAccountFragment userAccountFragment, CoroutineDispatchersFactory coroutineDispatchersFactory) {
        userAccountFragment.coroutineDispatchersFactory = coroutineDispatchersFactory;
    }

    @InjectedFieldSignature("com.talabat.home.useraccount.UserAccountFragment.customerRepository")
    public static void injectCustomerRepository(UserAccountFragment userAccountFragment, CustomerRepository customerRepository) {
        userAccountFragment.customerRepository = customerRepository;
    }

    @InjectedFieldSignature("com.talabat.home.useraccount.UserAccountFragment.deepLinkNavigator")
    public static void injectDeepLinkNavigator(UserAccountFragment userAccountFragment, DeepLinkNavigator deepLinkNavigator) {
        userAccountFragment.deepLinkNavigator = deepLinkNavigator;
    }

    @InjectedFieldSignature("com.talabat.home.useraccount.UserAccountFragment.experiment")
    public static void injectExperiment(UserAccountFragment userAccountFragment, ITalabatExperiment iTalabatExperiment) {
        userAccountFragment.experiment = iTalabatExperiment;
    }

    @InjectedFieldSignature("com.talabat.home.useraccount.UserAccountFragment.factory")
    public static void injectFactory(UserAccountFragment userAccountFragment, VoucherEntryPointViewModelFactory voucherEntryPointViewModelFactory) {
        userAccountFragment.factory = voucherEntryPointViewModelFactory;
    }

    @InjectedFieldSignature("com.talabat.home.useraccount.UserAccountFragment.featureFlagRepo")
    public static void injectFeatureFlagRepo(UserAccountFragment userAccountFragment, ITalabatFeatureFlag iTalabatFeatureFlag) {
        userAccountFragment.featureFlagRepo = iTalabatFeatureFlag;
    }

    @InjectedFieldSignature("com.talabat.home.useraccount.UserAccountFragment.getOverdueUseCase")
    public static void injectGetOverdueUseCase(UserAccountFragment userAccountFragment, GetOverdueUseCase getOverdueUseCase) {
        userAccountFragment.getOverdueUseCase = getOverdueUseCase;
    }

    @InjectedFieldSignature("com.talabat.home.useraccount.UserAccountFragment.getSubscriptionsSavingsInfo")
    public static void injectGetSubscriptionsSavingsInfo(UserAccountFragment userAccountFragment, GetSavingsInfoUseCase getSavingsInfoUseCase) {
        userAccountFragment.getSubscriptionsSavingsInfo = getSavingsInfoUseCase;
    }

    @InjectedFieldSignature("com.talabat.home.useraccount.UserAccountFragment.helpCenterDeeplinkBuilder")
    public static void injectHelpCenterDeeplinkBuilder(UserAccountFragment userAccountFragment, IHelpCenterDeeplinkBuilder iHelpCenterDeeplinkBuilder) {
        userAccountFragment.helpCenterDeeplinkBuilder = iHelpCenterDeeplinkBuilder;
    }

    @InjectedFieldSignature("com.talabat.home.useraccount.UserAccountFragment.isUserBNPLEligibleUseCase")
    public static void injectIsUserBNPLEligibleUseCase(UserAccountFragment userAccountFragment, IsUserBNPLEligibleUseCase isUserBNPLEligibleUseCase) {
        userAccountFragment.isUserBNPLEligibleUseCase = isUserBNPLEligibleUseCase;
    }

    @InjectedFieldSignature("com.talabat.home.useraccount.UserAccountFragment.locationConfigurationRepository")
    public static void injectLocationConfigurationRepository(UserAccountFragment userAccountFragment, LocationConfigurationRepository locationConfigurationRepository) {
        userAccountFragment.locationConfigurationRepository = locationConfigurationRepository;
    }

    @InjectedFieldSignature("com.talabat.home.useraccount.UserAccountFragment.navigator")
    public static void injectNavigator(UserAccountFragment userAccountFragment, Navigator navigator) {
        userAccountFragment.navigator = navigator;
    }

    @InjectedFieldSignature("com.talabat.home.useraccount.UserAccountFragment.observabilityManager")
    public static void injectObservabilityManager(UserAccountFragment userAccountFragment, IObservabilityManager iObservabilityManager) {
        userAccountFragment.observabilityManager = iObservabilityManager;
    }

    @InjectedFieldSignature("com.talabat.home.useraccount.UserAccountFragment.schedulersFactory")
    public static void injectSchedulersFactory(UserAccountFragment userAccountFragment, RxSchedulersFactory rxSchedulersFactory) {
        userAccountFragment.schedulersFactory = rxSchedulersFactory;
    }

    @InjectedFieldSignature("com.talabat.home.useraccount.UserAccountFragment.screenTracker")
    public static void injectScreenTracker(UserAccountFragment userAccountFragment, IScreenTracker iScreenTracker) {
        userAccountFragment.screenTracker = iScreenTracker;
    }

    @InjectedFieldSignature("com.talabat.home.useraccount.UserAccountFragment.sendNavigationOptionLoadedEventUsecase")
    public static void injectSendNavigationOptionLoadedEventUsecase(UserAccountFragment userAccountFragment, SendNavigationOptionLoadedEventUseCase sendNavigationOptionLoadedEventUseCase) {
        userAccountFragment.sendNavigationOptionLoadedEventUsecase = sendNavigationOptionLoadedEventUseCase;
    }

    @InjectedFieldSignature("com.talabat.home.useraccount.UserAccountFragment.subscriptionStatusRepository")
    public static void injectSubscriptionStatusRepository(UserAccountFragment userAccountFragment, ISubscriptionStatusRepository iSubscriptionStatusRepository) {
        userAccountFragment.subscriptionStatusRepository = iSubscriptionStatusRepository;
    }

    @InjectedFieldSignature("com.talabat.home.useraccount.UserAccountFragment.subscriptionTracker")
    public static void injectSubscriptionTracker(UserAccountFragment userAccountFragment, ISubscriptionsTracker iSubscriptionsTracker) {
        userAccountFragment.subscriptionTracker = iSubscriptionsTracker;
    }

    @InjectedFieldSignature("com.talabat.home.useraccount.UserAccountFragment.subscriptionsFeatureFlagRepo")
    public static void injectSubscriptionsFeatureFlagRepo(UserAccountFragment userAccountFragment, ISubscriptionsFeatureFlagsRepository iSubscriptionsFeatureFlagsRepository) {
        userAccountFragment.subscriptionsFeatureFlagRepo = iSubscriptionsFeatureFlagsRepository;
    }

    @InjectedFieldSignature("com.talabat.home.useraccount.UserAccountFragment.talabatTracker")
    public static void injectTalabatTracker(UserAccountFragment userAccountFragment, TalabatTracker talabatTracker) {
        userAccountFragment.talabatTracker = talabatTracker;
    }

    @InjectedFieldSignature("com.talabat.home.useraccount.UserAccountFragment.updateAutoRenewalUseCase")
    public static void injectUpdateAutoRenewalUseCase(UserAccountFragment userAccountFragment, UpdateAutoRenewalUseCase updateAutoRenewalUseCase) {
        userAccountFragment.updateAutoRenewalUseCase = updateAutoRenewalUseCase;
    }

    public void injectMembers(UserAccountFragment userAccountFragment) {
        injectAppLaunchTrackingManager(userAccountFragment, this.appLaunchTrackingManagerProvider.get());
        injectConfigurationRepository(userAccountFragment, this.configurationRepositoryProvider.get());
        injectLocationConfigurationRepository(userAccountFragment, this.locationConfigurationRepositoryProvider.get());
        injectFeatureFlagRepo(userAccountFragment, this.featureFlagRepoProvider.get());
        injectExperiment(userAccountFragment, this.experimentProvider.get());
        injectObservabilityManager(userAccountFragment, this.observabilityManagerProvider.get());
        injectCustomerRepository(userAccountFragment, this.customerRepositoryProvider.get());
        injectSubscriptionsFeatureFlagRepo(userAccountFragment, this.subscriptionsFeatureFlagRepoProvider.get());
        injectGetSubscriptionsSavingsInfo(userAccountFragment, this.getSubscriptionsSavingsInfoProvider.get());
        injectUpdateAutoRenewalUseCase(userAccountFragment, this.updateAutoRenewalUseCaseProvider.get());
        injectGetOverdueUseCase(userAccountFragment, this.getOverdueUseCaseProvider.get());
        injectSendNavigationOptionLoadedEventUsecase(userAccountFragment, this.sendNavigationOptionLoadedEventUsecaseProvider.get());
        injectCoroutineDispatchersFactory(userAccountFragment, this.coroutineDispatchersFactoryProvider.get());
        injectSchedulersFactory(userAccountFragment, this.schedulersFactoryProvider.get());
        injectScreenTracker(userAccountFragment, this.screenTrackerProvider.get());
        injectTalabatTracker(userAccountFragment, this.talabatTrackerProvider.get());
        injectSubscriptionStatusRepository(userAccountFragment, this.subscriptionStatusRepositoryProvider.get());
        injectSubscriptionTracker(userAccountFragment, this.subscriptionTrackerProvider.get());
        injectNavigator(userAccountFragment, this.navigatorProvider.get());
        injectIsUserBNPLEligibleUseCase(userAccountFragment, this.isUserBNPLEligibleUseCaseProvider.get());
        injectDeepLinkNavigator(userAccountFragment, this.deepLinkNavigatorProvider.get());
        injectHelpCenterDeeplinkBuilder(userAccountFragment, this.helpCenterDeeplinkBuilderProvider.get());
        injectFactory(userAccountFragment, this.factoryProvider.get());
        injectCobrandedCcViewModelFactory(userAccountFragment, this.cobrandedCcViewModelFactoryProvider.get());
    }
}
