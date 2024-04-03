package com.talabat.darkstores.di;

import com.talabat.darkstores.domain.basket.SaveBasketUpsellBottomSheetShownUseCase;
import com.talabat.darkstores.domain.basket.SaveBasketUpsellBottomSheetShownUseCaseImpl;
import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import javax.inject.Provider;

@ScopeMetadata
@DaggerGenerated
@QualifierMetadata
public final class DarkstoreBasketUpsellModule_ProvidesSaveBasketUpsellBottomSheetShownUseCaseFactory implements Factory<SaveBasketUpsellBottomSheetShownUseCase> {
    private final Provider<SaveBasketUpsellBottomSheetShownUseCaseImpl> implProvider;

    public DarkstoreBasketUpsellModule_ProvidesSaveBasketUpsellBottomSheetShownUseCaseFactory(Provider<SaveBasketUpsellBottomSheetShownUseCaseImpl> provider) {
        this.implProvider = provider;
    }

    public static DarkstoreBasketUpsellModule_ProvidesSaveBasketUpsellBottomSheetShownUseCaseFactory create(Provider<SaveBasketUpsellBottomSheetShownUseCaseImpl> provider) {
        return new DarkstoreBasketUpsellModule_ProvidesSaveBasketUpsellBottomSheetShownUseCaseFactory(provider);
    }

    public static SaveBasketUpsellBottomSheetShownUseCase providesSaveBasketUpsellBottomSheetShownUseCase(SaveBasketUpsellBottomSheetShownUseCaseImpl saveBasketUpsellBottomSheetShownUseCaseImpl) {
        return (SaveBasketUpsellBottomSheetShownUseCase) Preconditions.checkNotNullFromProvides(DarkstoreBasketUpsellModule.INSTANCE.providesSaveBasketUpsellBottomSheetShownUseCase(saveBasketUpsellBottomSheetShownUseCaseImpl));
    }

    public SaveBasketUpsellBottomSheetShownUseCase get() {
        return providesSaveBasketUpsellBottomSheetShownUseCase(this.implProvider.get());
    }
}
