package kotlin.collections;

import kotlin.ExperimentalUnsignedTypes;
import kotlin.Metadata;
import kotlin.UByteArray;
import kotlin.UIntArray;
import kotlin.ULongArray;
import kotlin.UShort;
import kotlin.UShortArray;
import kotlin.UnsignedKt;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u00000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0010\u001a*\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00012\u0006\u0010\u0005\u001a\u00020\u0001H\u0003ø\u0001\u0000¢\u0006\u0004\b\u0006\u0010\u0007\u001a*\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\b2\u0006\u0010\u0004\u001a\u00020\u00012\u0006\u0010\u0005\u001a\u00020\u0001H\u0003ø\u0001\u0000¢\u0006\u0004\b\t\u0010\n\u001a*\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u000b2\u0006\u0010\u0004\u001a\u00020\u00012\u0006\u0010\u0005\u001a\u00020\u0001H\u0003ø\u0001\u0000¢\u0006\u0004\b\f\u0010\r\u001a*\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u000e2\u0006\u0010\u0004\u001a\u00020\u00012\u0006\u0010\u0005\u001a\u00020\u0001H\u0003ø\u0001\u0000¢\u0006\u0004\b\u000f\u0010\u0010\u001a*\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00012\u0006\u0010\u0005\u001a\u00020\u0001H\u0003ø\u0001\u0000¢\u0006\u0004\b\u0013\u0010\u0014\u001a*\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0002\u001a\u00020\b2\u0006\u0010\u0004\u001a\u00020\u00012\u0006\u0010\u0005\u001a\u00020\u0001H\u0003ø\u0001\u0000¢\u0006\u0004\b\u0015\u0010\u0016\u001a*\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0002\u001a\u00020\u000b2\u0006\u0010\u0004\u001a\u00020\u00012\u0006\u0010\u0005\u001a\u00020\u0001H\u0003ø\u0001\u0000¢\u0006\u0004\b\u0017\u0010\u0018\u001a*\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0002\u001a\u00020\u000e2\u0006\u0010\u0004\u001a\u00020\u00012\u0006\u0010\u0005\u001a\u00020\u0001H\u0003ø\u0001\u0000¢\u0006\u0004\b\u0019\u0010\u001a\u001a*\u0010\u001b\u001a\u00020\u00122\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u001c\u001a\u00020\u00012\u0006\u0010\u001d\u001a\u00020\u0001H\u0001ø\u0001\u0000¢\u0006\u0004\b\u001e\u0010\u0014\u001a*\u0010\u001b\u001a\u00020\u00122\u0006\u0010\u0002\u001a\u00020\b2\u0006\u0010\u001c\u001a\u00020\u00012\u0006\u0010\u001d\u001a\u00020\u0001H\u0001ø\u0001\u0000¢\u0006\u0004\b\u001f\u0010\u0016\u001a*\u0010\u001b\u001a\u00020\u00122\u0006\u0010\u0002\u001a\u00020\u000b2\u0006\u0010\u001c\u001a\u00020\u00012\u0006\u0010\u001d\u001a\u00020\u0001H\u0001ø\u0001\u0000¢\u0006\u0004\b \u0010\u0018\u001a*\u0010\u001b\u001a\u00020\u00122\u0006\u0010\u0002\u001a\u00020\u000e2\u0006\u0010\u001c\u001a\u00020\u00012\u0006\u0010\u001d\u001a\u00020\u0001H\u0001ø\u0001\u0000¢\u0006\u0004\b!\u0010\u001a\u0002\u0004\n\u0002\b\u0019¨\u0006\""}, d2 = {"partition", "", "array", "Lkotlin/UByteArray;", "left", "right", "partition-4UcCI2c", "([BII)I", "Lkotlin/UIntArray;", "partition-oBK06Vg", "([III)I", "Lkotlin/ULongArray;", "partition--nroSd4", "([JII)I", "Lkotlin/UShortArray;", "partition-Aa5vz7o", "([SII)I", "quickSort", "", "quickSort-4UcCI2c", "([BII)V", "quickSort-oBK06Vg", "([III)V", "quickSort--nroSd4", "([JII)V", "quickSort-Aa5vz7o", "([SII)V", "sortArray", "fromIndex", "toIndex", "sortArray-4UcCI2c", "sortArray-oBK06Vg", "sortArray--nroSd4", "sortArray-Aa5vz7o", "kotlin-stdlib"}, k = 2, mv = {1, 7, 1}, xi = 48)
public final class UArraySortingKt {
    @ExperimentalUnsignedTypes
    /* renamed from: partition--nroSd4  reason: not valid java name */
    private static final int m6776partitionnroSd4(long[] jArr, int i11, int i12) {
        long j11 = ULongArray.m6560getsVKNKU(jArr, (i11 + i12) / 2);
        while (i11 <= i12) {
            while (UnsignedKt.ulongCompare(ULongArray.m6560getsVKNKU(jArr, i11), j11) < 0) {
                i11++;
            }
            while (UnsignedKt.ulongCompare(ULongArray.m6560getsVKNKU(jArr, i12), j11) > 0) {
                i12--;
            }
            if (i11 <= i12) {
                long j12 = ULongArray.m6560getsVKNKU(jArr, i11);
                ULongArray.m6565setk8EXiF4(jArr, i11, ULongArray.m6560getsVKNKU(jArr, i12));
                ULongArray.m6565setk8EXiF4(jArr, i12, j12);
                i11++;
                i12--;
            }
        }
        return i11;
    }

