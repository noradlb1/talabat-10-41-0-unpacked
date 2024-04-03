package kotlin;

import kotlin.jvm.JvmName;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u00000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0006\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\t\n\u0002\u0010\t\n\u0002\b\u0007\n\u0002\u0010\u000e\n\u0002\b\u0002\u001a\u0018\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\u0001ø\u0001\u0000¢\u0006\u0002\u0010\u0004\u001a\u0018\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0002\u001a\u00020\u0003H\u0001ø\u0001\u0000¢\u0006\u0002\u0010\u0007\u001a\u0018\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\u000b\u001a\u00020\tH\u0001\u001a\"\u0010\f\u001a\u00020\u00012\u0006\u0010\n\u001a\u00020\u00012\u0006\u0010\u000b\u001a\u00020\u0001H\u0001ø\u0001\u0000¢\u0006\u0004\b\r\u0010\u000e\u001a\"\u0010\u000f\u001a\u00020\u00012\u0006\u0010\n\u001a\u00020\u00012\u0006\u0010\u000b\u001a\u00020\u0001H\u0001ø\u0001\u0000¢\u0006\u0004\b\u0010\u0010\u000e\u001a\u0010\u0010\u0011\u001a\u00020\u00032\u0006\u0010\u0002\u001a\u00020\tH\u0001\u001a\u0018\u0010\u0012\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u00132\u0006\u0010\u000b\u001a\u00020\u0013H\u0001\u001a\"\u0010\u0014\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\u00062\u0006\u0010\u000b\u001a\u00020\u0006H\u0001ø\u0001\u0000¢\u0006\u0004\b\u0015\u0010\u0016\u001a\"\u0010\u0017\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\u00062\u0006\u0010\u000b\u001a\u00020\u0006H\u0001ø\u0001\u0000¢\u0006\u0004\b\u0018\u0010\u0016\u001a\u0010\u0010\u0019\u001a\u00020\u00032\u0006\u0010\u0002\u001a\u00020\u0013H\u0001\u001a\u0010\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u0002\u001a\u00020\u0013H\u0000\u001a\u0018\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u0002\u001a\u00020\u00132\u0006\u0010\u001c\u001a\u00020\tH\u0000\u0002\u0004\n\u0002\b\u0019¨\u0006\u001d"}, d2 = {"doubleToUInt", "Lkotlin/UInt;", "v", "", "(D)I", "doubleToULong", "Lkotlin/ULong;", "(D)J", "uintCompare", "", "v1", "v2", "uintDivide", "uintDivide-J1ME1BU", "(II)I", "uintRemainder", "uintRemainder-J1ME1BU", "uintToDouble", "ulongCompare", "", "ulongDivide", "ulongDivide-eb3DHEI", "(JJ)J", "ulongRemainder", "ulongRemainder-eb3DHEI", "ulongToDouble", "ulongToString", "", "base", "kotlin-stdlib"}, k = 2, mv = {1, 7, 1}, xi = 48)
@JvmName(name = "UnsignedKt")
public final class UnsignedKt {
    @PublishedApi
    public static final int doubleToUInt(double d11) {
        if (Double.isNaN(d11) || d11 <= uintToDouble(0)) {
            return 0;
        }
        if (d11 >= uintToDouble(-1)) {
            return -1;
        }
        if (d11 <= 2.147483647E9d) {
            return UInt.m6423constructorimpl((int) d11);
        }
        return UInt.m6423constructorimpl(UInt.m6423constructorimpl((int) (d11 - ((double) Integer.MAX_VALUE))) + UInt.m6423constructorimpl(Integer.MAX_VALUE));
    }

    @PublishedApi
    public static final long doubleToULong(double d11) {
        if (Double.isNaN(d11) || d11 <= ulongToDouble(0)) {
            return 0;
        }
        if (d11 >= ulongToDouble(-1)) {
            return -1;
        }
        if (d11 < 9.223372036854776E18d) {
            return ULong.m6501constructorimpl((long) d11);
        }
        return ULong.m6501constructorimpl(ULong.m6501constructorimpl((long) (d11 - 9.223372036854776E18d)) - Long.MIN_VALUE);
    }

