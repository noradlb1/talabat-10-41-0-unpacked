package kotlin;

import com.google.common.base.Ascii;
import kotlin.internal.InlineOnly;
import kotlin.internal.IntrinsicConstEvaluation;

@Metadata(d1 = {"\u0000 \n\u0000\n\u0002\u0010\b\n\u0002\u0010\u0005\n\u0000\n\u0002\u0010\t\n\u0002\u0010\n\n\u0000\n\u0002\u0010\u0006\n\u0002\u0010\u0007\n\u0000\u001a\u0015\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0002H\b\u001a\u0015\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0001H\b\u001a\u0015\u0010\u0000\u001a\u00020\u0004*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0004H\b\u001a\u0015\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0005H\b\u001a\u0015\u0010\u0000\u001a\u00020\u0001*\u00020\u00012\u0006\u0010\u0003\u001a\u00020\u0002H\b\u001a\u0015\u0010\u0000\u001a\u00020\u0001*\u00020\u00012\u0006\u0010\u0003\u001a\u00020\u0001H\b\u001a\u0015\u0010\u0000\u001a\u00020\u0004*\u00020\u00012\u0006\u0010\u0003\u001a\u00020\u0004H\b\u001a\u0015\u0010\u0000\u001a\u00020\u0001*\u00020\u00012\u0006\u0010\u0003\u001a\u00020\u0005H\b\u001a\u0015\u0010\u0000\u001a\u00020\u0004*\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\b\u001a\u0015\u0010\u0000\u001a\u00020\u0004*\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0001H\b\u001a\u0015\u0010\u0000\u001a\u00020\u0004*\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0004H\b\u001a\u0015\u0010\u0000\u001a\u00020\u0004*\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0005H\b\u001a\u0015\u0010\u0000\u001a\u00020\u0001*\u00020\u00052\u0006\u0010\u0003\u001a\u00020\u0002H\b\u001a\u0015\u0010\u0000\u001a\u00020\u0001*\u00020\u00052\u0006\u0010\u0003\u001a\u00020\u0001H\b\u001a\u0015\u0010\u0000\u001a\u00020\u0004*\u00020\u00052\u0006\u0010\u0003\u001a\u00020\u0004H\b\u001a\u0015\u0010\u0000\u001a\u00020\u0001*\u00020\u00052\u0006\u0010\u0003\u001a\u00020\u0005H\b\u001a\u0015\u0010\u0006\u001a\u00020\u0002*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0002H\b\u001a\u0015\u0010\u0006\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0001H\b\u001a\u0015\u0010\u0006\u001a\u00020\u0004*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0004H\b\u001a\u0015\u0010\u0006\u001a\u00020\u0005*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0005H\b\u001a\u0015\u0010\u0006\u001a\u00020\u0007*\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u0007H\b\u001a\u0015\u0010\u0006\u001a\u00020\u0007*\u00020\u00072\u0006\u0010\u0003\u001a\u00020\bH\b\u001a\u0015\u0010\u0006\u001a\u00020\u0007*\u00020\b2\u0006\u0010\u0003\u001a\u00020\u0007H\b\u001a\u0015\u0010\u0006\u001a\u00020\b*\u00020\b2\u0006\u0010\u0003\u001a\u00020\bH\b\u001a\u0015\u0010\u0006\u001a\u00020\u0002*\u00020\u00012\u0006\u0010\u0003\u001a\u00020\u0002H\b\u001a\u0015\u0010\u0006\u001a\u00020\u0001*\u00020\u00012\u0006\u0010\u0003\u001a\u00020\u0001H\b\u001a\u0015\u0010\u0006\u001a\u00020\u0004*\u00020\u00012\u0006\u0010\u0003\u001a\u00020\u0004H\b\u001a\u0015\u0010\u0006\u001a\u00020\u0005*\u00020\u00012\u0006\u0010\u0003\u001a\u00020\u0005H\b\u001a\u0015\u0010\u0006\u001a\u00020\u0002*\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\b\u001a\u0015\u0010\u0006\u001a\u00020\u0001*\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0001H\b\u001a\u0015\u0010\u0006\u001a\u00020\u0004*\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0004H\b\u001a\u0015\u0010\u0006\u001a\u00020\u0005*\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0005H\b\u001a\u0015\u0010\u0006\u001a\u00020\u0002*\u00020\u00052\u0006\u0010\u0003\u001a\u00020\u0002H\b\u001a\u0015\u0010\u0006\u001a\u00020\u0001*\u00020\u00052\u0006\u0010\u0003\u001a\u00020\u0001H\b\u001a\u0015\u0010\u0006\u001a\u00020\u0004*\u00020\u00052\u0006\u0010\u0003\u001a\u00020\u0004H\b\u001a\u0015\u0010\u0006\u001a\u00020\u0005*\u00020\u00052\u0006\u0010\u0003\u001a\u00020\u0005H\b¨\u0006\t"}, d2 = {"floorDiv", "", "", "other", "", "", "mod", "", "", "kotlin-stdlib"}, k = 5, mv = {1, 7, 1}, xi = 49, xs = "kotlin/NumbersKt")
class NumbersKt__FloorDivModKt extends NumbersKt__BigIntegersKt {
    @SinceKotlin(version = "1.5")
    @InlineOnly
    @IntrinsicConstEvaluation
    private static final int floorDiv(byte b11, byte b12) {
        int i11 = b11 / b12;
        return ((b11 ^ b12) >= 0 || b12 * i11 == b11) ? i11 : i11 - 1;
    }

