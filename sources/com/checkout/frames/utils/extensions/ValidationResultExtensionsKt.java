package com.checkout.frames.utils.extensions;

import com.checkout.base.error.CheckoutError;
import com.checkout.validation.error.ValidationError;
import com.checkout.validation.model.ValidationResult;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u0012\n\u0000\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\u001a\u0012\u0010\u0000\u001a\u00020\u0001*\b\u0012\u0004\u0012\u00020\u00030\u0002H\u0000\u001a\u0012\u0010\u0004\u001a\u00020\u0001*\b\u0012\u0004\u0012\u00020\u00030\u0002H\u0000¨\u0006\u0005"}, d2 = {"isDateInThePastError", "", "Lcom/checkout/validation/model/ValidationResult;", "", "isValid", "frames_release"}, k = 2, mv = {1, 7, 1}, xi = 48)
public final class ValidationResultExtensionsKt {
    public static final boolean isDateInThePastError(@NotNull ValidationResult<? extends Object> validationResult) {
        ValidationResult.Failure failure;
        CheckoutError error;
        Intrinsics.checkNotNullParameter(validationResult, "<this>");
        String str = null;
        if (validationResult instanceof ValidationResult.Failure) {
            failure = (ValidationResult.Failure) validationResult;
        } else {
            failure = null;
        }
        if (!(failure == null || (error = failure.getError()) == null)) {
            str = error.getErrorCode();
        }
        return Intrinsics.areEqual((Object) str, (Object) ValidationError.EXPIRY_DATE_IN_PAST);
    }

    public static final boolean isValid(@NotNull ValidationResult<? extends Object> validationResult) {
        Intrinsics.checkNotNullParameter(validationResult, "<this>");
        return validationResult instanceof ValidationResult.Success;
    }
}