    @ExperimentalUnsignedTypes
    /* renamed from: partition-4UcCI2c  reason: not valid java name */
    private static final int m6777partition4UcCI2c(byte[] bArr, int i11, int i12) {
        byte b11;
        byte b12 = UByteArray.m6404getw2LRezQ(bArr, (i11 + i12) / 2);
        while (i11 <= i12) {
            while (true) {
                b11 = b12 & 255;
                if (Intrinsics.compare((int) UByteArray.m6404getw2LRezQ(bArr, i11) & 255, (int) b11) >= 0) {
                    break;
                }
                i11++;
            }
            while (Intrinsics.compare((int) UByteArray.m6404getw2LRezQ(bArr, i12) & 255, (int) b11) > 0) {
                i12--;
            }
            if (i11 <= i12) {
                byte b13 = UByteArray.m6404getw2LRezQ(bArr, i11);
                UByteArray.m6409setVurrAj0(bArr, i11, UByteArray.m6404getw2LRezQ(bArr, i12));
                UByteArray.m6409setVurrAj0(bArr, i12, b13);
                i11++;
                i12--;
            }
        }
        return i11;
    }

    @ExperimentalUnsignedTypes
    /* renamed from: partition-Aa5vz7o  reason: not valid java name */
    private static final int m6778partitionAa5vz7o(short[] sArr, int i11, int i12) {
        short s11;
        short s12 = UShortArray.m6664getMh2AYeg(sArr, (i11 + i12) / 2);
        while (i11 <= i12) {
            while (true) {
                short s13 = UShortArray.m6664getMh2AYeg(sArr, i11) & UShort.MAX_VALUE;
                s11 = s12 & UShort.MAX_VALUE;
                if (Intrinsics.compare((int) s13, (int) s11) >= 0) {
                    break;
                }
                i11++;
            }
            while (Intrinsics.compare((int) UShortArray.m6664getMh2AYeg(sArr, i12) & UShort.MAX_VALUE, (int) s11) > 0) {
                i12--;
            }
            if (i11 <= i12) {
                short s14 = UShortArray.m6664getMh2AYeg(sArr, i11);
                UShortArray.m6669set01HTLdE(sArr, i11, UShortArray.m6664getMh2AYeg(sArr, i12));
                UShortArray.m6669set01HTLdE(sArr, i12, s14);
                i11++;
                i12--;
            }
        }
        return i11;
    }

