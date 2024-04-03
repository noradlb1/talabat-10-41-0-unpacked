package kotlin.ranges;

import java.util.NoSuchElementException;
import kotlin.ExperimentalStdlibApi;
import kotlin.ExperimentalUnsignedTypes;
import kotlin.Metadata;
import kotlin.SinceKotlin;
import kotlin.UByte;
import kotlin.UInt;
import kotlin.ULong;
import kotlin.UShort;
import kotlin.UnsignedKt;
import kotlin.WasExperimental;
import kotlin.internal.InlineOnly;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.random.Random;
import kotlin.random.URandomKt;
import kotlin.ranges.UIntProgression;
import kotlin.ranges.ULongProgression;
import okhttp3.internal.ws.WebSocketProtocol;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0010\b\n\u0002\u0010\t\n\u0002\b\u0006\u001a\u001e\u0010\u0000\u001a\u00020\u0001*\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0001H\u0007ø\u0001\u0000¢\u0006\u0004\b\u0003\u0010\u0004\u001a\u001e\u0010\u0000\u001a\u00020\u0005*\u00020\u00052\u0006\u0010\u0002\u001a\u00020\u0005H\u0007ø\u0001\u0000¢\u0006\u0004\b\u0006\u0010\u0007\u001a\u001e\u0010\u0000\u001a\u00020\b*\u00020\b2\u0006\u0010\u0002\u001a\u00020\bH\u0007ø\u0001\u0000¢\u0006\u0004\b\t\u0010\n\u001a\u001e\u0010\u0000\u001a\u00020\u000b*\u00020\u000b2\u0006\u0010\u0002\u001a\u00020\u000bH\u0007ø\u0001\u0000¢\u0006\u0004\b\f\u0010\r\u001a\u001e\u0010\u000e\u001a\u00020\u0001*\u00020\u00012\u0006\u0010\u000f\u001a\u00020\u0001H\u0007ø\u0001\u0000¢\u0006\u0004\b\u0010\u0010\u0004\u001a\u001e\u0010\u000e\u001a\u00020\u0005*\u00020\u00052\u0006\u0010\u000f\u001a\u00020\u0005H\u0007ø\u0001\u0000¢\u0006\u0004\b\u0011\u0010\u0007\u001a\u001e\u0010\u000e\u001a\u00020\b*\u00020\b2\u0006\u0010\u000f\u001a\u00020\bH\u0007ø\u0001\u0000¢\u0006\u0004\b\u0012\u0010\n\u001a\u001e\u0010\u000e\u001a\u00020\u000b*\u00020\u000b2\u0006\u0010\u000f\u001a\u00020\u000bH\u0007ø\u0001\u0000¢\u0006\u0004\b\u0013\u0010\r\u001a&\u0010\u0014\u001a\u00020\u0001*\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00012\u0006\u0010\u000f\u001a\u00020\u0001H\u0007ø\u0001\u0000¢\u0006\u0004\b\u0015\u0010\u0016\u001a&\u0010\u0014\u001a\u00020\u0005*\u00020\u00052\u0006\u0010\u0002\u001a\u00020\u00052\u0006\u0010\u000f\u001a\u00020\u0005H\u0007ø\u0001\u0000¢\u0006\u0004\b\u0017\u0010\u0018\u001a$\u0010\u0014\u001a\u00020\u0005*\u00020\u00052\f\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u00050\u001aH\u0007ø\u0001\u0000¢\u0006\u0004\b\u001b\u0010\u001c\u001a&\u0010\u0014\u001a\u00020\b*\u00020\b2\u0006\u0010\u0002\u001a\u00020\b2\u0006\u0010\u000f\u001a\u00020\bH\u0007ø\u0001\u0000¢\u0006\u0004\b\u001d\u0010\u001e\u001a$\u0010\u0014\u001a\u00020\b*\u00020\b2\f\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\b0\u001aH\u0007ø\u0001\u0000¢\u0006\u0004\b\u001f\u0010 \u001a&\u0010\u0014\u001a\u00020\u000b*\u00020\u000b2\u0006\u0010\u0002\u001a\u00020\u000b2\u0006\u0010\u000f\u001a\u00020\u000bH\u0007ø\u0001\u0000¢\u0006\u0004\b!\u0010\"\u001a\u001f\u0010#\u001a\u00020$*\u00020%2\u0006\u0010&\u001a\u00020\u0001H\u0002ø\u0001\u0000¢\u0006\u0004\b'\u0010(\u001a\u001f\u0010#\u001a\u00020$*\u00020%2\b\u0010)\u001a\u0004\u0018\u00010\u0005H\nø\u0001\u0000¢\u0006\u0002\b*\u001a\u001f\u0010#\u001a\u00020$*\u00020%2\u0006\u0010&\u001a\u00020\bH\u0002ø\u0001\u0000¢\u0006\u0004\b+\u0010,\u001a\u001f\u0010#\u001a\u00020$*\u00020%2\u0006\u0010&\u001a\u00020\u000bH\u0002ø\u0001\u0000¢\u0006\u0004\b-\u0010.\u001a\u001f\u0010#\u001a\u00020$*\u00020/2\u0006\u0010&\u001a\u00020\u0001H\u0002ø\u0001\u0000¢\u0006\u0004\b0\u00101\u001a\u001f\u0010#\u001a\u00020$*\u00020/2\u0006\u0010&\u001a\u00020\u0005H\u0002ø\u0001\u0000¢\u0006\u0004\b2\u00103\u001a\u001f\u0010#\u001a\u00020$*\u00020/2\b\u0010)\u001a\u0004\u0018\u00010\bH\nø\u0001\u0000¢\u0006\u0002\b4\u001a\u001f\u0010#\u001a\u00020$*\u00020/2\u0006\u0010&\u001a\u00020\u000bH\u0002ø\u0001\u0000¢\u0006\u0004\b5\u00106\u001a\u001f\u00107\u001a\u000208*\u00020\u00012\u0006\u00109\u001a\u00020\u0001H\u0004ø\u0001\u0000¢\u0006\u0004\b:\u0010;\u001a\u001f\u00107\u001a\u000208*\u00020\u00052\u0006\u00109\u001a\u00020\u0005H\u0004ø\u0001\u0000¢\u0006\u0004\b<\u0010=\u001a\u001f\u00107\u001a\u00020>*\u00020\b2\u0006\u00109\u001a\u00020\bH\u0004ø\u0001\u0000¢\u0006\u0004\b?\u0010@\u001a\u001f\u00107\u001a\u000208*\u00020\u000b2\u0006\u00109\u001a\u00020\u000bH\u0004ø\u0001\u0000¢\u0006\u0004\bA\u0010B\u001a\u0014\u0010C\u001a\u00020\u0005*\u000208H\u0007ø\u0001\u0000¢\u0006\u0002\u0010D\u001a\u0014\u0010C\u001a\u00020\b*\u00020>H\u0007ø\u0001\u0000¢\u0006\u0002\u0010E\u001a\u0011\u0010F\u001a\u0004\u0018\u00010\u0005*\u000208H\u0007ø\u0001\u0000\u001a\u0011\u0010F\u001a\u0004\u0018\u00010\b*\u00020>H\u0007ø\u0001\u0000\u001a\u0014\u0010G\u001a\u00020\u0005*\u000208H\u0007ø\u0001\u0000¢\u0006\u0002\u0010D\u001a\u0014\u0010G\u001a\u00020\b*\u00020>H\u0007ø\u0001\u0000¢\u0006\u0002\u0010E\u001a\u0011\u0010H\u001a\u0004\u0018\u00010\u0005*\u000208H\u0007ø\u0001\u0000\u001a\u0011\u0010H\u001a\u0004\u0018\u00010\b*\u00020>H\u0007ø\u0001\u0000\u001a\u0015\u0010I\u001a\u00020\u0005*\u00020%H\bø\u0001\u0000¢\u0006\u0002\u0010J\u001a\u001c\u0010I\u001a\u00020\u0005*\u00020%2\u0006\u0010I\u001a\u00020KH\u0007ø\u0001\u0000¢\u0006\u0002\u0010L\u001a\u0015\u0010I\u001a\u00020\b*\u00020/H\bø\u0001\u0000¢\u0006\u0002\u0010M\u001a\u001c\u0010I\u001a\u00020\b*\u00020/2\u0006\u0010I\u001a\u00020KH\u0007ø\u0001\u0000¢\u0006\u0002\u0010N\u001a\u0012\u0010O\u001a\u0004\u0018\u00010\u0005*\u00020%H\bø\u0001\u0000\u001a\u0019\u0010O\u001a\u0004\u0018\u00010\u0005*\u00020%2\u0006\u0010I\u001a\u00020KH\u0007ø\u0001\u0000\u001a\u0012\u0010O\u001a\u0004\u0018\u00010\b*\u00020/H\bø\u0001\u0000\u001a\u0019\u0010O\u001a\u0004\u0018\u00010\b*\u00020/2\u0006\u0010I\u001a\u00020KH\u0007ø\u0001\u0000\u001a\u001f\u0010P\u001a\u00020%*\u00020\u00012\u0006\u00109\u001a\u00020\u0001H\nø\u0001\u0000¢\u0006\u0004\bQ\u0010R\u001a\u001f\u0010P\u001a\u00020%*\u00020\u00052\u0006\u00109\u001a\u00020\u0005H\nø\u0001\u0000¢\u0006\u0004\bS\u0010T\u001a\u001f\u0010P\u001a\u00020/*\u00020\b2\u0006\u00109\u001a\u00020\bH\nø\u0001\u0000¢\u0006\u0004\bU\u0010V\u001a\u001f\u0010P\u001a\u00020%*\u00020\u000b2\u0006\u00109\u001a\u00020\u000bH\nø\u0001\u0000¢\u0006\u0004\bW\u0010X\u001a\f\u0010Y\u001a\u000208*\u000208H\u0007\u001a\f\u0010Y\u001a\u00020>*\u00020>H\u0007\u001a\u0015\u0010Z\u001a\u000208*\u0002082\u0006\u0010Z\u001a\u00020[H\u0004\u001a\u0015\u0010Z\u001a\u00020>*\u00020>2\u0006\u0010Z\u001a\u00020\\H\u0004\u001a\u001f\u0010]\u001a\u00020%*\u00020\u00012\u0006\u00109\u001a\u00020\u0001H\u0004ø\u0001\u0000¢\u0006\u0004\b^\u0010R\u001a\u001f\u0010]\u001a\u00020%*\u00020\u00052\u0006\u00109\u001a\u00020\u0005H\u0004ø\u0001\u0000¢\u0006\u0004\b_\u0010T\u001a\u001f\u0010]\u001a\u00020/*\u00020\b2\u0006\u00109\u001a\u00020\bH\u0004ø\u0001\u0000¢\u0006\u0004\b`\u0010V\u001a\u001f\u0010]\u001a\u00020%*\u00020\u000b2\u0006\u00109\u001a\u00020\u000bH\u0004ø\u0001\u0000¢\u0006\u0004\ba\u0010X\u0002\u0004\n\u0002\b\u0019¨\u0006b"}, d2 = {"coerceAtLeast", "Lkotlin/UByte;", "minimumValue", "coerceAtLeast-Kr8caGY", "(BB)B", "Lkotlin/UInt;", "coerceAtLeast-J1ME1BU", "(II)I", "Lkotlin/ULong;", "coerceAtLeast-eb3DHEI", "(JJ)J", "Lkotlin/UShort;", "coerceAtLeast-5PvTz6A", "(SS)S", "coerceAtMost", "maximumValue", "coerceAtMost-Kr8caGY", "coerceAtMost-J1ME1BU", "coerceAtMost-eb3DHEI", "coerceAtMost-5PvTz6A", "coerceIn", "coerceIn-b33U2AM", "(BBB)B", "coerceIn-WZ9TVnA", "(III)I", "range", "Lkotlin/ranges/ClosedRange;", "coerceIn-wuiCnnA", "(ILkotlin/ranges/ClosedRange;)I", "coerceIn-sambcqE", "(JJJ)J", "coerceIn-JPwROB0", "(JLkotlin/ranges/ClosedRange;)J", "coerceIn-VKSA0NQ", "(SSS)S", "contains", "", "Lkotlin/ranges/UIntRange;", "value", "contains-68kG9v0", "(Lkotlin/ranges/UIntRange;B)Z", "element", "contains-biwQdVI", "contains-fz5IDCE", "(Lkotlin/ranges/UIntRange;J)Z", "contains-ZsK3CEQ", "(Lkotlin/ranges/UIntRange;S)Z", "Lkotlin/ranges/ULongRange;", "contains-ULb-yJY", "(Lkotlin/ranges/ULongRange;B)Z", "contains-Gab390E", "(Lkotlin/ranges/ULongRange;I)Z", "contains-GYNo2lE", "contains-uhHAxoY", "(Lkotlin/ranges/ULongRange;S)Z", "downTo", "Lkotlin/ranges/UIntProgression;", "to", "downTo-Kr8caGY", "(BB)Lkotlin/ranges/UIntProgression;", "downTo-J1ME1BU", "(II)Lkotlin/ranges/UIntProgression;", "Lkotlin/ranges/ULongProgression;", "downTo-eb3DHEI", "(JJ)Lkotlin/ranges/ULongProgression;", "downTo-5PvTz6A", "(SS)Lkotlin/ranges/UIntProgression;", "first", "(Lkotlin/ranges/UIntProgression;)I", "(Lkotlin/ranges/ULongProgression;)J", "firstOrNull", "last", "lastOrNull", "random", "(Lkotlin/ranges/UIntRange;)I", "Lkotlin/random/Random;", "(Lkotlin/ranges/UIntRange;Lkotlin/random/Random;)I", "(Lkotlin/ranges/ULongRange;)J", "(Lkotlin/ranges/ULongRange;Lkotlin/random/Random;)J", "randomOrNull", "rangeUntil", "rangeUntil-Kr8caGY", "(BB)Lkotlin/ranges/UIntRange;", "rangeUntil-J1ME1BU", "(II)Lkotlin/ranges/UIntRange;", "rangeUntil-eb3DHEI", "(JJ)Lkotlin/ranges/ULongRange;", "rangeUntil-5PvTz6A", "(SS)Lkotlin/ranges/UIntRange;", "reversed", "step", "", "", "until", "until-Kr8caGY", "until-J1ME1BU", "until-eb3DHEI", "until-5PvTz6A", "kotlin-stdlib"}, k = 5, mv = {1, 7, 1}, xi = 49, xs = "kotlin/ranges/URangesKt")
class URangesKt___URangesKt {
    @SinceKotlin(version = "1.5")
    @WasExperimental(markerClass = {ExperimentalUnsignedTypes.class})
    /* renamed from: coerceAtLeast-5PvTz6A  reason: not valid java name */
    public static final short m9043coerceAtLeast5PvTz6A(short s11, short s12) {
        return Intrinsics.compare((int) s11 & UShort.MAX_VALUE, (int) 65535 & s12) < 0 ? s12 : s11;
    }

