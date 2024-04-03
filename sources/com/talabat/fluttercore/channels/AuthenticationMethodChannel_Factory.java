package com.talabat.fluttercore.channels;

import com.talabat.authentication.aaa.secrets.SecretProvider;
import com.talabat.authentication.token.data.flutter.TokenFlutterMapper;
import com.talabat.authentication.token.domain.repository.TokenRepository;
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
    private final Provider<SecretProvider> secretProvider;
    private final Provider<TokenFlutterMapper> tokenFlutterMapperProvider;
    private final Provider<TokenRepository> tokenRepositoryProvider;

    public AuthenticationMethodChannel_Factory(Provider<SecretProvider> provider, Provider<TokenRepository> provider2, Provider<TokenFlutterMapper> provider3, Provider<AuthenticationChannelCallback> provider4) {
        this.secretProvider = provider;
        this.tokenRepositoryProvider = provider2;
        this.tokenFlutterMapperProvider = provider3;
        this.authenticationChannelCallbackProvider = provider4;
    }

    public static AuthenticationMethodChannel_Factory create(Provider<SecretProvider> provider, Provider<TokenRepository> provider2, Provider<TokenFlutterMapper> provider3, Provider<AuthenticationChannelCallback> provider4) {
        return new AuthenticationMethodChannel_Factory(provider, provider2, provider3, provider4);
    }

    public static AuthenticationMethodChannel newInstance(SecretProvider secretProvider2, TokenRepository tokenRepository, TokenFlutterMapper tokenFlutterMapper, AuthenticationChannelCallback authenticationChannelCallback) {
        return new AuthenticationMethodChannel(secretProvider2, tokenRepository, tokenFlutterMapper, authenticationChannelCallback);
    }

    public AuthenticationMethodChannel get() {
        return newInstance(this.secretProvider.get(), this.tokenRepositoryProvider.get(), this.tokenFlutterMapperProvider.get(), this.authenticationChannelCallbackProvider.get());
    }
}
