package com.talabat.core.flutter.channels.data.di;

import com.talabat.core.flutter.channels.domain.PlatformChannel;
import com.talabat.core.flutter.channels.domain.sharedprefs.SharedPreferencesChannelCallback;
import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import javax.inject.Provider;

@ScopeMetadata("dagger.Reusable")
@DaggerGenerated
@QualifierMetadata
public final class FlutterChannelsCoreLibModule_Companion_ProvideSharedPreferencesMethodChannelFactory implements Factory<PlatformChannel> {
    private final Provider<SharedPreferencesChannelCallback> sharedPreferencesChannelCallbackProvider;

    public FlutterChannelsCoreLibModule_Companion_ProvideSharedPreferencesMethodChannelFactory(Provider<SharedPreferencesChannelCallback> provider) {
        this.sharedPreferencesChannelCallbackProvider = provider;
    }

    public static FlutterChannelsCoreLibModule_Companion_ProvideSharedPreferencesMethodChannelFactory create(Provider<SharedPreferencesChannelCallback> provider) {
        return new FlutterChannelsCoreLibModule_Companion_ProvideSharedPreferencesMethodChannelFactory(provider);
    }

    public static PlatformChannel provideSharedPreferencesMethodChannel(SharedPreferencesChannelCallback sharedPreferencesChannelCallback) {
        return (PlatformChannel) Preconditions.checkNotNullFromProvides(FlutterChannelsCoreLibModule.Companion.provideSharedPreferencesMethodChannel(sharedPreferencesChannelCallback));
    }

    public PlatformChannel get() {
        return provideSharedPreferencesMethodChannel(this.sharedPreferencesChannelCallbackProvider.get());
    }
}
