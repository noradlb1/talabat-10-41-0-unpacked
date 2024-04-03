package com.talabat.feature.subscriptions.fake;

import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;

@ScopeMetadata
@DaggerGenerated
@QualifierMetadata
public final class FakeSubscriptionsCustomerRepository_Factory implements Factory<FakeSubscriptionsCustomerRepository> {

    public static final class InstanceHolder {
        /* access modifiers changed from: private */
        public static final FakeSubscriptionsCustomerRepository_Factory INSTANCE = new FakeSubscriptionsCustomerRepository_Factory();

        private InstanceHolder() {
        }
    }

    public static FakeSubscriptionsCustomerRepository_Factory create() {
        return InstanceHolder.INSTANCE;
    }

    public static FakeSubscriptionsCustomerRepository newInstance() {
        return new FakeSubscriptionsCustomerRepository();
    }

    public FakeSubscriptionsCustomerRepository get() {
        return newInstance();
    }
}
