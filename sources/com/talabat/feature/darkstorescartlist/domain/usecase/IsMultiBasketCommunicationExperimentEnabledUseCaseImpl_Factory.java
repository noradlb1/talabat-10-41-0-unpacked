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
public final class IsMultiBasketCommunicationExperimentEnabledUseCaseImpl_Factory implements Factory<IsMultiBasketCommunicationExperimentEnabledUseCaseImpl> {
    private final Provider<ITalabatExperiment> talabatExperimentProvider;

    public IsMultiBasketCommunicationExperimentEnabledUseCaseImpl_Factory(Provider<ITalabatExperiment> provider) {
        this.talabatExperimentProvider = provider;
    }

    public static IsMultiBasketCommunicationExperimentEnabledUseCaseImpl_Factory create(Provider<ITalabatExperiment> provider) {
        return new IsMultiBasketCommunicationExperimentEnabledUseCaseImpl_Factory(provider);
    }

    public static IsMultiBasketCommunicationExperimentEnabledUseCaseImpl newInstance(ITalabatExperiment iTalabatExperiment) {
        return new IsMultiBasketCommunicationExperimentEnabledUseCaseImpl(iTalabatExperiment);
    }

    public IsMultiBasketCommunicationExperimentEnabledUseCaseImpl get() {
        return newInstance(this.talabatExperimentProvider.get());
    }
}
