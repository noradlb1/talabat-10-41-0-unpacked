package com.talabat.feature.tmart.growth.data.di;

import com.talabat.configuration.ConfigurationLocalRepository;
import com.talabat.configuration.country.Country;
import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import javax.inject.Provider;

@ScopeMetadata
@DaggerGenerated
@QualifierMetadata
public final class TMartGrowthUserDataModule_ProvideCountryFactory implements Factory<Country> {
    private final Provider<ConfigurationLocalRepository> configurationLocalRepositoryProvider;

    public TMartGrowthUserDataModule_ProvideCountryFactory(Provider<ConfigurationLocalRepository> provider) {
        this.configurationLocalRepositoryProvider = provider;
    }

    public static TMartGrowthUserDataModule_ProvideCountryFactory create(Provider<ConfigurationLocalRepository> provider) {
        return new TMartGrowthUserDataModule_ProvideCountryFactory(provider);
    }

    public static Country provideCountry(ConfigurationLocalRepository configurationLocalRepository) {
        return (Country) Preconditions.checkNotNullFromProvides(TMartGrowthUserDataModule.INSTANCE.provideCountry(configurationLocalRepository));
    }

    public Country get() {
        return provideCountry(this.configurationLocalRepositoryProvider.get());
    }
}
