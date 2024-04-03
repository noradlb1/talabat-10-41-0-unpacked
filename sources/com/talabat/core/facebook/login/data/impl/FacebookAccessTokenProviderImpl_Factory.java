package com.talabat.core.facebook.login.data.impl;

import com.facebook.AccessTokenManager;
import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import javax.inject.Provider;

@ScopeMetadata
@DaggerGenerated
@QualifierMetadata
public final class FacebookAccessTokenProviderImpl_Factory implements Factory<FacebookAccessTokenProviderImpl> {
    private final Provider<AccessTokenManager> accessTokenManagerProvider;

    public FacebookAccessTokenProviderImpl_Factory(Provider<AccessTokenManager> provider) {
        this.accessTokenManagerProvider = provider;
    }

    public static FacebookAccessTokenProviderImpl_Factory create(Provider<AccessTokenManager> provider) {
        return new FacebookAccessTokenProviderImpl_Factory(provider);
    }

    public static FacebookAccessTokenProviderImpl newInstance(AccessTokenManager accessTokenManager) {
        return new FacebookAccessTokenProviderImpl(accessTokenManager);
    }

    public FacebookAccessTokenProviderImpl get() {
        return newInstance(this.accessTokenManagerProvider.get());
    }
}
