package com.talabat.core.flutter.channels.data.di;

import com.talabat.core.flutter.channels.domain.PlatformChannel;
import com.talabat.core.flutter.channels.domain.qcommerce.QCommerceChannelCallback;
import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import javax.inject.Provider;

@ScopeMetadata("dagger.Reusable")
@DaggerGenerated
@QualifierMetadata
public final class FlutterChannelsFeatureLibModule_Companion_ProvideQCommerceMethodChannelFactory implements Factory<PlatformChannel> {
    private final Provider<QCommerceChannelCallback> qCommerceChannelCallbackProvider;

    public FlutterChannelsFeatureLibModule_Companion_ProvideQCommerceMethodChannelFactory(Provider<QCommerceChannelCallback> provider) {
        this.qCommerceChannelCallbackProvider = provider;
    }

    public static FlutterChannelsFeatureLibModule_Companion_ProvideQCommerceMethodChannelFactory create(Provider<QCommerceChannelCallback> provider) {
        return new FlutterChannelsFeatureLibModule_Companion_ProvideQCommerceMethodChannelFactory(provider);
    }

    public static PlatformChannel provideQCommerceMethodChannel(QCommerceChannelCallback qCommerceChannelCallback) {
        return (PlatformChannel) Preconditions.checkNotNullFromProvides(FlutterChannelsFeatureLibModule.Companion.provideQCommerceMethodChannel(qCommerceChannelCallback));
    }

    public PlatformChannel get() {
        return provideQCommerceMethodChannel(this.qCommerceChannelCallbackProvider.get());
    }
}
