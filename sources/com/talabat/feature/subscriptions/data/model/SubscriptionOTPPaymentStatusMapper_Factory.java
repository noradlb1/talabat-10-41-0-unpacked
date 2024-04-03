package com.talabat.feature.subscriptions.data.model;

import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;

@ScopeMetadata
@DaggerGenerated
@QualifierMetadata
public final class SubscriptionOTPPaymentStatusMapper_Factory implements Factory<SubscriptionOTPPaymentStatusMapper> {

    public static final class InstanceHolder {
        /* access modifiers changed from: private */
        public static final SubscriptionOTPPaymentStatusMapper_Factory INSTANCE = new SubscriptionOTPPaymentStatusMapper_Factory();

        private InstanceHolder() {
        }
    }

    public static SubscriptionOTPPaymentStatusMapper_Factory create() {
        return InstanceHolder.INSTANCE;
    }

    public static SubscriptionOTPPaymentStatusMapper newInstance() {
        return new SubscriptionOTPPaymentStatusMapper();
    }

    public SubscriptionOTPPaymentStatusMapper get() {
        return newInstance();
    }
}
