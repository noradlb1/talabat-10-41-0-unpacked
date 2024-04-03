package androidx.compose.ui.input.pointer.util;

import androidx.compose.runtime.internal.StabilityInferred;
import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.geometry.OffsetKt;
import androidx.compose.ui.unit.VelocityKt;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import org.jetbrains.annotations.NotNull;

@StabilityInferred(parameters = 0)
@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0007\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J#\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u0004ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\b\u0015\u0010\u0016J\u0016\u0010\u0017\u001a\u00020\u0018ø\u0001\u0002ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\b\u0019\u0010\u0006J\b\u0010\u001a\u001a\u00020\u001bH\u0002J\u0006\u0010\u001c\u001a\u00020\u0011R%\u0010\u0003\u001a\u00020\u0004X\u000eø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\u0010\n\u0002\u0010\t\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u000e\u0010\n\u001a\u00020\u000bX\u000e¢\u0006\u0002\n\u0000R\u0018\u0010\f\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u000e0\rX\u0004¢\u0006\u0004\n\u0002\u0010\u000f\u0002\u000f\n\u0002\b\u0019\n\u0005\b¡\u001e0\u0001\n\u0002\b!¨\u0006\u001d"}, d2 = {"Landroidx/compose/ui/input/pointer/util/VelocityTracker;", "", "()V", "currentPointerPositionAccumulator", "Landroidx/compose/ui/geometry/Offset;", "getCurrentPointerPositionAccumulator-F1C5BW0$ui_release", "()J", "setCurrentPointerPositionAccumulator-k-4lQ0M$ui_release", "(J)V", "J", "index", "", "samples", "", "Landroidx/compose/ui/input/pointer/util/PointAtTime;", "[Landroidx/compose/ui/input/pointer/util/PointAtTime;", "addPosition", "", "timeMillis", "", "position", "addPosition-Uv8p0NA", "(JJ)V", "calculateVelocity", "Landroidx/compose/ui/unit/Velocity;", "calculateVelocity-9UxMQ8M", "getVelocityEstimate", "Landroidx/compose/ui/input/pointer/util/VelocityEstimate;", "resetTracking", "ui_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class VelocityTracker {
    public static final int $stable = 8;
    private long currentPointerPositionAccumulator;
    private int index;
    @NotNull
    private final PointAtTime[] samples;

    public VelocityTracker() {
        PointAtTime[] pointAtTimeArr = new PointAtTime[20];
        for (int i11 = 0; i11 < 20; i11++) {
            pointAtTimeArr[i11] = null;
        }
        this.samples = pointAtTimeArr;
        this.currentPointerPositionAccumulator = Offset.Companion.m2692getZeroF1C5BW0();
    }

    private final VelocityEstimate getVelocityEstimate() {
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        ArrayList arrayList3 = new ArrayList();
        int i11 = this.index;
        PointAtTime pointAtTime = this.samples[i11];
        if (pointAtTime == null) {
            return VelocityEstimate.Companion.getNone();
        }
        int i12 = 0;
        PointAtTime pointAtTime2 = pointAtTime;
        while (true) {
            PointAtTime pointAtTime3 = this.samples[i11];
            if (pointAtTime3 != null) {
                float time = (float) (pointAtTime.getTime() - pointAtTime3.getTime());
                float abs = (float) Math.abs(pointAtTime3.getTime() - pointAtTime2.getTime());
                if (time > 100.0f || abs > 40.0f) {
                    break;
                }
                long r11 = pointAtTime3.m4416getPointF1C5BW0();
                arrayList.add(Float.valueOf(Offset.m2676getXimpl(r11)));
                arrayList2.add(Float.valueOf(Offset.m2677getYimpl(r11)));
                arrayList3.add(Float.valueOf(-time));
                if (i11 == 0) {
                    i11 = 20;
                }
                i11--;
                i12++;
                if (i12 >= 20) {
                    pointAtTime2 = pointAtTime3;
                    break;
                }
                pointAtTime2 = pointAtTime3;
            } else {
                break;
            }
        }
        if (i12 >= 3) {
            try {
                PolynomialFit polyFitLeastSquares = VelocityTrackerKt.polyFitLeastSquares(arrayList3, arrayList, 2);
                PolynomialFit polyFitLeastSquares2 = VelocityTrackerKt.polyFitLeastSquares(arrayList3, arrayList2, 2);
                float f11 = (float) 1000;
                return new VelocityEstimate(OffsetKt.Offset(polyFitLeastSquares.getCoefficients().get(1).floatValue() * f11, polyFitLeastSquares2.getCoefficients().get(1).floatValue() * f11), polyFitLeastSquares.getConfidence() * polyFitLeastSquares2.getConfidence(), pointAtTime.getTime() - pointAtTime2.getTime(), Offset.m2680minusMKHz9U(pointAtTime.m4416getPointF1C5BW0(), pointAtTime2.m4416getPointF1C5BW0()), (DefaultConstructorMarker) null);
            } catch (IllegalArgumentException unused) {
                return VelocityEstimate.Companion.getNone();
            }
        } else {
            return new VelocityEstimate(Offset.Companion.m2692getZeroF1C5BW0(), 1.0f, pointAtTime.getTime() - pointAtTime2.getTime(), Offset.m2680minusMKHz9U(pointAtTime.m4416getPointF1C5BW0(), pointAtTime2.m4416getPointF1C5BW0()), (DefaultConstructorMarker) null);
        }
    }

    /* renamed from: addPosition-Uv8p0NA  reason: not valid java name */
    public final void m4423addPositionUv8p0NA(long j11, long j12) {
        int i11 = (this.index + 1) % 20;
        this.index = i11;
        this.samples[i11] = new PointAtTime(j12, j11, (DefaultConstructorMarker) null);
    }

    /* renamed from: calculateVelocity-9UxMQ8M  reason: not valid java name */
    public final long m4424calculateVelocity9UxMQ8M() {
        long r02 = getVelocityEstimate().m4422getPixelsPerSecondF1C5BW0();
        return VelocityKt.Velocity(Offset.m2676getXimpl(r02), Offset.m2677getYimpl(r02));
    }

    /* renamed from: getCurrentPointerPositionAccumulator-F1C5BW0$ui_release  reason: not valid java name */
    public final long m4425getCurrentPointerPositionAccumulatorF1C5BW0$ui_release() {
        return this.currentPointerPositionAccumulator;
    }

    public final void resetTracking() {
        ArraysKt___ArraysJvmKt.fill$default((Object[]) this.samples, (Object) null, 0, 0, 6, (Object) null);
    }

    /* renamed from: setCurrentPointerPositionAccumulator-k-4lQ0M$ui_release  reason: not valid java name */
    public final void m4426setCurrentPointerPositionAccumulatork4lQ0M$ui_release(long j11) {
        this.currentPointerPositionAccumulator = j11;
    }
}
