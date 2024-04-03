package kotlin.random;

import kotlin.ExperimentalUnsignedTypes;
import kotlin.Metadata;
import kotlin.SinceKotlin;
import kotlin.UByteArray;
import kotlin.UInt;
import kotlin.ULong;
import kotlin.UnsignedKt;
import kotlin.WasExperimental;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.UIntRange;
import kotlin.ranges.ULongRange;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000:\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u000f\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a\"\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0003H\u0000ø\u0001\u0000¢\u0006\u0004\b\u0005\u0010\u0006\u001a\"\u0010\u0007\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\b2\u0006\u0010\u0004\u001a\u00020\bH\u0000ø\u0001\u0000¢\u0006\u0004\b\t\u0010\n\u001a\u001c\u0010\u000b\u001a\u00020\f*\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000fH\u0007ø\u0001\u0000¢\u0006\u0002\u0010\u0010\u001a\u001e\u0010\u000b\u001a\u00020\f*\u00020\r2\u0006\u0010\u0011\u001a\u00020\fH\u0007ø\u0001\u0000¢\u0006\u0004\b\u0012\u0010\u0013\u001a2\u0010\u000b\u001a\u00020\f*\u00020\r2\u0006\u0010\u0011\u001a\u00020\f2\b\b\u0002\u0010\u0014\u001a\u00020\u000f2\b\b\u0002\u0010\u0015\u001a\u00020\u000fH\u0007ø\u0001\u0000¢\u0006\u0004\b\u0016\u0010\u0017\u001a\u0014\u0010\u0018\u001a\u00020\u0003*\u00020\rH\u0007ø\u0001\u0000¢\u0006\u0002\u0010\u0019\u001a\u001e\u0010\u0018\u001a\u00020\u0003*\u00020\r2\u0006\u0010\u0004\u001a\u00020\u0003H\u0007ø\u0001\u0000¢\u0006\u0004\b\u001a\u0010\u001b\u001a&\u0010\u0018\u001a\u00020\u0003*\u00020\r2\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0003H\u0007ø\u0001\u0000¢\u0006\u0004\b\u001c\u0010\u001d\u001a\u001c\u0010\u0018\u001a\u00020\u0003*\u00020\r2\u0006\u0010\u001e\u001a\u00020\u001fH\u0007ø\u0001\u0000¢\u0006\u0002\u0010 \u001a\u0014\u0010!\u001a\u00020\b*\u00020\rH\u0007ø\u0001\u0000¢\u0006\u0002\u0010\"\u001a\u001e\u0010!\u001a\u00020\b*\u00020\r2\u0006\u0010\u0004\u001a\u00020\bH\u0007ø\u0001\u0000¢\u0006\u0004\b#\u0010$\u001a&\u0010!\u001a\u00020\b*\u00020\r2\u0006\u0010\u0002\u001a\u00020\b2\u0006\u0010\u0004\u001a\u00020\bH\u0007ø\u0001\u0000¢\u0006\u0004\b%\u0010&\u001a\u001c\u0010!\u001a\u00020\b*\u00020\r2\u0006\u0010\u001e\u001a\u00020'H\u0007ø\u0001\u0000¢\u0006\u0002\u0010(\u0002\u0004\n\u0002\b\u0019¨\u0006)"}, d2 = {"checkUIntRangeBounds", "", "from", "Lkotlin/UInt;", "until", "checkUIntRangeBounds-J1ME1BU", "(II)V", "checkULongRangeBounds", "Lkotlin/ULong;", "checkULongRangeBounds-eb3DHEI", "(JJ)V", "nextUBytes", "Lkotlin/UByteArray;", "Lkotlin/random/Random;", "size", "", "(Lkotlin/random/Random;I)[B", "array", "nextUBytes-EVgfTAA", "(Lkotlin/random/Random;[B)[B", "fromIndex", "toIndex", "nextUBytes-Wvrt4B4", "(Lkotlin/random/Random;[BII)[B", "nextUInt", "(Lkotlin/random/Random;)I", "nextUInt-qCasIEU", "(Lkotlin/random/Random;I)I", "nextUInt-a8DCA5k", "(Lkotlin/random/Random;II)I", "range", "Lkotlin/ranges/UIntRange;", "(Lkotlin/random/Random;Lkotlin/ranges/UIntRange;)I", "nextULong", "(Lkotlin/random/Random;)J", "nextULong-V1Xi4fY", "(Lkotlin/random/Random;J)J", "nextULong-jmpaW-c", "(Lkotlin/random/Random;JJ)J", "Lkotlin/ranges/ULongRange;", "(Lkotlin/random/Random;Lkotlin/ranges/ULongRange;)J", "kotlin-stdlib"}, k = 2, mv = {1, 7, 1}, xi = 48)
public final class URandomKt {
    /* renamed from: checkUIntRangeBounds-J1ME1BU  reason: not valid java name */
    public static final void m7553checkUIntRangeBoundsJ1ME1BU(int i11, int i12) {
        if (!(UnsignedKt.uintCompare(i12, i11) > 0)) {
            throw new IllegalArgumentException(RandomKt.boundsErrorMessage(UInt.m6417boximpl(i11), UInt.m6417boximpl(i12)).toString());
        }
    }

