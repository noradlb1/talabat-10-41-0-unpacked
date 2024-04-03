package com.talabat.core.flutter.channels.data.di;

import com.talabat.core.flutter.channels.domain.PlatformChannel;
import com.talabat.core.flutter.channels.domain.home.HomeChannelCallback;
import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import javax.inject.Provider;

@ScopeMetadata
@DaggerGenerated
@QualifierMetadata
public final class FlutterChannelsCoreLibModule_Companion_ProvideHomeMethodChannelFactory implements Factory<PlatformChannel> {
    private final Provider<HomeChannelCallback> homeChannelCallbackProvider;

    public FlutterChannelsCoreLibModule_Companion_ProvideHomeMethodChannelFactory(Provider<HomeChannelCallback> provider) {
        this.homeChannelCallbackProvider = provider;
    }

    public static FlutterChannelsCoreLibModule_Companion_ProvideHomeMethodChannelFactory create(Provider<HomeChannelCallback> provider) {
        return new FlutterChannelsCoreLibModule_Companion_ProvideHomeMethodChannelFactory(provider);
    }

    public static PlatformChannel provideHomeMethodChannel(HomeChannelCallback homeChannelCallback) {
        return (PlatformChannel) Preconditions.checkNotNullFromProvides(FlutterChannelsCoreLibModule.Companion.provideHomeMethodChannel(homeChannelCallback));
    }

    public PlatformChannel get() {
        return provideHomeMethodChannel(this.homeChannelCallbackProvider.get());
    }
}
