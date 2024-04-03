package com.talabat.core.social.login.data.di;

import com.talabat.authentication.authenticate.domain.AuthenticationCoreLibApi;
import com.talabat.authentication.authenticate.domain.repository.SocialAuthenticationRepository;
import com.talabat.core.facebook.login.domain.FacebookLoginCoreLibApi;
import com.talabat.core.facebook.login.domain.integration.FacebookLoginActivityIntegration;
import com.talabat.core.facebook.login.domain.repository.FacebookLoginRepository;
import com.talabat.core.google.login.domain.GoogleLoginCoreLibApi;
import com.talabat.core.google.login.domain.repository.GoogleLoginRepository;
import com.talabat.core.social.login.data.di.SocialLoginCoreLibComponent;
import com.talabat.core.social.login.domain.AaaAuthenticationForSocialLoginRepository;
import com.talabat.core.social.login.domain.FacebookLoginUseCase;
import com.talabat.core.social.login.domain.GoogleLoginUseCase;
import com.talabat.core.social.login.domain.InitializeFacebookLoginUseCase;
import com.talabat.core.social.login.domain.InitializeGoogleLoginUseCase;
import com.talabat.core.social.login.domain.di.SocialLoginDomainModule;
import dagger.internal.DaggerGenerated;
import dagger.internal.Preconditions;
import dagger.internal.SingleCheck;
import javax.inject.Provider;

@DaggerGenerated
public final class DaggerSocialLoginCoreLibComponent {

    public static final class Factory implements SocialLoginCoreLibComponent.Factory {
        private Factory() {
        }

        public SocialLoginCoreLibComponent create(AuthenticationCoreLibApi authenticationCoreLibApi, GoogleLoginCoreLibApi googleLoginCoreLibApi, FacebookLoginCoreLibApi facebookLoginCoreLibApi) {
            Preconditions.checkNotNull(authenticationCoreLibApi);
            Preconditions.checkNotNull(googleLoginCoreLibApi);
            Preconditions.checkNotNull(facebookLoginCoreLibApi);
            return new SocialLoginCoreLibComponentImpl(new SocialLoginCoreLibModule(), authenticationCoreLibApi, googleLoginCoreLibApi, facebookLoginCoreLibApi);
        }
    }

    public static final class SocialLoginCoreLibComponentImpl implements SocialLoginCoreLibComponent {
        private Provider<FacebookLoginUseCase> facebookLoginUseCaseProvider;
        private Provider<FacebookLoginActivityIntegration> getFacebookLoginActivityIntegrationProvider;
        private Provider<FacebookLoginRepository> getFacebookLoginRepositoryProvider;
        private Provider<GoogleLoginRepository> getGoogleLoginRepositoryProvider;
        private Provider<SocialAuthenticationRepository> getSocialAuthenticationRepositoryProvider;
        private Provider<GoogleLoginUseCase> googleLoginUseCaseProvider;
        private Provider<InitializeFacebookLoginUseCase> initializeFacebookLoginUseCaseProvider;
        private Provider<InitializeGoogleLoginUseCase> initializeGoogleLoginUseCaseProvider;
        private Provider<AaaAuthenticationForSocialLoginRepository> provideAaaAuthenticatorForSocialLoginProvider;
        private Provider<SocialLoginDomainModule> provideSocialLoginDomainModuleProvider;
        private final SocialLoginCoreLibComponentImpl socialLoginCoreLibComponentImpl;

        public static final class GetFacebookLoginActivityIntegrationProvider implements Provider<FacebookLoginActivityIntegration> {
            private final FacebookLoginCoreLibApi facebookLoginCoreLibApi;

            public GetFacebookLoginActivityIntegrationProvider(FacebookLoginCoreLibApi facebookLoginCoreLibApi2) {
                this.facebookLoginCoreLibApi = facebookLoginCoreLibApi2;
            }

            public FacebookLoginActivityIntegration get() {
                return (FacebookLoginActivityIntegration) Preconditions.checkNotNullFromComponent(this.facebookLoginCoreLibApi.getFacebookLoginActivityIntegration());
            }
        }

        public static final class GetFacebookLoginRepositoryProvider implements Provider<FacebookLoginRepository> {
            private final FacebookLoginCoreLibApi facebookLoginCoreLibApi;

            public GetFacebookLoginRepositoryProvider(FacebookLoginCoreLibApi facebookLoginCoreLibApi2) {
                this.facebookLoginCoreLibApi = facebookLoginCoreLibApi2;
            }

            public FacebookLoginRepository get() {
                return (FacebookLoginRepository) Preconditions.checkNotNullFromComponent(this.facebookLoginCoreLibApi.getFacebookLoginRepository());
            }
        }

        public static final class GetGoogleLoginRepositoryProvider implements Provider<GoogleLoginRepository> {
            private final GoogleLoginCoreLibApi googleLoginCoreLibApi;

            public GetGoogleLoginRepositoryProvider(GoogleLoginCoreLibApi googleLoginCoreLibApi2) {
                this.googleLoginCoreLibApi = googleLoginCoreLibApi2;
            }

