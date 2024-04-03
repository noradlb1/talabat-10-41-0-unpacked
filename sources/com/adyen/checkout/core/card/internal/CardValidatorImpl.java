package com.adyen.checkout.core.card.internal;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.annotation.VisibleForTesting;
import com.adyen.checkout.core.card.CardType;
import com.adyen.checkout.core.card.CardValidator;
import com.google.android.exoplayer2.extractor.ts.PsExtractor;
import java.util.Calendar;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public final class CardValidatorImpl implements CardValidator {
    public static final int AMEX_NUMBER_SIZE = 15;
    public static final int AMEX_SECURITY_CODE_SIZE = 4;
    public static final int GENERAL_CARD_NUMBER_SIZE = 16;
    public static final int GENERAL_CARD_SECURITY_CODE_SIZE = 3;
    @VisibleForTesting
    public static final int MAXIMUM_EXPIRED_MONTHS = 3;
    @VisibleForTesting
    public static final int MAXIMUM_YEARS_IN_FUTURE = 20;
    @VisibleForTesting
    public static final int MONTHS_IN_YEAR = 12;
    private final Pattern mExpiryDatePattern;
    private final char mExpiryDateSeparator;
    private final char mNumberSeparator;

    public CardValidatorImpl(char c11, char c12) {
        this.mNumberSeparator = c11;
        this.mExpiryDateSeparator = c12;
        this.mExpiryDatePattern = Pattern.compile("(0?[1-9]|1[0-2])\\" + c12 + "((20)?\\d{2})");
    }

    private boolean isAcceptedForTransaction(int i11, int i12) {
        Calendar instance = Calendar.getInstance();
        int i13 = (instance.get(1) * 12) + instance.get(2) + 1;
        int i14 = (i12 * 12) + i11;
        int i15 = i13 + PsExtractor.VIDEO_STREAM_MASK;
        if (i14 <= i13 - 3 || i14 > i15) {
            return false;
        }
        return true;
    }

    private boolean isDigitsAndSeparatorsOnly(@NonNull String str, @NonNull char... cArr) {
        for (int i11 = 0; i11 < str.length(); i11++) {
            char charAt = str.charAt(i11);
            for (char c11 : cArr) {
                if (!Character.isDigit(charAt) && c11 != charAt) {
                    return false;
                }
            }
        }
        return true;
    }

    private boolean isLuhnChecksumValid(@NonNull String str) {
        String stringBuffer = new StringBuffer(str).reverse().toString();
        int i11 = 0;
        int i12 = 0;
        for (int i13 = 0; i13 < stringBuffer.length(); i13++) {
            int digit = Character.digit(stringBuffer.charAt(i13), 10);
            if (i13 % 2 == 0) {
                i11 += digit;
            } else {
                i12 += digit * 2;
                if (digit >= 5) {
                    i12 -= 9;
                }
            }
        }
        if ((i11 + i12) % 10 == 0) {
            return true;
        }
        return false;
    }

    private int makeFourDigitYear(@NonNull String str) {
        int length = str.length();
        if (length == 2) {
            return Integer.parseInt("20" + str);
        } else if (length == 4) {
            return Integer.parseInt(str);
        } else {
            throw new IllegalStateException("Year has invalid length.");
        }
    }

    @NonNull
    private String normalize(@NonNull String str, @NonNull char... cArr) {
        return str.replaceAll("[\\s" + new String(cArr) + "]", "");
    }

    @NonNull
    public CardValidator.ExpiryDateValidationResult validateExpiryDate(@NonNull String str) {
        Integer num;
        CardValidator.Validity validity;
        Matcher matcher = this.mExpiryDatePattern.matcher(normalize(str, new char[0]));
        String[] split = str.split("\\" + String.valueOf(this.mExpiryDateSeparator));
        if (matcher.matches()) {
            Integer valueOf = Integer.valueOf(Integer.parseInt(split[0]));
            Integer valueOf2 = Integer.valueOf(makeFourDigitYear(split[1]));
            if (isAcceptedForTransaction(valueOf.intValue(), valueOf2.intValue())) {
                validity = CardValidator.Validity.VALID;
            } else {
                validity = CardValidator.Validity.INVALID;
            }
            return new CardValidator.ExpiryDateValidationResult(validity, valueOf, valueOf2);
        } else if (!matcher.hitEnd()) {
            return new CardValidator.ExpiryDateValidationResult(CardValidator.Validity.INVALID, (Integer) null, (Integer) null);
        } else {
            CardValidator.Validity validity2 = CardValidator.Validity.PARTIAL;
            if (split.length == 2) {
                num = Integer.valueOf(Integer.parseInt(split[0]));
            } else {
                num = null;
            }
            return new CardValidator.ExpiryDateValidationResult(validity2, num, (Integer) null);
        }
    }

    @NonNull
    public CardValidator.HolderNameValidationResult validateHolderName(@NonNull String str, boolean z11) {
        CardValidator.Validity validity;
        String trim = str.trim();
        if (!trim.isEmpty()) {
            return new CardValidator.HolderNameValidationResult(CardValidator.Validity.VALID, trim);
        }
        if (z11) {
            validity = CardValidator.Validity.INVALID;
        } else {
            validity = CardValidator.Validity.VALID;
        }
        return new CardValidator.HolderNameValidationResult(validity, (String) null);
    }

    @NonNull
    public CardValidator.NumberValidationResult validateNumber(@NonNull String str) {
        String normalize = normalize(str, this.mNumberSeparator);
        int length = normalize.length();
        if (!isDigitsAndSeparatorsOnly(normalize, this.mNumberSeparator)) {
            return new CardValidator.NumberValidationResult(CardValidator.Validity.INVALID, (String) null);
        }
        if (length > 19) {
            return new CardValidator.NumberValidationResult(CardValidator.Validity.INVALID, (String) null);
        }
        if (length < 8) {
            return new CardValidator.NumberValidationResult(CardValidator.Validity.PARTIAL, normalize);
        }
        if (isLuhnChecksumValid(normalize)) {
            return new CardValidator.NumberValidationResult(CardValidator.Validity.VALID, normalize);
        }
        if (length == 19) {
            return new CardValidator.NumberValidationResult(CardValidator.Validity.INVALID, (String) null);
        }
        return new CardValidator.NumberValidationResult(CardValidator.Validity.PARTIAL, normalize);
    }

    @NonNull
    public CardValidator.SecurityCodeValidationResult validateSecurityCode(@NonNull String str, boolean z11, @Nullable CardType cardType) {
        CardValidator.Validity validity;
        CardValidator.Validity validity2;
        String normalize = normalize(str, new char[0]);
        int length = normalize.length();
        if (!isDigitsAndSeparatorsOnly(normalize, new char[0])) {
            return new CardValidator.SecurityCodeValidationResult(CardValidator.Validity.INVALID, (String) null);
        }
        if (length > 4) {
            return new CardValidator.SecurityCodeValidationResult(CardValidator.Validity.INVALID, (String) null);
        }
        if (length < 3) {
            if (length != 0) {
                return new CardValidator.SecurityCodeValidationResult(CardValidator.Validity.PARTIAL, normalize);
            }
            if (z11) {
                validity2 = CardValidator.Validity.INVALID;
            } else {
                validity2 = CardValidator.Validity.VALID;
            }
            return new CardValidator.SecurityCodeValidationResult(validity2, (String) null);
        } else if (cardType == CardType.AMERICAN_EXPRESS) {
            if (length == 4) {
                validity = CardValidator.Validity.VALID;
            } else {
                validity = CardValidator.Validity.PARTIAL;
            }
            return new CardValidator.SecurityCodeValidationResult(validity, normalize);
        } else if (cardType == null) {
            return new CardValidator.SecurityCodeValidationResult(CardValidator.Validity.VALID, normalize);
        } else {
            if (length == 3) {
                return new CardValidator.SecurityCodeValidationResult(CardValidator.Validity.VALID, normalize);
            }
            return new CardValidator.SecurityCodeValidationResult(CardValidator.Validity.INVALID, (String) null);
        }
    }
}
