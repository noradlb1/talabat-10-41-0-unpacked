package com.talabat.feature.subscriptions.data.model;

import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;

@ScopeMetadata
@DaggerGenerated
@QualifierMetadata
public final class SubscriptionPaymentStatusModelMapper_Factory implements Factory<SubscriptionPaymentStatusModelMapper> {

    public static final class InstanceHolder {
        /* access modifiers changed from: private */
        public static final SubscriptionPaymentStatusModelMapper_Factory INSTANCE = new SubscriptionPaymentStatusModelMapper_Factory();

        private InstanceHolder() {
        }
    }

    public static SubscriptionPaymentStatusModelMapper_Factory create() {
        return InstanceHolder.INSTANCE;
    }

    public static SubscriptionPaymentStatusModelMapper newInstance() {
        return new SubscriptionPaymentStatusModelMapper();
    }

    public SubscriptionPaymentStatusModelMapper get() {
        return newInstance();
    }
}