    @PublishedApi
    public static final int uintCompare(int i11, int i12) {
        return Intrinsics.compare(i11 ^ Integer.MIN_VALUE, i12 ^ Integer.MIN_VALUE);
    }

    @PublishedApi
    /* renamed from: uintDivide-J1ME1BU  reason: not valid java name */
    public static final int m6676uintDivideJ1ME1BU(int i11, int i12) {
        return UInt.m6423constructorimpl((int) ((((long) i11) & 4294967295L) / (((long) i12) & 4294967295L)));
    }

    @PublishedApi
    /* renamed from: uintRemainder-J1ME1BU  reason: not valid java name */
    public static final int m6677uintRemainderJ1ME1BU(int i11, int i12) {
        return UInt.m6423constructorimpl((int) ((((long) i11) & 4294967295L) % (((long) i12) & 4294967295L)));
    }

    @PublishedApi
    public static final double uintToDouble(int i11) {
        return ((double) (Integer.MAX_VALUE & i11)) + (((double) ((i11 >>> 31) << 30)) * ((double) 2));
    }

    @PublishedApi
    public static final int ulongCompare(long j11, long j12) {
        return Intrinsics.compare(j11 ^ Long.MIN_VALUE, j12 ^ Long.MIN_VALUE);
    }

    @PublishedApi
    /* renamed from: ulongDivide-eb3DHEI  reason: not valid java name */
    public static final long m6678ulongDivideeb3DHEI(long j11, long j12) {
        if (j12 < 0) {
            if (ulongCompare(j11, j12) < 0) {
                return ULong.m6501constructorimpl(0);
            }
            return ULong.m6501constructorimpl(1);
        } else if (j11 >= 0) {
            return ULong.m6501constructorimpl(j11 / j12);
        } else {
            int i11 = 1;
            long j13 = ((j11 >>> 1) / j12) << 1;
            if (ulongCompare(ULong.m6501constructorimpl(j11 - (j13 * j12)), ULong.m6501constructorimpl(j12)) < 0) {
                i11 = 0;
            }
            return ULong.m6501constructorimpl(j13 + ((long) i11));
        }
    }

    @PublishedApi
    /* renamed from: ulongRemainder-eb3DHEI  reason: not valid java name */
    public static final long m6679ulongRemaindereb3DHEI(long j11, long j12) {
        if (j12 < 0) {
            if (ulongCompare(j11, j12) < 0) {
                return j11;
            }
            return ULong.m6501constructorimpl(j11 - j12);
        } else if (j11 >= 0) {
            return ULong.m6501constructorimpl(j11 % j12);
        } else {
            long j13 = j11 - ((((j11 >>> 1) / j12) << 1) * j12);
            if (ulongCompare(ULong.m6501constructorimpl(j13), ULong.m6501constructorimpl(j12)) < 0) {
                j12 = 0;
            }
            return ULong.m6501constructorimpl(j13 - j12);
        }
    }

    @PublishedApi
    public static final double ulongToDouble(long j11) {
        return (((double) (j11 >>> 11)) * ((double) 2048)) + ((double) (j11 & 2047));
    }

    @NotNull
    public static final String ulongToString(long j11) {
        return ulongToString(j11, 10);
    }

    @NotNull
    public static final String ulongToString(long j11, int i11) {
        if (j11 >= 0) {
            String l11 = Long.toString(j11, CharsKt__CharJVMKt.checkRadix(i11));
            Intrinsics.checkNotNullExpressionValue(l11, "toString(this, checkRadix(radix))");
            return l11;
        }
        long j12 = (long) i11;
        long j13 = ((j11 >>> 1) / j12) << 1;
        long j14 = j11 - (j13 * j12);
        if (j14 >= j12) {
            j14 -= j12;
            j13++;
        }
        StringBuilder sb2 = new StringBuilder();
        String l12 = Long.toString(j13, CharsKt__CharJVMKt.checkRadix(i11));
        Intrinsics.checkNotNullExpressionValue(l12, "toString(this, checkRadix(radix))");
        sb2.append(l12);
        String l13 = Long.toString(j14, CharsKt__CharJVMKt.checkRadix(i11));
        Intrinsics.checkNotNullExpressionValue(l13, "toString(this, checkRadix(radix))");
        sb2.append(l13);
        return sb2.toString();
    }
}
