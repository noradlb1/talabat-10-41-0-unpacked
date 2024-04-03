package com.talabat.core.wearable.huawei.data.di;

import android.content.Context;
import com.huawei.wearengine.p2p.P2pClient;
import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import javax.inject.Provider;

@ScopeMetadata("dagger.Reusable")
@DaggerGenerated
@QualifierMetadata
public final class HuaweiWatchModule_Companion_P2pClientFactory implements Factory<P2pClient> {
    private final Provider<Context> contextProvider;

    public HuaweiWatchModule_Companion_P2pClientFactory(Provider<Context> provider) {
        this.contextProvider = provider;
    }

    public static HuaweiWatchModule_Companion_P2pClientFactory create(Provider<Context> provider) {
        return new HuaweiWatchModule_Companion_P2pClientFactory(provider);
    }

    public static P2pClient p2pClient(Context context) {
        return (P2pClient) Preconditions.checkNotNullFromProvides(HuaweiWatchModule.Companion.p2pClient(context));
    }

    public P2pClient get() {
        return p2pClient(this.contextProvider.get());
    }
}
