package com.talabat.app.di;

import com.talabat.core.dispatcher.domain.DispatcherCoreLibApi;
import com.talabat.core.experiment.domain.ExperimentCoreLibApi;
import com.talabat.onboarding.domain.di.OnBoardingExperimentApi;
import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import javax.inject.Provider;

@ScopeMetadata("dagger.Reusable")
@DaggerGenerated
@QualifierMetadata
public final class CoreLibsModule_OnBoardingExperimentApiFactory implements Factory<OnBoardingExperimentApi> {
    private final Provider<DispatcherCoreLibApi> dispatcherCoreLibApiProvider;
    private final Provider<ExperimentCoreLibApi> experimentCoreLibApiProvider;
    private final CoreLibsModule module;

    public CoreLibsModule_OnBoardingExperimentApiFactory(CoreLibsModule coreLibsModule, Provider<DispatcherCoreLibApi> provider, Provider<ExperimentCoreLibApi> provider2) {
        this.module = coreLibsModule;
        this.dispatcherCoreLibApiProvider = provider;
        this.experimentCoreLibApiProvider = provider2;
    }

    public static CoreLibsModule_OnBoardingExperimentApiFactory create(CoreLibsModule coreLibsModule, Provider<DispatcherCoreLibApi> provider, Provider<ExperimentCoreLibApi> provider2) {
        return new CoreLibsModule_OnBoardingExperimentApiFactory(coreLibsModule, provider, provider2);
    }

    public static OnBoardingExperimentApi onBoardingExperimentApi(CoreLibsModule coreLibsModule, DispatcherCoreLibApi dispatcherCoreLibApi, ExperimentCoreLibApi experimentCoreLibApi) {
        return (OnBoardingExperimentApi) Preconditions.checkNotNullFromProvides(coreLibsModule.onBoardingExperimentApi(dispatcherCoreLibApi, experimentCoreLibApi));
    }

    public OnBoardingExperimentApi get() {
        return onBoardingExperimentApi(this.module, this.dispatcherCoreLibApiProvider.get(), this.experimentCoreLibApiProvider.get());
    }
}