            public GoogleLoginRepository get() {
                return (GoogleLoginRepository) Preconditions.checkNotNullFromComponent(this.googleLoginCoreLibApi.getGoogleLoginRepository());
            }
        }

        public static final class GetSocialAuthenticationRepositoryProvider implements Provider<SocialAuthenticationRepository> {
            private final AuthenticationCoreLibApi authenticationCoreLibApi;

            public GetSocialAuthenticationRepositoryProvider(AuthenticationCoreLibApi authenticationCoreLibApi2) {
                this.authenticationCoreLibApi = authenticationCoreLibApi2;
            }

            public SocialAuthenticationRepository get() {
                return (SocialAuthenticationRepository) Preconditions.checkNotNullFromComponent(this.authenticationCoreLibApi.getSocialAuthenticationRepository());
            }
        }

        private SocialLoginCoreLibComponentImpl(SocialLoginCoreLibModule socialLoginCoreLibModule, AuthenticationCoreLibApi authenticationCoreLibApi, GoogleLoginCoreLibApi googleLoginCoreLibApi, FacebookLoginCoreLibApi facebookLoginCoreLibApi) {
            this.socialLoginCoreLibComponentImpl = this;
            initialize(socialLoginCoreLibModule, authenticationCoreLibApi, googleLoginCoreLibApi, facebookLoginCoreLibApi);
        }

        private void initialize(SocialLoginCoreLibModule socialLoginCoreLibModule, AuthenticationCoreLibApi authenticationCoreLibApi, GoogleLoginCoreLibApi googleLoginCoreLibApi, FacebookLoginCoreLibApi facebookLoginCoreLibApi) {
            this.getGoogleLoginRepositoryProvider = new GetGoogleLoginRepositoryProvider(googleLoginCoreLibApi);
            this.getFacebookLoginRepositoryProvider = new GetFacebookLoginRepositoryProvider(facebookLoginCoreLibApi);
            GetSocialAuthenticationRepositoryProvider getSocialAuthenticationRepositoryProvider2 = new GetSocialAuthenticationRepositoryProvider(authenticationCoreLibApi);
            this.getSocialAuthenticationRepositoryProvider = getSocialAuthenticationRepositoryProvider2;
            this.provideAaaAuthenticatorForSocialLoginProvider = SingleCheck.provider(SocialLoginCoreLibModule_ProvideAaaAuthenticatorForSocialLoginFactory.create(socialLoginCoreLibModule, getSocialAuthenticationRepositoryProvider2));
            GetFacebookLoginActivityIntegrationProvider getFacebookLoginActivityIntegrationProvider2 = new GetFacebookLoginActivityIntegrationProvider(facebookLoginCoreLibApi);
            this.getFacebookLoginActivityIntegrationProvider = getFacebookLoginActivityIntegrationProvider2;
            Provider<SocialLoginDomainModule> provider = SingleCheck.provider(SocialLoginCoreLibModule_ProvideSocialLoginDomainModuleFactory.create(socialLoginCoreLibModule, this.getGoogleLoginRepositoryProvider, this.getFacebookLoginRepositoryProvider, this.provideAaaAuthenticatorForSocialLoginProvider, getFacebookLoginActivityIntegrationProvider2));
            this.provideSocialLoginDomainModuleProvider = provider;
            this.facebookLoginUseCaseProvider = SingleCheck.provider(SocialLoginCoreLibModule_FacebookLoginUseCaseFactory.create(socialLoginCoreLibModule, provider));
            this.googleLoginUseCaseProvider = SingleCheck.provider(SocialLoginCoreLibModule_GoogleLoginUseCaseFactory.create(socialLoginCoreLibModule, this.provideSocialLoginDomainModuleProvider));
            this.initializeFacebookLoginUseCaseProvider = SingleCheck.provider(SocialLoginCoreLibModule_InitializeFacebookLoginUseCaseFactory.create(socialLoginCoreLibModule, this.provideSocialLoginDomainModuleProvider));
            this.initializeGoogleLoginUseCaseProvider = SingleCheck.provider(SocialLoginCoreLibModule_InitializeGoogleLoginUseCaseFactory.create(socialLoginCoreLibModule, this.provideSocialLoginDomainModuleProvider));
        }

        public FacebookLoginUseCase getFacebookLoginUseCase() {
            return this.facebookLoginUseCaseProvider.get();
        }

        public GoogleLoginUseCase getGoogleLoginUseCase() {
            return this.googleLoginUseCaseProvider.get();
        }

        public InitializeFacebookLoginUseCase getInitializeFacebookLoginUseCase() {
            return this.initializeFacebookLoginUseCaseProvider.get();
        }

        public InitializeGoogleLoginUseCase getInitializeGoogleLoginUseCase() {
            return this.initializeGoogleLoginUseCaseProvider.get();
        }
    }

    private DaggerSocialLoginCoreLibComponent() {
    }

    public static SocialLoginCoreLibComponent.Factory factory() {
        return new Factory();
    }
}
