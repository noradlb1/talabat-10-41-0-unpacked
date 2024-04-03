package com.talabat.darkstores.feature.categories.subcategories.sort;

import com.talabat.core.experiment.domain.ITalabatExperiment;
import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import javax.inject.Provider;

@ScopeMetadata
@DaggerGenerated
@QualifierMetadata
public final class GetSortOnPLPEnabledUseCaseImpl_Factory implements Factory<GetSortOnPLPEnabledUseCaseImpl> {
    private final Provider<ITalabatExperiment> talabatExperimentProvider;

    public GetSortOnPLPEnabledUseCaseImpl_Factory(Provider<ITalabatExperiment> provider) {
        this.talabatExperimentProvider = provider;
    }

    public static GetSortOnPLPEnabledUseCaseImpl_Factory create(Provider<ITalabatExperiment> provider) {
        return new GetSortOnPLPEnabledUseCaseImpl_Factory(provider);
    }

    public static GetSortOnPLPEnabledUseCaseImpl newInstance(ITalabatExperiment iTalabatExperiment) {
        return new GetSortOnPLPEnabledUseCaseImpl(iTalabatExperiment);
    }

    public GetSortOnPLPEnabledUseCaseImpl get() {
        return newInstance(this.talabatExperimentProvider.get());
    }
}
