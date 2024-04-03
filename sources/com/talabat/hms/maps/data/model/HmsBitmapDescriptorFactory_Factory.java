package com.talabat.hms.maps.data.model;

import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;

@ScopeMetadata
@DaggerGenerated
@QualifierMetadata
public final class HmsBitmapDescriptorFactory_Factory implements Factory<HmsBitmapDescriptorFactory> {

    public static final class InstanceHolder {
        /* access modifiers changed from: private */
        public static final HmsBitmapDescriptorFactory_Factory INSTANCE = new HmsBitmapDescriptorFactory_Factory();

        private InstanceHolder() {
        }
    }

    public static HmsBitmapDescriptorFactory_Factory create() {
        return InstanceHolder.INSTANCE;
    }

    public static HmsBitmapDescriptorFactory newInstance() {
        return new HmsBitmapDescriptorFactory();
    }

    public HmsBitmapDescriptorFactory get() {
        return newInstance();
    }
}
