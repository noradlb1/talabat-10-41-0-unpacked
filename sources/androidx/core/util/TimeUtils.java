package androidx.core.util;

import androidx.annotation.RestrictTo;
import java.io.PrintWriter;
import net.bytebuddy.asm.Advice;
import net.bytebuddy.jar.asm.signature.SignatureVisitor;

@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
public final class TimeUtils {
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public static final int HUNDRED_DAY_FIELD_LEN = 19;
    private static final int SECONDS_PER_DAY = 86400;
    private static final int SECONDS_PER_HOUR = 3600;
    private static final int SECONDS_PER_MINUTE = 60;
    private static char[] sFormatStr = new char[24];
    private static final Object sFormatSync = new Object();

    private TimeUtils() {
    }

    private static int accumField(int i11, int i12, boolean z11, int i13) {
        if (i11 > 99 || (z11 && i13 >= 3)) {
            return i12 + 3;
        }
        if (i11 > 9 || (z11 && i13 >= 2)) {
            return i12 + 2;
        }
        if (z11 || i11 > 0) {
            return i12 + 1;
        }
        return 0;
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public static void formatDuration(long j11, StringBuilder sb2) {
        synchronized (sFormatSync) {
            sb2.append(sFormatStr, 0, formatDurationLocked(j11, 0));
        }
    }

    private static int formatDurationLocked(long j11, int i11) {
        char c11;
        int i12;
        int i13;
        int i14;
        int i15;
        int i16;
        boolean z11;
        boolean z12;
        int i17;
        boolean z13;
        int i18;
        boolean z14;
        int i19;
        int i21;
        boolean z15;
        boolean z16;
        boolean z17;
        int i22;
        long j12 = j11;
        int i23 = i11;
        if (sFormatStr.length < i23) {
            sFormatStr = new char[i23];
        }
        char[] cArr = sFormatStr;
        int i24 = (j12 > 0 ? 1 : (j12 == 0 ? 0 : -1));
        if (i24 == 0) {
            int i25 = i23 - 1;
            while (i25 > 0) {
                cArr[0] = ' ';
            }
            cArr[0] = '0';
            return 1;
        }
        if (i24 > 0) {
            c11 = SignatureVisitor.EXTENDS;
        } else {
            j12 = -j12;
            c11 = SignatureVisitor.SUPER;
        }
        int i26 = (int) (j12 % 1000);
        int floor = (int) Math.floor((double) (j12 / 1000));
        if (floor > 86400) {
            i12 = floor / 86400;
            floor -= 86400 * i12;
        } else {
            i12 = 0;
        }
        if (floor > SECONDS_PER_HOUR) {
            i13 = floor / SECONDS_PER_HOUR;
            floor -= i13 * SECONDS_PER_HOUR;
        } else {
            i13 = 0;
        }
        if (floor > 60) {
            int i27 = floor / 60;
            i14 = floor - (i27 * 60);
            i15 = i27;
        } else {
            i14 = floor;
            i15 = 0;
        }
        if (i23 != 0) {
            int accumField = accumField(i12, 1, false, 0);
            if (accumField > 0) {
                z15 = true;
            } else {
                z15 = false;
            }
            int accumField2 = accumField + accumField(i13, 1, z15, 2);
            if (accumField2 > 0) {
                z16 = true;
            } else {
                z16 = false;
            }
            int accumField3 = accumField2 + accumField(i15, 1, z16, 2);
            if (accumField3 > 0) {
                z17 = true;
            } else {
                z17 = false;
            }
            int accumField4 = accumField3 + accumField(i14, 1, z17, 2);
            if (accumField4 > 0) {
                i22 = 3;
            } else {
                i22 = 0;
            }
            i16 = 0;
            for (int accumField5 = accumField4 + accumField(i26, 2, true, i22) + 1; accumField5 < i23; accumField5++) {
                cArr[i16] = ' ';
                i16++;
            }
        } else {
            i16 = 0;
        }
        cArr[i16] = c11;
        int i28 = i16 + 1;
        if (i23 != 0) {
            z11 = true;
        } else {
            z11 = false;
        }
        int i29 = i28;
        int printField = printField(cArr, i12, Advice.OffsetMapping.ForOrigin.Renderer.ForDescriptor.SYMBOL, i28, false, 0);
        if (printField != i29) {
            z12 = true;
        } else {
            z12 = false;
        }
        if (z11) {
            i17 = 2;
        } else {
            i17 = 0;
        }
        int printField2 = printField(cArr, i13, 'h', printField, z12, i17);
        if (printField2 != i29) {
            z13 = true;
        } else {
            z13 = false;
        }
        if (z11) {
            i18 = 2;
        } else {
            i18 = 0;
        }
        int printField3 = printField(cArr, i15, Advice.OffsetMapping.ForOrigin.Renderer.ForMethodName.SYMBOL, printField2, z13, i18);
        if (printField3 != i29) {
            z14 = true;
        } else {
            z14 = false;
        }
        if (z11) {
            i19 = 2;
        } else {
            i19 = 0;
        }
        int printField4 = printField(cArr, i14, Advice.OffsetMapping.ForOrigin.Renderer.ForJavaSignature.SYMBOL, printField3, z14, i19);
        if (!z11 || printField4 == i29) {
            i21 = 0;
        } else {
            i21 = 3;
        }
        int printField5 = printField(cArr, i26, Advice.OffsetMapping.ForOrigin.Renderer.ForMethodName.SYMBOL, printField4, true, i21);
        cArr[printField5] = Advice.OffsetMapping.ForOrigin.Renderer.ForJavaSignature.SYMBOL;
        return printField5 + 1;
    }

    private static int printField(char[] cArr, int i11, char c11, int i12, boolean z11, int i13) {
        int i14;
        if (!z11 && i11 <= 0) {
            return i12;
        }
        if ((!z11 || i13 < 3) && i11 <= 99) {
            i14 = i12;
        } else {
            int i15 = i11 / 100;
            cArr[i12] = (char) (i15 + 48);
            i14 = i12 + 1;
            i11 -= i15 * 100;
        }
        if ((z11 && i13 >= 2) || i11 > 9 || i12 != i14) {
            int i16 = i11 / 10;
            cArr[i14] = (char) (i16 + 48);
            i14++;
            i11 -= i16 * 10;
        }
        cArr[i14] = (char) (i11 + 48);
        int i17 = i14 + 1;
        cArr[i17] = c11;
        return i17 + 1;
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public static void formatDuration(long j11, PrintWriter printWriter, int i11) {
        synchronized (sFormatSync) {
            printWriter.print(new String(sFormatStr, 0, formatDurationLocked(j11, i11)));
        }
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public static void formatDuration(long j11, PrintWriter printWriter) {
        formatDuration(j11, printWriter, 0);
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public static void formatDuration(long j11, long j12, PrintWriter printWriter) {
        if (j11 == 0) {
            printWriter.print("--");
        } else {
            formatDuration(j11 - j12, printWriter, 0);
        }
    }
}
