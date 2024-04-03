package com.talabat.darkstores.feature.cart;

import com.talabat.darkstores.data.discovery.DiscoveryRepo;
import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import javax.inject.Provider;

@ScopeMetadata
@DaggerGenerated
@QualifierMetadata
public final class CartSwimlaneUseCase_Factory implements Factory<CartSwimlaneUseCase> {
    private final Provider<DiscoveryRepo> discoveryRepoProvider;

    public CartSwimlaneUseCase_Factory(Provider<DiscoveryRepo> provider) {
        this.discoveryRepoProvider = provider;
    }

    public static CartSwimlaneUseCase_Factory create(Provider<DiscoveryRepo> provider) {
        return new CartSwimlaneUseCase_Factory(provider);
    }

    public static CartSwimlaneUseCase newInstance(DiscoveryRepo discoveryRepo) {
        return new CartSwimlaneUseCase(discoveryRepo);
    }

    public CartSwimlaneUseCase get() {
        return newInstance(this.discoveryRepoProvider.get());
    }
}