    @SinceKotlin(version = "1.5")
    @WasExperimental(markerClass = {ExperimentalUnsignedTypes.class})
    /* renamed from: coerceAtLeast-J1ME1BU  reason: not valid java name */
    public static final int m9044coerceAtLeastJ1ME1BU(int i11, int i12) {
        return UnsignedKt.uintCompare(i11, i12) < 0 ? i12 : i11;
    }

    @SinceKotlin(version = "1.5")
    @WasExperimental(markerClass = {ExperimentalUnsignedTypes.class})
    /* renamed from: coerceAtLeast-Kr8caGY  reason: not valid java name */
    public static final byte m9045coerceAtLeastKr8caGY(byte b11, byte b12) {
        return Intrinsics.compare((int) b11 & 255, (int) b12 & 255) < 0 ? b12 : b11;
    }

    @SinceKotlin(version = "1.5")
    @WasExperimental(markerClass = {ExperimentalUnsignedTypes.class})
    /* renamed from: coerceAtLeast-eb3DHEI  reason: not valid java name */
    public static final long m9046coerceAtLeasteb3DHEI(long j11, long j12) {
        return UnsignedKt.ulongCompare(j11, j12) < 0 ? j12 : j11;
    }

    @SinceKotlin(version = "1.5")
    @WasExperimental(markerClass = {ExperimentalUnsignedTypes.class})
    /* renamed from: coerceAtMost-5PvTz6A  reason: not valid java name */
    public static final short m9047coerceAtMost5PvTz6A(short s11, short s12) {
        return Intrinsics.compare((int) s11 & UShort.MAX_VALUE, (int) 65535 & s12) > 0 ? s12 : s11;
    }

