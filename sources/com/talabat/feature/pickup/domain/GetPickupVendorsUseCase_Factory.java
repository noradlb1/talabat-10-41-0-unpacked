package com.talabat.feature.pickup.domain;

import com.talabat.core.experiment.domain.ITalabatExperiment;
import com.talabat.core.featureflag.domain.ITalabatFeatureFlag;
import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import javax.inject.Provider;

@ScopeMetadata
@DaggerGenerated
@QualifierMetadata
public final class GetPickupVendorsUseCase_Factory implements Factory<GetPickupVendorsUseCase> {
    private final Provider<ITalabatExperiment> experimentProvider;
    private final Provider<ITalabatFeatureFlag> featureFlagProvider;
    private final Provider<PickupRepository> pickupRepositoryProvider;

    public GetPickupVendorsUseCase_Factory(Provider<PickupRepository> provider, Provider<ITalabatExperiment> provider2, Provider<ITalabatFeatureFlag> provider3) {
        this.pickupRepositoryProvider = provider;
        this.experimentProvider = provider2;
        this.featureFlagProvider = provider3;
    }

    public static GetPickupVendorsUseCase_Factory create(Provider<PickupRepository> provider, Provider<ITalabatExperiment> provider2, Provider<ITalabatFeatureFlag> provider3) {
        return new GetPickupVendorsUseCase_Factory(provider, provider2, provider3);
    }

    public static GetPickupVendorsUseCase newInstance(PickupRepository pickupRepository, ITalabatExperiment iTalabatExperiment, ITalabatFeatureFlag iTalabatFeatureFlag) {
        return new GetPickupVendorsUseCase(pickupRepository, iTalabatExperiment, iTalabatFeatureFlag);
    }

    public GetPickupVendorsUseCase get() {
        return newInstance(this.pickupRepositoryProvider.get(), this.experimentProvider.get(), this.featureFlagProvider.get());
    }
}
