package com.checkout.validation.error;

import com.checkout.base.util.ExceptionExtensionsKt;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\u0018\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\u001a(\u0010\u0000\u001a\u00020\u0001*\u00060\u0002j\u0002`\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0005H\u0000¨\u0006\u0007"}, d2 = {"asValidationError", "Lcom/checkout/validation/error/ValidationError;", "Ljava/lang/Exception;", "Lkotlin/Exception;", "errorCode", "", "message", "checkout_release"}, k = 2, mv = {1, 7, 1}, xi = 48)
public final class ValidationErrorKt {
    @NotNull
    public static final ValidationError asValidationError(@NotNull Exception exc, @Nullable String str, @Nullable String str2) {
        Intrinsics.checkNotNullParameter(exc, "<this>");
        if (!ExceptionExtensionsKt.getCanBeCaught(exc)) {
            throw exc;
        } else if (exc instanceof ValidationError) {
            return (ValidationError) exc;
        } else {
            if (str == null) {
                str = ValidationError.UNEXPECTED_VALIDATION_ERROR;
            }
            return new ValidationError(str, str2, exc);
        }
    }

    public static /* synthetic */ ValidationError asValidationError$default(Exception exc, String str, String str2, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            str = null;
        }
        if ((i11 & 2) != 0) {
            str2 = null;
        }
        return asValidationError(exc, str, str2);
    }
}
