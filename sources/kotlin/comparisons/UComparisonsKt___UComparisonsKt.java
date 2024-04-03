package kotlin.comparisons;

import kotlin.ExperimentalUnsignedTypes;
import kotlin.Metadata;
import kotlin.SinceKotlin;
import kotlin.UByteArray;
import kotlin.UIntArray;
import kotlin.ULongArray;
import kotlin.UShort;
import kotlin.UShortArray;
import kotlin.UnsignedKt;
import kotlin.WasExperimental;
import kotlin.internal.InlineOnly;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000B\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0010\u001a\"\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00012\u0006\u0010\u0003\u001a\u00020\u0001H\u0007ø\u0001\u0000¢\u0006\u0004\b\u0004\u0010\u0005\u001a+\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00012\u0006\u0010\u0003\u001a\u00020\u00012\u0006\u0010\u0006\u001a\u00020\u0001H\bø\u0001\u0000¢\u0006\u0004\b\u0007\u0010\b\u001a&\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00012\n\u0010\t\u001a\u00020\n\"\u00020\u0001H\u0007ø\u0001\u0000¢\u0006\u0004\b\u000b\u0010\f\u001a\"\u0010\u0000\u001a\u00020\r2\u0006\u0010\u0002\u001a\u00020\r2\u0006\u0010\u0003\u001a\u00020\rH\u0007ø\u0001\u0000¢\u0006\u0004\b\u000e\u0010\u000f\u001a+\u0010\u0000\u001a\u00020\r2\u0006\u0010\u0002\u001a\u00020\r2\u0006\u0010\u0003\u001a\u00020\r2\u0006\u0010\u0006\u001a\u00020\rH\bø\u0001\u0000¢\u0006\u0004\b\u0010\u0010\u0011\u001a&\u0010\u0000\u001a\u00020\r2\u0006\u0010\u0002\u001a\u00020\r2\n\u0010\t\u001a\u00020\u0012\"\u00020\rH\u0007ø\u0001\u0000¢\u0006\u0004\b\u0013\u0010\u0014\u001a\"\u0010\u0000\u001a\u00020\u00152\u0006\u0010\u0002\u001a\u00020\u00152\u0006\u0010\u0003\u001a\u00020\u0015H\u0007ø\u0001\u0000¢\u0006\u0004\b\u0016\u0010\u0017\u001a+\u0010\u0000\u001a\u00020\u00152\u0006\u0010\u0002\u001a\u00020\u00152\u0006\u0010\u0003\u001a\u00020\u00152\u0006\u0010\u0006\u001a\u00020\u0015H\bø\u0001\u0000¢\u0006\u0004\b\u0018\u0010\u0019\u001a&\u0010\u0000\u001a\u00020\u00152\u0006\u0010\u0002\u001a\u00020\u00152\n\u0010\t\u001a\u00020\u001a\"\u00020\u0015H\u0007ø\u0001\u0000¢\u0006\u0004\b\u001b\u0010\u001c\u001a\"\u0010\u0000\u001a\u00020\u001d2\u0006\u0010\u0002\u001a\u00020\u001d2\u0006\u0010\u0003\u001a\u00020\u001dH\u0007ø\u0001\u0000¢\u0006\u0004\b\u001e\u0010\u001f\u001a+\u0010\u0000\u001a\u00020\u001d2\u0006\u0010\u0002\u001a\u00020\u001d2\u0006\u0010\u0003\u001a\u00020\u001d2\u0006\u0010\u0006\u001a\u00020\u001dH\bø\u0001\u0000¢\u0006\u0004\b \u0010!\u001a&\u0010\u0000\u001a\u00020\u001d2\u0006\u0010\u0002\u001a\u00020\u001d2\n\u0010\t\u001a\u00020\"\"\u00020\u001dH\u0007ø\u0001\u0000¢\u0006\u0004\b#\u0010$\u001a\"\u0010%\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00012\u0006\u0010\u0003\u001a\u00020\u0001H\u0007ø\u0001\u0000¢\u0006\u0004\b&\u0010\u0005\u001a+\u0010%\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00012\u0006\u0010\u0003\u001a\u00020\u00012\u0006\u0010\u0006\u001a\u00020\u0001H\bø\u0001\u0000¢\u0006\u0004\b'\u0010\b\u001a&\u0010%\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00012\n\u0010\t\u001a\u00020\n\"\u00020\u0001H\u0007ø\u0001\u0000¢\u0006\u0004\b(\u0010\f\u001a\"\u0010%\u001a\u00020\r2\u0006\u0010\u0002\u001a\u00020\r2\u0006\u0010\u0003\u001a\u00020\rH\u0007ø\u0001\u0000¢\u0006\u0004\b)\u0010\u000f\u001a+\u0010%\u001a\u00020\r2\u0006\u0010\u0002\u001a\u00020\r2\u0006\u0010\u0003\u001a\u00020\r2\u0006\u0010\u0006\u001a\u00020\rH\bø\u0001\u0000¢\u0006\u0004\b*\u0010\u0011\u001a&\u0010%\u001a\u00020\r2\u0006\u0010\u0002\u001a\u00020\r2\n\u0010\t\u001a\u00020\u0012\"\u00020\rH\u0007ø\u0001\u0000¢\u0006\u0004\b+\u0010\u0014\u001a\"\u0010%\u001a\u00020\u00152\u0006\u0010\u0002\u001a\u00020\u00152\u0006\u0010\u0003\u001a\u00020\u0015H\u0007ø\u0001\u0000¢\u0006\u0004\b,\u0010\u0017\u001a+\u0010%\u001a\u00020\u00152\u0006\u0010\u0002\u001a\u00020\u00152\u0006\u0010\u0003\u001a\u00020\u00152\u0006\u0010\u0006\u001a\u00020\u0015H\bø\u0001\u0000¢\u0006\u0004\b-\u0010\u0019\u001a&\u0010%\u001a\u00020\u00152\u0006\u0010\u0002\u001a\u00020\u00152\n\u0010\t\u001a\u00020\u001a\"\u00020\u0015H\u0007ø\u0001\u0000¢\u0006\u0004\b.\u0010\u001c\u001a\"\u0010%\u001a\u00020\u001d2\u0006\u0010\u0002\u001a\u00020\u001d2\u0006\u0010\u0003\u001a\u00020\u001dH\u0007ø\u0001\u0000¢\u0006\u0004\b/\u0010\u001f\u001a+\u0010%\u001a\u00020\u001d2\u0006\u0010\u0002\u001a\u00020\u001d2\u0006\u0010\u0003\u001a\u00020\u001d2\u0006\u0010\u0006\u001a\u00020\u001dH\bø\u0001\u0000¢\u0006\u0004\b0\u0010!\u001a&\u0010%\u001a\u00020\u001d2\u0006\u0010\u0002\u001a\u00020\u001d2\n\u0010\t\u001a\u00020\"\"\u00020\u001dH\u0007ø\u0001\u0000¢\u0006\u0004\b1\u0010$\u0002\u0004\n\u0002\b\u0019¨\u00062"}, d2 = {"maxOf", "Lkotlin/UByte;", "a", "b", "maxOf-Kr8caGY", "(BB)B", "c", "maxOf-b33U2AM", "(BBB)B", "other", "Lkotlin/UByteArray;", "maxOf-Wr6uiD8", "(B[B)B", "Lkotlin/UInt;", "maxOf-J1ME1BU", "(II)I", "maxOf-WZ9TVnA", "(III)I", "Lkotlin/UIntArray;", "maxOf-Md2H83M", "(I[I)I", "Lkotlin/ULong;", "maxOf-eb3DHEI", "(JJ)J", "maxOf-sambcqE", "(JJJ)J", "Lkotlin/ULongArray;", "maxOf-R03FKyM", "(J[J)J", "Lkotlin/UShort;", "maxOf-5PvTz6A", "(SS)S", "maxOf-VKSA0NQ", "(SSS)S", "Lkotlin/UShortArray;", "maxOf-t1qELG4", "(S[S)S", "minOf", "minOf-Kr8caGY", "minOf-b33U2AM", "minOf-Wr6uiD8", "minOf-J1ME1BU", "minOf-WZ9TVnA", "minOf-Md2H83M", "minOf-eb3DHEI", "minOf-sambcqE", "minOf-R03FKyM", "minOf-5PvTz6A", "minOf-VKSA0NQ", "minOf-t1qELG4", "kotlin-stdlib"}, k = 5, mv = {1, 7, 1}, xi = 49, xs = "kotlin/comparisons/UComparisonsKt")
class UComparisonsKt___UComparisonsKt {
    @SinceKotlin(version = "1.5")
    @WasExperimental(markerClass = {ExperimentalUnsignedTypes.class})
    /* renamed from: maxOf-5PvTz6A  reason: not valid java name */
    public static final short m7520maxOf5PvTz6A(short s11, short s12) {
        return Intrinsics.compare((int) s11 & UShort.MAX_VALUE, (int) 65535 & s12) >= 0 ? s11 : s12;
    }

