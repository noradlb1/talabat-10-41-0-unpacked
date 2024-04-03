package com.talabat.configuration.location;

import com.talabat.configuration.ConfigurationLocalRepository;
import com.talabat.core.featureflag.domain.ITalabatFeatureFlag;
import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import datamodels.mappers.OldAreaToAreaMapper;
import datamodels.mappers.OldCountryToCountryMapper;
import javax.inject.Provider;

@ScopeMetadata("dagger.Reusable")
@DaggerGenerated
@QualifierMetadata
public final class LegacyLocationConfigurationRepository_Factory implements Factory<LegacyLocationConfigurationRepository> {
    private final Provider<OldAreaToAreaMapper> areaMapperProvider;
    private final Provider<ConfigurationLocalRepository> configurationLocalRepositoryProvider;
    private final Provider<OldCountryToCountryMapper> countryMapperProvider;
    private final Provider<ITalabatFeatureFlag> featureFlagsProvider;
    private final Provider<RealLocationConfigurationRepository> realRepositoryProvider;

    public LegacyLocationConfigurationRepository_Factory(Provider<RealLocationConfigurationRepository> provider, Provider<ConfigurationLocalRepository> provider2, Provider<ITalabatFeatureFlag> provider3, Provider<OldAreaToAreaMapper> provider4, Provider<OldCountryToCountryMapper> provider5) {
        this.realRepositoryProvider = provider;
        this.configurationLocalRepositoryProvider = provider2;
        this.featureFlagsProvider = provider3;
        this.areaMapperProvider = provider4;
        this.countryMapperProvider = provider5;
    }

    public static LegacyLocationConfigurationRepository_Factory create(Provider<RealLocationConfigurationRepository> provider, Provider<ConfigurationLocalRepository> provider2, Provider<ITalabatFeatureFlag> provider3, Provider<OldAreaToAreaMapper> provider4, Provider<OldCountryToCountryMapper> provider5) {
        return new LegacyLocationConfigurationRepository_Factory(provider, provider2, provider3, provider4, provider5);
    }

    public static LegacyLocationConfigurationRepository newInstance(RealLocationConfigurationRepository realLocationConfigurationRepository, ConfigurationLocalRepository configurationLocalRepository, ITalabatFeatureFlag iTalabatFeatureFlag, OldAreaToAreaMapper oldAreaToAreaMapper, OldCountryToCountryMapper oldCountryToCountryMapper) {
        return new LegacyLocationConfigurationRepository(realLocationConfigurationRepository, configurationLocalRepository, iTalabatFeatureFlag, oldAreaToAreaMapper, oldCountryToCountryMapper);
    }

    public LegacyLocationConfigurationRepository get() {
        return newInstance(this.realRepositoryProvider.get(), this.configurationLocalRepositoryProvider.get(), this.featureFlagsProvider.get(), this.areaMapperProvider.get(), this.countryMapperProvider.get());
    }
}
