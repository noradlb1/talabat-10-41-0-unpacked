package com.checkout.validation.validator;

import com.checkout.tokenization.model.Phone;
import com.checkout.validation.error.ValidationError;
import com.checkout.validation.model.PhoneValidationRequest;
import com.checkout.validation.model.ValidationResult;
import com.checkout.validation.validator.contract.Validator;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\b\u0000\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001B\u0005¢\u0006\u0002\u0010\u0004J\u0016\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00030\u00062\u0006\u0010\u0007\u001a\u00020\u0002H\u0016J\u0010\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u0003H\u0002¨\u0006\u000b"}, d2 = {"Lcom/checkout/validation/validator/PhoneValidator;", "Lcom/checkout/validation/validator/contract/Validator;", "Lcom/checkout/validation/model/PhoneValidationRequest;", "Lcom/checkout/tokenization/model/Phone;", "()V", "validate", "Lcom/checkout/validation/model/ValidationResult;", "data", "validatePhone", "", "phone", "checkout_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class PhoneValidator implements Validator<PhoneValidationRequest, Phone> {
    private final void validatePhone(Phone phone) throws ValidationError {
        if (phone.getNumber().length() < 6 || phone.getNumber().length() > 25) {
            throw new ValidationError(ValidationError.NUMBER_INCORRECT_LENGTH, "Invalid length of phone number", (Throwable) null, 4, (DefaultConstructorMarker) null);
        }
    }

    @NotNull
    public ValidationResult<Phone> validate(@NotNull PhoneValidationRequest phoneValidationRequest) {
        Intrinsics.checkNotNullParameter(phoneValidationRequest, "data");
        try {
            Phone phone = new Phone(phoneValidationRequest.getNumber(), phoneValidationRequest.getCountry());
            validatePhone(phone);
            return new ValidationResult.Success(phone);
        } catch (ValidationError e11) {
            return new ValidationResult.Failure(e11);
        }
    }
}