    @SinceKotlin(version = "1.5")
    @WasExperimental(markerClass = {ExperimentalUnsignedTypes.class})
    /* renamed from: coerceAtMost-J1ME1BU  reason: not valid java name */
    public static final int m9048coerceAtMostJ1ME1BU(int i11, int i12) {
        return UnsignedKt.uintCompare(i11, i12) > 0 ? i12 : i11;
    }

    @SinceKotlin(version = "1.5")
    @WasExperimental(markerClass = {ExperimentalUnsignedTypes.class})
    /* renamed from: coerceAtMost-Kr8caGY  reason: not valid java name */
    public static final byte m9049coerceAtMostKr8caGY(byte b11, byte b12) {
        return Intrinsics.compare((int) b11 & 255, (int) b12 & 255) > 0 ? b12 : b11;
    }

    @SinceKotlin(version = "1.5")
    @WasExperimental(markerClass = {ExperimentalUnsignedTypes.class})
    /* renamed from: coerceAtMost-eb3DHEI  reason: not valid java name */
    public static final long m9050coerceAtMosteb3DHEI(long j11, long j12) {
        return UnsignedKt.ulongCompare(j11, j12) > 0 ? j12 : j11;
    }

    @SinceKotlin(version = "1.5")
    @WasExperimental(markerClass = {ExperimentalUnsignedTypes.class})
    /* renamed from: coerceIn-JPwROB0  reason: not valid java name */
    public static final long m9051coerceInJPwROB0(long j11, @NotNull ClosedRange<ULong> closedRange) {
        Intrinsics.checkNotNullParameter(closedRange, BasketDeliveryFeeTiersInfoKeys.KEY_RANGE);
        if (closedRange instanceof ClosedFloatingPointRange) {
            return ((ULong) RangesKt___RangesKt.coerceIn(ULong.m6495boximpl(j11), (ClosedFloatingPointRange) closedRange)).m6552unboximpl();
        }
        if (closedRange.isEmpty()) {
            throw new IllegalArgumentException("Cannot coerce value to an empty range: " + closedRange + '.');
        } else if (UnsignedKt.ulongCompare(j11, closedRange.getStart().m6552unboximpl()) < 0) {
            return closedRange.getStart().m6552unboximpl();
        } else {
            if (UnsignedKt.ulongCompare(j11, closedRange.getEndInclusive().m6552unboximpl()) > 0) {
                return closedRange.getEndInclusive().m6552unboximpl();
            }
            return j11;
        }
    }

