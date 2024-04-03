package kotlin;

import kotlin.internal.InlineOnly;
import kotlin.jvm.JvmName;

@Metadata(d1 = {"\u0000&\n\u0000\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b)\u001a\u0017\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\bø\u0001\u0000¢\u0006\u0004\b\u0003\u0010\u0004\u001a\u0017\u0010\u0000\u001a\u00020\u0001*\u00020\u0005H\bø\u0001\u0000¢\u0006\u0004\b\u0006\u0010\u0007\u001a\u0017\u0010\u0000\u001a\u00020\u0001*\u00020\bH\bø\u0001\u0000¢\u0006\u0004\b\t\u0010\n\u001a\u0017\u0010\u0000\u001a\u00020\u0001*\u00020\u000bH\bø\u0001\u0000¢\u0006\u0004\b\f\u0010\r\u001a\u0017\u0010\u000e\u001a\u00020\u0001*\u00020\u0002H\bø\u0001\u0000¢\u0006\u0004\b\u000f\u0010\u0004\u001a\u0017\u0010\u000e\u001a\u00020\u0001*\u00020\u0005H\bø\u0001\u0000¢\u0006\u0004\b\u0010\u0010\u0007\u001a\u0017\u0010\u000e\u001a\u00020\u0001*\u00020\bH\bø\u0001\u0000¢\u0006\u0004\b\u0011\u0010\n\u001a\u0017\u0010\u000e\u001a\u00020\u0001*\u00020\u000bH\bø\u0001\u0000¢\u0006\u0004\b\u0012\u0010\r\u001a\u0017\u0010\u0013\u001a\u00020\u0001*\u00020\u0002H\bø\u0001\u0000¢\u0006\u0004\b\u0014\u0010\u0004\u001a\u0017\u0010\u0013\u001a\u00020\u0001*\u00020\u0005H\bø\u0001\u0000¢\u0006\u0004\b\u0015\u0010\u0007\u001a\u0017\u0010\u0013\u001a\u00020\u0001*\u00020\bH\bø\u0001\u0000¢\u0006\u0004\b\u0016\u0010\n\u001a\u0017\u0010\u0013\u001a\u00020\u0001*\u00020\u000bH\bø\u0001\u0000¢\u0006\u0004\b\u0017\u0010\r\u001a\u001f\u0010\u0018\u001a\u00020\u0002*\u00020\u00022\u0006\u0010\u0019\u001a\u00020\u0001H\bø\u0001\u0000¢\u0006\u0004\b\u001a\u0010\u001b\u001a\u001f\u0010\u0018\u001a\u00020\u0005*\u00020\u00052\u0006\u0010\u0019\u001a\u00020\u0001H\bø\u0001\u0000¢\u0006\u0004\b\u001c\u0010\u001d\u001a\u001f\u0010\u0018\u001a\u00020\b*\u00020\b2\u0006\u0010\u0019\u001a\u00020\u0001H\bø\u0001\u0000¢\u0006\u0004\b\u001e\u0010\u001f\u001a\u001f\u0010\u0018\u001a\u00020\u000b*\u00020\u000b2\u0006\u0010\u0019\u001a\u00020\u0001H\bø\u0001\u0000¢\u0006\u0004\b \u0010!\u001a\u001f\u0010\"\u001a\u00020\u0002*\u00020\u00022\u0006\u0010\u0019\u001a\u00020\u0001H\bø\u0001\u0000¢\u0006\u0004\b#\u0010\u001b\u001a\u001f\u0010\"\u001a\u00020\u0005*\u00020\u00052\u0006\u0010\u0019\u001a\u00020\u0001H\bø\u0001\u0000¢\u0006\u0004\b$\u0010\u001d\u001a\u001f\u0010\"\u001a\u00020\b*\u00020\b2\u0006\u0010\u0019\u001a\u00020\u0001H\bø\u0001\u0000¢\u0006\u0004\b%\u0010\u001f\u001a\u001f\u0010\"\u001a\u00020\u000b*\u00020\u000b2\u0006\u0010\u0019\u001a\u00020\u0001H\bø\u0001\u0000¢\u0006\u0004\b&\u0010!\u001a\u0017\u0010'\u001a\u00020\u0002*\u00020\u0002H\bø\u0001\u0000¢\u0006\u0004\b(\u0010)\u001a\u0017\u0010'\u001a\u00020\u0005*\u00020\u0005H\bø\u0001\u0000¢\u0006\u0004\b*\u0010\u0007\u001a\u0017\u0010'\u001a\u00020\b*\u00020\bH\bø\u0001\u0000¢\u0006\u0004\b+\u0010,\u001a\u0017\u0010'\u001a\u00020\u000b*\u00020\u000bH\bø\u0001\u0000¢\u0006\u0004\b-\u0010.\u001a\u0017\u0010/\u001a\u00020\u0002*\u00020\u0002H\bø\u0001\u0000¢\u0006\u0004\b0\u0010)\u001a\u0017\u0010/\u001a\u00020\u0005*\u00020\u0005H\bø\u0001\u0000¢\u0006\u0004\b1\u0010\u0007\u001a\u0017\u0010/\u001a\u00020\b*\u00020\bH\bø\u0001\u0000¢\u0006\u0004\b2\u0010,\u001a\u0017\u0010/\u001a\u00020\u000b*\u00020\u000bH\bø\u0001\u0000¢\u0006\u0004\b3\u0010.\u0002\u0004\n\u0002\b\u0019¨\u00064"}, d2 = {"countLeadingZeroBits", "", "Lkotlin/UByte;", "countLeadingZeroBits-7apg3OU", "(B)I", "Lkotlin/UInt;", "countLeadingZeroBits-WZ4Q5Ns", "(I)I", "Lkotlin/ULong;", "countLeadingZeroBits-VKZWuLQ", "(J)I", "Lkotlin/UShort;", "countLeadingZeroBits-xj2QHRw", "(S)I", "countOneBits", "countOneBits-7apg3OU", "countOneBits-WZ4Q5Ns", "countOneBits-VKZWuLQ", "countOneBits-xj2QHRw", "countTrailingZeroBits", "countTrailingZeroBits-7apg3OU", "countTrailingZeroBits-WZ4Q5Ns", "countTrailingZeroBits-VKZWuLQ", "countTrailingZeroBits-xj2QHRw", "rotateLeft", "bitCount", "rotateLeft-LxnNnR4", "(BI)B", "rotateLeft-V7xB4Y4", "(II)I", "rotateLeft-JSWoG40", "(JI)J", "rotateLeft-olVBNx4", "(SI)S", "rotateRight", "rotateRight-LxnNnR4", "rotateRight-V7xB4Y4", "rotateRight-JSWoG40", "rotateRight-olVBNx4", "takeHighestOneBit", "takeHighestOneBit-7apg3OU", "(B)B", "takeHighestOneBit-WZ4Q5Ns", "takeHighestOneBit-VKZWuLQ", "(J)J", "takeHighestOneBit-xj2QHRw", "(S)S", "takeLowestOneBit", "takeLowestOneBit-7apg3OU", "takeLowestOneBit-WZ4Q5Ns", "takeLowestOneBit-VKZWuLQ", "takeLowestOneBit-xj2QHRw", "kotlin-stdlib"}, k = 2, mv = {1, 7, 1}, xi = 48)
@JvmName(name = "UNumbersKt")
public final class UNumbersKt {
    @SinceKotlin(version = "1.5")
    @InlineOnly
    @WasExperimental(markerClass = {ExperimentalUnsignedTypes.class, ExperimentalStdlibApi.class})
    /* renamed from: countLeadingZeroBits-7apg3OU  reason: not valid java name */
    private static final int m6572countLeadingZeroBits7apg3OU(byte b11) {
        return Integer.numberOfLeadingZeros(b11 & 255) - 24;
    }

