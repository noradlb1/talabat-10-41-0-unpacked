package com.talabat.authentication.authenticate.data.di;

import com.google.gson.Gson;
import com.talabat.authentication.aaa.AaaApi;
import com.talabat.authentication.aaa.di.AaaCoreLibApi;
import com.talabat.authentication.aaa.di.SecretCoreLibApi;
import com.talabat.authentication.aaa.secrets.SecretProvider;
import com.talabat.authentication.authenticate.data.di.AuthenticationCoreLibComponent;
import com.talabat.authentication.authenticate.data.impl.AuthenticationRepositoryImpl;
import com.talabat.authentication.authenticate.data.impl.AuthenticationRepositoryImpl_Factory;
import com.talabat.authentication.authenticate.data.remote.AuthenticationRemoteDataSource;
import com.talabat.authentication.authenticate.data.remote.impl.AuthenticationRemoteDataSourceImpl;
import com.talabat.authentication.authenticate.data.remote.impl.AuthenticationRemoteDataSourceImpl_Factory;
import com.talabat.authentication.authenticate.data.usecase.UserLoggedInImpl;
import com.talabat.authentication.authenticate.data.usecase.UserLoggedInImpl_Factory;
import com.talabat.authentication.authenticate.domain.repository.AuthenticationRepository;
import com.talabat.authentication.authenticate.domain.repository.SocialAuthenticationRepository;
import com.talabat.authentication.authenticate.domain.usecase.UserLoggedIn;
import com.talabat.authentication.token.data.di.TokenCoreLibDataApi;
import com.talabat.authentication.token.data.local.LegacyTokenLocalDataSource;
import com.talabat.authentication.token.data.remote.LegacyTokenRemoteDataSource;
import com.talabat.authentication.token.data.remote.TokenResponseMapper;
import com.talabat.authentication.token.domain.repository.TokenRepository;
import com.talabat.authentication.usecase.RegistrationObservabilityUseCase;
import com.talabat.core.context.domain.ContextCoreLibApi;
import com.talabat.core.dispatcher.domain.DispatcherCoreLibApi;
import com.talabat.core.featureflag.domain.FeatureFlagCoreLibApi;
import com.talabat.core.featureflag.domain.ITalabatFeatureFlag;
import com.talabat.core.observabilityNew.domain.IObservabilityManager;
import com.talabat.core.observabilityNew.domain.ObservabilityCoreLibApi;
import com.talabat.core.parser.domain.ParserCoreLibApi;
import com.talabat.gdm.owin.domain.GdmOwinTokenApi;
import com.talabat.gdm.owin.domain.GdmOwinTokenRepository;
import dagger.internal.DaggerGenerated;
import dagger.internal.Preconditions;
import dagger.internal.SingleCheck;
import javax.inject.Provider;

@DaggerGenerated
public final class DaggerAuthenticationCoreLibComponent {

    public static final class AuthenticationCoreLibComponentImpl implements AuthenticationCoreLibComponent {
        private final AuthenticationCoreLibComponentImpl authenticationCoreLibComponentImpl;
        private Provider<AuthenticationRemoteDataSourceImpl> authenticationRemoteDataSourceImplProvider;
        private Provider<AuthenticationRemoteDataSource> authenticationRemoteDataSourceProvider;
        private Provider<AuthenticationRepositoryImpl> authenticationRepositoryImplProvider;
        private Provider<AuthenticationRepository> authenticationRepositoryProvider;
        private Provider<AaaApi> getAaaApiProvider;
        private Provider<GdmOwinTokenRepository> getGdmOwinTokenRepositoryProvider;
        private Provider<Gson> getGsonProvider;
        private Provider<LegacyTokenLocalDataSource> getLegacyTokenLocalDataSourceProvider;
        private Provider<LegacyTokenRemoteDataSource> getLegacyTokenRemoteDataSourceProvider;
        private Provider<IObservabilityManager> getObservabilityManagerProvider;
        private Provider<SecretProvider> getSecretProvider;
        private Provider<ITalabatFeatureFlag> getTalabatFeatureFlagProvider;
        private Provider<TokenRepository> getTokenRepositoryProvider;
        private Provider<TokenResponseMapper> getTokenResponseMapperProvider;
        private Provider<UserLoggedIn> isLoggedInUseCaseProvider;
        private final ObservabilityCoreLibApi observabilityCoreLibApi;
        private Provider<SocialAuthenticationRepository> socialAuthenticationRepositoryProvider;
        private Provider<UserLoggedInImpl> userLoggedInImplProvider;

