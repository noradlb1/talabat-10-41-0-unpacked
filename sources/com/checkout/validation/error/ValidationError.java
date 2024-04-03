package com.checkout.validation.error;

import androidx.annotation.RestrictTo;
import com.checkout.base.error.CheckoutError;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0003\n\u0002\b\u0003\b\u0007\u0018\u0000 \b2\u00020\u0001:\u0001\bB%\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\u0002\u0010\u0007¨\u0006\t"}, d2 = {"Lcom/checkout/validation/error/ValidationError;", "Lcom/checkout/base/error/CheckoutError;", "errorCode", "", "message", "throwable", "", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V", "Companion", "checkout_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
public final class ValidationError extends CheckoutError {
    @NotNull
    public static final String ADDRESS_LINE1_INCORRECT_LENGTH = "ValidationError:1012";
    @NotNull
    public static final String ADDRESS_LINE2_INCORRECT_LENGTH = "ValidationError:1013";
    @NotNull
    public static final String CARD_NUMBER_INVALID_CHARACTERS = "ValidationError:1001";
    @NotNull
    public static final String CARD_NUMBER_LUHN_CHECK_ERROR = "ValidationError:1023";
    @NotNull
    public static final String CARD_NUMBER_SCHEME_UNRECOGNIZED = "ValidationError:1024";
    @NotNull
    public static final String CVV_CONTAINS_NON_DIGITS = "ValidationError:1002";
    @NotNull
    public static final String CVV_INCOMPLETE_LENGTH = "ValidationError:1022";
    @NotNull
    public static final String CVV_INVALID_LENGTH = "ValidationError:1003";
    @NotNull
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    @NotNull
    public static final String EXPIRY_DATE_IN_PAST = "ValidationError:1011";
    @NotNull
    public static final String INVALID_CITY_LENGTH = "ValidationError:1014";
    @NotNull
    public static final String INVALID_COUNTRY = "ValidationError:1015";
    @NotNull
    public static final String INVALID_MONTH = "ValidationError:1007";
    @NotNull
    public static final String INVALID_MONTH_STRING = "ValidationError:1005";
    @NotNull
    public static final String INVALID_STATE_LENGTH = "ValidationError:1016";
    @NotNull
    public static final String INVALID_YEAR = "ValidationError:1008";
    @NotNull
    public static final String INVALID_YEAR_STRING = "ValidationError:1006";
    @NotNull
    public static final String INVALID_ZIP_LENGTH = "ValidationError:1017";
    @NotNull
    public static final String NUMBER_INCORRECT_LENGTH = "ValidationError:1018";
    @NotNull
    public static final String UNEXPECTED_VALIDATION_ERROR = "ValidationError:1000";

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0013\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0017"}, d2 = {"Lcom/checkout/validation/error/ValidationError$Companion;", "", "()V", "ADDRESS_LINE1_INCORRECT_LENGTH", "", "ADDRESS_LINE2_INCORRECT_LENGTH", "CARD_NUMBER_INVALID_CHARACTERS", "CARD_NUMBER_LUHN_CHECK_ERROR", "CARD_NUMBER_SCHEME_UNRECOGNIZED", "CVV_CONTAINS_NON_DIGITS", "CVV_INCOMPLETE_LENGTH", "CVV_INVALID_LENGTH", "EXPIRY_DATE_IN_PAST", "INVALID_CITY_LENGTH", "INVALID_COUNTRY", "INVALID_MONTH", "INVALID_MONTH_STRING", "INVALID_STATE_LENGTH", "INVALID_YEAR", "INVALID_YEAR_STRING", "INVALID_ZIP_LENGTH", "NUMBER_INCORRECT_LENGTH", "UNEXPECTED_VALIDATION_ERROR", "checkout_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ ValidationError(String str, String str2, Throwable th2, int i11, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, (i11 & 2) != 0 ? null : str2, (i11 & 4) != 0 ? null : th2);
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public ValidationError(@NotNull String str, @Nullable String str2, @Nullable Throwable th2) {
        super(str, str2, th2);
        Intrinsics.checkNotNullParameter(str, "errorCode");
    }
}
