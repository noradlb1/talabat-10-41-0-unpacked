package com.talabat.feature.darkstoresscheduleddelivery.domain.usecase;

import com.talabat.core.experiment.domain.ITalabatExperiment;
import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import javax.inject.Provider;

@ScopeMetadata
@DaggerGenerated
@QualifierMetadata
public final class IsDarkstoresScheduledDeliveryDiscountEnabledUseCaseImpl_Factory implements Factory<IsDarkstoresScheduledDeliveryDiscountEnabledUseCaseImpl> {
    private final Provider<ITalabatExperiment> talabatExperimentProvider;

    public IsDarkstoresScheduledDeliveryDiscountEnabledUseCaseImpl_Factory(Provider<ITalabatExperiment> provider) {
        this.talabatExperimentProvider = provider;
    }

    public static IsDarkstoresScheduledDeliveryDiscountEnabledUseCaseImpl_Factory create(Provider<ITalabatExperiment> provider) {
        return new IsDarkstoresScheduledDeliveryDiscountEnabledUseCaseImpl_Factory(provider);
    }

    public static IsDarkstoresScheduledDeliveryDiscountEnabledUseCaseImpl newInstance(ITalabatExperiment iTalabatExperiment) {
        return new IsDarkstoresScheduledDeliveryDiscountEnabledUseCaseImpl(iTalabatExperiment);
    }

    public IsDarkstoresScheduledDeliveryDiscountEnabledUseCaseImpl get() {
        return newInstance(this.talabatExperimentProvider.get());
    }
}
