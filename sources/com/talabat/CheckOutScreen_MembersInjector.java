package com.talabat;

import com.talabat.configuration.ConfigurationLocalRepository;
import com.talabat.configuration.discovery.AppVersionProvider;
import com.talabat.configuration.discovery.DiscoveryConfigurationRepository;
import com.talabat.configuration.location.LocationConfigurationRepository;
import com.talabat.configuration.payment.PaymentConfigurationRepository;
import com.talabat.configuration.tcs.TermsAndConditionsConfigurationRepository;
import com.talabat.core.featureflag.domain.ITalabatFeatureFlag;
import com.talabat.core.observabilityNew.domain.IObservabilityManager;
import com.talabat.core.observabilityNew.domain.IScreenTracker;
import com.talabat.customer.domain.CustomerRepository;
import com.talabat.feature.cancellationpolicy.domain.ICancellationPolicyFlag;
import com.talabat.feature.darkstoresscheduleddelivery.domain.usecase.DarkstoresScheduledDeliveryUseCase;
import com.talabat.feature.darkstoresscheduleddelivery.domain.usecase.IsDarkstoresScheduledDeliveryDiscountEnabledUseCase;
import com.talabat.feature.fees.presentation.viewmodel.FeesViewModelFactory;
import com.talabat.feature.pickup.domain.PickupFeatureApi;
import com.talabat.feature.subscriptions.domain.ISubscriptionStatusRepository;
import com.talabat.feature.subscriptions.domain.ISubscriptionsTracker;
import com.talabat.feature.subscriptions.domain.usecase.GetTProOrderStatusUseCase;
import com.talabat.feature.subscriptions.domain.wrapper.GetActiveSubscriptionsRxWrapper;
import com.talabat.feature.subscriptions.domain.wrapper.PostSubscriptionPaymentRxWrapper;
import com.talabat.maps.domain.CameraUpdateFactory;
import com.talabat.maps.domain.LatLngFactory;
import com.talabat.maps.domain.MapsInitializer;
import com.talabat.maps.domain.ModelsRepository;
import com.talabat.wallet.bnplmanager.data.local.BNPLManagerLocalDataSource;
import dagger.MembersInjector;
import dagger.internal.DaggerGenerated;
import dagger.internal.InjectedFieldSignature;
import dagger.internal.QualifierMetadata;
import javax.inject.Provider;

@QualifierMetadata
@DaggerGenerated
public final class CheckOutScreen_MembersInjector implements MembersInjector<CheckOutScreen> {
    private final Provider<AppVersionProvider> appVersionProvider;
    private final Provider<BNPLManagerLocalDataSource> bnplManagerLocalDataSourceProvider;
    private final Provider<CameraUpdateFactory> cameraUpdateFactoryProvider;
    private final Provider<ICancellationPolicyFlag> cancellationPolicyFlagProvider;
    private final Provider<ConfigurationLocalRepository> configurationLocalRepositoryProvider;
    private final Provider<CustomerRepository> customerRepositoryProvider;
    private final Provider<DarkstoresScheduledDeliveryUseCase> darkstoresScheduledDeliveryUseCaseProvider;
    private final Provider<DiscoveryConfigurationRepository> discoveryConfigurationRepositoryProvider;
    private final Provider<FeesViewModelFactory> feesViewModelFactoryProvider;
    private final Provider<GetActiveSubscriptionsRxWrapper> getActiveSubscriptionsRxWrapperProvider;
    private final Provider<GetTProOrderStatusUseCase> getTProOrderStatusUseCaseProvider;
    private final Provider<IsDarkstoresScheduledDeliveryDiscountEnabledUseCase> isDarkstoresScheduledDeliveryDiscountEnabledUseCaseProvider;
    private final Provider<LatLngFactory> latLngFactoryProvider;
    private final Provider<LocationConfigurationRepository> locationConfigurationRepositoryProvider;
    private final Provider<MapsInitializer> mapsInitializerProvider;
    private final Provider<ModelsRepository> modelsRepositoryProvider;
    private final Provider<IObservabilityManager> observabilityManagerProvider;
    private final Provider<PaymentConfigurationRepository> paymentConfigurationRepositoryProvider;
    private final Provider<PickupFeatureApi> pickupFeatureApiProvider;
    private final Provider<PostSubscriptionPaymentRxWrapper> postSubscriptionPaymentRxWrapperProvider;
    private final Provider<IScreenTracker> screenTrackerProvider;
    private final Provider<ISubscriptionStatusRepository> subscriptionStatusRepositoryProvider;
    private final Provider<ISubscriptionsTracker> subscriptionsTrackerProvider;
    private final Provider<ITalabatFeatureFlag> talabatFeatureFlagProvider;
    private final Provider<TermsAndConditionsConfigurationRepository> termsAndConditionsConfigurationRepositoryProvider;