    @ExperimentalUnsignedTypes
    /* renamed from: partition-oBK06Vg  reason: not valid java name */
    private static final int m6779partitionoBK06Vg(int[] iArr, int i11, int i12) {
        int i13 = UIntArray.m6482getpVg5ArA(iArr, (i11 + i12) / 2);
        while (i11 <= i12) {
            while (UnsignedKt.uintCompare(UIntArray.m6482getpVg5ArA(iArr, i11), i13) < 0) {
                i11++;
            }
            while (UnsignedKt.uintCompare(UIntArray.m6482getpVg5ArA(iArr, i12), i13) > 0) {
                i12--;
            }
            if (i11 <= i12) {
                int i14 = UIntArray.m6482getpVg5ArA(iArr, i11);
                UIntArray.m6487setVXSXFK8(iArr, i11, UIntArray.m6482getpVg5ArA(iArr, i12));
                UIntArray.m6487setVXSXFK8(iArr, i12, i14);
                i11++;
                i12--;
            }
        }
        return i11;
    }

    @ExperimentalUnsignedTypes
    /* renamed from: quickSort--nroSd4  reason: not valid java name */
    private static final void m6780quickSortnroSd4(long[] jArr, int i11, int i12) {
        int r02 = m6776partitionnroSd4(jArr, i11, i12);
        int i13 = r02 - 1;
        if (i11 < i13) {
            m6780quickSortnroSd4(jArr, i11, i13);
        }
        if (r02 < i12) {
            m6780quickSortnroSd4(jArr, r02, i12);
        }
    }

    @ExperimentalUnsignedTypes
    /* renamed from: quickSort-4UcCI2c  reason: not valid java name */
    private static final void m6781quickSort4UcCI2c(byte[] bArr, int i11, int i12) {
        int r02 = m6777partition4UcCI2c(bArr, i11, i12);
        int i13 = r02 - 1;
        if (i11 < i13) {
            m6781quickSort4UcCI2c(bArr, i11, i13);
        }
        if (r02 < i12) {
            m6781quickSort4UcCI2c(bArr, r02, i12);
        }
    }

    @ExperimentalUnsignedTypes
    /* renamed from: quickSort-Aa5vz7o  reason: not valid java name */
    private static final void m6782quickSortAa5vz7o(short[] sArr, int i11, int i12) {
        int r02 = m6778partitionAa5vz7o(sArr, i11, i12);
        int i13 = r02 - 1;
        if (i11 < i13) {
            m6782quickSortAa5vz7o(sArr, i11, i13);
        }
        if (r02 < i12) {
            m6782quickSortAa5vz7o(sArr, r02, i12);
        }
    }

    @ExperimentalUnsignedTypes
    /* renamed from: quickSort-oBK06Vg  reason: not valid java name */
    private static final void m6783quickSortoBK06Vg(int[] iArr, int i11, int i12) {
        int r02 = m6779partitionoBK06Vg(iArr, i11, i12);
        int i13 = r02 - 1;
        if (i11 < i13) {
            m6783quickSortoBK06Vg(iArr, i11, i13);
        }
        if (r02 < i12) {
            m6783quickSortoBK06Vg(iArr, r02, i12);
        }
    }

    @ExperimentalUnsignedTypes
    /* renamed from: sortArray--nroSd4  reason: not valid java name */
    public static final void m6784sortArraynroSd4(@NotNull long[] jArr, int i11, int i12) {
        Intrinsics.checkNotNullParameter(jArr, "array");
        m6780quickSortnroSd4(jArr, i11, i12 - 1);
    }

    @ExperimentalUnsignedTypes
    /* renamed from: sortArray-4UcCI2c  reason: not valid java name */
    public static final void m6785sortArray4UcCI2c(@NotNull byte[] bArr, int i11, int i12) {
        Intrinsics.checkNotNullParameter(bArr, "array");
        m6781quickSort4UcCI2c(bArr, i11, i12 - 1);
    }

    @ExperimentalUnsignedTypes
    /* renamed from: sortArray-Aa5vz7o  reason: not valid java name */
    public static final void m6786sortArrayAa5vz7o(@NotNull short[] sArr, int i11, int i12) {
        Intrinsics.checkNotNullParameter(sArr, "array");
        m6782quickSortAa5vz7o(sArr, i11, i12 - 1);
    }

    @ExperimentalUnsignedTypes
    /* renamed from: sortArray-oBK06Vg  reason: not valid java name */
    public static final void m6787sortArrayoBK06Vg(@NotNull int[] iArr, int i11, int i12) {
        Intrinsics.checkNotNullParameter(iArr, "array");
        m6783quickSortoBK06Vg(iArr, i11, i12 - 1);
    }
}
