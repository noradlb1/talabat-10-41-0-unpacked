package com.talabat.darkstores.domain.basket;

import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import javax.inject.Provider;

@ScopeMetadata
@DaggerGenerated
@QualifierMetadata
public final class IsBasketUpsellBottomSheetShownUseCaseImpl_Factory implements Factory<IsBasketUpsellBottomSheetShownUseCaseImpl> {
    private final Provider<BasketUpsellRepository> basketUpsellRepositoryProvider;

    public IsBasketUpsellBottomSheetShownUseCaseImpl_Factory(Provider<BasketUpsellRepository> provider) {
        this.basketUpsellRepositoryProvider = provider;
    }

    public static IsBasketUpsellBottomSheetShownUseCaseImpl_Factory create(Provider<BasketUpsellRepository> provider) {
        return new IsBasketUpsellBottomSheetShownUseCaseImpl_Factory(provider);
    }

    public static IsBasketUpsellBottomSheetShownUseCaseImpl newInstance(BasketUpsellRepository basketUpsellRepository) {
        return new IsBasketUpsellBottomSheetShownUseCaseImpl(basketUpsellRepository);
    }

    public IsBasketUpsellBottomSheetShownUseCaseImpl get() {
        return newInstance(this.basketUpsellRepositoryProvider.get());
    }
}
