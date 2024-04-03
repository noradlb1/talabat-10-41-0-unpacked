package com.talabat.authentication.natives.di;

import com.talabat.authentication.JwtTokenManager;
import com.talabat.authentication.JwtTokenRepository;
import com.talabat.authentication.aaa.AaaApi;
import com.talabat.authentication.aaa.di.AaaCoreLibApi;
import com.talabat.authentication.aaa.di.SecretCoreLibApi;
import com.talabat.authentication.aaa.secrets.SecretProvider;
import com.talabat.authentication.authenticate.data.repository.TokenExchangeRetriesRepositoryImpl_Factory;
import com.talabat.authentication.authenticate.data.usecase.TokenExchangeAllowedImpl;
import com.talabat.authentication.authenticate.data.usecase.TokenExchangeAllowedImpl_Factory;
import com.talabat.authentication.authenticate.domain.AuthenticationCoreLibApi;
import com.talabat.authentication.authenticate.domain.repository.TokenExchangeRetriesRepository;
import com.talabat.authentication.authenticate.domain.usecase.TokenExchangeAllowed;
import com.talabat.authentication.natives.JwtTokenRepositoryImpl;
import com.talabat.authentication.natives.JwtTokenRepositoryImpl_Factory;
import com.talabat.authentication.natives.di.JwtTokenCoreLibComponent;
import com.talabat.authentication.token.data.di.TokenCoreLibDataApi;
import com.talabat.authentication.token.data.remote.TokenResponseMapper;
import com.talabat.authentication.token.domain.repository.TokenRepository;
import com.talabat.authentication.usecase.DeviceTimeProvider_Factory;
import com.talabat.authentication.usecase.IsTokenExpiredUseCase;
import com.talabat.authentication.usecase.IsTokenExpiredUseCase_Factory;
import com.talabat.authentication.usecase.IsTokenTimeDifferenceEnabledUseCase;
import com.talabat.authentication.usecase.IsTokenTimeDifferenceEnabledUseCase_Factory;
import com.talabat.core.dispatcher.domain.CoroutineDispatchersFactory;
import com.talabat.core.dispatcher.domain.DispatcherCoreLibApi;
import com.talabat.core.experiment.domain.ExperimentCoreLibApi;
import com.talabat.core.experiment.domain.ITalabatExperiment;
import com.talabat.core.featureflag.domain.FeatureFlagCoreLibApi;
import com.talabat.core.featureflag.domain.ITalabatFeatureFlag;
import com.talabat.core.observabilityNew.domain.IObservabilityManager;
import com.talabat.core.observabilityNew.domain.ObservabilityCoreLibApi;
import com.talabat.talabatremoteconfiguration.datasource.IRemoteConfigurationDataSource;
import com.talabat.talabatremoteconfiguration.di.RemoteConfigCoreLibApi;
import dagger.internal.DaggerGenerated;
import dagger.internal.Preconditions;
import dagger.internal.SingleCheck;
import javax.inject.Provider;

@DaggerGenerated
public final class DaggerJwtTokenCoreLibComponent {

    public static final class Factory implements JwtTokenCoreLibComponent.Factory {
        private Factory() {
        }

        public JwtTokenCoreLibComponent create(AaaCoreLibApi aaaCoreLibApi, AuthenticationCoreLibApi authenticationCoreLibApi, DispatcherCoreLibApi dispatcherCoreLibApi, ExperimentCoreLibApi experimentCoreLibApi, FeatureFlagCoreLibApi featureFlagCoreLibApi, ObservabilityCoreLibApi observabilityCoreLibApi, RemoteConfigCoreLibApi remoteConfigCoreLibApi, SecretCoreLibApi secretCoreLibApi, TokenCoreLibDataApi tokenCoreLibDataApi) {
            Preconditions.checkNotNull(aaaCoreLibApi);
            Preconditions.checkNotNull(authenticationCoreLibApi);
            Preconditions.checkNotNull(dispatcherCoreLibApi);
            Preconditions.checkNotNull(experimentCoreLibApi);
            Preconditions.checkNotNull(featureFlagCoreLibApi);
            Preconditions.checkNotNull(observabilityCoreLibApi);
            Preconditions.checkNotNull(remoteConfigCoreLibApi);
            Preconditions.checkNotNull(secretCoreLibApi);
            Preconditions.checkNotNull(tokenCoreLibDataApi);
            return new JwtTokenCoreLibComponentImpl(aaaCoreLibApi, authenticationCoreLibApi, dispatcherCoreLibApi, experimentCoreLibApi, featureFlagCoreLibApi, observabilityCoreLibApi, remoteConfigCoreLibApi, secretCoreLibApi, tokenCoreLibDataApi);
        }
    }

