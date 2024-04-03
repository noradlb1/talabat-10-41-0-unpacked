package kotlin;

import kotlin.internal.InlineOnly;
import kotlin.jvm.internal.DoubleCompanionObject;
import kotlin.jvm.internal.FloatCompanionObject;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000*\n\u0000\n\u0002\u0010\b\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0010\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\n\u001a\r\u0010\u0000\u001a\u00020\u0001*\u00020\u0001H\b\u001a\r\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\b\u001a\r\u0010\u0003\u001a\u00020\u0001*\u00020\u0001H\b\u001a\r\u0010\u0003\u001a\u00020\u0001*\u00020\u0002H\b\u001a\r\u0010\u0004\u001a\u00020\u0001*\u00020\u0001H\b\u001a\r\u0010\u0004\u001a\u00020\u0001*\u00020\u0002H\b\u001a\u0015\u0010\u0005\u001a\u00020\u0006*\u00020\u00072\u0006\u0010\b\u001a\u00020\u0002H\b\u001a\u0015\u0010\u0005\u001a\u00020\t*\u00020\n2\u0006\u0010\b\u001a\u00020\u0001H\b\u001a\r\u0010\u000b\u001a\u00020\f*\u00020\u0006H\b\u001a\r\u0010\u000b\u001a\u00020\f*\u00020\tH\b\u001a\r\u0010\r\u001a\u00020\f*\u00020\u0006H\b\u001a\r\u0010\r\u001a\u00020\f*\u00020\tH\b\u001a\r\u0010\u000e\u001a\u00020\f*\u00020\u0006H\b\u001a\r\u0010\u000e\u001a\u00020\f*\u00020\tH\b\u001a\u0015\u0010\u000f\u001a\u00020\u0001*\u00020\u00012\u0006\u0010\u0010\u001a\u00020\u0001H\b\u001a\u0015\u0010\u000f\u001a\u00020\u0002*\u00020\u00022\u0006\u0010\u0010\u001a\u00020\u0001H\b\u001a\u0015\u0010\u0011\u001a\u00020\u0001*\u00020\u00012\u0006\u0010\u0010\u001a\u00020\u0001H\b\u001a\u0015\u0010\u0011\u001a\u00020\u0002*\u00020\u00022\u0006\u0010\u0010\u001a\u00020\u0001H\b\u001a\r\u0010\u0012\u001a\u00020\u0001*\u00020\u0001H\b\u001a\r\u0010\u0012\u001a\u00020\u0002*\u00020\u0002H\b\u001a\r\u0010\u0013\u001a\u00020\u0001*\u00020\u0001H\b\u001a\r\u0010\u0013\u001a\u00020\u0002*\u00020\u0002H\b\u001a\r\u0010\u0014\u001a\u00020\u0002*\u00020\u0006H\b\u001a\r\u0010\u0014\u001a\u00020\u0001*\u00020\tH\b\u001a\r\u0010\u0015\u001a\u00020\u0002*\u00020\u0006H\b\u001a\r\u0010\u0015\u001a\u00020\u0001*\u00020\tH\b¨\u0006\u0016"}, d2 = {"countLeadingZeroBits", "", "", "countOneBits", "countTrailingZeroBits", "fromBits", "", "Lkotlin/Double$Companion;", "bits", "", "Lkotlin/Float$Companion;", "isFinite", "", "isInfinite", "isNaN", "rotateLeft", "bitCount", "rotateRight", "takeHighestOneBit", "takeLowestOneBit", "toBits", "toRawBits", "kotlin-stdlib"}, k = 5, mv = {1, 7, 1}, xi = 49, xs = "kotlin/NumbersKt")
class NumbersKt__NumbersJVMKt extends NumbersKt__FloorDivModKt {
    @SinceKotlin(version = "1.4")
    @InlineOnly
    @WasExperimental(markerClass = {ExperimentalStdlibApi.class})
    private static final int countLeadingZeroBits(int i11) {
        return Integer.numberOfLeadingZeros(i11);
    }

    @SinceKotlin(version = "1.4")
    @InlineOnly
    @WasExperimental(markerClass = {ExperimentalStdlibApi.class})
    private static final int countOneBits(int i11) {
        return Integer.bitCount(i11);
    }

    @SinceKotlin(version = "1.4")
    @InlineOnly
    @WasExperimental(markerClass = {ExperimentalStdlibApi.class})
    private static final int countTrailingZeroBits(int i11) {
        return Integer.numberOfTrailingZeros(i11);
    }

