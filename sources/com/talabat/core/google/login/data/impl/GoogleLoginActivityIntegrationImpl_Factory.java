package com.talabat.core.google.login.data.impl;

import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;

@ScopeMetadata
@DaggerGenerated
@QualifierMetadata
public final class GoogleLoginActivityIntegrationImpl_Factory implements Factory<GoogleLoginActivityIntegrationImpl> {

    public static final class InstanceHolder {
        /* access modifiers changed from: private */
        public static final GoogleLoginActivityIntegrationImpl_Factory INSTANCE = new GoogleLoginActivityIntegrationImpl_Factory();

        private InstanceHolder() {
        }
    }

    public static GoogleLoginActivityIntegrationImpl_Factory create() {
        return InstanceHolder.INSTANCE;
    }

    public static GoogleLoginActivityIntegrationImpl newInstance() {
        return new GoogleLoginActivityIntegrationImpl();
    }

    public GoogleLoginActivityIntegrationImpl get() {
        return newInstance();
    }
}
