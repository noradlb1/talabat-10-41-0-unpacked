package com.talabat.hms.maps.data;

import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;

@ScopeMetadata
@DaggerGenerated
@QualifierMetadata
public final class DefaultHmsCameraUpdateFactory_Factory implements Factory<DefaultHmsCameraUpdateFactory> {

    public static final class InstanceHolder {
        /* access modifiers changed from: private */
        public static final DefaultHmsCameraUpdateFactory_Factory INSTANCE = new DefaultHmsCameraUpdateFactory_Factory();

        private InstanceHolder() {
        }
    }

    public static DefaultHmsCameraUpdateFactory_Factory create() {
        return InstanceHolder.INSTANCE;
    }

    public static DefaultHmsCameraUpdateFactory newInstance() {
        return new DefaultHmsCameraUpdateFactory();
    }

    public DefaultHmsCameraUpdateFactory get() {
        return newInstance();
    }
}