    public static final class JwtTokenCoreLibComponentImpl implements JwtTokenCoreLibComponent {
        private Provider<AaaApi> getAaaApiProvider;
        private Provider<CoroutineDispatchersFactory> getCoroutineDispatchersFactoryProvider;
        private Provider<ITalabatExperiment> getExperimentProvider;
        private Provider<IObservabilityManager> getObservabilityManagerProvider;
        private Provider<IRemoteConfigurationDataSource> getRemoteConfigurationDataSourceProvider;
        private Provider<SecretProvider> getSecretProvider;
        private Provider<ITalabatFeatureFlag> getTalabatFeatureFlagProvider;
        private Provider<TokenRepository> getTokenRepositoryProvider;
        private Provider<TokenResponseMapper> getTokenResponseMapperProvider;
        private Provider<IsTokenExpiredUseCase> isTokenExpiredUseCaseProvider;
        private Provider<IsTokenTimeDifferenceEnabledUseCase> isTokenTimeDifferenceEnabledUseCaseProvider;
        private final JwtTokenCoreLibComponentImpl jwtTokenCoreLibComponentImpl;
        private Provider<JwtTokenManager> jwtTokenManagerProvider;
        private Provider<JwtTokenRepositoryImpl> jwtTokenRepositoryImplProvider;
        private Provider<JwtTokenRepository> jwtTokenRepositoryProvider;
        private Provider<TokenExchangeAllowedImpl> tokenExchangeAllowedImplProvider;
        private Provider<TokenExchangeAllowed> tokenExchangeAllowedUseCaseProvider;
        private Provider<TokenExchangeRetriesRepository> tokenExchangeRetriesRepositoryProvider;

        public static final class GetAaaApiProvider implements Provider<AaaApi> {
            private final AaaCoreLibApi aaaCoreLibApi;

            public GetAaaApiProvider(AaaCoreLibApi aaaCoreLibApi2) {
                this.aaaCoreLibApi = aaaCoreLibApi2;
            }

            public AaaApi get() {
                return (AaaApi) Preconditions.checkNotNullFromComponent(this.aaaCoreLibApi.getAaaApi());
            }
        }

        public static final class GetCoroutineDispatchersFactoryProvider implements Provider<CoroutineDispatchersFactory> {
            private final DispatcherCoreLibApi dispatcherCoreLibApi;

            public GetCoroutineDispatchersFactoryProvider(DispatcherCoreLibApi dispatcherCoreLibApi2) {
                this.dispatcherCoreLibApi = dispatcherCoreLibApi2;
            }

            public CoroutineDispatchersFactory get() {
                return (CoroutineDispatchersFactory) Preconditions.checkNotNullFromComponent(this.dispatcherCoreLibApi.getCoroutineDispatchersFactory());
            }
        }

        public static final class GetExperimentProviderProvider implements Provider<ITalabatExperiment> {
            private final ExperimentCoreLibApi experimentCoreLibApi;

            public GetExperimentProviderProvider(ExperimentCoreLibApi experimentCoreLibApi2) {
                this.experimentCoreLibApi = experimentCoreLibApi2;
            }

            public ITalabatExperiment get() {
                return (ITalabatExperiment) Preconditions.checkNotNullFromComponent(this.experimentCoreLibApi.getExperimentProvider());
            }
        }

        public static final class GetObservabilityManagerProvider implements Provider<IObservabilityManager> {
            private final ObservabilityCoreLibApi observabilityCoreLibApi;

