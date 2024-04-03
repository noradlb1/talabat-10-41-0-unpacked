package org.apache.commons.lang3.math;

import com.talabat.sidemenu.SideMenuRewardViewHolder;
import java.lang.reflect.Array;
import java.math.BigDecimal;
import java.math.BigInteger;
import org.apache.commons.lang3.StringUtils;

public class NumberUtils {
    public static final Byte BYTE_MINUS_ONE = (byte) -1;
    public static final Byte BYTE_ONE = (byte) 1;
    public static final Byte BYTE_ZERO = (byte) 0;
    public static final Double DOUBLE_MINUS_ONE = Double.valueOf(-1.0d);
    public static final Double DOUBLE_ONE = Double.valueOf(1.0d);
    public static final Double DOUBLE_ZERO = Double.valueOf(0.0d);
    public static final Float FLOAT_MINUS_ONE = Float.valueOf(-1.0f);
    public static final Float FLOAT_ONE = Float.valueOf(1.0f);
    public static final Float FLOAT_ZERO = Float.valueOf(0.0f);
    public static final Integer INTEGER_MINUS_ONE = -1;
    public static final Integer INTEGER_ONE = 1;
    public static final Integer INTEGER_ZERO = 0;
    public static final Long LONG_MINUS_ONE = -1L;
    public static final Long LONG_ONE = 1L;
    public static final Long LONG_ZERO = 0L;
    public static final Short SHORT_MINUS_ONE = -1;
    public static final Short SHORT_ONE = 1;
    public static final Short SHORT_ZERO = 0;

    public static BigDecimal createBigDecimal(String str) {
        if (str == null) {
            return null;
        }
        if (StringUtils.isBlank(str)) {
            throw new NumberFormatException("A blank string is not a valid number");
        } else if (!str.trim().startsWith("--")) {
            return new BigDecimal(str);
        } else {
            throw new NumberFormatException(str + " is not a valid number.");
        }
    }

    public static BigInteger createBigInteger(String str) {
        int i11;
        int i12;
        if (str == null) {
            return null;
        }
        boolean startsWith = str.startsWith(SideMenuRewardViewHolder.DEFAULT_LOGGED_IN_USER_POINTS_VALUE);
        int i13 = 16;
        if (str.startsWith("0x", startsWith ? 1 : 0) || str.startsWith("0x", startsWith)) {
            i11 = startsWith + true;
        } else if (str.startsWith("#", startsWith)) {
            i11 = startsWith + true;
        } else if (!str.startsWith("0", startsWith) || str.length() <= (i12 = startsWith + true)) {
            i13 = 10;
            i11 = startsWith;
        } else {
            i13 = 8;
            i11 = i12;
        }
        BigInteger bigInteger = new BigInteger(str.substring(i11), i13);
        if (startsWith) {
            return bigInteger.negate();
        }
        return bigInteger;
    }

    public static Double createDouble(String str) {
        if (str == null) {
            return null;
        }
        return Double.valueOf(str);
    }

    public static Float createFloat(String str) {
        if (str == null) {
            return null;
        }
        return Float.valueOf(str);
    }

    public static Integer createInteger(String str) {
        if (str == null) {
            return null;
        }
        return Integer.decode(str);
    }

    public static Long createLong(String str) {
        if (str == null) {
            return null;
        }
        return Long.decode(str);
    }