    /* renamed from: checkULongRangeBounds-eb3DHEI  reason: not valid java name */
    public static final void m7554checkULongRangeBoundseb3DHEI(long j11, long j12) {
        if (!(UnsignedKt.ulongCompare(j12, j11) > 0)) {
            throw new IllegalArgumentException(RandomKt.boundsErrorMessage(ULong.m6495boximpl(j11), ULong.m6495boximpl(j12)).toString());
        }
    }

    @ExperimentalUnsignedTypes
    @NotNull
    @SinceKotlin(version = "1.3")
    public static final byte[] nextUBytes(@NotNull Random random, int i11) {
        Intrinsics.checkNotNullParameter(random, "<this>");
        return UByteArray.m6399constructorimpl(random.nextBytes(i11));
    }

    @ExperimentalUnsignedTypes
    @NotNull
    @SinceKotlin(version = "1.3")
    /* renamed from: nextUBytes-EVgfTAA  reason: not valid java name */
    public static final byte[] m7555nextUBytesEVgfTAA(@NotNull Random random, @NotNull byte[] bArr) {
        Intrinsics.checkNotNullParameter(random, "$this$nextUBytes");
        Intrinsics.checkNotNullParameter(bArr, "array");
        random.nextBytes(bArr);
        return bArr;
    }

    @ExperimentalUnsignedTypes
    @NotNull
    @SinceKotlin(version = "1.3")
    /* renamed from: nextUBytes-Wvrt4B4  reason: not valid java name */
    public static final byte[] m7556nextUBytesWvrt4B4(@NotNull Random random, @NotNull byte[] bArr, int i11, int i12) {
        Intrinsics.checkNotNullParameter(random, "$this$nextUBytes");
        Intrinsics.checkNotNullParameter(bArr, "array");
        random.nextBytes(bArr, i11, i12);
        return bArr;
    }

    /* renamed from: nextUBytes-Wvrt4B4$default  reason: not valid java name */
    public static /* synthetic */ byte[] m7557nextUBytesWvrt4B4$default(Random random, byte[] bArr, int i11, int i12, int i13, Object obj) {
        if ((i13 & 2) != 0) {
            i11 = 0;
        }
        if ((i13 & 4) != 0) {
            i12 = UByteArray.m6405getSizeimpl(bArr);
        }
        return m7556nextUBytesWvrt4B4(random, bArr, i11, i12);
    }

    @SinceKotlin(version = "1.5")
    @WasExperimental(markerClass = {ExperimentalUnsignedTypes.class})
    public static final int nextUInt(@NotNull Random random) {
        Intrinsics.checkNotNullParameter(random, "<this>");
        return UInt.m6423constructorimpl(random.nextInt());
    }

    @SinceKotlin(version = "1.5")
    @WasExperimental(markerClass = {ExperimentalUnsignedTypes.class})
    /* renamed from: nextUInt-a8DCA5k  reason: not valid java name */
    public static final int m7558nextUInta8DCA5k(@NotNull Random random, int i11, int i12) {
        Intrinsics.checkNotNullParameter(random, "$this$nextUInt");
        m7553checkUIntRangeBoundsJ1ME1BU(i11, i12);
        return UInt.m6423constructorimpl(random.nextInt(i11 ^ Integer.MIN_VALUE, i12 ^ Integer.MIN_VALUE) ^ Integer.MIN_VALUE);
    }

    @SinceKotlin(version = "1.5")
    @WasExperimental(markerClass = {ExperimentalUnsignedTypes.class})
    /* renamed from: nextUInt-qCasIEU  reason: not valid java name */
    public static final int m7559nextUIntqCasIEU(@NotNull Random random, int i11) {
        Intrinsics.checkNotNullParameter(random, "$this$nextUInt");
        return m7558nextUInta8DCA5k(random, 0, i11);
    }