    @SinceKotlin(version = "1.5")
    @InlineOnly
    @WasExperimental(markerClass = {ExperimentalUnsignedTypes.class, ExperimentalStdlibApi.class})
    /* renamed from: countLeadingZeroBits-VKZWuLQ  reason: not valid java name */
    private static final int m6573countLeadingZeroBitsVKZWuLQ(long j11) {
        return Long.numberOfLeadingZeros(j11);
    }

    @SinceKotlin(version = "1.5")
    @InlineOnly
    @WasExperimental(markerClass = {ExperimentalUnsignedTypes.class, ExperimentalStdlibApi.class})
    /* renamed from: countLeadingZeroBits-WZ4Q5Ns  reason: not valid java name */
    private static final int m6574countLeadingZeroBitsWZ4Q5Ns(int i11) {
        return Integer.numberOfLeadingZeros(i11);
    }

    @SinceKotlin(version = "1.5")
    @InlineOnly
    @WasExperimental(markerClass = {ExperimentalUnsignedTypes.class, ExperimentalStdlibApi.class})
    /* renamed from: countLeadingZeroBits-xj2QHRw  reason: not valid java name */
    private static final int m6575countLeadingZeroBitsxj2QHRw(short s11) {
        return Integer.numberOfLeadingZeros(s11 & UShort.MAX_VALUE) - 16;
    }

