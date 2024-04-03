package com.talabat.app.di;

import com.talabat.core.context.domain.ContextCoreLibApi;
import com.talabat.core.observabilityNew.domain.ObservabilityCoreLibApi;
import com.talabat.core.perseus.domain.TalabatPerseusCoreLibApi;
import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import javax.inject.Provider;

@ScopeMetadata("dagger.Reusable")
@DaggerGenerated
@QualifierMetadata
public final class CoreLibsModule_ObservabilityCoreLibApiFactory implements Factory<ObservabilityCoreLibApi> {
    private final Provider<ContextCoreLibApi> contextCoreLibApiProvider;
    private final CoreLibsModule module;
    private final Provider<TalabatPerseusCoreLibApi> talabatPerseusCoreLibApiProvider;

    public CoreLibsModule_ObservabilityCoreLibApiFactory(CoreLibsModule coreLibsModule, Provider<ContextCoreLibApi> provider, Provider<TalabatPerseusCoreLibApi> provider2) {
        this.module = coreLibsModule;
        this.contextCoreLibApiProvider = provider;
        this.talabatPerseusCoreLibApiProvider = provider2;
    }

    public static CoreLibsModule_ObservabilityCoreLibApiFactory create(CoreLibsModule coreLibsModule, Provider<ContextCoreLibApi> provider, Provider<TalabatPerseusCoreLibApi> provider2) {
        return new CoreLibsModule_ObservabilityCoreLibApiFactory(coreLibsModule, provider, provider2);
    }

    public static ObservabilityCoreLibApi observabilityCoreLibApi(CoreLibsModule coreLibsModule, ContextCoreLibApi contextCoreLibApi, TalabatPerseusCoreLibApi talabatPerseusCoreLibApi) {
        return (ObservabilityCoreLibApi) Preconditions.checkNotNullFromProvides(coreLibsModule.observabilityCoreLibApi(contextCoreLibApi, talabatPerseusCoreLibApi));
    }

    public ObservabilityCoreLibApi get() {
        return observabilityCoreLibApi(this.module, this.contextCoreLibApiProvider.get(), this.talabatPerseusCoreLibApiProvider.get());
    }
}
