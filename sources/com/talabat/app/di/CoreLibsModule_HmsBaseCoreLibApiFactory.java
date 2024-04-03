package com.talabat.app.di;

import com.talabat.core.context.domain.ContextCoreLibApi;
import com.talabat.core.hms.base.domain.HmsBaseCoreLibApi;
import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import javax.inject.Provider;

@ScopeMetadata("dagger.Reusable")
@DaggerGenerated
@QualifierMetadata
public final class CoreLibsModule_HmsBaseCoreLibApiFactory implements Factory<HmsBaseCoreLibApi> {
    private final Provider<ContextCoreLibApi> contextCoreLibApiProvider;
    private final CoreLibsModule module;

    public CoreLibsModule_HmsBaseCoreLibApiFactory(CoreLibsModule coreLibsModule, Provider<ContextCoreLibApi> provider) {
        this.module = coreLibsModule;
        this.contextCoreLibApiProvider = provider;
    }

    public static CoreLibsModule_HmsBaseCoreLibApiFactory create(CoreLibsModule coreLibsModule, Provider<ContextCoreLibApi> provider) {
        return new CoreLibsModule_HmsBaseCoreLibApiFactory(coreLibsModule, provider);
    }

    public static HmsBaseCoreLibApi hmsBaseCoreLibApi(CoreLibsModule coreLibsModule, ContextCoreLibApi contextCoreLibApi) {
        return (HmsBaseCoreLibApi) Preconditions.checkNotNullFromProvides(coreLibsModule.hmsBaseCoreLibApi(contextCoreLibApi));
    }

    public HmsBaseCoreLibApi get() {
        return hmsBaseCoreLibApi(this.module, this.contextCoreLibApiProvider.get());
    }
}
