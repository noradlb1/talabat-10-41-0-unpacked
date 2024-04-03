package com.talabat.app.di;

import com.talabat.configuration.di.ConfigurationLocalCoreLibApi;
import com.talabat.core.context.domain.ContextCoreLibApi;
import com.talabat.core.fwf.domain.di.FWFCoreLibApi;
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
public final class CoreLibsModule_FwfCoreLibApiFactory implements Factory<FWFCoreLibApi> {
    private final Provider<ConfigurationLocalCoreLibApi> configurationLocalCoreLibApiProvider;
    private final Provider<ContextCoreLibApi> contextCoreLibApiProvider;
    private final Provider<GmsBaseCoreLibApi> gmsBaseCoreLibApiProvider;
    private final CoreLibsModule module;

    public CoreLibsModule_FwfCoreLibApiFactory(CoreLibsModule coreLibsModule, Provider<ContextCoreLibApi> provider, Provider<ConfigurationLocalCoreLibApi> provider2, Provider<GmsBaseCoreLibApi> provider3) {
        this.module = coreLibsModule;
        this.contextCoreLibApiProvider = provider;
        this.configurationLocalCoreLibApiProvider = provider2;
        this.gmsBaseCoreLibApiProvider = provider3;
    }

    public static CoreLibsModule_FwfCoreLibApiFactory create(CoreLibsModule coreLibsModule, Provider<ContextCoreLibApi> provider, Provider<ConfigurationLocalCoreLibApi> provider2, Provider<GmsBaseCoreLibApi> provider3) {
        return new CoreLibsModule_FwfCoreLibApiFactory(coreLibsModule, provider, provider2, provider3);
    }

    public static FWFCoreLibApi fwfCoreLibApi(CoreLibsModule coreLibsModule, ContextCoreLibApi contextCoreLibApi, ConfigurationLocalCoreLibApi configurationLocalCoreLibApi, GmsBaseCoreLibApi gmsBaseCoreLibApi) {
        return (FWFCoreLibApi) Preconditions.checkNotNullFromProvides(coreLibsModule.fwfCoreLibApi(contextCoreLibApi, configurationLocalCoreLibApi, gmsBaseCoreLibApi));
    }

    public FWFCoreLibApi get() {
        return fwfCoreLibApi(this.module, this.contextCoreLibApiProvider.get(), this.configurationLocalCoreLibApiProvider.get(), this.gmsBaseCoreLibApiProvider.get());
    }
}
