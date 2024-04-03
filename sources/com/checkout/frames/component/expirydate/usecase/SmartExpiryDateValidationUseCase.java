package com.checkout.frames.component.expirydate.usecase;

import com.checkout.base.usecase.UseCase;
import com.checkout.frames.component.expirydate.model.SmartExpiryDateValidationRequest;
import com.checkout.frames.utils.extensions.ValidationResultExtensionsKt;
import com.checkout.tokenization.model.ExpiryDate;
import com.checkout.validation.api.CardValidator;
import com.checkout.validation.model.ValidationResult;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\b\u0000\u0018\u00002\u0014\u0012\u0004\u0012\u00020\u0002\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00040\u00030\u0001B\r\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0002\u0010\u0007J\u0016\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\u0006\u0010\t\u001a\u00020\u0002H\u0016J\u001e\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\u0006\u0010\u000b\u001a\u00020\u00042\u0006\u0010\f\u001a\u00020\rH\u0002J\u001e\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\u0006\u0010\u000b\u001a\u00020\u00042\u0006\u0010\f\u001a\u00020\rH\u0002J\u0014\u0010\u000f\u001a\u00020\u0004*\u00020\u00042\u0006\u0010\u0010\u001a\u00020\u0011H\u0002R\u000e\u0010\u0005\u001a\u00020\u0006X\u0004¢\u0006\u0002\n\u0000¨\u0006\u0012"}, d2 = {"Lcom/checkout/frames/component/expirydate/usecase/SmartExpiryDateValidationUseCase;", "Lcom/checkout/base/usecase/UseCase;", "Lcom/checkout/frames/component/expirydate/model/SmartExpiryDateValidationRequest;", "Lcom/checkout/validation/model/ValidationResult;", "", "cardValidator", "Lcom/checkout/validation/api/CardValidator;", "(Lcom/checkout/validation/api/CardValidator;)V", "execute", "data", "validateExpiryDate", "date", "isZeroPrefixExist", "", "validateFocusedExpiryDate", "dropSafe", "n", "", "frames_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class SmartExpiryDateValidationUseCase implements UseCase<SmartExpiryDateValidationRequest, ValidationResult<? extends String>> {
    @NotNull
    private final CardValidator cardValidator;

    public SmartExpiryDateValidationUseCase(@NotNull CardValidator cardValidator2) {
        Intrinsics.checkNotNullParameter(cardValidator2, "cardValidator");
        this.cardValidator = cardValidator2;
    }

    private final String dropSafe(String str, int i11) {
        try {
            return StringsKt___StringsKt.drop(str, i11);
        } catch (StringIndexOutOfBoundsException unused) {
            return "0";
        }
    }

    private final ValidationResult<String> validateExpiryDate(String str, boolean z11) {
        String str2;
        String str3;
        if (z11) {
            str2 = "0" + StringsKt___StringsKt.take(str, 1);
        } else {
            str2 = StringsKt___StringsKt.take(str, 2);
        }
        if (z11) {
            str3 = dropSafe(str, 1);
        } else {
            str3 = dropSafe(str, 2);
        }
        ValidationResult<ExpiryDate> validateExpiryDate = this.cardValidator.validateExpiryDate(str2, str3);
        if (validateExpiryDate instanceof ValidationResult.Success) {
            return new ValidationResult.Success(str);
        }
        if (validateExpiryDate instanceof ValidationResult.Failure) {
            return validateExpiryDate;
        }
        throw new NoWhenBranchMatchedException();
    }

    private final ValidationResult<String> validateFocusedExpiryDate(String str, boolean z11) {
        ValidationResult<String> validateExpiryDate = validateExpiryDate(str, z11);
        if (ValidationResultExtensionsKt.isDateInThePastError(validateExpiryDate)) {
            return validateExpiryDate;
        }
        return new ValidationResult.Success(str);
    }

    @NotNull
    public ValidationResult<String> execute(@NotNull SmartExpiryDateValidationRequest smartExpiryDateValidationRequest) {
        Intrinsics.checkNotNullParameter(smartExpiryDateValidationRequest, "data");
        boolean z11 = true;
        if (!(smartExpiryDateValidationRequest.getInputExpiryDate().length() > 0) || Intrinsics.compare((int) smartExpiryDateValidationRequest.getInputExpiryDate().charAt(0), 49) <= 0) {
            z11 = false;
        }
        if (smartExpiryDateValidationRequest.isFocused()) {
            return validateFocusedExpiryDate(smartExpiryDateValidationRequest.getInputExpiryDate(), z11);
        }
        return validateExpiryDate(smartExpiryDateValidationRequest.getInputExpiryDate(), z11);
    }
}
