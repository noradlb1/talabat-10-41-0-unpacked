package com.talabat.core.flutter.channels.impl.data.address;

import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;

@ScopeMetadata
@DaggerGenerated
@QualifierMetadata
public final class NativeAddressMapper_Factory implements Factory<NativeAddressMapper> {

    public static final class InstanceHolder {
        /* access modifiers changed from: private */
        public static final NativeAddressMapper_Factory INSTANCE = new NativeAddressMapper_Factory();

        private InstanceHolder() {
        }
    }

    public static NativeAddressMapper_Factory create() {
        return InstanceHolder.INSTANCE;
    }

    public static NativeAddressMapper newInstance() {
        return new NativeAddressMapper();
    }

    public NativeAddressMapper get() {
        return newInstance();
    }
}