    @SinceKotlin(version = "1.5")
    @WasExperimental(markerClass = {ExperimentalUnsignedTypes.class})
    /* renamed from: coerceIn-VKSA0NQ  reason: not valid java name */
    public static final short m9052coerceInVKSA0NQ(short s11, short s12, short s13) {
        short s14 = s12 & UShort.MAX_VALUE;
        short s15 = s13 & UShort.MAX_VALUE;
        if (Intrinsics.compare((int) s14, (int) s15) <= 0) {
            short s16 = 65535 & s11;
            if (Intrinsics.compare((int) s16, (int) s14) < 0) {
                return s12;
            }
            if (Intrinsics.compare((int) s16, (int) s15) > 0) {
                return s13;
            }
            return s11;
        }
        throw new IllegalArgumentException("Cannot coerce value to an empty range: maximum " + UShort.m6650toStringimpl(s13) + " is less than minimum " + UShort.m6650toStringimpl(s12) + '.');
    }

    @SinceKotlin(version = "1.5")
    @WasExperimental(markerClass = {ExperimentalUnsignedTypes.class})
    /* renamed from: coerceIn-WZ9TVnA  reason: not valid java name */
    public static final int m9053coerceInWZ9TVnA(int i11, int i12, int i13) {
        if (UnsignedKt.uintCompare(i12, i13) > 0) {
            throw new IllegalArgumentException("Cannot coerce value to an empty range: maximum " + UInt.m6468toStringimpl(i13) + " is less than minimum " + UInt.m6468toStringimpl(i12) + '.');
        } else if (UnsignedKt.uintCompare(i11, i12) < 0) {
            return i12;
        } else {
            if (UnsignedKt.uintCompare(i11, i13) > 0) {
                return i13;
            }
            return i11;
        }
    }

    @SinceKotlin(version = "1.5")
    @WasExperimental(markerClass = {ExperimentalUnsignedTypes.class})
    /* renamed from: coerceIn-b33U2AM  reason: not valid java name */
    public static final byte m9054coerceInb33U2AM(byte b11, byte b12, byte b13) {
        byte b14 = b12 & 255;
        byte b15 = b13 & 255;
        if (Intrinsics.compare((int) b14, (int) b15) <= 0) {
            byte b16 = b11 & 255;
            if (Intrinsics.compare((int) b16, (int) b14) < 0) {
                return b12;
            }
            if (Intrinsics.compare((int) b16, (int) b15) > 0) {
                return b13;
            }
            return b11;
        }
        throw new IllegalArgumentException("Cannot coerce value to an empty range: maximum " + UByte.m6390toStringimpl(b13) + " is less than minimum " + UByte.m6390toStringimpl(b12) + '.');
    }

