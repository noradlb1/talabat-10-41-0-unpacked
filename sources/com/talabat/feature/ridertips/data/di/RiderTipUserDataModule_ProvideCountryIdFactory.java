package com.talabat.feature.ridertips.data.di;

import com.talabat.configuration.di.ConfigurationLocalCoreLibApi;
import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import javax.inject.Provider;

@ScopeMetadata
@DaggerGenerated
@QualifierMetadata({"javax.inject.Named"})
public final class RiderTipUserDataModule_ProvideCountryIdFactory implements Factory<Integer> {
    private final Provider<ConfigurationLocalCoreLibApi> configurationLocalCoreLibApiProvider;

    public RiderTipUserDataModule_ProvideCountryIdFactory(Provider<ConfigurationLocalCoreLibApi> provider) {
        this.configurationLocalCoreLibApiProvider = provider;
    }

    public static RiderTipUserDataModule_ProvideCountryIdFactory create(Provider<ConfigurationLocalCoreLibApi> provider) {
        return new RiderTipUserDataModule_ProvideCountryIdFactory(provider);
    }

    public static int provideCountryId(ConfigurationLocalCoreLibApi configurationLocalCoreLibApi) {
        return RiderTipUserDataModule.INSTANCE.provideCountryId(configurationLocalCoreLibApi);
    }

    public Integer get() {
        return Integer.valueOf(provideCountryId(this.configurationLocalCoreLibApiProvider.get()));
    }
}
