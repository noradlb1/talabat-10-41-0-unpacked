package com.talabat.app.di;

import com.talabat.core.context.domain.ContextCoreLibApi;
import com.talabat.core.hms.location.domain.HmsLocationCoreLibApi;
import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import javax.inject.Provider;

@ScopeMetadata("dagger.Reusable")
@DaggerGenerated
@QualifierMetadata
public final class CoreLibsModule_HmsLocationCoreLibApiFactory implements Factory<HmsLocationCoreLibApi> {
    private final Provider<ContextCoreLibApi> contextCoreLibApiProvider;
    private final CoreLibsModule module;

    public CoreLibsModule_HmsLocationCoreLibApiFactory(CoreLibsModule coreLibsModule, Provider<ContextCoreLibApi> provider) {
        this.module = coreLibsModule;
        this.contextCoreLibApiProvider = provider;
    }

    public static CoreLibsModule_HmsLocationCoreLibApiFactory create(CoreLibsModule coreLibsModule, Provider<ContextCoreLibApi> provider) {
        return new CoreLibsModule_HmsLocationCoreLibApiFactory(coreLibsModule, provider);
    }

    public static HmsLocationCoreLibApi hmsLocationCoreLibApi(CoreLibsModule coreLibsModule, ContextCoreLibApi contextCoreLibApi) {
        return (HmsLocationCoreLibApi) Preconditions.checkNotNullFromProvides(coreLibsModule.hmsLocationCoreLibApi(contextCoreLibApi));
    }

    public HmsLocationCoreLibApi get() {
        return hmsLocationCoreLibApi(this.module, this.contextCoreLibApiProvider.get());
    }
}
