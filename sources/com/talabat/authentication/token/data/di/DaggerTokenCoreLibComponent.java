package com.talabat.authentication.token.data.di;

import android.content.Context;
import com.google.gson.Gson;
import com.squareup.moshi.Moshi;
import com.talabat.authentication.aaa.AaaApi;
import com.talabat.authentication.aaa.di.AaaCoreLibApi;
import com.talabat.authentication.aaa.di.SecretCoreLibApi;
import com.talabat.authentication.aaa.secrets.SecretProvider;
import com.talabat.authentication.authenticate.data.repository.TokenExchangeRetriesRepositoryImpl_Factory;
import com.talabat.authentication.authenticate.domain.repository.TokenExchangeRetriesRepository;
import com.talabat.authentication.token.data.di.TokenCoreLibComponent;
import com.talabat.authentication.token.data.flutter.TokenFlutterMapper;
import com.talabat.authentication.token.data.flutter.impl.TokenFlutterMapperImpl_Factory;
import com.talabat.authentication.token.data.impl.TokenRepositoryImpl;
import com.talabat.authentication.token.data.impl.TokenRepositoryImpl_Factory;
import com.talabat.authentication.token.data.local.EncryptedStorageProvider;
import com.talabat.authentication.token.data.local.LegacyTokenLocalDataSource;
import com.talabat.authentication.token.data.local.TokenLocalDataSource;
import com.talabat.authentication.token.data.local.impl.EncryptedStorageProviderImpl;
import com.talabat.authentication.token.data.local.impl.EncryptedStorageProviderImpl_Factory;
import com.talabat.authentication.token.data.local.impl.LegacyTokenLocalDataSourceImpl;
import com.talabat.authentication.token.data.local.impl.LegacyTokenLocalDataSourceImpl_Factory;
import com.talabat.authentication.token.data.local.impl.TokenLocalDataSourceImpl;
import com.talabat.authentication.token.data.local.impl.TokenLocalDataSourceImpl_Factory;
import com.talabat.authentication.token.data.remote.LegacyTokenRemoteDataSource;
import com.talabat.authentication.token.data.remote.TokenRemoteDataSource;
import com.talabat.authentication.token.data.remote.TokenResponseMapper;
import com.talabat.authentication.token.data.remote.impl.JwtPayloadDecoder;
import com.talabat.authentication.token.data.remote.impl.JwtPayloadDecoder_Factory;
import com.talabat.authentication.token.data.remote.impl.LegacyTokenRemoteDataSourceImpl;
import com.talabat.authentication.token.data.remote.impl.TokenRemoteDataSourceImpl;
import com.talabat.authentication.token.data.remote.impl.TokenRemoteDataSourceImpl_Factory;
import com.talabat.authentication.token.data.remote.impl.TokenResponseMapperImpl;
import com.talabat.authentication.token.data.remote.impl.TokenResponseMapperImpl_Factory;
import com.talabat.authentication.token.domain.repository.TokenRepository;
import com.talabat.authentication.usecase.CalculateTokenTimeDifferenceUseCase;
import com.talabat.authentication.usecase.CalculateTokenTimeDifferenceUseCase_Factory;
import com.talabat.authentication.usecase.DeviceTimeProvider;
import com.talabat.authentication.usecase.DeviceTimeProvider_Factory;
import com.talabat.authentication.usecase.IsTokenTimeDifferenceEnabledUseCase;
import com.talabat.authentication.usecase.IsTokenTimeDifferenceEnabledUseCase_Factory;
import com.talabat.core.context.domain.ContextCoreLibApi;
import com.talabat.core.featureflag.domain.FeatureFlagCoreLibApi;
import com.talabat.core.featureflag.domain.ITalabatFeatureFlag;
import com.talabat.core.observabilityNew.domain.IObservabilityManager;
import com.talabat.core.observabilityNew.domain.ObservabilityCoreLibApi;
import com.talabat.core.parser.domain.ParserCoreLibApi;
import dagger.internal.DaggerGenerated;
import dagger.internal.Preconditions;
import dagger.internal.SingleCheck;
import javax.inject.Provider;

@DaggerGenerated
public final class DaggerTokenCoreLibComponent {

    public static final class Factory implements TokenCoreLibComponent.Factory {
        private Factory() {
        }