    /* JADX WARNING: Can't wrap try/catch for region: R(11:(1:61)|62|(1:67)(1:66)|68|(5:70|(3:72|(2:74|(2:76|(1:78)))|(2:94|95)(3:88|89|90))|96|97|(1:103))|104|105|(1:111)|112|113|114) */
    /* JADX WARNING: Code restructure failed: missing block: B:117:0x01bb, code lost:
        throw new java.lang.NumberFormatException(r0 + " is not a valid number.");
     */
    /* JADX WARNING: Code restructure failed: missing block: B:129:0x01db, code lost:
        return createLong(r17);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:132:0x01e0, code lost:
        return createBigInteger(r17);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:79:0x013a, code lost:
        if (r2 == 'l') goto L_0x013c;
     */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Missing exception handler attribute for start block: B:104:0x018c */
    /* JADX WARNING: Missing exception handler attribute for start block: B:112:0x01a2 */
    /* JADX WARNING: Missing exception handler attribute for start block: B:127:0x01d7 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static java.lang.Number createNumber(java.lang.String r17) throws java.lang.NumberFormatException {
        /*
            r0 = r17
            r1 = 0
            if (r0 != 0) goto L_0x0006
            return r1
        L_0x0006:
            boolean r2 = org.apache.commons.lang3.StringUtils.isBlank(r17)
            if (r2 != 0) goto L_0x0222
            java.lang.String r3 = "0x"
            java.lang.String r4 = "0X"
            java.lang.String r5 = "-0x"
            java.lang.String r6 = "-0X"
            java.lang.String r7 = "#"
            java.lang.String r8 = "-#"
            java.lang.String[] r2 = new java.lang.String[]{r3, r4, r5, r6, r7, r8}
            r3 = 0
            r4 = r3
        L_0x001e:
            r5 = 6
            if (r4 >= r5) goto L_0x0032
            r5 = r2[r4]
            boolean r6 = r0.startsWith(r5)
            if (r6 == 0) goto L_0x002f
            int r2 = r5.length()
            int r2 = r2 + r3
            goto L_0x0033
        L_0x002f:
            int r4 = r4 + 1
            goto L_0x001e
        L_0x0032:
            r2 = r3
        L_0x0033:
            r4 = 16
            if (r2 <= 0) goto L_0x0071
            r1 = r2
        L_0x0038:
            int r5 = r17.length()
            if (r2 >= r5) goto L_0x004b
            char r3 = r0.charAt(r2)
            r5 = 48
            if (r3 != r5) goto L_0x004b
            int r1 = r1 + 1
            int r2 = r2 + 1
            goto L_0x0038
        L_0x004b:
            int r2 = r17.length()
            int r2 = r2 - r1
            if (r2 > r4) goto L_0x006c
            r1 = 55
            if (r2 != r4) goto L_0x0059
            if (r3 <= r1) goto L_0x0059
            goto L_0x006c
        L_0x0059:
            r4 = 8
            if (r2 > r4) goto L_0x0067
            if (r2 != r4) goto L_0x0062
            if (r3 <= r1) goto L_0x0062
            goto L_0x0067
        L_0x0062:
            java.lang.Integer r0 = createInteger(r17)
            return r0
        L_0x0067:
            java.lang.Long r0 = createLong(r17)
            return r0
        L_0x006c:
            java.math.BigInteger r0 = createBigInteger(r17)
            return r0
        L_0x0071:
            int r2 = r17.length()
            r5 = 1
            int r2 = r2 - r5
            char r2 = r0.charAt(r2)
            r6 = 46
            int r7 = r0.indexOf(r6)
            r8 = 101(0x65, float:1.42E-43)
            int r8 = r0.indexOf(r8)
            r9 = 69
            int r9 = r0.indexOf(r9)
            int r8 = r8 + r9
            int r8 = r8 + r5
            java.lang.String r9 = " is not a valid number."
            r10 = -1
            if (r7 <= r10) goto L_0x00c9
            if (r8 <= r10) goto L_0x00ba
            if (r8 < r7) goto L_0x00a5
            int r11 = r17.length()
            if (r8 > r11) goto L_0x00a5
            int r11 = r7 + 1
            java.lang.String r11 = r0.substring(r11, r8)
            goto L_0x00c0
        L_0x00a5:
            java.lang.NumberFormatException r1 = new java.lang.NumberFormatException
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            r2.append(r0)
            r2.append(r9)
            java.lang.String r0 = r2.toString()
            r1.<init>(r0)
            throw r1
        L_0x00ba:
            int r11 = r7 + 1
            java.lang.String r11 = r0.substring(r11)
        L_0x00c0:
            java.lang.String r7 = r0.substring(r3, r7)
            int r12 = r11.length()
            goto L_0x00ee
        L_0x00c9:
            if (r8 <= r10) goto L_0x00eb
            int r7 = r17.length()
            if (r8 > r7) goto L_0x00d6
            java.lang.String r7 = r0.substring(r3, r8)
            goto L_0x00ec
        L_0x00d6:
            java.lang.NumberFormatException r1 = new java.lang.NumberFormatException
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            r2.append(r0)
            r2.append(r9)
            java.lang.String r0 = r2.toString()
            r1.<init>(r0)
            throw r1
        L_0x00eb:
            r7 = r0
        L_0x00ec:
            r11 = r1
            r12 = r3
        L_0x00ee:
            boolean r13 = java.lang.Character.isDigit(r2)
            r14 = 0
            r15 = 0
            if (r13 != 0) goto L_0x01bc
            if (r2 == r6) goto L_0x01bc
            if (r8 <= r10) goto L_0x010c
            int r4 = r17.length()
            int r4 = r4 - r5
            if (r8 >= r4) goto L_0x010c
            int r8 = r8 + r5
            int r1 = r17.length()
            int r1 = r1 - r5
            java.lang.String r1 = r0.substring(r8, r1)
        L_0x010c:
            int r4 = r17.length()
            int r4 = r4 - r5
            java.lang.String r4 = r0.substring(r3, r4)
            boolean r6 = isAllZeros(r7)
            if (r6 == 0) goto L_0x0123
            boolean r6 = isAllZeros(r1)
            if (r6 == 0) goto L_0x0123
            r6 = r5
            goto L_0x0124
        L_0x0123:
            r6 = r3
        L_0x0124:
            r7 = 68
            if (r2 == r7) goto L_0x018c
            r7 = 70
            if (r2 == r7) goto L_0x0177
            r7 = 76
            if (r2 == r7) goto L_0x013c
            r7 = 100
            if (r2 == r7) goto L_0x018c
            r7 = 102(0x66, float:1.43E-43)
            if (r2 == r7) goto L_0x0177
            r6 = 108(0x6c, float:1.51E-43)
            if (r2 != r6) goto L_0x01a7
        L_0x013c:
            if (r11 != 0) goto L_0x0162
            if (r1 != 0) goto L_0x0162
            char r1 = r4.charAt(r3)
            r2 = 45
            if (r1 != r2) goto L_0x0152
            java.lang.String r1 = r4.substring(r5)
            boolean r1 = isDigits(r1)
            if (r1 != 0) goto L_0x0158
        L_0x0152:
            boolean r1 = isDigits(r4)
            if (r1 == 0) goto L_0x0162
        L_0x0158:
            java.lang.Long r0 = createLong(r4)     // Catch:{ NumberFormatException -> 0x015d }
            return r0
        L_0x015d:
            java.math.BigInteger r0 = createBigInteger(r4)
            return r0
        L_0x0162:
            java.lang.NumberFormatException r1 = new java.lang.NumberFormatException
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            r2.append(r0)
            r2.append(r9)
            java.lang.String r0 = r2.toString()
            r1.<init>(r0)
            throw r1
        L_0x0177:
            java.lang.Float r1 = createFloat(r4)     // Catch:{ NumberFormatException -> 0x018c }
            boolean r2 = r1.isInfinite()     // Catch:{ NumberFormatException -> 0x018c }
            if (r2 != 0) goto L_0x018c
            float r2 = r1.floatValue()     // Catch:{ NumberFormatException -> 0x018c }
            int r2 = (r2 > r14 ? 1 : (r2 == r14 ? 0 : -1))
            if (r2 != 0) goto L_0x018b
            if (r6 == 0) goto L_0x018c
        L_0x018b:
            return r1
        L_0x018c:
            java.lang.Double r1 = createDouble(r4)     // Catch:{ NumberFormatException -> 0x01a2 }
            boolean r2 = r1.isInfinite()     // Catch:{ NumberFormatException -> 0x01a2 }
            if (r2 != 0) goto L_0x01a2
            float r2 = r1.floatValue()     // Catch:{ NumberFormatException -> 0x01a2 }
            double r2 = (double) r2
            int r2 = (r2 > r15 ? 1 : (r2 == r15 ? 0 : -1))
            if (r2 != 0) goto L_0x01a1
            if (r6 == 0) goto L_0x01a2
        L_0x01a1:
            return r1
        L_0x01a2:
            java.math.BigDecimal r0 = createBigDecimal(r4)     // Catch:{ NumberFormatException -> 0x01a7 }
            return r0
        L_0x01a7:
            java.lang.NumberFormatException r1 = new java.lang.NumberFormatException
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            r2.append(r0)
            r2.append(r9)
            java.lang.String r0 = r2.toString()
            r1.<init>(r0)
            throw r1
        L_0x01bc:
            if (r8 <= r10) goto L_0x01ce
            int r2 = r17.length()
            int r2 = r2 - r5
            if (r8 >= r2) goto L_0x01ce
            int r8 = r8 + r5
            int r1 = r17.length()
            java.lang.String r1 = r0.substring(r8, r1)
        L_0x01ce:
            if (r11 != 0) goto L_0x01e1
            if (r1 != 0) goto L_0x01e1
            java.lang.Integer r0 = createInteger(r17)     // Catch:{ NumberFormatException -> 0x01d7 }
            return r0
        L_0x01d7:
            java.lang.Long r0 = createLong(r17)     // Catch:{ NumberFormatException -> 0x01dc }
            return r0
        L_0x01dc:
            java.math.BigInteger r0 = createBigInteger(r17)
            return r0
        L_0x01e1:
            boolean r2 = isAllZeros(r7)
            if (r2 == 0) goto L_0x01ee
            boolean r1 = isAllZeros(r1)
            if (r1 == 0) goto L_0x01ee
            r3 = r5
        L_0x01ee:
            r1 = 7
            if (r12 > r1) goto L_0x0206
            java.lang.Float r1 = createFloat(r17)     // Catch:{ NumberFormatException -> 0x0206 }
            boolean r2 = r1.isInfinite()     // Catch:{ NumberFormatException -> 0x0206 }
            if (r2 != 0) goto L_0x0206
            float r2 = r1.floatValue()     // Catch:{ NumberFormatException -> 0x0206 }
            int r2 = (r2 > r14 ? 1 : (r2 == r14 ? 0 : -1))
            if (r2 != 0) goto L_0x0205
            if (r3 == 0) goto L_0x0206
        L_0x0205:
            return r1
        L_0x0206:
            if (r12 > r4) goto L_0x021d
            java.lang.Double r1 = createDouble(r17)     // Catch:{ NumberFormatException -> 0x021d }
            boolean r2 = r1.isInfinite()     // Catch:{ NumberFormatException -> 0x021d }
            if (r2 != 0) goto L_0x021d
            double r4 = r1.doubleValue()     // Catch:{ NumberFormatException -> 0x021d }
            int r2 = (r4 > r15 ? 1 : (r4 == r15 ? 0 : -1))
            if (r2 != 0) goto L_0x021c
            if (r3 == 0) goto L_0x021d
        L_0x021c:
            return r1
        L_0x021d:
            java.math.BigDecimal r0 = createBigDecimal(r17)
            return r0
        L_0x0222:
            java.lang.NumberFormatException r0 = new java.lang.NumberFormatException
            java.lang.String r1 = "A blank string is not a valid number"
            r0.<init>(r1)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: org.apache.commons.lang3.math.NumberUtils.createNumber(java.lang.String):java.lang.Number");
    }

    private static boolean isAllZeros(String str) {
        if (str == null) {
            return true;
        }
        for (int length = str.length() - 1; length >= 0; length--) {
            if (str.charAt(length) != '0') {
                return false;
            }
        }
        if (str.length() > 0) {
            return true;
        }
        return false;
    }

    public static boolean isDigits(String str) {
        if (StringUtils.isEmpty(str)) {
            return false;
        }
        for (int i11 = 0; i11 < str.length(); i11++) {
            if (!Character.isDigit(str.charAt(i11))) {
                return false;
            }
        }
        return true;
    }

    public static boolean isNumber(String str) {
        int i11;
        if (StringUtils.isEmpty(str)) {
            return false;
        }
        char[] charArray = str.toCharArray();
        int length = charArray.length;
        boolean z11 = true;
        if (charArray[0] == '-') {
            i11 = 1;
        } else {
            i11 = 0;
        }
        int i12 = i11 + 1;
        if (length > i12 && charArray[i11] == '0') {
            char c11 = charArray[i12];
            if (c11 == 'x' || c11 == 'X') {
                int i13 = i11 + 2;
                if (i13 == length) {
                    return false;
                }
                while (i13 < charArray.length) {
                    char c12 = charArray[i13];
                    if ((c12 < '0' || c12 > '9') && ((c12 < 'a' || c12 > 'f') && (c12 < 'A' || c12 > 'F'))) {
                        return false;
                    }
                    i13++;
                }
                return true;
            } else if (Character.isDigit(c11)) {
                while (i12 < charArray.length) {
                    char c13 = charArray[i12];
                    if (c13 < '0' || c13 > '7') {
                        return false;
                    }
                    i12++;
                }
                return true;
            }
        }
        int i14 = length - 1;
        boolean z12 = false;
        boolean z13 = false;
        boolean z14 = false;
        boolean z15 = false;
        while (true) {
            if (i11 >= i14) {
                if (i11 >= i14 + 1 || !z12 || z13) {
                }
            }
            char c14 = charArray[i11];
            if (c14 >= '0' && c14 <= '9') {
                z12 = false;
                z13 = true;
            } else if (c14 == '.') {
                if (z15 || z14) {
                    return false;
                }
                z15 = true;
            } else if (c14 != 'e' && c14 != 'E') {
                if (c14 != '+') {
                    if (c14 != '-') {
                        return false;
                    }
                }
                if (!z12) {
                    return false;
                }
                z12 = false;
                z13 = false;
            } else if (z14 || !z13) {
                return false;
            } else {
                z12 = true;
                z14 = true;
            }
            i11++;
            z11 = true;
        }
        if (i11 < charArray.length) {
            char c15 = charArray[i11];
            if (c15 >= '0' && c15 <= '9') {
                return z11;
            }
            if (c15 == 'e' || c15 == 'E') {
                return false;
            }
            if (c15 == '.') {
                if (z15 || z14) {
                    return false;
                }
                return z13;
            } else if (!z12 && (c15 == 'd' || c15 == 'D' || c15 == 'f' || c15 == 'F')) {
                return z13;
            } else {
                if ((c15 == 'l' || c15 == 'L') && z13 && !z14 && !z15) {
                    return z11;
                }
                return false;
            }
        } else if (z12 || !z13) {
            return false;
        } else {
            return z11;
        }
    }

    public static byte max(byte b11, byte b12, byte b13) {
        if (b12 > b11) {
            b11 = b12;
        }
        return b13 > b11 ? b13 : b11;
    }

    public static int max(int i11, int i12, int i13) {
        if (i12 > i11) {
            i11 = i12;
        }
        return i13 > i11 ? i13 : i11;
    }

    public static long max(long j11, long j12, long j13) {
        if (j12 > j11) {
            j11 = j12;
        }
        return j13 > j11 ? j13 : j11;
    }

    public static long max(long[] jArr) {
        validateArray(jArr);
        long j11 = jArr[0];
        for (int i11 = 1; i11 < jArr.length; i11++) {
            long j12 = jArr[i11];
            if (j12 > j11) {
                j11 = j12;
            }
        }
        return j11;
    }

    public static short max(short s11, short s12, short s13) {
        if (s12 > s11) {
            s11 = s12;
        }
        return s13 > s11 ? s13 : s11;
    }

    public static byte min(byte b11, byte b12, byte b13) {
        if (b12 < b11) {
            b11 = b12;
        }
        return b13 < b11 ? b13 : b11;
    }

    public static int min(int i11, int i12, int i13) {
        if (i12 < i11) {
            i11 = i12;
        }
        return i13 < i11 ? i13 : i11;
    }

    public static long min(long j11, long j12, long j13) {
        if (j12 < j11) {
            j11 = j12;
        }
        return j13 < j11 ? j13 : j11;
    }

    public static long min(long[] jArr) {
        validateArray(jArr);
        long j11 = jArr[0];
        for (int i11 = 1; i11 < jArr.length; i11++) {
            long j12 = jArr[i11];
            if (j12 < j11) {
                j11 = j12;
            }
        }
        return j11;
    }

    public static short min(short s11, short s12, short s13) {
        if (s12 < s11) {
            s11 = s12;
        }
        return s13 < s11 ? s13 : s11;
    }

    public static byte toByte(String str) {
        return toByte(str, (byte) 0);
    }

    public static double toDouble(String str) {
        return toDouble(str, 0.0d);
    }

    public static float toFloat(String str) {
        return toFloat(str, 0.0f);
    }

    public static int toInt(String str) {
        return toInt(str, 0);
    }

    public static long toLong(String str) {
        return toLong(str, 0);
    }

    public static short toShort(String str) {
        return toShort(str, 0);
    }

    private static void validateArray(Object obj) {
        if (obj == null) {
            throw new IllegalArgumentException("The Array must not be null");
        } else if (Array.getLength(obj) == 0) {
            throw new IllegalArgumentException("Array cannot be empty.");
        }
    }

    public static byte toByte(String str, byte b11) {
        if (str == null) {
            return b11;
        }
        try {
            return Byte.parseByte(str);
        } catch (NumberFormatException unused) {
            return b11;
        }
    }

    public static double toDouble(String str, double d11) {
        if (str == null) {
            return d11;
        }
        try {
            return Double.parseDouble(str);
        } catch (NumberFormatException unused) {
            return d11;
        }
    }

    public static float toFloat(String str, float f11) {
        if (str == null) {
            return f11;
        }
        try {
            return Float.parseFloat(str);
        } catch (NumberFormatException unused) {
            return f11;
        }
    }

    public static int toInt(String str, int i11) {
        if (str == null) {
            return i11;
        }
        try {
            return Integer.parseInt(str);
        } catch (NumberFormatException unused) {
            return i11;
        }
    }

    public static long toLong(String str, long j11) {
        if (str == null) {
            return j11;
        }
        try {
            return Long.parseLong(str);
        } catch (NumberFormatException unused) {
            return j11;
        }
    }

    public static short toShort(String str, short s11) {
        if (str == null) {
            return s11;
        }
        try {
            return Short.parseShort(str);
        } catch (NumberFormatException unused) {
            return s11;
        }
    }

    public static int max(int[] iArr) {
        validateArray(iArr);
        int i11 = iArr[0];
        for (int i12 = 1; i12 < iArr.length; i12++) {
            int i13 = iArr[i12];
            if (i13 > i11) {
                i11 = i13;
            }
        }
        return i11;
    }

    public static int min(int[] iArr) {
        validateArray(iArr);
        int i11 = iArr[0];
        for (int i12 = 1; i12 < iArr.length; i12++) {
            int i13 = iArr[i12];
            if (i13 < i11) {
                i11 = i13;
            }
        }
        return i11;
    }

    public static short max(short[] sArr) {
        validateArray(sArr);
        short s11 = sArr[0];
        for (int i11 = 1; i11 < sArr.length; i11++) {
            short s12 = sArr[i11];
            if (s12 > s11) {
                s11 = s12;
            }
        }
        return s11;
    }

    public static short min(short[] sArr) {
        validateArray(sArr);
        short s11 = sArr[0];
        for (int i11 = 1; i11 < sArr.length; i11++) {
            short s12 = sArr[i11];
            if (s12 < s11) {
                s11 = s12;
            }
        }
        return s11;
    }

    public static byte max(byte[] bArr) {
        validateArray(bArr);
        byte b11 = bArr[0];
        for (int i11 = 1; i11 < bArr.length; i11++) {
            byte b12 = bArr[i11];
            if (b12 > b11) {
                b11 = b12;
            }
        }
        return b11;
    }

    public static byte min(byte[] bArr) {
        validateArray(bArr);
        byte b11 = bArr[0];
        for (int i11 = 1; i11 < bArr.length; i11++) {
            byte b12 = bArr[i11];
            if (b12 < b11) {
                b11 = b12;
            }
        }
        return b11;
    }

    public static double max(double[] dArr) {
        validateArray(dArr);
        double d11 = dArr[0];
        for (int i11 = 1; i11 < dArr.length; i11++) {
            if (Double.isNaN(dArr[i11])) {
                return Double.NaN;
            }
            double d12 = dArr[i11];
            if (d12 > d11) {
                d11 = d12;
            }
        }
        return d11;
    }

    public static double min(double[] dArr) {
        validateArray(dArr);
        double d11 = dArr[0];
        for (int i11 = 1; i11 < dArr.length; i11++) {
            if (Double.isNaN(dArr[i11])) {
                return Double.NaN;
            }
            double d12 = dArr[i11];
            if (d12 < d11) {
                d11 = d12;
            }
        }
        return d11;
    }

    public static float max(float[] fArr) {
        validateArray(fArr);
        float f11 = fArr[0];
        for (int i11 = 1; i11 < fArr.length; i11++) {
            if (Float.isNaN(fArr[i11])) {
                return Float.NaN;
            }
            float f12 = fArr[i11];
            if (f12 > f11) {
                f11 = f12;
            }
        }
        return f11;
    }

    public static float min(float[] fArr) {
        validateArray(fArr);
        float f11 = fArr[0];
        for (int i11 = 1; i11 < fArr.length; i11++) {
            if (Float.isNaN(fArr[i11])) {
                return Float.NaN;
            }
            float f12 = fArr[i11];
            if (f12 < f11) {
                f11 = f12;
            }
        }
        return f11;
    }

    public static double max(double d11, double d12, double d13) {
        return Math.max(Math.max(d11, d12), d13);
    }

    public static double min(double d11, double d12, double d13) {
        return Math.min(Math.min(d11, d12), d13);
    }

    public static float max(float f11, float f12, float f13) {
        return Math.max(Math.max(f11, f12), f13);
    }

    public static float min(float f11, float f12, float f13) {
        return Math.min(Math.min(f11, f12), f13);
    }
}
