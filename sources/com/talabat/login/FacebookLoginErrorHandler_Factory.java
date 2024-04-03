package com.talabat.login;

import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;

@ScopeMetadata
@DaggerGenerated
@QualifierMetadata
public final class FacebookLoginErrorHandler_Factory implements Factory<FacebookLoginErrorHandler> {

    public static final class InstanceHolder {
        /* access modifiers changed from: private */
        public static final FacebookLoginErrorHandler_Factory INSTANCE = new FacebookLoginErrorHandler_Factory();

        private InstanceHolder() {
        }
    }

    public static FacebookLoginErrorHandler_Factory create() {
        return InstanceHolder.INSTANCE;
    }

    public static FacebookLoginErrorHandler newInstance() {
        return new FacebookLoginErrorHandler();
    }

    public FacebookLoginErrorHandler get() {
        return newInstance();
    }
}
