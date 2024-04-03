package com.talabat.feature.subscriptions.fake;

import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;

@ScopeMetadata
@DaggerGenerated
@QualifierMetadata
public final class FakeSubscriptionsTracker_Factory implements Factory<FakeSubscriptionsTracker> {

    public static final class InstanceHolder {
        /* access modifiers changed from: private */
        public static final FakeSubscriptionsTracker_Factory INSTANCE = new FakeSubscriptionsTracker_Factory();

        private InstanceHolder() {
        }
    }

    public static FakeSubscriptionsTracker_Factory create() {
        return InstanceHolder.INSTANCE;
    }

    public static FakeSubscriptionsTracker newInstance() {
        return new FakeSubscriptionsTracker();
    }

    public FakeSubscriptionsTracker get() {
        return newInstance();
    }
}
