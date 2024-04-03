package com.talabat.feature.ridertips.presentation.di;

import com.talabat.configuration.location.LocationConfigurationRepository;
import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import javax.inject.Provider;

@ScopeMetadata
@DaggerGenerated
@QualifierMetadata({"javax.inject.Named"})
public final class RiderTipPresentationModule_ProvideNumOfDecimalPlacesFactory implements Factory<Integer> {
    private final Provider<LocationConfigurationRepository> locationConfigurationRepositoryProvider;

    public RiderTipPresentationModule_ProvideNumOfDecimalPlacesFactory(Provider<LocationConfigurationRepository> provider) {
        this.locationConfigurationRepositoryProvider = provider;
    }

    public static RiderTipPresentationModule_ProvideNumOfDecimalPlacesFactory create(Provider<LocationConfigurationRepository> provider) {
        return new RiderTipPresentationModule_ProvideNumOfDecimalPlacesFactory(provider);
    }

    public static int provideNumOfDecimalPlaces(LocationConfigurationRepository locationConfigurationRepository) {
        return RiderTipPresentationModule.INSTANCE.provideNumOfDecimalPlaces(locationConfigurationRepository);
    }

    public Integer get() {
        return Integer.valueOf(provideNumOfDecimalPlaces(this.locationConfigurationRepositoryProvider.get()));
    }
}