    @SinceKotlin(version = "1.5")
    @WasExperimental(markerClass = {ExperimentalUnsignedTypes.class})
    public static final long nextULong(@NotNull Random random) {
        Intrinsics.checkNotNullParameter(random, "<this>");
        return ULong.m6501constructorimpl(random.nextLong());
    }

    @SinceKotlin(version = "1.5")
    @WasExperimental(markerClass = {ExperimentalUnsignedTypes.class})
    /* renamed from: nextULong-V1Xi4fY  reason: not valid java name */
    public static final long m7560nextULongV1Xi4fY(@NotNull Random random, long j11) {
        Intrinsics.checkNotNullParameter(random, "$this$nextULong");
        return m7561nextULongjmpaWc(random, 0, j11);
    }

    @SinceKotlin(version = "1.5")
    @WasExperimental(markerClass = {ExperimentalUnsignedTypes.class})
    /* renamed from: nextULong-jmpaW-c  reason: not valid java name */
    public static final long m7561nextULongjmpaWc(@NotNull Random random, long j11, long j12) {
        Intrinsics.checkNotNullParameter(random, "$this$nextULong");
        m7554checkULongRangeBoundseb3DHEI(j11, j12);
        return ULong.m6501constructorimpl(random.nextLong(j11 ^ Long.MIN_VALUE, j12 ^ Long.MIN_VALUE) ^ Long.MIN_VALUE);
    }

    @SinceKotlin(version = "1.5")
    @WasExperimental(markerClass = {ExperimentalUnsignedTypes.class})
    public static final int nextUInt(@NotNull Random random, @NotNull UIntRange uIntRange) {
        Intrinsics.checkNotNullParameter(random, "<this>");
        Intrinsics.checkNotNullParameter(uIntRange, BasketDeliveryFeeTiersInfoKeys.KEY_RANGE);
        if (uIntRange.isEmpty()) {
            throw new IllegalArgumentException("Cannot get random in empty range: " + uIntRange);
        } else if (UnsignedKt.uintCompare(uIntRange.m9026getLastpVg5ArA(), -1) < 0) {
            return m7558nextUInta8DCA5k(random, uIntRange.m9025getFirstpVg5ArA(), UInt.m6423constructorimpl(uIntRange.m9026getLastpVg5ArA() + 1));
        } else {
            if (UnsignedKt.uintCompare(uIntRange.m9025getFirstpVg5ArA(), 0) > 0) {
                return UInt.m6423constructorimpl(m7558nextUInta8DCA5k(random, UInt.m6423constructorimpl(uIntRange.m9025getFirstpVg5ArA() - 1), uIntRange.m9026getLastpVg5ArA()) + 1);
            }
            return nextUInt(random);
        }
    }

    @SinceKotlin(version = "1.5")
    @WasExperimental(markerClass = {ExperimentalUnsignedTypes.class})
    public static final long nextULong(@NotNull Random random, @NotNull ULongRange uLongRange) {
        Intrinsics.checkNotNullParameter(random, "<this>");
        Intrinsics.checkNotNullParameter(uLongRange, BasketDeliveryFeeTiersInfoKeys.KEY_RANGE);
        if (uLongRange.isEmpty()) {
            throw new IllegalArgumentException("Cannot get random in empty range: " + uLongRange);
        } else if (UnsignedKt.ulongCompare(uLongRange.m9035getLastsVKNKU(), -1) < 0) {
            return m7561nextULongjmpaWc(random, uLongRange.m9034getFirstsVKNKU(), ULong.m6501constructorimpl(uLongRange.m9035getLastsVKNKU() + ULong.m6501constructorimpl(((long) 1) & 4294967295L)));
        } else {
            if (UnsignedKt.ulongCompare(uLongRange.m9034getFirstsVKNKU(), 0) <= 0) {
                return nextULong(random);
            }
            long j11 = ((long) 1) & 4294967295L;
            return ULong.m6501constructorimpl(m7561nextULongjmpaWc(random, ULong.m6501constructorimpl(uLongRange.m9034getFirstsVKNKU() - ULong.m6501constructorimpl(j11)), uLongRange.m9035getLastsVKNKU()) + ULong.m6501constructorimpl(j11));
        }
    }
}