    @SinceKotlin(version = "1.5")
    @InlineOnly
    @IntrinsicConstEvaluation
    private static final byte mod(byte b11, byte b12) {
        int i11 = b11 % b12;
        return (byte) (i11 + (b12 & (((i11 ^ b12) & ((-i11) | i11)) >> Ascii.US)));
    }

    @SinceKotlin(version = "1.5")
    @InlineOnly
    @IntrinsicConstEvaluation
    private static final int floorDiv(byte b11, short s11) {
        int i11 = b11 / s11;
        return ((b11 ^ s11) >= 0 || s11 * i11 == b11) ? i11 : i11 - 1;
    }

    @SinceKotlin(version = "1.5")
    @InlineOnly
    @IntrinsicConstEvaluation
    private static final short mod(byte b11, short s11) {
        int i11 = b11 % s11;
        return (short) (i11 + (s11 & (((i11 ^ s11) & ((-i11) | i11)) >> 31)));
    }

    @SinceKotlin(version = "1.5")
    @InlineOnly
    @IntrinsicConstEvaluation
    private static final int floorDiv(byte b11, int i11) {
        int i12 = b11 / i11;
        return ((b11 ^ i11) >= 0 || i11 * i12 == b11) ? i12 : i12 - 1;
    }

    @SinceKotlin(version = "1.5")
    @InlineOnly
    @IntrinsicConstEvaluation
    private static final int mod(byte b11, int i11) {
        int i12 = b11 % i11;
        return i12 + (i11 & (((i12 ^ i11) & ((-i12) | i12)) >> 31));
    }

    @SinceKotlin(version = "1.5")
    @InlineOnly
    @IntrinsicConstEvaluation
    private static final long floorDiv(byte b11, long j11) {
        long j12 = (long) b11;
        long j13 = j12 / j11;
        return ((j12 ^ j11) >= 0 || j11 * j13 == j12) ? j13 : j13 - 1;
    }

    @SinceKotlin(version = "1.5")
    @InlineOnly
    @IntrinsicConstEvaluation
    private static final long mod(byte b11, long j11) {
        long j12 = ((long) b11) % j11;
        return j12 + (j11 & (((j12 ^ j11) & ((-j12) | j12)) >> 63));
    }

    @SinceKotlin(version = "1.5")
    @InlineOnly
    @IntrinsicConstEvaluation
    private static final int floorDiv(short s11, byte b11) {
        int i11 = s11 / b11;
        return ((s11 ^ b11) >= 0 || b11 * i11 == s11) ? i11 : i11 - 1;
    }

    @SinceKotlin(version = "1.5")
    @InlineOnly
    @IntrinsicConstEvaluation
    private static final byte mod(short s11, byte b11) {
        int i11 = s11 % b11;
        return (byte) (i11 + (b11 & (((i11 ^ b11) & ((-i11) | i11)) >> Ascii.US)));
    }

    @SinceKotlin(version = "1.5")
    @InlineOnly
    @IntrinsicConstEvaluation
    private static final int floorDiv(short s11, short s12) {
        int i11 = s11 / s12;
        return ((s11 ^ s12) >= 0 || s12 * i11 == s11) ? i11 : i11 - 1;
    }

