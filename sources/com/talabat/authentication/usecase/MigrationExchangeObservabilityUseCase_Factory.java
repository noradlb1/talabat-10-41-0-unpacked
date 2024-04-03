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
public final class MigrationExchangeObservabilityUseCase_Factory implements Factory<MigrationExchangeObservabilityUseCase> {
    private final Provider<IObservabilityManager> observabilityManagerProvider;

    public MigrationExchangeObservabilityUseCase_Factory(Provider<IObservabilityManager> provider) {
        this.observabilityManagerProvider = provider;
    }

    public static MigrationExchangeObservabilityUseCase_Factory create(Provider<IObservabilityManager> provider) {
        return new MigrationExchangeObservabilityUseCase_Factory(provider);
    }

    public static MigrationExchangeObservabilityUseCase newInstance(IObservabilityManager iObservabilityManager) {
        return new MigrationExchangeObservabilityUseCase(iObservabilityManager);
    }

    public MigrationExchangeObservabilityUseCase get() {
        return newInstance(this.observabilityManagerProvider.get());
    }
}
