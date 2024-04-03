package com.squareup.moshi.adapters;

import com.facebook.internal.security.CertificateUtil;
import com.squareup.moshi.JsonDataException;
import j$.util.DesugarTimeZone;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Locale;
import java.util.TimeZone;
import kotlinx.serialization.json.internal.AbstractJsonLexerKt;
import net.bytebuddy.jar.asm.signature.SignatureVisitor;

final class Iso8601Utils {

    /* renamed from: a  reason: collision with root package name */
    public static final TimeZone f53343a = DesugarTimeZone.getTimeZone("GMT");

    private static boolean checkOffset(String str, int i11, char c11) {
        return i11 < str.length() && str.charAt(i11) == c11;
    }

    public static String format(Date date) {
        GregorianCalendar gregorianCalendar = new GregorianCalendar(f53343a, Locale.US);
        gregorianCalendar.setTime(date);
        StringBuilder sb2 = new StringBuilder(24);
        padInt(sb2, gregorianCalendar.get(1), 4);
        sb2.append(SignatureVisitor.SUPER);
        padInt(sb2, gregorianCalendar.get(2) + 1, 2);
        sb2.append(SignatureVisitor.SUPER);
        padInt(sb2, gregorianCalendar.get(5), 2);
        sb2.append('T');
        padInt(sb2, gregorianCalendar.get(11), 2);
        sb2.append(AbstractJsonLexerKt.COLON);
        padInt(sb2, gregorianCalendar.get(12), 2);
        sb2.append(AbstractJsonLexerKt.COLON);
        padInt(sb2, gregorianCalendar.get(13), 2);
        sb2.append('.');
        padInt(sb2, gregorianCalendar.get(14), 3);
        sb2.append('Z');
        return sb2.toString();
    }

    private static int indexOfNonDigit(String str, int i11) {
        while (i11 < str.length()) {
            char charAt = str.charAt(i11);
            if (charAt < '0' || charAt > '9') {
                return i11;
            }
            i11++;
        }
        return str.length();
    }

    private static void padInt(StringBuilder sb2, int i11, int i12) {
        String num = Integer.toString(i11);
        for (int length = i12 - num.length(); length > 0; length--) {
            sb2.append('0');
        }
        sb2.append(num);
    }

    public static Date parse(String str) {
        int i11;
        int i12;
        int i13;
        int i14;
        int i15;
        TimeZone timeZone;
        char charAt;
        String str2 = str;
        int i16 = 4;
        try {
            int parseInt = parseInt(str2, 0, 4);
            if (checkOffset(str2, 4, SignatureVisitor.SUPER)) {
                i16 = 5;
            }
            int i17 = i16 + 2;
            int parseInt2 = parseInt(str2, i16, i17);
            if (checkOffset(str2, i17, SignatureVisitor.SUPER)) {
                i17++;
            }
            int i18 = i17 + 2;
            int parseInt3 = parseInt(str2, i17, i18);
            boolean checkOffset = checkOffset(str2, i18, 'T');
            if (!checkOffset && str.length() <= i18) {
                return new GregorianCalendar(parseInt, parseInt2 - 1, parseInt3).getTime();
            }
            if (checkOffset) {
                int i19 = i18 + 1;
                int i21 = i19 + 2;
                int parseInt4 = parseInt(str2, i19, i21);
                if (checkOffset(str2, i21, AbstractJsonLexerKt.COLON)) {
                    i21++;
                }
                int i22 = i21 + 2;
                i13 = parseInt(str2, i21, i22);
                if (checkOffset(str2, i22, AbstractJsonLexerKt.COLON)) {
                    i22++;
                }
                if (str.length() <= i22 || (charAt = str2.charAt(i22)) == 'Z' || charAt == '+' || charAt == '-') {
                    i11 = parseInt3;
                    i15 = 0;
                    i14 = parseInt4;
                    i18 = i22;
                    i12 = 0;
                } else {
                    int i23 = i22 + 2;
                    i12 = parseInt(str2, i22, i23);
                    if (i12 > 59 && i12 < 63) {
                        i12 = 59;
                    }
                    if (checkOffset(str2, i23, '.')) {
                        int i24 = i23 + 1;
                        int indexOfNonDigit = indexOfNonDigit(str2, i24 + 1);
                        int min = Math.min(indexOfNonDigit, i24 + 3);
                        i11 = parseInt3;
                        i15 = (int) (Math.pow(10.0d, (double) (3 - (min - i24))) * ((double) parseInt(str2, i24, min)));
                        i14 = parseInt4;
                        i18 = indexOfNonDigit;
                    } else {
                        i11 = parseInt3;
                        i15 = 0;
                        i14 = parseInt4;
                        i18 = i23;
                    }
                }
            } else {
                i11 = parseInt3;
                i15 = 0;
                i14 = 0;
                i13 = 0;
                i12 = 0;
            }
            if (str.length() > i18) {
                char charAt2 = str2.charAt(i18);
                if (charAt2 == 'Z') {
                    timeZone = f53343a;
                } else {
                    if (charAt2 != '+') {
                        if (charAt2 != '-') {
                            throw new IndexOutOfBoundsException("Invalid time zone indicator '" + charAt2 + "'");
                        }
                    }
                    String substring = str2.substring(i18);
                    if (!"+0000".equals(substring)) {
                        if (!"+00:00".equals(substring)) {
                            String str3 = "GMT" + substring;
                            TimeZone timeZone2 = DesugarTimeZone.getTimeZone(str3);
                            String id2 = timeZone2.getID();
                            if (!id2.equals(str3)) {
                                if (!id2.replace(CertificateUtil.DELIMITER, "").equals(str3)) {
                                    throw new IndexOutOfBoundsException("Mismatching time zone indicator: " + str3 + " given, resolves to " + timeZone2.getID());
                                }
                            }
                            timeZone = timeZone2;
                        }
                    }
                    timeZone = f53343a;
                }
                GregorianCalendar gregorianCalendar = new GregorianCalendar(timeZone);
                gregorianCalendar.setLenient(false);
                gregorianCalendar.set(1, parseInt);
                gregorianCalendar.set(2, parseInt2 - 1);
                gregorianCalendar.set(5, i11);
                gregorianCalendar.set(11, i14);
                gregorianCalendar.set(12, i13);
                gregorianCalendar.set(13, i12);
                gregorianCalendar.set(14, i15);
                return gregorianCalendar.getTime();
            }
            throw new IllegalArgumentException("No time zone indicator");
        } catch (IllegalArgumentException | IndexOutOfBoundsException e11) {
            throw new JsonDataException("Not an RFC 3339 date: " + str2, e11);
        }
    }

    private static int parseInt(String str, int i11, int i12) throws NumberFormatException {
        int i13;
        int i14;
        if (i11 < 0 || i12 > str.length() || i11 > i12) {
            throw new NumberFormatException(str);
        }
        if (i11 < i12) {
            i14 = i11 + 1;
            int digit = Character.digit(str.charAt(i11), 10);
            if (digit >= 0) {
                i13 = -digit;
            } else {
                throw new NumberFormatException("Invalid number: " + str.substring(i11, i12));
            }
        } else {
            i13 = 0;
            i14 = i11;
        }
        while (i14 < i12) {
            int i15 = i14 + 1;
            int digit2 = Character.digit(str.charAt(i14), 10);
            if (digit2 >= 0) {
                i13 = (i13 * 10) - digit2;
                i14 = i15;
            } else {
                throw new NumberFormatException("Invalid number: " + str.substring(i11, i12));
            }
        }
        return -i13;
    }
}
