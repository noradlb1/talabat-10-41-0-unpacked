package com.talabat.authentication.token.data.impl;

import com.talabat.authentication.authenticate.domain.repository.TokenExchangeRetriesRepository;
import com.talabat.authentication.token.data.local.LegacyTokenLocalDataSource;
import com.talabat.authentication.token.data.local.TokenLocalDataSource;
import com.talabat.authentication.token.data.remote.TokenRemoteDataSource;
import com.talabat.core.observabilityNew.domain.IObservabilityManager;
import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import javax.inject.Provider;

@ScopeMetadata
@DaggerGenerated
@QualifierMetadata
public final class TokenRepositoryImpl_Factory implements Factory<TokenRepositoryImpl> {
    private final Provider<LegacyTokenLocalDataSource> legacyTokenLocalDataSourceProvider;
    private final Provider<IObservabilityManager> observabilityManagerProvider;
    private final Provider<TokenExchangeRetriesRepository> tokenExchangeRetriesRepositoryProvider;
    private final Provider<TokenLocalDataSource> tokenLocalDataSourceProvider;
    private final Provider<TokenRemoteDataSource> tokenRemoteDataSourceProvider;

    public TokenRepositoryImpl_Factory(Provider<LegacyTokenLocalDataSource> provider, Provider<TokenRemoteDataSource> provider2, Provider<TokenLocalDataSource> provider3, Provider<TokenExchangeRetriesRepository> provider4, Provider<IObservabilityManager> provider5) {
        this.legacyTokenLocalDataSourceProvider = provider;
        this.tokenRemoteDataSourceProvider = provider2;
        this.tokenLocalDataSourceProvider = provider3;
        this.tokenExchangeRetriesRepositoryProvider = provider4;
        this.observabilityManagerProvider = provider5;
    }

    public static TokenRepositoryImpl_Factory create(Provider<LegacyTokenLocalDataSource> provider, Provider<TokenRemoteDataSource> provider2, Provider<TokenLocalDataSource> provider3, Provider<TokenExchangeRetriesRepository> provider4, Provider<IObservabilityManager> provider5) {
        return new TokenRepositoryImpl_Factory(provider, provider2, provider3, provider4, provider5);
    }

    public static TokenRepositoryImpl newInstance(LegacyTokenLocalDataSource legacyTokenLocalDataSource, TokenRemoteDataSource tokenRemoteDataSource, TokenLocalDataSource tokenLocalDataSource, TokenExchangeRetriesRepository tokenExchangeRetriesRepository, IObservabilityManager iObservabilityManager) {
        return new TokenRepositoryImpl(legacyTokenLocalDataSource, tokenRemoteDataSource, tokenLocalDataSource, tokenExchangeRetriesRepository, iObservabilityManager);
    }

    public TokenRepositoryImpl get() {
        return newInstance(this.legacyTokenLocalDataSourceProvider.get(), this.tokenRemoteDataSourceProvider.get(), this.tokenLocalDataSourceProvider.get(), this.tokenExchangeRetriesRepositoryProvider.get(), this.observabilityManagerProvider.get());
    }
}
