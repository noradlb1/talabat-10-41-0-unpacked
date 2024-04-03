package com.talabat.feature.darkstoresvendor.data.local;

import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;

@ScopeMetadata
@DaggerGenerated
@QualifierMetadata
public final class VendorCache_Factory implements Factory<VendorCache> {

    public static final class InstanceHolder {
        /* access modifiers changed from: private */
        public static final VendorCache_Factory INSTANCE = new VendorCache_Factory();

        private InstanceHolder() {
        }
    }

    public static VendorCache_Factory create() {
        return InstanceHolder.INSTANCE;
    }

    public static VendorCache newInstance() {
        return new VendorCache();
    }

    public VendorCache get() {
        return newInstance();
    }
}
