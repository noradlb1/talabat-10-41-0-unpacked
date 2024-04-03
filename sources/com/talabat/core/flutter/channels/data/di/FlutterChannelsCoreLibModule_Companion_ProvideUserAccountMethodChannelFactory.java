package com.talabat.core.flutter.channels.data.di;

import com.talabat.core.flutter.channels.domain.PlatformChannel;
import com.talabat.core.flutter.channels.domain.useraccount.UserAccountChannelCallback;
import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import javax.inject.Provider;

@ScopeMetadata
@DaggerGenerated
@QualifierMetadata
public final class FlutterChannelsCoreLibModule_Companion_ProvideUserAccountMethodChannelFactory implements Factory<PlatformChannel> {
    private final Provider<UserAccountChannelCallback> userAccountChannelCallbackProvider;

    public FlutterChannelsCoreLibModule_Companion_ProvideUserAccountMethodChannelFactory(Provider<UserAccountChannelCallback> provider) {
        this.userAccountChannelCallbackProvider = provider;
    }

    public static FlutterChannelsCoreLibModule_Companion_ProvideUserAccountMethodChannelFactory create(Provider<UserAccountChannelCallback> provider) {
        return new FlutterChannelsCoreLibModule_Companion_ProvideUserAccountMethodChannelFactory(provider);
    }

    public static PlatformChannel provideUserAccountMethodChannel(UserAccountChannelCallback userAccountChannelCallback) {
        return (PlatformChannel) Preconditions.checkNotNullFromProvides(FlutterChannelsCoreLibModule.Companion.provideUserAccountMethodChannel(userAccountChannelCallback));
    }

    public PlatformChannel get() {
        return provideUserAccountMethodChannel(this.userAccountChannelCallbackProvider.get());
    }
}
