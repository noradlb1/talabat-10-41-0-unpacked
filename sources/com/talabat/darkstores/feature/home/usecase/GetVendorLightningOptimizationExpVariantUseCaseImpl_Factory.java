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
public final class GetVendorLightningOptimizationExpVariantUseCaseImpl_Factory implements Factory<GetVendorLightningOptimizationExpVariantUseCaseImpl> {
    private final Provider<ITalabatExperiment> talabatExperimentProvider;

    public GetVendorLightningOptimizationExpVariantUseCaseImpl_Factory(Provider<ITalabatExperiment> provider) {
        this.talabatExperimentProvider = provider;
    }

    public static GetVendorLightningOptimizationExpVariantUseCaseImpl_Factory create(Provider<ITalabatExperiment> provider) {
        return new GetVendorLightningOptimizationExpVariantUseCaseImpl_Factory(provider);
    }

    public static GetVendorLightningOptimizationExpVariantUseCaseImpl newInstance(ITalabatExperiment iTalabatExperiment) {
        return new GetVendorLightningOptimizationExpVariantUseCaseImpl(iTalabatExperiment);
    }

    public GetVendorLightningOptimizationExpVariantUseCaseImpl get() {
        return newInstance(this.talabatExperimentProvider.get());
    }
}
