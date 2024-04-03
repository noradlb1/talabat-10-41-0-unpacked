package com.talabat.address.list;

import com.talabat.configuration.ConfigurationLocalRepository;
import com.talabat.core.tracking.domain.TalabatTracker;
import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import javax.inject.Provider;

@ScopeMetadata
@DaggerGenerated
@QualifierMetadata
public final class AddressListModule_AddressListEventsListenerFactory implements Factory<AddressListEventsListener> {
    private final Provider<ConfigurationLocalRepository> configurationLocalRepositoryProvider;
    private final Provider<TalabatTracker> talabatTrackerProvider;

    public AddressListModule_AddressListEventsListenerFactory(Provider<TalabatTracker> provider, Provider<ConfigurationLocalRepository> provider2) {
        this.talabatTrackerProvider = provider;
        this.configurationLocalRepositoryProvider = provider2;
    }

    public static AddressListEventsListener addressListEventsListener(TalabatTracker talabatTracker, ConfigurationLocalRepository configurationLocalRepository) {
        return (AddressListEventsListener) Preconditions.checkNotNullFromProvides(AddressListModule.addressListEventsListener(talabatTracker, configurationLocalRepository));
    }

    public static AddressListModule_AddressListEventsListenerFactory create(Provider<TalabatTracker> provider, Provider<ConfigurationLocalRepository> provider2) {
        return new AddressListModule_AddressListEventsListenerFactory(provider, provider2);
    }

    public AddressListEventsListener get() {
        return addressListEventsListener(this.talabatTrackerProvider.get(), this.configurationLocalRepositoryProvider.get());
    }
}