    @SinceKotlin(version = "1.5")
    @InlineOnly
    @WasExperimental(markerClass = {ExperimentalUnsignedTypes.class, ExperimentalStdlibApi.class})
    /* renamed from: countOneBits-7apg3OU  reason: not valid java name */
    private static final int m6576countOneBits7apg3OU(byte b11) {
        return Integer.bitCount(UInt.m6423constructorimpl(b11 & 255));
    }

    @SinceKotlin(version = "1.5")
    @InlineOnly
    @WasExperimental(markerClass = {ExperimentalUnsignedTypes.class, ExperimentalStdlibApi.class})
    /* renamed from: countOneBits-VKZWuLQ  reason: not valid java name */
    private static final int m6577countOneBitsVKZWuLQ(long j11) {
        return Long.bitCount(j11);
    }

    @SinceKotlin(version = "1.5")
    @InlineOnly
    @WasExperimental(markerClass = {ExperimentalUnsignedTypes.class, ExperimentalStdlibApi.class})
    /* renamed from: countOneBits-WZ4Q5Ns  reason: not valid java name */
    private static final int m6578countOneBitsWZ4Q5Ns(int i11) {
        return Integer.bitCount(i11);
    }

    @SinceKotlin(version = "1.5")
    @InlineOnly
    @WasExperimental(markerClass = {ExperimentalUnsignedTypes.class, ExperimentalStdlibApi.class})
    /* renamed from: countOneBits-xj2QHRw  reason: not valid java name */
    private static final int m6579countOneBitsxj2QHRw(short s11) {
        return Integer.bitCount(UInt.m6423constructorimpl(s11 & UShort.MAX_VALUE));
    }

    @SinceKotlin(version = "1.5")
    @InlineOnly
    @WasExperimental(markerClass = {ExperimentalUnsignedTypes.class, ExperimentalStdlibApi.class})
    /* renamed from: countTrailingZeroBits-7apg3OU  reason: not valid java name */
    private static final int m6580countTrailingZeroBits7apg3OU(byte b11) {
        return Integer.numberOfTrailingZeros(b11 | 256);
    }

    @SinceKotlin(version = "1.5")
    @InlineOnly
    @WasExperimental(markerClass = {ExperimentalUnsignedTypes.class, ExperimentalStdlibApi.class})
    /* renamed from: countTrailingZeroBits-VKZWuLQ  reason: not valid java name */
    private static final int m6581countTrailingZeroBitsVKZWuLQ(long j11) {
        return Long.numberOfTrailingZeros(j11);
    }

    @SinceKotlin(version = "1.5")
    @InlineOnly
    @WasExperimental(markerClass = {ExperimentalUnsignedTypes.class, ExperimentalStdlibApi.class})
    /* renamed from: countTrailingZeroBits-WZ4Q5Ns  reason: not valid java name */
    private static final int m6582countTrailingZeroBitsWZ4Q5Ns(int i11) {
        return Integer.numberOfTrailingZeros(i11);
    }

