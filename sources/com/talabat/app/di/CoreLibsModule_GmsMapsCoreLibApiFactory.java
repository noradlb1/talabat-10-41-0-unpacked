package com.talabat.app.di;

import com.talabat.core.context.domain.ContextCoreLibApi;
import com.talabat.core.observabilityNew.domain.ObservabilityCoreLibApi;
import com.talabat.gms.maps.domain.di.GmsMapsCoreLibApi;
import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import javax.inject.Provider;

@ScopeMetadata("dagger.Reusable")
@DaggerGenerated
@QualifierMetadata
public final class CoreLibsModule_GmsMapsCoreLibApiFactory implements Factory<GmsMapsCoreLibApi> {
    private final Provider<ContextCoreLibApi> contextCoreLibApiProvider;
    private final CoreLibsModule module;
    private final Provider<ObservabilityCoreLibApi> observabilityCoreLibApiProvider;

    public CoreLibsModule_GmsMapsCoreLibApiFactory(CoreLibsModule coreLibsModule, Provider<ContextCoreLibApi> provider, Provider<ObservabilityCoreLibApi> provider2) {
        this.module = coreLibsModule;
        this.contextCoreLibApiProvider = provider;
        this.observabilityCoreLibApiProvider = provider2;
    }

    public static CoreLibsModule_GmsMapsCoreLibApiFactory create(CoreLibsModule coreLibsModule, Provider<ContextCoreLibApi> provider, Provider<ObservabilityCoreLibApi> provider2) {
        return new CoreLibsModule_GmsMapsCoreLibApiFactory(coreLibsModule, provider, provider2);
    }

    public static GmsMapsCoreLibApi gmsMapsCoreLibApi(CoreLibsModule coreLibsModule, ContextCoreLibApi contextCoreLibApi, ObservabilityCoreLibApi observabilityCoreLibApi) {
        return (GmsMapsCoreLibApi) Preconditions.checkNotNullFromProvides(coreLibsModule.gmsMapsCoreLibApi(contextCoreLibApi, observabilityCoreLibApi));
    }

    public GmsMapsCoreLibApi get() {
        return gmsMapsCoreLibApi(this.module, this.contextCoreLibApiProvider.get(), this.observabilityCoreLibApiProvider.get());
    }
}
