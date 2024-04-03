package com.talabat.feature.darkstorescarrierbag.domain.usecase;

import com.talabat.core.experiment.domain.ITalabatExperiment;
import com.talabat.feature.darkstorescarrierbag.domain.repository.DarkstoresCarrierBagRepository;
import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import javax.inject.Provider;

@ScopeMetadata
@DaggerGenerated
@QualifierMetadata
public final class ShouldShowDarkstoresCarrierBagFakeDoorTestImpl_Factory implements Factory<ShouldShowDarkstoresCarrierBagFakeDoorTestImpl> {
    private final Provider<DarkstoresCarrierBagRepository> repositoryProvider;
    private final Provider<ITalabatExperiment> talabatExperimentProvider;

    public ShouldShowDarkstoresCarrierBagFakeDoorTestImpl_Factory(Provider<ITalabatExperiment> provider, Provider<DarkstoresCarrierBagRepository> provider2) {
        this.talabatExperimentProvider = provider;
        this.repositoryProvider = provider2;
    }

    public static ShouldShowDarkstoresCarrierBagFakeDoorTestImpl_Factory create(Provider<ITalabatExperiment> provider, Provider<DarkstoresCarrierBagRepository> provider2) {
        return new ShouldShowDarkstoresCarrierBagFakeDoorTestImpl_Factory(provider, provider2);
    }

    public static ShouldShowDarkstoresCarrierBagFakeDoorTestImpl newInstance(ITalabatExperiment iTalabatExperiment, DarkstoresCarrierBagRepository darkstoresCarrierBagRepository) {
        return new ShouldShowDarkstoresCarrierBagFakeDoorTestImpl(iTalabatExperiment, darkstoresCarrierBagRepository);
    }

    public ShouldShowDarkstoresCarrierBagFakeDoorTestImpl get() {
        return newInstance(this.talabatExperimentProvider.get(), this.repositoryProvider.get());
    }
}
