package com.talabat.app.di;

import com.talabat.core.di.Api;
import com.talabat.onboarding.domain.di.OnBoardingExperimentApi;
import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import javax.inject.Provider;

@ScopeMetadata("dagger.Reusable")
@DaggerGenerated
@QualifierMetadata({"com.talabat.app.di.CoreApis"})
public final class CoreApiModule_OnBoardingExperimentApiFactory implements Factory<Api> {
    private final Provider<OnBoardingExperimentApi> onBoardingExperimentApiProvider;

    public CoreApiModule_OnBoardingExperimentApiFactory(Provider<OnBoardingExperimentApi> provider) {
        this.onBoardingExperimentApiProvider = provider;
    }

    public static CoreApiModule_OnBoardingExperimentApiFactory create(Provider<OnBoardingExperimentApi> provider) {
        return new CoreApiModule_OnBoardingExperimentApiFactory(provider);
    }

    public static Api onBoardingExperimentApi(OnBoardingExperimentApi onBoardingExperimentApi) {
        return (Api) Preconditions.checkNotNullFromProvides(CoreApiModule.INSTANCE.onBoardingExperimentApi(onBoardingExperimentApi));
    }

    public Api get() {
        return onBoardingExperimentApi(this.onBoardingExperimentApiProvider.get());
    }
}
