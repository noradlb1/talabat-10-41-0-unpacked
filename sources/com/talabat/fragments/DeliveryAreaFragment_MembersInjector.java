package com.talabat.fragments;

import com.talabat.configuration.ConfigurationLocalRepository;
import com.talabat.configuration.location.LocationConfigurationRepository;
import dagger.MembersInjector;
import dagger.internal.DaggerGenerated;
import dagger.internal.InjectedFieldSignature;
import dagger.internal.QualifierMetadata;
import javax.inject.Provider;

@QualifierMetadata
@DaggerGenerated
public final class DeliveryAreaFragment_MembersInjector implements MembersInjector<DeliveryAreaFragment> {
    private final Provider<ConfigurationLocalRepository> configurationLocalRepositoryProvider;
    private final Provider<LocationConfigurationRepository> locationConfigurationRepositoryProvider;

    public DeliveryAreaFragment_MembersInjector(Provider<ConfigurationLocalRepository> provider, Provider<LocationConfigurationRepository> provider2) {
        this.configurationLocalRepositoryProvider = provider;
        this.locationConfigurationRepositoryProvider = provider2;
    }

    public static MembersInjector<DeliveryAreaFragment> create(Provider<ConfigurationLocalRepository> provider, Provider<LocationConfigurationRepository> provider2) {
        return new DeliveryAreaFragment_MembersInjector(provider, provider2);
    }

    @InjectedFieldSignature("com.talabat.fragments.DeliveryAreaFragment.configurationLocalRepository")
    public static void injectConfigurationLocalRepository(DeliveryAreaFragment deliveryAreaFragment, ConfigurationLocalRepository configurationLocalRepository) {
        deliveryAreaFragment.configurationLocalRepository = configurationLocalRepository;
    }

    @InjectedFieldSignature("com.talabat.fragments.DeliveryAreaFragment.locationConfigurationRepository")
    public static void injectLocationConfigurationRepository(DeliveryAreaFragment deliveryAreaFragment, LocationConfigurationRepository locationConfigurationRepository) {
        deliveryAreaFragment.locationConfigurationRepository = locationConfigurationRepository;
    }

    public void injectMembers(DeliveryAreaFragment deliveryAreaFragment) {
        injectConfigurationLocalRepository(deliveryAreaFragment, this.configurationLocalRepositoryProvider.get());
        injectLocationConfigurationRepository(deliveryAreaFragment, this.locationConfigurationRepositoryProvider.get());
    }
}
