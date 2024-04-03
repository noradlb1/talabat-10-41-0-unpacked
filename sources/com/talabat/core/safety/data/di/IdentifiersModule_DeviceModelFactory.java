package com.talabat.core.safety.data.di;

import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;

@ScopeMetadata
@DaggerGenerated
@QualifierMetadata({"com.talabat.core.safety.data.di.DeviceName"})
public final class IdentifiersModule_DeviceModelFactory implements Factory<String> {

    public static final class InstanceHolder {
        /* access modifiers changed from: private */
        public static final IdentifiersModule_DeviceModelFactory INSTANCE = new IdentifiersModule_DeviceModelFactory();

        private InstanceHolder() {
        }
    }

    public static IdentifiersModule_DeviceModelFactory create() {
        return InstanceHolder.INSTANCE;
    }

    public static String deviceModel() {
        return (String) Preconditions.checkNotNullFromProvides(IdentifiersModule.INSTANCE.deviceModel());
    }

    public String get() {
        return deviceModel();
    }
}
