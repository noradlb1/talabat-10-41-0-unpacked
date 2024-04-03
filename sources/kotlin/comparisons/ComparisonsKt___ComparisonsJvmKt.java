package kotlin.comparisons;

import com.apptimize.c;
import kotlin.Metadata;
import kotlin.SinceKotlin;
import kotlin.internal.InlineOnly;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000F\n\u0002\b\u0002\n\u0002\u0010\u000f\n\u0002\b\u0006\n\u0002\u0010\u0011\n\u0000\n\u0002\u0010\u0005\n\u0002\u0010\u0012\n\u0002\u0010\u0006\n\u0002\u0010\u0013\n\u0002\u0010\u0007\n\u0002\u0010\u0014\n\u0002\u0010\b\n\u0002\u0010\u0015\n\u0002\u0010\t\n\u0002\u0010\u0016\n\u0002\u0010\n\n\u0002\u0010\u0017\n\u0002\b\u0002\u001a-\u0010\u0000\u001a\u0002H\u0001\"\u000e\b\u0000\u0010\u0001*\b\u0012\u0004\u0012\u0002H\u00010\u00022\u0006\u0010\u0003\u001a\u0002H\u00012\u0006\u0010\u0004\u001a\u0002H\u0001H\u0007¢\u0006\u0002\u0010\u0005\u001a5\u0010\u0000\u001a\u0002H\u0001\"\u000e\b\u0000\u0010\u0001*\b\u0012\u0004\u0012\u0002H\u00010\u00022\u0006\u0010\u0003\u001a\u0002H\u00012\u0006\u0010\u0004\u001a\u0002H\u00012\u0006\u0010\u0006\u001a\u0002H\u0001H\u0007¢\u0006\u0002\u0010\u0007\u001a9\u0010\u0000\u001a\u0002H\u0001\"\u000e\b\u0000\u0010\u0001*\b\u0012\u0004\u0012\u0002H\u00010\u00022\u0006\u0010\u0003\u001a\u0002H\u00012\u0012\u0010\b\u001a\n\u0012\u0006\b\u0001\u0012\u0002H\u00010\t\"\u0002H\u0001H\u0007¢\u0006\u0002\u0010\n\u001a\u0019\u0010\u0000\u001a\u00020\u000b2\u0006\u0010\u0003\u001a\u00020\u000b2\u0006\u0010\u0004\u001a\u00020\u000bH\b\u001a!\u0010\u0000\u001a\u00020\u000b2\u0006\u0010\u0003\u001a\u00020\u000b2\u0006\u0010\u0004\u001a\u00020\u000b2\u0006\u0010\u0006\u001a\u00020\u000bH\b\u001a\u001c\u0010\u0000\u001a\u00020\u000b2\u0006\u0010\u0003\u001a\u00020\u000b2\n\u0010\b\u001a\u00020\f\"\u00020\u000bH\u0007\u001a\u0019\u0010\u0000\u001a\u00020\r2\u0006\u0010\u0003\u001a\u00020\r2\u0006\u0010\u0004\u001a\u00020\rH\b\u001a!\u0010\u0000\u001a\u00020\r2\u0006\u0010\u0003\u001a\u00020\r2\u0006\u0010\u0004\u001a\u00020\r2\u0006\u0010\u0006\u001a\u00020\rH\b\u001a\u001c\u0010\u0000\u001a\u00020\r2\u0006\u0010\u0003\u001a\u00020\r2\n\u0010\b\u001a\u00020\u000e\"\u00020\rH\u0007\u001a\u0019\u0010\u0000\u001a\u00020\u000f2\u0006\u0010\u0003\u001a\u00020\u000f2\u0006\u0010\u0004\u001a\u00020\u000fH\b\u001a!\u0010\u0000\u001a\u00020\u000f2\u0006\u0010\u0003\u001a\u00020\u000f2\u0006\u0010\u0004\u001a\u00020\u000f2\u0006\u0010\u0006\u001a\u00020\u000fH\b\u001a\u001c\u0010\u0000\u001a\u00020\u000f2\u0006\u0010\u0003\u001a\u00020\u000f2\n\u0010\b\u001a\u00020\u0010\"\u00020\u000fH\u0007\u001a\u0019\u0010\u0000\u001a\u00020\u00112\u0006\u0010\u0003\u001a\u00020\u00112\u0006\u0010\u0004\u001a\u00020\u0011H\b\u001a!\u0010\u0000\u001a\u00020\u00112\u0006\u0010\u0003\u001a\u00020\u00112\u0006\u0010\u0004\u001a\u00020\u00112\u0006\u0010\u0006\u001a\u00020\u0011H\b\u001a\u001c\u0010\u0000\u001a\u00020\u00112\u0006\u0010\u0003\u001a\u00020\u00112\n\u0010\b\u001a\u00020\u0012\"\u00020\u0011H\u0007\u001a\u0019\u0010\u0000\u001a\u00020\u00132\u0006\u0010\u0003\u001a\u00020\u00132\u0006\u0010\u0004\u001a\u00020\u0013H\b\u001a!\u0010\u0000\u001a\u00020\u00132\u0006\u0010\u0003\u001a\u00020\u00132\u0006\u0010\u0004\u001a\u00020\u00132\u0006\u0010\u0006\u001a\u00020\u0013H\b\u001a\u001c\u0010\u0000\u001a\u00020\u00132\u0006\u0010\u0003\u001a\u00020\u00132\n\u0010\b\u001a\u00020\u0014\"\u00020\u0013H\u0007\u001a\u0019\u0010\u0000\u001a\u00020\u00152\u0006\u0010\u0003\u001a\u00020\u00152\u0006\u0010\u0004\u001a\u00020\u0015H\b\u001a!\u0010\u0000\u001a\u00020\u00152\u0006\u0010\u0003\u001a\u00020\u00152\u0006\u0010\u0004\u001a\u00020\u00152\u0006\u0010\u0006\u001a\u00020\u0015H\b\u001a\u001c\u0010\u0000\u001a\u00020\u00152\u0006\u0010\u0003\u001a\u00020\u00152\n\u0010\b\u001a\u00020\u0016\"\u00020\u0015H\u0007\u001a-\u0010\u0017\u001a\u0002H\u0001\"\u000e\b\u0000\u0010\u0001*\b\u0012\u0004\u0012\u0002H\u00010\u00022\u0006\u0010\u0003\u001a\u0002H\u00012\u0006\u0010\u0004\u001a\u0002H\u0001H\u0007¢\u0006\u0002\u0010\u0005\u001a5\u0010\u0017\u001a\u0002H\u0001\"\u000e\b\u0000\u0010\u0001*\b\u0012\u0004\u0012\u0002H\u00010\u00022\u0006\u0010\u0003\u001a\u0002H\u00012\u0006\u0010\u0004\u001a\u0002H\u00012\u0006\u0010\u0006\u001a\u0002H\u0001H\u0007¢\u0006\u0002\u0010\u0007\u001a9\u0010\u0017\u001a\u0002H\u0001\"\u000e\b\u0000\u0010\u0001*\b\u0012\u0004\u0012\u0002H\u00010\u00022\u0006\u0010\u0003\u001a\u0002H\u00012\u0012\u0010\b\u001a\n\u0012\u0006\b\u0001\u0012\u0002H\u00010\t\"\u0002H\u0001H\u0007¢\u0006\u0002\u0010\n\u001a\u0019\u0010\u0017\u001a\u00020\u000b2\u0006\u0010\u0003\u001a\u00020\u000b2\u0006\u0010\u0004\u001a\u00020\u000bH\b\u001a!\u0010\u0017\u001a\u00020\u000b2\u0006\u0010\u0003\u001a\u00020\u000b2\u0006\u0010\u0004\u001a\u00020\u000b2\u0006\u0010\u0006\u001a\u00020\u000bH\b\u001a\u001c\u0010\u0017\u001a\u00020\u000b2\u0006\u0010\u0003\u001a\u00020\u000b2\n\u0010\b\u001a\u00020\f\"\u00020\u000bH\u0007\u001a\u0019\u0010\u0017\u001a\u00020\r2\u0006\u0010\u0003\u001a\u00020\r2\u0006\u0010\u0004\u001a\u00020\rH\b\u001a!\u0010\u0017\u001a\u00020\r2\u0006\u0010\u0003\u001a\u00020\r2\u0006\u0010\u0004\u001a\u00020\r2\u0006\u0010\u0006\u001a\u00020\rH\b\u001a\u001c\u0010\u0017\u001a\u00020\r2\u0006\u0010\u0003\u001a\u00020\r2\n\u0010\b\u001a\u00020\u000e\"\u00020\rH\u0007\u001a\u0019\u0010\u0017\u001a\u00020\u000f2\u0006\u0010\u0003\u001a\u00020\u000f2\u0006\u0010\u0004\u001a\u00020\u000fH\b\u001a!\u0010\u0017\u001a\u00020\u000f2\u0006\u0010\u0003\u001a\u00020\u000f2\u0006\u0010\u0004\u001a\u00020\u000f2\u0006\u0010\u0006\u001a\u00020\u000fH\b\u001a\u001c\u0010\u0017\u001a\u00020\u000f2\u0006\u0010\u0003\u001a\u00020\u000f2\n\u0010\b\u001a\u00020\u0010\"\u00020\u000fH\u0007\u001a\u0019\u0010\u0017\u001a\u00020\u00112\u0006\u0010\u0003\u001a\u00020\u00112\u0006\u0010\u0004\u001a\u00020\u0011H\b\u001a!\u0010\u0017\u001a\u00020\u00112\u0006\u0010\u0003\u001a\u00020\u00112\u0006\u0010\u0004\u001a\u00020\u00112\u0006\u0010\u0006\u001a\u00020\u0011H\b\u001a\u001c\u0010\u0017\u001a\u00020\u00112\u0006\u0010\u0003\u001a\u00020\u00112\n\u0010\b\u001a\u00020\u0012\"\u00020\u0011H\u0007\u001a\u0019\u0010\u0017\u001a\u00020\u00132\u0006\u0010\u0003\u001a\u00020\u00132\u0006\u0010\u0004\u001a\u00020\u0013H\b\u001a!\u0010\u0017\u001a\u00020\u00132\u0006\u0010\u0003\u001a\u00020\u00132\u0006\u0010\u0004\u001a\u00020\u00132\u0006\u0010\u0006\u001a\u00020\u0013H\b\u001a\u001c\u0010\u0017\u001a\u00020\u00132\u0006\u0010\u0003\u001a\u00020\u00132\n\u0010\b\u001a\u00020\u0014\"\u00020\u0013H\u0007\u001a\u0019\u0010\u0017\u001a\u00020\u00152\u0006\u0010\u0003\u001a\u00020\u00152\u0006\u0010\u0004\u001a\u00020\u0015H\b\u001a!\u0010\u0017\u001a\u00020\u00152\u0006\u0010\u0003\u001a\u00020\u00152\u0006\u0010\u0004\u001a\u00020\u00152\u0006\u0010\u0006\u001a\u00020\u0015H\b\u001a\u001c\u0010\u0017\u001a\u00020\u00152\u0006\u0010\u0003\u001a\u00020\u00152\n\u0010\b\u001a\u00020\u0016\"\u00020\u0015H\u0007¨\u0006\u0018"}, d2 = {"maxOf", "T", "", "a", "b", "(Ljava/lang/Comparable;Ljava/lang/Comparable;)Ljava/lang/Comparable;", "c", "(Ljava/lang/Comparable;Ljava/lang/Comparable;Ljava/lang/Comparable;)Ljava/lang/Comparable;", "other", "", "(Ljava/lang/Comparable;[Ljava/lang/Comparable;)Ljava/lang/Comparable;", "", "", "", "", "", "", "", "", "", "", "", "", "minOf", "kotlin-stdlib"}, k = 5, mv = {1, 7, 1}, xi = 49, xs = "kotlin/comparisons/ComparisonsKt")
class ComparisonsKt___ComparisonsJvmKt extends ComparisonsKt__ComparisonsKt {
    @NotNull
    @SinceKotlin(version = "1.1")
    public static <T extends Comparable<? super T>> T maxOf(@NotNull T t11, @NotNull T t12) {
        Intrinsics.checkNotNullParameter(t11, "a");
        Intrinsics.checkNotNullParameter(t12, "b");
        return t11.compareTo(t12) >= 0 ? t11 : t12;
    }

