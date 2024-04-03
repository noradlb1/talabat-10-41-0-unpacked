package com.talabat.darkstores.domain.cart;

import com.talabat.core.experiment.domain.ITalabatExperiment;
import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import javax.inject.Provider;

@ScopeMetadata
@DaggerGenerated
@QualifierMetadata
public final class IsFlutterCartEnabledUseCaseImpl_Factory implements Factory<IsFlutterCartEnabledUseCaseImpl> {
    private final Provider<ITalabatExperiment> talabatExperimentProvider;

    public IsFlutterCartEnabledUseCaseImpl_Factory(Provider<ITalabatExperiment> provider) {
        this.talabatExperimentProvider = provider;
    }

    public static IsFlutterCartEnabledUseCaseImpl_Factory create(Provider<ITalabatExperiment> provider) {
        return new IsFlutterCartEnabledUseCaseImpl_Factory(provider);
    }

    public static IsFlutterCartEnabledUseCaseImpl newInstance(ITalabatExperiment iTalabatExperiment) {
        return new IsFlutterCartEnabledUseCaseImpl(iTalabatExperiment);
    }

    public IsFlutterCartEnabledUseCaseImpl get() {
        return newInstance(this.talabatExperimentProvider.get());
    }
}
