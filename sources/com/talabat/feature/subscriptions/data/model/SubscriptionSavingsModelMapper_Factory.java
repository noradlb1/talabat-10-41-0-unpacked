package com.talabat.feature.subscriptions.data.model;

import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;

@ScopeMetadata
@DaggerGenerated
@QualifierMetadata
public final class SubscriptionSavingsModelMapper_Factory implements Factory<SubscriptionSavingsModelMapper> {

    public static final class InstanceHolder {
        /* access modifiers changed from: private */
        public static final SubscriptionSavingsModelMapper_Factory INSTANCE = new SubscriptionSavingsModelMapper_Factory();

        private InstanceHolder() {
        }
    }

    public static SubscriptionSavingsModelMapper_Factory create() {
        return InstanceHolder.INSTANCE;
    }

    public static SubscriptionSavingsModelMapper newInstance() {
        return new SubscriptionSavingsModelMapper();
    }

    public SubscriptionSavingsModelMapper get() {
        return newInstance();
    }
}
