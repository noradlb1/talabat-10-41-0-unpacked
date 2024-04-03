package com.visa.checkout;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@Retention(RetentionPolicy.SOURCE)
public @interface Environment {
    public static final String PRODUCTION = "https://secure.checkout.visa.com";
    public static final String SANDBOX = "https://sandbox.secure.checkout.visa.com";
}
