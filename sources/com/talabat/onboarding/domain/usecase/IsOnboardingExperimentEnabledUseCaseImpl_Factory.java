package com.talabat.onboarding.domain.usecase;

import com.talabat.core.dispatcher.domain.CoroutineDispatchersFactory;
import com.talabat.core.experiment.domain.ITalabatExperiment;
import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import javax.inject.Provider;

@ScopeMetadata
@DaggerGenerated
@QualifierMetadata
public final class IsOnboardingExperimentEnabledUseCaseImpl_Factory implements Factory<IsOnboardingExperimentEnabledUseCaseImpl> {
    private final Provider<CoroutineDispatchersFactory> coroutineDispatchersFactoryProvider;
    private final Provider<ITalabatExperiment> talabatExperimentProvider;

    public IsOnboardingExperimentEnabledUseCaseImpl_Factory(Provider<ITalabatExperiment> provider, Provider<CoroutineDispatchersFactory> provider2) {
        this.talabatExperimentProvider = provider;
        this.coroutineDispatchersFactoryProvider = provider2;
    }

    public static IsOnboardingExperimentEnabledUseCaseImpl_Factory create(Provider<ITalabatExperiment> provider, Provider<CoroutineDispatchersFactory> provider2) {
        return new IsOnboardingExperimentEnabledUseCaseImpl_Factory(provider, provider2);
    }

    public static IsOnboardingExperimentEnabledUseCaseImpl newInstance(ITalabatExperiment iTalabatExperiment, CoroutineDispatchersFactory coroutineDispatchersFactory) {
        return new IsOnboardingExperimentEnabledUseCaseImpl(iTalabatExperiment, coroutineDispatchersFactory);
    }

    public IsOnboardingExperimentEnabledUseCaseImpl get() {
        return newInstance(this.talabatExperimentProvider.get(), this.coroutineDispatchersFactoryProvider.get());
    }
}
