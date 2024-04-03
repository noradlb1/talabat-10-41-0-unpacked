package com.talabat.feature.darkstores.vendorslanding.data.mapper;

import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;

@ScopeMetadata
@DaggerGenerated
@QualifierMetadata
public final class VendorInfoResponseMapper_Factory implements Factory<VendorInfoResponseMapper> {

    public static final class InstanceHolder {
        /* access modifiers changed from: private */
        public static final VendorInfoResponseMapper_Factory INSTANCE = new VendorInfoResponseMapper_Factory();

        private InstanceHolder() {
        }
    }

    public static VendorInfoResponseMapper_Factory create() {
        return InstanceHolder.INSTANCE;
    }

    public static VendorInfoResponseMapper newInstance() {
        return new VendorInfoResponseMapper();
    }

    public VendorInfoResponseMapper get() {
        return newInstance();
    }
}
