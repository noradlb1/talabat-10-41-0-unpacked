package com.checkout;

import com.checkout.logging.EventLoggerProvider;
import com.checkout.logging.Logger;
import com.checkout.validation.api.CardValidator;
import com.checkout.validation.validator.CardDetailsValidator;
import com.checkout.validation.validator.CardNumberValidator;
import com.checkout.validation.validator.CvvValidator;
import com.checkout.validation.validator.ExpiryDateValidator;
import com.checkout.validation.validator.LuhnChecker;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\b\u0010\u0003\u001a\u00020\u0004H\u0007J\r\u0010\u0005\u001a\u00020\u0004H\u0000¢\u0006\u0002\b\u0006¨\u0006\u0007"}, d2 = {"Lcom/checkout/CardValidatorFactory;", "", "()V", "create", "Lcom/checkout/validation/api/CardValidator;", "createInternal", "createInternal$checkout_release", "checkout_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class CardValidatorFactory {
    @NotNull
    public static final CardValidatorFactory INSTANCE = new CardValidatorFactory();

    private CardValidatorFactory() {
    }

    @JvmStatic
    @NotNull
    public static final CardValidator create() {
        return new CardDetailsValidator(new ExpiryDateValidator(), new CvvValidator(), new CardNumberValidator(new LuhnChecker()), EventLoggerProvider.INSTANCE.provide());
    }

    @NotNull
    public final CardValidator createInternal$checkout_release() {
        return new CardDetailsValidator(new ExpiryDateValidator(), new CvvValidator(), new CardNumberValidator(new LuhnChecker()), (Logger) null, 8, (DefaultConstructorMarker) null);
    }
}
