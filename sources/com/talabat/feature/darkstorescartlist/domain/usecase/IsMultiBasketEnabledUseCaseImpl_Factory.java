package com.talabat.feature.darkstorescartlist.domain.usecase;

import com.talabat.core.experiment.domain.ITalabatExperiment;
import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import javax.inject.Provider;

@ScopeMetadata
@DaggerGenerated
@QualifierMetadata
public final class IsMultiBasketEnabledUseCaseImpl_Factory implements Factory<IsMultiBasketEnabledUseCaseImpl> {
    private final Provider<ITalabatExperiment> talabatExperimentProvider;

    public IsMultiBasketEnabledUseCaseImpl_Factory(Provider<ITalabatExperiment> provider) {
        this.talabatExperimentProvider = provider;
    }

    public static IsMultiBasketEnabledUseCaseImpl_Factory create(Provider<ITalabatExperiment> provider) {
        return new IsMultiBasketEnabledUseCaseImpl_Factory(provider);
    }

    public static IsMultiBasketEnabledUseCaseImpl newInstance(ITalabatExperiment iTalabatExperiment) {
        return new IsMultiBasketEnabledUseCaseImpl(iTalabatExperiment);
    }

    public IsMultiBasketEnabledUseCaseImpl get() {
        return newInstance(this.talabatExperimentProvider.get());
    }
}
