package com.talabat.feature.subscriptions.data;

import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;

@ScopeMetadata
@DaggerGenerated
@QualifierMetadata
public final class SubscriptionsCustomerRepositoryImpl_Factory implements Factory<SubscriptionsCustomerRepositoryImpl> {

    public static final class InstanceHolder {
        /* access modifiers changed from: private */
        public static final SubscriptionsCustomerRepositoryImpl_Factory INSTANCE = new SubscriptionsCustomerRepositoryImpl_Factory();

        private InstanceHolder() {
        }
    }

    public static SubscriptionsCustomerRepositoryImpl_Factory create() {
        return InstanceHolder.INSTANCE;
    }

    public static SubscriptionsCustomerRepositoryImpl newInstance() {
        return new SubscriptionsCustomerRepositoryImpl();
    }

    public SubscriptionsCustomerRepositoryImpl get() {
        return newInstance();
    }
}
