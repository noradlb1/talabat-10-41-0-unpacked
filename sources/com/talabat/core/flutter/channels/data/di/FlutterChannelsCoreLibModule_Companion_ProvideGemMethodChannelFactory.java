package com.talabat.core.flutter.channels.data.di;

import com.talabat.core.flutter.channels.domain.PlatformChannel;
import com.talabat.core.flutter.channels.domain.gem.GemChannelCallback;
import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import javax.inject.Provider;

@ScopeMetadata
@DaggerGenerated
@QualifierMetadata
public final class FlutterChannelsCoreLibModule_Companion_ProvideGemMethodChannelFactory implements Factory<PlatformChannel> {
    private final Provider<GemChannelCallback> gemChannelCallbackProvider;

    public FlutterChannelsCoreLibModule_Companion_ProvideGemMethodChannelFactory(Provider<GemChannelCallback> provider) {
        this.gemChannelCallbackProvider = provider;
    }

    public static FlutterChannelsCoreLibModule_Companion_ProvideGemMethodChannelFactory create(Provider<GemChannelCallback> provider) {
        return new FlutterChannelsCoreLibModule_Companion_ProvideGemMethodChannelFactory(provider);
    }

    public static PlatformChannel provideGemMethodChannel(GemChannelCallback gemChannelCallback) {
        return (PlatformChannel) Preconditions.checkNotNullFromProvides(FlutterChannelsCoreLibModule.Companion.provideGemMethodChannel(gemChannelCallback));
    }

    public PlatformChannel get() {
        return provideGemMethodChannel(this.gemChannelCallbackProvider.get());
    }
}
