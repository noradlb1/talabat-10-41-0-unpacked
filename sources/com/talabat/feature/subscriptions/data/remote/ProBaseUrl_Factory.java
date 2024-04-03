package com.talabat.feature.subscriptions.data.remote;

import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;

@ScopeMetadata
@DaggerGenerated
@QualifierMetadata
public final class ProBaseUrl_Factory implements Factory<ProBaseUrl> {

    public static final class InstanceHolder {
        /* access modifiers changed from: private */
        public static final ProBaseUrl_Factory INSTANCE = new ProBaseUrl_Factory();

        private InstanceHolder() {
        }
    }

    public static ProBaseUrl_Factory create() {
        return InstanceHolder.INSTANCE;
    }

    public static ProBaseUrl newInstance() {
        return new ProBaseUrl();
    }

    public ProBaseUrl get() {
        return newInstance();
    }
}