    @SinceKotlin(version = "1.5")
    @WasExperimental(markerClass = {ExperimentalUnsignedTypes.class})
    /* renamed from: maxOf-J1ME1BU  reason: not valid java name */
    public static int m7521maxOfJ1ME1BU(int i11, int i12) {
        return UnsignedKt.uintCompare(i11, i12) >= 0 ? i11 : i12;
    }

    @SinceKotlin(version = "1.5")
    @WasExperimental(markerClass = {ExperimentalUnsignedTypes.class})
    /* renamed from: maxOf-Kr8caGY  reason: not valid java name */
    public static final byte m7522maxOfKr8caGY(byte b11, byte b12) {
        return Intrinsics.compare((int) b11 & 255, (int) b12 & 255) >= 0 ? b11 : b12;
    }

    @ExperimentalUnsignedTypes
    @SinceKotlin(version = "1.4")
    /* renamed from: maxOf-Md2H83M  reason: not valid java name */
    public static final int m7523maxOfMd2H83M(int i11, @NotNull int... iArr) {
        Intrinsics.checkNotNullParameter(iArr, "other");
        int r02 = UIntArray.m6483getSizeimpl(iArr);
        for (int i12 = 0; i12 < r02; i12++) {
            i11 = m7521maxOfJ1ME1BU(i11, UIntArray.m6482getpVg5ArA(iArr, i12));
        }
        return i11;
    }

