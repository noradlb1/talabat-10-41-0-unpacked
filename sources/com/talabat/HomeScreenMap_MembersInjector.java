package com.talabat;

import com.squareup.moshi.Moshi;
import com.talabat.authentication.aaa.secrets.SecretProvider;
import com.talabat.configuration.ConfigurationRemoteRepository;
import com.talabat.configuration.MutableConfigurationLocalRepository;
import com.talabat.configuration.MutableConfigurationRemoteRepository;
import com.talabat.configuration.MutableLocationConfigurationRepository;
import com.talabat.configuration.discovery.AppVersionProvider;
import com.talabat.configuration.payment.PaymentConfigurationRepository;
import com.talabat.core.deeplink.domain.DeepLinkNavigator;
import com.talabat.core.featureflag.domain.ITalabatFeatureFlag;
import com.talabat.core.navigation.domain.Navigator;
import com.talabat.core.pinless.checkout.domain.SetHasUserPinnedLocationInOnboardingMapUseCase;
import com.talabat.customer.domain.CustomerRepository;
import com.talabat.feature.subscriptions.domain.ISubscriptionsCustomerRepository;
import com.talabat.feature.subscriptions.domain.usecase.GetProCentralizationStatusUseCase;
import com.talabat.maps.domain.CameraUpdateFactory;
import com.talabat.maps.domain.LatLngFactory;
import com.talabat.maps.domain.MapsInitializer;
import com.talabat.maps.domain.ModelsRepository;
import dagger.MembersInjector;
import dagger.internal.DaggerGenerated;
import dagger.internal.InjectedFieldSignature;
import dagger.internal.QualifierMetadata;
import javax.inject.Provider;

@QualifierMetadata
@DaggerGenerated
public final class HomeScreenMap_MembersInjector implements MembersInjector<HomeScreenMap> {
    private final Provider<AppVersionProvider> appVersionProvider;
    private final Provider<CameraUpdateFactory> cameraUpdateFactoryProvider;
    private final Provider<ConfigurationRemoteRepository> configurationRemoteRepositoryProvider;
    private final Provider<CustomerRepository> customerRepositoryProvider;
    private final Provider<DeepLinkNavigator> deepLinkNavigatorProvider;
    private final Provider<GetProCentralizationStatusUseCase> getProCentralizationStatusUseCaseProvider;
    private final Provider<LatLngFactory> latLngFactoryProvider;
    private final Provider<MapsInitializer> mapsInitializerProvider;
    private final Provider<ModelsRepository> modelsRepositoryProvider;
    private final Provider<Moshi> moshiProvider;
    private final Provider<MutableConfigurationLocalRepository> mutableConfigurationLocalRepositoryProvider;
    private final Provider<MutableConfigurationRemoteRepository> mutableConfigurationRemoteRepositoryProvider;
    private final Provider<MutableLocationConfigurationRepository> mutableLocationConfigurationRepositoryProvider;
    private final Provider<Navigator> navigatorProvider;
    private final Provider<PaymentConfigurationRepository> paymentConfigurationRepositoryProvider;
    private final Provider<SecretProvider> secretProvider;
    private final Provider<SetHasUserPinnedLocationInOnboardingMapUseCase> setHasUserPinnedLocationInOnboardingMapUseCaseProvider;
    private final Provider<ISubscriptionsCustomerRepository> subscriptionsCustomerRepositoryProvider;
    private final Provider<ITalabatFeatureFlag> talabatFeatureFlagProvider;

    public HomeScreenMap_MembersInjector(Provider<Moshi> provider, Provider<AppVersionProvider> provider2, Provider<ConfigurationRemoteRepository> provider3, Provider<MutableConfigurationLocalRepository> provider4, Provider<MutableLocationConfigurationRepository> provider5, Provider<MutableConfigurationRemoteRepository> provider6, Provider<PaymentConfigurationRepository> provider7, Provider<SetHasUserPinnedLocationInOnboardingMapUseCase> provider8, Provider<SecretProvider> provider9, Provider<ISubscriptionsCustomerRepository> provider10, Provider<GetProCentralizationStatusUseCase> provider11, Provider<ITalabatFeatureFlag> provider12, Provider<CameraUpdateFactory> provider13, Provider<ModelsRepository> provider14, Provider<LatLngFactory> provider15, Provider<MapsInitializer> provider16, Provider<CustomerRepository> provider17, Provider<DeepLinkNavigator> provider18, Provider<Navigator> provider19) {
        this.moshiProvider = provider;
        this.appVersionProvider = provider2;
        this.configurationRemoteRepositoryProvider = provider3;
        this.mutableConfigurationLocalRepositoryProvider = provider4;
        this.mutableLocationConfigurationRepositoryProvider = provider5;
        this.mutableConfigurationRemoteRepositoryProvider = provider6;
        this.paymentConfigurationRepositoryProvider = provider7;
        this.setHasUserPinnedLocationInOnboardingMapUseCaseProvider = provider8;
        this.secretProvider = provider9;
        this.subscriptionsCustomerRepositoryProvider = provider10;
        this.getProCentralizationStatusUseCaseProvider = provider11;
        this.talabatFeatureFlagProvider = provider12;
        this.cameraUpdateFactoryProvider = provider13;
        this.modelsRepositoryProvider = provider14;
        this.latLngFactoryProvider = provider15;
        this.mapsInitializerProvider = provider16;
        this.customerRepositoryProvider = provider17;
        this.deepLinkNavigatorProvider = provider18;
        this.navigatorProvider = provider19;
    }

