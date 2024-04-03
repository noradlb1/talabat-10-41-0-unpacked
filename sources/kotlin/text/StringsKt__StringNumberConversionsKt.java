package kotlin.text;

import com.google.android.exoplayer2.C;
import kotlin.Metadata;
import kotlin.SinceKotlin;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000.\n\u0000\n\u0002\u0010\u0001\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0005\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0010\n\n\u0002\b\u0003\u001a\u0010\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\u0000\u001a\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0005*\u00020\u0003H\u0007¢\u0006\u0002\u0010\u0006\u001a\u001b\u0010\u0004\u001a\u0004\u0018\u00010\u0005*\u00020\u00032\u0006\u0010\u0007\u001a\u00020\bH\u0007¢\u0006\u0002\u0010\t\u001a\u0013\u0010\n\u001a\u0004\u0018\u00010\b*\u00020\u0003H\u0007¢\u0006\u0002\u0010\u000b\u001a\u001b\u0010\n\u001a\u0004\u0018\u00010\b*\u00020\u00032\u0006\u0010\u0007\u001a\u00020\bH\u0007¢\u0006\u0002\u0010\f\u001a\u0013\u0010\r\u001a\u0004\u0018\u00010\u000e*\u00020\u0003H\u0007¢\u0006\u0002\u0010\u000f\u001a\u001b\u0010\r\u001a\u0004\u0018\u00010\u000e*\u00020\u00032\u0006\u0010\u0007\u001a\u00020\bH\u0007¢\u0006\u0002\u0010\u0010\u001a\u0013\u0010\u0011\u001a\u0004\u0018\u00010\u0012*\u00020\u0003H\u0007¢\u0006\u0002\u0010\u0013\u001a\u001b\u0010\u0011\u001a\u0004\u0018\u00010\u0012*\u00020\u00032\u0006\u0010\u0007\u001a\u00020\bH\u0007¢\u0006\u0002\u0010\u0014¨\u0006\u0015"}, d2 = {"numberFormatError", "", "input", "", "toByteOrNull", "", "(Ljava/lang/String;)Ljava/lang/Byte;", "radix", "", "(Ljava/lang/String;I)Ljava/lang/Byte;", "toIntOrNull", "(Ljava/lang/String;)Ljava/lang/Integer;", "(Ljava/lang/String;I)Ljava/lang/Integer;", "toLongOrNull", "", "(Ljava/lang/String;)Ljava/lang/Long;", "(Ljava/lang/String;I)Ljava/lang/Long;", "toShortOrNull", "", "(Ljava/lang/String;)Ljava/lang/Short;", "(Ljava/lang/String;I)Ljava/lang/Short;", "kotlin-stdlib"}, k = 5, mv = {1, 7, 1}, xi = 49, xs = "kotlin/text/StringsKt")
class StringsKt__StringNumberConversionsKt extends StringsKt__StringNumberConversionsJVMKt {
    @NotNull
    public static final Void numberFormatError(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "input");
        throw new NumberFormatException("Invalid number format: '" + str + '\'');
    }

    @SinceKotlin(version = "1.1")
    @Nullable
    public static final Byte toByteOrNull(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "<this>");
        return toByteOrNull(str, 10);
    }

    @SinceKotlin(version = "1.1")
    @Nullable
    public static Integer toIntOrNull(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "<this>");
        return toIntOrNull(str, 10);
    }

    @SinceKotlin(version = "1.1")
    @Nullable
    public static Long toLongOrNull(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "<this>");
        return toLongOrNull(str, 10);
    }

    @SinceKotlin(version = "1.1")
    @Nullable
    public static final Short toShortOrNull(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "<this>");
        return toShortOrNull(str, 10);
    }

    @SinceKotlin(version = "1.1")
    @Nullable
    public static final Byte toByteOrNull(@NotNull String str, int i11) {
        int intValue;
        Intrinsics.checkNotNullParameter(str, "<this>");
        Integer intOrNull = toIntOrNull(str, i11);
        if (intOrNull == null || (intValue = intOrNull.intValue()) < -128 || intValue > 127) {
            return null;
        }
        return Byte.valueOf((byte) intValue);
    }

    @SinceKotlin(version = "1.1")
    @Nullable
    public static final Integer toIntOrNull(@NotNull String str, int i11) {
        int i12;
        boolean z11;
        int i13;
        Intrinsics.checkNotNullParameter(str, "<this>");
        int unused = CharsKt__CharJVMKt.checkRadix(i11);
        int length = str.length();
        if (length == 0) {
            return null;
        }
        int i14 = 0;
        char charAt = str.charAt(0);
        int compare = Intrinsics.compare((int) charAt, 48);
        int i15 = C.RATE_UNSET_INT;
        if (compare < 0) {
            i12 = 1;
            if (length == 1) {
                return null;
            }
            if (charAt == '-') {
                i15 = Integer.MIN_VALUE;
                z11 = true;
            } else if (charAt != '+') {
                return null;
            } else {
                z11 = false;
            }
        } else {
            z11 = false;
            i12 = 0;
        }
        int i16 = -59652323;
        while (i12 < length) {
            int digitOf = CharsKt__CharJVMKt.digitOf(str.charAt(i12), i11);
            if (digitOf < 0) {
                return null;
            }
            if ((i14 < i16 && (i16 != -59652323 || i14 < (i16 = i15 / i11))) || (i13 = i14 * i11) < i15 + digitOf) {
                return null;
            }
            i14 = i13 - digitOf;
            i12++;
        }
        return z11 ? Integer.valueOf(i14) : Integer.valueOf(-i14);
    }

    @SinceKotlin(version = "1.1")
    @Nullable
    public static final Long toLongOrNull(@NotNull String str, int i11) {
        boolean z11;
        String str2 = str;
        int i12 = i11;
        Intrinsics.checkNotNullParameter(str2, "<this>");
        int unused = CharsKt__CharJVMKt.checkRadix(i11);
        int length = str.length();
        if (length == 0) {
            return null;
        }
        int i13 = 0;
        char charAt = str2.charAt(0);
        int compare = Intrinsics.compare((int) charAt, 48);
        long j11 = C.TIME_UNSET;
        if (compare < 0) {
            z11 = true;
            if (length == 1) {
                return null;
            }
            if (charAt == '-') {
                j11 = Long.MIN_VALUE;
                i13 = 1;
            } else if (charAt != '+') {
                return null;
            } else {
                z11 = false;
                i13 = 1;
            }
        } else {
            z11 = false;
        }
        long j12 = -256204778801521550L;
        long j13 = 0;
        long j14 = -256204778801521550L;
        while (i13 < length) {
            int digitOf = CharsKt__CharJVMKt.digitOf(str2.charAt(i13), i12);
            if (digitOf < 0) {
                return null;
            }
            if (j13 < j14) {
                if (j14 == j12) {
                    j14 = j11 / ((long) i12);
                    if (j13 < j14) {
                    }
                }
                return null;
            }
            long j15 = j13 * ((long) i12);
            long j16 = (long) digitOf;
            if (j15 < j11 + j16) {
                return null;
            }
            j13 = j15 - j16;
            i13++;
            j12 = -256204778801521550L;
        }
        return z11 ? Long.valueOf(j13) : Long.valueOf(-j13);
    }

    @SinceKotlin(version = "1.1")
    @Nullable
    public static final Short toShortOrNull(@NotNull String str, int i11) {
        int intValue;
        Intrinsics.checkNotNullParameter(str, "<this>");
        Integer intOrNull = toIntOrNull(str, i11);
        if (intOrNull == null || (intValue = intOrNull.intValue()) < -32768 || intValue > 32767) {
            return null;
        }
        return Short.valueOf((short) intValue);
    }
}
