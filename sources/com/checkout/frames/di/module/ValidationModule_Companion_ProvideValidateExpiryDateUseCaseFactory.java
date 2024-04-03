package com.checkout.frames.di.module;

import com.checkout.base.usecase.UseCase;
import com.checkout.frames.component.expirydate.model.SmartExpiryDateValidationRequest;
import com.checkout.validation.api.CardValidator;
import com.checkout.validation.model.ValidationResult;
import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import javax.inject.Provider;

@ScopeMetadata
@DaggerGenerated
@QualifierMetadata
public final class ValidationModule_Companion_ProvideValidateExpiryDateUseCaseFactory implements Factory<UseCase<SmartExpiryDateValidationRequest, ValidationResult<String>>> {
    private final Provider<CardValidator> cardValidatorProvider;

    public ValidationModule_Companion_ProvideValidateExpiryDateUseCaseFactory(Provider<CardValidator> provider) {
        this.cardValidatorProvider = provider;
    }

    public static ValidationModule_Companion_ProvideValidateExpiryDateUseCaseFactory create(Provider<CardValidator> provider) {
        return new ValidationModule_Companion_ProvideValidateExpiryDateUseCaseFactory(provider);
    }

    public static UseCase<SmartExpiryDateValidationRequest, ValidationResult<String>> provideValidateExpiryDateUseCase(CardValidator cardValidator) {
        return (UseCase) Preconditions.checkNotNullFromProvides(ValidationModule.Companion.provideValidateExpiryDateUseCase(cardValidator));
    }

    public UseCase<SmartExpiryDateValidationRequest, ValidationResult<String>> get() {
        return provideValidateExpiryDateUseCase(this.cardValidatorProvider.get());
    }
}
