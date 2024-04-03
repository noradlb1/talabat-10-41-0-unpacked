package com.talabat.feature.bnplcore.data.di;

import com.talabat.core.flutter.channels.domain.PlatformChannel;
import com.talabat.feature.bnplcore.domain.usecase.impl.BNPLCoreFlutterChannel;
import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import io.flutter.embedding.engine.FlutterEngine;
import java.util.Map;
import javax.inject.Provider;

@ScopeMetadata("dagger.Reusable")
@DaggerGenerated
@QualifierMetadata
public final class BnplNetworkModule_ProvideBNPLCoreFlutterChannelFactory implements Factory<BNPLCoreFlutterChannel> {
    private final Provider<Map<Class<?>, Provider<PlatformChannel>>> channelsProvider;
    private final Provider<FlutterEngine> flutterEngineProvider;

    public BnplNetworkModule_ProvideBNPLCoreFlutterChannelFactory(Provider<FlutterEngine> provider, Provider<Map<Class<?>, Provider<PlatformChannel>>> provider2) {
        this.flutterEngineProvider = provider;
        this.channelsProvider = provider2;
    }

    public static BnplNetworkModule_ProvideBNPLCoreFlutterChannelFactory create(Provider<FlutterEngine> provider, Provider<Map<Class<?>, Provider<PlatformChannel>>> provider2) {
        return new BnplNetworkModule_ProvideBNPLCoreFlutterChannelFactory(provider, provider2);
    }

    public static BNPLCoreFlutterChannel provideBNPLCoreFlutterChannel(FlutterEngine flutterEngine, Map<Class<?>, Provider<PlatformChannel>> map) {
        return (BNPLCoreFlutterChannel) Preconditions.checkNotNullFromProvides(BnplNetworkModule.provideBNPLCoreFlutterChannel(flutterEngine, map));
    }

    public BNPLCoreFlutterChannel get() {
        return provideBNPLCoreFlutterChannel(this.flutterEngineProvider.get(), this.channelsProvider.get());
    }
}
