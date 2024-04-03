package com.talabat.core.flutter.channels.data.di;

import com.talabat.core.flutter.channels.domain.PlatformChannel;
import com.talabat.core.flutter.channels.domain.legacydeeplink.LegacyDeeplinkNavigationChannelCallback;
import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import javax.inject.Provider;

@ScopeMetadata("dagger.Reusable")
@DaggerGenerated
@QualifierMetadata
public final class FlutterChannelsCoreLibModule_Companion_ProvideLegacyDeepLinkNavigationMethodChannelFactory implements Factory<PlatformChannel> {
    private final Provider<LegacyDeeplinkNavigationChannelCallback> legacyDeeplinkNavigationChannelCallbackProvider;

    public FlutterChannelsCoreLibModule_Companion_ProvideLegacyDeepLinkNavigationMethodChannelFactory(Provider<LegacyDeeplinkNavigationChannelCallback> provider) {
        this.legacyDeeplinkNavigationChannelCallbackProvider = provider;
    }

    public static FlutterChannelsCoreLibModule_Companion_ProvideLegacyDeepLinkNavigationMethodChannelFactory create(Provider<LegacyDeeplinkNavigationChannelCallback> provider) {
        return new FlutterChannelsCoreLibModule_Companion_ProvideLegacyDeepLinkNavigationMethodChannelFactory(provider);
    }

    public static PlatformChannel provideLegacyDeepLinkNavigationMethodChannel(LegacyDeeplinkNavigationChannelCallback legacyDeeplinkNavigationChannelCallback) {
        return (PlatformChannel) Preconditions.checkNotNullFromProvides(FlutterChannelsCoreLibModule.Companion.provideLegacyDeepLinkNavigationMethodChannel(legacyDeeplinkNavigationChannelCallback));
    }

    public PlatformChannel get() {
        return provideLegacyDeepLinkNavigationMethodChannel(this.legacyDeeplinkNavigationChannelCallbackProvider.get());
    }
}
