package com.talabat.feature.tokenization.domain.usecase;

import com.talabat.core.observabilityNew.domain.IObservabilityManager;
import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import javax.inject.Provider;

@ScopeMetadata
@DaggerGenerated
@QualifierMetadata
public final class ObserveTokenizationFailedUseCase_Factory implements Factory<ObserveTokenizationFailedUseCase> {
    private final Provider<IObservabilityManager> observabilityManagerProvider;

    public ObserveTokenizationFailedUseCase_Factory(Provider<IObservabilityManager> provider) {
        this.observabilityManagerProvider = provider;
    }

    public static ObserveTokenizationFailedUseCase_Factory create(Provider<IObservabilityManager> provider) {
        return new ObserveTokenizationFailedUseCase_Factory(provider);
    }

    public static ObserveTokenizationFailedUseCase newInstance(IObservabilityManager iObservabilityManager) {
        return new ObserveTokenizationFailedUseCase(iObservabilityManager);
    }

    public ObserveTokenizationFailedUseCase get() {
        return newInstance(this.observabilityManagerProvider.get());
    }
}