    public static MembersInjector<HomeScreenMap> create(Provider<Moshi> provider, Provider<AppVersionProvider> provider2, Provider<ConfigurationRemoteRepository> provider3, Provider<MutableConfigurationLocalRepository> provider4, Provider<MutableLocationConfigurationRepository> provider5, Provider<MutableConfigurationRemoteRepository> provider6, Provider<PaymentConfigurationRepository> provider7, Provider<SetHasUserPinnedLocationInOnboardingMapUseCase> provider8, Provider<SecretProvider> provider9, Provider<ISubscriptionsCustomerRepository> provider10, Provider<GetProCentralizationStatusUseCase> provider11, Provider<ITalabatFeatureFlag> provider12, Provider<CameraUpdateFactory> provider13, Provider<ModelsRepository> provider14, Provider<LatLngFactory> provider15, Provider<MapsInitializer> provider16, Provider<CustomerRepository> provider17, Provider<DeepLinkNavigator> provider18, Provider<Navigator> provider19) {
        return new HomeScreenMap_MembersInjector(provider, provider2, provider3, provider4, provider5, provider6, provider7, provider8, provider9, provider10, provider11, provider12, provider13, provider14, provider15, provider16, provider17, provider18, provider19);
    }

    @InjectedFieldSignature("com.talabat.HomeScreenMap.appVersionProvider")
    public static void injectAppVersionProvider(HomeScreenMap homeScreenMap, AppVersionProvider appVersionProvider2) {
        homeScreenMap.appVersionProvider = appVersionProvider2;
    }

    @InjectedFieldSignature("com.talabat.HomeScreenMap.cameraUpdateFactory")
    public static void injectCameraUpdateFactory(HomeScreenMap homeScreenMap, CameraUpdateFactory cameraUpdateFactory) {
        homeScreenMap.cameraUpdateFactory = cameraUpdateFactory;
    }

    @InjectedFieldSignature("com.talabat.HomeScreenMap.configurationRemoteRepository")
    public static void injectConfigurationRemoteRepository(HomeScreenMap homeScreenMap, ConfigurationRemoteRepository configurationRemoteRepository) {
        homeScreenMap.configurationRemoteRepository = configurationRemoteRepository;
    }

    @InjectedFieldSignature("com.talabat.HomeScreenMap.customerRepository")
    public static void injectCustomerRepository(HomeScreenMap homeScreenMap, CustomerRepository customerRepository) {
        homeScreenMap.customerRepository = customerRepository;
    }

    @InjectedFieldSignature("com.talabat.HomeScreenMap.deepLinkNavigator")
    public static void injectDeepLinkNavigator(HomeScreenMap homeScreenMap, DeepLinkNavigator deepLinkNavigator) {
        homeScreenMap.deepLinkNavigator = deepLinkNavigator;
    }

    @InjectedFieldSignature("com.talabat.HomeScreenMap.getProCentralizationStatusUseCase")
    public static void injectGetProCentralizationStatusUseCase(HomeScreenMap homeScreenMap, GetProCentralizationStatusUseCase getProCentralizationStatusUseCase) {
        homeScreenMap.getProCentralizationStatusUseCase = getProCentralizationStatusUseCase;
    }

    @InjectedFieldSignature("com.talabat.HomeScreenMap.latLngFactory")
    public static void injectLatLngFactory(HomeScreenMap homeScreenMap, LatLngFactory latLngFactory) {
        homeScreenMap.latLngFactory = latLngFactory;
    }

    @InjectedFieldSignature("com.talabat.HomeScreenMap.mapsInitializer")
    public static void injectMapsInitializer(HomeScreenMap homeScreenMap, MapsInitializer mapsInitializer) {
        homeScreenMap.mapsInitializer = mapsInitializer;
    }

    @InjectedFieldSignature("com.talabat.HomeScreenMap.modelsRepository")
    public static void injectModelsRepository(HomeScreenMap homeScreenMap, ModelsRepository modelsRepository) {
        homeScreenMap.modelsRepository = modelsRepository;
    }

    @InjectedFieldSignature("com.talabat.HomeScreenMap.moshi")
    public static void injectMoshi(HomeScreenMap homeScreenMap, Moshi moshi) {
        homeScreenMap.moshi = moshi;
    }

    @InjectedFieldSignature("com.talabat.HomeScreenMap.mutableConfigurationLocalRepository")
    public static void injectMutableConfigurationLocalRepository(HomeScreenMap homeScreenMap, MutableConfigurationLocalRepository mutableConfigurationLocalRepository) {
        homeScreenMap.mutableConfigurationLocalRepository = mutableConfigurationLocalRepository;
    }

