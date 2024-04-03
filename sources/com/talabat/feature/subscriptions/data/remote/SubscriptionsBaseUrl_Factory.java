package com.talabat.feature.subscriptions.data.remote;

import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;

@ScopeMetadata
@DaggerGenerated
@QualifierMetadata
public final class SubscriptionsBaseUrl_Factory implements Factory<SubscriptionsBaseUrl> {

    public static final class InstanceHolder {
        /* access modifiers changed from: private */
        public static final SubscriptionsBaseUrl_Factory INSTANCE = new SubscriptionsBaseUrl_Factory();

        private InstanceHolder() {
        }
    }

    public static SubscriptionsBaseUrl_Factory create() {
        return InstanceHolder.INSTANCE;
    }

    public static SubscriptionsBaseUrl newInstance() {
        return new SubscriptionsBaseUrl();
    }

    public SubscriptionsBaseUrl get() {
        return newInstance();
    }
}