    @SinceKotlin(version = "1.5")
    @InlineOnly
    @IntrinsicConstEvaluation
    private static final short mod(short s11, short s12) {
        int i11 = s11 % s12;
        return (short) (i11 + (s12 & (((i11 ^ s12) & ((-i11) | i11)) >> 31)));
    }

    @SinceKotlin(version = "1.5")
    @InlineOnly
    @IntrinsicConstEvaluation
    private static final int floorDiv(short s11, int i11) {
        int i12 = s11 / i11;
        return ((s11 ^ i11) >= 0 || i11 * i12 == s11) ? i12 : i12 - 1;
    }

    @SinceKotlin(version = "1.5")
    @InlineOnly
    @IntrinsicConstEvaluation
    private static final int mod(short s11, int i11) {
        int i12 = s11 % i11;
        return i12 + (i11 & (((i12 ^ i11) & ((-i12) | i12)) >> 31));
    }

    @SinceKotlin(version = "1.5")
    @InlineOnly
    @IntrinsicConstEvaluation
    private static final long floorDiv(short s11, long j11) {
        long j12 = (long) s11;
        long j13 = j12 / j11;
        return ((j12 ^ j11) >= 0 || j11 * j13 == j12) ? j13 : j13 - 1;
    }

    @SinceKotlin(version = "1.5")
    @InlineOnly
    @IntrinsicConstEvaluation
    private static final long mod(short s11, long j11) {
        long j12 = ((long) s11) % j11;
        return j12 + (j11 & (((j12 ^ j11) & ((-j12) | j12)) >> 63));
    }

    @SinceKotlin(version = "1.5")
    @InlineOnly
    @IntrinsicConstEvaluation
    private static final int floorDiv(int i11, byte b11) {
        int i12 = i11 / b11;
        return ((i11 ^ b11) >= 0 || b11 * i12 == i11) ? i12 : i12 - 1;
    }

    @SinceKotlin(version = "1.5")
    @InlineOnly
    @IntrinsicConstEvaluation
    private static final byte mod(int i11, byte b11) {
        int i12 = i11 % b11;
        return (byte) (i12 + (b11 & (((i12 ^ b11) & ((-i12) | i12)) >> Ascii.US)));
    }

    @SinceKotlin(version = "1.5")
    @InlineOnly
    @IntrinsicConstEvaluation
    private static final int floorDiv(int i11, short s11) {
        int i12 = i11 / s11;
        return ((i11 ^ s11) >= 0 || s11 * i12 == i11) ? i12 : i12 - 1;
    }

    @SinceKotlin(version = "1.5")
    @InlineOnly
    @IntrinsicConstEvaluation
    private static final short mod(int i11, short s11) {
        int i12 = i11 % s11;
        return (short) (i12 + (s11 & (((i12 ^ s11) & ((-i12) | i12)) >> 31)));
    }

    @SinceKotlin(version = "1.5")
    @InlineOnly
    @IntrinsicConstEvaluation
    private static final int floorDiv(int i11, int i12) {
        int i13 = i11 / i12;
        return ((i11 ^ i12) >= 0 || i12 * i13 == i11) ? i13 : i13 - 1;
    }

    @SinceKotlin(version = "1.5")
    @InlineOnly
    @IntrinsicConstEvaluation
    private static final int mod(int i11, int i12) {
        int i13 = i11 % i12;
        return i13 + (i12 & (((i13 ^ i12) & ((-i13) | i13)) >> 31));
    }

    @SinceKotlin(version = "1.5")
    @InlineOnly
    @IntrinsicConstEvaluation
    private static final long floorDiv(int i11, long j11) {
        long j12 = (long) i11;
        long j13 = j12 / j11;
        return ((j12 ^ j11) >= 0 || j11 * j13 == j12) ? j13 : j13 - 1;
    }

    @SinceKotlin(version = "1.5")
    @InlineOnly
    @IntrinsicConstEvaluation
    private static final long mod(int i11, long j11) {
        long j12 = ((long) i11) % j11;
        return j12 + (j11 & (((j12 ^ j11) & ((-j12) | j12)) >> 63));
    }

