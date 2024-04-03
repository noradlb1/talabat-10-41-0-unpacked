package com.talabat.app.di;

import com.talabat.configuration.di.ConfigurationRemoteCoreLibApi;
import com.talabat.configuration.di.flutter.ConfigurationRemoteCoreLibFlutterApi;
import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import javax.inject.Provider;

@ScopeMetadata("dagger.Reusable")
@DaggerGenerated
@QualifierMetadata
public final class CoreLibsModule_ConfigurationRemoteCoreLibFlutterApiFactory implements Factory<ConfigurationRemoteCoreLibFlutterApi> {
    private final Provider<ConfigurationRemoteCoreLibApi> configurationRemoteCoreLibApiProvider;
    private final CoreLibsModule module;

    public CoreLibsModule_ConfigurationRemoteCoreLibFlutterApiFactory(CoreLibsModule coreLibsModule, Provider<ConfigurationRemoteCoreLibApi> provider) {
        this.module = coreLibsModule;
        this.configurationRemoteCoreLibApiProvider = provider;
    }

    public static ConfigurationRemoteCoreLibFlutterApi configurationRemoteCoreLibFlutterApi(CoreLibsModule coreLibsModule, ConfigurationRemoteCoreLibApi configurationRemoteCoreLibApi) {
        return (ConfigurationRemoteCoreLibFlutterApi) Preconditions.checkNotNullFromProvides(coreLibsModule.configurationRemoteCoreLibFlutterApi(configurationRemoteCoreLibApi));
    }

    public static CoreLibsModule_ConfigurationRemoteCoreLibFlutterApiFactory create(CoreLibsModule coreLibsModule, Provider<ConfigurationRemoteCoreLibApi> provider) {
        return new CoreLibsModule_ConfigurationRemoteCoreLibFlutterApiFactory(coreLibsModule, provider);
    }

    public ConfigurationRemoteCoreLibFlutterApi get() {
        return configurationRemoteCoreLibFlutterApi(this.module, this.configurationRemoteCoreLibApiProvider.get());
    }
}
