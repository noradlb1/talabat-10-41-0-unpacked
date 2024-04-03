package com.talabat.feature.rating.data.di;

import com.talabat.configuration.di.ConfigurationLocalCoreLibApi;
import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import javax.inject.Provider;

@ScopeMetadata
@DaggerGenerated
@QualifierMetadata({"javax.inject.Named"})
public final class RatingUserDataModule_ProvideCountryIdFactory implements Factory<Integer> {
    private final Provider<ConfigurationLocalCoreLibApi> configurationLocalCoreLibApiProvider;

    public RatingUserDataModule_ProvideCountryIdFactory(Provider<ConfigurationLocalCoreLibApi> provider) {
        this.configurationLocalCoreLibApiProvider = provider;
    }

    public static RatingUserDataModule_ProvideCountryIdFactory create(Provider<ConfigurationLocalCoreLibApi> provider) {
        return new RatingUserDataModule_ProvideCountryIdFactory(provider);
    }

    public static int provideCountryId(ConfigurationLocalCoreLibApi configurationLocalCoreLibApi) {
        return RatingUserDataModule.INSTANCE.provideCountryId(configurationLocalCoreLibApi);
    }

    public Integer get() {
        return Integer.valueOf(provideCountryId(this.configurationLocalCoreLibApiProvider.get()));
    }
}
