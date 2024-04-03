package com.talabat.app.di;

import com.talabat.configuration.di.ConfigurationLocalCoreLibApi;
import com.talabat.configuration.di.MutableConfigurationLocalCoreLibApi;
import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import javax.inject.Provider;

@ScopeMetadata("dagger.Reusable")
@DaggerGenerated
@QualifierMetadata
public final class CoreLibsModule_ConfigurationLocalCoreLibApiFactory implements Factory<ConfigurationLocalCoreLibApi> {
    private final Provider<MutableConfigurationLocalCoreLibApi> apiProvider;
    private final CoreLibsModule module;

    public CoreLibsModule_ConfigurationLocalCoreLibApiFactory(CoreLibsModule coreLibsModule, Provider<MutableConfigurationLocalCoreLibApi> provider) {
        this.module = coreLibsModule;
        this.apiProvider = provider;
    }

    public static ConfigurationLocalCoreLibApi configurationLocalCoreLibApi(CoreLibsModule coreLibsModule, MutableConfigurationLocalCoreLibApi mutableConfigurationLocalCoreLibApi) {
        return (ConfigurationLocalCoreLibApi) Preconditions.checkNotNullFromProvides(coreLibsModule.configurationLocalCoreLibApi(mutableConfigurationLocalCoreLibApi));
    }

    public static CoreLibsModule_ConfigurationLocalCoreLibApiFactory create(CoreLibsModule coreLibsModule, Provider<MutableConfigurationLocalCoreLibApi> provider) {
        return new CoreLibsModule_ConfigurationLocalCoreLibApiFactory(coreLibsModule, provider);
    }

    public ConfigurationLocalCoreLibApi get() {
        return configurationLocalCoreLibApi(this.module, this.apiProvider.get());
    }
}
