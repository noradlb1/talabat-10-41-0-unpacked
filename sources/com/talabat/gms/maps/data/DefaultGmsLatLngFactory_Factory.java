package com.talabat.gms.maps.data;

import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;

@ScopeMetadata
@DaggerGenerated
@QualifierMetadata
public final class DefaultGmsLatLngFactory_Factory implements Factory<DefaultGmsLatLngFactory> {

    public static final class InstanceHolder {
        /* access modifiers changed from: private */
        public static final DefaultGmsLatLngFactory_Factory INSTANCE = new DefaultGmsLatLngFactory_Factory();

        private InstanceHolder() {
        }
    }

    public static DefaultGmsLatLngFactory_Factory create() {
        return InstanceHolder.INSTANCE;
    }

    public static DefaultGmsLatLngFactory newInstance() {
        return new DefaultGmsLatLngFactory();
    }

    public DefaultGmsLatLngFactory get() {
        return newInstance();
    }
}
