package com.talabat.gms.maps.data;

import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;

@ScopeMetadata
@DaggerGenerated
@QualifierMetadata
public final class DefaultGmsCameraUpdateFactory_Factory implements Factory<DefaultGmsCameraUpdateFactory> {

    public static final class InstanceHolder {
        /* access modifiers changed from: private */
        public static final DefaultGmsCameraUpdateFactory_Factory INSTANCE = new DefaultGmsCameraUpdateFactory_Factory();

        private InstanceHolder() {
        }
    }

    public static DefaultGmsCameraUpdateFactory_Factory create() {
        return InstanceHolder.INSTANCE;
    }

    public static DefaultGmsCameraUpdateFactory newInstance() {
        return new DefaultGmsCameraUpdateFactory();
    }

    public DefaultGmsCameraUpdateFactory get() {
        return newInstance();
    }
}