    @NotNull
    @SinceKotlin(version = "1.1")
    public static final <T extends Comparable<? super T>> T minOf(@NotNull T t11, @NotNull T t12) {
        Intrinsics.checkNotNullParameter(t11, "a");
        Intrinsics.checkNotNullParameter(t12, "b");
        return t11.compareTo(t12) <= 0 ? t11 : t12;
    }

    @SinceKotlin(version = "1.1")
    @InlineOnly
    private static final byte maxOf(byte b11, byte b12) {
        return (byte) Math.max(b11, b12);
    }

    @SinceKotlin(version = "1.1")
    @InlineOnly
    private static final byte minOf(byte b11, byte b12) {
        return (byte) Math.min(b11, b12);
    }

    @SinceKotlin(version = "1.1")
    @InlineOnly
    private static final short maxOf(short s11, short s12) {
        return (short) Math.max(s11, s12);
    }

    @SinceKotlin(version = "1.1")
    @InlineOnly
    private static final short minOf(short s11, short s12) {
        return (short) Math.min(s11, s12);
    }

    @SinceKotlin(version = "1.1")
    @InlineOnly
    private static final int maxOf(int i11, int i12) {
        return Math.max(i11, i12);
    }

    @SinceKotlin(version = "1.1")
    @InlineOnly
    private static final int minOf(int i11, int i12) {
        return Math.min(i11, i12);
    }

