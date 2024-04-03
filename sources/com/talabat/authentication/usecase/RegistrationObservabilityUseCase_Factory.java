package com.talabat.authentication.usecase;

import com.talabat.core.observabilityNew.domain.IObservabilityManager;
import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import javax.inject.Provider;

@ScopeMetadata
@DaggerGenerated
@QualifierMetadata
public final class RegistrationObservabilityUseCase_Factory implements Factory<RegistrationObservabilityUseCase> {
    private final Provider<IObservabilityManager> observabilityManagerProvider;

    public RegistrationObservabilityUseCase_Factory(Provider<IObservabilityManager> provider) {
        this.observabilityManagerProvider = provider;
    }

    public static RegistrationObservabilityUseCase_Factory create(Provider<IObservabilityManager> provider) {
        return new RegistrationObservabilityUseCase_Factory(provider);
    }

    public static RegistrationObservabilityUseCase newInstance(IObservabilityManager iObservabilityManager) {
        return new RegistrationObservabilityUseCase(iObservabilityManager);
    }

    public RegistrationObservabilityUseCase get() {
        return newInstance(this.observabilityManagerProvider.get());
    }
}
