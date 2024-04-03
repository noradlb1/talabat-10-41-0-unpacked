package com.talabat.app.di;

import com.talabat.core.context.domain.ContextCoreLibApi;
import com.talabat.core.gms.location.domain.GmsLocationCoreLibApi;
import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import javax.inject.Provider;

@ScopeMetadata("dagger.Reusable")
@DaggerGenerated
@QualifierMetadata
public final class CoreLibsModule_GmsLocationCoreLibApiFactory implements Factory<GmsLocationCoreLibApi> {
    private final Provider<ContextCoreLibApi> contextCoreLibApiProvider;
    private final CoreLibsModule module;

    public CoreLibsModule_GmsLocationCoreLibApiFactory(CoreLibsModule coreLibsModule, Provider<ContextCoreLibApi> provider) {
        this.module = coreLibsModule;
        this.contextCoreLibApiProvider = provider;
    }

    public static CoreLibsModule_GmsLocationCoreLibApiFactory create(CoreLibsModule coreLibsModule, Provider<ContextCoreLibApi> provider) {
        return new CoreLibsModule_GmsLocationCoreLibApiFactory(coreLibsModule, provider);
    }

    public static GmsLocationCoreLibApi gmsLocationCoreLibApi(CoreLibsModule coreLibsModule, ContextCoreLibApi contextCoreLibApi) {
        return (GmsLocationCoreLibApi) Preconditions.checkNotNullFromProvides(coreLibsModule.gmsLocationCoreLibApi(contextCoreLibApi));
    }

    public GmsLocationCoreLibApi get() {
        return gmsLocationCoreLibApi(this.module, this.contextCoreLibApiProvider.get());
    }
}
