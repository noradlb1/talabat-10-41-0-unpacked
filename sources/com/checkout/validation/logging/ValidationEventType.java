package com.checkout.validation.logging;

import com.checkout.logging.LoggingEventType;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\n\b\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u00012\u00020\u0002B\u000f\b\u0002\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005R\u0014\u0010\u0003\u001a\u00020\u0004X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\r¨\u0006\u000e"}, d2 = {"Lcom/checkout/validation/logging/ValidationEventType;", "", "Lcom/checkout/logging/LoggingEventType;", "eventId", "", "(Ljava/lang/String;ILjava/lang/String;)V", "getEventId", "()Ljava/lang/String;", "INITIALIZE", "VALIDATE_CARD_NUMBER", "VALIDATE_CARD_NUMBER_EAGER", "VALIDATE_EXPIRY_DATE_STRING", "VALIDATE_EXPIRY_DATE_INT", "VALIDATE_CVV", "checkout_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public enum ValidationEventType implements LoggingEventType {
    INITIALIZE("card_validator"),
    VALIDATE_CARD_NUMBER("card_validator_card_number"),
    VALIDATE_CARD_NUMBER_EAGER("card_validator_card_number_eager"),
    VALIDATE_EXPIRY_DATE_STRING("card_validator_expiry_string"),
    VALIDATE_EXPIRY_DATE_INT("card_validator_expiry_integer"),
    VALIDATE_CVV("card_validator_cvv");
    
    @NotNull
    private final String eventId;

    private ValidationEventType(String str) {
        this.eventId = str;
    }

    @NotNull
    public String getEventId() {
        return this.eventId;
    }
}
