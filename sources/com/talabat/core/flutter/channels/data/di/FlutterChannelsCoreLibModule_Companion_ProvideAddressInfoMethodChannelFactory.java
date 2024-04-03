package com.talabat.core.flutter.channels.data.di;

import com.talabat.core.dispatcher.domain.CoroutineDispatchersFactory;
import com.talabat.core.flutter.channels.domain.PlatformChannel;
import com.talabat.core.flutter.channels.domain.address.AddressInfoChannelCallback;
import com.talabat.core.observabilityNew.domain.IObservabilityManager;
import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import javax.inject.Provider;

@ScopeMetadata("dagger.Reusable")
@DaggerGenerated
@QualifierMetadata
public final class FlutterChannelsCoreLibModule_Companion_ProvideAddressInfoMethodChannelFactory implements Factory<PlatformChannel> {
    private final Provider<AddressInfoChannelCallback> addressInfoChannelCallbackProvider;
    private final Provider<CoroutineDispatchersFactory> coroutineDispatchersFactoryProvider;
    private final Provider<IObservabilityManager> observabilityManagerProvider;

    public FlutterChannelsCoreLibModule_Companion_ProvideAddressInfoMethodChannelFactory(Provider<AddressInfoChannelCallback> provider, Provider<IObservabilityManager> provider2, Provider<CoroutineDispatchersFactory> provider3) {
        this.addressInfoChannelCallbackProvider = provider;
        this.observabilityManagerProvider = provider2;
        this.coroutineDispatchersFactoryProvider = provider3;
    }

    public static FlutterChannelsCoreLibModule_Companion_ProvideAddressInfoMethodChannelFactory create(Provider<AddressInfoChannelCallback> provider, Provider<IObservabilityManager> provider2, Provider<CoroutineDispatchersFactory> provider3) {
        return new FlutterChannelsCoreLibModule_Companion_ProvideAddressInfoMethodChannelFactory(provider, provider2, provider3);
    }

    public static PlatformChannel provideAddressInfoMethodChannel(AddressInfoChannelCallback addressInfoChannelCallback, IObservabilityManager iObservabilityManager, CoroutineDispatchersFactory coroutineDispatchersFactory) {
        return (PlatformChannel) Preconditions.checkNotNullFromProvides(FlutterChannelsCoreLibModule.Companion.provideAddressInfoMethodChannel(addressInfoChannelCallback, iObservabilityManager, coroutineDispatchersFactory));
    }

    public PlatformChannel get() {
        return provideAddressInfoMethodChannel(this.addressInfoChannelCallbackProvider.get(), this.observabilityManagerProvider.get(), this.coroutineDispatchersFactoryProvider.get());
    }
}
