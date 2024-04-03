package com.talabat;

import com.talabat.configuration.ConfigurationLocalRepository;
import com.talabat.configuration.location.LocationConfigurationRepository;
import dagger.MembersInjector;
import dagger.internal.DaggerGenerated;
import dagger.internal.InjectedFieldSignature;
import dagger.internal.QualifierMetadata;
import javax.inject.Provider;

@QualifierMetadata
@DaggerGenerated
public final class ChooseCityScreen_MembersInjector implements MembersInjector<ChooseCityScreen> {
    private final Provider<ConfigurationLocalRepository> configurationLocalRepositoryProvider;
    private final Provider<LocationConfigurationRepository> locationConfigurationRepositoryProvider;

    public ChooseCityScreen_MembersInjector(Provider<ConfigurationLocalRepository> provider, Provider<LocationConfigurationRepository> provider2) {
        this.configurationLocalRepositoryProvider = provider;
        this.locationConfigurationRepositoryProvider = provider2;
    }

    public static MembersInjector<ChooseCityScreen> create(Provider<ConfigurationLocalRepository> provider, Provider<LocationConfigurationRepository> provider2) {
        return new ChooseCityScreen_MembersInjector(provider, provider2);
    }

    @InjectedFieldSignature("com.talabat.ChooseCityScreen.configurationLocalRepository")
    public static void injectConfigurationLocalRepository(ChooseCityScreen chooseCityScreen, ConfigurationLocalRepository configurationLocalRepository) {
        chooseCityScreen.f53963k = configurationLocalRepository;
    }

    @InjectedFieldSignature("com.talabat.ChooseCityScreen.locationConfigurationRepository")
    public static void injectLocationConfigurationRepository(ChooseCityScreen chooseCityScreen, LocationConfigurationRepository locationConfigurationRepository) {
        chooseCityScreen.f53964l = locationConfigurationRepository;
    }

    public void injectMembers(ChooseCityScreen chooseCityScreen) {
        injectConfigurationLocalRepository(chooseCityScreen, this.configurationLocalRepositoryProvider.get());
        injectLocationConfigurationRepository(chooseCityScreen, this.locationConfigurationRepositoryProvider.get());
    }
}
