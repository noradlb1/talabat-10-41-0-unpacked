package com.talabat.app.di;

import com.talabat.core.di.Api;
import com.talabat.talabatremoteconfiguration.di.RemoteConfigCoreLibApi;
import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import javax.inject.Provider;

@ScopeMetadata("dagger.Reusable")
@DaggerGenerated
@QualifierMetadata({"com.talabat.app.di.CoreApis"})
public final class CoreApiModule_RemoteConfigCoreLibApiFactory implements Factory<Api> {
    private final Provider<RemoteConfigCoreLibApi> remoteConfigCoreLibApiProvider;

    public CoreApiModule_RemoteConfigCoreLibApiFactory(Provider<RemoteConfigCoreLibApi> provider) {
        this.remoteConfigCoreLibApiProvider = provider;
    }

    public static CoreApiModule_RemoteConfigCoreLibApiFactory create(Provider<RemoteConfigCoreLibApi> provider) {
        return new CoreApiModule_RemoteConfigCoreLibApiFactory(provider);
    }

    public static Api remoteConfigCoreLibApi(RemoteConfigCoreLibApi remoteConfigCoreLibApi) {
        return (Api) Preconditions.checkNotNullFromProvides(CoreApiModule.INSTANCE.remoteConfigCoreLibApi(remoteConfigCoreLibApi));
    }

    public Api get() {
        return remoteConfigCoreLibApi(this.remoteConfigCoreLibApiProvider.get());
    }
}
