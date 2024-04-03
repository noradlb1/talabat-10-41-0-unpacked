package com.talabat.core.facebook.login.data.di;

import com.facebook.AccessTokenManager;
import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;

@ScopeMetadata
@DaggerGenerated
@QualifierMetadata
public final class FacebookLoginModule_ProvideAccessTokenManagerFactory implements Factory<AccessTokenManager> {

    public static final class InstanceHolder {
        /* access modifiers changed from: private */
        public static final FacebookLoginModule_ProvideAccessTokenManagerFactory INSTANCE = new FacebookLoginModule_ProvideAccessTokenManagerFactory();

        private InstanceHolder() {
        }
    }

    public static FacebookLoginModule_ProvideAccessTokenManagerFactory create() {
        return InstanceHolder.INSTANCE;
    }

    public static AccessTokenManager provideAccessTokenManager() {
        return (AccessTokenManager) Preconditions.checkNotNullFromProvides(FacebookLoginModule.INSTANCE.provideAccessTokenManager());
    }

    public AccessTokenManager get() {
        return provideAccessTokenManager();
    }
}
