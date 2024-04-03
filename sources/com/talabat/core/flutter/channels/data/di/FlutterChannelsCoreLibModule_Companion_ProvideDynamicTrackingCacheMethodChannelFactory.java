package com.talabat.core.flutter.channels.data.di;

import com.talabat.core.flutter.channels.domain.PlatformChannel;
import com.talabat.core.flutter.channels.domain.dynamictrackingcache.DynamicTrackingCacheCallback;
import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import javax.inject.Provider;

@ScopeMetadata
@DaggerGenerated
@QualifierMetadata
public final class FlutterChannelsCoreLibModule_Companion_ProvideDynamicTrackingCacheMethodChannelFactory implements Factory<PlatformChannel> {
    private final Provider<DynamicTrackingCacheCallback> dynamicTrackingCacheCallbackProvider;

    public FlutterChannelsCoreLibModule_Companion_ProvideDynamicTrackingCacheMethodChannelFactory(Provider<DynamicTrackingCacheCallback> provider) {
        this.dynamicTrackingCacheCallbackProvider = provider;
    }

    public static FlutterChannelsCoreLibModule_Companion_ProvideDynamicTrackingCacheMethodChannelFactory create(Provider<DynamicTrackingCacheCallback> provider) {
        return new FlutterChannelsCoreLibModule_Companion_ProvideDynamicTrackingCacheMethodChannelFactory(provider);
    }

    public static PlatformChannel provideDynamicTrackingCacheMethodChannel(DynamicTrackingCacheCallback dynamicTrackingCacheCallback) {
        return (PlatformChannel) Preconditions.checkNotNullFromProvides(FlutterChannelsCoreLibModule.Companion.provideDynamicTrackingCacheMethodChannel(dynamicTrackingCacheCallback));
    }

    public PlatformChannel get() {
        return provideDynamicTrackingCacheMethodChannel(this.dynamicTrackingCacheCallbackProvider.get());
    }
}
