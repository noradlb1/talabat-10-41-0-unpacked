package com.talabat.feature.darkstoresvendor.data.mapper;

import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;

@ScopeMetadata
@DaggerGenerated
@QualifierMetadata
public final class VendorResponseMapper_Factory implements Factory<VendorResponseMapper> {

    public static final class InstanceHolder {
        /* access modifiers changed from: private */
        public static final VendorResponseMapper_Factory INSTANCE = new VendorResponseMapper_Factory();

        private InstanceHolder() {
        }
    }

    public static VendorResponseMapper_Factory create() {
        return InstanceHolder.INSTANCE;
    }

    public static VendorResponseMapper newInstance() {
        return new VendorResponseMapper();
    }

    public VendorResponseMapper get() {
        return newInstance();
    }
}
