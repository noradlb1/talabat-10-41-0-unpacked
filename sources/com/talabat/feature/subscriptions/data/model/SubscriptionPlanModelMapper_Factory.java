package com.talabat.feature.subscriptions.data.model;

import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;

@ScopeMetadata
@DaggerGenerated
@QualifierMetadata
public final class SubscriptionPlanModelMapper_Factory implements Factory<SubscriptionPlanModelMapper> {

    public static final class InstanceHolder {
        /* access modifiers changed from: private */
        public static final SubscriptionPlanModelMapper_Factory INSTANCE = new SubscriptionPlanModelMapper_Factory();

        private InstanceHolder() {
        }
    }

    public static SubscriptionPlanModelMapper_Factory create() {
        return InstanceHolder.INSTANCE;
    }

    public static SubscriptionPlanModelMapper newInstance() {
        return new SubscriptionPlanModelMapper();
    }

    public SubscriptionPlanModelMapper get() {
        return newInstance();
    }
}
