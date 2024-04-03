package com.talabat.darkstores.domain.swimlanes;

import com.talabat.core.experiment.domain.ITalabatExperiment;
import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import javax.inject.Provider;

@ScopeMetadata
@DaggerGenerated
@QualifierMetadata
public final class CheckFlutterSwimlanesSearchResultEnabledUseCaseImpl_Factory implements Factory<CheckFlutterSwimlanesSearchResultEnabledUseCaseImpl> {
    private final Provider<ITalabatExperiment> talabatExperimentProvider;

    public CheckFlutterSwimlanesSearchResultEnabledUseCaseImpl_Factory(Provider<ITalabatExperiment> provider) {
        this.talabatExperimentProvider = provider;
    }

    public static CheckFlutterSwimlanesSearchResultEnabledUseCaseImpl_Factory create(Provider<ITalabatExperiment> provider) {
        return new CheckFlutterSwimlanesSearchResultEnabledUseCaseImpl_Factory(provider);
    }

    public static CheckFlutterSwimlanesSearchResultEnabledUseCaseImpl newInstance(ITalabatExperiment iTalabatExperiment) {
        return new CheckFlutterSwimlanesSearchResultEnabledUseCaseImpl(iTalabatExperiment);
    }

    public CheckFlutterSwimlanesSearchResultEnabledUseCaseImpl get() {
        return newInstance(this.talabatExperimentProvider.get());
    }
}
