package com.talabat.app.di;

import com.talabat.core.context.domain.ContextCoreLibApi;
import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;

@ScopeMetadata("dagger.Reusable")
@DaggerGenerated
@QualifierMetadata
public final class CoreLibsModule_ContextCoreLibApiFactory implements Factory<ContextCoreLibApi> {
    private final CoreLibsModule module;

    public CoreLibsModule_ContextCoreLibApiFactory(CoreLibsModule coreLibsModule) {
        this.module = coreLibsModule;
    }

    public static ContextCoreLibApi contextCoreLibApi(CoreLibsModule coreLibsModule) {
        return (ContextCoreLibApi) Preconditions.checkNotNullFromProvides(coreLibsModule.contextCoreLibApi());
    }

    public static CoreLibsModule_ContextCoreLibApiFactory create(CoreLibsModule coreLibsModule) {
        return new CoreLibsModule_ContextCoreLibApiFactory(coreLibsModule);
    }

    public ContextCoreLibApi get() {
        return contextCoreLibApi(this.module);
    }
}
