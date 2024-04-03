package com.talabat.darkstores.domain.products;

import com.talabat.core.experiment.domain.ITalabatExperiment;
import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import javax.inject.Provider;

@ScopeMetadata
@DaggerGenerated
@QualifierMetadata
public final class CheckFlutterCategoryProductsEnabledUseCaseImpl_Factory implements Factory<CheckFlutterCategoryProductsEnabledUseCaseImpl> {
    private final Provider<ITalabatExperiment> talabatExperimentProvider;

    public CheckFlutterCategoryProductsEnabledUseCaseImpl_Factory(Provider<ITalabatExperiment> provider) {
        this.talabatExperimentProvider = provider;
    }

    public static CheckFlutterCategoryProductsEnabledUseCaseImpl_Factory create(Provider<ITalabatExperiment> provider) {
        return new CheckFlutterCategoryProductsEnabledUseCaseImpl_Factory(provider);
    }

    public static CheckFlutterCategoryProductsEnabledUseCaseImpl newInstance(ITalabatExperiment iTalabatExperiment) {
        return new CheckFlutterCategoryProductsEnabledUseCaseImpl(iTalabatExperiment);
    }

    public CheckFlutterCategoryProductsEnabledUseCaseImpl get() {
        return newInstance(this.talabatExperimentProvider.get());
    }
}
