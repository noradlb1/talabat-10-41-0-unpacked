package com.talabat.core.flutter.channels.data.di;

import com.talabat.core.flutter.channels.domain.PlatformChannel;
import com.talabat.core.flutter.channels.domain.vendorlist.InlineAdsChannelCallback;
import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import javax.inject.Provider;

@ScopeMetadata("dagger.Reusable")
@DaggerGenerated
@QualifierMetadata
public final class FlutterChannelsCoreLibModule_Companion_ProvideInlineAdsMethodChannelFactory implements Factory<PlatformChannel> {
    private final Provider<InlineAdsChannelCallback> inlineAdsChannelCallbackProvider;

    public FlutterChannelsCoreLibModule_Companion_ProvideInlineAdsMethodChannelFactory(Provider<InlineAdsChannelCallback> provider) {
        this.inlineAdsChannelCallbackProvider = provider;
    }

    public static FlutterChannelsCoreLibModule_Companion_ProvideInlineAdsMethodChannelFactory create(Provider<InlineAdsChannelCallback> provider) {
        return new FlutterChannelsCoreLibModule_Companion_ProvideInlineAdsMethodChannelFactory(provider);
    }

    public static PlatformChannel provideInlineAdsMethodChannel(InlineAdsChannelCallback inlineAdsChannelCallback) {
        return (PlatformChannel) Preconditions.checkNotNullFromProvides(FlutterChannelsCoreLibModule.Companion.provideInlineAdsMethodChannel(inlineAdsChannelCallback));
    }

    public PlatformChannel get() {
        return provideInlineAdsMethodChannel(this.inlineAdsChannelCallbackProvider.get());
    }
}
