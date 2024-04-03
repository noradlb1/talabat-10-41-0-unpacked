package com.talabat.feature.rating.data.di;

import com.talabat.core.experiment.domain.ITalabatExperiment;
import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;

@ScopeMetadata
@DaggerGenerated
@QualifierMetadata
public final class RatingUserDataModule_ProvideExperimentProviderFactory implements Factory<ITalabatExperiment> {

    public static final class InstanceHolder {
        /* access modifiers changed from: private */
        public static final RatingUserDataModule_ProvideExperimentProviderFactory INSTANCE = new RatingUserDataModule_ProvideExperimentProviderFactory();

        private InstanceHolder() {
        }
    }

    public static RatingUserDataModule_ProvideExperimentProviderFactory create() {
        return InstanceHolder.INSTANCE;
    }

    public static ITalabatExperiment provideExperimentProvider() {
        return (ITalabatExperiment) Preconditions.checkNotNullFromProvides(RatingUserDataModule.INSTANCE.provideExperimentProvider());
    }

    public ITalabatExperiment get() {
        return provideExperimentProvider();
    }
}
