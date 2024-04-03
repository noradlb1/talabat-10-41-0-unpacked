package com.talabat.app.di;

import com.talabat.core.experiment.domain.ExperimentCoreLibApi;
import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;

@ScopeMetadata("dagger.Reusable")
@DaggerGenerated
@QualifierMetadata
public final class CoreLibsModule_ExperimentCoreLibApiFactory implements Factory<ExperimentCoreLibApi> {
    private final CoreLibsModule module;

    public CoreLibsModule_ExperimentCoreLibApiFactory(CoreLibsModule coreLibsModule) {
        this.module = coreLibsModule;
    }

    public static CoreLibsModule_ExperimentCoreLibApiFactory create(CoreLibsModule coreLibsModule) {
        return new CoreLibsModule_ExperimentCoreLibApiFactory(coreLibsModule);
    }

    public static ExperimentCoreLibApi experimentCoreLibApi(CoreLibsModule coreLibsModule) {
        return (ExperimentCoreLibApi) Preconditions.checkNotNullFromProvides(coreLibsModule.experimentCoreLibApi());
    }

    public ExperimentCoreLibApi get() {
        return experimentCoreLibApi(this.module);
    }
}
