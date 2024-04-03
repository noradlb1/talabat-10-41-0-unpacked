package com.checkout.validation.validator;

import com.checkout.tokenization.model.ExpiryDate;
import com.checkout.validation.error.ValidationError;
import com.checkout.validation.model.ExpiryDateValidationRequest;
import com.checkout.validation.model.ValidationResult;
import com.checkout.validation.validator.contract.Validator;
import java.util.Calendar;
import java.util.Date;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.IntRange;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\b\u0000\u0018\u0000 \u00122\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001:\u0001\u0012B\u0005¢\u0006\u0002\u0010\u0004J\u001a\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\b\b\u0002\u0010\t\u001a\u00020\nH\u0002J\u0010\u0010\u000b\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0002J\u0016\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u00030\r2\u0006\u0010\u000e\u001a\u00020\u0002H\u0016J\u001a\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00032\b\b\u0002\u0010\t\u001a\u00020\nH\u0002¨\u0006\u0013"}, d2 = {"Lcom/checkout/validation/validator/ExpiryDateValidator;", "Lcom/checkout/validation/validator/contract/Validator;", "Lcom/checkout/validation/model/ExpiryDateValidationRequest;", "Lcom/checkout/tokenization/model/ExpiryDate;", "()V", "provideValidated4DigitYear", "", "value", "", "date", "Ljava/util/Date;", "provideValidatedMonth", "validate", "Lcom/checkout/validation/model/ValidationResult;", "data", "validateExpiryDate", "", "expiryDate", "Companion", "checkout_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class ExpiryDateValidator implements Validator<ExpiryDateValidationRequest, ExpiryDate> {
    @NotNull
    private static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    /* access modifiers changed from: private */
    @NotNull
    @Deprecated
    public static final IntRange MONTH_RANGE = new IntRange(1, 12);
    @Deprecated
    public static final int YEAR_LONG_DELTA = 2000;
    @Deprecated
    public static final int YEAR_LONG_FORMAT = 4;
    @Deprecated
    public static final int YEAR_SHORT_FORMAT = 2;

    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006R\u000e\u0010\u0007\u001a\u00020\bXT¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\bXT¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\bXT¢\u0006\u0002\n\u0000¨\u0006\u000b"}, d2 = {"Lcom/checkout/validation/validator/ExpiryDateValidator$Companion;", "", "()V", "MONTH_RANGE", "Lkotlin/ranges/IntRange;", "getMONTH_RANGE", "()Lkotlin/ranges/IntRange;", "YEAR_LONG_DELTA", "", "YEAR_LONG_FORMAT", "YEAR_SHORT_FORMAT", "checkout_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @NotNull
        public final IntRange getMONTH_RANGE() {
            return ExpiryDateValidator.MONTH_RANGE;
        }
    }

    private final int provideValidated4DigitYear(String str, Date date) throws ValidationError {
        Calendar instance = Calendar.getInstance();
        instance.setTime(date);
        String takeLast = StringsKt___StringsKt.takeLast(String.valueOf(instance.get(1)), 2);
        Integer intOrNull = StringsKt__StringNumberConversionsKt.toIntOrNull(str);
        if (intOrNull == null) {
            throw new ValidationError(ValidationError.INVALID_YEAR_STRING, "Invalid value provided for year: " + str, (Throwable) null, 4, (DefaultConstructorMarker) null);
        } else if (intOrNull.intValue() < 0) {
            throw new ValidationError(ValidationError.INVALID_YEAR, "Year cannot be a negative value: " + str, (Throwable) null, 4, (DefaultConstructorMarker) null);
        } else if ((str.length() == 1 && Intrinsics.compare((int) StringsKt___StringsKt.first(str), (int) StringsKt___StringsKt.first(takeLast)) < 0) || str.length() == 2) {
            return intOrNull.intValue() + 2000;
        } else {
            if (str.length() == 4) {
                return intOrNull.intValue();
            }
            throw new ValidationError(ValidationError.INVALID_YEAR, "Unexpected year value detected: " + str, (Throwable) null, 4, (DefaultConstructorMarker) null);
        }
    }

    public static /* synthetic */ int provideValidated4DigitYear$default(ExpiryDateValidator expiryDateValidator, String str, Date date, int i11, Object obj) throws ValidationError {
        if ((i11 & 2) != 0) {
            date = new Date();
        }
        return expiryDateValidator.provideValidated4DigitYear(str, date);
    }

    private final int provideValidatedMonth(String str) throws ValidationError {
        Integer intOrNull = StringsKt__StringNumberConversionsKt.toIntOrNull(str);
        if (intOrNull != null) {
            IntRange intRange = MONTH_RANGE;
            if (intRange.contains(intOrNull.intValue())) {
                return intOrNull.intValue();
            }
            int first = intRange.getFirst();
            int last = intRange.getLast();
            throw new ValidationError(ValidationError.INVALID_MONTH, "Month must be >= " + first + " && <= " + last, (Throwable) null, 4, (DefaultConstructorMarker) null);
        }
        throw new ValidationError(ValidationError.INVALID_MONTH_STRING, "Invalid value provided for month: " + intOrNull, (Throwable) null, 4, (DefaultConstructorMarker) null);
    }

    private final void validateExpiryDate(ExpiryDate expiryDate, Date date) throws ValidationError {
        int component1 = expiryDate.component1();
        int component2 = expiryDate.component2();
        Calendar instance = Calendar.getInstance();
        instance.setTime(date);
        int i11 = instance.get(1);
        int i12 = instance.get(2) + 1;
        if (component2 < i11 || (component2 == i11 && component1 < i12)) {
            throw new ValidationError(ValidationError.EXPIRY_DATE_IN_PAST, "Expiry month " + component1 + " & year " + component2 + " should be in the future", (Throwable) null, 4, (DefaultConstructorMarker) null);
        }
    }

    public static /* synthetic */ void validateExpiryDate$default(ExpiryDateValidator expiryDateValidator, ExpiryDate expiryDate, Date date, int i11, Object obj) throws ValidationError {
        if ((i11 & 2) != 0) {
            date = new Date();
        }
        expiryDateValidator.validateExpiryDate(expiryDate, date);
    }

    @NotNull
    public ValidationResult<ExpiryDate> validate(@NotNull ExpiryDateValidationRequest expiryDateValidationRequest) {
        Intrinsics.checkNotNullParameter(expiryDateValidationRequest, "data");
        try {
            ExpiryDate expiryDate = new ExpiryDate(provideValidatedMonth(expiryDateValidationRequest.getExpiryMonth()), provideValidated4DigitYear$default(this, expiryDateValidationRequest.getExpiryYear(), (Date) null, 2, (Object) null));
            validateExpiryDate$default(this, expiryDate, (Date) null, 2, (Object) null);
            return new ValidationResult.Success(expiryDate);
        } catch (ValidationError e11) {
            return new ValidationResult.Failure(e11);
        }
    }
}
