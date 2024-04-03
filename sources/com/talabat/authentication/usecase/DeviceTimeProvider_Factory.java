package com.talabat.authentication.usecase;

import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;

@ScopeMetadata
@DaggerGenerated
@QualifierMetadata
public final class DeviceTimeProvider_Factory implements Factory<DeviceTimeProvider> {

    public static final class InstanceHolder {
        /* access modifiers changed from: private */
        public static final DeviceTimeProvider_Factory INSTANCE = new DeviceTimeProvider_Factory();

        private InstanceHolder() {
        }
    }

    public static DeviceTimeProvider_Factory create() {
        return InstanceHolder.INSTANCE;
    }

    public static DeviceTimeProvider newInstance() {
        return new DeviceTimeProvider();
    }

    public DeviceTimeProvider get() {
        return newInstance();
    }
}
