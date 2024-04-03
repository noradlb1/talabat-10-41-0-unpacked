package com.talabat.feature.darkstorescartlist.data.di;

import com.talabat.feature.darkstorescartlist.data.remote.CartListApi;
import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import javax.inject.Provider;
import retrofit2.Retrofit;

@ScopeMetadata
@DaggerGenerated
@QualifierMetadata({"com.talabat.feature.darkstorescartlist.data.di.CartList"})
public final class CartListNetworkModule_ProvideCartListApiFactory implements Factory<CartListApi> {
    private final CartListNetworkModule module;
    private final Provider<Retrofit> retrofitProvider;

    public CartListNetworkModule_ProvideCartListApiFactory(CartListNetworkModule cartListNetworkModule, Provider<Retrofit> provider) {
        this.module = cartListNetworkModule;
        this.retrofitProvider = provider;
    }

    public static CartListNetworkModule_ProvideCartListApiFactory create(CartListNetworkModule cartListNetworkModule, Provider<Retrofit> provider) {
        return new CartListNetworkModule_ProvideCartListApiFactory(cartListNetworkModule, provider);
    }

    public static CartListApi provideCartListApi(CartListNetworkModule cartListNetworkModule, Retrofit retrofit) {
        return (CartListApi) Preconditions.checkNotNullFromProvides(cartListNetworkModule.provideCartListApi(retrofit));
    }

    public CartListApi get() {
        return provideCartListApi(this.module, this.retrofitProvider.get());
    }
}
