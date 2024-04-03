package com.talabat.core.flutter.channels.data.di;

import com.talabat.core.flutter.channels.domain.PlatformChannel;
import com.talabat.core.flutter.channels.domain.apicallmocks.ApiCallsMockChannelCallback;
import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import javax.inject.Provider;

@ScopeMetadata("dagger.Reusable")
@DaggerGenerated
@QualifierMetadata
public final class FlutterChannelsCoreLibModule_Companion_ProvideApiCallsMockChannelFactory implements Factory<PlatformChannel> {
    private final Provider<ApiCallsMockChannelCallback> apiMockChannelCallbackProvider;

    public FlutterChannelsCoreLibModule_Companion_ProvideApiCallsMockChannelFactory(Provider<ApiCallsMockChannelCallback> provider) {
        this.apiMockChannelCallbackProvider = provider;
    }

    public static FlutterChannelsCoreLibModule_Companion_ProvideApiCallsMockChannelFactory create(Provider<ApiCallsMockChannelCallback> provider) {
        return new FlutterChannelsCoreLibModule_Companion_ProvideApiCallsMockChannelFactory(provider);
    }

    public static PlatformChannel provideApiCallsMockChannel(ApiCallsMockChannelCallback apiCallsMockChannelCallback) {
        return (PlatformChannel) Preconditions.checkNotNullFromProvides(FlutterChannelsCoreLibModule.Companion.provideApiCallsMockChannel(apiCallsMockChannelCallback));
    }

    public PlatformChannel get() {
        return provideApiCallsMockChannel(this.apiMockChannelCallbackProvider.get());
    }
}
