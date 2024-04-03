package com.talabat.checkoutdotcom;

import com.talabat.configuration.ConfigurationLocalRepository;
import com.talabat.configuration.discovery.AppVersionProvider;
import com.talabat.configuration.discovery.DiscoveryConfigurationRepository;
import com.talabat.configuration.location.LocationConfigurationRepository;
import com.talabat.configuration.payment.PaymentConfigurationRepository;
import com.talabat.configuration.tcs.TermsAndConditionsConfigurationRepository;
import com.talabat.core.deeplink.domain.DeepLinkNavigator;
import com.talabat.core.featureflag.domain.ITalabatFeatureFlag;
import com.talabat.core.observabilityNew.domain.IObservabilityManager;
import com.talabat.feature.fees.presentation.viewmodel.FeesViewModelFactory;
import com.talabat.talabatcommon.views.wallet.walletCardManagement.viewModel.ICheckoutKit;
import dagger.MembersInjector;
import dagger.internal.DaggerGenerated;
import dagger.internal.InjectedFieldSignature;
import dagger.internal.QualifierMetadata;
import javax.inject.Provider;

@QualifierMetadata
@DaggerGenerated
public final class CheckoutTokenScreen_MembersInjector implements MembersInjector<CheckoutTokenScreen> {
    private final Provider<AppVersionProvider> appVersionProvider;
    private final Provider<ICheckoutKit> checkoutKitProvider;
    private final Provider<ConfigurationLocalRepository> configurationLocalRepositoryProvider;
    private final Provider<DeepLinkNavigator> deepLinkNavigatorProvider;
    private final Provider<DiscoveryConfigurationRepository> discoveryConfigurationRepositoryProvider;
    private final Provider<FeesViewModelFactory> feesViewModelFactoryProvider;
    private final Provider<LocationConfigurationRepository> locationConfigurationRepositoryProvider;
    private final Provider<IObservabilityManager> observabilityManagerProvider;
    private final Provider<PaymentConfigurationRepository> paymentConfigurationRepositoryProvider;
    private final Provider<ITalabatFeatureFlag> talabatFeatureFlagProvider;
    private final Provider<TermsAndConditionsConfigurationRepository> termsAndConditionsConfigurationRepositoryProvider;

    public CheckoutTokenScreen_MembersInjector(Provider<AppVersionProvider> provider, Provider<ConfigurationLocalRepository> provider2, Provider<DeepLinkNavigator> provider3, Provider<DiscoveryConfigurationRepository> provider4, Provider<LocationConfigurationRepository> provider5, Provider<PaymentConfigurationRepository> provider6, Provider<FeesViewModelFactory> provider7, Provider<IObservabilityManager> provider8, Provider<ITalabatFeatureFlag> provider9, Provider<ICheckoutKit> provider10, Provider<TermsAndConditionsConfigurationRepository> provider11) {
        this.appVersionProvider = provider;
        this.configurationLocalRepositoryProvider = provider2;
        this.deepLinkNavigatorProvider = provider3;
        this.discoveryConfigurationRepositoryProvider = provider4;
        this.locationConfigurationRepositoryProvider = provider5;
        this.paymentConfigurationRepositoryProvider = provider6;
        this.feesViewModelFactoryProvider = provider7;
        this.observabilityManagerProvider = provider8;
        this.talabatFeatureFlagProvider = provider9;
        this.checkoutKitProvider = provider10;
        this.termsAndConditionsConfigurationRepositoryProvider = provider11;
    }

    public static MembersInjector<CheckoutTokenScreen> create(Provider<AppVersionProvider> provider, Provider<ConfigurationLocalRepository> provider2, Provider<DeepLinkNavigator> provider3, Provider<DiscoveryConfigurationRepository> provider4, Provider<LocationConfigurationRepository> provider5, Provider<PaymentConfigurationRepository> provider6, Provider<FeesViewModelFactory> provider7, Provider<IObservabilityManager> provider8, Provider<ITalabatFeatureFlag> provider9, Provider<ICheckoutKit> provider10, Provider<TermsAndConditionsConfigurationRepository> provider11) {
        return new CheckoutTokenScreen_MembersInjector(provider, provider2, provider3, provider4, provider5, provider6, provider7, provider8, provider9, provider10, provider11);
    }

    @InjectedFieldSignature("com.talabat.checkoutdotcom.CheckoutTokenScreen.appVersionProvider")
    public static void injectAppVersionProvider(CheckoutTokenScreen checkoutTokenScreen, AppVersionProvider appVersionProvider2) {
        checkoutTokenScreen.f55555w = appVersionProvider2;
    }

    @InjectedFieldSignature("com.talabat.checkoutdotcom.CheckoutTokenScreen.checkoutKit")
    public static void injectCheckoutKit(CheckoutTokenScreen checkoutTokenScreen, ICheckoutKit iCheckoutKit) {
        checkoutTokenScreen.G = iCheckoutKit;
    }

