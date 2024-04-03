package com.talabat.app.di;

import com.talabat.configuration.di.ConfigurationLocalCoreLibApi;
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
public final class CoreApiModule_ConfigurationLocalCoreLibApiFactory implements Factory<Api> {
    private final Provider<ConfigurationLocalCoreLibApi> configurationLocalCoreLibApiProvider;

    public CoreApiModule_ConfigurationLocalCoreLibApiFactory(Provider<ConfigurationLocalCoreLibApi> provider) {
        this.configurationLocalCoreLibApiProvider = provider;
    }

    public static Api configurationLocalCoreLibApi(ConfigurationLocalCoreLibApi configurationLocalCoreLibApi) {
        return (Api) Preconditions.checkNotNullFromProvides(CoreApiModule.INSTANCE.configurationLocalCoreLibApi(configurationLocalCoreLibApi));
    }

    public static CoreApiModule_ConfigurationLocalCoreLibApiFactory create(Provider<ConfigurationLocalCoreLibApi> provider) {
        return new CoreApiModule_ConfigurationLocalCoreLibApiFactory(provider);
    }

    public Api get() {
        return configurationLocalCoreLibApi(this.configurationLocalCoreLibApiProvider.get());
    }
}
