package com.adyen.checkout.util.sepadirectdebit;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.google.zxing.client.result.ExpandedProductParsedResult;
import com.huawei.wearengine.sensor.Sensor;
import com.newrelic.agent.android.Agent;
import com.visa.checkout.Profile;
import java.math.BigInteger;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public final class Iban {
    private static final int CHECK_DIGIT_POSITION_END = 4;
    private static final int CHECK_DIGIT_POSITION_START = 2;
    private static final int COUNTRY_CODE_POSITION_END = 2;
    private static final Map<String, Details> COUNTRY_DETAILS = Collections.unmodifiableMap(new HashMap<String, Details>() {
        {
            put("AD", new Details(Pattern.compile("^AD\\d{10}[0-9A-Z]{12}$"), 24));
            put(Profile.Country.AE, new Details(Pattern.compile("^AE\\d{21}$"), 23));
            put("AL", new Details(Pattern.compile("^AL\\d{10}[0-9A-Z]{16}$"), 28));
            put("AT", new Details(Pattern.compile("^AT\\d{18}$"), 20, true));
            put("BA", new Details(Pattern.compile("^BA\\d{18}$"), 20));
            put("BE", new Details(Pattern.compile("^BE\\d{14}$"), 16, true));
            put("BG", new Details(Pattern.compile("^BG\\d{2}[A-Z]{4}\\d{6}[0-9A-Z]{8}$"), 22, true));
            put("BH", new Details(Pattern.compile("^BH\\d{2}[A-Z]{4}[0-9A-Z]{14}$"), 22));
            put("CH", new Details(Pattern.compile("^CH\\d{7}[0-9A-Z]{12}$"), 21, true));
            put("CY", new Details(Pattern.compile("^CY\\d{10}[0-9A-Z]{16}$"), 21, true));
            put("CZ", new Details(Pattern.compile("^CZ\\d{22}$"), 24, true));
            put("DE", new Details(Pattern.compile("^DE\\d{20}$"), 22, true));
            put("DK", new Details(Pattern.compile("^DK\\d{16}$|^FO\\d{16}$|^GL\\d{16}$"), 18, true));
            put("DO", new Details(Pattern.compile("^DO\\d{2}[0-9A-Z]{4}\\d{20}$"), 28));
            put("EE", new Details(Pattern.compile("^EE\\d{18}$"), 20, true));
            put(Profile.Country.ES, new Details(Pattern.compile("^ES\\d{22}$"), 24, true));
            put("FI", new Details(Pattern.compile("^FI\\d{16}$"), 18, true));
            put(Profile.Country.FR, new Details(Pattern.compile("^FR\\d{12}[0-9A-Z]{11}\\d{2}$"), 27, true));
            put(Profile.Country.GB, new Details(Pattern.compile("^GB\\d{2}[A-Z]{4}\\d{14}$"), 22, true));
            put("GE", new Details(Pattern.compile("^GE\\d{2}[A-Z]{2}\\d{16}$"), 22));
            put("GI", new Details(Pattern.compile("^GI\\d{2}[A-Z]{4}[0-9A-Z]{15}$"), 23));
            put("GR", new Details(Pattern.compile("^GR\\d{9}[0-9A-Z]{16}$"), 27, true));
            put(Sensor.NAME_HR, new Details(Pattern.compile("^HR\\d{19}$"), 21, true));
            put("HU", new Details(Pattern.compile("^HU\\d{26}$"), 28, true));
            put(Profile.Country.IE, new Details(Pattern.compile("^IE\\d{2}[A-Z]{4}\\d{14}$"), 22, true));
            put("IL", new Details(Pattern.compile("^IL\\d{21}$"), 23));
            put("IS", new Details(Pattern.compile("^IS\\d{24}$"), 26, true));
            put("IT", new Details(Pattern.compile("^IT\\d{2}[A-Z]\\d{10}[0-9A-Z]{12}$"), 27, true));
            put(Profile.Country.KW, new Details(Pattern.compile("^KW\\d{2}[A-Z]{4}22!$"), 30));
            put("KZ", new Details(Pattern.compile("^[A-Z]{2}\\d{5}[0-9A-Z]{13}$"), 20));
            put(ExpandedProductParsedResult.POUND, new Details(Pattern.compile("^LB\\d{6}[0-9A-Z]{20}$"), 28));
            put("LI", new Details(Pattern.compile("^LI\\d{7}[0-9A-Z]{12}$"), 21, true));
            put("LT", new Details(Pattern.compile("^LT\\d{18}$"), 20, true));
            put("LU", new Details(Pattern.compile("^LU\\d{5}[0-9A-Z]{13}$"), 20, true));
            put("LV", new Details(Pattern.compile("^LV\\d{2}[A-Z]{4}[0-9A-Z]{13}$"), 21, true));
            put("MC", new Details(Pattern.compile("^MC\\d{12}[0-9A-Z]{11}\\d{2}$"), 27, true));
            put("ME", new Details(Pattern.compile("^ME\\d{20}$"), 22));
            put("MK", new Details(Pattern.compile("^MK\\d{5}[0-9A-Z]{10}\\d{2}$"), 19));
            put("MR", new Details(Pattern.compile("^MR13\\d{23}$"), 27));
            put("MT", new Details(Pattern.compile("^MT\\d{2}[A-Z]{4}\\d{5}[0-9A-Z]{18}$"), 31, true));
            put("MU", new Details(Pattern.compile("^MU\\d{2}[A-Z]{4}\\d{19}[A-Z]{3}$"), 30));
            put("NL", new Details(Pattern.compile("^NL\\d{2}[A-Z]{4}\\d{10}$"), 18, true));
            put(Agent.MONO_INSTRUMENTATION_FLAG, new Details(Pattern.compile("^NO\\d{13}$"), 15, true));
            put(Profile.Country.PL, new Details(Pattern.compile("^PL\\d{10}[0-9A-Z]{16}$"), 28, true));
            put("PT", new Details(Pattern.compile("^PT\\d{23}$"), 25, true));
            put("RO", new Details(Pattern.compile("^RO\\d{2}[A-Z]{4}[0-9A-Z]{16}$"), 24, true));
            put("RS", new Details(Pattern.compile("^RS\\d{20}$"), 22));
            put(Profile.Country.SA, new Details(Pattern.compile("^SA\\d{4}[0-9A-Z]{18}$"), 24));
            put("SE", new Details(Pattern.compile("^SE\\d{22}$"), 24, true));
            put("SI", new Details(Pattern.compile("^SI\\d{17}$"), 19, true));
            put("SK", new Details(Pattern.compile("^SK\\d{22}$"), 24, true));
            put("SM", new Details(Pattern.compile("^SM\\d{2}[A-Z]\\d{10}[0-9A-Z]{12}$"), 27, true));
            put("TN", new Details(Pattern.compile("^TN59\\d{20}$"), 24));
            put("TR", new Details(Pattern.compile("^TR\\d{7}[0-9A-Z]{17}$"), 26));
        }
    });
    private static final BigInteger VALIDATION_MODULUS = new BigInteger("97");
    private String mValue;

    private Iban(@NonNull String str) {
        this.mValue = str;
    }

    @NonNull
    public static String format(@Nullable String str) {
        return normalize(str).replaceAll("(.{4})", "$1 ").trim();
    }

    @NonNull
    private static String getZeroPaddedValue(@NonNull String str, @NonNull Details details) {
        int length = str.length();
        int d11 = details.mLength - length;
        if (d11 <= 0 || d11 > 3) {
            return str;
        }
        int i11 = length - 1;
        int i12 = -1;
        while (i11 > 4 && Character.isDigit(str.charAt(i11))) {
            i12 = i11;
            i11--;
        }
        if (i12 <= 0) {
            return str;
        }
        char[] cArr = new char[(details.mLength - length)];
        Arrays.fill(cArr, '0');
        return str.substring(0, i12) + new String(cArr) + str.substring(i12, length);
    }

    private static boolean isChecksumValid(@NonNull String str) {
        String str2 = str.substring(4) + str.substring(0, 4);
        StringBuilder sb2 = new StringBuilder();
        for (int i11 = 0; i11 < str2.length(); i11++) {
            sb2.append(Character.getNumericValue(str2.charAt(i11)));
        }
        if (new BigInteger(sb2.toString()).mod(VALIDATION_MODULUS).intValue() == 1) {
            return true;
        }
        return false;
    }

    public static boolean isPartial(@Nullable String str) {
        String normalize = normalize(str);
        if (normalize.length() < 2) {
            for (String startsWith : COUNTRY_DETAILS.keySet()) {
                if (startsWith.startsWith(normalize)) {
                    return true;
                }
            }
            return false;
        }
        Details details = COUNTRY_DETAILS.get(normalize.substring(0, 2));
        if (details == null || !details.isPotentialMatchWithMoreInput(normalize)) {
            return false;
        }
        return true;
    }

    @NonNull
    public static String mask(@Nullable String str) {
        return normalize(str).replaceFirst("(.{4}).+(.{4})", "$1 … $2");
    }

    @NonNull
    private static String normalize(@Nullable String str) {
        if (str != null) {
            return str.replaceAll("[^\\a-zA-Z]&&[^\\d]", "").replaceAll("\\s", "").toUpperCase(Locale.US);
        }
        return "";
    }

    @Nullable
    public static Iban parse(@Nullable String str) {
        Details details;
        String normalize = normalize(str);
        if (normalize.length() >= 2) {
            details = COUNTRY_DETAILS.get(normalize.substring(0, 2));
        } else {
            details = null;
        }
        if (details == null || !details.isFullMatch(normalize) || !isChecksumValid(normalize)) {
            return null;
        }
        return new Iban(normalize);
    }

    @Nullable
    public static Iban parseByAddingMissingZeros(@Nullable String str) {
        Details details;
        String normalize = normalize(str);
        if (normalize.length() >= 2) {
            details = COUNTRY_DETAILS.get(normalize.substring(0, 2));
        } else {
            details = null;
        }
        if (details != null) {
            String zeroPaddedValue = getZeroPaddedValue(normalize, details);
            if (details.isFullMatch(zeroPaddedValue) && isChecksumValid(zeroPaddedValue)) {
                return new Iban(zeroPaddedValue);
            }
        }
        return null;
    }

    public static boolean startsWithSepaCountryCode(@Nullable String str) {
        String normalize = normalize(str);
        if (normalize.length() < 2) {
            for (Map.Entry next : COUNTRY_DETAILS.entrySet()) {
                Details details = (Details) next.getValue();
                if (((String) next.getKey()).startsWith(normalize) && details != null && details.mSepa) {
                    return true;
                }
            }
            return false;
        }
        Details details2 = COUNTRY_DETAILS.get(normalize.substring(0, 2));
        if (details2 == null || !details2.mSepa) {
            return false;
        }
        return true;
    }

    @NonNull
    public String getBban() {
        return this.mValue.substring(4);
    }

    @NonNull
    public String getCheckDigits() {
        return this.mValue.substring(2, 4);
    }

    @NonNull
    public String getCountryCode() {
        return this.mValue.substring(0, 2);
    }

    @NonNull
    public String getValue() {
        return this.mValue;
    }

    public boolean isSepa() {
        Details details = COUNTRY_DETAILS.get(getCountryCode());
        if (details == null || !details.mSepa) {
            return false;
        }
        return true;
    }

    public static final class Details {
        /* access modifiers changed from: private */
        public final int mLength;
        private final Pattern mPattern;
        /* access modifiers changed from: private */
        public final boolean mSepa;

        private int getLength() {
            return this.mLength;
        }

        @NonNull
        private Pattern getPattern() {
            return this.mPattern;
        }

        /* access modifiers changed from: private */
        public boolean isFullMatch(@NonNull String str) {
            return this.mLength == str.length() && this.mPattern.matcher(str).matches();
        }

        /* access modifiers changed from: private */
        public boolean isPotentialMatchWithMoreInput(@NonNull String str) {
            if (this.mLength <= str.length()) {
                return false;
            }
            Matcher matcher = this.mPattern.matcher(str);
            matcher.matches();
            return matcher.hitEnd();
        }

        private boolean isSepa() {
            return this.mSepa;
        }

        private Details(@NonNull Pattern pattern, int i11) {
            this(pattern, i11, false);
        }

        private Details(@NonNull Pattern pattern, int i11, boolean z11) {
            this.mPattern = pattern;
            this.mLength = i11;
            this.mSepa = z11;
        }
    }
}
