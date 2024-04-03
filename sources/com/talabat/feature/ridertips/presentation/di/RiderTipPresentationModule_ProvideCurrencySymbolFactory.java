package com.talabat.feature.ridertips.presentation.di;

import com.talabat.configuration.location.LocationConfigurationRepository;
import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import javax.inject.Provider;

@ScopeMetadata
@DaggerGenerated
@QualifierMetadata({"javax.inject.Named"})
public final class RiderTipPresentationModule_ProvideCurrencySymbolFactory implements Factory<String> {
    private final Provider<LocationConfigurationRepository> locationConfigurationRepositoryProvider;

    public RiderTipPresentationModule_ProvideCurrencySymbolFactory(Provider<LocationConfigurationRepository> provider) {
        this.locationConfigurationRepositoryProvider = provider;
    }

    public static RiderTipPresentationModule_ProvideCurrencySymbolFactory create(Provider<LocationConfigurationRepository> provider) {
        return new RiderTipPresentationModule_ProvideCurrencySymbolFactory(provider);
    }

    public static String provideCurrencySymbol(LocationConfigurationRepository locationConfigurationRepository) {
        return (String) Preconditions.checkNotNullFromProvides(RiderTipPresentationModule.INSTANCE.provideCurrencySymbol(locationConfigurationRepository));
    }

    public String get() {
        return provideCurrencySymbol(this.locationConfigurationRepositoryProvider.get());
    }
}
