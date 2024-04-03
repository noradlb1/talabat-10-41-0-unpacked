package com.talabat.darkstores.feature.cart;

import com.talabat.core.experiment.domain.ITalabatExperiment;
import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import javax.inject.Provider;

@ScopeMetadata
@DaggerGenerated
@QualifierMetadata
public final class BasketLifeTimeTooltipUseCase_Factory implements Factory<BasketLifeTimeTooltipUseCase> {
    private final Provider<ITalabatExperiment> talabatExperimentProvider;

    public BasketLifeTimeTooltipUseCase_Factory(Provider<ITalabatExperiment> provider) {
        this.talabatExperimentProvider = provider;
    }

    public static BasketLifeTimeTooltipUseCase_Factory create(Provider<ITalabatExperiment> provider) {
        return new BasketLifeTimeTooltipUseCase_Factory(provider);
    }

    public static BasketLifeTimeTooltipUseCase newInstance(ITalabatExperiment iTalabatExperiment) {
        return new BasketLifeTimeTooltipUseCase(iTalabatExperiment);
    }

    public BasketLifeTimeTooltipUseCase get() {
        return newInstance(this.talabatExperimentProvider.get());
    }
}
