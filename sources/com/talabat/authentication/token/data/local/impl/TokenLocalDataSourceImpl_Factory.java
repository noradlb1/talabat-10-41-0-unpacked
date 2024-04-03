package com.talabat.authentication.token.data.local.impl;

import com.squareup.moshi.Moshi;
import com.talabat.authentication.token.data.local.EncryptedStorageProvider;
import com.talabat.core.observabilityNew.domain.IObservabilityManager;
import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import javax.inject.Provider;

@ScopeMetadata
@DaggerGenerated
@QualifierMetadata
public final class TokenLocalDataSourceImpl_Factory implements Factory<TokenLocalDataSourceImpl> {
    private final Provider<EncryptedStorageProvider> encryptedStorageProvider;
    private final Provider<Moshi> moshiProvider;
    private final Provider<IObservabilityManager> observabilityManagerProvider;

    public TokenLocalDataSourceImpl_Factory(Provider<EncryptedStorageProvider> provider, Provider<Moshi> provider2, Provider<IObservabilityManager> provider3) {
        this.encryptedStorageProvider = provider;
        this.moshiProvider = provider2;
        this.observabilityManagerProvider = provider3;
    }

    public static TokenLocalDataSourceImpl_Factory create(Provider<EncryptedStorageProvider> provider, Provider<Moshi> provider2, Provider<IObservabilityManager> provider3) {
        return new TokenLocalDataSourceImpl_Factory(provider, provider2, provider3);
    }

    public static TokenLocalDataSourceImpl newInstance(EncryptedStorageProvider encryptedStorageProvider2, Moshi moshi, IObservabilityManager iObservabilityManager) {
        return new TokenLocalDataSourceImpl(encryptedStorageProvider2, moshi, iObservabilityManager);
    }

    public TokenLocalDataSourceImpl get() {
        return newInstance(this.encryptedStorageProvider.get(), this.moshiProvider.get(), this.observabilityManagerProvider.get());
    }
}
