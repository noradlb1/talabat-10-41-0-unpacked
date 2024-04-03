package com.talabat.feature.rewards.data;

import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;

@ScopeMetadata
@DaggerGenerated
@QualifierMetadata
public final class RewardsBaseUrl_Factory implements Factory<RewardsBaseUrl> {

    public static final class InstanceHolder {
        /* access modifiers changed from: private */
        public static final RewardsBaseUrl_Factory INSTANCE = new RewardsBaseUrl_Factory();

        private InstanceHolder() {
        }
    }

    public static RewardsBaseUrl_Factory create() {
        return InstanceHolder.INSTANCE;
    }

    public static RewardsBaseUrl newInstance() {
        return new RewardsBaseUrl();
    }

    public RewardsBaseUrl get() {
        return newInstance();
    }
}
