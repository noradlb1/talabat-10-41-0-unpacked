package com.talabat.configuration.location.mapper;

import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import javax.inject.Provider;

@ScopeMetadata
@DaggerGenerated
@QualifierMetadata
public final class LocationConfigMapper_Factory implements Factory<LocationConfigMapper> {
    private final Provider<AreaMapper> areaMapperProvider;
    private final Provider<CountryMapper> countryMapperProvider;

    public LocationConfigMapper_Factory(Provider<AreaMapper> provider, Provider<CountryMapper> provider2) {
        this.areaMapperProvider = provider;
        this.countryMapperProvider = provider2;
    }

    public static LocationConfigMapper_Factory create(Provider<AreaMapper> provider, Provider<CountryMapper> provider2) {
        return new LocationConfigMapper_Factory(provider, provider2);
    }

    public static LocationConfigMapper newInstance(AreaMapper areaMapper, CountryMapper countryMapper) {
        return new LocationConfigMapper(areaMapper, countryMapper);
    }

    public LocationConfigMapper get() {
        return newInstance(this.areaMapperProvider.get(), this.countryMapperProvider.get());
    }
}
