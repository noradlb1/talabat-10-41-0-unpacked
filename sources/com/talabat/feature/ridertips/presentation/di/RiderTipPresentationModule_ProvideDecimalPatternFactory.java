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
public final class RiderTipPresentationModule_ProvideDecimalPatternFactory implements Factory<String> {
    private final Provider<LocationConfigurationRepository> locationConfigurationRepositoryProvider;

    public RiderTipPresentationModule_ProvideDecimalPatternFactory(Provider<LocationConfigurationRepository> provider) {
        this.locationConfigurationRepositoryProvider = provider;
    }

    public static RiderTipPresentationModule_ProvideDecimalPatternFactory create(Provider<LocationConfigurationRepository> provider) {
        return new RiderTipPresentationModule_ProvideDecimalPatternFactory(provider);
    }

    public static String provideDecimalPattern(LocationConfigurationRepository locationConfigurationRepository) {
        return (String) Preconditions.checkNotNullFromProvides(RiderTipPresentationModule.INSTANCE.provideDecimalPattern(locationConfigurationRepository));
    }

    public String get() {
        return provideDecimalPattern(this.locationConfigurationRepositoryProvider.get());
    }
}
