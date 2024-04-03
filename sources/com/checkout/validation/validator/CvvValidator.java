package com.checkout.validation.validator;

import com.checkout.validation.error.ValidationError;
import com.checkout.validation.model.CvvValidationRequest;
import com.checkout.validation.model.ValidationResult;
import com.checkout.validation.validator.contract.Validator;
import java.util.Collection;
import java.util.Iterator;
import java.util.Set;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\"\n\u0002\u0010\b\n\u0000\b\u0000\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001B\u0005¢\u0006\u0002\u0010\u0004J\u0016\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00030\u00062\u0006\u0010\u0007\u001a\u00020\u0002H\u0016J\u001e\u0010\b\u001a\u00020\u00032\u0006\u0010\t\u001a\u00020\n2\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\r0\fH\u0002¨\u0006\u000e"}, d2 = {"Lcom/checkout/validation/validator/CvvValidator;", "Lcom/checkout/validation/validator/contract/Validator;", "Lcom/checkout/validation/model/CvvValidationRequest;", "", "()V", "validate", "Lcom/checkout/validation/model/ValidationResult;", "data", "validateCvv", "cvv", "", "cvvLength", "", "", "checkout_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class CvvValidator implements Validator<CvvValidationRequest, Unit> {
    private final void validateCvv(String str, Set<Integer> set) throws ValidationError {
        boolean z11;
        boolean z12;
        boolean z13 = false;
        int i11 = 0;
        while (true) {
            if (i11 >= str.length()) {
                z11 = false;
                break;
            } else if (!Character.isDigit(str.charAt(i11))) {
                z11 = true;
                break;
            } else {
                i11++;
            }
        }
        if (!z11) {
            if (!(set instanceof Collection) || !set.isEmpty()) {
                Iterator<T> it = set.iterator();
                while (true) {
                    if (it.hasNext()) {
                        if (((Number) it.next()).intValue() == str.length()) {
                            z12 = true;
                            continue;
                        } else {
                            z12 = false;
                            continue;
                        }
                        if (z12) {
                            z13 = true;
                            break;
                        }
                    } else {
                        break;
                    }
                }
            }
            if (!z13) {
                if (str.length() < ((Number) CollectionsKt___CollectionsKt.minOrThrow((Iterable<Double>) set)).intValue() || str.length() < ((Number) CollectionsKt___CollectionsKt.maxOrThrow((Iterable<Double>) set)).intValue()) {
                    throw new ValidationError(ValidationError.CVV_INCOMPLETE_LENGTH, "Incomplete CVV length, it should be " + set, (Throwable) null, 4, (DefaultConstructorMarker) null);
                }
                throw new ValidationError(ValidationError.CVV_INVALID_LENGTH, "Invalid CVV length, it should be " + set, (Throwable) null, 4, (DefaultConstructorMarker) null);
            }
            return;
        }
        throw new ValidationError(ValidationError.CVV_CONTAINS_NON_DIGITS, "CVV should contain only digits", (Throwable) null, 4, (DefaultConstructorMarker) null);
    }

    @NotNull
    public ValidationResult<Unit> validate(@NotNull CvvValidationRequest cvvValidationRequest) {
        Intrinsics.checkNotNullParameter(cvvValidationRequest, "data");
        try {
            validateCvv(cvvValidationRequest.getCvv(), cvvValidationRequest.getCardScheme().getCvvLength());
            return new ValidationResult.Success(Unit.INSTANCE);
        } catch (ValidationError e11) {
            return new ValidationResult.Failure(e11);
        }
    }
}