        public TokenCoreLibComponent create(AaaCoreLibApi aaaCoreLibApi, ContextCoreLibApi contextCoreLibApi, FeatureFlagCoreLibApi featureFlagCoreLibApi, ParserCoreLibApi parserCoreLibApi, SecretCoreLibApi secretCoreLibApi, ObservabilityCoreLibApi observabilityCoreLibApi) {
            Preconditions.checkNotNull(aaaCoreLibApi);
            Preconditions.checkNotNull(contextCoreLibApi);
            Preconditions.checkNotNull(featureFlagCoreLibApi);
            Preconditions.checkNotNull(parserCoreLibApi);
            Preconditions.checkNotNull(secretCoreLibApi);
            Preconditions.checkNotNull(observabilityCoreLibApi);
            return new TokenCoreLibComponentImpl(aaaCoreLibApi, contextCoreLibApi, featureFlagCoreLibApi, parserCoreLibApi, secretCoreLibApi, observabilityCoreLibApi);
        }
    }

    public static final class TokenCoreLibComponentImpl implements TokenCoreLibComponent {
        private final AaaCoreLibApi aaaCoreLibApi;
        private Provider<CalculateTokenTimeDifferenceUseCase> calculateTokenTimeDifferenceUseCaseProvider;
        private final ContextCoreLibApi contextCoreLibApi;
        private Provider<EncryptedStorageProviderImpl> encryptedStorageProviderImplProvider;
        private final FeatureFlagCoreLibApi featureFlagCoreLibApi;
        private Provider<AaaApi> getAaaApiProvider;
        private Provider<Context> getContextProvider;
        private Provider<Gson> getGsonProvider;
        private Provider<Moshi> getMoshiProvider;
        private Provider<IObservabilityManager> getObservabilityManagerProvider;
        private Provider<SecretProvider> getSecretProvider;
        private Provider<ITalabatFeatureFlag> getTalabatFeatureFlagProvider;
        private Provider<IsTokenTimeDifferenceEnabledUseCase> isTokenTimeDifferenceEnabledUseCaseProvider;
        private Provider<JwtPayloadDecoder> jwtPayloadDecoderProvider;
        private Provider<LegacyTokenLocalDataSourceImpl> legacyTokenLocalDataSourceImplProvider;
        private final ParserCoreLibApi parserCoreLibApi;
        private final SecretCoreLibApi secretCoreLibApi;
        private final TokenCoreLibComponentImpl tokenCoreLibComponentImpl;
        private Provider<TokenExchangeRetriesRepository> tokenExchangeRetriesRepositoryProvider;
        private Provider<TokenFlutterMapper> tokenFlutterMapperProvider;
        private Provider<TokenLocalDataSourceImpl> tokenLocalDataSourceImplProvider;
        private Provider<TokenLocalDataSource> tokenLocalDataSourceProvider;
        private Provider<TokenRemoteDataSourceImpl> tokenRemoteDataSourceImplProvider;
        private Provider<TokenRepositoryImpl> tokenRepositoryImplProvider;
        private Provider<TokenRepository> tokenRepositoryProvider;
        private Provider<TokenResponseMapperImpl> tokenResponseMapperImplProvider;

        public static final class GetAaaApiProvider implements Provider<AaaApi> {
            private final AaaCoreLibApi aaaCoreLibApi;

            public GetAaaApiProvider(AaaCoreLibApi aaaCoreLibApi2) {
                this.aaaCoreLibApi = aaaCoreLibApi2;
            }

            public AaaApi get() {
                return (AaaApi) Preconditions.checkNotNullFromComponent(this.aaaCoreLibApi.getAaaApi());
            }
        }

        public static final class GetContextProvider implements Provider<Context> {
            private final ContextCoreLibApi contextCoreLibApi;

            public GetContextProvider(ContextCoreLibApi contextCoreLibApi2) {
                this.contextCoreLibApi = contextCoreLibApi2;
            }

            public Context get() {
                return (Context) Preconditions.checkNotNullFromComponent(this.contextCoreLibApi.getContext());
            }
        }

        public static final class GetGsonProvider implements Provider<Gson> {
            private final ParserCoreLibApi parserCoreLibApi;

            public GetGsonProvider(ParserCoreLibApi parserCoreLibApi2) {
                this.parserCoreLibApi = parserCoreLibApi2;
            }

            public Gson get() {
                return (Gson) Preconditions.checkNotNullFromComponent(this.parserCoreLibApi.getGson());
            }
        }

        public static final class GetMoshiProvider implements Provider<Moshi> {
            private final ParserCoreLibApi parserCoreLibApi;

