package com.talabat.core.safety.data.repository.shield.remote;

import com.talabat.core.observabilityNew.domain.IObservabilityManager;
import com.talabat.core.safety.data.datasource.info.ShieldInfoDtoFactory;
import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import javax.inject.Provider;
import retrofit2.Retrofit;

@ScopeMetadata
@DaggerGenerated
@QualifierMetadata
public final class RemoteShieldRepository_Factory implements Factory<RemoteShieldRepository> {
    private final Provider<IObservabilityManager> observabilityManagerProvider;
    private final Provider<Retrofit> retrofitProvider;
    private final Provider<ShieldInfoDtoFactory> shieldInfoDtoFactoryProvider;

    public RemoteShieldRepository_Factory(Provider<Retrofit> provider, Provider<IObservabilityManager> provider2, Provider<ShieldInfoDtoFactory> provider3) {
        this.retrofitProvider = provider;
        this.observabilityManagerProvider = provider2;
        this.shieldInfoDtoFactoryProvider = provider3;
    }

    public static RemoteShieldRepository_Factory create(Provider<Retrofit> provider, Provider<IObservabilityManager> provider2, Provider<ShieldInfoDtoFactory> provider3) {
        return new RemoteShieldRepository_Factory(provider, provider2, provider3);
    }

    public static RemoteShieldRepository newInstance(Retrofit retrofit, IObservabilityManager iObservabilityManager, ShieldInfoDtoFactory shieldInfoDtoFactory) {
        return new RemoteShieldRepository(retrofit, iObservabilityManager, shieldInfoDtoFactory);
    }

    public RemoteShieldRepository get() {
        return newInstance(this.retrofitProvider.get(), this.observabilityManagerProvider.get(), this.shieldInfoDtoFactoryProvider.get());
    }
}
