package org.apache.commons.lang3.time;

import androidx.exifinterface.media.ExifInterface;
import com.huawei.hms.flutter.map.constants.Param;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.TimeZone;
import org.apache.commons.lang3.StringUtils;

public class DurationFormatUtils {
    static final Object H = "H";
    public static final String ISO_EXTENDED_FORMAT_PATTERN = "'P'yyyy'Y'M'M'd'DT'H'H'm'M's.S'S'";
    static final Object M = "M";
    static final Object S = ExifInterface.LATITUDE_SOUTH;

    /* renamed from: d  reason: collision with root package name */
    static final Object f27848d = "d";

    /* renamed from: m  reason: collision with root package name */
    static final Object f27849m = "m";

    /* renamed from: s  reason: collision with root package name */
    static final Object f27850s = "s";

    /* renamed from: y  reason: collision with root package name */
    static final Object f27851y = Param.Y;

    public static class Token {
        private int count = 1;
        private final Object value;

        public Token(Object obj) {
            this.value = obj;
        }

        public static boolean a(Token[] tokenArr, Object obj) {
            for (Token c11 : tokenArr) {
                if (c11.c() == obj) {
                    return true;
                }
            }
            return false;
        }

        public int b() {
            return this.count;
        }

        public Object c() {
            return this.value;
        }

        public void d() {
            this.count++;
        }

        public boolean equals(Object obj) {
            if (!(obj instanceof Token)) {
                return false;
            }
            Token token = (Token) obj;
            if (this.value.getClass() != token.value.getClass() || this.count != token.count) {
                return false;
            }
            Object obj2 = this.value;
            if (obj2 instanceof StringBuilder) {
                return obj2.toString().equals(token.value.toString());
            }
            if (obj2 instanceof Number) {
                return obj2.equals(token.value);
            }
            if (obj2 == token.value) {
                return true;
            }
            return false;
        }

        public int hashCode() {
            return this.value.hashCode();
        }

        public String toString() {
            return StringUtils.repeat(this.value.toString(), this.count);
        }
    }

    public static String format(Token[] tokenArr, long j11, long j12, long j13, long j14, long j15, long j16, long j17, boolean z11) {
        int i11;
        int i12;
        long j18;
        long j19;
        Token[] tokenArr2 = tokenArr;
        long j21 = j17;
        boolean z12 = z11;
        StringBuilder sb2 = new StringBuilder();
        int length = tokenArr2.length;
        int i13 = 0;
        boolean z13 = false;
        while (i13 < length) {
            Token token = tokenArr2[i13];
            Object c11 = token.c();
            int b11 = token.b();
            if (c11 instanceof StringBuilder) {
                sb2.append(c11.toString());
                long j22 = j11;
                long j23 = j12;
                j18 = j21;
                i12 = length;
                i11 = i13;
            } else {
                if (c11 == f27851y) {
                    sb2.append(paddedValue(j11, z12, b11));
                    long j24 = j12;
                } else {
                    long j25 = j11;
                    if (c11 == M) {
                        sb2.append(paddedValue(j12, z12, b11));
                    } else {
                        long j26 = j12;
                        if (c11 == f27848d) {
                            i11 = i13;
                            sb2.append(paddedValue(j13, z12, b11));
                            j18 = j21;
                            i12 = length;
                            z13 = false;
                        } else {
                            i11 = i13;
                            long j27 = j13;
                            if (c11 == H) {
                                i12 = length;
                                sb2.append(paddedValue(j14, z12, b11));
                                long j28 = j15;
                            } else {
                                i12 = length;
                                long j29 = j14;
                                if (c11 == f27849m) {
                                    sb2.append(paddedValue(j15, z12, b11));
                                } else {
                                    long j31 = j15;
                                    if (c11 == f27850s) {
                                        sb2.append(paddedValue(j16, z12, b11));
                                        j18 = j17;
                                        z13 = true;
                                    } else {
                                        long j32 = j16;
                                        if (c11 == S) {
                                            if (z13) {
                                                int i14 = 3;
                                                if (z12) {
                                                    i14 = Math.max(3, b11);
                                                }
                                                j19 = j17;
                                                sb2.append(paddedValue(j19, true, i14));
                                            } else {
                                                j19 = j17;
                                                sb2.append(paddedValue(j19, z12, b11));
                                            }
                                            z13 = false;
                                        } else {
                                            j18 = j17;
                                        }
                                    }
                                    i13 = i11 + 1;
                                    j21 = j18;
                                    length = i12;
                                    tokenArr2 = tokenArr;
                                }
                            }
                            j19 = j21;
                            z13 = false;
                            i13 = i11 + 1;
                            j21 = j18;
                            length = i12;
                            tokenArr2 = tokenArr;
                        }
                    }
                }
                j18 = j21;
                i12 = length;
                i11 = i13;
                z13 = false;
            }
            long j33 = j15;
            i13 = i11 + 1;
            j21 = j18;
            length = i12;
            tokenArr2 = tokenArr;
        }
        return sb2.toString();
    }

