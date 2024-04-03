package com.talabat.feature.tmart.growth.data.di;

import com.talabat.core.experiment.domain.ITalabatExperiment;
import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;

@ScopeMetadata
@DaggerGenerated
@QualifierMetadata
public final class TMartGrowthExperimentsModule_ProvideExperimentFactory implements Factory<ITalabatExperiment> {

    public static final class InstanceHolder {
        /* access modifiers changed from: private */
        public static final TMartGrowthExperimentsModule_ProvideExperimentFactory INSTANCE = new TMartGrowthExperimentsModule_ProvideExperimentFactory();

        private InstanceHolder() {
        }
    }

    public static TMartGrowthExperimentsModule_ProvideExperimentFactory create() {
        return InstanceHolder.INSTANCE;
    }

    public static ITalabatExperiment provideExperiment() {
        return (ITalabatExperiment) Preconditions.checkNotNullFromProvides(TMartGrowthExperimentsModule.INSTANCE.provideExperiment());
    }

    public ITalabatExperiment get() {
        return provideExperiment();
    }
}
