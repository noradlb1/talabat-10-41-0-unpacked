package com.talabat.core.flutter.channels.data.di;

import com.talabat.core.dispatcher.domain.CoroutineDispatchersFactory;
import com.talabat.core.flutter.channels.domain.PlatformChannel;
import com.talabat.core.flutter.channels.domain.tpro.TProChannelCallback;
import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import javax.inject.Provider;

@ScopeMetadata("dagger.Reusable")
@DaggerGenerated
@QualifierMetadata
public final class FlutterChannelsFeatureLibModule_Companion_ProvideTproMethodChannelFactory implements Factory<PlatformChannel> {
    private final Provider<CoroutineDispatchersFactory> coroutineDispatchersFactoryProvider;
    private final Provider<TProChannelCallback> tProChannelCallbackProvider;

    public FlutterChannelsFeatureLibModule_Companion_ProvideTproMethodChannelFactory(Provider<TProChannelCallback> provider, Provider<CoroutineDispatchersFactory> provider2) {
        this.tProChannelCallbackProvider = provider;
        this.coroutineDispatchersFactoryProvider = provider2;
    }

    public static FlutterChannelsFeatureLibModule_Companion_ProvideTproMethodChannelFactory create(Provider<TProChannelCallback> provider, Provider<CoroutineDispatchersFactory> provider2) {
        return new FlutterChannelsFeatureLibModule_Companion_ProvideTproMethodChannelFactory(provider, provider2);
    }

    public static PlatformChannel provideTproMethodChannel(TProChannelCallback tProChannelCallback, CoroutineDispatchersFactory coroutineDispatchersFactory) {
        return (PlatformChannel) Preconditions.checkNotNullFromProvides(FlutterChannelsFeatureLibModule.Companion.provideTproMethodChannel(tProChannelCallback, coroutineDispatchersFactory));
    }

    public PlatformChannel get() {
        return provideTproMethodChannel(this.tProChannelCallbackProvider.get(), this.coroutineDispatchersFactoryProvider.get());
    }
}
