package com.checkout.validation.validator.contract;

import com.checkout.validation.model.ValidationResult;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b`\u0018\u0000*\u0004\b\u0000\u0010\u0001*\b\b\u0001\u0010\u0002*\u00020\u00032\u00020\u0003J\u001b\u0010\u0004\u001a\b\u0012\u0004\u0012\u00028\u00010\u00052\u0006\u0010\u0006\u001a\u00028\u0000H&¢\u0006\u0002\u0010\u0007¨\u0006\b"}, d2 = {"Lcom/checkout/validation/validator/contract/Validator;", "D", "T", "", "validate", "Lcom/checkout/validation/model/ValidationResult;", "data", "(Ljava/lang/Object;)Lcom/checkout/validation/model/ValidationResult;", "checkout_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public interface Validator<D, T> {
    @NotNull
    ValidationResult<T> validate(D d11);
}
