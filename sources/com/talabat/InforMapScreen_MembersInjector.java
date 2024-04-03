package com.talabat;

import com.talabat.configuration.discovery.AppVersionProvider;
import com.talabat.configuration.location.LocationConfigurationRepository;
import dagger.MembersInjector;
import dagger.internal.DaggerGenerated;
import dagger.internal.InjectedFieldSignature;
import dagger.internal.QualifierMetadata;
import javax.inject.Provider;

@QualifierMetadata
@DaggerGenerated
public final class InforMapScreen_MembersInjector implements MembersInjector<InforMapScreen> {
    private final Provider<AppVersionProvider> appVersionProvider;
    private final Provider<LocationConfigurationRepository> locationConfigRepositoryProvider;

    public InforMapScreen_MembersInjector(Provider<AppVersionProvider> provider, Provider<LocationConfigurationRepository> provider2) {
        this.appVersionProvider = provider;
        this.locationConfigRepositoryProvider = provider2;
    }

    public static MembersInjector<InforMapScreen> create(Provider<AppVersionProvider> provider, Provider<LocationConfigurationRepository> provider2) {
        return new InforMapScreen_MembersInjector(provider, provider2);
    }

    @InjectedFieldSignature("com.talabat.InforMapScreen.appVersionProvider")
    public static void injectAppVersionProvider(InforMapScreen inforMapScreen, AppVersionProvider appVersionProvider2) {
        inforMapScreen.f54209i = appVersionProvider2;
    }

    @InjectedFieldSignature("com.talabat.InforMapScreen.locationConfigRepository")
    public static void injectLocationConfigRepository(InforMapScreen inforMapScreen, LocationConfigurationRepository locationConfigurationRepository) {
        inforMapScreen.f54210j = locationConfigurationRepository;
    }

    public void injectMembers(InforMapScreen inforMapScreen) {
        injectAppVersionProvider(inforMapScreen, this.appVersionProvider.get());
        injectLocationConfigRepository(inforMapScreen, this.locationConfigRepositoryProvider.get());
    }
}