        public static final class GetAaaApiProvider implements Provider<AaaApi> {
            private final AaaCoreLibApi aaaCoreLibApi;

            public GetAaaApiProvider(AaaCoreLibApi aaaCoreLibApi2) {
                this.aaaCoreLibApi = aaaCoreLibApi2;
            }

            public AaaApi get() {
                return (AaaApi) Preconditions.checkNotNullFromComponent(this.aaaCoreLibApi.getAaaApi());
            }
        }

        public static final class GetGdmOwinTokenRepositoryProvider implements Provider<GdmOwinTokenRepository> {
            private final GdmOwinTokenApi gdmOwinTokenApi;

            public GetGdmOwinTokenRepositoryProvider(GdmOwinTokenApi gdmOwinTokenApi2) {
                this.gdmOwinTokenApi = gdmOwinTokenApi2;
            }

            public GdmOwinTokenRepository get() {
                return (GdmOwinTokenRepository) Preconditions.checkNotNullFromComponent(this.gdmOwinTokenApi.getGdmOwinTokenRepository());
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

        public static final class GetLegacyTokenLocalDataSourceProvider implements Provider<LegacyTokenLocalDataSource> {
            private final TokenCoreLibDataApi tokenCoreLibDataApi;

            public GetLegacyTokenLocalDataSourceProvider(TokenCoreLibDataApi tokenCoreLibDataApi2) {
                this.tokenCoreLibDataApi = tokenCoreLibDataApi2;
            }

            public LegacyTokenLocalDataSource get() {
                return (LegacyTokenLocalDataSource) Preconditions.checkNotNullFromComponent(this.tokenCoreLibDataApi.getLegacyTokenLocalDataSource());
            }
        }

        public static final class GetLegacyTokenRemoteDataSourceProvider implements Provider<LegacyTokenRemoteDataSource> {
            private final TokenCoreLibDataApi tokenCoreLibDataApi;

            public GetLegacyTokenRemoteDataSourceProvider(TokenCoreLibDataApi tokenCoreLibDataApi2) {
                this.tokenCoreLibDataApi = tokenCoreLibDataApi2;
            }

            public LegacyTokenRemoteDataSource get() {
                return (LegacyTokenRemoteDataSource) Preconditions.checkNotNullFromComponent(this.tokenCoreLibDataApi.getLegacyTokenRemoteDataSource());
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

        private AuthenticationCoreLibComponentImpl(AaaCoreLibApi aaaCoreLibApi, ContextCoreLibApi contextCoreLibApi, DispatcherCoreLibApi dispatcherCoreLibApi, FeatureFlagCoreLibApi featureFlagCoreLibApi, GdmOwinTokenApi gdmOwinTokenApi, ParserCoreLibApi parserCoreLibApi, SecretCoreLibApi secretCoreLibApi, TokenCoreLibDataApi tokenCoreLibDataApi, ObservabilityCoreLibApi observabilityCoreLibApi2) {
            this.authenticationCoreLibComponentImpl = this;
            this.observabilityCoreLibApi = observabilityCoreLibApi2;
            initialize(aaaCoreLibApi, contextCoreLibApi, dispatcherCoreLibApi, featureFlagCoreLibApi, gdmOwinTokenApi, parserCoreLibApi, secretCoreLibApi, tokenCoreLibDataApi, observabilityCoreLibApi2);
        }

        private void initialize(AaaCoreLibApi aaaCoreLibApi, ContextCoreLibApi contextCoreLibApi, DispatcherCoreLibApi dispatcherCoreLibApi, FeatureFlagCoreLibApi featureFlagCoreLibApi, GdmOwinTokenApi gdmOwinTokenApi, ParserCoreLibApi parserCoreLibApi, SecretCoreLibApi secretCoreLibApi, TokenCoreLibDataApi tokenCoreLibDataApi, ObservabilityCoreLibApi observabilityCoreLibApi2) {
            this.getTokenRepositoryProvider = new GetTokenRepositoryProvider(tokenCoreLibDataApi);
            this.getAaaApiProvider = new GetAaaApiProvider(aaaCoreLibApi);
            this.getGsonProvider = new GetGsonProvider(parserCoreLibApi);
            this.getTalabatFeatureFlagProvider = new GetTalabatFeatureFlagProvider(featureFlagCoreLibApi);
            this.getSecretProvider = new GetSecretProviderProvider(secretCoreLibApi);
            this.getTokenResponseMapperProvider = new GetTokenResponseMapperProvider(tokenCoreLibDataApi);
            GetObservabilityManagerProvider getObservabilityManagerProvider2 = new GetObservabilityManagerProvider(observabilityCoreLibApi2);
            this.getObservabilityManagerProvider = getObservabilityManagerProvider2;
            AuthenticationRemoteDataSourceImpl_Factory create = AuthenticationRemoteDataSourceImpl_Factory.create(this.getAaaApiProvider, this.getGsonProvider, this.getTalabatFeatureFlagProvider, this.getSecretProvider, this.getTokenResponseMapperProvider, getObservabilityManagerProvider2);
            this.authenticationRemoteDataSourceImplProvider = create;
            this.authenticationRemoteDataSourceProvider = SingleCheck.provider(create);
            this.getLegacyTokenRemoteDataSourceProvider = new GetLegacyTokenRemoteDataSourceProvider(tokenCoreLibDataApi);
            this.getLegacyTokenLocalDataSourceProvider = new GetLegacyTokenLocalDataSourceProvider(tokenCoreLibDataApi);
            GetGdmOwinTokenRepositoryProvider getGdmOwinTokenRepositoryProvider2 = new GetGdmOwinTokenRepositoryProvider(gdmOwinTokenApi);
            this.getGdmOwinTokenRepositoryProvider = getGdmOwinTokenRepositoryProvider2;
            UserLoggedInImpl_Factory create2 = UserLoggedInImpl_Factory.create(getGdmOwinTokenRepositoryProvider2, this.getTokenRepositoryProvider);
            this.userLoggedInImplProvider = create2;
            Provider<UserLoggedIn> provider = SingleCheck.provider(create2);
            this.isLoggedInUseCaseProvider = provider;
            AuthenticationRepositoryImpl_Factory create3 = AuthenticationRepositoryImpl_Factory.create(this.getTokenRepositoryProvider, this.authenticationRemoteDataSourceProvider, this.getLegacyTokenRemoteDataSourceProvider, this.getLegacyTokenLocalDataSourceProvider, provider);
            this.authenticationRepositoryImplProvider = create3;
            this.authenticationRepositoryProvider = SingleCheck.provider(create3);
            this.socialAuthenticationRepositoryProvider = SingleCheck.provider(this.authenticationRepositoryImplProvider);
        }

        public AuthenticationRepository getAuthenticationRepository() {
            return this.authenticationRepositoryProvider.get();
        }

        public RegistrationObservabilityUseCase getRegistrationObservabilityUseCase() {
            return new RegistrationObservabilityUseCase((IObservabilityManager) Preconditions.checkNotNullFromComponent(this.observabilityCoreLibApi.getObservabilityManager()));
        }

        public SocialAuthenticationRepository getSocialAuthenticationRepository() {
            return this.socialAuthenticationRepositoryProvider.get();
        }
    }

    public static final class Factory implements AuthenticationCoreLibComponent.Factory {
        private Factory() {
        }

        public AuthenticationCoreLibComponent create(AaaCoreLibApi aaaCoreLibApi, ContextCoreLibApi contextCoreLibApi, DispatcherCoreLibApi dispatcherCoreLibApi, FeatureFlagCoreLibApi featureFlagCoreLibApi, GdmOwinTokenApi gdmOwinTokenApi, ParserCoreLibApi parserCoreLibApi, SecretCoreLibApi secretCoreLibApi, TokenCoreLibDataApi tokenCoreLibDataApi, ObservabilityCoreLibApi observabilityCoreLibApi) {
            Preconditions.checkNotNull(aaaCoreLibApi);
            Preconditions.checkNotNull(contextCoreLibApi);
            Preconditions.checkNotNull(dispatcherCoreLibApi);
            Preconditions.checkNotNull(featureFlagCoreLibApi);
            Preconditions.checkNotNull(gdmOwinTokenApi);
            Preconditions.checkNotNull(parserCoreLibApi);
            Preconditions.checkNotNull(secretCoreLibApi);
            Preconditions.checkNotNull(tokenCoreLibDataApi);
            Preconditions.checkNotNull(observabilityCoreLibApi);
            return new AuthenticationCoreLibComponentImpl(aaaCoreLibApi, contextCoreLibApi, dispatcherCoreLibApi, featureFlagCoreLibApi, gdmOwinTokenApi, parserCoreLibApi, secretCoreLibApi, tokenCoreLibDataApi, observabilityCoreLibApi);
        }
    }

    private DaggerAuthenticationCoreLibComponent() {
    }

    public static AuthenticationCoreLibComponent.Factory factory() {
        return new Factory();
    }
}