    public CheckOutScreen_MembersInjector(Provider<AppVersionProvider> provider, Provider<ConfigurationLocalRepository> provider2, Provider<PickupFeatureApi> provider3, Provider<LocationConfigurationRepository> provider4, Provider<DiscoveryConfigurationRepository> provider5, Provider<PaymentConfigurationRepository> provider6, Provider<FeesViewModelFactory> provider7, Provider<IObservabilityManager> provider8, Provider<ITalabatFeatureFlag> provider9, Provider<ISubscriptionsTracker> provider10, Provider<DarkstoresScheduledDeliveryUseCase> provider11, Provider<IsDarkstoresScheduledDeliveryDiscountEnabledUseCase> provider12, Provider<TermsAndConditionsConfigurationRepository> provider13, Provider<GetTProOrderStatusUseCase> provider14, Provider<ModelsRepository> provider15, Provider<LatLngFactory> provider16, Provider<MapsInitializer> provider17, Provider<CameraUpdateFactory> provider18, Provider<CustomerRepository> provider19, Provider<IScreenTracker> provider20, Provider<PostSubscriptionPaymentRxWrapper> provider21, Provider<GetActiveSubscriptionsRxWrapper> provider22, Provider<ISubscriptionStatusRepository> provider23, Provider<ICancellationPolicyFlag> provider24, Provider<BNPLManagerLocalDataSource> provider25) {
        this.appVersionProvider = provider;
        this.configurationLocalRepositoryProvider = provider2;
        this.pickupFeatureApiProvider = provider3;
        this.locationConfigurationRepositoryProvider = provider4;
        this.discoveryConfigurationRepositoryProvider = provider5;
        this.paymentConfigurationRepositoryProvider = provider6;
        this.feesViewModelFactoryProvider = provider7;
        this.observabilityManagerProvider = provider8;
        this.talabatFeatureFlagProvider = provider9;
        this.subscriptionsTrackerProvider = provider10;
        this.darkstoresScheduledDeliveryUseCaseProvider = provider11;
        this.isDarkstoresScheduledDeliveryDiscountEnabledUseCaseProvider = provider12;
        this.termsAndConditionsConfigurationRepositoryProvider = provider13;
        this.getTProOrderStatusUseCaseProvider = provider14;
        this.modelsRepositoryProvider = provider15;
        this.latLngFactoryProvider = provider16;
        this.mapsInitializerProvider = provider17;
        this.cameraUpdateFactoryProvider = provider18;
        this.customerRepositoryProvider = provider19;
        this.screenTrackerProvider = provider20;
        this.postSubscriptionPaymentRxWrapperProvider = provider21;
        this.getActiveSubscriptionsRxWrapperProvider = provider22;
        this.subscriptionStatusRepositoryProvider = provider23;
        this.cancellationPolicyFlagProvider = provider24;
        this.bnplManagerLocalDataSourceProvider = provider25;
    }