            public GetMoshiProvider(ParserCoreLibApi parserCoreLibApi2) {
                this.parserCoreLibApi = parserCoreLibApi2;
            }

            public Moshi get() {
                return (Moshi) Preconditions.checkNotNullFromComponent(this.parserCoreLibApi.getMoshi());
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

        private TokenCoreLibComponentImpl(AaaCoreLibApi aaaCoreLibApi2, ContextCoreLibApi contextCoreLibApi2, FeatureFlagCoreLibApi featureFlagCoreLibApi2, ParserCoreLibApi parserCoreLibApi2, SecretCoreLibApi secretCoreLibApi2, ObservabilityCoreLibApi observabilityCoreLibApi) {
            this.tokenCoreLibComponentImpl = this;
            this.contextCoreLibApi = contextCoreLibApi2;
            this.featureFlagCoreLibApi = featureFlagCoreLibApi2;
            this.parserCoreLibApi = parserCoreLibApi2;
            this.aaaCoreLibApi = aaaCoreLibApi2;
            this.secretCoreLibApi = secretCoreLibApi2;
            initialize(aaaCoreLibApi2, contextCoreLibApi2, featureFlagCoreLibApi2, parserCoreLibApi2, secretCoreLibApi2, observabilityCoreLibApi);
        }

        private CalculateTokenTimeDifferenceUseCase calculateTokenTimeDifferenceUseCase() {
            return new CalculateTokenTimeDifferenceUseCase(isTokenTimeDifferenceEnabledUseCase(), new DeviceTimeProvider(), jwtPayloadDecoder());
        }

        private EncryptedStorageProviderImpl encryptedStorageProviderImpl() {
            return new EncryptedStorageProviderImpl((Context) Preconditions.checkNotNullFromComponent(this.contextCoreLibApi.getContext()));
        }

        private void initialize(AaaCoreLibApi aaaCoreLibApi2, ContextCoreLibApi contextCoreLibApi2, FeatureFlagCoreLibApi featureFlagCoreLibApi2, ParserCoreLibApi parserCoreLibApi2, SecretCoreLibApi secretCoreLibApi2, ObservabilityCoreLibApi observabilityCoreLibApi) {
            this.getContextProvider = new GetContextProvider(contextCoreLibApi2);
            GetGsonProvider getGsonProvider2 = new GetGsonProvider(parserCoreLibApi2);
            this.getGsonProvider = getGsonProvider2;
            this.legacyTokenLocalDataSourceImplProvider = LegacyTokenLocalDataSourceImpl_Factory.create(this.getContextProvider, getGsonProvider2);
            this.getAaaApiProvider = new GetAaaApiProvider(aaaCoreLibApi2);
            GetTalabatFeatureFlagProvider getTalabatFeatureFlagProvider2 = new GetTalabatFeatureFlagProvider(featureFlagCoreLibApi2);
            this.getTalabatFeatureFlagProvider = getTalabatFeatureFlagProvider2;
            this.isTokenTimeDifferenceEnabledUseCaseProvider = IsTokenTimeDifferenceEnabledUseCase_Factory.create(getTalabatFeatureFlagProvider2);
            GetMoshiProvider getMoshiProvider2 = new GetMoshiProvider(parserCoreLibApi2);
            this.getMoshiProvider = getMoshiProvider2;
            this.jwtPayloadDecoderProvider = JwtPayloadDecoder_Factory.create(getMoshiProvider2);
            CalculateTokenTimeDifferenceUseCase_Factory create = CalculateTokenTimeDifferenceUseCase_Factory.create(this.isTokenTimeDifferenceEnabledUseCaseProvider, DeviceTimeProvider_Factory.create(), this.jwtPayloadDecoderProvider);
            this.calculateTokenTimeDifferenceUseCaseProvider = create;
            this.tokenResponseMapperImplProvider = TokenResponseMapperImpl_Factory.create(create);
            GetSecretProviderProvider getSecretProviderProvider = new GetSecretProviderProvider(secretCoreLibApi2);
            this.getSecretProvider = getSecretProviderProvider;
            this.tokenRemoteDataSourceImplProvider = TokenRemoteDataSourceImpl_Factory.create(this.getAaaApiProvider, this.tokenResponseMapperImplProvider, this.getGsonProvider, getSecretProviderProvider);
            this.encryptedStorageProviderImplProvider = EncryptedStorageProviderImpl_Factory.create(this.getContextProvider);
            GetObservabilityManagerProvider getObservabilityManagerProvider2 = new GetObservabilityManagerProvider(observabilityCoreLibApi);
            this.getObservabilityManagerProvider = getObservabilityManagerProvider2;
            TokenLocalDataSourceImpl_Factory create2 = TokenLocalDataSourceImpl_Factory.create(this.encryptedStorageProviderImplProvider, this.getMoshiProvider, getObservabilityManagerProvider2);
            this.tokenLocalDataSourceImplProvider = create2;
            this.tokenLocalDataSourceProvider = SingleCheck.provider(create2);
            Provider<TokenExchangeRetriesRepository> provider = SingleCheck.provider(TokenExchangeRetriesRepositoryImpl_Factory.create());
            this.tokenExchangeRetriesRepositoryProvider = provider;
            TokenRepositoryImpl_Factory create3 = TokenRepositoryImpl_Factory.create(this.legacyTokenLocalDataSourceImplProvider, this.tokenRemoteDataSourceImplProvider, this.tokenLocalDataSourceProvider, provider, this.getObservabilityManagerProvider);
            this.tokenRepositoryImplProvider = create3;
            this.tokenRepositoryProvider = SingleCheck.provider(create3);
            this.tokenFlutterMapperProvider = SingleCheck.provider(TokenFlutterMapperImpl_Factory.create());
        }

        private IsTokenTimeDifferenceEnabledUseCase isTokenTimeDifferenceEnabledUseCase() {
            return new IsTokenTimeDifferenceEnabledUseCase((ITalabatFeatureFlag) Preconditions.checkNotNullFromComponent(this.featureFlagCoreLibApi.getTalabatFeatureFlag()));
        }

        private JwtPayloadDecoder jwtPayloadDecoder() {
            return new JwtPayloadDecoder((Moshi) Preconditions.checkNotNullFromComponent(this.parserCoreLibApi.getMoshi()));
        }

        private LegacyTokenLocalDataSourceImpl legacyTokenLocalDataSourceImpl() {
            return new LegacyTokenLocalDataSourceImpl((Context) Preconditions.checkNotNullFromComponent(this.contextCoreLibApi.getContext()), (Gson) Preconditions.checkNotNullFromComponent(this.parserCoreLibApi.getGson()));
        }

        private LegacyTokenRemoteDataSourceImpl legacyTokenRemoteDataSourceImpl() {
            return new LegacyTokenRemoteDataSourceImpl(SwapTokenApiModule_SwapTokenApiFactory.swapTokenApi());
        }

        private TokenRemoteDataSourceImpl tokenRemoteDataSourceImpl() {
            return new TokenRemoteDataSourceImpl((AaaApi) Preconditions.checkNotNullFromComponent(this.aaaCoreLibApi.getAaaApi()), tokenResponseMapperImpl(), (Gson) Preconditions.checkNotNullFromComponent(this.parserCoreLibApi.getGson()), (SecretProvider) Preconditions.checkNotNullFromComponent(this.secretCoreLibApi.getSecretProvider()));
        }

        private TokenResponseMapperImpl tokenResponseMapperImpl() {
            return new TokenResponseMapperImpl(calculateTokenTimeDifferenceUseCase());
        }

        public EncryptedStorageProvider getEncryptedStorageProvider() {
            return encryptedStorageProviderImpl();
        }

        public LegacyTokenLocalDataSource getLegacyTokenLocalDataSource() {
            return legacyTokenLocalDataSourceImpl();
        }

        public LegacyTokenRemoteDataSource getLegacyTokenRemoteDataSource() {
            return legacyTokenRemoteDataSourceImpl();
        }

        public TokenFlutterMapper getTokenFlutterMapper() {
            return this.tokenFlutterMapperProvider.get();
        }

        public TokenLocalDataSource getTokenLocalDataSource() {
            return this.tokenLocalDataSourceProvider.get();
        }

        public TokenRemoteDataSource getTokenRemoteDataSource() {
            return tokenRemoteDataSourceImpl();
        }

        public TokenRepository getTokenRepository() {
            return this.tokenRepositoryProvider.get();
        }

        public TokenResponseMapper getTokenResponseMapper() {
            return tokenResponseMapperImpl();
        }
    }

    private DaggerTokenCoreLibComponent() {
    }

    public static TokenCoreLibComponent.Factory factory() {
        return new Factory();
    }
}
