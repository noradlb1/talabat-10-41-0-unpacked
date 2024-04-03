package com.talabat.di.auth;

import com.talabat.authentication.token.domain.TokenCoreLibApi;
import com.talabat.authentication.token.domain.repository.TokenRepository;
import com.talabat.core.dispatcher.domain.CoroutineDispatchersFactory;
import com.talabat.core.dispatcher.domain.DispatcherCoreLibApi;
import com.talabat.core.social.login.domain.FacebookLoginUseCase;
import com.talabat.core.social.login.domain.InitializeFacebookLoginUseCase;
import com.talabat.core.social.login.domain.SocialLoginCoreLibApi;
import com.talabat.di.auth.SocialLoginScreenComponent;
import com.talabat.login.FacebookLoginErrorHandler;
import com.talabat.login.FacebookLoginScreenDelegate;
import com.talabat.login.FacebookSuccessfulLoginHandler;
import dagger.internal.DaggerGenerated;
import dagger.internal.Preconditions;

@DaggerGenerated
public final class DaggerSocialLoginScreenComponent {

    public static final class Factory implements SocialLoginScreenComponent.Factory {
        private Factory() {
        }

        public SocialLoginScreenComponent create(DispatcherCoreLibApi dispatcherCoreLibApi, SocialLoginCoreLibApi socialLoginCoreLibApi, TokenCoreLibApi tokenCoreLibApi) {
            Preconditions.checkNotNull(dispatcherCoreLibApi);
            Preconditions.checkNotNull(socialLoginCoreLibApi);
            Preconditions.checkNotNull(tokenCoreLibApi);
            return new SocialLoginScreenComponentImpl(dispatcherCoreLibApi, socialLoginCoreLibApi, tokenCoreLibApi);
        }
    }

    public static final class SocialLoginScreenComponentImpl implements SocialLoginScreenComponent {
        private final DispatcherCoreLibApi dispatcherCoreLibApi;
        private final SocialLoginCoreLibApi socialLoginCoreLibApi;
        private final SocialLoginScreenComponentImpl socialLoginScreenComponentImpl;
        private final TokenCoreLibApi tokenCoreLibApi;

        private SocialLoginScreenComponentImpl(DispatcherCoreLibApi dispatcherCoreLibApi2, SocialLoginCoreLibApi socialLoginCoreLibApi2, TokenCoreLibApi tokenCoreLibApi2) {
            this.socialLoginScreenComponentImpl = this;
            this.socialLoginCoreLibApi = socialLoginCoreLibApi2;
            this.dispatcherCoreLibApi = dispatcherCoreLibApi2;
            this.tokenCoreLibApi = tokenCoreLibApi2;
        }

        private FacebookSuccessfulLoginHandler facebookSuccessfulLoginHandler() {
            return new FacebookSuccessfulLoginHandler((TokenRepository) Preconditions.checkNotNullFromComponent(this.tokenCoreLibApi.getTokenRepository()));
        }

        public FacebookLoginScreenDelegate getFacebookLoginScreenDelegate() {
            return new FacebookLoginScreenDelegate((InitializeFacebookLoginUseCase) Preconditions.checkNotNullFromComponent(this.socialLoginCoreLibApi.getInitializeFacebookLoginUseCase()), (FacebookLoginUseCase) Preconditions.checkNotNullFromComponent(this.socialLoginCoreLibApi.getFacebookLoginUseCase()), (CoroutineDispatchersFactory) Preconditions.checkNotNullFromComponent(this.dispatcherCoreLibApi.getCoroutineDispatchersFactory()), facebookSuccessfulLoginHandler(), new FacebookLoginErrorHandler());
        }
    }

    private DaggerSocialLoginScreenComponent() {
    }

    public static SocialLoginScreenComponent.Factory factory() {
        return new Factory();
    }
}
