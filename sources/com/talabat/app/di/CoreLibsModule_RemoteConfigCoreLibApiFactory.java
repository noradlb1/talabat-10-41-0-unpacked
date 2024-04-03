package com.talabat.app.di;

import com.talabat.talabatremoteconfiguration.di.RemoteConfigCoreLibApi;
import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;

@ScopeMetadata("dagger.Reusable")
@DaggerGenerated
@QualifierMetadata
public final class CoreLibsModule_RemoteConfigCoreLibApiFactory implements Factory<RemoteConfigCoreLibApi> {
    private final CoreLibsModule module;

    public CoreLibsModule_RemoteConfigCoreLibApiFactory(CoreLibsModule coreLibsModule) {
        this.module = coreLibsModule;
    }

    public static CoreLibsModule_RemoteConfigCoreLibApiFactory create(CoreLibsModule coreLibsModule) {
        return new CoreLibsModule_RemoteConfigCoreLibApiFactory(coreLibsModule);
    }

    public static RemoteConfigCoreLibApi remoteConfigCoreLibApi(CoreLibsModule coreLibsModule) {
        return (RemoteConfigCoreLibApi) Preconditions.checkNotNullFromProvides(coreLibsModule.remoteConfigCoreLibApi());
    }

    public RemoteConfigCoreLibApi get() {
        return remoteConfigCoreLibApi(this.module);
    }
}
