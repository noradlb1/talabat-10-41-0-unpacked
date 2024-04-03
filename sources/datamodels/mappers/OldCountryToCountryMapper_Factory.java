package datamodels.mappers;

import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import javax.inject.Provider;

@ScopeMetadata("dagger.Reusable")
@DaggerGenerated
@QualifierMetadata
public final class OldCountryToCountryMapper_Factory implements Factory<OldCountryToCountryMapper> {
    private final Provider<OldCityToCityMapper> cityMapperProvider;

    public OldCountryToCountryMapper_Factory(Provider<OldCityToCityMapper> provider) {
        this.cityMapperProvider = provider;
    }

    public static OldCountryToCountryMapper_Factory create(Provider<OldCityToCityMapper> provider) {
        return new OldCountryToCountryMapper_Factory(provider);
    }

    public static OldCountryToCountryMapper newInstance(OldCityToCityMapper oldCityToCityMapper) {
        return new OldCountryToCountryMapper(oldCityToCityMapper);
    }

    public OldCountryToCountryMapper get() {
        return newInstance(this.cityMapperProvider.get());
    }
}
