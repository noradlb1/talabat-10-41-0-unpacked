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
public final class ObserveTokenizationSuccessUseCase_Factory implements Factory<ObserveTokenizationSuccessUseCase> {
    private final Provider<IObservabilityManager> observabilityManagerProvider;

    public ObserveTokenizationSuccessUseCase_Factory(Provider<IObservabilityManager> provider) {
        this.observabilityManagerProvider = provider;
    }

    public static ObserveTokenizationSuccessUseCase_Factory create(Provider<IObservabilityManager> provider) {
        return new ObserveTokenizationSuccessUseCase_Factory(provider);
    }

    public static ObserveTokenizationSuccessUseCase newInstance(IObservabilityManager iObservabilityManager) {
        return new ObserveTokenizationSuccessUseCase(iObservabilityManager);
    }

    public ObserveTokenizationSuccessUseCase get() {
        return newInstance(this.observabilityManagerProvider.get());
    }
}
