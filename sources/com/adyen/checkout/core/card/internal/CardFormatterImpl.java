package com.adyen.checkout.core.card.internal;

import android.support.annotation.NonNull;
import android.text.TextWatcher;
import android.widget.EditText;
import com.adyen.checkout.core.card.CardFormatter;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Locale;

public final class CardFormatterImpl implements CardFormatter {
    private static final char MASKING_CHAR = '•';
    private static final char NON_BREAKING_SPACE = ' ';
    private static final int VISIBLE_CHARS_MASK = 4;
    private final String mExpiryDateFormat;
    private final char mExpiryDateSeparator;
    private final char mNumberSeparator;

    public CardFormatterImpl(char c11, char c12) {
        this.mNumberSeparator = c11;
        this.mExpiryDateSeparator = c12;
        this.mExpiryDateFormat = "MM" + c12 + "yy";
    }

    @NonNull
    public TextWatcher attachAsYouTypeExpiryDateFormatter(@NonNull EditText editText) {
        return AsYouTypeExpiryDateFormatter.a(editText, this.mExpiryDateSeparator);
    }

    @NonNull
    public TextWatcher attachAsYouTypeNumberFormatter(@NonNull EditText editText) {
        return AsYouTypeCardNumberFormatter.a(editText, this.mNumberSeparator);
    }

    @NonNull
    public String formatExpiryDate(int i11, int i12) {
        Calendar instance = Calendar.getInstance();
        instance.clear();
        instance.set(2, i11 - 1);
        instance.set(1, i12);
        return new SimpleDateFormat(this.mExpiryDateFormat, Locale.US).format(instance.getTime());
    }

    @NonNull
    public String formatNumber(@NonNull String str) {
        String replaceAll = str.replaceAll("(.{4})", "$1" + this.mNumberSeparator);
        if (replaceAll.endsWith(String.valueOf(this.mNumberSeparator))) {
            return replaceAll.substring(0, replaceAll.length() - 1);
        }
        return replaceAll;
    }

    @NonNull
    public String formatSecurityCode(@NonNull String str) {
        return str.trim();
    }

    @NonNull
    public String maskNumber(@NonNull String str) {
        return String.format("%1$8s", new Object[]{str.substring(Math.max(str.length() - 4, 0))}).replaceAll("\\s", String.valueOf(8226)).replaceFirst("(.{4})", "$1 ");
    }
}
