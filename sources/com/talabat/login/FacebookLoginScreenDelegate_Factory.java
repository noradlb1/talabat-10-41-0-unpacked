package com.talabat.login;

import com.talabat.core.dispatcher.domain.CoroutineDispatchersFactory;
import com.talabat.core.social.login.domain.FacebookLoginUseCase;
import com.talabat.core.social.login.domain.InitializeFacebookLoginUseCase;
import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import javax.inject.Provider;

@ScopeMetadata
@DaggerGenerated
@QualifierMetadata
public final class FacebookLoginScreenDelegate_Factory implements Factory<FacebookLoginScreenDelegate> {
    private final Provider<CoroutineDispatchersFactory> coroutineDispatchersFactoryProvider;
    private final Provider<FacebookLoginErrorHandler> facebookLoginErrorHandlerProvider;
    private final Provider<FacebookLoginUseCase> facebookLoginUseCaseProvider;
    private final Provider<FacebookSuccessfulLoginHandler> facebookSuccessfulLoginHandlerProvider;
    private final Provider<InitializeFacebookLoginUseCase> initializeFacebookLoginUseCaseProvider;

    public FacebookLoginScreenDelegate_Factory(Provider<InitializeFacebookLoginUseCase> provider, Provider<FacebookLoginUseCase> provider2, Provider<CoroutineDispatchersFactory> provider3, Provider<FacebookSuccessfulLoginHandler> provider4, Provider<FacebookLoginErrorHandler> provider5) {
        this.initializeFacebookLoginUseCaseProvider = provider;
        this.facebookLoginUseCaseProvider = provider2;
        this.coroutineDispatchersFactoryProvider = provider3;
        this.facebookSuccessfulLoginHandlerProvider = provider4;
        this.facebookLoginErrorHandlerProvider = provider5;
    }

    public static FacebookLoginScreenDelegate_Factory create(Provider<InitializeFacebookLoginUseCase> provider, Provider<FacebookLoginUseCase> provider2, Provider<CoroutineDispatchersFactory> provider3, Provider<FacebookSuccessfulLoginHandler> provider4, Provider<FacebookLoginErrorHandler> provider5) {
        return new FacebookLoginScreenDelegate_Factory(provider, provider2, provider3, provider4, provider5);
    }

    public static FacebookLoginScreenDelegate newInstance(InitializeFacebookLoginUseCase initializeFacebookLoginUseCase, FacebookLoginUseCase facebookLoginUseCase, CoroutineDispatchersFactory coroutineDispatchersFactory, FacebookSuccessfulLoginHandler facebookSuccessfulLoginHandler, FacebookLoginErrorHandler facebookLoginErrorHandler) {
        return new FacebookLoginScreenDelegate(initializeFacebookLoginUseCase, facebookLoginUseCase, coroutineDispatchersFactory, facebookSuccessfulLoginHandler, facebookLoginErrorHandler);
    }

    public FacebookLoginScreenDelegate get() {
        return newInstance(this.initializeFacebookLoginUseCaseProvider.get(), this.facebookLoginUseCaseProvider.get(), this.coroutineDispatchersFactoryProvider.get(), this.facebookSuccessfulLoginHandlerProvider.get(), this.facebookLoginErrorHandlerProvider.get());
    }
}