    @InjectedFieldSignature("com.talabat.checkoutdotcom.CheckoutTokenScreen.configurationLocalRepository")
    public static void injectConfigurationLocalRepository(CheckoutTokenScreen checkoutTokenScreen, ConfigurationLocalRepository configurationLocalRepository) {
        checkoutTokenScreen.f55556x = configurationLocalRepository;
    }

    @InjectedFieldSignature("com.talabat.checkoutdotcom.CheckoutTokenScreen.deepLinkNavigator")
    public static void injectDeepLinkNavigator(CheckoutTokenScreen checkoutTokenScreen, DeepLinkNavigator deepLinkNavigator) {
        checkoutTokenScreen.f55557y = deepLinkNavigator;
    }

    @InjectedFieldSignature("com.talabat.checkoutdotcom.CheckoutTokenScreen.discoveryConfigurationRepository")
    public static void injectDiscoveryConfigurationRepository(CheckoutTokenScreen checkoutTokenScreen, DiscoveryConfigurationRepository discoveryConfigurationRepository) {
        checkoutTokenScreen.f55558z = discoveryConfigurationRepository;
    }

    @InjectedFieldSignature("com.talabat.checkoutdotcom.CheckoutTokenScreen.feesViewModelFactory")
    public static void injectFeesViewModelFactory(CheckoutTokenScreen checkoutTokenScreen, FeesViewModelFactory feesViewModelFactory) {
        checkoutTokenScreen.C = feesViewModelFactory;
    }

    @InjectedFieldSignature("com.talabat.checkoutdotcom.CheckoutTokenScreen.locationConfigurationRepository")
    public static void injectLocationConfigurationRepository(CheckoutTokenScreen checkoutTokenScreen, LocationConfigurationRepository locationConfigurationRepository) {
        checkoutTokenScreen.A = locationConfigurationRepository;
    }

    @InjectedFieldSignature("com.talabat.checkoutdotcom.CheckoutTokenScreen.observabilityManager")
    public static void injectObservabilityManager(CheckoutTokenScreen checkoutTokenScreen, IObservabilityManager iObservabilityManager) {
        checkoutTokenScreen.D = iObservabilityManager;
    }

    @InjectedFieldSignature("com.talabat.checkoutdotcom.CheckoutTokenScreen.paymentConfigurationRepository")
    public static void injectPaymentConfigurationRepository(CheckoutTokenScreen checkoutTokenScreen, PaymentConfigurationRepository paymentConfigurationRepository) {
        checkoutTokenScreen.B = paymentConfigurationRepository;
    }

    @InjectedFieldSignature("com.talabat.checkoutdotcom.CheckoutTokenScreen.talabatFeatureFlag")
    public static void injectTalabatFeatureFlag(CheckoutTokenScreen checkoutTokenScreen, ITalabatFeatureFlag iTalabatFeatureFlag) {
        checkoutTokenScreen.E = iTalabatFeatureFlag;
    }

    @InjectedFieldSignature("com.talabat.checkoutdotcom.CheckoutTokenScreen.termsAndConditionsConfigurationRepository")
    public static void injectTermsAndConditionsConfigurationRepository(CheckoutTokenScreen checkoutTokenScreen, TermsAndConditionsConfigurationRepository termsAndConditionsConfigurationRepository) {
        checkoutTokenScreen.H = termsAndConditionsConfigurationRepository;
    }

    public void injectMembers(CheckoutTokenScreen checkoutTokenScreen) {
        injectAppVersionProvider(checkoutTokenScreen, this.appVersionProvider.get());
        injectConfigurationLocalRepository(checkoutTokenScreen, this.configurationLocalRepositoryProvider.get());
        injectDeepLinkNavigator(checkoutTokenScreen, this.deepLinkNavigatorProvider.get());
        injectDiscoveryConfigurationRepository(checkoutTokenScreen, this.discoveryConfigurationRepositoryProvider.get());
        injectLocationConfigurationRepository(checkoutTokenScreen, this.locationConfigurationRepositoryProvider.get());
        injectPaymentConfigurationRepository(checkoutTokenScreen, this.paymentConfigurationRepositoryProvider.get());
        injectFeesViewModelFactory(checkoutTokenScreen, this.feesViewModelFactoryProvider.get());
        injectObservabilityManager(checkoutTokenScreen, this.observabilityManagerProvider.get());
        injectTalabatFeatureFlag(checkoutTokenScreen, this.talabatFeatureFlagProvider.get());
        injectCheckoutKit(checkoutTokenScreen, this.checkoutKitProvider.get());
        injectTermsAndConditionsConfigurationRepository(checkoutTokenScreen, this.termsAndConditionsConfigurationRepositoryProvider.get());
    }
}
