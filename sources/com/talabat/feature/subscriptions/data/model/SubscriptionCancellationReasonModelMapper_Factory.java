package com.talabat.feature.subscriptions.data.model;

import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;

@ScopeMetadata
@DaggerGenerated
@QualifierMetadata
public final class SubscriptionCancellationReasonModelMapper_Factory implements Factory<SubscriptionCancellationReasonModelMapper> {

    public static final class InstanceHolder {
        /* access modifiers changed from: private */
        public static final SubscriptionCancellationReasonModelMapper_Factory INSTANCE = new SubscriptionCancellationReasonModelMapper_Factory();

        private InstanceHolder() {
        }
    }

    public static SubscriptionCancellationReasonModelMapper_Factory create() {
        return InstanceHolder.INSTANCE;
    }

    public static SubscriptionCancellationReasonModelMapper newInstance() {
        return new SubscriptionCancellationReasonModelMapper();
    }

    public SubscriptionCancellationReasonModelMapper get() {
        return newInstance();
    }
}
