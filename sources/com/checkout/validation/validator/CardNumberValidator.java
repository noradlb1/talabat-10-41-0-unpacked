package com.checkout.validation.validator;

import com.checkout.base.model.CardScheme;
import com.checkout.validation.error.ValidationError;
import com.checkout.validation.model.CardNumberValidationRequest;
import com.checkout.validation.model.ValidationResult;
import com.checkout.validation.validator.contract.Checker;
import com.checkout.validation.validator.contract.Validator;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Regex;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0000\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001B\u0013\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\u0002\u0010\u0007J\u0018\u0010\b\u001a\u00020\u00032\u0006\u0010\t\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\u000bH\u0002J\u0016\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u00030\r2\u0006\u0010\u000e\u001a\u00020\u0002H\u0016J\u0010\u0010\f\u001a\u00020\u00032\u0006\u0010\t\u001a\u00020\u0006H\u0002J\u0010\u0010\u000f\u001a\u00020\u00032\u0006\u0010\t\u001a\u00020\u0006H\u0002R\u0014\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005X\u0004¢\u0006\u0002\n\u0000¨\u0006\u0010"}, d2 = {"Lcom/checkout/validation/validator/CardNumberValidator;", "Lcom/checkout/validation/validator/contract/Validator;", "Lcom/checkout/validation/model/CardNumberValidationRequest;", "Lcom/checkout/base/model/CardScheme;", "checker", "Lcom/checkout/validation/validator/contract/Checker;", "", "(Lcom/checkout/validation/validator/contract/Checker;)V", "provideCardScheme", "cardNumber", "isEager", "", "validate", "Lcom/checkout/validation/model/ValidationResult;", "data", "validateEager", "checkout_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class CardNumberValidator implements Validator<CardNumberValidationRequest, CardScheme> {
    @NotNull
    private final Checker<String> checker;

    public CardNumberValidator(@NotNull Checker<String> checker2) {
        Intrinsics.checkNotNullParameter(checker2, "checker");
        this.checker = checker2;
    }

    private final CardScheme provideCardScheme(String str, boolean z11) throws ValidationError {
        boolean z12;
        Regex regex;
        int i11 = 0;
        while (true) {
            if (i11 >= str.length()) {
                z12 = false;
                break;
            }
            z12 = true;
            if (!Character.isDigit(str.charAt(i11))) {
                break;
            }
            i11++;
        }
        if (!z12) {
            for (CardScheme cardScheme : CardScheme.values()) {
                if (z11) {
                    regex = cardScheme.getEagerRegex$checkout_release();
                } else {
                    regex = cardScheme.getRegex$checkout_release();
                }
                if (regex.matches(str)) {
                    return cardScheme;
                }
            }
            return CardScheme.UNKNOWN;
        }
        throw new ValidationError(ValidationError.CARD_NUMBER_INVALID_CHARACTERS, "Card number should contain only digits", (Throwable) null, 4, (DefaultConstructorMarker) null);
    }

    private final CardScheme validateEager(String str) throws ValidationError {
        return provideCardScheme(str, true);
    }

    @NotNull
    public ValidationResult<CardScheme> validate(@NotNull CardNumberValidationRequest cardNumberValidationRequest) {
        Intrinsics.checkNotNullParameter(cardNumberValidationRequest, "data");
        try {
            String replace = new Regex("\\s").replace((CharSequence) cardNumberValidationRequest.getCardNumber(), "");
            return new ValidationResult.Success(cardNumberValidationRequest.isEagerValidation() ? validateEager(replace) : validate(replace));
        } catch (ValidationError e11) {
            return new ValidationResult.Failure(e11);
        }
    }

    private final CardScheme validate(String str) throws ValidationError {
        CardScheme provideCardScheme = provideCardScheme(str, false);
        if (provideCardScheme == CardScheme.UNKNOWN) {
            throw new ValidationError(ValidationError.CARD_NUMBER_SCHEME_UNRECOGNIZED, "Card scheme not recognized", (Throwable) null, 4, (DefaultConstructorMarker) null);
        } else if (this.checker.check(str)) {
            return provideCardScheme;
        } else {
            throw new ValidationError(ValidationError.CARD_NUMBER_LUHN_CHECK_ERROR, "Card number Luhn check error", (Throwable) null, 4, (DefaultConstructorMarker) null);
        }
    }
}
