package com.talabat.feature.subscriptions.data.model;

import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;

@ScopeMetadata
@DaggerGenerated
@QualifierMetadata
public final class HeroBannerModelMapper_Factory implements Factory<HeroBannerModelMapper> {

    public static final class InstanceHolder {
        /* access modifiers changed from: private */
        public static final HeroBannerModelMapper_Factory INSTANCE = new HeroBannerModelMapper_Factory();

        private InstanceHolder() {
        }
    }

    public static HeroBannerModelMapper_Factory create() {
        return InstanceHolder.INSTANCE;
    }

    public static HeroBannerModelMapper newInstance() {
        return new HeroBannerModelMapper();
    }

    public HeroBannerModelMapper get() {
        return newInstance();
    }
}
