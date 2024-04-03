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
public final class IsVendorLightningOptimizationEnabledUseCaseImpl_Factory implements Factory<IsVendorLightningOptimizationEnabledUseCaseImpl> {
    private final Provider<ITalabatExperiment> talabatExperimentProvider;

    public IsVendorLightningOptimizationEnabledUseCaseImpl_Factory(Provider<ITalabatExperiment> provider) {
        this.talabatExperimentProvider = provider;
    }

    public static IsVendorLightningOptimizationEnabledUseCaseImpl_Factory create(Provider<ITalabatExperiment> provider) {
        return new IsVendorLightningOptimizationEnabledUseCaseImpl_Factory(provider);
    }

    public static IsVendorLightningOptimizationEnabledUseCaseImpl newInstance(ITalabatExperiment iTalabatExperiment) {
        return new IsVendorLightningOptimizationEnabledUseCaseImpl(iTalabatExperiment);
    }

    public IsVendorLightningOptimizationEnabledUseCaseImpl get() {
        return newInstance(this.talabatExperimentProvider.get());
    }
}