    public static String formatDuration(long j11, String str) {
        return formatDuration(j11, str, true);
    }

    public static String formatDurationHMS(long j11) {
        return formatDuration(j11, "H:mm:ss.SSS");
    }

    public static String formatDurationISO(long j11) {
        return formatDuration(j11, ISO_EXTENDED_FORMAT_PATTERN, false);
    }

    public static String formatDurationWords(long j11, boolean z11, boolean z12) {
        String formatDuration = formatDuration(j11, "d' days 'H' hours 'm' minutes 's' seconds'");
        if (z11) {
            formatDuration = " " + formatDuration;
            String replaceOnce = StringUtils.replaceOnce(formatDuration, " 0 days", "");
            if (replaceOnce.length() != formatDuration.length()) {
                String replaceOnce2 = StringUtils.replaceOnce(replaceOnce, " 0 hours", "");
                if (replaceOnce2.length() != replaceOnce.length()) {
                    formatDuration = StringUtils.replaceOnce(replaceOnce2, " 0 minutes", "");
                    if (formatDuration.length() != formatDuration.length()) {
                        formatDuration = StringUtils.replaceOnce(formatDuration, " 0 seconds", "");
                    }
                } else {
                    formatDuration = replaceOnce;
                }
            }
            if (formatDuration.length() != 0) {
                formatDuration = formatDuration.substring(1);
            }
        }
        if (z12) {
            String replaceOnce3 = StringUtils.replaceOnce(formatDuration, " 0 seconds", "");
            if (replaceOnce3.length() != formatDuration.length()) {
                formatDuration = StringUtils.replaceOnce(replaceOnce3, " 0 minutes", "");
                if (formatDuration.length() != replaceOnce3.length()) {
                    String replaceOnce4 = StringUtils.replaceOnce(formatDuration, " 0 hours", "");
                    if (replaceOnce4.length() != formatDuration.length()) {
                        formatDuration = StringUtils.replaceOnce(replaceOnce4, " 0 days", "");
                    }
                } else {
                    formatDuration = replaceOnce3;
                }
            }
        }
        return StringUtils.replaceOnce(StringUtils.replaceOnce(StringUtils.replaceOnce(StringUtils.replaceOnce(" " + formatDuration, " 1 seconds", " 1 second"), " 1 minutes", " 1 minute"), " 1 hours", " 1 hour"), " 1 days", " 1 day").trim();
    }

    public static String formatPeriod(long j11, long j12, String str) {
        return formatPeriod(j11, j12, str, true, TimeZone.getDefault());
    }

    public static String formatPeriodISO(long j11, long j12) {
        return formatPeriod(j11, j12, ISO_EXTENDED_FORMAT_PATTERN, false, TimeZone.getDefault());
    }

