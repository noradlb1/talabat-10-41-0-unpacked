package com.talabat.darkstores.data.tracking.impression;

import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;

@ScopeMetadata
@DaggerGenerated
@QualifierMetadata
public final class BannerImpressionMapper_Factory implements Factory<BannerImpressionMapper> {

    public static final class InstanceHolder {
        /* access modifiers changed from: private */
        public static final BannerImpressionMapper_Factory INSTANCE = new BannerImpressionMapper_Factory();

        private InstanceHolder() {
        }
    }

    public static BannerImpressionMapper_Factory create() {
        return InstanceHolder.INSTANCE;
    }

    public static BannerImpressionMapper newInstance() {
        return new BannerImpressionMapper();
    }

    public BannerImpressionMapper get() {
        return newInstance();
    }
}