    @InjectedFieldSignature("com.talabat.HomeScreenMap.mutableConfigurationRemoteRepository")
    public static void injectMutableConfigurationRemoteRepository(HomeScreenMap homeScreenMap, MutableConfigurationRemoteRepository mutableConfigurationRemoteRepository) {
        homeScreenMap.mutableConfigurationRemoteRepository = mutableConfigurationRemoteRepository;
    }

    @InjectedFieldSignature("com.talabat.HomeScreenMap.mutableLocationConfigurationRepository")
    public static void injectMutableLocationConfigurationRepository(HomeScreenMap homeScreenMap, MutableLocationConfigurationRepository mutableLocationConfigurationRepository) {
        homeScreenMap.mutableLocationConfigurationRepository = mutableLocationConfigurationRepository;
    }

    @InjectedFieldSignature("com.talabat.HomeScreenMap.navigator")
    public static void injectNavigator(HomeScreenMap homeScreenMap, Navigator navigator) {
        homeScreenMap.navigator = navigator;
    }

    @InjectedFieldSignature("com.talabat.HomeScreenMap.paymentConfigurationRepository")
    public static void injectPaymentConfigurationRepository(HomeScreenMap homeScreenMap, PaymentConfigurationRepository paymentConfigurationRepository) {
        homeScreenMap.paymentConfigurationRepository = paymentConfigurationRepository;
    }

    @InjectedFieldSignature("com.talabat.HomeScreenMap.secretProvider")
    public static void injectSecretProvider(HomeScreenMap homeScreenMap, SecretProvider secretProvider2) {
        homeScreenMap.secretProvider = secretProvider2;
    }

    @InjectedFieldSignature("com.talabat.HomeScreenMap.setHasUserPinnedLocationInOnboardingMapUseCase")
    public static void injectSetHasUserPinnedLocationInOnboardingMapUseCase(HomeScreenMap homeScreenMap, SetHasUserPinnedLocationInOnboardingMapUseCase setHasUserPinnedLocationInOnboardingMapUseCase) {
        homeScreenMap.setHasUserPinnedLocationInOnboardingMapUseCase = setHasUserPinnedLocationInOnboardingMapUseCase;
    }

    @InjectedFieldSignature("com.talabat.HomeScreenMap.subscriptionsCustomerRepository")
    public static void injectSubscriptionsCustomerRepository(HomeScreenMap homeScreenMap, ISubscriptionsCustomerRepository iSubscriptionsCustomerRepository) {
        homeScreenMap.subscriptionsCustomerRepository = iSubscriptionsCustomerRepository;
    }

    @InjectedFieldSignature("com.talabat.HomeScreenMap.talabatFeatureFlag")
    public static void injectTalabatFeatureFlag(HomeScreenMap homeScreenMap, ITalabatFeatureFlag iTalabatFeatureFlag) {
        homeScreenMap.talabatFeatureFlag = iTalabatFeatureFlag;
    }

    public void injectMembers(HomeScreenMap homeScreenMap) {
        injectMoshi(homeScreenMap, this.moshiProvider.get());
        injectAppVersionProvider(homeScreenMap, this.appVersionProvider.get());
        injectConfigurationRemoteRepository(homeScreenMap, this.configurationRemoteRepositoryProvider.get());
        injectMutableConfigurationLocalRepository(homeScreenMap, this.mutableConfigurationLocalRepositoryProvider.get());
        injectMutableLocationConfigurationRepository(homeScreenMap, this.mutableLocationConfigurationRepositoryProvider.get());
        injectMutableConfigurationRemoteRepository(homeScreenMap, this.mutableConfigurationRemoteRepositoryProvider.get());
        injectPaymentConfigurationRepository(homeScreenMap, this.paymentConfigurationRepositoryProvider.get());
        injectSetHasUserPinnedLocationInOnboardingMapUseCase(homeScreenMap, this.setHasUserPinnedLocationInOnboardingMapUseCaseProvider.get());
        injectSecretProvider(homeScreenMap, this.secretProvider.get());
        injectSubscriptionsCustomerRepository(homeScreenMap, this.subscriptionsCustomerRepositoryProvider.get());
        injectGetProCentralizationStatusUseCase(homeScreenMap, this.getProCentralizationStatusUseCaseProvider.get());
        injectTalabatFeatureFlag(homeScreenMap, this.talabatFeatureFlagProvider.get());
        injectCameraUpdateFactory(homeScreenMap, this.cameraUpdateFactoryProvider.get());
        injectModelsRepository(homeScreenMap, this.modelsRepositoryProvider.get());
        injectLatLngFactory(homeScreenMap, this.latLngFactoryProvider.get());
        injectMapsInitializer(homeScreenMap, this.mapsInitializerProvider.get());
        injectCustomerRepository(homeScreenMap, this.customerRepositoryProvider.get());
        injectDeepLinkNavigator(homeScreenMap, this.deepLinkNavigatorProvider.get());
        injectNavigator(homeScreenMap, this.navigatorProvider.get());
    }
}
