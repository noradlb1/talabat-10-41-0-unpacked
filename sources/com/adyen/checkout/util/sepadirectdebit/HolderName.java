package com.adyen.checkout.util.sepadirectdebit;

import android.support.annotation.Nullable;

public final class HolderName {
    private static final String REGEX_AT_LEAST_PARTIAL = "[\\w0-9/?!:().,'+\\- ]*";
    private static final String REGEX_VALID_IF_MATCHED_PARTIAL = ".*[\\w0-9].*[\\w0-9].*[\\w0-9].*";

    private HolderName() {
        throw new IllegalStateException("No instances.");
    }

    public static boolean isPartial(@Nullable String str) {
        return str != null && str.trim().matches(REGEX_AT_LEAST_PARTIAL);
    }

    public static boolean isValid(@Nullable String str) {
        if (str == null) {
            return false;
        }
        String trim = str.trim();
        if (!trim.matches(REGEX_AT_LEAST_PARTIAL) || !trim.matches(REGEX_VALID_IF_MATCHED_PARTIAL)) {
            return false;
        }
        return true;
    }
}
