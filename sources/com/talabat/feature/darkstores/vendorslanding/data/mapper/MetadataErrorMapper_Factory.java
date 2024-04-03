package com.talabat.feature.darkstores.vendorslanding.data.mapper;

import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;

@ScopeMetadata
@DaggerGenerated
@QualifierMetadata
public final class MetadataErrorMapper_Factory implements Factory<MetadataErrorMapper> {

    public static final class InstanceHolder {
        /* access modifiers changed from: private */
        public static final MetadataErrorMapper_Factory INSTANCE = new MetadataErrorMapper_Factory();

        private InstanceHolder() {
        }
    }

    public static MetadataErrorMapper_Factory create() {
        return InstanceHolder.INSTANCE;
    }

    public static MetadataErrorMapper newInstance() {
        return new MetadataErrorMapper();
    }

    public MetadataErrorMapper get() {
        return newInstance();
    }
}
