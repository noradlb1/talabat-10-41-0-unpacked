package com.talabat.app.di;

import com.talabat.core.di.Api;
import com.talabat.core.experiment.domain.ExperimentCoreLibApi;
import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import javax.inject.Provider;

@ScopeMetadata("dagger.Reusable")
@DaggerGenerated
@QualifierMetadata({"com.talabat.app.di.CoreApis"})
public final class CoreApiModule_ExperimentCoreLibApiFactory implements Factory<Api> {
    private final Provider<ExperimentCoreLibApi> experimentCoreLibApiProvider;

    public CoreApiModule_ExperimentCoreLibApiFactory(Provider<ExperimentCoreLibApi> provider) {
        this.experimentCoreLibApiProvider = provider;
    }

    public static CoreApiModule_ExperimentCoreLibApiFactory create(Provider<ExperimentCoreLibApi> provider) {
        return new CoreApiModule_ExperimentCoreLibApiFactory(provider);
    }

    public static Api experimentCoreLibApi(ExperimentCoreLibApi experimentCoreLibApi) {
        return (Api) Preconditions.checkNotNullFromProvides(CoreApiModule.INSTANCE.experimentCoreLibApi(experimentCoreLibApi));
    }

    public Api get() {
        return experimentCoreLibApi(this.experimentCoreLibApiProvider.get());
    }
}