    @SinceKotlin(version = "1.5")
    @WasExperimental(markerClass = {ExperimentalUnsignedTypes.class})
    /* renamed from: coerceIn-sambcqE  reason: not valid java name */
    public static final long m9055coerceInsambcqE(long j11, long j12, long j13) {
        if (UnsignedKt.ulongCompare(j12, j13) > 0) {
            throw new IllegalArgumentException("Cannot coerce value to an empty range: maximum " + ULong.m6546toStringimpl(j13) + " is less than minimum " + ULong.m6546toStringimpl(j12) + '.');
        } else if (UnsignedKt.ulongCompare(j11, j12) < 0) {
            return j12;
        } else {
            if (UnsignedKt.ulongCompare(j11, j13) > 0) {
                return j13;
            }
            return j11;
        }
    }

    @SinceKotlin(version = "1.5")
    @WasExperimental(markerClass = {ExperimentalUnsignedTypes.class})
    /* renamed from: coerceIn-wuiCnnA  reason: not valid java name */
    public static final int m9056coerceInwuiCnnA(int i11, @NotNull ClosedRange<UInt> closedRange) {
        Intrinsics.checkNotNullParameter(closedRange, BasketDeliveryFeeTiersInfoKeys.KEY_RANGE);
        if (closedRange instanceof ClosedFloatingPointRange) {
            return ((UInt) RangesKt___RangesKt.coerceIn(UInt.m6417boximpl(i11), (ClosedFloatingPointRange) closedRange)).m6474unboximpl();
        }
        if (closedRange.isEmpty()) {
            throw new IllegalArgumentException("Cannot coerce value to an empty range: " + closedRange + '.');
        } else if (UnsignedKt.uintCompare(i11, closedRange.getStart().m6474unboximpl()) < 0) {
            return closedRange.getStart().m6474unboximpl();
        } else {
            if (UnsignedKt.uintCompare(i11, closedRange.getEndInclusive().m6474unboximpl()) > 0) {
                return closedRange.getEndInclusive().m6474unboximpl();
            }
            return i11;
        }
    }

    @SinceKotlin(version = "1.5")
    @WasExperimental(markerClass = {ExperimentalUnsignedTypes.class})
    /* renamed from: contains-68kG9v0  reason: not valid java name */
    public static final boolean m9057contains68kG9v0(@NotNull UIntRange uIntRange, byte b11) {
        Intrinsics.checkNotNullParameter(uIntRange, "$this$contains");
        return uIntRange.m9030containsWZ4Q5Ns(UInt.m6423constructorimpl(b11 & 255));
    }

    @SinceKotlin(version = "1.5")
    @InlineOnly
    @WasExperimental(markerClass = {ExperimentalUnsignedTypes.class})
    /* renamed from: contains-GYNo2lE  reason: not valid java name */
    private static final boolean m9058containsGYNo2lE(ULongRange uLongRange, ULong uLong) {
        Intrinsics.checkNotNullParameter(uLongRange, "$this$contains");
        if (uLong == null || !uLongRange.m9039containsVKZWuLQ(uLong.m6552unboximpl())) {
            return false;
        }
        return true;
    }

    @SinceKotlin(version = "1.5")
    @WasExperimental(markerClass = {ExperimentalUnsignedTypes.class})
    /* renamed from: contains-Gab390E  reason: not valid java name */
    public static final boolean m9059containsGab390E(@NotNull ULongRange uLongRange, int i11) {
        Intrinsics.checkNotNullParameter(uLongRange, "$this$contains");
        return uLongRange.m9039containsVKZWuLQ(ULong.m6501constructorimpl(((long) i11) & 4294967295L));
    }

    @SinceKotlin(version = "1.5")
    @WasExperimental(markerClass = {ExperimentalUnsignedTypes.class})
    /* renamed from: contains-ULb-yJY  reason: not valid java name */
    public static final boolean m9060containsULbyJY(@NotNull ULongRange uLongRange, byte b11) {
        Intrinsics.checkNotNullParameter(uLongRange, "$this$contains");
        return uLongRange.m9039containsVKZWuLQ(ULong.m6501constructorimpl(((long) b11) & 255));
    }

    @SinceKotlin(version = "1.5")
    @WasExperimental(markerClass = {ExperimentalUnsignedTypes.class})
    /* renamed from: contains-ZsK3CEQ  reason: not valid java name */
    public static final boolean m9061containsZsK3CEQ(@NotNull UIntRange uIntRange, short s11) {
        Intrinsics.checkNotNullParameter(uIntRange, "$this$contains");
        return uIntRange.m9030containsWZ4Q5Ns(UInt.m6423constructorimpl(s11 & UShort.MAX_VALUE));
    }

    @SinceKotlin(version = "1.5")
    @InlineOnly
    @WasExperimental(markerClass = {ExperimentalUnsignedTypes.class})
    /* renamed from: contains-biwQdVI  reason: not valid java name */
    private static final boolean m9062containsbiwQdVI(UIntRange uIntRange, UInt uInt) {
        Intrinsics.checkNotNullParameter(uIntRange, "$this$contains");
        if (uInt == null || !uIntRange.m9030containsWZ4Q5Ns(uInt.m6474unboximpl())) {
            return false;
        }
        return true;
    }