    @ExperimentalUnsignedTypes
    @SinceKotlin(version = "1.4")
    /* renamed from: maxOf-R03FKyM  reason: not valid java name */
    public static final long m7524maxOfR03FKyM(long j11, @NotNull long... jArr) {
        Intrinsics.checkNotNullParameter(jArr, "other");
        int r02 = ULongArray.m6561getSizeimpl(jArr);
        for (int i11 = 0; i11 < r02; i11++) {
            j11 = m7529maxOfeb3DHEI(j11, ULongArray.m6560getsVKNKU(jArr, i11));
        }
        return j11;
    }

    @SinceKotlin(version = "1.5")
    @InlineOnly
    @WasExperimental(markerClass = {ExperimentalUnsignedTypes.class})
    /* renamed from: maxOf-VKSA0NQ  reason: not valid java name */
    private static final short m7525maxOfVKSA0NQ(short s11, short s12, short s13) {
        return m7520maxOf5PvTz6A(s11, m7520maxOf5PvTz6A(s12, s13));
    }

    @SinceKotlin(version = "1.5")
    @InlineOnly
    @WasExperimental(markerClass = {ExperimentalUnsignedTypes.class})
    /* renamed from: maxOf-WZ9TVnA  reason: not valid java name */
    private static final int m7526maxOfWZ9TVnA(int i11, int i12, int i13) {
        return m7521maxOfJ1ME1BU(i11, m7521maxOfJ1ME1BU(i12, i13));
    }

