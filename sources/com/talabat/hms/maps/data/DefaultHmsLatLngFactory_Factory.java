package com.talabat.hms.maps.data;

import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;

@ScopeMetadata
@DaggerGenerated
@QualifierMetadata
public final class DefaultHmsLatLngFactory_Factory implements Factory<DefaultHmsLatLngFactory> {

    public static final class InstanceHolder {
        /* access modifiers changed from: private */
        public static final DefaultHmsLatLngFactory_Factory INSTANCE = new DefaultHmsLatLngFactory_Factory();

        private InstanceHolder() {
        }
    }

    public static DefaultHmsLatLngFactory_Factory create() {
        return InstanceHolder.INSTANCE;
    }

    public static DefaultHmsLatLngFactory newInstance() {
        return new DefaultHmsLatLngFactory();
    }

    public DefaultHmsLatLngFactory get() {
        return newInstance();
    }
}
