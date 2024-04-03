package com.talabat.darkstores.feature.home.usecase;

import com.talabat.core.experiment.domain.ITalabatExperiment;
import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import javax.inject.Provider;

@ScopeMetadata
@DaggerGenerated
@QualifierMetadata
public final class ShouldShowTalabatAiEntryPointUseCaseImpl_Factory implements Factory<ShouldShowTalabatAiEntryPointUseCaseImpl> {
    private final Provider<ITalabatExperiment> talabatExperimentProvider;

    public ShouldShowTalabatAiEntryPointUseCaseImpl_Factory(Provider<ITalabatExperiment> provider) {
        this.talabatExperimentProvider = provider;
    }

    public static ShouldShowTalabatAiEntryPointUseCaseImpl_Factory create(Provider<ITalabatExperiment> provider) {
        return new ShouldShowTalabatAiEntryPointUseCaseImpl_Factory(provider);
    }

    public static ShouldShowTalabatAiEntryPointUseCaseImpl newInstance(ITalabatExperiment iTalabatExperiment) {
        return new ShouldShowTalabatAiEntryPointUseCaseImpl(iTalabatExperiment);
    }

    public ShouldShowTalabatAiEntryPointUseCaseImpl get() {
        return newInstance(this.talabatExperimentProvider.get());
    }
}
