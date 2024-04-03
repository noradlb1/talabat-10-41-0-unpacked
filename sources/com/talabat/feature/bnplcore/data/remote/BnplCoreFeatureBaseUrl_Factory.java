package com.talabat.feature.bnplcore.data.remote;

import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;

@ScopeMetadata
@DaggerGenerated
@QualifierMetadata
public final class BnplCoreFeatureBaseUrl_Factory implements Factory<BnplCoreFeatureBaseUrl> {

    public static final class InstanceHolder {
        /* access modifiers changed from: private */
        public static final BnplCoreFeatureBaseUrl_Factory INSTANCE = new BnplCoreFeatureBaseUrl_Factory();

        private InstanceHolder() {
        }
    }

    public static BnplCoreFeatureBaseUrl_Factory create() {
        return InstanceHolder.INSTANCE;
    }

    public static BnplCoreFeatureBaseUrl newInstance() {
        return new BnplCoreFeatureBaseUrl();
    }

    public BnplCoreFeatureBaseUrl get() {
        return newInstance();
    }
}
