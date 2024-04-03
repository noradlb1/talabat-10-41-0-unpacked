package com.talabat.core.safety.data;

import com.talabat.authentication.aaa.secrets.SecretProvider;
import com.talabat.core.dispatcher.domain.CoroutineDispatchersFactory;
import com.talabat.core.observabilityNew.domain.IObservabilityManager;
import com.talabat.core.safety.data.datasource.api.SafetyApi;
import com.talabat.core.safety.data.datasource.availability.AvailabilityCheck;
import com.talabat.core.safety.data.repository.protection.ProtectionRepository;
import com.talabat.core.safety.data.repository.shield.ShieldRepository;
import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import javax.inject.Provider;

@ScopeMetadata
@DaggerGenerated
@QualifierMetadata
public final class DefaultSafetyAgent_Factory implements Factory<DefaultSafetyAgent> {
    private final Provider<AvailabilityCheck> availabilityCheckProvider;
    private final Provider<CoroutineDispatchersFactory> coroutineDispatchersFactoryProvider;
    private final Provider<IObservabilityManager> observabilityManagerProvider;
    private final Provider<ProtectionRepository> protectionRepositoryProvider;
    private final Provider<SafetyApi> safetyApiProvider;
    private final Provider<SecretProvider> secretProvider;
    private final Provider<ShieldRepository> shieldRepositoryProvider;

    public DefaultSafetyAgent_Factory(Provider<SafetyApi> provider, Provider<AvailabilityCheck> provider2, Provider<ShieldRepository> provider3, Provider<IObservabilityManager> provider4, Provider<ProtectionRepository> provider5, Provider<CoroutineDispatchersFactory> provider6, Provider<SecretProvider> provider7) {
        this.safetyApiProvider = provider;
        this.availabilityCheckProvider = provider2;
        this.shieldRepositoryProvider = provider3;
        this.observabilityManagerProvider = provider4;
        this.protectionRepositoryProvider = provider5;
        this.coroutineDispatchersFactoryProvider = provider6;
        this.secretProvider = provider7;
    }

    public static DefaultSafetyAgent_Factory create(Provider<SafetyApi> provider, Provider<AvailabilityCheck> provider2, Provider<ShieldRepository> provider3, Provider<IObservabilityManager> provider4, Provider<ProtectionRepository> provider5, Provider<CoroutineDispatchersFactory> provider6, Provider<SecretProvider> provider7) {
        return new DefaultSafetyAgent_Factory(provider, provider2, provider3, provider4, provider5, provider6, provider7);
    }

    public static DefaultSafetyAgent newInstance(SafetyApi safetyApi, AvailabilityCheck availabilityCheck, ShieldRepository shieldRepository, IObservabilityManager iObservabilityManager, ProtectionRepository protectionRepository, CoroutineDispatchersFactory coroutineDispatchersFactory, SecretProvider secretProvider2) {
        return new DefaultSafetyAgent(safetyApi, availabilityCheck, shieldRepository, iObservabilityManager, protectionRepository, coroutineDispatchersFactory, secretProvider2);
    }

    public DefaultSafetyAgent get() {
        return newInstance(this.safetyApiProvider.get(), this.availabilityCheckProvider.get(), this.shieldRepositoryProvider.get(), this.observabilityManagerProvider.get(), this.protectionRepositoryProvider.get(), this.coroutineDispatchersFactoryProvider.get(), this.secretProvider.get());
    }
}