            public GetObservabilityManagerProvider(ObservabilityCoreLibApi observabilityCoreLibApi2) {
                this.observabilityCoreLibApi = observabilityCoreLibApi2;
            }

            public IObservabilityManager get() {
                return (IObservabilityManager) Preconditions.checkNotNullFromComponent(this.observabilityCoreLibApi.getObservabilityManager());
            }
        }

        public static final class GetRemoteConfigurationDataSourceProvider implements Provider<IRemoteConfigurationDataSource> {
            private final RemoteConfigCoreLibApi remoteConfigCoreLibApi;

            public GetRemoteConfigurationDataSourceProvider(RemoteConfigCoreLibApi remoteConfigCoreLibApi2) {
                this.remoteConfigCoreLibApi = remoteConfigCoreLibApi2;
            }

            public IRemoteConfigurationDataSource get() {
                return (IRemoteConfigurationDataSource) Preconditions.checkNotNullFromComponent(this.remoteConfigCoreLibApi.getRemoteConfigurationDataSource());
            }
        }

        public static final class GetSecretProviderProvider implements Provider<SecretProvider> {
            private final SecretCoreLibApi secretCoreLibApi;

            public GetSecretProviderProvider(SecretCoreLibApi secretCoreLibApi2) {
                this.secretCoreLibApi = secretCoreLibApi2;
            }

            public SecretProvider get() {
                return (SecretProvider) Preconditions.checkNotNullFromComponent(this.secretCoreLibApi.getSecretProvider());
            }
        }

        public static final class GetTalabatFeatureFlagProvider implements Provider<ITalabatFeatureFlag> {
            private final FeatureFlagCoreLibApi featureFlagCoreLibApi;

            public GetTalabatFeatureFlagProvider(FeatureFlagCoreLibApi featureFlagCoreLibApi2) {
                this.featureFlagCoreLibApi = featureFlagCoreLibApi2;
            }

            public ITalabatFeatureFlag get() {
                return (ITalabatFeatureFlag) Preconditions.checkNotNullFromComponent(this.featureFlagCoreLibApi.getTalabatFeatureFlag());
            }
        }

        public static final class GetTokenRepositoryProvider implements Provider<TokenRepository> {
            private final TokenCoreLibDataApi tokenCoreLibDataApi;

            public GetTokenRepositoryProvider(TokenCoreLibDataApi tokenCoreLibDataApi2) {
                this.tokenCoreLibDataApi = tokenCoreLibDataApi2;
            }

            public TokenRepository get() {
                return (TokenRepository) Preconditions.checkNotNullFromComponent(this.tokenCoreLibDataApi.getTokenRepository());
            }
        }

        public static final class GetTokenResponseMapperProvider implements Provider<TokenResponseMapper> {
            private final TokenCoreLibDataApi tokenCoreLibDataApi;

            public GetTokenResponseMapperProvider(TokenCoreLibDataApi tokenCoreLibDataApi2) {
                this.tokenCoreLibDataApi = tokenCoreLibDataApi2;
            }

            public TokenResponseMapper get() {
                return (TokenResponseMapper) Preconditions.checkNotNullFromComponent(this.tokenCoreLibDataApi.getTokenResponseMapper());
            }
        }

        private JwtTokenCoreLibComponentImpl(AaaCoreLibApi aaaCoreLibApi, AuthenticationCoreLibApi authenticationCoreLibApi, DispatcherCoreLibApi dispatcherCoreLibApi, ExperimentCoreLibApi experimentCoreLibApi, FeatureFlagCoreLibApi featureFlagCoreLibApi, ObservabilityCoreLibApi observabilityCoreLibApi, RemoteConfigCoreLibApi remoteConfigCoreLibApi, SecretCoreLibApi secretCoreLibApi, TokenCoreLibDataApi tokenCoreLibDataApi) {
            this.jwtTokenCoreLibComponentImpl = this;
            initialize(aaaCoreLibApi, authenticationCoreLibApi, dispatcherCoreLibApi, experimentCoreLibApi, featureFlagCoreLibApi, observabilityCoreLibApi, remoteConfigCoreLibApi, secretCoreLibApi, tokenCoreLibDataApi);
        }

