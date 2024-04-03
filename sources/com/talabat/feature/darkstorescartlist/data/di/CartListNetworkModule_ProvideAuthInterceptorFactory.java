package com.talabat.feature.darkstorescartlist.data.di;

import com.talabat.authentication.aaa.secrets.SecretProvider;
import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import javax.inject.Provider;
import okhttp3.Interceptor;

@ScopeMetadata
@DaggerGenerated
@QualifierMetadata({"com.talabat.feature.darkstorescartlist.data.di.CartList"})
public final class CartListNetworkModule_ProvideAuthInterceptorFactory implements Factory<Interceptor> {
    private final CartListNetworkModule module;
    private final Provider<SecretProvider> secretProvider;

    public CartListNetworkModule_ProvideAuthInterceptorFactory(CartListNetworkModule cartListNetworkModule, Provider<SecretProvider> provider) {
        this.module = cartListNetworkModule;
        this.secretProvider = provider;
    }

    public static CartListNetworkModule_ProvideAuthInterceptorFactory create(CartListNetworkModule cartListNetworkModule, Provider<SecretProvider> provider) {
        return new CartListNetworkModule_ProvideAuthInterceptorFactory(cartListNetworkModule, provider);
    }

    public static Interceptor provideAuthInterceptor(CartListNetworkModule cartListNetworkModule, SecretProvider secretProvider2) {
        return (Interceptor) Preconditions.checkNotNullFromProvides(cartListNetworkModule.provideAuthInterceptor(secretProvider2));
    }

    public Interceptor get() {
        return provideAuthInterceptor(this.module, this.secretProvider.get());
    }
}
