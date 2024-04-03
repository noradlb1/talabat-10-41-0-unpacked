package com.talabat.feature.incentiveautoapplydiscounts.data.datasource.remote;

import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;

@ScopeMetadata
@DaggerGenerated
@QualifierMetadata
public final class LoyaltyBaseUrl_Factory implements Factory<LoyaltyBaseUrl> {

    public static final class InstanceHolder {
        /* access modifiers changed from: private */
        public static final LoyaltyBaseUrl_Factory INSTANCE = new LoyaltyBaseUrl_Factory();

        private InstanceHolder() {
        }
    }

    public static LoyaltyBaseUrl_Factory create() {
        return InstanceHolder.INSTANCE;
    }

    public static LoyaltyBaseUrl newInstance() {
        return new LoyaltyBaseUrl();
    }

    public LoyaltyBaseUrl get() {
        return newInstance();
    }
}
