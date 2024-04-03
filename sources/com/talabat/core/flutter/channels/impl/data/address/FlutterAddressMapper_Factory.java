package com.talabat.core.flutter.channels.impl.data.address;

import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;

@ScopeMetadata
@DaggerGenerated
@QualifierMetadata
public final class FlutterAddressMapper_Factory implements Factory<FlutterAddressMapper> {

    public static final class InstanceHolder {
        /* access modifiers changed from: private */
        public static final FlutterAddressMapper_Factory INSTANCE = new FlutterAddressMapper_Factory();

        private InstanceHolder() {
        }
    }

    public static FlutterAddressMapper_Factory create() {
        return InstanceHolder.INSTANCE;
    }

    public static FlutterAddressMapper newInstance() {
        return new FlutterAddressMapper();
    }

    public FlutterAddressMapper get() {
        return newInstance();
    }
}
