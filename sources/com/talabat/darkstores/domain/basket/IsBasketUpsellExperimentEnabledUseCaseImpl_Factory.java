package com.talabat.darkstores.domain.basket;

import com.talabat.core.experiment.domain.ITalabatExperiment;
import com.talabat.darkstores.data.ConfigurationParameters;
import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import javax.inject.Provider;

@ScopeMetadata
@DaggerGenerated
@QualifierMetadata
public final class IsBasketUpsellExperimentEnabledUseCaseImpl_Factory implements Factory<IsBasketUpsellExperimentEnabledUseCaseImpl> {
    private final Provider<ConfigurationParameters> configurationParametersProvider;
    private final Provider<ITalabatExperiment> talabatExperimentProvider;

    public IsBasketUpsellExperimentEnabledUseCaseImpl_Factory(Provider<ITalabatExperiment> provider, Provider<ConfigurationParameters> provider2) {
        this.talabatExperimentProvider = provider;
        this.configurationParametersProvider = provider2;
    }

    public static IsBasketUpsellExperimentEnabledUseCaseImpl_Factory create(Provider<ITalabatExperiment> provider, Provider<ConfigurationParameters> provider2) {
        return new IsBasketUpsellExperimentEnabledUseCaseImpl_Factory(provider, provider2);
    }

    public static IsBasketUpsellExperimentEnabledUseCaseImpl newInstance(ITalabatExperiment iTalabatExperiment, ConfigurationParameters configurationParameters) {
        return new IsBasketUpsellExperimentEnabledUseCaseImpl(iTalabatExperiment, configurationParameters);
    }

    public IsBasketUpsellExperimentEnabledUseCaseImpl get() {
        return newInstance(this.talabatExperimentProvider.get(), this.configurationParametersProvider.get());
    }
}
