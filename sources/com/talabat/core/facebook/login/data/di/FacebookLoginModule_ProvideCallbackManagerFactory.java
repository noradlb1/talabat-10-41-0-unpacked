package com.talabat.core.facebook.login.data.di;

import com.facebook.CallbackManager;
import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;

@ScopeMetadata("dagger.Reusable")
@DaggerGenerated
@QualifierMetadata
public final class FacebookLoginModule_ProvideCallbackManagerFactory implements Factory<CallbackManager> {

    public static final class InstanceHolder {
        /* access modifiers changed from: private */
        public static final FacebookLoginModule_ProvideCallbackManagerFactory INSTANCE = new FacebookLoginModule_ProvideCallbackManagerFactory();

        private InstanceHolder() {
        }
    }

    public static FacebookLoginModule_ProvideCallbackManagerFactory create() {
        return InstanceHolder.INSTANCE;
    }

    public static CallbackManager provideCallbackManager() {
        return (CallbackManager) Preconditions.checkNotNullFromProvides(FacebookLoginModule.INSTANCE.provideCallbackManager());
    }

    public CallbackManager get() {
        return provideCallbackManager();
    }
}
