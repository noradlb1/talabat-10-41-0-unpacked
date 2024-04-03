package com.talabat.feature.subscriptions.fake;

import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;

@ScopeMetadata
@DaggerGenerated
@QualifierMetadata
public final class FakeSubscriptionsStatusRepository_Factory implements Factory<FakeSubscriptionsStatusRepository> {

    public static final class InstanceHolder {
        /* access modifiers changed from: private */
        public static final FakeSubscriptionsStatusRepository_Factory INSTANCE = new FakeSubscriptionsStatusRepository_Factory();

        private InstanceHolder() {
        }
    }

    public static FakeSubscriptionsStatusRepository_Factory create() {
        return InstanceHolder.INSTANCE;
    }

    public static FakeSubscriptionsStatusRepository newInstance() {
        return new FakeSubscriptionsStatusRepository();
    }

    public FakeSubscriptionsStatusRepository get() {
        return newInstance();
    }
}
