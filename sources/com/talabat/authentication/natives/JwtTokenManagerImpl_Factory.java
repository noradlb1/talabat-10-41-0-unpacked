package com.talabat.authentication.natives;

import com.talabat.authentication.aaa.AaaApi;
import com.talabat.authentication.aaa.secrets.SecretProvider;
import com.talabat.authentication.authenticate.domain.repository.TokenExchangeRetriesRepository;
import com.talabat.authentication.authenticate.domain.usecase.TokenExchangeAllowed;
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
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import javax.inject.Provider;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;

@ScopeMetadata
@DaggerGenerated
@QualifierMetadata
public final class JwtTokenManagerImpl_Factory implements Factory<JwtTokenManagerImpl> {
    private final Provider<AaaApi> aaaApiProvider;
    private final Provider<CoroutineDispatchersFactory> coroutineDispatchersFactoryProvider;
    private final Provider<Function0<String>> deviceIdProvider;
    private final Provider<TokenExchangeAllowed> exchangeAllowedProvider;
    private final Provider<ITalabatExperiment> experimentProvider;
    private final Provider<ITalabatFeatureFlag> featureFlagProvider;
    private final Provider<IsTokenExpiredUseCase> isTokenExpiredUseCaseProvider;
    private final Provider<Function0<Unit>> logoutWithOwinTokenProvider;
    private final Provider<IObservabilityManager> observabilityManagerProvider;
    private final Provider<Function0<String>> owinTokenProvider;
    private final Provider<Function0<? extends IRemoteConfigurationDataSource>> remoteConfigProvider;
    private final Provider<SecretProvider> secretProvider;
    private final Provider<TokenExchangeRetriesRepository> tokenExchangeRetriesRepositoryProvider;
    private final Provider<TokenRepository> tokenRepositoryProvider;
    private final Provider<TokenResponseMapper> tokenResponseMapperProvider;

    public JwtTokenManagerImpl_Factory(Provider<AaaApi> provider, Provider<CoroutineDispatchersFactory> provider2, Provider<TokenExchangeAllowed> provider3, Provider<ITalabatExperiment> provider4, Provider<ITalabatFeatureFlag> provider5, Provider<IObservabilityManager> provider6, Provider<Function0<? extends IRemoteConfigurationDataSource>> provider7, Provider<SecretProvider> provider8, Provider<TokenExchangeRetriesRepository> provider9, Provider<TokenResponseMapper> provider10, Provider<TokenRepository> provider11, Provider<IsTokenExpiredUseCase> provider12, Provider<Function0<String>> provider13, Provider<Function0<Unit>> provider14, Provider<Function0<String>> provider15) {
        this.aaaApiProvider = provider;
        this.coroutineDispatchersFactoryProvider = provider2;
        this.exchangeAllowedProvider = provider3;
        this.experimentProvider = provider4;
        this.featureFlagProvider = provider5;
        this.observabilityManagerProvider = provider6;
        this.remoteConfigProvider = provider7;
        this.secretProvider = provider8;
        this.tokenExchangeRetriesRepositoryProvider = provider9;
        this.tokenResponseMapperProvider = provider10;
        this.tokenRepositoryProvider = provider11;
        this.isTokenExpiredUseCaseProvider = provider12;
        this.deviceIdProvider = provider13;
        this.logoutWithOwinTokenProvider = provider14;
        this.owinTokenProvider = provider15;
    }

    public static JwtTokenManagerImpl_Factory create(Provider<AaaApi> provider, Provider<CoroutineDispatchersFactory> provider2, Provider<TokenExchangeAllowed> provider3, Provider<ITalabatExperiment> provider4, Provider<ITalabatFeatureFlag> provider5, Provider<IObservabilityManager> provider6, Provider<Function0<? extends IRemoteConfigurationDataSource>> provider7, Provider<SecretProvider> provider8, Provider<TokenExchangeRetriesRepository> provider9, Provider<TokenResponseMapper> provider10, Provider<TokenRepository> provider11, Provider<IsTokenExpiredUseCase> provider12, Provider<Function0<String>> provider13, Provider<Function0<Unit>> provider14, Provider<Function0<String>> provider15) {
        return new JwtTokenManagerImpl_Factory(provider, provider2, provider3, provider4, provider5, provider6, provider7, provider8, provider9, provider10, provider11, provider12, provider13, provider14, provider15);
    }

    public static JwtTokenManagerImpl newInstance(AaaApi aaaApi, CoroutineDispatchersFactory coroutineDispatchersFactory, TokenExchangeAllowed tokenExchangeAllowed, ITalabatExperiment iTalabatExperiment, ITalabatFeatureFlag iTalabatFeatureFlag, IObservabilityManager iObservabilityManager, Function0<? extends IRemoteConfigurationDataSource> function0, SecretProvider secretProvider2, TokenExchangeRetriesRepository tokenExchangeRetriesRepository, TokenResponseMapper tokenResponseMapper, TokenRepository tokenRepository, IsTokenExpiredUseCase isTokenExpiredUseCase, Function0<String> function02, Function0<Unit> function03, Function0<String> function04) {
        return new JwtTokenManagerImpl(aaaApi, coroutineDispatchersFactory, tokenExchangeAllowed, iTalabatExperiment, iTalabatFeatureFlag, iObservabilityManager, function0, secretProvider2, tokenExchangeRetriesRepository, tokenResponseMapper, tokenRepository, isTokenExpiredUseCase, function02, function03, function04);
    }

    public JwtTokenManagerImpl get() {
        return newInstance(this.aaaApiProvider.get(), this.coroutineDispatchersFactoryProvider.get(), this.exchangeAllowedProvider.get(), this.experimentProvider.get(), this.featureFlagProvider.get(), this.observabilityManagerProvider.get(), this.remoteConfigProvider.get(), this.secretProvider.get(), this.tokenExchangeRetriesRepositoryProvider.get(), this.tokenResponseMapperProvider.get(), this.tokenRepositoryProvider.get(), this.isTokenExpiredUseCaseProvider.get(), this.deviceIdProvider.get(), this.logoutWithOwinTokenProvider.get(), this.owinTokenProvider.get());
    }
}
