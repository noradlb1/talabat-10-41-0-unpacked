package com.talabat.core.safety.data.repository.shield.remote;

import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;

@ScopeMetadata
@DaggerGenerated
@QualifierMetadata
public final class ShieldBaseUrl_Factory implements Factory<ShieldBaseUrl> {

    public static final class InstanceHolder {
        /* access modifiers changed from: private */
        public static final ShieldBaseUrl_Factory INSTANCE = new ShieldBaseUrl_Factory();

        private InstanceHolder() {
        }
    }

    public static ShieldBaseUrl_Factory create() {
        return InstanceHolder.INSTANCE;
    }

    public static ShieldBaseUrl newInstance() {
        return new ShieldBaseUrl();
    }

    public ShieldBaseUrl get() {
        return newInstance();
    }
}