    @SinceKotlin(version = "1.5")
    @WasExperimental(markerClass = {ExperimentalUnsignedTypes.class})
    /* renamed from: contains-fz5IDCE  reason: not valid java name */
    public static final boolean m9063containsfz5IDCE(@NotNull UIntRange uIntRange, long j11) {
        Intrinsics.checkNotNullParameter(uIntRange, "$this$contains");
        if (ULong.m6501constructorimpl(j11 >>> 32) != 0 || !uIntRange.m9030containsWZ4Q5Ns(UInt.m6423constructorimpl((int) j11))) {
            return false;
        }
        return true;
    }

    @SinceKotlin(version = "1.5")
    @WasExperimental(markerClass = {ExperimentalUnsignedTypes.class})
    /* renamed from: contains-uhHAxoY  reason: not valid java name */
    public static final boolean m9064containsuhHAxoY(@NotNull ULongRange uLongRange, short s11) {
        Intrinsics.checkNotNullParameter(uLongRange, "$this$contains");
        return uLongRange.m9039containsVKZWuLQ(ULong.m6501constructorimpl(((long) s11) & WebSocketProtocol.PAYLOAD_SHORT_MAX));
    }

    @NotNull
    @SinceKotlin(version = "1.5")
    @WasExperimental(markerClass = {ExperimentalUnsignedTypes.class})
    /* renamed from: downTo-5PvTz6A  reason: not valid java name */
    public static final UIntProgression m9065downTo5PvTz6A(short s11, short s12) {
        return UIntProgression.Companion.m9027fromClosedRangeNkh28Cs(UInt.m6423constructorimpl(s11 & UShort.MAX_VALUE), UInt.m6423constructorimpl(s12 & UShort.MAX_VALUE), -1);
    }

    @NotNull
    @SinceKotlin(version = "1.5")
    @WasExperimental(markerClass = {ExperimentalUnsignedTypes.class})
    /* renamed from: downTo-J1ME1BU  reason: not valid java name */
    public static final UIntProgression m9066downToJ1ME1BU(int i11, int i12) {
        return UIntProgression.Companion.m9027fromClosedRangeNkh28Cs(i11, i12, -1);
    }

    @NotNull
    @SinceKotlin(version = "1.5")
    @WasExperimental(markerClass = {ExperimentalUnsignedTypes.class})
    /* renamed from: downTo-Kr8caGY  reason: not valid java name */
    public static final UIntProgression m9067downToKr8caGY(byte b11, byte b12) {
        return UIntProgression.Companion.m9027fromClosedRangeNkh28Cs(UInt.m6423constructorimpl(b11 & 255), UInt.m6423constructorimpl(b12 & 255), -1);
    }

    @NotNull
    @SinceKotlin(version = "1.5")
    @WasExperimental(markerClass = {ExperimentalUnsignedTypes.class})
    /* renamed from: downTo-eb3DHEI  reason: not valid java name */
    public static final ULongProgression m9068downToeb3DHEI(long j11, long j12) {
        return ULongProgression.Companion.m9036fromClosedRange7ftBX0g(j11, j12, -1);
    }

    @SinceKotlin(version = "1.7")
    public static final int first(@NotNull UIntProgression uIntProgression) {
        Intrinsics.checkNotNullParameter(uIntProgression, "<this>");
        if (!uIntProgression.isEmpty()) {
            return uIntProgression.m9025getFirstpVg5ArA();
        }
        throw new NoSuchElementException("Progression " + uIntProgression + " is empty.");
    }

    @SinceKotlin(version = "1.7")
    @Nullable
    public static final UInt firstOrNull(@NotNull UIntProgression uIntProgression) {
        Intrinsics.checkNotNullParameter(uIntProgression, "<this>");
        if (uIntProgression.isEmpty()) {
            return null;
        }
        return UInt.m6417boximpl(uIntProgression.m9025getFirstpVg5ArA());
    }

    @SinceKotlin(version = "1.7")
    public static final int last(@NotNull UIntProgression uIntProgression) {
        Intrinsics.checkNotNullParameter(uIntProgression, "<this>");
        if (!uIntProgression.isEmpty()) {
            return uIntProgression.m9026getLastpVg5ArA();
        }
        throw new NoSuchElementException("Progression " + uIntProgression + " is empty.");
    }

    @SinceKotlin(version = "1.7")
    @Nullable
    public static final UInt lastOrNull(@NotNull UIntProgression uIntProgression) {
        Intrinsics.checkNotNullParameter(uIntProgression, "<this>");
        if (uIntProgression.isEmpty()) {
            return null;
        }
        return UInt.m6417boximpl(uIntProgression.m9026getLastpVg5ArA());
    }

    @SinceKotlin(version = "1.5")
    @InlineOnly
    @WasExperimental(markerClass = {ExperimentalUnsignedTypes.class})
    private static final int random(UIntRange uIntRange) {
        Intrinsics.checkNotNullParameter(uIntRange, "<this>");
        return random(uIntRange, (Random) Random.Default);
    }

    @SinceKotlin(version = "1.5")
    @InlineOnly
    @WasExperimental(markerClass = {ExperimentalStdlibApi.class, ExperimentalUnsignedTypes.class})
    private static final UInt randomOrNull(UIntRange uIntRange) {
        Intrinsics.checkNotNullParameter(uIntRange, "<this>");
        return randomOrNull(uIntRange, (Random) Random.Default);
    }

    @SinceKotlin(version = "1.7")
    @ExperimentalStdlibApi
    @InlineOnly
    /* renamed from: rangeUntil-5PvTz6A  reason: not valid java name */
    private static final UIntRange m9069rangeUntil5PvTz6A(short s11, short s12) {
        return m9073until5PvTz6A(s11, s12);
    }

