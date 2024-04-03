package com.talabat.authentication.natives.di;

import com.talabat.authentication.JwtTokenManager;
import com.talabat.authentication.aaa.AaaApi;
import com.talabat.authentication.aaa.secrets.SecretProvider;
import com.talabat.authentication.authenticate.domain.repository.TokenExchangeRetriesRepository;
import com.talabat.authentication.authenticate.domain.usecase.TokenExchangeAllowed;
import com.talabat.authentication.natives.di.JwtTokenCoreLibModule;
import com.talabat.authentication.token.data.remote.TokenResponseMapper;
import com.talabat.authentication.token.domain.repository.TokenRepository;
import com.talabat.authentication.usecase.IsTokenExpiredUseCase;
import com.talabat.core.dispatcher.domain.CoroutineDispatchersFactory;
import com.talabat.core.experiment.domain.ITalabatExperiment;
import com.talabat.core.featureflag.domain.ITalabatFeatureFlag;
import com.talabat.core.observabilityNew.domain.IObservabilityManager;
import com.talabat.talabatremoteconfiguration.datasource.IRemoteConfigurationDataSource;
import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import javax.inject.Provider;

@ScopeMetadata("dagger.Reusable")
@DaggerGenerated
@QualifierMetadata
public final class JwtTokenCoreLibModule_Ext_JwtTokenManagerFactory implements Factory<JwtTokenManager> {
    private final Provider<AaaApi> aaaApiProvider;
    private final Provider<CoroutineDispatchersFactory> coroutineDispatchersFactoryProvider;
    private final Provider<TokenExchangeAllowed> exchangeAllowedProvider;
    private final Provider<ITalabatExperiment> experimentProvider;
    private final Provider<ITalabatFeatureFlag> featureFlagProvider;
    private final Provider<IsTokenExpiredUseCase> isTokenExpiredUseCaseProvider;
    private final Provider<IObservabilityManager> observabilityManagerProvider;
    private final Provider<IRemoteConfigurationDataSource> remoteConfigProvider;
    private final Provider<SecretProvider> secretProvider;
    private final Provider<TokenExchangeRetriesRepository> tokenExchangeRetriesRepositoryProvider;
    private final Provider<TokenRepository> tokenRepositoryProvider;
    private final Provider<TokenResponseMapper> tokenResponseMapperProvider;

    public JwtTokenCoreLibModule_Ext_JwtTokenManagerFactory(Provider<AaaApi> provider, Provider<CoroutineDispatchersFactory> provider2, Provider<TokenExchangeAllowed> provider3, Provider<ITalabatExperiment> provider4, Provider<ITalabatFeatureFlag> provider5, Provider<IRemoteConfigurationDataSource> provider6, Provider<SecretProvider> provider7, Provider<TokenExchangeRetriesRepository> provider8, Provider<TokenResponseMapper> provider9, Provider<TokenRepository> provider10, Provider<IsTokenExpiredUseCase> provider11, Provider<IObservabilityManager> provider12) {
        this.aaaApiProvider = provider;
        this.coroutineDispatchersFactoryProvider = provider2;
        this.exchangeAllowedProvider = provider3;
        this.experimentProvider = provider4;
        this.featureFlagProvider = provider5;
        this.remoteConfigProvider = provider6;
        this.secretProvider = provider7;
        this.tokenExchangeRetriesRepositoryProvider = provider8;
        this.tokenResponseMapperProvider = provider9;
        this.tokenRepositoryProvider = provider10;
        this.isTokenExpiredUseCaseProvider = provider11;
        this.observabilityManagerProvider = provider12;
    }

    public static JwtTokenCoreLibModule_Ext_JwtTokenManagerFactory create(Provider<AaaApi> provider, Provider<CoroutineDispatchersFactory> provider2, Provider<TokenExchangeAllowed> provider3, Provider<ITalabatExperiment> provider4, Provider<ITalabatFeatureFlag> provider5, Provider<IRemoteConfigurationDataSource> provider6, Provider<SecretProvider> provider7, Provider<TokenExchangeRetriesRepository> provider8, Provider<TokenResponseMapper> provider9, Provider<TokenRepository> provider10, Provider<IsTokenExpiredUseCase> provider11, Provider<IObservabilityManager> provider12) {
        return new JwtTokenCoreLibModule_Ext_JwtTokenManagerFactory(provider, provider2, provider3, provider4, provider5, provider6, provider7, provider8, provider9, provider10, provider11, provider12);
    }

    public static JwtTokenManager jwtTokenManager(AaaApi aaaApi, CoroutineDispatchersFactory coroutineDispatchersFactory, TokenExchangeAllowed tokenExchangeAllowed, ITalabatExperiment iTalabatExperiment, ITalabatFeatureFlag iTalabatFeatureFlag, IRemoteConfigurationDataSource iRemoteConfigurationDataSource, SecretProvider secretProvider2, TokenExchangeRetriesRepository tokenExchangeRetriesRepository, TokenResponseMapper tokenResponseMapper, TokenRepository tokenRepository, IsTokenExpiredUseCase isTokenExpiredUseCase, IObservabilityManager iObservabilityManager) {
        return (JwtTokenManager) Preconditions.checkNotNullFromProvides(JwtTokenCoreLibModule.Ext.INSTANCE.jwtTokenManager(aaaApi, coroutineDispatchersFactory, tokenExchangeAllowed, iTalabatExperiment, iTalabatFeatureFlag, iRemoteConfigurationDataSource, secretProvider2, tokenExchangeRetriesRepository, tokenResponseMapper, tokenRepository, isTokenExpiredUseCase, iObservabilityManager));
    }

    public JwtTokenManager get() {
        return jwtTokenManager(this.aaaApiProvider.get(), this.coroutineDispatchersFactoryProvider.get(), this.exchangeAllowedProvider.get(), this.experimentProvider.get(), this.featureFlagProvider.get(), this.remoteConfigProvider.get(), this.secretProvider.get(), this.tokenExchangeRetriesRepositoryProvider.get(), this.tokenResponseMapperProvider.get(), this.tokenRepositoryProvider.get(), this.isTokenExpiredUseCaseProvider.get(), this.observabilityManagerProvider.get());
    }
}
