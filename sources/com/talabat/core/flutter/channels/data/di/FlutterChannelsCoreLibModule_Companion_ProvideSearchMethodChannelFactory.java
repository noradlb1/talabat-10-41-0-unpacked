package com.talabat.core.flutter.channels.data.di;

import com.talabat.core.flutter.channels.domain.PlatformChannel;
import com.talabat.core.flutter.channels.domain.search.SearchChannelCallback;
import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import javax.inject.Provider;

@ScopeMetadata
@DaggerGenerated
@QualifierMetadata
public final class FlutterChannelsCoreLibModule_Companion_ProvideSearchMethodChannelFactory implements Factory<PlatformChannel> {
    private final Provider<SearchChannelCallback> searchChannelCallbackProvider;

    public FlutterChannelsCoreLibModule_Companion_ProvideSearchMethodChannelFactory(Provider<SearchChannelCallback> provider) {
        this.searchChannelCallbackProvider = provider;
    }

    public static FlutterChannelsCoreLibModule_Companion_ProvideSearchMethodChannelFactory create(Provider<SearchChannelCallback> provider) {
        return new FlutterChannelsCoreLibModule_Companion_ProvideSearchMethodChannelFactory(provider);
    }

    public static PlatformChannel provideSearchMethodChannel(SearchChannelCallback searchChannelCallback) {
        return (PlatformChannel) Preconditions.checkNotNullFromProvides(FlutterChannelsCoreLibModule.Companion.provideSearchMethodChannel(searchChannelCallback));
    }

    public PlatformChannel get() {
        return provideSearchMethodChannel(this.searchChannelCallbackProvider.get());
    }
}
