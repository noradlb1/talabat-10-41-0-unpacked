package com.talabat.app.di;

import com.talabat.configuration.di.ConfigurationRemoteCoreLibApi;
import com.talabat.core.di.Api;
import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import javax.inject.Provider;

@ScopeMetadata("dagger.Reusable")
@DaggerGenerated
@QualifierMetadata({"com.talabat.app.di.CoreApis"})
public final class CoreApiModule_ConfigurationRemoteCoreLibApiFactory implements Factory<Api> {
    private final Provider<ConfigurationRemoteCoreLibApi> configurationRemoteCoreLibApiProvider;

    public CoreApiModule_ConfigurationRemoteCoreLibApiFactory(Provider<ConfigurationRemoteCoreLibApi> provider) {
        this.configurationRemoteCoreLibApiProvider = provider;
    }

    public static Api configurationRemoteCoreLibApi(ConfigurationRemoteCoreLibApi configurationRemoteCoreLibApi) {
        return (Api) Preconditions.checkNotNullFromProvides(CoreApiModule.INSTANCE.configurationRemoteCoreLibApi(configurationRemoteCoreLibApi));
    }

    public static CoreApiModule_ConfigurationRemoteCoreLibApiFactory create(Provider<ConfigurationRemoteCoreLibApi> provider) {
        return new CoreApiModule_ConfigurationRemoteCoreLibApiFactory(provider);
    }

    public Api get() {
        return configurationRemoteCoreLibApi(this.configurationRemoteCoreLibApiProvider.get());
    }
}