    public static MembersInjector<CheckOutScreen> create(Provider<AppVersionProvider> provider, Provider<ConfigurationLocalRepository> provider2, Provider<PickupFeatureApi> provider3, Provider<LocationConfigurationRepository> provider4, Provider<DiscoveryConfigurationRepository> provider5, Provider<PaymentConfigurationRepository> provider6, Provider<FeesViewModelFactory> provider7, Provider<IObservabilityManager> provider8, Provider<ITalabatFeatureFlag> provider9, Provider<ISubscriptionsTracker> provider10, Provider<DarkstoresScheduledDeliveryUseCase> provider11, Provider<IsDarkstoresScheduledDeliveryDiscountEnabledUseCase> provider12, Provider<TermsAndConditionsConfigurationRepository> provider13, Provider<GetTProOrderStatusUseCase> provider14, Provider<ModelsRepository> provider15, Provider<LatLngFactory> provider16, Provider<MapsInitializer> provider17, Provider<CameraUpdateFactory> provider18, Provider<CustomerRepository> provider19, Provider<IScreenTracker> provider20, Provider<PostSubscriptionPaymentRxWrapper> provider21, Provider<GetActiveSubscriptionsRxWrapper> provider22, Provider<ISubscriptionStatusRepository> provider23, Provider<ICancellationPolicyFlag> provider24, Provider<BNPLManagerLocalDataSource> provider25) {
        return new CheckOutScreen_MembersInjector(provider, provider2, provider3, provider4, provider5, provider6, provider7, provider8, provider9, provider10, provider11, provider12, provider13, provider14, provider15, provider16, provider17, provider18, provider19, provider20, provider21, provider22, provider23, provider24, provider25);
    }

    @InjectedFieldSignature("com.talabat.CheckOutScreen.appVersionProvider")
    public static void injectAppVersionProvider(CheckOutScreen checkOutScreen, AppVersionProvider appVersionProvider2) {
        checkOutScreen.D = appVersionProvider2;
    }

    @InjectedFieldSignature("com.talabat.CheckOutScreen.bnplManagerLocalDataSource")
    public static void injectBnplManagerLocalDataSource(CheckOutScreen checkOutScreen, BNPLManagerLocalDataSource bNPLManagerLocalDataSource) {
        checkOutScreen.f53827c0 = bNPLManagerLocalDataSource;
    }

    @InjectedFieldSignature("com.talabat.CheckOutScreen.cameraUpdateFactory")
    public static void injectCameraUpdateFactory(CheckOutScreen checkOutScreen, CameraUpdateFactory cameraUpdateFactory) {
        checkOutScreen.U = cameraUpdateFactory;
    }

    @InjectedFieldSignature("com.talabat.CheckOutScreen.cancellationPolicyFlag")
    public static void injectCancellationPolicyFlag(CheckOutScreen checkOutScreen, ICancellationPolicyFlag iCancellationPolicyFlag) {
        checkOutScreen.f53826b0 = iCancellationPolicyFlag;
    }

    @InjectedFieldSignature("com.talabat.CheckOutScreen.configurationLocalRepository")
    public static void injectConfigurationLocalRepository(CheckOutScreen checkOutScreen, ConfigurationLocalRepository configurationLocalRepository) {
        checkOutScreen.E = configurationLocalRepository;
    }

    @InjectedFieldSignature("com.talabat.CheckOutScreen.customerRepository")
    public static void injectCustomerRepository(CheckOutScreen checkOutScreen, CustomerRepository customerRepository) {
        checkOutScreen.V = customerRepository;
    }

    @InjectedFieldSignature("com.talabat.CheckOutScreen.darkstoresScheduledDeliveryUseCase")
    public static void injectDarkstoresScheduledDeliveryUseCase(CheckOutScreen checkOutScreen, DarkstoresScheduledDeliveryUseCase darkstoresScheduledDeliveryUseCase) {
        checkOutScreen.N = darkstoresScheduledDeliveryUseCase;
    }

    @InjectedFieldSignature("com.talabat.CheckOutScreen.discoveryConfigurationRepository")
    public static void injectDiscoveryConfigurationRepository(CheckOutScreen checkOutScreen, DiscoveryConfigurationRepository discoveryConfigurationRepository) {
        checkOutScreen.H = discoveryConfigurationRepository;
    }

    @InjectedFieldSignature("com.talabat.CheckOutScreen.feesViewModelFactory")
    public static void injectFeesViewModelFactory(CheckOutScreen checkOutScreen, FeesViewModelFactory feesViewModelFactory) {
        checkOutScreen.J = feesViewModelFactory;
    }

