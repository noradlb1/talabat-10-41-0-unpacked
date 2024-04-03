package com.talabat.core.experiment.data.di;

import com.talabat.core.experiment.domain.ITalabatExperiment;
import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;

@ScopeMetadata("dagger.Reusable")
@DaggerGenerated
@QualifierMetadata
public final class ExperimentCoreModule_ProvideTalabatExperimentFactory implements Factory<ITalabatExperiment> {

    public static final class InstanceHolder {
        /* access modifiers changed from: private */
        public static final ExperimentCoreModule_ProvideTalabatExperimentFactory INSTANCE = new ExperimentCoreModule_ProvideTalabatExperimentFactory();

        private InstanceHolder() {
        }
    }

    public static ExperimentCoreModule_ProvideTalabatExperimentFactory create() {
        return InstanceHolder.INSTANCE;
    }

    public static ITalabatExperiment provideTalabatExperiment() {
        return (ITalabatExperiment) Preconditions.checkNotNullFromProvides(ExperimentCoreModule.INSTANCE.provideTalabatExperiment());
    }

    public ITalabatExperiment get() {
        return provideTalabatExperiment();
    }
}
