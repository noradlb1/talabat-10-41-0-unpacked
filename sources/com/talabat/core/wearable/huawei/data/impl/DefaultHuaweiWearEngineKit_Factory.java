package com.talabat.core.wearable.huawei.data.impl;

import com.huawei.wearengine.auth.AuthClient;
import com.huawei.wearengine.device.DeviceClient;
import com.huawei.wearengine.p2p.P2pClient;
import com.talabat.talabatcore.cache.Cache;
import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import javax.inject.Provider;

@ScopeMetadata
@DaggerGenerated
@QualifierMetadata
public final class DefaultHuaweiWearEngineKit_Factory implements Factory<DefaultHuaweiWearEngineKit> {
    private final Provider<AuthClient> authClientProvider;
    private final Provider<Cache> cacheProvider;
    private final Provider<DeviceClient> deviceClientProvider;
    private final Provider<P2pClient> p2pClientProvider;

    public DefaultHuaweiWearEngineKit_Factory(Provider<Cache> provider, Provider<DeviceClient> provider2, Provider<AuthClient> provider3, Provider<P2pClient> provider4) {
        this.cacheProvider = provider;
        this.deviceClientProvider = provider2;
        this.authClientProvider = provider3;
        this.p2pClientProvider = provider4;
    }

    public static DefaultHuaweiWearEngineKit_Factory create(Provider<Cache> provider, Provider<DeviceClient> provider2, Provider<AuthClient> provider3, Provider<P2pClient> provider4) {
        return new DefaultHuaweiWearEngineKit_Factory(provider, provider2, provider3, provider4);
    }

    public static DefaultHuaweiWearEngineKit newInstance(Cache cache, DeviceClient deviceClient, AuthClient authClient, P2pClient p2pClient) {
        return new DefaultHuaweiWearEngineKit(cache, deviceClient, authClient, p2pClient);
    }

    public DefaultHuaweiWearEngineKit get() {
        return newInstance(this.cacheProvider.get(), this.deviceClientProvider.get(), this.authClientProvider.get(), this.p2pClientProvider.get());
    }
}
