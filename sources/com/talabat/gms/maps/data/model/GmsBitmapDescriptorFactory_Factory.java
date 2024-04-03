package com.talabat.gms.maps.data.model;

import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;

@ScopeMetadata
@DaggerGenerated
@QualifierMetadata
public final class GmsBitmapDescriptorFactory_Factory implements Factory<GmsBitmapDescriptorFactory> {

    public static final class InstanceHolder {
        /* access modifiers changed from: private */
        public static final GmsBitmapDescriptorFactory_Factory INSTANCE = new GmsBitmapDescriptorFactory_Factory();

        private InstanceHolder() {
        }
    }

    public static GmsBitmapDescriptorFactory_Factory create() {
        return InstanceHolder.INSTANCE;
    }

    public static GmsBitmapDescriptorFactory newInstance() {
        return new GmsBitmapDescriptorFactory();
    }

    public GmsBitmapDescriptorFactory get() {
        return newInstance();
    }
}
