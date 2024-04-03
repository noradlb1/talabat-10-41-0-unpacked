package com.talabat.app.di;

import com.talabat.core.context.domain.ContextCoreLibApi;
import com.talabat.core.observabilityNew.domain.ObservabilityCoreLibApi;
import com.talabat.hms.maps.domain.di.HmsMapsCoreLibApi;
import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import javax.inject.Provider;

@ScopeMetadata("dagger.Reusable")
@DaggerGenerated
@QualifierMetadata
public final class CoreLibsModule_HmsMapsCoreLibApiFactory implements Factory<HmsMapsCoreLibApi> {
    private final Provider<ContextCoreLibApi> contextCoreLibApiProvider;
    private final CoreLibsModule module;
    private final Provider<ObservabilityCoreLibApi> observabilityCoreLibApiProvider;

    public CoreLibsModule_HmsMapsCoreLibApiFactory(CoreLibsModule coreLibsModule, Provider<ContextCoreLibApi> provider, Provider<ObservabilityCoreLibApi> provider2) {
        this.module = coreLibsModule;
        this.contextCoreLibApiProvider = provider;
        this.observabilityCoreLibApiProvider = provider2;
    }

    public static CoreLibsModule_HmsMapsCoreLibApiFactory create(CoreLibsModule coreLibsModule, Provider<ContextCoreLibApi> provider, Provider<ObservabilityCoreLibApi> provider2) {
        return new CoreLibsModule_HmsMapsCoreLibApiFactory(coreLibsModule, provider, provider2);
    }

    public static HmsMapsCoreLibApi hmsMapsCoreLibApi(CoreLibsModule coreLibsModule, ContextCoreLibApi contextCoreLibApi, ObservabilityCoreLibApi observabilityCoreLibApi) {
        return (HmsMapsCoreLibApi) Preconditions.checkNotNullFromProvides(coreLibsModule.hmsMapsCoreLibApi(contextCoreLibApi, observabilityCoreLibApi));
    }

    public HmsMapsCoreLibApi get() {
        return hmsMapsCoreLibApi(this.module, this.contextCoreLibApiProvider.get(), this.observabilityCoreLibApiProvider.get());
    }
}