    @SinceKotlin(version = "1.7")
    @ExperimentalStdlibApi
    @InlineOnly
    /* renamed from: rangeUntil-J1ME1BU  reason: not valid java name */
    private static final UIntRange m9070rangeUntilJ1ME1BU(int i11, int i12) {
        return m9074untilJ1ME1BU(i11, i12);
    }

    @SinceKotlin(version = "1.7")
    @ExperimentalStdlibApi
    @InlineOnly
    /* renamed from: rangeUntil-Kr8caGY  reason: not valid java name */
    private static final UIntRange m9071rangeUntilKr8caGY(byte b11, byte b12) {
        return m9075untilKr8caGY(b11, b12);
    }

    @SinceKotlin(version = "1.7")
    @ExperimentalStdlibApi
    @InlineOnly
    /* renamed from: rangeUntil-eb3DHEI  reason: not valid java name */
    private static final ULongRange m9072rangeUntileb3DHEI(long j11, long j12) {
        return m9076untileb3DHEI(j11, j12);
    }

    @NotNull
    @SinceKotlin(version = "1.5")
    @WasExperimental(markerClass = {ExperimentalUnsignedTypes.class})
    public static final UIntProgression reversed(@NotNull UIntProgression uIntProgression) {
        Intrinsics.checkNotNullParameter(uIntProgression, "<this>");
        return UIntProgression.Companion.m9027fromClosedRangeNkh28Cs(uIntProgression.m9026getLastpVg5ArA(), uIntProgression.m9025getFirstpVg5ArA(), -uIntProgression.getStep());
    }

    @NotNull
    @SinceKotlin(version = "1.5")
    @WasExperimental(markerClass = {ExperimentalUnsignedTypes.class})
    public static final UIntProgression step(@NotNull UIntProgression uIntProgression, int i11) {
        Intrinsics.checkNotNullParameter(uIntProgression, "<this>");
        RangesKt__RangesKt.checkStepIsPositive(i11 > 0, Integer.valueOf(i11));
        UIntProgression.Companion companion = UIntProgression.Companion;
        int r12 = uIntProgression.m9025getFirstpVg5ArA();
        int r22 = uIntProgression.m9026getLastpVg5ArA();
        if (uIntProgression.getStep() <= 0) {
            i11 = -i11;
        }
        return companion.m9027fromClosedRangeNkh28Cs(r12, r22, i11);
    }

    @NotNull
    @SinceKotlin(version = "1.5")
    @WasExperimental(markerClass = {ExperimentalUnsignedTypes.class})
    /* renamed from: until-5PvTz6A  reason: not valid java name */
    public static final UIntRange m9073until5PvTz6A(short s11, short s12) {
        short s13 = s12 & UShort.MAX_VALUE;
        if (Intrinsics.compare((int) s13, 0) <= 0) {
            return UIntRange.Companion.getEMPTY();
        }
        return new UIntRange(UInt.m6423constructorimpl(s11 & UShort.MAX_VALUE), UInt.m6423constructorimpl(UInt.m6423constructorimpl(s13) - 1), (DefaultConstructorMarker) null);
    }

    @NotNull
    @SinceKotlin(version = "1.5")
    @WasExperimental(markerClass = {ExperimentalUnsignedTypes.class})
    /* renamed from: until-J1ME1BU  reason: not valid java name */
    public static final UIntRange m9074untilJ1ME1BU(int i11, int i12) {
        if (UnsignedKt.uintCompare(i12, 0) <= 0) {
            return UIntRange.Companion.getEMPTY();
        }
        return new UIntRange(i11, UInt.m6423constructorimpl(i12 - 1), (DefaultConstructorMarker) null);
    }

    @NotNull
    @SinceKotlin(version = "1.5")
    @WasExperimental(markerClass = {ExperimentalUnsignedTypes.class})
    /* renamed from: until-Kr8caGY  reason: not valid java name */
    public static final UIntRange m9075untilKr8caGY(byte b11, byte b12) {
        byte b13 = b12 & 255;
        if (Intrinsics.compare((int) b13, 0) <= 0) {
            return UIntRange.Companion.getEMPTY();
        }
        return new UIntRange(UInt.m6423constructorimpl(b11 & 255), UInt.m6423constructorimpl(UInt.m6423constructorimpl(b13) - 1), (DefaultConstructorMarker) null);
    }

    @NotNull
    @SinceKotlin(version = "1.5")
    @WasExperimental(markerClass = {ExperimentalUnsignedTypes.class})
    /* renamed from: until-eb3DHEI  reason: not valid java name */
    public static final ULongRange m9076untileb3DHEI(long j11, long j12) {
        if (UnsignedKt.ulongCompare(j12, 0) <= 0) {
            return ULongRange.Companion.getEMPTY();
        }
        return new ULongRange(j11, ULong.m6501constructorimpl(j12 - ULong.m6501constructorimpl(((long) 1) & 4294967295L)), (DefaultConstructorMarker) null);
    }

    @SinceKotlin(version = "1.7")
    @Nullable
    public static final ULong firstOrNull(@NotNull ULongProgression uLongProgression) {
        Intrinsics.checkNotNullParameter(uLongProgression, "<this>");
        if (uLongProgression.isEmpty()) {
            return null;
        }
        return ULong.m6495boximpl(uLongProgression.m9034getFirstsVKNKU());
    }

