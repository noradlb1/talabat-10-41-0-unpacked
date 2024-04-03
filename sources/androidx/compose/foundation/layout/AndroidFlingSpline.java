package androidx.compose.foundation.layout;

import kotlin.Metadata;
import kotlin.jvm.JvmInline;
import kotlin.jvm.internal.FloatCompanionObject;
import l.a;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0014\n\u0002\b\u0002\n\u0002\u0010\u0006\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\bÂ\u0002\u0018\u00002\u00020\u0001:\u0001\u0012B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0016\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u000bJ\u001e\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u000bø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\u0004\b\u0010\u0010\u0011R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0006X\u0004¢\u0006\u0002\n\u0000\u0002\u000f\n\u0002\b!\n\u0005\b¡\u001e0\u0001\n\u0002\b\u0019¨\u0006\u0013"}, d2 = {"Landroidx/compose/foundation/layout/AndroidFlingSpline;", "", "()V", "NbSamples", "", "SplinePositions", "", "SplineTimes", "deceleration", "", "velocity", "", "friction", "flingPosition", "Landroidx/compose/foundation/layout/AndroidFlingSpline$FlingResult;", "time", "flingPosition-LfoxSSI", "(F)J", "FlingResult", "foundation-layout_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
final class AndroidFlingSpline {
    @NotNull
    public static final AndroidFlingSpline INSTANCE = new AndroidFlingSpline();
    private static final int NbSamples = 100;
    @NotNull
    private static final float[] SplinePositions = new float[101];
    @NotNull
    private static final float[] SplineTimes = new float[101];

    @JvmInline
    @Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\b@\u0018\u00002\u00020\u0001B\u0012\u0012\u0006\u0010\u0002\u001a\u00020\u0003ø\u0001\u0000¢\u0006\u0004\b\u0004\u0010\u0005J\u001a\u0010\f\u001a\u00020\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u000f\u0010\u0010J\u0010\u0010\u0011\u001a\u00020\u0012HÖ\u0001¢\u0006\u0004\b\u0013\u0010\u0014J\u0010\u0010\u0015\u001a\u00020\u0016HÖ\u0001¢\u0006\u0004\b\u0017\u0010\u0018R\u0011\u0010\u0006\u001a\u00020\u00078F¢\u0006\u0006\u001a\u0004\b\b\u0010\tR\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000R\u0011\u0010\n\u001a\u00020\u00078F¢\u0006\u0006\u001a\u0004\b\u000b\u0010\t\u0001\u0002\u0001\u00020\u0003ø\u0001\u0000\u0002\u0004\n\u0002\b\u0019¨\u0006\u0019"}, d2 = {"Landroidx/compose/foundation/layout/AndroidFlingSpline$FlingResult;", "", "packedValue", "", "constructor-impl", "(J)J", "distanceCoefficient", "", "getDistanceCoefficient-impl", "(J)F", "velocityCoefficient", "getVelocityCoefficient-impl", "equals", "", "other", "equals-impl", "(JLjava/lang/Object;)Z", "hashCode", "", "hashCode-impl", "(J)I", "toString", "", "toString-impl", "(J)Ljava/lang/String;", "foundation-layout_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public static final class FlingResult {
        private final long packedValue;

        private /* synthetic */ FlingResult(long j11) {
            this.packedValue = j11;
        }

        /* renamed from: box-impl  reason: not valid java name */
        public static final /* synthetic */ FlingResult m385boximpl(long j11) {
            return new FlingResult(j11);
        }

        /* renamed from: constructor-impl  reason: not valid java name */
        public static long m386constructorimpl(long j11) {
            return j11;
        }

        /* renamed from: equals-impl  reason: not valid java name */
        public static boolean m387equalsimpl(long j11, Object obj) {
            return (obj instanceof FlingResult) && j11 == ((FlingResult) obj).m393unboximpl();
        }

        /* renamed from: equals-impl0  reason: not valid java name */
        public static final boolean m388equalsimpl0(long j11, long j12) {
            return j11 == j12;
        }

        /* renamed from: getDistanceCoefficient-impl  reason: not valid java name */
        public static final float m389getDistanceCoefficientimpl(long j11) {
            FloatCompanionObject floatCompanionObject = FloatCompanionObject.INSTANCE;
            return Float.intBitsToFloat((int) (j11 >> 32));
        }

        /* renamed from: getVelocityCoefficient-impl  reason: not valid java name */
        public static final float m390getVelocityCoefficientimpl(long j11) {
            FloatCompanionObject floatCompanionObject = FloatCompanionObject.INSTANCE;
            return Float.intBitsToFloat((int) (j11 & 4294967295L));
        }

        /* renamed from: hashCode-impl  reason: not valid java name */
        public static int m391hashCodeimpl(long j11) {
            return a.a(j11);
        }

        /* renamed from: toString-impl  reason: not valid java name */
        public static String m392toStringimpl(long j11) {
            return "FlingResult(packedValue=" + j11 + ')';
        }

        public boolean equals(Object obj) {
            return m387equalsimpl(this.packedValue, obj);
        }

        public int hashCode() {
            return m391hashCodeimpl(this.packedValue);
        }

        public String toString() {
            return m392toStringimpl(this.packedValue);
        }

        /* renamed from: unbox-impl  reason: not valid java name */
        public final /* synthetic */ long m393unboximpl() {
            return this.packedValue;
        }
    }