    @SinceKotlin(version = "1.1")
    @InlineOnly
    private static final long maxOf(long j11, long j12) {
        return Math.max(j11, j12);
    }

    @SinceKotlin(version = "1.1")
    @InlineOnly
    private static final long minOf(long j11, long j12) {
        return Math.min(j11, j12);
    }

    @SinceKotlin(version = "1.1")
    @InlineOnly
    private static final float maxOf(float f11, float f12) {
        return Math.max(f11, f12);
    }

    @SinceKotlin(version = "1.1")
    @InlineOnly
    private static final float minOf(float f11, float f12) {
        return Math.min(f11, f12);
    }

    @SinceKotlin(version = "1.1")
    @InlineOnly
    private static final double maxOf(double d11, double d12) {
        return Math.max(d11, d12);
    }

    @SinceKotlin(version = "1.1")
    @InlineOnly
    private static final double minOf(double d11, double d12) {
        return Math.min(d11, d12);
    }

    @NotNull
    @SinceKotlin(version = "1.1")
    public static final <T extends Comparable<? super T>> T maxOf(@NotNull T t11, @NotNull T t12, @NotNull T t13) {
        Intrinsics.checkNotNullParameter(t11, "a");
        Intrinsics.checkNotNullParameter(t12, "b");
        Intrinsics.checkNotNullParameter(t13, c.f41585a);
        return maxOf(t11, (T) maxOf(t12, t13));
    }

