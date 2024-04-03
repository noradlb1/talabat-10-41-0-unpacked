package org.threeten.bp.format;

import j$.util.concurrent.ConcurrentHashMap;
import java.text.DecimalFormatSymbols;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Locale;
import java.util.Set;
import java.util.concurrent.ConcurrentMap;
import net.bytebuddy.jar.asm.signature.SignatureVisitor;
import org.threeten.bp.jdk8.Jdk8Methods;

public final class DecimalStyle {
    private static final ConcurrentMap<Locale, DecimalStyle> CACHE = new ConcurrentHashMap(16, 0.75f, 2);
    public static final DecimalStyle STANDARD = new DecimalStyle('0', SignatureVisitor.EXTENDS, SignatureVisitor.SUPER, '.');
    private final char decimalSeparator;
    private final char negativeSign;
    private final char positiveSign;
    private final char zeroDigit;

    private DecimalStyle(char c11, char c12, char c13, char c14) {
        this.zeroDigit = c11;
        this.positiveSign = c12;
        this.negativeSign = c13;
        this.decimalSeparator = c14;
    }

    private static DecimalStyle create(Locale locale) {
        DecimalFormatSymbols instance = DecimalFormatSymbols.getInstance(locale);
        char zeroDigit2 = instance.getZeroDigit();
        char minusSign = instance.getMinusSign();
        char decimalSeparator2 = instance.getDecimalSeparator();
        if (zeroDigit2 == '0' && minusSign == '-' && decimalSeparator2 == '.') {
            return STANDARD;
        }
        return new DecimalStyle(zeroDigit2, SignatureVisitor.EXTENDS, minusSign, decimalSeparator2);
    }

    public static Set<Locale> getAvailableLocales() {
        return new HashSet(Arrays.asList(DecimalFormatSymbols.getAvailableLocales()));
    }

    public static DecimalStyle of(Locale locale) {
        Jdk8Methods.requireNonNull(locale, "locale");
        ConcurrentMap<Locale, DecimalStyle> concurrentMap = CACHE;
        DecimalStyle decimalStyle = concurrentMap.get(locale);
        if (decimalStyle != null) {
            return decimalStyle;
        }
        concurrentMap.putIfAbsent(locale, create(locale));
        return concurrentMap.get(locale);
    }

    public static DecimalStyle ofDefaultLocale() {
        return of(Locale.getDefault());
    }

    public String a(String str) {
        char c11 = this.zeroDigit;
        if (c11 == '0') {
            return str;
        }
        int i11 = c11 - '0';
        char[] charArray = str.toCharArray();
        for (int i12 = 0; i12 < charArray.length; i12++) {
            charArray[i12] = (char) (charArray[i12] + i11);
        }
        return new String(charArray);
    }

    public int b(char c11) {
        int i11 = c11 - this.zeroDigit;
        if (i11 < 0 || i11 > 9) {
            return -1;
        }
        return i11;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof DecimalStyle)) {
            return false;
        }
        DecimalStyle decimalStyle = (DecimalStyle) obj;
        if (this.zeroDigit == decimalStyle.zeroDigit && this.positiveSign == decimalStyle.positiveSign && this.negativeSign == decimalStyle.negativeSign && this.decimalSeparator == decimalStyle.decimalSeparator) {
            return true;
        }
        return false;
    }

    public char getDecimalSeparator() {
        return this.decimalSeparator;
    }

    public char getNegativeSign() {
        return this.negativeSign;
    }

    public char getPositiveSign() {
        return this.positiveSign;
    }

    public char getZeroDigit() {
        return this.zeroDigit;
    }

    public int hashCode() {
        return this.zeroDigit + this.positiveSign + this.negativeSign + this.decimalSeparator;
    }

    public String toString() {
        return "DecimalStyle[" + this.zeroDigit + this.positiveSign + this.negativeSign + this.decimalSeparator + "]";
    }

    public DecimalStyle withDecimalSeparator(char c11) {
        if (c11 == this.decimalSeparator) {
            return this;
        }
        return new DecimalStyle(this.zeroDigit, this.positiveSign, this.negativeSign, c11);
    }

    public DecimalStyle withNegativeSign(char c11) {
        if (c11 == this.negativeSign) {
            return this;
        }
        return new DecimalStyle(this.zeroDigit, this.positiveSign, c11, this.decimalSeparator);
    }

    public DecimalStyle withPositiveSign(char c11) {
        if (c11 == this.positiveSign) {
            return this;
        }
        return new DecimalStyle(this.zeroDigit, c11, this.negativeSign, this.decimalSeparator);
    }

    public DecimalStyle withZeroDigit(char c11) {
        if (c11 == this.zeroDigit) {
            return this;
        }
        return new DecimalStyle(c11, this.positiveSign, this.negativeSign, this.decimalSeparator);
    }
}