    @SinceKotlin(version = "1.5")
    @InlineOnly
    @IntrinsicConstEvaluation
    private static final long floorDiv(long j11, byte b11) {
        long j12 = (long) b11;
        long j13 = j11 / j12;
        return ((j11 ^ j12) >= 0 || j12 * j13 == j11) ? j13 : j13 - 1;
    }

    @SinceKotlin(version = "1.5")
    @InlineOnly
    @IntrinsicConstEvaluation
    private static final byte mod(long j11, byte b11) {
        long j12 = (long) b11;
        long j13 = j11 % j12;
        return (byte) ((int) (j13 + (j12 & (((j13 ^ j12) & ((-j13) | j13)) >> 63))));
    }

    @SinceKotlin(version = "1.5")
    @InlineOnly
    @IntrinsicConstEvaluation
    private static final long floorDiv(long j11, short s11) {
        long j12 = (long) s11;
        long j13 = j11 / j12;
        return ((j11 ^ j12) >= 0 || j12 * j13 == j11) ? j13 : j13 - 1;
    }

    @SinceKotlin(version = "1.5")
    @InlineOnly
    @IntrinsicConstEvaluation
    private static final short mod(long j11, short s11) {
        long j12 = (long) s11;
        long j13 = j11 % j12;
        return (short) ((int) (j13 + (j12 & (((j13 ^ j12) & ((-j13) | j13)) >> 63))));
    }

    @SinceKotlin(version = "1.5")
    @InlineOnly
    @IntrinsicConstEvaluation
    private static final long floorDiv(long j11, int i11) {
        long j12 = (long) i11;
        long j13 = j11 / j12;
        return ((j11 ^ j12) >= 0 || j12 * j13 == j11) ? j13 : j13 - 1;
    }

    @SinceKotlin(version = "1.5")
    @InlineOnly
    @IntrinsicConstEvaluation
    private static final int mod(long j11, int i11) {
        long j12 = (long) i11;
        long j13 = j11 % j12;
        return (int) (j13 + (j12 & (((j13 ^ j12) & ((-j13) | j13)) >> 63)));
    }

    @SinceKotlin(version = "1.5")
    @InlineOnly
    @IntrinsicConstEvaluation
    private static final long floorDiv(long j11, long j12) {
        long j13 = j11 / j12;
        return ((j11 ^ j12) >= 0 || j12 * j13 == j11) ? j13 : j13 - 1;
    }

    @SinceKotlin(version = "1.5")
    @InlineOnly
    @IntrinsicConstEvaluation
    private static final long mod(long j11, long j12) {
        long j13 = j11 % j12;
        return j13 + (j12 & (((j13 ^ j12) & ((-j13) | j13)) >> 63));
    }

    @SinceKotlin(version = "1.5")
    @InlineOnly
    @IntrinsicConstEvaluation
    private static final float mod(float f11, float f12) {
        float f13 = f11 % f12;
        boolean z11 = true;
        if (f13 == 0.0f) {
            return f13;
        }
        if (Math.signum(f13) != Math.signum(f12)) {
            z11 = false;
        }
        return !z11 ? f13 + f12 : f13;
    }

    @SinceKotlin(version = "1.5")
    @InlineOnly
    @IntrinsicConstEvaluation
    private static final double mod(float f11, double d11) {
        double d12 = ((double) f11) % d11;
        boolean z11 = true;
        if (d12 == 0.0d) {
            return d12;
        }
        if (Math.signum(d12) != Math.signum(d11)) {
            z11 = false;
        }
        return !z11 ? d12 + d11 : d12;
    }

    @SinceKotlin(version = "1.5")
    @InlineOnly
    @IntrinsicConstEvaluation
    private static final double mod(double d11, float f11) {
        double d12 = (double) f11;
        double d13 = d11 % d12;
        boolean z11 = true;
        if (d13 == 0.0d) {
            return d13;
        }
        if (Math.signum(d13) != Math.signum(d12)) {
            z11 = false;
        }
        return !z11 ? d13 + d12 : d13;
    }

    @SinceKotlin(version = "1.5")
    @InlineOnly
    @IntrinsicConstEvaluation
    private static final double mod(double d11, double d12) {
        double d13 = d11 % d12;
        boolean z11 = true;
        if (d13 == 0.0d) {
            return d13;
        }
        if (Math.signum(d13) != Math.signum(d12)) {
            z11 = false;
        }
        return !z11 ? d13 + d12 : d13;
    }
}
