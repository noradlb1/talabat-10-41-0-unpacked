package com.talabat.feature.darkstorescartlist.data.di;

import com.squareup.moshi.Moshi;
import com.talabat.feature.darkstorescartlist.data.remote.RestaurantJsonAdapter;
import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import javax.inject.Provider;

@ScopeMetadata
@DaggerGenerated
@QualifierMetadata({"com.talabat.feature.darkstorescartlist.data.di.CartList"})
public final class CartListNetworkModule_ProvideMoshiFactory implements Factory<Moshi> {
    private final CartListNetworkModule module;
    private final Provider<Moshi> moshiProvider;
    private final Provider<RestaurantJsonAdapter> restaurantAdapterProvider;

    public CartListNetworkModule_ProvideMoshiFactory(CartListNetworkModule cartListNetworkModule, Provider<Moshi> provider, Provider<RestaurantJsonAdapter> provider2) {
        this.module = cartListNetworkModule;
        this.moshiProvider = provider;
        this.restaurantAdapterProvider = provider2;
    }

    public static CartListNetworkModule_ProvideMoshiFactory create(CartListNetworkModule cartListNetworkModule, Provider<Moshi> provider, Provider<RestaurantJsonAdapter> provider2) {
        return new CartListNetworkModule_ProvideMoshiFactory(cartListNetworkModule, provider, provider2);
    }

    public static Moshi provideMoshi(CartListNetworkModule cartListNetworkModule, Moshi moshi, RestaurantJsonAdapter restaurantJsonAdapter) {
        return (Moshi) Preconditions.checkNotNullFromProvides(cartListNetworkModule.provideMoshi(moshi, restaurantJsonAdapter));
    }

    public Moshi get() {
        return provideMoshi(this.module, this.moshiProvider.get(), this.restaurantAdapterProvider.get());
    }
}
