package com.talabat.app.di;

import com.talabat.configuration.di.ConfigurationRemoteCoreLibApi;
import com.talabat.configuration.di.MutableConfigurationRemoteCoreLibApi;
import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import javax.inject.Provider;

@ScopeMetadata("dagger.Reusable")
@DaggerGenerated
@QualifierMetadata
public final class CoreLibsModule_ConfigurationRemoteCoreLibApiFactory implements Factory<ConfigurationRemoteCoreLibApi> {
    private final Provider<MutableConfigurationRemoteCoreLibApi> apiProvider;
    private final CoreLibsModule module;

    public CoreLibsModule_ConfigurationRemoteCoreLibApiFactory(CoreLibsModule coreLibsModule, Provider<MutableConfigurationRemoteCoreLibApi> provider) {
        this.module = coreLibsModule;
        this.apiProvider = provider;
    }

    public static ConfigurationRemoteCoreLibApi configurationRemoteCoreLibApi(CoreLibsModule coreLibsModule, MutableConfigurationRemoteCoreLibApi mutableConfigurationRemoteCoreLibApi) {
        return (ConfigurationRemoteCoreLibApi) Preconditions.checkNotNullFromProvides(coreLibsModule.configurationRemoteCoreLibApi(mutableConfigurationRemoteCoreLibApi));
    }

    public static CoreLibsModule_ConfigurationRemoteCoreLibApiFactory create(CoreLibsModule coreLibsModule, Provider<MutableConfigurationRemoteCoreLibApi> provider) {
        return new CoreLibsModule_ConfigurationRemoteCoreLibApiFactory(coreLibsModule, provider);
    }

    public ConfigurationRemoteCoreLibApi get() {
        return configurationRemoteCoreLibApi(this.module, this.apiProvider.get());
    }
}
