package com.talabat.feature.darkstores.swimlanes.data.di;

import com.talabat.configuration.country.Country;
import com.talabat.configuration.di.ConfigurationLocalCoreLibApi;
import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import javax.inject.Provider;

@ScopeMetadata
@DaggerGenerated
@QualifierMetadata({"javax.inject.Named"})
public final class SwimlanesUserDataModule_ProvideSleectedCountryFactory implements Factory<Country> {
    private final Provider<ConfigurationLocalCoreLibApi> configurationLocalCoreLibApiProvider;

    public SwimlanesUserDataModule_ProvideSleectedCountryFactory(Provider<ConfigurationLocalCoreLibApi> provider) {
        this.configurationLocalCoreLibApiProvider = provider;
    }

    public static SwimlanesUserDataModule_ProvideSleectedCountryFactory create(Provider<ConfigurationLocalCoreLibApi> provider) {
        return new SwimlanesUserDataModule_ProvideSleectedCountryFactory(provider);
    }

    public static Country provideSleectedCountry(ConfigurationLocalCoreLibApi configurationLocalCoreLibApi) {
        return (Country) Preconditions.checkNotNullFromProvides(SwimlanesUserDataModule.INSTANCE.provideSleectedCountry(configurationLocalCoreLibApi));
    }

    public Country get() {
        return provideSleectedCountry(this.configurationLocalCoreLibApiProvider.get());
    }
}