    @SinceKotlin(version = "1.2")
    @InlineOnly
    private static final double fromBits(DoubleCompanionObject doubleCompanionObject, long j11) {
        Intrinsics.checkNotNullParameter(doubleCompanionObject, "<this>");
        return Double.longBitsToDouble(j11);
    }

    @InlineOnly
    private static final boolean isFinite(double d11) {
        return !Double.isInfinite(d11) && !Double.isNaN(d11);
    }

    @InlineOnly
    private static final boolean isInfinite(double d11) {
        return Double.isInfinite(d11);
    }

    @InlineOnly
    private static final boolean isNaN(double d11) {
        return Double.isNaN(d11);
    }

    @SinceKotlin(version = "1.6")
    @InlineOnly
    @WasExperimental(markerClass = {ExperimentalStdlibApi.class})
    private static final int rotateLeft(int i11, int i12) {
        return Integer.rotateLeft(i11, i12);
    }

    @SinceKotlin(version = "1.6")
    @InlineOnly
    @WasExperimental(markerClass = {ExperimentalStdlibApi.class})
    private static final int rotateRight(int i11, int i12) {
        return Integer.rotateRight(i11, i12);
    }

    @SinceKotlin(version = "1.4")
    @InlineOnly
    @WasExperimental(markerClass = {ExperimentalStdlibApi.class})
    private static final int takeHighestOneBit(int i11) {
        return Integer.highestOneBit(i11);
    }

    @SinceKotlin(version = "1.4")
    @InlineOnly
    @WasExperimental(markerClass = {ExperimentalStdlibApi.class})
    private static final int takeLowestOneBit(int i11) {
        return Integer.lowestOneBit(i11);
    }

    @SinceKotlin(version = "1.2")
    @InlineOnly
    private static final long toBits(double d11) {
        return Double.doubleToLongBits(d11);
    }

    @SinceKotlin(version = "1.2")
    @InlineOnly
    private static final long toRawBits(double d11) {
        return Double.doubleToRawLongBits(d11);
    }

    @SinceKotlin(version = "1.4")
    @InlineOnly
    @WasExperimental(markerClass = {ExperimentalStdlibApi.class})
    private static final int countLeadingZeroBits(long j11) {
        return Long.numberOfLeadingZeros(j11);
    }

    @SinceKotlin(version = "1.4")
    @InlineOnly
    @WasExperimental(markerClass = {ExperimentalStdlibApi.class})
    private static final int countOneBits(long j11) {
        return Long.bitCount(j11);
    }

    @SinceKotlin(version = "1.4")
    @InlineOnly
    @WasExperimental(markerClass = {ExperimentalStdlibApi.class})
    private static final int countTrailingZeroBits(long j11) {
        return Long.numberOfTrailingZeros(j11);
    }

    @SinceKotlin(version = "1.2")
    @InlineOnly
    private static final float fromBits(FloatCompanionObject floatCompanionObject, int i11) {
        Intrinsics.checkNotNullParameter(floatCompanionObject, "<this>");
        return Float.intBitsToFloat(i11);
    }

    @InlineOnly
    private static final boolean isFinite(float f11) {
        return !Float.isInfinite(f11) && !Float.isNaN(f11);
    }

    @InlineOnly
    private static final boolean isInfinite(float f11) {
        return Float.isInfinite(f11);
    }

    @InlineOnly
    private static final boolean isNaN(float f11) {
        return Float.isNaN(f11);
    }

    @SinceKotlin(version = "1.6")
    @InlineOnly
    @WasExperimental(markerClass = {ExperimentalStdlibApi.class})
    private static final long rotateLeft(long j11, int i11) {
        return Long.rotateLeft(j11, i11);
    }

    @SinceKotlin(version = "1.6")
    @InlineOnly
    @WasExperimental(markerClass = {ExperimentalStdlibApi.class})
    private static final long rotateRight(long j11, int i11) {
        return Long.rotateRight(j11, i11);
    }

    @SinceKotlin(version = "1.4")
    @InlineOnly
    @WasExperimental(markerClass = {ExperimentalStdlibApi.class})
    private static final long takeHighestOneBit(long j11) {
        return Long.highestOneBit(j11);
    }

    @SinceKotlin(version = "1.4")
    @InlineOnly
    @WasExperimental(markerClass = {ExperimentalStdlibApi.class})
    private static final long takeLowestOneBit(long j11) {
        return Long.lowestOneBit(j11);
    }

    @SinceKotlin(version = "1.2")
    @InlineOnly
    private static final int toBits(float f11) {
        return Float.floatToIntBits(f11);
    }

    @SinceKotlin(version = "1.2")
    @InlineOnly
    private static final int toRawBits(float f11) {
        return Float.floatToRawIntBits(f11);
    }
}
