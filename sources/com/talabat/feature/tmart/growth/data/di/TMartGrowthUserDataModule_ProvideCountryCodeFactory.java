package com.talabat.feature.tmart.growth.data.di;

import com.talabat.configuration.country.Country;
import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import javax.inject.Provider;

@ScopeMetadata
@DaggerGenerated
@QualifierMetadata({"javax.inject.Named"})
public final class TMartGrowthUserDataModule_ProvideCountryCodeFactory implements Factory<String> {
    private final Provider<Country> countryProvider;

    public TMartGrowthUserDataModule_ProvideCountryCodeFactory(Provider<Country> provider) {
        this.countryProvider = provider;
    }

    public static TMartGrowthUserDataModule_ProvideCountryCodeFactory create(Provider<Country> provider) {
        return new TMartGrowthUserDataModule_ProvideCountryCodeFactory(provider);
    }

    public static String provideCountryCode(Country country) {
        return (String) Preconditions.checkNotNullFromProvides(TMartGrowthUserDataModule.INSTANCE.provideCountryCode(country));
    }

    public String get() {
        return provideCountryCode(this.countryProvider.get());
    }
}
