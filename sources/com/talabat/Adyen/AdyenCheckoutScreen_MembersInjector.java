package com.talabat.Adyen;

import com.talabat.configuration.ConfigurationLocalRepository;
import com.talabat.configuration.discovery.AppVersionProvider;
import com.talabat.configuration.discovery.DiscoveryConfigurationRepository;
import com.talabat.configuration.location.LocationConfigurationRepository;
import com.talabat.configuration.payment.PaymentConfigurationRepository;
import com.talabat.configuration.tcs.TermsAndConditionsConfigurationRepository;
import com.talabat.feature.tokenization.data.mapper.NonEnglishNumbersMapper;
import dagger.MembersInjector;
import dagger.internal.DaggerGenerated;
import dagger.internal.InjectedFieldSignature;
import dagger.internal.QualifierMetadata;
import javax.inject.Provider;

@QualifierMetadata
@DaggerGenerated
public final class AdyenCheckoutScreen_MembersInjector implements MembersInjector<AdyenCheckoutScreen> {
    private final Provider<AppVersionProvider> appVersionProvider;
    private final Provider<ConfigurationLocalRepository> configurationLocalRepositoryProvider;
    private final Provider<DiscoveryConfigurationRepository> discoveryConfigurationRepositoryProvider;
    private final Provider<LocationConfigurationRepository> locationConfigurationRepositoryProvider;
    private final Provider<NonEnglishNumbersMapper> nonEnglishNumbersMapperProvider;
    private final Provider<PaymentConfigurationRepository> paymentConfigurationRepositoryProvider;
    private final Provider<TermsAndConditionsConfigurationRepository> termsAndConditionsConfigurationRepositoryProvider;

    public AdyenCheckoutScreen_MembersInjector(Provider<AppVersionProvider> provider, Provider<ConfigurationLocalRepository> provider2, Provider<DiscoveryConfigurationRepository> provider3, Provider<LocationConfigurationRepository> provider4, Provider<PaymentConfigurationRepository> provider5, Provider<TermsAndConditionsConfigurationRepository> provider6, Provider<NonEnglishNumbersMapper> provider7) {
        this.appVersionProvider = provider;
        this.configurationLocalRepositoryProvider = provider2;
        this.discoveryConfigurationRepositoryProvider = provider3;
        this.locationConfigurationRepositoryProvider = provider4;
        this.paymentConfigurationRepositoryProvider = provider5;
        this.termsAndConditionsConfigurationRepositoryProvider = provider6;
        this.nonEnglishNumbersMapperProvider = provider7;
    }

    public static MembersInjector<AdyenCheckoutScreen> create(Provider<AppVersionProvider> provider, Provider<ConfigurationLocalRepository> provider2, Provider<DiscoveryConfigurationRepository> provider3, Provider<LocationConfigurationRepository> provider4, Provider<PaymentConfigurationRepository> provider5, Provider<TermsAndConditionsConfigurationRepository> provider6, Provider<NonEnglishNumbersMapper> provider7) {
        return new AdyenCheckoutScreen_MembersInjector(provider, provider2, provider3, provider4, provider5, provider6, provider7);
    }

    @InjectedFieldSignature("com.talabat.Adyen.AdyenCheckoutScreen.appVersionProvider")
    public static void injectAppVersionProvider(AdyenCheckoutScreen adyenCheckoutScreen, AppVersionProvider appVersionProvider2) {
        adyenCheckoutScreen.f53576v = appVersionProvider2;
    }

    @InjectedFieldSignature("com.talabat.Adyen.AdyenCheckoutScreen.configurationLocalRepository")
    public static void injectConfigurationLocalRepository(AdyenCheckoutScreen adyenCheckoutScreen, ConfigurationLocalRepository configurationLocalRepository) {
        adyenCheckoutScreen.f53577w = configurationLocalRepository;
    }

    @InjectedFieldSignature("com.talabat.Adyen.AdyenCheckoutScreen.discoveryConfigurationRepository")
    public static void injectDiscoveryConfigurationRepository(AdyenCheckoutScreen adyenCheckoutScreen, DiscoveryConfigurationRepository discoveryConfigurationRepository) {
        adyenCheckoutScreen.f53578x = discoveryConfigurationRepository;
    }

    @InjectedFieldSignature("com.talabat.Adyen.AdyenCheckoutScreen.locationConfigurationRepository")
    public static void injectLocationConfigurationRepository(AdyenCheckoutScreen adyenCheckoutScreen, LocationConfigurationRepository locationConfigurationRepository) {
        adyenCheckoutScreen.f53579y = locationConfigurationRepository;
    }

    @InjectedFieldSignature("com.talabat.Adyen.AdyenCheckoutScreen.nonEnglishNumbersMapper")
    public static void injectNonEnglishNumbersMapper(AdyenCheckoutScreen adyenCheckoutScreen, NonEnglishNumbersMapper nonEnglishNumbersMapper) {
        adyenCheckoutScreen.B = nonEnglishNumbersMapper;
    }

    @InjectedFieldSignature("com.talabat.Adyen.AdyenCheckoutScreen.paymentConfigurationRepository")
    public static void injectPaymentConfigurationRepository(AdyenCheckoutScreen adyenCheckoutScreen, PaymentConfigurationRepository paymentConfigurationRepository) {
        adyenCheckoutScreen.f53580z = paymentConfigurationRepository;
    }

    @InjectedFieldSignature("com.talabat.Adyen.AdyenCheckoutScreen.termsAndConditionsConfigurationRepository")
    public static void injectTermsAndConditionsConfigurationRepository(AdyenCheckoutScreen adyenCheckoutScreen, TermsAndConditionsConfigurationRepository termsAndConditionsConfigurationRepository) {
        adyenCheckoutScreen.A = termsAndConditionsConfigurationRepository;
    }

    public void injectMembers(AdyenCheckoutScreen adyenCheckoutScreen) {
        injectAppVersionProvider(adyenCheckoutScreen, this.appVersionProvider.get());
        injectConfigurationLocalRepository(adyenCheckoutScreen, this.configurationLocalRepositoryProvider.get());
        injectDiscoveryConfigurationRepository(adyenCheckoutScreen, this.discoveryConfigurationRepositoryProvider.get());
        injectLocationConfigurationRepository(adyenCheckoutScreen, this.locationConfigurationRepositoryProvider.get());
        injectPaymentConfigurationRepository(adyenCheckoutScreen, this.paymentConfigurationRepositoryProvider.get());
        injectTermsAndConditionsConfigurationRepository(adyenCheckoutScreen, this.termsAndConditionsConfigurationRepositoryProvider.get());
        injectNonEnglishNumbersMapper(adyenCheckoutScreen, this.nonEnglishNumbersMapperProvider.get());
    }
}
