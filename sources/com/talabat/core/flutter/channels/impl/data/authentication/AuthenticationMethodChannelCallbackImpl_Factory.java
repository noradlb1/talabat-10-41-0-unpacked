package com.talabat.core.flutter.channels.impl.data.authentication;

import android.content.Context;
import com.talabat.authentication.aaa.secrets.SecretProvider;
import com.talabat.authentication.token.data.flutter.TokenFlutterMapper;
import com.talabat.authentication.token.domain.repository.TokenRepository;
import com.talabat.core.featureflag.domain.ITalabatFeatureFlag;
import com.talabat.core.navigation.domain.Navigator;
import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import javax.inject.Provider;

@ScopeMetadata
@DaggerGenerated
@QualifierMetadata
public final class AuthenticationMethodChannelCallbackImpl_Factory implements Factory<AuthenticationMethodChannelCallbackImpl> {
    private final Provider<Context> contextProvider;
    private final Provider<ITalabatFeatureFlag> featureFlagsProvider;
    private final Provider<Navigator> navigatorProvider;
    private final Provider<SecretProvider> secretProvider;
    private final Provider<TokenFlutterMapper> tokenFlutterMapperProvider;
    private final Provider<TokenRepository> tokenRepositoryProvider;

    public AuthenticationMethodChannelCallbackImpl_Factory(Provider<SecretProvider> provider, Provider<TokenRepository> provider2, Provider<TokenFlutterMapper> provider3, Provider<ITalabatFeatureFlag> provider4, Provider<Navigator> provider5, Provider<Context> provider6) {
        this.secretProvider = provider;
        this.tokenRepositoryProvider = provider2;
        this.tokenFlutterMapperProvider = provider3;
        this.featureFlagsProvider = provider4;
        this.navigatorProvider = provider5;
        this.contextProvider = provider6;
    }

    public static AuthenticationMethodChannelCallbackImpl_Factory create(Provider<SecretProvider> provider, Provider<TokenRepository> provider2, Provider<TokenFlutterMapper> provider3, Provider<ITalabatFeatureFlag> provider4, Provider<Navigator> provider5, Provider<Context> provider6) {
        return new AuthenticationMethodChannelCallbackImpl_Factory(provider, provider2, provider3, provider4, provider5, provider6);
    }

    public static AuthenticationMethodChannelCallbackImpl newInstance(SecretProvider secretProvider2, TokenRepository tokenRepository, TokenFlutterMapper tokenFlutterMapper, ITalabatFeatureFlag iTalabatFeatureFlag, Navigator navigator, Context context) {
        return new AuthenticationMethodChannelCallbackImpl(secretProvider2, tokenRepository, tokenFlutterMapper, iTalabatFeatureFlag, navigator, context);
    }

    public AuthenticationMethodChannelCallbackImpl get() {
        return newInstance(this.secretProvider.get(), this.tokenRepositoryProvider.get(), this.tokenFlutterMapperProvider.get(), this.featureFlagsProvider.get(), this.navigatorProvider.get(), this.contextProvider.get());
    }
}
