package com.talabat.darkstores.data.discovery.mappers;

import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;

@ScopeMetadata
@DaggerGenerated
@QualifierMetadata
public final class BannerDomainToViewModelMapper_Factory implements Factory<BannerDomainToViewModelMapper> {

    public static final class InstanceHolder {
        /* access modifiers changed from: private */
        public static final BannerDomainToViewModelMapper_Factory INSTANCE = new BannerDomainToViewModelMapper_Factory();

        private InstanceHolder() {
        }
    }

    public static BannerDomainToViewModelMapper_Factory create() {
        return InstanceHolder.INSTANCE;
    }

    public static BannerDomainToViewModelMapper newInstance() {
        return new BannerDomainToViewModelMapper();
    }

    public BannerDomainToViewModelMapper get() {
        return newInstance();
    }
}
