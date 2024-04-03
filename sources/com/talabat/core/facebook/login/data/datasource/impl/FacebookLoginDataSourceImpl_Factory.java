package com.talabat.core.facebook.login.data.datasource.impl;

import android.content.Context;
import com.facebook.CallbackManager;
import com.facebook.login.LoginManager;
import com.talabat.core.facebook.login.data.FacebookAccessTokenProvider;
import com.talabat.core.facebook.login.data.datasource.GraphRequestFactory;
import com.talabat.core.facebook.login.domain.integration.FacebookLoginActivityIntegration;
import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import javax.inject.Provider;

@ScopeMetadata
@DaggerGenerated
@QualifierMetadata
public final class FacebookLoginDataSourceImpl_Factory implements Factory<FacebookLoginDataSourceImpl> {
    private final Provider<FacebookAccessTokenProvider> accessTokenProvider;
    private final Provider<CallbackManager> callbackManagerProvider;
    private final Provider<Context> contextProvider;
    private final Provider<FacebookLoginActivityIntegration> facebookLoginActivityIntegrationProvider;
    private final Provider<GraphRequestFactory> graphRequestFactoryProvider;
    private final Provider<LoginManager> loginManagerProvider;

    public FacebookLoginDataSourceImpl_Factory(Provider<Context> provider, Provider<CallbackManager> provider2, Provider<LoginManager> provider3, Provider<FacebookAccessTokenProvider> provider4, Provider<GraphRequestFactory> provider5, Provider<FacebookLoginActivityIntegration> provider6) {
        this.contextProvider = provider;
        this.callbackManagerProvider = provider2;
        this.loginManagerProvider = provider3;
        this.accessTokenProvider = provider4;
        this.graphRequestFactoryProvider = provider5;
        this.facebookLoginActivityIntegrationProvider = provider6;
    }

    public static FacebookLoginDataSourceImpl_Factory create(Provider<Context> provider, Provider<CallbackManager> provider2, Provider<LoginManager> provider3, Provider<FacebookAccessTokenProvider> provider4, Provider<GraphRequestFactory> provider5, Provider<FacebookLoginActivityIntegration> provider6) {
        return new FacebookLoginDataSourceImpl_Factory(provider, provider2, provider3, provider4, provider5, provider6);
    }

    public static FacebookLoginDataSourceImpl newInstance(Context context, CallbackManager callbackManager, LoginManager loginManager, FacebookAccessTokenProvider facebookAccessTokenProvider, GraphRequestFactory graphRequestFactory, FacebookLoginActivityIntegration facebookLoginActivityIntegration) {
        return new FacebookLoginDataSourceImpl(context, callbackManager, loginManager, facebookAccessTokenProvider, graphRequestFactory, facebookLoginActivityIntegration);
    }

    public FacebookLoginDataSourceImpl get() {
        return newInstance(this.contextProvider.get(), this.callbackManagerProvider.get(), this.loginManagerProvider.get(), this.accessTokenProvider.get(), this.graphRequestFactoryProvider.get(), this.facebookLoginActivityIntegrationProvider.get());
    }
}