    @SinceKotlin(version = "1.5")
    @InlineOnly
    @WasExperimental(markerClass = {ExperimentalUnsignedTypes.class, ExperimentalStdlibApi.class})
    /* renamed from: countTrailingZeroBits-xj2QHRw  reason: not valid java name */
    private static final int m6583countTrailingZeroBitsxj2QHRw(short s11) {
        return Integer.numberOfTrailingZeros(s11 | 65536);
    }

    @SinceKotlin(version = "1.6")
    @InlineOnly
    @WasExperimental(markerClass = {ExperimentalStdlibApi.class, ExperimentalUnsignedTypes.class})
    /* renamed from: rotateLeft-JSWoG40  reason: not valid java name */
    private static final long m6584rotateLeftJSWoG40(long j11, int i11) {
        return ULong.m6501constructorimpl(Long.rotateLeft(j11, i11));
    }

    @SinceKotlin(version = "1.6")
    @InlineOnly
    @WasExperimental(markerClass = {ExperimentalStdlibApi.class, ExperimentalUnsignedTypes.class})
    /* renamed from: rotateLeft-LxnNnR4  reason: not valid java name */
    private static final byte m6585rotateLeftLxnNnR4(byte b11, int i11) {
        return UByte.m6347constructorimpl(NumbersKt__NumbersKt.rotateLeft(b11, i11));
    }

    @SinceKotlin(version = "1.6")
    @InlineOnly
    @WasExperimental(markerClass = {ExperimentalStdlibApi.class, ExperimentalUnsignedTypes.class})
    /* renamed from: rotateLeft-V7xB4Y4  reason: not valid java name */
    private static final int m6586rotateLeftV7xB4Y4(int i11, int i12) {
        return UInt.m6423constructorimpl(Integer.rotateLeft(i11, i12));
    }

    @SinceKotlin(version = "1.6")
    @InlineOnly
    @WasExperimental(markerClass = {ExperimentalStdlibApi.class, ExperimentalUnsignedTypes.class})
    /* renamed from: rotateLeft-olVBNx4  reason: not valid java name */
    private static final short m6587rotateLeftolVBNx4(short s11, int i11) {
        return UShort.m6607constructorimpl(NumbersKt__NumbersKt.rotateLeft(s11, i11));
    }

    @SinceKotlin(version = "1.6")
    @InlineOnly
    @WasExperimental(markerClass = {ExperimentalStdlibApi.class, ExperimentalUnsignedTypes.class})
    /* renamed from: rotateRight-JSWoG40  reason: not valid java name */
    private static final long m6588rotateRightJSWoG40(long j11, int i11) {
        return ULong.m6501constructorimpl(Long.rotateRight(j11, i11));
    }

    @SinceKotlin(version = "1.6")
    @InlineOnly
    @WasExperimental(markerClass = {ExperimentalStdlibApi.class, ExperimentalUnsignedTypes.class})
    /* renamed from: rotateRight-LxnNnR4  reason: not valid java name */
    private static final byte m6589rotateRightLxnNnR4(byte b11, int i11) {
        return UByte.m6347constructorimpl(NumbersKt__NumbersKt.rotateRight(b11, i11));
    }

    @SinceKotlin(version = "1.6")
    @InlineOnly
    @WasExperimental(markerClass = {ExperimentalStdlibApi.class, ExperimentalUnsignedTypes.class})
    /* renamed from: rotateRight-V7xB4Y4  reason: not valid java name */
    private static final int m6590rotateRightV7xB4Y4(int i11, int i12) {
        return UInt.m6423constructorimpl(Integer.rotateRight(i11, i12));
    }

