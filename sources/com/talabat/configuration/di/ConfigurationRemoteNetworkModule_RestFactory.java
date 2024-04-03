package com.talabat.configuration.di;

import com.talabat.configuration.remote.ConfigurationRemoteRest;
import com.talabat.configuration.remote.endpoint.AppInfoBaseUrl;
import com.talabat.core.network.domain.endpoint.BaseUrlFactory;
import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import javax.inject.Provider;
import retrofit2.Retrofit;

@ScopeMetadata
@DaggerGenerated
@QualifierMetadata({"com.talabat.configuration.di.AppInfoRest", "com.talabat.core.network.domain.MoshiRetrofit"})
public final class ConfigurationRemoteNetworkModule_RestFactory implements Factory<ConfigurationRemoteRest> {
    private final Provider<AppInfoBaseUrl> appInfoBaseUrlProvider;
    private final Provider<BaseUrlFactory> baseUrlFactoryProvider;
    private final Provider<Retrofit.Builder> retrofitBuilderProvider;

    public ConfigurationRemoteNetworkModule_RestFactory(Provider<BaseUrlFactory> provider, Provider<AppInfoBaseUrl> provider2, Provider<Retrofit.Builder> provider3) {
        this.baseUrlFactoryProvider = provider;
        this.appInfoBaseUrlProvider = provider2;
        this.retrofitBuilderProvider = provider3;
    }

    public static ConfigurationRemoteNetworkModule_RestFactory create(Provider<BaseUrlFactory> provider, Provider<AppInfoBaseUrl> provider2, Provider<Retrofit.Builder> provider3) {
        return new ConfigurationRemoteNetworkModule_RestFactory(provider, provider2, provider3);
    }

    public static ConfigurationRemoteRest rest(BaseUrlFactory baseUrlFactory, AppInfoBaseUrl appInfoBaseUrl, Retrofit.Builder builder) {
        return (ConfigurationRemoteRest) Preconditions.checkNotNullFromProvides(ConfigurationRemoteNetworkModule.INSTANCE.rest(baseUrlFactory, appInfoBaseUrl, builder));
    }

    public ConfigurationRemoteRest get() {
        return rest(this.baseUrlFactoryProvider.get(), this.appInfoBaseUrlProvider.get(), this.retrofitBuilderProvider.get());
    }
}
