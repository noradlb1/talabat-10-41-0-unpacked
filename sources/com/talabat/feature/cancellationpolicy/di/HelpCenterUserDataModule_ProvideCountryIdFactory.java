package com.talabat.feature.cancellationpolicy.di;

import com.talabat.configuration.di.ConfigurationLocalCoreLibApi;
import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import javax.inject.Provider;

@ScopeMetadata
@DaggerGenerated
@QualifierMetadata({"javax.inject.Named"})
public final class HelpCenterUserDataModule_ProvideCountryIdFactory implements Factory<Integer> {
    private final Provider<ConfigurationLocalCoreLibApi> configurationLocalCoreLibApiProvider;

    public HelpCenterUserDataModule_ProvideCountryIdFactory(Provider<ConfigurationLocalCoreLibApi> provider) {
        this.configurationLocalCoreLibApiProvider = provider;
    }

    public static HelpCenterUserDataModule_ProvideCountryIdFactory create(Provider<ConfigurationLocalCoreLibApi> provider) {
        return new HelpCenterUserDataModule_ProvideCountryIdFactory(provider);
    }

    public static int provideCountryId(ConfigurationLocalCoreLibApi configurationLocalCoreLibApi) {
        return HelpCenterUserDataModule.INSTANCE.provideCountryId(configurationLocalCoreLibApi);
    }

    public Integer get() {
        return Integer.valueOf(provideCountryId(this.configurationLocalCoreLibApiProvider.get()));
    }
}
