package com.checkout.tokenization.usecase;

import com.checkout.base.mapper.Mapper;
import com.checkout.base.model.CardScheme;
import com.checkout.base.usecase.UseCase;
import com.checkout.tokenization.model.Address;
import com.checkout.tokenization.model.Card;
import com.checkout.tokenization.model.ExpiryDate;
import com.checkout.tokenization.model.Phone;
import com.checkout.validation.api.CardValidator;
import com.checkout.validation.model.AddressValidationRequest;
import com.checkout.validation.model.PhoneValidationRequest;
import com.checkout.validation.model.ValidationResult;
import com.checkout.validation.validator.contract.Validator;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\b\u0000\u0018\u00002\u0014\u0012\u0004\u0012\u00020\u0002\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00040\u00030\u0001BI\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0012\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\n0\b\u0012\u0012\u0010\u000b\u001a\u000e\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\r0\b\u0012\u0012\u0010\u000e\u001a\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\t0\u000f¢\u0006\u0002\u0010\u0010J\u0016\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\u0006\u0010\u0012\u001a\u00020\u0002H\u0016J\u0014\u0010\u0013\u001a\u0004\u0018\u00010\t2\b\u0010\u0014\u001a\u0004\u0018\u00010\nH\u0002J\u0014\u0010\u0015\u001a\u0004\u0018\u00010\f2\b\u0010\u0016\u001a\u0004\u0018\u00010\rH\u0002R\u001a\u0010\u000e\u001a\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\t0\u000fX\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\n0\bX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u000b\u001a\u000e\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\r0\bX\u0004¢\u0006\u0002\n\u0000¨\u0006\u0017"}, d2 = {"Lcom/checkout/tokenization/usecase/ValidateTokenizationDataUseCase;", "Lcom/checkout/base/usecase/UseCase;", "Lcom/checkout/tokenization/model/Card;", "Lcom/checkout/validation/model/ValidationResult;", "", "cardValidator", "Lcom/checkout/validation/api/CardValidator;", "addressValidator", "Lcom/checkout/validation/validator/contract/Validator;", "Lcom/checkout/validation/model/AddressValidationRequest;", "Lcom/checkout/tokenization/model/Address;", "phoneValidator", "Lcom/checkout/validation/model/PhoneValidationRequest;", "Lcom/checkout/tokenization/model/Phone;", "addressToAddressValidationRequestDataMapper", "Lcom/checkout/base/mapper/Mapper;", "(Lcom/checkout/validation/api/CardValidator;Lcom/checkout/validation/validator/contract/Validator;Lcom/checkout/validation/validator/contract/Validator;Lcom/checkout/base/mapper/Mapper;)V", "execute", "data", "provideAddressValidationRequest", "address", "providePhoneValidationRequest", "phone", "checkout_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class ValidateTokenizationDataUseCase implements UseCase<Card, ValidationResult<? extends Unit>> {
    @NotNull
    private final Mapper<Address, AddressValidationRequest> addressToAddressValidationRequestDataMapper;
    @NotNull
    private final Validator<AddressValidationRequest, Address> addressValidator;
    @NotNull
    private final CardValidator cardValidator;
    @NotNull
    private final Validator<PhoneValidationRequest, Phone> phoneValidator;

    public ValidateTokenizationDataUseCase(@NotNull CardValidator cardValidator2, @NotNull Validator<AddressValidationRequest, Address> validator, @NotNull Validator<PhoneValidationRequest, Phone> validator2, @NotNull Mapper<Address, AddressValidationRequest> mapper) {
        Intrinsics.checkNotNullParameter(cardValidator2, "cardValidator");
        Intrinsics.checkNotNullParameter(validator, "addressValidator");
        Intrinsics.checkNotNullParameter(validator2, "phoneValidator");
        Intrinsics.checkNotNullParameter(mapper, "addressToAddressValidationRequestDataMapper");
        this.cardValidator = cardValidator2;
        this.addressValidator = validator;
        this.phoneValidator = validator2;
        this.addressToAddressValidationRequestDataMapper = mapper;
    }

    private final AddressValidationRequest provideAddressValidationRequest(Address address) {
        if (address != null) {
            return this.addressToAddressValidationRequestDataMapper.map(address);
        }
        return null;
    }

    private final PhoneValidationRequest providePhoneValidationRequest(Phone phone) {
        if (phone != null) {
            return new PhoneValidationRequest(phone.getNumber(), phone.getCountry());
        }
        return null;
    }

    @NotNull
    public ValidationResult<Unit> execute(@NotNull Card card) {
        Intrinsics.checkNotNullParameter(card, "data");
        ValidationResult<CardScheme> validateCardNumber = this.cardValidator.validateCardNumber(card.getNumber());
        if (validateCardNumber instanceof ValidationResult.Failure) {
            return validateCardNumber;
        }
        if (validateCardNumber instanceof ValidationResult.Success) {
            Object value = ((ValidationResult.Success) validateCardNumber).getValue();
            ValidationResult<ExpiryDate> validateExpiryDate = this.cardValidator.validateExpiryDate(card.getExpiryDate().getExpiryMonth(), card.getExpiryDate().getExpiryYear());
            if (validateExpiryDate instanceof ValidationResult.Failure) {
                return validateExpiryDate;
            }
            CardValidator cardValidator2 = this.cardValidator;
            String cvv = card.getCvv();
            if (cvv == null) {
                cvv = "";
            }
            ValidationResult<Unit> validateCvv = cardValidator2.validateCvv(cvv, (CardScheme) value);
            if (validateCvv instanceof ValidationResult.Failure) {
                String cvv2 = card.getCvv();
                if (!(cvv2 == null || cvv2.length() == 0)) {
                    return validateCvv;
                }
            }
            AddressValidationRequest provideAddressValidationRequest = provideAddressValidationRequest(card.getBillingAddress());
            if (provideAddressValidationRequest != null) {
                ValidationResult<Address> validate = this.addressValidator.validate(provideAddressValidationRequest);
                if (validate instanceof ValidationResult.Failure) {
                    return validate;
                }
            }
            PhoneValidationRequest providePhoneValidationRequest = providePhoneValidationRequest(card.getPhone());
            if (providePhoneValidationRequest != null) {
                ValidationResult<Phone> validate2 = this.phoneValidator.validate(providePhoneValidationRequest);
                if (validate2 instanceof ValidationResult.Failure) {
                    return validate2;
                }
            }
            return new ValidationResult.Success(Unit.INSTANCE);
        }
        throw new NoWhenBranchMatchedException();
    }
}
