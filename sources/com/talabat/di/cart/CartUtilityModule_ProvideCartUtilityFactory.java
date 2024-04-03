package com.talabat.di.cart;

import com.talabat.feature.foodcart2.domain.IFoodCartRepository;
import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import javax.inject.Provider;
import library.talabat.mvp.cart.CartUtility;

@ScopeMetadata
@DaggerGenerated
@QualifierMetadata
public final class CartUtilityModule_ProvideCartUtilityFactory implements Factory<CartUtility> {
    private final Provider<IFoodCartRepository> foodCartRepositoryProvider;

    public CartUtilityModule_ProvideCartUtilityFactory(Provider<IFoodCartRepository> provider) {
        this.foodCartRepositoryProvider = provider;
    }

    public static CartUtilityModule_ProvideCartUtilityFactory create(Provider<IFoodCartRepository> provider) {
        return new CartUtilityModule_ProvideCartUtilityFactory(provider);
    }

    public static CartUtility provideCartUtility(IFoodCartRepository iFoodCartRepository) {
        return (CartUtility) Preconditions.checkNotNullFromProvides(CartUtilityModule.INSTANCE.provideCartUtility(iFoodCartRepository));
    }

    public CartUtility get() {
        return provideCartUtility(this.foodCartRepositoryProvider.get());
    }
}