    @ExperimentalUnsignedTypes
    @SinceKotlin(version = "1.4")
    /* renamed from: maxOf-Wr6uiD8  reason: not valid java name */
    public static final byte m7527maxOfWr6uiD8(byte b11, @NotNull byte... bArr) {
        Intrinsics.checkNotNullParameter(bArr, "other");
        int r02 = UByteArray.m6405getSizeimpl(bArr);
        for (int i11 = 0; i11 < r02; i11++) {
            b11 = m7522maxOfKr8caGY(b11, UByteArray.m6404getw2LRezQ(bArr, i11));
        }
        return b11;
    }

    @SinceKotlin(version = "1.5")
    @InlineOnly
    @WasExperimental(markerClass = {ExperimentalUnsignedTypes.class})
    /* renamed from: maxOf-b33U2AM  reason: not valid java name */
    private static final byte m7528maxOfb33U2AM(byte b11, byte b12, byte b13) {
        return m7522maxOfKr8caGY(b11, m7522maxOfKr8caGY(b12, b13));
    }

    @SinceKotlin(version = "1.5")
    @WasExperimental(markerClass = {ExperimentalUnsignedTypes.class})
    /* renamed from: maxOf-eb3DHEI  reason: not valid java name */
    public static long m7529maxOfeb3DHEI(long j11, long j12) {
        return UnsignedKt.ulongCompare(j11, j12) >= 0 ? j11 : j12;
    }

    @SinceKotlin(version = "1.5")
    @InlineOnly
    @WasExperimental(markerClass = {ExperimentalUnsignedTypes.class})
    /* renamed from: maxOf-sambcqE  reason: not valid java name */
    private static final long m7530maxOfsambcqE(long j11, long j12, long j13) {
        return m7529maxOfeb3DHEI(j11, m7529maxOfeb3DHEI(j12, j13));
    }

    @ExperimentalUnsignedTypes
    @SinceKotlin(version = "1.4")
    /* renamed from: maxOf-t1qELG4  reason: not valid java name */
    public static final short m7531maxOft1qELG4(short s11, @NotNull short... sArr) {
        Intrinsics.checkNotNullParameter(sArr, "other");
        int r02 = UShortArray.m6665getSizeimpl(sArr);
        for (int i11 = 0; i11 < r02; i11++) {
            s11 = m7520maxOf5PvTz6A(s11, UShortArray.m6664getMh2AYeg(sArr, i11));
        }
        return s11;
    }

    @SinceKotlin(version = "1.5")
    @WasExperimental(markerClass = {ExperimentalUnsignedTypes.class})
    /* renamed from: minOf-5PvTz6A  reason: not valid java name */
    public static final short m7532minOf5PvTz6A(short s11, short s12) {
        return Intrinsics.compare((int) s11 & UShort.MAX_VALUE, (int) 65535 & s12) <= 0 ? s11 : s12;
    }

    @SinceKotlin(version = "1.5")
    @WasExperimental(markerClass = {ExperimentalUnsignedTypes.class})
    /* renamed from: minOf-J1ME1BU  reason: not valid java name */
    public static int m7533minOfJ1ME1BU(int i11, int i12) {
        return UnsignedKt.uintCompare(i11, i12) <= 0 ? i11 : i12;
    }

    @SinceKotlin(version = "1.5")
    @WasExperimental(markerClass = {ExperimentalUnsignedTypes.class})
    /* renamed from: minOf-Kr8caGY  reason: not valid java name */
    public static final byte m7534minOfKr8caGY(byte b11, byte b12) {
        return Intrinsics.compare((int) b11 & 255, (int) b12 & 255) <= 0 ? b11 : b12;
    }

    @ExperimentalUnsignedTypes
    @SinceKotlin(version = "1.4")
    /* renamed from: minOf-Md2H83M  reason: not valid java name */
    public static final int m7535minOfMd2H83M(int i11, @NotNull int... iArr) {
        Intrinsics.checkNotNullParameter(iArr, "other");
        int r02 = UIntArray.m6483getSizeimpl(iArr);
        for (int i12 = 0; i12 < r02; i12++) {
            i11 = m7533minOfJ1ME1BU(i11, UIntArray.m6482getpVg5ArA(iArr, i12));
        }
        return i11;
    }

