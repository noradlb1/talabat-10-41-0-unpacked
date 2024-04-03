package com.checkout.frames.component.expirydate;

import com.checkout.base.mapper.Mapper;
import com.checkout.base.usecase.UseCase;
import com.checkout.frames.component.base.InputComponentState;
import com.checkout.frames.component.expirydate.model.SmartExpiryDateValidationRequest;
import com.checkout.frames.screen.manager.PaymentStateManager;
import com.checkout.frames.style.component.ExpiryDateComponentStyle;
import com.checkout.frames.style.component.base.InputComponentStyle;
import com.checkout.frames.style.view.InputComponentViewStyle;
import com.checkout.validation.model.ValidationResult;
import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import javax.inject.Provider;

@ScopeMetadata
@DaggerGenerated
@QualifierMetadata
/* renamed from: com.checkout.frames.component.expirydate.ExpiryDateViewModel_Factory  reason: case insensitive filesystem */
public final class C0333ExpiryDateViewModel_Factory implements Factory<ExpiryDateViewModel> {
    private final Provider<Mapper<InputComponentStyle, InputComponentState>> inputComponentStateMapperProvider;
    private final Provider<Mapper<InputComponentStyle, InputComponentViewStyle>> inputComponentStyleMapperProvider;
    private final Provider<PaymentStateManager> paymentStateManagerProvider;
    private final Provider<UseCase<SmartExpiryDateValidationRequest, ValidationResult<String>>> smartExpiryDateValidationUseCaseProvider;
    private final Provider<ExpiryDateComponentStyle> styleProvider;

    public C0333ExpiryDateViewModel_Factory(Provider<PaymentStateManager> provider, Provider<UseCase<SmartExpiryDateValidationRequest, ValidationResult<String>>> provider2, Provider<Mapper<InputComponentStyle, InputComponentViewStyle>> provider3, Provider<Mapper<InputComponentStyle, InputComponentState>> provider4, Provider<ExpiryDateComponentStyle> provider5) {
        this.paymentStateManagerProvider = provider;
        this.smartExpiryDateValidationUseCaseProvider = provider2;
        this.inputComponentStyleMapperProvider = provider3;
        this.inputComponentStateMapperProvider = provider4;
        this.styleProvider = provider5;
    }

    public static C0333ExpiryDateViewModel_Factory create(Provider<PaymentStateManager> provider, Provider<UseCase<SmartExpiryDateValidationRequest, ValidationResult<String>>> provider2, Provider<Mapper<InputComponentStyle, InputComponentViewStyle>> provider3, Provider<Mapper<InputComponentStyle, InputComponentState>> provider4, Provider<ExpiryDateComponentStyle> provider5) {
        return new C0333ExpiryDateViewModel_Factory(provider, provider2, provider3, provider4, provider5);
    }

    public static ExpiryDateViewModel newInstance(PaymentStateManager paymentStateManager, UseCase<SmartExpiryDateValidationRequest, ValidationResult<String>> useCase, Mapper<InputComponentStyle, InputComponentViewStyle> mapper, Mapper<InputComponentStyle, InputComponentState> mapper2, ExpiryDateComponentStyle expiryDateComponentStyle) {
        return new ExpiryDateViewModel(paymentStateManager, useCase, mapper, mapper2, expiryDateComponentStyle);
    }

    public ExpiryDateViewModel get() {
        return newInstance(this.paymentStateManagerProvider.get(), this.smartExpiryDateValidationUseCaseProvider.get(), this.inputComponentStyleMapperProvider.get(), this.inputComponentStateMapperProvider.get(), this.styleProvider.get());
    }
}
