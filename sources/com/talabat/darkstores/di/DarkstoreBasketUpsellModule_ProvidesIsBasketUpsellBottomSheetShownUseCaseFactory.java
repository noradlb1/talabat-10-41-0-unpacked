package com.talabat.darkstores.di;

import com.talabat.darkstores.domain.basket.IsBasketUpsellBottomSheetShownUseCase;
import com.talabat.darkstores.domain.basket.IsBasketUpsellBottomSheetShownUseCaseImpl;
import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import javax.inject.Provider;

@ScopeMetadata
@DaggerGenerated
@QualifierMetadata
public final class DarkstoreBasketUpsellModule_ProvidesIsBasketUpsellBottomSheetShownUseCaseFactory implements Factory<IsBasketUpsellBottomSheetShownUseCase> {
    private final Provider<IsBasketUpsellBottomSheetShownUseCaseImpl> implProvider;

    public DarkstoreBasketUpsellModule_ProvidesIsBasketUpsellBottomSheetShownUseCaseFactory(Provider<IsBasketUpsellBottomSheetShownUseCaseImpl> provider) {
        this.implProvider = provider;
    }

    public static DarkstoreBasketUpsellModule_ProvidesIsBasketUpsellBottomSheetShownUseCaseFactory create(Provider<IsBasketUpsellBottomSheetShownUseCaseImpl> provider) {
        return new DarkstoreBasketUpsellModule_ProvidesIsBasketUpsellBottomSheetShownUseCaseFactory(provider);
    }

    public static IsBasketUpsellBottomSheetShownUseCase providesIsBasketUpsellBottomSheetShownUseCase(IsBasketUpsellBottomSheetShownUseCaseImpl isBasketUpsellBottomSheetShownUseCaseImpl) {
        return (IsBasketUpsellBottomSheetShownUseCase) Preconditions.checkNotNullFromProvides(DarkstoreBasketUpsellModule.INSTANCE.providesIsBasketUpsellBottomSheetShownUseCase(isBasketUpsellBottomSheetShownUseCaseImpl));
    }

    public IsBasketUpsellBottomSheetShownUseCase get() {
        return providesIsBasketUpsellBottomSheetShownUseCase(this.implProvider.get());
    }
}
