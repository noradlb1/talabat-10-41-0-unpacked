package com.adyen.checkout.core.internal;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import java.util.Locale;

public final class SearchUtil {
    private SearchUtil() {
        throw new IllegalStateException("No instances.");
    }

    public static boolean allMatch(@Nullable CharSequence charSequence, @NonNull CharSequence... charSequenceArr) {
        for (CharSequence matches : charSequenceArr) {
            if (!matches(charSequence, matches)) {
                return false;
            }
        }
        return true;
    }

    public static boolean anyMatches(@Nullable CharSequence charSequence, @NonNull CharSequence... charSequenceArr) {
        for (CharSequence matches : charSequenceArr) {
            if (matches(charSequence, matches)) {
                return true;
            }
        }
        return false;
    }

    public static boolean matches(@Nullable CharSequence charSequence, @NonNull CharSequence charSequence2) {
        if (TextUtils.isEmpty(charSequence)) {
            return true;
        }
        String charSequence3 = charSequence.toString();
        Locale locale = Locale.US;
        String[] split = charSequence3.toLowerCase(locale).split("\\s+");
        String[] split2 = charSequence2.toString().toLowerCase(locale).split("\\s+");
        int length = split.length;
        int i11 = 0;
        while (i11 < length) {
            String str = split[i11];
            int length2 = split2.length;
            int i12 = 0;
            while (i12 < length2) {
                if (split2[i12].contains(str)) {
                    i11++;
                } else {
                    i12++;
                }
            }
            return false;
        }
        return true;
    }
}