    @InjectedFieldSignature("com.talabat.CheckOutScreen.getActiveSubscriptionsRxWrapper")
    public static void injectGetActiveSubscriptionsRxWrapper(CheckOutScreen checkOutScreen, GetActiveSubscriptionsRxWrapper getActiveSubscriptionsRxWrapper) {
        checkOutScreen.Y = getActiveSubscriptionsRxWrapper;
    }

    @InjectedFieldSignature("com.talabat.CheckOutScreen.getTProOrderStatusUseCase")
    public static void injectGetTProOrderStatusUseCase(CheckOutScreen checkOutScreen, GetTProOrderStatusUseCase getTProOrderStatusUseCase) {
        checkOutScreen.Q = getTProOrderStatusUseCase;
    }

    @InjectedFieldSignature("com.talabat.CheckOutScreen.isDarkstoresScheduledDeliveryDiscountEnabledUseCase")
    public static void injectIsDarkstoresScheduledDeliveryDiscountEnabledUseCase(CheckOutScreen checkOutScreen, IsDarkstoresScheduledDeliveryDiscountEnabledUseCase isDarkstoresScheduledDeliveryDiscountEnabledUseCase) {
        checkOutScreen.O = isDarkstoresScheduledDeliveryDiscountEnabledUseCase;
    }

    @InjectedFieldSignature("com.talabat.CheckOutScreen.latLngFactory")
    public static void injectLatLngFactory(CheckOutScreen checkOutScreen, LatLngFactory latLngFactory) {
        checkOutScreen.S = latLngFactory;
    }

    @InjectedFieldSignature("com.talabat.CheckOutScreen.locationConfigurationRepository")
    public static void injectLocationConfigurationRepository(CheckOutScreen checkOutScreen, LocationConfigurationRepository locationConfigurationRepository) {
        checkOutScreen.G = locationConfigurationRepository;
    }

    @InjectedFieldSignature("com.talabat.CheckOutScreen.mapsInitializer")
    public static void injectMapsInitializer(CheckOutScreen checkOutScreen, MapsInitializer mapsInitializer) {
        checkOutScreen.T = mapsInitializer;
    }

    @InjectedFieldSignature("com.talabat.CheckOutScreen.modelsRepository")
    public static void injectModelsRepository(CheckOutScreen checkOutScreen, ModelsRepository modelsRepository) {
        checkOutScreen.R = modelsRepository;
    }

    @InjectedFieldSignature("com.talabat.CheckOutScreen.observabilityManager")
    public static void injectObservabilityManager(CheckOutScreen checkOutScreen, IObservabilityManager iObservabilityManager) {
        checkOutScreen.K = iObservabilityManager;
    }

    @InjectedFieldSignature("com.talabat.CheckOutScreen.paymentConfigurationRepository")
    public static void injectPaymentConfigurationRepository(CheckOutScreen checkOutScreen, PaymentConfigurationRepository paymentConfigurationRepository) {
        checkOutScreen.I = paymentConfigurationRepository;
    }

    @InjectedFieldSignature("com.talabat.CheckOutScreen.pickupFeatureApi")
    public static void injectPickupFeatureApi(CheckOutScreen checkOutScreen, PickupFeatureApi pickupFeatureApi) {
        checkOutScreen.F = pickupFeatureApi;
    }

    @InjectedFieldSignature("com.talabat.CheckOutScreen.postSubscriptionPaymentRxWrapper")
    public static void injectPostSubscriptionPaymentRxWrapper(CheckOutScreen checkOutScreen, PostSubscriptionPaymentRxWrapper postSubscriptionPaymentRxWrapper) {
        checkOutScreen.X = postSubscriptionPaymentRxWrapper;
    }

    @InjectedFieldSignature("com.talabat.CheckOutScreen.screenTracker")
    public static void injectScreenTracker(CheckOutScreen checkOutScreen, IScreenTracker iScreenTracker) {
        checkOutScreen.W = iScreenTracker;
    }

