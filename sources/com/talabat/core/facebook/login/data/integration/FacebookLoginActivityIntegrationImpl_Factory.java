package com.talabat.core.facebook.login.data.integration;

import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;

@ScopeMetadata
@DaggerGenerated
@QualifierMetadata
public final class FacebookLoginActivityIntegrationImpl_Factory implements Factory<FacebookLoginActivityIntegrationImpl> {

    public static final class InstanceHolder {
        /* access modifiers changed from: private */
        public static final FacebookLoginActivityIntegrationImpl_Factory INSTANCE = new FacebookLoginActivityIntegrationImpl_Factory();

        private InstanceHolder() {
        }
    }

    public static FacebookLoginActivityIntegrationImpl_Factory create() {
        return InstanceHolder.INSTANCE;
    }

    public static FacebookLoginActivityIntegrationImpl newInstance() {
        return new FacebookLoginActivityIntegrationImpl();
    }

    public FacebookLoginActivityIntegrationImpl get() {
        return newInstance();
    }
}