        private void initialize(AaaCoreLibApi aaaCoreLibApi, AuthenticationCoreLibApi authenticationCoreLibApi, DispatcherCoreLibApi dispatcherCoreLibApi, ExperimentCoreLibApi experimentCoreLibApi, FeatureFlagCoreLibApi featureFlagCoreLibApi, ObservabilityCoreLibApi observabilityCoreLibApi, RemoteConfigCoreLibApi remoteConfigCoreLibApi, SecretCoreLibApi secretCoreLibApi, TokenCoreLibDataApi tokenCoreLibDataApi) {
            TokenCoreLibDataApi tokenCoreLibDataApi2 = tokenCoreLibDataApi;
            AaaCoreLibApi aaaCoreLibApi2 = aaaCoreLibApi;
            this.getAaaApiProvider = new GetAaaApiProvider(aaaCoreLibApi);
            this.getCoroutineDispatchersFactoryProvider = new GetCoroutineDispatchersFactoryProvider(dispatcherCoreLibApi);
            Provider<TokenExchangeRetriesRepository> provider = SingleCheck.provider(TokenExchangeRetriesRepositoryImpl_Factory.create());
            this.tokenExchangeRetriesRepositoryProvider = provider;
            TokenExchangeAllowedImpl_Factory create = TokenExchangeAllowedImpl_Factory.create(provider);
            this.tokenExchangeAllowedImplProvider = create;
            this.tokenExchangeAllowedUseCaseProvider = SingleCheck.provider(create);
            this.getExperimentProvider = new GetExperimentProviderProvider(experimentCoreLibApi);
            this.getTalabatFeatureFlagProvider = new GetTalabatFeatureFlagProvider(featureFlagCoreLibApi);
            this.getRemoteConfigurationDataSourceProvider = new GetRemoteConfigurationDataSourceProvider(remoteConfigCoreLibApi);
            this.getSecretProvider = new GetSecretProviderProvider(secretCoreLibApi);
            this.getTokenResponseMapperProvider = new GetTokenResponseMapperProvider(tokenCoreLibDataApi2);
            this.getTokenRepositoryProvider = new GetTokenRepositoryProvider(tokenCoreLibDataApi2);
            IsTokenTimeDifferenceEnabledUseCase_Factory create2 = IsTokenTimeDifferenceEnabledUseCase_Factory.create(this.getTalabatFeatureFlagProvider);
            this.isTokenTimeDifferenceEnabledUseCaseProvider = create2;
            this.isTokenExpiredUseCaseProvider = IsTokenExpiredUseCase_Factory.create(create2, DeviceTimeProvider_Factory.create());
            GetObservabilityManagerProvider getObservabilityManagerProvider2 = new GetObservabilityManagerProvider(observabilityCoreLibApi);
            this.getObservabilityManagerProvider = getObservabilityManagerProvider2;
            Provider<JwtTokenManager> provider2 = SingleCheck.provider(JwtTokenCoreLibModule_Ext_JwtTokenManagerFactory.create(this.getAaaApiProvider, this.getCoroutineDispatchersFactoryProvider, this.tokenExchangeAllowedUseCaseProvider, this.getExperimentProvider, this.getTalabatFeatureFlagProvider, this.getRemoteConfigurationDataSourceProvider, this.getSecretProvider, this.tokenExchangeRetriesRepositoryProvider, this.getTokenResponseMapperProvider, this.getTokenRepositoryProvider, this.isTokenExpiredUseCaseProvider, getObservabilityManagerProvider2));
            this.jwtTokenManagerProvider = provider2;
            JwtTokenRepositoryImpl_Factory create3 = JwtTokenRepositoryImpl_Factory.create(provider2);
            this.jwtTokenRepositoryImplProvider = create3;
            this.jwtTokenRepositoryProvider = SingleCheck.provider(create3);
        }

        public JwtTokenRepository getJwtTokenRepository() {
            return this.jwtTokenRepositoryProvider.get();
        }
    }

    private DaggerJwtTokenCoreLibComponent() {
    }

    public static JwtTokenCoreLibComponent.Factory factory() {
        return new Factory();
    }
}
