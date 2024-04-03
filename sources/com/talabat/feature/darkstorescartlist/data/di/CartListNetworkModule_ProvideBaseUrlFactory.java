package com.talabat.feature.darkstorescartlist.data.di;

import com.talabat.core.network.domain.endpoint.BaseUrlFactory;
import com.talabat.feature.darkstorescartlist.data.remote.CartListBaseUrl;
import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import javax.inject.Provider;

@ScopeMetadata
@DaggerGenerated
@QualifierMetadata({"com.talabat.feature.darkstorescartlist.data.di.CartList"})
public final class CartListNetworkModule_ProvideBaseUrlFactory implements Factory<String> {
    private final Provider<BaseUrlFactory> baseUrlFactoryProvider;
    private final CartListNetworkModule module;
    private final Provider<CartListBaseUrl> vendorBaseUrlProvider;

    public CartListNetworkModule_ProvideBaseUrlFactory(CartListNetworkModule cartListNetworkModule, Provider<BaseUrlFactory> provider, Provider<CartListBaseUrl> provider2) {
        this.module = cartListNetworkModule;
        this.baseUrlFactoryProvider = provider;
        this.vendorBaseUrlProvider = provider2;
    }

    public static CartListNetworkModule_ProvideBaseUrlFactory create(CartListNetworkModule cartListNetworkModule, Provider<BaseUrlFactory> provider, Provider<CartListBaseUrl> provider2) {
        return new CartListNetworkModule_ProvideBaseUrlFactory(cartListNetworkModule, provider, provider2);
    }

    public static String provideBaseUrl(CartListNetworkModule cartListNetworkModule, BaseUrlFactory baseUrlFactory, CartListBaseUrl cartListBaseUrl) {
        return (String) Preconditions.checkNotNullFromProvides(cartListNetworkModule.provideBaseUrl(baseUrlFactory, cartListBaseUrl));
    }

    public String get() {
        return provideBaseUrl(this.module, this.baseUrlFactoryProvider.get(), this.vendorBaseUrlProvider.get());
    }
}
