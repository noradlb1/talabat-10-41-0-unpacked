package com.talabat.app.di;

import com.talabat.core.context.domain.ContextCoreLibApi;
import com.talabat.core.gms.base.domain.GmsBaseCoreLibApi;
import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import javax.inject.Provider;

@ScopeMetadata("dagger.Reusable")
@DaggerGenerated
@QualifierMetadata
public final class CoreLibsModule_GmsBaseCoreLibApiFactory implements Factory<GmsBaseCoreLibApi> {
    private final Provider<ContextCoreLibApi> contextCoreLibApiProvider;
    private final CoreLibsModule module;

    public CoreLibsModule_GmsBaseCoreLibApiFactory(CoreLibsModule coreLibsModule, Provider<ContextCoreLibApi> provider) {
        this.module = coreLibsModule;
        this.contextCoreLibApiProvider = provider;
    }

    public static CoreLibsModule_GmsBaseCoreLibApiFactory create(CoreLibsModule coreLibsModule, Provider<ContextCoreLibApi> provider) {
        return new CoreLibsModule_GmsBaseCoreLibApiFactory(coreLibsModule, provider);
    }

    public static GmsBaseCoreLibApi gmsBaseCoreLibApi(CoreLibsModule coreLibsModule, ContextCoreLibApi contextCoreLibApi) {
        return (GmsBaseCoreLibApi) Preconditions.checkNotNullFromProvides(coreLibsModule.gmsBaseCoreLibApi(contextCoreLibApi));
    }

    public GmsBaseCoreLibApi get() {
        return gmsBaseCoreLibApi(this.module, this.contextCoreLibApiProvider.get());
    }
}
