package com.checkout.validation.validator;

import com.checkout.tokenization.mapper.request.AddressValidationRequestToAddressDataMapper;
import com.checkout.tokenization.model.Address;
import com.checkout.validation.error.ValidationError;
import com.checkout.validation.model.AddressValidationRequest;
import com.checkout.validation.model.ValidationResult;
import com.checkout.validation.validator.contract.Validator;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\b\u0000\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001B\u0005¢\u0006\u0002\u0010\u0004J\u0016\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00030\u00062\u0006\u0010\u0007\u001a\u00020\u0002H\u0016J\u0010\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u0003H\u0002¨\u0006\u000b"}, d2 = {"Lcom/checkout/validation/validator/AddressValidator;", "Lcom/checkout/validation/validator/contract/Validator;", "Lcom/checkout/validation/model/AddressValidationRequest;", "Lcom/checkout/tokenization/model/Address;", "()V", "validate", "Lcom/checkout/validation/model/ValidationResult;", "data", "validateAddress", "", "address", "checkout_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class AddressValidator implements Validator<AddressValidationRequest, Address> {
    private final void validateAddress(Address address) throws ValidationError {
        if (address.getAddressLine1().length() > 200) {
            throw new ValidationError(ValidationError.ADDRESS_LINE1_INCORRECT_LENGTH, "Address line 1 exceeding minimum length of characters", (Throwable) null, 4, (DefaultConstructorMarker) null);
        } else if (address.getAddressLine2().length() > 200) {
            throw new ValidationError(ValidationError.ADDRESS_LINE2_INCORRECT_LENGTH, "Address line 2 exceeding minimum length of characters", (Throwable) null, 4, (DefaultConstructorMarker) null);
        } else if (address.getCity().length() > 50) {
            throw new ValidationError(ValidationError.INVALID_CITY_LENGTH, "City exceeding minimum length of characters", (Throwable) null, 4, (DefaultConstructorMarker) null);
        } else if (address.getState().length() > 50) {
            throw new ValidationError(ValidationError.INVALID_STATE_LENGTH, "State exceeding minimum length of characters", (Throwable) null, 4, (DefaultConstructorMarker) null);
        } else if (address.getZip().length() > 50) {
            throw new ValidationError(ValidationError.INVALID_ZIP_LENGTH, "Zipcode exceeding minimum length of characters", (Throwable) null, 4, (DefaultConstructorMarker) null);
        } else if (StringsKt__StringsJVMKt.isBlank(address.getCountry().getIso3166Alpha2())) {
            throw new ValidationError(ValidationError.INVALID_COUNTRY, "Invalid country found", (Throwable) null, 4, (DefaultConstructorMarker) null);
        }
    }

    @NotNull
    public ValidationResult<Address> validate(@NotNull AddressValidationRequest addressValidationRequest) {
        Intrinsics.checkNotNullParameter(addressValidationRequest, "data");
        try {
            Address map = new AddressValidationRequestToAddressDataMapper().map(addressValidationRequest);
            validateAddress(map);
            return new ValidationResult.Success(map);
        } catch (ValidationError e11) {
            return new ValidationResult.Failure(e11);
        }
    }
}
