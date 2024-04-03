package com.talabat;

import com.talabat.configuration.ConfigurationLocalRepository;
import com.talabat.configuration.discovery.AppVersionProvider;
import com.talabat.configuration.discovery.DiscoveryConfigurationRepository;
import com.talabat.configuration.location.LocationConfigurationRepository;
import dagger.MembersInjector;
import dagger.internal.DaggerGenerated;
import dagger.internal.InjectedFieldSignature;
import dagger.internal.QualifierMetadata;
import javax.inject.Provider;

@QualifierMetadata
@DaggerGenerated
public final class MobileNumberVerification_MembersInjector implements MembersInjector<MobileNumberVerification> {
    private final Provider<AppVersionProvider> appVersionProvider;
    private final Provider<ConfigurationLocalRepository> configurationLocalRepositoryProvider;
    private final Provider<DiscoveryConfigurationRepository> discoveryConfigurationRepositoryProvider;
    private final Provider<LocationConfigurationRepository> locationConfigurationRepositoryProvider;

    public MobileNumberVerification_MembersInjector(Provider<AppVersionProvider> provider, Provider<ConfigurationLocalRepository> provider2, Provider<DiscoveryConfigurationRepository> provider3, Provider<LocationConfigurationRepository> provider4) {
        this.appVersionProvider = provider;
        this.configurationLocalRepositoryProvider = provider2;
        this.discoveryConfigurationRepositoryProvider = provider3;
        this.locationConfigurationRepositoryProvider = provider4;
    }

    public static MembersInjector<MobileNumberVerification> create(Provider<AppVersionProvider> provider, Provider<ConfigurationLocalRepository> provider2, Provider<DiscoveryConfigurationRepository> provider3, Provider<LocationConfigurationRepository> provider4) {
        return new MobileNumberVerification_MembersInjector(provider, provider2, provider3, provider4);
    }

    @InjectedFieldSignature("com.talabat.MobileNumberVerification.appVersionProvider")
    public static void injectAppVersionProvider(MobileNumberVerification mobileNumberVerification, AppVersionProvider appVersionProvider2) {
        mobileNumberVerification.f54414r = appVersionProvider2;
    }

    @InjectedFieldSignature("com.talabat.MobileNumberVerification.configurationLocalRepository")
    public static void injectConfigurationLocalRepository(MobileNumberVerification mobileNumberVerification, ConfigurationLocalRepository configurationLocalRepository) {
        mobileNumberVerification.f54415s = configurationLocalRepository;
    }

    @InjectedFieldSignature("com.talabat.MobileNumberVerification.discoveryConfigurationRepository")
    public static void injectDiscoveryConfigurationRepository(MobileNumberVerification mobileNumberVerification, DiscoveryConfigurationRepository discoveryConfigurationRepository) {
        mobileNumberVerification.f54416t = discoveryConfigurationRepository;
    }

    @InjectedFieldSignature("com.talabat.MobileNumberVerification.locationConfigurationRepository")
    public static void injectLocationConfigurationRepository(MobileNumberVerification mobileNumberVerification, LocationConfigurationRepository locationConfigurationRepository) {
        mobileNumberVerification.f54417u = locationConfigurationRepository;
    }

    public void injectMembers(MobileNumberVerification mobileNumberVerification) {
        injectAppVersionProvider(mobileNumberVerification, this.appVersionProvider.get());
        injectConfigurationLocalRepository(mobileNumberVerification, this.configurationLocalRepositoryProvider.get());
        injectDiscoveryConfigurationRepository(mobileNumberVerification, this.discoveryConfigurationRepositoryProvider.get());
        injectLocationConfigurationRepository(mobileNumberVerification, this.locationConfigurationRepositoryProvider.get());
    }
}
