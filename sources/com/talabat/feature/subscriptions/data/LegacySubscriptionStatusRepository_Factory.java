package com.talabat.feature.subscriptions.data;

import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;

@ScopeMetadata
@DaggerGenerated
@QualifierMetadata
public final class LegacySubscriptionStatusRepository_Factory implements Factory<LegacySubscriptionStatusRepository> {

    public static final class InstanceHolder {
        /* access modifiers changed from: private */
        public static final LegacySubscriptionStatusRepository_Factory INSTANCE = new LegacySubscriptionStatusRepository_Factory();

        private InstanceHolder() {
        }
    }

    public static LegacySubscriptionStatusRepository_Factory create() {
        return InstanceHolder.INSTANCE;
    }

    public static LegacySubscriptionStatusRepository newInstance() {
        return new LegacySubscriptionStatusRepository();
    }

    public LegacySubscriptionStatusRepository get() {
        return newInstance();
    }
}