    /* JADX WARNING: Removed duplicated region for block: B:37:0x0081  */
    /* JADX WARNING: Removed duplicated region for block: B:52:0x0097 A[SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static org.apache.commons.lang3.time.DurationFormatUtils.Token[] lexx(java.lang.String r9) {
        /*
            java.util.ArrayList r0 = new java.util.ArrayList
            int r1 = r9.length()
            r0.<init>(r1)
            r1 = 0
            r2 = 0
            r3 = r1
            r4 = r3
            r5 = r2
            r6 = r5
        L_0x000f:
            int r7 = r9.length()
            if (r3 >= r7) goto L_0x009b
            char r7 = r9.charAt(r3)
            r8 = 39
            if (r4 == 0) goto L_0x0024
            if (r7 == r8) goto L_0x0024
            r5.append(r7)
            goto L_0x0097
        L_0x0024:
            if (r7 == r8) goto L_0x006a
            r8 = 72
            if (r7 == r8) goto L_0x0067
            r8 = 77
            if (r7 == r8) goto L_0x0064
            r8 = 83
            if (r7 == r8) goto L_0x0061
            r8 = 100
            if (r7 == r8) goto L_0x005e
            r8 = 109(0x6d, float:1.53E-43)
            if (r7 == r8) goto L_0x005b
            r8 = 115(0x73, float:1.61E-43)
            if (r7 == r8) goto L_0x0058
            r8 = 121(0x79, float:1.7E-43)
            if (r7 == r8) goto L_0x0055
            if (r5 != 0) goto L_0x0051
            java.lang.StringBuilder r5 = new java.lang.StringBuilder
            r5.<init>()
            org.apache.commons.lang3.time.DurationFormatUtils$Token r8 = new org.apache.commons.lang3.time.DurationFormatUtils$Token
            r8.<init>(r5)
            r0.add(r8)
        L_0x0051:
            r5.append(r7)
            goto L_0x007e
        L_0x0055:
            java.lang.Object r7 = f27851y
            goto L_0x007f
        L_0x0058:
            java.lang.Object r7 = f27850s
            goto L_0x007f
        L_0x005b:
            java.lang.Object r7 = f27849m
            goto L_0x007f
        L_0x005e:
            java.lang.Object r7 = f27848d
            goto L_0x007f
        L_0x0061:
            java.lang.Object r7 = S
            goto L_0x007f
        L_0x0064:
            java.lang.Object r7 = M
            goto L_0x007f
        L_0x0067:
            java.lang.Object r7 = H
            goto L_0x007f
        L_0x006a:
            if (r4 == 0) goto L_0x0070
            r4 = r1
            r5 = r2
            r7 = r5
            goto L_0x007f
        L_0x0070:
            java.lang.StringBuilder r5 = new java.lang.StringBuilder
            r5.<init>()
            org.apache.commons.lang3.time.DurationFormatUtils$Token r4 = new org.apache.commons.lang3.time.DurationFormatUtils$Token
            r4.<init>(r5)
            r0.add(r4)
            r4 = 1
        L_0x007e:
            r7 = r2
        L_0x007f:
            if (r7 == 0) goto L_0x0097
            if (r6 == 0) goto L_0x008d
            java.lang.Object r5 = r6.c()
            if (r5 != r7) goto L_0x008d
            r6.d()
            goto L_0x0096
        L_0x008d:
            org.apache.commons.lang3.time.DurationFormatUtils$Token r5 = new org.apache.commons.lang3.time.DurationFormatUtils$Token
            r5.<init>(r7)
            r0.add(r5)
            r6 = r5
        L_0x0096:
            r5 = r2
        L_0x0097:
            int r3 = r3 + 1
            goto L_0x000f
        L_0x009b:
            if (r4 != 0) goto L_0x00aa
            int r9 = r0.size()
            org.apache.commons.lang3.time.DurationFormatUtils$Token[] r9 = new org.apache.commons.lang3.time.DurationFormatUtils.Token[r9]
            java.lang.Object[] r9 = r0.toArray(r9)
            org.apache.commons.lang3.time.DurationFormatUtils$Token[] r9 = (org.apache.commons.lang3.time.DurationFormatUtils.Token[]) r9
            return r9
        L_0x00aa:
            java.lang.IllegalArgumentException r0 = new java.lang.IllegalArgumentException
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            java.lang.String r2 = "Unmatched quote in format: "
            r1.append(r2)
            r1.append(r9)
            java.lang.String r9 = r1.toString()
            r0.<init>(r9)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: org.apache.commons.lang3.time.DurationFormatUtils.lexx(java.lang.String):org.apache.commons.lang3.time.DurationFormatUtils$Token[]");
    }

    private static String paddedValue(long j11, boolean z11, int i11) {
        String l11 = Long.toString(j11);
        if (z11) {
            return StringUtils.leftPad(l11, i11, '0');
        }
        return l11;
    }

    public static String formatDuration(long j11, String str, boolean z11) {
        long j12;
        long j13;
        long j14;
        long j15;
        long j16;
        long j17;
        Token[] lexx = lexx(str);
        if (Token.a(lexx, f27848d)) {
            j12 = j11 / 86400000;
            j13 = j11 - (86400000 * j12);
        } else {
            j13 = j11;
            j12 = 0;
        }
        if (Token.a(lexx, H)) {
            j14 = j13 / DateUtils.MILLIS_PER_HOUR;
            j13 -= DateUtils.MILLIS_PER_HOUR * j14;
        } else {
            j14 = 0;
        }
        if (Token.a(lexx, f27849m)) {
            j15 = j13 / 60000;
            j13 -= 60000 * j15;
        } else {
            j15 = 0;
        }
        if (Token.a(lexx, f27850s)) {
            long j18 = j13 / 1000;
            j16 = j13 - (1000 * j18);
            j17 = j18;
        } else {
            j17 = 0;
            j16 = j13;
        }
        return format(lexx, 0, 0, j12, j14, j15, j17, j16, z11);
    }

    public static String formatPeriod(long j11, long j12, String str, boolean z11, TimeZone timeZone) {
        int i11;
        Token[] lexx = lexx(str);
        Calendar instance = Calendar.getInstance(timeZone);
        instance.setTime(new Date(j11));
        Calendar instance2 = Calendar.getInstance(timeZone);
        instance2.setTime(new Date(j12));
        int i12 = instance2.get(14) - instance.get(14);
        int i13 = instance2.get(13) - instance.get(13);
        int i14 = instance2.get(12) - instance.get(12);
        int i15 = instance2.get(11) - instance.get(11);
        int i16 = instance2.get(5) - instance.get(5);
        int i17 = instance2.get(2) - instance.get(2);
        int i18 = instance2.get(1) - instance.get(1);
        while (i12 < 0) {
            i12 += 1000;
            i13--;
        }
        while (i13 < 0) {
            i13 += 60;
            i14--;
        }
        while (i14 < 0) {
            i14 += 60;
            i15--;
        }
        while (i15 < 0) {
            i15 += 24;
            i16--;
        }
        int i19 = 0;
        if (Token.a(lexx, M)) {
            while (i16 < 0) {
                i16 += instance.getActualMaximum(5);
                i17--;
                instance.add(2, 1);
            }
            while (i11 < 0) {
                i17 = i11 + 12;
                i18--;
            }
            if (!Token.a(lexx, f27851y) && i18 != 0) {
                while (i18 != 0) {
                    i11 += i18 * 12;
                    i18 = 0;
                }
            }
        } else {
            if (!Token.a(lexx, f27851y)) {
                int i21 = instance2.get(1);
                if (i17 < 0) {
                    i21--;
                }
                while (instance.get(1) != i21) {
                    int actualMaximum = i16 + (instance.getActualMaximum(6) - instance.get(6));
                    if ((instance instanceof GregorianCalendar) && instance.get(2) == 1 && instance.get(5) == 29) {
                        actualMaximum++;
                    }
                    instance.add(1, 1);
                    i16 = actualMaximum + instance.get(6);
                }
                i18 = 0;
            }
            while (instance.get(2) != instance2.get(2)) {
                i16 += instance.getActualMaximum(5);
                instance.add(2, 1);
            }
            i11 = 0;
            while (i16 < 0) {
                i16 += instance.getActualMaximum(5);
                i11--;
                instance.add(2, 1);
            }
        }
        if (!Token.a(lexx, f27848d)) {
            i15 += i16 * 24;
            i16 = 0;
        }
        if (!Token.a(lexx, H)) {
            i14 += i15 * 60;
            i15 = 0;
        }
        if (!Token.a(lexx, f27849m)) {
            i13 += i14 * 60;
            i14 = 0;
        }
        if (!Token.a(lexx, f27850s)) {
            i12 += i13 * 1000;
        } else {
            i19 = i13;
        }
        return format(lexx, (long) i18, (long) i11, (long) i16, (long) i15, (long) i14, (long) i19, (long) i12, z11);
    }
}
