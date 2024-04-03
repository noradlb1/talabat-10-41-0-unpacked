package com.talabat.core.flutter.channels.data.di;

import com.talabat.core.dispatcher.domain.CoroutineDispatchersFactory;
import com.talabat.core.flutter.channels.domain.navigation.DeeplinkNavigationChannelCallback;
import com.talabat.core.flutter.channels.domain.navigation.DeeplinkNavigationNativeDomain;
import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import javax.inject.Provider;

@ScopeMetadata
@DaggerGenerated
@QualifierMetadata
public final class DeeplinkNavigationChannelCoreLibModule_ProvideDeeplinkNavigationNativeDomainFactory implements Factory<DeeplinkNavigationNativeDomain> {
    private final Provider<CoroutineDispatchersFactory> coroutineDispatchersFactoryProvider;
    private final Provider<DeeplinkNavigationChannelCallback> deeplinkNavigationChannelCallbackProvider;

    public DeeplinkNavigationChannelCoreLibModule_ProvideDeeplinkNavigationNativeDomainFactory(Provider<DeeplinkNavigationChannelCallback> provider, Provider<CoroutineDispatchersFactory> provider2) {
        this.deeplinkNavigationChannelCallbackProvider = provider;
        this.coroutineDispatchersFactoryProvider = provider2;
    }

    public static DeeplinkNavigationChannelCoreLibModule_ProvideDeeplinkNavigationNativeDomainFactory create(Provider<DeeplinkNavigationChannelCallback> provider, Provider<CoroutineDispatchersFactory> provider2) {
        return new DeeplinkNavigationChannelCoreLibModule_ProvideDeeplinkNavigationNativeDomainFactory(provider, provider2);
    }

    public static DeeplinkNavigationNativeDomain provideDeeplinkNavigationNativeDomain(DeeplinkNavigationChannelCallback deeplinkNavigationChannelCallback, CoroutineDispatchersFactory coroutineDispatchersFactory) {
        return (DeeplinkNavigationNativeDomain) Preconditions.checkNotNullFromProvides(DeeplinkNavigationChannelCoreLibModule.INSTANCE.provideDeeplinkNavigationNativeDomain(deeplinkNavigationChannelCallback, coroutineDispatchersFactory));
    }

    public DeeplinkNavigationNativeDomain get() {
        return provideDeeplinkNavigationNativeDomain(this.deeplinkNavigationChannelCallbackProvider.get(), this.coroutineDispatchersFactoryProvider.get());
    }
}
