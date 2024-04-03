package com.talabat.core.flutter.channels.data.di;

import com.talabat.core.flutter.channels.domain.PlatformChannel;
import com.talabat.core.flutter.channels.domain.authentication.AuthenticationChannelCallback;
import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import javax.inject.Provider;

@ScopeMetadata
@DaggerGenerated
@QualifierMetadata
public final class FlutterChannelsCoreLibModule_Companion_ProvideAuthenticationMethodChannelFactory implements Factory<PlatformChannel> {
    private final Provider<AuthenticationChannelCallback> authenticationChannelCallbackProvider;

    public FlutterChannelsCoreLibModule_Companion_ProvideAuthenticationMethodChannelFactory(Provider<AuthenticationChannelCallback> provider) {
        this.authenticationChannelCallbackProvider = provider;
    }

    public static FlutterChannelsCoreLibModule_Companion_ProvideAuthenticationMethodChannelFactory create(Provider<AuthenticationChannelCallback> provider) {
        return new FlutterChannelsCoreLibModule_Companion_ProvideAuthenticationMethodChannelFactory(provider);
    }

    public static PlatformChannel provideAuthenticationMethodChannel(AuthenticationChannelCallback authenticationChannelCallback) {
        return (PlatformChannel) Preconditions.checkNotNullFromProvides(FlutterChannelsCoreLibModule.Companion.provideAuthenticationMethodChannel(authenticationChannelCallback));
    }

    public PlatformChannel get() {
        return provideAuthenticationMethodChannel(this.authenticationChannelCallbackProvider.get());
    }
}
