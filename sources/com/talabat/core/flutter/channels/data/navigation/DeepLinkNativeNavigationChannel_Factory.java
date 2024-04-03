package com.talabat.core.flutter.channels.data.navigation;

import com.talabat.core.dispatcher.domain.CoroutineDispatchersFactory;
import com.talabat.core.flutter.channels.domain.navigation.DeeplinkNavigationChannelCallback;
import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import javax.inject.Provider;

@ScopeMetadata
@DaggerGenerated
@QualifierMetadata
public final class DeepLinkNativeNavigationChannel_Factory implements Factory<DeepLinkNativeNavigationChannel> {
    private final Provider<CoroutineDispatchersFactory> coroutineDispatchersFactoryProvider;
    private final Provider<DeeplinkNavigationChannelCallback> fromNativeCallbackProvider;

    public DeepLinkNativeNavigationChannel_Factory(Provider<DeeplinkNavigationChannelCallback> provider, Provider<CoroutineDispatchersFactory> provider2) {
        this.fromNativeCallbackProvider = provider;
        this.coroutineDispatchersFactoryProvider = provider2;
    }

    public static DeepLinkNativeNavigationChannel_Factory create(Provider<DeeplinkNavigationChannelCallback> provider, Provider<CoroutineDispatchersFactory> provider2) {
        return new DeepLinkNativeNavigationChannel_Factory(provider, provider2);
    }

    public static DeepLinkNativeNavigationChannel newInstance(DeeplinkNavigationChannelCallback deeplinkNavigationChannelCallback, CoroutineDispatchersFactory coroutineDispatchersFactory) {
        return new DeepLinkNativeNavigationChannel(deeplinkNavigationChannelCallback, coroutineDispatchersFactory);
    }

    public DeepLinkNativeNavigationChannel get() {
        return newInstance(this.fromNativeCallbackProvider.get(), this.coroutineDispatchersFactoryProvider.get());
    }
}
