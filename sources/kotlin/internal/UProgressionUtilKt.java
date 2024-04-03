package kotlin.internal;

import kotlin.Metadata;
import kotlin.PublishedApi;
import kotlin.SinceKotlin;
import kotlin.UInt;
import kotlin.ULong;
import kotlin.UnsignedKt;

@Metadata(d1 = {"\u0000 \n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\b\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\u001a*\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00012\u0006\u0010\u0003\u001a\u00020\u00012\u0006\u0010\u0004\u001a\u00020\u0001H\u0002ø\u0001\u0000¢\u0006\u0004\b\u0005\u0010\u0006\u001a*\u0010\u0000\u001a\u00020\u00072\u0006\u0010\u0002\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u00072\u0006\u0010\u0004\u001a\u00020\u0007H\u0002ø\u0001\u0000¢\u0006\u0004\b\b\u0010\t\u001a*\u0010\n\u001a\u00020\u00012\u0006\u0010\u000b\u001a\u00020\u00012\u0006\u0010\f\u001a\u00020\u00012\u0006\u0010\r\u001a\u00020\u000eH\u0001ø\u0001\u0000¢\u0006\u0004\b\u000f\u0010\u0006\u001a*\u0010\n\u001a\u00020\u00072\u0006\u0010\u000b\u001a\u00020\u00072\u0006\u0010\f\u001a\u00020\u00072\u0006\u0010\r\u001a\u00020\u0010H\u0001ø\u0001\u0000¢\u0006\u0004\b\u0011\u0010\t\u0002\u0004\n\u0002\b\u0019¨\u0006\u0012"}, d2 = {"differenceModulo", "Lkotlin/UInt;", "a", "b", "c", "differenceModulo-WZ9TVnA", "(III)I", "Lkotlin/ULong;", "differenceModulo-sambcqE", "(JJJ)J", "getProgressionLastElement", "start", "end", "step", "", "getProgressionLastElement-Nkh28Cs", "", "getProgressionLastElement-7ftBX0g", "kotlin-stdlib"}, k = 2, mv = {1, 7, 1}, xi = 48)
public final class UProgressionUtilKt {
    /* renamed from: differenceModulo-WZ9TVnA  reason: not valid java name */
    private static final int m7545differenceModuloWZ9TVnA(int i11, int i12, int i13) {
        int r12 = UnsignedKt.m6677uintRemainderJ1ME1BU(i11, i13);
        int r22 = UnsignedKt.m6677uintRemainderJ1ME1BU(i12, i13);
        int uintCompare = UnsignedKt.uintCompare(r12, r22);
        int r13 = UInt.m6423constructorimpl(r12 - r22);
        if (uintCompare >= 0) {
            return r13;
        }
        return UInt.m6423constructorimpl(r13 + i13);
    }

    /* renamed from: differenceModulo-sambcqE  reason: not valid java name */
    private static final long m7546differenceModulosambcqE(long j11, long j12, long j13) {
        long r12 = UnsignedKt.m6679ulongRemaindereb3DHEI(j11, j13);
        long r32 = UnsignedKt.m6679ulongRemaindereb3DHEI(j12, j13);
        int ulongCompare = UnsignedKt.ulongCompare(r12, r32);
        long r13 = ULong.m6501constructorimpl(r12 - r32);
        if (ulongCompare >= 0) {
            return r13;
        }
        return ULong.m6501constructorimpl(r13 + j13);
    }

    @SinceKotlin(version = "1.3")
    @PublishedApi
    /* renamed from: getProgressionLastElement-7ftBX0g  reason: not valid java name */
    public static final long m7547getProgressionLastElement7ftBX0g(long j11, long j12, long j13) {
        int i11 = (j13 > 0 ? 1 : (j13 == 0 ? 0 : -1));
        if (i11 > 0) {
            if (UnsignedKt.ulongCompare(j11, j12) >= 0) {
                return j12;
            }
            return ULong.m6501constructorimpl(j12 - m7546differenceModulosambcqE(j12, j11, ULong.m6501constructorimpl(j13)));
        } else if (i11 >= 0) {
            throw new IllegalArgumentException("Step is zero.");
        } else if (UnsignedKt.ulongCompare(j11, j12) <= 0) {
            return j12;
        } else {
            return ULong.m6501constructorimpl(j12 + m7546differenceModulosambcqE(j11, j12, ULong.m6501constructorimpl(-j13)));
        }
    }

    @SinceKotlin(version = "1.3")
    @PublishedApi
    /* renamed from: getProgressionLastElement-Nkh28Cs  reason: not valid java name */
    public static final int m7548getProgressionLastElementNkh28Cs(int i11, int i12, int i13) {
        if (i13 > 0) {
            if (UnsignedKt.uintCompare(i11, i12) >= 0) {
                return i12;
            }
            return UInt.m6423constructorimpl(i12 - m7545differenceModuloWZ9TVnA(i12, i11, UInt.m6423constructorimpl(i13)));
        } else if (i13 >= 0) {
            throw new IllegalArgumentException("Step is zero.");
        } else if (UnsignedKt.uintCompare(i11, i12) <= 0) {
            return i12;
        } else {
            return UInt.m6423constructorimpl(i12 + m7545differenceModuloWZ9TVnA(i11, i12, UInt.m6423constructorimpl(-i13)));
        }
    }
}
