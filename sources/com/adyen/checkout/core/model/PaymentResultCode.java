package com.adyen.checkout.core.model;

public enum PaymentResultCode {
    PENDING,
    RECEIVED,
    AUTHORIZED,
    IDENTIFY_SHOPPER,
    CHALLENGE_SHOPPER,
    ERROR,
    REFUSED,
    CANCELLED
}
