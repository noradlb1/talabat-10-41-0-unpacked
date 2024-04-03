package com.talabat.feature.darkstores.vendorslanding.data.mapper;

import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;

@ScopeMetadata
@DaggerGenerated
@QualifierMetadata
public final class PageInfoMapper_Factory implements Factory<PageInfoMapper> {

    public static final class InstanceHolder {
        /* access modifiers changed from: private */
        public static final PageInfoMapper_Factory INSTANCE = new PageInfoMapper_Factory();

        private InstanceHolder() {
        }
    }

    public static PageInfoMapper_Factory create() {
        return InstanceHolder.INSTANCE;
    }

    public static PageInfoMapper newInstance() {
        return new PageInfoMapper();
    }

    public PageInfoMapper get() {
        return newInstance();
    }
}
