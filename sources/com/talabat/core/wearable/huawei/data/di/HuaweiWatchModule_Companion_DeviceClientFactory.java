package com.talabat.core.wearable.huawei.data.di;

import android.content.Context;
import com.huawei.wearengine.device.DeviceClient;
import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import javax.inject.Provider;

@ScopeMetadata("dagger.Reusable")
@DaggerGenerated
@QualifierMetadata
public final class HuaweiWatchModule_Companion_DeviceClientFactory implements Factory<DeviceClient> {
    private final Provider<Context> contextProvider;

    public HuaweiWatchModule_Companion_DeviceClientFactory(Provider<Context> provider) {
        this.contextProvider = provider;
    }

    public static HuaweiWatchModule_Companion_DeviceClientFactory create(Provider<Context> provider) {
        return new HuaweiWatchModule_Companion_DeviceClientFactory(provider);
    }

    public static DeviceClient deviceClient(Context context) {
        return (DeviceClient) Preconditions.checkNotNullFromProvides(HuaweiWatchModule.Companion.deviceClient(context));
    }

    public DeviceClient get() {
        return deviceClient(this.contextProvider.get());
    }
}
