package com.talabat.configuration;

import com.squareup.moshi.Moshi;
import com.talabat.configuration.remote.ConfigurationRemoteRest;
import com.talabat.configuration.remote.mapper.AppRemoteConfigMapper;
import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import javax.inject.Provider;

@ScopeMetadata("dagger.Reusable")
@DaggerGenerated
@QualifierMetadata({"com.talabat.configuration.di.AppInfoRest"})
public final class RealConfigurationRemoteRepository_Factory implements Factory<RealConfigurationRemoteRepository> {
    private final Provider<ConfigurationRemoteRest> appInfoRemoteProvider;
    private final Provider<AppRemoteConfigMapper> appRemoteConfigMapperProvider;
    private final Provider<Moshi> moshiProvider;

    public RealConfigurationRemoteRepository_Factory(Provider<ConfigurationRemoteRest> provider, Provider<AppRemoteConfigMapper> provider2, Provider<Moshi> provider3) {
        this.appInfoRemoteProvider = provider;
        this.appRemoteConfigMapperProvider = provider2;
        this.moshiProvider = provider3;
    }

    public static RealConfigurationRemoteRepository_Factory create(Provider<ConfigurationRemoteRest> provider, Provider<AppRemoteConfigMapper> provider2, Provider<Moshi> provider3) {
        return new RealConfigurationRemoteRepository_Factory(provider, provider2, provider3);
    }

    public static RealConfigurationRemoteRepository newInstance(ConfigurationRemoteRest configurationRemoteRest, AppRemoteConfigMapper appRemoteConfigMapper, Moshi moshi) {
        return new RealConfigurationRemoteRepository(configurationRemoteRest, appRemoteConfigMapper, moshi);
    }

    public RealConfigurationRemoteRepository get() {
        return newInstance(this.appInfoRemoteProvider.get(), this.appRemoteConfigMapperProvider.get(), this.moshiProvider.get());
    }
}
