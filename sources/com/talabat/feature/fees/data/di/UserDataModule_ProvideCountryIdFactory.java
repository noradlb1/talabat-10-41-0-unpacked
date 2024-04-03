package com.talabat.feature.fees.data.di;

import com.talabat.configuration.di.ConfigurationLocalCoreLibApi;
import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import javax.inject.Provider;

@ScopeMetadata
@DaggerGenerated
@QualifierMetadata({"javax.inject.Named"})
public final class UserDataModule_ProvideCountryIdFactory implements Factory<Integer> {
    private final Provider<ConfigurationLocalCoreLibApi> configurationLocalCoreLibApiProvider;

    public UserDataModule_ProvideCountryIdFactory(Provider<ConfigurationLocalCoreLibApi> provider) {
        this.configurationLocalCoreLibApiProvider = provider;
    }

    public static UserDataModule_ProvideCountryIdFactory create(Provider<ConfigurationLocalCoreLibApi> provider) {
        return new UserDataModule_ProvideCountryIdFactory(provider);
    }

    public static int provideCountryId(ConfigurationLocalCoreLibApi configurationLocalCoreLibApi) {
        return UserDataModule.INSTANCE.provideCountryId(configurationLocalCoreLibApi);
    }

    public Integer get() {
        return Integer.valueOf(provideCountryId(this.configurationLocalCoreLibApiProvider.get()));
    }
}
