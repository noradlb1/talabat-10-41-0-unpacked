package com.talabat.darkstores.domain.basket;

import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import javax.inject.Provider;

@ScopeMetadata
@DaggerGenerated
@QualifierMetadata
public final class SaveBasketUpsellBottomSheetShownUseCaseImpl_Factory implements Factory<SaveBasketUpsellBottomSheetShownUseCaseImpl> {
    private final Provider<BasketUpsellRepository> basketUpsellRepositoryProvider;

    public SaveBasketUpsellBottomSheetShownUseCaseImpl_Factory(Provider<BasketUpsellRepository> provider) {
        this.basketUpsellRepositoryProvider = provider;
    }

    public static SaveBasketUpsellBottomSheetShownUseCaseImpl_Factory create(Provider<BasketUpsellRepository> provider) {
        return new SaveBasketUpsellBottomSheetShownUseCaseImpl_Factory(provider);
    }

    public static SaveBasketUpsellBottomSheetShownUseCaseImpl newInstance(BasketUpsellRepository basketUpsellRepository) {
        return new SaveBasketUpsellBottomSheetShownUseCaseImpl(basketUpsellRepository);
    }

    public SaveBasketUpsellBottomSheetShownUseCaseImpl get() {
        return newInstance(this.basketUpsellRepositoryProvider.get());
    }
}
