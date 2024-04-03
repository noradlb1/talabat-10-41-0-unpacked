package com.talabat.core.flutter.channels.impl.data.qcommerce;

import buisnessmodels.Cart;
import com.google.gson.Gson;
import com.squareup.moshi.Moshi;
import com.talabat.core.navigation.domain.Navigator;
import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import javax.inject.Provider;

@ScopeMetadata
@DaggerGenerated
@QualifierMetadata({"javax.inject.Named"})
public final class QCommerceChannelCallbackImpl_Factory implements Factory<QCommerceChannelCallbackImpl> {
    private final Provider<Gson> gsonProvider;
    private final Provider<Moshi> moshiProvider;
    private final Provider<Navigator> navigatorProvider;
    private final Provider<Cart> nonMigratedCartProvider;

    public QCommerceChannelCallbackImpl_Factory(Provider<Navigator> provider, Provider<Cart> provider2, Provider<Moshi> provider3, Provider<Gson> provider4) {
        this.navigatorProvider = provider;
        this.nonMigratedCartProvider = provider2;
        this.moshiProvider = provider3;
        this.gsonProvider = provider4;
    }

    public static QCommerceChannelCallbackImpl_Factory create(Provider<Navigator> provider, Provider<Cart> provider2, Provider<Moshi> provider3, Provider<Gson> provider4) {
        return new QCommerceChannelCallbackImpl_Factory(provider, provider2, provider3, provider4);
    }

    public static QCommerceChannelCallbackImpl newInstance(Navigator navigator, Cart cart, Moshi moshi, Gson gson) {
        return new QCommerceChannelCallbackImpl(navigator, cart, moshi, gson);
    }

    public QCommerceChannelCallbackImpl get() {
        return newInstance(this.navigatorProvider.get(), this.nonMigratedCartProvider.get(), this.moshiProvider.get(), this.gsonProvider.get());
    }
}
