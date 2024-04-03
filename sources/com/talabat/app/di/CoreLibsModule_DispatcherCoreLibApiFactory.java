package com.talabat.app.di;

import com.talabat.core.dispatcher.domain.DispatcherCoreLibApi;
import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;

@ScopeMetadata("dagger.Reusable")
@DaggerGenerated
@QualifierMetadata
public final class CoreLibsModule_DispatcherCoreLibApiFactory implements Factory<DispatcherCoreLibApi> {
    private final CoreLibsModule module;

    public CoreLibsModule_DispatcherCoreLibApiFactory(CoreLibsModule coreLibsModule) {
        this.module = coreLibsModule;
    }

    public static CoreLibsModule_DispatcherCoreLibApiFactory create(CoreLibsModule coreLibsModule) {
        return new CoreLibsModule_DispatcherCoreLibApiFactory(coreLibsModule);
    }

    public static DispatcherCoreLibApi dispatcherCoreLibApi(CoreLibsModule coreLibsModule) {
        return (DispatcherCoreLibApi) Preconditions.checkNotNullFromProvides(coreLibsModule.dispatcherCoreLibApi());
    }

    public DispatcherCoreLibApi get() {
        return dispatcherCoreLibApi(this.module);
    }
}
