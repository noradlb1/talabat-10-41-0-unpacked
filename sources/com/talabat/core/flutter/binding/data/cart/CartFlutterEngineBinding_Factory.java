package com.talabat.core.flutter.binding.data.cart;

import com.talabat.core.flutter.channels.domain.cart.CartChannelFlutterDomain;
import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import javax.inject.Provider;

@ScopeMetadata
@DaggerGenerated
@QualifierMetadata
public final class CartFlutterEngineBinding_Factory implements Factory<CartFlutterEngineBinding> {
    private final Provider<CartChannelFlutterDomain> cartChannelFlutterDomainProvider;

    public CartFlutterEngineBinding_Factory(Provider<CartChannelFlutterDomain> provider) {
        this.cartChannelFlutterDomainProvider = provider;
    }

    public static CartFlutterEngineBinding_Factory create(Provider<CartChannelFlutterDomain> provider) {
        return new CartFlutterEngineBinding_Factory(provider);
    }

    public static CartFlutterEngineBinding newInstance(CartChannelFlutterDomain cartChannelFlutterDomain) {
        return new CartFlutterEngineBinding(cartChannelFlutterDomain);
    }

    public CartFlutterEngineBinding get() {
        return newInstance(this.cartChannelFlutterDomainProvider.get());
    }
}
