package com.talabat.feature.subscriptions.data.model;

import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;

@ScopeMetadata
@DaggerGenerated
@QualifierMetadata
public final class SubscriptionUpgradePlanModelMapper_Factory implements Factory<SubscriptionUpgradePlanModelMapper> {

    public static final class InstanceHolder {
        /* access modifiers changed from: private */
        public static final SubscriptionUpgradePlanModelMapper_Factory INSTANCE = new SubscriptionUpgradePlanModelMapper_Factory();

        private InstanceHolder() {
        }
    }

    public static SubscriptionUpgradePlanModelMapper_Factory create() {
        return InstanceHolder.INSTANCE;
    }

    public static SubscriptionUpgradePlanModelMapper newInstance() {
        return new SubscriptionUpgradePlanModelMapper();
    }

    public SubscriptionUpgradePlanModelMapper get() {
        return newInstance();
    }
}