    @NotNull
    @SinceKotlin(version = "1.1")
    public static final <T extends Comparable<? super T>> T minOf(@NotNull T t11, @NotNull T t12, @NotNull T t13) {
        Intrinsics.checkNotNullParameter(t11, "a");
        Intrinsics.checkNotNullParameter(t12, "b");
        Intrinsics.checkNotNullParameter(t13, c.f41585a);
        return minOf(t11, (T) minOf(t12, t13));
    }

    @SinceKotlin(version = "1.1")
    @InlineOnly
    private static final byte maxOf(byte b11, byte b12, byte b13) {
        return (byte) Math.max(b11, Math.max(b12, b13));
    }

    @SinceKotlin(version = "1.1")
    @InlineOnly
    private static final byte minOf(byte b11, byte b12, byte b13) {
        return (byte) Math.min(b11, Math.min(b12, b13));
    }

    @SinceKotlin(version = "1.1")
    @InlineOnly
    private static final short maxOf(short s11, short s12, short s13) {
        return (short) Math.max(s11, Math.max(s12, s13));
    }

    @SinceKotlin(version = "1.1")
    @InlineOnly
    private static final short minOf(short s11, short s12, short s13) {
        return (short) Math.min(s11, Math.min(s12, s13));
    }

    @SinceKotlin(version = "1.1")
    @InlineOnly
    private static final int maxOf(int i11, int i12, int i13) {
        return Math.max(i11, Math.max(i12, i13));
    }

    @SinceKotlin(version = "1.1")
    @InlineOnly
    private static final int minOf(int i11, int i12, int i13) {
        return Math.min(i11, Math.min(i12, i13));
    }

    @SinceKotlin(version = "1.1")
    @InlineOnly
    private static final long maxOf(long j11, long j12, long j13) {
        return Math.max(j11, Math.max(j12, j13));
    }

    @SinceKotlin(version = "1.1")
    @InlineOnly
    private static final long minOf(long j11, long j12, long j13) {
        return Math.min(j11, Math.min(j12, j13));
    }

    @SinceKotlin(version = "1.1")
    @InlineOnly
    private static final float maxOf(float f11, float f12, float f13) {
        return Math.max(f11, Math.max(f12, f13));
    }

    @SinceKotlin(version = "1.1")
    @InlineOnly
    private static final float minOf(float f11, float f12, float f13) {
        return Math.min(f11, Math.min(f12, f13));
    }

    @SinceKotlin(version = "1.1")
    @InlineOnly
    private static final double maxOf(double d11, double d12, double d13) {
        return Math.max(d11, Math.max(d12, d13));
    }

