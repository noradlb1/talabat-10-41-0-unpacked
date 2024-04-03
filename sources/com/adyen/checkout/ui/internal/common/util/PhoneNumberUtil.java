package com.adyen.checkout.ui.internal.common.util;

import android.text.TextUtils;
import android.util.Patterns;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import java.util.regex.Matcher;

public final class PhoneNumberUtil {

    public static final class ValidationResult {
        private final String mPhoneNumber;
        private final Validity mValidity;

        @Nullable
        public String getPhoneNumber() {
            return this.mPhoneNumber;
        }

        @NonNull
        public Validity getValidity() {
            return this.mValidity;
        }

        private ValidationResult(@NonNull Validity validity, @Nullable String str) {
            this.mValidity = validity;
            this.mPhoneNumber = str;
        }
    }

    public enum Validity {
        VALID,
        PARTIAL,
        INVALID
    }

    private PhoneNumberUtil() {
        throw new IllegalStateException("No instances.");
    }

    @NonNull
    public static ValidationResult validate(@NonNull String str, boolean z11) {
        Validity validity;
        String trim = str.trim();
        Matcher matcher = Patterns.PHONE.matcher(trim);
        if (matcher.matches()) {
            return new ValidationResult(Validity.VALID, trim);
        }
        if (!matcher.hitEnd()) {
            return new ValidationResult(Validity.INVALID, (String) null);
        }
        if (!TextUtils.isEmpty(trim)) {
            validity = Validity.PARTIAL;
        } else if (z11) {
            validity = Validity.PARTIAL;
        } else {
            validity = Validity.VALID;
            trim = null;
        }
        return new ValidationResult(validity, trim);
    }
}
