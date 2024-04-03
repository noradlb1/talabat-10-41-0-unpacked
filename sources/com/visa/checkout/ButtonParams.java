package com.visa.checkout;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@Deprecated
public class ButtonParams {

    @Deprecated
    @Retention(RetentionPolicy.SOURCE)
    public @interface ButtonColor {
        public static final String NEUTRAL = "NEUTRAL";
        public static final String STANDARD = "STANDARD";
    }
}
