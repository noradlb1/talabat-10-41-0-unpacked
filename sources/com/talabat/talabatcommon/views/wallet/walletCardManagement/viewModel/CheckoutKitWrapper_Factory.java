package com.talabat.talabatcommon.views.wallet.walletCardManagement.viewModel;

import com.talabat.feature.tokenization.domain.usecase.GenerateCardTokenUseCase;
import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import javax.inject.Provider;

@ScopeMetadata
@DaggerGenerated
@QualifierMetadata
public final class CheckoutKitWrapper_Factory implements Factory<CheckoutKitWrapper> {
    private final Provider<GenerateCardTokenUseCase> generateCardTokenUseCaseProvider;

    public CheckoutKitWrapper_Factory(Provider<GenerateCardTokenUseCase> provider) {
        this.generateCardTokenUseCaseProvider = provider;
    }

    public static CheckoutKitWrapper_Factory create(Provider<GenerateCardTokenUseCase> provider) {
        return new CheckoutKitWrapper_Factory(provider);
    }

    public static CheckoutKitWrapper newInstance(GenerateCardTokenUseCase generateCardTokenUseCase) {
        return new CheckoutKitWrapper(generateCardTokenUseCase);
    }

    public CheckoutKitWrapper get() {
        return newInstance(this.generateCardTokenUseCaseProvider.get());
    }
}
