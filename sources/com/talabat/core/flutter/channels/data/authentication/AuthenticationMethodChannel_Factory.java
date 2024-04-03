package com.talabat.core.flutter.channels.data.authentication;

import com.talabat.core.flutter.channels.domain.authentication.AuthenticationChannelCallback;
import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import javax.inject.Provider;

@ScopeMetadata
@DaggerGenerated
@QualifierMetadata
public final class AuthenticationMethodChannel_Factory implements Factory<AuthenticationMethodChannel> {
    private final Provider<AuthenticationChannelCallback> authenticationChannelCallbackProvider;

    public AuthenticationMethodChannel_Factory(Provider<AuthenticationChannelCallback> provider) {
        this.authenticationChannelCallbackProvider = provider;
    }

    public static AuthenticationMethodChannel_Factory create(Provider<AuthenticationChannelCallback> provider) {
        return new AuthenticationMethodChannel_Factory(provider);
    }

    public static AuthenticationMethodChannel newInstance(AuthenticationChannelCallback authenticationChannelCallback) {
        return new AuthenticationMethodChannel(authenticationChannelCallback);
    }

    public AuthenticationMethodChannel get() {
        return newInstance(this.authenticationChannelCallbackProvider.get());
    }
}