    @SinceKotlin(version = "1.1")
    @InlineOnly
    private static final double minOf(double d11, double d12, double d13) {
        return Math.min(d11, Math.min(d12, d13));
    }

    @NotNull
    @SinceKotlin(version = "1.4")
    public static final <T extends Comparable<? super T>> T maxOf(@NotNull T t11, @NotNull T... tArr) {
        Intrinsics.checkNotNullParameter(t11, "a");
        Intrinsics.checkNotNullParameter(tArr, "other");
        for (T maxOf : tArr) {
            t11 = maxOf(t11, maxOf);
        }
        return t11;
    }

    @NotNull
    @SinceKotlin(version = "1.4")
    public static final <T extends Comparable<? super T>> T minOf(@NotNull T t11, @NotNull T... tArr) {
        Intrinsics.checkNotNullParameter(t11, "a");
        Intrinsics.checkNotNullParameter(tArr, "other");
        for (T minOf : tArr) {
            t11 = minOf(t11, minOf);
        }
        return t11;
    }

    @SinceKotlin(version = "1.4")
    public static final byte maxOf(byte b11, @NotNull byte... bArr) {
        Intrinsics.checkNotNullParameter(bArr, "other");
        for (byte max : bArr) {
            b11 = (byte) Math.max(b11, max);
        }
        return b11;
    }

    @SinceKotlin(version = "1.4")
    public static final byte minOf(byte b11, @NotNull byte... bArr) {
        Intrinsics.checkNotNullParameter(bArr, "other");
        for (byte min : bArr) {
            b11 = (byte) Math.min(b11, min);
        }
        return b11;
    }

    @SinceKotlin(version = "1.4")
    public static final short maxOf(short s11, @NotNull short... sArr) {
        Intrinsics.checkNotNullParameter(sArr, "other");
        for (short max : sArr) {
            s11 = (short) Math.max(s11, max);
        }
        return s11;
    }

    @SinceKotlin(version = "1.4")
    public static final short minOf(short s11, @NotNull short... sArr) {
        Intrinsics.checkNotNullParameter(sArr, "other");
        for (short min : sArr) {
            s11 = (short) Math.min(s11, min);
        }
        return s11;
    }

    @SinceKotlin(version = "1.4")
    public static final int maxOf(int i11, @NotNull int... iArr) {
        Intrinsics.checkNotNullParameter(iArr, "other");
        for (int max : iArr) {
            i11 = Math.max(i11, max);
        }
        return i11;
    }

    @SinceKotlin(version = "1.4")
    public static final int minOf(int i11, @NotNull int... iArr) {
        Intrinsics.checkNotNullParameter(iArr, "other");
        for (int min : iArr) {
            i11 = Math.min(i11, min);
        }
        return i11;
    }

    @SinceKotlin(version = "1.4")
    public static final long maxOf(long j11, @NotNull long... jArr) {
        Intrinsics.checkNotNullParameter(jArr, "other");
        for (long max : jArr) {
            j11 = Math.max(j11, max);
        }
        return j11;
    }

    @SinceKotlin(version = "1.4")
    public static final long minOf(long j11, @NotNull long... jArr) {
        Intrinsics.checkNotNullParameter(jArr, "other");
        for (long min : jArr) {
            j11 = Math.min(j11, min);
        }
        return j11;
    }

    @SinceKotlin(version = "1.4")
    public static float maxOf(float f11, @NotNull float... fArr) {
        Intrinsics.checkNotNullParameter(fArr, "other");
        for (float max : fArr) {
            f11 = Math.max(f11, max);
        }
        return f11;
    }

    @SinceKotlin(version = "1.4")
    public static float minOf(float f11, @NotNull float... fArr) {
        Intrinsics.checkNotNullParameter(fArr, "other");
        for (float min : fArr) {
            f11 = Math.min(f11, min);
        }
        return f11;
    }

    @SinceKotlin(version = "1.4")
    public static final double maxOf(double d11, @NotNull double... dArr) {
        Intrinsics.checkNotNullParameter(dArr, "other");
        for (double max : dArr) {
            d11 = Math.max(d11, max);
        }
        return d11;
    }

    @SinceKotlin(version = "1.4")
    public static final double minOf(double d11, @NotNull double... dArr) {
        Intrinsics.checkNotNullParameter(dArr, "other");
        for (double min : dArr) {
            d11 = Math.min(d11, min);
        }
        return d11;
    }
}