    @InjectedFieldSignature("com.talabat.CheckOutScreen.subscriptionStatusRepository")
    public static void injectSubscriptionStatusRepository(CheckOutScreen checkOutScreen, ISubscriptionStatusRepository iSubscriptionStatusRepository) {
        checkOutScreen.Z = iSubscriptionStatusRepository;
    }

    @InjectedFieldSignature("com.talabat.CheckOutScreen.subscriptionsTracker")
    public static void injectSubscriptionsTracker(CheckOutScreen checkOutScreen, ISubscriptionsTracker iSubscriptionsTracker) {
        checkOutScreen.M = iSubscriptionsTracker;
    }

    @InjectedFieldSignature("com.talabat.CheckOutScreen.talabatFeatureFlag")
    public static void injectTalabatFeatureFlag(CheckOutScreen checkOutScreen, ITalabatFeatureFlag iTalabatFeatureFlag) {
        checkOutScreen.L = iTalabatFeatureFlag;
    }

    @InjectedFieldSignature("com.talabat.CheckOutScreen.termsAndConditionsConfigurationRepository")
    public static void injectTermsAndConditionsConfigurationRepository(CheckOutScreen checkOutScreen, TermsAndConditionsConfigurationRepository termsAndConditionsConfigurationRepository) {
        checkOutScreen.P = termsAndConditionsConfigurationRepository;
    }

    public void injectMembers(CheckOutScreen checkOutScreen) {
        injectAppVersionProvider(checkOutScreen, this.appVersionProvider.get());
        injectConfigurationLocalRepository(checkOutScreen, this.configurationLocalRepositoryProvider.get());
        injectPickupFeatureApi(checkOutScreen, this.pickupFeatureApiProvider.get());
        injectLocationConfigurationRepository(checkOutScreen, this.locationConfigurationRepositoryProvider.get());
        injectDiscoveryConfigurationRepository(checkOutScreen, this.discoveryConfigurationRepositoryProvider.get());
        injectPaymentConfigurationRepository(checkOutScreen, this.paymentConfigurationRepositoryProvider.get());
        injectFeesViewModelFactory(checkOutScreen, this.feesViewModelFactoryProvider.get());
        injectObservabilityManager(checkOutScreen, this.observabilityManagerProvider.get());
        injectTalabatFeatureFlag(checkOutScreen, this.talabatFeatureFlagProvider.get());
        injectSubscriptionsTracker(checkOutScreen, this.subscriptionsTrackerProvider.get());
        injectDarkstoresScheduledDeliveryUseCase(checkOutScreen, this.darkstoresScheduledDeliveryUseCaseProvider.get());
        injectIsDarkstoresScheduledDeliveryDiscountEnabledUseCase(checkOutScreen, this.isDarkstoresScheduledDeliveryDiscountEnabledUseCaseProvider.get());
        injectTermsAndConditionsConfigurationRepository(checkOutScreen, this.termsAndConditionsConfigurationRepositoryProvider.get());
        injectGetTProOrderStatusUseCase(checkOutScreen, this.getTProOrderStatusUseCaseProvider.get());
        injectModelsRepository(checkOutScreen, this.modelsRepositoryProvider.get());
        injectLatLngFactory(checkOutScreen, this.latLngFactoryProvider.get());
        injectMapsInitializer(checkOutScreen, this.mapsInitializerProvider.get());
        injectCameraUpdateFactory(checkOutScreen, this.cameraUpdateFactoryProvider.get());
        injectCustomerRepository(checkOutScreen, this.customerRepositoryProvider.get());
        injectScreenTracker(checkOutScreen, this.screenTrackerProvider.get());
        injectPostSubscriptionPaymentRxWrapper(checkOutScreen, this.postSubscriptionPaymentRxWrapperProvider.get());
        injectGetActiveSubscriptionsRxWrapper(checkOutScreen, this.getActiveSubscriptionsRxWrapperProvider.get());
        injectSubscriptionStatusRepository(checkOutScreen, this.subscriptionStatusRepositoryProvider.get());
        injectCancellationPolicyFlag(checkOutScreen, this.cancellationPolicyFlagProvider.get());
        injectBnplManagerLocalDataSource(checkOutScreen, this.bnplManagerLocalDataSourceProvider.get());
    }
}
