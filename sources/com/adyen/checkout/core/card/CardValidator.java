package com.adyen.checkout.core.card;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

public interface CardValidator {
    public static final int NUMBER_MAXIMUM_LENGTH = 19;
    public static final int NUMBER_MINIMUM_LENGTH = 8;
    public static final int SECURITY_CODE_MAXIMUM_LENGTH = 4;
    public static final int SECURITY_CODE_MINIMUM_LENGTH = 3;

    public static final class ExpiryDateValidationResult extends ValidationResult {
        private final Integer mExpiryMonth;
        private final Integer mExpiryYear;

        public ExpiryDateValidationResult(@NonNull Validity validity, @Nullable Integer num, @Nullable Integer num2) {
            super(validity);
            this.mExpiryMonth = num;
            this.mExpiryYear = num2;
        }

        @Nullable
        public Integer getExpiryMonth() {
            return this.mExpiryMonth;
        }

        @Nullable
        public Integer getExpiryYear() {
            return this.mExpiryYear;
        }
    }

    public static final class HolderNameValidationResult extends ValidationResult {
        private final String mHolderName;

        public HolderNameValidationResult(@NonNull Validity validity, @Nullable String str) {
            super(validity);
            this.mHolderName = str;
        }

        @Nullable
        public String getHolderName() {
            return this.mHolderName;
        }
    }

    public static final class NumberValidationResult extends ValidationResult {
        private final String mNumber;

        public NumberValidationResult(@NonNull Validity validity, @Nullable String str) {
            super(validity);
            this.mNumber = str;
        }

        @Nullable
        public String getNumber() {
            return this.mNumber;
        }
    }

    public static final class SecurityCodeValidationResult extends ValidationResult {
        private String mSecurityCode;

        public SecurityCodeValidationResult(@NonNull Validity validity, @Nullable String str) {
            super(validity);
            this.mSecurityCode = str;
        }

        @Nullable
        public String getSecurityCode() {
            return this.mSecurityCode;
        }
    }

    public static abstract class ValidationResult {
        private final Validity mValidity;

        @NonNull
        public Validity getValidity() {
            return this.mValidity;
        }

        private ValidationResult(@NonNull Validity validity) {
            this.mValidity = validity;
        }
    }

    public enum Validity {
        VALID,
        PARTIAL,
        INVALID
    }

    @NonNull
    ExpiryDateValidationResult validateExpiryDate(@NonNull String str);

    @NonNull
    HolderNameValidationResult validateHolderName(@NonNull String str, boolean z11);

    @NonNull
    NumberValidationResult validateNumber(@NonNull String str);

    @NonNull
    SecurityCodeValidationResult validateSecurityCode(@NonNull String str, boolean z11, @Nullable CardType cardType);
}
