package com.checkout.frames.di.module;

import com.checkout.CardValidatorFactory;
import com.checkout.base.usecase.UseCase;
import com.checkout.frames.component.expirydate.model.SmartExpiryDateValidationRequest;
import com.checkout.frames.component.expirydate.usecase.SmartExpiryDateValidationUseCase;
import com.checkout.frames.di.component.CardNumberViewModelSubComponent;
import com.checkout.frames.di.component.ExpiryDateViewModelSubComponent;
import com.checkout.validation.api.CardValidator;
import com.checkout.validation.model.ValidationResult;
import dagger.Module;
import dagger.Provides;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\b!\u0018\u0000 \u00032\u00020\u0001:\u0001\u0003B\u0005¢\u0006\u0002\u0010\u0002¨\u0006\u0004"}, d2 = {"Lcom/checkout/frames/di/module/ValidationModule;", "", "()V", "Companion", "frames_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
@Module(subcomponents = {CardNumberViewModelSubComponent.class, ExpiryDateViewModelSubComponent.class})
public abstract class ValidationModule {
    @NotNull
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);

    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\b\u0010\u0003\u001a\u00020\u0004H\u0007J\"\u0010\u0005\u001a\u0014\u0012\u0004\u0012\u00020\u0007\u0012\n\u0012\b\u0012\u0004\u0012\u00020\t0\b0\u00062\u0006\u0010\n\u001a\u00020\u0004H\u0007¨\u0006\u000b"}, d2 = {"Lcom/checkout/frames/di/module/ValidationModule$Companion;", "", "()V", "provideCardValidator", "Lcom/checkout/validation/api/CardValidator;", "provideValidateExpiryDateUseCase", "Lcom/checkout/base/usecase/UseCase;", "Lcom/checkout/frames/component/expirydate/model/SmartExpiryDateValidationRequest;", "Lcom/checkout/validation/model/ValidationResult;", "", "cardValidator", "frames_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @NotNull
        @Provides
        public final CardValidator provideCardValidator() {
            return CardValidatorFactory.create();
        }

        @NotNull
        @Provides
        public final UseCase<SmartExpiryDateValidationRequest, ValidationResult<String>> provideValidateExpiryDateUseCase(@NotNull CardValidator cardValidator) {
            Intrinsics.checkNotNullParameter(cardValidator, "cardValidator");
            return new SmartExpiryDateValidationUseCase(cardValidator);
        }
    }
}
