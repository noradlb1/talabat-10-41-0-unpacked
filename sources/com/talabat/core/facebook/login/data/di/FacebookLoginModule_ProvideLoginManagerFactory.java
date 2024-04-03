package com.talabat.core.facebook.login.data.di;

import com.facebook.login.LoginManager;
import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;

@ScopeMetadata
@DaggerGenerated
@QualifierMetadata
public final class FacebookLoginModule_ProvideLoginManagerFactory implements Factory<LoginManager> {

    public static final class InstanceHolder {
        /* access modifiers changed from: private */
        public static final FacebookLoginModule_ProvideLoginManagerFactory INSTANCE = new FacebookLoginModule_ProvideLoginManagerFactory();

        private InstanceHolder() {
        }
    }

    public static FacebookLoginModule_ProvideLoginManagerFactory create() {
        return InstanceHolder.INSTANCE;
    }

    public static LoginManager provideLoginManager() {
        return (LoginManager) Preconditions.checkNotNullFromProvides(FacebookLoginModule.INSTANCE.provideLoginManager());
    }

    public LoginManager get() {
        return provideLoginManager();
    }
}