    static {
        float f11;
        float f12;
        float f13;
        float f14;
        float f15;
        float f16;
        float f17;
        float f18;
        float f19 = 0.0f;
        float f21 = 0.0f;
        for (int i11 = 0; i11 < 100; i11++) {
            float f22 = ((float) i11) / ((float) 100);
            float f23 = 1.0f;
            while (true) {
                f11 = ((f23 - f19) / 2.0f) + f19;
                f12 = 1.0f - f11;
                f13 = f11 * 3.0f * f12;
                f14 = f11 * f11 * f11;
                float f24 = (((f12 * 0.175f) + (f11 * 0.35000002f)) * f13) + f14;
                if (((double) Math.abs(f24 - f22)) < 1.0E-5d) {
                    break;
                } else if (f24 > f22) {
                    f23 = f11;
                } else {
                    f19 = f11;
                }
            }
            float f25 = 0.5f;
            SplinePositions[i11] = (f13 * ((f12 * 0.5f) + f11)) + f14;
            float f26 = 1.0f;
            while (true) {
                f15 = ((f26 - f21) / 2.0f) + f21;
                f16 = 1.0f - f15;
                f17 = f15 * 3.0f * f16;
                f18 = f15 * f15 * f15;
                float f27 = (((f16 * f25) + f15) * f17) + f18;
                if (((double) Math.abs(f27 - f22)) < 1.0E-5d) {
                    break;
                }
                if (f27 > f22) {
                    f26 = f15;
                } else {
                    f21 = f15;
                }
                f25 = 0.5f;
            }
            SplineTimes[i11] = (f17 * ((f16 * 0.175f) + (f15 * 0.35000002f))) + f18;
        }
        SplineTimes[100] = 1.0f;
        SplinePositions[100] = 1.0f;
    }

    private AndroidFlingSpline() {
    }

    public final double deceleration(float f11, float f12) {
        return Math.log(((double) (Math.abs(f11) * 0.35f)) / ((double) f12));
    }

    /* renamed from: flingPosition-LfoxSSI  reason: not valid java name */
    public final long m384flingPositionLfoxSSI(float f11) {
        float f12;
        float f13;
        float f14 = (float) 100;
        int i11 = (int) (f14 * f11);
        if (i11 < 100) {
            float f15 = ((float) i11) / f14;
            int i12 = i11 + 1;
            float f16 = ((float) i12) / f14;
            float[] fArr = SplinePositions;
            float f17 = fArr[i11];
            f13 = (fArr[i12] - f17) / (f16 - f15);
            f12 = f17 + ((f11 - f15) * f13);
        } else {
            f12 = 1.0f;
            f13 = 0.0f;
        }
        long floatToIntBits = (long) Float.floatToIntBits(f12);
        return FlingResult.m386constructorimpl((((long) Float.floatToIntBits(f13)) & 4294967295L) | (floatToIntBits << 32));
    }
}