    @SinceKotlin(version = "1.7")
    @Nullable
    public static final ULong lastOrNull(@NotNull ULongProgression uLongProgression) {
        Intrinsics.checkNotNullParameter(uLongProgression, "<this>");
        if (uLongProgression.isEmpty()) {
            return null;
        }
        return ULong.m6495boximpl(uLongProgression.m9035getLastsVKNKU());
    }

    @SinceKotlin(version = "1.5")
    @InlineOnly
    @WasExperimental(markerClass = {ExperimentalUnsignedTypes.class})
    private static final long random(ULongRange uLongRange) {
        Intrinsics.checkNotNullParameter(uLongRange, "<this>");
        return random(uLongRange, (Random) Random.Default);
    }

    @SinceKotlin(version = "1.5")
    @InlineOnly
    @WasExperimental(markerClass = {ExperimentalStdlibApi.class, ExperimentalUnsignedTypes.class})
    private static final ULong randomOrNull(ULongRange uLongRange) {
        Intrinsics.checkNotNullParameter(uLongRange, "<this>");
        return randomOrNull(uLongRange, (Random) Random.Default);
    }

    @NotNull
    @SinceKotlin(version = "1.5")
    @WasExperimental(markerClass = {ExperimentalUnsignedTypes.class})
    public static final ULongProgression reversed(@NotNull ULongProgression uLongProgression) {
        Intrinsics.checkNotNullParameter(uLongProgression, "<this>");
        return ULongProgression.Companion.m9036fromClosedRange7ftBX0g(uLongProgression.m9035getLastsVKNKU(), uLongProgression.m9034getFirstsVKNKU(), -uLongProgression.getStep());
    }

    @SinceKotlin(version = "1.5")
    @WasExperimental(markerClass = {ExperimentalUnsignedTypes.class})
    public static final int random(@NotNull UIntRange uIntRange, @NotNull Random random) {
        Intrinsics.checkNotNullParameter(uIntRange, "<this>");
        Intrinsics.checkNotNullParameter(random, "random");
        try {
            return URandomKt.nextUInt(random, uIntRange);
        } catch (IllegalArgumentException e11) {
            throw new NoSuchElementException(e11.getMessage());
        }
    }

    @SinceKotlin(version = "1.5")
    @Nullable
    @WasExperimental(markerClass = {ExperimentalStdlibApi.class, ExperimentalUnsignedTypes.class})
    public static final UInt randomOrNull(@NotNull UIntRange uIntRange, @NotNull Random random) {
        Intrinsics.checkNotNullParameter(uIntRange, "<this>");
        Intrinsics.checkNotNullParameter(random, "random");
        if (uIntRange.isEmpty()) {
            return null;
        }
        return UInt.m6417boximpl(URandomKt.nextUInt(random, uIntRange));
    }

    @NotNull
    @SinceKotlin(version = "1.5")
    @WasExperimental(markerClass = {ExperimentalUnsignedTypes.class})
    public static final ULongProgression step(@NotNull ULongProgression uLongProgression, long j11) {
        Intrinsics.checkNotNullParameter(uLongProgression, "<this>");
        RangesKt__RangesKt.checkStepIsPositive(j11 > 0, Long.valueOf(j11));
        ULongProgression.Companion companion = ULongProgression.Companion;
        long r52 = uLongProgression.m9034getFirstsVKNKU();
        long r72 = uLongProgression.m9035getLastsVKNKU();
        if (uLongProgression.getStep() <= 0) {
            j11 = -j11;
        }
        return companion.m9036fromClosedRange7ftBX0g(r52, r72, j11);
    }

    @SinceKotlin(version = "1.7")
    public static final long first(@NotNull ULongProgression uLongProgression) {
        Intrinsics.checkNotNullParameter(uLongProgression, "<this>");
        if (!uLongProgression.isEmpty()) {
            return uLongProgression.m9034getFirstsVKNKU();
        }
        throw new NoSuchElementException("Progression " + uLongProgression + " is empty.");
    }

    @SinceKotlin(version = "1.7")
    public static final long last(@NotNull ULongProgression uLongProgression) {
        Intrinsics.checkNotNullParameter(uLongProgression, "<this>");
        if (!uLongProgression.isEmpty()) {
            return uLongProgression.m9035getLastsVKNKU();
        }
        throw new NoSuchElementException("Progression " + uLongProgression + " is empty.");
    }

    @SinceKotlin(version = "1.5")
    @WasExperimental(markerClass = {ExperimentalUnsignedTypes.class})
    public static final long random(@NotNull ULongRange uLongRange, @NotNull Random random) {
        Intrinsics.checkNotNullParameter(uLongRange, "<this>");
        Intrinsics.checkNotNullParameter(random, "random");
        try {
            return URandomKt.nextULong(random, uLongRange);
        } catch (IllegalArgumentException e11) {
            throw new NoSuchElementException(e11.getMessage());
        }
    }

    @SinceKotlin(version = "1.5")
    @Nullable
    @WasExperimental(markerClass = {ExperimentalStdlibApi.class, ExperimentalUnsignedTypes.class})
    public static final ULong randomOrNull(@NotNull ULongRange uLongRange, @NotNull Random random) {
        Intrinsics.checkNotNullParameter(uLongRange, "<this>");
        Intrinsics.checkNotNullParameter(random, "random");
        if (uLongRange.isEmpty()) {
            return null;
        }
        return ULong.m6495boximpl(URandomKt.nextULong(random, uLongRange));
    }
}
