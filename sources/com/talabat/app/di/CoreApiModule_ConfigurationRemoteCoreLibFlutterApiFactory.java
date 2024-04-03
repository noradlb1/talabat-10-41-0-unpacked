package com.talabat.app.di;

import com.talabat.configuration.di.flutter.ConfigurationRemoteCoreLibFlutterApi;
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
public final class CoreApiModule_ConfigurationRemoteCoreLibFlutterApiFactory implements Factory<Api> {
    private final Provider<ConfigurationRemoteCoreLibFlutterApi> configurationRemoteCoreLibFlutterApiProvider;

    public CoreApiModule_ConfigurationRemoteCoreLibFlutterApiFactory(Provider<ConfigurationRemoteCoreLibFlutterApi> provider) {
        this.configurationRemoteCoreLibFlutterApiProvider = provider;
    }

    public static Api configurationRemoteCoreLibFlutterApi(ConfigurationRemoteCoreLibFlutterApi configurationRemoteCoreLibFlutterApi) {
        return (Api) Preconditions.checkNotNullFromProvides(CoreApiModule.INSTANCE.configurationRemoteCoreLibFlutterApi(configurationRemoteCoreLibFlutterApi));
    }

    public static CoreApiModule_ConfigurationRemoteCoreLibFlutterApiFactory create(Provider<ConfigurationRemoteCoreLibFlutterApi> provider) {
        return new CoreApiModule_ConfigurationRemoteCoreLibFlutterApiFactory(provider);
    }

    public Api get() {
        return configurationRemoteCoreLibFlutterApi(this.configurationRemoteCoreLibFlutterApiProvider.get());
    }
}
