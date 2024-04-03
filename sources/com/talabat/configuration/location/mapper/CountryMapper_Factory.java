package com.talabat.configuration.location.mapper;

import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import javax.inject.Provider;

@ScopeMetadata
@DaggerGenerated
@QualifierMetadata
public final class CountryMapper_Factory implements Factory<CountryMapper> {
    private final Provider<CityMapper> cityMapperProvider;

    public CountryMapper_Factory(Provider<CityMapper> provider) {
        this.cityMapperProvider = provider;
    }

    public static CountryMapper_Factory create(Provider<CityMapper> provider) {
        return new CountryMapper_Factory(provider);
    }

    public static CountryMapper newInstance(CityMapper cityMapper) {
        return new CountryMapper(cityMapper);
    }

    public CountryMapper get() {
        return newInstance(this.cityMapperProvider.get());
    }
}
