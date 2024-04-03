package com.talabat.core.flutter.channels.impl.data.experiment;

import com.talabat.core.experiment.domain.ITalabatExperiment;
import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import javax.inject.Provider;

@ScopeMetadata
@DaggerGenerated
@QualifierMetadata
public final class ExperimentChannelCallbackImpl_Factory implements Factory<ExperimentChannelCallbackImpl> {
    private final Provider<ITalabatExperiment> talabatExperimentProvider;

    public ExperimentChannelCallbackImpl_Factory(Provider<ITalabatExperiment> provider) {
        this.talabatExperimentProvider = provider;
    }

    public static ExperimentChannelCallbackImpl_Factory create(Provider<ITalabatExperiment> provider) {
        return new ExperimentChannelCallbackImpl_Factory(provider);
    }

    public static ExperimentChannelCallbackImpl newInstance(ITalabatExperiment iTalabatExperiment) {
        return new ExperimentChannelCallbackImpl(iTalabatExperiment);
    }

    public ExperimentChannelCallbackImpl get() {
        return newInstance(this.talabatExperimentProvider.get());
    }
}
