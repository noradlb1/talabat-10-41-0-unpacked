package com.talabat.core.flutter.channels.data.di;

import com.talabat.core.flutter.channels.domain.PlatformChannel;
import com.talabat.core.flutter.channels.domain.tracking.TrackingChannelCallback;
import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import javax.inject.Provider;

@ScopeMetadata
@DaggerGenerated
@QualifierMetadata
public final class FlutterChannelsCoreLibModule_Companion_ProvideTrackingMethodChannelFactory implements Factory<PlatformChannel> {
    private final Provider<TrackingChannelCallback> trackingChannelCallbackProvider;

    public FlutterChannelsCoreLibModule_Companion_ProvideTrackingMethodChannelFactory(Provider<TrackingChannelCallback> provider) {
        this.trackingChannelCallbackProvider = provider;
    }

    public static FlutterChannelsCoreLibModule_Companion_ProvideTrackingMethodChannelFactory create(Provider<TrackingChannelCallback> provider) {
        return new FlutterChannelsCoreLibModule_Companion_ProvideTrackingMethodChannelFactory(provider);
    }

    public static PlatformChannel provideTrackingMethodChannel(TrackingChannelCallback trackingChannelCallback) {
        return (PlatformChannel) Preconditions.checkNotNullFromProvides(FlutterChannelsCoreLibModule.Companion.provideTrackingMethodChannel(trackingChannelCallback));
    }

    public PlatformChannel get() {
        return provideTrackingMethodChannel(this.trackingChannelCallbackProvider.get());
    }
}