    @SinceKotlin(version = "1.6")
    @InlineOnly
    @WasExperimental(markerClass = {ExperimentalStdlibApi.class, ExperimentalUnsignedTypes.class})
    /* renamed from: rotateRight-olVBNx4  reason: not valid java name */
    private static final short m6591rotateRightolVBNx4(short s11, int i11) {
        return UShort.m6607constructorimpl(NumbersKt__NumbersKt.rotateRight(s11, i11));
    }

    @SinceKotlin(version = "1.5")
    @InlineOnly
    @WasExperimental(markerClass = {ExperimentalUnsignedTypes.class, ExperimentalStdlibApi.class})
    /* renamed from: takeHighestOneBit-7apg3OU  reason: not valid java name */
    private static final byte m6592takeHighestOneBit7apg3OU(byte b11) {
        return UByte.m6347constructorimpl((byte) Integer.highestOneBit(b11 & 255));
    }

    @SinceKotlin(version = "1.5")
    @InlineOnly
    @WasExperimental(markerClass = {ExperimentalUnsignedTypes.class, ExperimentalStdlibApi.class})
    /* renamed from: takeHighestOneBit-VKZWuLQ  reason: not valid java name */
    private static final long m6593takeHighestOneBitVKZWuLQ(long j11) {
        return ULong.m6501constructorimpl(Long.highestOneBit(j11));
    }

    @SinceKotlin(version = "1.5")
    @InlineOnly
    @WasExperimental(markerClass = {ExperimentalUnsignedTypes.class, ExperimentalStdlibApi.class})
    /* renamed from: takeHighestOneBit-WZ4Q5Ns  reason: not valid java name */
    private static final int m6594takeHighestOneBitWZ4Q5Ns(int i11) {
        return UInt.m6423constructorimpl(Integer.highestOneBit(i11));
    }

    @SinceKotlin(version = "1.5")
    @InlineOnly
    @WasExperimental(markerClass = {ExperimentalUnsignedTypes.class, ExperimentalStdlibApi.class})
    /* renamed from: takeHighestOneBit-xj2QHRw  reason: not valid java name */
    private static final short m6595takeHighestOneBitxj2QHRw(short s11) {
        return UShort.m6607constructorimpl((short) Integer.highestOneBit(s11 & UShort.MAX_VALUE));
    }

    @SinceKotlin(version = "1.5")
    @InlineOnly
    @WasExperimental(markerClass = {ExperimentalUnsignedTypes.class, ExperimentalStdlibApi.class})
    /* renamed from: takeLowestOneBit-7apg3OU  reason: not valid java name */
    private static final byte m6596takeLowestOneBit7apg3OU(byte b11) {
        return UByte.m6347constructorimpl((byte) Integer.lowestOneBit(b11 & 255));
    }

    @SinceKotlin(version = "1.5")
    @InlineOnly
    @WasExperimental(markerClass = {ExperimentalUnsignedTypes.class, ExperimentalStdlibApi.class})
    /* renamed from: takeLowestOneBit-VKZWuLQ  reason: not valid java name */
    private static final long m6597takeLowestOneBitVKZWuLQ(long j11) {
        return ULong.m6501constructorimpl(Long.lowestOneBit(j11));
    }

    @SinceKotlin(version = "1.5")
    @InlineOnly
    @WasExperimental(markerClass = {ExperimentalUnsignedTypes.class, ExperimentalStdlibApi.class})
    /* renamed from: takeLowestOneBit-WZ4Q5Ns  reason: not valid java name */
    private static final int m6598takeLowestOneBitWZ4Q5Ns(int i11) {
        return UInt.m6423constructorimpl(Integer.lowestOneBit(i11));
    }

    @SinceKotlin(version = "1.5")
    @InlineOnly
    @WasExperimental(markerClass = {ExperimentalUnsignedTypes.class, ExperimentalStdlibApi.class})
    /* renamed from: takeLowestOneBit-xj2QHRw  reason: not valid java name */
    private static final short m6599takeLowestOneBitxj2QHRw(short s11) {
        return UShort.m6607constructorimpl((short) Integer.lowestOneBit(s11 & UShort.MAX_VALUE));
    }
}
