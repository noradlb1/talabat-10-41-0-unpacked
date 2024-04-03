package com.talabat.core.flutter.channels.data.di;

import com.talabat.core.flutter.channels.domain.PlatformChannel;
import com.talabat.core.flutter.channels.domain.cart.CartChannelCallback;
import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import javax.inject.Provider;

@ScopeMetadata
@DaggerGenerated
@QualifierMetadata
public final class FlutterChannelsCoreLibModule_Companion_ProvideCartMethodChannelFactory implements Factory<PlatformChannel> {
    private final Provider<CartChannelCallback> cartChannelCallbackProvider;

    public FlutterChannelsCoreLibModule_Companion_ProvideCartMethodChannelFactory(Provider<CartChannelCallback> provider) {
        this.cartChannelCallbackProvider = provider;
    }

    public static FlutterChannelsCoreLibModule_Companion_ProvideCartMethodChannelFactory create(Provider<CartChannelCallback> provider) {
        return new FlutterChannelsCoreLibModule_Companion_ProvideCartMethodChannelFactory(provider);
    }

    public static PlatformChannel provideCartMethodChannel(CartChannelCallback cartChannelCallback) {
        return (PlatformChannel) Preconditions.checkNotNullFromProvides(FlutterChannelsCoreLibModule.Companion.provideCartMethodChannel(cartChannelCallback));
    }

    public PlatformChannel get() {
        return provideCartMethodChannel(this.cartChannelCallbackProvider.get());
    }
}
