package com.talabat.darkstores.di;

import com.talabat.core.experiment.domain.ITalabatExperiment;
import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;

@ScopeMetadata
@DaggerGenerated
@QualifierMetadata
public final class DarkstoresApplicationModule_ProvidesTalabatExperimentFactory implements Factory<ITalabatExperiment> {

    public static final class InstanceHolder {
        /* access modifiers changed from: private */
        public static final DarkstoresApplicationModule_ProvidesTalabatExperimentFactory INSTANCE = new DarkstoresApplicationModule_ProvidesTalabatExperimentFactory();

        private InstanceHolder() {
        }
    }

    public static DarkstoresApplicationModule_ProvidesTalabatExperimentFactory create() {
        return InstanceHolder.INSTANCE;
    }

    public static ITalabatExperiment providesTalabatExperiment() {
        return (ITalabatExperiment) Preconditions.checkNotNullFromProvides(DarkstoresApplicationModule.INSTANCE.providesTalabatExperiment());
    }

    public ITalabatExperiment get() {
        return providesTalabatExperiment();
    }
}