    @ExperimentalUnsignedTypes
    @SinceKotlin(version = "1.4")
    /* renamed from: minOf-R03FKyM  reason: not valid java name */
    public static final long m7536minOfR03FKyM(long j11, @NotNull long... jArr) {
        Intrinsics.checkNotNullParameter(jArr, "other");
        int r02 = ULongArray.m6561getSizeimpl(jArr);
        for (int i11 = 0; i11 < r02; i11++) {
            j11 = m7541minOfeb3DHEI(j11, ULongArray.m6560getsVKNKU(jArr, i11));
        }
        return j11;
    }

    @SinceKotlin(version = "1.5")
    @InlineOnly
    @WasExperimental(markerClass = {ExperimentalUnsignedTypes.class})
    /* renamed from: minOf-VKSA0NQ  reason: not valid java name */
    private static final short m7537minOfVKSA0NQ(short s11, short s12, short s13) {
        return m7532minOf5PvTz6A(s11, m7532minOf5PvTz6A(s12, s13));
    }

    @SinceKotlin(version = "1.5")
    @InlineOnly
    @WasExperimental(markerClass = {ExperimentalUnsignedTypes.class})
    /* renamed from: minOf-WZ9TVnA  reason: not valid java name */
    private static final int m7538minOfWZ9TVnA(int i11, int i12, int i13) {
        return m7533minOfJ1ME1BU(i11, m7533minOfJ1ME1BU(i12, i13));
    }

    @ExperimentalUnsignedTypes
    @SinceKotlin(version = "1.4")
    /* renamed from: minOf-Wr6uiD8  reason: not valid java name */
    public static final byte m7539minOfWr6uiD8(byte b11, @NotNull byte... bArr) {
        Intrinsics.checkNotNullParameter(bArr, "other");
        int r02 = UByteArray.m6405getSizeimpl(bArr);
        for (int i11 = 0; i11 < r02; i11++) {
            b11 = m7534minOfKr8caGY(b11, UByteArray.m6404getw2LRezQ(bArr, i11));
        }
        return b11;
    }

    @SinceKotlin(version = "1.5")
    @InlineOnly
    @WasExperimental(markerClass = {ExperimentalUnsignedTypes.class})
    /* renamed from: minOf-b33U2AM  reason: not valid java name */
    private static final byte m7540minOfb33U2AM(byte b11, byte b12, byte b13) {
        return m7534minOfKr8caGY(b11, m7534minOfKr8caGY(b12, b13));
    }

    @SinceKotlin(version = "1.5")
    @WasExperimental(markerClass = {ExperimentalUnsignedTypes.class})
    /* renamed from: minOf-eb3DHEI  reason: not valid java name */
    public static long m7541minOfeb3DHEI(long j11, long j12) {
        return UnsignedKt.ulongCompare(j11, j12) <= 0 ? j11 : j12;
    }

    @SinceKotlin(version = "1.5")
    @InlineOnly
    @WasExperimental(markerClass = {ExperimentalUnsignedTypes.class})
    /* renamed from: minOf-sambcqE  reason: not valid java name */
    private static final long m7542minOfsambcqE(long j11, long j12, long j13) {
        return m7541minOfeb3DHEI(j11, m7541minOfeb3DHEI(j12, j13));
    }

    @ExperimentalUnsignedTypes
    @SinceKotlin(version = "1.4")
    /* renamed from: minOf-t1qELG4  reason: not valid java name */
    public static final short m7543minOft1qELG4(short s11, @NotNull short... sArr) {
        Intrinsics.checkNotNullParameter(sArr, "other");
        int r02 = UShortArray.m6665getSizeimpl(sArr);
        for (int i11 = 0; i11 < r02; i11++) {
            s11 = m7532minOf5PvTz6A(s11, UShortArray.m6664getMh2AYeg(sArr, i11));
        }
        return s11;
    }
}
