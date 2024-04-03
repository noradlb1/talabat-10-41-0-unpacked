package com.talabat.feature.darkstores.vendorslanding.data.mapper;

import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;

@ScopeMetadata
@DaggerGenerated
@QualifierMetadata
public final class BannerResponseMapper_Factory implements Factory<BannerResponseMapper> {

    public static final class InstanceHolder {
        /* access modifiers changed from: private */
        public static final BannerResponseMapper_Factory INSTANCE = new BannerResponseMapper_Factory();

        private InstanceHolder() {
        }
    }

    public static BannerResponseMapper_Factory create() {
        return InstanceHolder.INSTANCE;
    }

    public static BannerResponseMapper newInstance() {
        return new BannerResponseMapper();
    }

    public BannerResponseMapper get() {
        return newInstance();
    }
}
