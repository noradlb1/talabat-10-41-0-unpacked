package com.talabat;

import com.talabat.configuration.ConfigurationLocalRepository;
import com.talabat.configuration.discovery.AppVersionProvider;
import com.talabat.configuration.location.LocationConfigurationRepository;
import dagger.MembersInjector;
import dagger.internal.DaggerGenerated;
import dagger.internal.InjectedFieldSignature;
import dagger.internal.QualifierMetadata;
import javax.inject.Provider;

@QualifierMetadata
@DaggerGenerated
public final class PayfortCardPaymentListScreen_MembersInjector implements MembersInjector<PayfortCardPaymentListScreen> {
    private final Provider<AppVersionProvider> appVersionProvider;
    private final Provider<ConfigurationLocalRepository> configurationLocalRepositoryProvider;
    private final Provider<LocationConfigurationRepository> locationConfigurationRepositoryProvider;

    public PayfortCardPaymentListScreen_MembersInjector(Provider<AppVersionProvider> provider, Provider<ConfigurationLocalRepository> provider2, Provider<LocationConfigurationRepository> provider3) {
        this.appVersionProvider = provider;
        this.configurationLocalRepositoryProvider = provider2;
        this.locationConfigurationRepositoryProvider = provider3;
    }

    public static MembersInjector<PayfortCardPaymentListScreen> create(Provider<AppVersionProvider> provider, Provider<ConfigurationLocalRepository> provider2, Provider<LocationConfigurationRepository> provider3) {
        return new PayfortCardPaymentListScreen_MembersInjector(provider, provider2, provider3);
    }

    @InjectedFieldSignature("com.talabat.PayfortCardPaymentListScreen.appVersionProvider")
    public static void injectAppVersionProvider(PayfortCardPaymentListScreen payfortCardPaymentListScreen, AppVersionProvider appVersionProvider2) {
        payfortCardPaymentListScreen.f54508i = appVersionProvider2;
    }

    @InjectedFieldSignature("com.talabat.PayfortCardPaymentListScreen.configurationLocalRepository")
    public static void injectConfigurationLocalRepository(PayfortCardPaymentListScreen payfortCardPaymentListScreen, ConfigurationLocalRepository configurationLocalRepository) {
        payfortCardPaymentListScreen.configurationLocalRepository = configurationLocalRepository;
    }

    @InjectedFieldSignature("com.talabat.PayfortCardPaymentListScreen.locationConfigurationRepository")
    public static void injectLocationConfigurationRepository(PayfortCardPaymentListScreen payfortCardPaymentListScreen, LocationConfigurationRepository locationConfigurationRepository) {
        payfortCardPaymentListScreen.locationConfigurationRepository = locationConfigurationRepository;
    }

    public void injectMembers(PayfortCardPaymentListScreen payfortCardPaymentListScreen) {
        injectAppVersionProvider(payfortCardPaymentListScreen, this.appVersionProvider.get());
        injectConfigurationLocalRepository(payfortCardPaymentListScreen, this.configurationLocalRepositoryProvider.get());
        injectLocationConfigurationRepository(payfortCardPaymentListScreen, this.locationConfigurationRepositoryProvider.get());
    }
}
